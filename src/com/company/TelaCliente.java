package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCliente extends JFrame {

    private Container fClientes;
    private JPanel pClientes;
    final private JLabel lNome;
    final private JLabel lCPF;
    final private JLabel lTelefone;
    final private JButton bOk;
    final private JButton bCancel;
    private JTextField tNome;
    private JTextField tCPF;
    private JTextField tTelefone;
    Box boNome;
    Box boCPF;
    Box boTelefone;
    Box boCadastro;


    public TelaCliente()
    {
        fClientes = this.getContentPane();
        pClientes = new JPanel();

        boNome = Box.createHorizontalBox();
        tNome = new JTextField(40);
        lNome = new JLabel("Nome: ");
        boNome.add(lNome);
        boNome.add(tNome);

        boCPF = Box.createHorizontalBox();
        tCPF = new JTextField(11);
        lCPF = new JLabel("CPF - apenas números: ");
        boCPF.add(lCPF);
        boCPF.add(tCPF);

        boTelefone = Box.createHorizontalBox();
        tTelefone = new JTextField(12);
        lTelefone = new JLabel("Telefone + DDD: ");
        boTelefone.add(lTelefone);
        boTelefone.add(tTelefone);

        bOk = new JButton("OK");
        bCancel = new JButton("Cancelar");

        boCadastro = Box.createVerticalBox();
        boCadastro.add(boNome);
        boCadastro.add(boCPF);
        boCadastro.add(boTelefone);

        pClientes.add(boCadastro);
        pClientes.add(bOk);
        pClientes.add(bCancel);
        fClientes.add(pClientes);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(500,132);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bOk) {
            Cliente cliente = new Cliente(tNome.getText(), Long.parseLong(tCPF.getText()), Integer.parseInt(tTelefone.getText()));
        }

        else if(event.getSource() == bCancel) {
            // ABRIR TELA CLIENTES
        }
    }
}
