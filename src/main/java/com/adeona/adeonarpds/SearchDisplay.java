package com.adeona.adeonarpds;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class SearchDisplay implements Initializable{

    @FXML
    private VBox itemHolder = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Node[] nodes = new Node[20];

        for (int i=0; i<nodes.length; i++) {
            try {
                nodes[i] = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search_item.fxml")));


                itemHolder.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
