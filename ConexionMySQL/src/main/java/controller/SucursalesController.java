package controller;

import model.SucursalesDAO;
import model.SucursalesModel;
import model.conexion;
import view.ConsoleView;
import view.DoctorView;
import view.SucursalesView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SucursalesController {

    private ConsoleView viewConsole;
    private SucursalesView sucursalView;
    private SucursalesDAO sucursalDAO;

    public SucursalesController(ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.sucursalDAO = new SucursalesDAO(connection);
    }

    public void agregarSucursal(String nombre, String locacion, String doctores, String clientes, String recetas){
        SucursalesModel datos = new SucursalesModel(nombre, locacion, doctores, clientes, recetas);

        try
        {
            sucursalDAO.agregarSucursal(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        }catch (SQLException e){
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void getAllSucursales() {
        try {
            List<SucursalesModel> sucursales = SucursalesDAO.getAllSucursales();
            sucursalView.showAllSucursales(sucursales);
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener lista de sucursales: " + e.getMessage());
        }
    }

    // Update
    public void updateSucursal(String nombre, String locacion, String doctores, String clientes, String recetas) {
        SucursalesModel data = new SucursalesModel(nombre, locacion, doctores, clientes, recetas);

        try {
            SucursalesDAO.updateSucursal(data);
            viewConsole.showMessage("Actualización de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar datos: " + e.getMessage());
        }
    }

    // Delete
    public void deleteSucursal(String nombre) {
        try {
            SucursalesDAO.deleteSucursal(nombre);
            viewConsole.showMessage("Eliminación de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar datos: " + e.getMessage());
        }
    }
}
