package com.example.MobileApp.DataAccess.Concretes.TestDB;

import com.example.MobileApp.DataAccess.Abstracts.IAytTuruDao;
import com.example.MobileApp.Entities.Concretes.AytvSoruTuru;

import java.util.ArrayList;

public class AytTuruDao implements IAytTuruDao {
private ArrayList<AytvSoruTuru> GiderTuruList=new ArrayList<>();

    @Override
    public ArrayList<AytvSoruTuru> GetAll() {

        GiderTuruList.add(new AytvSoruTuru(1,"Fizik"));
        GiderTuruList.add(new AytvSoruTuru(2,"Kimya"));
        GiderTuruList.add(new AytvSoruTuru(3,"Biyoloji"));
        GiderTuruList.add(new AytvSoruTuru(4,"Geometri"));
        GiderTuruList.add(new AytvSoruTuru(4,"Matematik"));
        GiderTuruList.add(new AytvSoruTuru(4,"Edebiyat"));
        GiderTuruList.add(new AytvSoruTuru(4,"Coğrafya"));
        GiderTuruList.add(new AytvSoruTuru(4,"Tarih"));
        GiderTuruList.add(new AytvSoruTuru(4,"Felsefe"));
        GiderTuruList.add(new AytvSoruTuru(4,"Din Kültürü"));
        GiderTuruList.add(new AytvSoruTuru(4,"Diğer"));



        return GiderTuruList;
    }

    @Override
    public void Add(AytvSoruTuru entity) {

    }

    @Override
    public void Update(AytvSoruTuru entity) {

    }

    @Override
    public void Delete(AytvSoruTuru entity) {

    }
}
