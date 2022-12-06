package com.ironsource.mediationsdk.adunit.b;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

public final class g extends f {
    public g(d dVar) {
        super(dVar);
    }

    public final void a() {
        a(b.INIT_STARTED);
    }

    public final void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j));
        a(b.INIT_ENDED, hashMap);
    }
}
