package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzb;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdux {
    private final zzdcy zza;
    private final zzdkl zzb;
    /* access modifiers changed from: private */
    public final zzdeh zzc;
    private final zzdeu zzd;
    private final zzdfg zze;
    private final zzdht zzf;
    private final Executor zzg;
    private final zzdki zzh;
    private final zzcvk zzi;
    private final zzb zzj;
    private final zzcdq zzk;
    private final zzape zzl;
    /* access modifiers changed from: private */
    public final zzdhk zzm;
    private final zzego zzn;
    private final zzfkm zzo;
    private final zzdxq zzp;
    private final zzfir zzq;

    public zzdux(zzdcy zzdcy, zzdeh zzdeh, zzdeu zzdeu, zzdfg zzdfg, zzdht zzdht, Executor executor, zzdki zzdki, zzcvk zzcvk, zzb zzb2, zzcdq zzcdq, zzape zzape, zzdhk zzdhk, zzego zzego, zzfkm zzfkm, zzdxq zzdxq, zzfir zzfir, zzdkl zzdkl) {
        this.zza = zzdcy;
        this.zzc = zzdeh;
        this.zzd = zzdeu;
        this.zze = zzdfg;
        this.zzf = zzdht;
        this.zzg = executor;
        this.zzh = zzdki;
        this.zzi = zzcvk;
        this.zzj = zzb2;
        this.zzk = zzcdq;
        this.zzl = zzape;
        this.zzm = zzdhk;
        this.zzn = zzego;
        this.zzo = zzfkm;
        this.zzp = zzdxq;
        this.zzq = zzfir;
        this.zzb = zzdkl;
    }

    public static final zzfzp zzj(zzcmp zzcmp, String str, String str2) {
        zzchh zzchh = new zzchh();
        zzcmp.zzP().zzz(new zzduv(zzchh));
        zzcmp.zzad(str, str2, (String) null);
        return zzchh;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzbD(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(View view) {
        this.zzj.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcmp zzcmp, zzcmp zzcmp2, Map map) {
        this.zzi.zzh(zzcmp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzh(View view, MotionEvent motionEvent) {
        this.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    public final void zzi(zzcmp zzcmp, boolean z, zzbpx zzbpx) {
        zzapa zzc2;
        zzcmp zzcmp2 = zzcmp;
        zzcoc zzP = zzcmp.zzP();
        zzduo zzduo = r4;
        zzduo zzduo2 = new zzduo(this);
        zzdeu zzdeu = this.zzd;
        zzdfg zzdfg = this.zze;
        zzdup zzdup = r7;
        zzdup zzdup2 = new zzdup(this);
        zzduq zzduq = r10;
        zzduq zzduq2 = new zzduq(this);
        zzb zzb2 = this.zzj;
        zzduw zzduw = r12;
        zzduw zzduw2 = new zzduw(this);
        zzP.zzL(zzduo, zzdeu, zzdfg, zzdup, zzduq, z, zzbpx, zzb2, zzduw, this.zzk, this.zzn, this.zzo, this.zzp, this.zzq, (zzbpv) null, this.zzb, (zzbqm) null, (zzbqg) null);
        zzcmp zzcmp3 = zzcmp;
        zzcmp3.setOnTouchListener(new zzdur(this));
        zzcmp3.setOnClickListener(new zzdus(this));
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzch)).booleanValue() && (zzc2 = this.zzl.zzc()) != null) {
            zzc2.zzn((View) zzcmp3);
        }
        this.zzh.zzj(zzcmp3, this.zzg);
        this.zzh.zzj(new zzdut(zzcmp3), this.zzg);
        this.zzh.zza((View) zzcmp3);
        zzcmp3.zzaf("/trackActiveViewUnit", new zzduu(this, zzcmp3));
        this.zzi.zzi(zzcmp3);
    }
}
