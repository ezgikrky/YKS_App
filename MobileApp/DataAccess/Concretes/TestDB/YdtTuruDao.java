package com.example.MobileApp.DataAccess.Concretes.TestDB;

import com.example.MobileApp.DataAccess.Abstracts.IYdtTuruDao;
import com.example.MobileApp.Entities.Concretes.YdtSoruTuru;

import java.util.ArrayList;

public class YdtTuruDao implements IYdtTuruDao {
    ArrayList<YdtSoruTuru> YdtTuruList =new ArrayList<>();

    @Override
    public ArrayList<YdtSoruTuru> GetAll() {
        YdtTuruList.add(new YdtSoruTuru(1,"İngilizce"));
        YdtTuruList.add(new YdtSoruTuru(2,"Almanca"));
        YdtTuruList.add(new YdtSoruTuru(3,"Fransızca"));
        YdtTuruList.add(new YdtSoruTuru(4,"Rusça"));
        YdtTuruList.add(new YdtSoruTuru(5,"Arapça"));


        return YdtTuruList;
    }

    @Override
    public void Add(YdtSoruTuru entity) {

    }

    @Override
    public void Update(YdtSoruTuru entity) {

    }

    @Override
    public void Delete(YdtSoruTuru entity) {

    }


}
