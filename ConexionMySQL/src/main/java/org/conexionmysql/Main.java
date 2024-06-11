package org.conexionmysql;

import controller.*;
import view.ConsoleView;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello MySQL!");

        ConsoleView consoleView = new ConsoleView();

        /*PreciosController preciosController = new PreciosController(consoleView);
        int id = 12;
        String producto = "Acetaminofen";
        int precio = 25;
        Date fecha_actualizacion = new Date(2024,06,10);
        preciosController.insertPrecio(id, producto, precio,fecha_actualizacion);*/

        RecetasMedicasController recetasMedicasController = new RecetasMedicasController(consoleView);
        int id = 11;
        String paciente = "Jhon";
        String medicamento = "Acetaminofen";
        String dosis = "25mg";
        Date fecha_prescripcion = new Date(2024,06,10);
        recetasMedicasController.insertRecetasMedicas(id,paciente,medicamento,dosis,fecha_prescripcion);
    }
}