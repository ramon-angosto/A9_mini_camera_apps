package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfxb extends zzfvq {
    static final zzfvq zza = new zzfxb((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzfxb(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r5v5 ?, r5v11 ?, r5v8 ?, r5v12 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static com.google.android.gms.internal.ads.zzfxb zzi(int r17, java.lang.Object[] r18, com.google.android.gms.internal.ads.zzfvp r19) {
        /*
            r0 = r17
            r1 = r18
            if (r0 != 0) goto L_0x000b
            com.google.android.gms.internal.ads.zzfvq r0 = zza
            com.google.android.gms.internal.ads.zzfxb r0 = (com.google.android.gms.internal.ads.zzfxb) r0
            return r0
        L_0x000b:
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 != r4) goto L_0x0023
            r0 = r1[r3]
            r0.getClass()
            r3 = r1[r4]
            r3.getClass()
            com.google.android.gms.internal.ads.zzfum.zzb(r0, r3)
            com.google.android.gms.internal.ads.zzfxb r0 = new com.google.android.gms.internal.ads.zzfxb
            r0.<init>(r2, r1, r4)
            return r0
        L_0x0023:
            int r5 = r1.length
            int r5 = r5 >> r4
            java.lang.String r6 = "index"
            com.google.android.gms.internal.ads.zzfsx.zzb(r0, r5, r6)
            int r5 = com.google.android.gms.internal.ads.zzfvs.zzh(r17)
            if (r0 != r4) goto L_0x0040
            r5 = r1[r3]
            r5.getClass()
            r7 = r1[r4]
            r7.getClass()
            com.google.android.gms.internal.ads.zzfum.zzb(r5, r7)
        L_0x003d:
            r5 = 2
            goto L_0x0185
        L_0x0040:
            int r7 = r5 + -1
            r8 = 128(0x80, float:1.794E-43)
            r9 = 3
            r10 = -1
            if (r5 > r8) goto L_0x00b1
            byte[] r5 = new byte[r5]
            java.util.Arrays.fill(r5, r10)
            r10 = r2
            r2 = r3
            r8 = r2
        L_0x0050:
            if (r2 >= r0) goto L_0x009e
            int r11 = r2 + r2
            int r12 = r8 + r8
            r13 = r1[r11]
            r13.getClass()
            r11 = r11 ^ r4
            r11 = r1[r11]
            r11.getClass()
            com.google.android.gms.internal.ads.zzfum.zzb(r13, r11)
            int r14 = r13.hashCode()
            int r14 = com.google.android.gms.internal.ads.zzfvf.zza(r14)
        L_0x006c:
            r14 = r14 & r7
            byte r15 = r5[r14]
            r6 = 255(0xff, float:3.57E-43)
            r15 = r15 & r6
            if (r15 != r6) goto L_0x0082
            byte r6 = (byte) r12
            r5[r14] = r6
            if (r8 >= r2) goto L_0x007f
            r1[r12] = r13
            r6 = r12 ^ 1
            r1[r6] = r11
        L_0x007f:
            int r8 = r8 + 1
            goto L_0x0098
        L_0x0082:
            r6 = r1[r15]
            boolean r6 = r13.equals(r6)
            if (r6 == 0) goto L_0x009b
            r6 = r15 ^ 1
            com.google.android.gms.internal.ads.zzfvo r10 = new com.google.android.gms.internal.ads.zzfvo
            r12 = r1[r6]
            r12.getClass()
            r10.<init>(r13, r11, r12)
            r1[r6] = r11
        L_0x0098:
            int r2 = r2 + 1
            goto L_0x0050
        L_0x009b:
            int r14 = r14 + 1
            goto L_0x006c
        L_0x009e:
            if (r8 != r0) goto L_0x00a2
        L_0x00a0:
            r2 = r5
            goto L_0x003d
        L_0x00a2:
            java.lang.Object[] r2 = new java.lang.Object[r9]
            r2[r3] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r2[r4] = r5
            r5 = 2
            r2[r5] = r10
            goto L_0x0185
        L_0x00b1:
            r6 = 32768(0x8000, float:4.5918E-41)
            if (r5 > r6) goto L_0x011f
            short[] r5 = new short[r5]
            java.util.Arrays.fill(r5, r10)
            r8 = r2
            r2 = r3
            r6 = r2
        L_0x00be:
            if (r2 >= r0) goto L_0x010e
            int r10 = r2 + r2
            int r11 = r6 + r6
            r12 = r1[r10]
            r12.getClass()
            r10 = r10 ^ r4
            r10 = r1[r10]
            r10.getClass()
            com.google.android.gms.internal.ads.zzfum.zzb(r12, r10)
            int r13 = r12.hashCode()
            int r13 = com.google.android.gms.internal.ads.zzfvf.zza(r13)
        L_0x00da:
            r13 = r13 & r7
            short r14 = r5[r13]
            char r14 = (char) r14
            r15 = 65535(0xffff, float:9.1834E-41)
            if (r14 != r15) goto L_0x00f1
            short r14 = (short) r11
            r5[r13] = r14
            if (r6 >= r2) goto L_0x00ee
            r1[r11] = r12
            r11 = r11 ^ 1
            r1[r11] = r10
        L_0x00ee:
            int r6 = r6 + 1
            goto L_0x0108
        L_0x00f1:
            r15 = r1[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x010b
            r8 = r14 ^ 1
            com.google.android.gms.internal.ads.zzfvo r11 = new com.google.android.gms.internal.ads.zzfvo
            r13 = r1[r8]
            r13.getClass()
            r11.<init>(r12, r10, r13)
            r1[r8] = r10
            r8 = r11
        L_0x0108:
            int r2 = r2 + 1
            goto L_0x00be
        L_0x010b:
            int r13 = r13 + 1
            goto L_0x00da
        L_0x010e:
            if (r6 != r0) goto L_0x0111
            goto L_0x00a0
        L_0x0111:
            java.lang.Object[] r2 = new java.lang.Object[r9]
            r2[r3] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r2[r4] = r5
            r5 = 2
            r2[r5] = r8
            goto L_0x0185
        L_0x011f:
            int[] r5 = new int[r5]
            java.util.Arrays.fill(r5, r10)
            r8 = r2
            r2 = r3
            r6 = r2
        L_0x0127:
            if (r2 >= r0) goto L_0x0174
            int r11 = r2 + r2
            int r12 = r6 + r6
            r13 = r1[r11]
            r13.getClass()
            r11 = r11 ^ r4
            r11 = r1[r11]
            r11.getClass()
            com.google.android.gms.internal.ads.zzfum.zzb(r13, r11)
            int r14 = r13.hashCode()
            int r14 = com.google.android.gms.internal.ads.zzfvf.zza(r14)
        L_0x0143:
            r14 = r14 & r7
            r15 = r5[r14]
            if (r15 != r10) goto L_0x0155
            r5[r14] = r12
            if (r6 >= r2) goto L_0x0152
            r1[r12] = r13
            r12 = r12 ^ 1
            r1[r12] = r11
        L_0x0152:
            int r6 = r6 + 1
            goto L_0x016c
        L_0x0155:
            r10 = r1[r15]
            boolean r10 = r13.equals(r10)
            if (r10 == 0) goto L_0x0170
            r8 = r15 ^ 1
            com.google.android.gms.internal.ads.zzfvo r10 = new com.google.android.gms.internal.ads.zzfvo
            r12 = r1[r8]
            r12.getClass()
            r10.<init>(r13, r11, r12)
            r1[r8] = r11
            r8 = r10
        L_0x016c:
            int r2 = r2 + 1
            r10 = -1
            goto L_0x0127
        L_0x0170:
            int r14 = r14 + 1
            r10 = -1
            goto L_0x0143
        L_0x0174:
            if (r6 != r0) goto L_0x0178
            goto L_0x00a0
        L_0x0178:
            java.lang.Object[] r2 = new java.lang.Object[r9]
            r2[r3] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r2[r4] = r5
            r5 = 2
            r2[r5] = r8
        L_0x0185:
            boolean r6 = r2 instanceof java.lang.Object[]
            if (r6 == 0) goto L_0x01a4
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r0 = r2[r5]
            com.google.android.gms.internal.ads.zzfvo r0 = (com.google.android.gms.internal.ads.zzfvo) r0
            r5 = r19
            r5.zzc = r0
            r0 = r2[r3]
            r2 = r2[r4]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r2 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            goto L_0x01a9
        L_0x01a4:
            r16 = r2
            r2 = r0
            r0 = r16
        L_0x01a9:
            com.google.android.gms.internal.ads.zzfxb r3 = new com.google.android.gms.internal.ads.zzfxb
            r3.<init>(r0, r1, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfxb.zzi(int, java.lang.Object[], com.google.android.gms.internal.ads.zzfvp):com.google.android.gms.internal.ads.zzfxb");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[RETURN] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzc
            java.lang.Object[] r1 = r9.zzb
            int r2 = r9.zzd
            r3 = 0
            if (r10 != 0) goto L_0x000c
        L_0x0009:
            r10 = r3
            goto L_0x009c
        L_0x000c:
            r4 = 1
            if (r2 != r4) goto L_0x0022
            r0 = 0
            r0 = r1[r0]
            r0.getClass()
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0009
            r10 = r1[r4]
            r10.getClass()
            goto L_0x009c
        L_0x0022:
            if (r0 != 0) goto L_0x0025
            goto L_0x0009
        L_0x0025:
            boolean r2 = r0 instanceof byte[]
            r5 = -1
            if (r2 == 0) goto L_0x0051
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.ads.zzfvf.zza(r0)
        L_0x0038:
            r0 = r0 & r6
            byte r5 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L_0x0041
            goto L_0x0009
        L_0x0041:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x004e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x004e:
            int r0 = r0 + 1
            goto L_0x0038
        L_0x0051:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L_0x007d
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.ads.zzfvf.zza(r0)
        L_0x0063:
            r0 = r0 & r6
            short r5 = r2[r0]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L_0x006d
            goto L_0x0009
        L_0x006d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x007a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x007a:
            int r0 = r0 + 1
            goto L_0x0063
        L_0x007d:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzfvf.zza(r6)
        L_0x0089:
            r6 = r6 & r2
            r7 = r0[r6]
            if (r7 != r5) goto L_0x0090
            goto L_0x0009
        L_0x0090:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x00a0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L_0x009c:
            if (r10 != 0) goto L_0x009f
            return r3
        L_0x009f:
            return r10
        L_0x00a0:
            int r6 = r6 + 1
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfxb.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzfvi zza() {
        return new zzfxa(this.zzb, 1, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzfvs zze() {
        return new zzfwy(this, this.zzb, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzfvs zzf() {
        return new zzfwz(this, new zzfxa(this.zzb, 0, this.zzd));
    }
}
