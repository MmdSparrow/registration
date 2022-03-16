package ir.blacksparrow.websitebackend.business.sevice.user;

import ir.blacksparrow.websitebackend.business.dto.TokenConfirmationDtoChild;
import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.repository.person.PersonRepository;
import ir.blacksparrow.websitebackend.repository.tokenConfirmation.TokenConfirmationRepository;
import ir.blacksparrow.websitebackend.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService implements IUserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenConfirmationRepository tokenConfirmationRepository;


    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        return userRepository.findByEmail(emailAddress)
                .orElseThrow(()-> new UsernameNotFoundException("user not found!"));
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("user not found!"));
    }



    @Transactional
    @Override
    public String signupUser(UserDto user){
//        boolean userExist = userRepository.findByEmail(user.getEmailAddress()).isPresent();
//        if(userExist)
//            throw new IllegalStateException("email already exist!");

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        personRepository.insertAndUpdate(user.getPerson());

        System.out.println("test,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
        System.out.println(user.toString());
        System.out.println("test,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");

        userRepository.insert(user);

        //todo: send confirmation token

        String token=UUID.randomUUID().toString();

        TokenConfirmationDtoChild tokenConfirmationDtoChild= new TokenConfirmationDtoChild(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(7),
                user
        );

        tokenConfirmationRepository.insertAndUpdate(tokenConfirmationDtoChild);

        //todo: send email

        return token;
    }

    @Override
    public Optional<UserDto> enableUser(String emailAddress) throws ServerException {
        UserDto userDto=userRepository
                .findByEmail(emailAddress)
                .orElseThrow(() -> new ServerException("email not found!"));
        userDto.setEnabled(true);
        return userRepository.insert(userDto);
    }
}
