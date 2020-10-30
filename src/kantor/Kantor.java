package kantor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kantor extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menuOprogramie, menuPomoc;
    JMenuItem mOprogramie, mAutor, mWyjscie, mPomoc;
    JLabel lOpis, lPierwsza, lDruga, lIloscP, lIloscO, imgLabel;
    JComboBox wPierwsza, wDruga;
    JButton button;
    JTextField walutaP, walutaO;
    double wejscie=0, wyjscie=0;
    String rezulat;


    public Kantor() {
        setTitle("Baza Pracownikow");                        //Elementy okna glownego
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        menuBar = new JMenuBar();                                  //Definiowanie Menu
        menuOprogramie = new JMenu("O Programie");
        menuPomoc = new JMenu("Pomoc");

        mOprogramie = new JMenuItem("O programie");         //Definiowanie podMenu
        mAutor = new JMenuItem("Autor");
        mWyjscie = new JMenuItem("Wyjdź");
        mPomoc = new JMenuItem("Pomoc");


        setJMenuBar(menuBar);                                   //Dodawanie elementow do menu
        menuBar.add(menuOprogramie);
        menuBar.add(menuPomoc);

        menuOprogramie.add(mOprogramie);                            //Dodawanie subelementow do Menu
        menuOprogramie.add(mAutor);
        menuOprogramie.addSeparator();
        menuOprogramie.add(mWyjscie);
        menuPomoc.add(mPomoc);

        lOpis = new JLabel("Przelicznik walut");
        lOpis.setBounds(170, 50, 150, 20);
        lOpis.setFont(new Font("SansSerif",Font.HANGING_BASELINE, 20));
        lOpis.setForeground(Color.red);
        add(lOpis);

        lPierwsza = new JLabel("Posiadana Waluta");
        lPierwsza.setBounds(75, 80, 150, 30);
        add(lPierwsza);

        lDruga = new JLabel("Chciana waluta");
        lDruga.setBounds(300, 80, 150, 30);
        add(lDruga);

        wPierwsza = new JComboBox();
        wPierwsza.setBounds(55, 110, 150, 30);
        wPierwsza.addItem("PLN");
        wPierwsza.addItem("EUR");
        wPierwsza.addItem("USD");
        add(wPierwsza);

        wDruga = new JComboBox();
        wDruga.setBounds(280, 110, 150, 30);
        wDruga.addItem("PLN");
        wDruga.addItem("EUR");
        wDruga.addItem("USD");
        add(wDruga);

        lIloscP = new JLabel("Ilosc posiadanej waluty: ");
        lIloscP.setBounds(160, 150, 150, 30);
        add(lIloscP);

        walutaP = new JTextField();
        walutaP.setBounds(160, 175, 150, 30);
        add(walutaP);

        button = new JButton("Sprawdz:");
        button.setBounds(170, 230, 120, 30);
        add(button);

        lIloscO = new JLabel("Ilosc otrzymanej waluty:");
        lIloscO.setBounds(160, 275, 150, 30);
        add(lIloscO);

        walutaO = new JTextField();
        walutaO.setBounds(160, 300, 150, 30);
        walutaO.setBackground(Color.lightGray);
        walutaO.setFont(new Font("SansSerif",Font.BOLD,16));
        add(walutaO);

        imgLabel = new JLabel(new ImageIcon("C:\\Users\\kacpe\\Documents\\NetBeansProjects\\Kantor\\logo.jpg"));
        imgLabel.setBounds(100, 335, 300, 100);
        add(imgLabel);

        mWyjscie.addActionListener(this);
        mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        mOprogramie.addActionListener(this);
        mAutor.addActionListener(this);
        mPomoc.addActionListener(this);
        wPierwsza.addActionListener(this);
        wDruga.addActionListener(this);
        button.addActionListener(this);
        walutaP.addActionListener(this);
        walutaO.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {      //Obsluga zdzarzen
        Object zdarzenie = e.getSource();



        if (zdarzenie == mWyjscie) {
            dispose();
        } else if (zdarzenie == mOprogramie) {
            JOptionPane.showMessageDialog(this, "Kantor - przelicznik walut", "Informacje o programie", JOptionPane.INFORMATION_MESSAGE);
        } else if (zdarzenie == mAutor) {
            JOptionPane.showMessageDialog(this, "Autor: Kacper Haduch \n Szkoła: WSIZ we Wroclawiu", "O Autorze", JOptionPane.INFORMATION_MESSAGE);
        } else if (zdarzenie == mPomoc) {
            JOptionPane.showMessageDialog(this, "Program okienkowy - zaliczenie nr2 JAVA", "Wyjasnienie", JOptionPane.WARNING_MESSAGE);
        }

        if (zdarzenie == button) {
            wejscie =Double.parseDouble(walutaP.getText());
            if (wPierwsza.getSelectedItem() == "USD") {
                KonwertujDollary();
            } else if (wPierwsza.getSelectedItem() == "PLN") {
                KonwertujZlote();
            } else
                KonwertujEuro();
        }
    }

    public static void main(String[] args) {
        Kantor kantor = new Kantor();
        kantor.setVisible(true);
    }

    public void KonwertujDollary(){
        if(wDruga.getSelectedItem()=="USD") {
            wyjscie = (wejscie);
            rezulat = String.format("%.2f",wyjscie);
            walutaO.setText("" + rezulat);
        }
        else if(wDruga.getSelectedItem()=="PLN"){
            wyjscie=(wejscie*3.78);
            rezulat = String.format("%.2f",wyjscie);
            walutaO.setText(""+rezulat);
        }
        else{
            wyjscie=(wejscie*0.89);
            rezulat = String.format("%.2f",wyjscie);
            walutaO.setText(""+rezulat);
        }
    }

    public void KonwertujEuro(){
        if(wDruga.getSelectedItem()=="EUR"){
            wyjscie=(wejscie);
            rezulat = String.format("%.2f",wyjscie);
            walutaO.setText(""+rezulat);
        }
        else if(wDruga.getSelectedItem()=="PLN"){
            wyjscie=(wejscie*4.22);
            rezulat = String.format("%.2f",wyjscie);
            walutaO.setText(""+rezulat);
        }
        else{
            wyjscie=(wejscie*1.11);
            rezulat = String.format("%.2f",wyjscie);
            walutaO.setText(""+rezulat);
        }
    }

    public void KonwertujZlote(){
        if(wDruga.getSelectedItem()=="PLN"){
            wyjscie=(wejscie);
            rezulat = String.format("%.2f",wyjscie);
            walutaO.setText(""+rezulat);
        }
        else if(wDruga.getSelectedItem()=="EUR"){
            wyjscie=(wejscie*0.23);
            rezulat = String.format("%.2f",wyjscie);
            walutaO.setText(""+rezulat);
        }
        else{
            wyjscie=(wejscie*0.26);
            rezulat = String.format("%.2f",wyjscie);
            walutaO.setText(""+rezulat);
        }
    }
}

