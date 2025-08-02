package com.dada31735.JAVIP.service;

import com.dada31735.JAVIP.dto.JournalEntryDTO;
import com.dada31735.JAVIP.dto.UserDTO;
import com.dada31735.JAVIP.modele.JournalEntry;
import com.dada31735.JAVIP.modele.User;
import com.dada31735.JAVIP.persistance.JournalEntryRepository;
import com.dada31735.JAVIP.persistance.UserRepository;
import com.dada31735.JAVIP.service.exceptions.JournalEntryNotFoundException;
import com.dada31735.JAVIP.service.exceptions.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JournalEntryRepository journalEntryRepository;

    public UserService(UserRepository userRepository, JournalEntryRepository journalEntryRepository) {
        this.userRepository = userRepository;
        this.journalEntryRepository = journalEntryRepository;
    }

    //region User management
    @Transactional
    public UserDTO getUserByEmail(String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User with email :" + email + " not found");
        }
        return UserDTO.fromUser(user);
    }

    @Transactional
    public UserDTO getUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User with username :" + username + "not found");
        }
        return UserDTO.fromUser(user);
    }

    @Transactional
    public void createUser(UserDTO userDTO) {
        User user = UserDTO.toUser(userDTO);
        User saved = userRepository.save(user);
    }
    //endregion

    //region journal Entry management
    @Transactional
    public void createJournalEntry(JournalEntryDTO journalEntryDTO) throws UserNotFoundException {
        User user = userRepository.findById(journalEntryDTO.getUserId()).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User with id: " + journalEntryDTO.getUserId() + " not found");
        }
        JournalEntry entry = JournalEntryDTO.toJournalEntry(journalEntryDTO, user);
        journalEntryRepository.save(entry);
    }

    @Transactional
    public List<JournalEntryDTO> getAllEntriesByUser(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User with id: " + userId + " not found");
        }
        List<JournalEntry> entries = journalEntryRepository.findByUser(user);
        return entries.stream().map(JournalEntryDTO::fromJournalEntry).toList();
    }

    @Transactional
    public JournalEntryDTO getEntryById(Long id) throws JournalEntryNotFoundException {
        Optional<JournalEntry> entry = journalEntryRepository.findById(id);
        if (entry.isEmpty()) {
            throw new JournalEntryNotFoundException("Journal entry with id: " + id + " not found");
        }
        return JournalEntryDTO.fromJournalEntry(entry.get());
    }

    @Transactional
    public JournalEntryDTO getEntryByUserAndTitle(Long userId, String title) throws UserNotFoundException, JournalEntryNotFoundException {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User with id: " + userId + " not found");
        }
        JournalEntry entry = journalEntryRepository.findByUserAndTitle(user, title);
        if (entry == null) {
            throw new JournalEntryNotFoundException("Journal entry with title: " + title + " for user id: " + userId + " not found");
        }
        return JournalEntryDTO.fromJournalEntry(entry);
    }

    //endregion

    
}