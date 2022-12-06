package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzef;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdoq {
    private int zza;
    private zzdk zzb;
    private zzblw zzc;
    private View zzd;
    private List zze;
    private List zzf = Collections.emptyList();
    private zzef zzg;
    private Bundle zzh;
    private zzcmp zzi;
    private zzcmp zzj;
    private zzcmp zzk;
    private IObjectWrapper zzl;
    private View zzm;
    private View zzn;
    private IObjectWrapper zzo;
    private double zzp;
    private zzbme zzq;
    private zzbme zzr;
    private String zzs;
    private final SimpleArrayMap zzt = new SimpleArrayMap();
    private final SimpleArrayMap zzu = new SimpleArrayMap();
    private float zzv;
    private String zzw;

    public static zzdoq zzab(zzbvv zzbvv) {
        try {
            zzdop zzaf = zzaf(zzbvv.zzg(), (zzbvz) null);
            zzblw zzh2 = zzbvv.zzh();
            String zzo2 = zzbvv.zzo();
            List zzr2 = zzbvv.zzr();
            String zzm2 = zzbvv.zzm();
            Bundle zzf2 = zzbvv.zzf();
            String zzn2 = zzbvv.zzn();
            IObjectWrapper zzl2 = zzbvv.zzl();
            String zzq2 = zzbvv.zzq();
            String zzp2 = zzbvv.zzp();
            double zze2 = zzbvv.zze();
            zzbme zzi2 = zzbvv.zzi();
            zzdoq zzdoq = new zzdoq();
            zzdoq.zza = 2;
            zzdoq.zzb = zzaf;
            zzdoq.zzc = zzh2;
            zzdoq.zzd = (View) zzah(zzbvv.zzj());
            zzdoq.zzU("headline", zzo2);
            zzdoq.zze = zzr2;
            zzdoq.zzU(TtmlNode.TAG_BODY, zzm2);
            zzdoq.zzh = zzf2;
            zzdoq.zzU("call_to_action", zzn2);
            zzdoq.zzm = (View) zzah(zzbvv.zzk());
            zzdoq.zzo = zzl2;
            zzdoq.zzU("store", zzq2);
            zzdoq.zzU("price", zzp2);
            zzdoq.zzp = zze2;
            zzdoq.zzq = zzi2;
            return zzdoq;
        } catch (RemoteException e) {
            zze.zzk("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdoq zzac(zzbvw zzbvw) {
        try {
            zzdop zzaf = zzaf(zzbvw.zzf(), (zzbvz) null);
            zzblw zzg2 = zzbvw.zzg();
            String zzo2 = zzbvw.zzo();
            List zzp2 = zzbvw.zzp();
            String zzm2 = zzbvw.zzm();
            Bundle zze2 = zzbvw.zze();
            String zzn2 = zzbvw.zzn();
            IObjectWrapper zzk2 = zzbvw.zzk();
            String zzl2 = zzbvw.zzl();
            zzbme zzh2 = zzbvw.zzh();
            zzdoq zzdoq = new zzdoq();
            zzdoq.zza = 1;
            zzdoq.zzb = zzaf;
            zzdoq.zzc = zzg2;
            zzdoq.zzd = (View) zzah(zzbvw.zzi());
            zzdoq.zzU("headline", zzo2);
            zzdoq.zze = zzp2;
            zzdoq.zzU(TtmlNode.TAG_BODY, zzm2);
            zzdoq.zzh = zze2;
            zzdoq.zzU("call_to_action", zzn2);
            zzdoq.zzm = (View) zzah(zzbvw.zzj());
            zzdoq.zzo = zzk2;
            zzdoq.zzU(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, zzl2);
            zzdoq.zzr = zzh2;
            return zzdoq;
        } catch (RemoteException e) {
            zze.zzk("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdoq zzad(zzbvv zzbvv) {
        try {
            return zzag(zzaf(zzbvv.zzg(), (zzbvz) null), zzbvv.zzh(), (View) zzah(zzbvv.zzj()), zzbvv.zzo(), zzbvv.zzr(), zzbvv.zzm(), zzbvv.zzf(), zzbvv.zzn(), (View) zzah(zzbvv.zzk()), zzbvv.zzl(), zzbvv.zzq(), zzbvv.zzp(), zzbvv.zze(), zzbvv.zzi(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zze.zzk("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdoq zzae(zzbvw zzbvw) {
        try {
            return zzag(zzaf(zzbvw.zzf(), (zzbvz) null), zzbvw.zzg(), (View) zzah(zzbvw.zzi()), zzbvw.zzo(), zzbvw.zzp(), zzbvw.zzm(), zzbvw.zze(), zzbvw.zzn(), (View) zzah(zzbvw.zzj()), zzbvw.zzk(), (String) null, (String) null, -1.0d, zzbvw.zzh(), zzbvw.zzl(), 0.0f);
        } catch (RemoteException e) {
            zze.zzk("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdop zzaf(zzdk zzdk, zzbvz zzbvz) {
        if (zzdk == null) {
            return null;
        }
        return new zzdop(zzdk, zzbvz);
    }

    private static zzdoq zzag(zzdk zzdk, zzblw zzblw, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbme zzbme, String str6, float f) {
        zzdoq zzdoq = new zzdoq();
        zzdoq.zza = 6;
        zzdoq.zzb = zzdk;
        zzdoq.zzc = zzblw;
        zzdoq.zzd = view;
        String str7 = str;
        zzdoq.zzU("headline", str);
        zzdoq.zze = list;
        String str8 = str2;
        zzdoq.zzU(TtmlNode.TAG_BODY, str2);
        zzdoq.zzh = bundle;
        String str9 = str3;
        zzdoq.zzU("call_to_action", str3);
        zzdoq.zzm = view2;
        zzdoq.zzo = iObjectWrapper;
        String str10 = str4;
        zzdoq.zzU("store", str4);
        String str11 = str5;
        zzdoq.zzU("price", str5);
        zzdoq.zzp = d;
        zzdoq.zzq = zzbme;
        zzdoq.zzU(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, str6);
        zzdoq.zzP(f);
        return zzdoq;
    }

    private static Object zzah(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdoq zzs(zzbvz zzbvz) {
        try {
            return zzag(zzaf(zzbvz.zzj(), zzbvz), zzbvz.zzk(), (View) zzah(zzbvz.zzm()), zzbvz.zzs(), zzbvz.zzv(), zzbvz.zzq(), zzbvz.zzi(), zzbvz.zzr(), (View) zzah(zzbvz.zzn()), zzbvz.zzo(), zzbvz.zzu(), zzbvz.zzt(), zzbvz.zze(), zzbvz.zzl(), zzbvz.zzp(), zzbvz.zzf());
        } catch (RemoteException e) {
            zze.zzk("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzw;
    }

    public final synchronized String zzB() {
        return zzD("price");
    }

    public final synchronized String zzC() {
        return zzD("store");
    }

    public final synchronized String zzD(String str) {
        return (String) this.zzu.get(str);
    }

    public final synchronized List zzE() {
        return this.zze;
    }

    public final synchronized List zzF() {
        return this.zzf;
    }

    public final synchronized void zzG() {
        zzcmp zzcmp = this.zzi;
        if (zzcmp != null) {
            zzcmp.destroy();
            this.zzi = null;
        }
        zzcmp zzcmp2 = this.zzj;
        if (zzcmp2 != null) {
            zzcmp2.destroy();
            this.zzj = null;
        }
        zzcmp zzcmp3 = this.zzk;
        if (zzcmp3 != null) {
            zzcmp3.destroy();
            this.zzk = null;
        }
        this.zzl = null;
        this.zzt.clear();
        this.zzu.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzm = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
    }

    public final synchronized void zzH(zzblw zzblw) {
        this.zzc = zzblw;
    }

    public final synchronized void zzI(String str) {
        this.zzs = str;
    }

    public final synchronized void zzJ(zzef zzef) {
        this.zzg = zzef;
    }

    public final synchronized void zzK(zzbme zzbme) {
        this.zzq = zzbme;
    }

    public final synchronized void zzL(String str, zzblq zzblq) {
        if (zzblq == null) {
            this.zzt.remove(str);
        } else {
            this.zzt.put(str, zzblq);
        }
    }

    public final synchronized void zzM(zzcmp zzcmp) {
        this.zzj = zzcmp;
    }

    public final synchronized void zzN(List list) {
        this.zze = list;
    }

    public final synchronized void zzO(zzbme zzbme) {
        this.zzr = zzbme;
    }

    public final synchronized void zzP(float f) {
        this.zzv = f;
    }

    public final synchronized void zzQ(List list) {
        this.zzf = list;
    }

    public final synchronized void zzR(zzcmp zzcmp) {
        this.zzk = zzcmp;
    }

    public final synchronized void zzS(String str) {
        this.zzw = str;
    }

    public final synchronized void zzT(double d) {
        this.zzp = d;
    }

    public final synchronized void zzU(String str, String str2) {
        if (str2 == null) {
            this.zzu.remove(str);
        } else {
            this.zzu.put(str, str2);
        }
    }

    public final synchronized void zzV(int i) {
        this.zza = i;
    }

    public final synchronized void zzW(zzdk zzdk) {
        this.zzb = zzdk;
    }

    public final synchronized void zzX(View view) {
        this.zzm = view;
    }

    public final synchronized void zzY(zzcmp zzcmp) {
        this.zzi = zzcmp;
    }

    public final synchronized void zzZ(View view) {
        this.zzn = view;
    }

    public final synchronized double zza() {
        return this.zzp;
    }

    public final synchronized void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzl = iObjectWrapper;
    }

    public final synchronized float zzb() {
        return this.zzv;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzm;
    }

    public final synchronized View zzg() {
        return this.zzn;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzt;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzu;
    }

    public final synchronized zzdk zzj() {
        return this.zzb;
    }

    public final synchronized zzef zzk() {
        return this.zzg;
    }

    public final synchronized zzblw zzl() {
        return this.zzc;
    }

    public final zzbme zzm() {
        List list = this.zze;
        if (list != null && !list.isEmpty()) {
            Object obj = this.zze.get(0);
            if (obj instanceof IBinder) {
                return zzbmd.zzg((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized zzbme zzn() {
        return this.zzq;
    }

    public final synchronized zzbme zzo() {
        return this.zzr;
    }

    public final synchronized zzcmp zzp() {
        return this.zzj;
    }

    public final synchronized zzcmp zzq() {
        return this.zzk;
    }

    public final synchronized zzcmp zzr() {
        return this.zzi;
    }

    public final synchronized IObjectWrapper zzt() {
        return this.zzo;
    }

    public final synchronized IObjectWrapper zzu() {
        return this.zzl;
    }

    public final synchronized String zzv() {
        return zzD(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER);
    }

    public final synchronized String zzw() {
        return zzD(TtmlNode.TAG_BODY);
    }

    public final synchronized String zzx() {
        return zzD("call_to_action");
    }

    public final synchronized String zzy() {
        return this.zzs;
    }

    public final synchronized String zzz() {
        return zzD("headline");
    }
}
