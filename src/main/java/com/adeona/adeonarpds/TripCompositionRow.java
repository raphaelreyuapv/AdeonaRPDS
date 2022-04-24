package com.adeona.adeonarpds;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class TripCompositionRow {

    private StringProperty tripName;
    private StringProperty dateBegin;
    private StringProperty dateEnd;
    private int tripId;

    public TripCompositionRow(String tripName, Date dateBegin, Date dateEnd, int tripId) {
        this.tripName = new SimpleStringProperty(tripName);
        this.dateBegin = new SimpleStringProperty(dateBegin.toString());
        this.dateEnd = new SimpleStringProperty(dateEnd.toString());
        this.tripId = tripId;

    }

    public String getTripName() {
        return tripName.get();
    }

    public StringProperty tripNameProperty() {
        return tripName;
    }

    public String getDateBegin() {
        return dateBegin.get();
    }

    public StringProperty dateBeginProperty() {
        return dateBegin;
    }

    public String getDateEnd() {
        return dateEnd.get();
    }

    public StringProperty dateEndProperty() {
        return dateEnd;
    }

    public int getTripId() {
        return tripId;
    }


}
