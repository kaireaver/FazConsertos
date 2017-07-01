package com.company;
import javax.swing.*;

public class TelaInicial extends JFrame {
    private JPanel pInicial;
    final private JLabel lDescription;
    private JButton bTecnicos;
    private JButton bClientes;

    public TelaInicial() {
        super("Bem-vindo ao sistema FazConsertos v1.0!");

        lDescription = new JLabel("Selecione a opção desejada:");
        bTecnicos = new JButton("Técnicos");
        bClientes = new JButton("Clientes");
        pInicial = new JPanel();

        pInicial.add(lDescription);
        pInicial.add(bTecnicos);
        pInicial.add(bClientes);

        getContentPane().add(pInicial);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}