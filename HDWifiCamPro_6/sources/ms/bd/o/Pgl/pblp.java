package ms.bd.o.Pgl;

import javax.net.ssl.SSLSocketFactory;

public final class pblp extends pblo {
    private SSLSocketFactory a;

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x04f8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x04f9, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x04f8 A[ExcHandler: all (th java.lang.Throwable), PHI: r6 
      PHI: (r6v46 java.io.DataOutputStream) = (r6v47 java.io.DataOutputStream), (r6v50 java.io.DataOutputStream) binds: [B:93:0x0451, B:88:0x043a] A[DONT_GENERATE, DONT_INLINE], Splitter:B:88:0x043a] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x058f A[Catch:{ all -> 0x05c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x059b A[SYNTHETIC, Splitter:B:142:0x059b] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x05d2 A[SYNTHETIC, Splitter:B:152:0x05d2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object[] a(java.lang.String r31, byte[] r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, boolean r36) {
        /*
            r30 = this;
            r1 = r30
            r0 = r31
            r2 = r34
            r3 = r35
            ms.bd.o.Pgl.pblm$pgla r4 = new ms.bd.o.Pgl.pblm$pgla
            r4.<init>()
            r10 = 5
            r11 = 7
            r13 = 4
            r14 = 3
            r15 = 2
            r5 = 1
            r7 = 0
            r18 = -1
            java.net.URL r8 = new java.net.URL     // Catch:{ Exception -> 0x0508, all -> 0x0502 }
            r8.<init>(r0)     // Catch:{ Exception -> 0x0508, all -> 0x0502 }
            java.net.URLConnection r8 = r8.openConnection()     // Catch:{ Exception -> 0x0508, all -> 0x0502 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x0508, all -> 0x0502 }
            boolean r9 = r8 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r21 = 115(0x73, float:1.61E-43)
            if (r9 == 0) goto L_0x00ae
            javax.net.ssl.SSLSocketFactory r9 = r1.a     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            if (r9 != 0) goto L_0x0096
            java.lang.Class<ms.bd.o.Pgl.pblp> r9 = ms.bd.o.Pgl.pblp.class
            monitor-enter(r9)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            javax.net.ssl.SSLSocketFactory r6 = r1.a     // Catch:{ all -> 0x0092 }
            if (r6 != 0) goto L_0x008d
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0092 }
            r12 = 20
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            if (r6 < r12) goto L_0x0054
            java.lang.String r27 = "b53eff"
            byte[] r6 = new byte[r14]     // Catch:{ all -> 0x0092 }
            r12 = 71
            r6[r7] = r12     // Catch:{ all -> 0x0092 }
            r12 = 27
            r6[r5] = r12     // Catch:{ all -> 0x0092 }
            r6[r15] = r21     // Catch:{ all -> 0x0092 }
            r28 = r6
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x0092 }
            goto L_0x007c
        L_0x0054:
            java.lang.String r27 = "b4f464"
            byte[] r6 = new byte[r11]     // Catch:{ all -> 0x0092 }
            r12 = 71
            r6[r7] = r12     // Catch:{ all -> 0x0092 }
            r12 = 26
            r6[r5] = r12     // Catch:{ all -> 0x0092 }
            r12 = 38
            r6[r15] = r12     // Catch:{ all -> 0x0092 }
            r12 = 86
            r6[r14] = r12     // Catch:{ all -> 0x0092 }
            r12 = 88
            r6[r13] = r12     // Catch:{ all -> 0x0092 }
            r12 = 109(0x6d, float:1.53E-43)
            r6[r10] = r12     // Catch:{ all -> 0x0092 }
            r12 = 51
            r22 = 6
            r6[r22] = r12     // Catch:{ all -> 0x0092 }
            r28 = r6
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x0092 }
        L_0x007c:
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0092 }
            javax.net.ssl.SSLContext r6 = javax.net.ssl.SSLContext.getInstance(r6)     // Catch:{ all -> 0x0092 }
            r12 = 0
            r6.init(r12, r12, r12)     // Catch:{ all -> 0x0090 }
            javax.net.ssl.SSLSocketFactory r6 = r6.getSocketFactory()     // Catch:{ all -> 0x0090 }
            r1.a = r6     // Catch:{ all -> 0x0090 }
            goto L_0x008e
        L_0x008d:
            r12 = 0
        L_0x008e:
            monitor-exit(r9)     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x0090:
            r0 = move-exception
            goto L_0x0094
        L_0x0092:
            r0 = move-exception
            r12 = 0
        L_0x0094:
            monitor-exit(r9)     // Catch:{ all -> 0x0090 }
            throw r0     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
        L_0x0096:
            r12 = 0
        L_0x0097:
            r6 = r8
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 20
            if (r9 < r12) goto L_0x00a6
            javax.net.ssl.SSLSocketFactory r9 = r1.a     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
        L_0x00a2:
            r6.setSSLSocketFactory(r9)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            goto L_0x00ae
        L_0x00a6:
            ms.bd.o.Pgl.pblr r9 = new ms.bd.o.Pgl.pblr     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            javax.net.ssl.SSLSocketFactory r12 = r1.a     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9.<init>(r12)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            goto L_0x00a2
        L_0x00ae:
            r6 = 10000(0x2710, float:1.4013E-41)
            r8.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 5000(0x1388, float:7.006E-42)
            r8.setReadTimeout(r6)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "f15ada"
            r6 = 6
            byte[] r9 = new byte[r6]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 86
            r9[r7] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 48
            r9[r5] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 69
            r9[r15] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 16
            r9[r14] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 75
            r9[r13] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 98
            r9[r10] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r9
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "6897e1"
            byte[] r9 = new byte[r14]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 109(0x6d, float:1.53E-43)
            r9[r7] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 117(0x75, float:1.64E-43)
            r9[r5] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9[r15] = r7     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r9
            java.lang.Object r9 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r8.setRequestProperty(r6, r9)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "b651cb"
            r6 = 10
            byte[] r9 = new byte[r6]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 80
            r9[r7] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 59
            r9[r5] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 72
            r9[r15] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 75
            r9[r14] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 89
            r9[r13] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 118(0x76, float:1.65E-43)
            r9[r10] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 117(0x75, float:1.64E-43)
            r12 = 6
            r9[r12] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 30
            r9[r11] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 107(0x6b, float:1.5E-43)
            r12 = 8
            r9[r12] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 111(0x6f, float:1.56E-43)
            r12 = 9
            r9[r12] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r9
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "eb40f8"
            r9 = 10
            byte[] r12 = new byte[r9]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 95
            r12[r7] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 101(0x65, float:1.42E-43)
            r12[r5] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 66
            r12[r15] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 84
            r12[r14] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 20
            r12[r13] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 14
            r12[r10] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 106(0x6a, float:1.49E-43)
            r22 = 6
            r12[r22] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 74
            r12[r11] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 8
            r12[r9] = r21     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 101(0x65, float:1.42E-43)
            r17 = 9
            r12[r17] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r12
            java.lang.Object r9 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r8.setRequestProperty(r6, r9)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "3fbfa9"
            r6 = 10
            byte[] r9 = new byte[r6]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 23
            r9[r7] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 119(0x77, float:1.67E-43)
            r9[r5] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 20
            r9[r15] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9[r14] = r7     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 19
            r9[r13] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 15
            r9[r10] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 55
            r12 = 6
            r9[r12] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 66
            r9[r11] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 61
            r12 = 8
            r9[r12] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 34
            r12 = 9
            r9[r12] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r9
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "3155c1"
            r9 = 15
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9[r7] = r7     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 42
            r9[r5] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 82
            r9[r15] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 68
            r9[r14] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 120(0x78, float:1.68E-43)
            r9[r13] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 39
            r9[r10] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 62
            r22 = 6
            r9[r22] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 19
            r9[r11] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 97
            r19 = 8
            r9[r19] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 40
            r17 = 9
            r9[r17] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 15
            r20 = 10
            r9[r20] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12 = 11
            r9[r12] = r7     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 12
            r29 = 117(0x75, float:1.64E-43)
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 13
            r29 = 101(0x65, float:1.42E-43)
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 119(0x77, float:1.67E-43)
            r16 = 14
            r9[r16] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r9
            java.lang.Object r9 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r8.setRequestProperty(r6, r9)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "2a06bc"
            r6 = 12
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6[r7] = r7     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 108(0x6c, float:1.51E-43)
            r6[r5] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 77
            r6[r15] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 86
            r6[r14] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 88
            r6[r13] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 122(0x7a, float:1.71E-43)
            r6[r10] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 37
            r22 = 6
            r6[r22] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 13
            r6[r11] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 85
            r19 = 8
            r6[r19] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 127(0x7f, float:1.78E-43)
            r17 = 9
            r6[r17] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 51
            r20 = 10
            r6[r20] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 102(0x66, float:1.43E-43)
            r6[r12] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r6
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "d64e8a"
            r9 = 24
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 116(0x74, float:1.63E-43)
            r9[r7] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 36
            r9[r5] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 87
            r9[r15] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 29
            r9[r14] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r16 = 14
            r9[r13] = r16     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 117(0x75, float:1.64E-43)
            r9[r10] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 102(0x66, float:1.43E-43)
            r22 = 6
            r9[r22] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9[r11] = r14     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 108(0x6c, float:1.51E-43)
            r19 = 8
            r9[r19] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 58
            r17 = 9
            r9[r17] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 123(0x7b, float:1.72E-43)
            r20 = 10
            r9[r20] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 123(0x7b, float:1.72E-43)
            r9[r12] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 12
            r29 = 72
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 13
            r29 = 18
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 19
            r16 = 14
            r9[r16] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 15
            r9[r28] = r21     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 16
            r9[r28] = r21     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 17
            r29 = 90
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 18
            r29 = 118(0x76, float:1.65E-43)
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 19
            r29 = 33
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 20
            r29 = 103(0x67, float:1.44E-43)
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 21
            r29 = 49
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 22
            r29 = 70
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 23
            r29 = 28
            r9[r28] = r29     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r9
            java.lang.Object r9 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r8.setRequestProperty(r6, r9)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            if (r33 == 0) goto L_0x0395
            java.lang.String r6 = r33.trim()     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            int r6 = r6.length()     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            if (r6 <= 0) goto L_0x0395
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "bea2ce"
            r6 = 6
            byte[] r9 = new byte[r6]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 80
            r9[r7] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 104(0x68, float:1.46E-43)
            r9[r5] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 29
            r9[r15] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 77
            r9[r14] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 85
            r9[r13] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6 = 119(0x77, float:1.67E-43)
            r9[r10] = r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r9
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "cc601b"
            r9 = 12
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 97
            r9[r7] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 100
            r9[r5] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 86
            r9[r15] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 87
            r9[r14] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9[r13] = r11     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 122(0x7a, float:1.71E-43)
            r9[r10] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 110(0x6e, float:1.54E-43)
            r22 = 6
            r9[r22] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 75
            r9[r11] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 99
            r19 = 8
            r9[r19] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 61
            r17 = 9
            r9[r17] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 55
            r20 = 10
            r9[r20] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = 114(0x72, float:1.6E-43)
            r9[r12] = r28     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r9
            java.lang.Object r9 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r12[r7] = r33     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r9 = java.lang.String.format(r9, r12)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r8.setRequestProperty(r6, r9)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
        L_0x0395:
            if (r2 == 0) goto L_0x0405
            java.lang.String r6 = r34.trim()     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            int r6 = r6.length()     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            if (r6 <= 0) goto L_0x0405
            r24 = 16777217(0x1000001, float:2.350989E-38)
            r25 = 0
            r26 = 0
            java.lang.String r28 = "6b528c"
            r6 = 16
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 63
            r6[r7] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 45
            r6[r5] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 82
            r6[r15] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 82
            r6[r14] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 74
            r6[r13] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 102(0x66, float:1.43E-43)
            r6[r10] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 48
            r12 = 6
            r6[r12] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 82
            r6[r11] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 113(0x71, float:1.58E-43)
            r12 = 8
            r6[r12] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 103(0x67, float:1.44E-43)
            r12 = 9
            r6[r12] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 52
            r12 = 10
            r6[r12] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 116(0x74, float:1.63E-43)
            r12 = 11
            r6[r12] = r9     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 12
            r6[r9] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 13
            r12 = 82
            r6[r9] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 14
            r12 = 6
            r6[r9] = r12     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r9 = 15
            r6[r9] = r21     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r29 = r6
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r24, r25, r26, r28, r29)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r8.setRequestProperty(r6, r2)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
        L_0x0405:
            r4.a(r0)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            if (r36 == 0) goto L_0x0441
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "d13332"
            byte[] r0 = new byte[r13]     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r2 = 69
            r0[r7] = r2     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r2 = 28
            r0[r5] = r2     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r0[r15] = r21     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r0[r14] = r21     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r28 = r0
            java.lang.Object r0 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r8.setRequestMethod(r0)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r8.setDoOutput(r5)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            java.io.OutputStream r0 = r8.getOutputStream()     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0509, all -> 0x0500 }
            r0 = r32
            r6.write(r0)     // Catch:{ Exception -> 0x04fc, all -> 0x04f8 }
            r6.flush()     // Catch:{ Exception -> 0x04fc, all -> 0x04f8 }
            goto L_0x0442
        L_0x0441:
            r6 = 0
        L_0x0442:
            int r0 = r8.getResponseCode()     // Catch:{ Exception -> 0x04fc, all -> 0x04f8 }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "0a3e2c"
            r2 = 10
            byte[] r9 = new byte[r2]     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 57
            r9[r7] = r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 46
            r9[r5] = r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 84
            r9[r15] = r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r9[r14] = r10     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 64
            r9[r13] = r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 120(0x78, float:1.68E-43)
            r9[r10] = r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 60
            r12 = 6
            r9[r12] = r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 71
            r9[r11] = r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 107(0x6b, float:1.5E-43)
            r12 = 8
            r9[r12] = r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 49
            r12 = 9
            r9[r12] = r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r28 = r9
            java.lang.Object r2 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            java.lang.String r2 = r8.getHeaderField(r2)     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r4.b(r2, r0)     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x04c9
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            java.io.InputStream r9 = r8.getInputStream()     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            r2.<init>(r9)     // Catch:{ Exception -> 0x04f5, all -> 0x04f8 }
            if (r3 == 0) goto L_0x04a2
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x050d }
            r9.<init>(r3)     // Catch:{ Exception -> 0x050d }
            goto L_0x04a7
        L_0x04a2:
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x050d }
            r9.<init>()     // Catch:{ Exception -> 0x050d }
        L_0x04a7:
            r3 = 256(0x100, float:3.59E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x050d }
        L_0x04ab:
            int r12 = r2.read(r3)     // Catch:{ Exception -> 0x050d }
            if (r12 <= 0) goto L_0x04b5
            r9.write(r3, r7, r12)     // Catch:{ Exception -> 0x050d }
            goto L_0x04ab
        L_0x04b5:
            r9.flush()     // Catch:{ Exception -> 0x050d }
            boolean r3 = r9 instanceof java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x050d }
            if (r3 == 0) goto L_0x04c4
            r3 = r9
            java.io.ByteArrayOutputStream r3 = (java.io.ByteArrayOutputStream) r3     // Catch:{ Exception -> 0x050d }
            byte[] r3 = r3.toByteArray()     // Catch:{ Exception -> 0x050d }
            goto L_0x04c5
        L_0x04c4:
            r3 = 0
        L_0x04c5:
            r9.close()     // Catch:{ Exception -> 0x050d }
            goto L_0x04cb
        L_0x04c9:
            r2 = 0
            r3 = 0
        L_0x04cb:
            r1.a((java.io.InputStream) r2)
            r1.a((java.io.OutputStream) r6)
            r8.disconnect()     // Catch:{ Exception -> 0x04d6 }
            goto L_0x05be
        L_0x04d6:
            byte[] r2 = new byte[r11]
            r2 = {58, 59, 22, 122, 5, 52, 105} // fill-array
            r4 = 16777217(0x1000001, float:2.350989E-38)
            r6 = 0
            r8 = 0
            java.lang.String r10 = "81f122"
            r31 = r4
            r32 = r6
            r33 = r8
            r35 = r10
            r36 = r2
            java.lang.Object r2 = ms.bd.o.Pgl.pblk.a(r31, r32, r33, r35, r36)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x05be
        L_0x04f5:
            r18 = r0
            goto L_0x04fc
        L_0x04f8:
            r0 = move-exception
            r2 = 0
            goto L_0x05ca
        L_0x04fc:
            r0 = r18
            r2 = 0
            goto L_0x050d
        L_0x0500:
            r0 = move-exception
            goto L_0x0504
        L_0x0502:
            r0 = move-exception
            r8 = 0
        L_0x0504:
            r2 = 0
            r6 = 0
            goto L_0x05ca
        L_0x0508:
            r8 = 0
        L_0x0509:
            r0 = r18
            r2 = 0
            r6 = 0
        L_0x050d:
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r23 = 0
            java.lang.String r12 = "cfed9d"
            r11 = 6
            byte[] r9 = new byte[r11]     // Catch:{ all -> 0x05c9 }
            r11 = 97
            r9[r7] = r11     // Catch:{ all -> 0x05c9 }
            r11 = 108(0x6c, float:1.51E-43)
            r9[r5] = r11     // Catch:{ all -> 0x05c9 }
            r11 = 21
            r9[r15] = r11     // Catch:{ all -> 0x05c9 }
            r11 = 47
            r9[r14] = r11     // Catch:{ all -> 0x05c9 }
            r11 = 14
            r9[r13] = r11     // Catch:{ all -> 0x05c9 }
            r11 = 98
            r9[r10] = r11     // Catch:{ all -> 0x05c9 }
            r31 = r3
            r3 = 0
            r32 = r3
            r33 = r23
            r35 = r12
            r36 = r9
            java.lang.Object r3 = ms.bd.o.Pgl.pblk.a(r31, r32, r33, r35, r36)     // Catch:{ all -> 0x05c9 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x05c9 }
            if (r8 == 0) goto L_0x058f
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r9 = 0
            java.lang.String r16 = "781d0b"
            r11 = 10
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x05c9 }
            r12 = 62
            r11[r7] = r12     // Catch:{ all -> 0x05c9 }
            r12 = 119(0x77, float:1.67E-43)
            r11[r5] = r12     // Catch:{ all -> 0x05c9 }
            r12 = 86
            r11[r15] = r12     // Catch:{ all -> 0x05c9 }
            r11[r14] = r13     // Catch:{ all -> 0x05c9 }
            r12 = 66
            r11[r13] = r12     // Catch:{ all -> 0x05c9 }
            r12 = 121(0x79, float:1.7E-43)
            r11[r10] = r12     // Catch:{ all -> 0x05c9 }
            r10 = 59
            r12 = 6
            r11[r12] = r10     // Catch:{ all -> 0x05c9 }
            r10 = 30
            r12 = 7
            r11[r12] = r10     // Catch:{ all -> 0x05c9 }
            r10 = 105(0x69, float:1.47E-43)
            r12 = 8
            r11[r12] = r10     // Catch:{ all -> 0x05c9 }
            r10 = 48
            r12 = 9
            r11[r12] = r10     // Catch:{ all -> 0x05c9 }
            r31 = r3
            r32 = r9
            r9 = 0
            r33 = r9
            r35 = r16
            r36 = r11
            java.lang.Object r3 = ms.bd.o.Pgl.pblk.a(r31, r32, r33, r35, r36)     // Catch:{ all -> 0x05c9 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x05c9 }
            java.lang.String r3 = r8.getHeaderField(r3)     // Catch:{ all -> 0x05c9 }
            goto L_0x0590
        L_0x058f:
            r3 = 0
        L_0x0590:
            r4.a(r3, r0)     // Catch:{ all -> 0x05c9 }
            r1.a((java.io.InputStream) r2)
            r1.a((java.io.OutputStream) r6)
            if (r8 == 0) goto L_0x05bd
            r8.disconnect()     // Catch:{ Exception -> 0x059f }
            goto L_0x05bd
        L_0x059f:
            r2 = 7
            byte[] r2 = new byte[r2]
            r2 = {97, 56, 66, 121, 85, 48, 50} // fill-array
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            r8 = 0
            java.lang.String r6 = "c222b6"
            r31 = r3
            r32 = r4
            r33 = r8
            r35 = r6
            r36 = r2
            java.lang.Object r2 = ms.bd.o.Pgl.pblk.a(r31, r32, r33, r35, r36)
            java.lang.String r2 = (java.lang.String) r2
        L_0x05bd:
            r3 = 0
        L_0x05be:
            java.lang.Object[] r2 = new java.lang.Object[r15]
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2[r7] = r0
            r2[r5] = r3
            return r2
        L_0x05c9:
            r0 = move-exception
        L_0x05ca:
            r1.a((java.io.InputStream) r2)
            r1.a((java.io.OutputStream) r6)
            if (r8 == 0) goto L_0x05f4
            r8.disconnect()     // Catch:{ Exception -> 0x05d6 }
            goto L_0x05f4
        L_0x05d6:
            r2 = 7
            byte[] r2 = new byte[r2]
            r2 = {96, 107, 19, 45, 83, 63, 51} // fill-array
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            r5 = 0
            java.lang.String r7 = "bacfd9"
            r31 = r3
            r32 = r4
            r33 = r5
            r35 = r7
            r36 = r2
            java.lang.Object r2 = ms.bd.o.Pgl.pblk.a(r31, r32, r33, r35, r36)
            java.lang.String r2 = (java.lang.String) r2
        L_0x05f4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bd.o.Pgl.pblp.a(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.Object[]");
    }

    public Object[] a(String str, String str2, String str3) {
        return a(str, (byte[]) null, (String) null, str3, str2, false);
    }

    public Object[] a(String str, byte[] bArr, String str2, String str3) {
        return a(str, bArr, str2, str3, (String) null, true);
    }

    public Object[] b(String str, String str2, String str3) {
        return a(str, (byte[]) null, str2, str3, (String) null, false);
    }
}
