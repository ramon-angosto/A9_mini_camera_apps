package com.huawei.hms.framework.network.grs.p015b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C0768a;
import com.huawei.hms.framework.network.grs.p014a.C0726a;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.b.b */
public class C0731b {

    /* renamed from: a */
    private static Map<String, C0731b> f479a = new ConcurrentHashMap(16);

    /* renamed from: b */
    private C0730a f480b;

    public C0731b(Context context, GrsBaseInfo grsBaseInfo, boolean z) {
        mo13828a(context, z);
        Map<String, C0731b> map = f479a;
        map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
    }

    /* renamed from: a */
    public static C0731b m539a(String str, GrsBaseInfo grsBaseInfo) {
        Map<String, C0731b> map = f479a;
        return map.get(str + grsBaseInfo.uniqueCode());
    }

    /* renamed from: a */
    public static void m540a(Context context, GrsBaseInfo grsBaseInfo) {
        C0768a a;
        C0731b a2 = m539a(context.getPackageName(), grsBaseInfo);
        if (a2 != null && (a = a2.mo13825a()) != null) {
            Logger.m474i("LocalManagerProxy", "appGrs is not null and clear services.");
            a.mo13900a();
        }
    }

    /* renamed from: a */
    public C0768a mo13825a() {
        return this.f480b.mo13813a();
    }

    /* renamed from: a */
    public String mo13826a(Context context, C0726a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        return this.f480b.mo13814a(context, aVar, grsBaseInfo, str, str2, z);
    }

    /* renamed from: a */
    public Map<String, String> mo13827a(Context context, C0726a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        return this.f480b.mo13816a(context, aVar, grsBaseInfo, str, z);
    }

    /* renamed from: a */
    public void mo13828a(Context context, boolean z) {
        this.f480b = new C0733d(context, z);
        if (!this.f480b.mo13822c()) {
            this.f480b = new C0732c(context, z);
        }
    }

    /* renamed from: a */
    public void mo13829a(GrsBaseInfo grsBaseInfo) {
        this.f480b.mo13817a(grsBaseInfo);
    }

    /* renamed from: b */
    public Set<String> mo13830b() {
        return this.f480b.mo13819b();
    }
}
