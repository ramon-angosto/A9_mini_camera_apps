package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.b1 */
public class C0779b1 extends C0833v {

    /* renamed from: com.huawei.hms.hatool.b1$a */
    public static /* synthetic */ class C0780a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f602a = new int[C0836w0.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.huawei.hms.hatool.w0[] r0 = com.huawei.hms.hatool.C0836w0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f602a = r0
                int[] r0 = f602a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.huawei.hms.hatool.w0 r1 = com.huawei.hms.hatool.C0836w0.SN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f602a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.huawei.hms.hatool.w0 r1 = com.huawei.hms.hatool.C0836w0.IMEI     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f602a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.huawei.hms.hatool.w0 r1 = com.huawei.hms.hatool.C0836w0.UDID     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.C0779b1.C0780a.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static C0783c1 m735a(String str, String str2) {
        C0783c1 a = C0833v.m1041a(str, str2);
        C0834v0 c = C0839x0.m1066a().mo14137c(str, str2);
        a.mo13937g(C0839x0.m1066a().mo14134a(C0781c.m743c(str, str2)));
        a.mo13936f(C0781c.m755o(str, str2));
        a.mo13933c(C0839x0.m1066a().mo14140f(str, str2));
        int i = C0780a.f602a[c.mo14122a().ordinal()];
        if (i == 1) {
            a.mo13934d(c.mo14123b());
        } else if (i == 2) {
            a.mo13932b(c.mo14123b());
        } else if (i == 3) {
            a.mo13935e(c.mo14123b());
        }
        return a;
    }

    /* renamed from: a */
    public static C0786d1 m736a(String str, String str2, String str3, String str4) {
        C0786d1 a = C0833v.m1042a(str, str2, str3, str4);
        String a2 = C0839x0.m1066a().mo14134a(C0781c.m743c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String sha256Encrypt = SHA.sha256Encrypt(C0777b.m725c() + a2 + currentTimeMillis);
        a.mo14089f(String.valueOf(currentTimeMillis));
        a.mo13946g(sha256Encrypt);
        return a;
    }

    /* renamed from: a */
    public static C0789e1 m737a(String str, String str2, String str3) {
        C0789e1 a = C0833v.m1043a(str, str2, str3);
        Pair<String, String> e = C0839x0.m1066a().mo14139e(str2, str);
        a.mo13949f((String) e.first);
        a.mo13950g((String) e.second);
        a.mo13951h(C0790f.m806b());
        a.mo14096d(C0839x0.m1066a().mo14138d(str2, str));
        return a;
    }

    /* renamed from: a */
    public static C0825r m738a(List<C0823q> list, String str, String str2, String str3, String str4) {
        C0841y.m1087c("hmsSdk", "generate UploadData");
        C0825r a = C0833v.m1044a();
        if (a == null) {
            return null;
        }
        a.mo14109a((C0819o) m736a(C0837x.m1056f().mo14124a(), str, str2, str3));
        a.mo14108a(m735a(str, str2));
        a.mo14110a((C0821p) m737a(str2, str, str4));
        a.mo14111a(C0781c.m747g(str, str2));
        a.mo14112a(list);
        return a;
    }

    /* renamed from: b */
    public static Map<String, String> m739b(String str, String str2, String str3) {
        Map<String, String> b = C0833v.m1045b(str, str3);
        Map<String, String> i = C0781c.m749i(str, str2);
        if (i == null) {
            return b;
        }
        b.putAll(i);
        return b;
    }
}
