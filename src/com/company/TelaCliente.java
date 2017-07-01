package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TelaCliente extends JFrame implements ActionListener, WindowListener {

    private Container fClientes;
    private JPanel pClientes;

    Box boCadastro;
        Box boNome;
            final private JLabel lNome;
            private JTextField tNome;
        Box boCPF;
            final private JLabel lCPF;
            private JTextField tCPF;
        Box boTelefone;
            final private JLabel lTelefone;
            private JTextField tTelefone;
        final private JButton bOk;
        final private JButton bCancel;

        Box boRG;
            private JTextField tRG;
            private JLabel lRG;
        Box boEmail;
            private JTextField tEmail;
            private JLabel lEmail;
        Box boEndereco;
            private JTextField tEndereco;
            private JLabel lEndereco;
        Box boDataNascimento;
            private JTextField tDia, tMes, tAno;
            private JLabel lDataNascimento;


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
        bOk.addActionListener(this);
        bCancel = new JButton("Cancelar");
        bCancel.addActionListener(this);
        addWindowListener(this);

        boCadastro = Box.createVerticalBox();
        boCadastro.add(boNome);
        boCadastro.add(boCPF);
        boCadastro.add(boTelefone);


        atualizaCadastro(132);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bOk) {
            System.out.print("OK então");
            //Cliente cliente = new Cliente(tNome.getText(), Long.parseLong(tCPF.getText()), Integer.parseInt(tTelefone.getText()));
            cadastraNovoCliente();
        }

        else if(event.getSource() == bCancel) {
            this.dispose();
        }
    }

    public void cadastraNovoCliente()
    {
        boRG = Box.createHorizontalBox();
            tRG= new JTextField(12);
            lRG = new JLabel("Registro Geral: ");
            boRG.add(lRG);
            boRG.add(tRG);

        boEmail = Box.createHorizontalBox();
            tEmail = new JTextField(40);
            lEmail = new JLabel("E-mail: ");
            boEmail.add(lEmail);
            boEmail.add(tEmail);

        boEndereco = Box.createHorizontalBox();
            tEndereco = new JTextField(40);
            lEndereco = new JLabel("Endereço: ");
            boEndereco.add(lEndereco);
            boEndereco.add(tEndereco);

        boDataNascimento = Box.createHorizontalBox();
            tDia = new JTextField(2);
            tMes = new JTextField(2);
            tAno = new JTextField(2);
            lDataNascimento = new JLabel("Registro Geral: ");
            boDataNascimento.add(lDataNascimento);
            boDataNascimento.add(tDia);
            boDataNascimento.add(new JLabel("/"));
            boDataNascimento.add(tMes);
            boDataNascimento.add(new JLabel("/"));
            boDataNascimento.add(tAno);

        boCadastro.add(boRG);
        boCadastro.add(boEmail);
        boCadastro.add(boEndereco);
        boCadastro.add(boDataNascimento);

        this.atualizaCadastro( 200);
    }

    public void atualizaCadastro(int tam)
    {
        pClientes.remove(boCadastro);
          pClientes.add(boCadastro);
        pClientes.remove(bOk);
            pClientes.add(bOk);
        pClientes.remove(bCancel);
            pClientes.add(bCancel);
        fClientes.add(pClientes);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(500, tam);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void windowClosed(WindowEvent event) {
        TelaInicial.setBotaoClientes(true);
    }

    public void windowDeiconified(WindowEvent event) {}
    public void windowOpened(WindowEvent event) {}
    public void windowClosing(WindowEvent event) {}
    public void windowDeactivated(WindowEvent event) {}
    public void windowIconified(WindowEvent event) {}
    public void windowActivated(WindowEvent event) {}
}
