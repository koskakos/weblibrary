package project.weblibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.weblibrary.Entities.BookEntity;
import project.weblibrary.Services.BooksService;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("")
    public String mainPage(Model model){
        model.addAttribute("books", booksService.getBooks());
        return "books";
    }

    @GetMapping("/new")
    public String newBookPage(Model model){
        model.addAttribute("book", new BookEntity());
        return "newBook";
    }

    @PostMapping("/new")
    public String newBook(Model model, @ModelAttribute("book") BookEntity bookEntity){
        booksService.addBook(bookEntity);
        return "redirect:/books";
    }
}
