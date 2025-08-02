package com.dada31735.JAVIP.dto;

import com.dada31735.JAVIP.modele.JournalEntry;
import com.dada31735.JAVIP.modele.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntryDTO {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static JournalEntryDTO fromJournalEntry(JournalEntry journalEntry) {
        return new JournalEntryDTO(
                journalEntry.getId(),
                journalEntry.getTitle(),
                journalEntry.getContent(),
                journalEntry.getUser().getId(),
                journalEntry.getUser().getUsername(),
                journalEntry.getCreatedAt(),
                journalEntry.getUpdatedAt()
        );
    }

    public static JournalEntry toJournalEntry(JournalEntryDTO dto, User user) {
        JournalEntry entry = new JournalEntry();
        entry.setId(dto.getId());
        entry.setTitle(dto.getTitle());
        entry.setContent(dto.getContent());
        entry.setUser(user);
        entry.setCreatedAt(dto.getCreatedAt());
        entry.setUpdatedAt(dto.getUpdatedAt());
        return entry;
    }
}