package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbz;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfed {
    /* access modifiers changed from: private */
    public zzl zza;
    /* access modifiers changed from: private */
    public zzq zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public zzff zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public ArrayList zzf;
    /* access modifiers changed from: private */
    public ArrayList zzg;
    /* access modifiers changed from: private */
    public zzbls zzh;
    /* access modifiers changed from: private */
    public zzw zzi;
    /* access modifiers changed from: private */
    public AdManagerAdViewOptions zzj;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzk;
    /* access modifiers changed from: private */
    public zzbz zzl;
    /* access modifiers changed from: private */
    public int zzm = 1;
    /* access modifiers changed from: private */
    public zzbsc zzn;
    /* access modifiers changed from: private */
    public final zzfdq zzo = new zzfdq();
    /* access modifiers changed from: private */
    public boolean zzp = false;
    /* access modifiers changed from: private */
    public zzeof zzq;
    /* access modifiers changed from: private */
    public boolean zzr = false;
    /* access modifiers changed from: private */
    public zzcd zzs;

    public final zzfed zzA(zzbls zzbls) {
        this.zzh = zzbls;
        return this;
    }

    public final zzfed zzB(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfed zzC(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfed zzD(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzc();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzfed zzE(zzl zzl2) {
        this.zza = zzl2;
        return this;
    }

    public final zzfed zzF(zzff zzff) {
        this.zzd = zzff;
        return this;
    }

    public final zzfef zzG() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfef(this, (zzfee) null);
    }

    public final String zzI() {
        return this.zzc;
    }

    public final boolean zzO() {
        return this.zzp;
    }

    public final zzfed zzQ(zzcd zzcd) {
        this.zzs = zzcd;
        return this;
    }

    public final zzl zze() {
        return this.zza;
    }

    public final zzq zzg() {
        return this.zzb;
    }

    public final zzfdq zzo() {
        return this.zzo;
    }

    public final zzfed zzp(zzfef zzfef) {
        this.zzo.zza(zzfef.zzo.zza);
        this.zza = zzfef.zzd;
        this.zzb = zzfef.zze;
        this.zzs = zzfef.zzr;
        this.zzc = zzfef.zzf;
        this.zzd = zzfef.zza;
        this.zzf = zzfef.zzg;
        this.zzg = zzfef.zzh;
        this.zzh = zzfef.zzi;
        this.zzi = zzfef.zzj;
        zzq(zzfef.zzl);
        zzD(zzfef.zzm);
        this.zzp = zzfef.zzp;
        this.zzq = zzfef.zzc;
        this.zzr = zzfef.zzq;
        return this;
    }

    public final zzfed zzq(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfed zzr(zzq zzq2) {
        this.zzb = zzq2;
        return this;
    }

    public final zzfed zzs(String str) {
        this.zzc = str;
        return this;
    }

    public final zzfed zzt(zzw zzw) {
        this.zzi = zzw;
        return this;
    }

    public final zzfed zzu(zzeof zzeof) {
        this.zzq = zzeof;
        return this;
    }

    public final zzfed zzv(zzbsc zzbsc) {
        this.zzn = zzbsc;
        this.zzd = new zzff(false, true, false);
        return this;
    }

    public final zzfed zzw(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzfed zzx(boolean z) {
        this.zzr = true;
        return this;
    }

    public final zzfed zzy(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzfed zzz(int i) {
        this.zzm = i;
        return this;
    }
}
