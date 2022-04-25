package com.adeona.adeonarpds;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage mainStage;
    private BorderPane rootLayout;
    private Scene scene;

    private Session userSession;

    @Override
    public void start(Stage stage) throws IOException {

        this.mainStage = stage;
        this.mainStage.setResizable(false);
        initRootLayout();

        displayConnection();
    }

    public void initRootLayout()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("rootLayout.fxml"));

            rootLayout = (BorderPane) loader.load();

            scene = new Scene(rootLayout, 600,600);
            mainStage.setScene(scene);
            mainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void displayConnection()
    {
        try {
            //charger le fichier fxml associé
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("hello-view.fxml")); //on charge la vue souhaitée
            AnchorPane view = (AnchorPane) loader.load();

            this.mainStage.setTitle("Adeonas - Connexion"); //on choisi le titre de la fenêtre

            //on charge le controlleur associé a la vue
            HelloController controller = loader.getController();
            controller.setMainApp(this);
            view.setPrefWidth(600);
            view.setPrefHeight(600);
            mainStage.setWidth(600);
            mainStage.setHeight(600);

            //on met la vue au centre de la scene

            rootLayout.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMenu()
    {
        try {
            //charger le fichier fxml associé
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("menu-view.fxml")); //on charge la vue souhaitée
            AnchorPane view = (AnchorPane) loader.load();

            this.mainStage.setTitle("Adeonas - Menu"); //on choisi le titre de la fenêtre

            //on charge le controlleur associé a la vue
            MenuController controller = loader.getController();
            controller.setMainApp(this);
            view.setPrefWidth(1000);
            view.setPrefHeight(700);
            mainStage.setWidth(1000);
            mainStage.setHeight(700);

            //on met la vue au centre de la scene

            rootLayout.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displaySearch()
    {
        try {
            //charger le fichier fxml associé
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("search_display.fxml")); //on charge la vue souhaitée
            AnchorPane view = (AnchorPane) loader.load();


            this.mainStage.setTitle("Adeonas - Recherche"); //on choisi le titre de la fenêtre

            //on charge le controlleur associé a la vue
            SearchDisplay controller = loader.getController();
            controller.setMainApp(this);
            view.setPrefWidth(700);
            view.setPrefHeight(500);
            mainStage.setWidth(700);
            mainStage.setHeight(500);

            //on met la vue au centre de la scene

            rootLayout.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayTripPage(int tripID) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("stay-details.fxml"));
            ScrollPane stayView = (ScrollPane) loader.load();

            TripDetailsController controller = loader.getController();
            controller.setMainApp(this, tripID);

            mainStage.setWidth(1000);
            mainStage.setHeight(900);
            rootLayout.setCenter(stayView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayTripCreationPage()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("composition.fxml"));
            AnchorPane view = loader.load();

            this.mainStage.setTitle("Adeonas - Ajouter un séjour");
            CompositionController controller = loader.getController();
            controller.setMainApp(this);

            mainStage.setWidth(800);
            mainStage.setHeight(850);
            rootLayout.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayHostProfile(int userID)
    {
        try
        {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profilPage-view.fxml"));
        AnchorPane view = loader.load();

        this.mainStage.setTitle("Adeonas - Votre profil");
        ProfilPageController controller = loader.getController();
        controller.setMainApp(this);
        controller.loadUserData(userID);

        mainStage.setWidth(1000);
        mainStage.setHeight(681);
        rootLayout.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayHostProfileEdit(int userID)
    {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("profilEditPage-view.fxml"));
            AnchorPane view = loader.load();

            this.mainStage.setTitle("Adeonas - Modifiez votre profil");
            ProfilEditPageController controller = loader.getController();
            controller.loadUserData(userID);
            controller.setMainApp(this);

            mainStage.setWidth(1000);
            mainStage.setHeight(681);
            rootLayout.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayHostReservation(int hostID)
    {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("hostPlanning.fxml"));
            AnchorPane view = loader.load();

            this.mainStage.setTitle("Adeonas - Planning de réservation hôte");
            HostPlanningController controller = loader.getController();
            controller.setMainApp(this, hostID);

            mainStage.setWidth(1000);
            mainStage.setHeight(900);
            rootLayout.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayTripComposition(int userID)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("tripCompositionPage-view.fxml"));
            AnchorPane stayView = (AnchorPane) loader.load();

            this.mainStage.setTitle("Adeonas - Composition de votre voyage");
            TripCompositionController controller = loader.getController();
            controller.setMainApp(this, userID);

            mainStage.setWidth(1000);
            mainStage.setHeight(800);
            rootLayout.setCenter(stayView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title)
    {
        this.mainStage.setTitle(title);
    }

    public static void main(String[] args) {
        launch();
    }
}