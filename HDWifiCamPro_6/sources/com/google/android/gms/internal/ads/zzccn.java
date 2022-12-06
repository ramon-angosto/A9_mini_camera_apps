package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzccn extends zzasa implements zzcco {
    public zzccn() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbI(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            switch(r2) {
                case 1: goto L_0x004e;
                case 2: goto L_0x004a;
                case 3: goto L_0x0027;
                case 4: goto L_0x001c;
                case 5: goto L_0x000d;
                case 6: goto L_0x0009;
                case 7: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            r1.zze()
            goto L_0x0051
        L_0x0009:
            r1.zzf()
            goto L_0x0051
        L_0x000d:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zze> r2 = com.google.android.gms.ads.internal.client.zze.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzasb.zza(r3, r2)
            com.google.android.gms.ads.internal.client.zze r2 = (com.google.android.gms.ads.internal.client.zze) r2
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzi(r2)
            goto L_0x0051
        L_0x001c:
            int r2 = r3.readInt()
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzh(r2)
            goto L_0x0051
        L_0x0027:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x002f
            r2 = 0
            goto L_0x0043
        L_0x002f:
            java.lang.String r5 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzcci
            if (r0 == 0) goto L_0x003d
            r2 = r5
            com.google.android.gms.internal.ads.zzcci r2 = (com.google.android.gms.internal.ads.zzcci) r2
            goto L_0x0043
        L_0x003d:
            com.google.android.gms.internal.ads.zzccg r5 = new com.google.android.gms.internal.ads.zzccg
            r5.<init>(r2)
            r2 = r5
        L_0x0043:
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzk(r2)
            goto L_0x0051
        L_0x004a:
            r1.zzg()
            goto L_0x0051
        L_0x004e:
            r1.zzj()
        L_0x0051:
            r4.writeNoException()
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccn.zzbI(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
