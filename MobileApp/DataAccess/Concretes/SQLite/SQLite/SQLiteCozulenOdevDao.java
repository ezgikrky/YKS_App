package com.example.MobileApp.DataAccess.Concretes.SQLite.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.MobileApp.DataAccess.Abstracts.ICozulenOdevDao;
import com.example.MobileApp.Entities.Concretes.CozulenOdev;

import java.util.ArrayList;

public class SQLiteCozulenOdevDao implements ICozulenOdevDao {
    private DataBaseConnection vt;

    public SQLiteCozulenOdevDao(DataBaseConnection vt) {
        this.vt = vt;
    }

    @Override
    public ArrayList<CozulenOdev> GetAll() {
        ArrayList<CozulenOdev> GelirGiderList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM CozulenOdev",null);

        while (c.moveToNext()){
            CozulenOdev gelirGider=new CozulenOdev(
                    c.getInt(c.getColumnIndex("gelirGiderId"))
                    ,Double.valueOf(c.getString(c.getColumnIndex("tutar"))),
                    c.getInt(c.getColumnIndex("tur")),
                    c.getString(c.getColumnIndex("detay")),
                   c.getInt(c.getColumnIndex("time")),
                    c.getInt(c.getColumnIndex("hesap")));

            GelirGiderList.add(gelirGider);
        }

        return GelirGiderList;
    }

    @Override
    public void Add(CozulenOdev entity) {

        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("tutar",entity.getTutar());
        degerler.put("tur",entity.getTür());
        degerler.put("detay",entity.getDetay());
         degerler.put("time",entity.getTime());
        degerler.put("hesap",entity.getSınav());

        dbx.insertOrThrow("CozulenOdev",null,degerler);
        dbx.close();

    }

    @Override
    public void Update(CozulenOdev entity) {

    }

    @Override
    public void Delete(CozulenOdev entity) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("CozulenOdev","Id?",new String[]{String.valueOf(entity.getId())});
        dbx.close();

    }
}
