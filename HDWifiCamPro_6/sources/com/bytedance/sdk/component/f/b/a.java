package com.bytedance.sdk.component.f.b;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.component.b.a.b;
import com.bytedance.sdk.component.b.a.c;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.k;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: DownloadExecutor */
public class a extends c {
    public File a;
    public File b;

    public a(i iVar) {
        super(iVar);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r0 = 'I';
        r1 = '`';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        switch(r1) {
            case 55: goto L_0x004f;
            case 56: goto L_0x004f;
            case 57: goto L_0x0010;
            default: goto L_0x000f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        switch(1) {
            case 60: goto L_0x0017;
            case 61: goto L_0x0023;
            case 62: goto L_0x0030;
            default: goto L_0x0016;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0000;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a1667305730938dc(java.lang.String r4) {
        /*
        L_0x0000:
            r0 = 74
            r1 = 55
        L_0x0004:
            r2 = 0
            switch(r0) {
                case 72: goto L_0x0000;
                case 73: goto L_0x0009;
                case 74: goto L_0x000c;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0054
        L_0x0009:
            switch(r1) {
                case 94: goto L_0x004f;
                case 95: goto L_0x0010;
                case 96: goto L_0x0039;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r1) {
                case 55: goto L_0x004f;
                case 56: goto L_0x004f;
                case 57: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x004f
        L_0x0010:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L_0x0017;
                case 61: goto L_0x0023;
                case 62: goto L_0x0030;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x0039
        L_0x0017:
            int r3 = 0 - r1
            int r3 = r3 * r2
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0000
        L_0x0023:
            int r2 = 18 - r1
            int r2 = r2 * r0
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x004f
        L_0x0030:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L_0x0000
        L_0x0039:
            char[] r4 = r4.toCharArray()
        L_0x003d:
            int r0 = r4.length
            if (r2 >= r0) goto L_0x0049
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L_0x003d
        L_0x0049:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L_0x004f:
            r0 = 73
            r1 = 96
            goto L_0x0004
        L_0x0054:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.b.a.a1667305730938dc(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r1 = this;
            java.io.File r0 = r1.a     // Catch:{ all -> 0x0005 }
            r0.delete()     // Catch:{ all -> 0x0005 }
        L_0x0005:
            java.io.File r0 = r1.b     // Catch:{ all -> 0x000a }
            r0.delete()     // Catch:{ all -> 0x000a }
        L_0x000a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.b.a.c():void");
    }

    /* access modifiers changed from: private */
    public static boolean e(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* access modifiers changed from: private */
    public static long f(Map<String, String> map) {
        String str;
        String str2 = "content-length";
        if (!map.containsKey(str2)) {
            str2 = HttpHeaders.CONTENT_LENGTH;
            if (!map.containsKey(str2)) {
                str = null;
                if (!TextUtils.isEmpty(str) || str == null) {
                    return 0;
                }
                try {
                    return Long.valueOf(str).longValue();
                } catch (Throwable unused) {
                    return 0;
                }
            }
        }
        str = map.get(str2);
        if (!TextUtils.isEmpty(str)) {
            return 0;
        }
        return Long.valueOf(str).longValue();
    }

    /* access modifiers changed from: private */
    public static boolean g(Map<String, String> map) {
        return TextUtils.equals(map.get(HttpHeaders.CONTENT_ENCODING), "gzip");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:133|134|(1:136)|137|(4:139|140|141|142)|143|144|145|146|196) */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:92|93|154|155|156|(0)|(0)|164|165|166|167|198) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:115|116|117|118) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:125|126|127|128) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:139|140|141|142) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:160|161|162|163) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:(4:125|126|127|128)|129|130|131|132|194) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:113|(4:115|116|117|118)|119|120|121|122|123) */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02e9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02ea, code lost:
        if (r6 != null) goto L_0x02ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        com.bytedance.sdk.component.f.d.d.a(r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x02fb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:?, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:117:0x0264, B:155:0x02cb, B:172:0x02f0, B:176:0x02f7] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:117:0x0264 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x026b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x0275 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x027d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x02aa */
    /* JADX WARNING: Missing exception handler attribute for start block: B:145:0x02b2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:162:0x02dc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:166:0x02e4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:172:0x02f0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:176:0x02f7 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x024f A[Catch:{ all -> 0x02b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0282 A[SYNTHETIC, Splitter:B:133:0x0282] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02d3 A[Catch:{ all -> 0x02e9, all -> 0x02f0, all -> 0x02f7, IOException -> 0x02fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02d8 A[SYNTHETIC, Splitter:B:160:0x02d8] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x021c A[EDGE_INSN: B:190:0x021c->B:94:0x021c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x021f A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:172:0x02f0=Splitter:B:172:0x02f0, B:145:0x02b2=Splitter:B:145:0x02b2, B:117:0x0264=Splitter:B:117:0x0264, B:166:0x02e4=Splitter:B:166:0x02e4, B:127:0x0275=Splitter:B:127:0x0275, B:176:0x02f7=Splitter:B:176:0x02f7, B:141:0x02aa=Splitter:B:141:0x02aa, B:121:0x026b=Splitter:B:121:0x026b, B:162:0x02dc=Splitter:B:162:0x02dc, B:131:0x027d=Splitter:B:131:0x027d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.f.b a() {
        /*
            r25 = this;
            r1 = r25
            java.lang.String r2 = "Error occured when calling tmpFile.close"
            java.lang.String r3 = "Error occured when calling InputStream.close"
            java.io.File r0 = r1.a
            r4 = 0
            if (r0 == 0) goto L_0x0312
            java.io.File r5 = r1.b
            if (r5 != 0) goto L_0x0011
            goto L_0x0312
        L_0x0011:
            boolean r0 = r0.exists()
            r5 = 0
            if (r0 == 0) goto L_0x003b
            java.io.File r0 = r1.a
            long r7 = r0.length()
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x003b
            com.bytedance.sdk.component.f.b r0 = new com.bytedance.sdk.component.f.b
            r8 = 1
            r9 = 200(0xc8, float:2.8E-43)
            r11 = 0
            r12 = 0
            long r15 = java.lang.System.currentTimeMillis()
            java.lang.String r10 = "Success"
            r7 = r0
            r13 = r15
            r7.<init>(r8, r9, r10, r11, r12, r13, r15)
            java.io.File r2 = r1.a
            r0.a(r2)
            return r0
        L_0x003b:
            java.io.File r0 = r1.b
            long r7 = r0.length()
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0046
            r7 = r5
        L_0x0046:
            com.bytedance.sdk.component.b.a.k$a r0 = new com.bytedance.sdk.component.b.a.k$a
            r0.<init>()
            java.lang.String r9 = r25.b()
            r0.a((java.lang.Object) r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "bytes="
            r9.append(r10)
            r9.append(r7)
            java.lang.String r10 = "-"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r11 = "Range"
            r1.b(r11, r9)
            java.lang.String r9 = r1.f
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r11 = "DownloadExecutor"
            if (r9 == 0) goto L_0x007f
            java.lang.String r0 = "execute: Url is Empty"
            android.util.Log.e(r11, r0)
            return r4
        L_0x007f:
            java.lang.String r9 = r1.f     // Catch:{ IllegalArgumentException -> 0x0309 }
            r0.a((java.lang.String) r9)     // Catch:{ IllegalArgumentException -> 0x0309 }
            r1.a((com.bytedance.sdk.component.b.a.k.a) r0)
            com.bytedance.sdk.component.b.a.k$a r0 = r0.a()
            com.bytedance.sdk.component.b.a.k r0 = r0.b()
            com.bytedance.sdk.component.b.a.i r9 = r1.c     // Catch:{ IOException -> 0x02ff }
            com.bytedance.sdk.component.b.a.b r0 = r9.a(r0)     // Catch:{ IOException -> 0x02ff }
            com.bytedance.sdk.component.b.a.m r0 = r0.a()     // Catch:{ IOException -> 0x02ff }
            if (r0 == 0) goto L_0x02fd
            boolean r9 = r0.d()     // Catch:{ IOException -> 0x02ff }
            if (r9 == 0) goto L_0x02fd
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ IOException -> 0x02ff }
            r9.<init>()     // Catch:{ IOException -> 0x02ff }
            com.bytedance.sdk.component.b.a.e r12 = r0.g()     // Catch:{ IOException -> 0x02ff }
            if (r12 == 0) goto L_0x00c1
            r13 = 0
        L_0x00ad:
            int r14 = r12.a()     // Catch:{ IOException -> 0x02ff }
            if (r13 >= r14) goto L_0x00c1
            java.lang.String r14 = r12.a(r13)     // Catch:{ IOException -> 0x02ff }
            java.lang.String r15 = r12.b(r13)     // Catch:{ IOException -> 0x02ff }
            r9.put(r14, r15)     // Catch:{ IOException -> 0x02ff }
            int r13 = r13 + 1
            goto L_0x00ad
        L_0x00c1:
            com.bytedance.sdk.component.f.b r15 = new com.bytedance.sdk.component.f.b     // Catch:{ IOException -> 0x02ff }
            boolean r13 = r0.d()     // Catch:{ IOException -> 0x02ff }
            int r14 = r0.c()     // Catch:{ IOException -> 0x02ff }
            java.lang.String r17 = r0.e()     // Catch:{ IOException -> 0x02ff }
            r18 = 0
            long r19 = r0.b()     // Catch:{ IOException -> 0x02ff }
            long r21 = r0.a()     // Catch:{ IOException -> 0x02ff }
            r12 = r15
            r23 = r15
            r15 = r17
            r16 = r9
            r17 = r18
            r18 = r19
            r20 = r21
            r12.<init>(r13, r14, r15, r16, r17, r18, r20)     // Catch:{ IOException -> 0x02ff }
            com.bytedance.sdk.component.b.a.n r12 = r0.f()     // Catch:{ IOException -> 0x02ff }
            long r12 = r12.a()     // Catch:{ IOException -> 0x02ff }
            int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r14 > 0) goto L_0x00f9
            long r12 = f(r9)     // Catch:{ IOException -> 0x02ff }
        L_0x00f9:
            java.io.File r14 = r1.b     // Catch:{ IOException -> 0x02ff }
            long r14 = r14.length()     // Catch:{ IOException -> 0x02ff }
            boolean r16 = e(r9)     // Catch:{ IOException -> 0x02ff }
            if (r16 == 0) goto L_0x0170
            long r12 = r12 + r14
            java.lang.String r6 = "Content-Range"
            java.lang.Object r6 = r9.get(r6)     // Catch:{ IOException -> 0x02ff }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x02ff }
            r19 = r6
            java.lang.CharSequence r19 = (java.lang.CharSequence) r19     // Catch:{ IOException -> 0x02ff }
            boolean r19 = android.text.TextUtils.isEmpty(r19)     // Catch:{ IOException -> 0x02ff }
            if (r19 != 0) goto L_0x0170
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02ff }
            r4.<init>()     // Catch:{ IOException -> 0x02ff }
            java.lang.String r5 = "bytes "
            r4.append(r5)     // Catch:{ IOException -> 0x02ff }
            r4.append(r14)     // Catch:{ IOException -> 0x02ff }
            r4.append(r10)     // Catch:{ IOException -> 0x02ff }
            r14 = 1
            long r14 = r12 - r14
            r4.append(r14)     // Catch:{ IOException -> 0x02ff }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x02ff }
            r5 = r6
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ IOException -> 0x02ff }
            r10 = r4
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ IOException -> 0x02ff }
            int r5 = android.text.TextUtils.indexOf(r5, r10)     // Catch:{ IOException -> 0x02ff }
            r10 = -1
            if (r5 != r10) goto L_0x0170
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02ff }
            r0.<init>()     // Catch:{ IOException -> 0x02ff }
            java.lang.String r2 = "execute: The Content-Range Header is invalid Assume["
            r0.append(r2)     // Catch:{ IOException -> 0x02ff }
            r0.append(r4)     // Catch:{ IOException -> 0x02ff }
            java.lang.String r2 = "] vs Real["
            r0.append(r2)     // Catch:{ IOException -> 0x02ff }
            r0.append(r6)     // Catch:{ IOException -> 0x02ff }
            java.lang.String r2 = "], please remove the temporary file ["
            r0.append(r2)     // Catch:{ IOException -> 0x02ff }
            java.io.File r2 = r1.b     // Catch:{ IOException -> 0x02ff }
            r0.append(r2)     // Catch:{ IOException -> 0x02ff }
            java.lang.String r2 = "]."
            r0.append(r2)     // Catch:{ IOException -> 0x02ff }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x02ff }
            com.bytedance.sdk.component.f.d.d.b(r11, r0)     // Catch:{ IOException -> 0x02ff }
            r25.c()     // Catch:{ IOException -> 0x02ff }
            r2 = 0
            return r2
        L_0x0170:
            r4 = 0
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x01a1
            java.io.File r4 = r1.b     // Catch:{ IOException -> 0x02ff }
            boolean r4 = r4.exists()     // Catch:{ IOException -> 0x02ff }
            if (r4 == 0) goto L_0x01a1
            java.io.File r4 = r1.b     // Catch:{ IOException -> 0x02ff }
            long r4 = r4.length()     // Catch:{ IOException -> 0x02ff }
            int r4 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x01a1
            java.io.File r0 = r1.b     // Catch:{ IOException -> 0x02ff }
            java.io.File r2 = r1.a     // Catch:{ IOException -> 0x02ff }
            boolean r0 = r0.renameTo(r2)     // Catch:{ IOException -> 0x02ff }
            if (r0 == 0) goto L_0x019a
            java.io.File r0 = r1.a     // Catch:{ IOException -> 0x02ff }
            r4 = r23
            r4.a(r0)     // Catch:{ IOException -> 0x02ff }
            return r4
        L_0x019a:
            java.lang.String r0 = "Rename fail"
            com.bytedance.sdk.component.f.d.d.b(r11, r0)     // Catch:{ IOException -> 0x02ff }
            r2 = 0
            return r2
        L_0x01a1:
            r4 = r23
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x01bb }
            java.io.File r6 = r1.b     // Catch:{ all -> 0x01bb }
            java.lang.String r10 = "rw"
            r5.<init>(r6, r10)     // Catch:{ all -> 0x01bb }
            if (r16 == 0) goto L_0x01b3
            r5.seek(r7)     // Catch:{ all -> 0x01b8 }
            r14 = r7
            goto L_0x01bd
        L_0x01b3:
            r14 = 0
            r5.setLength(r14)     // Catch:{ all -> 0x01b8 }
        L_0x01b8:
            r14 = 0
            goto L_0x01bd
        L_0x01bb:
            r5 = 0
            goto L_0x01b8
        L_0x01bd:
            com.bytedance.sdk.component.b.a.n r0 = r0.f()     // Catch:{ all -> 0x02c2 }
            java.io.InputStream r6 = r0.c()     // Catch:{ all -> 0x02c2 }
            boolean r0 = g(r9)     // Catch:{ all -> 0x02bb }
            if (r0 == 0) goto L_0x01d5
            boolean r0 = r6 instanceof java.util.zip.GZIPInputStream     // Catch:{ all -> 0x02bb }
            if (r0 != 0) goto L_0x01d5
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x02bb }
            r0.<init>(r6)     // Catch:{ all -> 0x02bb }
            r6 = r0
        L_0x01d5:
            r0 = 16384(0x4000, float:2.2959E-41)
            byte[] r9 = new byte[r0]     // Catch:{ all -> 0x02bb }
            r21 = r2
            r22 = r3
            r23 = r11
            r2 = r14
            r10 = 0
            r14 = 0
        L_0x01e3:
            int r11 = 16384 - r10
            int r11 = r6.read(r9, r10, r11)     // Catch:{ all -> 0x02b9 }
            r24 = 1
            r0 = -1
            if (r11 == r0) goto L_0x021c
            int r10 = r10 + r11
            long r0 = (long) r11
            long r14 = r14 + r0
            r0 = 16384(0x4000, double:8.0948E-320)
            long r0 = r14 % r0
            r17 = 0
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0204
            long r0 = r12 - r7
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0202
            goto L_0x0204
        L_0x0202:
            r24 = 0
        L_0x0204:
            if (r24 == 0) goto L_0x0211
            r5.seek(r2)     // Catch:{ all -> 0x0217 }
            r0 = 0
            r5.write(r9, r0, r10)     // Catch:{ all -> 0x0217 }
            long r10 = (long) r10     // Catch:{ all -> 0x0217 }
            long r2 = r2 + r10
            r10 = r0
            goto L_0x0212
        L_0x0211:
            r0 = 0
        L_0x0212:
            r0 = 16384(0x4000, float:2.2959E-41)
            r1 = r25
            goto L_0x01e3
        L_0x0217:
            r0 = move-exception
            r3 = r25
            goto L_0x02c9
        L_0x021c:
            r0 = 0
            if (r11 == 0) goto L_0x0225
            r5.seek(r2)     // Catch:{ all -> 0x0217 }
            r5.write(r9, r0, r10)     // Catch:{ all -> 0x0217 }
        L_0x0225:
            r1 = 0
            if (r16 == 0) goto L_0x0231
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x022e
            goto L_0x0231
        L_0x022e:
            r3 = r25
            goto L_0x0239
        L_0x0231:
            r3 = r25
            java.io.File r7 = r3.b     // Catch:{ all -> 0x02b7 }
            long r12 = r7.length()     // Catch:{ all -> 0x02b7 }
        L_0x0239:
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0282
            java.io.File r1 = r3.b     // Catch:{ all -> 0x02b7 }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x02b7 }
            if (r1 == 0) goto L_0x0282
            java.io.File r1 = r3.b     // Catch:{ all -> 0x02b7 }
            long r1 = r1.length()     // Catch:{ all -> 0x02b7 }
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x0282
            java.io.File r0 = r3.b     // Catch:{ all -> 0x02b7 }
            java.io.File r1 = r3.a     // Catch:{ all -> 0x02b7 }
            boolean r0 = r0.renameTo(r1)     // Catch:{ all -> 0x02b7 }
            if (r0 == 0) goto L_0x026f
            java.io.File r0 = r3.a     // Catch:{ all -> 0x02b7 }
            r4.a(r0)     // Catch:{ all -> 0x02b7 }
            if (r6 == 0) goto L_0x0267
            r6.close()     // Catch:{ all -> 0x0264 }
            goto L_0x0267
        L_0x0264:
            com.bytedance.sdk.component.f.d.d.a(r22)     // Catch:{ IOException -> 0x02fb }
        L_0x0267:
            r5.close()     // Catch:{ all -> 0x026b }
            goto L_0x026e
        L_0x026b:
            com.bytedance.sdk.component.f.d.d.a(r21)     // Catch:{ IOException -> 0x02fb }
        L_0x026e:
            return r4
        L_0x026f:
            if (r6 == 0) goto L_0x0278
            r6.close()     // Catch:{ all -> 0x0275 }
            goto L_0x0278
        L_0x0275:
            com.bytedance.sdk.component.f.d.d.a(r22)     // Catch:{ IOException -> 0x02fb }
        L_0x0278:
            r5.close()     // Catch:{ all -> 0x027d }
        L_0x027b:
            r1 = 0
            goto L_0x0281
        L_0x027d:
            com.bytedance.sdk.component.f.d.d.a(r21)     // Catch:{ IOException -> 0x02fb }
            goto L_0x027b
        L_0x0281:
            return r1
        L_0x0282:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b7 }
            r1.<init>()     // Catch:{ all -> 0x02b7 }
            java.lang.String r2 = " tempFile.length() == fileSize is"
            r1.append(r2)     // Catch:{ all -> 0x02b7 }
            java.io.File r2 = r3.b     // Catch:{ all -> 0x02b7 }
            long r7 = r2.length()     // Catch:{ all -> 0x02b7 }
            int r2 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0298
            r0 = r24
        L_0x0298:
            r1.append(r0)     // Catch:{ all -> 0x02b7 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x02b7 }
            r1 = r23
            com.bytedance.sdk.component.f.d.d.b(r1, r0)     // Catch:{ all -> 0x02b7 }
            if (r6 == 0) goto L_0x02ad
            r6.close()     // Catch:{ all -> 0x02aa }
            goto L_0x02ad
        L_0x02aa:
            com.bytedance.sdk.component.f.d.d.a(r22)     // Catch:{ IOException -> 0x02fb }
        L_0x02ad:
            r5.close()     // Catch:{ all -> 0x02b2 }
        L_0x02b0:
            r1 = 0
            goto L_0x02b6
        L_0x02b2:
            com.bytedance.sdk.component.f.d.d.a(r21)     // Catch:{ IOException -> 0x02fb }
            goto L_0x02b0
        L_0x02b6:
            return r1
        L_0x02b7:
            r0 = move-exception
            goto L_0x02c9
        L_0x02b9:
            r0 = move-exception
            goto L_0x02c0
        L_0x02bb:
            r0 = move-exception
            r21 = r2
            r22 = r3
        L_0x02c0:
            r3 = r1
            goto L_0x02c9
        L_0x02c2:
            r0 = move-exception
            r21 = r2
            r22 = r3
            r3 = r1
            r6 = 0
        L_0x02c9:
            java.lang.String r1 = "Error occured when FileRequest.parseHttpResponse"
            com.bytedance.sdk.component.f.d.d.a(r1)     // Catch:{ all -> 0x02e9 }
            r0.printStackTrace()     // Catch:{ all -> 0x02e9 }
            if (r16 != 0) goto L_0x02d6
            r25.c()     // Catch:{ all -> 0x02e9 }
        L_0x02d6:
            if (r6 == 0) goto L_0x02df
            r6.close()     // Catch:{ all -> 0x02dc }
            goto L_0x02df
        L_0x02dc:
            com.bytedance.sdk.component.f.d.d.a(r22)     // Catch:{ IOException -> 0x02fb }
        L_0x02df:
            r5.close()     // Catch:{ all -> 0x02e4 }
        L_0x02e2:
            r1 = 0
            goto L_0x02e8
        L_0x02e4:
            com.bytedance.sdk.component.f.d.d.a(r21)     // Catch:{ IOException -> 0x02fb }
            goto L_0x02e2
        L_0x02e8:
            return r1
        L_0x02e9:
            r0 = move-exception
            if (r6 == 0) goto L_0x02f3
            r6.close()     // Catch:{ all -> 0x02f0 }
            goto L_0x02f3
        L_0x02f0:
            com.bytedance.sdk.component.f.d.d.a(r22)     // Catch:{ IOException -> 0x02fb }
        L_0x02f3:
            r5.close()     // Catch:{ all -> 0x02f7 }
            goto L_0x02fa
        L_0x02f7:
            com.bytedance.sdk.component.f.d.d.a(r21)     // Catch:{ IOException -> 0x02fb }
        L_0x02fa:
            throw r0     // Catch:{ IOException -> 0x02fb }
        L_0x02fb:
            r0 = move-exception
            goto L_0x0301
        L_0x02fd:
            r3 = r1
            goto L_0x0307
        L_0x02ff:
            r0 = move-exception
            r3 = r1
        L_0x0301:
            r0.printStackTrace()
            r25.c()
        L_0x0307:
            r2 = 0
            return r2
        L_0x0309:
            r3 = r1
            r2 = r4
            r1 = r11
            java.lang.String r0 = "execute: Url is not a valid HTTP or HTTPS URL"
            android.util.Log.e(r1, r0)
            return r2
        L_0x0312:
            r3 = r1
            r2 = r4
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.b.a.a():com.bytedance.sdk.component.f.b");
    }

    /* access modifiers changed from: protected */
    public void a(long j, long j2, com.bytedance.sdk.component.f.a.a aVar) {
        if (aVar != null) {
            aVar.a(this, j, j2);
        }
    }

    public void a(final com.bytedance.sdk.component.f.a.a aVar) {
        File file = this.a;
        if (file != null && this.b != null) {
            final long j = 0;
            if (!file.exists() || this.a.length() == 0 || aVar == null) {
                long length = this.b.length();
                if (length >= 0) {
                    j = length;
                }
                k.a aVar2 = new k.a();
                aVar2.a((Object) b());
                b("Range", "bytes=" + j + "-");
                if (TextUtils.isEmpty(this.f)) {
                    aVar.a((c) this, new IOException("Url is Empty"));
                    return;
                }
                try {
                    aVar2.a(this.f);
                    a(aVar2);
                    this.c.a(aVar2.a().b()).a(new c() {
                        public void a(b bVar, IOException iOException) {
                            com.bytedance.sdk.component.f.a.a aVar = aVar;
                            if (aVar != null) {
                                aVar.a((c) a.this, iOException);
                            }
                            a.this.c();
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:102:0x0267 A[SYNTHETIC, Splitter:B:102:0x0267] */
                        /* JADX WARNING: Removed duplicated region for block: B:118:0x029a A[Catch:{ all -> 0x02b0, all -> 0x02b7, all -> 0x02be }] */
                        /* JADX WARNING: Removed duplicated region for block: B:120:0x02a1 A[SYNTHETIC, Splitter:B:120:0x02a1] */
                        /* JADX WARNING: Removed duplicated region for block: B:141:0x01d1 A[EDGE_INSN: B:141:0x01d1->B:81:0x01d1 ?: BREAK  , SYNTHETIC] */
                        /* JADX WARNING: Removed duplicated region for block: B:56:0x0175  */
                        /* JADX WARNING: Removed duplicated region for block: B:83:0x01d6 A[Catch:{ all -> 0x01cc, all -> 0x01df }] */
                        /* JADX WARNING: Removed duplicated region for block: B:92:0x0200 A[Catch:{ all -> 0x01cc, all -> 0x01df }] */
                        /* JADX WARNING: Removed duplicated region for block: B:96:0x0238 A[Catch:{ all -> 0x01cc, all -> 0x01df }] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void a(com.bytedance.sdk.component.b.a.b r32, com.bytedance.sdk.component.b.a.m r33) throws java.io.IOException {
                            /*
                                r31 = this;
                                r1 = r31
                                java.lang.String r2 = "Error occured when calling tmpFile.close"
                                java.lang.String r3 = "Error occured when calling InputStream.close"
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                if (r0 == 0) goto L_0x02ca
                                java.util.HashMap r0 = new java.util.HashMap
                                r0.<init>()
                                if (r33 == 0) goto L_0x02ca
                                com.bytedance.sdk.component.b.a.e r4 = r33.g()
                                if (r4 == 0) goto L_0x002c
                                r5 = 0
                            L_0x0018:
                                int r6 = r4.a()
                                if (r5 >= r6) goto L_0x002c
                                java.lang.String r6 = r4.a(r5)
                                java.lang.String r7 = r4.b(r5)
                                r0.put(r6, r7)
                                int r5 = r5 + 1
                                goto L_0x0018
                            L_0x002c:
                                com.bytedance.sdk.component.f.b r15 = new com.bytedance.sdk.component.f.b
                                boolean r5 = r33.d()
                                int r6 = r33.c()
                                java.lang.String r7 = r33.e()
                                r9 = 0
                                long r10 = r33.b()
                                long r12 = r33.a()
                                r4 = r15
                                r8 = r0
                                r4.<init>(r5, r6, r7, r8, r9, r10, r12)
                                boolean r4 = r33.d()
                                if (r4 == 0) goto L_0x02c2
                                com.bytedance.sdk.component.b.a.n r4 = r33.f()
                                long r4 = r4.a()
                                r6 = 0
                                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                                if (r8 > 0) goto L_0x0060
                                long r4 = com.bytedance.sdk.component.f.b.a.f(r0)
                            L_0x0060:
                                boolean r8 = com.bytedance.sdk.component.f.b.a.e(r0)
                                r9 = -1
                                if (r8 == 0) goto L_0x00d9
                                long r10 = r1
                                long r4 = r4 + r10
                                java.lang.String r10 = "Content-Range"
                                java.lang.Object r10 = r0.get(r10)
                                java.lang.String r10 = (java.lang.String) r10
                                boolean r11 = android.text.TextUtils.isEmpty(r10)
                                if (r11 != 0) goto L_0x00d9
                                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                                r11.<init>()
                                java.lang.String r12 = "bytes "
                                r11.append(r12)
                                long r12 = r1
                                r11.append(r12)
                                java.lang.String r12 = "-"
                                r11.append(r12)
                                r12 = 1
                                long r12 = r4 - r12
                                r11.append(r12)
                                java.lang.String r11 = r11.toString()
                                int r12 = android.text.TextUtils.indexOf(r10, r11)
                                if (r12 != r9) goto L_0x00d9
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this
                                r0.c()
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this
                                java.io.IOException r3 = new java.io.IOException
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                r4.<init>()
                                java.lang.String r5 = "The Content-Range Header is invalid Assume["
                                r4.append(r5)
                                r4.append(r11)
                                java.lang.String r5 = "] vs Real["
                                r4.append(r5)
                                r4.append(r10)
                                java.lang.String r5 = "], please remove the temporary file ["
                                r4.append(r5)
                                com.bytedance.sdk.component.f.b.a r5 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r5 = r5.b
                                r4.append(r5)
                                java.lang.String r5 = "]."
                                r4.append(r5)
                                java.lang.String r4 = r4.toString()
                                r3.<init>(r4)
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (java.io.IOException) r3)
                                return
                            L_0x00d9:
                                r10 = r4
                                int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                                java.lang.String r5 = "Rename fail"
                                if (r4 <= 0) goto L_0x012a
                                com.bytedance.sdk.component.f.b.a r4 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r4 = r4.b
                                boolean r4 = r4.exists()
                                if (r4 == 0) goto L_0x012a
                                com.bytedance.sdk.component.f.b.a r4 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r4 = r4.b
                                long r12 = r4.length()
                                int r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                                if (r4 != 0) goto L_0x012a
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r0 = r0.b
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r2 = r2.a
                                boolean r0 = r0.renameTo(r2)
                                if (r0 == 0) goto L_0x011d
                                com.bytedance.sdk.component.f.b.a r5 = com.bytedance.sdk.component.f.b.a.this
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                r6 = r10
                                r8 = r10
                                r10 = r0
                                r5.a(r6, r8, r10)
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this
                                java.io.File r0 = r0.a
                                r15.a(r0)
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (com.bytedance.sdk.component.f.b) r15)
                                goto L_0x0129
                            L_0x011d:
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this
                                java.io.IOException r3 = new java.io.IOException
                                r3.<init>(r5)
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (java.io.IOException) r3)
                            L_0x0129:
                                return
                            L_0x012a:
                                java.io.RandomAccessFile r12 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0146 }
                                com.bytedance.sdk.component.f.b.a r13 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x0146 }
                                java.io.File r13 = r13.b     // Catch:{ all -> 0x0146 }
                                java.lang.String r4 = "rw"
                                r12.<init>(r13, r4)     // Catch:{ all -> 0x0146 }
                                if (r8 == 0) goto L_0x0140
                                r13 = r15
                                long r14 = r1     // Catch:{ all -> 0x0144 }
                                r12.seek(r14)     // Catch:{ all -> 0x0144 }
                                long r14 = r1     // Catch:{ all -> 0x0144 }
                                goto L_0x0149
                            L_0x0140:
                                r13 = r15
                                r12.setLength(r6)     // Catch:{ all -> 0x0144 }
                            L_0x0144:
                                r14 = r6
                                goto L_0x0149
                            L_0x0146:
                                r13 = r15
                                r12 = 0
                                goto L_0x0144
                            L_0x0149:
                                com.bytedance.sdk.component.b.a.n r16 = r33.f()     // Catch:{ all -> 0x027b }
                                java.io.InputStream r4 = r16.c()     // Catch:{ all -> 0x027b }
                                boolean r0 = com.bytedance.sdk.component.f.b.a.g(r0)     // Catch:{ all -> 0x0276 }
                                if (r0 == 0) goto L_0x0161
                                boolean r0 = r4 instanceof java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0276 }
                                if (r0 != 0) goto L_0x0161
                                java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0276 }
                                r0.<init>(r4)     // Catch:{ all -> 0x0276 }
                                r4 = r0
                            L_0x0161:
                                r0 = 16384(0x4000, float:2.2959E-41)
                                byte[] r6 = new byte[r0]     // Catch:{ all -> 0x0276 }
                                r22 = r14
                                r7 = 0
                                r14 = 0
                            L_0x016a:
                                int r9 = 16384 - r7
                                int r9 = r4.read(r6, r7, r9)     // Catch:{ all -> 0x0276 }
                                r16 = 1
                                r0 = -1
                                if (r9 == r0) goto L_0x01d1
                                int r7 = r7 + r9
                                long r0 = (long) r9
                                long r14 = r14 + r0
                                r0 = 16384(0x4000, double:8.0948E-320)
                                long r0 = r14 % r0
                                r18 = 0
                                int r0 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
                                if (r0 == 0) goto L_0x0193
                                r1 = r31
                                r9 = r2
                                r24 = r3
                                long r2 = r1     // Catch:{ all -> 0x01df }
                                long r2 = r10 - r2
                                int r0 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
                                if (r0 != 0) goto L_0x0190
                                goto L_0x0198
                            L_0x0190:
                                r16 = 0
                                goto L_0x0198
                            L_0x0193:
                                r1 = r31
                                r9 = r2
                                r24 = r3
                            L_0x0198:
                                if (r16 == 0) goto L_0x01ad
                                r2 = r22
                                r12.seek(r2)     // Catch:{ all -> 0x01a8 }
                                r0 = 0
                                r12.write(r6, r0, r7)     // Catch:{ all -> 0x01a8 }
                                long r0 = (long) r7
                                long r0 = r0 + r2
                                r7 = 0
                                r2 = r0
                                goto L_0x01af
                            L_0x01a8:
                                r0 = move-exception
                                r1 = r31
                                goto L_0x0280
                            L_0x01ad:
                                r2 = r22
                            L_0x01af:
                                r1 = r31
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                r25 = r2
                                long r2 = r1     // Catch:{ all -> 0x01df }
                                long r17 = r2 + r14
                                com.bytedance.sdk.component.f.a.a r2 = r14     // Catch:{ all -> 0x01df }
                                r16 = r0
                                r19 = r10
                                r21 = r2
                                r16.a(r17, r19, r21)     // Catch:{ all -> 0x01df }
                                r2 = r9
                                r3 = r24
                                r22 = r25
                                r0 = 16384(0x4000, float:2.2959E-41)
                                goto L_0x016a
                            L_0x01cc:
                                r0 = move-exception
                                r1 = r31
                                goto L_0x0277
                            L_0x01d1:
                                r9 = r2
                                r24 = r3
                                if (r8 != 0) goto L_0x01e2
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                java.io.File r0 = r0.b     // Catch:{ all -> 0x01df }
                                long r10 = r0.length()     // Catch:{ all -> 0x01df }
                                goto L_0x01e2
                            L_0x01df:
                                r0 = move-exception
                                goto L_0x0280
                            L_0x01e2:
                                r28 = r10
                                r2 = 0
                                int r0 = (r28 > r2 ? 1 : (r28 == r2 ? 0 : -1))
                                if (r0 <= 0) goto L_0x0238
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                java.io.File r0 = r0.b     // Catch:{ all -> 0x01df }
                                boolean r0 = r0.exists()     // Catch:{ all -> 0x01df }
                                if (r0 == 0) goto L_0x0238
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                java.io.File r0 = r0.b     // Catch:{ all -> 0x01df }
                                long r2 = r0.length()     // Catch:{ all -> 0x01df }
                                int r0 = (r2 > r28 ? 1 : (r2 == r28 ? 0 : -1))
                                if (r0 != 0) goto L_0x0238
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                java.io.File r0 = r0.b     // Catch:{ all -> 0x01df }
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                java.io.File r2 = r2.a     // Catch:{ all -> 0x01df }
                                boolean r0 = r0.renameTo(r2)     // Catch:{ all -> 0x01df }
                                if (r0 == 0) goto L_0x022b
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                com.bytedance.sdk.component.f.a.a r2 = r14     // Catch:{ all -> 0x01df }
                                r25 = r0
                                r26 = r28
                                r30 = r2
                                r25.a(r26, r28, r30)     // Catch:{ all -> 0x01df }
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                java.io.File r0 = r0.a     // Catch:{ all -> 0x01df }
                                r2 = r13
                                r2.a(r0)     // Catch:{ all -> 0x01df }
                                com.bytedance.sdk.component.f.a.a r0 = r14     // Catch:{ all -> 0x01df }
                                com.bytedance.sdk.component.f.b.a r3 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                r0.a((com.bytedance.sdk.component.f.b.c) r3, (com.bytedance.sdk.component.f.b) r2)     // Catch:{ all -> 0x01df }
                                goto L_0x0265
                            L_0x022b:
                                com.bytedance.sdk.component.f.a.a r0 = r14     // Catch:{ all -> 0x01df }
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x01df }
                                r3.<init>(r5)     // Catch:{ all -> 0x01df }
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (java.io.IOException) r3)     // Catch:{ all -> 0x01df }
                                goto L_0x0265
                            L_0x0238:
                                com.bytedance.sdk.component.f.a.a r0 = r14     // Catch:{ all -> 0x01df }
                                com.bytedance.sdk.component.f.b.a r2 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x01df }
                                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01df }
                                r5.<init>()     // Catch:{ all -> 0x01df }
                                java.lang.String r6 = " tempFile.length() == fileSize is"
                                r5.append(r6)     // Catch:{ all -> 0x01df }
                                com.bytedance.sdk.component.f.b.a r6 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x01df }
                                java.io.File r6 = r6.b     // Catch:{ all -> 0x01df }
                                long r6 = r6.length()     // Catch:{ all -> 0x01df }
                                int r6 = (r6 > r28 ? 1 : (r6 == r28 ? 0 : -1))
                                if (r6 != 0) goto L_0x0257
                                r6 = r16
                                goto L_0x0258
                            L_0x0257:
                                r6 = 0
                            L_0x0258:
                                r5.append(r6)     // Catch:{ all -> 0x01df }
                                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01df }
                                r3.<init>(r5)     // Catch:{ all -> 0x01df }
                                r0.a((com.bytedance.sdk.component.f.b.c) r2, (java.io.IOException) r3)     // Catch:{ all -> 0x01df }
                            L_0x0265:
                                if (r4 == 0) goto L_0x026e
                                r4.close()     // Catch:{ all -> 0x026b }
                                goto L_0x026e
                            L_0x026b:
                                com.bytedance.sdk.component.f.d.d.a(r24)
                            L_0x026e:
                                r12.close()     // Catch:{ all -> 0x0272 }
                                goto L_0x02ca
                            L_0x0272:
                                com.bytedance.sdk.component.f.d.d.a(r9)
                                goto L_0x02ca
                            L_0x0276:
                                r0 = move-exception
                            L_0x0277:
                                r9 = r2
                                r24 = r3
                                goto L_0x0280
                            L_0x027b:
                                r0 = move-exception
                                r9 = r2
                                r24 = r3
                                r4 = 0
                            L_0x0280:
                                java.lang.String r2 = "Error occured when FileRequest.parseHttpResponse"
                                com.bytedance.sdk.component.f.d.d.a(r2)     // Catch:{ all -> 0x02b0 }
                                r0.printStackTrace()     // Catch:{ all -> 0x02b0 }
                                com.bytedance.sdk.component.f.a.a r2 = r14     // Catch:{ all -> 0x02b0 }
                                com.bytedance.sdk.component.f.b.a r3 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x02b0 }
                                java.io.IOException r5 = new java.io.IOException     // Catch:{ all -> 0x02b0 }
                                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02b0 }
                                r5.<init>(r0)     // Catch:{ all -> 0x02b0 }
                                r2.a((com.bytedance.sdk.component.f.b.c) r3, (java.io.IOException) r5)     // Catch:{ all -> 0x02b0 }
                                if (r8 != 0) goto L_0x029f
                                com.bytedance.sdk.component.f.b.a r0 = com.bytedance.sdk.component.f.b.a.this     // Catch:{ all -> 0x02b0 }
                                r0.c()     // Catch:{ all -> 0x02b0 }
                            L_0x029f:
                                if (r4 == 0) goto L_0x02a8
                                r4.close()     // Catch:{ all -> 0x02a5 }
                                goto L_0x02a8
                            L_0x02a5:
                                com.bytedance.sdk.component.f.d.d.a(r24)
                            L_0x02a8:
                                r12.close()     // Catch:{ all -> 0x02ac }
                                goto L_0x02af
                            L_0x02ac:
                                com.bytedance.sdk.component.f.d.d.a(r9)
                            L_0x02af:
                                return
                            L_0x02b0:
                                r0 = move-exception
                                if (r4 == 0) goto L_0x02ba
                                r4.close()     // Catch:{ all -> 0x02b7 }
                                goto L_0x02ba
                            L_0x02b7:
                                com.bytedance.sdk.component.f.d.d.a(r24)
                            L_0x02ba:
                                r12.close()     // Catch:{ all -> 0x02be }
                                goto L_0x02c1
                            L_0x02be:
                                com.bytedance.sdk.component.f.d.d.a(r9)
                            L_0x02c1:
                                throw r0
                            L_0x02c2:
                                r2 = r15
                                com.bytedance.sdk.component.f.a.a r0 = r14
                                com.bytedance.sdk.component.f.b.a r3 = com.bytedance.sdk.component.f.b.a.this
                                r0.a((com.bytedance.sdk.component.f.b.c) r3, (com.bytedance.sdk.component.f.b) r2)
                            L_0x02ca:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.b.a.AnonymousClass1.a(com.bytedance.sdk.component.b.a.b, com.bytedance.sdk.component.b.a.m):void");
                        }
                    });
                } catch (IllegalArgumentException unused) {
                    aVar.a((c) this, new IOException("Url is not a valid HTTP or HTTPS URL"));
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.component.f.b bVar = new com.bytedance.sdk.component.f.b(true, 200, "Success", (Map<String, String>) null, (String) null, currentTimeMillis, currentTimeMillis);
                bVar.a(this.a);
                aVar.a((c) this, bVar);
            }
        } else if (aVar != null) {
            aVar.a((c) this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
        }
    }

    public void a(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.a = new File(str, str2);
        this.b = new File(str, str2 + ".temp");
    }
}
