package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import javafx.scene.text.Text;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HostValidationPageController {


    @FXML
    private Text offerUsername;
    @FXML
    private Text offerTitle;
    @FXML
    private Text offerLocation;
    @FXML
    private Text offerStart;
    @FXML
    private Text offerEnd;
    @FXML
    private Text offerDesc;

    int sejourIDInList=-1;

    @FXML
    protected void onOfferNoButton() {

        Session.sejourOffer.remove(sejourIDInList);
        Session.sejourOfferTravelerID.remove(sejourIDInList);

    }

    @FXML
    protected void onOfferYesButton() {


        ReservationDatabase.setReservation(Session.sejourOffer.get(sejourIDInList).date_debut,Session.sejourOffer.get(sejourIDInList).date_fin,Session.id_logged,sejourIDInList,Session.sejourOffer.get(sejourIDInList).id);

        Session.sejourOffer.remove(sejourIDInList);
        Session.sejourOfferTravelerID.remove(sejourIDInList);

    }

    public void loadOfferData(int sejourIDInList){

        /*
            sejourIDInList correspond a la position de l'offre de sejour dans la liste Session.sejourOffer.
            utiliser les lignes en dessous apres avoir load la page :
            HostValidationPageController temp = fxmlLoader.getController();
            temp.loadOfferData(idDeOffre);
         */
        this.sejourIDInList = sejourIDInList;
        offerTitle.setText(Session.sejourOffer.get(sejourIDInList).titre);
        offerLocation.setText(Session.sejourOffer.get(sejourIDInList).lieu);
        offerStart.setText(String.valueOf(Session.sejourOffer.get(sejourIDInList).date_debut));
        offerEnd.setText(String.valueOf(Session.sejourOffer.get(sejourIDInList).date_fin));
        offerDesc.setText(Session.sejourOffer.get(sejourIDInList).description);

        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:users.sqlite");
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select name from users where id="+Session.sejourOfferTravelerID.get(sejourIDInList));

            while (resultSet.next()) {

                offerUsername.setText(resultSet.getString("name"));

            }

            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (Exception exception) {
            System.out.println(exception);
        }

    }

}
