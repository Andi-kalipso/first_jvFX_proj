package com.example.first_jvfx_proj;


import javafx.event.ActionEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.lang.Comparable;

public abstract class ganeralTaskPage implements Comparable<ganeralTaskPage>{

    /////////////////////////FILDS///////////////////////////////////////
    private String date;
    public  Date dateNeed;
    private String time;
    private Priority priorityObj;



    ///////////////////////////SET-GET////////////////////////////////////
    public Date getDate(){
        return dateNeed;
    }
    public void setDate(Date newDate){
        dateNeed = newDate;
    }


    public Priority getPrior(){
        return priorityObj;
    }

    public void setPrior(Priority newPrior){
        priorityObj = newPrior;
    }
    ///////////////////////////SET-GET/////////////////////////////////////

    public ganeralTaskPage(String d, String t, Priority p){     //constructor
        this.date = d;
        this.time = t;
        this.priorityObj = p;
        try {
            createNormalDateAndTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    private void createNormalDateAndTime() throws ParseException {
        char a = time.charAt(0);
        String sh = "";
        String sm = "";
        int i = 0;
        while (a != ':'){
            i++;
            sh = sh + a;
            a = time.charAt(i);
        }
        a = time.charAt(i+1);
        sm = sm + a;
        a = time.charAt(i+2);
        sm = sm + a;

        int h = Integer.parseInt(sh);
        int m = Integer.parseInt(sm);
        dateNeed = new SimpleDateFormat("yyy-MM-dd").parse(date);
        dateNeed.setHours(h);
        dateNeed.setMinutes(m);
    }


    public String getsPrior(){

        String prior = String.valueOf(getPrior().ordinal());
        String per = null;

        switch (prior){
            case "0":
                per = "не важна";

                break;
            case "1":
                per = "обычная";

                break;
            case "2":
                per = "важна";

                break;
            case "3":
                per = "крайне важна";

                break;
        }
        return per;
    }
    ////////////////////////Overrides///////////////////////////////////////
    @Override
    public String toString(){
        String stroka = null;
        stroka = this.dateNeed.toString() + "#" + priorityObj.ordinal() + "\n";
        return stroka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ganeralTaskPage that = (ganeralTaskPage) o;
        return Objects.equals(date, that.date) && Objects.equals(time, that.time) && priorityObj == that.priorityObj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time, priorityObj);
    }

    @Override
    public int compareTo(ganeralTaskPage g0){

        if(dateNeed == g0.getDate() && priorityObj == g0.getPrior()){
                return 0;
        }
        if(dateNeed.before(g0.getDate())){
            return -1;
        }
        return 1;
    }
    ////////////////////////Overrides///////////////////////////////////////
}