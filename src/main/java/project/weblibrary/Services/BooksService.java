package project.weblibrary.Services;

import org.springframework.stereotype.Service;
import project.weblibrary.Entities.BookEntity;
import project.weblibrary.Repositories.BooksRepository;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void addBook(BookEntity bookEntity){
        booksRepository.save(bookEntity);
    }

    public List<BookEntity> getBooks(){
        return booksRepository.findAll();
    }
}
