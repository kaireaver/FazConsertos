package com.company;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.*;

/**
 * Created by kings on 12/06/2017.
 */
public class Database {

    private static final String URL = "jdbc:h2:~/test;AUTO_SERVER=TRUE";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "sa";


    public static void Connection () throws SQLException {
        Connection conn = null;
        try {
            JdbcDataSource ds = new JdbcDataSource();
            Class.forName("org.h2.Driver");
            //conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ds.setURL(URL);
            ds.setUser("sa");
            ds.setPassword("sa");
            conn = ds.getConnection();
            String query  = "SELECT * FROM TBL";
            PreparedStatement pps = conn.prepareStatement(query);
            ResultSet rs = pps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.close();
    }
}