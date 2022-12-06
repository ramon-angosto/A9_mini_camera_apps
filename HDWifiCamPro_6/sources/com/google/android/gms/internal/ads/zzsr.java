package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzsr {
    public final int zza;
    public final zzsi zzb;
    private final CopyOnWriteArrayList zzc;

    public zzsr() {
        this(new CopyOnWriteArrayList(), 0, (zzsi) null, 0);
    }

    private zzsr(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzsi zzsi, long j) {
        this.zzc = copyOnWriteArrayList;
        this.zza = i;
        this.zzb = zzsi;
    }

    private static final long zzn(long j) {
        long zzz = zzen.zzz(j);
        return zzz == C.TIME_UNSET ? C.TIME_UNSET : zzz;
    }

    public final zzsr zza(int i, zzsi zzsi, long j) {
        return new zzsr(this.zzc, i, zzsi, 0);
    }

    public final void zzc(zzse zzse) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzsq zzsq = (zzsq) it.next();
            zzen.zzY(zzsq.zza, new zzsl(this, zzsq.zzb, zzse));
        }
    }

    public final void zzd(int i, zzaf zzaf, int i2, Object obj, long j) {
        zzc(new zzse(1, i, zzaf, 0, (Object) null, zzn(j), C.TIME_UNSET));
    }

    public final void zze(zzrz zzrz, zzse zzse) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzsq zzsq = (zzsq) it.next();
            zzen.zzY(zzsq.zza, new zzsm(this, zzsq.zzb, zzrz, zzse));
        }
    }

    public final void zzf(zzrz zzrz, int i, int i2, zzaf zzaf, int i3, Object obj, long j, long j2) {
        zzrz zzrz2 = zzrz;
        zze(zzrz, new zzse(1, -1, (zzaf) null, 0, (Object) null, zzn(j), zzn(j2)));
    }

    public final void zzg(zzrz zzrz, zzse zzse) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzsq zzsq = (zzsq) it.next();
            zzen.zzY(zzsq.zza, new zzsp(this, zzsq.zzb, zzrz, zzse));
        }
    }

    public final void zzh(zzrz zzrz, int i, int i2, zzaf zzaf, int i3, Object obj, long j, long j2) {
        zzrz zzrz2 = zzrz;
        zzg(zzrz, new zzse(1, -1, (zzaf) null, 0, (Object) null, zzn(j), zzn(j2)));
    }

    public final void zzi(zzrz zzrz, zzse zzse, IOException iOException, boolean z) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzsq zzsq = (zzsq) it.next();
            zzen.zzY(zzsq.zza, new zzsn(this, zzsq.zzb, zzrz, zzse, iOException, z));
        }
    }

    public final void zzj(zzrz zzrz, int i, int i2, zzaf zzaf, int i3, Object obj, long j, long j2, IOException iOException, boolean z) {
        zzrz zzrz2 = zzrz;
        zzi(zzrz, new zzse(1, -1, (zzaf) null, 0, (Object) null, zzn(j), zzn(j2)), iOException, z);
    }

    public final void zzk(zzrz zzrz, zzse zzse) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzsq zzsq = (zzsq) it.next();
            zzen.zzY(zzsq.zza, new zzso(this, zzsq.zzb, zzrz, zzse));
        }
    }

    public final void zzl(zzrz zzrz, int i, int i2, zzaf zzaf, int i3, Object obj, long j, long j2) {
        zzrz zzrz2 = zzrz;
        zzk(zzrz, new zzse(1, -1, (zzaf) null, 0, (Object) null, zzn(j), zzn(j2)));
    }

    public final void zzm(zzss zzss) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzsq zzsq = (zzsq) it.next();
            if (zzsq.zzb == zzss) {
                this.zzc.remove(zzsq);
            }
        }
    }

    public final void zzb(Handler handler, zzss zzss) {
        if (zzss != null) {
            this.zzc.add(new zzsq(handler, zzss));
            return;
        }
        throw null;
    }
}
