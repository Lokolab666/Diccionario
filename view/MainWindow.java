package view;

import control.Controller;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements Actioner {

    //BackGround
    private JLabel header;
    private JLabel footer;

    //Texts
    private JLabel textWelcome;


    public MainWindow(){
        //Features
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setSize( 1200, 720 );
        this.setLocation( 100,100 );
        this.setExtendedState(MAXIMIZED_BOTH);
        Image iconWindow= new ImageIcon(getClass().getResource("/logoTuDiccionario.png")).getImage();
        setIconImage( iconWindow );
        this.setIconImage( iconWindow );
        this.setLayout( null );
        this.getContentPane().setBackground(new Color( 27,31,64 ));

        components();
        styleComponents();
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

        //Text
        String texto = "<html><body>Bienvenido a Tu Diccionario, el libro virtual de las definiciones<br>Por favor, seleccione una opción de preferencia<br></body></html>";
        textWelcome = new JLabel(texto);


        textWelcome.setBounds(50,130, 732,87);


    }

    public void styleComponents() {
        textWelcome.setFont(new Font("Brawler", Font.PLAIN, 24));
        textWelcome.setForeground(Color.WHITE);

    }

    public void addComponent() {
        add(textWelcome);
        add(header);
        add(footer);

    }


    public void initialMenu( Controller controller ){
        setVisible(true);


    }


    @Override
    public void active(String window) {

    }

    @Override
    public void inactive(String window) {

    }
}
