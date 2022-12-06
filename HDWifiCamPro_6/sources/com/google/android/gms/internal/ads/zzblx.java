package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzblx extends NativeAd.AdChoicesInfo {
    private final zzblw zza;
    private final List zzb = new ArrayList();
    private String zzc;

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzblx(com.google.android.gms.internal.ads.zzblw r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r4.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r4.zzb = r1
            r4.zza = r5
            com.google.android.gms.internal.ads.zzblw r1 = r4.zza     // Catch:{ RemoteException -> 0x0017 }
            java.lang.String r1 = r1.zzg()     // Catch:{ RemoteException -> 0x0017 }
            r4.zzc = r1     // Catch:{ RemoteException -> 0x0017 }
            goto L_0x001d
        L_0x0017:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r1)
            r4.zzc = r0
        L_0x001d:
            java.util.List r5 = r5.zzh()     // Catch:{ RemoteException -> 0x005a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ RemoteException -> 0x005a }
        L_0x0025:
            boolean r1 = r5.hasNext()     // Catch:{ RemoteException -> 0x005a }
            if (r1 == 0) goto L_0x0059
            java.lang.Object r1 = r5.next()     // Catch:{ RemoteException -> 0x005a }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005a }
            r3 = 0
            if (r2 == 0) goto L_0x004c
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x005a }
            if (r1 != 0) goto L_0x0039
            goto L_0x004c
        L_0x0039:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x005a }
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbme     // Catch:{ RemoteException -> 0x005a }
            if (r3 == 0) goto L_0x0047
            r3 = r2
            com.google.android.gms.internal.ads.zzbme r3 = (com.google.android.gms.internal.ads.zzbme) r3     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004c
        L_0x0047:
            com.google.android.gms.internal.ads.zzbmc r3 = new com.google.android.gms.internal.ads.zzbmc     // Catch:{ RemoteException -> 0x005a }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x005a }
        L_0x004c:
            if (r3 == 0) goto L_0x0025
            java.util.List r1 = r4.zzb     // Catch:{ RemoteException -> 0x005a }
            com.google.android.gms.internal.ads.zzbmf r2 = new com.google.android.gms.internal.ads.zzbmf     // Catch:{ RemoteException -> 0x005a }
            r2.<init>(r3)     // Catch:{ RemoteException -> 0x005a }
            r1.add(r2)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x0025
        L_0x0059:
            return
        L_0x005a:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzcgp.zzh(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblx.<init>(com.google.android.gms.internal.ads.zzblw):void");
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final CharSequence getText() {
        return this.zzc;
    }
}
