package view;

import control.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que contiene los botones para que el usuario seleccione su opcion de preferencia
 */
public class MenuWindow extends JPanel{

    //Texts
    private JLabel textWelcome;

    private JLabel firstSpace;
    private JLabel secondSpace;

    //Button
    private JButton buttonAddWord;
    private JButton buttonSearchWord;
    private JButton buttonShowWord;
    private JButton buttonEditWord;
    private JButton buttonDeleteWord;



    public MenuWindow(){
        setLayout(new GridLayout(3,3));

        components();
        styleComponents();
        addComponent();
    }

    private void components() {
        //Text
        String textHtmlWelcome = "<html><body>Bienvenido a Tu Diccionario<br>Por favor, seleccione una opción de preferencia<br></body></html>";
        textWelcome = new JLabel(textHtmlWelcome);

        firstSpace = new JLabel("");
        secondSpace = new JLabel("");

        //Image for buttons
        Image addButtonAddImage = new ImageIcon(getClass().getResource("/imageButton1.png")).getImage();
        Image addButtonSearchImage = new ImageIcon(getClass().getResource("/imageButton2.png")).getImage();
        Image addButtonShowImage = new ImageIcon(getClass().getResource("/imageButton3.png")).getImage();
        Image addButtonEditImage = new ImageIcon(getClass().getResource("/imageButton4.png")).getImage();
        Image addButtonDeleteImage = new ImageIcon(getClass().getResource("/imageButton5.png")).getImage();

        //Buttons
        buttonAddWord = new JButton(new ImageIcon(addButtonAddImage));
        buttonSearchWord = new JButton(new ImageIcon(addButtonSearchImage));
        buttonShowWord = new JButton(new ImageIcon(addButtonShowImage));
        buttonEditWord = new JButton(new ImageIcon(addButtonEditImage));
        buttonDeleteWord = new JButton(new ImageIcon(addButtonDeleteImage));

    }

    private void styleComponents() {
        //Text
        textWelcome.setFont(new Font("Brawler", Font.PLAIN, 24));
        textWelcome.setForeground(Color.WHITE);

        firstSpace.setFont(new Font("Brawler", Font.PLAIN, 24));
        firstSpace.setForeground(Color.WHITE);

        //Button
        Color c4c4c4 = new Color(196,196,196);

        buttonAddWord.setForeground(c4c4c4);
        buttonAddWord.setBackground(c4c4c4);

        buttonSearchWord.setForeground(c4c4c4);
        buttonSearchWord.setBackground(c4c4c4);

        buttonShowWord.setForeground(c4c4c4);
        buttonShowWord.setBackground(c4c4c4);

        buttonEditWord.setForeground(c4c4c4);
        buttonEditWord.setBackground(c4c4c4);

        buttonDeleteWord.setForeground(c4c4c4);
        buttonDeleteWord.setBackground(c4c4c4);

    }

    private void addComponent() {
        //Text
        add(textWelcome);

        add(firstSpace);
        add(secondSpace);

        //Button
        add(buttonAddWord);
        add(buttonSearchWord);
        add(buttonShowWord);
        add(buttonEditWord);
        add(buttonDeleteWord);
    }

    public void actionMenuWindow(Controller controller){
        //SetActionCommands
        buttonAddWord.setActionCommand(Actioner.ADDWORDMENUWINDOW);
        buttonSearchWord.setActionCommand(Actioner.SEARCHWORDMENUWINDOW);
        buttonShowWord.setActionCommand(Actioner.SHOWORDMENUWINDOW);
        buttonEditWord.setActionCommand(Actioner.EDITWORDMENUWINDOW);
        buttonDeleteWord.setActionCommand(Actioner.DELETEWORDMENUWINDOW);

        //AddActionListener
        buttonAddWord.addActionListener(controller);
        buttonSearchWord.addActionListener(controller);
        buttonShowWord.addActionListener(controller);
        buttonEditWord.addActionListener(controller);
        buttonDeleteWord.addActionListener(controller);
    }

    public JButton getButtonSearchWord() {
        return buttonSearchWord;
    }

    public JButton getButtonShowWord() {
        return buttonShowWord;
    }

    public JButton getButtonEditWord() {
        return buttonEditWord;
    }

    public JButton getButtonDeleteWord() {
        return buttonDeleteWord;
    }
}
