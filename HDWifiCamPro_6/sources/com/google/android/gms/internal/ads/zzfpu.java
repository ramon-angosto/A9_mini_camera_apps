package com.google.android.gms.internal.ads;

import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzfpu extends zzfpi {
    private zzftn<Integer> zza;
    private zzftn<Integer> zzb;
    private zzfpt zzc;
    private HttpURLConnection zzd;

    zzfpu() {
        this(zzfpr.zza, zzfps.zza, (zzfpt) null);
    }

    zzfpu(zzftn<Integer> zzftn, zzftn<Integer> zzftn2, zzfpt zzfpt) {
        this.zza = zzftn;
        this.zzb = zzftn2;
        this.zzc = zzfpt;
    }

    static /* synthetic */ Integer zzf() {
        return -1;
    }

    static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzfpj.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfpj.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfpt zzfpt = this.zzc;
        if (zzfpt != null) {
            this.zzd = (HttpURLConnection) zzfpt.zza();
            return this.zzd;
        }
        throw null;
    }

    public HttpURLConnection zzn(zzfpt zzfpt, int i, int i2) throws IOException {
        this.zza = new zzfpk(i);
        this.zzb = new zzfpl(i2);
        this.zzc = zzfpt;
        return zzm();
    }

    public HttpURLConnection zzo(Network network, URL url, int i, int i2) throws IOException {
        this.zza = new zzfpm(i);
        this.zzb = new zzfpn(i2);
        this.zzc = new zzfpo(network, url);
        return zzm();
    }

    public URLConnection zzr(URL url, int i) throws IOException {
        this.zza = new zzfpp(i);
        this.zzc = new zzfpq(url);
        return zzm();
    }
}
