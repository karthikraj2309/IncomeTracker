package com.example.test.Model;

public class Income_Model {
    public String ID;
    public String IncSrc;
    public Double IncVal;

    public Income_Model(String ID, String incSrc, Double incVal) {
        this.ID = ID;
        IncSrc = incSrc;
        IncVal = incVal;
    }

    public String getID() {
        return ID;
    }

    public String getIncSrc() {
        return IncSrc;
    }

    public Double getIncVal() {
        return IncVal;
    }

}