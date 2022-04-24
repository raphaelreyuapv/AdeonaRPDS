package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConversationController {

    @FXML
    private TextArea chatbox;
    @FXML
    private TextField chatinput;

    private String user_home;
    public void send(){
        chatbox.appendText("\n"+Session.name_logged+":"+chatinput.getText());
        chatinput.setText("");
    }

    public void setUser_home(String user_home){
        this.user_home = user_home;
    }

    public void loadhistory(String hist){
        chatbox.setText(hist);
    }
}
