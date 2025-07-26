package com.dada31735.JAVIP.utils;

import org.h2.tools.Server;

import java.sql.SQLException;

public class TcpServer {
    public static void startTcpServer() throws SQLException {
        final Server tcpServer = Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
        System.out.println("Tcp server start: " + tcpServer.start());
        System.out.println(tcpServer.getStatus() + " " +
                tcpServer.getPort());
        System.out.println("jdbc:h2:tcp://localhost:9092/~/springbootdemo");
    }

    public static void createTcpServer(String dbUrl) throws SQLException {
        String dbPort = "9092";
        Server tcpServer = Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", dbPort);
        System.out.println("Tcp server start: " + tcpServer.start());
        System.out.println(tcpServer.getStatus() + " " +
                tcpServer.getPort());
        System.out.println("jdbc:h2:tcp://localhost:" + dbPort + "/mem:" + dbUrl);
    }
}
