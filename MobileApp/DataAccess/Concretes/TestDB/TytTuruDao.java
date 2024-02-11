package com.example.MobileApp.DataAccess.Concretes.TestDB;

import com.example.MobileApp.DataAccess.Abstracts.ITytTuruDao;
import com.example.MobileApp.Entities.Concretes.TytSoruTuru;

import java.util.ArrayList;

public class TytTuruDao implements ITytTuruDao {
    ArrayList<TytSoruTuru> GelirTuruList=new ArrayList<>();

    @Override
    public ArrayList<TytSoruTuru> GetAll() {
        GelirTuruList.add(new TytSoruTuru(1,"Türkçe"));
        GelirTuruList.add(new TytSoruTuru(2,"Matematik"));
        GelirTuruList.add(new TytSoruTuru(3,"Fizik"));
        GelirTuruList.add(new TytSoruTuru(4,"Kimya"));
        GelirTuruList.add(new TytSoruTuru(4,"Biyoloji"));
        GelirTuruList.add(new TytSoruTuru(4,"Tarih"));
        GelirTuruList.add(new TytSoruTuru(4,"Coğrafya"));
        GelirTuruList.add(new TytSoruTuru(4,"Din Kültürü"));
        GelirTuruList.add(new TytSoruTuru(4,"Felsefe"));
        GelirTuruList.add(new TytSoruTuru(4,"Diğer"));





        return GelirTuruList;
    }

    @Override
    public void Add(TytSoruTuru entity) {
    }

    @Override
    public void Update(TytSoruTuru entity) {

    }

    @Override
    public void Delete(TytSoruTuru entity) {

    }
}
