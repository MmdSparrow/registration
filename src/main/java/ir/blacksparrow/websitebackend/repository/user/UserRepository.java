package ir.blacksparrow.websitebackend.repository.user;

import ir.blacksparrow.websitebackend.dataModel.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional(readOnly = true)
@Repository
public class UserRepository {
    private final IUserRepository userRepository;

//    public List<Optional<>>
    public Optional<UserEntity> findByEmail(String emailAddress){
        return userRepository.findByEmailAddress(emailAddress);
    }
}
