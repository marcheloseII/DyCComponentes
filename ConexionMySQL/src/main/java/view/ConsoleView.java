package view;

import model.ClientModel;
import model.DoctorModel;
import model.PreciosModel;
import model.RecetasMedicasModel;

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

    public void showPrecioDetails(PreciosModel precio) {
        System.out.println("Precio Details:");
        System.out.println("ID: " + precio.getId());
        System.out.println("Producto: " + precio.getProducto());
        System.out.println("Precio: " + precio.getPrecio());
        System.out.println("Fecha de Actualización: " + precio.getFechaActualizacion());
        System.out.println();
    }

    //Precios
    public void showAllPrecios(List<PreciosModel> precios) {
        System.out.println("Lista de Precios:");
        for (PreciosModel precio : precios) {
            System.out.println("ID: " + precio.getId() + ", Producto: " + precio.getProducto() + ", Precio: " + precio.getPrecio() + ", Fecha de Actualización: " + precio.getFechaActualizacion());
        }
        System.out.println();
    }

    //Recetas Medicas
    public void showRecetaMedicaDetails(RecetasMedicasModel recetaMedica) {
        System.out.println("Receta Médica Details:");
        System.out.println("ID: " + recetaMedica.getId());
        System.out.println("Paciente: " + recetaMedica.getPaciente());
        System.out.println("Medicamento: " + recetaMedica.getMedicamento());
        System.out.println("Dosis: " + recetaMedica.getDosis());
        System.out.println("Fecha de Prescripción: " + recetaMedica.getFechaPrescripcion());
        System.out.println();
    }

    public void showAllRecetasMedicas(List<RecetasMedicasModel> recetasMedicas) {
        System.out.println("Lista de Recetas Médicas:");
        for (RecetasMedicasModel recetaMedica : recetasMedicas) {
            System.out.println("ID: " + recetaMedica.getId() +
                    ", Paciente: " + recetaMedica.getPaciente() +
                    ", Medicamento: " + recetaMedica.getMedicamento() +
                    ", Dosis: " + recetaMedica.getDosis() +
                    ", Fecha de Prescripción: " + recetaMedica.getFechaPrescripcion());
        }
        System.out.println();
    }
}
