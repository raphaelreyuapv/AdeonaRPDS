package com.adeona.adeonarpds;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class TripCompositionController {

    @FXML
    private TableView<TripCompositionRow> reservationTable;

    @FXML
    private TableColumn<TripCompositionRow, String> title;

    @FXML
    private TableColumn<TripCompositionRow, String> begin;

    @FXML
    private TableColumn<TripCompositionRow, String> end;

    @FXML
    private TableColumn<TripCompositionRow, TripCompositionRow> link;

    @FXML
    private TableColumn<TripCompositionRow, TripCompositionRow> delete;

    private ObservableList<TripCompositionRow> reservationsData = FXCollections.observableArrayList();

    @FXML
    AnchorPane currentWindow;

    @FXML
    private void initialize() {
        ArrayList<Reservation> reserv = (ArrayList<Reservation>) SearchHelper.getClientReservations(0);

        title.setCellValueFactory(cellData -> cellData.getValue().tripNameProperty());
        begin.setCellValueFactory(cellData -> cellData.getValue().dateBeginProperty());
        end.setCellValueFactory(cellData -> cellData.getValue().dateEndProperty());

        delete.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );

        link.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );

        if (reserv != null)
        {
            for (Reservation r : reserv) {

                System.out.println(r.toString());
                delete.setCellFactory(param -> new TableCell<TripCompositionRow, TripCompositionRow>()
                {
                    private final Button deleteButton = new Button("Supprimer");

                    @Override
                    protected void updateItem(TripCompositionRow c, boolean empty) {
                        super.updateItem( c,  empty);


                        if (c == null) {
                            setGraphic(null);
                            return;
                        }
                        setGraphic(deleteButton);
                        deleteButton.setOnAction(
                                event -> cancel(c)
                        );
                    }
                });

                link.setCellFactory(param -> new TableCell<TripCompositionRow, TripCompositionRow>()
                {
                    private final Button linkButton = new Button("Voir");

                    @Override
                    protected void updateItem(TripCompositionRow c, boolean empty) {
                        super.updateItem( c,  empty);

                        if (c == null) {
                            setGraphic(null);
                            return;
                        }
                        setGraphic(linkButton);
                        linkButton.setOnAction(
                                event -> goToTrip(c)
                        );
                    }
                });

                Sejour s = SearchHelper.getSejour(r.getId_sejour());
                if(s != null)
                {
                    reservationsData.add(new TripCompositionRow(s.getTitre(), r.getDate_debut(), r.getDate_fin(), s.getId()));
                    reservationTable.setItems(reservationsData);
                }
                else
                {
                    System.out.println("null");
                }
            }
        }
    }

    public void cancel(TripCompositionRow c)
    {
        ReservationDatabase.cancelReservation(c.getTripId(), 0); //suppression dans la base de donnée
        reservationsData.remove(c); //suppression dans l'interface (de la liste d'observable)
    }

    public void goToTrip(TripCompositionRow c)
    {
        //Pour aller vers le voyage en question, à améliorer avec la navigation.
        /*try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stay-details.fxml"));
            ScrollPane window = fxmlLoader.load();
            currentWindow.getChildren().setAll(window);
            TripDetailsController tripDetailsController = fxmlLoader.getController();
            tripDetailsController.setTripId(c.getTripId());


        } catch (
                IOException e) {
            e.printStackTrace();
        }*/
    }
}
