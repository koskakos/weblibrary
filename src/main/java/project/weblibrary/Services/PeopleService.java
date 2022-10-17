package project.weblibrary.Services;

import org.springframework.stereotype.Service;
import project.weblibrary.Entities.PersonEntity;
import project.weblibrary.Repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service

public class PeopleService {

    private final PersonRepository personRepository;

    public PeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(PersonEntity personEntity){
        personRepository.save(personEntity);
    }

    public List<PersonEntity> getPersons(){
        return personRepository.findAll();
    }

    public PersonEntity getPersonById(Long id){
        Optional<PersonEntity> personEntity = personRepository.findById(id);
        return personEntity.get();
    }

    public void deletePersonById(Long id){
        personRepository.deleteById(id);
    }

    public void editPersonById(Long id, String name, Integer birthday){
        PersonEntity editedPerson = getPersonById(id);
        editedPerson.setName(name);
        editedPerson.setBirthday(birthday);
        personRepository.save(editedPerson);
    }
}
