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

    public static void addSejour(Sejour s,int idhost){
        Connection conn = null;
        String query = "INSERT INTO sejour(titre,lieu,description,id_host,URL_image,note,nombre_chambre,type_logement,capacity,pension,cuisine,internet,television,lave_linge,date_debut,date_fin) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,s.getTitre());
            preparedStatement.setString(2,s.getLieu());
            preparedStatement.setString(3,s.getDescription());
            preparedStatement.setInt(4,idhost);
            preparedStatement.setString(5,s.getURL_image());
            preparedStatement.setInt(6,s.getNote());
            preparedStatement.setInt(7,s.getNombre_chambre());
            preparedStatement.setInt(8,s.getType_logement());
            preparedStatement.setInt(9,s.getCapacity());
            preparedStatement.setInt(10,s.getPension());
            preparedStatement.setBoolean(11,s.isCuisine());
            preparedStatement.setBoolean(12,s.isInternet());
            preparedStatement.setBoolean(13,s.isTelevision());
            preparedStatement.setBoolean(14,s.isLave_linge());
            preparedStatement.setDate(15,s.date_debut);
            preparedStatement.setDate(16,s.date_fin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




}
