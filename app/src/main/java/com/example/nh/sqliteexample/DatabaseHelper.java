package com.example.nh.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String  DATABASE_NAME = "Shops";
    private static final int DATABASE_VERSION = 2;

    private static final String STORE_TABLE = "stores";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "descreption";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("constructor","constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStatement = "CREATE TABLE "+STORE_TABLE+"("+
                KEY_ID+" INTEGER PRIMARY KEY,"+
                KEY_NAME+" VARCHAR(100),"+
                KEY_DESCRIPTION+" VARCHAR(255))";
        db.execSQL(createStatement);
        Log.e("onCreate","onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropStatement = "DROP TABLE IF EXISTS "+STORE_TABLE;
        db.execSQL(dropStatement);
        onCreate(db);
        Log.e("onUpgrade","onUpgrade");
    }

    public void addStore(Store store){
        Log.e("addStore","addStore");
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,store.getId());
        values.put(KEY_NAME,store.getName());
        values.put(KEY_DESCRIPTION,store.getDescreption());
        db.insert(STORE_TABLE,null,values);
        db.close();
    }

    public ArrayList<Store> getAllStores(){
        ArrayList<Store> allStores = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+STORE_TABLE,null);
        while (cursor.moveToNext()){
            Store store = new Store(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2));
            allStores.add(store);
        }
        cursor.close();
        db.close();
        return allStores;
    }
}
