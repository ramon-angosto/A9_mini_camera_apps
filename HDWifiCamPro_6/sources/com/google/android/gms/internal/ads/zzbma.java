package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbma extends zzasa implements zzbmb {
    public zzbma() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
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
                case 2: goto L_0x0074;
                case 3: goto L_0x0062;
                case 4: goto L_0x0057;
                case 5: goto L_0x004c;
                case 6: goto L_0x0041;
                case 7: goto L_0x0036;
                case 8: goto L_0x002b;
                case 9: goto L_0x0005;
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
            java.lang.String r5 = "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbnm
            if (r0 == 0) goto L_0x001b
            r2 = r5
            com.google.android.gms.internal.ads.zzbnm r2 = (com.google.android.gms.internal.ads.zzbnm) r2
            goto L_0x0021
        L_0x001b:
            com.google.android.gms.internal.ads.zzbnm r5 = new com.google.android.gms.internal.ads.zzbnm
            r5.<init>(r2)
            r2 = r5
        L_0x0021:
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzl(r2)
            r4.writeNoException()
            goto L_0x007e
        L_0x002b:
            boolean r2 = r1.zzk()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r4, r2)
            goto L_0x007e
        L_0x0036:
            com.google.android.gms.ads.internal.client.zzdk r2 = r1.zzh()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x007e
        L_0x0041:
            float r2 = r1.zzf()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x007e
        L_0x004c:
            float r2 = r1.zzg()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x007e
        L_0x0057:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzi()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x007e
        L_0x0062:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzj(r2)
            r4.writeNoException()
            goto L_0x007e
        L_0x0074:
            float r2 = r1.zze()
            r4.writeNoException()
            r4.writeFloat(r2)
        L_0x007e:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbma.zzbI(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
