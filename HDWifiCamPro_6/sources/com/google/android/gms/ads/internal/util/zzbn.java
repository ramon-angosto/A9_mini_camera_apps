package com.google.android.gms.ads.internal.util;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.internal.ads.zzajz;
import com.google.android.gms.internal.ads.zzakd;
import com.google.android.gms.internal.ads.zzakj;
import com.google.android.gms.internal.ads.zzala;
import com.google.android.gms.internal.ads.zzcgo;
import com.google.android.gms.internal.ads.zzchh;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbn extends zzakd {
    private final zzchh zza;
    private final zzcgo zzb = new zzcgo((String) null);

    public zzbn(String str, Map map, zzchh zzchh) {
        super(0, str, new zzbm(zzchh));
        this.zza = zzchh;
        this.zzb.zzd(str, ShareTarget.METHOD_GET, (Map) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzakj zzh(zzajz zzajz) {
        return zzakj.zzb(zzajz, zzala.zzb(zzajz));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzajz zzajz = (zzajz) obj;
        this.zzb.zzf(zzajz.zzc, zzajz.zza);
        zzcgo zzcgo = this.zzb;
        byte[] bArr = zzajz.zzb;
        if (zzcgo.zzl() && bArr != null) {
            zzcgo.zzh(bArr);
        }
        this.zza.zzd(zzajz);
    }
}
