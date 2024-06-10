package org.conexionmysql;

import controller.ConexionController;
import controller.CursoController;
import controller.EspecialidadesController;
import view.ConsoleView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello MySQL!");
        ConsoleView viewConsole = new ConsoleView();
        //ConexionController conexionController = new ConexionController(viewConsole);
        //conexionController.openConnection();
        ConsoleView consoleView = new ConsoleView();
        CursoController cursoController = new CursoController(consoleView);
        String nombre = "Matematicas";
        int estado = 1;
        cursoController.agregarCurso(nombre, estado);

        //Especialidades agregar
        /*ConsoleView consoleView = new ConsoleView();
        EspecialidadesController especialidadesController = new EspecialidadesController(consoleView);
        String nombre = "Neurología";
        String descripcion = "La neurologia es la rama de la medicina que estudia el sistema nervioso. Específicamente se ocupa de la prevención, diagnóstico, tratamiento y rehabilitación de todas las enfermedades que involucran al sistema nervioso central, sistema nervioso periférico y el sistema nervioso autónomo.";
        especialidadesController.agregarEspecialidad(nombre, descripcion);*/

        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    crudMenu("Doctor", "Doctors");
                    break;
                case 2:
                    crudMenu("Price", "Prices");
                    break;
                case 3:
                    crudMenu("Medical Prescription", "Medical Prescriptions");
                    break;
                case 4:
                    crudMenu("Specialty", "Specialties");
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("==== Drug Store Management System ====");
        System.out.println("1. Manage Doctors");
        System.out.println("2. Manage Prices");
        System.out.println("3. Manage Medical Prescriptions");
        System.out.println("4. Manage Specialties");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void crudMenu(String entity, String tableName) {
        boolean back = false;

        while (!back) {
            displayCRUDMenu(entity, tableName);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void displayCRUDMenu(String entity, String tableName) {
        System.out.println("==== " + entity + " Menu ====");
        System.out.println("1. Add a new " + entity);
        System.out.println("2. View all " + tableName);
        System.out.println("3. Update a " + entity);
        System.out.println("4. Delete a " + entity);
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void createEntity(String entity) {
        System.out.println("Creating a new " + entity);
        // Implement logic to add a new entity
    }

    private static void viewEntities(String tableName) {
        System.out.println("Viewing all " + tableName);
        // Implement logic to view all entities
    }

    private static void updateEntity(String entity) {
        System.out.println("Updating a " + entity);
        // Implement logic to update an entity
    }

    private static void deleteEntity(String entity) {
        System.out.println("Deleting a " + entity);
        // Implement logic to delete an entity
    }

}