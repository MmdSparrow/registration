package ir.blacksparrow.websitebackend.business.sevice.tokenConfirmation;

import ir.blacksparrow.websitebackend.business.dto.TokenConfirmationDto;
import ir.blacksparrow.websitebackend.repository.tokenConfirmation.TokenConfirmationRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenConfirmationService implements ITokenConfirmationService{
    private final TokenConfirmationRepository tokenConfirmationRepository;

    public TokenConfirmationService(TokenConfirmationRepository tokenConfirmationRepository) {
        this.tokenConfirmationRepository = tokenConfirmationRepository;
    }

    private void insert(TokenConfirmationDto tokenConfirmationDto){
        tokenConfirmationRepository.save
    }
}
