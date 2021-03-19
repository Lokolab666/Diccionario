package execution;

import control.Controller;
import view.MainWindow;

/**
 * Clase que contiene static void main para que se ejecute el programa
 */
public class Runner {

    /**
     * Metodo que inicializa el programa.
     * Contiene la ventana principal y el controlador
     * @param args contiene argumentos de tipo String
     */
    public static void main(String[] args) {

        MainWindow mainWindow =new MainWindow();

        Controller controller = new Controller( mainWindow );

        mainWindow.initialMenu( controller );

    }
}