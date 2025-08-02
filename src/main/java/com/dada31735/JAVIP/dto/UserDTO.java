package com.dada31735.JAVIP.dto;

import com.dada31735.JAVIP.modele.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), null, user.getCreatedAt());
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(userDTO.getPassword()); // TO BE HASHED !!!!!!!!!!!!!!!!!!!
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }
}