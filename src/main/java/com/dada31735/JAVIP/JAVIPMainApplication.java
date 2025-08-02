package com.dada31735.JAVIP;

import com.dada31735.JAVIP.dto.UserDTO;
import com.dada31735.JAVIP.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class JAVIPMainApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(JAVIPMainApplication.class, args);
//         TcpServer.startTcpServer(); // Comment this out for now
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            try {

                UserDTO testUser = new UserDTO();
                testUser.setUsername("testuser");
                testUser.setEmail("test@example.com");
                testUser.setPassword("password123");

                userService.createUser(testUser);

                UserDTO testUser2 = new UserDTO();
                testUser2.setUsername("john");
                testUser2.setEmail("john@example.com");
                testUser2.setPassword("mypassword");

                userService.createUser(testUser2);

                UserDTO fetchedUser = userService.getUserByEmail("test@example.com");
                if (fetchedUser != null) {
                    System.out.println("   Username: " + fetchedUser.getUsername());
                    System.out.println("   Created At: " + fetchedUser.getCreatedAt());
                } else {
                    System.err.println("User not found!");
                }

                UserDTO fetchedUser2 = userService.getUserByUsername("john");
                if (fetchedUser2 != null) {
                    System.out.println("   Email: " + fetchedUser2.getEmail());
                    System.out.println("   Created At: " + fetchedUser2.getCreatedAt());
                } else {
                    System.err.println("User not found!");
                }



                System.out.println("\n🎯 Database ready! Check H2 console at: http://localhost:8080/h2-console");
                System.out.println("   JDBC URL: jdbc:h2:mem:JAVIP");
                System.out.println("   Username: sa");
                System.out.println("   Password: password");
                System.out.println("   Query to run: SELECT * FROM USERS;");

            } catch (Exception e) {
                System.err.println("Error creating test data: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }
}