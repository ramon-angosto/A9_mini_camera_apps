package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.opendevice.n */
/* compiled from: ReportAaidToken */
public class C0860n {

    /* renamed from: com.huawei.hms.opendevice.n$a */
    /* compiled from: ReportAaidToken */
    private enum C0861a {
        MOBILE("1"),
        PC("2"),
        TABLET("3"),
        TV("4"),
        SOUNDBOX("5"),
        GLASS("6"),
        WATCH("7"),
        VEHICLE("8"),
        OFFICE_DEVICE("9"),
        IOT_DEVICES("10"),
        HEALTHY("11"),
        ENTERTAINMENT("12"),
        TRANSPORT_DEVICES("13");
        

        /* renamed from: o */
        public String f815o;

        /* access modifiers changed from: public */
        C0861a(String str) {
            this.f815o = str;
        }

        /* renamed from: a */
        public String mo14175a() {
            return this.f815o;
        }
    }

    /* renamed from: com.huawei.hms.opendevice.n$b */
    /* compiled from: ReportAaidToken */
    private enum C0862b {
        IOS("ios"),
        ANDROID("android"),
        HARMONY("harmony"),
        WINDOWS("windows"),
        EMBED("embed"),
        OTHERS("others");
        

        /* renamed from: h */
        public String f823h;

        /* access modifiers changed from: public */
        C0862b(String str) {
            this.f823h = str;
        }

        /* renamed from: a */
        public String mo14176a() {
            return this.f823h;
        }
    }

    /* renamed from: c */
    public static String m1161c(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timezone", TimeZone.getDefault().getID());
            jSONObject2.put("country", SystemUtils.getLocalCountry());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("agent_version", new PackageManagerHelper(context).getPackageVersionName("com.huawei.android.pushagent"));
            jSONObject3.put("hms_version", String.valueOf(Util.getHmsVersion(context)));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("dev_type", C0861a.MOBILE.mo14175a());
            jSONObject4.put("dev_sub_type", "phone");
            jSONObject4.put("os_type", C0862b.ANDROID.mo14176a());
            jSONObject4.put("os_version", String.valueOf(HwBuildEx.VERSION.EMUI_SDK_INT));
            jSONObject.put("id", UUID.randomUUID().toString());
            jSONObject.put("global", jSONObject2);
            jSONObject.put("push_agent", jSONObject3);
            jSONObject.put("hardware", jSONObject4);
            jSONObject.put("aaid", str);
            jSONObject.put("token", str2);
            jSONObject.put("app_id", AGConnectServicesConfig.fromContext(context).getString("client/app_id"));
            jSONObject.put("region", AGConnectServicesConfig.fromContext(context).getString("region"));
            return jSONObject.toString();
        } catch (JSONException unused) {
            HMSLog.m1377e("ReportAaidToken", "Catch JSONException.");
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m1162d(Context context, String str, String str2) {
        C0855i a = C0855i.m1144a(context);
        if (!a.containsKey("reportAaidAndToken")) {
            HMSLog.m1374d("ReportAaidToken", "It hasn't been reported, this time needs report.");
            return true;
        }
        String string = a.getString("reportAaidAndToken");
        if (TextUtils.isEmpty(string)) {
            HMSLog.m1377e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
            return true;
        }
        return !string.equals(C0866r.m1184a(str2 + str, "SHA-256"));
    }

    /* renamed from: b */
    public static boolean m1160b(Context context) {
        int packageVersionCode = new PackageManagerHelper(context).getPackageVersionCode("com.huawei.android.pushagent");
        HMSLog.m1374d("ReportAaidToken", "NC version code: " + packageVersionCode);
        return (90101400 <= packageVersionCode && packageVersionCode < 100000000) || packageVersionCode >= 100001301;
    }

    /* renamed from: a */
    public static void m1154a(Context context, String str) {
        new C0859m(context, str).start();
    }

    /* renamed from: b */
    public static void m1159b(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.m1377e("ReportAaidToken", "Https response is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("ret", 256);
            if (optInt == 0) {
                boolean saveString = C0855i.m1144a(context).saveString("reportAaidAndToken", C0866r.m1184a(str3 + str2, "SHA-256"));
                StringBuilder sb = new StringBuilder();
                sb.append("Report success ");
                sb.append(saveString ? "and save success." : "but save failure.");
                HMSLog.m1374d("ReportAaidToken", sb.toString());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Https response body's ret code: ");
            sb2.append(optInt);
            sb2.append(", error message: ");
            sb2.append(jSONObject.optString("msg"));
            HMSLog.m1377e("ReportAaidToken", sb2.toString());
        } catch (JSONException unused) {
            HMSLog.m1377e("ReportAaidToken", "Has JSONException.");
        } catch (Exception unused2) {
            HMSLog.m1377e("ReportAaidToken", "Exception occur.");
        }
    }
}
