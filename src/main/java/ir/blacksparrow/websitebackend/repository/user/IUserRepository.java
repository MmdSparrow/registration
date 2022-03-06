package ir.blacksparrow.websitebackend.repository.user;

import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.dataModel.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmailAddress(String emailAddress);
//    Optional<UserEntity> insert(UserEntity userEntity);

}
