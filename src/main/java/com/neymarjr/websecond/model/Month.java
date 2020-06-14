package com.neymarjr.websecond.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/*
 *created 24/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
public class Month implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;

    private int months;


    private String cm;

    public Month(int months, String cm) {
        this.months = months;
        this.cm = cm;

    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }
}
