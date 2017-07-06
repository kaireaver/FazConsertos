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
    private Database data;

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

    @Override
    public void setDefaultCloseOperation(int operation) {
        //Save lists.
        try{
            Connection conn = data.Connection();
            String query = "TRUNCATE TABLE Cliente";
            PreparedStatement pps = conn.prepareStatement(query);
            pps.execute();
            query = "TRUNCATE TABLE ORDEM";
            pps = conn.prepareStatement(query);
            pps.execute();
            query = "TRUNCATE TABLE TECNICO";
            pps = conn.prepareStatement(query);
            pps.execute();
            for(Cliente c : cList){
                query = "Insert INTO Cliente (nome,telefone,cpf,endereco,email) VALUES (" + c.getNome() + "," + c.getTelefone() + "," + c.getCPF() + "," + c.getEndereco() + "," + c.getEmail() + ")";
                pps = conn.prepareStatement(query);
                pps.execute();
            }
            for(Ordem o : oList){
                query = "Insert INTO Ordem (Qnt_Horas,ValorHora,DataPedido,Preco,Materiais,tID,Descricao,Habilidade,cID,Status) VALUES (" + o.getHora() + "," + o.getValor_hora() + "," + o.getData_pedido() + "," + o.getMaterial_valor() + "," + o.getMateriais() + "," + o.gettID() + "," + o.getDescricao() + "," + o.getHabilidades() + "," + o.getCliente().getCPF() + "," + o.getStatus() + ")";
                pps = conn.prepareStatement(query);
                pps.execute();
            }
            for(Tecnico t : tList){
                query = "Insert INTO Tecnico (ID,nome,email,habilidade,numMatricula,Telefone) VALUES (" + t.getId() + "," + t.getEmail() + "," + t.getHabilidade() + "," + t.getNumMatricula() + "," + t.getTelefone() + ")";
                pps = conn.prepareStatement(query);
                pps.execute();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}