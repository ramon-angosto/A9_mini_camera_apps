package com.xiaomi.push.service.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.File;
import junit.framework.Assert;

class a {
    private Context a;
    private String b;
    private String c;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private String g;
    private SharedPreferences h;

    public a(Context context, String str) {
        this.a = context.getApplicationContext();
        this.b = str;
        this.h = this.a.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        Assert.assertEquals(true, !TextUtils.isEmpty(this.b));
    }

    public static String a(Context context, String str) {
        return b(context, str) + "/" + str + ".apk";
    }

    private String a(String str) {
        try {
            return this.a.getPackageManager().getPackageArchiveInfo(str, 16512).applicationInfo.metaData.getString("Launcher");
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(int i) {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putInt(this.b + "_asset_app_version", i).commit();
    }

    private void a(long j) {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putLong(this.b + "_asset_modified", j).commit();
    }

    private static String b(Context context, String str) {
        return context.getDir(str, 0).getAbsolutePath();
    }

    private void b(int i) {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putInt(this.b + "_asset_version", i).commit();
    }

    private void b(long j) {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putLong(this.b + "_local_modified", j).commit();
    }

    private void b(String str) {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putString(this.b + "_asset_launcher", str).commit();
    }

    private void c(int i) {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putInt(this.b + "_local_version", i).commit();
    }

    private void c(String str) {
        SharedPreferences.Editor edit = this.h.edit();
        edit.putString(this.b + "_local_launcher", str).commit();
    }

    private boolean g() {
        File file = new File(l());
        return file.exists() && (s() != file.lastModified() || q() == 0);
    }

    private boolean h() {
        File file = new File(d());
        return file.exists() && (t() == file.lastModified() || r() == 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        if (r1 == null) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        com.xiaomi.channel.commonutils.file.a.a(r1.getParcelFileDescriptor());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        if (r1 == null) goto L_0x007d;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean i() {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r7.l()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 == 0) goto L_0x007d
            r1 = 0
            android.content.Context r3 = r7.a     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            java.lang.String r5 = r7.b     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            java.lang.String r5 = ".apk"
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            android.content.res.AssetFileDescriptor r1 = r3.openFd(r4)     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            long r3 = r1.getLength()     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            long r5 = r0.length()     // Catch:{ FileNotFoundException -> 0x0055, Exception -> 0x0047 }
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x003b
            r2 = 1
        L_0x003b:
            if (r1 == 0) goto L_0x0044
            android.os.ParcelFileDescriptor r0 = r1.getParcelFileDescriptor()
            com.xiaomi.channel.commonutils.file.a.a((android.os.ParcelFileDescriptor) r0)
        L_0x0044:
            return r2
        L_0x0045:
            r0 = move-exception
            goto L_0x0073
        L_0x0047:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x007d
        L_0x004d:
            android.os.ParcelFileDescriptor r0 = r1.getParcelFileDescriptor()
            com.xiaomi.channel.commonutils.file.a.a((android.os.ParcelFileDescriptor) r0)
            goto L_0x007d
        L_0x0055:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r0.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "no "
            r0.append(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = r7.b     // Catch:{ all -> 0x0045 }
            r0.append(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = ".apk file in assets of app"
            r0.append(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0045 }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x007d
            goto L_0x004d
        L_0x0073:
            if (r1 == 0) goto L_0x007c
            android.os.ParcelFileDescriptor r1 = r1.getParcelFileDescriptor()
            com.xiaomi.channel.commonutils.file.a.a((android.os.ParcelFileDescriptor) r1)
        L_0x007c:
            throw r0
        L_0x007d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.module.a.i():boolean");
    }

    private void j() {
        try {
            b.b("copyAssetFile start");
            String[] list = this.a.getAssets().list("");
            if (list != null) {
                int length = list.length;
                int i = 0;
                while (i < length) {
                    String str = list[i];
                    if (TextUtils.isEmpty(str) || !str.startsWith(this.b)) {
                        i++;
                    } else {
                        c.a(this.a, str, l());
                        b.b("copyAssetFile end");
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            b.b("copyAssetFile end");
            throw th;
        }
        b.b("copyAssetFile end");
    }

    private String k() {
        return b(this.a, this.b);
    }

    private String l() {
        return k() + "/" + this.b + "_asset.apk";
    }

    private String m() {
        return k() + "/lib/";
    }

    private String n() {
        return k() + "/asset_lib/";
    }

    private boolean o() {
        try {
            return p() != com.xiaomi.channel.commonutils.android.b.b(this.a, this.a.getPackageName());
        } catch (Exception unused) {
            return true;
        }
    }

    private int p() {
        try {
            SharedPreferences sharedPreferences = this.h;
            return sharedPreferences.getInt(this.b + "_asset_app_version", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private int q() {
        try {
            SharedPreferences sharedPreferences = this.h;
            return sharedPreferences.getInt(this.b + "_asset_version", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private int r() {
        try {
            SharedPreferences sharedPreferences = this.h;
            return sharedPreferences.getInt(this.b + "_local_version", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private long s() {
        try {
            SharedPreferences sharedPreferences = this.h;
            return sharedPreferences.getLong(this.b + "_asset_modified", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private long t() {
        try {
            SharedPreferences sharedPreferences = this.h;
            return sharedPreferences.getLong(this.b + "_local_modified", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private String u() {
        try {
            SharedPreferences sharedPreferences = this.h;
            return sharedPreferences.getString(this.b + "_asset_launcher", (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    private String v() {
        try {
            SharedPreferences sharedPreferences = this.h;
            return sharedPreferences.getString(this.b + "_local_launcher", (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public int a() {
        return this.d;
    }

    public String b() {
        return this.g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b0 A[Catch:{ Exception -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0104 A[Catch:{ Exception -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0177 A[SYNTHETIC, Splitter:B:39:0x0177] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized dalvik.system.DexClassLoader c() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0212 }
            r0.<init>()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = "load apk "
            r0.append(r1)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = r6.b     // Catch:{ Exception -> 0x0212 }
            r0.append(r1)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0212 }
            com.xiaomi.channel.commonutils.logger.b.b(r0)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = r6.l()     // Catch:{ Exception -> 0x0212 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0212 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0212 }
            boolean r2 = r6.i()     // Catch:{ Exception -> 0x0212 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0212 }
            r3.<init>()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r4 = "assert app size changed : "
            r3.append(r4)     // Catch:{ Exception -> 0x0212 }
            r3.append(r2)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0212 }
            com.xiaomi.channel.commonutils.logger.b.b(r3)     // Catch:{ Exception -> 0x0212 }
            boolean r3 = r1.exists()     // Catch:{ Exception -> 0x0212 }
            if (r3 == 0) goto L_0x0046
            if (r2 != 0) goto L_0x0046
            boolean r3 = r6.o()     // Catch:{ Exception -> 0x0212 }
            if (r3 == 0) goto L_0x004e
        L_0x0046:
            java.lang.String r3 = "re-copy asset file"
            com.xiaomi.channel.commonutils.logger.b.b(r3)     // Catch:{ Exception -> 0x0212 }
            r6.j()     // Catch:{ Exception -> 0x0212 }
        L_0x004e:
            boolean r3 = r1.exists()     // Catch:{ Exception -> 0x0212 }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x00a0
            java.lang.String r3 = "check modify."
            com.xiaomi.channel.commonutils.logger.b.b(r3)     // Catch:{ Exception -> 0x0212 }
            boolean r3 = r6.g()     // Catch:{ Exception -> 0x0212 }
            if (r3 != 0) goto L_0x0076
            if (r2 != 0) goto L_0x0076
            boolean r2 = r6.o()     // Catch:{ Exception -> 0x0212 }
            if (r2 == 0) goto L_0x006a
            goto L_0x0076
        L_0x006a:
            java.lang.String r0 = "not modified."
            com.xiaomi.channel.commonutils.logger.b.b(r0)     // Catch:{ Exception -> 0x0212 }
            int r0 = r6.q()     // Catch:{ Exception -> 0x0212 }
            r6.e = r0     // Catch:{ Exception -> 0x0212 }
            goto L_0x00a0
        L_0x0076:
            java.lang.String r2 = "modified."
            com.xiaomi.channel.commonutils.logger.b.b(r2)     // Catch:{ Exception -> 0x0212 }
            android.content.Context r2 = r6.a     // Catch:{ Exception -> 0x0212 }
            int r0 = com.xiaomi.channel.commonutils.android.b.c(r2, r0)     // Catch:{ Exception -> 0x0212 }
            r6.e = r0     // Catch:{ Exception -> 0x0212 }
            int r0 = r6.e     // Catch:{ Exception -> 0x0212 }
            r6.b((int) r0)     // Catch:{ Exception -> 0x0212 }
            android.content.Context r0 = r6.a     // Catch:{ Exception -> 0x0212 }
            android.content.Context r2 = r6.a     // Catch:{ Exception -> 0x0212 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0212 }
            int r0 = com.xiaomi.channel.commonutils.android.b.b(r0, r2)     // Catch:{ Exception -> 0x0212 }
            r6.a((int) r0)     // Catch:{ Exception -> 0x0212 }
            long r0 = r1.lastModified()     // Catch:{ Exception -> 0x0212 }
            r6.a((long) r0)     // Catch:{ Exception -> 0x0212 }
            r0 = 1
            goto L_0x00a1
        L_0x00a0:
            r0 = 0
        L_0x00a1:
            java.lang.String r1 = r6.d()     // Catch:{ Exception -> 0x0212 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0212 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0212 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x0212 }
            if (r3 == 0) goto L_0x00d1
            boolean r3 = r6.h()     // Catch:{ Exception -> 0x0212 }
            if (r3 == 0) goto L_0x00cb
            android.content.Context r3 = r6.a     // Catch:{ Exception -> 0x0212 }
            int r1 = com.xiaomi.channel.commonutils.android.b.c(r3, r1)     // Catch:{ Exception -> 0x0212 }
            r6.f = r1     // Catch:{ Exception -> 0x0212 }
            int r1 = r6.f     // Catch:{ Exception -> 0x0212 }
            r6.c((int) r1)     // Catch:{ Exception -> 0x0212 }
            long r1 = r2.lastModified()     // Catch:{ Exception -> 0x0212 }
            r6.b((long) r1)     // Catch:{ Exception -> 0x0212 }
            goto L_0x00d2
        L_0x00cb:
            int r1 = r6.r()     // Catch:{ Exception -> 0x0212 }
            r6.f = r1     // Catch:{ Exception -> 0x0212 }
        L_0x00d1:
            r4 = 0
        L_0x00d2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0212 }
            r1.<init>()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r2 = "asset version "
            r1.append(r2)     // Catch:{ Exception -> 0x0212 }
            int r2 = r6.e     // Catch:{ Exception -> 0x0212 }
            r1.append(r2)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0212 }
            com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ Exception -> 0x0212 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0212 }
            r1.<init>()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r2 = "local version "
            r1.append(r2)     // Catch:{ Exception -> 0x0212 }
            int r2 = r6.f     // Catch:{ Exception -> 0x0212 }
            r1.append(r2)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0212 }
            com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ Exception -> 0x0212 }
            int r1 = r6.e     // Catch:{ Exception -> 0x0212 }
            int r2 = r6.f     // Catch:{ Exception -> 0x0212 }
            if (r1 < r2) goto L_0x0177
            int r1 = r6.e     // Catch:{ Exception -> 0x0212 }
            int r2 = r6.d     // Catch:{ Exception -> 0x0212 }
            if (r1 <= r2) goto L_0x01ea
            int r1 = r6.e     // Catch:{ Exception -> 0x0212 }
            r6.d = r1     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = r6.l()     // Catch:{ Exception -> 0x0212 }
            r6.c = r1     // Catch:{ Exception -> 0x0212 }
            if (r0 == 0) goto L_0x012f
            java.lang.String r0 = r6.c     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = r6.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0212 }
            r6.g = r0     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = r6.g     // Catch:{ Exception -> 0x0212 }
            r6.b((java.lang.String) r0)     // Catch:{ Exception -> 0x0212 }
            android.content.Context r0 = r6.a     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = r6.c     // Catch:{ Exception -> 0x0212 }
            java.lang.String r2 = r6.n()     // Catch:{ Exception -> 0x0212 }
            com.xiaomi.channel.commonutils.android.a.a(r0, r1, r2)     // Catch:{ Exception -> 0x0212 }
            goto L_0x0135
        L_0x012f:
            java.lang.String r0 = r6.u()     // Catch:{ Exception -> 0x0212 }
            r6.g = r0     // Catch:{ Exception -> 0x0212 }
        L_0x0135:
            dalvik.system.DexClassLoader r0 = new dalvik.system.DexClassLoader     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = r6.c     // Catch:{ Exception -> 0x0212 }
            android.content.Context r2 = r6.a     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = "dex"
            java.io.File r2 = r2.getDir(r3, r5)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = r6.n()     // Catch:{ Exception -> 0x0212 }
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ Exception -> 0x0212 }
            r0.<init>(r1, r2, r3, r4)     // Catch:{ Exception -> 0x0212 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r1.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = "load apk : "
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = r6.c     // Catch:{ all -> 0x0262 }
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = ", version : "
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            int r2 = r6.d     // Catch:{ all -> 0x0262 }
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0262 }
            com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = "load apk done."
            com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ all -> 0x0262 }
            monitor-exit(r6)
            return r0
        L_0x0177:
            int r0 = r6.f     // Catch:{ Exception -> 0x0212 }
            int r1 = r6.d     // Catch:{ Exception -> 0x0212 }
            if (r0 <= r1) goto L_0x01ea
            int r0 = r6.f     // Catch:{ Exception -> 0x0212 }
            r6.d = r0     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = r6.d()     // Catch:{ Exception -> 0x0212 }
            r6.c = r0     // Catch:{ Exception -> 0x0212 }
            if (r4 == 0) goto L_0x01a2
            java.lang.String r0 = r6.c     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = r6.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0212 }
            r6.g = r0     // Catch:{ Exception -> 0x0212 }
            java.lang.String r0 = r6.g     // Catch:{ Exception -> 0x0212 }
            r6.c((java.lang.String) r0)     // Catch:{ Exception -> 0x0212 }
            android.content.Context r0 = r6.a     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = r6.c     // Catch:{ Exception -> 0x0212 }
            java.lang.String r2 = r6.m()     // Catch:{ Exception -> 0x0212 }
            com.xiaomi.channel.commonutils.android.a.a(r0, r1, r2)     // Catch:{ Exception -> 0x0212 }
            goto L_0x01a8
        L_0x01a2:
            java.lang.String r0 = r6.v()     // Catch:{ Exception -> 0x0212 }
            r6.g = r0     // Catch:{ Exception -> 0x0212 }
        L_0x01a8:
            dalvik.system.DexClassLoader r0 = new dalvik.system.DexClassLoader     // Catch:{ Exception -> 0x0212 }
            java.lang.String r1 = r6.c     // Catch:{ Exception -> 0x0212 }
            android.content.Context r2 = r6.a     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = "dex"
            java.io.File r2 = r2.getDir(r3, r5)     // Catch:{ Exception -> 0x0212 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0212 }
            java.lang.String r3 = r6.m()     // Catch:{ Exception -> 0x0212 }
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ Exception -> 0x0212 }
            r0.<init>(r1, r2, r3, r4)     // Catch:{ Exception -> 0x0212 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r1.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = "load apk : "
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = r6.c     // Catch:{ all -> 0x0262 }
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = ", version : "
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            int r2 = r6.d     // Catch:{ all -> 0x0262 }
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0262 }
            com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = "load apk done."
            com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ all -> 0x0262 }
            monitor-exit(r6)
            return r0
        L_0x01ea:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r0.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = "load apk : "
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r6.c     // Catch:{ all -> 0x0262 }
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = ", version : "
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            int r1 = r6.d     // Catch:{ all -> 0x0262 }
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0262 }
            com.xiaomi.channel.commonutils.logger.b.b(r0)     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = "load apk done."
        L_0x020c:
            com.xiaomi.channel.commonutils.logger.b.b(r0)     // Catch:{ all -> 0x0262 }
            goto L_0x0239
        L_0x0210:
            r0 = move-exception
            goto L_0x023c
        L_0x0212:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0210 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r0.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = "load apk : "
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r6.c     // Catch:{ all -> 0x0262 }
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = ", version : "
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            int r1 = r6.d     // Catch:{ all -> 0x0262 }
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0262 }
            com.xiaomi.channel.commonutils.logger.b.b(r0)     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = "load apk done."
            goto L_0x020c
        L_0x0239:
            r0 = 0
            monitor-exit(r6)
            return r0
        L_0x023c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r1.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = "load apk : "
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = r6.c     // Catch:{ all -> 0x0262 }
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = ", version : "
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            int r2 = r6.d     // Catch:{ all -> 0x0262 }
            r1.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0262 }
            com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = "load apk done."
            com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ all -> 0x0262 }
            throw r0     // Catch:{ all -> 0x0262 }
        L_0x0262:
            r0 = move-exception
            monitor-exit(r6)
            goto L_0x0266
        L_0x0265:
            throw r0
        L_0x0266:
            goto L_0x0265
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.module.a.c():dalvik.system.DexClassLoader");
    }

    public String d() {
        return a(this.a, this.b);
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }
}
