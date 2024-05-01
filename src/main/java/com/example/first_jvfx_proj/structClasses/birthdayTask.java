package com.example.first_jvfx_proj.structClasses;

import com.example.first_jvfx_proj.Priority;
import com.example.first_jvfx_proj.ganeralTaskPage;

import java.util.Objects;

public class birthdayTask extends ganeralTaskPage{

    private String fio;

    public birthdayTask(String d, String t, Priority p, String fio) {
        super(d,t,p);
        this.fio = fio;
    }

    @Override
    public String toString(){
        return fio + "#" + dateNeed.toString() + "#" + getsPrior();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        birthdayTask that = (birthdayTask) o;
        return Objects.equals(fio, that.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fio);
    }

}
