package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbls;
import com.google.android.gms.internal.ads.zzbnc;
import com.google.android.gms.internal.ads.zzbnf;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbnp;
import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbsc;
import com.google.android.gms.internal.ads.zzbsl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface zzbo extends IInterface {
    zzbl zze() throws RemoteException;

    void zzf(zzbnc zzbnc) throws RemoteException;

    void zzg(zzbnf zzbnf) throws RemoteException;

    void zzh(String str, zzbnl zzbnl, zzbni zzbni) throws RemoteException;

    void zzi(zzbsl zzbsl) throws RemoteException;

    void zzj(zzbnp zzbnp, zzq zzq) throws RemoteException;

    void zzk(zzbns zzbns) throws RemoteException;

    void zzl(zzbf zzbf) throws RemoteException;

    void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException;

    void zzn(zzbsc zzbsc) throws RemoteException;

    void zzo(zzbls zzbls) throws RemoteException;

    void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException;

    void zzq(zzcd zzcd) throws RemoteException;
}
