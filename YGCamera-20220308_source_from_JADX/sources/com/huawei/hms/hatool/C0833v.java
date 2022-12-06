package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.v */
public class C0833v {
    /* renamed from: a */
    public static C0783c1 m1041a(String str, String str2) {
        C0783c1 c1Var = new C0783c1();
        c1Var.mo14081a(C0839x0.m1066a().mo14133a(str, str2));
        return c1Var;
    }

    /* renamed from: a */
    public static C0786d1 m1042a(String str, String str2, String str3, String str4) {
        C0786d1 d1Var = new C0786d1();
        d1Var.mo14084a(str);
        d1Var.mo14085b(C0777b.m725c());
        d1Var.mo14088e(str2);
        d1Var.mo14086c(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        d1Var.mo14087d(stringBuffer.toString());
        return d1Var;
    }

    /* renamed from: a */
    public static C0789e1 m1043a(String str, String str2, String str3) {
        C0789e1 e1Var = new C0789e1();
        e1Var.mo14095c(C0777b.m730g());
        e1Var.mo14097e(C0777b.m732i());
        e1Var.mo14093a(str3);
        e1Var.mo14094b(C0839x0.m1066a().mo14136b(str2, str));
        return e1Var;
    }

    /* renamed from: a */
    public static C0825r m1044a() {
        C0841y.m1087c("hmsSdk", "generate UploadData EventModelHandlerBase");
        C0837x.m1056f().mo14127d();
        if (!TextUtils.isEmpty(C0837x.m1056f().mo14124a())) {
            return new C0825r(C0837x.m1056f().mo14126c());
        }
        C0841y.m1092f("hmsSdk", "event chifer is empty");
        return null;
    }

    /* renamed from: b */
    public static Map<String, String> m1045b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", C0777b.m725c());
        hashMap.put("App-Ver", C0777b.m727d());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.308");
        hashMap.put("Device-Type", Build.MODEL);
        hashMap.put("servicetag", str);
        C0841y.m1082a("hmsSdk", "sendData RequestId : %s", str2);
        hashMap.put("Request-Id", str2);
        return hashMap;
    }
}
