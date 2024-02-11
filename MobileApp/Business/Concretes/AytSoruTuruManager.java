package com.example.MobileApp.Business.Concretes;

import com.example.MobileApp.Business.Abstracts.IAytSoruTuruService;
import com.example.MobileApp.DataAccess.Abstracts.IAytTuruDao;
import com.example.MobileApp.Entities.Concretes.AytvSoruTuru;

import java.util.ArrayList;

public class AytSoruTuruManager implements IAytSoruTuruService {
    IAytTuruDao _IOdevTuruDao;

    public AytSoruTuruManager(IAytTuruDao _IOdevTuruDao) {
        this._IOdevTuruDao = _IOdevTuruDao;
    }

    @Override
    public ArrayList<AytvSoruTuru> GetAll() {
        return _IOdevTuruDao.GetAll();
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
