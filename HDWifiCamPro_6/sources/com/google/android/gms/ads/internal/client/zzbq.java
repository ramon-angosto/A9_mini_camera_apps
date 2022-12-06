package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzasb;
import com.google.android.gms.internal.ads.zzbdm;
import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcby;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbq extends zzarz implements zzbs {
    zzbq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final void zzA() throws RemoteException {
        zzbl(11, zza());
    }

    public final void zzB() throws RemoteException {
        zzbl(6, zza());
    }

    public final void zzC(zzbc zzbc) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbc);
        zzbl(20, zza);
    }

    public final void zzD(zzbf zzbf) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbf);
        zzbl(7, zza);
    }

    public final void zzE(zzbw zzbw) throws RemoteException {
        throw null;
    }

    public final void zzF(zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzq);
        zzbl(13, zza);
    }

    public final void zzG(zzbz zzbz) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbz);
        zzbl(8, zza);
    }

    public final void zzH(zzbdm zzbdm) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbdm);
        zzbl(40, zza);
    }

    public final void zzI(zzw zzw) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzw);
        zzbl(39, zza);
    }

    public final void zzJ(zzcg zzcg) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzcg);
        zzbl(45, zza);
    }

    public final void zzK(zzdo zzdo) throws RemoteException {
        throw null;
    }

    public final void zzL(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzd(zza, z);
        zzbl(34, zza);
    }

    public final void zzM(zzbzl zzbzl) throws RemoteException {
        throw null;
    }

    public final void zzN(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzd(zza, z);
        zzbl(22, zza);
    }

    public final void zzO(zzbjx zzbjx) throws RemoteException {
        throw null;
    }

    public final void zzP(zzde zzde) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzde);
        zzbl(42, zza);
    }

    public final void zzQ(zzbzo zzbzo, String str) throws RemoteException {
        throw null;
    }

    public final void zzR(String str) throws RemoteException {
        throw null;
    }

    public final void zzS(zzcby zzcby) throws RemoteException {
        throw null;
    }

    public final void zzT(String str) throws RemoteException {
        throw null;
    }

    public final void zzU(zzff zzff) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzff);
        zzbl(29, zza);
    }

    public final void zzW(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(44, zza);
    }

    public final void zzX() throws RemoteException {
        throw null;
    }

    public final boolean zzY() throws RemoteException {
        Parcel zzbk = zzbk(23, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    public final boolean zzZ() throws RemoteException {
        throw null;
    }

    public final boolean zzaa(zzl zzl) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzl);
        Parcel zzbk = zzbk(4, zza);
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    public final void zzab(zzcd zzcd) throws RemoteException {
        throw null;
    }

    public final Bundle zzd() throws RemoteException {
        throw null;
    }

    public final zzq zzg() throws RemoteException {
        Parcel zzbk = zzbk(12, zza());
        zzq zzq = (zzq) zzasb.zza(zzbk, zzq.CREATOR);
        zzbk.recycle();
        return zzq;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzbf zzi() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 33
            android.os.Parcel r0 = r4.zzbk(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzbf
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzbf r1 = (com.google.android.gms.ads.internal.client.zzbf) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzbd r2 = new com.google.android.gms.ads.internal.client.zzbd
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbq.zzi():com.google.android.gms.ads.internal.client.zzbf");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzbz zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 32
            android.os.Parcel r0 = r4.zzbk(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzbz
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzbz r1 = (com.google.android.gms.ads.internal.client.zzbz) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzbx r2 = new com.google.android.gms.ads.internal.client.zzbx
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbq.zzj():com.google.android.gms.ads.internal.client.zzbz");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzdh zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 41
            android.os.Parcel r0 = r4.zzbk(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IResponseInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzdh
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzdh r1 = (com.google.android.gms.ads.internal.client.zzdh) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzdf r2 = new com.google.android.gms.ads.internal.client.zzdf
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbq.zzk():com.google.android.gms.ads.internal.client.zzdh");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzdk zzl() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 26
            android.os.Parcel r0 = r4.zzbk(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoController"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzdk
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzdk r1 = (com.google.android.gms.ads.internal.client.zzdk) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzdi r2 = new com.google.android.gms.ads.internal.client.zzdi
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbq.zzl():com.google.android.gms.ads.internal.client.zzdk");
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbk = zzbk(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbk.readStrongBinder());
        zzbk.recycle();
        return asInterface;
    }

    public final String zzr() throws RemoteException {
        Parcel zzbk = zzbk(31, zza());
        String readString = zzbk.readString();
        zzbk.recycle();
        return readString;
    }

    public final String zzs() throws RemoteException {
        throw null;
    }

    public final String zzt() throws RemoteException {
        throw null;
    }

    public final void zzx() throws RemoteException {
        zzbl(2, zza());
    }

    public final void zzy(zzl zzl, zzbi zzbi) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzl);
        zzasb.zzg(zza, zzbi);
        zzbl(43, zza);
    }

    public final void zzz() throws RemoteException {
        zzbl(5, zza());
    }
}
