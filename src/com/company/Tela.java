package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Tela extends JFrame {
    protected boolean checaDispose = false;

    Tela(String str) {
        super(str);
    }

    public void checaDispose() {
        if (checaDispose) {
            TelaInicial.setBotaoTecnicos(false);
            TelaInicial.setBotaoClientes(false);
        } else {
            TelaInicial.setBotaoTecnicos(true);
            TelaInicial.setBotaoClientes(true);
        }
    }

    public void tamanhoTela(int tam)
    {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(500, tam);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public JTextField novoJTextFieldMascarado(String str)
    {
        try{
            MaskFormatter format_textField4 = new MaskFormatter(str);
            return new JFormattedTextField(format_textField4);
        }catch (Exception e){
            return null;
        }
    }

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

    public static boolean emailIsValid(String email)
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

    public Box novoBoxHorizontal(JLabel label, Component textField)
    {
        Box b = Box.createHorizontalBox();
        b.add(label);
        b.add(textField);
        return b;
    }
}
