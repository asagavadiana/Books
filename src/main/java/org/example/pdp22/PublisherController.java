package org.example.pdp22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public String showPublisherList(Model model) {
        List<Publisher> publishers = publisherService.getAllPublishers();
        model.addAttribute("publishers", publishers);
        return "publisher-list";
    }

    @GetMapping("/new")
    public String showPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher-form";
    }

    @PostMapping
    public String savePublisher(@ModelAttribute Publisher publisher) {
        System.out.println("Received request to save publisher: " + publisher);
        publisherService.savePublisher(publisher);
        System.out.println("Publisher saved successfully: " + publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.getPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "publisher-form";
    }

    @GetMapping("/{id}/delete")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }
}
