package com.bytedance.sdk.openadsdk.c.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.component.e.a.b.b.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.multipro.a;

/* compiled from: EventProviderWrapper */
public class d implements a {
    private b a;

    public d(b bVar) {
        this.a = bVar;
    }

    public String a() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public void b() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.d();
        }
    }

    public String a(Uri uri) {
        l.b("wrapper getType1");
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri);
        }
        return null;
    }

    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public Uri a(Uri uri, ContentValues contentValues) {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri, contentValues);
        }
        return null;
    }

    public int a(Uri uri, String str, String[] strArr) {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri, str, strArr);
        }
        return 0;
    }

    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
