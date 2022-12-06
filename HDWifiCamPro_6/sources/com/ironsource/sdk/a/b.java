package com.ironsource.sdk.a;

import android.content.Context;
import com.adcolony.adcolonysdk.BuildConfig;
import com.ironsource.a.c;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;

public final class b implements c {
    private static Map<String, Object> a = new HashMap();

    public static class a {
        public String a;
        public String b;
        public Context c;
        public String d;
    }

    private b(a aVar) {
        Context context = aVar.c;
        com.ironsource.sdk.utils.a a2 = com.ironsource.sdk.utils.a.a(context);
        a.put("deviceos", SDKUtils.encodeString(a2.c));
        a.put("deviceosversion", SDKUtils.encodeString(a2.d));
        a.put("deviceapilevel", Integer.valueOf(a2.e));
        a.put("deviceoem", SDKUtils.encodeString(a2.a));
        a.put("devicemodel", SDKUtils.encodeString(a2.b));
        a.put("bundleid", SDKUtils.encodeString(context.getPackageName()));
        a.put("applicationkey", SDKUtils.encodeString(aVar.b));
        a.put("sessionid", SDKUtils.encodeString(aVar.a));
        a.put("sdkversion", SDKUtils.encodeString(SDKUtils.getSDKVersion()));
        a.put("applicationuserid", SDKUtils.encodeString(aVar.d));
        a.put("env", BuildConfig.FLAVOR);
        a.put("origin", "n");
        a.put("connectiontype", com.ironsource.d.a.a(aVar.c));
    }

    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    public static void a(String str) {
        a.put("connectiontype", SDKUtils.encodeString(str));
    }

    public final Map<String, Object> a() {
        return a;
    }
}
