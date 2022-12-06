package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.huawei.hms.framework.network.grs.p014a.C0726a;
import com.huawei.hms.framework.network.grs.p014a.C0727b;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import com.huawei.hms.framework.network.grs.p015b.C0731b;
import com.huawei.hms.framework.network.grs.p016c.C0748f;
import com.huawei.hms.framework.network.grs.p016c.C0755m;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0743c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.a */
public class C0723a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f446a = "a";

    /* renamed from: b */
    private GrsBaseInfo f447b;

    /* renamed from: c */
    private C0726a f448c;

    /* renamed from: d */
    private C0755m f449d;

    /* renamed from: e */
    private C0728c f450e;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a */
    private static class C0724a implements C0729b {

        /* renamed from: a */
        String f451a;

        /* renamed from: b */
        Map<String, String> f452b;

        /* renamed from: c */
        IQueryUrlsCallBack f453c;

        /* renamed from: d */
        Context f454d;

        /* renamed from: e */
        GrsBaseInfo f455e;

        /* renamed from: f */
        C0726a f456f;

        C0724a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, C0726a aVar) {
            this.f451a = str;
            this.f452b = map;
            this.f453c = iQueryUrlsCallBack;
            this.f454d = context;
            this.f455e = grsBaseInfo;
            this.f456f = aVar;
        }

        /* renamed from: a */
        public void mo13793a() {
            Map<String, String> map = this.f452b;
            if (map != null && !map.isEmpty()) {
                this.f453c.onCallBackSuccess(this.f452b);
            } else if (this.f452b == null) {
                Logger.m474i(C0723a.f446a, "access local config for return a domain.");
                this.f453c.onCallBackSuccess(C0731b.m539a(this.f454d.getPackageName(), this.f455e).mo13827a(this.f454d, this.f456f, this.f455e, this.f451a, true));
            } else {
                this.f453c.onCallBackFail(-3);
            }
        }

        /* renamed from: a */
        public void mo13794a(C0748f fVar) {
            Map<String, String> a = C0723a.m487a(fVar.mo13873i(), this.f451a);
            if (a.isEmpty()) {
                Map<String, String> map = this.f452b;
                if (map != null && !map.isEmpty()) {
                    this.f453c.onCallBackSuccess(this.f452b);
                    return;
                } else if (this.f452b == null) {
                    Logger.m474i(C0723a.f446a, "access local config for return a domain.");
                    a = C0731b.m539a(this.f454d.getPackageName(), this.f455e).mo13827a(this.f454d, this.f456f, this.f455e, this.f451a, true);
                } else {
                    this.f453c.onCallBackFail(-5);
                    return;
                }
            }
            this.f453c.onCallBackSuccess(a);
        }
    }

    /* renamed from: com.huawei.hms.framework.network.grs.a$b */
    private static class C0725b implements C0729b {

        /* renamed from: a */
        String f457a;

        /* renamed from: b */
        String f458b;

        /* renamed from: c */
        IQueryUrlCallBack f459c;

        /* renamed from: d */
        String f460d;

        /* renamed from: e */
        Context f461e;

        /* renamed from: f */
        GrsBaseInfo f462f;

        /* renamed from: g */
        C0726a f463g;

        C0725b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, C0726a aVar) {
            this.f457a = str;
            this.f458b = str2;
            this.f459c = iQueryUrlCallBack;
            this.f460d = str3;
            this.f461e = context;
            this.f462f = grsBaseInfo;
            this.f463g = aVar;
        }

        /* renamed from: a */
        public void mo13793a() {
            if (!TextUtils.isEmpty(this.f460d)) {
                this.f459c.onCallBackSuccess(this.f460d);
            } else if (TextUtils.isEmpty(this.f460d)) {
                Logger.m474i(C0723a.f446a, "access local config for return a domain.");
                this.f459c.onCallBackSuccess(C0731b.m539a(this.f461e.getPackageName(), this.f462f).mo13826a(this.f461e, this.f463g, this.f462f, this.f457a, this.f458b, true));
            } else {
                this.f459c.onCallBackFail(-3);
            }
        }

        /* renamed from: a */
        public void mo13794a(C0748f fVar) {
            String a = C0723a.m484a(fVar.mo13873i(), this.f457a, this.f458b);
            if (TextUtils.isEmpty(a)) {
                if (!TextUtils.isEmpty(this.f460d)) {
                    this.f459c.onCallBackSuccess(this.f460d);
                    return;
                } else if (TextUtils.isEmpty(this.f460d)) {
                    Logger.m474i(C0723a.f446a, "access local config for return a domain.");
                    a = C0731b.m539a(this.f461e.getPackageName(), this.f462f).mo13826a(this.f461e, this.f463g, this.f462f, this.f457a, this.f458b, true);
                } else {
                    this.f459c.onCallBackFail(-5);
                    return;
                }
            }
            this.f459c.onCallBackSuccess(a);
        }
    }

    public C0723a(GrsBaseInfo grsBaseInfo, C0726a aVar, C0755m mVar, C0728c cVar) {
        this.f447b = grsBaseInfo;
        this.f448c = aVar;
        this.f449d = mVar;
        this.f450e = cVar;
    }

    /* renamed from: a */
    public static CountryCodeBean m481a(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    /* renamed from: a */
    private String m483a(String str, String str2, C0727b bVar, Context context) {
        String a = this.f448c.mo13796a(this.f447b, str, str2, bVar, context);
        if (!TextUtils.isEmpty(a)) {
            Logger.m474i(f446a, "get url from sp is not empty.");
            C0731b.m540a(context, this.f447b);
            return a;
        }
        return C0731b.m539a(context.getPackageName(), this.f447b).mo13826a(context, this.f448c, this.f447b, str, str2, false);
    }

    /* renamed from: a */
    public static String m484a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).getJSONObject(str2).getString(str3);
        } catch (JSONException e) {
            Logger.m479w(f446a, "Method{getServiceNameUrl} query url from SP occur an JSONException", (Throwable) e);
            return "";
        }
    }

    /* renamed from: a */
    public static Map<String, Map<String, String>> m485a(String str) {
        HashMap hashMap = new HashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.m476v(f446a, "isSpExpire jsonValue is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, m488a(jSONObject.getJSONObject(obj)));
            }
            return hashMap;
        } catch (JSONException e) {
            Logger.m479w(f446a, "getServicesUrlsMap occur a JSONException", (Throwable) e);
            return hashMap;
        }
    }

    /* renamed from: a */
    private Map<String, String> m486a(String str, C0727b bVar, Context context) {
        Map<String, String> a = this.f448c.mo13797a(this.f447b, str, bVar, context);
        if (a == null || a.isEmpty()) {
            return C0731b.m539a(context.getPackageName(), this.f447b).mo13827a(context, this.f448c, this.f447b, str, false);
        }
        Logger.m474i(f446a, "get url from sp is not empty.");
        C0731b.m540a(context, this.f447b);
        return a;
    }

    /* renamed from: a */
    public static Map<String, String> m487a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.m476v(f446a, "isSpExpire jsonValue is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(str2);
            if (jSONObject == null) {
                Logger.m476v(f446a, "getServiceNameUrls jsObject null.");
                return hashMap;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.get(obj).toString());
            }
            return hashMap;
        } catch (JSONException e) {
            Logger.m479w(f446a, "Method{getServiceNameUrls} query url from SP occur an JSONException", (Throwable) e);
            return hashMap;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m488a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.get(obj).toString());
            }
            return hashMap;
        } catch (JSONException e) {
            Logger.m479w(f446a, "getServiceUrls occur a JSONException", (Throwable) e);
            return hashMap;
        }
    }

    /* renamed from: a */
    private void m489a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        this.f449d.mo13885a(new C0743c(this.f447b, context), new C0724a(str, map, iQueryUrlsCallBack, context, this.f447b, this.f448c), str, this.f450e);
    }

    /* renamed from: a */
    public String mo13788a(Context context, String str) {
        C0748f a = this.f449d.mo13883a(new C0743c(this.f447b, context), str, this.f450e);
        return a == null ? "" : a.mo13873i();
    }

    /* renamed from: a */
    public String mo13789a(String str, String str2, Context context) {
        C0727b bVar = new C0727b();
        String a = m483a(str, str2, bVar, context);
        if (!bVar.mo13804a() || TextUtils.isEmpty(a)) {
            String a2 = m484a(mo13788a(context, str), str, str2);
            if (!TextUtils.isEmpty(a2)) {
                Logger.m474i(f446a, "get url is from remote server");
                C0731b.m540a(context, this.f447b);
                return a2;
            } else if (!TextUtils.isEmpty(a)) {
                return a;
            } else {
                Logger.m474i(f446a, "access local config for return a domain.");
                return C0731b.m539a(context.getPackageName(), this.f447b).mo13826a(context, this.f448c, this.f447b, str, str2, true);
            }
        } else {
            Logger.m477v(f446a, "get unexpired cache localUrl{%s}", a);
            C0731b.m540a(context, this.f447b);
            return a;
        }
    }

    /* renamed from: a */
    public Map<String, String> mo13790a(String str, Context context) {
        C0727b bVar = new C0727b();
        Map<String, String> a = m486a(str, bVar, context);
        if (!bVar.mo13804a() || a == null || a.isEmpty()) {
            Map<String, String> a2 = m487a(mo13788a(context, str), str);
            if (!a2.isEmpty()) {
                C0731b.m540a(context, this.f447b);
                return a2;
            } else if (a == null || !a.isEmpty()) {
                return a;
            } else {
                Logger.m474i(f446a, "access local config for return a domain.");
                return C0731b.m539a(context.getPackageName(), this.f447b).mo13827a(context, this.f448c, this.f447b, str, true);
            }
        } else {
            C0731b.m540a(context, this.f447b);
            return a;
        }
    }

    /* renamed from: a */
    public void mo13791a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        C0727b bVar = new C0727b();
        Map<String, String> a = m486a(str, bVar, context);
        if (!bVar.mo13804a()) {
            m489a(str, a, iQueryUrlsCallBack, context);
        } else if (a == null || a.isEmpty()) {
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            C0731b.m540a(context, this.f447b);
            iQueryUrlsCallBack.onCallBackSuccess(a);
        }
    }

    /* renamed from: a */
    public void mo13792a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context) {
        C0727b bVar = new C0727b();
        String a = m483a(str, str2, bVar, context);
        if (!bVar.mo13804a()) {
            this.f449d.mo13885a(new C0743c(this.f447b, context), new C0725b(str, str2, iQueryUrlCallBack, a, context, this.f447b, this.f448c), str, this.f450e);
        } else if (TextUtils.isEmpty(a)) {
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            C0731b.m540a(context, this.f447b);
            iQueryUrlCallBack.onCallBackSuccess(a);
        }
    }
}
