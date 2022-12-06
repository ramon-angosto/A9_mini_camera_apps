package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaya implements zzaye, zzayd {
    private final Uri zza;
    private final zzazl zzb;
    private final zzavb zzc;
    private final int zzd;
    private final Handler zze;
    private final zzaxz zzf;
    private final zzatf zzg = new zzatf();
    private final int zzh;
    private zzayd zzi;
    private zzath zzj;
    private boolean zzk;

    public zzaya(Uri uri, zzazl zzazl, zzavb zzavb, int i, Handler handler, zzaxz zzaxz, String str, int i2) {
        this.zza = uri;
        this.zzb = zzazl;
        this.zzc = zzavb;
        this.zzd = i;
        this.zze = handler;
        this.zzf = zzaxz;
        this.zzh = i2;
    }

    public final void zza() throws IOException {
    }

    public final void zzb(zzasm zzasm, boolean z, zzayd zzayd) {
        this.zzi = zzayd;
        this.zzj = new zzayr(C.TIME_UNSET, false);
        zzayd.zzg(this.zzj, (Object) null);
    }

    public final void zzc(zzayc zzayc) {
        ((zzaxy) zzayc).zzx();
    }

    public final void zzd() {
        this.zzi = null;
    }

    public final zzayc zze(int i, zzazp zzazp) {
        zzbac.zzc(i == 0);
        return new zzaxy(this.zza, this.zzb.zza(), this.zzc.zza(), this.zzd, this.zze, this.zzf, this, zzazp, (String) null, this.zzh, (byte[]) null);
    }

    public final void zzg(zzath zzath, Object obj) {
        zzatf zzatf = this.zzg;
        boolean z = false;
        zzath.zzd(0, zzatf, false);
        if (zzatf.zzc != C.TIME_UNSET) {
            z = true;
        }
        if (!this.zzk || z) {
            this.zzj = zzath;
            this.zzk = z;
            this.zzi.zzg(this.zzj, (Object) null);
        }
    }
}
