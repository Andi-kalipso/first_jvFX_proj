package com.example.first_jvfx_proj.structClasses;

import com.example.first_jvfx_proj.Priority;
import com.example.first_jvfx_proj.ganeralTaskPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class buisnessMeetTask extends ganeralTaskPage {

    private String place;
    private List<String> partners = new ArrayList<String>();

    public buisnessMeetTask(String d, String t, Priority p, String pl, List<String> part) {
        super(d, t, p);
        this.place = pl;
        this.partners = part;
    }

    @Override
    public String toString(){                   //////////////////////////////////////////////////////////////дописать
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        buisnessMeetTask that = (buisnessMeetTask) o;
        return Objects.equals(place, that.place) && Objects.equals(partners, that.partners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), place, partners);
    }



}
