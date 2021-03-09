package execution;

import control.Controller;
import view.MainWindow;

public class Runner {

    public static void main(String[] args) {

        MainWindow mainWindow =new MainWindow();

        Controller controller = new Controller( mainWindow );

        mainWindow.initialMenu( controller );

    }
}