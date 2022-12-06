package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbcs implements Comparator {
    zzbcs(zzbcu zzbcu) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbcy zzbcy = (zzbcy) obj;
        zzbcy zzbcy2 = (zzbcy) obj2;
        int i = zzbcy.zzc - zzbcy2.zzc;
        if (i != 0) {
            return i;
        }
        return (zzbcy.zza > zzbcy2.zza ? 1 : (zzbcy.zza == zzbcy2.zza ? 0 : -1));
    }
}
