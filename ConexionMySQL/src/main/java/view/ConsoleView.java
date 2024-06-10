package view;

import model.EspecialidadesModel;
import java.util.List;

public class ConsoleView {

    public void showMessage(String message){
        System.out.println(message);
    }

    public void errorMessage(String message){
        System.err.println(message);
    }

    public void showEspecialidadDetails(EspecialidadesModel especialidad) {
        System.out.println("Nombre: " + especialidad.getNombre());
        System.out.println("Descripcion: " + especialidad.getDescripcion());;
    }

    public void showAllEspecialidades(List<EspecialidadesModel> especialidades) {
        for (EspecialidadesModel especialidad : especialidades) {
            showEspecialidadDetails(especialidad);
            System.out.println("-------------------");
        }
    }

}
