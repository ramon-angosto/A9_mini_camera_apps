package com.ironsource.mediationsdk.adunit.b;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

public final class h extends f {
    public h(d dVar) {
        super(dVar);
    }

    public final void a(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        a(b.LOAD_AD_NO_FILL, hashMap);
    }

    public final void a(long j, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        }
        a(b.LOAD_AD_FAILED, hashMap);
    }

    public final void a(long j, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        if (z) {
            hashMap.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.valueOf(z));
        }
        a(b.LOAD_AD_SUCCESS, hashMap);
    }

    public final void a(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.valueOf(z));
        }
        a(b.LOAD_AD, hashMap);
    }

    public final void a(boolean z, long j, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        if (z2) {
            hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS));
            hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, "loaded ads are expired");
        }
        a(z ? b.AD_AVAILABILITY_CHANGED_TRUE : b.AD_AVAILABILITY_CHANGED_FALSE, hashMap);
    }

    public final void b(long j, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        }
        a(b.LOAD_AD_FAILED_WITH_REASON, hashMap);
    }
}
