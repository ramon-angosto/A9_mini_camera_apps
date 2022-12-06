package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.Map;

public class GrsClient {
    private C0757d grsClientGlobal;

    public GrsClient(Context context, GrsBaseInfo grsBaseInfo) {
        if (context == null || grsBaseInfo == null) {
            throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        }
        this.grsClientGlobal = C0766e.m679a(grsBaseInfo, context);
    }

    public void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        this.grsClientGlobal.mo13890a(str, str2, iQueryUrlCallBack);
    }

    public void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        this.grsClientGlobal.mo13889a(str, iQueryUrlsCallBack);
    }

    public void clearSp() {
        this.grsClientGlobal.mo13892b();
    }

    public boolean forceExpire() {
        return this.grsClientGlobal.mo13893c();
    }

    public String synGetGrsUrl(String str, String str2) {
        return this.grsClientGlobal.mo13887a(str, str2);
    }

    public Map<String, String> synGetGrsUrls(String str) {
        return this.grsClientGlobal.mo13888a(str);
    }
}
