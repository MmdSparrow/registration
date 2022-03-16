package ir.blacksparrow.websitebackend.repository.user;

import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.dataModel.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,String> {
    @Query
    Optional<UserEntity> findByEmailAddress(String emailAddress);

    @Query
    Optional<UserEntity> findByUsername(String username);
//    Optional<UserEntity> insert(UserEntity userEntity);

}
