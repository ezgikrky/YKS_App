package com.example.MobileApp.DataAccess.Concretes.SQLite.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.MobileApp.DataAccess.Abstracts.ITytTuruDao;
import com.example.MobileApp.Entities.Concretes.TytSoruTuru;

import java.util.ArrayList;

public class SQLiteTytSoruTuruDao implements ITytTuruDao {

    private DataBaseConnection vt;

    public SQLiteTytSoruTuruDao(DataBaseConnection vt) {
        this.vt = vt;
    }



    @Override
    public ArrayList<TytSoruTuru> GetAll() {
        ArrayList<TytSoruTuru> GelirTuruList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM CozulenTuru",null);

        while (c.moveToNext()){
            TytSoruTuru gelirTuru=new TytSoruTuru(
                    c.getInt(c.getColumnIndex("TuruId")),
                    c.getString(c.getColumnIndex("turAdi"))
            );

            GelirTuruList.add(gelirTuru);
        }

        return GelirTuruList;
    }

    @Override
    public void Add(TytSoruTuru entity) {

        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("turAdi",entity.getTurAdi());


        dbx.insertOrThrow("CozulenSoruTuru",null,degerler);
        dbx.close();
    }

    @Override
    public void Update(TytSoruTuru entity) {

    }

    @Override
    public void Delete(TytSoruTuru entity) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("CozulenSoruTuru","Id?",new String[]{String.valueOf(entity.getId())});
        dbx.close();
    }


}
