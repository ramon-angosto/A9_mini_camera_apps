package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzay {
    public final Uri zza;
    public final String zzb = null;
    public final zzas zzc = null;
    public final zzai zzd = null;
    public final List zze;
    public final String zzf;
    public final zzfvn zzg;
    @Deprecated
    public final List zzh;
    public final Object zzi;

    /* synthetic */ zzay(Uri uri, String str, zzas zzas, zzai zzai, List list, String str2, zzfvn zzfvn, Object obj, zzax zzax) {
        this.zza = uri;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzfvn;
        zzfvk zzi2 = zzfvn.zzi();
        if (zzfvn.size() <= 0) {
            this.zzh = zzi2.zzg();
            this.zzi = null;
            return;
        }
        zzbe zzbe = (zzbe) zzfvn.get(0);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzay)) {
            return false;
        }
        zzay zzay = (zzay) obj;
        if (this.zza.equals(zzay.zza)) {
            String str = zzay.zzb;
            if (zzen.zzT((Object) null, (Object) null)) {
                zzas zzas = zzay.zzc;
                if (zzen.zzT((Object) null, (Object) null)) {
                    zzai zzai = zzay.zzd;
                    if (zzen.zzT((Object) null, (Object) null) && this.zze.equals(zzay.zze)) {
                        String str2 = zzay.zzf;
                        if (zzen.zzT((Object) null, (Object) null) && this.zzg.equals(zzay.zzg)) {
                            Object obj2 = zzay.zzi;
                            if (zzen.zzT((Object) null, (Object) null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() * 923521) + this.zze.hashCode()) * 961) + this.zzg.hashCode()) * 31;
    }
}
