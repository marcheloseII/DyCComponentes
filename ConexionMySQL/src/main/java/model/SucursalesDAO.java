package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalesDAO {
    private static Connection connection;

    public SucursalesDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarSucursal( SucursalesModel objeto) throws SQLException {
        String query = "INSERT INTO `Sucursales_AFS`(`nombre`, `locacion`, `clienteID`, `doctorID`, `recetaID`) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getLocacion());
            stmt.setString(3, objeto.getClienteID());
            stmt.setString(4, objeto.getDoctorID());
            stmt.setString(5, objeto.getRecetaID());
            stmt.executeUpdate();
        }
    }

    public static List<SucursalesModel> getAllSucursales() throws SQLException {
        List<SucursalesModel> sucursales = new ArrayList<>();
        String query = "SELECT * FROM `Sucursales_AFS`";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                sucursales.add(new SucursalesModel(
                        rs.getString("nombre"),
                        rs.getString("locacion"),
                        rs.getString("clienteID"),
                        rs.getString("doctorID"),
                        rs.getString("recetaID")
                ));
            }
        }
        return sucursales;
    }



    public static void updateSucursal(SucursalesModel model) throws SQLException {
        String query = "UPDATE `Sucursales_AFS` SET `sucursalID`= ?, `nombre` = ?, `locacion` = ?, `clienteID`= ?, `doctorID`= ?, `recetaID`= ? WHERE `sucursalID` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, model.getNombre());
            stmt.setString(2, model.getLocacion());
            stmt.setString(3, model.getClienteID());
            stmt.setString(4, model.getDoctorID());
            stmt.setString(5, model.getRecetaID());
            stmt.setInt(6, model.getId());
            stmt.executeUpdate();
        }
    }

    public static void deleteSucursal(String Nombre) throws SQLException {
        String query = "DELETE FROM `Sucursales_AFS` WHERE `Nombre` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, Nombre);
            stmt.executeUpdate();
        }
    }
}