package com.example.MobileApp.Entities.Concretes;

import com.example.MobileApp.Entities.Abstracts.IEntity;

public class YdtSoruTuru implements IEntity {
    private int id;
    private String TurAdi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTurAdi() {
        return TurAdi;
    }

    public void setTurAdi(String turAdi) {
        TurAdi = turAdi;
    }

    public YdtSoruTuru() {
    }

    public YdtSoruTuru(int id, String turAdi) {
        this.id = id;
        TurAdi = turAdi;
    }
}
