package com.example.MobileApp.Business.Concretes;

import com.example.MobileApp.Business.Abstracts.IYdtSoruTuruService;
import com.example.MobileApp.DataAccess.Abstracts.IYdtTuruDao;
import com.example.MobileApp.Entities.Concretes.YdtSoruTuru;

import java.util.ArrayList;

public class YdtSoruTuruManager implements IYdtSoruTuruService {
    IYdtTuruDao _ydtTuruDao;

    public YdtSoruTuruManager(IYdtTuruDao _TurDao) {
        this._ydtTuruDao = _TurDao;
    }
    @Override
    public ArrayList<YdtSoruTuru> GetAll() {
        return _ydtTuruDao.GetAll();
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
