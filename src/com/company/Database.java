package com.company;

import java.sql.*;

/**
 * Created by kings on 12/06/2017.
 */
public class Database {

    private static final String URL = "jdbc:mysql://50.116.87.79:3306/clini357_poo";
    private static final String USERNAME = "clini357_databas";
    private static final String PASSWORD = "database";


    public static void Connection () throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query  = "Create table IF NOT EXISTS Tecnico(ID int NOT NULL AUTO_INCREMENT," +
                    "nome VARCHAR(30), email varchar(50),habilidade varchar(200),numMatricula int," +
                    " PRIMARY KEY(ID))";
            PreparedStatement pps = conn.prepareStatement(query);
            pps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
        conn.close();
    }
}