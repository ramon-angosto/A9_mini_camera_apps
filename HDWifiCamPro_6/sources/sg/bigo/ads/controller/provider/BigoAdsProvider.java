package sg.bigo.ads.controller.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import sg.bigo.ads.common.b.c;
import sg.bigo.ads.common.k.a;

public class BigoAdsProvider extends ContentProvider {
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
        a.a(0, 3, "BigoAdsProvider", "onCreate");
        Context context = getContext();
        if (!(context instanceof Application)) {
            return true;
        }
        c.a((Application) context);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
