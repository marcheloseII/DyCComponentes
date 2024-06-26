package controller;

import model.ClientDAO;
import model.ClientModel;
import model.conexion;
import view.ClientView;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ClientController {
    private ConsoleView viewConsole;
    private ClientView clientView;
    private ClientDAO clientDAO;

    public ClientController(ClientView viewClient, ConsoleView viewConsole) {
        this.clientView = viewClient;
        this.viewConsole = viewConsole;
        Connection conn = conexion.getInstance().getConnection();
        this.clientDAO = new ClientDAO(conn);
    }

    // Create
    public void insertClient(int clientID, String name, Date birthdate, String sex, String nationality, String civilStatus, String address, int phoneNumber, String email, int idNumber, String bloodType) {
        ClientModel data = new ClientModel(clientID, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email, idNumber, bloodType);

        try {
            clientDAO.createClient(data);
            viewConsole.showMessage("Inserción de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

    // Read by ID
    public void getClientByID(int doctorID) {
        try {
            ClientModel client = clientDAO.getClientByID(doctorID);
            if (client != null) {
                clientView.showClientDetails(client);
            } else {
                viewConsole.showMessage("Cliente no encontrado");
            }
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener datos: " + e.getMessage());
        }
    }

    // Read all
    public void getAllClients() {
        try {
            List<ClientModel> clients = clientDAO.getAllClients();
            clientView.showAllClients(clients);
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al obtener lista de doctores: " + e.getMessage());
        }
    }

    // Update
    public void updateClient(int clientID, String name, Date birthdate, String sex, String nationality, String civilStatus, String address, int phoneNumber, String email, int idNumber, String bloodType) {
        ClientModel data = new ClientModel(clientID, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email, idNumber, bloodType);

        try {
            clientDAO.updateClient(data);
            viewConsole.showMessage("Actualización de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al actualizar datos: " + e.getMessage());
        }
    }

    // Delete
    public void deleteClient(int clientID) {
        try {
            clientDAO.deleteClient(clientID);
            viewConsole.showMessage("Eliminación de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al eliminar datos: " + e.getMessage());
        }
    }
}
