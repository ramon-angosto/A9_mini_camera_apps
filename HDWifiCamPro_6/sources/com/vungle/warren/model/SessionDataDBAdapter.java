package com.vungle.warren.model;

import android.content.ContentValues;
import com.vungle.warren.persistence.DBAdapter;
import com.vungle.warren.persistence.IdColumns;

public class SessionDataDBAdapter implements DBAdapter<SessionData> {
    public static final String CREATE_SESSION_DATA_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS session_data(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE,json_string TEXT, send_attempts INT)";

    public interface SessionDataColumns extends IdColumns {
        public static final String JSON_STRING = "json_string";
        public static final String SEND_ATTEMPTS = "send_attempts";
        public static final String TABLE_NAME = "session_data";
    }

    public String tableName() {
        return SessionDataColumns.TABLE_NAME;
    }

    public ContentValues toContentValues(SessionData sessionData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IdColumns.COLUMN_IDENTIFIER, sessionData.getId());
        contentValues.put(SessionDataColumns.JSON_STRING, sessionData.getAsJsonString());
        contentValues.put(SessionDataColumns.SEND_ATTEMPTS, Integer.valueOf(sessionData.getSendAttempts()));
        return contentValues;
    }

    public SessionData fromContentValues(ContentValues contentValues) {
        return new SessionData(contentValues.getAsString(SessionDataColumns.JSON_STRING), contentValues.getAsInteger(SessionDataColumns.SEND_ATTEMPTS).intValue());
    }
}
