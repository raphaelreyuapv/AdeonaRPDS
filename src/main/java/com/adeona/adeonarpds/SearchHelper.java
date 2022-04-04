package com.adeona.adeonarpds;
import java.sql.*;

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

    public static void getUser(String name){
        Connection conn = null;
        Statement statement = null;
        String query = String.format("SELECT * FROM users WHERE name = '%s'", name);
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("imageURL"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
