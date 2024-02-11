package com.example.MobileApp.Business.Abstracts;


import com.example.MobileApp.Entities.Concretes.CozulenOdev;

import java.util.ArrayList;

public interface ICozulenOdevService {
    ArrayList<CozulenOdev> GetAll();
    void Add(CozulenOdev gelirGİder);
    void Delete(CozulenOdev gelirGİder);
    void Update(CozulenOdev gelirGİder);
}
