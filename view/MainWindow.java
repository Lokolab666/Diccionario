package view;

import control.Controller;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements Actioner {

    //BackGround
    private JLabel header;
    private JLabel footer;

    //Class
    private MenuWindow menuWindow;
    private AddEditWindow addEditWindow;




    public MainWindow(){
        //Features
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setSize( 1200, 720 );
        this.setLocation( 100,100 );
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Tu Diccionario");
        Image iconWindow= new ImageIcon(getClass().getResource("/logoTuDiccionario.png")).getImage();
        setIconImage( iconWindow );
        this.setIconImage( iconWindow );
        this.setLayout( null );
        this.getContentPane().setBackground(new Color( 27,31,64 ));

        components();
        addComponent();

    }




    public void components() {
        //Header
        header = new JLabel("");
        Image bannerHead = new ImageIcon(getClass().getResource("/head.png")).getImage();
        header.setIcon(new ImageIcon(bannerHead));
        header.setBounds(0,0,1400,150);

        //Footer
        footer = new JLabel("");
        Image bannerFoot = new ImageIcon(getClass().getResource("/foot.png")).getImage();
        footer.setIcon(new ImageIcon(bannerFoot));
        footer.setBounds(0,595,1400,110);

        //Class
        menuWindow = new MenuWindow();
        menuWindow.setBackground(new Color( 27,31,64 ));
        menuWindow.setBounds(53,130,1200,400);

        addEditWindow = new AddEditWindow();
        addEditWindow.setBackground(new Color( 27,31,64 ));
        addEditWindow.setBounds(53,130,1250,400);


    }



    public void addComponent() {
        add(menuWindow);
        add(header);
        add(footer);

    }


    public void initialMenu( Controller controller ){
        setVisible(true);

        menuWindow.actionMenuWindow(controller);
        addEditWindow.actionAddEditWindow(controller);


    }


    @Override
    public void active(String window) {

        if ( window.equals(Actioner.ADDWORDMENUWINDOW) ){
            //TODO Agregar la ventana para agregar y editar palabra (es la misma mompi)
            addEditWindow.setVisible(true);
            add(addEditWindow);
        }

        else if ( window.equals(Actioner.SEARCHWORDMENUWINDOW) ){

        }
    }

    @Override
    public void inactive(String window) {

        if ( window.equals(Actioner.ADDWORDMENUWINDOW) ){
            menuWindow.setVisible(false);
            remove(menuWindow);
        }

        else if ( window.equals(Actioner.SEARCHWORDMENUWINDOW) ){
            addEditWindow.setVisible(false);
            remove(addEditWindow);
        }
    }

    @Override
    public String[] captureData(String window) {
        return new String[0];
    }

    @Override
    public void showData(String window) {

    }

    @Override
    public void showMessage(String window) {

    }
}
