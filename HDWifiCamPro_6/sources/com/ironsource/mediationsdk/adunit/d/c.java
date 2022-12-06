package com.ironsource.mediationsdk.adunit.d;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdInteractionAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.ironsource.mediationsdk.adunit.d.a.b;
import com.ironsource.mediationsdk.model.a;

public final class c extends b<com.ironsource.mediationsdk.adunit.c.a.c> implements RewardedVideoAdListener {
    public c(a aVar, BaseAdInteractionAdapter<?, AdapterAdRewardListener> baseAdInteractionAdapter, com.ironsource.mediationsdk.adunit.c.a.c cVar) {
        super(aVar, baseAdInteractionAdapter, new a(aVar.c, aVar.c.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), cVar);
    }
}
