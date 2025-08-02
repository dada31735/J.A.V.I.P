package com.dada31735.JAVIP.persistance;

import com.dada31735.JAVIP.modele.JournalEntry;
import com.dada31735.JAVIP.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
    List<JournalEntry> findByUser(User user);
    JournalEntry findByUserAndTitle(User user, String title);
}