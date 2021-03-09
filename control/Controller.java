package control;

import view.Actioner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Actioner actioner;




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




        }


    }
}
