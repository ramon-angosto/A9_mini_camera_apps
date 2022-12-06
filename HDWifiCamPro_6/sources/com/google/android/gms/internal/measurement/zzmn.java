package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzmn extends zzml {
    zzmn() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zza(Object obj) {
        return ((zzmm) obj).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzmm) obj).zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        return ((zzkc) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzd(Object obj, Object obj2) {
        zzmm zzmm = (zzmm) obj2;
        if (zzmm.equals(zzmm.zzc())) {
            return obj;
        }
        return zzmm.zzd((zzmm) obj, zzmm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zze() {
        return zzmm.zze();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zzmm) obj).zzh(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Object obj) {
        ((zzkc) obj).zzc.zzf();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzkc) obj).zzc = (zzmm) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Object obj, zznd zznd) throws IOException {
        ((zzmm) obj).zzi(zznd);
    }
}
