package com.mbridge.msdk.mbsignalcommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.mbsignalcommon.mraid.a;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: MraidUriUtil */
public final class c {
    private static volatile ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();
    private static ArrayList<String> b = new ArrayList<>();

    public static a a(WindVaneWebView windVaneWebView, String str) {
        Set<String> set;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains(CampaignEx.JSON_KEY_MRAID)) {
            return null;
        }
        a aVar = new a();
        aVar.d = l.b("n+ztLkxpVTzBLkxgHN==");
        aVar.e = parse.getHost();
        int i = 0;
        if (b.size() == 0) {
            for (Method name : b.class.getDeclaredMethods()) {
                b.add(name.getName());
            }
        }
        if (b.contains(aVar.e) || windVaneWebView == null) {
            String encodedQuery = parse.getEncodedQuery();
            if (encodedQuery == null) {
                set = Collections.emptySet();
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                do {
                    int indexOf = encodedQuery.indexOf(38, i);
                    if (indexOf == -1) {
                        indexOf = encodedQuery.length();
                    }
                    int indexOf2 = encodedQuery.indexOf(61, i);
                    if (indexOf2 > indexOf || indexOf2 == -1) {
                        indexOf2 = indexOf;
                    }
                    linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
                    i = indexOf + 1;
                } while (i < encodedQuery.length());
                set = Collections.unmodifiableSet(linkedHashSet);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str2 : set) {
                    jSONObject.put(str2, parse.getQueryParameter(str2));
                }
                aVar.f = jSONObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return aVar;
        }
        String campaignId = windVaneWebView.getCampaignId();
        String str3 = aVar.e;
        if (!TextUtils.isEmpty(campaignId)) {
            if (a.containsKey(campaignId)) {
                String str4 = a.get(campaignId);
                if (!TextUtils.isEmpty(str3) && !str4.contains(str3)) {
                    if (str4.length() > 0) {
                        str4 = str4.concat(",");
                    }
                    a.put(campaignId, str4.concat(str3));
                }
            } else {
                a.put(campaignId, str3);
            }
        }
        a.C0071a.a.a((WebView) windVaneWebView, aVar.e);
        a.C0071a.a.a((WebView) windVaneWebView, aVar.e, "Specified command is not implemented");
        return null;
    }

    public static String a(String str) {
        if (a.containsKey(str)) {
            return a.get(str);
        }
        return null;
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            a.remove(str);
        }
    }
}
