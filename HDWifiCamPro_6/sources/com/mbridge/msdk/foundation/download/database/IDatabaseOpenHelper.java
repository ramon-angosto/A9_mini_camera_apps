package com.mbridge.msdk.foundation.download.database;

import android.database.sqlite.SQLiteDatabase;

public interface IDatabaseOpenHelper {
    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();
}
