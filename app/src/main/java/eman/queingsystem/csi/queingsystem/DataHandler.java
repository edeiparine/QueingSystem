package eman.queingsystem.csi.queingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by csi on 27/8/15.
 */
public class DataHandler {

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String TABLE_NAME = "mytable";
    public static final String DATABASE_NAME = "mydatabase.db";
    public static final int DATABASE_VERSION = 1;

    Context context;
    DataBaseHelper dataBaseHelper;
    public SQLiteDatabase db;

    public DataHandler(Context context) {
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context);
    }

    public DataHandler open() {
        db = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dataBaseHelper.close();
    }

    public long insertData(String name, String email) {
        ContentValues content = new ContentValues();
        content.put(NAME, name);
        content.put(EMAIL, email);
        return db.insert(TABLE_NAME, null, content);
    }

    public Cursor returnData() {
        return db.query(
                TABLE_NAME,
                new String[]{NAME, EMAIL},
                null,
                null,
                null,
                null,
                null);
    }

    private static class DataBaseHelper extends SQLiteOpenHelper {

        public DataBaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                    NAME + " TEXT NOT NULL," +
                    EMAIL + " TEXT NOT NULL" +
                    " );";

            try {
            } catch (SQLiteException e) {
                e.printStackTrace();
            }

            db.execSQL(SQL_CREATE_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
