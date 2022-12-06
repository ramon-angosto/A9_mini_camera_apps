package com.mbridge.msdk.foundation.download.database;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.download.DownloadResourceType;

public class DownloadModel {
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS download_record( id INTEGER PRIMARY KEY AUTOINCREMENT,download_id TEXT,download_url TEXT, resource_url TEXT,etag TEXT, director_path TEXT, file_name TEXT, total_bytes INTEGER, downloaded_bytes INTEGER, last_modified_time INTEGER,download_rate INTEGER,usage_counter INTEGER,download_resource_type INTEGER)";
    public static final String DIRECTORY_PATH = "director_path";
    public static final String DOWNLOADED_BYTES = "downloaded_bytes";
    public static final String DOWNLOAD_ID = "download_id";
    public static final String DOWNLOAD_RATE = "download_rate";
    public static final String DOWNLOAD_RESOURCE_TYPE = "download_resource_type";
    public static final String DOWNLOAD_URL = "download_url";
    public static final String ETAG = "etag";
    public static final String FILE_NAME = "file_name";
    public static final String ID = "id";
    public static final String LAST_MODIFIED_TIME = "last_modified_time";
    public static final String RESOURCE_URL = "resource_url";
    public static final String TABLE_NAME = "download_record";
    public static final String TOTAL_BYTES = "total_bytes";
    public static final String USAGE_COUNTER = "usage_counter";
    private String downloadId;
    private int downloadRate;
    private DownloadResourceType downloadResourceType;
    private String downloadUrl;
    private long downloadedBytes;
    private String etag;
    private long lastModifiedTime;
    private String resourceUrl;
    private String saveDirectorPath;
    private String saveFileName;
    private long totalBytes;
    private long unZipResourceByte;
    private String unZipResourceDirectory;
    private int usageCounter;

    private DownloadModel() {
    }

    public String getDownloadId() {
        return this.downloadId;
    }

    public void setDownloadId(String str) {
        this.downloadId = str;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public String getSaveDirectorPath() {
        return this.saveDirectorPath;
    }

    public void setSaveDirectorPath(String str) {
        this.saveDirectorPath = str;
    }

    public String getSaveFileName() {
        return this.saveFileName;
    }

    public void setSaveFileName(String str) {
        this.saveFileName = str;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public void setDownloadedBytes(long j) {
        this.downloadedBytes = j;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public void setLastModifiedTime(long j) {
        this.lastModifiedTime = j;
    }

    public int getUsageCounter() {
        return this.usageCounter;
    }

    public void setUsageCounter(int i) {
        this.usageCounter = i;
    }

    public int getDownloadRate() {
        return this.downloadRate;
    }

    public void setDownloadRate(int i) {
        this.downloadRate = i;
    }

    public static DownloadModel create(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2, int i, int i2, DownloadResourceType downloadResourceType2) {
        DownloadModel downloadModel = new DownloadModel();
        downloadModel.setDownloadId(str);
        downloadModel.setDownloadUrl(str2);
        downloadModel.setResourceUrl(str3);
        downloadModel.setEtag(str4);
        downloadModel.setSaveDirectorPath(str5);
        downloadModel.setSaveFileName(str6);
        downloadModel.setDownloadedBytes(j2);
        downloadModel.setTotalBytes(j);
        downloadModel.setLastModifiedTime(System.currentTimeMillis());
        downloadModel.setUsageCounter(i2);
        downloadModel.setDownloadRate(i);
        downloadModel.setDownloadResourceType(downloadResourceType2);
        downloadModel.setUnZipResourceDirectory((String) null);
        downloadModel.setUnZipResourceByte(0);
        return downloadModel;
    }

    public static DownloadModel create(Cursor cursor) {
        DownloadModel downloadModel = new DownloadModel();
        downloadModel.setDownloadId(cursor.getString(cursor.getColumnIndex(DOWNLOAD_ID)));
        downloadModel.setDownloadUrl(cursor.getString(cursor.getColumnIndex(DOWNLOAD_URL)));
        downloadModel.setResourceUrl(cursor.getString(cursor.getColumnIndex(RESOURCE_URL)));
        downloadModel.setEtag(cursor.getString(cursor.getColumnIndex(ETAG)));
        downloadModel.setSaveDirectorPath(cursor.getString(cursor.getColumnIndex(DIRECTORY_PATH)));
        downloadModel.setSaveFileName(cursor.getString(cursor.getColumnIndex(FILE_NAME)));
        downloadModel.setTotalBytes(cursor.getLong(cursor.getColumnIndex(TOTAL_BYTES)));
        downloadModel.setDownloadedBytes(cursor.getLong(cursor.getColumnIndex(DOWNLOADED_BYTES)));
        downloadModel.setLastModifiedTime(cursor.getLong(cursor.getColumnIndex(LAST_MODIFIED_TIME)));
        downloadModel.setDownloadRate(cursor.getInt(cursor.getColumnIndex(DOWNLOAD_RATE)));
        downloadModel.setUsageCounter(cursor.getInt(cursor.getColumnIndex(USAGE_COUNTER)));
        downloadModel.setDownloadResourceType(DownloadResourceType.getDownloadResourceType(cursor.getInt(cursor.getColumnIndex(DOWNLOAD_RESOURCE_TYPE))));
        return downloadModel;
    }

    public static ContentValues create(DownloadModel downloadModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DOWNLOAD_ID, downloadModel.getDownloadId());
        contentValues.put(DOWNLOAD_URL, downloadModel.getDownloadUrl());
        contentValues.put(RESOURCE_URL, downloadModel.getResourceUrl());
        contentValues.put(ETAG, downloadModel.getEtag());
        contentValues.put(DIRECTORY_PATH, downloadModel.getSaveDirectorPath());
        contentValues.put(FILE_NAME, downloadModel.getSaveFileName());
        contentValues.put(TOTAL_BYTES, Long.valueOf(downloadModel.getTotalBytes()));
        contentValues.put(DOWNLOADED_BYTES, Long.valueOf(downloadModel.getDownloadedBytes()));
        contentValues.put(LAST_MODIFIED_TIME, Long.valueOf(downloadModel.getLastModifiedTime()));
        contentValues.put(DOWNLOAD_RATE, Integer.valueOf(downloadModel.getDownloadRate()));
        contentValues.put(USAGE_COUNTER, Integer.valueOf(downloadModel.getUsageCounter()));
        contentValues.put(DOWNLOAD_RESOURCE_TYPE, Integer.valueOf(downloadModel.getDownloadResourceType().resourceType));
        return contentValues;
    }

    public DownloadResourceType getDownloadResourceType() {
        return this.downloadResourceType;
    }

    public void setDownloadResourceType(DownloadResourceType downloadResourceType2) {
        this.downloadResourceType = downloadResourceType2;
    }

    public String getUnZipResourceDirectory() {
        return this.unZipResourceDirectory;
    }

    public void setUnZipResourceDirectory(String str) {
        this.unZipResourceDirectory = str;
    }

    public long getUnZipResourceByte() {
        return this.unZipResourceByte;
    }

    public void setUnZipResourceByte(long j) {
        this.unZipResourceByte = j;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }

    public void setResourceUrl(String str) {
        this.resourceUrl = str;
    }
}
