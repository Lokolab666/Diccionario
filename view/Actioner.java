package view;

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


    public void active(String window);
    public void inactive(String window);
    public String[] captureData(String window);
    public void showData(String window);
    public void showMessage(String window);

}
