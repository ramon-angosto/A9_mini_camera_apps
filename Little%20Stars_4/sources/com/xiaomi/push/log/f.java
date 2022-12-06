package com.xiaomi.push.log;

import android.content.Context;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.misc.f;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class f implements LoggerInterface {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
    private static com.xiaomi.channel.commonutils.misc.f b = new com.xiaomi.channel.commonutils.misc.f(true);
    private static String c = "/MiPushLog";
    /* access modifiers changed from: private */
    public static List<Pair<String, Throwable>> f = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public String d;
    private Context e;

    public f(Context context) {
        this.e = context;
        if (context.getApplicationContext() != null) {
            this.e = context.getApplicationContext();
        }
        this.d = this.e.getPackageName();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.RandomAccessFile} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.BufferedWriter, java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013d A[SYNTHETIC, Splitter:B:71:0x013d] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x015b A[SYNTHETIC, Splitter:B:83:0x015b] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0162 A[SYNTHETIC, Splitter:B:87:0x0162] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0180 A[SYNTHETIC, Splitter:B:99:0x0180] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r11 = this;
            java.lang.String r0 = "log1.txt"
            java.lang.String r1 = ""
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            r4.<init>()     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            android.content.Context r5 = r11.e     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            java.io.File r5 = r5.getExternalFilesDir(r2)     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            r4.append(r5)     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            java.lang.String r5 = c     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            r4.append(r5)     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            if (r4 == 0) goto L_0x002d
            boolean r4 = r3.isDirectory()     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            if (r4 != 0) goto L_0x003b
        L_0x002d:
            boolean r4 = r3.mkdirs()     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            if (r4 != 0) goto L_0x003b
            java.lang.String r0 = r11.d     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            java.lang.String r3 = "Create mipushlog directory fail."
            android.util.Log.w(r0, r3)     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            return
        L_0x003b:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            java.lang.String r5 = "log.lock"
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            if (r5 == 0) goto L_0x004e
            boolean r5 = r4.isDirectory()     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            if (r5 == 0) goto L_0x0051
        L_0x004e:
            r4.createNewFile()     // Catch:{ Exception -> 0x0133, all -> 0x012f }
        L_0x0051:
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            java.lang.String r6 = "rw"
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x0133, all -> 0x012f }
            java.nio.channels.FileChannel r4 = r5.getChannel()     // Catch:{ Exception -> 0x012c, all -> 0x0129 }
            java.nio.channels.FileLock r4 = r4.lock()     // Catch:{ Exception -> 0x012c, all -> 0x0129 }
            java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0127 }
            java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0127 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0127 }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0127 }
            r9.<init>(r3, r0)     // Catch:{ Exception -> 0x0127 }
            r10 = 1
            r8.<init>(r9, r10)     // Catch:{ Exception -> 0x0127 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0127 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0127 }
        L_0x0075:
            java.util.List<android.util.Pair<java.lang.String, java.lang.Throwable>> r7 = f     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            boolean r7 = r7.isEmpty()     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            if (r7 != 0) goto L_0x00c9
            java.util.List<android.util.Pair<java.lang.String, java.lang.Throwable>> r7 = f     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r8 = 0
            java.lang.Object r7 = r7.remove(r8)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            android.util.Pair r7 = (android.util.Pair) r7     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.Object r8 = r7.first     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.Object r9 = r7.second     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.String r10 = "\n"
            if (r9 == 0) goto L_0x00b6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r9.<init>()     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r9.append(r8)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r9.append(r10)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r9.<init>()     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r9.append(r8)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.Object r7 = r7.second     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r9.append(r7)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
        L_0x00b6:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r7.<init>()     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r7.append(r8)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r7.append(r10)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r6.write(r7)     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            goto L_0x0075
        L_0x00c9:
            r6.flush()     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            r6.close()     // Catch:{ Exception -> 0x0124, all -> 0x0121 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0127 }
            r6.<init>(r3, r0)     // Catch:{ Exception -> 0x0127 }
            long r7 = r6.length()     // Catch:{ Exception -> 0x0127 }
            r9 = 1048576(0x100000, double:5.180654E-318)
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x00f8
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0127 }
            java.lang.String r7 = "log0.txt"
            r0.<init>(r3, r7)     // Catch:{ Exception -> 0x0127 }
            boolean r3 = r0.exists()     // Catch:{ Exception -> 0x0127 }
            if (r3 == 0) goto L_0x00f5
            boolean r3 = r0.isFile()     // Catch:{ Exception -> 0x0127 }
            if (r3 == 0) goto L_0x00f5
            r0.delete()     // Catch:{ Exception -> 0x0127 }
        L_0x00f5:
            r6.renameTo(r0)     // Catch:{ Exception -> 0x0127 }
        L_0x00f8:
            if (r2 == 0) goto L_0x0104
            r2.close()     // Catch:{ IOException -> 0x00fe }
            goto L_0x0104
        L_0x00fe:
            r0 = move-exception
            java.lang.String r2 = r11.d
            android.util.Log.e(r2, r1, r0)
        L_0x0104:
            if (r4 == 0) goto L_0x0116
            boolean r0 = r4.isValid()
            if (r0 == 0) goto L_0x0116
            r4.release()     // Catch:{ IOException -> 0x0110 }
            goto L_0x0116
        L_0x0110:
            r0 = move-exception
            java.lang.String r2 = r11.d
            android.util.Log.e(r2, r1, r0)
        L_0x0116:
            r5.close()     // Catch:{ IOException -> 0x011a }
            goto L_0x015e
        L_0x011a:
            r0 = move-exception
            java.lang.String r2 = r11.d
            android.util.Log.e(r2, r1, r0)
            goto L_0x015e
        L_0x0121:
            r0 = move-exception
            r2 = r6
            goto L_0x0160
        L_0x0124:
            r0 = move-exception
            r2 = r6
            goto L_0x0136
        L_0x0127:
            r0 = move-exception
            goto L_0x0136
        L_0x0129:
            r0 = move-exception
            r4 = r2
            goto L_0x0160
        L_0x012c:
            r0 = move-exception
            r4 = r2
            goto L_0x0136
        L_0x012f:
            r0 = move-exception
            r4 = r2
            r5 = r4
            goto L_0x0160
        L_0x0133:
            r0 = move-exception
            r4 = r2
            r5 = r4
        L_0x0136:
            java.lang.String r3 = r11.d     // Catch:{ all -> 0x015f }
            android.util.Log.e(r3, r1, r0)     // Catch:{ all -> 0x015f }
            if (r2 == 0) goto L_0x0147
            r2.close()     // Catch:{ IOException -> 0x0141 }
            goto L_0x0147
        L_0x0141:
            r0 = move-exception
            java.lang.String r2 = r11.d
            android.util.Log.e(r2, r1, r0)
        L_0x0147:
            if (r4 == 0) goto L_0x0159
            boolean r0 = r4.isValid()
            if (r0 == 0) goto L_0x0159
            r4.release()     // Catch:{ IOException -> 0x0153 }
            goto L_0x0159
        L_0x0153:
            r0 = move-exception
            java.lang.String r2 = r11.d
            android.util.Log.e(r2, r1, r0)
        L_0x0159:
            if (r5 == 0) goto L_0x015e
            r5.close()     // Catch:{ IOException -> 0x011a }
        L_0x015e:
            return
        L_0x015f:
            r0 = move-exception
        L_0x0160:
            if (r2 == 0) goto L_0x016c
            r2.close()     // Catch:{ IOException -> 0x0166 }
            goto L_0x016c
        L_0x0166:
            r2 = move-exception
            java.lang.String r3 = r11.d
            android.util.Log.e(r3, r1, r2)
        L_0x016c:
            if (r4 == 0) goto L_0x017e
            boolean r2 = r4.isValid()
            if (r2 == 0) goto L_0x017e
            r4.release()     // Catch:{ IOException -> 0x0178 }
            goto L_0x017e
        L_0x0178:
            r2 = move-exception
            java.lang.String r3 = r11.d
            android.util.Log.e(r3, r1, r2)
        L_0x017e:
            if (r5 == 0) goto L_0x018a
            r5.close()     // Catch:{ IOException -> 0x0184 }
            goto L_0x018a
        L_0x0184:
            r2 = move-exception
            java.lang.String r3 = r11.d
            android.util.Log.e(r3, r1, r2)
        L_0x018a:
            goto L_0x018c
        L_0x018b:
            throw r0
        L_0x018c:
            goto L_0x018b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.log.f.b():void");
    }

    public final void log(String str) {
        log(str, (Throwable) null);
    }

    public final void log(String str, Throwable th) {
        f.add(new Pair(String.format("%1$s %2$s %3$s ", new Object[]{a.format(new Date()), this.d, str}), th));
        b.a((f.b) new g(this));
    }

    public final void setTag(String str) {
        this.d = str;
    }
}
