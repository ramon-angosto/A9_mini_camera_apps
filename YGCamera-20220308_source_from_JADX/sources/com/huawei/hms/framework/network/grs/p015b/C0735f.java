package com.huawei.hms.framework.network.grs.p015b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p014a.C0726a;
import com.huawei.hms.framework.network.grs.p016c.C0745c;
import java.util.Collections;
import java.util.Set;

/* renamed from: com.huawei.hms.framework.network.grs.b.f */
public class C0735f {

    /* renamed from: a */
    private static final String f481a = "f";

    /* renamed from: b */
    public static final Set<String> f482b = Collections.unmodifiableSet(new C0734e(16));

    /* renamed from: a */
    public static String m554a(Context context, C0726a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Logger.m478w(f481a, "routeBy must be not empty string or null.");
            return null;
        } else if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return m555b(context, aVar, str, grsBaseInfo, z);
        } else {
            Logger.m476v(f481a, "routeBy equals NO_ROUTE_POLICY");
            return "no_route_country";
        }
    }

    /* renamed from: b */
    private static String m555b(Context context, C0726a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        String str2;
        StringBuilder sb;
        String str3;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str4 : str.split(">")) {
            if (f482b.contains(str4.trim())) {
                if ("ser_country".equals(str4.trim()) && !TextUtils.isEmpty(serCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(serCountry)) {
                    str2 = f481a;
                    sb = new StringBuilder();
                    str3 = "current route_by is serCountry and routerCountry is:";
                } else if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(regCountry)) {
                    Logger.m474i(f481a, "current route_by is regCountry and routerCountry is:" + regCountry);
                    return regCountry;
                } else if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(issueCountry)) {
                    Logger.m474i(f481a, "current route_by is issueCountry and routerCountry is:" + issueCountry);
                    return issueCountry;
                } else if ("geo_ip".equals(str4.trim())) {
                    serCountry = new C0745c(context, aVar, new GrsBaseInfo()).mo13856a(z);
                    str2 = f481a;
                    sb = new StringBuilder();
                    str3 = "current route_by is geo_ip and routerCountry is: ";
                }
                sb.append(str3);
                sb.append(serCountry);
                Logger.m474i(str2, sb.toString());
                return serCountry;
            }
        }
        return "";
    }
}
