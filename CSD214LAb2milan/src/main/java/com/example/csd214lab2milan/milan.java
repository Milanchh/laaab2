package com.example.csd214lab2milan;


public class milan {
    private int ID;
    private String NAME;
    private String EMAIL;
    private String ADRRESS;


    public milan(int ID, String NAME, String EMAIL, String ADRRESS) {
        this.ID = ID;
        this.NAME = NAME;
        this.EMAIL = EMAIL;
        this.ADRRESS = ADRRESS;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getADRRESS() {
        return ADRRESS;
    }

    public void setADRRESS(String ADRRESS) {
        this.ADRRESS = ADRRESS;
    }
}