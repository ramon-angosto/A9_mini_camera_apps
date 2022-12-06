package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzars implements PackageManager.OnChecksumsReadyListener {
    public final /* synthetic */ zzfzy zza;

    public /* synthetic */ zzars(zzfzy zzfzy) {
        this.zza = zzfzy;
    }

    public final void onChecksumsReady(List list) {
        zzfzy zzfzy = this.zza;
        if (list == null) {
            zzfzy.zzd((Object) null);
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                if (apkChecksum.getType() == 8) {
                    zzfzy.zzd(zzaqh.zzc(apkChecksum.getValue()));
                    return;
                }
            }
            zzfzy.zzd((Object) null);
        } catch (Throwable unused) {
            zzfzy.zzd((Object) null);
        }
    }
}
