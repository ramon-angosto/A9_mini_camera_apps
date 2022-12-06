package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.multipro.a;

/* compiled from: DBMultiProviderImpl */
public class b implements a {
    private static final Object b = new Object();
    private Context a;

    public String a() {
        return "t_db";
    }

    public void b() {
    }

    private boolean b(Uri uri) {
        boolean z = uri == null || TextUtils.isEmpty(uri.getPath());
        if (z) {
            l.b("DBMultiProviderImpl", "==check uri is null==");
        }
        return z;
    }

    private Context c() {
        Context context = this.a;
        return context == null ? m.a() : context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor a(android.net.Uri r14, java.lang.String[] r15, java.lang.String r16, java.lang.String[] r17, java.lang.String r18) {
        /*
            r13 = this;
            java.lang.Object r1 = b
            monitor-enter(r1)
            boolean r0 = r13.b(r14)     // Catch:{ all -> 0x004a }
            r2 = 0
            if (r0 == 0) goto L_0x000c
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            return r2
        L_0x000c:
            java.lang.String r0 = r14.getPath()     // Catch:{ all -> 0x004a }
            java.lang.String r3 = "/"
            java.lang.String[] r0 = r0.split(r3)     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0048
            int r3 = r0.length     // Catch:{ all -> 0x004a }
            r4 = 4
            if (r3 >= r4) goto L_0x001d
            goto L_0x0048
        L_0x001d:
            r3 = 2
            r3 = r0[r3]     // Catch:{ all -> 0x004a }
            r4 = 3
            r6 = r0[r4]     // Catch:{ all -> 0x004a }
            java.lang.String r0 = "ttopensdk.db"
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0046
            android.content.Context r0 = r13.c()     // Catch:{ all -> 0x004a }
            com.bytedance.sdk.openadsdk.core.e r0 = com.bytedance.sdk.openadsdk.core.e.a(r0)     // Catch:{ all -> 0x004a }
            com.bytedance.sdk.openadsdk.core.f$c r5 = r0.a()     // Catch:{ all -> 0x004a }
            r10 = 0
            r11 = 0
            r7 = r15
            r8 = r16
            r9 = r17
            r12 = r18
            android.database.Cursor r0 = r5.a(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x004a }
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            return r0
        L_0x0046:
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            return r2
        L_0x0048:
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            return r2
        L_0x004a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.a.b.a(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(android.net.Uri r6) {
        /*
            r5 = this;
            java.lang.Object r0 = b
            monitor-enter(r0)
            boolean r1 = r5.b(r6)     // Catch:{ all -> 0x00a2 }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            return r2
        L_0x000c:
            java.lang.String r1 = r6.getPath()     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = "/"
            java.lang.String[] r1 = r1.split(r3)     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x00a0
            int r3 = r1.length     // Catch:{ all -> 0x00a2 }
            r4 = 5
            if (r3 >= r4) goto L_0x001e
            goto L_0x00a0
        L_0x001e:
            r3 = 2
            r3 = r1[r3]     // Catch:{ all -> 0x00a2 }
            r4 = 3
            r4 = r1[r4]     // Catch:{ all -> 0x00a2 }
            r4 = 4
            r1 = r1[r4]     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = "ttopensdk.db"
            boolean r3 = r4.equals(r3)     // Catch:{ all -> 0x00a2 }
            if (r3 == 0) goto L_0x009e
            java.lang.String r3 = "execSQL"
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x00a2 }
            if (r3 == 0) goto L_0x0057
            java.lang.String r1 = "sql"
            java.lang.String r6 = r6.getQueryParameter(r1)     // Catch:{ all -> 0x00a2 }
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a2 }
            if (r1 != 0) goto L_0x009e
            android.content.Context r1 = r5.c()     // Catch:{ all -> 0x00a2 }
            com.bytedance.sdk.openadsdk.core.e r1 = com.bytedance.sdk.openadsdk.core.e.a(r1)     // Catch:{ all -> 0x00a2 }
            com.bytedance.sdk.openadsdk.core.f$c r1 = r1.a()     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = android.net.Uri.decode(r6)     // Catch:{ all -> 0x00a2 }
            r1.a(r6)     // Catch:{ all -> 0x00a2 }
            goto L_0x009e
        L_0x0057:
            java.lang.String r6 = "transactionBegin"
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x00a2 }
            if (r6 == 0) goto L_0x006f
            android.content.Context r6 = r5.c()     // Catch:{ all -> 0x00a2 }
            com.bytedance.sdk.openadsdk.core.e r6 = com.bytedance.sdk.openadsdk.core.e.a(r6)     // Catch:{ all -> 0x00a2 }
            com.bytedance.sdk.openadsdk.core.f$c r6 = r6.a()     // Catch:{ all -> 0x00a2 }
            r6.b()     // Catch:{ all -> 0x00a2 }
            goto L_0x009e
        L_0x006f:
            java.lang.String r6 = "transactionSetSuccess"
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x00a2 }
            if (r6 == 0) goto L_0x0087
            android.content.Context r6 = r5.c()     // Catch:{ all -> 0x00a2 }
            com.bytedance.sdk.openadsdk.core.e r6 = com.bytedance.sdk.openadsdk.core.e.a(r6)     // Catch:{ all -> 0x00a2 }
            com.bytedance.sdk.openadsdk.core.f$c r6 = r6.a()     // Catch:{ all -> 0x00a2 }
            r6.c()     // Catch:{ all -> 0x00a2 }
            goto L_0x009e
        L_0x0087:
            java.lang.String r6 = "transactionEnd"
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x00a2 }
            if (r6 == 0) goto L_0x009e
            android.content.Context r6 = r5.c()     // Catch:{ all -> 0x00a2 }
            com.bytedance.sdk.openadsdk.core.e r6 = com.bytedance.sdk.openadsdk.core.e.a(r6)     // Catch:{ all -> 0x00a2 }
            com.bytedance.sdk.openadsdk.core.f$c r6 = r6.a()     // Catch:{ all -> 0x00a2 }
            r6.d()     // Catch:{ all -> 0x00a2 }
        L_0x009e:
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            return r2
        L_0x00a0:
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            return r2
        L_0x00a2:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.a.b.a(android.net.Uri):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.net.Uri a(android.net.Uri r5, android.content.ContentValues r6) {
        /*
            r4 = this;
            java.lang.Object r0 = b
            monitor-enter(r0)
            boolean r1 = r4.b(r5)     // Catch:{ all -> 0x003e }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r2
        L_0x000c:
            java.lang.String r5 = r5.getPath()     // Catch:{ all -> 0x003e }
            java.lang.String r1 = "/"
            java.lang.String[] r5 = r5.split(r1)     // Catch:{ all -> 0x003e }
            if (r5 == 0) goto L_0x003c
            int r1 = r5.length     // Catch:{ all -> 0x003e }
            r3 = 4
            if (r1 >= r3) goto L_0x001d
            goto L_0x003c
        L_0x001d:
            r1 = 2
            r1 = r5[r1]     // Catch:{ all -> 0x003e }
            r3 = 3
            r5 = r5[r3]     // Catch:{ all -> 0x003e }
            java.lang.String r3 = "ttopensdk.db"
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x003a
            android.content.Context r1 = r4.c()     // Catch:{ all -> 0x003e }
            com.bytedance.sdk.openadsdk.core.e r1 = com.bytedance.sdk.openadsdk.core.e.a(r1)     // Catch:{ all -> 0x003e }
            com.bytedance.sdk.openadsdk.core.f$c r1 = r1.a()     // Catch:{ all -> 0x003e }
            r1.a((java.lang.String) r5, (java.lang.String) r2, (android.content.ContentValues) r6)     // Catch:{ all -> 0x003e }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r2
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r2
        L_0x003e:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.a.b.a(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(android.net.Uri r5, java.lang.String r6, java.lang.String[] r7) {
        /*
            r4 = this;
            java.lang.Object r0 = b
            monitor-enter(r0)
            boolean r1 = r4.b(r5)     // Catch:{ all -> 0x0041 }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r2
        L_0x000c:
            java.lang.String r5 = r5.getPath()     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = "/"
            java.lang.String[] r5 = r5.split(r1)     // Catch:{ all -> 0x0041 }
            if (r5 == 0) goto L_0x003f
            int r1 = r5.length     // Catch:{ all -> 0x0041 }
            r3 = 4
            if (r1 >= r3) goto L_0x001d
            goto L_0x003f
        L_0x001d:
            r1 = 2
            r1 = r5[r1]     // Catch:{ all -> 0x0041 }
            r3 = 3
            r5 = r5[r3]     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "ttopensdk.db"
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x003d
            android.content.Context r1 = r4.c()     // Catch:{ all -> 0x0041 }
            com.bytedance.sdk.openadsdk.core.e r1 = com.bytedance.sdk.openadsdk.core.e.a(r1)     // Catch:{ all -> 0x0041 }
            com.bytedance.sdk.openadsdk.core.f$c r1 = r1.a()     // Catch:{ all -> 0x0041 }
            int r5 = r1.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String[]) r7)     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r5
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r2
        L_0x003f:
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r2
        L_0x0041:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.a.b.a(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(android.net.Uri r5, android.content.ContentValues r6, java.lang.String r7, java.lang.String[] r8) {
        /*
            r4 = this;
            java.lang.Object r0 = b
            monitor-enter(r0)
            boolean r1 = r4.b(r5)     // Catch:{ all -> 0x0041 }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r2
        L_0x000c:
            java.lang.String r5 = r5.getPath()     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = "/"
            java.lang.String[] r5 = r5.split(r1)     // Catch:{ all -> 0x0041 }
            if (r5 == 0) goto L_0x003f
            int r1 = r5.length     // Catch:{ all -> 0x0041 }
            r3 = 4
            if (r1 >= r3) goto L_0x001d
            goto L_0x003f
        L_0x001d:
            r1 = 2
            r1 = r5[r1]     // Catch:{ all -> 0x0041 }
            r3 = 3
            r5 = r5[r3]     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "ttopensdk.db"
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x003d
            android.content.Context r1 = r4.c()     // Catch:{ all -> 0x0041 }
            com.bytedance.sdk.openadsdk.core.e r1 = com.bytedance.sdk.openadsdk.core.e.a(r1)     // Catch:{ all -> 0x0041 }
            com.bytedance.sdk.openadsdk.core.f$c r1 = r1.a()     // Catch:{ all -> 0x0041 }
            int r5 = r1.a(r5, r6, r7, r8)     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r5
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r2
        L_0x003f:
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r2
        L_0x0041:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.a.b.a(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
