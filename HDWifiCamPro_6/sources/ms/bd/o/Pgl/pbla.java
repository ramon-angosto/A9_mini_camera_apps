package ms.bd.o.Pgl;

import com.bytedance.retrofit2.client.Header;
import java.util.List;

public final class pbla extends pblo {
    private String a(List<Header> list) {
        if (list != null && list.size() > 0) {
            for (Header next : list) {
                if (next != null && ((String) pblk.a(16777217, 0, 0, "95a3b9", new byte[]{48, 122, 6, 83, 16, 34, 53, 19, 57, 103})).equalsIgnoreCase(next.getName())) {
                    return next.getValue();
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x041a A[Catch:{ all -> 0x043f }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0423 A[Catch:{ all -> 0x043f }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x042f A[DONT_GENERATE] */
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
            r7 = 5
            r8 = 4
            r9 = 1
            r10 = 2
            r11 = 6
            r12 = 3
            r13 = 0
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x03df }
            r15.<init>()     // Catch:{ all -> 0x03df }
            com.bytedance.retrofit2.client.Header r6 = new com.bytedance.retrofit2.client.Header     // Catch:{ all -> 0x03df }
            r17 = 16777217(0x1000001, float:2.350989E-38)
            r18 = 0
            r19 = 0
            java.lang.String r21 = "d29e0b"
            byte[] r14 = new byte[r11]     // Catch:{ all -> 0x03df }
            r22 = 86
            r14[r13] = r22     // Catch:{ all -> 0x03df }
            r22 = 63
            r14[r9] = r22     // Catch:{ all -> 0x03df }
            r22 = 69
            r14[r10] = r22     // Catch:{ all -> 0x03df }
            r22 = 26
            r14[r12] = r22     // Catch:{ all -> 0x03df }
            r14[r8] = r11     // Catch:{ all -> 0x03df }
            r22 = 112(0x70, float:1.57E-43)
            r14[r7] = r22     // Catch:{ all -> 0x03df }
            r22 = r14
            java.lang.Object r14 = ms.bd.o.Pgl.pblk.a(r17, r18, r19, r21, r22)     // Catch:{ all -> 0x03df }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x03df }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x03df }
            r5.<init>()     // Catch:{ all -> 0x03df }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "262d47"
            r11 = 10
            byte[] r7 = new byte[r11]     // Catch:{ all -> 0x03df }
            r20 = 48
            r7[r13] = r20     // Catch:{ all -> 0x03df }
            r20 = 49
            r7[r9] = r20     // Catch:{ all -> 0x03df }
            r20 = 82
            r7[r10] = r20     // Catch:{ all -> 0x03df }
            r7[r12] = r12     // Catch:{ all -> 0x03df }
            r7[r8] = r10     // Catch:{ all -> 0x03df }
            r20 = 47
            r19 = 5
            r7[r19] = r20     // Catch:{ all -> 0x03df }
            r20 = 63
            r18 = 6
            r7[r18] = r20     // Catch:{ all -> 0x03df }
            r20 = 30
            r21 = 7
            r7[r21] = r20     // Catch:{ all -> 0x03df }
            r20 = 103(0x67, float:1.44E-43)
            r22 = 8
            r7[r22] = r20     // Catch:{ all -> 0x03df }
            r20 = 105(0x69, float:1.47E-43)
            r29 = 9
            r7[r29] = r20     // Catch:{ all -> 0x03df }
            r28 = r7
            java.lang.Object r7 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x03df }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x03df }
            r5.append(r7)     // Catch:{ all -> 0x03df }
            r7 = r33
            r5.append(r7)     // Catch:{ all -> 0x03df }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x03df }
            r6.<init>(r14, r5)     // Catch:{ all -> 0x03df }
            r15.add(r6)     // Catch:{ all -> 0x03df }
            com.bytedance.retrofit2.client.Header r5 = new com.bytedance.retrofit2.client.Header     // Catch:{ all -> 0x03df }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "810288"
            r6 = 6
            byte[] r7 = new byte[r6]     // Catch:{ all -> 0x03df }
            r7[r13] = r22     // Catch:{ all -> 0x03df }
            r6 = 48
            r7[r9] = r6     // Catch:{ all -> 0x03df }
            r6 = 64
            r7[r10] = r6     // Catch:{ all -> 0x03df }
            r6 = 67
            r7[r12] = r6     // Catch:{ all -> 0x03df }
            r6 = 23
            r7[r8] = r6     // Catch:{ all -> 0x03df }
            r6 = 59
            r14 = 5
            r7[r14] = r6     // Catch:{ all -> 0x03df }
            r28 = r7
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x03df }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x03df }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "a1f748"
            byte[] r7 = new byte[r12]     // Catch:{ all -> 0x03df }
            r14 = 58
            r7[r13] = r14     // Catch:{ all -> 0x03df }
            r14 = 124(0x7c, float:1.74E-43)
            r7[r9] = r14     // Catch:{ all -> 0x03df }
            r14 = 95
            r7[r10] = r14     // Catch:{ all -> 0x03df }
            r28 = r7
            java.lang.Object r7 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x03df }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x03df }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x03df }
            r15.add(r5)     // Catch:{ all -> 0x03df }
            com.bytedance.retrofit2.client.Header r5 = new com.bytedance.retrofit2.client.Header     // Catch:{ all -> 0x03df }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "5c829a"
            byte[] r6 = new byte[r11]     // Catch:{ all -> 0x03df }
            r7 = 17
            r6[r13] = r7     // Catch:{ all -> 0x03df }
            r7 = 114(0x72, float:1.6E-43)
            r6[r9] = r7     // Catch:{ all -> 0x03df }
            r7 = 78
            r6[r10] = r7     // Catch:{ all -> 0x03df }
            r7 = 84
            r6[r12] = r7     // Catch:{ all -> 0x03df }
            r7 = 75
            r6[r8] = r7     // Catch:{ all -> 0x03df }
            r7 = 87
            r14 = 5
            r6[r14] = r7     // Catch:{ all -> 0x03df }
            r7 = 49
            r14 = 6
            r6[r14] = r7     // Catch:{ all -> 0x03df }
            r7 = 71
            r6[r21] = r7     // Catch:{ all -> 0x03df }
            r7 = 103(0x67, float:1.44E-43)
            r6[r22] = r7     // Catch:{ all -> 0x03df }
            r7 = 118(0x76, float:1.65E-43)
            r6[r29] = r7     // Catch:{ all -> 0x03df }
            r28 = r6
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x03df }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x03df }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "5923e1"
            r7 = 15
            byte[] r14 = new byte[r7]     // Catch:{ all -> 0x03df }
            r7 = 6
            r14[r13] = r7     // Catch:{ all -> 0x03df }
            r7 = 34
            r14[r9] = r7     // Catch:{ all -> 0x03df }
            r7 = 85
            r14[r10] = r7     // Catch:{ all -> 0x03df }
            r7 = 66
            r14[r12] = r7     // Catch:{ all -> 0x03df }
            r7 = 126(0x7e, float:1.77E-43)
            r14[r8] = r7     // Catch:{ all -> 0x03df }
            r7 = 39
            r19 = 5
            r14[r19] = r7     // Catch:{ all -> 0x03df }
            r7 = 56
            r18 = 6
            r14[r18] = r7     // Catch:{ all -> 0x03df }
            r7 = 27
            r14[r21] = r7     // Catch:{ all -> 0x03df }
            r7 = 102(0x66, float:1.43E-43)
            r14[r22] = r7     // Catch:{ all -> 0x03df }
            r7 = 46
            r14[r29] = r7     // Catch:{ all -> 0x03df }
            r14[r11] = r29     // Catch:{ all -> 0x03df }
            r7 = 11
            r14[r7] = r22     // Catch:{ all -> 0x03df }
            r20 = 114(0x72, float:1.6E-43)
            r7 = 12
            r14[r7] = r20     // Catch:{ all -> 0x03df }
            r20 = 13
            r28 = 99
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 14
            r28 = 113(0x71, float:1.58E-43)
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r28 = r14
            java.lang.Object r14 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x03df }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x03df }
            r5.<init>(r6, r14)     // Catch:{ all -> 0x03df }
            r15.add(r5)     // Catch:{ all -> 0x03df }
            com.bytedance.retrofit2.client.Header r5 = new com.bytedance.retrofit2.client.Header     // Catch:{ all -> 0x03df }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "6f4769"
            byte[] r6 = new byte[r7]     // Catch:{ all -> 0x03df }
            r6[r13] = r8     // Catch:{ all -> 0x03df }
            r14 = 107(0x6b, float:1.5E-43)
            r6[r9] = r14     // Catch:{ all -> 0x03df }
            r14 = 73
            r6[r10] = r14     // Catch:{ all -> 0x03df }
            r14 = 87
            r6[r12] = r14     // Catch:{ all -> 0x03df }
            r6[r8] = r7     // Catch:{ all -> 0x03df }
            r14 = 32
            r19 = 5
            r6[r19] = r14     // Catch:{ all -> 0x03df }
            r14 = 33
            r18 = 6
            r6[r18] = r14     // Catch:{ all -> 0x03df }
            r6[r21] = r11     // Catch:{ all -> 0x03df }
            r14 = 81
            r6[r22] = r14     // Catch:{ all -> 0x03df }
            r14 = 126(0x7e, float:1.77E-43)
            r6[r29] = r14     // Catch:{ all -> 0x03df }
            r14 = 55
            r6[r11] = r14     // Catch:{ all -> 0x03df }
            r14 = 97
            r20 = 11
            r6[r20] = r14     // Catch:{ all -> 0x03df }
            r28 = r6
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x03df }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x03df }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "015d33"
            r14 = 24
            byte[] r14 = new byte[r14]     // Catch:{ all -> 0x03df }
            r20 = 32
            r14[r13] = r20     // Catch:{ all -> 0x03df }
            r20 = 35
            r14[r9] = r20     // Catch:{ all -> 0x03df }
            r20 = 86
            r14[r10] = r20     // Catch:{ all -> 0x03df }
            r20 = 28
            r14[r12] = r20     // Catch:{ all -> 0x03df }
            r19 = 5
            r14[r8] = r19     // Catch:{ all -> 0x03df }
            r20 = 39
            r14[r19] = r20     // Catch:{ all -> 0x03df }
            r20 = 50
            r18 = 6
            r14[r18] = r20     // Catch:{ all -> 0x03df }
            r14[r21] = r8     // Catch:{ all -> 0x03df }
            r20 = 109(0x6d, float:1.53E-43)
            r14[r22] = r20     // Catch:{ all -> 0x03df }
            r20 = 59
            r14[r29] = r20     // Catch:{ all -> 0x03df }
            r20 = 47
            r14[r11] = r20     // Catch:{ all -> 0x03df }
            r20 = 124(0x7c, float:1.74E-43)
            r28 = 11
            r14[r28] = r20     // Catch:{ all -> 0x03df }
            r20 = 73
            r14[r7] = r20     // Catch:{ all -> 0x03df }
            r20 = 13
            r28 = 19
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 14
            r28 = 24
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 33
            r17 = 15
            r14[r17] = r20     // Catch:{ all -> 0x03df }
            r20 = 16
            r28 = 39
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 17
            r28 = 93
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 18
            r28 = 119(0x77, float:1.67E-43)
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 19
            r28 = 32
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 20
            r28 = 51
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 21
            r28 = 54
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 22
            r28 = 71
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r20 = 23
            r28 = 29
            r14[r20] = r28     // Catch:{ all -> 0x03df }
            r28 = r14
            java.lang.Object r14 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x03df }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x03df }
            r5.<init>(r6, r14)     // Catch:{ all -> 0x03df }
            r15.add(r5)     // Catch:{ all -> 0x03df }
            if (r2 == 0) goto L_0x02d2
            java.lang.String r5 = r34.trim()     // Catch:{ all -> 0x03df }
            int r5 = r5.length()     // Catch:{ all -> 0x03df }
            if (r5 <= 0) goto L_0x02d2
            com.bytedance.retrofit2.client.Header r5 = new com.bytedance.retrofit2.client.Header     // Catch:{ all -> 0x03df }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "ed2c94"
            r6 = 16
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x03df }
            r14 = 108(0x6c, float:1.51E-43)
            r6[r13] = r14     // Catch:{ all -> 0x03df }
            r14 = 43
            r6[r9] = r14     // Catch:{ all -> 0x03df }
            r14 = 85
            r6[r10] = r14     // Catch:{ all -> 0x03df }
            r6[r12] = r12     // Catch:{ all -> 0x03df }
            r14 = 75
            r6[r8] = r14     // Catch:{ all -> 0x03df }
            r14 = 49
            r19 = 5
            r6[r19] = r14     // Catch:{ all -> 0x03df }
            r14 = 99
            r18 = 6
            r6[r18] = r14     // Catch:{ all -> 0x03df }
            r14 = 84
            r6[r21] = r14     // Catch:{ all -> 0x03df }
            r14 = 118(0x76, float:1.65E-43)
            r6[r22] = r14     // Catch:{ all -> 0x03df }
            r14 = 54
            r6[r29] = r14     // Catch:{ all -> 0x03df }
            r14 = 103(0x67, float:1.44E-43)
            r6[r11] = r14     // Catch:{ all -> 0x03df }
            r14 = 114(0x72, float:1.6E-43)
            r20 = 11
            r6[r20] = r14     // Catch:{ all -> 0x03df }
            r6[r7] = r7     // Catch:{ all -> 0x03df }
            r14 = 13
            r6[r14] = r12     // Catch:{ all -> 0x03df }
            r14 = 14
            r6[r14] = r21     // Catch:{ all -> 0x03df }
            r14 = 36
            r17 = 15
            r6[r17] = r14     // Catch:{ all -> 0x03df }
            r28 = r6
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x03df }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x03df }
            r5.<init>(r6, r2)     // Catch:{ all -> 0x03df }
            r15.add(r5)     // Catch:{ all -> 0x03df }
        L_0x02d2:
            com.bytedance.retrofit2.Retrofit r2 = com.bytedance.ttnet.utils.RetrofitUtils.getSsRetrofit(r31)     // Catch:{ all -> 0x03df }
            java.lang.Class<ms.bd.o.Pgl.a> r5 = ms.bd.o.Pgl.a.class
            java.lang.Object r2 = r2.create(r5)     // Catch:{ all -> 0x03df }
            ms.bd.o.Pgl.a r2 = (ms.bd.o.Pgl.a) r2     // Catch:{ all -> 0x03df }
            if (r36 == 0) goto L_0x037b
            com.bytedance.retrofit2.mime.TypedByteArray r5 = new com.bytedance.retrofit2.mime.TypedByteArray     // Catch:{ all -> 0x03df }
            r23 = 16777217(0x1000001, float:2.350989E-38)
            r24 = 0
            r25 = 0
            java.lang.String r27 = "13c0da"
            r6 = 24
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x03df }
            r14 = 33
            r6[r13] = r14     // Catch:{ all -> 0x03df }
            r14 = 33
            r6[r9] = r14     // Catch:{ all -> 0x03df }
            r6[r10] = r13     // Catch:{ all -> 0x03df }
            r14 = 72
            r6[r12] = r14     // Catch:{ all -> 0x03df }
            r14 = 82
            r6[r8] = r14     // Catch:{ all -> 0x03df }
            r14 = 117(0x75, float:1.64E-43)
            r19 = 5
            r6[r19] = r14     // Catch:{ all -> 0x03df }
            r14 = 51
            r18 = 6
            r6[r18] = r14     // Catch:{ all -> 0x03df }
            r6[r21] = r18     // Catch:{ all -> 0x03df }
            r14 = 59
            r6[r22] = r14     // Catch:{ all -> 0x03df }
            r14 = 111(0x6f, float:1.56E-43)
            r6[r29] = r14     // Catch:{ all -> 0x03df }
            r14 = 46
            r6[r11] = r14     // Catch:{ all -> 0x03df }
            r11 = 126(0x7e, float:1.77E-43)
            r14 = 11
            r6[r14] = r11     // Catch:{ all -> 0x03df }
            r11 = 31
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 13
            r11 = 71
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 14
            r11 = 79
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 115(0x73, float:1.61E-43)
            r11 = 15
            r6[r11] = r7     // Catch:{ all -> 0x03df }
            r7 = 16
            r11 = 38
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 17
            r11 = 95
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 18
            r11 = 33
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 19
            r11 = 116(0x74, float:1.63E-43)
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 20
            r11 = 50
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 21
            r11 = 52
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 22
            r11 = 17
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r7 = 23
            r11 = 73
            r6[r7] = r11     // Catch:{ all -> 0x03df }
            r28 = r6
            java.lang.Object r6 = ms.bd.o.Pgl.pblk.a(r23, r24, r25, r27, r28)     // Catch:{ all -> 0x03df }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x03df }
            java.lang.String[] r7 = new java.lang.String[r13]     // Catch:{ all -> 0x03df }
            r11 = r32
            r5.<init>(r6, r11, r7)     // Catch:{ all -> 0x03df }
            com.bytedance.retrofit2.Call r2 = r2.a(r0, r15, r5)     // Catch:{ all -> 0x03df }
            goto L_0x037f
        L_0x037b:
            com.bytedance.retrofit2.Call r2 = r2.a(r0, r15)     // Catch:{ all -> 0x03df }
        L_0x037f:
            r6 = r2
            r4.a(r0)     // Catch:{ all -> 0x03da }
            com.bytedance.retrofit2.SsResponse r0 = r6.execute()     // Catch:{ all -> 0x03da }
            int r14 = r0.code()     // Catch:{ all -> 0x03db }
            java.util.List r2 = r0.headers()     // Catch:{ all -> 0x03dc }
            java.lang.String r2 = r1.a(r2)     // Catch:{ all -> 0x03dc }
            r4.b(r2, r14)     // Catch:{ all -> 0x03dc }
            if (r3 == 0) goto L_0x039e
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x03dc }
            r2.<init>(r3)     // Catch:{ all -> 0x03dc }
            goto L_0x03a3
        L_0x039e:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x03dc }
            r2.<init>()     // Catch:{ all -> 0x03dc }
        L_0x03a3:
            java.lang.Object r3 = r0.body()     // Catch:{ all -> 0x03dd }
            com.bytedance.retrofit2.mime.TypedInput r3 = (com.bytedance.retrofit2.mime.TypedInput) r3     // Catch:{ all -> 0x03dd }
            java.io.InputStream r3 = r3.in()     // Catch:{ all -> 0x03dd }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x03e4 }
        L_0x03b1:
            r7 = 1024(0x400, float:1.435E-42)
            int r7 = r3.read(r5, r13, r7)     // Catch:{ all -> 0x03e4 }
            if (r7 <= 0) goto L_0x03bd
            r2.write(r5, r13, r7)     // Catch:{ all -> 0x03e4 }
            goto L_0x03b1
        L_0x03bd:
            r2.flush()     // Catch:{ all -> 0x03e4 }
            boolean r5 = r2 instanceof java.io.ByteArrayOutputStream     // Catch:{ all -> 0x03e4 }
            if (r5 == 0) goto L_0x03ce
            r5 = r2
            java.io.ByteArrayOutputStream r5 = (java.io.ByteArrayOutputStream) r5     // Catch:{ all -> 0x03e4 }
            byte[] r0 = r5.toByteArray()     // Catch:{ all -> 0x03e4 }
            r16 = r0
            goto L_0x03d0
        L_0x03ce:
            r16 = 0
        L_0x03d0:
            com.bytedance.frameworks.baselib.network.http.parser.StreamParser.safeClose(r3)
            com.bytedance.frameworks.baselib.network.http.parser.StreamParser.safeClose(r2)
            r6.cancel()
            goto L_0x0434
        L_0x03da:
            r0 = 0
        L_0x03db:
            r14 = -1
        L_0x03dc:
            r2 = 0
        L_0x03dd:
            r3 = 0
            goto L_0x03e4
        L_0x03df:
            r0 = 0
            r2 = 0
            r3 = 0
            r6 = 0
            r14 = -1
        L_0x03e4:
            r5 = 16777217(0x1000001, float:2.350989E-38)
            r7 = 0
            r20 = 0
            java.lang.String r11 = "84e687"
            r15 = 6
            byte[] r15 = new byte[r15]     // Catch:{ all -> 0x043f }
            r18 = 61
            r15[r13] = r18     // Catch:{ all -> 0x043f }
            r18 = 62
            r15[r9] = r18     // Catch:{ all -> 0x043f }
            r18 = 21
            r15[r10] = r18     // Catch:{ all -> 0x043f }
            r18 = 125(0x7d, float:1.75E-43)
            r15[r12] = r18     // Catch:{ all -> 0x043f }
            r12 = 15
            r15[r8] = r12     // Catch:{ all -> 0x043f }
            r8 = 49
            r12 = 5
            r15[r12] = r8     // Catch:{ all -> 0x043f }
            r31 = r5
            r32 = r7
            r33 = r20
            r35 = r11
            r36 = r15
            java.lang.Object r5 = ms.bd.o.Pgl.pblk.a(r31, r32, r33, r35, r36)     // Catch:{ all -> 0x043f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x043f }
            if (r0 == 0) goto L_0x0423
            java.util.List r0 = r0.headers()     // Catch:{ all -> 0x043f }
            java.lang.String r0 = r1.a(r0)     // Catch:{ all -> 0x043f }
            goto L_0x0424
        L_0x0423:
            r0 = 0
        L_0x0424:
            r4.a(r0, r14)     // Catch:{ all -> 0x043f }
            com.bytedance.frameworks.baselib.network.http.parser.StreamParser.safeClose(r3)
            com.bytedance.frameworks.baselib.network.http.parser.StreamParser.safeClose(r2)
            if (r6 == 0) goto L_0x0432
            r6.cancel()
        L_0x0432:
            r16 = 0
        L_0x0434:
            java.lang.Object[] r0 = new java.lang.Object[r10]
            java.lang.String r2 = java.lang.String.valueOf(r14)
            r0[r13] = r2
            r0[r9] = r16
            return r0
        L_0x043f:
            r0 = move-exception
            com.bytedance.frameworks.baselib.network.http.parser.StreamParser.safeClose(r3)
            com.bytedance.frameworks.baselib.network.http.parser.StreamParser.safeClose(r2)
            if (r6 == 0) goto L_0x044b
            r6.cancel()
        L_0x044b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bd.o.Pgl.pbla.a(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.Object[]");
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
