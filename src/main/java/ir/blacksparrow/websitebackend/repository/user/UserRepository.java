package ir.blacksparrow.websitebackend.repository.user;

import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.dataModel.PersonEntity;
import ir.blacksparrow.websitebackend.dataModel.UserEntity;
import ir.blacksparrow.websitebackend.repository.ParentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional(readOnly = true)
@Repository
public class UserRepository extends ParentRepository {

    private final IUserRepository userRepository;

    public Optional<UserDto> findByEmail(String emailAddress){
        return Optional.of(getModelMapper().map(userRepository.findByEmailAddress(emailAddress),UserDto.class));
    }

    public Optional<UserDto> insert(UserDto user){
        System.out.println("11111111111111111111111111111111111111111111111111111111111");
        System.out.println(user.toString());
        System.out.println("11111111111111111111111111111111111111111111111111111111111");

//        UserEntity userEntity = getModelMapper().map(user, UserEntity.class); //todo: mapper
        UserEntity userEntity=new UserEntity();
        System.out.println("2222222222222222222222222222222222222222222222222222222222");
        System.out.println(user.getUsername());
        System.out.println("2222222222222222222222222222222222222222222222222222222222");

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        PersonEntity personEntity=new PersonEntity();
        personEntity.setFirstName(user.getPerson().getFirstName());
        personEntity.setLastName(user.getPerson().getLastName());
        personEntity.setNationalId(user.getPerson().getNationalId());
        userEntity.setPersonEntity(personEntity);
//        userEntity.getPersonEntity().setBirthday(user.getPerson().get());
        System.out.println("in insert....................................................");
        System.out.println(userEntity.toString());
        System.out.println("in insert....................................................");

        userEntity = userRepository.save(userEntity);
        return Optional.of(getModelMapper().map(userEntity,UserDto.class));
    }
}
