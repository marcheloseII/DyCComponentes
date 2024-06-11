package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
