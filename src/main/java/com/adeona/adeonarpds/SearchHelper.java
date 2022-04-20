package com.adeona.adeonarpds;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static User getUser(String name){
        Connection conn = null;
        Statement statement = null;
        String query = String.format("SELECT * FROM users WHERE name LIKE '%s'", "%"+name+"%");
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                List<String> urls = new ArrayList<String>();
                urls.add(rs.getString("imageURL"));
                User res = new User(rs.getString("name"),rs.getString("desc"),urls,rs.getInt("type"));
                return res;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    public static Sejour getSejour(String titre){
        Connection conn = null;
        Statement statement = null;
        String query = String.format("SELECT * FROM sejour  WHERE titre LIKE '%s'", "%"+titre+"%");
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Sejour res = new Sejour(rs);
                return res;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }




}
