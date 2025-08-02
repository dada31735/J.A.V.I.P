package com.dada31735.JAVIP.service;

import com.dada31735.JAVIP.dto.UserDTO;
import com.dada31735.JAVIP.modele.User;
import com.dada31735.JAVIP.persistance.UserRepository;
import com.dada31735.JAVIP.service.exceptions.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
}