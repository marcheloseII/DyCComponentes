package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecialidadesDAO {
    private Connection connection;

    public EspecialidadesDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarEspecialidad( EspecialidadesModel objeto) throws SQLException {
        String query = "INSERT INTO `especialidades_AFS`(`Nombre`, `Descripcion`) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getDescripcion());
            stmt.executeUpdate();
        }
    }

    public EspecialidadesModel obtenerEspecialidadPorId(int id) throws SQLException {
        EspecialidadesModel especialidad = null;
        String query = "SELECT `Nombre`, `Descripcion` FROM `especialidades_AFS` WHERE 1";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    especialidad = new EspecialidadesModel(
                            rs.getString("Nombre"),
                            rs.getString("Descripcion")
                    );
                }
            }
        }
        return especialidad;
    }
}
