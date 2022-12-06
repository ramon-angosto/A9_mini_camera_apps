package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzezy implements zzfyn {
    public final /* synthetic */ zzfaa zza;
    public final /* synthetic */ zzffz zzb;
    public final /* synthetic */ zzdah zzc;

    public /* synthetic */ zzezy(zzfaa zzfaa, zzffz zzffz, zzdah zzdah) {
        this.zza = zzfaa;
        this.zzb = zzffz;
        this.zzc = zzdah;
    }

    public final zzfzp zza(Object obj) {
        zzffz zzffz = this.zzb;
        zzdah zzdah = this.zzc;
        zzfdw zzfdw = (zzfdw) obj;
        zzffz.zzb = zzfdw;
        Iterator it = zzfdw.zzb.zza.iterator();
        boolean z = false;
        loop0:
        while (true) {
            if (it.hasNext()) {
                Iterator it2 = ((zzfdk) it.next()).zza.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z = true;
                    }
                }
            } else if (z) {
                return zzdah.zzh(zzfzg.zzi(zzfdw));
            }
        }
        return zzfzg.zzi((Object) null);
    }
}
