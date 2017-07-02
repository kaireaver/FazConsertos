package com.company;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.*;
import java.text.NumberFormat;

public class LogaTecnico extends JFrame implements ActionListener {
    private JPanel pLoginTecnico;
    private static JButton bLogin;
    private static JButton bCancela;
    final private static JLabel lDescription = new JLabel("Número de Matrícula:");
    final private static JLabel lNotFound = new JLabel("Número de matrícula não encontrado!");
    private JFormattedTextField txtMatricula;

    public LogaTecnico() {
        super("Digite seus dados de usuário:");

        bLogin = new JButton("Entrar");
        bCancela = new JButton("Cancelar");
        bLogin.addActionListener(this);
        bCancela.addActionListener(this);

        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setAllowsInvalid(false);
        txtMatricula = new JFormattedTextField(formatter);
        txtMatricula.setColumns(15);

        pLoginTecnico = new JPanel();
        pLoginTecnico.add(lDescription);
        pLoginTecnico.add(txtMatricula);
        pLoginTecnico.add(bLogin);
        pLoginTecnico.add(bCancela);
        pLoginTecnico.add(lNotFound);

        lNotFound.setVisible(false);
        getContentPane().add(pLoginTecnico);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,70);
        setResizable(false);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bLogin){
            // CHECAR SE EXISTE MATRÍCULA!
            if(true) {
                JFrame fMainTecnico = new MainTecnico(txtMatricula.getText());
                this.dispose();
            } else {
                lNotFound.setVisible(true);
            }
        }

        else if(event.getSource() == bCancela) {
            this.dispose();
        }
    }

}
