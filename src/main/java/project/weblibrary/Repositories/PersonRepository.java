package project.weblibrary.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.weblibrary.Entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
