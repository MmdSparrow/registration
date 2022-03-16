package ir.blacksparrow.websitebackend.repository.tokenConfirmation;

import ir.blacksparrow.websitebackend.repository.ParentRepository;
import ir.blacksparrow.websitebackend.repository.person.IPersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TokenConfirmationRepository extends ParentRepository {
    private final ITokenConfirmationRepository tokenConfirmationRepository;


    public TokenConfirmationRepository(ModelMapper modelMapper, ITokenConfirmationRepository tokenConfirmationRepository) {
        super(modelMapper);
        this.tokenConfirmationRepository = tokenConfirmationRepository;
    }
}
