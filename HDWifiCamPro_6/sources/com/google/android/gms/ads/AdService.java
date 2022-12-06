package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class AdService extends IntentService {
    public AdService() {
        super("AdService");
    }

    /* access modifiers changed from: protected */
    public final void onHandleIntent(Intent intent) {
        try {
            zzaw.zza().zzl(this, new zzbvh()).zze(intent);
        } catch (RemoteException e) {
            zzcgp.zzg("RemoteException calling handleNotificationIntent: ".concat(e.toString()));
        }
    }
}
