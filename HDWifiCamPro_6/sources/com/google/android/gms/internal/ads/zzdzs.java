package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdzs {
    private boolean zza = false;
    private boolean zzb = false;
    /* access modifiers changed from: private */
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final zzchh zze = new zzchh();
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdvl zzh;
    /* access modifiers changed from: private */
    public final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    /* access modifiers changed from: private */
    public final zzdxz zzl;
    private final zzcgv zzm;
    private final Map zzn = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final zzdjr zzo;
    /* access modifiers changed from: private */
    public final zzfjw zzp;
    private boolean zzq = true;

    public zzdzs(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdvl zzdvl, ScheduledExecutorService scheduledExecutorService, zzdxz zzdxz, zzcgv zzcgv, zzdjr zzdjr, zzfjw zzfjw) {
        this.zzh = zzdvl;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdxz;
        this.zzm = zzcgv;
        this.zzo = zzdjr;
        this.zzp = zzfjw;
        this.zzd = zzt.zzB().elapsedRealtime();
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    static /* bridge */ /* synthetic */ void zzj(zzdzs zzdzs, String str) {
        zzdzs zzdzs2 = zzdzs;
        int i = 5;
        zzfjj zza2 = zzfji.zza(zzdzs2.zzf, 5);
        zza2.zzf();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzfjj zza3 = zzfji.zza(zzdzs2.zzf, i);
                zza3.zzf();
                zza3.zzc(next);
                Object obj = new Object();
                zzchh zzchh = new zzchh();
                zzfzp zzo2 = zzfzg.zzo(zzchh, ((Long) zzay.zzc().zzb(zzbjc.zzbB)).longValue(), TimeUnit.SECONDS, zzdzs2.zzk);
                zzdzs2.zzl.zzc(next);
                zzdzs2.zzo.zzc(next);
                long elapsedRealtime = zzt.zzB().elapsedRealtime();
                zzdzj zzdzj = r1;
                zzfzp zzfzp = zzo2;
                zzdzj zzdzj2 = new zzdzj(zzdzs, obj, zzchh, next, elapsedRealtime, zza3);
                zzfzp.zzc(zzdzj, zzdzs2.zzi);
                arrayList.add(zzfzp);
                zzdzr zzdzr = new zzdzr(zzdzs, obj, next, elapsedRealtime, zza3, zzchh);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        int i2 = 0;
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzbsa(optString, bundle));
                            i2++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdzs2.zzv(next, false, "", 0);
                try {
                    zzdzs2.zzj.execute(new zzdzn(zzdzs, zzdzs2.zzh.zzc(next, new JSONObject()), zzdzr, arrayList2, next));
                } catch (zzfek unused2) {
                    try {
                        zzdzr.zze("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzcgp.zzh("", e);
                    }
                }
                i = 5;
            }
            zzfzg.zza(arrayList).zza(new zzdzk(zzdzs2, zza2), zzdzs2.zzi);
        } catch (JSONException e2) {
            zze.zzb("Malformed CLD response", e2);
            zzdzs2.zzo.zza("MalformedJson");
            zzdzs2.zzl.zza("MalformedJson");
            zzdzs2.zze.zze(e2);
            zzt.zzo().zzt(e2, "AdapterInitializer.updateAdapterStatus");
            zzfjw zzfjw = zzdzs2.zzp;
            zza2.zze(false);
            zzfjw.zzb(zza2.zzj());
        }
    }

    private final synchronized zzfzp zzu() {
        String zzc2 = zzt.zzo().zzh().zzh().zzc();
        if (!TextUtils.isEmpty(zzc2)) {
            return zzfzg.zzi(zzc2);
        }
        zzchh zzchh = new zzchh();
        zzt.zzo().zzh().zzq(new zzdzo(this, zzchh));
        return zzchh;
    }

    /* access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbrq(str, z, i, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzf(zzfjj zzfjj) throws Exception {
        this.zze.zzd(true);
        zzfjw zzfjw = this.zzp;
        zzfjj.zze(true);
        zzfjw.zzb(zzfjj.zzj());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbrq zzbrq = (zzbrq) this.zzn.get(str);
            arrayList.add(new zzbrq(str, zzbrq.zzb, zzbrq.zzc, zzbrq.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        synchronized (this) {
            if (!this.zzc) {
                zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzt.zzB().elapsedRealtime() - this.zzd));
                this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zze.zze(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        com.google.android.gms.internal.ads.zzcgp.zzh("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3.zze("Failed to initialize adapter. " + r5 + " does not implement the initialize() method.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzn(com.google.android.gms.internal.ads.zzffa r2, com.google.android.gms.internal.ads.zzbru r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference r0 = r1.zzg     // Catch:{ zzfek -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzfek -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzfek -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzf     // Catch:{ zzfek -> 0x0011 }
        L_0x000d:
            r2.zzi(r0, r3, r4)     // Catch:{ zzfek -> 0x0011 }
            return
        L_0x0011:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x002b }
            r2.<init>()     // Catch:{ RemoteException -> 0x002b }
            java.lang.String r4 = "Failed to initialize adapter. "
            r2.append(r4)     // Catch:{ RemoteException -> 0x002b }
            r2.append(r5)     // Catch:{ RemoteException -> 0x002b }
            java.lang.String r4 = " does not implement the initialize() method."
            r2.append(r4)     // Catch:{ RemoteException -> 0x002b }
            java.lang.String r2 = r2.toString()     // Catch:{ RemoteException -> 0x002b }
            r3.zze(r2)     // Catch:{ RemoteException -> 0x002b }
            return
        L_0x002b:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzcgp.zzh(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdzs.zzn(com.google.android.gms.internal.ads.zzffa, com.google.android.gms.internal.ads.zzbru, java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzchh zzchh) {
        this.zzi.execute(new zzdzh(this, zzchh));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Object obj, zzchh zzchh, String str, long j, zzfjj zzfjj) {
        synchronized (obj) {
            if (!zzchh.isDone()) {
                zzv(str, false, "Timeout.", (int) (zzt.zzB().elapsedRealtime() - j));
                this.zzl.zzb(str, "timeout");
                this.zzo.zzb(str, "timeout");
                zzfjw zzfjw = this.zzp;
                zzfjj.zze(false);
                zzfjw.zzb(zzfjj.zzj());
                zzchh.zzd(false);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbkx.zza.zze()).booleanValue()) {
            if (this.zzm.zzc >= ((Integer) zzay.zzc().zzb(zzbjc.zzbA)).intValue() && this.zzq) {
                if (!this.zza) {
                    synchronized (this) {
                        if (!this.zza) {
                            this.zzl.zzf();
                            this.zzo.zzf();
                            this.zze.zzc(new zzdzi(this), this.zzi);
                            this.zza = true;
                            zzfzp zzu = zzu();
                            this.zzk.schedule(new zzdzl(this), ((Long) zzay.zzc().zzb(zzbjc.zzbC)).longValue(), TimeUnit.SECONDS);
                            zzfzg.zzr(zzu, new zzdzq(this), this.zzi);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zza) {
            zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzd(false);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final void zzs(zzbrx zzbrx) {
        this.zze.zzc(new zzdzm(this, zzbrx), this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
