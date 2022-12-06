package com.ironsource.mediationsdk.server;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.environment.a;
import com.ironsource.environment.c;
import com.ironsource.environment.d.b;
import com.ironsource.environment.h;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.g;
import com.ironsource.mediationsdk.utils.k;
import com.mbridge.msdk.MBridgeConstans;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public class ServerURL {
    private static final String AMPERSAND = "&";
    private static final String ANDROID = "android";
    private static final String APPLICATION_KEY = "applicationKey";
    private static final String APPLICATION_USER_ID = "applicationUserId";
    private static final String APPLICATION_VERSION = "appVer";
    private static final String AUID = "auid";
    private static String BASE_URL_PREFIX = "https://init.supersonicads.com/sdk/v";
    private static String BASE_URL_SUFFIX = "?request=";
    private static final String BROWSER_USER_AGENT = "browserUserAgent";
    private static final String BUNDLE_ID = "bundleId";
    private static final String CONNECTION_TYPE = "connType";
    private static final String COPPA = "coppa";
    private static final String DEVICE_LANG = "deviceLang";
    private static final String DEVICE_MAKE = "devMake";
    private static final String DEVICE_MODEL = "devModel";
    private static final String EQUAL = "=";
    private static final String FIRST_SESSION = "fs";
    private static final String GAID = "advId";
    private static final String IMPRESSION = "impression";
    private static final String ISO_COUNTRY_CODE = "icc";
    private static final String MEDIATION_TYPE = "mt";
    private static final String MOBILE_CARRIER = "mCar";
    private static final String MOBILE_COUNTRY_CODE = "mcc";
    private static final String MOBILE_NETWORK_CODE = "mnc";
    private static final String OS_VERSION = "osVer";
    private static final String PLACEMENT = "placementId";
    private static final String PLATFORM_KEY = "platform";
    private static final String PLUGIN_FW_VERSION = "plugin_fw_v";
    private static final String PLUGIN_TYPE = "pluginType";
    private static final String PLUGIN_VERSION = "pluginVersion";
    private static final String REWARDED_VIDEO_MANUAL_MODE = "rvManual";
    private static final String SDK_VERSION = "sdkVersion";
    private static final String SERR = "serr";
    private static final String TIME_ZONE_ID = "tz";
    private static final String TIME_ZONE_OFFSET = "tzOff";

    private static String createURLParams(Vector<Pair<String, String>> vector) {
        Iterator<Pair<String, String>> it = vector.iterator();
        String str = "";
        while (it.hasNext()) {
            Pair next = it.next();
            if (str.length() > 0) {
                str = str + AMPERSAND;
            }
            str = str + ((String) next.first) + EQUAL + URLEncoder.encode((String) next.second, "UTF-8");
        }
        return str;
    }

    private static String getBaseUrl(String str) {
        return BASE_URL_PREFIX + str + BASE_URL_SUFFIX;
    }

    public static String getCPVProvidersURL(Context context, String str, String str2, String str3, String str4, boolean z, Vector<Pair<String, String>> vector) {
        Vector vector2 = new Vector();
        vector2.add(new Pair(PLATFORM_KEY, ANDROID));
        vector2.add(new Pair(APPLICATION_KEY, str));
        vector2.add(new Pair(APPLICATION_USER_ID, str2));
        vector2.add(new Pair(SDK_VERSION, IronSourceUtils.getSDKVersion()));
        if (z) {
            vector2.add(new Pair(REWARDED_VIDEO_MANUAL_MODE, z ? "1" : MBridgeConstans.ENDCARD_URL_TYPE_PL));
        }
        if (IronSourceUtils.getSerr() == 0) {
            vector2.add(new Pair(SERR, String.valueOf(IronSourceUtils.getSerr())));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginType())) {
            vector2.add(new Pair(PLUGIN_TYPE, ConfigFile.getConfigFile().getPluginType()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginVersion())) {
            vector2.add(new Pair(PLUGIN_VERSION, ConfigFile.getConfigFile().getPluginVersion()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginFrameworkVersion())) {
            vector2.add(new Pair(PLUGIN_FW_VERSION, ConfigFile.getConfigFile().getPluginFrameworkVersion()));
        }
        if (!TextUtils.isEmpty(str3)) {
            vector2.add(new Pair(GAID, str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            vector2.add(new Pair(MEDIATION_TYPE, str4));
        }
        String c = c.c(context, context.getPackageName());
        if (!TextUtils.isEmpty(c)) {
            vector2.add(new Pair(APPLICATION_VERSION, c));
        }
        int i = Build.VERSION.SDK_INT;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        vector2.add(new Pair(OS_VERSION, sb.toString()));
        vector2.add(new Pair(DEVICE_MAKE, Build.MANUFACTURER));
        vector2.add(new Pair(DEVICE_MODEL, Build.MODEL));
        boolean firstSession = IronSourceUtils.getFirstSession(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(firstSession ? 1 : 0);
        vector2.add(new Pair(FIRST_SESSION, sb2.toString()));
        ConcurrentHashMap<String, List<String>> d = k.a().d();
        if (d.containsKey("is_child_directed")) {
            vector2.add(new Pair("coppa", d.get("is_child_directed").get(0)));
        }
        String connectionType = IronSourceUtils.getConnectionType(context);
        if (!TextUtils.isEmpty(connectionType)) {
            vector2.add(new Pair(CONNECTION_TYPE, connectionType));
        }
        if (vector != null) {
            vector2.addAll(vector);
        }
        String r = h.r();
        if (r.length() != 0) {
            vector2.add(new Pair(BROWSER_USER_AGENT, r));
        }
        String str5 = null;
        try {
            str5 = h.a(context) + "-" + h.b(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!(str5 == null || str5.length() == 0)) {
            vector2.add(new Pair(DEVICE_LANG, str5));
        }
        if (context != null) {
            vector2.add(new Pair(BUNDLE_ID, context.getPackageName()));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(a.AnonymousClass1.c(context));
            vector2.add(new Pair(MOBILE_COUNTRY_CODE, sb3.toString()));
            StringBuilder sb4 = new StringBuilder();
            sb4.append(a.AnonymousClass1.d(context));
            vector2.add(new Pair(MOBILE_NETWORK_CODE, sb4.toString()));
            String j = h.j(context);
            if (!TextUtils.isEmpty(j)) {
                vector2.add(new Pair(ISO_COUNTRY_CODE, j));
            }
            String i2 = h.i(context);
            if (!TextUtils.isEmpty(i2)) {
                vector2.add(new Pair(MOBILE_CARRIER, i2));
            }
        }
        String c2 = h.c();
        if (!TextUtils.isEmpty(c2)) {
            vector2.add(new Pair(TIME_ZONE_ID, c2));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(h.b());
        vector2.add(new Pair(TIME_ZONE_OFFSET, sb5.toString()));
        String y = h.y(context);
        if (!TextUtils.isEmpty(y)) {
            vector2.add(new Pair(AUID, y));
        }
        b bVar = new b();
        JSONObject a = bVar.b.a(bVar.a);
        Intrinsics.checkNotNullExpressionValue(a, "mGlobalDataReader.getDataByKeys(mInitKeyList)");
        vector2.addAll(IronSourceUtils.parseJsonToPairVector(a));
        return getBaseUrl(IronSourceUtils.getSDKVersion()) + URLEncoder.encode(IronSourceAES.encode(g.a().b(), createURLParams(vector2)), "UTF-8");
    }

    public static String getRequestURL(String str, boolean z, int i) {
        Vector vector = new Vector();
        vector.add(new Pair("impression", Boolean.toString(z)));
        vector.add(new Pair("placementId", Integer.toString(i)));
        String createURLParams = createURLParams(vector);
        return str + AMPERSAND + createURLParams;
    }

    private static void setBaseUrlPrefix(String str) {
        BASE_URL_PREFIX = str;
    }
}
