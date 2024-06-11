package org.conexionmysql;

import controller.ConexionController;
import controller.CursoController;
import controller.EspecialidadesController;
import view.ConsoleView;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("¡Hola MySQL!");

        ConsoleView consoleView = new ConsoleView();
        CursoController cursoController = new CursoController(consoleView);

        String nombreCurso = "Matemáticas";
        int estadoCurso = 1;
        cursoController.agregarCurso(nombreCurso, estadoCurso);

        // Descomentar para agregar Especialidades
        /*
        EspecialidadesController especialidadesController = new EspecialidadesController(consoleView);
        String nombreEspecialidad = "Neurología";
        String descripcionEspecialidad = "La neurología es la rama de la medicina que estudia el sistema nervioso. Específicamente se ocupa de la prevención, diagnóstico, tratamiento y rehabilitación de todas las enfermedades que involucran al sistema nervioso central, sistema nervioso periférico y el sistema nervioso autónomo.";
        especialidadesController.agregarEspecialidad(nombreEspecialidad, descripcionEspecialidad);
        */

        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (choice) {
                case 1:
                    crudMenu("Doctor", "Doctores");
                    break;
                case 2:
                    crudMenu("Precio", "Precios");
                    break;
                case 3:
                    crudMenu("Receta Médica", "Recetas Médicas");
                    break;
                case 4:
                    crudMenu("Especialidad", "Especialidades");
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 5.");
            }
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("==== Sistema de Gestión de Farmacia ====");
        System.out.println("1. Gestionar Doctores");
        System.out.println("2. Gestionar Precios");
        System.out.println("3. Gestionar Recetas Médicas");
        System.out.println("4. Gestionar Especialidades");
        System.out.println("5. Salir");
        System.out.print("Ingrese su elección: ");
    }

    private static void crudMenu(String entity, String tableName) {
        boolean back = false;

        while (!back) {
            displayCRUDMenu(entity, tableName);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (choice) {
                case 1:
                    createEntity(entity);
                    break;
                case 2:
                    viewEntities(tableName);
                    break;
                case 3:
                    updateEntity(entity);
                    break;
                case 4:
                    deleteEntity(entity);
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 5.");
            }
        }
    }

    private static void displayCRUDMenu(String entity, String tableName) {
        System.out.println("==== Menú de " + entity + " ====");
        System.out.println("1. Agregar un nuevo " + entity);
        System.out.println("2. Ver todos los " + tableName);
        System.out.println("3. Actualizar un " + entity);
        System.out.println("4. Eliminar un " + entity);
        System.out.println("5. Volver al Menú Principal");
        System.out.print("Ingrese su elección: ");
    }

    private static void createEntity(String entity) {
        System.out.println("Creando un nuevo " + entity);
        // Implementar lógica para agregar una nueva entidad
    }

    private static void viewEntities(String tableName) {
        System.out.println("Viendo todos los " + tableName);
        // Implementar lógica para ver todas las entidades
    }

    private static void updateEntity(String entity) {
        System.out.println("Actualizando un " + entity);
        // Implementar lógica para actualizar una entidad
    }

    private static void deleteEntity(String entity) {
        System.out.println("Eliminando un " + entity);
        // Implementar lógica para eliminar una entidad
    }
}
