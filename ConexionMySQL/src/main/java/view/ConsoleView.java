package view;


import model.ClientModel;
import model.DoctorModel;
import model.PreciosModel;
import model.RecetasMedicasModel;


import java.util.List;

public class ConsoleView {

    public void showMessage(String message){
        System.out.println(message);
    }

    public void errorMessage(String message){
        System.err.println(message);
    }

}
