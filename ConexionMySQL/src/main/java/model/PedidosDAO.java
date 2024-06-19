package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidosDAO {
    private Connection connection;

    public PedidosDAO(Connection connection) {
        this.connection = connection;
    }

    // Create
    public void createPedido(PedidosModel pedido) throws SQLException {
        String query = "INSERT INTO `Pedidos_AFS`(`IDpedido`, `Descripcion`, `FechaDeVenta`, `ClienteID`, `RecetasID`, `PreciosID`, `FarmaciaID`, `NombreFarmacia`) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pedido.getPedidoID());
            stmt.setString(2, pedido.getDescripcion());
            stmt.setDate(3, pedido.getFechaVenta());
            stmt.setInt(4, pedido.getCliente());
            stmt.setInt(5, pedido.getRecetas());
            stmt.setInt(6, pedido.getPrecios());
            stmt.setInt(7, pedido.getFarmaciaID());
            stmt.setString(8, pedido.getNombreFarmacia());
            stmt.executeUpdate();
        }
    }

    // Read by ID
//    public PedidosModel getPedidoByID(int pedidoID) throws SQLException {
//        String query = "SELECT * FROM `Pedidos` WHERE `pedidoID` = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, pedidoID);
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    ClientModel cliente = getClienteByID(rs.getInt("clienteID"));
//                    RecetasMedicasDAO recetas = getRecetasByID(rs.getInt("recetaID"));
//                    PreciosModel precios = getPreciosByID(rs.getInt("precioID"));
//                    return new PedidosModel(
//                            rs.getInt("pedidoID"),
//                            rs.getString("descripcion"),
//                            rs.getDate("fechaVenta"),
//                            cliente,
//                            recetas,
//                            precios,
//                            rs.getInt("farmaciaID"),
//                            rs.getString("nombreFarmacia")
//                    );
//                } else {
//                    return null;
//                }
//            }
//        }
//    }

    // Read all
    public List<PedidosModel> getAllPedidos() throws SQLException {
        List<PedidosModel> pedidosList = new ArrayList<>();
        String query = "SELECT * FROM `Pedidos_AFS`";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                PedidosModel pedido = new PedidosModel(
                        rs.getInt("ID pedido"),
                        rs.getString("descripcion"),
                        rs.getDate("fechaVenta"),
                        rs.getInt("clienteID"),
                        rs.getInt("recetasID"),
                        rs.getInt("preciosID"),
                        rs.getInt("farmaciaID"),
                        rs.getString("nombreFarmacia")
                );
                pedidosList.add(pedido);
            }
        }
        return pedidosList;
    }

    // Update
    public void updatePedido(PedidosModel pedido) throws SQLException {
        String query = "UPDATE `Pedidos_AFS` SET `Descripcion` = ?, `FechaDeVenta` = ?, `ClienteID` = ?, `RecetasID` = ?, `PreciosID` = ?, `FarmaciaID` = ?, `NombreFarmacia` = ?  WHERE `IDpedido` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, pedido.getDescripcion());
            stmt.setDate(2, pedido.getFechaVenta());
            stmt.setInt(3, pedido.getCliente());
            stmt.setInt(4, pedido.getRecetas());
            stmt.setInt(5, pedido.getPrecios());
            stmt.setInt(6, pedido.getFarmaciaID());
            stmt.setString(7, pedido.getNombreFarmacia());
            stmt.setInt(8, pedido.getPedidoID());
            stmt.executeUpdate();
        }
    }

    // Delete
    public void deletePedido(int pedidoID) throws SQLException {
        String query = "DELETE FROM `Pedidos_AFS` WHERE `IDpedido` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pedidoID);
            stmt.executeUpdate();
        }
    }

//    private ClientModel getClienteByID(int clienteID) throws SQLException {
//        String query = "SELECT * FROM `Clientes` WHERE `clientID` = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, clienteID);
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    return new ClientModel(
//                            rs.getInt("clientID"),
//                            rs.getString("name"),
//                            rs.getDate("birthdate"),
//                            rs.getString("sex"),
//                            rs.getString("nationality"),
//                            rs.getString("civilStatus"),
//                            rs.getString("address"),
//                            rs.getInt("phoneNumber"),
//                            rs.getString("email"),
//                            rs.getInt("idNumber"),
//                            rs.getString("bloodType")
//                    );
//                } else {
//                    return null;
//                }
//            }
//        }
//    }
//
//    private RecetasMedicasModel getRecetasByID(int recetaID) throws SQLException {
//        String query = "SELECT * FROM `Recetas` WHERE `recetaID` = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, recetaID);
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    return new RecetasMedicasModel(
//                            rs.getInt("id"),
//                            rs.getString("paciente"),
//                            rs.getString("medicamento"),
//                            rs.getString("dosis"),
//                            rs.getDate("fecha_prescripcion")
//                    );
//                } else {
//                    return null;
//                }
//            }
//        }
//    }
//
//    private PreciosModel getPreciosByID(int precioID) throws SQLException {
//        String query = "SELECT * FROM `Precios` WHERE `precioID` = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, precioID);
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    return new PreciosModel(
//                            rs.getInt("id"),
//                            rs.getString("producto"),
//                            rs.getInt("precio"),
//                            rs.getDate("fecha_actualizacion")
//                    );
//                } else {
//                    return null;
//                }
//            }
//        }
//    }
}