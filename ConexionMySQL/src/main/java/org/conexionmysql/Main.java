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


    }
}