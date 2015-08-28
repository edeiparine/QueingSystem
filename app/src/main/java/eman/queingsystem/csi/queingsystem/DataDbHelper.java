package eman.queingsystem.csi.queingsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by csi on 27/8/15.
 */
public class DataDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "queingsystem.db";
    private static final String TABLE_NAME = "user";
    private static final String USER_NAME = "name";
    private static final String USER_EMAIL = "email";

    public DataDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_DATABASE = "CREATE TABLE " + TABLE_NAME + " (" +
                USER_NAME + " TEXT NOT NULL," +
                USER_EMAIL + " TEXT NOT NULL" +
                " );";

        db.execSQL(SQL_CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
