package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tela extends JFrame implements WindowListener {

    static Database data;
    static ArrayList<Cliente> cList;
    static ArrayList<Tecnico> tList;
    static ArrayList oList;

    protected boolean checaDispose = false;

    Tela(String str, int w, int h) {
        super(str);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(this);
        setSize(w, h);
    }

    public void fechaTela(boolean ativaBotaoInicial) {
        this.checaDispose = ativaBotaoInicial;
        checaDispose();
        this.dispose();
    }

    public void checaDispose() {
        if (!checaDispose) {
            TelaInicial.setBotaoTecnicos(false);
            TelaInicial.setBotaoClientes(false);
        } else {
            TelaInicial.setBotaoTecnicos(true);
            TelaInicial.setBotaoClientes(true);
        }
    }


    public JTextField novoJTextFieldMascarado(String str)
    {
        try{
            MaskFormatter format_textField = new MaskFormatter(str);
            return new JFormattedTextField(format_textField);
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
    public void windowClosing(WindowEvent e) {
        fechaTela(true);
    }

    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

}
