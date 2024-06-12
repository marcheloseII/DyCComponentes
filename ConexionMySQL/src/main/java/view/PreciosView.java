package view;

import controller.PreciosController;
import model.PreciosModel;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class PreciosView implements CRUDView {
    Scanner scanner;

    private PreciosController preciosController;

    public PreciosView() {
        preciosController = new PreciosController(this, new ConsoleView());
        this.scanner = new Scanner(System.in);
    }
/*
    public void showPrecioDetails(PreciosModel precio) {
        System.out.println("Precio Details:");
        System.out.println("ID: " + precio.getId());
        System.out.println("Producto: " + precio.getProducto());
        System.out.println("Precio: " + precio.getPrecio());
        System.out.println("Fecha de Actualización: " + precio.getFechaActualizacion());
        System.out.println();
    }
*/
    public void showAllPrecios(List<PreciosModel> precios) {
        System.out.println("Lista de Precios:");
        for (PreciosModel precio : precios) {
            System.out.println("ID: " + precio.getId() + ", Producto: " + precio.getProducto() + ", Precio: " + precio.getPrecio() + ", Fecha de Actualización: " + precio.getFechaActualizacion());
        }
        System.out.println();
    }

    @Override
    public void crear() {
        System.out.print("Ingrese el id del precio: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el nombre del precio: ");
        String producto = scanner.nextLine();
        System.out.print("Ingrese el precio del precio: ");
        int precio = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese la fecha de actualización del precio (yyyy-MM-dd): ");
        Date fecha_actualizacion = Date.valueOf(scanner.nextLine());
        preciosController.insertPrecio(id, producto, precio, fecha_actualizacion);
        System.out.println("Precio creado exitosamente.");
    }

    @Override
    public void leer() {
        preciosController.getAllPrecios();
        System.out.println("Leer precios.");
    }

    @Override
    public void actualizar() {
        System.out.print("Ingrese el id del precio: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el nombre del precio: ");
        String producto = scanner.nextLine();
        System.out.print("Ingrese el precio del precio: ");
        int precio = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese la fecha de actualización del precio (yyyy-MM-dd): ");
        Date fecha_actualizacion = Date.valueOf(scanner.nextLine());
        preciosController.updatePrecio(id, producto, precio, fecha_actualizacion);
        System.out.println("Actualizar precios.");
    }

    @Override
    public void eliminar() {
        System.out.print("Ingrese el id del precio a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        preciosController.deletePrecio(id);
        System.out.println("El precio ha sido eliminado.");
    }
}
