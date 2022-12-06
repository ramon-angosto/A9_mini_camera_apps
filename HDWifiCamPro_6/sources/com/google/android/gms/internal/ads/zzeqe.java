package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeqe implements zzeve {
    private final zzfzq zza;
    private final zzdvl zzb;
    private final zzdzs zzc;
    private final zzeqh zzd;

    public zzeqe(zzfzq zzfzq, zzdvl zzdvl, zzdzs zzdzs, zzeqh zzeqh) {
        this.zza = zzfzq;
        this.zzb = zzdvl;
        this.zzc = zzdzs;
        this.zzd = zzeqh;
    }

    public final int zza() {
        return 1;
    }

    public final zzfzp zzb() {
        if (zzftm.zzd((String) zzay.zzc().zzb(zzbjc.zzbk)) || this.zzd.zzb() || !this.zzc.zzt()) {
            return zzfzg.zzi(new zzeqg(new Bundle(), (zzeqf) null));
        }
        this.zzd.zza(true);
        return this.zza.zzb(new zzeqd(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:4|5|6|7|8|(1:10)|11|12|(1:14)|15|16|21|19|1) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x005c */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053 A[Catch:{ zzfek -> 0x005c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeqg zzc() throws java.lang.Exception {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbk
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)
            java.util.List r0 = java.util.Arrays.asList(r0)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0060
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.ads.zzdvl r3 = r7.zzb     // Catch:{ zzfek -> 0x001f }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ zzfek -> 0x001f }
            r4.<init>()     // Catch:{ zzfek -> 0x001f }
            com.google.android.gms.internal.ads.zzffa r3 = r3.zzc(r2, r4)     // Catch:{ zzfek -> 0x001f }
            r3.zzA()     // Catch:{ zzfek -> 0x001f }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ zzfek -> 0x001f }
            r4.<init>()     // Catch:{ zzfek -> 0x001f }
            com.google.android.gms.internal.ads.zzbxq r5 = r3.zzf()     // Catch:{ zzfek -> 0x004d }
            if (r5 == 0) goto L_0x004d
            java.lang.String r6 = "sdk_version"
            java.lang.String r5 = r5.toString()     // Catch:{ zzfek -> 0x004d }
            r4.putString(r6, r5)     // Catch:{ zzfek -> 0x004d }
        L_0x004d:
            com.google.android.gms.internal.ads.zzbxq r3 = r3.zze()     // Catch:{ zzfek -> 0x005c }
            if (r3 == 0) goto L_0x005c
            java.lang.String r5 = "adapter_version"
            java.lang.String r3 = r3.toString()     // Catch:{ zzfek -> 0x005c }
            r4.putString(r5, r3)     // Catch:{ zzfek -> 0x005c }
        L_0x005c:
            r1.putBundle(r2, r4)     // Catch:{ zzfek -> 0x001f }
            goto L_0x001f
        L_0x0060:
            com.google.android.gms.internal.ads.zzeqg r0 = new com.google.android.gms.internal.ads.zzeqg
            r2 = 0
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeqe.zzc():com.google.android.gms.internal.ads.zzeqg");
    }
}
