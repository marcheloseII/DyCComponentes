package controller;

import model.EspecialidadesDAO;
import model.EspecialidadesModel;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EspecialidadesController {

    private ConsoleView viewConsole;

    private EspecialidadesDAO cursoDAO;

    public EspecialidadesController(ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.cursoDAO = new EspecialidadesDAO(connection);
    }

    public void agregarEspecialidad(String nombre, String descripcion){
        EspecialidadesModel datos = new EspecialidadesModel(nombre, descripcion);

        try
        {
            cursoDAO.agregarEspecialidad(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void getAllEspecialidades() {
        try {
            List<EspecialidadesModel> especialidades = EspecialidadesDAO.getAllEspecialidades();
            viewConsole.showAllEspecialidades(especialidades);
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener lista de especialidades: " + e.getMessage());
        }
    }

    // Update
    public void updateEspecialidad(String Nombre, String Descripcion) {
        EspecialidadesModel data = new EspecialidadesModel(Nombre, Descripcion);

        try {
            EspecialidadesDAO.updateEspecialidad(data);
            viewConsole.showMessage("Actualización de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar datos: " + e.getMessage());
        }
    }

    // Delete
    public void deleteEspecialidad(String nombre) {
        try {
            EspecialidadesDAO.deleteEspecialidad(nombre);
            viewConsole.showMessage("Eliminación de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar datos: " + e.getMessage());
        }
    }
}
