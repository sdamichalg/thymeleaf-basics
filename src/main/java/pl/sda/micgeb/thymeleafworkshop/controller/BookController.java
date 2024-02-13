package pl.sda.micgeb.thymeleafworkshop.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.micgeb.thymeleafworkshop.model.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
@Slf4j
public class BookController {

    private final List<Book> books;

    public BookController() {
        this.books = new ArrayList<>();
        books.add(new Book("Ogniem i Mieczem", "Henryk Sienkiewicz"));
        books.add(new Book("Pan Tadeusz", "Adam Mickiewicz"));
        books.add(new Book("Harry Potter i Kamień Filozoficzny", "J.K. Rowling"));
        books.add(new Book("Harry Potter i Komnata Tajemnic", "J.K. Rowling"));
    }

    @GetMapping("/all")
    public String showAllBooks(ModelMap model) {
        model.addAttribute("books", books);
        model.addAttribute("newBook", new Book());
        return "book";
    }

    @PostMapping("/addBook1")
    public String addBook(@Valid @ModelAttribute("newBook") Book book) {
        System.out.println(book);
        books.add(book);

        return "redirect:/book/all";
    }

    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
//            result.getAllErrors().forEach(er -> log.error(er.toString()));
            model.addAttribute("books", books);
            return "book";
        }
        books.add(book);
        return "redirect:/book/all";
    }

    @PostMapping("/removeBook1")
    public String removeBook(@RequestParam("author") String author) {
        if (author.isBlank()) {
          throw new IllegalArgumentException("Nie może być puste");
        }

        books.removeIf(book -> book.getAuthor().equals(author));
        return "redirect:/book/all";
    }

    @PostMapping("/removeBook")
    public String removeBook(@Valid @ModelAttribute("newBook") Book book) {
        books.removeIf(bk -> bk.getAuthor().equals(book.getAuthor()));
        return "redirect:/book/all";
    }
}
