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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelaCliente extends Tela implements ActionListener, WindowListener {

    private Container fClientes;
    private JPanel pClientes;

    private ArrayList<Cliente> listaClientes;
    private Cliente cliente = null;

    Box boFormulario;
        Box boNome;
            final private JLabel lNome;
            private JTextField tNome;
        Box boCPF;
            final private JLabel lCPF;
            private JTextField tCPF;
        Box boTelefone;
            final private JLabel lTelefone;
            private JTextField tTelefone;
        Box boBotoes;
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


    public TelaCliente(ArrayList<Cliente> listaClientes)
    {
        super("INSIRA SEUS DADOS:");

        this.listaClientes = listaClientes;

        fClientes = this.getContentPane();
        pClientes = new JPanel();

        boNome = Box.createHorizontalBox();
            tNome = new JTextField(40);
            lNome = new JLabel("Nome:   ");
            boNome.add(lNome);
            boNome.add(tNome);

        boCPF = Box.createHorizontalBox();
            tCPF = novaMascara("###.###.###-##");
            lCPF = new JLabel("CPF - apenas números:   ");
            boCPF.add(lCPF);
            boCPF.add(tCPF);

        boTelefone = Box.createHorizontalBox();
            try{
                javax.swing.text.MaskFormatter format_textFieldTel = new javax.swing.text.MaskFormatter(" (##) ####-####");
                tTelefone = new JFormattedTextField(format_textFieldTel);
            }catch (Exception e){}
            lTelefone = new JLabel("Telefone Fixo + DDD:   ");
            boTelefone.add(lTelefone);
            boTelefone.add(tTelefone);



        boBotoes = Box.createHorizontalBox();
            bOk = new JButton("OK");
            bOk.addActionListener(this);
            bCancel = new JButton("CANCELAR");
            bCancel.addActionListener(this);
            boBotoes.add(bOk);
            boBotoes.add(bCancel);

        boFormulario = Box.createVerticalBox();
            boFormulario.add(boNome);
            boFormulario.add(boCPF);
            boFormulario.add(boTelefone);
            boFormulario.add(boBotoes);

        pClientes.add(boFormulario);

        fClientes.add(pClientes);
        addWindowListener(this);
        atualizaCadastro(132);
    }

    public void actionPerformed(ActionEvent event) {
        
        if(event.getSource() == bOk) {
            if(bOk.getText() == "OK")
            {
                if(tNome.getText().trim()!="" || tCPF.getText().trim()!="")
                {
                    criaCliente();
                    Cliente c = procuraClienteNaLista();
                    if(c != null)
                    {
                        this.cliente = c;
                        confirmaprocuraClienteNaLista();
                    }
                    else
                    {
                        cadastraNovoCliente();
                    }
                } else
                    JOptionPane.showMessageDialog(this,"NOME INVÁLIDO!");

            }
            else if(bOk.getText() == "CADASTRAR")
            {
                if(emailIsValid(tEmail.getText()))
                    confirmaCliente();
                else
                    JOptionPane.showMessageDialog(this,"EMAIL INVÁLIDO!");
            }
            else if(cliente!= null)
            {
                logaCliente();
            }
        }

        else if(event.getSource() == bCancel) {
            if(bCancel.getText()=="EDITAR")
            {
                editaCliente();
            }else
                this.dispose();
        }

    }

    private void criaCliente()
    {
        String sCPF = tCPF.getText();
        sCPF = sCPF.replace("-", "");
        sCPF = sCPF.replace(".", "");
        System.out.println(sCPF);
        this.cliente = new Cliente(tNome.getText(), (Long.parseLong(sCPF)), tTelefone.getText());
    }

    private void logaCliente()
    {
        listaClientes.add(this.cliente);
        JFrame TelaDeSolicitacoes = new MainCliente(cliente);
        this.dispose();
    }

    private void confirmaCliente()
    {
        this.setTitle("CONFIRME SEUS DADOS CADASTRAIS:");
        Data dataNascimento = new Data(Integer.parseInt(tDia.getText()), Integer.parseInt(tMes.getText()), Integer.parseInt(tAno.getText()));
        cliente.preencheCliente(tRG.getText(), tEmail.getText(), tEndereco.getText(), dataNascimento);
        tRG.setEditable(false);
        tEmail.setEditable(false);
        tEndereco.setEditable(false);
        tDia.setEditable(false);
        tMes.setEditable(false);
        tAno.setEditable(false);
        bOk.setText("CONFIRMAR");
        bCancel.setText("EDITAR");

    }
    private void editaCliente()
    {
        this.setTitle("INSIRA SEUS DADOS:");
        tRG.setEditable(true);
        tEmail.setEditable(true);
        tEndereco.setEditable(true);
        tDia.setEditable(true);
        tMes.setEditable(true);
        tAno.setEditable(true);
        bOk.setText("CADASTRAR");
        bCancel.setText("CANCELAR");

    }

    public void confirmaprocuraClienteNaLista()
    {
        cadastraNovoCliente();
        this.setTitle("CONFIRME SEUS DADOS CADASTRAIS:");
        tRG.setText(cliente.RG);
        tRG.setEditable(false);
        tEmail.setText(cliente.Email);
        tEmail.setEditable(false);
        tEndereco.setText(cliente.Endereco);
        tEndereco.setEditable(false);
        tDia.setText(String.valueOf(cliente.DataNascimento.Dia));
        tDia.setEditable(false);
        tMes.setText(String.valueOf(cliente.DataNascimento.Mes));
        tMes.setEditable(false);
        tAno.setText(String.valueOf(cliente.DataNascimento.Ano));
        tAno.setEditable(false);
        bOk.setText("CONFIRMAR");
        bCancel.setText("EDITAR");
    }



    public void cadastraNovoCliente()
    {
        this.setTitle("NOVO CADASTRO - "+tNome.getText());
        tNome.setEditable(false);
        tCPF.setEditable(false);
        tTelefone.setEditable(false);
        boRG = Box.createHorizontalBox();
            tRG = novaMascara("##.###.###-#");
            lRG = new JLabel("Registro Geral - apenas números:   ");
            boRG.add(lRG);
            boRG.add(tRG);

        boEmail = Box.createHorizontalBox();
            tEmail = new JTextField();
            lEmail = new JLabel("E-mail:   ");
            boEmail.add(lEmail);
            boEmail.add(tEmail);

        boEndereco = Box.createHorizontalBox();
            tEndereco = new JTextField();
            lEndereco = new JLabel("Endereço:   ");
            boEndereco.add(lEndereco);
            boEndereco.add(tEndereco);

        boDataNascimento = Box.createHorizontalBox();
            tDia = new JFormattedTextField(FormatoNumerico(2, 2));
            tDia.setText("01");
            tMes = new JFormattedTextField(FormatoNumerico(2, 2));
            tMes.setText("01");
            tAno = new JFormattedTextField(FormatoNumerico(4, 4));
            tAno.setText("1800");
            lDataNascimento = new JLabel("Data de Nascimento:   ");
            boDataNascimento.add(lDataNascimento);
            boDataNascimento.add(tDia);
            boDataNascimento.add(new JLabel("/"));
            boDataNascimento.add(tMes);
            boDataNascimento.add(new JLabel("/"));
            boDataNascimento.add(tAno);

        boFormulario.add(boRG, 3);
        boFormulario.add(boEmail, 4);
        boFormulario.add(boEndereco, 5);
        boFormulario.add(boDataNascimento, 6);

        pClientes.add(boFormulario, 0);
        bOk.setText("CADASTRAR");
        atualizaCadastro(212);
    }

    public void atualizaCadastro(int tam)
    {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(500, tam);
        this.setResizable(false);
        this.pack();
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




    public Cliente procuraClienteNaLista()
    {
        for (Cliente c:this.listaClientes
             ) {
            if(c.CPF == this.cliente.CPF)
            {
                return c;
            }

        }
        return null;
    }
}

