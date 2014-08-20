package com.tpandroid.nicolas.sqliteapplication;

import android.content.Context;
import android.database.sqlite.*;

/**
 * Created by nicolas on 20/08/14.
 */
public class BDDHelper extends SQLiteOpenHelper {

    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE infos (_id INTEGER PRIMARY KEY AUTOINCREMENT, info TEXT NOT NULL)");
        db.execSQL("INSERT INTO infos VALUES (1, 'lundi')");
        db.execSQL("INSERT INTO infos VALUES (2, 'mardi')");
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public BDDHelper(Context context) {
        super(context, "infos.db", null, 1);
    }
}
