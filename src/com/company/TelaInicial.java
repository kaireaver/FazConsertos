package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Set;

public class TelaInicial extends Tela implements ActionListener {
    private JPanel pInicial;
    final private JLabel lDescription;
    private static JButton bTecnicos;
    private static JButton bClientes;

    public TelaInicial() {
        super("Bem-vindo ao sistema FazConsertos v1.0!", 500, 70);

        data = new Database();
        try{
            Connection conn = data.Connection();
            if (conn != null) {
                cList = new ArrayList(); //Clients List.
                tList = new ArrayList(); //Technicians List.
                oList = new ArrayList(); //Orders List.
                String query  = "Create table IF NOT EXISTS Tecnico(ID int NOT NULL AUTO_INCREMENT," +
                        "nome VARCHAR(30), email varchar(50),habilidade varchar(200),numMatricula int," +
                        " PRIMARY KEY(ID))";
                PreparedStatement pps = conn.prepareStatement(query);
                pps.execute();
                query  = "Create table IF NOT EXISTS Tecnico(ID int NOT NULL AUTO_INCREMENT," +
                        "nome VARCHAR(30), email varchar(50),habilidade varchar(200),numMatricula int," +
                        " PRIMARY KEY(ID))";
                pps = conn.prepareStatement(query);
                pps.execute();
                query  = "Create table IF NOT EXISTS Tecnico(ID int NOT NULL AUTO_INCREMENT," +
                        "nome VARCHAR(30), email varchar(50),habilidade varchar(200),numMatricula int," +
                        " PRIMARY KEY(ID))";
                pps = conn.prepareStatement(query);
                pps.execute();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        data.closeConnection();

        lDescription = new JLabel("Selecione o tipo de usuário:");

        bTecnicos = new JButton("Técnicos");
        bClientes = new JButton("Clientes");

        bTecnicos.addActionListener(this);
        bClientes.addActionListener(this);

        pInicial = new JPanel();
        pInicial.add(lDescription);
        pInicial.add(bTecnicos);
        pInicial.add(bClientes);

        getContentPane().add(pInicial);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bTecnicos) {
            JFrame fTecnico = new TelaTecnico(tList);
            setBotaoTecnicos(false);
            setBotaoClientes(false);
        }

        else if(event.getSource() == bClientes) {
            JFrame fClientes = new TelaCliente();
            setBotaoTecnicos(false);
            setBotaoClientes(false);
        }
    }

    public static void setBotaoTecnicos(boolean state) {
        bTecnicos.setEnabled(state);
        bTecnicos.setBorderPainted(state);
    }

    public static void setBotaoClientes(boolean state) {
        bClientes.setEnabled(state);
        bClientes.setBorderPainted(state);
    }

}