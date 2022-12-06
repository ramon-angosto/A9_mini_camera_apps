package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.multipro.a;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* compiled from: SPMultiProviderImpl */
public class c implements a {
    private Context a;

    public String a() {
        return "t_sp";
    }

    public void b() {
    }

    private Context c() {
        Context context = this.a;
        return context == null ? m.a() : context;
    }

    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> c;
        if (!uri.getPath().split("/")[2].equals("get_all") || (c = b.c(c(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String next : c.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = next;
            objArr[2] = c.get(next);
            if (objArr[2] instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (objArr[2] instanceof String) {
                objArr[1] = "string";
            } else if (objArr[2] instanceof Integer) {
                objArr[1] = "int";
            } else if (objArr[2] instanceof Long) {
                objArr[1] = "long";
            } else if (objArr[2] instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    public String a(Uri uri) {
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        if (str.equals("contain")) {
            return b.a(m.a(), uri.getQueryParameter("sp_file_name"), str2) + "";
        }
        return "" + b.a(c(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    public Uri a(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        Object obj = contentValues.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (obj != null) {
            b.a(c(), uri.getQueryParameter("sp_file_name"), str2, obj);
        }
        return null;
    }

    public int a(Uri uri, String str, String[] strArr) {
        String[] split = uri.getPath().split("/");
        if (split[2].equals("clean")) {
            b.b(c(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = split[3];
        if (b.a(c(), uri.getQueryParameter("sp_file_name"), str2)) {
            b.b(c(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        a(uri, contentValues);
        return 0;
    }
}
