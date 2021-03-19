package view;

/**
 * Clase que contiene la interfaz del programa. Contiene las acciones a las cuales se les asigna los botones
 */
public interface Actioner {

    //Menu Window
    public static String ADDWORDMENUWINDOW = "addWordInMenuWindow";
    public static String SEARCHWORDMENUWINDOW = "searchWordInMenuWindow";
    public static String SHOWORDMENUWINDOW = "showWordInMenuWindow";
    public static String EDITWORDMENUWINDOW = "editWordInMenuWindow";
    public static String DELETEWORDMENUWINDOW = "deleteWordInMenuWindow";

    //AddEditWindow
    public static String SENDNEWWORD = "sendNewWord";
    public static String SENDEDITWORD = "sendEditWord";
    public static String BACKTOMENU = "backToMenu";

    //SearchEditWindow
    public static String SEARCHWORD = "searchWord";
    public static String SEARCHEDITWORD = "searchEditWord";
    public static String SEARCHDELETEWORD = "searchDeleteWord";

    //ViewWindow
    public static String VIEWALETTER = "showOnlyALetter";
    public static String VIEWALLLETTER = "showAllLetters";
    public static String VIEWSEARHALETTER = "searchToWordForView";


    /**
     * Contiene los métodos para los que hace funcionar los botoner
     * active para activar las ventanas y componentes
     * inactive para desactivar las ventanas y componentes
     * captureData para obtener o capturar los datos
     * showData para mostrar los datos o atributos de acuerdo con la seleccion
     * showMessage para mostrar el mensaje que indica la operacion
     * @param window Sirve para contener la ventana a la cual participan las acciones
     */
    public void active(String window);
    public void inactive(String window);
    public String[] captureData(String window);
    public void showData(String[][] out, String window);
    public void showMessage(String message);

}
