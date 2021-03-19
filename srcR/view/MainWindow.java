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
    private ViewWindow viewWindow;



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

        viewWindow = new ViewWindow();
        viewWindow.setBackground(new Color(27,31,64));
        viewWindow.setBounds(53,130,1250,400);



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
        viewWindow.actionViweWindow(controller);


    }


    @Override
    public void active(String window) {


        if ( window.equals(Actioner.ADDWORDMENUWINDOW) ){
            cleanSpace();
            addEditWindow.setVisible(true);
            add(addEditWindow);

            //Components
            addEditWindow.getButtonSendNewWord().setVisible(true);
            addEditWindow.getBoxSaveWord().setEditable(true);
            addEditWindow.getBoxSaveMeaning().setEditable(true);
            addEditWindow.getBoxSaveTranslate().setEditable(true);
        }

        else if ( window.equals(Actioner.SEARCHWORDMENUWINDOW) ){
            searchEditWindow.setVisible(true);
            add(searchEditWindow);

            //Components
            searchEditWindow.getButtonSearchWord().setVisible(true);
        }

        else if ( window.equals(Actioner.SHOWORDMENUWINDOW) ){
            viewWindow.setVisible(true);
            add(viewWindow);

        }

        else if ( window.equals(Actioner.EDITWORDMENUWINDOW) ){

            searchEditWindow.setVisible(true);
            add(searchEditWindow);

            //Components
            searchEditWindow.getButtonSearchEditWord().setVisible(true);

        }

        else if ( window.equals(Actioner.DELETEWORDMENUWINDOW) ){
            searchEditWindow.setVisible(true);
            add(searchEditWindow);

            //Components
            searchEditWindow.getButtonSearchDeleteWord().setVisible(true);
        }

        else if ( window.equals(Actioner.SEARCHEDITWORD) ){

            addEditWindow.setVisible(true);
            add(addEditWindow);

            //Components
            addEditWindow.getButtonSendEditWord().setVisible(true);
            addEditWindow.getBoxSaveWord().setEditable(true);
            addEditWindow.getBoxSaveMeaning().setEditable(true);
            addEditWindow.getBoxSaveTranslate().setEditable(true);
        }


        //Clic en las otras ventanas
        else if ( window.equals(Actioner.SENDNEWWORD) || window.equals(Actioner.SENDEDITWORD) || window.equals(Actioner.BACKTOMENU)){
            menuWindow.setVisible(true);
            add(menuWindow);
        }

        else if ( window.equals(Actioner.VIEWALETTER) ){
            //Components
            viewWindow.getTextToSearchView().setVisible(true);
            viewWindow.getBoxSaveWordToView().setVisible(true);
            viewWindow.getButtonSearchToView().setVisible(true);
        }

        else if ( window.equals(Actioner.VIEWSEARHALETTER) ){
            viewWindow.getjScrollPaneShowLetter().setVisible(true);
            viewWindow.getjTableShowLetter().setVisible(true);
        }

        else if ( window.equals(Actioner.VIEWALLLETTER) ){
            viewWindow.getjScrollPaneShowAllLetter().setVisible(true);
            viewWindow.getjTableShowAllLetter().setVisible(true);

            add(viewWindow);
        }

        else if ( window.equals(Actioner.SEARCHWORD ) ){
            addEditWindow.setVisible(true);
            add(addEditWindow);

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

            //Components
            viewWindow.getTextToSearchView().setVisible(false);
            viewWindow.getBoxSaveWordToView().setVisible(false);
            viewWindow.getButtonSearchToView().setVisible(false);

            viewWindow.getjScrollPaneShowLetter().setVisible(false);
            viewWindow.getjTableShowLetter().setVisible(false);
            viewWindow.getjScrollPaneShowAllLetter().setVisible(false);
            viewWindow.getjTableShowAllLetter().setVisible(false);


        }

        else if ( window.equals(Actioner.EDITWORDMENUWINDOW) ){
            menuWindow.setVisible(false);
            remove(menuWindow);

            //Components
            searchEditWindow.getButtonSearchDeleteWord().setVisible(false);
            searchEditWindow.getButtonSearchWord().setVisible(false);

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

            viewWindow.setVisible(false);
            remove(searchEditWindow);
        }

        else if ( window.equals(Actioner.SEARCHEDITWORD) ){
            searchEditWindow.setVisible(false);
            remove(searchEditWindow);

            //Components
            addEditWindow.getButtonSendNewWord().setVisible(false);
            addEditWindow.getBoxSaveWord().setEditable(true);
            addEditWindow.getBoxSaveMeaning().setEditable(true);
            addEditWindow.getBoxSaveTranslate().setEditable(true);
        }

        else if ( window.equals(Actioner.VIEWALETTER ) ){

            //Components
            viewWindow.getjScrollPaneShowAllLetter().setVisible(false);
            viewWindow.getjScrollPaneShowLetter().setVisible(false);

        }

        else if ( window.equals(Actioner.VIEWSEARHALETTER) ){
            //Components
            viewWindow.getTextToSearchView().setVisible(false);
            viewWindow.getBoxSaveWordToView().setVisible(false);
            viewWindow.getButtonSearchToView().setVisible(false);

            viewWindow.getjScrollPaneShowAllLetter().setVisible(false);
            viewWindow.getjTableShowAllLetter().setVisible(false);
        }

        else if ( window.equals(Actioner.VIEWALLLETTER) ){

            //Components
            viewWindow.getTextToSearchView().setVisible(false);
            viewWindow.getBoxSaveWordToView().setVisible(false);
            viewWindow.getButtonSearchToView().setVisible(false);

            viewWindow.getjScrollPaneShowLetter().setVisible(false);
            viewWindow.getjTableShowLetter().setVisible(false);

        }

        else if ( window.equals(Actioner.SEARCHWORD ) ){
            searchEditWindow.setVisible(false);
            remove(searchEditWindow);

            //Components
            addEditWindow.getBoxSaveWord().setEditable(false);
            addEditWindow.getBoxSaveMeaning().setEditable(false);
            addEditWindow.getBoxSaveTranslate().setEditable(false);
            addEditWindow.getButtonSendEditWord().setVisible(false);
            addEditWindow.getButtonSendNewWord().setVisible(false);
        }


    }

    @Override
    public String[] captureData(String window) {

        if ( window.equals(Actioner.SENDNEWWORD ) ){
            String[] dataEntryNewWord = {
                    addEditWindow.getBoxSaveWord().getText(),
                    addEditWindow.getBoxSaveMeaning().getText(),
                    addEditWindow.getBoxSaveTranslate().getText()
            };

            cleanSpace();
            repaint();
            return dataEntryNewWord;
        }

        else if ( window.equals(Actioner.SENDEDITWORD ) ){
            String[] dataEntryEditWord = {
                    addEditWindow.getBoxSaveWord().getText(),
                    addEditWindow.getBoxSaveMeaning().getText(),
                    addEditWindow.getBoxSaveTranslate().getText()
            };
            cleanSpace();
            repaint();
            return dataEntryEditWord;
        }

        else if ( window.equals(Actioner.SEARCHWORD ) ){
            String[] dataEntrySearchWord = {
                    searchEditWindow.getBoxSpaceWord().getText()
            };
            cleanSpace();
            repaint();
            return dataEntrySearchWord;
        }

        else if ( window.equals(Actioner.SEARCHEDITWORD ) ){
            String[] dataEntrySearchEdit = {
              searchEditWindow.getBoxSpaceWord().getText()
            };
            cleanSpace();
            repaint();
            return dataEntrySearchEdit;
        }

        else if ( window.equals(Actioner.SEARCHDELETEWORD ) ){
            String[] dataEntrySearchDeleteWord = {
              searchEditWindow.getBoxSpaceWord().getText()
            };
            cleanSpace();
            repaint();
            return dataEntrySearchDeleteWord;
        }

        else if ( window.equals(Actioner.VIEWALETTER) ){
            String[] dataEntryViewALetter = {
              viewWindow.getBoxSaveWordToView().getText()
            };
            cleanSpace();
            repaint();
            return dataEntryViewALetter;
        }

        else if ( window.equals(Actioner.VIEWSEARHALETTER ) ){
            String[] dataEntrySearch = {
                    viewWindow.getBoxSaveWordToView().getText()
            };
            cleanSpace();
            repaint();
            return dataEntrySearch;
        }
        return null;
    }

    @Override
    public void showData(String[][] out, String window) {
        cleanTable();

        if ( window.equals(Actioner.VIEWSEARHALETTER ) ){
            for (int i = 0; i < out.length; i++){
                viewWindow.getTableModelShowLetter().addRow(out[i]);
            }
        }

        if ( window.equals(Actioner.VIEWALLLETTER ) ){
            for (int i = 0; i < out.length; i++){
                viewWindow.getTableModelSowhAllLetter().addRow(out[i]);
            }

        }

        if ( window.equals(Actioner.SEARCHWORD) ){
            addEditWindow.getBoxSaveWord().setText(out[0][0]);
            addEditWindow.getBoxSaveMeaning().setText(out[0][1]);
            addEditWindow.getBoxSaveTranslate().setText(out[0][2]);
        }

        if ( window.equals(Actioner.SEARCHEDITWORD) ){
            addEditWindow.getBoxSaveWord().setText(out[0][0]);
            addEditWindow.getBoxSaveMeaning().setText(out[0][1]);
            addEditWindow.getBoxSaveTranslate().setText(out[0][2]);
        }

    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void cleanSpace() {
        addEditWindow.getBoxSaveMeaning().setText("");
        addEditWindow.getBoxSaveWord().setText("");
        addEditWindow.getBoxSaveTranslate().setText("");

        searchEditWindow.getBoxSpaceWord().setText("");

        viewWindow.getBoxSaveWordToView().setText("");
    }

    private void cleanTable(){
        for ( int i = 0; i < viewWindow.getTableModelShowLetter().getRowCount(); i++ ){
            viewWindow.getTableModelShowLetter().removeRow(i);
            i--;
        }

        for ( int i = 0; i < viewWindow.getTableModelSowhAllLetter().getRowCount(); i++ ){
            viewWindow.getTableModelSowhAllLetter().removeRow(i);
            i--;
        }
    }


}
