package com.example.test.Model;

public class Expense_Model {
    public String ID;

    public String getID() {
        return ID;
    }

    public String getExpSrc() {
        return ExpSrc;
    }

    public Double getExpVal() {
        return ExpVal;
    }

    public Integer getPrios() {
        return Prios;
    }

    public String ExpSrc;
    public Double ExpVal;
    public Integer Prios;

    public Expense_Model(String ID, String expSrc, Double expVal, Integer prios) {
        this.ID = ID;
        ExpSrc = expSrc;
        ExpVal = expVal;
        Prios = prios;
    }
}