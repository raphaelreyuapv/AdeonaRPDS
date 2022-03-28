package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConversationController {

    @FXML
    private TextArea chatbox;
    @FXML
    private TextField chatinput;
    public void send(){
        chatbox.appendText("\nUser1:"+chatinput.getText());
        chatinput.setText("");
    }
}
