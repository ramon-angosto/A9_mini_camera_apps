package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C2014bd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.push.dj */
class C1721dj {

    /* renamed from: a */
    private static String f2026a = "/MiPushLog";

    /* renamed from: a */
    private int f2027a;

    /* renamed from: a */
    private final SimpleDateFormat f2028a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: a */
    private ArrayList<File> f2029a = new ArrayList<>();

    /* renamed from: a */
    private boolean f2030a;

    /* renamed from: b */
    private int f2031b = 2097152;

    /* renamed from: b */
    private String f2032b;

    /* renamed from: c */
    private String f2033c;

    C1721dj() {
    }

    /* renamed from: a */
    private void m3002a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
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
                String substring = str.substring(start, this.f2032b.length() + start);
                if (this.f2030a) {
                    if (substring.compareTo(this.f2033c) > 0) {
                        read = start;
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.f2032b) >= 0) {
                    this.f2030a = true;
                    i2 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f2032b.length();
                }
                i = start + indexOf;
            }
            if (this.f2030a) {
                int i3 = read - i2;
                this.f2027a += i3;
                bufferedWriter.write(cArr, i2, i3);
                if (z || this.f2027a > this.f2031b) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: java.io.BufferedWriter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mo17385a(java.io.File r9) {
        /*
            r8 = this;
            java.lang.String r0 = "LOG: filter error = "
            java.lang.String r1 = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            r2 = 0
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x00d4, IOException -> 0x00be, all -> 0x00bb }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x00d4, IOException -> 0x00be, all -> 0x00bb }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00d4, IOException -> 0x00be, all -> 0x00bb }
            r5.<init>(r9)     // Catch:{ FileNotFoundException -> 0x00d4, IOException -> 0x00be, all -> 0x00bb }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00d4, IOException -> 0x00be, all -> 0x00bb }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00d4, IOException -> 0x00be, all -> 0x00bb }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = "model :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = "; os :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = "; uid :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = com.xiaomi.push.service.C2027bo.mo18506a()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = "; lng :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = "; sdk :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r4 = 46
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = "; andver :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r4 = "\n"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r9 = r9.toString()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r3.write(r9)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r9 = 0
            r8.f2027a = r9     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.util.ArrayList<java.io.File> r9 = r8.f2029a     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
        L_0x0076:
            boolean r4 = r9.hasNext()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            if (r4 == 0) goto L_0x009f
            java.lang.Object r4 = r9.next()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.io.File r4 = (java.io.File) r4     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r7.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r8.m3002a(r5, r3, r1)     // Catch:{ FileNotFoundException -> 0x009d, IOException -> 0x009b, all -> 0x0099 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x009d, IOException -> 0x009b, all -> 0x0099 }
            r2 = r5
            goto L_0x0076
        L_0x0099:
            r9 = move-exception
            goto L_0x00f5
        L_0x009b:
            r9 = move-exception
            goto L_0x00b5
        L_0x009d:
            r9 = move-exception
            goto L_0x00b9
        L_0x009f:
            com.xiaomi.push.cu r9 = com.xiaomi.push.C1702cu.mo17360a()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            java.lang.String r9 = r9.mo17365c()     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            r3.write(r9)     // Catch:{ FileNotFoundException -> 0x00b7, IOException -> 0x00b3, all -> 0x00b1 }
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r3)
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            goto L_0x00f2
        L_0x00b1:
            r9 = move-exception
            goto L_0x00f6
        L_0x00b3:
            r9 = move-exception
            r5 = r2
        L_0x00b5:
            r2 = r3
            goto L_0x00c0
        L_0x00b7:
            r9 = move-exception
            r5 = r2
        L_0x00b9:
            r2 = r3
            goto L_0x00d6
        L_0x00bb:
            r9 = move-exception
            r3 = r2
            goto L_0x00f6
        L_0x00be:
            r9 = move-exception
            r5 = r2
        L_0x00c0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            r1.<init>()     // Catch:{ all -> 0x00f3 }
            r1.append(r0)     // Catch:{ all -> 0x00f3 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00f3 }
            r1.append(r9)     // Catch:{ all -> 0x00f3 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00f3 }
            goto L_0x00e9
        L_0x00d4:
            r9 = move-exception
            r5 = r2
        L_0x00d6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f3 }
            r1.<init>()     // Catch:{ all -> 0x00f3 }
            r1.append(r0)     // Catch:{ all -> 0x00f3 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00f3 }
            r1.append(r9)     // Catch:{ all -> 0x00f3 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00f3 }
        L_0x00e9:
            com.xiaomi.channel.commonutils.logger.C1524b.m2159c(r9)     // Catch:{ all -> 0x00f3 }
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r5)
        L_0x00f2:
            return
        L_0x00f3:
            r9 = move-exception
            r3 = r2
        L_0x00f5:
            r2 = r5
        L_0x00f6:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r3)
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            goto L_0x00fe
        L_0x00fd:
            throw r9
        L_0x00fe:
            goto L_0x00fd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1721dj.mo17385a(java.io.File):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1721dj m3004a(File file) {
        if (file.exists()) {
            this.f2029a.add(file);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1721dj mo17386a(Date date, Date date2) {
        String str;
        if (date.after(date2)) {
            this.f2032b = this.f2028a.format(date2);
            str = this.f2028a.format(date);
        } else {
            this.f2032b = this.f2028a.format(date);
            str = this.f2028a.format(date2);
        }
        this.f2033c = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo17387a(Context context, Date date, Date date2, File file) {
        File file2;
        File file3;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file3 = new File(context.getExternalFilesDir((String) null), C2014bd.f3781M);
            if (!file3.exists()) {
                file3 = context.getFilesDir();
            }
            mo17385a(new File(file3, "xmsf.log.1"));
            file2 = new File(file3, "xmsf.log");
        } else {
            file3 = new File(context.getExternalFilesDir((String) null) + f2026a);
            mo17385a(new File(file3, "log0.txt"));
            file2 = new File(file3, "log1.txt");
        }
        mo17385a(file2);
        if (!file3.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        mo17386a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        mo17385a(file5);
        C1524b.m2159c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            C1608aa.m2493a(file4, file5);
            C1524b.m2159c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo17388a(int i) {
        if (i != 0) {
            this.f2031b = i;
        }
    }
}
