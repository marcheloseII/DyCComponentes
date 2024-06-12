package view;


import controller.EspecialidadesController;
import model.EspecialidadesModel;

import java.util.List;
import java.util.Scanner;

public class EspecialidadesView {
    private EspecialidadesController especialidadesController;
    private Scanner scanner;

    public EspecialidadesView(EspecialidadesController controller) {
        this.especialidadesController = controller;
        this.scanner = new Scanner(System.in);
    }

    public void showAllEspecialides(List<EspecialidadesModel> especialidades) {
        System.out.println("Lista de especialidades:");
        for (EspecialidadesModel especialidad : especialidades) {
            System.out.println("ID: " + especialidad.getId() + ", Nombre: " + especialidad.getNombre() + ", Descripcion: " + especialidad.getDescripcion());
        }
        System.out.println();
    }

    @Override
    public void crear() {
        System.out.print("Ingrese el nombre de la especialidad: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción de la especialidad: ");
        String descripcion = scanner.nextLine();
        especialidadesController.agregarEspecialidad(nombre, descripcion);
    }

    @Override
    public void leer() {
        especialidadesController.getAllEspecialidades();
        System.out.println("Leer especialidades");
    }

    @Override
    public void actualizar() {
        System.out.print("Ingrese el nombre de la especialidad a actualizar: ");
        String nombreEspecialidad = scanner.nextLine();
        System.out.print("Ingrese la nueva descripción de la especialidad: ");
        String nuevaDescripcion = scanner.nextLine();
        especialidadesController.updateEspecialidad(nombreEspecialidad, nuevaDescripcion);
    }

    @Override
    public void eliminar() {
        System.out.print("Ingrese el nombre de la especialidad a eliminar: ");
        String nombreEliminar = scanner.nextLine();
        especialidadesController.deleteEspecialidad(nombreEliminar);
    }
}
