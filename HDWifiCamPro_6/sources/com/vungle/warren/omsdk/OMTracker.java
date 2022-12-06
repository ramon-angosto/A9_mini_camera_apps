package com.vungle.warren.omsdk;

import android.webkit.WebView;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.adsession.AdSession;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import com.iab.omid.library.vungle.adsession.Partner;
import com.vungle.warren.BuildConfig;
import java.util.concurrent.TimeUnit;

public class OMTracker implements WebViewObserver {
    static final long DESTROY_DELAY_MS = TimeUnit.SECONDS.toMillis(1);
    private AdSession adSession;
    private final boolean enabled;
    private boolean started;

    public static class Factory {
        public OMTracker make(boolean z) {
            return new OMTracker(z);
        }
    }

    private OMTracker(boolean z) {
        this.enabled = z;
    }

    public void start() {
        if (this.enabled && Omid.isActive()) {
            this.started = true;
        }
    }

    public long stop() {
        long j;
        AdSession adSession2;
        if (!this.started || (adSession2 = this.adSession) == null) {
            j = 0;
        } else {
            adSession2.finish();
            j = DESTROY_DELAY_MS;
        }
        this.started = false;
        this.adSession = null;
        return j;
    }

    public void onPageFinished(WebView webView) {
        if (this.started && this.adSession == null) {
            this.adSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.DEFINED_BY_JAVASCRIPT, ImpressionType.DEFINED_BY_JAVASCRIPT, Owner.JAVASCRIPT, Owner.JAVASCRIPT, false), AdSessionContext.createHtmlAdSessionContext(Partner.createPartner(BuildConfig.OMSDK_PARTNER_NAME, "6.12.0"), webView, (String) null, (String) null));
            this.adSession.registerAdView(webView);
            this.adSession.start();
        }
    }
}
