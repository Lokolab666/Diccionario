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


    }
}
