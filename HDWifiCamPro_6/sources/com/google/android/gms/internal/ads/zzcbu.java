package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzcbu extends zzasa implements zzcbv {
    public zzcbu() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.google.android.gms.internal.ads.zzcbt} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzcby] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbI(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 1
            if (r3 == r6) goto L_0x0149
            r0 = 2
            if (r3 == r0) goto L_0x0142
            r0 = 3
            r1 = 0
            if (r3 == r0) goto L_0x011e
            r0 = 34
            if (r3 == r0) goto L_0x0110
            switch(r3) {
                case 5: goto L_0x0105;
                case 6: goto L_0x00fe;
                case 7: goto L_0x00f7;
                case 8: goto L_0x00f0;
                case 9: goto L_0x00dd;
                case 10: goto L_0x00ca;
                case 11: goto L_0x00b7;
                case 12: goto L_0x00ab;
                case 13: goto L_0x009c;
                case 14: goto L_0x0089;
                case 15: goto L_0x007d;
                case 16: goto L_0x0058;
                case 17: goto L_0x004d;
                case 18: goto L_0x003a;
                case 19: goto L_0x002b;
                case 20: goto L_0x001f;
                case 21: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            r3 = 0
            return r3
        L_0x0013:
            com.google.android.gms.ads.internal.client.zzdh r3 = r2.zzc()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r5, r3)
            goto L_0x015a
        L_0x001f:
            boolean r3 = r2.zzt()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r5, r3)
            goto L_0x015a
        L_0x002b:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzm(r3)
            r5.writeNoException()
            goto L_0x015a
        L_0x003a:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzr(r3)
            r5.writeNoException()
            goto L_0x015a
        L_0x004d:
            r4.readString()
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r5.writeNoException()
            goto L_0x015a
        L_0x0058:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x005f
            goto L_0x0072
        L_0x005f:
            java.lang.String r0 = "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzcbt
            if (r1 == 0) goto L_0x006d
            r1 = r0
            com.google.android.gms.internal.ads.zzcbt r1 = (com.google.android.gms.internal.ads.zzcbt) r1
            goto L_0x0072
        L_0x006d:
            com.google.android.gms.internal.ads.zzcbt r1 = new com.google.android.gms.internal.ads.zzcbt
            r1.<init>(r3)
        L_0x0072:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzu(r1)
            r5.writeNoException()
            goto L_0x015a
        L_0x007d:
            android.os.Bundle r3 = r2.zzb()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzf(r5, r3)
            goto L_0x015a
        L_0x0089:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzbw r3 = com.google.android.gms.ads.internal.client.zzbv.zzb(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzl(r3)
            r5.writeNoException()
            goto L_0x015a
        L_0x009c:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzp(r3)
            r5.writeNoException()
            goto L_0x015a
        L_0x00ab:
            java.lang.String r3 = r2.zzd()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x015a
        L_0x00b7:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzf(r3)
            r5.writeNoException()
            goto L_0x015a
        L_0x00ca:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzk(r3)
            r5.writeNoException()
            goto L_0x015a
        L_0x00dd:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzi(r3)
            r5.writeNoException()
            goto L_0x015a
        L_0x00f0:
            r2.zze()
            r5.writeNoException()
            goto L_0x015a
        L_0x00f7:
            r2.zzj()
            r5.writeNoException()
            goto L_0x015a
        L_0x00fe:
            r2.zzh()
            r5.writeNoException()
            goto L_0x015a
        L_0x0105:
            boolean r3 = r2.zzs()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r5, r3)
            goto L_0x015a
        L_0x0110:
            boolean r3 = com.google.android.gms.internal.ads.zzasb.zzh(r4)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzn(r3)
            r5.writeNoException()
            goto L_0x015a
        L_0x011e:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0125
            goto L_0x0138
        L_0x0125:
            java.lang.String r0 = "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzcby
            if (r1 == 0) goto L_0x0133
            r1 = r0
            com.google.android.gms.internal.ads.zzcby r1 = (com.google.android.gms.internal.ads.zzcby) r1
            goto L_0x0138
        L_0x0133:
            com.google.android.gms.internal.ads.zzcbw r1 = new com.google.android.gms.internal.ads.zzcbw
            r1.<init>(r3)
        L_0x0138:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzo(r1)
            r5.writeNoException()
            goto L_0x015a
        L_0x0142:
            r2.zzq()
            r5.writeNoException()
            goto L_0x015a
        L_0x0149:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzcbz> r3 = com.google.android.gms.internal.ads.zzcbz.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzasb.zza(r4, r3)
            com.google.android.gms.internal.ads.zzcbz r3 = (com.google.android.gms.internal.ads.zzcbz) r3
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzg(r3)
            r5.writeNoException()
        L_0x015a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbu.zzbI(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
