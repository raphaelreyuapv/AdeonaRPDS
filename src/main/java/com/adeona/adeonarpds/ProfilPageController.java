package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.sql.*;

public class ProfilPageController {



    @FXML
    private Text userPseudo;

    @FXML
    private Text userPresentation;


    public void loadUserData(int userID){

        /*
            quand la scene ProfilPage est appelle, utiliser les deux lignes dessous.
            ProfilPageController profilPageController = fxmlLoader.getController();
            ProfilPageController.loadUserData(0);
         */


        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:users.sqlite");
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select name,desc from users where id="+userID);

            while (resultSet.next()) {
                userPseudo.setText(resultSet.getString("name"));

                userPresentation.setText(resultSet.getString("desc"));

            }

            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (Exception exception) {
            System.out.println(exception);
        }

    }

}
