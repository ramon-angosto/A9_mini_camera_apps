package com.bytedance.sdk.openadsdk.multipro;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: TTMultiInitHelper */
public class c {
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r2) {
        /*
            if (r2 != 0) goto L_0x0003
            return
        L_0x0003:
            android.content.Context r0 = r2.getApplicationContext()
            com.bytedance.sdk.openadsdk.multipro.d.a.a((android.content.Context) r0)
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0044 }
            r1 = 28
            if (r0 < r1) goto L_0x004c
            boolean r0 = com.bytedance.sdk.component.utils.r.a(r2)     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x001a
            b(r2)     // Catch:{ all -> 0x0044 }
            goto L_0x004c
        L_0x001a:
            java.lang.String r0 = com.bytedance.sdk.component.utils.r.b(r2)     // Catch:{ all -> 0x0044 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IllegalStateException -> 0x0040, Exception -> 0x004c }
            if (r1 == 0) goto L_0x003c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0040, Exception -> 0x004c }
            r1.<init>()     // Catch:{ IllegalStateException -> 0x0040, Exception -> 0x004c }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ IllegalStateException -> 0x0040, Exception -> 0x004c }
            r1.append(r2)     // Catch:{ IllegalStateException -> 0x0040, Exception -> 0x004c }
            int r2 = android.os.Process.myPid()     // Catch:{ IllegalStateException -> 0x0040, Exception -> 0x004c }
            r1.append(r2)     // Catch:{ IllegalStateException -> 0x0040, Exception -> 0x004c }
            java.lang.String r2 = r1.toString()     // Catch:{ IllegalStateException -> 0x0040, Exception -> 0x004c }
            r0 = r2
        L_0x003c:
            android.webkit.WebView.setDataDirectorySuffix(r0)     // Catch:{ IllegalStateException -> 0x0040, Exception -> 0x004c }
            goto L_0x004c
        L_0x0040:
            a((java.lang.String) r0)     // Catch:{ all -> 0x0044 }
            goto L_0x004c
        L_0x0044:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.bytedance.sdk.component.utils.l.d(r2)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.c.a(android.content.Context):void");
    }

    private static void a(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke((Object) null, new Object[]{"android.webkit.WebViewFactory"});
            Field field = (Field) declaredMethod2.invoke(cls, new Object[]{"sDataDirectorySuffix"});
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v21, resolved type: java.nio.channels.FileLock} */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v26 */
    /* JADX WARNING: type inference failed for: r7v28 */
    /* JADX WARNING: type inference failed for: r7v30 */
    /* JADX WARNING: type inference failed for: r7v31 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:18|17|37|38|(2:40|41)|(3:45|46|65)(1:63)) */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d5, code lost:
        r2 = th;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00dc, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00dd, code lost:
        com.bytedance.sdk.component.utils.l.b("checkWebViewDataLock try close exclusiveFileChannel : " + r7.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f9, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fa, code lost:
        com.bytedance.sdk.component.utils.l.b("checkWebViewDataLock try close accessFile : " + r7.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0097 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c A[SYNTHETIC, Splitter:B:40:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9 A[SYNTHETIC, Splitter:B:45:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d8 A[SYNTHETIC, Splitter:B:52:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f5 A[SYNTHETIC, Splitter:B:57:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.Context r7) {
        /*
            java.lang.String r0 = "checkWebViewDataLock try close accessFile : "
            java.lang.String r1 = "checkWebViewDataLock try close exclusiveFileChannel : "
            java.lang.String r2 = a()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x0011
            java.lang.String r2 = "webview"
            goto L_0x0022
        L_0x0011:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "webview_"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
        L_0x0022:
            r3 = 0
            java.io.File r7 = r7.getDir(r2, r3)
            java.lang.String r7 = r7.getPath()
            java.io.File r2 = new java.io.File
            java.lang.String r3 = "webview_data.lock"
            r2.<init>(r7, r3)
            java.lang.String r7 = r2.getAbsolutePath()
            java.lang.String r3 = "TTMultiInitHelper"
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r3, (java.lang.String) r7)
            boolean r7 = r2.exists()
            if (r7 != 0) goto L_0x0042
            return
        L_0x0042:
            r7 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0096, all -> 0x0093 }
            java.lang.String r4 = "rw"
            r3.<init>(r2, r4)     // Catch:{ Exception -> 0x0096, all -> 0x0093 }
            java.nio.channels.FileChannel r4 = r3.getChannel()     // Catch:{ Exception -> 0x0097 }
            if (r4 == 0) goto L_0x005c
            java.nio.channels.FileLock r7 = r4.tryLock()     // Catch:{ Exception -> 0x005a, all -> 0x0055 }
            goto L_0x005c
        L_0x0055:
            r7 = move-exception
            r2 = r7
            r7 = r4
            goto L_0x00d6
        L_0x005a:
            r7 = r4
            goto L_0x0097
        L_0x005c:
            if (r7 == 0) goto L_0x0068
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x005a, all -> 0x0055 }
            r6 = 19
            if (r5 < r6) goto L_0x006b
            r7.close()     // Catch:{ Exception -> 0x005a, all -> 0x0055 }
            goto L_0x006b
        L_0x0068:
            a((java.io.File) r2)     // Catch:{ Exception -> 0x005a, all -> 0x0055 }
        L_0x006b:
            if (r4 == 0) goto L_0x0088
            r4.close()     // Catch:{ all -> 0x0071 }
            goto L_0x0088
        L_0x0071:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.bytedance.sdk.component.utils.l.b(r7)
        L_0x0088:
            r3.close()     // Catch:{ all -> 0x008c }
            goto L_0x00d4
        L_0x008c:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x00c3
        L_0x0093:
            r2 = move-exception
            r3 = r7
            goto L_0x00d6
        L_0x0096:
            r3 = r7
        L_0x0097:
            a((java.io.File) r2)     // Catch:{ all -> 0x00d5 }
            if (r7 == 0) goto L_0x00b7
            r7.close()     // Catch:{ all -> 0x00a0 }
            goto L_0x00b7
        L_0x00a0:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.bytedance.sdk.component.utils.l.b(r7)
        L_0x00b7:
            if (r3 == 0) goto L_0x00d4
            r3.close()     // Catch:{ all -> 0x00bd }
            goto L_0x00d4
        L_0x00bd:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x00c3:
            r1.append(r0)
            java.lang.String r7 = r7.getMessage()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.bytedance.sdk.component.utils.l.b(r7)
        L_0x00d4:
            return
        L_0x00d5:
            r2 = move-exception
        L_0x00d6:
            if (r7 == 0) goto L_0x00f3
            r7.close()     // Catch:{ all -> 0x00dc }
            goto L_0x00f3
        L_0x00dc:
            r7 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r7 = r7.getMessage()
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            com.bytedance.sdk.component.utils.l.b(r7)
        L_0x00f3:
            if (r3 == 0) goto L_0x0110
            r3.close()     // Catch:{ all -> 0x00f9 }
            goto L_0x0110
        L_0x00f9:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r7 = r7.getMessage()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.bytedance.sdk.component.utils.l.b(r7)
        L_0x0110:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.c.b(android.content.Context):void");
    }

    private static void a(File file) {
        a(file, file.exists() ? file.delete() : false);
    }

    private static void a(File file, boolean z) {
        if (z && !file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String a() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke((Object) null, new Object[]{"android.webkit.WebViewFactory"});
            return (String) ((Field) declaredMethod2.invoke(cls, new Object[]{"sDataDirectorySuffix"})).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
