package com.example.MobileApp.Business.Concretes;

import com.example.MobileApp.Business.Abstracts.ITytSoruTuruService;
import com.example.MobileApp.DataAccess.Abstracts.ITytTuruDao;
import com.example.MobileApp.Entities.Concretes.TytSoruTuru;

import java.util.ArrayList;

public class TytSoruTuruManager implements ITytSoruTuruService {
    ITytTuruDao _CozulenTuruDao;

    public TytSoruTuruManager(ITytTuruDao _TurDao) {
        this._CozulenTuruDao = _TurDao;
    }

    @Override
    public ArrayList<TytSoruTuru> GetAll() {
        return _CozulenTuruDao.GetAll();
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
