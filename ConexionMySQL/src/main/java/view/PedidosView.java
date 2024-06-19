package view;

import controller.PedidosController;
import model.PedidosModel;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class PedidosView implements CRUDView {

    Scanner scanner;

    private PedidosController pedidosController;

    public PedidosView () {
        pedidosController = new PedidosController(new ConsoleView(), this);
        this.scanner = new Scanner(System.in);
    }
    public void showPedidoDetails(PedidosModel pedido) {
        System.out.println("Detalles del Pedido:");
        System.out.println("ID Pedido: " + pedido.getPedidoID());
        System.out.println("Descripción: " + pedido.getDescripcion());
        System.out.println("Fecha de Venta: " + pedido.getFechaVenta());
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Receta: " + pedido.getRecetas());
        System.out.println("Precio: " + pedido.getPrecios());
        System.out.println("ID Farmacia: " + pedido.getFarmaciaID());
        System.out.println("Nombre Farmacia: " + pedido.getNombreFarmacia());
    }

    public void showAllPedidos(List<PedidosModel> pedidosList) {
        System.out.println("Lista de Pedidos:");
        for (PedidosModel pedido : pedidosList) {
            showPedidoDetails(pedido);
            System.out.println("---------------------");
        }
    }

    @Override
    public void crear() {
        System.out.println("Ingrese los datos del nuevo pedido:");
        System.out.print("ID Pedido: ");
        int pedidoID = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha de Venta (YYYY-MM-DD): ");
        Date fechaVenta = Date.valueOf(scanner.nextLine());

        System.out.print("ID Cliente: ");
        int clienteID = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("ID Receta: ");
        int recetaID = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("ID Precio: ");
        int precioID = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("ID Farmacia: ");
        int farmaciaID = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Nombre Farmacia: ");
        String nombreFarmacia = scanner.nextLine();
        System.out.println("--------------------");

        pedidosController.insertPedidos(pedidoID, descripcion, fechaVenta, clienteID, recetaID, precioID, farmaciaID, nombreFarmacia);
    }

    @Override
    public void leer() {
        System.out.println("\n--- Ver Todos los Pedidos ---");
        pedidosController.getAllPedidos();
    }

    @Override
    public void actualizar() {
        System.out.println("Ingrese los datos del pedido a actualizar:");
        int pedidoID = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha de Venta (YYYY-MM-DD): ");
        Date fechaVenta = Date.valueOf(scanner.nextLine());

        System.out.print("ID Cliente: ");
        int clienteID = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("ID Receta: ");
        int recetaID = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("ID Precio: ");
        int precioID = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("ID Farmacia: ");
        int farmaciaID = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Nombre Farmacia: ");
        String nombreFarmacia = scanner.nextLine();

        pedidosController.updatePedido(pedidoID, descripcion, fechaVenta, clienteID, recetaID, precioID, farmaciaID, nombreFarmacia);
    }

    @Override
    public void eliminar() {
        System.out.println("\n--- Eliminar Pedido ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        pedidosController.deletePedido(id);
    }
}
