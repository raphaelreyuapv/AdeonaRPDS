package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProfilEditPageController {


    @FXML
    private TextField userPseudoField;

    @FXML
    private TextField userIconField;

    @FXML
    private TextField userMailField;

    @FXML
    private Text warningMessage;

    @FXML
    private TextArea userDescField;

    @FXML
    private CheckBox typeField;
    private boolean creation = true;
    private int userID = -1;

    @FXML
    AnchorPane currentWindow;

    public void loadUserData(int userID){

        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:users.sqlite");
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select name,desc,imageURL from users where id="+userID);
            creation = false;
            this.userID = userID;

            while (resultSet.next()) {

                userPseudoField.setText(resultSet.getString("name"));
                userIconField.setText(resultSet.getString("imageURL"));
                userDescField.setText(resultSet.getString("desc"));

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
    protected void onEditFinish() {


        if ( (userPseudoField.getText() == null || userPseudoField.getText().trim().isEmpty())
                || (userIconField.getText() == null || userIconField.getText().trim().isEmpty())
                || (userMailField.getText() == null || userMailField.getText().trim().isEmpty())
                || (userDescField.getText() == null || userDescField.getText().trim().isEmpty())) {
            warningMessage.setVisible(true);
        }
        else{
            int type=0;
            if(typeField.isSelected()){
                type=1;
            }
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:users.sqlite");
                Statement statement;
                statement = connection.createStatement();
                String query;

                if(creation){

                    ResultSet resultSet;
                    resultSet = statement.executeQuery("select MAX(id) from users");

                    int nID = 0;

                    while (resultSet.next()) {
                        nID = resultSet.getInt("MAX(id)");
                    }

                    userID = nID+1;
                    query = "INSERT INTO users VALUES ( "+ userID +", '"+ userPseudoField.getText()+ "' , '"+ userDescField.getText() +"', '"+ userIconField.getText() +"', "+type+")";
                }
                else{

                    query = "UPDATE users set name = '"+ userPseudoField.getText()+ "', desc = '"+ userDescField.getText() + "', imageURL='" + userIconField.getText() + "' where id="+ userID;


                }

                statement.executeUpdate(query);
                statement.close();
                connection.close();
                creation = true;


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profilPage-view.fxml"));
                AnchorPane window = fxmlLoader.load();
                currentWindow.getChildren().setAll(window);
                ProfilPageController profilPageController = fxmlLoader.getController();
                profilPageController.loadUserData(userID);

            }
            catch (Exception exception) {
                System.out.println(exception);
            }

        }


    }


}
