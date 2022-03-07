package ir.blacksparrow.websitebackend.repository.person;

import ir.blacksparrow.websitebackend.business.dto.CategoryDto;
import ir.blacksparrow.websitebackend.business.dto.PersonDto;
import ir.blacksparrow.websitebackend.dataModel.CategoryEntity;
import ir.blacksparrow.websitebackend.dataModel.PersonEntity;
import ir.blacksparrow.websitebackend.repository.ParentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)

@Repository
public class PersonRepository extends ParentRepository {
    private final IPersonRepository personRepository;

    @Autowired
    public PersonRepository(ModelMapper modelMapper, IPersonRepository personRepository) {
        super(modelMapper);
        this.personRepository = personRepository;
    }

    public Optional<PersonDto> insertAndUpdate(PersonDto personDto) {
        PersonEntity personEntity = getModelMapper().map(personDto, PersonEntity.class);
        personEntity = personRepository.save(personEntity);
//        System.out.println("i really confused.........................................");
//        System.out.println(personEntity.toString());
//        System.out.println("i really confused.........................................");
        return Optional.of(getModelMapper().map(personEntity, PersonDto.class));
    }
}
