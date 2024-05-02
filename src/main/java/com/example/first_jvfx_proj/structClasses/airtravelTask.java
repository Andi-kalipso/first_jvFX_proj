package com.example.first_jvfx_proj.structClasses;

import com.example.first_jvfx_proj.Priority;
import com.example.first_jvfx_proj.ganeralTaskPage;

import java.util.Objects;

public class airtravelTask extends ganeralTaskPage {

    private String airportFROM;
    private String airportIN;

    private String timeOfPlane;

    public airtravelTask(String d, String t, Priority p, String aFrom, String aIn, String timOP) {
        super(d, t, p);
        this.airportFROM = aFrom;
        this.airportIN = aIn;
        this.timeOfPlane = timOP;
    }




    @Override
    public String toString(){
        return airportFROM + "-->" + airportIN + "-->" + timeOfPlane + "#" + dateNeed.toString() + "#" + getsPrior();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        airtravelTask that = (airtravelTask) o;
        return Objects.equals(airportFROM, that.airportFROM) && Objects.equals(airportIN, that.airportIN) && Objects.equals(timeOfPlane, that.timeOfPlane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), airportFROM, airportIN, timeOfPlane);
    }



}