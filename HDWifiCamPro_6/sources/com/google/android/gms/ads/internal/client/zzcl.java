package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzasa;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzcl extends zzasa implements zzcm {
    public zzcl() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbI(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            switch(r2) {
                case 1: goto L_0x0100;
                case 2: goto L_0x00f2;
                case 3: goto L_0x00e4;
                case 4: goto L_0x00d6;
                case 5: goto L_0x00c0;
                case 6: goto L_0x00aa;
                case 7: goto L_0x009f;
                case 8: goto L_0x0094;
                case 9: goto L_0x0088;
                case 10: goto L_0x0079;
                case 11: goto L_0x0066;
                case 12: goto L_0x0053;
                case 13: goto L_0x0047;
                case 14: goto L_0x0034;
                case 15: goto L_0x002c;
                case 16: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x000d
            r2 = 0
            goto L_0x0021
        L_0x000d:
            java.lang.String r5 = "com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.ads.internal.client.zzcy
            if (r0 == 0) goto L_0x001b
            r2 = r5
            com.google.android.gms.ads.internal.client.zzcy r2 = (com.google.android.gms.ads.internal.client.zzcy) r2
            goto L_0x0021
        L_0x001b:
            com.google.android.gms.ads.internal.client.zzcw r5 = new com.google.android.gms.ads.internal.client.zzcw
            r5.<init>(r2)
            r2 = r5
        L_0x0021:
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzl(r2)
            r4.writeNoException()
            goto L_0x0106
        L_0x002c:
            r1.zzi()
            r4.writeNoException()
            goto L_0x0106
        L_0x0034:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzez> r2 = com.google.android.gms.ads.internal.client.zzez.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzasb.zza(r3, r2)
            com.google.android.gms.ads.internal.client.zzez r2 = (com.google.android.gms.ads.internal.client.zzez) r2
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzs(r2)
            r4.writeNoException()
            goto L_0x0106
        L_0x0047:
            java.util.List r2 = r1.zzg()
            r4.writeNoException()
            r4.writeTypedList(r2)
            goto L_0x0106
        L_0x0053:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbrx r2 = com.google.android.gms.internal.ads.zzbrw.zzc(r2)
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzr(r2)
            r4.writeNoException()
            goto L_0x0106
        L_0x0066:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzbvk r2 = com.google.android.gms.internal.ads.zzbvj.zzf(r2)
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzn(r2)
            r4.writeNoException()
            goto L_0x0106
        L_0x0079:
            java.lang.String r2 = r3.readString()
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzh(r2)
            r4.writeNoException()
            goto L_0x0106
        L_0x0088:
            java.lang.String r2 = r1.zzf()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x0106
        L_0x0094:
            boolean r2 = r1.zzt()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r4, r2)
            goto L_0x0106
        L_0x009f:
            float r2 = r1.zze()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x0106
        L_0x00aa:
            java.lang.String r2 = r3.readString()
            android.os.IBinder r5 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzk(r2, r5)
            r4.writeNoException()
            goto L_0x0106
        L_0x00c0:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            java.lang.String r5 = r3.readString()
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzm(r2, r5)
            r4.writeNoException()
            goto L_0x0106
        L_0x00d6:
            boolean r2 = com.google.android.gms.internal.ads.zzasb.zzh(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzo(r2)
            r4.writeNoException()
            goto L_0x0106
        L_0x00e4:
            java.lang.String r2 = r3.readString()
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzq(r2)
            r4.writeNoException()
            goto L_0x0106
        L_0x00f2:
            float r2 = r3.readFloat()
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzp(r2)
            r4.writeNoException()
            goto L_0x0106
        L_0x0100:
            r1.zzj()
            r4.writeNoException()
        L_0x0106:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzcl.zzbI(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
