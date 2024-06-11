package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadesDAO {
    private static Connection connection;

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

    public static List<EspecialidadesModel> getAllEspecialidades() throws SQLException {
        List<EspecialidadesModel> especialidades = new ArrayList<>();
        String query = "SELECT * FROM `especialidades_AFS`";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                especialidades.add(new EspecialidadesModel(
                        rs.getString("Nombre"),
                        rs.getString("Descripcion")
                ));
            }
        }
        return especialidades;
    }

    public static void updateEspecialidad(EspecialidadesModel model) throws SQLException {
        String query = "UPDATE `especialidades_AFS` SET `Nombre` = ?,`Descripcion`= ? WHERE `Nombre` = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, model.getNombre());
            stmt.setString(2, model.getDescripcion());
            stmt.executeUpdate();
        }
    }

    public static void deleteEspecialidad(String Nombre) throws SQLException {
        String query = "DELETE FROM `especialidades_AFS` WHERE `Nombre` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, Nombre);
            stmt.executeUpdate();
        }
    }
}
