package controller;

import model.*;
import view.ConsoleView;
import view.SucursalesView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SucursalesController {

    private ConsoleView viewConsole;
    private SucursalesView sucursalView;
    private SucursalesDAO sucursalDAO;


    public SucursalesController(SucursalesView sucursalesview ,ConsoleView viewConsole){
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.sucursalDAO = new SucursalesDAO(connection);
    }

    public void agregarSucursal(int id, String nombre, String locacion, String clientes, String doctores, String recetas){
        SucursalesModel datos = new SucursalesModel(id, nombre, locacion, clientes, doctores, recetas);

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
            List<SucursalesModel> sucursales = sucursalDAO.getAllSucursales();
            if (!sucursales.isEmpty()) {
                System.out.println("Lista de recetas médicas:");
                for (SucursalesModel sucursal : sucursales) {
                    System.out.println(sucursal);
                }
            } else {
                System.out.println("No hay recetas médicas registradas.");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener lista de recetas médicas: " + e.getMessage());
        }
    }

    // Update
    public void updateSucursal(int id, String nombre, String locacion, String clientes, String doctores, String recetas) {
        SucursalesModel data = new SucursalesModel(id, nombre, locacion, clientes, doctores, recetas);

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
