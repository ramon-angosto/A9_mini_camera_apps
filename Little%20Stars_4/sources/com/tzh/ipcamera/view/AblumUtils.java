package com.tzh.ipcamera.view;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;

public class AblumUtils {
    private static AblumUtils mInstance;
    private Context context = null;

    private AblumUtils(Context context2) {
        this.context = context2;
    }

    public static AblumUtils getInstance(Context context2) {
        if (mInstance == null) {
            mInstance = new AblumUtils(context2);
        }
        return mInstance;
    }

    public void insertVideoToMediaStore(Context context2, String str, long j, long j2) {
        insertVideoToMediaStore(context2, str, j, 0, 0, j2);
    }

    public void insertImageToMediaStore(Context context2, String str, long j) {
        insertImageToMediaStore(context2, str, j, 0, 0);
    }

    public void scanFile(Context context2, String str) {
        if (checkFile(str)) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(str)));
            context2.sendBroadcast(intent);
        }
    }

    private ContentValues initCommonContentValues(String str, long j) {
        ContentValues contentValues = new ContentValues();
        File file = new File(str);
        long timeWrap = getTimeWrap(j);
        contentValues.put(PushConstants.TITLE, file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("date_modified", Long.valueOf(timeWrap));
        contentValues.put("date_added", Long.valueOf(timeWrap));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    public void insertImageToMediaStore(Context context2, String str, long j, int i, int i2) {
        if (checkFile(str)) {
            long timeWrap = getTimeWrap(j);
            ContentValues initCommonContentValues = initCommonContentValues(str, timeWrap);
            initCommonContentValues.put("datetaken", Long.valueOf(timeWrap));
            initCommonContentValues.put("orientation", 0);
            initCommonContentValues.put("orientation", 0);
            if (Build.VERSION.SDK_INT > 16) {
                if (i > 0) {
                    initCommonContentValues.put("width", 0);
                }
                if (i2 > 0) {
                    initCommonContentValues.put("height", 0);
                }
            }
            initCommonContentValues.put("mime_type", getPhotoMimeType(str));
            context2.getApplicationContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, initCommonContentValues);
        }
    }

    public void insertVideoToMediaStore(Context context2, String str, long j, int i, int i2, long j2) {
        String videoMimeType;
        if (checkFile(str) && (videoMimeType = getVideoMimeType(str)) != "unknow") {
            long timeWrap = getTimeWrap(j);
            ContentValues initCommonContentValues = initCommonContentValues(str, timeWrap);
            initCommonContentValues.put("datetaken", Long.valueOf(timeWrap));
            if (j2 > 0) {
                initCommonContentValues.put("duration", Long.valueOf(j2));
            }
            if (Build.VERSION.SDK_INT > 16) {
                if (i > 0) {
                    initCommonContentValues.put("width", Integer.valueOf(i));
                }
                if (i2 > 0) {
                    initCommonContentValues.put("height", Integer.valueOf(i2));
                }
            }
            initCommonContentValues.put("mime_type", videoMimeType);
            context2.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, initCommonContentValues);
        }
    }

    private boolean isSystemDcim(String str) {
        return str.toLowerCase().contains("dcim") || str.toLowerCase().contains("camera");
    }

    private String getPhotoMimeType(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("jpg") && !lowerCase.endsWith("jpeg")) {
            if (lowerCase.endsWith("png")) {
                return "image/png";
            }
            if (lowerCase.endsWith("gif")) {
                return "image/gif";
            }
        }
        return "image/jpeg";
    }

    private String getVideoMimeType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4")) {
            return "video/mp4";
        }
        if (lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return lowerCase.endsWith("avi") ? "video/x-msvideo" : "unknow";
    }

    private long getTimeWrap(long j) {
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    private boolean checkFile(String str) {
        return new File(str).exists();
    }
}
