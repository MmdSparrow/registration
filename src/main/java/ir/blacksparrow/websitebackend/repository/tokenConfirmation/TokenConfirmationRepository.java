package ir.blacksparrow.websitebackend.repository.tokenConfirmation;

import ir.blacksparrow.websitebackend.business.dto.TokenConfirmationDtoChild;
import ir.blacksparrow.websitebackend.business.dto.UserDto;
import ir.blacksparrow.websitebackend.dataModel.TokenConfirmationEntity;
import ir.blacksparrow.websitebackend.dataModel.UserEntity;
import ir.blacksparrow.websitebackend.repository.ParentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TokenConfirmationRepository extends ParentRepository {
    private final ITokenConfirmationRepository tokenConfirmationRepository;


    public TokenConfirmationRepository(ModelMapper modelMapper, ITokenConfirmationRepository tokenConfirmationRepository) {
        super(modelMapper);
        this.tokenConfirmationRepository = tokenConfirmationRepository;

        TypeMap<TokenConfirmationDtoChild, TokenConfirmationEntity> propertyMapper = getModelMapper().createTypeMap(TokenConfirmationDtoChild.class, TokenConfirmationEntity.class);
        propertyMapper.addMappings(
                mapper -> mapper.map(TokenConfirmationDtoChild::getUser, TokenConfirmationEntity::setUserEntity)
        );
    }

    public Optional<TokenConfirmationDtoChild> insertAndUpdate(TokenConfirmationDtoChild tokenConfirmationDto) {
        TokenConfirmationEntity tokenConfirmationEntity =new TokenConfirmationEntity();
        tokenConfirmationEntity.setUserEntity(new UserEntity());
        tokenConfirmationEntity = getModelMapper().map(tokenConfirmationDto, TokenConfirmationEntity.class);

        System.out.println("test......................................");
        System.out.println(tokenConfirmationDto.getUser().toString());
        System.out.println("test......................................");
        System.out.println(tokenConfirmationEntity.toString());
        System.out.println("test......................................");

        tokenConfirmationEntity = tokenConfirmationRepository.save(tokenConfirmationEntity);
        return Optional.of(getModelMapper().map(tokenConfirmationEntity, TokenConfirmationDtoChild.class));
    }

    public Optional<TokenConfirmationDtoChild> findByToken(String token){
        return Optional.of(getModelMapper().map(tokenConfirmationRepository.findByToken(token).orElse(null), TokenConfirmationDtoChild.class));
    }
}
