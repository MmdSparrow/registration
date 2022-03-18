package ir.blacksparrow.websitebackend.repository.user;

import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.dataModel.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,String> {
    @Query(value = "SELECT * FROM BS_USER WHERE EMAIL_ADDRESS = ?1",
            nativeQuery = true)
    Optional<UserEntity> findByEmailAddress(String emailAddress);

    @Query(value = "SELECT * FROM BS_USER WHERE USERNAME = ?1",
            nativeQuery = true)
    Optional<UserEntity> findByUsername(String username);
//    Optional<UserEntity> insert(UserEntity userEntity);

}
