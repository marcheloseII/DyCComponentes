package view;

import controller.RecetasMedicasController;
import controller.SucursalesController;
import model.RecetasMedicasModel;
import model.SucursalesModel;

import java.util.List;
import java.util.Scanner;

public class SucursalesView implements CRUDView {
    private SucursalesController sucursalesController;
    private Scanner scanner;

    public SucursalesView() {
        sucursalesController = new SucursalesController(this, new ConsoleView());
        this.scanner = new Scanner(System.in);
    }

    public void showAllSucursales(List<SucursalesModel> sucursales) {
        System.out.println("Lista de sucursales:");
        for (SucursalesModel sucursal : sucursales) {
            System.out.println("ID: " + sucursal.getId() +
                    ", Nombre: " + sucursal.getNombre() +
                    ", Locacion: " + sucursal.getLocacion() +
                    ", Doctores: " + sucursal.getClienteID() +
                    ", Clientes: " + sucursal.getDoctorID() +
                    ", Receta: " + sucursal.getRecetaID());
        }
        System.out.println();
    }

    @Override
    public void crear() {
        System.out.println("\n--- Insertar Sucursal ---");
        System.out.print("ID de sucursal: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Locacion: ");
        String locacion = scanner.nextLine();
        System.out.print("Ingrese el ID del cliente: ");
        String doctor = scanner.nextLine();
        System.out.print("Ingrese el ID del doctor: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese el ID de la receta asignada: ");
        String receta = scanner.nextLine();
        System.out.println("--------------------");

        sucursalesController.agregarSucursal(id, nombre, locacion, doctor, cliente, receta);
    }

    @Override
    public void leer() {
        sucursalesController.getAllSucursales();
        System.out.println("\n--- Ver Todas las Sucursales ---");
    }

    @Override
    public void actualizar() {
        System.out.println("\n--- Actualizar Sucursal ---");
        System.out.print("ID de sucursal: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Locacion: ");
        String locacion = scanner.nextLine();
        System.out.print("Ingrese el ID del cliente: ");
        String doctor = scanner.nextLine();
        System.out.print("Ingrese el ID del doctor: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese el ID de la receta asignada: ");
        String receta = scanner.nextLine();
        System.out.println("--------------------");

        sucursalesController.updateSucursal(id, nombre, locacion, doctor, cliente, receta);
    }

    @Override
    public void eliminar() {
        System.out.println("\n--- Eliminar Sucursal ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        sucursalesController.deleteSucursal(nombre);
    }
}
