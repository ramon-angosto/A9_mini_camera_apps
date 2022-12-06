package com.huawei.hms.availableupdate;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.huawei.hms.availableupdate.a */
/* compiled from: DownloadRecord */
public class C0631a {

    /* renamed from: a */
    public String f344a;

    /* renamed from: b */
    public int f345b;

    /* renamed from: c */
    public String f346c;

    /* renamed from: d */
    public int f347d;

    /* renamed from: a */
    public void mo13215a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD" + str, 0);
        this.f344a = sharedPreferences.getString("mUri", "");
        this.f345b = sharedPreferences.getInt("mSize", 0);
        this.f346c = sharedPreferences.getString("mHash", "");
        this.f347d = sharedPreferences.getInt("mReceived", 0);
    }

    /* renamed from: b */
    public final void mo13218b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD" + str, 0).edit();
        edit.putString("mUri", this.f344a);
        edit.putInt("mSize", this.f345b);
        edit.putString("mHash", this.f346c);
        edit.putInt("mReceived", this.f347d);
        edit.commit();
    }

    /* renamed from: a */
    public void mo13216a(String str, int i, String str2) {
        this.f344a = str;
        this.f345b = i;
        this.f346c = str2;
        this.f347d = 0;
    }

    /* renamed from: a */
    public void mo13214a(Context context, int i, String str) {
        this.f347d = i;
        mo13218b(context, str);
    }

    /* renamed from: b */
    public int mo13217b() {
        return this.f345b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f344a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r2 = r1.f346c;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo13219b(java.lang.String r2, int r3, java.lang.String r4) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0024
            if (r4 == 0) goto L_0x0024
            java.lang.String r0 = r1.f344a
            if (r0 == 0) goto L_0x0024
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0024
            int r2 = r1.f345b
            if (r2 != r3) goto L_0x0024
            java.lang.String r2 = r1.f346c
            if (r2 == 0) goto L_0x0024
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0024
            int r2 = r1.f347d
            int r3 = r1.f345b
            if (r2 > r3) goto L_0x0024
            r2 = 1
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.availableupdate.C0631a.mo13219b(java.lang.String, int, java.lang.String):boolean");
    }

    /* renamed from: a */
    public int mo13213a() {
        return this.f347d;
    }
}
