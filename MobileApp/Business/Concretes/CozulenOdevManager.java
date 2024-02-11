package com.example.MobileApp.Business.Concretes;



import com.example.MobileApp.Business.Abstracts.ICozulenOdevService;
import com.example.MobileApp.DataAccess.Abstracts.ICozulenOdevDao;
import com.example.MobileApp.Entities.Concretes.CozulenOdev;

import java.util.ArrayList;

public class CozulenOdevManager implements ICozulenOdevService {
    ICozulenOdevDao _CozulenSoruDao;

    public CozulenOdevManager(ICozulenOdevDao _CozulenSoruDao) {
        this._CozulenSoruDao = _CozulenSoruDao;
    }

    @Override
    public ArrayList<CozulenOdev> GetAll( ) {
        return _CozulenSoruDao.GetAll();
    }

    @Override
    public void Add(CozulenOdev entity) {
        _CozulenSoruDao.Add(entity);
    }

    @Override
    public void Update(CozulenOdev entity) {

    }

    @Override
    public void Delete(CozulenOdev entity) {

    }
}
