package com.vungle.warren.model;

import android.content.ContentValues;
import com.vungle.warren.persistence.DBAdapter;
import com.vungle.warren.persistence.IdColumns;

public class CacheBustDBAdapter implements DBAdapter<CacheBust> {
    public static final String CREATE_CACHE_BUST_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS cache_bust(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, id TEXT, time_window_end INTEGER, id_type INTEGER, event_ids TEXT, timestamp_processed INTEGER )";
    static final String DELIMITER = ";";

    public interface CacheBustColumns extends IdColumns {
        public static final String COLUMN_EVENT_ID = "id";
        public static final String COLUMN_EVENT_IDS = "event_ids";
        public static final String COLUMN_EVENT_ID_TYPE = "id_type";
        public static final String COLUMN_TIMESTAMP_PROCESSED = "timestamp_processed";
        public static final String COLUMN_TIME_WINDOW_END = "time_window_end";
        public static final String TABLE_NAME = "cache_bust";
    }

    public String tableName() {
        return CacheBustColumns.TABLE_NAME;
    }

    public ContentValues toContentValues(CacheBust cacheBust) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IdColumns.COLUMN_IDENTIFIER, cacheBust.calculateId());
        contentValues.put("id", cacheBust.id);
        contentValues.put(CacheBustColumns.COLUMN_TIME_WINDOW_END, Long.valueOf(cacheBust.timeWindowEnd));
        contentValues.put(CacheBustColumns.COLUMN_EVENT_ID_TYPE, Integer.valueOf(cacheBust.idType));
        contentValues.put(CacheBustColumns.COLUMN_EVENT_IDS, arrayToString(cacheBust.eventIds));
        contentValues.put(CacheBustColumns.COLUMN_TIMESTAMP_PROCESSED, Long.valueOf(cacheBust.timestampProcessed));
        return contentValues;
    }

    public CacheBust fromContentValues(ContentValues contentValues) {
        CacheBust cacheBust = new CacheBust();
        cacheBust.id = contentValues.getAsString("id");
        cacheBust.timeWindowEnd = contentValues.getAsLong(CacheBustColumns.COLUMN_TIME_WINDOW_END).longValue();
        cacheBust.idType = contentValues.getAsInteger(CacheBustColumns.COLUMN_EVENT_ID_TYPE).intValue();
        cacheBust.eventIds = stringToArray(contentValues.getAsString(CacheBustColumns.COLUMN_EVENT_IDS));
        cacheBust.timestampProcessed = contentValues.getAsLong(CacheBustColumns.COLUMN_TIMESTAMP_PROCESSED).longValue();
        return cacheBust;
    }

    static String arrayToString(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        if (strArr.length == 1) {
            return strArr[0];
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(DELIMITER);
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    static String[] stringToArray(String str) {
        if (str.isEmpty()) {
            return new String[0];
        }
        return str.split(DELIMITER);
    }
}
