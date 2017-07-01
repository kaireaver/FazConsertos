package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args) throws SQLException {
        System.out.println("OI LINDOS");
        Database Data = new Database();
        Data.Connection();
        ordersScreen orders = new ordersScreen();
    }
}
//Não funcionou .