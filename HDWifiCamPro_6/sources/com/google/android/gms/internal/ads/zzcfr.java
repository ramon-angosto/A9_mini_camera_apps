package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcfr {
    /* access modifiers changed from: private */
    public final Clock zza;
    private final zzcgc zzb;
    private final LinkedList zzc;
    private final Object zzd = new Object();
    private final String zze;
    private final String zzf;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = 0;
    private long zzj = -1;
    private long zzk = -1;

    zzcfr(Clock clock, zzcgc zzcgc, String str, String str2) {
        this.zza = clock;
        this.zzb = zzcgc;
        this.zze = str;
        this.zzf = str2;
        this.zzc = new LinkedList();
    }

    public final Bundle zza() {
        Bundle bundle;
        synchronized (this.zzd) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zze);
            bundle.putString("slotid", this.zzf);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzj);
            bundle.putLong("tresponse", this.zzk);
            bundle.putLong("timp", this.zzg);
            bundle.putLong("tload", this.zzh);
            bundle.putLong("pcc", this.zzi);
            bundle.putLong("tfetch", -1);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzcfq) it.next()).zzb());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzc() {
        return this.zze;
    }

    public final void zzd() {
        synchronized (this.zzd) {
            if (this.zzk != -1) {
                zzcfq zzcfq = new zzcfq(this);
                zzcfq.zzd();
                this.zzc.add(zzcfq);
                this.zzi++;
                this.zzb.zzd();
                this.zzb.zzc(this);
            }
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            if (this.zzk != -1 && !this.zzc.isEmpty()) {
                zzcfq zzcfq = (zzcfq) this.zzc.getLast();
                if (zzcfq.zza() == -1) {
                    zzcfq.zzc();
                    this.zzb.zzc(this);
                }
            }
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            if (this.zzk != -1 && this.zzg == -1) {
                this.zzg = this.zza.elapsedRealtime();
                this.zzb.zzc(this);
            }
            this.zzb.zze();
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zzb.zzf();
        }
    }

    public final void zzh(boolean z) {
        synchronized (this.zzd) {
            if (this.zzk != -1) {
                this.zzh = this.zza.elapsedRealtime();
            }
        }
    }

    public final void zzi() {
        synchronized (this.zzd) {
            this.zzb.zzg();
        }
    }

    public final void zzj(zzl zzl) {
        synchronized (this.zzd) {
            long elapsedRealtime = this.zza.elapsedRealtime();
            this.zzj = elapsedRealtime;
            this.zzb.zzh(zzl, elapsedRealtime);
        }
    }

    public final void zzk(long j) {
        synchronized (this.zzd) {
            this.zzk = j;
            if (j != -1) {
                this.zzb.zzc(this);
            }
        }
    }
}
