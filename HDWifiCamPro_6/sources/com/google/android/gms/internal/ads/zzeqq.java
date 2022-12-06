package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeqq implements zzevd {
    public final /* synthetic */ ArrayList zza;

    public /* synthetic */ zzeqq(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zzf(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zza);
    }
}
