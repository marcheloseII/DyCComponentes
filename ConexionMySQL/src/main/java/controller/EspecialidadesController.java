package controller;

import model.EspecialidadesDAO;
import model.EspecialidadesModel;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

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
}
