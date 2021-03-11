package control;

import view.Actioner;
import view.AddEditWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Actioner actioner;

    //Class
    private AddEditWindow addEditWindow;


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

                //TODO Hacer validacion de la busqueda de la palabra para editar y luego si se activa
           //     if (  ){
                    actioner.inactive( Actioner.EDITWORDMENUWINDOW );
                    actioner.active( Actioner.EDITWORDMENUWINDOW );
           //     }

                break;

            case Actioner.DELETEWORDMENUWINDOW:
                actioner.inactive( Actioner.DELETEWORDMENUWINDOW );
                actioner.active( Actioner.DELETEWORDMENUWINDOW );
                break;







            case Actioner.SENDNEWWORD:
                String[] captureDataSendWord = actioner.captureData(Actioner.SENDNEWWORD);
                //TODO Dentro del parentesis, va el mensaje que retorna al agregar una nueva letra
                // actioner.showMessage();

                actioner.inactive( Actioner.SENDNEWWORD );
                actioner.active( Actioner.SENDNEWWORD );
                break;

            case Actioner.SENDEDITWORD:
                captureDataSendWord = actioner.captureData(Actioner.SENDEDITWORD);

                actioner.inactive( Actioner.SENDEDITWORD );
                actioner.active( Actioner.SENDEDITWORD );
                break;

            case Actioner.BACKTOMENU:
                actioner.inactive( Actioner.BACKTOMENU );
                actioner.active( Actioner.BACKTOMENU );

                break;





        }


    }
}
