package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.hk */
public class C1863hk {

    /* renamed from: a */
    private static boolean f2646a = false;

    /* renamed from: com.xiaomi.push.hk$a */
    static class C1864a implements Runnable {

        /* renamed from: a */
        private Context f2647a;

        /* renamed from: a */
        private C1867hn f2648a;

        public C1864a(Context context, C1867hn hnVar) {
            this.f2648a = hnVar;
            this.f2647a = context;
        }

        public void run() {
            C1863hk.m3882c(this.f2647a, this.f2648a);
        }
    }

    /* renamed from: a */
    private static void m3877a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* renamed from: a */
    public static void m3878a(Context context, C1867hn hnVar) {
        C1618ak.m2518a(context).mo17212a((Runnable) new C1864a(context, hnVar));
    }

    /* renamed from: a */
    private static void m3879a(Context context, C1867hn hnVar, File file, byte[] bArr) {
        String str;
        int a;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            loop0:
            while (true) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr2);
                        if (read == -1) {
                            break loop0;
                        } else if (read != 4) {
                            str = "TinyData read from cache file failed cause lengthBuffer error. size:" + read;
                            break loop0;
                        } else {
                            a = C1612ae.m2508a(bArr2);
                            if (a < 1) {
                                break loop0;
                            } else if (a > 10240) {
                                break loop0;
                            } else {
                                byte[] bArr3 = new byte[a];
                                int read2 = bufferedInputStream2.read(bArr3);
                                if (read2 != a) {
                                    str = "TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a;
                                    break loop0;
                                }
                                byte[] a2 = C1880i.m3999a(bArr, bArr3);
                                if (a2 != null) {
                                    if (a2.length != 0) {
                                        C1872hs hsVar = new C1872hs();
                                        C1905iy.m4542a(hsVar, a2);
                                        hsVar.mo17782a("item_size", String.valueOf(a2.length));
                                        arrayList.add(hsVar);
                                        i++;
                                        i2 += a2.length;
                                        if (i >= 8 || i2 >= 10240) {
                                            C1865hl.m3885a(context, hnVar, (List<C1872hs>) arrayList);
                                            arrayList.clear();
                                        }
                                    }
                                }
                                C1524b.m2160d("TinyData read from cache file failed cause decrypt fail");
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            C1524b.m2155a((Throwable) e);
                            C1608aa.m2491a((Closeable) bufferedInputStream);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream2 = bufferedInputStream;
                            C1608aa.m2491a((Closeable) bufferedInputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        C1608aa.m2491a((Closeable) bufferedInputStream2);
                        throw th;
                    }
                }
            }
            str = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + a;
            C1524b.m2160d(str);
            C1865hl.m3885a(context, hnVar, (List<C1872hs>) arrayList);
            if (file != null && file.exists() && !file.delete()) {
                C1524b.m2141a("TinyData delete reading temp file failed");
            }
            C1608aa.m2491a((Closeable) bufferedInputStream2);
        } catch (Exception e2) {
            e = e2;
            C1524b.m2155a((Throwable) e);
            C1608aa.m2491a((Closeable) bufferedInputStream);
        }
    }

    /* renamed from: b */
    private static void m3880b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bb  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m3882c(android.content.Context r11, com.xiaomi.push.C1867hn r12) {
        /*
            java.lang.String r0 = "/"
            java.lang.String r1 = "/tdReadTemp"
            boolean r2 = f2646a
            if (r2 != 0) goto L_0x00dd
            r2 = 1
            f2646a = r2
            java.io.File r2 = new java.io.File
            java.io.File r3 = r11.getFilesDir()
            java.lang.String r4 = "tiny_data.data"
            r2.<init>(r3, r4)
            boolean r3 = r2.exists()
            java.lang.String r5 = "TinyData no ready file to get data."
            if (r3 != 0) goto L_0x0022
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r5)
            return
        L_0x0022:
            m3877a(r11)
            byte[] r3 = com.xiaomi.push.service.C2034bt.m5183a((android.content.Context) r11)
            r6 = 0
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.io.File r8 = r11.getFilesDir()     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.lang.String r9 = "tiny_data.lock"
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r7)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.lang.String r9 = "rw"
            r8.<init>(r7, r9)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.nio.channels.FileChannel r7 = r8.getChannel()     // Catch:{ Exception -> 0x0076 }
            java.nio.channels.FileLock r6 = r7.lock()     // Catch:{ Exception -> 0x0076 }
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x0076 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0076 }
            r9.<init>()     // Catch:{ Exception -> 0x0076 }
            java.io.File r10 = r11.getFilesDir()     // Catch:{ Exception -> 0x0076 }
            r9.append(r10)     // Catch:{ Exception -> 0x0076 }
            r9.append(r1)     // Catch:{ Exception -> 0x0076 }
            r9.append(r0)     // Catch:{ Exception -> 0x0076 }
            r9.append(r4)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0076 }
            r7.<init>(r9)     // Catch:{ Exception -> 0x0076 }
            r2.renameTo(r7)     // Catch:{ Exception -> 0x0076 }
            if (r6 == 0) goto L_0x0090
            boolean r2 = r6.isValid()
            if (r2 == 0) goto L_0x0090
            r6.release()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0090
        L_0x0074:
            r2 = move-exception
            goto L_0x008d
        L_0x0076:
            r2 = move-exception
            goto L_0x007d
        L_0x0078:
            r11 = move-exception
            r8 = r6
            goto L_0x00c9
        L_0x007b:
            r2 = move-exception
            r8 = r6
        L_0x007d:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r2)     // Catch:{ all -> 0x00c8 }
            if (r6 == 0) goto L_0x0090
            boolean r2 = r6.isValid()
            if (r2 == 0) goto L_0x0090
            r6.release()     // Catch:{ IOException -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r2 = move-exception
        L_0x008d:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r2)
        L_0x0090:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r8)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.io.File r7 = r11.getFilesDir()
            r6.append(r7)
            r6.append(r1)
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = r6.toString()
            r2.<init>(r0)
            boolean r0 = r2.exists()
            if (r0 != 0) goto L_0x00bb
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r5)
            return
        L_0x00bb:
            m3879a(r11, r12, r2, r3)
            r12 = 0
            com.xiaomi.push.C1862hj.m3873a((boolean) r12)
            m3880b(r11)
            f2646a = r12
            return
        L_0x00c8:
            r11 = move-exception
        L_0x00c9:
            if (r6 == 0) goto L_0x00d9
            boolean r12 = r6.isValid()
            if (r12 == 0) goto L_0x00d9
            r6.release()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x00d9
        L_0x00d5:
            r12 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r12)
        L_0x00d9:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r8)
            throw r11
        L_0x00dd:
            java.lang.String r11 = "TinyData extractTinyData is running"
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1863hk.m3882c(android.content.Context, com.xiaomi.push.hn):void");
    }
}
