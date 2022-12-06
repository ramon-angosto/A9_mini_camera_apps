package com.vungle.warren.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "vungle_db";
    public static final String TAG = DatabaseHelper.class.getSimpleName();
    private final DatabaseFactory databaseFactory;

    public interface DatabaseFactory {
        void create(SQLiteDatabase sQLiteDatabase);

        void deleteData(SQLiteDatabase sQLiteDatabase);

        void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

        void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    public static class DBException extends Exception {
        public DBException(String str) {
            super(str);
        }
    }

    public DatabaseHelper(Context context, int i, DatabaseFactory databaseFactory2) {
        super(new NoBackupDatabaseWrapperContext(context.getApplicationContext()), DB_NAME, (SQLiteDatabase.CursorFactory) null, i);
        this.databaseFactory = databaseFactory2;
    }

    public synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.databaseFactory.create(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.databaseFactory.onUpgrade(sQLiteDatabase, i, i2);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.databaseFactory.onDowngrade(sQLiteDatabase, i, i2);
    }

    public long insertWithConflict(String str, ContentValues contentValues, int i) throws DBException {
        try {
            return loadWritableDB().insertWithOnConflict(str, (String) null, contentValues, i);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    public long update(Query query, ContentValues contentValues) throws DBException {
        try {
            return (long) loadWritableDB().update(query.tableName, contentValues, query.selection, query.args);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    public Cursor query(Query query) {
        return loadWritableDB().query(query.tableName, query.columns, query.selection, query.args, query.groupBy, query.having, query.orderBy, query.limit);
    }

    public Cursor queryRaw(String str, String[] strArr) {
        return loadWritableDB().rawQuery(str, strArr);
    }

    public void delete(Query query) throws DBException {
        try {
            loadWritableDB().delete(query.tableName, query.selection, query.args);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    public void execSQL(String str) throws DBException {
        try {
            loadWritableDB().execSQL(str);
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    public synchronized void dropDb() {
        this.databaseFactory.deleteData(loadWritableDB());
        close();
        onCreate(loadWritableDB());
    }

    public void init() {
        loadWritableDB();
    }

    private synchronized SQLiteDatabase loadWritableDB() {
        return getWritableDatabase();
    }

    private static class NoBackupDatabaseWrapperContext extends ContextWrapper {
        private int getFlags(int i) {
            int i2 = 0;
            int i3 = ((i & 8) != 0 ? 536870912 : 0) | 268435456;
            if ((i & 16) != 0) {
                i2 = 16;
            }
            return i3 | i2;
        }

        public NoBackupDatabaseWrapperContext(Context context) {
            super(context);
        }

        public File getDatabasePath(String str) {
            File databasePath = super.getDatabasePath(str);
            File file = new File(getApplicationContext().getNoBackupFilesDir(), str);
            try {
                FileUtility.delete(new File(databasePath.getPath()));
                FileUtility.delete(new File(databasePath.getPath() + "-journal"));
            } catch (IOException unused) {
                VungleLogger.error(true, DatabaseHelper.TAG, IDatabaseHelper.TAG, "Failed to delete old db/-journal");
            }
            return file;
        }

        public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
            return SQLiteDatabase.openDatabase(getDatabasePath(str).getPath(), cursorFactory, getFlags(i));
        }

        public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
            return SQLiteDatabase.openDatabase(getDatabasePath(str).getPath(), cursorFactory, getFlags(i), databaseErrorHandler);
        }
    }
}
