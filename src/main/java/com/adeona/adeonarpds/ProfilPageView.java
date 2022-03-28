package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProfilPageView {

    Connection connection = DriverManager.getConnection("jdbc:sqlite:$PROJECT_DIR$/users.sqlite");

    public ProfilPageView() throws SQLException {
    }
}
