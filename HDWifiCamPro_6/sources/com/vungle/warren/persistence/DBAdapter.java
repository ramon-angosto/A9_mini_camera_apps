package com.vungle.warren.persistence;

import android.content.ContentValues;

public interface DBAdapter<T> {
    T fromContentValues(ContentValues contentValues);

    String tableName();

    ContentValues toContentValues(T t);
}
