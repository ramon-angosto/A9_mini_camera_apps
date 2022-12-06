package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaxv implements zzazy {
    final /* synthetic */ zzaxy zza;
    private final Uri zzb;
    private final zzazm zzc;
    private final zzaxw zzd;
    private final zzbae zze;
    private final zzave zzf;
    private volatile boolean zzg;
    private boolean zzh;
    private long zzi;
    /* access modifiers changed from: private */
    public long zzj;

    public zzaxv(zzaxy zzaxy, Uri uri, zzazm zzazm, zzaxw zzaxw, zzbae zzbae) {
        this.zza = zzaxy;
        if (uri != null) {
            this.zzb = uri;
            if (zzazm != null) {
                this.zzc = zzazm;
                if (zzaxw != null) {
                    this.zzd = zzaxw;
                    this.zze = zzbae;
                    this.zzf = new zzave();
                    this.zzh = true;
                    this.zzj = -1;
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public final void zzb() {
        this.zzg = true;
    }

    public final void zzc() throws IOException, InterruptedException {
        zzauy zzauy;
        long j;
        while (!this.zzg) {
            int i = 0;
            try {
                long j2 = this.zzf.zza;
                zzazm zzazm = this.zzc;
                zzazo zzazo = r4;
                long j3 = j2;
                zzazo zzazo2 = new zzazo(this.zzb, (byte[]) null, j2, j2, -1, (String) null, 0);
                long zzb2 = zzazm.zzb(zzazo);
                this.zzj = zzb2;
                if (zzb2 != -1) {
                    j = j3;
                    zzb2 += j;
                    this.zzj = zzb2;
                } else {
                    j = j3;
                }
                zzauy = new zzauy(this.zzc, j, zzb2);
                try {
                    zzauz zzb3 = this.zzd.zzb(zzauy, this.zzc.zzc());
                    if (this.zzh) {
                        zzb3.zze(j, this.zzi);
                        this.zzh = false;
                    }
                    int i2 = 0;
                    long j4 = j;
                    while (true) {
                        if (i2 != 0) {
                            break;
                        }
                        try {
                            if (this.zzg) {
                                i2 = 0;
                                break;
                            }
                            this.zze.zza();
                            i2 = zzb3.zzf(zzauy, this.zzf);
                            if (zzauy.zzd() > this.zza.zzg + j4) {
                                j4 = zzauy.zzd();
                                this.zze.zzb();
                                zzaxy zzaxy = this.zza;
                                zzaxy.zzm.post(zzaxy.zzl);
                            }
                        } catch (Throwable th) {
                            th = th;
                            i = i2;
                            if (!(i == 1 || zzauy == null)) {
                                this.zzf.zza = zzauy.zzd();
                            }
                            zzbar.zzm(this.zzc);
                            throw th;
                        }
                    }
                    if (i2 != 1) {
                        this.zzf.zza = zzauy.zzd();
                        i = i2;
                    }
                    zzbar.zzm(this.zzc);
                    if (i != 0) {
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.zzf.zza = zzauy.zzd();
                    zzbar.zzm(this.zzc);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zzauy = null;
                this.zzf.zza = zzauy.zzd();
                zzbar.zzm(this.zzc);
                throw th;
            }
        }
    }

    public final void zzd(long j, long j2) {
        this.zzf.zza = j;
        this.zzi = j2;
        this.zzh = true;
    }

    public final boolean zze() {
        return this.zzg;
    }
}
