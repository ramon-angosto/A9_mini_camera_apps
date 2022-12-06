package com.google.ads.mediation.vungle;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.vungle.mediation.VungleBannerAdapter;
import com.vungle.warren.VungleBanner;
import java.lang.ref.WeakReference;

public class VungleBannerAd {
    private final WeakReference<VungleBannerAdapter> adapter;
    private final String placementId;
    private VungleBanner vungleBanner;

    public VungleBannerAd(String str, VungleBannerAdapter vungleBannerAdapter) {
        this.placementId = str;
        this.adapter = new WeakReference<>(vungleBannerAdapter);
    }

    public VungleBannerAdapter getAdapter() {
        return (VungleBannerAdapter) this.adapter.get();
    }

    public void setVungleBanner(VungleBanner vungleBanner2) {
        this.vungleBanner = vungleBanner2;
    }

    public VungleBanner getVungleBanner() {
        return this.vungleBanner;
    }

    public void attach() {
        RelativeLayout adLayout;
        VungleBanner vungleBanner2;
        VungleBannerAdapter vungleBannerAdapter = (VungleBannerAdapter) this.adapter.get();
        if (vungleBannerAdapter != null && (adLayout = vungleBannerAdapter.getAdLayout()) != null && (vungleBanner2 = this.vungleBanner) != null && vungleBanner2.getParent() == null) {
            adLayout.addView(this.vungleBanner);
        }
    }

    public void detach() {
        VungleBanner vungleBanner2 = this.vungleBanner;
        if (vungleBanner2 != null && vungleBanner2.getParent() != null) {
            ((ViewGroup) this.vungleBanner.getParent()).removeView(this.vungleBanner);
        }
    }

    public void destroyAd() {
        if (this.vungleBanner != null) {
            String str = VungleMediationAdapter.TAG;
            Log.d(str, "Vungle banner adapter cleanUp: destroyAd # " + this.vungleBanner.hashCode());
            this.vungleBanner.destroyAd();
            this.vungleBanner = null;
        }
    }
}
