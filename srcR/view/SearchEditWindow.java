package view;

import control.Controller;

import javax.swing.*;
import java.awt.*;

public class SearchEditWindow extends JPanel {

    //Instructions
    private JLabel textToWord;

    //Spaces to info
    private JTextField boxSpaceWord;

    //Buttons
    private JButton buttonSearchWord;
    private JButton buttonSearchEditWord;
    private JButton buttonSearchDeleteWord;
    private JButton buttonBackToMenu;

    public SearchEditWindow(){
        setLayout(null);

        components();
        styleComponent();
        addComponent();
    }

    private void components() {
        //Texts
        textToWord = new JLabel("Digite la palabra");
        textToWord.setBounds(540,140,120,29);

        //Boxes
        boxSpaceWord = new JTextField();
        boxSpaceWord.setBounds(540,180,180,25);

        //Image for Buttons
        Image imageButtonSearchWord = new ImageIcon(getClass().getResource("/imageButton9.png")).getImage();
        Image imageButtonSearchEditWord = new ImageIcon(getClass().getResource("/imageButton8.png")).getImage();
        Image imageButtonSearchDeleteWord = new ImageIcon(getClass().getResource("/imageButton10.png")).getImage();
        Image imageButtonBackToMenu = new ImageIcon(getClass().getResource("/imageButton6.png")).getImage();

        //Buttons
        buttonSearchWord = new JButton(new ImageIcon(imageButtonSearchWord));
        buttonSearchWord.setBounds(420,270,207,57);

        buttonSearchEditWord = new JButton(new ImageIcon(imageButtonSearchEditWord));
        buttonSearchEditWord.setBounds(420,270,207,57);

        buttonSearchDeleteWord = new JButton(new ImageIcon(imageButtonSearchDeleteWord));
        buttonSearchDeleteWord.setBounds(420,270,207,57);

        buttonBackToMenu = new JButton(new ImageIcon(imageButtonBackToMenu));
        buttonBackToMenu.setBounds(650,270,207,57);


    }

    private void styleComponent() {
        textToWord.setFont(new Font("Brawler", Font.PLAIN, 15));
        textToWord.setForeground(Color.WHITE);

        Color c4c4c4 = new Color(196,196,196);

        buttonSearchWord.setForeground(c4c4c4);
        buttonSearchWord.setBackground(c4c4c4);

        buttonSearchEditWord.setForeground(c4c4c4);
        buttonSearchEditWord.setBackground(c4c4c4);

        buttonSearchDeleteWord.setForeground(c4c4c4);
        buttonSearchDeleteWord.setBackground(c4c4c4);

        buttonBackToMenu.setForeground(c4c4c4);
        buttonBackToMenu.setBackground(c4c4c4);

    }

    private void addComponent() {
        //Texts
        add(textToWord);

        //Boxes
        add(boxSpaceWord);

        //Buttons
        add(buttonSearchWord);
        add(buttonSearchEditWord);
        add(buttonSearchDeleteWord);
        add(buttonBackToMenu);

    }

    public void actionSearchEditWindow(Controller controller){

        //SetActionCommand
        buttonSearchWord.setActionCommand(Actioner.SEARCHWORD);
        buttonSearchEditWord.setActionCommand(Actioner.SEARCHEDITWORD);
        buttonSearchDeleteWord.setActionCommand(Actioner.SEARCHDELETEWORD);
        buttonBackToMenu.setActionCommand(Actioner.BACKTOMENU);

        //AddActionListener
        buttonSearchWord.addActionListener(controller);
        buttonSearchEditWord.addActionListener(controller);
        buttonSearchDeleteWord.addActionListener(controller);
        buttonBackToMenu.addActionListener(controller);

    }

    public JTextField getBoxSpaceWord() {
        return boxSpaceWord;
    }

    public JButton getButtonSearchWord() {
        return buttonSearchWord;
    }

    public JButton getButtonSearchEditWord() {
        return buttonSearchEditWord;
    }

    public JButton getButtonSearchDeleteWord() {
        return buttonSearchDeleteWord;
    }

    public JButton getButtonBackToMenu() {
        return buttonBackToMenu;
    }
}
