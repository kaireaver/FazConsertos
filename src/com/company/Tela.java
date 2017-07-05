package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tela extends JFrame implements WindowListener {
    protected boolean checaDispose = false;

    Tela(String str) {
        super(str);
    }

    // Enviar true se for para setar os botões da tela inicial.
    public void fechaTela(boolean disposeStatus) {
        this.checaDispose = disposeStatus;
        checaDispose();
        this.dispose();
    }

    public void checaDispose() {
        if (checaDispose) {
            TelaInicial.setBotaoTecnicos(true);
            TelaInicial.setBotaoClientes(true);
        } else {
            TelaInicial.setBotaoTecnicos(false);
            TelaInicial.setBotaoClientes(false);
        }
    }

    public JTextField novaMascara(String str)
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

    public void windowClosing(WindowEvent event) {
        this.fechaTela(true);
    }

    public void windowDeiconified(WindowEvent event) {}
    public void windowOpened(WindowEvent event) {}
    public void windowClosed(WindowEvent event) {}
    public void windowDeactivated(WindowEvent event) {}
    public void windowIconified(WindowEvent event) {}
    public void windowActivated(WindowEvent event) {}

}