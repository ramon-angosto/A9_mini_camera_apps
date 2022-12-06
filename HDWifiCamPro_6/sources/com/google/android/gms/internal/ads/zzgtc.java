package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgtc {
    private final ArrayDeque zza = new ArrayDeque();

    private zzgtc() {
    }

    static /* bridge */ /* synthetic */ zzgpw zza(zzgtc zzgtc, zzgpw zzgpw, zzgpw zzgpw2) {
        zzgtc.zzb(zzgpw);
        zzgtc.zzb(zzgpw2);
        zzgpw zzgpw3 = (zzgpw) zzgtc.zza.pop();
        while (!zzgtc.zza.isEmpty()) {
            zzgpw3 = new zzgtg((zzgpw) zzgtc.zza.pop(), zzgpw3);
        }
        return zzgpw3;
    }

    private final void zzb(zzgpw zzgpw) {
        if (zzgpw.zzh()) {
            int zzc = zzc(zzgpw.zzd());
            int zzc2 = zzgtg.zzc(zzc + 1);
            if (this.zza.isEmpty() || ((zzgpw) this.zza.peek()).zzd() >= zzc2) {
                this.zza.push(zzgpw);
                return;
            }
            int zzc3 = zzgtg.zzc(zzc);
            zzgpw zzgpw2 = (zzgpw) this.zza.pop();
            while (!this.zza.isEmpty() && ((zzgpw) this.zza.peek()).zzd() < zzc3) {
                zzgpw2 = new zzgtg((zzgpw) this.zza.pop(), zzgpw2);
            }
            zzgtg zzgtg = new zzgtg(zzgpw2, zzgpw);
            while (!this.zza.isEmpty() && ((zzgpw) this.zza.peek()).zzd() < zzgtg.zzc(zzc(zzgtg.zzd()) + 1)) {
                zzgtg = new zzgtg((zzgpw) this.zza.pop(), zzgtg);
            }
            this.zza.push(zzgtg);
        } else if (zzgpw instanceof zzgtg) {
            zzgtg zzgtg2 = (zzgtg) zzgpw;
            zzb(zzgtg2.zzd);
            zzb(zzgtg2.zze);
        } else {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzgpw.getClass()))));
        }
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzgtg.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzgtc(zzgtb zzgtb) {
    }
}
