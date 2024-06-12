package controller;

import model.DoctorDAO;
import model.DoctorModel;
import model.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class DoctorController {
    /*private ConsoleView viewConsole;
    private DoctorDAO doctorDAO;

    public DoctorController(ConsoleView viewConsole) {
        this.viewConsole = viewConsole;
        Connection connection = conexion.getConnection();
        this.doctorDAO = new DoctorDAO(connection);
    }

    // Create
    public void insertDoctor(int doctorID, String name, Date birthdate, String sex, String nationality, String civilStatus, String address, int phoneNumber, String email) {
        DoctorModel data = new DoctorModel(doctorID, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email);

        try {
            doctorDAO.createDoctor(data);
            viewConsole.showMessage("Inserción de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    // Read by ID
    public void getDoctorByID(int doctorID) {
        try {
            DoctorModel doctor = doctorDAO.getDoctorByID(doctorID);
            if (doctor != null) {
                viewConsole.showDoctorDetails(doctor);
            } else {
                viewConsole.showMessage("Doctor no encontrado");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener datos: " + e.getMessage());
        }
    }

    // Read all
    public void getAllDoctors() {
        try {
            List<DoctorModel> doctors = doctorDAO.getAllDoctors();
            viewConsole.showAllDoctors(doctors);
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener lista de doctores: " + e.getMessage());
        }
    }

    // Update
    public void updateDoctor(int doctorID, String name, Date birthdate, String sex, String nationality, String civilStatus, String address, int phoneNumber, String email) {
        DoctorModel data = new DoctorModel(doctorID, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email);

        try {
            doctorDAO.updateDoctor(data);
            viewConsole.showMessage("Actualización de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar datos: " + e.getMessage());
        }
    }

    // Delete
    public void deleteDoctor(int doctorID) {
        try {
            doctorDAO.deleteDoctor(doctorID);
            viewConsole.showMessage("Eliminación de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar datos: " + e.getMessage());
        }
    }*/
}
