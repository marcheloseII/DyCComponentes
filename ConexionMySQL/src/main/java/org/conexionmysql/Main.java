package org.conexionmysql;

import controller.ConexionController;
import controller.CursoController;
import controller.DoctorController;
import controller.EspecialidadesController;
import controller.PreciosController;
import view.ConsoleView;

import java.sql.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello MySQL!");
        //ConsoleView viewConsole = new ConsoleView();
        //ConexionController conexionController = new ConexionController(viewConsole);
        //conexionController.openConnection();
        ConsoleView consoleView = new ConsoleView();
        /*CursoController cursoController = new CursoController(consoleView);
        String nombre = "Matematicas";
        int estado = 1;
        cursoController.agregarCurso(nombre, estado);*/

        //Insert a list of Doctors
        /*DoctorController doctorController = new DoctorController(consoleView);
        int doctorID = 2;
        String name = "Robert";
        Date birthdate = new Date(1978,05,12);
        String sex = "male";
        String nationality = "american";
        String civilStatus = "married";
        String address = "123 Main St, Sprinfield, IL";
        int phoneNumber = 555-1234;
        String email = "Robert@example.com";
        doctorController.insertDoctor(doctorID, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email);*/

        PreciosController preciosController = new PreciosController(consoleView);
        int id = 1;
        String producto = "Acetaminofen";
        int precio = 1;
        Date fecha_actualizacion = new Date(2024,06,10);
        preciosController.insertPrecio(id, producto, precio,fecha_actualizacion);
    }
}