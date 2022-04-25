package com.adeona.adeonarpds;
import java.sql.*;


public class ReservationDatabase {

    public static String url = "jdbc:sqlite:users.sqlite";

    public static void testConn(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void setReservation(Date dateBegin, Date dateEnd, int ownerId, int clientId, int tripId)
    {
        String query = "INSERT INTO reservation(id_sejour, host_id, client_id, date_debut, date_fin) VALUES (?,?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement statement;
            statement = connection.prepareStatement(query);

            statement.setInt(1, tripId);
            statement.setInt(2, ownerId);
            statement.setInt(3, clientId);
            statement.setDate(4, dateBegin);
            statement.setDate(5, dateEnd);

            statement.executeUpdate();
            statement.close();
            connection.close();

        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void cancelReservation(int id, int clientID)
    {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement;
            statement = connection.createStatement();
            String query;

            query = "DELETE FROM reservation WHERE id_sejour = " + id + " AND client_id = " + clientID;

            statement.executeUpdate(query);
            statement.close();
            connection.close();

        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

}
