package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecetasMedicasDAO {

    private Connection connection;

    public RecetasMedicasDAO(Connection connection) {
        this.connection = connection;
    }

    public void createRecetaMedica(RecetasMedicasModel model) throws SQLException {
        String query = "INSERT INTO `Recetas_Medicas_AFS`(`id`, `paciente`, `medicamento`, `dosis`, `fecha_prescripcion`) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, model.getId());
            stmt.setString(2, model.getPaciente());
            stmt.setString(3, model.getMedicamento());
            stmt.setString(4, model.getDosis());
            stmt.setDate(5, model.getFechaPrescripcion());
            stmt.executeUpdate();
        }
    }

    public RecetasMedicasModel getRecetaMedicaByID(int recetaID) throws SQLException {
        String query = "SELECT * FROM `Recetas_Medicas_AFS` WHERE `id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, recetaID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new RecetasMedicasModel(
                            rs.getInt("id"),
                            rs.getString("paciente"),
                            rs.getString("medicamento"),
                            rs.getString("dosis"),
                            rs.getDate("fecha_prescripcion")
                    );
                }
            }
        }
        return null;
    }

    public List<RecetasMedicasModel> getAllRecetasMedicas() throws SQLException {
        List<RecetasMedicasModel> recetas = new ArrayList<>();
        String query = "SELECT * FROM `Recetas_Medicas_AFS`";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                recetas.add(new RecetasMedicasModel(
                        rs.getInt("id"),
                        rs.getString("paciente"),
                        rs.getString("medicamento"),
                        rs.getString("dosis"),
                        rs.getDate("fecha_prescripcion")
                ));
            }
        }
        return recetas;
    }

    public void updateRecetaMedica(RecetasMedicasModel model) throws SQLException {
        String query = "UPDATE `Recetas_Medicas_AFS` SET `paciente` = ?, `medicamento` = ?, `dosis` = ?, `fecha_prescripcion` = ? WHERE `id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, model.getPaciente());
            stmt.setString(2, model.getMedicamento());
            stmt.setString(3, model.getDosis());
            stmt.setDate(4, model.getFechaPrescripcion());
            stmt.setInt(5, model.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteRecetaMedica(int recetaID) throws SQLException {
        String query = "DELETE FROM `Recetas_Medicas_AFS` WHERE `id` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, recetaID);
            stmt.executeUpdate();
        }
    }
}
