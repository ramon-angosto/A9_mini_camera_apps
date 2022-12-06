package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbvl extends zzarz implements zzbvn {
    zzbvl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zzA(zzl zzl, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzB(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zze(zza, zzl);
        zza.writeString(str);
        zzasb.zzg(zza, zzbvq);
        zzbl(32, zza);
    }

    public final void zzC(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(21, zza);
    }

    public final void zzD() throws RemoteException {
        zzbl(8, zza());
    }

    public final void zzE() throws RemoteException {
        zzbl(9, zza());
    }

    public final void zzF(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzd(zza, z);
        zzbl(25, zza);
    }

    public final void zzG() throws RemoteException {
        zzbl(4, zza());
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(37, zza);
    }

    public final void zzI(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(30, zza);
    }

    public final void zzJ() throws RemoteException {
        zzbl(12, zza());
    }

    public final boolean zzK() throws RemoteException {
        Parcel zzbk = zzbk(22, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    public final boolean zzL() throws RemoteException {
        Parcel zzbk = zzbk(13, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvv zzM() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 15
            android.os.Parcel r0 = r4.zzbk(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbvv
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbvv r1 = (com.google.android.gms.internal.ads.zzbvv) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbvv r2 = new com.google.android.gms.internal.ads.zzbvv
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvl.zzM():com.google.android.gms.internal.ads.zzbvv");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvw zzN() throws android.os.RemoteException {
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
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbvw
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbvw r1 = (com.google.android.gms.internal.ads.zzbvw) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbvw r2 = new com.google.android.gms.internal.ads.zzbvw
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvl.zzN():com.google.android.gms.internal.ads.zzbvw");
    }

    public final Bundle zze() throws RemoteException {
        throw null;
    }

    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    public final zzdk zzh() throws RemoteException {
        Parcel zzbk = zzbk(26, zza());
        zzdk zzb = zzdj.zzb(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzb;
    }

    public final zzbmy zzi() throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvt zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 36
            android.os.Parcel r0 = r4.zzbk(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbvt
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbvt r1 = (com.google.android.gms.internal.ads.zzbvt) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbvr r2 = new com.google.android.gms.internal.ads.zzbvr
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvl.zzj():com.google.android.gms.internal.ads.zzbvt");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbvz zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 27
            android.os.Parcel r0 = r4.zzbk(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbvz
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzbvz r1 = (com.google.android.gms.internal.ads.zzbvz) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzbvx r2 = new com.google.android.gms.internal.ads.zzbvx
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvl.zzk():com.google.android.gms.internal.ads.zzbvz");
    }

    public final zzbxq zzl() throws RemoteException {
        Parcel zzbk = zzbk(33, zza());
        zzbxq zzbxq = (zzbxq) zzasb.zza(zzbk, zzbxq.CREATOR);
        zzbk.recycle();
        return zzbxq;
    }

    public final zzbxq zzm() throws RemoteException {
        Parcel zzbk = zzbk(34, zza());
        zzbxq zzbxq = (zzbxq) zzasb.zza(zzbk, zzbxq.CREATOR);
        zzbk.recycle();
        return zzbxq;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbk = zzbk(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbk.readStrongBinder());
        zzbk.recycle();
        return asInterface;
    }

    public final void zzo() throws RemoteException {
        zzbl(5, zza());
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzccd zzccd, String str2) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zze(zza, zzl);
        zza.writeString((String) null);
        zzasb.zzg(zza, zzccd);
        zza.writeString(str2);
        zzbl(10, zza);
    }

    public final void zzq(IObjectWrapper iObjectWrapper, zzbru zzbru, List list) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbru);
        zza.writeTypedList(list);
        zzbl(31, zza);
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzccd zzccd, List list) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzccd);
        zza.writeStringList(list);
        zzbl(23, zza);
    }

    public final void zzs(zzl zzl, String str) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzl);
        zza.writeString(str);
        zzbl(11, zza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, zzbvq zzbvq) throws RemoteException {
        throw null;
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zze(zza, zzq);
        zzasb.zze(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zzg(zza, zzbvq);
        zzbl(6, zza);
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zze(zza, zzq);
        zzasb.zze(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zzg(zza, zzbvq);
        zzbl(35, zza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbvq zzbvq) throws RemoteException {
        throw null;
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zze(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zzg(zza, zzbvq);
        zzbl(7, zza);
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzbvq zzbvq, zzbls zzbls, List list) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zze(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zzg(zza, zzbvq);
        zzasb.zze(zza, zzbls);
        zza.writeStringList(list);
        zzbl(14, zza);
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zze(zza, zzl);
        zza.writeString(str);
        zzasb.zzg(zza, zzbvq);
        zzbl(28, zza);
    }
}
