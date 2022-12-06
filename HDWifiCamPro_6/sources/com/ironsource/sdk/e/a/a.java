package com.ironsource.sdk.e.a;

import android.text.TextUtils;
import com.iab.omid.library.ironsrc.Omid;
import com.iab.omid.library.ironsrc.adsession.AdSession;
import com.iab.omid.library.ironsrc.adsession.CreativeType;
import com.iab.omid.library.ironsrc.adsession.ImpressionType;
import com.iab.omid.library.ironsrc.adsession.Owner;
import com.iab.omid.library.ironsrc.adsession.Partner;
import com.ironsource.sdk.g.f;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

public final class a {
    public static final String a = Omid.getVersion();
    public final Partner b = Partner.createPartner("Ironsrc", "7");
    public final HashMap<String, AdSession> c = new HashMap<>();
    public boolean d = false;

    /* renamed from: com.ironsource.sdk.e.a.a$a  reason: collision with other inner class name */
    public static class C0094a {
        public boolean a;
        public Owner b;
        public Owner c;
        public String d;
        public ImpressionType e;
        public CreativeType f;
        public String g;
        private Owner h;

        public static C0094a a(JSONObject jSONObject) {
            C0094a aVar = new C0094a();
            aVar.a = jSONObject.optBoolean("isolateVerificationScripts", false);
            String optString = jSONObject.optString("impressionOwner", "");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    aVar.b = Owner.valueOf(optString.toUpperCase());
                    String optString2 = jSONObject.optString("videoEventsOwner", "");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            aVar.c = Owner.valueOf(optString2.toUpperCase());
                            aVar.d = jSONObject.optString("customReferenceData", "");
                            aVar.f = c(jSONObject);
                            aVar.e = b(jSONObject);
                            String optString3 = jSONObject.optString("adViewId", "");
                            if (!TextUtils.isEmpty(optString3)) {
                                aVar.g = optString3;
                                aVar.h = d(jSONObject);
                                return aVar;
                            }
                            throw new IllegalArgumentException("Missing adview id in OMID params" + optString3);
                        } catch (IllegalArgumentException unused) {
                            throw new IllegalArgumentException("Invalid OMID videoEventsOwner " + optString2);
                        }
                    } else {
                        throw new IllegalArgumentException("Missing OMID videoEventsOwner");
                    }
                } catch (IllegalArgumentException unused2) {
                    throw new IllegalArgumentException("Invalid OMID impressionOwner " + optString);
                }
            } else {
                throw new IllegalArgumentException("Missing OMID impressionOwner");
            }
        }

        private static ImpressionType b(JSONObject jSONObject) {
            String optString = jSONObject.optString("impressionType", "");
            if (!TextUtils.isEmpty(optString)) {
                for (ImpressionType impressionType : ImpressionType.values()) {
                    if (optString.equalsIgnoreCase(impressionType.toString())) {
                        return impressionType;
                    }
                }
                throw new IllegalArgumentException("Missing OMID creativeType" + optString);
            }
            throw new IllegalArgumentException("Missing OMID creativeType" + optString);
        }

        private static CreativeType c(JSONObject jSONObject) {
            String optString = jSONObject.optString("creativeType", "");
            if (!TextUtils.isEmpty(optString)) {
                for (CreativeType creativeType : CreativeType.values()) {
                    if (optString.equalsIgnoreCase(creativeType.toString())) {
                        return creativeType;
                    }
                }
                throw new IllegalArgumentException("Missing OMID creativeType" + optString);
            }
            throw new IllegalArgumentException("Missing OMID creativeType" + optString);
        }

        private static Owner d(JSONObject jSONObject) {
            try {
                return Owner.valueOf(jSONObject.optString("videoEventsOwner", "").toUpperCase());
            } catch (IllegalArgumentException unused) {
                return Owner.NONE;
            }
        }
    }

    public final f a() {
        f fVar = new f();
        fVar.a("omidVersion", SDKUtils.encodeString(a));
        fVar.a("omidPartnerName", SDKUtils.encodeString("Ironsrc"));
        fVar.a("omidPartnerVersion", SDKUtils.encodeString("7"));
        fVar.a("omidActiveAdSessions", SDKUtils.encodeString(Arrays.toString(this.c.keySet().toArray())));
        return fVar;
    }

    public void a(JSONObject jSONObject) {
        if (!this.d) {
            throw new IllegalStateException("OMID has not been activated");
        } else if (jSONObject == null) {
            throw new IllegalStateException("OMID Session has not started");
        }
    }
}
