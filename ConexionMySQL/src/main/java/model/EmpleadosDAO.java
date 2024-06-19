package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAO {

    private Connection connection;

    public EmpleadosDAO(Connection connection) {
        this.connection = connection;
    }

    public void createEmpleados(EmpleadosModel empleado) throws SQLException {
        String query = "INSERT INTO Empleados_AFS (ID, Nombre, Rol, email, sexo, doctorID) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, empleado.getId());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getRol());
            stmt.setString(4, empleado.getEmail());
            stmt.setString(5, String.valueOf(empleado.getSexo()));
            stmt.setInt(6, empleado.getDoctorID());
            stmt.executeUpdate();
        }
    }

    public EmpleadosModel getEmpleadoByID(int id) throws SQLException {
        String query = "SELECT * FROM Empleados_AFS WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new EmpleadosModel(
                            rs.getInt("ID"),
                            rs.getString("Nombre"),
                            rs.getString("Rol"),
                            rs.getString("email"),
                            rs.getString("sexo").charAt(0),
                            rs.getInt("doctorID")
                    );
                }
            }
        }
        return null;
    }

    public List<EmpleadosModel> getAllEmpleados() throws SQLException {
        List<EmpleadosModel> empleados = new ArrayList<>();
        String query = "SELECT ID, Nombre, Rol, email, sexo, doctorID FROM Empleados_AFS";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                EmpleadosModel empleado = new EmpleadosModel();
                empleado.setId(rs.getInt("ID"));
                empleado.setNombre(rs.getString("Nombre"));
                empleado.setRol(rs.getString("Rol"));
                empleado.setEmail(rs.getString("email"));
                empleado.setSexo(rs.getString("sexo").charAt(0));
                empleado.setDoctorID(rs.getInt("doctorID"));
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    public void updateEmpleado(EmpleadosModel empleado) throws SQLException {
        String query = "UPDATE Empleados_AFS SET Nombre = ?, Rol = ?, email = ?, sexo = ?, doctorID = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getRol());
            stmt.setString(3, empleado.getEmail());
            stmt.setString(4, String.valueOf(empleado.getSexo()));
            stmt.setInt(5, empleado.getDoctorID());
            stmt.setInt(6, empleado.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteEmpleado(int id) throws SQLException {
        String query = "DELETE FROM Empleados_AFS WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
