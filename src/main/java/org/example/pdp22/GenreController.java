package org.example.pdp22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "genre/add";
    }
    @PostMapping
    public String saveGenre(@ModelAttribute Genre genre, RedirectAttributes redirectAttributes) {
        genreService.saveGenre(genre);
        redirectAttributes.addFlashAttribute("message", "Genre added successfully!");
        return "redirect:/genres";
    }

    @GetMapping
    public String listGenres(Model model) {
        model.addAttribute("genres", genreService.getAllGenres());
        System.out.println(genreService.getAllGenres());
        return "genre/genres";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable UUID id, Model model) {
        Genre genre = genreService.findGenreById(id);
        if (genre == null) {
            return "genres/add";
        }
        model.addAttribute("genres", genre);
        return "genres";
    }

    @PostMapping("genre/genres/{id}")
    @ResponseBody
    public String updateGenre(@PathVariable UUID id, @RequestBody Genre genre) {
        genreService.updateGenre(id, genre);
        return "Genre updated successfully!";
    }

    // Delete a genre by its ID
    @PostMapping("genre/genres/delete/{id}")
    @ResponseBody
    public String deleteGenre(@PathVariable UUID id) {
        genreService.deleteGenre(id);
        return "Genre deleted successfully!";
    }
}
