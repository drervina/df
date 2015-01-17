package ir.drervina.dontforget;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DbClass extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "df.db";
    private static final String TABLE_NAME = "df";
    private static final String KEY_ID = "df_id";
    private static final String KEY_TITLE = "df_title";
    private static final String KEY_DESC = "df_desc";
    private static final String KEY_TIME = "df_time";
    private static final String KEY_DATE = "df_date";
    private static final String KEY_OTHER = "df_other";
    private static final String KEY_NEXT = "df_next";
    private static final String KEY_SUBJECT = "df_subject";
    private static final String KEY_MARKED = "df_marked";

    public DbClass(Context context) {

        super(context,DATABASE_NAME , null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE  TABLE  IF NOT EXISTS df (df_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , df_time INTEGER, df_date INTEGER, df_title VARCHAR, df_desc VARCHAR, df_other VARCHAR,df_subject VARCHAR,df_next INTEGER,df_marked BOOL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DbClass.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS df ");
        onCreate(db);
    }
    void addEntry(DF df) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TIME, df.getAdf_time());
        values.put(KEY_DATE, df.getAdf_date());
        values.put(KEY_TITLE, df.getAdf_title());
        values.put(KEY_DESC, df.getAdf_desc());
        values.put(KEY_OTHER, df.getAdf_other());
        values.put(KEY_NEXT, df.getAdf_next());
        values.put(KEY_SUBJECT, df.getAdf_subject());
        values.put(KEY_MARKED, df.getAdf_marked());


        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    DF getEntry(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {
                        KEY_ID,
                        KEY_TIME,
                        KEY_DATE,
                        KEY_TITLE,
                        KEY_DESC,
                        KEY_OTHER,
                        KEY_NEXT,
                        KEY_SUBJECT,
                        KEY_MARKED},KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DF df = new DF(cursor.getInt(0),
                cursor.getInt(1),
                cursor.getInt(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getInt(6),
                cursor.getString(7),
                cursor.getInt(8));

        return df;
    }
    public List<DF> getAllEntry() {
        List<DF> entryList = new ArrayList<DF>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                DF contact = new DF();
                contact.setAdf_id(cursor.getInt(0));
                contact.setAdf_time(cursor.getInt(1));
                contact.setAdf_date(cursor.getInt(2));
                contact.setAdf_title(cursor.getString(3));
                contact.setAdf_desc(cursor.getString(4));
                contact.setAdf_other(cursor.getString(5));
                contact.setAdf_next(cursor.getInt(6));
                contact.setAdf_subject(cursor.getString(7));
                contact.setAdf_marked(cursor.getInt(8));


                entryList.add(contact);
            } while (cursor.moveToNext());
        }


        return entryList;
    }
    public int updateEntry(DF df) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TIME, df.getAdf_time());
        values.put(KEY_DATE, df.getAdf_date());
        values.put(KEY_TITLE, df.getAdf_title());
        values.put(KEY_DESC, df.getAdf_desc());
        values.put(KEY_OTHER, df.getAdf_other());
        values.put(KEY_NEXT, df.getAdf_next());
        values.put(KEY_SUBJECT, df.getAdf_subject());
        values.put(KEY_MARKED, df.getAdf_marked());


        return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[] { String.valueOf(df.getAdf_id()) });
    }
    public void deleteEntry(DF df) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?",
                new String[] { String.valueOf(df.getAdf_id()) });
        db.close();
    }



}
