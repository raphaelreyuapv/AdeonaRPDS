package com.adeona.adeonarpds;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation {

    private int id;
    private int id_sejour;
    private int host_id;
    private int client_id;
    private Date date_debut;
    private Date date_fin;

    public Reservation(ResultSet rs) throws SQLException {
            this.id = rs.getInt("id");
            this.id_sejour = rs.getInt("id_sejour");
            this.host_id = rs.getInt("host_id");
            this.client_id = rs.getInt("client_id");
            this.date_debut = rs.getDate("date_debut");
            this.date_fin = rs.getDate("date_fin");

    }

    public Reservation(int id, int id_sejour, int host_id, int client_id, Date date_debut, Date date_fin) {
        this.id = id;
        this.id_sejour = id_sejour;
        this.host_id = host_id;
        this.client_id = client_id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public int getId_sejour() {
        return id_sejour;
    }

    public int getHost_id() {
        return host_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", id_sejour=" + id_sejour +
                ", host_id=" + host_id +
                ", client_id=" + client_id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                '}';
    }

}
