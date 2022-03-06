package ir.blacksparrow.websitebackend.repository.person;

import ir.blacksparrow.websitebackend.repository.ParentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)

@Repository
public class PersonRepository extends ParentRepository {
    private final IPersonRepository personRepository;

    public PersonRepository(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
