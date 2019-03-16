package esz.dev.repository;

import esz.dev.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryJpaRepository extends JpaRepository<Entry, Long> {
}
