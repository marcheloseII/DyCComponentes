package org.conexionmysql;

import controller.*;
import view.*;

import java.sql.Date;


public class Main {
    public static void main(String[] args) {

            int opcion = scanner.nextInt();
            scanner.nextLine();


        MenuView menuView = new MenuView();
        menuView.showMainMenu();


    }
}

