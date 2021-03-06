package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
                cList = new ArrayList<Cliente>(); //Clients List.
                tList = new ArrayList<Tecnico>(); //Technicians List.
                oList = new ArrayList<Ordem>(); //Orders List.
                String query  = "SELECT * FROM Cliente";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                int i=0;//Controlar para preencherCliente.
                System.out.println("\n----------------------\n\nCarregando arquivos do banco de dados\n\n------------------");
                while(rs.next()) {
                    cList.add(new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone")));
                    cList.get(i).preencheCliente(rs.getString("RG"),rs.getString("Email"),rs.getString("Endereco"),rs.getString("DataNascimento"));
                    i++;
                }
                query  = "SELECT * FROM Tecnico";
                rs = stmt.executeQuery(query);
                while(rs.next()){
                    tList.add(new Tecnico(rs.getString("nome"),rs.getString("email"),rs.getString("telefone"),rs.getString("habilidade"),rs.getInt("numMatricula")));
                }
                query  = "SELECT * FROM Ordem";
                rs = stmt.executeQuery(query);
                Cliente client = null;
                while(rs.next()){
                    for(Cliente c : cList){
                        if(rs.getString("cId").equals(c.getCPF())){
                            client = c;
                            break;
                        }
                    }
                    Ordem o = new Ordem(client,rs.getString("descricao"),rs.getString("Habilidade"), rs.getString("DataPedido"), rs.getString("tID"), rs.getString("Status"));
                    oList.add(o);
                    o.preencheOrcamento(rs.getString("Qnt_Horas"), rs.getString("ValorHora"));
                }
                //Query materiais.
                query = "SELECT COUNT(DISTINCT Ordem) AS total FROM Materiais";
                ResultSet aux = stmt.executeQuery(query);
                aux.next();
                int total = aux.getInt("total");
                String Mat[] = new String[10];
                float MatVal[] = new float[10];
                for(int iter = 0;iter<total;iter++){
                    query = "Select * FROM Materiais" + " WHERE Ordem = " + iter;
                    aux = stmt.executeQuery(query);
                    while (aux.next()){//Retornar todos os materiais e valores para cada ordem.
                        Mat[iter] = aux.getString("Material");
                        MatVal[iter] = aux.getFloat("Material_Valor");
                    }
                    oList.get(iter).setMateriais(Mat,MatVal);
                }
                System.out.println("\n-------------\n\nCarregamento efetuado com sucesso\n\n---------------------\n");
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
    public void windowClosing(WindowEvent evnt) {

        try{
            Connection conn = data.Connection();
            String query;
            PreparedStatement pps;
            System.out.println("\n-------------\n\nArmazenando arquivos no banco de dados!\n\n---------------------\n");
            for(Cliente c : cList){
                query = "Insert INTO Cliente (nome,telefone,cpf,rg,endereco,email,DataNascimento) VALUES (" + "'" + c.Nome + "'" + "," + "'" + c.Telefone + "'" + "," + "'" + c.getCPF()+ "'" + "," + "'" + c.getRG() + "'" + "," + "'" + c.getEndereco() + "'" + "," + "'" + c.Email + "'" + "," + "'" + c.DataNascimento + "'" + ")"
                        + " ON DUPLICATE KEY UPDATE nome = " + "'" + c.Nome + "'," + "telefone = " + "'" + c.Telefone + "'," + "rg = " + "'" + c.getRG() + "'," + "endereco = " + "'" + c.getEndereco() + "'," + "email = '" + c.Email +  "'," + "DataNascimento = " + "'" + c.DataNascimento + "'";
                pps = conn.prepareStatement(query);
                pps.execute();
            }
            for(Ordem o : oList){
                System.out.println(o.getCliente());
                query = "Insert INTO Ordem (Qnt_Horas,id,ValorHora,DataPedido,tID,Descricao,Habilidade,cID,Status) VALUES (" + o.getHora() + "," + o.getId() + "," + o.getValor_hora() + "," + "'" + o.getData_pedido() + "'" + "," + o.gettID() + "," + "'" + o.getDescricao() + "'" + "," + "'" + o.getHabilidades() + "'" + "," + "'" + o.getCliente().getCPF() + "'" + "," + "'" + o.getStatus() + "'" + ") ON DUPLICATE KEY UPDATE Qnt_Horas = " + o.getHora() + "," + "id = " + o.getId() + "," + "ValorHora = " + o.getValor_hora() + "," + "DataPedido = " + "'" + o.getData_pedido() + "'," +
                        "tID = " + o.gettID() + "," + "Descricao = '" + o.getDescricao() + "'," + "Habilidade = '" + o.getHabilidades() + "'," + "cID = '" + o.getCliente().getCPF() + "'," + "Status = '" + o.getStatus() + "'";
                pps = conn.prepareStatement(query);
                pps.execute();

                //Materiais table.
                query = "TRUNCATE TABLE Materiais";
                pps = conn.prepareStatement(query);
                pps.execute();
                for(int loading = 0; loading<o.getMateriais().length;loading++){
                    if(o.getMaterial_valor()[loading]!=0){
                        query = "INSERT INTO Materiais(Ordem,Material,Material_Valor) VALUES (" + o.getId() + ",'" + o.getMateriais()[loading] + "'," + o.getMaterial_valor()[loading] + ")";
                        pps = conn.prepareStatement(query);
                        pps.execute();
                    }
                }
            }
            for(Tecnico t : tList){
                query = "Insert INTO Tecnico (nome,email,habilidade,numMatricula,Telefone) VALUES ('" + t.getNome() + "'," + "'" + t.getEmail() + "'" + ",'" + t.getHabilidade() + "'," + t.getNumMatricula() + ",'" + t.getTelefone() + "')" + "ON DUPLICATE KEY UPDATE nome = '" + t.getNome() + "'," + "email = " + "'" + t.getEmail() + "'," + "habilidade = '" + t.getHabilidade() + "'," + "Telefone = " + "'" + t.getTelefone() + "'";
                pps = conn.prepareStatement(query);
                pps.execute();
            }
            conn.close();
            System.out.println("\n-------------\n\nArmazenamento efetuado com sucesso\n\n---------------------\n");

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("\n-------------\n\nFalha no armazenamento!\n\n---------------------\n");
        }
        finally {
            super.windowClosing(evnt);
        }
    }
}