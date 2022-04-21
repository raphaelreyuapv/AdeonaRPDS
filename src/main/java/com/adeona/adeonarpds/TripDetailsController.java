package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class TripDetailsController {

    @FXML
    private Label tripTitle;

    @FXML
    private Label host;

    @FXML
    private Label place;

    @FXML
    private Label score;

    @FXML
    private Label description;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private Label chamberNumber;

    @FXML
    private Label lodgingType;

    @FXML
    private Label capacity;

    @FXML
    private Label pension;

    @FXML
    private CheckBox kitchen;

    @FXML
    private CheckBox internet;

    @FXML
    private CheckBox tv;

    @FXML
    private CheckBox washer;

    @FXML
    private Button contact;

    public void test()
    {
        //System.out.println("fonctionne");

        Sejour sej  = SearchHelper.getSejour("Sejour ardeche");
        System.out.println(sej.cuisine);

    }





}
