package com.example.MobileApp.DataAccess.Concretes.SQLite.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseConnection extends SQLiteOpenHelper {
    public DataBaseConnection(@Nullable Context context) {
        super(context, "YksTakibi3", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"CozulenOdev\" (\n" +
                "\t\"gelirGiderId\"\tINTEGER,\n" +
                "\t\"tutar\"\tTEXT,\n" +
                "\t\"tur\"\tTEXT,\n" +
                "\t\"detay\"\tTEXT,\n" +
                "\t\"time\"\tINTEGER,\n" +
                "\t\"hesap\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"gelirGiderId\")\n" +
                ");");

        db.execSQL("CREATE TABLE \"CozulenTuru\" (\n" +
                "\t\"TuruId\"\tINTEGER,\n" +
                "\t\"turAdi\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"TuruId\")\n" +
                ");");

         db.execSQL("CREATE TABLE \"OdevTuru\" (\n" +
               "\t\"TuruId\"\tINTEGER,\n" +
               "\t\"turAdi\"\tTEXT,\n" +
               "\tPRIMARY KEY(\"TuruId\" )\n" +
                ");");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS GelirGider");
        onCreate(db);
    }
}
