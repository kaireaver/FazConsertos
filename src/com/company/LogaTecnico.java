package com.company;
import javax.swing.*;
import java.awt.event.*;

public class LogaTecnico extends JFrame implements ActionListener {
    private JPanel pLoginTecnico;
    private static JButton bLogin;
    final private JLabel lDescription = new JLabel("Número de Matrícula:");
    private JTextField txtMatricula;

    public LogaTecnico() {
        super("Digite seus dados de usuário:");

        bLogin = new JButton("Entrar");
        bLogin.addActionListener(this);

        txtMatricula = new JTextField("Digite o seu número de matrícula.");

        pLoginTecnico = new JPanel();
        pLoginTecnico.add(lDescription);
        pLoginTecnico.add(txtMatricula);
        pLoginTecnico.add(bLogin);

        getContentPane().add(pLoginTecnico);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,70);
        setResizable(false);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bLogin){
            // IMPLEMENTAR!
        }
    }

}
