package com.adcolony.sdk;

import android.util.Log;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.adcolony.sdk.e0;
import com.iab.omid.library.adcolony.adsession.AdEvents;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.AdSessionConfiguration;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.CreativeType;
import com.iab.omid.library.adcolony.adsession.ErrorType;
import com.iab.omid.library.adcolony.adsession.ImpressionType;
import com.iab.omid.library.adcolony.adsession.Owner;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.adsession.media.InteractionType;
import com.iab.omid.library.adcolony.adsession.media.MediaEvents;
import com.iab.omid.library.adcolony.adsession.media.Position;
import com.iab.omid.library.adcolony.adsession.media.VastProperties;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class p0 {
    private AdSession a;
    private AdEvents b;
    private MediaEvents c;
    private List<VerificationScriptResource> d = new ArrayList();
    /* access modifiers changed from: private */
    public int e = -1;
    /* access modifiers changed from: private */
    public String f = "";
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    private int l;
    private int m;
    private String n = "";
    /* access modifiers changed from: private */
    public String o = "";

    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void run() {
            f1 b2 = c0.b();
            f1 b3 = c0.b();
            c0.b(b3, "session_type", p0.this.e);
            c0.a(b3, "session_id", p0.this.f);
            c0.a(b3, NotificationCompat.CATEGORY_EVENT, this.a);
            c0.a(b2, "type", "iab_hook");
            c0.a(b2, "message", b3.toString());
            new h0("CustomMessage.controller_send", 0, b2).c();
        }
    }

    class b implements AdColonyCustomMessageListener {

        class a implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ float c;

            a(String str, String str2, float f) {
                this.a = str;
                this.b = str2;
                this.c = f;
            }

            public void run() {
                if (this.a.equals(p0.this.o)) {
                    p0.this.a(this.b, this.c);
                    return;
                }
                AdColonyAdView adColonyAdView = a.b().c().d().get(this.a);
                p0 omidManager = adColonyAdView != null ? adColonyAdView.getOmidManager() : null;
                if (omidManager != null) {
                    omidManager.a(this.b, this.c);
                }
            }
        }

        b() {
        }

        public void onAdColonyCustomMessage(AdColonyCustomMessage adColonyCustomMessage) {
            f1 b = c0.b(adColonyCustomMessage.getMessage());
            String h = c0.h(b, "event_type");
            float floatValue = BigDecimal.valueOf(c0.c(b, IronSourceConstants.EVENTS_DURATION)).floatValue();
            boolean b2 = c0.b(b, "replay");
            boolean equals = c0.h(b, "skip_type").equals("dec");
            String h2 = c0.h(b, "asi");
            if (h.equals("skip") && equals) {
                boolean unused = p0.this.k = true;
            } else if (!b2 || (!h.equals("start") && !h.equals(CampaignEx.JSON_NATIVE_VIDEO_FIRST_QUARTILE) && !h.equals(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT) && !h.equals(CampaignEx.JSON_NATIVE_VIDEO_THIRD_QUARTILE) && !h.equals(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE))) {
                z0.b((Runnable) new a(h2, h, floatValue));
            }
        }
    }

    p0(f1 f1Var, String str) {
        VerificationScriptResource verificationScriptResource;
        this.e = a(f1Var);
        this.j = c0.b(f1Var, "skippable");
        this.l = c0.d(f1Var, "skip_offset");
        this.m = c0.d(f1Var, "video_duration");
        e1 a2 = c0.a(f1Var, "js_resources");
        e1 a3 = c0.a(f1Var, "verification_params");
        e1 a4 = c0.a(f1Var, "vendor_keys");
        this.o = str;
        for (int i2 = 0; i2 < a2.b(); i2++) {
            try {
                String b2 = c0.b(a3, i2);
                String b3 = c0.b(a4, i2);
                URL url = new URL(c0.b(a2, i2));
                if (b2.equals("") || b3.equals("")) {
                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                } else {
                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(b3, url, b2);
                }
                this.d.add(verificationScriptResource);
            } catch (MalformedURLException unused) {
                new e0.a().a("Invalid js resource url passed to Omid").a(e0.i);
            }
        }
        try {
            this.n = a.b().p().a(c0.h(f1Var, "filepath"), true).toString();
        } catch (IOException unused2) {
            new e0.a().a("Error loading IAB JS Client").a(e0.i);
        }
    }

    private void e() {
        AdColony.addCustomMessageListener(new b(), "viewability_ad_event");
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.h = true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        AdColony.removeCustomMessageListener("viewability_ad_event");
        this.a.finish();
        b("end_session");
        this.a = null;
    }

    /* access modifiers changed from: package-private */
    public AdSession c() {
        return this.a;
    }

    private int a(f1 f1Var) {
        if (this.e == -1) {
            int d2 = c0.d(f1Var, "ad_unit_type");
            String h2 = c0.h(f1Var, "ad_type");
            if (d2 == 0) {
                return 0;
            }
            if (d2 == 1) {
                if (h2.equals("video")) {
                    return 0;
                }
                if (h2.equals("display")) {
                    return 1;
                }
                if (h2.equals("banner_display") || h2.equals("interstitial_display")) {
                    return 2;
                }
            }
        }
        return this.e;
    }

    private void b(String str) {
        if (!z0.a((Runnable) new a(str))) {
            new e0.a().a("Executing ADCOmidManager.sendIabCustomMessage failed").a(e0.i);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        MediaEvents mediaEvents;
        VastProperties vastProperties;
        if (!this.i && this.e >= 0 && this.a != null) {
            b(cVar);
            e();
            if (this.e != 0) {
                mediaEvents = null;
            } else {
                mediaEvents = MediaEvents.createMediaEvents(this.a);
            }
            this.c = mediaEvents;
            try {
                this.a.start();
                this.b = AdEvents.createAdEvents(this.a);
                b("start_session");
                if (this.c != null) {
                    Position position = Position.PREROLL;
                    if (this.j) {
                        vastProperties = VastProperties.createVastPropertiesForSkippableMedia((float) this.l, true, position);
                    } else {
                        vastProperties = VastProperties.createVastPropertiesForNonSkippableMedia(true, position);
                    }
                    this.b.loaded(vastProperties);
                } else {
                    this.b.loaded();
                }
                this.i = true;
            } catch (NullPointerException e2) {
                AdSession adSession = this.a;
                ErrorType errorType = ErrorType.GENERIC;
                adSession.error(errorType, "Exception occurred on AdSession.start: " + Log.getStackTraceString(e2));
                b();
                e0.a a2 = new e0.a().a("Exception in ADCOmidManager on AdSession.start: ").a(Log.getStackTraceString(e2));
                a2.a(" Ad with adSessionId: " + this.o + ".").a(e0.i);
            }
        }
    }

    private void b(c cVar) {
        b("register_ad_view");
        b1 b1Var = a.b().B().get(Integer.valueOf(cVar.k()));
        if (b1Var == null && !cVar.n().isEmpty()) {
            b1Var = (b1) cVar.n().entrySet().iterator().next().getValue();
        }
        AdSession adSession = this.a;
        if (adSession != null && b1Var != null) {
            adSession.registerAdView(b1Var);
            if (b1Var instanceof l0) {
                ((l0) b1Var).p();
            }
        } else if (adSession != null) {
            adSession.registerAdView(cVar);
            cVar.a(this.a);
            b("register_obstructions");
        }
    }

    /* access modifiers changed from: package-private */
    public void a() throws IllegalArgumentException {
        a((WebView) null);
    }

    /* access modifiers changed from: package-private */
    public void a(WebView webView) throws IllegalArgumentException {
        String str;
        List<VerificationScriptResource> list;
        if (this.e >= 0 && (str = this.n) != null && !str.equals("") && (list = this.d) != null) {
            if (!list.isEmpty() || d() == 2) {
                k b2 = a.b();
                Owner owner = Owner.NATIVE;
                ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
                int d2 = d();
                if (d2 == 0) {
                    CreativeType creativeType = CreativeType.VIDEO;
                    AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false), AdSessionContext.createNativeAdSessionContext(b2.t(), this.n, this.d, (String) null, (String) null));
                    this.a = createAdSession;
                    this.f = createAdSession.getAdSessionId();
                    b("inject_javascript");
                } else if (d2 == 1) {
                    CreativeType creativeType2 = CreativeType.NATIVE_DISPLAY;
                    AdSession createAdSession2 = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType2, impressionType, owner, (Owner) null, false), AdSessionContext.createNativeAdSessionContext(b2.t(), this.n, this.d, (String) null, (String) null));
                    this.a = createAdSession2;
                    this.f = createAdSession2.getAdSessionId();
                    b("inject_javascript");
                } else if (d2 == 2) {
                    CreativeType creativeType3 = CreativeType.HTML_DISPLAY;
                    AdSession createAdSession3 = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType3, impressionType, owner, (Owner) null, false), AdSessionContext.createHtmlAdSessionContext(b2.t(), webView, "", (String) null));
                    this.a = createAdSession3;
                    this.f = createAdSession3.getAdSessionId();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        a(str, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, float f2) {
        if (a.c() && this.a != null) {
            if (this.c != null || str.equals("start") || str.equals("skip") || str.equals("continue") || str.equals("cancel")) {
                char c2 = 65535;
                try {
                    switch (str.hashCode()) {
                        case -1941887438:
                            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_FIRST_QUARTILE)) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -1710060637:
                            if (str.equals("buffer_start")) {
                                c2 = 12;
                                break;
                            }
                            break;
                        case -1638835128:
                            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT)) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case -1367724422:
                            if (str.equals("cancel")) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case -934426579:
                            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_RESUME)) {
                                c2 = 11;
                                break;
                            }
                            break;
                        case -651914917:
                            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_THIRD_QUARTILE)) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -599445191:
                            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case -567202649:
                            if (str.equals("continue")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case -342650039:
                            if (str.equals("sound_mute")) {
                                c2 = 8;
                                break;
                            }
                            break;
                        case 3532159:
                            if (str.equals("skip")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 106440182:
                            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_PAUSE)) {
                                c2 = 10;
                                break;
                            }
                            break;
                        case 109757538:
                            if (str.equals("start")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 583742045:
                            if (str.equals("in_video_engagement")) {
                                c2 = 14;
                                break;
                            }
                            break;
                        case 823102269:
                            if (str.equals("html5_interaction")) {
                                c2 = 15;
                                break;
                            }
                            break;
                        case 1648173410:
                            if (str.equals("sound_unmute")) {
                                c2 = 9;
                                break;
                            }
                            break;
                        case 1906584668:
                            if (str.equals("buffer_end")) {
                                c2 = 13;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            this.b.impressionOccurred();
                            MediaEvents mediaEvents = this.c;
                            if (mediaEvents != null) {
                                if (f2 <= 0.0f) {
                                    f2 = (float) this.m;
                                }
                                mediaEvents.start(f2, 1.0f);
                            }
                            b(str);
                            return;
                        case 1:
                            this.c.firstQuartile();
                            b(str);
                            return;
                        case 2:
                            this.c.midpoint();
                            b(str);
                            return;
                        case 3:
                            this.c.thirdQuartile();
                            b(str);
                            return;
                        case 4:
                            this.k = true;
                            this.c.complete();
                            b(str);
                            return;
                        case 5:
                            b(str);
                            b();
                            return;
                        case 6:
                        case 7:
                            MediaEvents mediaEvents2 = this.c;
                            if (mediaEvents2 != null) {
                                mediaEvents2.skipped();
                            }
                            b(str);
                            b();
                            return;
                        case 8:
                            this.c.volumeChange(0.0f);
                            b(str);
                            return;
                        case 9:
                            this.c.volumeChange(1.0f);
                            b(str);
                            return;
                        case 10:
                            if (!this.g && !this.h && !this.k) {
                                this.c.pause();
                                b(str);
                                this.g = true;
                                this.h = false;
                                return;
                            }
                            return;
                        case 11:
                            if (this.g && !this.k) {
                                this.c.resume();
                                b(str);
                                this.g = false;
                                return;
                            }
                            return;
                        case 12:
                            this.c.bufferStart();
                            b(str);
                            return;
                        case 13:
                            this.c.bufferFinish();
                            b(str);
                            return;
                        case 14:
                        case 15:
                            this.c.adUserInteraction(InteractionType.CLICK);
                            b(str);
                            if (this.h && !this.g && !this.k) {
                                this.c.pause();
                                b(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
                                this.g = true;
                                this.h = false;
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (IllegalArgumentException | IllegalStateException e2) {
                    new e0.a().a("Recording IAB event for ").a(str).a(" caused " + e2.getClass()).a(e0.g);
                }
            }
        }
    }
}
