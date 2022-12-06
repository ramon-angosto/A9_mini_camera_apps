package com.bytedance.sdk.component.adexpress.a.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.bytedance.sdk.component.adexpress.a.a.a;
import com.bytedance.sdk.component.adexpress.a.c.b;
import com.bytedance.sdk.component.utils.l;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: TmplDbHelper */
public class d {
    private static volatile d a;
    private Set<String> b = Collections.synchronizedSet(new HashSet());
    private final Object c = new Object();
    private LruCache<String, b> d = new LruCache<String, b>(2000) {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, b bVar) {
            return 1;
        }
    };

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private d() {
    }

    /* access modifiers changed from: package-private */
    public b a(String str) {
        b bVar;
        b a2;
        if (TextUtils.isEmpty(str) || a.a().b() == null) {
            return null;
        }
        synchronized (this.c) {
            bVar = this.d.get(String.valueOf(str));
        }
        if (bVar != null) {
            return bVar;
        }
        Cursor a3 = a.a().b().a("template_diff_new", (String[]) null, "id=?", new String[]{str}, (String) null, (String) null, (String) null);
        if (a3 != null) {
            try {
                if (a3.moveToFirst()) {
                    do {
                        String string = a3.getString(a3.getColumnIndex("rit"));
                        String string2 = a3.getString(a3.getColumnIndex("id"));
                        String string3 = a3.getString(a3.getColumnIndex(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5));
                        String string4 = a3.getString(a3.getColumnIndex("url"));
                        String string5 = a3.getString(a3.getColumnIndex(DataSchemeDataSource.SCHEME_DATA));
                        String string6 = a3.getString(a3.getColumnIndex("version"));
                        a2 = new b().a(string).b(string2).c(string3).d(string4).e(string5).f(string6).a(Long.valueOf(a3.getLong(a3.getColumnIndex("update_time"))));
                        synchronized (this.c) {
                            this.d.put(string2, a2);
                        }
                        this.b.add(string2);
                    } while (a3.moveToNext());
                    a3.close();
                    return a2;
                }
            } catch (Throwable th) {
                try {
                    l.c("TmplDbHelper", "getTemplate error", th);
                } catch (Throwable th2) {
                    a3.close();
                    throw th2;
                }
            }
            a3.close();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Set<String> b(String str) {
        if (!TextUtils.isEmpty(str) && a.a().b() != null) {
            HashSet hashSet = new HashSet();
            Cursor a2 = a.a().b().a("template_diff_new", (String[]) null, "rit=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (a2 != null) {
                try {
                    if (a2.moveToFirst()) {
                        do {
                            hashSet.add(a2.getString(a2.getColumnIndex("id")));
                        } while (a2.moveToNext());
                        a2.close();
                        return hashSet;
                    }
                } catch (Exception e) {
                    Log.e("TmplDbHelper", "", e);
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
                a2.close();
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b8, code lost:
        if (r1 != null) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ba, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c6, code lost:
        if (r1 == null) goto L_0x00d0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.bytedance.sdk.component.adexpress.a.c.b> b() {
        /*
            r10 = this;
            com.bytedance.sdk.component.adexpress.a.a.a r0 = com.bytedance.sdk.component.adexpress.a.a.a.a()
            com.bytedance.sdk.component.adexpress.a.a.b r0 = r0.b()
            if (r0 != 0) goto L_0x000c
            r0 = 0
            return r0
        L_0x000c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.bytedance.sdk.component.adexpress.a.a.a r1 = com.bytedance.sdk.component.adexpress.a.a.a.a()
            com.bytedance.sdk.component.adexpress.a.a.b r2 = r1.b()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r3 = "template_diff_new"
            android.database.Cursor r1 = r2.a(r3, r4, r5, r6, r7, r8, r9)
            if (r1 == 0) goto L_0x00d0
        L_0x0027:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x00be }
            if (r2 == 0) goto L_0x00b8
            java.lang.String r2 = "rit"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = "id"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r4 = "md5"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r1.getString(r4)     // Catch:{ all -> 0x00be }
            java.lang.String r5 = "url"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ all -> 0x00be }
            java.lang.String r5 = r1.getString(r5)     // Catch:{ all -> 0x00be }
            java.lang.String r6 = "data"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ all -> 0x00be }
            java.lang.String r6 = r1.getString(r6)     // Catch:{ all -> 0x00be }
            java.lang.String r7 = "version"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ all -> 0x00be }
            java.lang.String r7 = r1.getString(r7)     // Catch:{ all -> 0x00be }
            java.lang.String r8 = "update_time"
            int r8 = r1.getColumnIndex(r8)     // Catch:{ all -> 0x00be }
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x00be }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00be }
            com.bytedance.sdk.component.adexpress.a.c.b r9 = new com.bytedance.sdk.component.adexpress.a.c.b     // Catch:{ all -> 0x00be }
            r9.<init>()     // Catch:{ all -> 0x00be }
            com.bytedance.sdk.component.adexpress.a.c.b r2 = r9.a((java.lang.String) r2)     // Catch:{ all -> 0x00be }
            com.bytedance.sdk.component.adexpress.a.c.b r2 = r2.b(r3)     // Catch:{ all -> 0x00be }
            com.bytedance.sdk.component.adexpress.a.c.b r2 = r2.c(r4)     // Catch:{ all -> 0x00be }
            com.bytedance.sdk.component.adexpress.a.c.b r2 = r2.d(r5)     // Catch:{ all -> 0x00be }
            com.bytedance.sdk.component.adexpress.a.c.b r2 = r2.e(r6)     // Catch:{ all -> 0x00be }
            com.bytedance.sdk.component.adexpress.a.c.b r2 = r2.f(r7)     // Catch:{ all -> 0x00be }
            com.bytedance.sdk.component.adexpress.a.c.b r2 = r2.a((java.lang.Long) r8)     // Catch:{ all -> 0x00be }
            r0.add(r2)     // Catch:{ all -> 0x00be }
            java.lang.Object r2 = r10.c     // Catch:{ all -> 0x00be }
            monitor-enter(r2)     // Catch:{ all -> 0x00be }
            android.util.LruCache<java.lang.String, com.bytedance.sdk.component.adexpress.a.c.b> r4 = r10.d     // Catch:{ all -> 0x00b5 }
            int r5 = r0.size()     // Catch:{ all -> 0x00b5 }
            int r5 = r5 + -1
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x00b5 }
            r4.put(r3, r5)     // Catch:{ all -> 0x00b5 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b5 }
            java.util.Set<java.lang.String> r2 = r10.b     // Catch:{ all -> 0x00be }
            r2.add(r3)     // Catch:{ all -> 0x00be }
            goto L_0x0027
        L_0x00b5:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00b5 }
            throw r3     // Catch:{ all -> 0x00be }
        L_0x00b8:
            if (r1 == 0) goto L_0x00d0
        L_0x00ba:
            r1.close()
            goto L_0x00d0
        L_0x00be:
            r2 = move-exception
            java.lang.String r3 = "TmplDbHelper"
            java.lang.String r4 = "getTemplate error"
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r3, (java.lang.String) r4, (java.lang.Throwable) r2)     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00d0
            goto L_0x00ba
        L_0x00c9:
            r0 = move-exception
            if (r1 == 0) goto L_0x00cf
            r1.close()
        L_0x00cf:
            throw r0
        L_0x00d0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.a.b.d.b():java.util.List");
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        if (bVar != null && a.a().b() != null && !TextUtils.isEmpty(bVar.b())) {
            Cursor a2 = a.a().b().a("template_diff_new", (String[]) null, "id=?", new String[]{bVar.b()}, (String) null, (String) null, (String) null);
            boolean z = a2 != null && a2.getCount() > 0;
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Throwable unused) {
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("rit", bVar.a());
            contentValues.put("id", bVar.b());
            contentValues.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5, bVar.c());
            contentValues.put("url", bVar.d());
            contentValues.put(DataSchemeDataSource.SCHEME_DATA, bVar.e());
            contentValues.put("version", bVar.f());
            contentValues.put("update_time", bVar.g());
            if (z) {
                a.a().b().a("template_diff_new", contentValues, "id=?", new String[]{bVar.b()});
            } else {
                a.a().b().a("template_diff_new", contentValues);
            }
            synchronized (this.c) {
                this.d.put(bVar.b(), bVar);
            }
            this.b.add(bVar.b());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Set<String> set) {
        if (set != null && !set.isEmpty() && a.a().b() != null) {
            String[] strArr = (String[]) set.toArray(new String[set.size()]);
            if (strArr.length > 0) {
                for (int i = 0; i < strArr.length; i++) {
                    c(strArr[i]);
                    a.a().b().a("template_diff_new", "id=?", new String[]{strArr[i]});
                }
            }
        }
    }

    private void c(String str) {
        LruCache<String, b> lruCache;
        if (!TextUtils.isEmpty(str) && (lruCache = this.d) != null && lruCache.size() > 0) {
            synchronized (this.c) {
                this.d.remove(str);
            }
        }
    }

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS " + "template_diff_new" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "rit" + " TEXT ," + "id" + " TEXT UNIQUE," + AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5 + " TEXT ," + "url" + " TEXT , " + DataSchemeDataSource.SCHEME_DATA + " TEXT , " + "version" + " TEXT , " + "update_time" + " TEXT" + ")";
    }
}
