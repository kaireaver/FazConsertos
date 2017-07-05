package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

        tNome = new JTextField(40);
        lNome = new JLabel("Nome:   ");
        boNome = novoBoxHorizontal(lNome, tNome);

        tCPF = novoJTextFieldMascarado("###.###.###-##");
        lCPF = new JLabel("CPF - apenas números:   ");
        boCPF = novoBoxHorizontal(lCPF, tCPF);

        tTelefone = novoJTextFieldMascarado(" (##) ####-####");
        lTelefone = new JLabel("Telefone Fixo + DDD:   ");
        boTelefone = novoBoxHorizontal(lTelefone, tTelefone);



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
        tamanhoTela(132);
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
            tRG = novoJTextFieldMascarado("##.###.###-#");
            lRG = new JLabel("Registro Geral - apenas números:   ");
            boRG = novoBoxHorizontal(lRG, tRG);

        tEmail = new JTextField();
        lEmail = new JLabel("E-mail:   ");
        boEmail = novoBoxHorizontal(lEmail, tEmail);

        tEndereco = new JTextField();
        lEndereco = new JLabel("Endereço:   ");
        boEndereco = novoBoxHorizontal(lEndereco, tEndereco);

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
        tamanhoTela(212);
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

