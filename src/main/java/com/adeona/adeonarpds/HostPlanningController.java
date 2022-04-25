package com.adeona.adeonarpds;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class HostPlanningController {
    @FXML
    private TableView<TripCompositionRow> reservationTable;

    @FXML
    private TableColumn<TripCompositionRow, String> title;

    @FXML
    private TableColumn<TripCompositionRow, String> begin;

    @FXML
    private TableColumn<TripCompositionRow, String> end;

    @FXML
    private TableColumn<TripCompositionRow, String> clientName;

    @FXML
    private TableColumn<TripCompositionRow, TripCompositionRow> link;

    @FXML
    private TableColumn<TripCompositionRow, TripCompositionRow> delete;

    private ObservableList<TripCompositionRow> reservationsData = FXCollections.observableArrayList();

    private HelloApplication helloApplication;

    private int hostID;

    public void setMainApp(HelloApplication helloApplication, int hostID)
    {
        this.helloApplication = helloApplication;
        this.hostID = hostID;
        display();
    }

    public void display()
    {
        ArrayList<Reservation> reserv = (ArrayList<Reservation>) SearchHelper.getHostReservationsList(0);

        title.setCellValueFactory(cellData -> cellData.getValue().tripNameProperty());
        begin.setCellValueFactory(cellData -> cellData.getValue().dateBeginProperty());
        end.setCellValueFactory(cellData -> cellData.getValue().dateEndProperty());
        clientName.setCellValueFactory(cellData -> cellData.getValue().clientNameProperty());

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
                    private final Button deleteButton = new Button("Annuler");

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
                if(s != null && SearchHelper.getUser(r.getClient_id()).getName() != null)
                {
                    reservationsData.add(new TripCompositionRow(s.getTitre(), r.getDate_debut(), r.getDate_fin(), s.getId(), SearchHelper.getUser(r.getClient_id()).getName()));
                    reservationTable.setItems(reservationsData);
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
        this.helloApplication.displayTripPage(c.getTripId());
    }

    @FXML
    public void goToMenu()
    {
        this.helloApplication.displayMenu();
    }


}
