package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    private static final String URL = "jdbc:mysql://45.88.196.5:3306/u484426513_diseno224";
    private static final String USER = "u484426513_diseno224";
    private static final String PASSWORD = "#7cYr646u@*Rp.P";

    // Singleton instance
    private static conexion instance;
    private static Connection connection;

    // Private constructor to prevent instantiation
    private conexion() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado al server remoto");
        } catch (SQLException e) {
            System.err.println("Fallo la conexion: " + e.getMessage());
        }
    }

    // Public method to provide access to the singleton instance
    public static synchronized conexion getInstance() {
        if (instance == null) {
            instance = new conexion();
        }
        return instance;
    }

    // Method to get the connection
    public Connection getConnection() {
        return connection;
    }
}
