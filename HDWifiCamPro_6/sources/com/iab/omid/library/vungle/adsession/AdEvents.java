package com.iab.omid.library.vungle.adsession;

import com.iab.omid.library.vungle.adsession.media.VastProperties;
import com.iab.omid.library.vungle.d.e;

public final class AdEvents {
    private final a adSession;

    private AdEvents(a aVar) {
        this.adSession = aVar;
    }

    public static AdEvents createAdEvents(AdSession adSession2) {
        a aVar = (a) adSession2;
        e.a((Object) adSession2, "AdSession is null");
        e.d(aVar);
        e.b(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.getAdSessionStatePublisher().a(adEvents);
        return adEvents;
    }

    public void impressionOccurred() {
        e.b(this.adSession);
        e.f(this.adSession);
        if (!this.adSession.e()) {
            try {
                this.adSession.start();
            } catch (Exception unused) {
            }
        }
        if (this.adSession.e()) {
            this.adSession.b();
        }
    }

    public void loaded() {
        e.c(this.adSession);
        e.f(this.adSession);
        this.adSession.c();
    }

    public void loaded(VastProperties vastProperties) {
        e.a((Object) vastProperties, "VastProperties is null");
        e.c(this.adSession);
        e.f(this.adSession);
        this.adSession.a(vastProperties.a());
    }
}
