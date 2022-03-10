package ir.blacksparrow.websitebackend.repository.user;

import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.dataModel.PersonEntity;
import ir.blacksparrow.websitebackend.dataModel.UserEntity;
import ir.blacksparrow.websitebackend.repository.ParentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public class UserRepository extends ParentRepository {

    private final IUserRepository userRepository;

    @Autowired
    public UserRepository(ModelMapper modelMapper, IUserRepository userRepository) {
        super(modelMapper);
        this.userRepository = userRepository;
    }

    public Optional<UserDto> findByEmail(String emailAddress){
        return Optional.of(getModelMapper().map(userRepository.findByEmailAddress(emailAddress),UserDto.class));
    }

    public Optional<UserDto> insert(UserDto user){

        UserEntity userEntity = getModelMapper().map(user, UserEntity.class);
        PersonEntity personEntity=new PersonEntity();
        personEntity.setFirstName(user.getPerson().getFirstName());
        personEntity.setLastName(user.getPerson().getLastName());
        personEntity.setNationalId(user.getPerson().getNationalId());
        userEntity.setPersonEntity(personEntity);
//        userEntity.getPersonEntity().setBirthday(user.getPerson().getBirthday());
        //todo

        System.out.println(userEntity.getPersonEntity().getNationalId());
        userEntity = userRepository.save(userEntity);
        return Optional.of(user);        // todo

    }
}
