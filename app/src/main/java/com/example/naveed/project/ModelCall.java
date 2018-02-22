package com.example.naveed.project;

/**
 * Created by Naveed on 2/19/2018.
 */

public class ModelCall {

   private  String Name,Date;

    public ModelCall(String name, String date) {
        Name = name;
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

}
