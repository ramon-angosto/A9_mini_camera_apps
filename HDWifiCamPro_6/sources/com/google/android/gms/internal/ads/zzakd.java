package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzakd implements Comparable {
    /* access modifiers changed from: private */
    public final zzako zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzakh zzf;
    private Integer zzg;
    private zzakg zzh;
    private boolean zzi;
    private zzajm zzj;
    private zzakc zzk;
    private final zzajr zzl;

    public zzakd(int i, String str, zzakh zzakh) {
        Uri parse;
        String host;
        this.zza = zzako.zza ? new zzako() : null;
        this.zze = new Object();
        int i2 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzakh;
        this.zzl = new zzajr();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.zzd = i2;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzakd) obj).zzg.intValue();
    }

    public final String toString() {
        String hexString = Integer.toHexString(this.zzd);
        zzw();
        String str = this.zzc;
        Integer num = this.zzg;
        return "[ ] " + str + " " + "0x".concat(String.valueOf(hexString)) + " NORMAL " + num;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzajm zzd() {
        return this.zzj;
    }

    public final zzakd zze(zzajm zzajm) {
        this.zzj = zzajm;
        return this;
    }

    public final zzakd zzf(zzakg zzakg) {
        this.zzh = zzakg;
        return this;
    }

    public final zzakd zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzakj zzh(zzajz zzajz);

    public final String zzj() {
        String str = this.zzc;
        if (this.zzb == 0) {
            return str;
        }
        String num = Integer.toString(1);
        return num + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzajl {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzako.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzakm zzakm) {
        zzakh zzakh;
        synchronized (this.zze) {
            zzakh = this.zzf;
        }
        if (zzakh != null) {
            zzakh.zza(zzakm);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzo(Object obj);

    /* access modifiers changed from: package-private */
    public final void zzp(String str) {
        zzakg zzakg = this.zzh;
        if (zzakg != null) {
            zzakg.zzb(this);
        }
        if (zzako.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzakb(this, str, id));
                return;
            }
            this.zza.zza(str, id);
            this.zza.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzr() {
        zzakc zzakc;
        synchronized (this.zze) {
            zzakc = this.zzk;
        }
        if (zzakc != null) {
            zzakc.zza(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzs(zzakj zzakj) {
        zzakc zzakc;
        synchronized (this.zze) {
            zzakc = this.zzk;
        }
        if (zzakc != null) {
            zzakc.zzb(this, zzakj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzt(int i) {
        zzakg zzakg = this.zzh;
        if (zzakg != null) {
            zzakg.zzc(this, i);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzu(zzakc zzakc) {
        synchronized (this.zze) {
            this.zzk = zzakc;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzajl {
        return null;
    }

    public final zzajr zzy() {
        return this.zzl;
    }
}
