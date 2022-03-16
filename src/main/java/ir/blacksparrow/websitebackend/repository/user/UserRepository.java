package ir.blacksparrow.websitebackend.repository.user;

import com.sun.istack.NotNull;
import ir.blacksparrow.websitebackend.business.dto.CategoryElementDto;
import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.dataModel.CategoryElementEntity;
import ir.blacksparrow.websitebackend.dataModel.CategoryEntity;
import ir.blacksparrow.websitebackend.dataModel.PersonEntity;
import ir.blacksparrow.websitebackend.dataModel.UserEntity;
import ir.blacksparrow.websitebackend.repository.ParentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;



@Repository
public class UserRepository extends ParentRepository {

    private final IUserRepository userRepository;

    @Autowired
    public UserRepository(ModelMapper modelMapper, IUserRepository userRepository) {
        super(modelMapper);
        this.userRepository = userRepository;

        TypeMap<UserDto, UserEntity> propertyMapper = modelMapper.createTypeMap(UserDto.class, UserEntity.class);
        propertyMapper.addMappings(
                mapper -> mapper.map(UserDto::getCategoryElement, UserEntity::setCategoryElementEntity)
        );
    }

    public Optional<UserDto> findByEmail(String emailAddress){
        return Optional.of(getModelMapper().map(userRepository.findByEmailAddress(emailAddress),UserDto.class));
    }

    public Optional<UserDto> insert(UserDto user){
        UserEntity userEntity = getModelMapper().map(user, UserEntity.class);

        PersonEntity personEntity=new PersonEntity(
                user.getPerson().getNationalId(),
                user.getPerson().getFirstName(),
                user.getPerson().getLastName(),
                user.getPerson().getBirthday(),
                user.getPerson().getBalance()
        );
        userEntity.setPersonEntity(personEntity);
        //todo

        CategoryElementEntity categoryElementEntity=new CategoryElementEntity(
                user.getCategoryElement().getId(),
                user.getCategoryElement().getCode(),
                user.getCategoryElement().getTitle(),
                new CategoryEntity(
                        user.getCategoryElement().getCategory().getId(),
                        user.getCategoryElement().getCategory().getCode(),
                        user.getCategoryElement().getCategory().getTitle()
                )
        );
        //todo

        userEntity.setCategoryElementEntity(categoryElementEntity);
        userEntity = userRepository.save(userEntity);

        return Optional.of(user);        // todo

    }
}
