package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzair {
    private final List zza;
    private final zzaap[] zzb;

    public zzair(List list) {
        this.zza = list;
        this.zzb = new zzaap[list.size()];
    }

    public final void zza(long j, zzef zzef) {
        if (zzef.zza() >= 9) {
            int zze = zzef.zze();
            int zze2 = zzef.zze();
            int zzk = zzef.zzk();
            if (zze == 434 && zze2 == 1195456820 && zzk == 3) {
                zzyv.zzb(j, zzef, this.zzb);
            }
        }
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzaio.zzc();
            zzaap zzv = zzzl.zzv(zzaio.zza(), 3);
            zzaf zzaf = (zzaf) this.zza.get(i);
            String str = zzaf.zzm;
            boolean z = true;
            if (!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) {
                z = false;
            }
            zzdd.zze(z, "Invalid closed caption mime type provided: ".concat(String.valueOf(str)));
            zzad zzad = new zzad();
            zzad.zzH(zzaio.zzb());
            zzad.zzS(str);
            zzad.zzU(zzaf.zze);
            zzad.zzK(zzaf.zzd);
            zzad.zzu(zzaf.zzE);
            zzad.zzI(zzaf.zzo);
            zzv.zzk(zzad.zzY());
            this.zzb[i] = zzv;
        }
    }
}
