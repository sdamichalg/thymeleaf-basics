package pl.sda.micgeb.thymeleafworkshop.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.micgeb.thymeleafworkshop.model.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
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

    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute("newBook") Book book) {
        System.out.println(book);
        books.add(book);

        return "redirect:/book/all";
    }
}
