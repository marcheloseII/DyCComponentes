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

    public void getPrecioByID(int precioID) {
        try {
            PreciosModel precio = preciosDAO.getPrecioByID(precioID);
            if (precio != null) {
                viewConsole.showPrecioDetails(precio);
            } else {
                viewConsole.showMessage("Precio no encontrado");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener datos: " + e.getMessage());
        }
    }

    public void getAllPrecios() {
        try {
            List<PreciosModel> precios = preciosDAO.getAllPrecios();
            viewConsole.showAllPrecios(precios);
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener lista de precios: " + e.getMessage());
        }
    }

    public void updatePrecio(int precioID, String producto, int precio, Date fechaActualizacion) {
        PreciosModel data = new PreciosModel(precioID, producto, precio, fechaActualizacion);

        try {
            preciosDAO.updatePrecio(data);
            viewConsole.showMessage("Actualización de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar datos: " + e.getMessage());
        }
    }

    public void deletePrecio(int precioID) {
        try {
            preciosDAO.deletePrecio(precioID);
            viewConsole.showMessage("Eliminación de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar datos: " + e.getMessage());
        }
    }

}
