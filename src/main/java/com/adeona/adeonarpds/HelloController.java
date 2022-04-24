package com.adeona.adeonarpds;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button login;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent event){
        Session.Login(username.getText());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profilPage-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
            //This line gets the Stage Information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            ProfilPageController profilPageController = fxmlLoader.getController();
            profilPageController.loadUserData(Session.id_logged);
            window.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}