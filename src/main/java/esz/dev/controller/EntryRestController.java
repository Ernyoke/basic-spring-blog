package esz.dev.controller;

import esz.dev.dto.EntryDto;
import esz.dev.model.Entry;
import esz.dev.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntryRestController {
    private EntryService entryService;

    public EntryRestController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping(value = "entries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Entry> entries(@RequestParam int page) {
        return entryService.getEntries(page);
    }

    @PostMapping(value = "entries", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addEntry(@RequestBody EntryDto entryDto) {
        entryService.addEntry(entryDto);
    }
}
