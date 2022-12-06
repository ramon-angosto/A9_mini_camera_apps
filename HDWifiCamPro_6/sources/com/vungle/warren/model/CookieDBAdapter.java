package com.vungle.warren.model;

import android.content.ContentValues;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vungle.warren.persistence.DBAdapter;
import com.vungle.warren.persistence.IdColumns;
import java.lang.reflect.Type;
import java.util.Map;

public class CookieDBAdapter implements DBAdapter<Cookie> {
    public static final String CREATE_COOKIE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS cookie(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, bools TEXT, ints TEXT, longs TEXT, strings TEXT )";
    Type boolType = new TypeToken<Map<String, Boolean>>() {
    }.getType();
    private Gson gson = new GsonBuilder().create();
    Type intType = new TypeToken<Map<String, Integer>>() {
    }.getType();
    Type longType = new TypeToken<Map<String, Long>>() {
    }.getType();
    Type stringType = new TypeToken<Map<String, String>>() {
    }.getType();

    public interface CookieColumns extends IdColumns {
        public static final String COLUMN_BOOLS = "bools";
        public static final String COLUMN_INTS = "ints";
        public static final String COLUMN_LONGS = "longs";
        public static final String COLUMN_STRINGS = "strings";
        public static final String TABLE_NAME = "cookie";
    }

    public String tableName() {
        return CookieColumns.TABLE_NAME;
    }

    public ContentValues toContentValues(Cookie cookie) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IdColumns.COLUMN_IDENTIFIER, cookie.identifier);
        contentValues.put(CookieColumns.COLUMN_BOOLS, this.gson.toJson((Object) cookie.booleans, this.boolType));
        contentValues.put(CookieColumns.COLUMN_INTS, this.gson.toJson((Object) cookie.integers, this.intType));
        contentValues.put(CookieColumns.COLUMN_LONGS, this.gson.toJson((Object) cookie.longs, this.longType));
        contentValues.put(CookieColumns.COLUMN_STRINGS, this.gson.toJson((Object) cookie.strings, this.stringType));
        return contentValues;
    }

    public Cookie fromContentValues(ContentValues contentValues) {
        Cookie cookie = new Cookie(contentValues.getAsString(IdColumns.COLUMN_IDENTIFIER));
        cookie.booleans = (Map) this.gson.fromJson(contentValues.getAsString(CookieColumns.COLUMN_BOOLS), this.boolType);
        cookie.longs = (Map) this.gson.fromJson(contentValues.getAsString(CookieColumns.COLUMN_LONGS), this.longType);
        cookie.integers = (Map) this.gson.fromJson(contentValues.getAsString(CookieColumns.COLUMN_INTS), this.intType);
        cookie.strings = (Map) this.gson.fromJson(contentValues.getAsString(CookieColumns.COLUMN_STRINGS), this.stringType);
        return cookie;
    }
}
