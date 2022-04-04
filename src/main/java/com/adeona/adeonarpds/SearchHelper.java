package com.adeona.adeonarpds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SearchHelper {

    static String url = "jdbc:sqlite:users.sqlite";

    public static void testConn(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.getMessage();
        }
        System.out.println("yay");
    }

    public static void getUser(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            e.getMessage();
        }
    }
}
