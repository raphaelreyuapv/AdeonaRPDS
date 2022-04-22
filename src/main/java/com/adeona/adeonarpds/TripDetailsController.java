package com.adeona.adeonarpds;

import javafx.fxml.FXML;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class TripDetailsController {


    private ArrayList<ImageView> imgLayout = new ArrayList<>();

    private int trip_id;

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
    private Label beginning;

    @FXML
    private Label end;

    @FXML
    private void initialize()
    {
        System.out.println("fonctionne");
        imgLayout.add(img1);
        imgLayout.add(img2);
        imgLayout.add(img3);

        Sejour sej = SearchHelper.getSejour("Sejour ardeche");

        if(sej != null) {
            tripTitle.setText(sej.getTitre());
            System.out.println(sej.toString());
            place.setText(sej.getLieu());
            System.out.println(sej.getId_host());
            User u = SearchHelper.getUser(sej.getId());
            if(u != null) {
                host.setText(u.getName());
            }
            this.score.setText(sej.getNote() + "/20");
            this.description.setText(sej.getDescription());
            this.capacity.setText(String.valueOf(sej.getCapacity()));
            this.chamberNumber.setText(String.valueOf(sej.getNombre_chambre()));

            this.end.setText(sej.getDate_fin().toString());
            this.beginning.setText(sej.getDate_debut().toString());

            if(sej.getType_logement() == 0)
            {
                this.lodgingType.setText("Appartement");
            }
            else if(sej.getType_logement() == 1)
            {
                this.lodgingType.setText("Maison");
            }
            else if(sej.getType_logement() == 2)
            {
                this.lodgingType.setText("Chambre");
            }

            if(sej.getPension() == 0) {
                this.pension.setText("Aucune");
            }
            else if(sej.getPension() == 1)
            {
                this.pension.setText("Demi-pension");
            }
            else if(sej.getPension() == 2)
            {
                this.pension.setText("Pension complète");
            }

            this.kitchen.setSelected(sej.isCuisine());
            this.kitchen.setDisable(true);
            this.internet.setSelected(sej.isInternet());
            this.internet.setDisable(true);
            this.tv.setSelected(sej.isTelevision());
            this.tv.setDisable(true);
            this.washer.setSelected(sej.isLave_linge());
            this.washer.setDisable(true);

            if(!sej.getURL_image().equals(""))
            {
                String[] imgList = sej.getURL_image().split(";");
                for (int i = 0; i < imgList.length; i++) {
                    this.imgLayout.get(i).setImage(new Image(imgList[i]));
                }
            }



        }


    }







}
