package com.ironsource.mediationsdk.adunit.d.a;

import com.ironsource.mediationsdk.H;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdInteractionAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.c.a.c;
import com.ironsource.mediationsdk.adunit.d.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.f;
import java.util.HashMap;

public class b<Listener extends c> extends a<Listener> implements AdapterAdRewardListener {
    private f g;

    public b(a aVar, BaseAdInteractionAdapter<?, AdapterAdRewardListener> baseAdInteractionAdapter, com.ironsource.mediationsdk.model.a aVar2, Listener listener) {
        super(aVar, baseAdInteractionAdapter, aVar2, listener);
    }

    public void onAdClosed() {
        this.g = new f();
        super.onAdClosed();
    }

    public void onAdOpened() {
        this.g = null;
        super.onAdOpened();
    }

    public void onAdRewarded() {
        if (this.e != null) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose(c("placement name = " + q()));
            if (this.c != null) {
                HashMap hashMap = new HashMap();
                if (H.a().n != null) {
                    for (String next : H.a().n.keySet()) {
                        hashMap.put("custom_" + next, H.a().n.get(next));
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                this.c.d.a(q(), this.e.getRewardName(), this.e.getRewardAmount(), currentTimeMillis, IronSourceUtils.getTransId(currentTimeMillis, k()), f.a(this.g), hashMap, H.a().m);
            }
            ((c) this.b).a(this, this.e);
            return;
        }
        IronLog.INTERNAL.verbose(c("placement is null "));
        if (this.c != null) {
            this.c.e.l("mCurrentPlacement is null");
        }
    }
}
