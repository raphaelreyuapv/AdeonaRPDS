package com.adeona.adeonarpds;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SearchHelper {

    public static String url = "jdbc:sqlite:users.sqlite";

    public static void testConn(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("yay");
    }
}
