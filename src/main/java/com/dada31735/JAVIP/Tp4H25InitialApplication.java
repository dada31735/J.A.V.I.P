package com.dada31735.JAVIP;

import com.dada31735.JAVIP.utils.TcpServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class Tp4H25InitialApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Tp4H25InitialApplication.class, args);
        TcpServer.startTcpServer();
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            try {

                System.out.println("Hello World");
            } catch (Exception e) {
                System.err.println("Erreur lors de l'initialisation des données : " + e.getMessage());
                e.printStackTrace();
            }
        };

    }
}
