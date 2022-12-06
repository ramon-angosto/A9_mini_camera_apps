package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfoz {
    final zzfpc zza;
    final boolean zzb;

    private zzfoz(zzfpc zzfpc) {
        this.zza = zzfpc;
        this.zzb = zzfpc != null;
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfoz zzb(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r6 = "GASS"
            java.lang.String r0 = "com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger"
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r1 = com.google.android.gms.dynamite.DynamiteModule.PREFER_REMOTE     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = "com.google.android.gms.ads.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r1 = com.google.android.gms.dynamite.DynamiteModule.load(r4, r1, r2)     // Catch:{ Exception -> 0x003b }
            android.os.IBinder r0 = r1.instantiate(r0)     // Catch:{ Exception -> 0x0042 }
            r1 = 0
            if (r0 != 0) goto L_0x0015
            r0 = r1
            goto L_0x0029
        L_0x0015:
            java.lang.String r2 = "com.google.android.gms.gass.internal.clearcut.IGassClearcut"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)     // Catch:{ Exception -> 0x0042 }
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzfpc     // Catch:{ Exception -> 0x0042 }
            if (r3 == 0) goto L_0x0023
            r0 = r2
            com.google.android.gms.internal.ads.zzfpc r0 = (com.google.android.gms.internal.ads.zzfpc) r0     // Catch:{ Exception -> 0x0042 }
            goto L_0x0029
        L_0x0023:
            com.google.android.gms.internal.ads.zzfpa r2 = new com.google.android.gms.internal.ads.zzfpa     // Catch:{ Exception -> 0x0042 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0042 }
            r0 = r2
        L_0x0029:
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch:{ RemoteException | zzfob | NullPointerException | SecurityException -> 0x0049 }
            r0.zze(r4, r5, r1)     // Catch:{ RemoteException | zzfob | NullPointerException | SecurityException -> 0x0049 }
            java.lang.String r4 = "GassClearcutLogger Initialized."
            android.util.Log.i(r6, r4)     // Catch:{ RemoteException | zzfob | NullPointerException | SecurityException -> 0x0049 }
            com.google.android.gms.internal.ads.zzfoz r4 = new com.google.android.gms.internal.ads.zzfoz     // Catch:{ RemoteException | zzfob | NullPointerException | SecurityException -> 0x0049 }
            r4.<init>(r0)     // Catch:{ RemoteException | zzfob | NullPointerException | SecurityException -> 0x0049 }
            return r4
        L_0x003b:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzfob r5 = new com.google.android.gms.internal.ads.zzfob     // Catch:{ Exception -> 0x0042 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0042 }
            throw r5     // Catch:{ Exception -> 0x0042 }
        L_0x0042:
            r4 = move-exception
            com.google.android.gms.internal.ads.zzfob r5 = new com.google.android.gms.internal.ads.zzfob     // Catch:{ RemoteException | zzfob | NullPointerException | SecurityException -> 0x0049 }
            r5.<init>(r4)     // Catch:{ RemoteException | zzfob | NullPointerException | SecurityException -> 0x0049 }
            throw r5     // Catch:{ RemoteException | zzfob | NullPointerException | SecurityException -> 0x0049 }
        L_0x0049:
            java.lang.String r4 = "Cannot dynamite load clearcut"
            android.util.Log.d(r6, r4)
            com.google.android.gms.internal.ads.zzfpd r4 = new com.google.android.gms.internal.ads.zzfpd
            r4.<init>()
            com.google.android.gms.internal.ads.zzfoz r5 = new com.google.android.gms.internal.ads.zzfoz
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfoz.zzb(android.content.Context, java.lang.String, java.lang.String):com.google.android.gms.internal.ads.zzfoz");
    }

    public static zzfoz zzc() {
        zzfpd zzfpd = new zzfpd();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfoz(zzfpd);
    }

    public final zzfoy zza(byte[] bArr) {
        return new zzfoy(this, bArr, (zzfox) null);
    }
}
