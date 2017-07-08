package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class TelaCliente extends Tela {

    private Container fClientes;
    private JPanel pClientes;

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
            private JTextField tDataNascimento;
            private JLabel lDataNascimento;


    public TelaCliente()
    {
        super("INSIRA SEUS DADOS:", 500, 132);

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
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        if(event.getSource() == bOk) 
        {
            if(bOk.getText() == "OK")
            {
                if(tNome.getText().trim()!="" || tCPF.getText().trim()!="")
                {
                    try
                    {
                        procuraCliente();
                        confirmaClienteExistente();
                    }
                    catch (Exception e)
                    {
                        cadastraNovoCliente();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "DADOS INVÁLIDO!");
                }

            }
            else if(bOk.getText() == "CADASTRAR")
            {
                if(emailIsValid(tEmail.getText()))
                    confirmaCliente();
                else
                    JOptionPane.showMessageDialog(this,"EMAIL INVÁLIDO!");
            }
            else if(bOk.getText() == "CONFIRMAR")
            {
                logaCliente();
            }
        }

        else if(event.getSource() == bCancel) {
            if(bCancel.getText()=="EDITAR")
            {
                editaCliente();
            }else
                this.fechaTela(true);
        }

    }


    private void logaCliente()
    {
        String dataNascimento = new String(tDataNascimento.getText());
        cliente.preencheCliente(tRG.getText(), tEmail.getText(), tEndereco.getText(), dataNascimento);
        cList.add(this.cliente);
        System.out.println("Cliente adicionado." +cliente.toString());

        JFrame TelaDeSolicitacoes = new TelaMainCliente(cliente);
        this.fechaTela(false);
    }


    private void confirmaCliente()
    {
        this.setTitle("CONFIRME SEUS DADOS CADASTRAIS:");
        String dataNascimento = new String(tDataNascimento.getText());
        cliente.preencheCliente(tRG.getText(), tEmail.getText(), tEndereco.getText(), dataNascimento);
        tRG.setEditable(false);
        tEmail.setEditable(false);
        tEndereco.setEditable(false);
        tDataNascimento.setEditable(false);
        bOk.setText("CONFIRMAR");
        bCancel.setText("EDITAR");

    }

    private void editaCliente()
    {
        this.setTitle("INSIRA SEUS DADOS:");
        tRG.setEditable(true);
        tEmail.setEditable(true);
        tEndereco.setEditable(true);
        tDataNascimento.setEditable(true);
        bOk.setText("CONFIRMAR");
        bCancel.setText("CANCELAR");

    }

    public void confirmaClienteExistente()
    {
        cadastraNovoCliente();
        this.setTitle("CONFIRME SEUS DADOS CADASTRAIS:");
        System.out.println("Abrindo tela de confirmação de cliente.");
        tRG.setText(cliente.RG);
        tRG.setEditable(false);

        tEmail.setText(cliente.Email);
        tEmail.setEditable(false);

        tEndereco.setText(cliente.Endereco);
        tEndereco.setEditable(false);

        tDataNascimento.setText(cliente.DataNascimento.toString());
        tDataNascimento.setEditable(false);

        bOk.setText("CONFIRMAR");
        bCancel.setText("EDITAR");
    }


    public void cadastraNovoCliente()
    {
        this.setTitle("NOVO CADASTRO - "+tNome.getText());

        System.out.println("Abrindo tela de cadastro.");
        tNome.setText(this.cliente.Nome);
        tNome.setEditable(false);
        tCPF.setText(this.cliente.CPF);
        tCPF.setEditable(false);
        tTelefone.setText(this.cliente.Telefone);
        tTelefone.setEditable(false);

        tRG = novoJTextFieldMascarado("##.###.###");
        lRG = new JLabel("Registro Geral - apenas números:   ");
        boRG = novoBoxHorizontal(lRG, tRG);

        tEmail = new JTextField();
        lEmail = new JLabel("E-mail:   ");
        boEmail = novoBoxHorizontal(lEmail, tEmail);

        tEndereco = new JTextField();
        lEndereco = new JLabel("Endereço:   ");
        boEndereco = novoBoxHorizontal(lEndereco, tEndereco);

        tDataNascimento = novoJTextFieldMascarado("##/##/####");
        lDataNascimento = new JLabel("Data de Nascimento:   ");
        boDataNascimento = novoBoxHorizontal(lDataNascimento, tDataNascimento);

        boFormulario.add(boRG, 3);
        boFormulario.add(boEmail, 4);
        boFormulario.add(boEndereco, 5);
        boFormulario.add(boDataNascimento, 6);

        pClientes.add(boFormulario, 0);
        bOk.setText("CADASTRAR");
        setSize(500, 212);
    }


    public void procuraCliente() throws Exception {

        String sCPF = tCPF.getText();
        this.cliente = new Cliente(tNome.getText(), sCPF, tTelefone.getText());

        System.out.println("Procurando na lista com  "+ String.valueOf(cList.size()) + " clientes cadastrados.");
        System.out.println("Procurando pelo cliente: " + String.valueOf(cliente.CPF) + ".");
        for (Cliente c : Tela.cList )
        {
            System.out.println("Encontrado cliente: " + String.valueOf(c.CPF) + ".");
            if(c.CPF.equals(this.cliente.CPF) )
            {
                System.out.println(String.valueOf(cList.remove(cList.indexOf(c))));
                System.out.println("Cliente " + cliente.Nome + " encontrado!\n--------------------\n");
                this.cliente = c;
                return;
            }
        }

        System.out.println("Cliente " + cliente.Nome + " não encontrado!");
        throw new Exception("Cliente existente!");
    }

    @Override
    public void fechaTela(boolean ativaBotaoInicial) {
        this.cliente = null;
        super.fechaTela(ativaBotaoInicial);
    }
}

