package view;

import control.Controller;

import javax.swing.*;
import java.awt.*;

public class AddEditWindow extends JPanel {

    // Instructions
    private JLabel textToAddWord;
    private JLabel textToAddMeaning;
    private JLabel textToAddTranslate;

    //Spaces to info
    private JTextField boxSaveWord;
    private JTextArea boxSaveMeaning;
    private JTextField boxSaveTranslate;

    //Buttons
    private JButton buttonSendNewWord;
    private JButton buttonSendEditWord;
    private JButton buttonBackToMenu;

    public AddEditWindow(){
        setLayout(null);

        components();
        styleComponent();
        addComponent();
    }

    private void components(){
        //Texts
        textToAddWord = new JLabel("Palabra");
        textToAddWord.setBounds(142,64,120,29);

        textToAddMeaning = new JLabel("Significado");
        textToAddMeaning.setBounds(410,64,180,29);

        textToAddTranslate = new JLabel("Traducción");
        textToAddTranslate.setBounds(142,160,180,29);

        //Boxes
        boxSaveWord = new JTextField();
        boxSaveWord.setBounds(142,104,180,25);

        boxSaveMeaning = new JTextArea();
        boxSaveMeaning.setBounds(410,104,393,198);

        boxSaveTranslate = new JTextField();
        boxSaveTranslate.setBounds(142,200,180,25);

        //Image for Buttons
        Image imageButtonSendNewWord = new ImageIcon(getClass().getResource("/imageButton7.png")).getImage();
        Image imageButtonEditWord = new ImageIcon(getClass().getResource("/imageButton8.png")).getImage();
        Image imageButtonBackToMenu = new ImageIcon(getClass().getResource("/imageButton6.png")).getImage();


        //Buttons
        buttonSendNewWord = new JButton(new ImageIcon(imageButtonSendNewWord));
        buttonSendNewWord.setBounds(890,200,207,57);

        buttonSendEditWord = new JButton(new ImageIcon(imageButtonEditWord));
        buttonSendEditWord.setBounds(890,200,207,57);

        buttonBackToMenu = new JButton(new ImageIcon(imageButtonBackToMenu));
        buttonBackToMenu.setBounds(890,100,207,57);

    }

    private void styleComponent(){
        textToAddWord.setFont(new Font("Brawler", Font.PLAIN, 15));
        textToAddWord.setForeground(Color.WHITE);

        textToAddMeaning.setFont(new Font("Brawler", Font.PLAIN, 15));
        textToAddMeaning.setForeground(Color.WHITE);

        textToAddTranslate.setFont(new Font("Brawler", Font.PLAIN, 15));
        textToAddTranslate.setForeground(Color.WHITE);

        Color c4c4c4 = new Color(196,196,196);

        buttonSendNewWord.setForeground(c4c4c4);
        buttonSendNewWord.setBackground(c4c4c4);

        buttonSendEditWord.setForeground(c4c4c4);
        buttonSendEditWord.setBackground(c4c4c4);

        buttonBackToMenu.setForeground(c4c4c4);
        buttonBackToMenu.setBackground(c4c4c4);


    }

    private void addComponent(){
        //Texts
        add(textToAddWord);
        add(textToAddMeaning);
        add(textToAddTranslate);

        //Boxes
        add(boxSaveWord);
        add(boxSaveMeaning);
        add(boxSaveTranslate);

        //Buttons
        add(buttonSendNewWord);
        add(buttonSendEditWord);
        add(buttonBackToMenu);
    }

    public void actionAddEditWindow(Controller controller){

        //SetActionCommand
        buttonSendNewWord.setActionCommand(Actioner.SENDNEWWORD);
        buttonSendEditWord.setActionCommand(Actioner.SENDEDITWORD);
        buttonBackToMenu.setActionCommand(Actioner.BACKTOMENU);

        //AddActionListener
        buttonSendNewWord.addActionListener(controller);
        buttonSendEditWord.addActionListener(controller);
        buttonBackToMenu.addActionListener(controller);
    }

    public JButton getButtonSendNewWord() {
        return buttonSendNewWord;
    }

    public JButton getButtonSendEditWord() {
        return buttonSendEditWord;
    }

    public JButton getButtonBackToMenu() {
        return buttonBackToMenu;
    }

    public JTextField getBoxSaveWord() {
        return boxSaveWord;
    }

    public JTextArea getBoxSaveMeaning() {
        return boxSaveMeaning;
    }

    public JTextField getBoxSaveTranslate() {
        return boxSaveTranslate;
    }
}
