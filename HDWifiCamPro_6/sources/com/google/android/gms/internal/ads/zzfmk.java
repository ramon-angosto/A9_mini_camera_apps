package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfmk extends AsyncTask {
    private zzfml zza;
    protected final zzfmc zzd;

    public zzfmk(zzfmc zzfmc, byte[] bArr) {
        this.zzd = zzfmc;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public void onPostExecute(String str) {
        zzfml zzfml = this.zza;
        if (zzfml != null) {
            zzfml.zza(this);
        }
    }

    public final void zzb(zzfml zzfml) {
        this.zza = zzfml;
    }
}
