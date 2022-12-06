package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbtw {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final Context zzb;
    private final String zzc;
    private final zzcgv zzd;
    /* access modifiers changed from: private */
    public final zzfjw zze;
    private final zzbb zzf;
    private final zzbb zzg;
    /* access modifiers changed from: private */
    public zzbtv zzh;
    /* access modifiers changed from: private */
    public int zzi = 1;

    public zzbtw(Context context, zzcgv zzcgv, String str, zzbb zzbb, zzbb zzbb2, zzfjw zzfjw) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = zzcgv;
        this.zze = zzfjw;
        this.zzf = zzbb;
        this.zzg = zzbb2;
    }

    public final zzbtq zzb(zzape zzape) {
        synchronized (this.zza) {
            synchronized (this.zza) {
                zzbtv zzbtv = this.zzh;
                if (zzbtv != null && this.zzi == 0) {
                    zzbtv.zzi(new zzbtb(this), zzbtc.zza);
                }
            }
            zzbtv zzbtv2 = this.zzh;
            if (zzbtv2 != null) {
                if (zzbtv2.zze() != -1) {
                    int i = this.zzi;
                    if (i == 0) {
                        zzbtq zza2 = this.zzh.zza();
                        return zza2;
                    } else if (i == 1) {
                        this.zzi = 2;
                        zzd((zzape) null);
                        zzbtq zza3 = this.zzh.zza();
                        return zza3;
                    } else {
                        zzbtq zza4 = this.zzh.zza();
                        return zza4;
                    }
                }
            }
            this.zzi = 2;
            this.zzh = zzd((zzape) null);
            zzbtq zza5 = this.zzh.zza();
            return zza5;
        }
    }

    /* access modifiers changed from: protected */
    public final zzbtv zzd(zzape zzape) {
        zzfjj zza2 = zzfji.zza(this.zzb, 6);
        zza2.zzf();
        zzbtv zzbtv = new zzbtv(this.zzg);
        zzchc.zze.execute(new zzbtd(this, (zzape) null, zzbtv));
        zzbtv.zzi(new zzbtl(this, zzbtv, zza2), new zzbtm(this, zzbtv, zza2));
        return zzbtv;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzi(com.google.android.gms.internal.ads.zzbtv r4, com.google.android.gms.internal.ads.zzbsr r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zza
            monitor-enter(r0)
            int r1 = r4.zze()     // Catch:{ all -> 0x0028 }
            r2 = -1
            if (r1 == r2) goto L_0x0026
            int r1 = r4.zze()     // Catch:{ all -> 0x0028 }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            r4.zzg()     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.ads.zzfzq r4 = com.google.android.gms.internal.ads.zzchc.zze     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.ads.zzbtg r1 = new com.google.android.gms.internal.ads.zzbtg     // Catch:{ all -> 0x0028 }
            r1.<init>(r5)     // Catch:{ all -> 0x0028 }
            r4.execute(r1)     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.ads.internal.util.zze.zza(r4)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0026:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtw.zzi(com.google.android.gms.internal.ads.zzbtv, com.google.android.gms.internal.ads.zzbsr):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzape zzape, zzbtv zzbtv) {
        try {
            zzbsz zzbsz = new zzbsz(this.zzb, this.zzd, (zzape) null, (zza) null);
            zzbsz.zzk(new zzbtf(this, zzbtv, zzbsz));
            zzbsz.zzq("/jsLoaded", new zzbth(this, zzbtv, zzbsz));
            zzca zzca = new zzca();
            zzbti zzbti = new zzbti(this, (zzape) null, zzbsz, zzca);
            zzca.zzb(zzbti);
            zzbsz.zzq("/requestReload", zzbti);
            if (this.zzc.endsWith(".js")) {
                zzbsz.zzh(this.zzc);
            } else if (this.zzc.startsWith("<html>")) {
                zzbsz.zzf(this.zzc);
            } else {
                zzbsz.zzg(this.zzc);
            }
            zzs.zza.postDelayed(new zzbtk(this, zzbtv, zzbsz), ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        } catch (Throwable th) {
            zze.zzh("Error creating webview.", th);
            zzt.zzo().zzt(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbtv.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzbsr zzbsr) {
        if (zzbsr.zzi()) {
            this.zzi = 1;
        }
    }
}
