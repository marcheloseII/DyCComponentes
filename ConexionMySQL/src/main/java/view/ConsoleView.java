package view;

import model.ClientModel;
import model.DoctorModel;

import java.util.List;

public class ConsoleView {

    public void showMessage(String message){
        System.out.println(message);
    }

    public void errorMessage(String message){
        System.err.println(message);
    }
    public void showDoctorDetails(DoctorModel doctor) {
        System.out.println("Doctor ID: " + doctor.getDoctorID());
        System.out.println("Name: " + doctor.getName());
        System.out.println("Birthday: " + doctor.getBirthdate());
        System.out.println("Sex: " + doctor.getSex());
        System.out.println("Nationality: " + doctor.getNationality());
        System.out.println("Civil Status: " + doctor.getCivilStatus());
        System.out.println("Address: " + doctor.getAddress());
        System.out.println("Phone Number: " + doctor.getPhoneNumber());
        System.out.println("Email: " + doctor.getEmail());
    }

    public void showAllDoctors(List<DoctorModel> doctors) {
        for (DoctorModel doctor : doctors) {
            showDoctorDetails(doctor);
            System.out.println("-------------------");
        }
    }

    public void showClientDetails(ClientModel client) {
        System.out.println("Doctor ID: " + client.getClientID());
        System.out.println("Name: " + client.getName());
        System.out.println("Birthday: " + client.getBirthdate());
        System.out.println("Sex: " + client.getSex());
        System.out.println("Nationality: " + client.getNationality());
        System.out.println("Civil Status: " + client.getCivilStatus());
        System.out.println("Address: " + client.getAddress());
        System.out.println("Phone Number: " + client.getPhoneNumber());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Identification Number: " + client.getIdNumber());
        System.out.println("Blood Type: " + client.getBloodType());

    }

    public void showAllClients(List<ClientModel> clients) {
        for (ClientModel client : clients) {
            showClientDetails(client);
            System.out.println("-------------------");
        }
    }
}
