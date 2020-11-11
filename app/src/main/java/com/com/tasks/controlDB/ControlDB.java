package com.com.tasks.controlDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Display;

import androidx.annotation.Nullable;

import com.com.tasks.Model.ModelDB;
import com.com.tasks.Utils.utils;

import java.util.ArrayList;

public class ControlDB extends SQLiteOpenHelper {

    public ControlDB(@Nullable Context context) {
        super(context, utils.DATABASE_NAME  , null, utils.V_databade);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String DATABASE_CREATE = "create table TASKS_DATA(_id integer primary key autoincrement, "
                + "tasktext text not null,"
                + "counter text not null "
                +");";

        String creatTable = " CREATE TABLE " + utils.TABLE_NAME
                + "("
                + utils.KEY_ID + " TEXT PRIMARY KEY ,"
                + utils.KEY_TASKS + " TEXT "
                + ")";

        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + utils.TABLE_NAME);
        onCreate(db);
    }

    public void addData(ModelDB modelDB) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(utils.KEY_TASKS, modelDB.getTasks_text());
        contentValues.put(utils.KEY_COUNTER,"0");
        database.insert(utils.TABLE_NAME, null, contentValues);
        database.close();
    }

    public ArrayList<ModelDB> getallData() {
        ArrayList<ModelDB> MmLIST = new ArrayList<>();
        SQLiteDatabase DATABASE = this.getReadableDatabase();
        String getdata = "SELECT * FROM " + utils.TABLE_NAME;
        Cursor cursor = DATABASE.rawQuery(getdata, null);

        if (cursor.moveToFirst()) {

            do {

                String taskss = cursor.getString(cursor.getColumnIndex(utils.KEY_TASKS));
                ModelDB modelDB = new ModelDB(taskss);
                MmLIST.add(modelDB);
            } while (cursor.moveToNext());

        }
        return MmLIST;
    }

    public void Delete_data()
    {
        SQLiteDatabase database=this.getWritableDatabase();
        database.delete("TASKS_DATA " ,null, null);
        database.execSQL("delete  from " +"TASKS_DATA " );
        database.close();

    }


}
