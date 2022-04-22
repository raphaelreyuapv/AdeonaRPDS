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
                User res = new User(rs.getString("name"),rs.getString("desc"),urls,rs.getInt("type"),rs.getInt("id"));
                return res;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    public static User getUser(int id)
    {
        Connection conn = null;
        Statement statement = null;
        String query = String.format("SELECT * FROM users WHERE id = %d",  id );
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                List<String> urls = new ArrayList<String>();
                urls.add(rs.getString("imageURL"));
                User res = new User(rs.getString("name"),rs.getString("desc"),urls,rs.getInt("type"),rs.getInt("id"));
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

    public static List<Sejour> getSejours(String search_param){
        Connection conn = null;
        Statement statement = null;
        List<Sejour> res = new ArrayList<Sejour>();
        String query = String.format("SELECT * FROM sejour  WHERE titre LIKE '%s' OR lieu LIKE '%s' OR description LIKE '%s'", "%"+search_param+"%","%"+search_param+"%","%"+search_param+"%");
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Sejour itm = new Sejour(rs);
                res.add(itm);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return res;
    }

    public static List<Sejour> getAllSejours(){
        Connection conn = null;
        Statement statement = null;
        List<Sejour> res = new ArrayList<Sejour>();
        String query = String.format("SELECT * FROM sejour");
        try {
            conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Sejour itm = new Sejour(rs);
                res.add(itm);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return res;
    }




}
