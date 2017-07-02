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

public class TelaCliente extends JFrame implements ActionListener, WindowListener {

    private Container fClientes;
    private JPanel pClientes;
    private Cliente cliente = null;

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
        this.setTitle("INSIRA SEUS DADOS CADASTRAIS:");
        fClientes = this.getContentPane();
        pClientes = new JPanel();

        boNome = Box.createHorizontalBox();
            tNome = new JTextField(40);
            lNome = new JLabel("Nome:   ");
            boNome.add(lNome);
            boNome.add(tNome);

        boCPF = Box.createHorizontalBox();
            try{
                javax.swing.text.MaskFormatter format_textFieldCPF = new javax.swing.text.MaskFormatter("##.###.###-##");
                tCPF = new JFormattedTextField(format_textFieldCPF);
            }catch (Exception e){}
            lCPF = new JLabel("CPF - apenas números:   ");
            boCPF.add(lCPF);
            boCPF.add(tCPF);
            //boCPF.add(new JLabel("                                                                                     "));



        boTelefone = Box.createHorizontalBox();
            try{
                javax.swing.text.MaskFormatter format_textFieldTel = new javax.swing.text.MaskFormatter(" (##) ####-####");
                tTelefone = new JFormattedTextField(format_textFieldTel);
            }catch (Exception e){}
            lTelefone = new JLabel("Telefone Fixo + DDD:   ");
            boTelefone.add(lTelefone);
            boTelefone.add(tTelefone);



        bOk = new JButton("OK");
        bOk.addActionListener(this);
        bCancel = new JButton("CANCELAR");
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
        
        if(event.getSource() == bOk) {
            if(bOk.getText() == "OK")
            {
                if(tNome.getText().trim()!="" || tCPF.getText().trim()!="")
                {
                    criaCliente();
                    if(true)//(listaClientes.contains(cliente))
                    {
                        //cliente = listaClientes.find(cliente);
                        cliente.preencheCliente("1231231231", "1231asda", "asda@asdac.com", new Data(06,11,1996));
                        confirmaClienteExistente();
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
                if(isValid(tEmail.getText()))
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
        cliente = new Cliente(tNome.getText(), (Long.parseLong(sCPF)), tTelefone.getText());
    }

    private void logaCliente()
    {
        //listaClientes.add(cliente);
        //JFrame TelaDeSolicitacoes = new TelaServicos
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
        this.setTitle("INSIRA SEUS DADOS CADASTRAIS:");
        tRG.setEditable(true);
        tEmail.setEditable(true);
        tEndereco.setEditable(true);
        tDia.setEditable(true);
        tMes.setEditable(true);
        tAno.setEditable(true);
        bOk.setText("CADASTRAR");
        bCancel.setText("CANCELAR");

    }

    public void confirmaClienteExistente()
    {
        cadastraNovoCliente();
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
            try{
                javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##.###.###-#");
                tRG = new JFormattedTextField(format_textField4);
            }catch (Exception e){}
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

        boCadastro.add(boRG);
        boCadastro.add(boEmail);
        boCadastro.add(boEndereco);
        boCadastro.add(boDataNascimento);

        pClientes.add(boCadastro, 0);
        bOk.setText("CADASTRAR");
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

    public static boolean isValid(String email)
    {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

}

