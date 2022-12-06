package com.huawei.hms.framework.network.grs.p016c;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.C0723a;
import com.huawei.hms.framework.network.grs.C0729b;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p014a.C0726a;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0743c;
import com.huawei.hms.framework.network.grs.p019d.C0765e;
import org.json.JSONException;

/* renamed from: com.huawei.hms.framework.network.grs.c.c */
public class C0745c {

    /* renamed from: a */
    private Context f510a;

    /* renamed from: b */
    private GrsBaseInfo f511b;

    /* renamed from: c */
    private C0726a f512c;

    public C0745c(Context context, C0726a aVar, GrsBaseInfo grsBaseInfo) {
        this.f510a = context;
        this.f511b = grsBaseInfo;
        this.f512c = aVar;
    }

    /* renamed from: a */
    public String mo13856a(boolean z) {
        String str;
        String a = C0723a.m484a(this.f512c.mo13795a().mo13805a("geoipCountryCode", ""), "geoip.countrycode", "ROOT");
        Logger.m474i("GeoipCountry", "geoIpCountry is: " + a);
        String a2 = this.f512c.mo13795a().mo13805a("geoipCountryCodetime", "0");
        long j = 0;
        if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
            try {
                j = Long.parseLong(a2);
            } catch (NumberFormatException e) {
                Logger.m479w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", (Throwable) e);
            }
        }
        if (TextUtils.isEmpty(a) || C0765e.m677a(Long.valueOf(j))) {
            C0743c cVar = new C0743c(this.f511b, this.f510a);
            cVar.mo13844a("geoip.countrycode");
            C0728c c = this.f512c.mo13802c();
            if (c != null) {
                try {
                    str = C0756n.m636a(c.mo13805a("services", ""), cVar.mo13846c());
                } catch (JSONException e2) {
                    Logger.m479w("GeoipCountry", "getGeoipCountry merge services occure jsonException.", (Throwable) e2);
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    c.mo13809b("services", str);
                }
            }
            if (z) {
                C0748f a3 = this.f512c.mo13800b().mo13883a(cVar, "geoip.countrycode", c);
                if (a3 != null) {
                    a = C0723a.m484a(a3.mo13873i(), "geoip.countrycode", "ROOT");
                }
                Logger.m474i("GeoipCountry", "sync request to query geoip.countrycode is:" + a);
            } else {
                Logger.m474i("GeoipCountry", "async request to query geoip.countrycode");
                this.f512c.mo13800b().mo13885a(cVar, (C0729b) null, "geoip.countrycode", c);
            }
        }
        return a;
    }
}
