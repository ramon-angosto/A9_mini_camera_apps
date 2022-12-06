package com.vungle.warren.model;

import android.content.ContentValues;
import com.vungle.warren.persistence.DBAdapter;
import com.vungle.warren.persistence.IdColumns;

public class AdAssetDBAdapter implements DBAdapter<AdAsset> {
    public static final String CREATE_ASSET_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS adAsset ( _id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, paren_id TEXT , ad_identifier TEXT NOT NULL, server_path TEXT, local_path TEXT NOT NULL, file_status SHORT, file_type SHORT, file_size INT, retry_count SHORT, retry_error SHORT, unique ( local_path, ad_identifier ));";

    public interface AdAssetColumns extends IdColumns {
        public static final String COLUMN_AD_ID = "ad_identifier";
        public static final String COLUMN_FILE_SIZE = "file_size";
        public static final String COLUMN_FILE_STATUS = "file_status";
        public static final String COLUMN_FILE_TYPE = "file_type";
        public static final String COLUMN_LOCAL_PATH = "local_path";
        public static final String COLUMN_PARENT_ID = "paren_id";
        public static final String COLUMN_RETRY_COUNT = "retry_count";
        public static final String COLUMN_RETRY_ERROR = "retry_error";
        public static final String COLUMN_SERVER_PATH = "server_path";
        public static final String TABLE_NAME = "adAsset";
    }

    public String tableName() {
        return AdAssetColumns.TABLE_NAME;
    }

    public ContentValues toContentValues(AdAsset adAsset) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IdColumns.COLUMN_IDENTIFIER, adAsset.identifier);
        contentValues.put(AdAssetColumns.COLUMN_AD_ID, adAsset.adIdentifier);
        contentValues.put(AdAssetColumns.COLUMN_PARENT_ID, adAsset.parentId);
        contentValues.put(AdAssetColumns.COLUMN_SERVER_PATH, adAsset.serverPath);
        contentValues.put(AdAssetColumns.COLUMN_LOCAL_PATH, adAsset.localPath);
        contentValues.put(AdAssetColumns.COLUMN_FILE_STATUS, Integer.valueOf(adAsset.status));
        contentValues.put(AdAssetColumns.COLUMN_FILE_TYPE, Integer.valueOf(adAsset.fileType));
        contentValues.put(AdAssetColumns.COLUMN_FILE_SIZE, Long.valueOf(adAsset.fileSize));
        contentValues.put("retry_count", Integer.valueOf(adAsset.retryCount));
        contentValues.put(AdAssetColumns.COLUMN_RETRY_ERROR, Integer.valueOf(adAsset.retryTypeError));
        return contentValues;
    }

    public AdAsset fromContentValues(ContentValues contentValues) {
        AdAsset adAsset = new AdAsset(contentValues.getAsString(AdAssetColumns.COLUMN_AD_ID), contentValues.getAsString(AdAssetColumns.COLUMN_SERVER_PATH), contentValues.getAsString(AdAssetColumns.COLUMN_LOCAL_PATH), contentValues.getAsString(IdColumns.COLUMN_IDENTIFIER));
        adAsset.status = contentValues.getAsInteger(AdAssetColumns.COLUMN_FILE_STATUS).intValue();
        adAsset.fileType = contentValues.getAsInteger(AdAssetColumns.COLUMN_FILE_TYPE).intValue();
        adAsset.fileSize = (long) contentValues.getAsInteger(AdAssetColumns.COLUMN_FILE_SIZE).intValue();
        adAsset.retryCount = contentValues.getAsInteger("retry_count").intValue();
        adAsset.retryTypeError = contentValues.getAsInteger(AdAssetColumns.COLUMN_RETRY_ERROR).intValue();
        adAsset.parentId = contentValues.getAsString(AdAssetColumns.COLUMN_PARENT_ID);
        return adAsset;
    }
}
