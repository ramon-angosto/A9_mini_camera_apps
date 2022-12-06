package com.xiaomi.push.log;

import android.annotation.SuppressLint;
import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class a {
    private static String b = "/MiPushLog";
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String c;
    private String d;
    private boolean e;
    private int f;
    private int g = 2097152;
    private ArrayList<File> h = new ArrayList<>();

    a() {
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= read || !matcher.find(i)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.c.length() + start);
                if (this.e) {
                    if (substring.compareTo(this.d) > 0) {
                        read = start;
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.c) >= 0) {
                    this.e = true;
                    i2 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.c.length();
                }
                i = start + indexOf;
            }
            if (this.e) {
                int i3 = read - i2;
                this.f += i3;
                if (z) {
                    bufferedWriter.write(cArr, i2, i3);
                    return;
                }
                bufferedWriter.write(cArr, i2, i3);
                if (this.f > this.g) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.Writer] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.io.Writer] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.io.File r9) {
        /*
            r8 = this;
            java.lang.String r0 = "LOG: filter error = "
            java.lang.String r1 = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            r2 = 0
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a9, all -> 0x00a6 }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a9, all -> 0x00a6 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a9, all -> 0x00a6 }
            r5.<init>(r9)     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a9, all -> 0x00a6 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a9, all -> 0x00a6 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a9, all -> 0x00a6 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = "model :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = "; os :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = "; uid :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = com.xiaomi.push.service.ah.e()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = "; lng :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = "; sdk :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r4 = 21
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r4 = "\n"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.lang.String r9 = r9.toString()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r3.write(r9)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r9 = 0
            r8.f = r9     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.util.ArrayList<java.io.File> r9 = r8.h     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
        L_0x006c:
            boolean r4 = r9.hasNext()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            if (r4 == 0) goto L_0x0095
            java.lang.Object r4 = r9.next()     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.io.File r4 = (java.io.File) r4     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r7.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00a2, IOException -> 0x009e, all -> 0x009c }
            r8.a(r5, r3, r1)     // Catch:{ FileNotFoundException -> 0x0093, IOException -> 0x0091, all -> 0x008f }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0093, IOException -> 0x0091, all -> 0x008f }
            r2 = r5
            goto L_0x006c
        L_0x008f:
            r9 = move-exception
            goto L_0x00e0
        L_0x0091:
            r9 = move-exception
            goto L_0x00a0
        L_0x0093:
            r9 = move-exception
            goto L_0x00a4
        L_0x0095:
            com.xiaomi.channel.commonutils.file.a.a((java.io.Writer) r3)
            com.xiaomi.channel.commonutils.file.a.a((java.io.Reader) r2)
            goto L_0x00dd
        L_0x009c:
            r9 = move-exception
            goto L_0x00e1
        L_0x009e:
            r9 = move-exception
            r5 = r2
        L_0x00a0:
            r2 = r3
            goto L_0x00ab
        L_0x00a2:
            r9 = move-exception
            r5 = r2
        L_0x00a4:
            r2 = r3
            goto L_0x00c1
        L_0x00a6:
            r9 = move-exception
            r3 = r2
            goto L_0x00e1
        L_0x00a9:
            r9 = move-exception
            r5 = r2
        L_0x00ab:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00de }
            r1.<init>()     // Catch:{ all -> 0x00de }
            r1.append(r0)     // Catch:{ all -> 0x00de }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00de }
            r1.append(r9)     // Catch:{ all -> 0x00de }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00de }
            goto L_0x00d4
        L_0x00bf:
            r9 = move-exception
            r5 = r2
        L_0x00c1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00de }
            r1.<init>()     // Catch:{ all -> 0x00de }
            r1.append(r0)     // Catch:{ all -> 0x00de }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00de }
            r1.append(r9)     // Catch:{ all -> 0x00de }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00de }
        L_0x00d4:
            com.xiaomi.channel.commonutils.logger.b.c(r9)     // Catch:{ all -> 0x00de }
            com.xiaomi.channel.commonutils.file.a.a((java.io.Writer) r2)
            com.xiaomi.channel.commonutils.file.a.a((java.io.Reader) r5)
        L_0x00dd:
            return
        L_0x00de:
            r9 = move-exception
            r3 = r2
        L_0x00e0:
            r2 = r5
        L_0x00e1:
            com.xiaomi.channel.commonutils.file.a.a((java.io.Writer) r3)
            com.xiaomi.channel.commonutils.file.a.a((java.io.Reader) r2)
            goto L_0x00e9
        L_0x00e8:
            throw r9
        L_0x00e9:
            goto L_0x00e8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.log.a.b(java.io.File):void");
    }

    /* access modifiers changed from: package-private */
    public a a(File file) {
        if (file.exists()) {
            this.h.add(file);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public a a(Date date, Date date2) {
        String str;
        if (date.after(date2)) {
            this.c = this.a.format(date2);
            str = this.a.format(date);
        } else {
            this.c = this.a.format(date);
            str = this.a.format(date2);
        }
        this.d = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = context.getFilesDir();
            a(new File(file2, "xmsf.log.1"));
            a(new File(file2, "xmsf.log"));
        } else {
            File file3 = new File(context.getExternalFilesDir((String) null) + b);
            a(new File(file3, "log0.txt"));
            a(new File(file3, "log1.txt"));
            file2 = file3;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        b(file5);
        b.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.file.a.a(file4, file5);
            b.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        if (i != 0) {
            this.g = i;
        }
    }
}
