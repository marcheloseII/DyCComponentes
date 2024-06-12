package view;

import controller.DoctorController;
import model.DoctorModel;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class DoctorView implements CRUDView {

    Scanner scanner;
    private DoctorController doctorController;

    public DoctorView() {
        doctorController = new DoctorController(new ConsoleView(), this);
        this.scanner = new Scanner(System.in);
    }
    public void showDoctorDetails(DoctorModel doctor) {
        System.out.println("Detalles del doctor:");
        System.out.println("ID: " + doctor.getDoctorID());
        System.out.println("Nombre: " + doctor.getName());
        System.out.println("Fecha de nacimiento: " + doctor.getBirthdate());
        System.out.println("Sexo: " + doctor.getSex());
        System.out.println("Nacionalidad: " + doctor.getNationality());
        System.out.println("Estado civil: " + doctor.getCivilStatus());
        System.out.println("Dirección: " + doctor.getAddress());
        System.out.println("Número de teléfono: " + doctor.getPhoneNumber());
        System.out.println("Email: " + doctor.getEmail());
    }

    public void showAllDoctors(List<DoctorModel> doctors) {
        for (DoctorModel doctor : doctors) {
            showDoctorDetails(doctor);
            System.out.println("--------------------------------");
        }
    }

    @Override
    public void crear() {
        System.out.println("\n--- Insertar Doctor ---");
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
        int phoneNumber = scanner.nextInt();
        System.out.print("Correo electrónico: ");
        scanner.nextLine();
        String email = scanner.nextLine();
        System.out.println("--------------------");

        doctorController.insertDoctor(id, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email);
    }

    @Override
    public void leer() {
        System.out.println("\n--- Ver Todos los Doctores ---");
        doctorController.getAllDoctors();
    }

    @Override
    public void actualizar() {
        System.out.println("\n--- Actualizar Doctor ---");
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
        int phoneNumber = scanner.nextInt();
        System.out.print("Correo electrónico: ");
        scanner.nextLine();
        String email = scanner.nextLine();

        doctorController.updateDoctor(id, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email);
    }

    @Override
    public void eliminar() {
        System.out.println("\n--- Eliminar Doctor ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        doctorController.deleteDoctor(id);
    }
}
