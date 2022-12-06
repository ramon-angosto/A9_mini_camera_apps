package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface MediationNativeAdapter extends MediationAdapter {
    void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2);
}
