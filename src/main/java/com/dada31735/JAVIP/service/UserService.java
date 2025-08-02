package com.dada31735.JAVIP.service;

import com.dada31735.JAVIP.dto.UserDTO;
import com.dada31735.JAVIP.modele.User;
import com.dada31735.JAVIP.persistance.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null; // TO BE REPLACED BY THROWING AN ACTUAL ERROR MESSAGE
        }
        return UserDTO.fromUser(user);
    }

    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        return UserDTO.fromUser(user);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserDTO.toUser(userDTO);
        User saved = userRepository.save(user);
        return UserDTO.fromUser(saved);
    }
}