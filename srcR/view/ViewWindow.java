package view;

import control.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewWindow extends JPanel {

    //Text
    private JLabel textToInfo;

    private JLabel textToSearchView;

    //Spaces to info
    private JTextField boxSaveWordToView;


    //Button
    private JButton buttonShowLetter;
    private JButton buttonShowAllLetters;
    private JButton buttonBackToMenu;

    private JButton buttonSearchToView;

    //For Show a Letter
    private JScrollPane jScrollPaneShowLetter;
    private DefaultTableModel tableModelShowLetter;
    private JTable jTableShowLetter;

    //For Show all Letter
    private JScrollPane jScrollPaneShowAllLetter;
    private DefaultTableModel tableModelSowhAllLetter;
    private JTable jTableShowAllLetter;

    public ViewWindow(){
        setLayout(null);

        components();
        styleComponent();
        addComponent();

    }

    private void components() {
        //Text
        textToInfo = new JLabel("Seleccione la opción de preferencia");
        textToInfo.setBounds(115,40,290,29);

        textToSearchView = new JLabel("Escriba la letra que desea listar las palabras");
        textToSearchView.setBounds(610,90,299,29);

        //Spaces to info
        boxSaveWordToView = new JTextField();
        boxSaveWordToView.setBounds(657,150,180,29);

        //Image for Buttons
        Image imageButtonShowLetter = new ImageIcon(getClass().getResource("/imageButton11.png")).getImage();
        Image imageButtonShowAllLetter = new ImageIcon(getClass().getResource("/imageButton12.png")).getImage();
        Image imageButtonBackToMenu = new ImageIcon(getClass().getResource("/imageButton6.png")).getImage();
        Image imageButtonSearchToView = new ImageIcon(getClass().getResource("/imageButton13.png")).getImage();

        //Buttons
        buttonShowLetter = new JButton(new ImageIcon(imageButtonShowLetter));
        buttonShowLetter.setBounds(115,70,207,57);

        buttonShowAllLetters = new JButton(new ImageIcon(imageButtonShowAllLetter));
        buttonShowAllLetters.setBounds(115,167,207,57);

        buttonBackToMenu = new JButton(new ImageIcon(imageButtonBackToMenu));
        buttonBackToMenu.setBounds(115,264,207,57);

        buttonSearchToView = new JButton(new ImageIcon(imageButtonSearchToView));
        buttonSearchToView.setBounds(654,230,207,57);

        //TABLE
        String[] dataTableLetter = {"Letter", "Word", "Translate"};

        //Table Columns
        tableModelShowLetter = new DefaultTableModel();
        tableModelShowLetter.setColumnIdentifiers(dataTableLetter);

        tableModelSowhAllLetter = new DefaultTableModel();
        tableModelSowhAllLetter.setColumnIdentifiers(dataTableLetter);

        //JTable
        jTableShowLetter = new JTable(tableModelShowLetter);
        jTableShowLetter.setRowSelectionAllowed(true);

        jTableShowAllLetter = new JTable(tableModelSowhAllLetter);
        jTableShowAllLetter.setRowSelectionAllowed(true);

        //JScrollPane
        jScrollPaneShowLetter = new JScrollPane(jTableShowLetter);
        jScrollPaneShowLetter.setBounds(450,70,720,200);

        jScrollPaneShowAllLetter = new JScrollPane(jTableShowAllLetter);
        jScrollPaneShowAllLetter.setBounds(450, 70,720,200);


    }

    private void styleComponent() {
        //Text
        textToInfo.setFont(new Font("Brawler", Font.PLAIN, 15));
        textToInfo.setForeground(Color.WHITE);

        textToSearchView.setFont(new Font("Brawler", Font.PLAIN, 15));
        textToSearchView.setForeground(Color.WHITE);


        //Button
        Color c4c4c4 = new Color(196,196,196);

        buttonShowLetter.setForeground(c4c4c4);
        buttonShowLetter.setBackground(c4c4c4);

        buttonShowAllLetters.setForeground(c4c4c4);
        buttonShowAllLetters.setBackground(c4c4c4);

        buttonBackToMenu.setForeground(c4c4c4);
        buttonBackToMenu.setBackground(c4c4c4);

        buttonSearchToView.setForeground(c4c4c4);
        buttonSearchToView.setBackground(c4c4c4);

    }

    private void addComponent() {
        add(jScrollPaneShowLetter);
        add(jScrollPaneShowAllLetter);

        add(textToInfo);
        add(textToSearchView);

        add(boxSaveWordToView);

        add(buttonShowLetter);
        add(buttonShowAllLetters);
        add(buttonBackToMenu);
        add(buttonSearchToView);

    }

    public void actionViweWindow(Controller controller){
        //SetActionCommand
        buttonShowLetter.setActionCommand(Actioner.VIEWALETTER);
        buttonShowAllLetters.setActionCommand(Actioner.VIEWALLLETTER);
        buttonBackToMenu.setActionCommand(Actioner.BACKTOMENU);
        buttonSearchToView.setActionCommand(Actioner.VIEWSEARHALETTER);

        //AddActionCommand
        buttonShowLetter.addActionListener(controller);
        buttonShowAllLetters.addActionListener(controller);
        buttonBackToMenu.addActionListener(controller);
        buttonSearchToView.addActionListener(controller);

    }

    public JButton getButtonShowLetter() {
        return buttonShowLetter;
    }

    public JButton getButtonShowAllLetters() {
        return buttonShowAllLetters;
    }

    public JScrollPane getjScrollPaneShowLetter() {
        return jScrollPaneShowLetter;
    }

    public DefaultTableModel getTableModelShowLetter() {
        return tableModelShowLetter;
    }

    public JTable getjTableShowLetter() {
        return jTableShowLetter;
    }

    public JScrollPane getjScrollPaneShowAllLetter() {
        return jScrollPaneShowAllLetter;
    }

    public DefaultTableModel getTableModelSowhAllLetter() {
        return tableModelSowhAllLetter;
    }

    public JTable getjTableShowAllLetter() {
        return jTableShowAllLetter;
    }

    public JLabel getTextToSearchView() {
        return textToSearchView;
    }

    public JTextField getBoxSaveWordToView() {
        return boxSaveWordToView;
    }

    public JButton getButtonSearchToView() {
        return buttonSearchToView;
    }
}
