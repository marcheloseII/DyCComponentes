package controller;

import model.RecetasMedicasDAO;
import model.RecetasMedicasModel;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

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

    public void getRecetaMedicaByID(int recetaID) {
        try {
            RecetasMedicasModel receta = recetasMedicasDAO.getRecetaMedicaByID(recetaID);
            if (receta != null) {
                System.out.println("Detalles de la receta médica:");
                System.out.println(receta);
            } else {
                System.out.println("Receta médica no encontrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener receta médica: " + e.getMessage());
        }
    }

    public void getAllRecetasMedicas() {
        try {
            List<RecetasMedicasModel> recetas = recetasMedicasDAO.getAllRecetasMedicas();
            if (!recetas.isEmpty()) {
                System.out.println("Lista de recetas médicas:");
                for (RecetasMedicasModel receta : recetas) {
                    System.out.println(receta);
                }
            } else {
                System.out.println("No hay recetas médicas registradas.");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener lista de recetas médicas: " + e.getMessage());
        }
    }

    public void updateRecetaMedica(int id, String paciente, String medicamento, String dosis, Date fechaPrescripcion) {
        RecetasMedicasModel model = new RecetasMedicasModel(id, paciente, medicamento, dosis, fechaPrescripcion);

        try {
            recetasMedicasDAO.updateRecetaMedica(model);
            System.out.println("Receta médica actualizada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar receta médica: " + e.getMessage());
        }
    }

    public void deleteRecetaMedica(int recetaID) {
        try {
            recetasMedicasDAO.deleteRecetaMedica(recetaID);
            System.out.println("Receta médica eliminada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar receta médica: " + e.getMessage());
        }
    }
}
