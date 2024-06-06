package controller;

import model.CursoDAO;
import model.CursoModel;
import view.ConsoleView;
import model.conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class CursoController {

    private ConsoleView viewConsole;

    private CursoDAO cursoDAO;

    public CursoController (ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.cursoDAO = new CursoDAO(connection);
    }

    public void agregarCurso(String nombre, int estado){
        CursoModel datos = new CursoModel(nombre, estado);

        try
        {
            cursoDAO.agregarCurso(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

}



























