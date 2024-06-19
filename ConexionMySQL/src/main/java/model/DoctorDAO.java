package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private Connection connection;

    public DoctorDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new doctor record
    public void createDoctor(DoctorModel model) throws SQLException {
        String query = "INSERT INTO `Doctores_AFS`(`doctorID`, `nombre`, `fechaNacimiento`, `sexo`, `nacionalidad`, `estadoCivil`, `direccion`, `telefono`, `correoElectronico`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, model.getDoctorID());
            stmt.setString(2, model.getName());
            stmt.setDate(3, model.getBirthdate());
            stmt.setString(4, model.getSex());
            stmt.setString(5, model.getNationality());
            stmt.setString(6, model.getCivilStatus());
            stmt.setString(7, model.getAddress());
            stmt.setInt(8, model.getPhoneNumber());
            stmt.setString(9, model.getEmail());
            stmt.executeUpdate();
        }
    }

    // Read a doctor record by ID
    public DoctorModel getDoctorByID(int doctorID) throws SQLException {
        String query = "SELECT * FROM `Doctores_AFS` WHERE `doctorID` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, doctorID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new DoctorModel(
                            rs.getInt("doctorID"),
                            rs.getString("name"),
                            rs.getDate("birthday"),
                            rs.getString("sex"),
                            rs.getString("nationality"),
                            rs.getString("civilStatus"),
                            rs.getString("address"),
                            rs.getInt("phoneNumber"),
                            rs.getString("email")
                    );
                }
            }
        }
        return null; // Return null if no doctor found with the provided ID
    }

    // Read all doctor records
    public List<DoctorModel> getAllDoctors() throws SQLException {
        List<DoctorModel> doctors = new ArrayList<>();
        String query = "SELECT * FROM `Doctores_AFS`";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                doctors.add(new DoctorModel(
                        rs.getInt("doctorID"),
                        rs.getString("nombre"),
                        rs.getDate("fechaNacimiento"),
                        rs.getString("sexo"),
                        rs.getString("nacionalidad"),
                        rs.getString("estadoCivil"),
                        rs.getString("direccion"),
                        rs.getInt("telefono"),
                        rs.getString("correoElectronico")
                ));
            }
        }
        return doctors;
    }

    // Update a doctor record
    public void updateDoctor(DoctorModel model) throws SQLException {
        String query = "UPDATE `Doctores_AFS` SET `nombre` = ?, `fechaNacimiento` = ?, `sexo` = ?, `nacionalidad` = ?, `estadoCivil` = ?, `direccion` = ?, `telefono` = ?, `correoElectronico` = ? WHERE `doctorID` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, model.getName());
            stmt.setDate(2, model.getBirthdate());
            stmt.setString(3, model.getSex());
            stmt.setString(4, model.getNationality());
            stmt.setString(5, model.getCivilStatus());
            stmt.setString(6, model.getAddress());
            stmt.setInt(7, model.getPhoneNumber());
            stmt.setString(8, model.getEmail());
            stmt.setInt(9, model.getDoctorID());
            stmt.executeUpdate();
        }
    }

    // Delete a doctor record by ID
    public void deleteDoctor(int doctorID) throws SQLException {
        String query = "DELETE FROM `Doctores_AFS` WHERE `doctorID` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, doctorID);
            stmt.executeUpdate();
        }
    }
}
