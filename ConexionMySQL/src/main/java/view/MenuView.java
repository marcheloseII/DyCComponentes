package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private PreciosView preciosView;
    private RecetasMedicasView recetasMedicasView;
    private EspecialidadesView especialidadesView;
    private DoctorView doctorView;
    private ClientView clientView;
    private EmpleadosView empleadosView;

    public MenuView() {
        scanner = new Scanner(System.in);
        preciosView = new PreciosView();
        recetasMedicasView = new RecetasMedicasView();
        especialidadesView = new EspecialidadesView();
        doctorView = new DoctorView();
        clientView = new ClientView();
        empleadosView = new EmpleadosView();
    }

    public void showMainMenu() {
        int option = -1;

        while (true) {
            System.out.println("Seleccione una tabla:");
            System.out.println("1. Precios");
            System.out.println("2. Recetas Medicas");
            System.out.println("3. Doctores");
            System.out.println("4. Clientes");
            System.out.println("5. Especialidades");
            System.out.println("8. Especialidades");
            System.out.println("0. Salir");

            option = getValidIntInput();

            switch (option) {
                case 1:
                    manageCRUD(preciosView);
                    break;
                case 2:
                    manageCRUD(recetasMedicasView);
                    break;
                case 3:
                    manageCRUD(doctorView);
                    break;
                case 4:
                    manageCRUD(clientView);
                    break;
                case 5:
                    manageCRUD(especialidadesView);
                    break;
                case 8:
                    manageCRUD(empleadosView);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }

    private void manageCRUD(CRUDView tablaSeleccionada) {
        while (true) {
            System.out.println("Gestión de CRUD:");
            System.out.println("1. Crear");
            System.out.println("2. Leer");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver al menú principal");

            int option = getValidIntInput();

            switch (option) {
                case 1:
                    tablaSeleccionada.crear();
                    break;
                case 2:
                    tablaSeleccionada.leer();
                    break;
                case 3:
                    tablaSeleccionada.actualizar();
                    break;
                case 4:
                    tablaSeleccionada.eliminar();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }

    private int getValidIntInput() {
        int input = -1;
        while (true) {
            try {
                input = scanner.nextInt();
                if (input < 0) {
                    System.out.println("No se permiten números negativos. Por favor, intente nuevamente.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
        return input;
    }
}
