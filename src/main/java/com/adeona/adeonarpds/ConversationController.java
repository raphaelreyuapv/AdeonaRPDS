package com.adeona.adeonarpds;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    @FXML
    private void initialize(){
        setUser_home(Session.name_logged);
        chatbox.setText(Session.chat_history);
        chatinput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER)
                send();
                Session.setChatHistory(chatbox.getText());
            }
        });
    }
    public void setUser_home(String user_home){
        this.user_home = user_home;
    }

    public void loadhistory(String hist){
        chatbox.setText(hist);
    }


}
