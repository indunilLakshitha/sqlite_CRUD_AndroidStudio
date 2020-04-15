package com.indunil.sqlitecrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    private static final String DTABASE_NAME="test_DB";
    private static final int DTABASE_VERSION=1;
    private  String queryToCreateDatabase="create table test_TB (ID INTEGER PRIMARY KEY AUTOINCREMENT"+
            ",Name VARCHAR(255),Mobile VARCHAR(255),Email VARCHAR(255),Address VARCHAR(255))";
    Context context;
    public DB(Context context) {
        super(context, DTABASE_NAME, null, DTABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try
        {
            db.execSQL(queryToCreateDatabase);
            Toast.makeText(context,"table created",Toast.LENGTH_LONG).show();

        }
        catch (Exception e)
        {
            Toast.makeText(context,"error making table",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
