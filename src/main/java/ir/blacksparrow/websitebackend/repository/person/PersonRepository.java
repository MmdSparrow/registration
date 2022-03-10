package ir.blacksparrow.websitebackend.repository.person;

import ir.blacksparrow.websitebackend.business.dto.PersonDto;
import ir.blacksparrow.websitebackend.dataModel.PersonEntity;
import ir.blacksparrow.websitebackend.repository.ParentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class PersonRepository extends ParentRepository {
    private final IPersonRepository personRepository;

    public PersonRepository(ModelMapper modelMapper, IPersonRepository personRepository) {
        super(modelMapper);
        this.personRepository = personRepository;
    }

    public Optional<PersonDto> insertAndUpdate(PersonDto personDto) {
        PersonEntity personEntity = getModelMapper().map(personDto, PersonEntity.class);
        personEntity = personRepository.save(personEntity);
        return Optional.of(getModelMapper().map(personEntity, PersonDto.class));
    }
}
