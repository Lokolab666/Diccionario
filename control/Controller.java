package control;

import view.Actioner;
import view.AddEditWindow;
import view.ViewWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Actioner actioner;

    //Class
    private AddEditWindow addEditWindow;
    private ViewWindow viewWindow;


    public Controller( Actioner actioner ){
        this.actioner = actioner;


    }

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
                //TODO Dentro del parentesis, va el mensaje que retorna al agregar una nueva letra
                // actioner.showMessage();

                actioner.inactive( Actioner.SENDNEWWORD );
                actioner.active( Actioner.SENDNEWWORD );
                break;

            case Actioner.SENDEDITWORD:
                String[] captureDataSendEdit = actioner.captureData(Actioner.SENDEDITWORD);
               //TODO Capturar los datos y mostrar mensaje
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
                actioner.inactive( Actioner.SEARCHWORD );
                actioner.active( Actioner.SEARCHWORD );

                break;


            case Actioner.SEARCHEDITWORD:
                //TODO captureDataSendWord = actioner.captureData(Actioner.SENDEDITWORD);
                // if (la palabra existe, mostrar solo el arbol de esa palabra){
                actioner.inactive( Actioner.SEARCHEDITWORD );
                actioner.active( Actioner.SEARCHEDITWORD );
                // }
                break;



            case Actioner.SEARCHDELETEWORD:
                String[] captureDataSearchWWord = actioner.captureData(Actioner.SEARCHDELETEWORD);
                actioner.inactive( Actioner.SEARCHDELETEWORD );
                actioner.active( Actioner.SEARCHDELETEWORD );

                // actioner.showMessage();

                break;

            //WINDOW VIEW

            case Actioner.VIEWALETTER:
                actioner.inactive( Actioner.VIEWALETTER );
                actioner.active( Actioner.VIEWALETTER );

                break;

            case Actioner.VIEWSEARHALETTER:
                captureDataSendWord = actioner.captureData(Actioner.SENDEDITWORD);
                // if (la palabra existe){
                actioner.inactive( Actioner.VIEWSEARHALETTER );
                actioner.active( Actioner.VIEWSEARHALETTER );
                //actioner.showData(class, Actioner.VIEWSEARCHALETTER);
                // }

                break;

            case Actioner.VIEWALLLETTER:
                actioner.inactive( Actioner.VIEWALLLETTER );
                //TODO actioner.showData(clase, Actioner.VIEWALLLETTER);
                actioner.active( Actioner.VIEWALLLETTER);

                break;

        }


    }
}
