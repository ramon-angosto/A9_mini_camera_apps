package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzcy;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeas implements zzo, zzcoa {
    private final Context zza;
    private final zzcgv zzb;
    private zzeak zzc;
    private zzcmp zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private zzcy zzh;
    private boolean zzi;

    zzeas(Context context, zzcgv zzcgv) {
        this.zza = context;
        this.zzb = zzcgv;
    }

    private final synchronized boolean zzl(zzcy zzcy) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzhE)).booleanValue()) {
            zze.zzj("Ad inspector had an internal error.");
            try {
                zzcy.zze(zzffe.zzd(16, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
            } catch (RemoteException unused) {
            }
        } else if (this.zzc == null) {
            zze.zzj("Ad inspector had an internal error.");
            try {
                zzcy.zze(zzffe.zzd(16, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
            } catch (RemoteException unused2) {
            }
        } else {
            if (!this.zze && !this.zzf) {
                if (zzt.zzB().currentTimeMillis() >= this.zzg + ((long) ((Integer) zzay.zzc().zzb(zzbjc.zzhH)).intValue())) {
                    return true;
                }
            }
            zze.zzj("Ad inspector cannot be opened because it is already open.");
            try {
                zzcy.zze(zzffe.zzd(19, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
            } catch (RemoteException unused3) {
            }
        }
        return false;
        return false;
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|11|12|(1:14)|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 1
            if (r4 == 0) goto L_0x0012
            java.lang.String r4 = "Ad inspector loaded."
            com.google.android.gms.ads.internal.util.zze.zza(r4)     // Catch:{ all -> 0x002e }
            r3.zze = r0     // Catch:{ all -> 0x002e }
            java.lang.String r4 = ""
            r3.zzk(r4)     // Catch:{ all -> 0x002e }
            monitor-exit(r3)
            return
        L_0x0012:
            java.lang.String r4 = "Ad inspector failed to load."
            com.google.android.gms.ads.internal.util.zze.zzj(r4)     // Catch:{ all -> 0x002e }
            com.google.android.gms.ads.internal.client.zzcy r4 = r3.zzh     // Catch:{ RemoteException -> 0x0025 }
            if (r4 == 0) goto L_0x0025
            r1 = 17
            r2 = 0
            com.google.android.gms.ads.internal.client.zze r1 = com.google.android.gms.internal.ads.zzffe.zzd(r1, r2, r2)     // Catch:{ RemoteException -> 0x0025 }
            r4.zze(r1)     // Catch:{ RemoteException -> 0x0025 }
        L_0x0025:
            r3.zzi = r0     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzcmp r4 = r3.zzd     // Catch:{ all -> 0x002e }
            r4.destroy()     // Catch:{ all -> 0x002e }
            monitor-exit(r3)
            return
        L_0x002e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeas.zza(boolean):void");
    }

    public final synchronized void zzb() {
        this.zzf = true;
        zzk("");
    }

    public final void zzbC() {
    }

    public final void zzbK() {
    }

    public final void zzbr() {
    }

    public final void zze() {
    }

    public final synchronized void zzf(int i) {
        this.zzd.destroy();
        if (!this.zzi) {
            zze.zza("Inspector closed.");
            zzcy zzcy = this.zzh;
            if (zzcy != null) {
                try {
                    zzcy.zze((com.google.android.gms.ads.internal.client.zze) null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0;
        this.zzi = false;
        this.zzh = null;
    }

    public final Activity zzg() {
        zzcmp zzcmp = this.zzd;
        if (zzcmp == null || zzcmp.zzaB()) {
            return null;
        }
        return this.zzd.zzk();
    }

    public final void zzh(zzeak zzeak) {
        this.zzc = zzeak;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str) {
        JSONObject zze2 = this.zzc.zze();
        if (!TextUtils.isEmpty(str)) {
            try {
                zze2.put("redirectUrl", str);
            } catch (JSONException unused) {
            }
        }
        this.zzd.zzb("window.inspectorInfo", zze2.toString());
    }

    public final synchronized void zzj(zzcy zzcy, zzbpv zzbpv, zzbqg zzbqg) {
        zzcy zzcy2 = zzcy;
        synchronized (this) {
            if (zzl(zzcy)) {
                try {
                    zzt.zzz();
                    this.zzd = zzcnb.zza(this.zza, zzcoe.zza(), "", false, false, (zzape) null, (zzbkb) null, this.zzb, (zzbjr) null, (zzl) null, (zza) null, zzbep.zza(), (zzfdk) null, (zzfdn) null);
                    zzcoc zzP = this.zzd.zzP();
                    if (zzP == null) {
                        zze.zzj("Failed to obtain a web view for the ad inspector");
                        try {
                            zzcy2.zze(zzffe.zzd(17, "Failed to obtain a web view for the ad inspector", (com.google.android.gms.ads.internal.client.zze) null));
                        } catch (RemoteException unused) {
                        }
                    } else {
                        this.zzh = zzcy2;
                        zzP.zzL((com.google.android.gms.ads.internal.client.zza) null, (zzbop) null, (zzo) null, (zzbor) null, (zzz) null, false, (zzbpx) null, (zzb) null, (zzbyg) null, (zzcdq) null, (zzego) null, (zzfkm) null, (zzdxq) null, (zzfir) null, zzbpv, (zzdkn) null, new zzbqm(this.zza), zzbqg);
                        zzP.zzz(this);
                        this.zzd.loadUrl((String) zzay.zzc().zzb(zzbjc.zzhF));
                        zzt.zzi();
                        zzm.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
                        this.zzg = zzt.zzB().currentTimeMillis();
                    }
                } catch (zzcna e) {
                    zze.zzk("Failed to obtain a web view for the ad inspector", e);
                    try {
                        zzcy2.zze(zzffe.zzd(17, "Failed to obtain a web view for the ad inspector", (com.google.android.gms.ads.internal.client.zze) null));
                    } catch (RemoteException unused2) {
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzk(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            boolean r0 = r2.zzf     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            com.google.android.gms.internal.ads.zzfzq r0 = com.google.android.gms.internal.ads.zzchc.zze     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzear r1 = new com.google.android.gms.internal.ads.zzear     // Catch:{ all -> 0x0018 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.execute(r1)     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return
        L_0x0016:
            monitor-exit(r2)
            return
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeas.zzk(java.lang.String):void");
    }
}
