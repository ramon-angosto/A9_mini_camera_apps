package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzasa;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzdj extends zzasa implements zzdk {
    public zzdj() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzdk zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzdk ? (zzdk) queryLocalInterface : new zzdi(iBinder);
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
                case 1: goto L_0x00a4;
                case 2: goto L_0x009d;
                case 3: goto L_0x008f;
                case 4: goto L_0x0084;
                case 5: goto L_0x0079;
                case 6: goto L_0x006e;
                case 7: goto L_0x0063;
                case 8: goto L_0x003d;
                case 9: goto L_0x0031;
                case 10: goto L_0x0025;
                case 11: goto L_0x0019;
                case 12: goto L_0x000d;
                case 13: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            r1.zzn()
            r4.writeNoException()
            goto L_0x00aa
        L_0x000d:
            boolean r2 = r1.zzo()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r4, r2)
            goto L_0x00aa
        L_0x0019:
            com.google.android.gms.ads.internal.client.zzdn r2 = r1.zzi()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r4, r2)
            goto L_0x00aa
        L_0x0025:
            boolean r2 = r1.zzp()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r4, r2)
            goto L_0x00aa
        L_0x0031:
            float r2 = r1.zze()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x00aa
        L_0x003d:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0045
            r2 = 0
            goto L_0x0059
        L_0x0045:
            java.lang.String r5 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.ads.internal.client.zzdn
            if (r0 == 0) goto L_0x0053
            r2 = r5
            com.google.android.gms.ads.internal.client.zzdn r2 = (com.google.android.gms.ads.internal.client.zzdn) r2
            goto L_0x0059
        L_0x0053:
            com.google.android.gms.ads.internal.client.zzdl r5 = new com.google.android.gms.ads.internal.client.zzdl
            r5.<init>(r2)
            r2 = r5
        L_0x0059:
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzm(r2)
            r4.writeNoException()
            goto L_0x00aa
        L_0x0063:
            float r2 = r1.zzf()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x00aa
        L_0x006e:
            float r2 = r1.zzg()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x00aa
        L_0x0079:
            int r2 = r1.zzh()
            r4.writeNoException()
            r4.writeInt(r2)
            goto L_0x00aa
        L_0x0084:
            boolean r2 = r1.zzq()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r4, r2)
            goto L_0x00aa
        L_0x008f:
            boolean r2 = com.google.android.gms.internal.ads.zzasb.zzh(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r3)
            r1.zzj(r2)
            r4.writeNoException()
            goto L_0x00aa
        L_0x009d:
            r1.zzk()
            r4.writeNoException()
            goto L_0x00aa
        L_0x00a4:
            r1.zzl()
            r4.writeNoException()
        L_0x00aa:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzdj.zzbI(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
