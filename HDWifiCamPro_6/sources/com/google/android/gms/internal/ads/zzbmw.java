package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbmw extends zzarz implements zzbmy {
    zzbmw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public final zzdk zze() throws RemoteException {
        Parcel zzbk = zzbk(7, zza());
        zzdk zzb = zzdj.zzb(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbmb zzf() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 16
            android.os.Parcel r0 = r4.zzbk(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbmb
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbmb r1 = (com.google.android.gms.internal.ads.zzbmb) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzblz r2 = new com.google.android.gms.internal.ads.zzblz
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmw.zzf():com.google.android.gms.internal.ads.zzbmb");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbme zzg(java.lang.String r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zza()
            r0.writeString(r4)
            r4 = 2
            android.os.Parcel r4 = r3.zzbk(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzbme
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.internal.ads.zzbme r0 = (com.google.android.gms.internal.ads.zzbme) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.internal.ads.zzbmc r1 = new com.google.android.gms.internal.ads.zzbmc
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmw.zzg(java.lang.String):com.google.android.gms.internal.ads.zzbme");
    }

    public final IObjectWrapper zzh() throws RemoteException {
        Parcel zzbk = zzbk(9, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbk.readStrongBinder());
        zzbk.recycle();
        return asInterface;
    }

    public final String zzi() throws RemoteException {
        Parcel zzbk = zzbk(4, zza());
        String readString = zzbk.readString();
        zzbk.recycle();
        return readString;
    }

    public final String zzj(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbk = zzbk(1, zza);
        String readString = zzbk.readString();
        zzbk.recycle();
        return readString;
    }

    public final List zzk() throws RemoteException {
        Parcel zzbk = zzbk(3, zza());
        ArrayList<String> createStringArrayList = zzbk.createStringArrayList();
        zzbk.recycle();
        return createStringArrayList;
    }

    public final void zzl() throws RemoteException {
        zzbl(8, zza());
    }

    public final void zzm() throws RemoteException {
        zzbl(15, zza());
    }

    public final void zzn(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbl(5, zza);
    }

    public final void zzo() throws RemoteException {
        zzbl(6, zza());
    }

    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(14, zza);
    }

    public final boolean zzq() throws RemoteException {
        Parcel zzbk = zzbk(12, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        Parcel zzbk = zzbk(10, zza);
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    public final boolean zzs() throws RemoteException {
        Parcel zzbk = zzbk(13, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }
}
