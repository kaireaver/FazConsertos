package com.company;
import javafx.collections.transformation.SortedList;
import javafx.scene.input.DataFormat;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class TelaCliente extends JFrame implements ActionListener, WindowListener {

    protected Container fClientes;
    protected JPanel pClientes;

    Box boCadastro;
        Box boNome;
            final protected JLabel lNome;
            protected JTextField tNome;
        Box boCPF;
            final protected JLabel lCPF;
            protected JTextField tCPF;
        Box boTelefone;
            final protected JLabel lTelefone;
            protected JTextField tTelefone;
        final protected JButton bOk;
        final protected JButton bCancel;

        Box boRG;
            protected JTextField tRG;
            protected JLabel lRG;
        Box boEmail;
            protected JTextField tEmail;
            protected JLabel lEmail;
        Box boEndereco;
            protected JTextField tEndereco;
            protected JLabel lEndereco;
        Box boDataNascimento;
            protected JTextField tDia, tMes, tAno;
            protected JLabel lDataNascimento;


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
            //tCPF = new JFormattedTextField(FormatoNumerico(0,0));
            try{
                javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("###.###.###-##");
                tCPF = new JFormattedTextField(format_textField4);
            }catch (Exception e){}
            lCPF = new JLabel("CPF - apenas números: ");
            boCPF.add(lCPF);
            boCPF.add(tCPF);
            //boCPF.add(new JLabel("                                                                                     "));



        boTelefone = Box.createHorizontalBox();
            tTelefone = new JFormattedTextField(FormatoNumerico(0,0));
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

        pClientes.add(boCadastro);
        pClientes.add(bOk);
        pClientes.add(bCancel);
        fClientes.add(pClientes);

        atualizaCadastro(132);
    }

    public void actionPerformed(ActionEvent event) {
        Cliente cliente = null;
        if(event.getSource() == bOk) {
            if(bOk.getText() == "OK"){
                String sCPF = tCPF.getText();
                sCPF = sCPF.replace("-", "");
                sCPF = sCPF.replace(".", "");
                System.out.println(sCPF);
                cliente = new Cliente(tNome.getText(), (Long.parseLong(sCPF)), tTelefone.getText());
                if(false)//(listaClientes.contains(cliente))
                {

                }
                else
                {
                    cadastraNovoCliente();
                    bOk.setText("CADASTRAR");
                }
            }
            else
            {
                if(cliente!= null)
                {
                    cliente.ConfirmaCliente(tRG.getText(), tEmail.getText(), tEndereco.getText(), new Data(Integer.parseInt(tDia.getText()), Integer.parseInt(tMes.getText()), Integer.parseInt(tAno.getText())));
                }
                TelaCliente ConfirmaCliente = new TelaCliente();
            }
        }

        else if(event.getSource() == bCancel) {
            this.dispose();
        }

    }

    public void cadastraNovoCliente()
    {
        tNome.setEditable(false);
        tCPF.setEditable(false);
        tTelefone.setEditable(false);
        boRG = Box.createHorizontalBox();
            tRG= new JTextField(12);
            lRG = new JLabel("Registro Geral: ");
            boRG.add(lRG);
            boRG.add(tRG);

        boEmail = Box.createHorizontalBox();
            tEmail = new JTextField();
            lEmail = new JLabel("E-mail: ");
            boEmail.add(lEmail);
            boEmail.add(tEmail);

        boEndereco = Box.createHorizontalBox();
            tEndereco = new JTextField();
            lEndereco = new JLabel("Endereço: ");
            boEndereco.add(lEndereco);
            boEndereco.add(tEndereco);

        boDataNascimento = Box.createHorizontalBox();
            //tDia = new JTextField(2);


            tDia = new JFormattedTextField(FormatoNumerico(2, 2));
            tDia.setText("01");
            tMes = new JFormattedTextField(FormatoNumerico(2, 2));
            tMes.setText("01");
            tAno = new JFormattedTextField(FormatoNumerico(4, 4));
            tAno.setText("1800");
            lDataNascimento = new JLabel("Data de Nascimento: ");
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

        pClientes.add(boCadastro, 0);
        atualizaCadastro(212);
    }

    public void atualizaCadastro(int tam)
    {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(500, tam);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void windowClosed(WindowEvent event) {
        TelaInicial.setBotaoClientes(true);
        TelaInicial.setBotaoTecnicos(true);
    }

    public void windowDeiconified(WindowEvent event) {}
    public void windowOpened(WindowEvent event) {}
    public void windowClosing(WindowEvent event) {}
    public void windowDeactivated(WindowEvent event) {}
    public void windowIconified(WindowEvent event) {}
    public void windowActivated(WindowEvent event) {}

    public NumberFormatter FormatoNumerico(int max, int min)
    {
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        if(max!=0)
            format.setMaximumIntegerDigits(max);
        if(min!=0)
            format.setMinimumIntegerDigits(min);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Long.class);
        formatter.setAllowsInvalid(false);
        return formatter;
    }

}

