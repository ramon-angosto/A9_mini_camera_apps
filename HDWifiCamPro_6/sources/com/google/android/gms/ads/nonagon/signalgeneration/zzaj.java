package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.internal.ads.zzcbc;
import com.google.android.gms.internal.ads.zzfyn;
import com.google.android.gms.internal.ads.zzfzg;
import com.google.android.gms.internal.ads.zzfzp;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzaj implements zzfyn {
    public final /* synthetic */ zzcbc zza;

    public /* synthetic */ zzaj(zzcbc zzcbc) {
        this.zza = zzcbc;
    }

    public final zzfzp zza(Object obj) {
        zzcbc zzcbc = this.zza;
        zzam zzam = new zzam(new JsonReader(new InputStreamReader((InputStream) obj)));
        try {
            zzam.zzb = zzaw.zzb().zzh(zzcbc.zza).toString();
        } catch (JSONException unused) {
            zzam.zzb = "{}";
        }
        return zzfzg.zzi(zzam);
    }
}
