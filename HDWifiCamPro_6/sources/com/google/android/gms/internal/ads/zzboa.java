package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzboa extends zzasa implements zzbob {
    public zzboa() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
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
                case 2: goto L_0x019d;
                case 3: goto L_0x0192;
                case 4: goto L_0x0187;
                case 5: goto L_0x017c;
                case 6: goto L_0x0171;
                case 7: goto L_0x0166;
                case 8: goto L_0x015b;
                case 9: goto L_0x0150;
                case 10: goto L_0x0145;
                case 11: goto L_0x013a;
                case 12: goto L_0x012e;
                case 13: goto L_0x0126;
                case 14: goto L_0x011a;
                case 15: goto L_0x0107;
                case 16: goto L_0x00f0;
                case 17: goto L_0x00dd;
                case 18: goto L_0x00d1;
                case 19: goto L_0x00c5;
                case 20: goto L_0x00b9;
                case 21: goto L_0x0092;
                case 22: goto L_0x008a;
                case 23: goto L_0x007e;
                case 24: goto L_0x0072;
                case 25: goto L_0x005f;
                case 26: goto L_0x004c;
                case 27: goto L_0x0044;
                case 28: goto L_0x003c;
                case 29: goto L_0x0030;
                case 30: goto L_0x0024;
                case 31: goto L_0x0018;
                case 32: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzde r2 = com.google.android.gms.ads.internal.client.zzdd.zzb(r2)
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzE(r2)
            r4.writeNoException()
            goto L_0x01a7
        L_0x0018:
            com.google.android.gms.ads.internal.client.zzdh r2 = r1.zzg()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x01a7
        L_0x0024:
            boolean r2 = r1.zzG()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r4, r2)
            goto L_0x01a7
        L_0x0030:
            com.google.android.gms.internal.ads.zzbmb r2 = r1.zzj()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x01a7
        L_0x003c:
            r1.zzA()
            r4.writeNoException()
            goto L_0x01a7
        L_0x0044:
            r1.zzC()
            r4.writeNoException()
            goto L_0x01a7
        L_0x004c:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzcq r2 = com.google.android.gms.ads.internal.client.zzcp.zzb(r2)
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzD(r2)
            r4.writeNoException()
            goto L_0x01a7
        L_0x005f:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzcu r2 = com.google.android.gms.ads.internal.client.zzct.zzb(r2)
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzy(r2)
            r4.writeNoException()
            goto L_0x01a7
        L_0x0072:
            boolean r2 = r1.zzH()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r4, r2)
            goto L_0x01a7
        L_0x007e:
            java.util.List r2 = r1.zzv()
            r4.writeNoException()
            r4.writeList(r2)
            goto L_0x01a7
        L_0x008a:
            r1.zzw()
            r4.writeNoException()
            goto L_0x01a7
        L_0x0092:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x009a
            r2 = 0
            goto L_0x00ae
        L_0x009a:
            java.lang.String r5 = "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbny
            if (r0 == 0) goto L_0x00a8
            r2 = r5
            com.google.android.gms.internal.ads.zzbny r2 = (com.google.android.gms.internal.ads.zzbny) r2
            goto L_0x00ae
        L_0x00a8:
            com.google.android.gms.internal.ads.zzbnw r5 = new com.google.android.gms.internal.ads.zzbnw
            r5.<init>(r2)
            r2 = r5
        L_0x00ae:
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzF(r2)
            r4.writeNoException()
            goto L_0x01a7
        L_0x00b9:
            android.os.Bundle r2 = r1.zzf()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzf(r4, r2)
            goto L_0x01a7
        L_0x00c5:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzl()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x01a7
        L_0x00d1:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzm()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x01a7
        L_0x00dd:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzasb.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzB(r2)
            r4.writeNoException()
            goto L_0x01a7
        L_0x00f0:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzasb.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            boolean r2 = r1.zzI(r2)
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r4, r2)
            goto L_0x01a7
        L_0x0107:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzasb.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzz(r2)
            r4.writeNoException()
            goto L_0x01a7
        L_0x011a:
            com.google.android.gms.internal.ads.zzblw r2 = r1.zzi()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x01a7
        L_0x0126:
            r1.zzx()
            r4.writeNoException()
            goto L_0x01a7
        L_0x012e:
            java.lang.String r2 = r1.zzr()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01a7
        L_0x013a:
            com.google.android.gms.ads.internal.client.zzdk r2 = r1.zzh()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x01a7
        L_0x0145:
            java.lang.String r2 = r1.zzs()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01a7
        L_0x0150:
            java.lang.String r2 = r1.zzt()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01a7
        L_0x015b:
            double r2 = r1.zze()
            r4.writeNoException()
            r4.writeDouble(r2)
            goto L_0x01a7
        L_0x0166:
            java.lang.String r2 = r1.zzn()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01a7
        L_0x0171:
            java.lang.String r2 = r1.zzp()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01a7
        L_0x017c:
            com.google.android.gms.internal.ads.zzbme r2 = r1.zzk()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x01a7
        L_0x0187:
            java.lang.String r2 = r1.zzo()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x01a7
        L_0x0192:
            java.util.List r2 = r1.zzu()
            r4.writeNoException()
            r4.writeList(r2)
            goto L_0x01a7
        L_0x019d:
            java.lang.String r2 = r1.zzq()
            r4.writeNoException()
            r4.writeString(r2)
        L_0x01a7:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzboa.zzbI(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
