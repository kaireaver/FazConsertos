package com.company;
import javax.swing.*;
import java.awt.event.*;

public class TelaTecnico extends JFrame implements ActionListener, WindowListener {
    private JPanel pTecnicos;
    private static JButton bNovoTecnico;
    private static JButton bLogaTecnico;

    public TelaTecnico() {
        super("Selecione sua opção:");

        bNovoTecnico = new JButton("Criar técnico");
        bLogaTecnico = new JButton("Entrar no sistema");

        bNovoTecnico.addActionListener(this);
        bLogaTecnico.addActionListener(this);

        pTecnicos = new JPanel();
        pTecnicos.add(bNovoTecnico);
        pTecnicos.add(bLogaTecnico);

        getContentPane().add(pTecnicos);
        addWindowListener(this);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,70);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bNovoTecnico) {
            // IMPLEMENTAR!!
        }

        else if(event.getSource() == bLogaTecnico) {
            JFrame fLoginTecnico = new LogaTecnico();
            this.dispose();
        }
    }

    public void windowClosed(WindowEvent event) {
        TelaInicial.setBotaoTecnicos(true);
    }

    public void windowDeiconified(WindowEvent event) {}
    public void windowOpened(WindowEvent event) {}
    public void windowClosing(WindowEvent event) {}
    public void windowDeactivated(WindowEvent event) {}
    public void windowIconified(WindowEvent event) {}
    public void windowActivated(WindowEvent event) {}
}
