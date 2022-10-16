package project.weblibrary.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.weblibrary.Entities.PersonEntity;
import project.weblibrary.Repositories.PersonRepository;

@Service

public class PeopleService {

    private final PersonRepository personRepository;

    public PeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPeople(PersonEntity personEntity){
        personRepository.save(personEntity);
    }
}
