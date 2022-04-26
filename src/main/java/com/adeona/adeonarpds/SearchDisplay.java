package com.adeona.adeonarpds;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.concurrent.Task;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class SearchDisplay implements Initializable{

    @FXML
    private VBox itemHolder = null;

    @FXML
    private TextField searchBar = null;

    private List<Sejour> sejoursToDisplay = null;

    private HelloApplication helloApplication;

    public void setMainApp(HelloApplication helloApplication)
    {
        this.helloApplication = helloApplication;
    }


    Service<Void> service = new Service<Void>()
    {
        @Override
        protected Task<Void> createTask()
        {
            Node[] nodes = new Node[sejoursToDisplay.size()];

            return new Task<Void>() {
                protected Void call() throws Exception {
                    Thread.sleep(400);
                    for (int i=0; i< nodes.length; i++) {
                        try {
                            final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search_item.fxml"));
                            int id = sejoursToDisplay.get(i).getId();
                            String title = sejoursToDisplay.get(i).getTitre();
                            String loc = sejoursToDisplay.get(i).getLieu();
                            String host = SearchHelper.getUser(sejoursToDisplay.get(i).getId_host()).getName();
                            String img = sejoursToDisplay.get(i).getURL_image();
                            fxmlLoader.setControllerFactory(controllerClass -> new SearchItem(id, title, loc, host, img, helloApplication));
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
                    return null;
                }
            };
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Session.type_logged == 1) {
            this.sejoursToDisplay = SearchHelper.getAllHostSejours(Session.id_logged);
        }
        else {
            this.sejoursToDisplay = SearchHelper.getAllSejours();
        }

        for (Sejour sejour : sejoursToDisplay) {
            System.out.println(sejour.getURL_image());
        }
        service.start();
    }

    public void search(KeyEvent event) {
        if(searchBar.getText().length() >= 2) {
            if (Session.type_logged == 1) {
                sejoursToDisplay = SearchHelper.getSejours(searchBar.getText(), Session.id_logged);
            }
            else {
                sejoursToDisplay = SearchHelper.getSejours(searchBar.getText());
            }
            itemHolder.getChildren().clear();
            service.restart();
        }
    }

    public void backToMenu(MouseEvent mouseEvent) {
        this.helloApplication.displayMenu();
    }
}
