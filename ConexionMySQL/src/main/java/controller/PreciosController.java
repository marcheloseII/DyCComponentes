package controller;

import model.*;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class PreciosController {

    private ConsoleView viewConsole;
    private PreciosDAO preciosDAO;

    public PreciosController(ConsoleView viewConsole) {
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.preciosDAO = new PreciosDAO(connection);
    }

    public void insertPrecio(int id, String producto, int precio, Date fecha_actualizacion) {
        PreciosModel data = new PreciosModel(id, producto, precio, fecha_actualizacion);

        try {
            preciosDAO.createPrecio(data);
            viewConsole.showMessage("Inserción de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }
}
