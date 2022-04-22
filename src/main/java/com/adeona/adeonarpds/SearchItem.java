package com.adeona.adeonarpds;

import eu.hansolo.tilesfx.Tile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchItem implements Initializable {

    Class<?> clazz = this.getClass();

    InputStream input = clazz.getResourceAsStream("img.png");
    private Image image = new Image(input);

    @FXML
    private Label title = new Label("hello");

    @FXML
    private Label location = new Label("loieu");

    @FXML
    private Label host = new Label("hote");



    @FXML
    private ImageView urlProfile = new ImageView();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
