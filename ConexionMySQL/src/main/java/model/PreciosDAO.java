package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreciosDAO {

    private Connection connection;

    public PreciosDAO(Connection connection) {
        this.connection = connection;
    }

    public void createPrecio(PreciosModel model) throws SQLException {
        String query = "INSERT INTO `Doctors_AFS`(`id`, `producto`, `precio`,`fecha_actualizacion`) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, model.getId());
            stmt.setString(2, model.getProducto());
            stmt.setInt(3, model.getPrecio());
            stmt.setDate(4,model.getFechaActualizacion());
            stmt.executeUpdate();
        }
    }
}
