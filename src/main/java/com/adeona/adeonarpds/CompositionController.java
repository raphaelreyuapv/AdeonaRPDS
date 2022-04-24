package com.adeona.adeonarpds;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.time.ZoneId;

public class CompositionController {

    @FXML
    private TextField titre;
    @FXML
    private TextField lieu;
    @FXML
    private TextArea desc;
    @FXML
    private TextField url_image;
    @FXML
    private TextField pension;
    @FXML
    private TextField nombre_chambre;
    @FXML
    private ChoiceBox type;
    @FXML
    private ChoiceBox capacity;
    @FXML
    private CheckBox cuisine;
    @FXML
    private CheckBox internet;
    @FXML
    private CheckBox television;
    @FXML
    private CheckBox lave_linge;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;

    private HelloApplication helloApplication;

    public void setMainApp(HelloApplication helloApplication)
    {
        this.helloApplication = helloApplication;
    }

    @FXML
    private void initialize(){
        type.getItems().addAll("Maison","Appartement","Villa");
        capacity.getItems().addAll(0,1,2,3,4);
    }
    public void doReservation(){
        ZoneId local = ZoneId.systemDefault();
        String ss = (String)type.getValue();
        int typ = 0;
        if (ss.equals("Maison")) {
            typ=0;
        }else if(ss.equals("Appartement")){
            typ=1;
        }else if(ss.equals("Villa")){
            typ=2;
        }
        Sejour s = new Sejour(
                0,
                titre.getText(),
                lieu.getText(),
                desc.getText(),
                0,
                url_image.getText(),
                0,
                (int)Integer.valueOf(nombre_chambre.getText()),
                typ,
                (int)capacity.getValue(),
                (int)Integer.valueOf(pension.getText()),
                cuisine.isSelected(),
                internet.isSelected(),
                television.isSelected(),
                lave_linge.isSelected()
                ,Date.valueOf(date_debut.getValue()),
                Date.valueOf(date_fin.getValue())
        );
        SearchHelper.addSejour(s,0);

    }
}
