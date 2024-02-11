package com.example.MobileApp.Entities.Concretes;

import com.example.MobileApp.Entities.Abstracts.IEntity;

public class AytvSoruTuru implements IEntity {
    private int id;
    private String OdevTurAdi;


    public AytvSoruTuru() {
    }

    public AytvSoruTuru(int id, String odevTurAdi) {
        this.id = id;
        OdevTurAdi = odevTurAdi;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOdevTurAdi() {
        return OdevTurAdi;
    }

    public void setOdevTurAdi(String odevTurAdi) {
        OdevTurAdi = odevTurAdi;
    }
}
