package com.adcolony.sdk;

import android.content.Context;
import android.util.Log;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.Locale;
import org.json.JSONObject;

public class AdColonyAppOptions {
    public static final String ADMARVEL = "AdMarvel";
    public static final String ADMOB = "AdMob";
    public static final String ADOBEAIR = "Adobe AIR";
    public static final String AERSERVE = "AerServe";
    @Deprecated
    public static final int ALL = 2;
    public static final String APPODEAL = "Appodeal";
    public static final String CCPA = "CCPA";
    public static final String COCOS2DX = "Cocos2d-x";
    public static final String COPPA = "COPPA";
    public static final String CORONA = "Corona";
    public static final String FUSEPOWERED = "Fuse Powered";
    public static final String FYBER = "Fyber";
    public static final String GDPR = "GDPR";
    public static final String IRONSOURCE = "ironSource";
    @Deprecated
    public static final int LANDSCAPE = 1;
    public static final String MOPUB = "MoPub";
    @Deprecated
    public static final int PORTRAIT = 0;
    @Deprecated
    public static final int SENSOR = 2;
    public static final String UNITY = "Unity";
    private String a = "";
    private f1 b = new f1();
    private AdColonyUserMetadata c;

    public AdColonyAppOptions() {
        setOriginStore("google");
    }

    /* access modifiers changed from: package-private */
    public AdColonyAppOptions a(String str) {
        if (str == null) {
            return this;
        }
        this.a = str;
        c0.a(this.b, "app_id", str);
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 b() {
        return this.b;
    }

    public int getAppOrientation() {
        return c0.a(this.b, "app_orientation", -1);
    }

    public String getAppVersion() {
        return c0.h(this.b, "app_version");
    }

    @Deprecated
    public String getGDPRConsentString() {
        return c0.h(this.b, "consent_string");
    }

    @Deprecated
    public boolean getGDPRRequired() {
        return c0.b(this.b, "gdpr_required");
    }

    public boolean getIsChildDirectedApp() {
        return c0.b(this.b, "is_child_directed");
    }

    public boolean getKeepScreenOn() {
        return c0.b(this.b, "keep_screen_on");
    }

    public JSONObject getMediationInfo() {
        f1 b2 = c0.b();
        c0.a(b2, "name", c0.h(this.b, "mediation_network"));
        c0.a(b2, "version", c0.h(this.b, "mediation_network_version"));
        return b2.a();
    }

    public boolean getMultiWindowEnabled() {
        return c0.b(this.b, "multi_window_enabled");
    }

    public Object getOption(String str) {
        return c0.g(this.b, str);
    }

    public String getOriginStore() {
        return c0.h(this.b, "origin_store");
    }

    public JSONObject getPluginInfo() {
        f1 b2 = c0.b();
        c0.a(b2, "name", c0.h(this.b, "plugin"));
        c0.a(b2, "version", c0.h(this.b, "plugin_version"));
        return b2.a();
    }

    public String getPrivacyConsentString(String str) {
        f1 f1Var = this.b;
        return c0.h(f1Var, str.toLowerCase(Locale.ENGLISH) + "_consent_string");
    }

    public boolean getPrivacyFrameworkRequired(String str) {
        f1 f1Var = this.b;
        return c0.b(f1Var, str.toLowerCase(Locale.ENGLISH) + "_required");
    }

    @Deprecated
    public int getRequestedAdOrientation() {
        return c0.a(this.b, "orientation", -1);
    }

    public boolean getTestModeEnabled() {
        return c0.b(this.b, "test_mode");
    }

    public String getUserID() {
        return c0.h(this.b, ReportDBAdapter.ReportColumns.COLUMN_USER_ID);
    }

    @Deprecated
    public AdColonyUserMetadata getUserMetadata() {
        return this.c;
    }

    public boolean isPrivacyFrameworkRequiredSet(String str) {
        f1 f1Var = this.b;
        return f1Var.a(str.toLowerCase(Locale.ENGLISH) + "_required");
    }

    public AdColonyAppOptions setAppOrientation(int i) {
        setOption("app_orientation", (double) i);
        return this;
    }

    public AdColonyAppOptions setAppVersion(String str) {
        setOption("app_version", str);
        return this;
    }

    @Deprecated
    public AdColonyAppOptions setGDPRConsentString(String str) {
        c0.a(this.b, "consent_string", str);
        return this;
    }

    @Deprecated
    public AdColonyAppOptions setGDPRRequired(boolean z) {
        setOption("gdpr_required", z);
        return this;
    }

    public AdColonyAppOptions setIsChildDirectedApp(boolean z) {
        setOption("is_child_directed", z);
        return this;
    }

    public AdColonyAppOptions setKeepScreenOn(boolean z) {
        c0.b(this.b, "keep_screen_on", z);
        return this;
    }

    public AdColonyAppOptions setMediationNetwork(String str, String str2) {
        c0.a(this.b, "mediation_network", str);
        c0.a(this.b, "mediation_network_version", str2);
        return this;
    }

    public AdColonyAppOptions setMultiWindowEnabled(boolean z) {
        c0.b(this.b, "multi_window_enabled", z);
        return this;
    }

    public AdColonyAppOptions setOption(String str, boolean z) {
        c0.b(this.b, str, z);
        return this;
    }

    public AdColonyAppOptions setOriginStore(String str) {
        setOption("origin_store", str);
        return this;
    }

    public AdColonyAppOptions setPlugin(String str, String str2) {
        c0.a(this.b, "plugin", str);
        c0.a(this.b, "plugin_version", str2);
        return this;
    }

    public AdColonyAppOptions setPrivacyConsentString(String str, String str2) {
        f1 f1Var = this.b;
        c0.a(f1Var, str.toLowerCase(Locale.ENGLISH) + "_consent_string", str2);
        return this;
    }

    public AdColonyAppOptions setPrivacyFrameworkRequired(String str, boolean z) {
        setOption(str.toLowerCase(Locale.ENGLISH) + "_required", z);
        return this;
    }

    @Deprecated
    public AdColonyAppOptions setRequestedAdOrientation(int i) {
        setOption("orientation", (double) i);
        return this;
    }

    public AdColonyAppOptions setTestModeEnabled(boolean z) {
        c0.b(this.b, "test_mode", z);
        return this;
    }

    public AdColonyAppOptions setUserID(String str) {
        setOption(ReportDBAdapter.ReportColumns.COLUMN_USER_ID, str);
        return this;
    }

    @Deprecated
    public AdColonyAppOptions setUserMetadata(AdColonyUserMetadata adColonyUserMetadata) {
        this.c = adColonyUserMetadata;
        c0.a(this.b, "user_metadata", adColonyUserMetadata.b);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b(Context context) {
        a(context);
        Boolean g = this.b.g("use_forced_controller");
        if (g != null) {
            l.H = g.booleanValue();
        }
        if (this.b.f("use_staging_launch_server")) {
            k.Z = "https://adc3-launch-staging.adcolony.com/v4/launch";
        }
        String b2 = z0.b(context, "IABUSPrivacy_String");
        String b3 = z0.b(context, "IABTCF_TCString");
        int a2 = z0.a(context, "IABTCF_gdprApplies");
        if (b2 != null) {
            c0.a(this.b, "ccpa_consent_string", b2);
        }
        if (b3 != null) {
            c0.a(this.b, "gdpr_consent_string", b3);
        }
        boolean z = true;
        if (a2 == 0 || a2 == 1) {
            f1 f1Var = this.b;
            if (a2 != 1) {
                z = false;
            }
            c0.b(f1Var, "gdpr_required", z);
        }
    }

    public AdColonyAppOptions setOption(String str, double d) {
        c0.a(this.b, str, d);
        return this;
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.a;
    }

    public AdColonyAppOptions setOption(String str, String str2) {
        c0.a(this.b, str, str2);
        return this;
    }

    private void a(Context context) {
        setOption("bundle_id", z0.d(context));
    }

    public static AdColonyAppOptions getMoPubAppOptions(String str) {
        AdColonyAppOptions mediationNetwork = new AdColonyAppOptions().setMediationNetwork("MoPub", "unknown");
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String[] split2 = split[i].split(":");
                if (split2.length == 2) {
                    String str2 = split2[0];
                    str2.hashCode();
                    if (str2.equals("store")) {
                        mediationNetwork.setOriginStore(split2[1]);
                    } else if (!str2.equals("version")) {
                        Log.e("AdColonyMoPub", "AdColony client options in wrong format - please check your MoPub dashboard");
                        return mediationNetwork;
                    } else {
                        mediationNetwork.setAppVersion(split2[1]);
                    }
                    i++;
                } else {
                    Log.e("AdColonyMoPub", "AdColony client options not recognized - please check your MoPub dashboard");
                    return null;
                }
            }
        }
        return mediationNetwork;
    }
}
