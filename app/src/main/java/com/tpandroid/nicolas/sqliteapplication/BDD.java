package com.tpandroid.nicolas.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by nicolas on 20/08/14.
 */
public class BDD {
    BDDHelper helper; // Helper pour ouverture / création de la base
    SQLiteDatabase database; // Objet représentant la base de données

    public void open(Context activity){
        helper = new BDDHelper(activity);
        database = helper.getWritableDatabase();
    }


    public Cursor getInfos() {
        return database.rawQuery("SELECT _id, info FROM infos", null);
    }

    public long createInfo(String info) {
        ContentValues values = new ContentValues();
        values.putNull("_id");
        values.put("info", info);
        return database.insert("infos", null, values);
    }
}
