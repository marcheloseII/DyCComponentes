package view;

import controller.RecetasMedicasController;
import model.RecetasMedicasModel;

import java.sql.Date;
import java.util.List;

public class RecetasMedicasView implements CRUDView {
    private RecetasMedicasController recetasMedicasController;

    public RecetasMedicasView() {
        recetasMedicasController = new RecetasMedicasController(this, new ConsoleView());
    }

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
    /*        RecetasMedicasController recetasMedicasController = new RecetasMedicasController(consoleView);
        int id = 11;
        String paciente = "Jhon";
        String medicamento = "Acetaminofen";
        String dosis = "25mg";
        Date fecha_prescripcion = new Date(2024,06,10);
        recetasMedicasController.insertRecetasMedicas(id,paciente,medicamento,dosis,fecha_prescripcion);*/

    @Override
    public void crear() {
        // Lógica para crear una receta médica
        System.out.println("Crear receta médica.");
    }

    @Override
    public void leer() {
        // Lógica para leer recetas médicas
        System.out.println("Leer recetas médicas.");
    }

    @Override
    public void actualizar() {
        // Lógica para actualizar una receta médica
        System.out.println("Actualizar recetas médicas.");
    }

    @Override
    public void eliminar() {
        // Lógica para eliminar una receta médica
        System.out.println("Eliminar recetas médicas.");
    }
}
