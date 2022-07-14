package com.example.requestsqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Studentsmark.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Subject";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SUBJECTNAME = "SubjectName";
    private static final String COLUMN_MAXMARK = "MAXMARK";



    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
       String query = "CREATE TABLE " + TABLE_NAME +
                       " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                       COLUMN_SUBJECTNAME + " TEXT, " +
                       COLUMN_MAXMARK + " TEXT); ";
       DB.execSQL(query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(DB);


    }




    public void Add(String SubjectName, String MaxMark){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_SUBJECTNAME,SubjectName);
        cv.put(COLUMN_MAXMARK,MaxMark);
       long result = db.insert(TABLE_NAME,null,cv);
       if (result == -1){
           Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
       }
    }

    Cursor display(){
        String query = " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }

}
