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
    private SearchEditWindow searchEditWindow;



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

        searchEditWindow = new SearchEditWindow();
        searchEditWindow.setBackground(new Color( 27,31,64 ));
        searchEditWindow.setBounds(53,130,1250,400);



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
        searchEditWindow.actionSearchEditWindow(controller);


    }


    @Override
    public void active(String window) {

        if ( window.equals(Actioner.ADDWORDMENUWINDOW) ){
            //TODO Agregar la ventana para agregar y editar palabra (es la misma mompi)
            addEditWindow.setVisible(true);
            add(addEditWindow);

            //Components
            addEditWindow.getButtonSendNewWord().setVisible(true);
        }

        else if ( window.equals(Actioner.SEARCHWORDMENUWINDOW) ){
            searchEditWindow.setVisible(true);
            add(searchEditWindow);

            //Components
            searchEditWindow.getButtonSearchWord().setVisible(true);
        }

        else if ( window.equals(Actioner.SHOWORDMENUWINDOW) ){

        }

        else if ( window.equals(Actioner.EDITWORDMENUWINDOW) ){
            addEditWindow.setVisible(true);
            add(addEditWindow);

            //Components
            addEditWindow.getButtonSendEditWord().setVisible(true);
        }

        else if ( window.equals(Actioner.DELETEWORDMENUWINDOW) ){
            searchEditWindow.setVisible(true);
            add(searchEditWindow);

            //Components
            searchEditWindow.getButtonSearchDeleteWord().setVisible(true);
        }


        //Clic en las otras ventanas
        else if ( window.equals(Actioner.SENDNEWWORD) || window.equals(Actioner.SENDEDITWORD) || window.equals(Actioner.BACKTOMENU)){
            menuWindow.setVisible(true);
            add(menuWindow);
        }
    }

    @Override
    public void inactive(String window) {

        if ( window.equals(Actioner.ADDWORDMENUWINDOW) ){
            menuWindow.setVisible(false);
            remove(menuWindow);

            //Components
            addEditWindow.getButtonSendEditWord().setVisible(false);
        }

        else if ( window.equals(Actioner.SEARCHWORDMENUWINDOW) ){
            menuWindow.setVisible(false);
            remove(menuWindow);

            //Components
            searchEditWindow.getButtonSearchEditWord().setVisible(false);
            searchEditWindow.getButtonSearchDeleteWord().setVisible(false);
        }

        else if ( window.equals(Actioner.SHOWORDMENUWINDOW) ){
            menuWindow.setVisible(false);
            remove(menuWindow);


        }

        else if ( window.equals(Actioner.EDITWORDMENUWINDOW) ){
            menuWindow.setVisible(false);
            remove(menuWindow);

            //Components
            addEditWindow.getButtonSendNewWord().setVisible(false);
        }

        else if ( window.equals(Actioner.DELETEWORDMENUWINDOW) ){
            menuWindow.setVisible(false);
            remove(menuWindow);

            //Components
            searchEditWindow.getButtonSearchEditWord().setVisible(false);
            searchEditWindow.getButtonSearchWord().setVisible(false);
        }




        else if ( window.equals(Actioner.SENDNEWWORD) || window.equals(Actioner.SENDEDITWORD) ){
            addEditWindow.setVisible(false);
            remove(addEditWindow);
        }

        else if ( window.equals(Actioner.BACKTOMENU) ){
            addEditWindow.setVisible(false);
            remove(addEditWindow);

            searchEditWindow.setVisible(false);
            remove(searchEditWindow);
        }




    }

    @Override
    public String[] captureData(String window) {

        if ( window.equals(Actioner.SENDNEWWORD) ){
            String[] dataEntryNewWord = {
                    addEditWindow.getBoxSaveWord().getText(),
                    addEditWindow.getBoxSaveMeaning().getText(),
                    addEditWindow.getBoxSaveTranslate().getText()
            };
            cleanSpace();
            repaint();
            return dataEntryNewWord;
        }

        else if ( window.equals(Actioner.SENDEDITWORD) ){
            String[] dataEntryEditWord = {
                    addEditWindow.getBoxSaveWord().getText(),
                    addEditWindow.getBoxSaveMeaning().getText(),
                    addEditWindow.getBoxSaveTranslate().getText()
            };
            cleanSpace();
            repaint();
            return dataEntryEditWord;
        }
        return new String[0];


    }

    @Override
    public void showData(String window) {

    }

    @Override
    public void showMessage(String window) {

    }

    private void cleanSpace() {
        addEditWindow.getBoxSaveMeaning().setText("");
        addEditWindow.getBoxSaveWord().setText("");
        addEditWindow.getBoxSaveTranslate().setText("");
    }
}
