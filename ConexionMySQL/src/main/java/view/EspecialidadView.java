package view;

import controller.EspecialidadesController;
import java.util.Scanner;

public class EspecialidadView {
    private EspecialidadesController controller;
    private Scanner scanner;

    public EspecialidadView(EspecialidadesController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    private void agregarEspecialidad() {
        System.out.print("Ingrese el nombre de la especialidad: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción de la especialidad: ");
        String descripcion = scanner.nextLine();
        controller.agregarEspecialidad(nombre, descripcion);
    }

    private void mostrarTodasLasEspecialidades() {
        controller.getAllEspecialidades();
    }

    private void actualizarEspecialidad() {
        System.out.print("Ingrese el nombre de la especialidad a actualizar: ");
        String nombreEspecialidad = scanner.nextLine();
        System.out.print("Ingrese la nueva descripción de la especialidad: ");
        String nuevaDescripcion = scanner.nextLine();
        controller.updateEspecialidad(nombreEspecialidad, nuevaDescripcion);
    }

    private void eliminarEspecialidad() {
        System.out.print("Ingrese el nombre de la especialidad a eliminar: ");
        String nombreEliminar = scanner.nextLine();
        controller.deleteEspecialidad(nombreEliminar);
    }
}
