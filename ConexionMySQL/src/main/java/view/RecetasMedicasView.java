package view;

import controller.RecetasMedicasController;
import model.RecetasMedicasModel;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class RecetasMedicasView implements CRUDView {
    Scanner scanner;

    private RecetasMedicasController recetasMedicasController;

    public RecetasMedicasView() {
        recetasMedicasController = new RecetasMedicasController(this, new ConsoleView());
        this.scanner = new Scanner(System.in);
    }
/*
    public void showRecetaMedicaDetails(RecetasMedicasModel recetaMedica) {
        System.out.println("Receta Médica Details:");
        System.out.println("ID: " + recetaMedica.getId());
        System.out.println("Paciente: " + recetaMedica.getPaciente());
        System.out.println("Medicamento: " + recetaMedica.getMedicamento());
        System.out.println("Dosis: " + recetaMedica.getDosis());
        System.out.println("Fecha de Prescripción: " + recetaMedica.getFechaPrescripcion());
        System.out.println();
    }
*/
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
    /*        RecetasMedicasController recetasMedicasController = new RecetasMedicasController(consoleView);
        int id = 11;
        String paciente = "Jhon";
        String medicamento = "Acetaminofen";
        String dosis = "25mg";
        Date fecha_prescripcion = new Date(2024,06,10);
        recetasMedicasController.insertRecetasMedicas(id,paciente,medicamento,dosis,fecha_prescripcion);*/

    @Override
    public void crear() {
        System.out.print("Ingrese el id de la receta: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el nombre del paciente: ");
        String paciente = scanner.nextLine();
        System.out.print("Ingrese el nombre del medicamento: ");
        String medicamento = scanner.nextLine();
        System.out.print("Ingrese la cantidad de la dosis: ");
        String dosis = scanner.nextLine();
        System.out.print("Ingrese la fecha de prescripcion del precio (yyyy-MM-dd): ");
        Date fecha_prescripcion = Date.valueOf(scanner.nextLine());
        recetasMedicasController.insertRecetasMedicas(id, paciente, medicamento, dosis,fecha_prescripcion);
        System.out.println("Crear receta médica.");
    }

    @Override
    public void leer() {
        recetasMedicasController.getAllRecetasMedicas();
        System.out.println("Leer recetas médicas.");
    }

    @Override
    public void actualizar() {
        System.out.print("Ingrese el id de la receta: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el nombre del paciente: ");
        String paciente = scanner.nextLine();
        System.out.print("Ingrese el nombre del medicamento: ");
        String medicamento = scanner.nextLine();
        System.out.print("Ingrese la cantidad de la dosis: ");
        String dosis = scanner.nextLine();
        System.out.print("Ingrese la fecha de prescripcion del precio (yyyy-MM-dd): ");
        Date fecha_prescripcion = Date.valueOf(scanner.nextLine());
        recetasMedicasController.updateRecetaMedica(id, paciente, medicamento, dosis,fecha_prescripcion);
        System.out.println("Actualizar recetas médicas.");
    }

    @Override
    public void eliminar() {
        System.out.print("Ingrese el id del precio a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        recetasMedicasController.deleteRecetaMedica(id);
        System.out.println("Eliminar recetas médicas.");
    }
}
