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

}
