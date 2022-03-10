package ir.blacksparrow.websitebackend.business.sevice.user;

import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.repository.person.PersonRepository;
import ir.blacksparrow.websitebackend.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService implements IUserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        return userRepository.findByEmail(emailAddress)
                .orElseThrow(()-> new UsernameNotFoundException("user not found!"));
    }



    public String signupUser(UserDto user){
//        boolean userExist = userRepository.findByEmail(user.getEmailAddress()).isPresent();
//        if(userExist)
//            throw new IllegalStateException("email already exist!");

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
//
//        System.out.println("signup user....................................................");
//        System.out.println(user);
//        System.out.println("signup user....................................................");

        personRepository.insertAndUpdate(user.getPerson());
//        userRepository.insert(user);

        System.out.println("00000000000000000000000000000000000000000000");
        //todo: send confirmation token
        return "string";
    }
}
