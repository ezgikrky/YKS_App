package com.example.MobileApp.DataAccess.Concretes.SQLite.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.MobileApp.DataAccess.Abstracts.IAytTuruDao;
import com.example.MobileApp.Entities.Concretes.AytvSoruTuru;

import java.util.ArrayList;

public class SQLiteAytSoruTuruDao implements IAytTuruDao {
    private DataBaseConnection vt;

    public SQLiteAytSoruTuruDao(DataBaseConnection vt) {
        this.vt = vt;
    }

    @Override
    public ArrayList<AytvSoruTuru> GetAll() {

        ArrayList<AytvSoruTuru> OdevTuruList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM OdevTuru",null);



        while (c.moveToNext()){
            AytvSoruTuru giderTuru=new AytvSoruTuru(
                    c.getInt(c.getColumnIndex("TuruId")),
                    c.getString(c.getColumnIndex("turAdi"))
            );

            OdevTuruList.add(giderTuru);
        }


        return OdevTuruList;
    }

    @Override
    public void Add(AytvSoruTuru entity) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("turAdi",entity.getOdevTurAdi());


        dbx.insertOrThrow("OdevSoruTuru",null,degerler);
        dbx.close();
    }

    @Override
    public void Update(AytvSoruTuru entity) {

    }

    @Override
    public void Delete(AytvSoruTuru entity) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("OdevSoruTuru","Id?",new String[]{String.valueOf(entity.getId())});
        dbx.close();
    }
}
