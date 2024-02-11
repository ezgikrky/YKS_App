package com.example.MobileApp.DataAccess.Concretes.TestDB;

import com.example.MobileApp.DataAccess.Abstracts.ICozulenOdevDao;
import com.example.MobileApp.Entities.Concretes.CozulenOdev;

import java.util.ArrayList;

public class CozulenOdevDao implements ICozulenOdevDao {
    ArrayList<CozulenOdev> GelirGiderList=new ArrayList<>();


    @Override
    public ArrayList<CozulenOdev> GetAll() {

       // GelirGiderList.add(new GelirGİder(500,-1,"Lcw mont aldım",));
        //GelirGiderList.add(new GelirGİder(1500,-1,"Kira","12.07.2022"));
        //GelirGiderList.add(new GelirGİder(5000,1,"Maaş","12.07.2022"));
        //GelirGiderList.add(new GelirGİder(300,-1,"Lcw mont aldım",".07.2022"));
        //GelirGiderList.add(new GelirGİder(100,-1,"Lcw mont aldım","12.07.2022"));
        //GelirGiderList.add(new GelirGİder(50,1,"market","12.07.2022"));

        return GelirGiderList;
    }

    @Override
    public void Add(CozulenOdev entity) {
        GelirGiderList.add(entity);
    }

    @Override
    public void Update(CozulenOdev entity) {

    }

    @Override
    public void Delete(CozulenOdev entity) {

    }
}
