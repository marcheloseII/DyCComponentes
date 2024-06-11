package controller;

import model.RecetasMedicasDAO;
import model.RecetasMedicasModel;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class RecetasMedicasController {

    private ConsoleView viewConsole;
    private RecetasMedicasDAO recetasMedicasDAO;

    public RecetasMedicasController(ConsoleView viewConsole) {
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.recetasMedicasDAO = new RecetasMedicasDAO(connection);
    }

    public void insertRecetasMedicas(int id, String paciente, String medicamento,String dosis, Date fecha_prescripcion) {
        RecetasMedicasModel data = new RecetasMedicasModel(id,paciente,medicamento,dosis,fecha_prescripcion);

        try {
            recetasMedicasDAO.createRecetaMedica(data);
            viewConsole.showMessage("Inserción de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }
}
