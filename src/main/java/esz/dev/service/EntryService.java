package esz.dev.service;

import esz.dev.dto.EntryDto;
import esz.dev.model.Entry;
import esz.dev.repository.EntryJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    private EntryJpaRepository entryRepository;

    public EntryService(EntryJpaRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<Entry> getEntries(int page) {
        return entryRepository.findAll();
    }

    public void addEntry(EntryDto entryDto) {
        Entry entry = new Entry(null, entryDto.getTitle(), entryDto.getContent());
        System.out.println(entry.toString());
        entryRepository.save(entry);
    }
}
