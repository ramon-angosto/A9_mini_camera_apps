package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.BasePlugin;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import java.util.Locale;

public class GrsManager implements BasePlugin {
    private static final int GRS_KEY_INDEX = 1;
    private static final int GRS_PATH_INDEX = 2;
    private static final String GRS_SCHEMA = "grs://";
    private static final int GRS_SERVICE_INDEX = 0;
    private static final int MAX_GRS_SPLIT = 3;
    private static final String SEPARATOR = "/";
    private static final String TAG = "GrsManager";
    private static volatile GrsManager instance;
    private GrsConfig grsConfig;
    private C0767f grsInterceptor;

    private GrsManager() {
    }

    public static GrsManager getInstance() {
        if (instance == null) {
            synchronized (GrsManager.class) {
                if (instance == null) {
                    instance = new GrsManager();
                }
            }
        }
        return instance;
    }

    private String getServiceNameUrl(String str, String str2) {
        return GrsApi.synGetGrsUrl(str, str2);
    }

    public static boolean isGRSSchema(String str) {
        return str != null && str.startsWith(GRS_SCHEMA);
    }

    private String[] parseGRSSchema(String str) {
        return StringUtils.substring(str, str.toLowerCase(Locale.ENGLISH).indexOf(GRS_SCHEMA) + 6).split(SEPARATOR, 3);
    }

    public PluginInterceptor getInterceptor() {
        if (this.grsInterceptor == null) {
            this.grsInterceptor = new C0767f();
        }
        return this.grsInterceptor;
    }

    public boolean initGrs(Context context, GrsConfig grsConfig2) {
        GrsConfig grsConfig3 = this.grsConfig;
        if (grsConfig3 != null && grsConfig3.equal(grsConfig2)) {
            return true;
        }
        this.grsConfig = grsConfig2;
        GrsBaseInfo grsBaseInfo = null;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        GrsConfig grsConfig4 = this.grsConfig;
        if (grsConfig4 != null) {
            grsBaseInfo = grsConfig4.getGrsBaseInfo(applicationContext);
        }
        GrsApi.grsSdkInit(applicationContext, grsBaseInfo);
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String parseGrs(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "/"
            boolean r1 = r6.endsWith(r0)
            r2 = 1
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = "grs://"
            int r1 = r6.indexOf(r1)
            int r3 = r6.length()
            int r3 = r3 - r2
            java.lang.String r6 = com.huawei.hms.framework.common.StringUtils.substring(r6, r1, r3)
        L_0x0018:
            java.lang.String[] r6 = r5.parseGRSSchema(r6)
            int r1 = r6.length
            r3 = 0
            r4 = 2
            if (r1 != r2) goto L_0x002a
            r1 = r6[r3]
            java.lang.String r2 = "ROOT"
        L_0x0025:
            java.lang.String r1 = r5.getServiceNameUrl(r1, r2)
            goto L_0x003b
        L_0x002a:
            int r1 = r6.length
            if (r1 < r4) goto L_0x0032
            r1 = r6[r3]
            r2 = r6[r2]
            goto L_0x0025
        L_0x0032:
            java.lang.String r1 = "GrsManager"
            java.lang.String r2 = "parseGrs params.length<1."
            com.huawei.hms.framework.common.Logger.m474i(r1, r2)
            java.lang.String r1 = ""
        L_0x003b:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0071
            int r2 = r6.length
            if (r2 <= r4) goto L_0x0070
            boolean r2 = r1.endsWith(r0)
            if (r2 == 0) goto L_0x005c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r6 = r6[r4]
            r0.append(r6)
            java.lang.String r1 = r0.toString()
            goto L_0x0070
        L_0x005c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r0)
            r6 = r6[r4]
            r2.append(r6)
            java.lang.String r1 = r2.toString()
        L_0x0070:
            return r1
        L_0x0071:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r0 = "can not get url, do grsUrl(serviceName or key) error?"
            r6.<init>(r0)
            goto L_0x007a
        L_0x0079:
            throw r6
        L_0x007a:
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.GrsManager.parseGrs(java.lang.String):java.lang.String");
    }
}
