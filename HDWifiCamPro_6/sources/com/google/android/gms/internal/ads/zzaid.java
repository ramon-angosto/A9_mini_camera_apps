package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaid {
    private final List zza;
    private final zzaap[] zzb;

    public zzaid(List list) {
        this.zza = list;
        this.zzb = new zzaap[list.size()];
    }

    public final void zza(long j, zzef zzef) {
        zzyv.zza(j, zzef, this.zzb);
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
            String str2 = zzaf.zzb;
            if (str2 == null) {
                str2 = zzaio.zzb();
            }
            zzad zzad = new zzad();
            zzad.zzH(str2);
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
