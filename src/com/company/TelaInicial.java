package com.company;
import javax.swing.*;
import java.awt.event.*;

public class TelaInicial extends JFrame implements ActionListener {
    private JPanel pInicial;
    final private JLabel lDescription;
    private static JButton bTecnicos = new JButton("Técnicos");
    private static JButton bClientes = new JButton("Clientes");

    public TelaInicial() {
        super("Bem-vindo ao sistema FazConsertos v1.0!");

        lDescription = new JLabel("Selecione a opção desejada:");

        bTecnicos.addActionListener(this);
        bClientes.addActionListener(this);

        pInicial = new JPanel();
        pInicial.add(lDescription);
        pInicial.add(bTecnicos);
        pInicial.add(bClientes);

        getContentPane().add(pInicial);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,70);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bTecnicos) {
            JFrame fTecnico;
            fTecnico = new TelaTecnico();

            setBotaoTecnicos(false);
        }

        else if(event.getSource() == bClientes) {
            JFrame fClientes;
            fClientes = new TelaCliente();

            setBotaoClientes(false);
        }
    }

    public static void setBotaoTecnicos(boolean state) {
        bTecnicos.setEnabled(state);
        bTecnicos.setBorderPainted(state);
    }

    public static void setBotaoClientes(boolean state) {
        bClientes.setEnabled(state);
        bClientes.setBorderPainted(state);
    }

}