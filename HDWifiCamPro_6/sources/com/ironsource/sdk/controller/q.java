package com.ironsource.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.iab.omid.library.ironsrc.Omid;
import com.iab.omid.library.ironsrc.adsession.AdEvents;
import com.iab.omid.library.ironsrc.adsession.AdSession;
import com.iab.omid.library.ironsrc.adsession.AdSessionConfiguration;
import com.iab.omid.library.ironsrc.adsession.AdSessionContext;
import com.ironsource.sdk.c.d;
import com.ironsource.sdk.c.e;
import com.ironsource.sdk.controller.x;
import com.ironsource.sdk.e.a.a;
import com.ironsource.sdk.g.f;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONObject;

public class q {
    private static final String a = q.class.getSimpleName();
    private final Context b;
    private final com.ironsource.sdk.e.a.a c = new com.ironsource.sdk.e.a.a();

    static class a {
        String a;
        JSONObject b;
        String c;
        String d;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public q(Context context) {
        this.b = context;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, x.d.a aVar) {
        com.ironsource.sdk.e.a.a aVar2;
        JSONObject jSONObject = new JSONObject(str);
        a aVar3 = new a((byte) 0);
        aVar3.a = jSONObject.optString("omidFunction");
        aVar3.b = jSONObject.optJSONObject("omidParams");
        aVar3.c = jSONObject.optString("success");
        aVar3.d = jSONObject.optString("fail");
        f fVar = new f();
        if (aVar3.b != null) {
            String optString = aVar3.b.optString("adViewId", "");
            if (!TextUtils.isEmpty(optString)) {
                fVar.a("adViewId", optString);
            }
        }
        try {
            String str2 = aVar3.a;
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1655974669:
                    if (str2.equals("activate")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -984459207:
                    if (str2.equals("getOmidData")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 70701699:
                    if (str2.equals("finishSession")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1208109646:
                    if (str2.equals("impressionOccurred")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1850541012:
                    if (str2.equals("startSession")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    com.ironsource.sdk.e.a.a aVar4 = this.c;
                    a.C0094a a2 = a.C0094a.a(aVar3.b);
                    if (!aVar4.d) {
                        throw new IllegalStateException("OMID has not been activated");
                    } else if (!TextUtils.isEmpty(a2.g)) {
                        String str3 = a2.g;
                        if (!aVar4.c.containsKey(str3)) {
                            e a3 = d.a().a(str3);
                            if (a3 != null) {
                                AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(a2.f, a2.e, a2.b, a2.c, a2.a), AdSessionContext.createHtmlAdSessionContext(aVar4.b, a3.b(), (String) null, a2.d));
                                createAdSession.registerAdView(a3.b());
                                createAdSession.start();
                                aVar4.c.put(str3, createAdSession);
                            } else {
                                throw new IllegalStateException("No adview found with the provided adViewId");
                            }
                        } else {
                            throw new IllegalStateException("OMID Session has already started");
                        }
                    } else {
                        throw new IllegalStateException("Missing adview id in OMID params");
                    }
                } else if (c2 == 2) {
                    com.ironsource.sdk.e.a.a aVar5 = this.c;
                    JSONObject jSONObject2 = aVar3.b;
                    aVar5.a(jSONObject2);
                    String optString2 = jSONObject2.optString("adViewId");
                    AdSession adSession = aVar5.c.get(optString2);
                    if (adSession != null) {
                        adSession.finish();
                        aVar5.c.remove(optString2);
                    } else {
                        throw new IllegalStateException("OMID Session has not started");
                    }
                } else if (c2 == 3) {
                    com.ironsource.sdk.e.a.a aVar6 = this.c;
                    JSONObject jSONObject3 = aVar3.b;
                    aVar6.a(jSONObject3);
                    AdSession adSession2 = aVar6.c.get(jSONObject3.optString("adViewId"));
                    if (adSession2 != null) {
                        AdEvents createAdEvents = AdEvents.createAdEvents(adSession2);
                        if (jSONObject3.optBoolean("signalLoaded")) {
                            createAdEvents.loaded();
                        }
                        createAdEvents.impressionOccurred();
                    } else {
                        throw new IllegalStateException("OMID Session has not started");
                    }
                } else if (c2 == 4) {
                    aVar2 = this.c;
                } else {
                    throw new IllegalArgumentException(String.format("%s | unsupported OMID API", new Object[]{aVar3.a}));
                }
                aVar.a(true, aVar3.c, fVar);
            }
            com.ironsource.sdk.e.a.a aVar7 = this.c;
            Context context = this.b;
            if (!aVar7.d) {
                Omid.activate(context);
                aVar7.d = true;
            }
            aVar2 = this.c;
            fVar = aVar2.a();
            aVar.a(true, aVar3.c, fVar);
        } catch (Exception e) {
            fVar.a("errMsg", e.getMessage());
            Logger.i(a, "OMIDJSAdapter " + aVar3.a + " Exception: " + e.getMessage());
            aVar.a(false, aVar3.d, fVar);
        }
    }
}
