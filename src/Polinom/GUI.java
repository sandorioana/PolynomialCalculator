package Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JFrame {
    public GUI(){
        setSize(750, 360);
        setLocation(new Point(100, 200));
        initComponent();
        initEvent();
    }

    private void initComponent(){
        getContentPane().setLayout(null);

        polinom1.setBounds(260, 40, 240, 40);
        getContentPane().add(polinom1);
        polinom2.setBounds(260, 180, 240, 40);
        getContentPane().add(polinom2);
        rezultat.setBounds(160, 260, 461, 40);
        getContentPane().add(rezultat);
        textPol1.setBounds(290, 10, 400, 25);
        getContentPane().add(textPol1);
        textPol2.setBounds(290, 150, 400, 25);
        getContentPane().add(textPol2);
        textRez.setBounds(320, 230, 200, 25);
        getContentPane().add(textRez);
        butonAdunare.setBounds(110, 100, 70, 40);
        getContentPane().add(butonAdunare);
        butonScadere.setBounds(230, 100, 70, 40);
        getContentPane().add(butonScadere);
        butonInmultire.setBounds(340, 100, 70, 40);
        getContentPane().add(butonInmultire);
        butonDerivare.setBounds(450,100,80,40);
        getContentPane().add(butonDerivare);
        butonIntegrare.setBounds(560,100,70,40);
        getContentPane().add(butonIntegrare);

    }

    private void initEvent() {

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

        butonAdunare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polinom f1 = new Polinom();
                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();
                pol1 = f1.formaPolinom(polinom1.getText());
                pol2 = f1.formaPolinom(polinom2.getText());
                rezultat.setText(pol1.adunare(pol2).afisare());
            }
        });
        butonScadere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polinom f1 = new Polinom();
                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();
                pol1 = f1.formaPolinom(polinom1.getText());
                pol2 = f1.formaPolinom(polinom2.getText());
                rezultat.setText(pol1.scadere(pol2).afisare());
            }
        });
        butonInmultire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polinom f1 = new Polinom();
                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();
                pol1 = f1.formaPolinom(polinom1.getText());
                pol2 = f1.formaPolinom(polinom2.getText());
                rezultat.setText(pol1.inmultire(pol2).afisare());
            }
        });
        butonDerivare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom f1 = new Polinom();
                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();
                pol1 = f1.formaPolinom(polinom1.getText());
                rezultat.setText(pol2.derivare(pol1).afisare());
            }
        });
        butonIntegrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom f1 = new Polinom();
                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();
                pol1 = f1.formaPolinom(polinom1.getText());
                rezultat.setText(pol2.integrare(pol1).afisare());
            }
        });
    }

    private JTextField polinom1 = new JTextField(15);
    private JTextField polinom2 = new JTextField(15);
    private JTextField rezultat = new JTextField(47);
    private JLabel textRez = new JLabel ("REZULTATUL OPERATIEI");
    private JLabel textPol2 = new JLabel ("INTRODUCETI AL 2-LEA POLINOM");
    private JLabel textPol1 = new JLabel ("INTRODUCETI PRIMUL POLINOM");
    private JButton butonAdunare = new JButton("+");
    private JButton butonScadere = new JButton("-");
    private JButton butonInmultire = new JButton("*");
    private JButton butonDerivare = new JButton("'");
    private JButton butonIntegrare = new JButton("I");
}
