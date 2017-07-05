package com.company;
import javax.swing.*;
import java.awt.event.*;

public class TelaTecnico extends Tela implements ActionListener, WindowListener {
    private JPanel pTecnicos;
    private static JButton bNovoTecnico;
    private static JButton bLogaTecnico;
    private static JButton bCancela;

    public TelaTecnico() {
        super("Selecione sua opção:");

        bNovoTecnico = new JButton("Novo Técnico");
        bLogaTecnico = new JButton("Entrar no sistema");
        bCancela = new JButton("Cancelar");

        bNovoTecnico.addActionListener(this);
        bLogaTecnico.addActionListener(this);
        bCancela.addActionListener(this);

        pTecnicos = new JPanel();
        pTecnicos.add(bNovoTecnico);
        pTecnicos.add(bLogaTecnico);
        pTecnicos.add(bCancela);

        getContentPane().add(pTecnicos);
        addWindowListener(this);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,70);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bNovoTecnico) {
            JFrame fCriaTecnico = new CriaTecnico();
            this.dispose();
        }

        else if(event.getSource() == bLogaTecnico) {
            JFrame fLoginTecnico = new LogaTecnico();
            this.checaDispose = true;
            this.dispose();
        }

        else if(event.getSource() == bCancela) {
            this.dispose();
        }
    }

    public void windowClosed(WindowEvent event) {
        this.checaDispose();
    }

    public void windowDeiconified(WindowEvent event) {}
    public void windowOpened(WindowEvent event) {}
    public void windowClosing(WindowEvent event) {}
    public void windowDeactivated(WindowEvent event) {}
    public void windowIconified(WindowEvent event) {}
    public void windowActivated(WindowEvent event) {}
}
