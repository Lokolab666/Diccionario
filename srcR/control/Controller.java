package control;

import logic.DictionaryManagement;
import view.Actioner;
import view.AddEditWindow;
import view.ViewWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que contiene las acciones del controlador de acuerdo con los botones
 */
public class Controller implements ActionListener {

    private Actioner actioner;

    //Class
    private AddEditWindow addEditWindow;
    private ViewWindow viewWindow;

    private DictionaryManagement dictionaryManagement;


    public Controller( Actioner actioner ){
        this.actioner = actioner;

        dictionaryManagement = new DictionaryManagement();


    }

    /**
     * Metodo que contiene las acciones de los botones
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()){

            case Actioner.ADDWORDMENUWINDOW:
                actioner.inactive( Actioner.ADDWORDMENUWINDOW );
                actioner.active( Actioner.ADDWORDMENUWINDOW );
                break;

            case Actioner.SEARCHWORDMENUWINDOW:
                actioner.inactive( Actioner.SEARCHWORDMENUWINDOW );
                actioner.active( Actioner.SEARCHWORDMENUWINDOW );
                break;

            case Actioner.SHOWORDMENUWINDOW:
                actioner.inactive( Actioner.SHOWORDMENUWINDOW );
                actioner.active( Actioner.SHOWORDMENUWINDOW );
                break;

            case Actioner.EDITWORDMENUWINDOW:
                actioner.inactive( Actioner.EDITWORDMENUWINDOW );
                actioner.active( Actioner.EDITWORDMENUWINDOW );
                break;

            case Actioner.DELETEWORDMENUWINDOW:
                actioner.inactive( Actioner.DELETEWORDMENUWINDOW );
                actioner.active( Actioner.DELETEWORDMENUWINDOW );
                break;

            //WINDOW ADDEDIT

            case Actioner.SENDNEWWORD:
                String[] captureDataSendWord = actioner.captureData(Actioner.SENDNEWWORD);
                actioner.showMessage(dictionaryManagement.createWord(captureDataSendWord));

                actioner.inactive( Actioner.SENDNEWWORD );
                actioner.active( Actioner.SENDNEWWORD );
                break;

            case Actioner.SENDEDITWORD:
                String[] captureDataSendEdit = actioner.captureData(Actioner.SENDEDITWORD);
                actioner.showMessage(dictionaryManagement.editWord(captureDataSendEdit));

                actioner.inactive( Actioner.SENDEDITWORD);
                actioner.active( Actioner.SENDEDITWORD );

                break;

            case Actioner.BACKTOMENU:
                actioner.inactive( Actioner.BACKTOMENU );
                actioner.active( Actioner.BACKTOMENU );

                break;

                //WINDOW SEARCHEDITWORD

            case Actioner.SEARCHWORD:
                String[] captureDataSearchWord = actioner.captureData(Actioner.SEARCHWORD);
                if ( dictionaryManagement.searchWord(captureDataSearchWord) != null ){
                    String[][] showSearchData = new String[1][3];
                    showSearchData[0][0] = dictionaryManagement.searchWord(captureDataSearchWord)[0];
                    showSearchData[0][1] = dictionaryManagement.searchWord(captureDataSearchWord)[1];
                    showSearchData[0][2] = dictionaryManagement.searchWord(captureDataSearchWord)[2];
                    actioner.showData(showSearchData, Actioner.SEARCHWORD);
                    actioner.inactive( Actioner.SEARCHWORD );
                    actioner.active( Actioner.SEARCHWORD );
                }else {
                    actioner.showMessage("Palabra no encontrada");
                }
                break;

            case Actioner.SEARCHEDITWORD:
                String[] captureDataSendEditWord = actioner.captureData(Actioner.SEARCHEDITWORD);
                 if (dictionaryManagement.searchEditWord(captureDataSendEditWord) != null){
                    String[][] showEditData = new String[1][3];
                    showEditData[0][0] = dictionaryManagement.searchEditWord(captureDataSendEditWord)[0];
                    showEditData[0][1] = dictionaryManagement.searchEditWord(captureDataSendEditWord)[1];
                    showEditData[0][2] = dictionaryManagement.searchEditWord(captureDataSendEditWord)[2];
                    actioner.showData(showEditData, Actioner.SEARCHEDITWORD);

                    dictionaryManagement.deleteWordInSearch(captureDataSendEditWord);
                    actioner.inactive( Actioner.SEARCHEDITWORD );
                    actioner.active( Actioner.SEARCHEDITWORD );
                 }
                break;

            case Actioner.SEARCHDELETEWORD:
                String[] captureDataDeleteWWord = actioner.captureData(Actioner.SEARCHDELETEWORD);
                if ( dictionaryManagement.deleteWord(captureDataDeleteWWord) == "Palabra eliminada" ){
                    actioner.showMessage("Palabra eliminada");
                }else {
                    actioner.showMessage("Palabra NO eliminada");
                }

                actioner.inactive( Actioner.SEARCHDELETEWORD );
                actioner.active( Actioner.SEARCHDELETEWORD );

                break;

            //WINDOW VIEW

            case Actioner.VIEWALETTER:
                actioner.inactive( Actioner.VIEWALETTER );
                actioner.active( Actioner.VIEWALETTER );

                break;

            case Actioner.VIEWSEARHALETTER:
                String[] dataSearchWord = actioner.captureData(Actioner.VIEWSEARHALETTER);
                if (dictionaryManagement.showALetter(dataSearchWord) != null){
                actioner.inactive( Actioner.VIEWSEARHALETTER );
                actioner.active( Actioner.VIEWSEARHALETTER );
                actioner.showData(dictionaryManagement.showALetter(dataSearchWord), Actioner.VIEWSEARHALETTER);
                 }

                break;

            case Actioner.VIEWALLLETTER:
                actioner.inactive( Actioner.VIEWALLLETTER );
                actioner.showData(dictionaryManagement.showAllLetters(), Actioner.VIEWALLLETTER);
                actioner.active( Actioner.VIEWALLLETTER);
                break;
        }
    }
}
