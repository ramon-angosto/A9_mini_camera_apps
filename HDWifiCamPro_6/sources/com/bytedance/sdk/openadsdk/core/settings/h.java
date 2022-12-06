package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.settings.d;
import com.bytedance.sdk.openadsdk.l.w;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* compiled from: SettingsPropRepository */
public class h implements d {
    private final ConcurrentHashMap<String, Object> c = new ConcurrentHashMap<>();
    private final Object d = new Object();
    private final Object e = new Object();
    private final CountDownLatch f = new CountDownLatch(1);
    /* access modifiers changed from: private */
    public Properties g = new Properties();
    private volatile boolean h = false;

    public h() {
        w.a((g) new g("SetL") {
            public void run() {
                h.this.a(false);
            }
        });
    }

    public String a(String str, String str2) {
        Log.d("SdkSettings.Prop", "getString() called with: key = [" + str + "], defaultValue = [" + str2 + "]");
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        c();
        return this.g.getProperty(str, str2);
    }

    private void c() {
        while (!this.h) {
            try {
                this.f.await();
            } catch (InterruptedException e2) {
                l.c("SdkSettings.Prop", "awaitLoadedLocked: ", (Throwable) e2);
            }
        }
    }

    public int a(String str, int i) {
        Log.d("SdkSettings.Prop", "getInt() called with: key = [" + str + "], defaultValue = [" + i + "]");
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        c();
        try {
            return Integer.parseInt(this.g.getProperty(str, String.valueOf(i)));
        } catch (NumberFormatException e2) {
            l.c("SdkSettings.Prop", "", (Throwable) e2);
            return i;
        }
    }

    public long a(String str, long j) {
        Log.d("SdkSettings.Prop", "getLong() called with: key = [" + str + "], defaultValue = [" + j + "]");
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        c();
        try {
            return Long.parseLong(this.g.getProperty(str, String.valueOf(j)));
        } catch (NumberFormatException e2) {
            l.c("SdkSettings.Prop", "", (Throwable) e2);
            return j;
        }
    }

    public float a(String str, float f2) {
        Log.d("SdkSettings.Prop", "getFloat() called with: key = [" + str + "], defaultValue = [" + f2 + "]");
        if (TextUtils.isEmpty(str)) {
            return f2;
        }
        c();
        try {
            return Float.parseFloat(this.g.getProperty(str, String.valueOf(f2)));
        } catch (NumberFormatException e2) {
            l.c("SdkSettings.Prop", "", (Throwable) e2);
            return f2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4 A[SYNTHETIC, Splitter:B:32:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.d
            monitor-enter(r0)
            boolean r1 = r9.h     // Catch:{ all -> 0x011f }
            if (r1 == 0) goto L_0x0012
            if (r10 != 0) goto L_0x0012
            java.lang.String r10 = "SdkSettings.Prop"
            java.lang.String r1 = "reload: already loaded, ignore"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r10, (java.lang.String) r1)     // Catch:{ all -> 0x011f }
            monitor-exit(r0)     // Catch:{ all -> 0x011f }
            return
        L_0x0012:
            java.io.File r10 = r9.d()     // Catch:{ all -> 0x011f }
            java.lang.String r1 = "SdkSettings.Prop"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r2.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "reload: "
            r2.append(r3)     // Catch:{ all -> 0x011f }
            java.lang.String r3 = r10.getAbsolutePath()     // Catch:{ all -> 0x011f }
            r2.append(r3)     // Catch:{ all -> 0x011f }
            java.lang.String r3 = ", exist? "
            r2.append(r3)     // Catch:{ all -> 0x011f }
            boolean r3 = r10.exists()     // Catch:{ all -> 0x011f }
            r2.append(r3)     // Catch:{ all -> 0x011f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x011f }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x011f }
            boolean r1 = r10.exists()     // Catch:{ all -> 0x011f }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x00b5
            java.util.Properties r1 = new java.util.Properties     // Catch:{ all -> 0x011f }
            r1.<init>()     // Catch:{ all -> 0x011f }
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x009a }
            r5.<init>(r10)     // Catch:{ Exception -> 0x009a }
            r1.load(r5)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r4 = "SdkSettings.Prop"
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r7 = "reload: find"
            r6[r2] = r7     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            int r2 = r1.size()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r6[r3] = r2     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r2 = 2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r7.<init>()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r8 = "items from "
            r7.append(r8)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r10 = r10.getAbsolutePath()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r7.append(r10)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r10 = r7.toString()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r6[r2] = r10     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            com.bytedance.sdk.component.utils.l.a((java.lang.String) r4, (java.lang.Object[]) r6)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            boolean r10 = r1.isEmpty()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            if (r10 != 0) goto L_0x0088
            r9.g = r1     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
        L_0x0088:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r5)     // Catch:{ all -> 0x011f }
            java.lang.Object r10 = r9.d     // Catch:{ all -> 0x011f }
        L_0x008d:
            r10.notifyAll()     // Catch:{ all -> 0x011f }
            goto L_0x0116
        L_0x0092:
            r10 = move-exception
            goto L_0x00aa
        L_0x0094:
            r10 = move-exception
            r4 = r5
            goto L_0x009b
        L_0x0097:
            r10 = move-exception
            r5 = r4
            goto L_0x00aa
        L_0x009a:
            r10 = move-exception
        L_0x009b:
            java.lang.String r1 = "SdkSettings.Prop"
            java.lang.String r2 = "reload: "
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r10)     // Catch:{ all -> 0x0097 }
            if (r4 == 0) goto L_0x00a7
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)     // Catch:{ all -> 0x011f }
        L_0x00a7:
            java.lang.Object r10 = r9.d     // Catch:{ all -> 0x011f }
            goto L_0x008d
        L_0x00aa:
            if (r5 == 0) goto L_0x00af
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r5)     // Catch:{ all -> 0x011f }
        L_0x00af:
            java.lang.Object r1 = r9.d     // Catch:{ all -> 0x011f }
            r1.notifyAll()     // Catch:{ all -> 0x011f }
            throw r10     // Catch:{ all -> 0x011f }
        L_0x00b5:
            android.content.Context r10 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x011f }
            boolean r10 = com.bytedance.sdk.component.utils.r.a(r10)     // Catch:{ all -> 0x011f }
            if (r10 == 0) goto L_0x0116
            android.content.Context r10 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x011f }
            java.lang.String r1 = "tt_sdk_settings"
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x011f }
            java.util.Map r1 = r10.getAll()     // Catch:{ all -> 0x011f }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x011f }
            if (r1 != 0) goto L_0x0116
            java.lang.String r1 = "SdkSettings.Prop"
            java.lang.String r2 = "reload: copy old data from sp"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x011f }
            com.bytedance.sdk.openadsdk.core.settings.d$a r1 = r9.a()     // Catch:{ all -> 0x011f }
            java.util.Map r2 = r10.getAll()     // Catch:{ all -> 0x011f }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x011f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x011f }
        L_0x00ea:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x011f }
            if (r4 == 0) goto L_0x0108
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x011f }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x011f }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x011f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x011f }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x011f }
            r1.a((java.lang.String) r5, (java.lang.String) r4)     // Catch:{ all -> 0x011f }
            goto L_0x00ea
        L_0x0108:
            r1.a()     // Catch:{ all -> 0x011f }
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ all -> 0x011f }
            android.content.SharedPreferences$Editor r10 = r10.clear()     // Catch:{ all -> 0x011f }
            r10.commit()     // Catch:{ all -> 0x011f }
        L_0x0116:
            r9.h = r3     // Catch:{ all -> 0x011f }
            java.util.concurrent.CountDownLatch r10 = r9.f     // Catch:{ all -> 0x011f }
            r10.countDown()     // Catch:{ all -> 0x011f }
            monitor-exit(r0)     // Catch:{ all -> 0x011f }
            return
        L_0x011f:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011f }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.h.a(boolean):void");
    }

    private File d() {
        return new File(m.a().getFilesDir(), "tt_sdk_settings.prop");
    }

    public d.a a() {
        return new a();
    }

    public <T> T a(String str, T t, d.b<T> bVar) {
        T b;
        if (TextUtils.isEmpty(str)) {
            return t;
        }
        if (this.c.containsKey(str)) {
            try {
                return this.c.get(str);
            } catch (Exception e2) {
                l.c("SdkSettings.Prop", "", (Throwable) e2);
                return t;
            }
        } else {
            c();
            String property = this.g.getProperty(str, (String) null);
            if (property == null || bVar == null || (b = bVar.b(property)) == null) {
                return t;
            }
            this.c.put(str, b);
            return b;
        }
    }

    public boolean b() {
        return this.h;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[SYNTHETIC, Splitter:B:21:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d A[SYNTHETIC, Splitter:B:27:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.Properties r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.e
            monitor-enter(r0)
            java.io.File r1 = r6.d()     // Catch:{ all -> 0x0051 }
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0035 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0035 }
            r7.store(r3, r2)     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            java.lang.String r7 = "SdkSettings.Prop"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r4 = 0
            java.lang.String r5 = "saveToLocal: save to"
            r2[r4] = r5     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r4 = 1
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r2[r4] = r1     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r1 = 2
            java.lang.String r4 = "success"
            r2[r1] = r4     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            com.bytedance.sdk.component.utils.l.a((java.lang.String) r7, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)     // Catch:{ all -> 0x0051 }
            goto L_0x0042
        L_0x002d:
            r7 = move-exception
            goto L_0x004b
        L_0x002f:
            r7 = move-exception
            r2 = r3
            goto L_0x0036
        L_0x0032:
            r7 = move-exception
            r3 = r2
            goto L_0x004b
        L_0x0035:
            r7 = move-exception
        L_0x0036:
            java.lang.String r1 = "SdkSettings.Prop"
            java.lang.String r3 = "saveToLocal: "
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r7)     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0042
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ all -> 0x0051 }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            com.bytedance.sdk.openadsdk.core.settings.j r7 = com.bytedance.sdk.openadsdk.core.settings.j.b()
            r7.W()
            return
        L_0x004b:
            if (r3 == 0) goto L_0x0050
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)     // Catch:{ all -> 0x0051 }
        L_0x0050:
            throw r7     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.h.a(java.util.Properties):void");
    }

    /* compiled from: SettingsPropRepository */
    public class a implements d.a {
        private final Map<String, Object> b = new HashMap();
        private final Object c = new Object();

        public a() {
        }

        public void a() {
            Object obj;
            boolean z = false;
            l.a("SdkSettings.Prop", "commit: ", this.b);
            Properties properties = new Properties();
            synchronized (this.c) {
                properties.putAll(h.this.g);
                for (Map.Entry next : this.b.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value != this) {
                        if (value != null) {
                            if (!properties.containsKey(str) || (obj = properties.get(str)) == null || !obj.equals(value)) {
                                properties.put(str, String.valueOf(value));
                                z = true;
                            }
                        }
                    }
                    if (properties.containsKey(str)) {
                        properties.remove(str);
                        z = true;
                    }
                }
                this.b.clear();
                if (z) {
                    h.this.a(properties);
                    Properties unused = h.this.g = properties;
                }
            }
        }

        public d.a a(String str, String str2) {
            synchronized (this.c) {
                this.b.put(str, str2);
            }
            return this;
        }

        public d.a a(String str, int i) {
            synchronized (this.c) {
                this.b.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public d.a a(String str, long j) {
            synchronized (this.c) {
                this.b.put(str, Long.valueOf(j));
            }
            return this;
        }

        public d.a a(String str) {
            synchronized (this.c) {
                this.b.put(str, this);
            }
            return this;
        }

        public d.a a(String str, float f) {
            synchronized (this.c) {
                this.b.put(str, Float.valueOf(f));
            }
            return this;
        }
    }
}
