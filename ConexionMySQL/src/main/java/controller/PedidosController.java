package controller;

import model.*;
import view.ConsoleView;
import view.PedidosView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class PedidosController {
    private ConsoleView viewConsole;
    private PedidosView pedidosView;
    private PedidosDAO pedidosDAO;

    public PedidosController(ConsoleView viewConsole, PedidosView pedidosView) {
        this.viewConsole = viewConsole;
        this.pedidosView = pedidosView;
        Connection connection = conexion.getConnection();
        this.pedidosDAO = new PedidosDAO(connection);
    }

    // Create
    public void insertPedidos(int pedidoID, String descripcion, Date fechaVenta, int cliente, int recetas, int precios, int farmaciaID, String nombreFarmacia) {
        PedidosModel pedido = new PedidosModel(pedidoID, descripcion, fechaVenta, cliente, recetas, precios, farmaciaID, nombreFarmacia);
        try {
            pedidosDAO.createPedido(pedido);
            viewConsole.showMessage("Pedido creado correctamente.");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al crear el pedido: " + e.getMessage());
        }
    }

    // Read by ID
//    public void getPedidoByID(int pedidoID) {
//        try {
//            PedidosModel pedido = pedidosDAO.getPedidoByID(pedidoID);
//            if (pedido != null) {
//                viewConsole.showPedidoDetails(pedido);
//            } else {
//                viewConsole.showMessage("Pedido no encontrado.");
//            }
//        } catch (SQLException e) {
//            viewConsole.errorMessage("Error al obtener el pedido: " + e.getMessage());
//        }
//    }

    // Read all
    public void getAllPedidos() {
        try {
            List<PedidosModel> pedidosList = pedidosDAO.getAllPedidos();
            pedidosView.showAllPedidos(pedidosList);
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener todos los pedidos: " + e.getMessage());
        }
    }

    // Update
    public void updatePedido(int pedidoID, String descripcion, Date fechaVenta, int cliente, int recetas, int precios, int farmaciaID, String nombreFarmacia) {
        PedidosModel pedido = new PedidosModel(pedidoID, descripcion, fechaVenta, cliente, recetas, precios, farmaciaID, nombreFarmacia);
        try {
            pedidosDAO.updatePedido(pedido);
            viewConsole.showMessage("Pedido actualizado correctamente.");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar el pedido: " + e.getMessage());
        }
    }

    // Delete
    public void deletePedido(int pedidoID) {
        try {
            pedidosDAO.deletePedido(pedidoID);
            viewConsole.showMessage("Pedido eliminado correctamente.");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar el pedido: " + e.getMessage());
        }
    }
}
