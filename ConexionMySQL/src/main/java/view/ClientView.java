package view;

import controller.ClientController;
import model.ClientModel;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ClientView implements CRUDView {

    private Scanner scanner;
    private ClientController clientController;

    public ClientView() {
        clientController = new ClientController(this, new ConsoleView());
        this.scanner = new Scanner(System.in);
    }

    public void showClientDetails(ClientModel client) {
        System.out.println("Detalles del cliente:");
        System.out.println("ID: " + client.getClientID());
        System.out.println("Nombre: " + client.getName());
        System.out.println("Fecha de nacimiento: " + client.getBirthdate());
        System.out.println("Sexo: " + client.getSex());
        System.out.println("Nacionalidad: " + client.getNationality());
        System.out.println("Estado civil: " + client.getCivilStatus());
        System.out.println("Dirección: " + client.getAddress());
        System.out.println("Número de teléfono: " + client.getPhoneNumber());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Número de identificación: " + client.getIdNumber());
        System.out.println("Tipo de sangre: " + client.getBloodType());
    }

    public void showAllClients(List<ClientModel> clients) {
        for (ClientModel client : clients) {
            showClientDetails(client);
            System.out.println("--------------------------------");
        }
    }

    @Override
    public void crear() {
        System.out.println("\n--- Insertar Cliente ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Fecha de nacimiento (yyyy-mm-dd): ");
        Date birthdate = Date.valueOf(scanner.nextLine());
        System.out.print("Sexo: ");
        String sex = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nationality = scanner.nextLine();
        System.out.print("Estado Civil: ");
        String civilStatus = scanner.nextLine();
        System.out.print("Dirección: ");
        String address = scanner.nextLine();
        System.out.print("Número de teléfono: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine()); // Cambiado a int
        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();
        System.out.print("Número de identificación: ");
        int idNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo de sangre: ");
        scanner.nextLine();
        String bloodType = scanner.nextLine();
        System.out.println("--------------------");

        clientController.insertClient(id, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email, idNumber, bloodType);
    }

    @Override
    public void leer() {
        System.out.println("\n--- Ver Todos los Clientes ---");
        clientController.getAllClients();
    }

    @Override
    public void actualizar() {
        System.out.println("\n--- Actualizar Cliente ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Fecha de nacimiento (yyyy-mm-dd): ");
        Date birthdate = Date.valueOf(scanner.nextLine());
        System.out.print("Sexo: ");
        String sex = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nationality = scanner.nextLine();
        System.out.print("Estado Civil: ");
        String civilStatus = scanner.nextLine();
        System.out.print("Dirección: ");
        String address = scanner.nextLine();
        System.out.print("Número de teléfono: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine()); // Cambiado a int
        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();
        System.out.print("Número de identificación: ");
        int idNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo de sangre: ");
        scanner.nextLine();
        String bloodType = scanner.nextLine();

        clientController.updateClient(id, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email, idNumber, bloodType);
    }

    @Override
    public void eliminar() {
        System.out.println("\n--- Eliminar Cliente ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        clientController.deleteClient(id);
    }
}
