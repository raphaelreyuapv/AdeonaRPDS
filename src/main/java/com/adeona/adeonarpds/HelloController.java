package com.adeona.adeonarpds;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    private HelloApplication helloApplication;

    public void setMainApp(HelloApplication helloApplication)
    {
        this.helloApplication = helloApplication;
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent event){
        Session.Login(username.getText());

        helloApplication.displayMenu();
    }
}