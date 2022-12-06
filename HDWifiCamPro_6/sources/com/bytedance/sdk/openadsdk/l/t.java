package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.m;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* compiled from: TTCrashHandler */
public class t implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    private String b;

    public static t a() {
        return new t();
    }

    private t() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    private void b() {
        Context a2 = m.a();
        if (a2 != null) {
            try {
                File file = new File(a2.getFilesDir(), "TTCache");
                file.mkdirs();
                this.b = file.getPath();
            } catch (Throwable unused) {
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        boolean z = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (stringWriter2 != null) {
                z = stringWriter2.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (z) {
            a(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f7 A[SYNTHETIC, Splitter:B:55:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010b A[SYNTHETIC, Splitter:B:68:0x010b] */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.Thread r18, java.lang.Throwable r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = ", "
            java.lang.String r2 = "0"
            java.lang.String r3 = "TTCrashHandler"
            r4 = 0
            java.lang.String r5 = r1.b     // Catch:{ all -> 0x0102 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0102 }
            if (r5 == 0) goto L_0x0014
            r17.b()     // Catch:{ all -> 0x0102 }
        L_0x0014:
            java.lang.String r5 = r1.b     // Catch:{ all -> 0x0102 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0102 }
            if (r5 == 0) goto L_0x001d
            return
        L_0x001d:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0102 }
            java.lang.String r6 = r1.b     // Catch:{ all -> 0x0102 }
            java.lang.String r7 = "tt_crash_count.properties"
            r5.<init>(r6, r7)     // Catch:{ all -> 0x0102 }
            boolean r6 = r5.exists()     // Catch:{ all -> 0x0102 }
            java.lang.String r7 = "tt_crash_info"
            java.lang.String r8 = "crash_last_time"
            java.lang.String r9 = "crash_count"
            r10 = 1
            if (r6 == 0) goto L_0x00d1
            boolean r6 = r5.isFile()     // Catch:{ all -> 0x0102 }
            if (r6 == 0) goto L_0x00d1
            boolean r6 = r5.canRead()     // Catch:{ all -> 0x0102 }
            if (r6 == 0) goto L_0x00d1
            java.util.Properties r6 = new java.util.Properties     // Catch:{ all -> 0x0102 }
            r6.<init>()     // Catch:{ all -> 0x0102 }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ all -> 0x0102 }
            r11.<init>(r5)     // Catch:{ all -> 0x0102 }
            r6.load(r11)     // Catch:{ all -> 0x00cd }
            java.lang.String r12 = r6.getProperty(r9, r2)     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = r6.getProperty(r8, r2)     // Catch:{ all -> 0x00cd }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x00cd }
            int r12 = r12.intValue()     // Catch:{ all -> 0x00cd }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00cd }
            long r13 = r2.longValue()     // Catch:{ all -> 0x00cd }
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cd }
            long r15 = r15 - r13
            r13 = 300000(0x493e0, double:1.482197E-318)
            int r2 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            r13 = 0
            if (r2 >= 0) goto L_0x0075
            int r2 = r12 + 1
            r12 = r13
            goto L_0x0077
        L_0x0075:
            r2 = r10
            r12 = r2
        L_0x0077:
            r14 = 3
            if (r2 < r14) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r10 = r13
        L_0x007c:
            if (r10 == 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r13 = r2
        L_0x0080:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r2.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r14 = "=="
            r2.append(r14)     // Catch:{ all -> 0x00cd }
            r2.append(r13)     // Catch:{ all -> 0x00cd }
            r2.append(r0)     // Catch:{ all -> 0x00cd }
            r2.append(r10)     // Catch:{ all -> 0x00cd }
            r2.append(r0)     // Catch:{ all -> 0x00cd }
            r2.append(r12)     // Catch:{ all -> 0x00cd }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00cd }
            com.bytedance.sdk.component.utils.l.e(r3, r0)     // Catch:{ all -> 0x00cd }
            if (r10 == 0) goto L_0x00a6
            r5.delete()     // Catch:{ all -> 0x00c3 }
            goto L_0x00c3
        L_0x00a6:
            java.lang.String r0 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x00cd }
            r6.setProperty(r9, r0)     // Catch:{ all -> 0x00cd }
            if (r12 == 0) goto L_0x00ba
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cd }
            java.lang.String r0 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x00cd }
            r6.setProperty(r8, r0)     // Catch:{ all -> 0x00cd }
        L_0x00ba:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00cd }
            r2.<init>(r5)     // Catch:{ all -> 0x00cd }
            r6.store(r2, r7)     // Catch:{ all -> 0x00cb }
            r4 = r2
        L_0x00c3:
            if (r10 == 0) goto L_0x00c8
            r17.c()     // Catch:{ all -> 0x00cd }
        L_0x00c8:
            r2 = r4
            r4 = r11
            goto L_0x00f5
        L_0x00cb:
            r0 = move-exception
            goto L_0x00cf
        L_0x00cd:
            r0 = move-exception
            r2 = r4
        L_0x00cf:
            r4 = r11
            goto L_0x0104
        L_0x00d1:
            java.util.Properties r0 = new java.util.Properties     // Catch:{ all -> 0x0102 }
            r0.<init>()     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0102 }
            r0.setProperty(r9, r2)     // Catch:{ all -> 0x0102 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0102 }
            r0.setProperty(r8, r2)     // Catch:{ all -> 0x0102 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0102 }
            r2.<init>(r5)     // Catch:{ all -> 0x0102 }
            r0.store(r2, r7)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "==first"
            com.bytedance.sdk.component.utils.l.e(r3, r0)     // Catch:{ all -> 0x0100 }
        L_0x00f5:
            if (r4 == 0) goto L_0x00fa
            r4.close()     // Catch:{ all -> 0x00fa }
        L_0x00fa:
            if (r2 == 0) goto L_0x0111
        L_0x00fc:
            r2.close()     // Catch:{ all -> 0x0111 }
            goto L_0x0111
        L_0x0100:
            r0 = move-exception
            goto L_0x0104
        L_0x0102:
            r0 = move-exception
            r2 = r4
        L_0x0104:
            java.lang.String r5 = "crash count error"
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r3, (java.lang.String) r5, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0112 }
            if (r4 == 0) goto L_0x010e
            r4.close()     // Catch:{ all -> 0x010e }
        L_0x010e:
            if (r2 == 0) goto L_0x0111
            goto L_0x00fc
        L_0x0111:
            return
        L_0x0112:
            r0 = move-exception
            if (r4 == 0) goto L_0x0118
            r4.close()     // Catch:{ all -> 0x0118 }
        L_0x0118:
            if (r2 == 0) goto L_0x011d
            r2.close()     // Catch:{ all -> 0x011d }
        L_0x011d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.t.a(java.lang.Thread, java.lang.Throwable):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|(1:4)|5|7|8|(1:10)|11|12|13|14|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0037 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r7 = this;
            java.lang.String r0 = "a"
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r4 = "com.bytedance.sdk.openadsdk.TTC2Proxy"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x001e }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r2] = r6     // Catch:{ all -> 0x001e }
            java.lang.reflect.Method r4 = com.bytedance.sdk.component.utils.w.a(r4, r0, r5)     // Catch:{ all -> 0x001e }
            if (r4 == 0) goto L_0x001e
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x001e }
            android.content.Context r6 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x001e }
            r5[r2] = r6     // Catch:{ all -> 0x001e }
            r4.invoke(r1, r5)     // Catch:{ all -> 0x001e }
        L_0x001e:
            java.lang.String r4 = "com.bytedance.sdk.openadsdk.TTC3Proxy"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x0037 }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r2] = r6     // Catch:{ all -> 0x0037 }
            java.lang.reflect.Method r0 = com.bytedance.sdk.component.utils.w.a(r4, r0, r5)     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0037
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0037 }
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x0037 }
            r3[r2] = r4     // Catch:{ all -> 0x0037 }
            r0.invoke(r1, r3)     // Catch:{ all -> 0x0037 }
        L_0x0037:
            com.bytedance.sdk.openadsdk.core.settings.j.a()     // Catch:{ all -> 0x003a }
        L_0x003a:
            com.bytedance.sdk.component.adexpress.a.b.a.b()     // Catch:{ all -> 0x0042 }
            java.lang.String r0 = "2"
            com.bytedance.sdk.openadsdk.h.b.c((java.lang.String) r0)     // Catch:{ all -> 0x0042 }
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.t.c():void");
    }
}
