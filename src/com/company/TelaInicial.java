package com.company;
import javax.swing.*;
import java.awt.event.*;

public class TelaInicial extends JFrame implements ActionListener {
    private JPanel pInicial;
    final private JLabel lDescription;
    private static JButton bTecnicos;
    private static JButton bClientes;

    public TelaInicial() {
        super("Bem-vindo ao sistema FazConsertos v1.0!");

        lDescription = new JLabel("Selecione a opção desejada:");

        bTecnicos = new JButton("Técnicos");
        bClientes = new JButton("Clientes");

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
            JFrame fTecnico = new TelaTecnico();
            setBotaoTecnicos(false);
            setBotaoClientes(false);
        }

        else if(event.getSource() == bClientes) {
            JFrame fClientes = new TelaCliente();
            setBotaoTecnicos(false);
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