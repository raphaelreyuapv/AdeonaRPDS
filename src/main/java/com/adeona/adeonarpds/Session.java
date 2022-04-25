package com.adeona.adeonarpds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Session {

    static int id_logged = 0;
    static String name_logged = "";
    static String desc_logged = "";
    static int type_logged = 0;
    static List<String> urls_img_logged;

    static List<Sejour> sejourOffer = new ArrayList<>();
    static List<Integer> sejourOfferTravelerID= new ArrayList<>();

    static String chat_history = "";
    public static void Login(String name){
        User logged_user = SearchHelper.getUser(name);
        id_logged = logged_user.getId();
        name_logged = logged_user.getName();
        desc_logged = logged_user.getDesc();
        type_logged = logged_user.getType();
        urls_img_logged = logged_user.getUrls();
    }
    public static void setChatHistory(String set){
        chat_history = set;
    }

    public static void addSejourOffer(Sejour nSejourOffer, int nOfferTravelerID){

        sejourOffer.add(nSejourOffer);
        sejourOfferTravelerID.add(nOfferTravelerID);

    }

}
