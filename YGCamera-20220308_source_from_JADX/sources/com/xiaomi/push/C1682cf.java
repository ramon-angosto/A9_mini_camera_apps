package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.C1685ci;

/* renamed from: com.xiaomi.push.cf */
public class C1682cf extends C1685ci.C1690e {

    /* renamed from: a */
    private String f1918a = "MessageInsertJob";

    public C1682cf(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f1918a = str2;
    }

    /* renamed from: a */
    public static C1682cf m2834a(Context context, String str, C1872hs hsVar) {
        byte[] a = C1905iy.m4543a(hsVar);
        if (a == null || a.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", hsVar.mo17792d());
        contentValues.put("messageItem", a);
        contentValues.put("appId", C1671bw.m2760a(context).mo17275b());
        contentValues.put("packageName", C1671bw.m2760a(context).mo17270a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", 0);
        return new C1682cf(str, contentValues, "a job build to insert message to db");
    }
}
