package psy.krupesh.lalu.grupee.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }
    //OPEN
    public DBAdapter openDB()
    {
        try {
            db=helper.getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    //CLOSE
    public void closeDB()
    {
        try {
            helper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //SAVE
    public long add(String time,String url)
    {
        try {
            ContentValues cv=new ContentValues();
            cv.put(Constants.TIME,time);
            cv.put(Constants.URL, url);

            db.insert(Constants.TB_NAME, Constants.ROW_ID, cv);

            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    //RETRIEVE
    public Cursor getDogs()
    {
        String[] columns={Constants.ROW_ID,Constants.TIME,Constants.URL};

        return db.query(Constants.TB_NAME,columns,null,null,null,null,null);
    }
}