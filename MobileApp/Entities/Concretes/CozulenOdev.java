package com.example.MobileApp.Entities.Concretes;

import com.example.MobileApp.Entities.Abstracts.IEntity;

public class CozulenOdev implements IEntity {
    //tarih tür tutar  detay
    private int id;
    private double tutar ;
    private int tür;
    private String detay;
    private int time;

    private int sınav;

    public CozulenOdev() {
    }

    public CozulenOdev(int id, double tutar, int tür, String detay, int time, int hesap) {
        this.id = id;
        this.tutar = tutar;
        this.tür = tür;
        this.detay = detay;
        this.time = time;

        this.sınav = hesap;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public int getTür() {
        return tür;
    }

    public void setTür(int tür) {
        this.tür = tür;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }



    public int getSınav() {
        return sınav;
    }

    public void setSınav(int sınav) {
        this.sınav = sınav;
    }
}
