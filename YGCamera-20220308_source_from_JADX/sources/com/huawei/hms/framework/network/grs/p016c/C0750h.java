package com.huawei.hms.framework.network.grs.p016c;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;

/* renamed from: com.huawei.hms.framework.network.grs.c.h */
public class C0750h {
    /* renamed from: a */
    public static void m626a(ArrayList<C0748f> arrayList, long j, JSONArray jSONArray, Context context) {
        if (context != null && arrayList != null && arrayList.size() > 0 && HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new C0749g(j, context, arrayList, jSONArray));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static LinkedHashMap<String, String> m627b(C0748f fVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception d = fVar.mo13868d();
        if (d != null) {
            linkedHashMapPack.put("error_code", (long) ExceptionCode.getErrorCodeFromException(d));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, d.getClass().getSimpleName());
            linkedHashMapPack.put(CrashHianalyticsData.MESSAGE, StringUtils.anonymizeMessage(d.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", (long) fVar.mo13865b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, (long) fVar.mo13867c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(fVar.mo13875k()).getHost());
        } catch (MalformedURLException e) {
            Logger.m479w("HaReportHelper", "report host MalformedURLException", (Throwable) e);
        }
        linkedHashMapPack.put("req_start_time", fVar.mo13871g());
        linkedHashMapPack.put("req_end_time", fVar.mo13870f());
        linkedHashMapPack.put("req_total_time", fVar.mo13872h());
        return linkedHashMapPack.getAll();
    }
}
