package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class TelaInicial extends Tela {
    private JPanel pInicial;
    final private JLabel lDescription;
    protected static JButton bTecnicos;
    protected static JButton bClientes;

    public TelaInicial() {
        super("Bem-vindo ao sistema FazConsertos v1.0!", 500, 70);

        data = new Database();
        try{
            Connection conn = data.Connection();
            if (conn != null) {
                cList = new ArrayList(); //Clients List.
                tList = new ArrayList(); //Technicians List.
                oList = new ArrayList(); //Orders List.
                String query  = "SELECT * FROM Clientes";
                PreparedStatement pps = conn.prepareStatement(query);
                ResultSet rs = pps.executeQuery();
                while(rs.next()){
                    cList.add(new Cliente(rs.getString("nome"),rs.getInt("cpf"),rs.getString("telefone")));
                }
                query  = "SELECT * FROM Tecnicos";
                pps = conn.prepareStatement(query);
                rs = pps.executeQuery();
                while(rs.next()){
                    tList.add(new Tecnico(rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("habilidade")));
                }
                query  = "SELECT * FROM Orders";
                pps = conn.prepareStatement(query);
                rs = pps.executeQuery();
                Cliente client = null;
                while(rs.next()){
                    for(Cliente c : cList){
                        if(c.getCPF()==rs.getInt("cpf")){
                            client = c;
                            break;
                        }
                    }
                    oList.add(new Ordem(client,rs.getString("descricao")));
                }
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

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bTecnicos) {
            JFrame fTecnico = new TelaTecnico();
            setButton(bTecnicos,false);
            setButton(bClientes,false);
        }

        else if(event.getSource() == bClientes) {
            JFrame fClientes = new TelaCliente();
            setButton(bTecnicos,false);
            setButton(bClientes,false);
        }
    }

}