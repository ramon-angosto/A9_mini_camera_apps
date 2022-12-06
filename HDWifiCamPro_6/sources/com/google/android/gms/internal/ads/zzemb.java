package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzemb implements zzehc {
    private final zzehe zza;
    private final zzehj zzb;
    private final zzfih zzc;
    private final zzfzq zzd;

    public zzemb(zzfih zzfih, zzfzq zzfzq, zzehe zzehe, zzehj zzehj) {
        this.zzc = zzfih;
        this.zzd = zzfzq;
        this.zzb = zzehj;
        this.zza = zzehe;
    }

    static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        zzehf zzehf;
        Iterator it = zzfdk.zzu.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzehf = null;
                break;
            }
            try {
                zzehf = this.zza.zza((String) it.next(), zzfdk.zzw);
                break;
            } catch (zzfek unused) {
            }
        }
        if (zzehf == null) {
            return zzfzg.zzh(new zzekd("Unable to instantiate mediation adapter class."));
        }
        zzchh zzchh = new zzchh();
        zzehf.zzc.zza(new zzema(this, zzehf, zzchh));
        if (zzfdk.zzN) {
            Bundle bundle = zzfdw.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfih zzfih = this.zzc;
        return zzfhr.zzd(new zzely(this, zzfdw, zzfdk, zzehf), this.zzd, zzfib.ADAPTER_LOAD_AD_SYN, zzfih).zzb(zzfib.ADAPTER_LOAD_AD_ACK).zzd(zzchh).zzb(zzfib.ADAPTER_WRAP_ADAPTER).zze(new zzelz(this, zzfdw, zzfdk, zzehf)).zza();
    }

    public final boolean zzb(zzfdw zzfdw, zzfdk zzfdk) {
        return !zzfdk.zzu.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf, Void voidR) throws Exception {
        return this.zzb.zza(zzfdw, zzfdk, zzehf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws Exception {
        this.zzb.zzb(zzfdw, zzfdk, zzehf);
    }
}
