package com.example.eventjinni.view.View.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "eventJinni.db";

    public DataBaseHelper(Context context) {
        super(context, DBNAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table user_registration(id INTEGER primary key autoincrement, name TEXT, number TEXT, email TEXT, password TEXT)");
        db.execSQL("create Table order_info(id INTEGER primary key autoincrement, service_name TEXT, provider_name TEXT, name TEXT, phone TEXT, address TEXT, date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists order_info");
    }

    public Boolean insertUserRegistrationData(String name, String number, String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("number", number);
        contentValues.put("email", email);
        contentValues.put("password", password);

        long result = myDB.insert("user_registration",null, contentValues);

        if (result == -1) return false;
        else
            return true;
    }

    public Boolean updateUserRegistrationData(String id, String name, String number, String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("number", number);
        contentValues.put("email", email);
        contentValues.put("password", password);

        Cursor cursor = myDB.rawQuery("Select * from user_registration where id = ?", new String[] {id});
        if(cursor.getCount() > 0){
            long result = myDB.update("user_registration", contentValues, "id=?", new String[] {id});

            if (result == -1) return false;
            else
                return true;
        }
        else {
            return false;
        }
    }

    public Boolean insertOrderInfo(String s_name, String p_name, String c_name, String phone, String address, String date){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("service_name",s_name);
        contentValues.put("provider_name",p_name);
        contentValues.put("name",c_name);
        contentValues.put("phone",phone);
        contentValues.put("address",address);
        contentValues.put("date",date);

        long result = myDb.insert("order_info", null, contentValues);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from order_info order by id desc", null);
        return cursor;
    }

    public Cursor getDataByID(String id){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from order_info where id= ?", new String[] {id});
        return cursor;
    }

    public Cursor getDataByEmail(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from user_registration where email= ?", new String[] {email});
        return cursor;
    }

    public int deleteUser(int id) {
        SQLiteDatabase myDb = this.getWritableDatabase();
        return myDb.delete("order_info", "id=?", new String[] {String.valueOf(id)});
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from user_registration where email = ?", new String[] {email});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkedEmailPassword(String email, String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from user_registration where email = ? and password = ? ", new String[] {email,password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
