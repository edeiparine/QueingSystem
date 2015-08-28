package eman.queingsystem.csi.queingsystem.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import eman.queingsystem.csi.queingsystem.DataDbHelper;
import eman.queingsystem.csi.queingsystem.DataHandler;

/**
 * Created by csi on 27/8/15.
 */
public class TestDb extends AndroidTestCase {

    public static final String LOG_TAG = TestDb.class.getSimpleName();

    public void setUp() {
        deleteTheDatabase();
    }

    void deleteTheDatabase() {
        mContext.deleteDatabase(DataHandler.DATABASE_NAME);
    }

    public void testCreateDb() throws Throwable {
        mContext.deleteDatabase(DataHandler.DATABASE_NAME);

        SQLiteDatabase db = new DataDbHelper(
                this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());

        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        assertTrue("Error: This means that the database has not been created correctly", cursor.moveToFirst());

    }
}
