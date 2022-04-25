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
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement;
            statement = connection.createStatement();
            String query;

            ResultSet resultSet;
            resultSet = statement.executeQuery("select MAX(id) from reservation");

            int nID = 0;

            while (resultSet.next()) {
                nID = resultSet.getInt("MAX(id)");
            }
            int userID = nID+1;

            query = "INSERT INTO reservation VALUES ("+ userID +","+ tripId +", '"+ ownerId + "' , '"+ clientId +"', '"+ dateBegin +"', '"+ dateEnd +"' )";

            statement.executeUpdate(query);
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
