package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new client record
    public void createClient(ClientModel model) throws SQLException {
        String query = "INSERT INTO `Clients_AFS`(`clientID`, `name`, `birthday`, `sex`, `nationality`, `civilStatus`, `address`, `phoneNumber`, `email`, `idNumber`, `bloodType`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, model.getClientID());
            stmt.setString(2, model.getName());
            stmt.setDate(3, model.getBirthdate());
            stmt.setString(4, model.getSex());
            stmt.setString(5, model.getNationality());
            stmt.setString(6, model.getCivilStatus());
            stmt.setString(7, model.getAddress());
            stmt.setInt(8, model.getPhoneNumber());
            stmt.setString(9, model.getEmail());
            stmt.setInt(10, model.getIdNumber());
            stmt.setString(11, model.getBloodType());
            stmt.executeUpdate();
        }
    }

    // Read a client record by ID
    public ClientModel getClientByID(int clientID) throws SQLException {
        String query = "SELECT * FROM `Clients_AFS` WHERE `clientID` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, clientID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ClientModel(
                            rs.getInt("clientID"),
                            rs.getString("name"),
                            rs.getDate("birthday"),
                            rs.getString("sex"),
                            rs.getString("nationality"),
                            rs.getString("civilStatus"),
                            rs.getString("address"),
                            rs.getInt("phoneNumber"),
                            rs.getString("email"),
                            rs.getInt("idNumber"),
                            rs.getString("bloodType")
                    );
                }
            }
        }
        return null; // Return null if no client found with the provided ID
    }

    // Read all client records
    public List<ClientModel> getAllClients() throws SQLException {
        List<ClientModel> clients = new ArrayList<>();
        String query = "SELECT * FROM `Clients_AFS`";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clients.add(new ClientModel(
                        rs.getInt("clientID"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("sex"),
                        rs.getString("nationality"),
                        rs.getString("civilStatus"),
                        rs.getString("address"),
                        rs.getInt("phoneNumber"),
                        rs.getString("email"),
                        rs.getInt("idNumber"),
                        rs.getString("bloodType")
                ));
            }
        }
        return clients;
    }

    // Update a client record
    public void updateClient(ClientModel model) throws SQLException {
        String query = "UPDATE `Clients_AFS` SET `name` = ?, `birthday` = ?, `sex` = ?, `nationality` = ?, `civilStatus` = ?, `address` = ?, `phoneNumber` = ?, `email` = ?, `idNumber` = ?, `bloodType` = ? WHERE `clientID` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, model.getName());
            stmt.setDate(2, model.getBirthdate());
            stmt.setString(3, model.getSex());
            stmt.setString(4, model.getNationality());
            stmt.setString(5, model.getCivilStatus());
            stmt.setString(6, model.getAddress());
            stmt.setInt(7, model.getPhoneNumber());
            stmt.setString(8, model.getEmail());
            stmt.setInt(9, model.getIdNumber());
            stmt.setString(10, model.getBloodType());
            stmt.setInt(11, model.getClientID());
            stmt.executeUpdate();
        }
    }

    // Delete a client record by ID
    public void deleteClient(int clientID) throws SQLException {
        String query = "DELETE FROM `Clients_AFS` WHERE `clientID` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, clientID);
            stmt.executeUpdate();
        }
    }
}
