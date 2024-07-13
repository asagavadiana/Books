package org.example.pdp22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String showBookList(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/new")
    public String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book, Model model) {
        Book savedBook = bookService.saveBook(book);
        if (savedBook != null) {
            model.addAttribute("message", "Книга успешно сохранена.");
        } else {
            model.addAttribute("message", "Ошибка при сохранении книги.");
        }
        return "redirect:/PDP22/PDP22.main/templates/book-add.html?_ijt=8o39frcqd6dtcg9cmrjrde2ioi&_ij_reload=RELOAD_ON_SAVE";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "/PDP22/PDP22.main/templates/book-add.html?_ijt=8o39frcqd6dtcg9cmrjrde2ioi&_ij_reload=RELOAD_ON_SAVE";
    }

    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/PDP22/PDP22.main/templates/book-add.html?_ijt=8o39frcqd6dtcg9cmrjrde2ioi&_ij_reload=RELOAD_ON_SAVE";
    }
}
