package com.adeona.adeonarpds;

import javafx.fxml.FXML;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.sql.Date;
import java.util.ArrayList;

public class TripDetailsController {


    private ArrayList<ImageView> imgLayout = new ArrayList<>();

    private int tripId;

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
    private AnchorPane reservation;

    @FXML
    private DatePicker datePickerBegin;

    @FXML
    private DatePicker datePickerEnd;

    private Sejour sej;

    private HelloApplication helloApplication;

    public void setTripId(int tripId)
    {
        this.tripId = tripId;
    }

    public void setMainApp(HelloApplication helloApplication, int tripId)
    {
        this.helloApplication = helloApplication;
        this.tripId = tripId;
        displayInformation();
    }

    private void displayInformation()
    {
        reservation.setVisible(false);
        imgLayout.add(img1);
        imgLayout.add(img2);
        imgLayout.add(img3);

        sej = SearchHelper.getSejour(tripId);

        if(sej != null) {
            tripTitle.setText(sej.getTitre());
            this.helloApplication.setTitle("Séjour - " + sej.getTitre());
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

            if(sej.getURL_image() != null && sej.getURL_image().equals(""))
            {
                String[] imgList = sej.getURL_image().split(";");
                for (int i = 0; i < imgList.length; i++) {
                    this.imgLayout.get(i).setImage(new Image(imgList[i]));
                }
            }
        }
    }

    @FXML
    private void initialize()
    {}

    @FXML
    public void displayReservation()
    {
        reservation.setVisible(true);
    }

    @FXML
    public void AddToDatabase()
    {
        if(datePickerBegin.valueProperty() != null && datePickerEnd.valueProperty() != null)
        {
            if(datePickerBegin.valueProperty().get() != datePickerEnd.valueProperty().get())
            {
                ReservationDatabase.setReservation(Date.valueOf(datePickerBegin.valueProperty().get()), Date.valueOf(datePickerEnd.valueProperty().get()), sej.getId_host(), 1, sej.getId());
            }
        }
    }







}
