package com.ironsource.lifecycle;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class IronsourceLifecycleProvider extends ContentProvider {
    private static boolean a = false;

    static boolean a() {
        return a;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Application application;
        a = true;
        d a2 = d.a();
        Context context = getContext();
        if (d.a.compareAndSet(false, true) && (application = (Application) context.getApplicationContext()) != null) {
            application.registerActivityLifecycleCallbacks(a2);
        }
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
