package org.conexionmysql;

import controller.ConexionController;
import controller.CursoController;
import controller.DoctorController;
import controller.EspecialidadesController;
import view.ConsoleView;

import java.sql.Date;

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

        //Insert a list of Doctors
        DoctorController doctorController = new DoctorController(consoleView);
        int doctorID = 1;
        String name = "John Doe";
        Date birthdate = new Date(1978,05,12);
        String sex = "male";
        String nationality = "american";
        String civilStatus = "married";
        String address = "123 Main St, Sprinfield, IL";
        int phoneNumber = 555-1234;
        String email = "john.doe@example.com";
        doctorController.insertDoctor(doctorID, name, birthdate, sex, nationality, civilStatus, address, phoneNumber, email);

        /*INSERT INTO `Doctors_AFS` (`doctorID`, `name`, `birthdate`, `sex`, `nationality`, `civilStatus`, `address`, `phoneNumber`, `email`) VALUES
        (1, 'John Doe', '1978-05-12', 'Male', 'American', 'Married', '123 Main St, Springfield, IL', '555-1234', 'john.doe@example.com'),
        (2, 'Jane Smith', '1985-03-22', 'Female', 'British', 'Single', '456 Elm St, London', '555-5678', 'jane.smith@example.co.uk'),
        (3, 'Carlos González', '1990-07-30', 'Male', 'Mexican', 'Married', '789 Pine St, Mexico City', '555-8765', 'carlos.gonzalez@example.mx'),
        (4, 'Anna Müller', '1982-11-17', 'Female', 'German', 'Single', '321 Oak St, Berlin', '555-4321', 'anna.mueller@example.de'),
        (5, 'Li Wei', '1975-01-25', 'Male', 'Chinese', 'Divorced', '654 Willow St, Beijing', '555-5674', 'li.wei@example.cn'),
        (6, 'Sophia Rossi', '1992-06-15', 'Female', 'Italian', 'Single', '987 Cedar St, Rome', '555-3456', 'sophia.rossi@example.it'),
        (7, 'Ahmed Khan', '1980-09-05', 'Male', 'Pakistani', 'Married', '432 Birch St, Karachi', '555-9087', 'ahmed.khan@example.pk'),
        (8, 'Emily Brown', '1988-12-11', 'Female', 'Australian', 'Married', '123 Maple St, Sydney', '555-6543', 'emily.brown@example.au'),
        (9, 'Victor Ivanov', '1977-04-19', 'Male', 'Russian', 'Single', '456 Ash St, Moscow', '555-3210', 'victor.ivanov@example.ru'),
        (10, 'Aiko Tanaka', '1983-08-23', 'Female', 'Japanese', 'Married', '789 Fir St, Tokyo', '555-7890', 'aiko.tanaka@example.jp'); */
    }
}