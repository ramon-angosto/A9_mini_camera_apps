package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzbvk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class LiteSdkInfo extends zzci {
    public LiteSdkInfo(Context context) {
    }

    public zzbvk getAdapterCreator() {
        return new zzbvh();
    }

    public zzeh getLiteSdkVersion() {
        return new zzeh(ModuleDescriptor.MODULE_VERSION, 223104000, "21.3.0");
    }
}
