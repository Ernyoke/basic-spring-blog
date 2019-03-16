package esz.dev.controller;

import esz.dev.service.EntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("home")
    public String entries(Model model) {
        model.addAttribute("user", "brother");
        return "home";
    }
}
