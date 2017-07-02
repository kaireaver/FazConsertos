package com.company;

import java.sql.*;

/**
 * Created by kaireaver on 02/07/17.
 */
public class ClientsDatabase {

    Connection conn;

    public ClientsDatabase(Connection conn){
        this.conn = conn;
    }

    public void AddClient(){

    }

    public boolean findClient(int cpfProcurado) {
        String query = "select count(1)" +
                "from Cliente" +
                "where cpf = " + cpfProcurado;
        try {
            PreparedStatement pps = conn.prepareStatement(query);
            ResultSet rs = pps.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
