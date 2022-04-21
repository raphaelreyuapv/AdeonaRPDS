package com.adeona.adeonarpds;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sejour {
    int id;
    String titre;
    String lieu;
    String description;
    int id_host;
    String URL_image;
    int note;
    int nombre_chambre;
    int type_logement;
    int capacity;
    int pension;
    boolean cuisine;
    boolean internet;
    boolean television;
    boolean lave_linge;
    Date date_debut;
    Date date_fin;

    public Sejour(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.titre = rs.getString("titre");
        this.lieu = rs.getString("lieu");
        this.description = rs.getString("description");
        this.id_host = rs.getInt("id_host");
        this.URL_image = rs.getString("URL_image");
        this.note = rs.getInt("note");
        this.nombre_chambre = rs.getInt("nombre_chambre");
        this.type_logement = rs.getInt("type_logement");
        this.capacity = rs.getInt("capacity");
        this.pension = rs.getInt("pension");
        this.cuisine = rs.getBoolean("cuisine");
        this.internet = rs.getBoolean("internet");
        this.television = rs.getBoolean("television");
        this.lave_linge = rs.getBoolean("lave_linge");
        this.date_debut = rs.getDate("date_debut");
        this.date_fin = rs.getDate("date_fin");
    }
    public Sejour(int id, String titre, String lieu, String description, int id_host, String URL_image, int note, int nombre_chambre, int type_logement, int capacity, int pension, boolean cuisine, boolean internet, boolean television, boolean lave_linge, Date date_debut, Date date_fin) {
        this.id = id;
        this.titre = titre;
        this.lieu = lieu;
        this.description = description;
        this.id_host = id_host;
        this.URL_image = URL_image;
        this.note = note;
        this.nombre_chambre = nombre_chambre;
        this.type_logement = type_logement;
        this.capacity = capacity;
        this.pension = pension;
        this.cuisine = cuisine;
        this.internet = internet;
        this.television = television;
        this.lave_linge = lave_linge;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getLieu() {
        return lieu;
    }

    public String getDescription() {
        return description;
    }

    public int getId_host() {
        return id_host;
    }

    public String getURL_image() {
        return URL_image;
    }

    public int getNote() {
        return note;
    }

    public int getNombre_chambre() {
        return nombre_chambre;
    }

    public int getType_logement() {
        return type_logement;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPension() {
        return pension;
    }

    public boolean isCuisine() {
        return cuisine;
    }

    public boolean isInternet() {
        return internet;
    }

    public boolean isTelevision() {
        return television;
    }

    public boolean isLave_linge() {
        return lave_linge;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    @Override
    public String toString() {
        return "Sejour{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", lieu='" + lieu + '\'' +
                ", description='" + description + '\'' +
                ", id_host=" + id_host +
                ", URL_image='" + URL_image + '\'' +
                ", note=" + note +
                ", nombre_chambre=" + nombre_chambre +
                ", type_logement=" + type_logement +
                ", capacity=" + capacity +
                ", pension=" + pension +
                ", cuisine=" + cuisine +
                ", internet=" + internet +
                ", television=" + television +
                ", lave_linge=" + lave_linge +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                '}';
    }
}
