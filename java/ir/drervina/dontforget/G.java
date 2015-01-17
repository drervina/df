package ir.drervina.dontforget;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;

import static android.database.sqlite.SQLiteDatabase.*;

public class G extends Application {

    /*
    public static SQLiteDatabase database;
    public static final String SDCARD_DIR = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static final String DB_DIR = SDCARD_DIR + "/DontForget/";


    @Override
    public void onCreate() {
        super.onCreate();
        File file = new File(DB_DIR);
        file.mkdirs();
        database = SQLiteDatabase.openOrCreateDatabase(/appdb.sqlite, null);
        }
        */
    /*
    public static Context context;
    public static SQLiteDatabase database;
    public static final String DIR_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String DIR_DATABASE = DIR_SDCARD + "/database-test/";


    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();

        new File(DIR_DATABASE).mkdirs();

        database = SQLiteDatabase.openOrCreateDatabase(DIR_DATABASE + "/database.sqlite", null);


    }
    */
}







