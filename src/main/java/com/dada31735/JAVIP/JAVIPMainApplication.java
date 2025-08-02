package com.dada31735.JAVIP;

import com.dada31735.JAVIP.dto.JournalEntryDTO;
import com.dada31735.JAVIP.dto.UserDTO;
import com.dada31735.JAVIP.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;
import java.util.List;

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
                System.out.println("   Username: " + fetchedUser.getUsername());
                System.out.println("   Created At: " + fetchedUser.getCreatedAt());

                UserDTO fetchedUser2 = userService.getUserByUsername("john");
                System.out.println("   Email: " + fetchedUser2.getEmail());
                System.out.println("   Created At: " + fetchedUser2.getCreatedAt());

                // Test journal entries
                JournalEntryDTO entry1 = new JournalEntryDTO();
                entry1.setTitle("My First Day");
                entry1.setContent("Today was a great day! I learned a lot about Spring Boot.");
                entry1.setUserId(fetchedUser.getId());

                userService.createJournalEntry(entry1);

                JournalEntryDTO entry2 = new JournalEntryDTO();
                entry2.setTitle("Weekend Plans");
                entry2.setContent("Planning to work on my journal app this weekend.");
                entry2.setUserId(fetchedUser.getId());

                userService.createJournalEntry(entry2);

                JournalEntryDTO johnEntry = new JournalEntryDTO();
                johnEntry.setTitle("John's Notes");
                johnEntry.setContent("Working on the database design today.");
                johnEntry.setUserId(fetchedUser2.getId());

                userService.createJournalEntry(johnEntry);

                // Fetch and display entries
                List<JournalEntryDTO> userEntries = userService.getAllEntriesByUser(fetchedUser.getId());
                System.out.println("\n📝 " + fetchedUser.getUsername() + "'s entries (" + userEntries.size() + "):");
                for (JournalEntryDTO entry : userEntries) {
                    System.out.println("   - " + entry.getTitle() + ": " + entry.getContent());
                }

                JournalEntryDTO specificEntry = userService.getEntryByUserAndTitle(fetchedUser.getId(), "My First Day");
                System.out.println("\n🔍 Found entry: " + specificEntry.getTitle());
                System.out.println("   Content: " + specificEntry.getContent());

                System.out.println("\n🎯 Database ready! Check H2 console at: http://localhost:8080/h2-console");
                System.out.println("   JDBC URL: jdbc:h2:mem:JAVIP");
                System.out.println("   Username: sa");
                System.out.println("   Password: password");
                System.out.println("   Queries to run:");
                System.out.println("   SELECT * FROM USERS;");
                System.out.println("   SELECT * FROM JOURNAL_ENTRIES;");

            } catch (Exception e) {
                System.err.println("Error creating test data: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }
}