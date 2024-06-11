package org.conexionmysql;

import controller.ConexionController;
import controller.CursoController;
import controller.EspecialidadesController;
import view.ConsoleView;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleView viewConsole = new ConsoleView();
        EspecialidadesController controller = new EspecialidadesController(viewConsole);

        boolean running = true;

        while (running) {
            System.out.println("=== Menú de Especialidades ===");
            System.out.println("1. Agregar Especialidad");
            System.out.println("2. Mostrar Todas las Especialidades");
            System.out.println("3. Actualizar Especialidad");
            System.out.println("4. Eliminar Especialidad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la especialidad: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la descripción de la especialidad: ");
                    String descripcion = scanner.nextLine();
                    controller.agregarEspecialidad(nombre, descripcion);
                    break;
                case 2:
                    controller.getAllEspecialidades();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la especialidad a actualizar: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Ingrese la nueva descripción de la especialidad: ");
                    String nuevaDescripcion = scanner.nextLine();
                    controller.updateEspecialidad(nombreActualizar, nuevaDescripcion);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la especialidad a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    controller.deleteEspecialidad(nombreEliminar);
                    break;
                case 5:
                    running = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}

