package project.weblibrary.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.weblibrary.Entities.BookEntity;

public interface BooksRepository extends JpaRepository<BookEntity, Long> {
}
