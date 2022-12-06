package com.dommy.qrcode.util;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

@Deprecated
public class UriUtil {
    public static String getRealPathFromUri(Context context, Uri uri) {
        int i = Build.VERSION.SDK_INT;
        if (i < 11) {
            return getRealPathFromUri_BelowApi11(context, uri);
        }
        if (i < 19) {
            return getRealPathFromUri_Api11To18(context, uri);
        }
        return getRealPathFromUri_AboveApi19(context, uri);
    }

    private static String getRealPathFromUri_AboveApi19(Context context, Uri uri) {
        String str;
        String[] split = DocumentsContract.getDocumentId(uri).split(":");
        String str2 = null;
        if (split == null) {
            return null;
        }
        if (split.length > 1) {
            str = split[1];
        } else {
            str = split[0];
        }
        String[] strArr = {"_data"};
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "_id=?", new String[]{str}, (String) null);
        int columnIndex = query.getColumnIndex(strArr[0]);
        if (query.moveToFirst()) {
            str2 = query.getString(columnIndex);
        }
        query.close();
        return str2;
    }

    private static String getRealPathFromUri_Api11To18(Context context, Uri uri) {
        String[] strArr = {"_data"};
        Cursor loadInBackground = new CursorLoader(context, uri, strArr, (String) null, (String[]) null, (String) null).loadInBackground();
        if (loadInBackground == null) {
            return null;
        }
        loadInBackground.moveToFirst();
        String string = loadInBackground.getString(loadInBackground.getColumnIndex(strArr[0]));
        loadInBackground.close();
        return string;
    }

    private static String getRealPathFromUri_BelowApi11(Context context, Uri uri) {
        String[] strArr = {"_data"};
        Cursor query = context.getContentResolver().query(uri, strArr, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return null;
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex(strArr[0]));
        query.close();
        return string;
    }
}
