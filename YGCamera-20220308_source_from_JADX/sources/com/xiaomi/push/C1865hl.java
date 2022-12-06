package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C2033bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.hl */
public class C1865hl {
    /* renamed from: a */
    private static HashMap<String, ArrayList<C1872hs>> m3883a(Context context, List<C1872hs> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<C1872hs>> hashMap = new HashMap<>();
        for (C1872hs next : list) {
            m3886a(context, next);
            ArrayList arrayList = hashMap.get(next.mo17788c());
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(next.mo17788c(), arrayList);
            }
            arrayList.add(next);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static void m3884a(Context context, C1867hn hnVar, HashMap<String, ArrayList<C1872hs>> hashMap) {
        for (Map.Entry next : hashMap.entrySet()) {
            try {
                ArrayList arrayList = (ArrayList) next.getValue();
                if (arrayList != null) {
                    if (arrayList.size() != 0) {
                        hnVar.mo17765a(arrayList, ((C1872hs) arrayList.get(0)).mo17794e(), (String) next.getKey());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m3885a(Context context, C1867hn hnVar, List<C1872hs> list) {
        HashMap<String, ArrayList<C1872hs>> a = m3883a(context, list);
        if (a == null || a.size() == 0) {
            C1524b.m2141a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
            return;
        }
        m3884a(context, hnVar, a);
    }

    /* renamed from: a */
    private static void m3886a(Context context, C1872hs hsVar) {
        if (hsVar.f2740a) {
            hsVar.mo17779a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(hsVar.mo17792d())) {
            hsVar.mo17796f(C2033bs.m5177a());
        }
        hsVar.mo17783b(System.currentTimeMillis());
        if (TextUtils.isEmpty(hsVar.mo17794e())) {
            hsVar.mo17793e(context.getPackageName());
        }
        if (TextUtils.isEmpty(hsVar.mo17788c())) {
            hsVar.mo17793e(hsVar.mo17794e());
        }
    }
}
