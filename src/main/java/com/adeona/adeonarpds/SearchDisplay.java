package com.adeona.adeonarpds;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.concurrent.Task;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class SearchDisplay implements Initializable{

    @FXML
    private VBox itemHolder = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Sejour> allSejours = SearchHelper.getAllSejours();

        Node[] nodes = new Node[allSejours.size()];

        Thread taskThread = new Thread(new Runnable() {
            @Override public void run() {
                for (int i=0; i< nodes.length; i++) {
                    try {
                        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search_item.fxml"));
                        int id = allSejours.get(i).getId();
                        String title = allSejours.get(i).getTitre();
                        String loc = allSejours.get(i).getLieu();
                        String host = SearchHelper.getUser(allSejours.get(i).getId_host()).getName();
                        String img = allSejours.get(i).getURL_image();
                        fxmlLoader.setControllerFactory(controllerClass -> new SearchItem(id, title, loc, host, img));
                        nodes[i] = fxmlLoader.load();
                        final int index = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                itemHolder.getChildren().add(nodes[index]);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        taskThread.start();

    }
}
