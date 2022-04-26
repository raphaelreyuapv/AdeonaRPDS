package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.*;

public class ProfilPageController {



    @FXML
    private Text userPseudo;

    @FXML
    private Text userPresentation;

    @FXML
    AnchorPane currentWindow;

    private int userID;

    private HelloApplication helloApplication;

    public void setMainApp(HelloApplication helloApplication)
    {
        this.helloApplication = helloApplication;
    }

    public void loadUserData(int userID){

        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:users.sqlite");
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select name,desc from users where id="+userID);
            this.userID = userID;
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

    @FXML
    public void onEditButton() {
        this.helloApplication.displayHostProfileEdit(userID);
    }

    public void backToMenu()
    {
        this.helloApplication.displayMenu();
    }

    public void openConv(){ this.helloApplication.displayConversation();}

}
