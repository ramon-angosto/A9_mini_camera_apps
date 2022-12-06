package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.data.C1526a;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.manager.C1528a;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1608aa;
import com.xiaomi.push.C1612ae;
import com.xiaomi.push.C1663bo;
import com.xiaomi.push.C1667bs;
import com.xiaomi.push.C1880i;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.xiaomi.clientreport.processor.a */
public class C1537a implements IEventProcessor {

    /* renamed from: a */
    protected Context f1609a;

    /* renamed from: a */
    private HashMap<String, ArrayList<C1526a>> f1610a;

    public C1537a(Context context) {
        mo16998a(context);
    }

    /* renamed from: a */
    public static String mo16999a(C1526a aVar) {
        return String.valueOf(aVar.production);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.xiaomi.channel.commonutils.logger.C1524b.m2160d("eventData read from cache file failed because magicNumber error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m2192a(java.lang.String r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 4
            byte[] r2 = new byte[r1]
            byte[] r3 = new byte[r1]
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0072 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0072 }
            r6.<init>(r9)     // Catch:{ Exception -> 0x0072 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0072 }
        L_0x0015:
            int r9 = r5.read(r2)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            r4 = -1
            if (r9 != r4) goto L_0x001d
            goto L_0x0066
        L_0x001d:
            java.lang.String r6 = "eventData read from cache file failed because magicNumber error"
            if (r9 == r1) goto L_0x0025
        L_0x0021:
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r6)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            goto L_0x0066
        L_0x0025:
            int r9 = com.xiaomi.push.C1612ae.m2508a((byte[]) r2)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            r7 = -573785174(0xffffffffddccbbaa, float:-1.84407149E18)
            if (r9 == r7) goto L_0x002f
            goto L_0x0021
        L_0x002f:
            int r9 = r5.read(r3)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            if (r9 != r4) goto L_0x0036
            goto L_0x0066
        L_0x0036:
            if (r9 == r1) goto L_0x003e
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer error"
        L_0x003a:
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r9)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            goto L_0x0066
        L_0x003e:
            int r9 = com.xiaomi.push.C1612ae.m2508a((byte[]) r3)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            r4 = 1
            if (r9 < r4) goto L_0x0063
            r4 = 4096(0x1000, float:5.74E-42)
            if (r9 <= r4) goto L_0x004a
            goto L_0x0063
        L_0x004a:
            byte[] r4 = new byte[r9]     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            int r6 = r5.read(r4)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            if (r6 == r9) goto L_0x0055
            java.lang.String r9 = "eventData read from cache file failed cause buffer size not equal length"
            goto L_0x003a
        L_0x0055:
            java.lang.String r9 = r8.bytesToString(r4)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            if (r4 != 0) goto L_0x0015
            r0.add(r9)     // Catch:{ Exception -> 0x006c, all -> 0x006a }
            goto L_0x0015
        L_0x0063:
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K"
            goto L_0x003a
        L_0x0066:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r5)
            goto L_0x0079
        L_0x006a:
            r9 = move-exception
            goto L_0x007a
        L_0x006c:
            r9 = move-exception
            r4 = r5
            goto L_0x0073
        L_0x006f:
            r9 = move-exception
            r5 = r4
            goto L_0x007a
        L_0x0072:
            r9 = move-exception
        L_0x0073:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r9)     // Catch:{ all -> 0x006f }
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)
        L_0x0079:
            return r0
        L_0x007a:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r5)
            goto L_0x007f
        L_0x007e:
            throw r9
        L_0x007f:
            goto L_0x007e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.C1537a.m2192a(java.lang.String):java.util.List");
    }

    /* renamed from: a */
    private void m2193a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                C1524b.m2155a((Throwable) e);
            }
        }
        C1608aa.m2491a((Closeable) randomAccessFile);
    }

    /* renamed from: a */
    private void m2194a(String str, String str2) {
        C1528a a = C1528a.m2164a(this.f1609a);
        EventClientReport a2 = a.mo16976a(5001, "24:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2.toJsonString());
        mo17000a((List<String>) arrayList);
    }

    /* renamed from: a */
    private C1526a[] mo17001a(C1526a[] aVarArr) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        String b = m2196b(aVarArr[0]);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            File file = new File(b + ".lock");
            C1608aa.m2490a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
            } catch (Exception e) {
                e = e;
                fileLock = null;
                bufferedOutputStream = null;
                try {
                    C1524b.m2154a("event data write to cache file failed cause exception", (Throwable) e);
                    C1608aa.m2491a((Closeable) bufferedOutputStream);
                    m2193a(randomAccessFile, fileLock);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    C1608aa.m2491a((Closeable) bufferedOutputStream);
                    m2193a(randomAccessFile, fileLock);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileLock = null;
                bufferedOutputStream = null;
                C1608aa.m2491a((Closeable) bufferedOutputStream);
                m2193a(randomAccessFile, fileLock);
                throw th;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b), true));
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream = null;
                C1524b.m2154a("event data write to cache file failed cause exception", (Throwable) e);
                C1608aa.m2491a((Closeable) bufferedOutputStream);
                m2193a(randomAccessFile, fileLock);
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                C1608aa.m2491a((Closeable) bufferedOutputStream);
                m2193a(randomAccessFile, fileLock);
                throw th;
            }
            try {
                int i = 0;
                for (C1526a aVar : aVarArr) {
                    if (aVar != null) {
                        byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                        if (stringToBytes != null && stringToBytes.length >= 1) {
                            if (stringToBytes.length <= 4096) {
                                if (!C1667bs.m2747a(this.f1609a, b)) {
                                    int length = aVarArr.length - i;
                                    C1526a[] aVarArr2 = new C1526a[length];
                                    System.arraycopy(aVarArr, i, aVarArr2, 0, length);
                                    C1608aa.m2491a((Closeable) bufferedOutputStream);
                                    m2193a(randomAccessFile, fileLock);
                                    return aVarArr2;
                                }
                                bufferedOutputStream.write(C1612ae.m2509a(-573785174));
                                bufferedOutputStream.write(C1612ae.m2509a(stringToBytes.length));
                                bufferedOutputStream.write(stringToBytes);
                                bufferedOutputStream.flush();
                                i++;
                            }
                        }
                        C1524b.m2160d("event data throw a invalid item ");
                    }
                }
            } catch (Exception e3) {
                e = e3;
                C1524b.m2154a("event data write to cache file failed cause exception", (Throwable) e);
                C1608aa.m2491a((Closeable) bufferedOutputStream);
                m2193a(randomAccessFile, fileLock);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
            C1524b.m2154a("event data write to cache file failed cause exception", (Throwable) e);
            C1608aa.m2491a((Closeable) bufferedOutputStream);
            m2193a(randomAccessFile, fileLock);
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
            C1608aa.m2491a((Closeable) bufferedOutputStream);
            m2193a(randomAccessFile, fileLock);
            throw th;
        }
        C1608aa.m2491a((Closeable) bufferedOutputStream);
        m2193a(randomAccessFile, fileLock);
        return null;
    }

    /* renamed from: b */
    private String m2196b(C1526a aVar) {
        File externalFilesDir = this.f1609a.getExternalFilesDir(NotificationCompat.CATEGORY_EVENT);
        String a = mo16999a(aVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + a;
        for (int i = 0; i < 100; i++) {
            String str2 = str + i;
            if (C1667bs.m2747a(this.f1609a, str2)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x010c A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo16997a() {
        /*
            r12 = this;
            android.content.Context r0 = r12.f1609a
            java.lang.String r1 = "eventUploading"
            java.lang.String r2 = "event"
            com.xiaomi.push.C1667bs.m2748a(r0, r2, r1)
            android.content.Context r0 = r12.f1609a
            java.io.File[] r0 = com.xiaomi.push.C1667bs.m2747a((android.content.Context) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x0129
            int r1 = r0.length
            if (r1 > 0) goto L_0x0016
            goto L_0x0129
        L_0x0016:
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x001b:
            if (r2 >= r1) goto L_0x0129
            r6 = r0[r2]
            if (r6 != 0) goto L_0x003b
            if (r3 == 0) goto L_0x0031
            boolean r6 = r3.isValid()
            if (r6 == 0) goto L_0x0031
            r3.release()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r6 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r6)
        L_0x0031:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x010c
        L_0x0036:
            r5.delete()
            goto L_0x010c
        L_0x003b:
            long r7 = r6.length()     // Catch:{ Exception -> 0x00f1 }
            r9 = 5242880(0x500000, double:2.590327E-317)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0094
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f1 }
            r7.<init>()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = "eventData read from cache file failed because "
            r7.append(r8)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = r6.getName()     // Catch:{ Exception -> 0x00f1 }
            r7.append(r8)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = " is too big, length "
            r7.append(r8)     // Catch:{ Exception -> 0x00f1 }
            long r8 = r6.length()     // Catch:{ Exception -> 0x00f1 }
            r7.append(r8)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00f1 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r7)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = r6.getName()     // Catch:{ Exception -> 0x00f1 }
            android.content.Context r8 = r12.f1609a     // Catch:{ Exception -> 0x00f1 }
            long r9 = r6.length()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = android.text.format.Formatter.formatFileSize(r8, r9)     // Catch:{ Exception -> 0x00f1 }
            r12.m2194a((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x00f1 }
            r6.delete()     // Catch:{ Exception -> 0x00f1 }
            if (r3 == 0) goto L_0x008e
            boolean r6 = r3.isValid()
            if (r6 == 0) goto L_0x008e
            r3.release()     // Catch:{ IOException -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r6 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r6)
        L_0x008e:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x010c
            goto L_0x0036
        L_0x0094:
            java.lang.String r7 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00f1 }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00f1 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f1 }
            r9.<init>()     // Catch:{ Exception -> 0x00f1 }
            r9.append(r7)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r10 = ".lock"
            r9.append(r10)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00f1 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00f1 }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r8)     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            java.lang.String r9 = "rw"
            r5.<init>(r8, r9)     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            java.nio.channels.FileChannel r4 = r5.getChannel()     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            java.nio.channels.FileLock r3 = r4.lock()     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            java.util.List r4 = r12.m2192a((java.lang.String) r7)     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            r12.mo17000a((java.util.List<java.lang.String>) r4)     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            r6.delete()     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            if (r3 == 0) goto L_0x00da
            boolean r4 = r3.isValid()
            if (r4 == 0) goto L_0x00da
            r3.release()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r4)
        L_0x00da:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r5)
            r8.delete()
            r4 = r5
            r5 = r8
            goto L_0x010c
        L_0x00e3:
            r0 = move-exception
            r4 = r5
            goto L_0x00ea
        L_0x00e6:
            r6 = move-exception
            r4 = r5
            goto L_0x00ed
        L_0x00e9:
            r0 = move-exception
        L_0x00ea:
            r5 = r8
            goto L_0x0110
        L_0x00ec:
            r6 = move-exception
        L_0x00ed:
            r5 = r8
            goto L_0x00f2
        L_0x00ef:
            r0 = move-exception
            goto L_0x0110
        L_0x00f1:
            r6 = move-exception
        L_0x00f2:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r6)     // Catch:{ all -> 0x00ef }
            if (r3 == 0) goto L_0x0105
            boolean r6 = r3.isValid()
            if (r6 == 0) goto L_0x0105
            r3.release()     // Catch:{ IOException -> 0x0101 }
            goto L_0x0105
        L_0x0101:
            r6 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r6)
        L_0x0105:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x010c
            goto L_0x0036
        L_0x010c:
            int r2 = r2 + 1
            goto L_0x001b
        L_0x0110:
            if (r3 == 0) goto L_0x0120
            boolean r1 = r3.isValid()
            if (r1 == 0) goto L_0x0120
            r3.release()     // Catch:{ IOException -> 0x011c }
            goto L_0x0120
        L_0x011c:
            r1 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r1)
        L_0x0120:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x0128
            r5.delete()
        L_0x0128:
            throw r0
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.C1537a.mo16997a():void");
    }

    /* renamed from: a */
    public void mo16998a(Context context) {
        this.f1609a = context;
    }

    /* renamed from: a */
    public void m2199a(C1526a aVar) {
        if ((aVar instanceof EventClientReport) && this.f1610a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a = mo16999a((C1526a) eventClientReport);
            ArrayList arrayList = this.f1610a.get(a);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(eventClientReport);
            this.f1610a.put(a, arrayList);
        }
    }

    /* renamed from: a */
    public void mo17000a(List<String> list) {
        C1667bs.m2749a(this.f1609a, list);
    }

    /* renamed from: a */
    public void m2201a(C1526a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            C1524b.m2141a("event data write to cache file failed because data null");
            return;
        }
        do {
            aVarArr = mo17001a(aVarArr);
            if (aVarArr == null || aVarArr.length <= 0 || aVarArr[0] == null) {
            }
            aVarArr = mo17001a(aVarArr);
            return;
        } while (aVarArr[0] == null);
    }

    /* renamed from: b */
    public void mo17002b() {
        HashMap<String, ArrayList<C1526a>> hashMap = this.f1610a;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str : this.f1610a.keySet()) {
                    ArrayList arrayList = this.f1610a.get(str);
                    if (arrayList != null && arrayList.size() > 0) {
                        C1526a[] aVarArr = new C1526a[arrayList.size()];
                        arrayList.toArray(aVarArr);
                        mo17001a(aVarArr);
                    }
                }
            }
            this.f1610a.clear();
        }
    }

    public String bytesToString(byte[] bArr) {
        byte[] a;
        if (bArr != null && bArr.length >= 1) {
            if (!C1528a.m2164a(this.f1609a).mo16975a().isEventEncrypted()) {
                return C1663bo.m2731a(bArr);
            }
            String a2 = C1667bs.m2746a(this.f1609a);
            if (!TextUtils.isEmpty(a2) && (a = C1667bs.m2752a(a2)) != null && a.length > 0) {
                try {
                    return C1663bo.m2731a(Base64.decode(C1880i.m3999a(a, bArr), 2));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                    C1524b.m2155a(e);
                }
            }
        }
        return null;
    }

    public void setEventMap(HashMap<String, ArrayList<C1526a>> hashMap) {
        this.f1610a = hashMap;
    }

    public byte[] stringToBytes(String str) {
        byte[] a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!C1528a.m2164a(this.f1609a).mo16975a().isEventEncrypted()) {
            return C1663bo.m2727a(str);
        }
        String a2 = C1667bs.m2746a(this.f1609a);
        byte[] a3 = C1663bo.m2727a(str);
        if (!TextUtils.isEmpty(a2) && a3 != null && a3.length > 1 && (a = C1667bs.m2752a(a2)) != null) {
            try {
                if (a.length > 1) {
                    return C1880i.m4000b(a, Base64.encode(a3, 2));
                }
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
            }
        }
        return null;
    }
}
