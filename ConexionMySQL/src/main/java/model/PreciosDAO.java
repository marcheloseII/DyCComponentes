package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PreciosDAO {

    private Connection connection;

    public PreciosDAO(Connection connection) {
        this.connection = connection;
    }

    public void createPrecio(PreciosModel model) throws SQLException {
        String query = "INSERT INTO `Precios_AFS`(`id`, `producto`, `precio`,`fecha_actualizacion`) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, model.getId());
            stmt.setString(2, model.getProducto());
            stmt.setInt(3, model.getPrecio());
            stmt.setDate(4,model.getFechaActualizacion());
            stmt.executeUpdate();
        }
    }

    public PreciosModel  getPrecioByID(int id) throws SQLException {
        String query = "SELECT * FROM `Precios_AFS` WHERE `id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PreciosModel(
                            rs.getInt("id"),
                            rs.getString("producto"),
                            rs.getInt("precio"),
                            rs.getDate("fecha_actualizacion")
                    );
                }
            }
        }
        return null; // Return null if no price found with the provided ID
    }

    public List<PreciosModel> getAllPrecios() throws SQLException {
        List<PreciosModel> precios = new ArrayList<>();
        String query = "SELECT * FROM `Precios_AFS`";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                precios.add(new PreciosModel(
                        rs.getInt("id"),
                        rs.getString("producto"),
                        rs.getInt("precio"),
                        rs.getDate("fecha_actualizacion")
                ));
            }
        }
        return precios;
    }

    public void updatePrecio(PreciosModel model) throws SQLException {
        String query = "UPDATE `Precios_AFS` SET `producto` = ?, `precio` = ?, `fecha_actualizacion` = ? WHERE `id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, model.getProducto());
            stmt.setInt(2, model.getPrecio());
            stmt.setDate(3, model.getFechaActualizacion());
            stmt.setInt(4, model.getId());
            stmt.executeUpdate();
        }
    }

    public void deletePrecio(int id) throws SQLException {
        String query = "DELETE FROM `Precios_AFS` WHERE `id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
