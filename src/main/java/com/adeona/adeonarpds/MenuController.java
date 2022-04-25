package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuController {

    private HelloApplication helloApplication;

    @FXML
    AnchorPane hostPane;

    @FXML
    private Button searchButton;

    @FXML
    private Button reservationButton;

    @FXML
    private Button profileButton;

    public void setMainApp(HelloApplication helloApplication)
    {
        this.helloApplication = helloApplication;
    }

    @FXML
    private void initialize() {
        hostPane.setVisible(false);
        if (Session.type_logged == 1) {
            hostPane.setVisible(true);
            this.searchButton.setText("Proposition de séjour");
        }

    }


    @FXML
    public void createTrip()
    {
        this.helloApplication.displayTripCreationPage();
    }

    @FXML
    public void hostReservation()
    {
        this.helloApplication.displayHostReservation(Session.id_logged);
    }

    @FXML
    public void voyageComposition()
    {
        this.helloApplication.displayTripComposition(Session.id_logged);
    }

    @FXML
    public void search()
    {
        this.helloApplication.displaySearch();
    }

    @FXML
    public void profile()
    {
        this.helloApplication.displayHostProfile(Session.id_logged);
    }


}
