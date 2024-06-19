package controller;

import model.*;
import view.ConsoleView;
import view.EmpleadosView;
import view.PreciosView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class EmpleadosController {

    private ConsoleView viewConsole;
    private EmpleadosView viewEmpleados;
    private EmpleadosDAO empleadosDAO;

    public EmpleadosController(EmpleadosView viewEmpleados, ConsoleView viewConsole) {
        this.viewConsole = viewConsole;
        this.viewEmpleados = viewEmpleados;
        Connection conn = conexion.getInstance().getConnection();
        this.empleadosDAO = new EmpleadosDAO(conn);
    }

    public void insertEmpleado(int id, String nombre, String rol, String email, char sexo, int doctorID) {
        EmpleadosModel data = new EmpleadosModel(id, nombre, rol, email, sexo, doctorID);

        try {
            empleadosDAO.createEmpleados(data);
            viewConsole.showMessage("Inserción de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    public void getAllEmpleados() {
        try {
            List<EmpleadosModel> empleados = empleadosDAO.getAllEmpleados();
            viewEmpleados.showAllEmpleados(empleados);
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener lista de empleados: " + e.getMessage());
        }
    }

    public void updateEmpleado(int id, String nombre, String rol, String email, char sexo, int doctorID) {
        EmpleadosModel empleado = new EmpleadosModel(id, nombre, rol, email, sexo, doctorID);

        try {
            empleadosDAO.updateEmpleado(empleado);
            viewConsole.showMessage("Actualización de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar datos: " + e.getMessage());
        }
    }

    public void deleteEmpleado(int id) {
        try {
            empleadosDAO.deleteEmpleado(id);
            viewConsole.showMessage("Eliminación de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar datos: " + e.getMessage());
        }
    }

}
