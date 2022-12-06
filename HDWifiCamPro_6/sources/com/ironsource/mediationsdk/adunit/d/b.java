package com.ironsource.mediationsdk.adunit.d;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdInteractionAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;
import com.ironsource.mediationsdk.adunit.d.a.a;

public final class b extends a<com.ironsource.mediationsdk.adunit.c.a.a> implements InterstitialAdListener {
    public b(a aVar, BaseAdInteractionAdapter<?, AdapterAdInteractionListener> baseAdInteractionAdapter, com.ironsource.mediationsdk.adunit.c.a.a aVar2) {
        super(aVar, baseAdInteractionAdapter, new com.ironsource.mediationsdk.model.a(aVar.c, aVar.c.getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), aVar2);
    }
}
