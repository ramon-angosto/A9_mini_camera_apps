package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzct {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    /* access modifiers changed from: private */
    public final zzfvn zzh;
    /* access modifiers changed from: private */
    public final zzfvn zzi;
    private final int zzj;
    private final int zzk;
    /* access modifiers changed from: private */
    public final zzfvn zzl;
    /* access modifiers changed from: private */
    public zzfvn zzm;
    /* access modifiers changed from: private */
    public int zzn;
    /* access modifiers changed from: private */
    public final HashMap zzo;
    /* access modifiers changed from: private */
    public final HashSet zzp;

    @Deprecated
    public zzct() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = zzfvn.zzo();
        this.zzi = zzfvn.zzo();
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzfvn.zzo();
        this.zzm = zzfvn.zzo();
        this.zzn = 0;
        this.zzo = new HashMap();
        this.zzp = new HashSet();
    }

    public final zzct zzd(Context context) {
        CaptioningManager captioningManager;
        if ((zzen.zza >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            this.zzn = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzm = zzfvn.zzp(zzen.zzN(locale));
            }
        }
        return this;
    }

    public zzct zze(int i, int i2, boolean z) {
        this.zze = i;
        this.zzf = i2;
        this.zzg = true;
        return this;
    }

    protected zzct(zzcu zzcu) {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = zzcu.zzl;
        this.zzf = zzcu.zzm;
        this.zzg = zzcu.zzn;
        this.zzh = zzcu.zzo;
        this.zzi = zzcu.zzq;
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzcu.zzu;
        this.zzm = zzcu.zzv;
        this.zzn = zzcu.zzw;
        this.zzp = new HashSet(zzcu.zzC);
        this.zzo = new HashMap(zzcu.zzB);
    }
}
