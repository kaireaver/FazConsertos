package com.company;

import java.sql.*;

/**
 * Created by kings on 12/06/2017.
 */
public class Database {

    private static final String URL = "jdbc:mysql://50.116.87.79:3306/clini357_poo";
    private static final String USERNAME = "clini357_databas";
    private static final String PASSWORD = "database";
    private static Connection conn;
    ClientsDatabase clDB;


    public static Connection Connection () throws SQLException {
        conn = null;
        System.out.println("Iniciando conexão...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(conn != null)System.out.println("Conexão iniciada com sucesso!");
        return conn;
    }

    public static void closeConnection(){
        try{
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Conexão encerrada com sucesso!");
    }
}