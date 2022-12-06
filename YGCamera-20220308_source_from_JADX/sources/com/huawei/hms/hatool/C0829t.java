package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.agconnect.exception.AGCServerException;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.t */
public class C0829t {

    /* renamed from: a */
    public List<C0823q> f743a;

    /* renamed from: b */
    public String f744b;

    /* renamed from: c */
    public String f745c;

    /* renamed from: d */
    public String f746d;

    public C0829t(List<C0823q> list, String str, String str2, String str3) {
        this.f743a = list;
        this.f744b = str;
        this.f745c = str2;
        this.f746d = str3;
    }

    /* renamed from: a */
    public void mo14113a() {
        if ("_default_config_tag".equals(this.f745c)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (C0823q next : this.f743a) {
                String c = next.mo14102c();
                if (TextUtils.isEmpty(c) || "oper".equals(c)) {
                    arrayList4.add(next);
                } else if ("maint".equals(c)) {
                    arrayList.add(next);
                } else if ("preins".equals(c)) {
                    arrayList2.add(next);
                } else if ("diffprivacy".equals(c)) {
                    arrayList3.add(next);
                }
            }
            mo14114a(arrayList4, "oper", "_default_config_tag");
            mo14114a(arrayList, "maint", "_default_config_tag");
            mo14114a(arrayList2, "preins", "_default_config_tag");
            mo14114a(arrayList3, "diffprivacy", "_default_config_tag");
            return;
        }
        mo14114a(this.f743a, this.f745c, this.f744b);
    }

    /* renamed from: a */
    public final void mo14114a(List<C0823q> list, String str, String str2) {
        if (!list.isEmpty()) {
            int size = (list.size() / AGCServerException.UNKNOW_EXCEPTION) + 1;
            for (int i = 0; i < size; i++) {
                int i2 = i * AGCServerException.UNKNOW_EXCEPTION;
                List<C0823q> subList = list.subList(i2, Math.min(list.size(), i2 + AGCServerException.UNKNOW_EXCEPTION));
                String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                long currentTimeMillis = System.currentTimeMillis();
                long b = ((long) C0781c.m742b(str2, str)) * 86400000;
                ArrayList arrayList = new ArrayList();
                for (C0823q next : subList) {
                    if (!C0822p0.m990a(next.mo14100b(), currentTimeMillis, b)) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() > 0) {
                    new C0831u(str2, str, this.f746d, arrayList, replace).mo14116a();
                } else {
                    C0841y.m1091e("hmsSdk", "No data to report handler");
                }
            }
        }
    }
}
