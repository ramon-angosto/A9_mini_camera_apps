package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.push.do */
public class C1729do implements LoggerInterface {

    /* renamed from: a */
    private static volatile C1729do f2059a;

    /* renamed from: a */
    public static String f2060a = "/MiPushLog";

    /* renamed from: a */
    private static final SimpleDateFormat f2061a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: a */
    private static List<Pair<String, Throwable>> f2062a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a */
    private Context f2063a;

    /* renamed from: a */
    private Handler f2064a;

    /* renamed from: b */
    private String f2065b;

    /* renamed from: c */
    private String f2066c = "";

    private C1729do(Context context) {
        this.f2063a = context;
        if (context.getApplicationContext() != null) {
            this.f2063a = context.getApplicationContext();
        }
        this.f2065b = this.f2063a.getPackageName();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f2064a = new Handler(handlerThread.getLooper());
    }

    /* renamed from: a */
    public static C1729do m3031a(Context context) {
        if (f2059a == null) {
            synchronized (C1729do.class) {
                if (f2059a == null) {
                    f2059a = new C1729do(context);
                }
            }
        }
        return f2059a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.io.RandomAccessFile} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.BufferedWriter, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01a1 A[SYNTHETIC, Splitter:B:104:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0157 A[SYNTHETIC, Splitter:B:74:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0175 A[SYNTHETIC, Splitter:B:86:0x0175] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0183 A[SYNTHETIC, Splitter:B:92:0x0183] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3035a() {
        /*
            r11 = this;
            java.lang.String r0 = "log1.txt"
            java.lang.String r1 = ""
            r2 = 0
            java.lang.String r3 = r11.f2066c     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            if (r3 == 0) goto L_0x002a
            android.content.Context r3 = r11.f2063a     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.io.File r3 = r3.getExternalFilesDir(r2)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            if (r3 == 0) goto L_0x002a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            r4.<init>()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            r4.append(r3)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            r4.append(r1)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            r11.f2066c = r3     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
        L_0x002a:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            r4.<init>()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.lang.String r5 = r11.f2066c     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            r4.append(r5)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.lang.String r5 = f2060a     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            r4.append(r5)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            if (r4 == 0) goto L_0x004e
            boolean r4 = r3.isDirectory()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            if (r4 != 0) goto L_0x005c
        L_0x004e:
            boolean r4 = r3.mkdirs()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            if (r4 != 0) goto L_0x005c
            java.lang.String r0 = r11.f2065b     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.lang.String r3 = "Create mipushlog directory fail."
            android.util.Log.w(r0, r3)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            return
        L_0x005c:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.lang.String r5 = "log.lock"
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            if (r5 == 0) goto L_0x006f
            boolean r5 = r4.isDirectory()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            if (r5 == 0) goto L_0x0072
        L_0x006f:
            r4.createNewFile()     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
        L_0x0072:
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.lang.String r6 = "rw"
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x014d, all -> 0x0149 }
            java.nio.channels.FileChannel r4 = r5.getChannel()     // Catch:{ Exception -> 0x0146, all -> 0x0143 }
            java.nio.channels.FileLock r4 = r4.lock()     // Catch:{ Exception -> 0x0146, all -> 0x0143 }
            java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0141 }
            java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0141 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0141 }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0141 }
            r9.<init>(r3, r0)     // Catch:{ Exception -> 0x0141 }
            r10 = 1
            r8.<init>(r9, r10)     // Catch:{ Exception -> 0x0141 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0141 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0141 }
        L_0x0096:
            java.util.List<android.util.Pair<java.lang.String, java.lang.Throwable>> r7 = f2062a     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            boolean r7 = r7.isEmpty()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            if (r7 != 0) goto L_0x00ea
            java.util.List<android.util.Pair<java.lang.String, java.lang.Throwable>> r7 = f2062a     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r8 = 0
            java.lang.Object r7 = r7.remove(r8)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            android.util.Pair r7 = (android.util.Pair) r7     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.Object r8 = r7.first     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.Object r9 = r7.second     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r10 = "\n"
            if (r9 == 0) goto L_0x00d7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r9.<init>()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r9.append(r8)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r9.append(r10)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r9.<init>()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r9.append(r8)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.Object r7 = r7.second     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r9.append(r7)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
        L_0x00d7:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r7.<init>()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r7.append(r8)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r7.append(r10)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r6.write(r7)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            goto L_0x0096
        L_0x00ea:
            r6.flush()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r6.close()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0141 }
            r6.<init>(r3, r0)     // Catch:{ Exception -> 0x0141 }
            long r7 = r6.length()     // Catch:{ Exception -> 0x0141 }
            r9 = 1048576(0x100000, double:5.180654E-318)
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x0119
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0141 }
            java.lang.String r7 = "log0.txt"
            r0.<init>(r3, r7)     // Catch:{ Exception -> 0x0141 }
            boolean r3 = r0.exists()     // Catch:{ Exception -> 0x0141 }
            if (r3 == 0) goto L_0x0116
            boolean r3 = r0.isFile()     // Catch:{ Exception -> 0x0141 }
            if (r3 == 0) goto L_0x0116
            r0.delete()     // Catch:{ Exception -> 0x0141 }
        L_0x0116:
            r6.renameTo(r0)     // Catch:{ Exception -> 0x0141 }
        L_0x0119:
            if (r2 == 0) goto L_0x0125
            r2.close()     // Catch:{ IOException -> 0x011f }
            goto L_0x0125
        L_0x011f:
            r0 = move-exception
            java.lang.String r2 = r11.f2065b
            android.util.Log.e(r2, r1, r0)
        L_0x0125:
            if (r4 == 0) goto L_0x0137
            boolean r0 = r4.isValid()
            if (r0 == 0) goto L_0x0137
            r4.release()     // Catch:{ IOException -> 0x0131 }
            goto L_0x0137
        L_0x0131:
            r0 = move-exception
            java.lang.String r2 = r11.f2065b
            android.util.Log.e(r2, r1, r0)
        L_0x0137:
            r5.close()     // Catch:{ IOException -> 0x0179 }
            goto L_0x017f
        L_0x013b:
            r0 = move-exception
            r2 = r6
            goto L_0x0181
        L_0x013e:
            r0 = move-exception
            r2 = r6
            goto L_0x0150
        L_0x0141:
            r0 = move-exception
            goto L_0x0150
        L_0x0143:
            r0 = move-exception
            r4 = r2
            goto L_0x0181
        L_0x0146:
            r0 = move-exception
            r4 = r2
            goto L_0x0150
        L_0x0149:
            r0 = move-exception
            r4 = r2
            r5 = r4
            goto L_0x0181
        L_0x014d:
            r0 = move-exception
            r4 = r2
            r5 = r4
        L_0x0150:
            java.lang.String r3 = r11.f2065b     // Catch:{ all -> 0x0180 }
            android.util.Log.e(r3, r1, r0)     // Catch:{ all -> 0x0180 }
            if (r2 == 0) goto L_0x0161
            r2.close()     // Catch:{ IOException -> 0x015b }
            goto L_0x0161
        L_0x015b:
            r0 = move-exception
            java.lang.String r2 = r11.f2065b
            android.util.Log.e(r2, r1, r0)
        L_0x0161:
            if (r4 == 0) goto L_0x0173
            boolean r0 = r4.isValid()
            if (r0 == 0) goto L_0x0173
            r4.release()     // Catch:{ IOException -> 0x016d }
            goto L_0x0173
        L_0x016d:
            r0 = move-exception
            java.lang.String r2 = r11.f2065b
            android.util.Log.e(r2, r1, r0)
        L_0x0173:
            if (r5 == 0) goto L_0x017f
            r5.close()     // Catch:{ IOException -> 0x0179 }
            goto L_0x017f
        L_0x0179:
            r0 = move-exception
            java.lang.String r2 = r11.f2065b
            android.util.Log.e(r2, r1, r0)
        L_0x017f:
            return
        L_0x0180:
            r0 = move-exception
        L_0x0181:
            if (r2 == 0) goto L_0x018d
            r2.close()     // Catch:{ IOException -> 0x0187 }
            goto L_0x018d
        L_0x0187:
            r2 = move-exception
            java.lang.String r3 = r11.f2065b
            android.util.Log.e(r3, r1, r2)
        L_0x018d:
            if (r4 == 0) goto L_0x019f
            boolean r2 = r4.isValid()
            if (r2 == 0) goto L_0x019f
            r4.release()     // Catch:{ IOException -> 0x0199 }
            goto L_0x019f
        L_0x0199:
            r2 = move-exception
            java.lang.String r3 = r11.f2065b
            android.util.Log.e(r3, r1, r2)
        L_0x019f:
            if (r5 == 0) goto L_0x01ab
            r5.close()     // Catch:{ IOException -> 0x01a5 }
            goto L_0x01ab
        L_0x01a5:
            r2 = move-exception
            java.lang.String r3 = r11.f2065b
            android.util.Log.e(r3, r1, r2)
        L_0x01ab:
            goto L_0x01ad
        L_0x01ac:
            throw r0
        L_0x01ad:
            goto L_0x01ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1729do.m3035a():void");
    }

    public final void log(String str) {
        log(str, (Throwable) null);
    }

    public final void log(String str, Throwable th) {
        this.f2064a.post(new C1730dp(this, str, th));
    }

    public final void setTag(String str) {
        this.f2065b = str;
    }
}
