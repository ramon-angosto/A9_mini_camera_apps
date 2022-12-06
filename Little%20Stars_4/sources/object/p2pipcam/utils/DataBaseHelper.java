package object.p2pipcam.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_ALARMLOG_TABLE = "create table alarmlog(id integer primary key autoincrement, did text not null, content text not null, pushuuid text not null, createtime text not null, user text , logstatues integer);";
    private static final String CREATE_FIRSTPIC_TABLE = "create table firstpic(id integer primary key autoincrement,did text not null, filepath text not null)";
    private static final String CREATE_STUDENT_TABLE = "create table cameralist (id integer primary key autoincrement, name text not null, did text not null, user text not null,pwd text);";
    private static final String CREATE_VIDEO_PICTURE_TABLE = "create table cameravidpic(id integer primary key autoincrement, did text not null, filepath text not null, createtime text not null, type text not null);";
    private static final String DATABASE_ALARMLOG_TABLE = "alarmlog";
    private static final String DATABASE_FIRSTPIC_TABLE = "firstpic";
    private static final String DATABASE_NAME = "p2p_camera_database";
    private static final String DATABASE_TABLE = "cameralist";
    private static final int DATABASE_VERSION = 6;
    private static final String DATABASW_VIDEOPICTURE_TABLE = "cameravidpic";
    public static final String KEY_ALARMLOG_CONTENT = "content";
    public static final String KEY_CREATETIME = "createtime";
    public static final String KEY_DID = "did";
    public static final String KEY_FILEPATH = "filepath";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PWD = "pwd";
    public static final String KEY_STATUS = "logstatues";
    public static final String KEY_TYPE = "type";
    public static final String KEY_USER = "user";
    public static final String KEY_UUID = "pushuuid";
    public static final String TYPE_PICTURE = "picture";
    public static final String TYPE_VIDEO = "video";
    private static SQLiteDatabase db;
    private static DataBaseHelper dbHelper;
    private String TAG = "DataBaseHelper";
    private Context context;

    private DataBaseHelper(Context context2) {
        super(context2, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 6);
    }

    public static DataBaseHelper getInstance(Context context2) {
        if (dbHelper == null) {
            dbHelper = new DataBaseHelper(context2);
            db = dbHelper.getWritableDatabase();
            Log.e(DataBaseHelper.class.getSimpleName(), "create database");
        }
        return dbHelper;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.i(this.TAG, "Creating student_table: create table cameralist (id integer primary key autoincrement, name text not null, did text not null, user text not null,pwd text);");
        Log.i(this.TAG, "Creating Video_Picture_Table: create table cameravidpic(id integer primary key autoincrement, did text not null, filepath text not null, createtime text not null, type text not null);");
        Log.i(this.TAG, "Creating alarmlog_table: create table alarmlog(id integer primary key autoincrement, did text not null, content text not null, pushuuid text not null, createtime text not null, user text , logstatues integer);");
        Log.i(this.TAG, "Creating Firstpic_tablecreate table firstpic(id integer primary key autoincrement,did text not null, filepath text not null)");
        sQLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
        sQLiteDatabase.execSQL(CREATE_VIDEO_PICTURE_TABLE);
        sQLiteDatabase.execSQL(CREATE_ALARMLOG_TABLE);
        sQLiteDatabase.execSQL(CREATE_FIRSTPIC_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cameralist");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cameravidpic");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS alarmlog");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS firstpic");
            onCreate(sQLiteDatabase);
        }
    }

    public void close() {
        Log.e(DataBaseHelper.class.getSimpleName(), "close database");
        SQLiteDatabase sQLiteDatabase = db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        dbHelper = null;
        db = null;
    }

    public long createCamera(String str, String str2, String str3, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, str);
        contentValues.put(KEY_DID, str2);
        contentValues.put(KEY_USER, str3);
        contentValues.put(KEY_PWD, str4);
        return db.insert(DATABASE_TABLE, (String) null, contentValues);
    }

    public boolean deleteCamera(long j) {
        SQLiteDatabase sQLiteDatabase = db;
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(j);
        return sQLiteDatabase.delete(DATABASE_TABLE, sb.toString(), (String[]) null) > 0;
    }

    public boolean deleteCamera(String str) {
        SQLiteDatabase sQLiteDatabase = db;
        StringBuilder sb = new StringBuilder();
        sb.append("did='");
        sb.append(str);
        sb.append("'");
        return sQLiteDatabase.delete(DATABASE_TABLE, sb.toString(), (String[]) null) > 0;
    }

    public Cursor fetchAllCameras() {
        return db.query(DATABASE_TABLE, new String[]{KEY_ID, KEY_NAME, KEY_DID, KEY_USER, KEY_PWD}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    public Cursor fetchCamera(long j) throws SQLException {
        SQLiteDatabase sQLiteDatabase = db;
        String[] strArr = {KEY_ID, KEY_NAME, KEY_DID, KEY_USER, KEY_PWD};
        Cursor query = sQLiteDatabase.query(true, DATABASE_TABLE, strArr, "id=" + j, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
        }
        return query;
    }

    public boolean updateCamera(String str, String str2, String str3, String str4, String str5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, str2);
        contentValues.put(KEY_DID, str3);
        contentValues.put(KEY_USER, str4);
        contentValues.put(KEY_PWD, str5);
        SQLiteDatabase sQLiteDatabase = db;
        StringBuilder sb = new StringBuilder();
        sb.append("did='");
        sb.append(str);
        sb.append("'");
        return sQLiteDatabase.update(DATABASE_TABLE, contentValues, sb.toString(), (String[]) null) > 0;
    }

    public boolean updateCameraUser(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USER, str2);
        contentValues.put(KEY_PWD, str3);
        SQLiteDatabase sQLiteDatabase = db;
        StringBuilder sb = new StringBuilder();
        sb.append("did='");
        sb.append(str);
        sb.append("'");
        return sQLiteDatabase.update(DATABASE_TABLE, contentValues, sb.toString(), (String[]) null) > 0;
    }

    public long createVideoOrPic(String str, String str2, String str3, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_DID, str);
        contentValues.put(KEY_FILEPATH, str2);
        contentValues.put(KEY_TYPE, str3);
        contentValues.put(KEY_CREATETIME, str4);
        return db.insert(DATABASW_VIDEOPICTURE_TABLE, (String) null, contentValues);
    }

    public Cursor queryAllVideo(String str) {
        return db.rawQuery("select * from cameravidpic where  type='video' and did='" + str + "' order by " + KEY_FILEPATH + " desc", (String[]) null);
    }

    public Cursor queryAllPicture(String str) {
        return db.rawQuery("select * from cameravidpic where  type='picture' and did='" + str + "' order by " + KEY_CREATETIME + " desc", (String[]) null);
    }

    public Cursor queryVideoOrPictureByDate(String str, String str2, String str3) {
        return db.rawQuery("select * from cameravidpic where  type='picture' and did='" + str + "' and " + KEY_CREATETIME + "='" + str2 + "'", (String[]) null);
    }

    public boolean deleteVideoOrPicture(String str, String str2, String str3) {
        return db.delete(DATABASW_VIDEOPICTURE_TABLE, "did=? and filepath=? and type=?", new String[]{str, str2, str3}) > 0;
    }

    public boolean deleteAllVideoOrPicture(String str, String str2) {
        return db.delete(DATABASW_VIDEOPICTURE_TABLE, "did=? and type=?", new String[]{str, str2}) > 0;
    }

    public boolean deldteAllVideoPicture(String str) {
        return db.delete(DATABASW_VIDEOPICTURE_TABLE, "did=?", new String[]{str}) > 0;
    }

    public long insertAlarmLogToDB(String str, String str2, String str3, String str4, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_DID, str);
        contentValues.put("content", str2);
        contentValues.put(KEY_UUID, str4);
        contentValues.put(KEY_CREATETIME, str3);
        contentValues.put(KEY_USER, "");
        contentValues.put(KEY_STATUS, Integer.valueOf(i));
        return db.insertOrThrow(DATABASE_ALARMLOG_TABLE, (String) null, contentValues);
    }

    public boolean updateLogs(String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USER, str2);
        contentValues.put(KEY_STATUS, Integer.valueOf(i));
        SQLiteDatabase sQLiteDatabase = db;
        StringBuilder sb = new StringBuilder();
        sb.append("pushuuid='");
        sb.append(str);
        sb.append("'");
        return sQLiteDatabase.update(DATABASE_ALARMLOG_TABLE, contentValues, sb.toString(), (String[]) null) > 0;
    }

    public Cursor queryAllAlarmLog(String str) {
        return db.rawQuery("select * from alarmlog where did='" + str + "' order by " + KEY_CREATETIME + " desc", (String[]) null);
    }

    public boolean delAlarmLog(String str, String str2) {
        return db.delete(DATABASE_ALARMLOG_TABLE, "did=? and createtime=?", new String[]{str, str2}) > 0;
    }

    public boolean addFirstpic(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_DID, str);
        contentValues.put(KEY_FILEPATH, str2);
        return db.insert(DATABASE_FIRSTPIC_TABLE, (String) null, contentValues) > 0;
    }

    public Cursor queryFirstpic(String str) {
        return db.rawQuery("select *  from firstpic where did='" + str + "'", (String[]) null);
    }
}
