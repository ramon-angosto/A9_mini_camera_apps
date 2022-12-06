package com.xiaomi.clientreport.processor;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.C1608aa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

/* renamed from: com.xiaomi.clientreport.processor.e */
public class C1541e {
    /* renamed from: a */
    private static PerfClientReport m2214a(PerfClientReport perfClientReport, String str) {
        long[] a;
        if (perfClientReport == null || (a = m2215a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = a[0];
        perfClientReport.perfLatencies = a[1];
        return perfClientReport;
    }

    /* renamed from: a */
    private static PerfClientReport m2215a(String str) {
        try {
            String[] a = m2215a(str);
            if (a == null || a.length < 4 || TextUtils.isEmpty(a[0]) || TextUtils.isEmpty(a[1]) || TextUtils.isEmpty(a[2]) || TextUtils.isEmpty(a[3])) {
                return null;
            }
            PerfClientReport blankInstance = PerfClientReport.getBlankInstance();
            blankInstance.production = Integer.parseInt(a[0]);
            blankInstance.clientInterfaceId = a[1];
            blankInstance.reportType = Integer.parseInt(a[2]);
            blankInstance.code = Integer.parseInt(a[3]);
            return blankInstance;
        } catch (Exception unused) {
            C1524b.m2159c("parse per key error");
            return null;
        }
    }

    /* renamed from: a */
    public static String m2216a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }

    /* renamed from: a */
    private static HashMap<String, String> m2217a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("%%%");
                    if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        hashMap.put(split[0], split[1]);
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    try {
                        C1524b.m2155a((Throwable) e);
                        C1608aa.m2491a((Closeable) bufferedReader);
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        C1608aa.m2491a((Closeable) bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C1608aa.m2491a((Closeable) bufferedReader2);
                    throw th;
                }
            }
            C1608aa.m2491a((Closeable) bufferedReader2);
        } catch (Exception e2) {
            e = e2;
            C1524b.m2155a((Throwable) e);
            C1608aa.m2491a((Closeable) bufferedReader);
            return hashMap;
        }
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d3, code lost:
        if (r1 == null) goto L_0x00d8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f4  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> m2218a(android.content.Context r7, java.lang.String r8) {
        /*
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x00f8
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0018
            goto L_0x00f8
        L_0x0018:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00b6, all -> 0x00b1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6, all -> 0x00b1 }
            r2.<init>()     // Catch:{ Exception -> 0x00b6, all -> 0x00b1 }
            r2.append(r8)     // Catch:{ Exception -> 0x00b6, all -> 0x00b1 }
            java.lang.String r3 = ".lock"
            r2.append(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00b1 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b6, all -> 0x00b1 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b1 }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r1)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.nio.channels.FileChannel r3 = r2.getChannel()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.nio.channels.FileLock r3 = r3.lock()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00a1, all -> 0x009f }
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ Exception -> 0x00a1, all -> 0x009f }
            r5.<init>(r8)     // Catch:{ Exception -> 0x00a1, all -> 0x009f }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00a1, all -> 0x009f }
        L_0x004b:
            java.lang.String r8 = r4.readLine()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r8 == 0) goto L_0x0084
            java.lang.String r0 = "%%%"
            java.lang.String[] r8 = r8.split(r0)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r0 = r8.length     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 2
            if (r0 < r5) goto L_0x004b
            r0 = 0
            r5 = r8[r0]     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r5 != 0) goto L_0x004b
            r5 = 1
            r6 = r8[r5]     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r6 != 0) goto L_0x004b
            r0 = r8[r0]     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            com.xiaomi.clientreport.data.PerfClientReport r0 = m2215a((java.lang.String) r0)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r8 = r8[r5]     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            com.xiaomi.clientreport.data.PerfClientReport r8 = m2214a((com.xiaomi.clientreport.data.PerfClientReport) r0, (java.lang.String) r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r8 != 0) goto L_0x007c
            goto L_0x004b
        L_0x007c:
            java.lang.String r8 = r8.toJsonString()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r7.add(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            goto L_0x004b
        L_0x0084:
            if (r3 == 0) goto L_0x0094
            boolean r8 = r3.isValid()
            if (r8 == 0) goto L_0x0094
            r3.release()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r8 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r8)
        L_0x0094:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)
            goto L_0x00d5
        L_0x009b:
            r7 = move-exception
            goto L_0x00db
        L_0x009d:
            r8 = move-exception
            goto L_0x00a3
        L_0x009f:
            r7 = move-exception
            goto L_0x00dc
        L_0x00a1:
            r8 = move-exception
            r4 = r0
        L_0x00a3:
            r0 = r3
            goto L_0x00ba
        L_0x00a5:
            r7 = move-exception
            r3 = r0
            goto L_0x00dc
        L_0x00a8:
            r8 = move-exception
            r4 = r0
            goto L_0x00ba
        L_0x00ab:
            r7 = move-exception
            r2 = r0
            goto L_0x00b4
        L_0x00ae:
            r8 = move-exception
            r2 = r0
            goto L_0x00b9
        L_0x00b1:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L_0x00b4:
            r3 = r2
            goto L_0x00dc
        L_0x00b6:
            r8 = move-exception
            r1 = r0
            r2 = r1
        L_0x00b9:
            r4 = r2
        L_0x00ba:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r8)     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00cd
            boolean r8 = r0.isValid()
            if (r8 == 0) goto L_0x00cd
            r0.release()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r8 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r8)
        L_0x00cd:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)
            if (r1 == 0) goto L_0x00d8
        L_0x00d5:
            r1.delete()
        L_0x00d8:
            return r7
        L_0x00d9:
            r7 = move-exception
            r3 = r0
        L_0x00db:
            r0 = r4
        L_0x00dc:
            if (r3 == 0) goto L_0x00ec
            boolean r8 = r3.isValid()
            if (r8 == 0) goto L_0x00ec
            r3.release()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00ec
        L_0x00e8:
            r8 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r8)
        L_0x00ec:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r0)
            if (r1 == 0) goto L_0x00f7
            r1.delete()
        L_0x00f7:
            throw r7
        L_0x00f8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.C1541e.m2218a(android.content.Context, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    private static void m2219a(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Exception e;
        if (!TextUtils.isEmpty(str) && hashMap != null && hashMap.size() != 0) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                try {
                    for (String next : hashMap.keySet()) {
                        bufferedWriter.write(next + "%%%" + hashMap.get(next));
                        bufferedWriter.newLine();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C1524b.m2155a((Throwable) e);
                        C1608aa.m2491a((Closeable) bufferedWriter);
                    } catch (Throwable th) {
                        th = th;
                        C1608aa.m2491a((Closeable) bufferedWriter);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                bufferedWriter = null;
                e = e3;
                C1524b.m2155a((Throwable) e);
                C1608aa.m2491a((Closeable) bufferedWriter);
            } catch (Throwable th2) {
                bufferedWriter = null;
                th = th2;
                C1608aa.m2491a((Closeable) bufferedWriter);
                throw th;
            }
            C1608aa.m2491a((Closeable) bufferedWriter);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.RandomAccessFile} */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0084 A[DONT_GENERATE] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m2220a(java.lang.String r13, com.xiaomi.clientreport.data.C1526a[] r14) {
        /*
            if (r14 == 0) goto L_0x00ab
            int r0 = r14.length
            if (r0 <= 0) goto L_0x00ab
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 == 0) goto L_0x000d
            goto L_0x00ab
        L_0x000d:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r2.<init>()     // Catch:{ all -> 0x007c }
            r2.append(r13)     // Catch:{ all -> 0x007c }
            java.lang.String r3 = ".lock"
            r2.append(r3)     // Catch:{ all -> 0x007c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007c }
            r1.<init>(r2)     // Catch:{ all -> 0x007c }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r1)     // Catch:{ all -> 0x007c }
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ all -> 0x007c }
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch:{ all -> 0x007c }
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch:{ all -> 0x007d }
            java.nio.channels.FileLock r0 = r1.lock()     // Catch:{ all -> 0x007d }
            java.util.HashMap r1 = m2215a((java.lang.String) r13)     // Catch:{ all -> 0x007d }
            int r9 = r14.length     // Catch:{ all -> 0x007d }
            r3 = 0
            r10 = 0
        L_0x003d:
            if (r10 >= r9) goto L_0x006b
            r3 = r14[r10]     // Catch:{ all -> 0x007d }
            if (r3 == 0) goto L_0x0068
            r4 = r3
            com.xiaomi.clientreport.data.PerfClientReport r4 = (com.xiaomi.clientreport.data.PerfClientReport) r4     // Catch:{ all -> 0x007d }
            java.lang.String r4 = m2216a((com.xiaomi.clientreport.data.PerfClientReport) r4)     // Catch:{ all -> 0x007d }
            r5 = r3
            com.xiaomi.clientreport.data.PerfClientReport r5 = (com.xiaomi.clientreport.data.PerfClientReport) r5     // Catch:{ all -> 0x007d }
            long r5 = r5.perfCounts     // Catch:{ all -> 0x007d }
            com.xiaomi.clientreport.data.PerfClientReport r3 = (com.xiaomi.clientreport.data.PerfClientReport) r3     // Catch:{ all -> 0x007d }
            long r7 = r3.perfLatencies     // Catch:{ all -> 0x007d }
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x007d }
            if (r3 != 0) goto L_0x0068
            r11 = 0
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x0068
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x0064
            goto L_0x0068
        L_0x0064:
            r3 = r1
            m2221a(r3, r4, r5, r7)     // Catch:{ all -> 0x007d }
        L_0x0068:
            int r10 = r10 + 1
            goto L_0x003d
        L_0x006b:
            m2219a((java.lang.String) r13, (java.util.HashMap<java.lang.String, java.lang.String>) r1)     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x0092
            boolean r13 = r0.isValid()
            if (r13 == 0) goto L_0x0092
            r0.release()     // Catch:{ IOException -> 0x007a }
            goto L_0x0092
        L_0x007a:
            r13 = move-exception
            goto L_0x008f
        L_0x007c:
            r2 = r0
        L_0x007d:
            java.lang.String r13 = "failed to write perf to file "
            com.xiaomi.channel.commonutils.logger.C1524b.m2159c(r13)     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0092
            boolean r13 = r0.isValid()
            if (r13 == 0) goto L_0x0092
            r0.release()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r13 = move-exception
        L_0x008f:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r13)
        L_0x0092:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            return
        L_0x0096:
            r13 = move-exception
            if (r0 == 0) goto L_0x00a7
            boolean r14 = r0.isValid()
            if (r14 == 0) goto L_0x00a7
            r0.release()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r14 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r14)
        L_0x00a7:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r2)
            throw r13
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.C1541e.m2220a(java.lang.String, com.xiaomi.clientreport.data.a[]):void");
    }

    /* renamed from: a */
    private static void m2221a(HashMap<String, String> hashMap, String str, long j, long j2) {
        StringBuilder sb;
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
        } else {
            long[] a = m2215a(str2);
            if (a == null || a[0] <= 0 || a[1] < 0) {
                sb = new StringBuilder();
            } else {
                j += a[0];
                j2 += a[1];
                sb = new StringBuilder();
            }
        }
        sb.append(j);
        sb.append("#");
        sb.append(j2);
        hashMap.put(str, sb.toString());
    }

    /* renamed from: a */
    protected static long[] m2222a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    private static String[] m2223a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }
}
