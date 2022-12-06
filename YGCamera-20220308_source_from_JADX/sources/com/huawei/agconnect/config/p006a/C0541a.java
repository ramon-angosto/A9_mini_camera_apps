package com.huawei.agconnect.config.p006a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectApp;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.core.p007a.C0553a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.agconnect.config.a.a */
public class C0541a extends AGConnectApp {

    /* renamed from: a */
    private static final Map<String, AGConnectApp> f95a = new HashMap();

    /* renamed from: b */
    private static final Object f96b = new Object();

    /* renamed from: c */
    private static String f97c;

    /* renamed from: d */
    private AGConnectServicesConfig f98d;

    private C0541a(Context context, String str) {
        this.f98d = AGConnectServicesConfig.fromContext(context, str);
    }

    public static AGConnectApp getInstance() {
        return getInstance(f97c);
    }

    public static AGConnectApp getInstance(String str) {
        AGConnectApp aGConnectApp;
        synchronized (f96b) {
            aGConnectApp = f95a.get(str);
            if (aGConnectApp == null) {
                throw new IllegalStateException("you should call AGConnectApp.initialize first");
            }
        }
        return aGConnectApp;
    }

    public static AGConnectApp initialize(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        f97c = context.getPackageName();
        return initialize(context, f97c);
    }

    public static AGConnectApp initialize(Context context, String str) {
        AGConnectApp aGConnectApp;
        if (!TextUtils.isEmpty(str)) {
            synchronized (f96b) {
                aGConnectApp = f95a.get(str);
                if (aGConnectApp == null) {
                    f95a.put(str, new C0541a(context, str));
                }
            }
            return aGConnectApp;
        }
        throw new IllegalArgumentException("packageName can not be empty");
    }

    public void setApiKey(String str) {
        this.f98d.setParam("/client/api_key", str);
    }

    public void setClientId(String str) {
        this.f98d.setParam("/client/client_id", str);
    }

    public void setClientSecret(String str) {
        this.f98d.setParam("/client/client_secret", str);
    }

    public void setCustomAuthProvider(CustomAuthProvider customAuthProvider) {
        ((C0553a) AGConnectInstance.getInstance()).mo12752a(customAuthProvider);
    }

    public void setCustomCredentialsProvider(CustomCredentialsProvider customCredentialsProvider) {
        ((C0553a) AGConnectInstance.getInstance()).mo12753a(customCredentialsProvider);
    }

    public void setParam(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f98d.setParam(str, str2);
            return;
        }
        throw new IllegalArgumentException("path can not be empty");
    }
}
