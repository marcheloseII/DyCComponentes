package view;

import controller.EmpleadosController;
import model.EmpleadosModel;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpleadosView implements CRUDView {
    private Scanner scanner;
    private EmpleadosController empleadosController;

    public EmpleadosView() {
        empleadosController = new EmpleadosController(this, new ConsoleView());
        this.scanner = new Scanner(System.in);
    }

    public void showAllEmpleados(List<EmpleadosModel> empleados) {
        System.out.println("Lista de Empleados:");
        for (EmpleadosModel empleado : empleados) {
            System.out.println("ID: " + empleado.getId() + ", Nombre: " + empleado.getNombre() +
                    ", Rol: " + empleado.getRol() + ", Email: " + empleado.getEmail() +
                    ", Sexo: " + empleado.getSexo() + ", Doctor ID: " + empleado.getDoctorID());
        }
        System.out.println();
    }

    @Override
    public void crear() {
        System.out.print("Ingrese el id del empleado: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el rol del empleado: ");
        String rol = scanner.nextLine();
        System.out.print("Ingrese el email del empleado: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el sexo del empleado (M/F): ");
        char sexo = scanner.nextLine().charAt(0);
        System.out.print("Ingrese el id del doctor asociado: ");
        int doctorID = Integer.parseInt(scanner.nextLine());
        empleadosController.insertEmpleado(id, nombre, rol, email, sexo, doctorID);
        System.out.println("Empleado creado exitosamente.");
    }

    @Override
    public void leer() {
        empleadosController.getAllEmpleados();
        System.out.println("Leer empleados.");
    }

    @Override
    public void actualizar() {
        System.out.print("Ingrese el id del empleado: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el rol del empleado: ");
        String rol = scanner.nextLine();
        System.out.print("Ingrese el email del empleado: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el sexo del empleado (M/F): ");
        char sexo = scanner.nextLine().charAt(0);
        System.out.print("Ingrese el id del doctor asociado: ");
        int doctorID = Integer.parseInt(scanner.nextLine());
        empleadosController.updateEmpleado(id, nombre, rol, email, sexo, doctorID);
        System.out.println("Empleado actualizado exitosamente.");
    }

    @Override
    public void eliminar() {
        System.out.print("Ingrese el id del empleado a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        empleadosController.deleteEmpleado(id);
        System.out.println("El empleado ha sido eliminado.");
    }

}
