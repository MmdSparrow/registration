package ir.blacksparrow.websitebackend.repository.user;

import ir.blacksparrow.websitebackend.business.dto.UserDto;
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
        Optional<UserEntity> userEntity = Optional.of(getModelMapper().map(user, UserEntity.class));
        userEntity = Optional.of(userRepository.save(userEntity.get()));
        return Optional.of(getModelMapper().map(userEntity,UserDto.class));
    }
}
