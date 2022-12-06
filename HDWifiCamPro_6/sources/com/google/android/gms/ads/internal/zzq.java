package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzape;
import com.google.android.gms.internal.ads.zzcgp;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzq extends AsyncTask {
    final /* synthetic */ zzs zza;

    /* synthetic */ zzq(zzs zzs, zzp zzp) {
        this.zza = zzs;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzs zzs = this.zza;
        if (zzs.zzf != null && str != null) {
            zzs.zzf.loadUrl(str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzs zzs = this.zza;
            zzs.zzh = (zzape) zzs.zzc.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            zzcgp.zzk("", e);
        } catch (TimeoutException e2) {
            zzcgp.zzk("", e2);
        }
        return this.zza.zzp();
    }
}
