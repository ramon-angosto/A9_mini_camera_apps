package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbdl extends zzasa implements zzbdm {
    public zzbdl() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzbdm zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        return queryLocalInterface instanceof zzbdm ? (zzbdm) queryLocalInterface : new zzbdk(iBinder);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbI(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 1
            if (r3 == r6) goto L_0x0021
            r0 = 2
            if (r3 == r0) goto L_0x001a
            r0 = 3
            if (r3 == r0) goto L_0x000b
            r3 = 0
            return r3
        L_0x000b:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zze> r3 = com.google.android.gms.ads.internal.client.zze.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzasb.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zze r3 = (com.google.android.gms.ads.internal.client.zze) r3
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzc(r3)
            goto L_0x0043
        L_0x001a:
            r4.readInt()
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            goto L_0x0043
        L_0x0021:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0029
            r3 = 0
            goto L_0x003d
        L_0x0029:
            java.lang.String r0 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzbdj
            if (r1 == 0) goto L_0x0037
            r3 = r0
            com.google.android.gms.internal.ads.zzbdj r3 = (com.google.android.gms.internal.ads.zzbdj) r3
            goto L_0x003d
        L_0x0037:
            com.google.android.gms.internal.ads.zzbdh r0 = new com.google.android.gms.internal.ads.zzbdh
            r0.<init>(r3)
            r3 = r0
        L_0x003d:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzd(r3)
        L_0x0043:
            r5.writeNoException()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdl.zzbI(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
