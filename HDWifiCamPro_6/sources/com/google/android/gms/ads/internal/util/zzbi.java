package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzajl;
import com.google.android.gms.internal.ads.zzakh;
import com.google.android.gms.internal.ads.zzaki;
import com.google.android.gms.internal.ads.zzali;
import com.google.android.gms.internal.ads.zzcgo;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbi extends zzali {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzcgo zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbi(zzbo zzbo, int i, String str, zzaki zzaki, zzakh zzakh, byte[] bArr, Map map, zzcgo zzcgo) {
        super(i, str, zzaki, zzakh);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzcgo;
    }

    public final Map zzl() throws zzajl {
        Map map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzo((String) obj);
    }

    public final byte[] zzx() throws zzajl {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public final void zzz(String str) {
        this.zzc.zzg(str);
        super.zzo(str);
    }
}
