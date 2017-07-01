package com.company;
import javax.swing.*;
import java.awt.event.*;

public class LogaTecnico extends JFrame implements ActionListener {
    private JPanel pLoginTecnico;
    private static JButton bLogin;
    final private static JLabel lDescription = new JLabel("Número de Matrícula:");
    final private static JLabel lNotFound = new JLabel("Número de matrícula não encontrado!");
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
                JFrame fMainTecnico = new MainTecnico();
                this.dispose();
            } else {
                lNotFound.setVisible(true);
            }
        }
    }

}
