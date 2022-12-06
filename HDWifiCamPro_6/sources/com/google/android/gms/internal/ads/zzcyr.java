package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcyr implements zzdeo, zzddu {
    private final Context zza;
    private final zzcmp zzb;
    private final zzfdk zzc;
    private final zzcgv zzd;
    private IObjectWrapper zze;
    private boolean zzf;

    public zzcyr(Context context, zzcmp zzcmp, zzfdk zzfdk, zzcgv zzcgv) {
        this.zza = context;
        this.zzb = zzcmp;
        this.zzc = zzfdk;
        this.zzd = zzcgv;
    }

    private final synchronized void zza() {
        zzeha zzeha;
        zzehb zzehb;
        if (this.zzc.zzU) {
            if (this.zzb != null) {
                if (zzt.zzA().zze(this.zza)) {
                    zzcgv zzcgv = this.zzd;
                    String str = zzcgv.zzb + "." + zzcgv.zzc;
                    String zza2 = this.zzc.zzW.zza();
                    if (this.zzc.zzW.zzb() == 1) {
                        zzeha = zzeha.VIDEO;
                        zzehb = zzehb.DEFINED_BY_JAVASCRIPT;
                    } else {
                        zzeha = zzeha.HTML_DISPLAY;
                        if (this.zzc.zzf == 1) {
                            zzehb = zzehb.ONE_PIXEL;
                        } else {
                            zzehb = zzehb.BEGIN_TO_RENDER;
                        }
                    }
                    this.zze = zzt.zzA().zza(str, this.zzb.zzI(), "", "javascript", zza2, zzehb, zzeha, this.zzc.zzan);
                    zzcmp zzcmp = this.zzb;
                    if (this.zze != null) {
                        zzt.zzA().zzc(this.zze, (View) zzcmp);
                        this.zzb.zzar(this.zze);
                        zzt.zzA().zzd(this.zze);
                        this.zzf = true;
                        this.zzb.zzd("onSdkLoaded", new ArrayMap());
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzl() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzf     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0008
            r3.zza()     // Catch:{ all -> 0x0024 }
        L_0x0008:
            com.google.android.gms.internal.ads.zzfdk r0 = r3.zzc     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.zzU     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.dynamic.IObjectWrapper r0 = r3.zze     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.zzcmp r0 = r3.zzb     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "onSdkImpression"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x0024 }
            monitor-exit(r3)
            return
        L_0x0022:
            monitor-exit(r3)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcyr.zzl():void");
    }

    public final synchronized void zzn() {
        if (!this.zzf) {
            zza();
        }
    }
}
