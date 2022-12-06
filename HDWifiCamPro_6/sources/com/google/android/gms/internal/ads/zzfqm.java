package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfqm extends zzfre {
    private final int zza;
    private final String zzb;

    /* synthetic */ zzfqm(int i, String str, zzfql zzfql) {
        this.zza = i;
        this.zzb = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = r4.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.gms.internal.ads.zzfre
            r2 = 0
            if (r1 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzfre r5 = (com.google.android.gms.internal.ads.zzfre) r5
            int r1 = r4.zza
            int r3 = r5.zza()
            if (r1 != r3) goto L_0x002a
            java.lang.String r1 = r4.zzb
            if (r1 != 0) goto L_0x001e
            java.lang.String r5 = r5.zzb()
            if (r5 != 0) goto L_0x002a
            goto L_0x0029
        L_0x001e:
            java.lang.String r5 = r5.zzb()
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            return r0
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfqm.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = (this.zza ^ 1000003) * 1000003;
        String str = this.zzb;
        return i ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        int i = this.zza;
        String str = this.zzb;
        return "OverlayDisplayState{statusCode=" + i + ", sessionToken=" + str + "}";
    }

    public final int zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
