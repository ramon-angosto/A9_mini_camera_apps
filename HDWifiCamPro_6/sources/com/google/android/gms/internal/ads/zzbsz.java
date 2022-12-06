package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbsz implements zzbsr, zzbsp {
    private final zzcmp zza;

    public zzbsz(Context context, zzcgv zzcgv, zzape zzape, zza zza2) throws zzcna {
        zzt.zzz();
        this.zza = zzcnb.zza(context, zzcoe.zza(), "", false, false, (zzape) null, (zzbkb) null, zzcgv, (zzbjr) null, (zzl) null, (zza) null, zzbep.zza(), (zzfdk) null, (zzfdn) null);
        ((View) this.zza).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        zzaw.zzb();
        if (zzcgi.zzt()) {
            runnable.run();
        } else {
            zzs.zza.post(runnable);
        }
    }

    public final void zza(String str) {
        zzs(new zzbsu(this, str));
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbso.zzc(this, str, str2);
    }

    public final void zzc() {
        this.zza.destroy();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbso.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbso.zzb(this, str, jSONObject);
    }

    public final void zzf(String str) {
        zzs(new zzbsv(this, str));
    }

    public final void zzg(String str) {
        zzs(new zzbsx(this, str));
    }

    public final void zzh(String str) {
        zzs(new zzbsw(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final boolean zzi() {
        return this.zza.zzaB();
    }

    public final zzbty zzj() {
        return new zzbty(this);
    }

    public final void zzk(zzbtf zzbtf) {
        this.zza.zzP().zzF(new zzbss(zzbtf, (byte[]) null));
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbso.zzd(this, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(String str) {
        this.zza.zza(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        this.zza.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    public final void zzq(String str, zzbpu zzbpu) {
        this.zza.zzaf(str, new zzbsy(this, zzbpu));
    }

    public final void zzr(String str, zzbpu zzbpu) {
        this.zza.zzax(str, new zzbst(zzbpu));
    }
}
