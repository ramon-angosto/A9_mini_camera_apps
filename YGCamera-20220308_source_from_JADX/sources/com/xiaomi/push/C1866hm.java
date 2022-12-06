package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C2033bs;
import com.xiaomi.push.service.C2034bt;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.hm */
public class C1866hm {

    /* renamed from: a */
    private static volatile C1866hm f2649a;

    /* renamed from: a */
    private final Context f2650a;

    /* renamed from: a */
    private Map<String, C1867hn> f2651a = new HashMap();

    private C1866hm(Context context) {
        this.f2650a = context;
    }

    /* renamed from: a */
    public static C1866hm m3887a(Context context) {
        if (context == null) {
            C1524b.m2160d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f2649a == null) {
            synchronized (C1866hm.class) {
                if (f2649a == null) {
                    f2649a = new C1866hm(context);
                }
            }
        }
        return f2649a;
    }

    /* renamed from: a */
    private boolean m3888a(String str, String str2, String str3, String str4, long j, String str5) {
        C1872hs hsVar = new C1872hs();
        hsVar.mo17791d(str3);
        hsVar.mo17787c(str4);
        hsVar.mo17778a(j);
        hsVar.mo17784b(str5);
        hsVar.mo17781a(true);
        hsVar.mo17779a("push_sdk_channel");
        hsVar.mo17793e(str2);
        return mo17763a(hsVar, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1867hn mo17761a() {
        C1867hn hnVar = this.f2651a.get("UPLOADER_PUSH_CHANNEL");
        if (hnVar != null) {
            return hnVar;
        }
        C1867hn hnVar2 = this.f2651a.get("UPLOADER_HTTP");
        if (hnVar2 != null) {
            return hnVar2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, C1867hn> m3890a() {
        return this.f2651a;
    }

    /* renamed from: a */
    public void mo17762a(C1867hn hnVar, String str) {
        if (hnVar == null) {
            C1524b.m2160d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            C1524b.m2160d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            mo17761a().put(str, hnVar);
        }
    }

    /* renamed from: a */
    public boolean mo17763a(C1872hs hsVar, String str) {
        if (TextUtils.isEmpty(str)) {
            C1524b.m2141a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (C2033bs.m5180a(hsVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(hsVar.mo17792d())) {
                hsVar.mo17796f(C2033bs.m5177a());
            }
            hsVar.mo17798g(str);
            C2034bt.m5182a(this.f2650a, hsVar);
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo17764a(String str, String str2, long j, String str3) {
        return m3888a(this.f2650a.getPackageName(), this.f2650a.getPackageName(), str, str2, j, str3);
    }
}
