package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tela extends JFrame implements WindowListener, ActionListener {

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

    public static void setButton(JButton button, boolean state) {
        button.setEnabled(state);
        button.setBorderPainted(state);
    }

    public void fechaTela(boolean ativaBotaoInicial) {
        this.checaDispose = ativaBotaoInicial;
        checaDispose();
        this.dispose();
    }

    private void checaDispose() {
        if (!checaDispose) {
            setButton(TelaInicial.bTecnicos,false);
            setButton(TelaInicial.bClientes,false);
        } else {
            setButton(TelaInicial.bTecnicos,true);
            setButton(TelaInicial.bClientes,true);
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

    public void actionPerformed(ActionEvent e){}
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
