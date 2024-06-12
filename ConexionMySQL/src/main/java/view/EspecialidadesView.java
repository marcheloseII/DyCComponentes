package view;


import controller.EspecialidadesController;
import java.util.Scanner;

public class EspecialidadesView {
    private EspecialidadesController especialidadesController;
    private Scanner scanner;

    public EspecialidadesView(EspecialidadesController controller) {
        this.especialidadesController = controller;
        this.scanner = new Scanner(System.in);
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
