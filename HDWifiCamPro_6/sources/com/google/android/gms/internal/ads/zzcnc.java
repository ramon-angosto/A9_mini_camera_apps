package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcnc implements Runnable {
    public final /* synthetic */ IObjectWrapper zza;

    public /* synthetic */ zzcnc(IObjectWrapper iObjectWrapper) {
        this.zza = iObjectWrapper;
    }

    public final void run() {
        IObjectWrapper iObjectWrapper = this.zza;
        zzt.zzA();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeg)).booleanValue() && zzfkp.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfkr) {
                ((zzfkr) unwrap).zzc();
            }
        }
    }
}
