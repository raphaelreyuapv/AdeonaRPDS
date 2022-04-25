package com.adeona.adeonarpds;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hostValidationPage-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        Session.addSejourOffer(SearchHelper.getSejour(1),0);
        HostValidationPageController temp = fxmlLoader.getController();
        temp.loadOfferData(0);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}