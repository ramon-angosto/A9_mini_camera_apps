package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgxx extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzgxx(zzbka zzbka, byte[] bArr) {
        this.zza = new WeakReference(zzbka);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbka zzbka = (zzbka) this.zza.get();
        if (zzbka != null) {
            zzbka.zzc(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbka zzbka = (zzbka) this.zza.get();
        if (zzbka != null) {
            zzbka.zzd();
        }
    }
}
