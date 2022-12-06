package com.apm.insight;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.apm.insight.entity.b;
import com.apm.insight.k.k;
import com.apm.insight.l.l;
import com.apm.insight.l.v;
import com.apm.insight.runtime.d;
import com.mbridge.msdk.MBridgeConstans;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
    protected static MonitorCrash b;
    protected MonitorCrash a;

    private g(MonitorCrash monitorCrash) {
        this.a = monitorCrash;
        b.a(this);
        com.apm.insight.j.b.d();
        k.e();
    }

    public static Object a() {
        return b;
    }

    static void a(Context context, final MonitorCrash monitorCrash) {
        b = monitorCrash;
        g gVar = new g(monitorCrash);
        final d a2 = h.a();
        Npth.init(context, new ICommonParams(gVar) {
            final /* synthetic */ g a;

            {
                this.a = r1;
            }

            public Map<String, Object> getCommonParams() {
                return l.b(this.a.e());
            }

            public String getDeviceId() {
                return TextUtils.isEmpty(monitorCrash.mConfig.mDeviceId) ? a2.d() : monitorCrash.mConfig.mDeviceId;
            }

            public List<String> getPatchInfo() {
                return null;
            }

            public Map<String, Integer> getPluginInfo() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public long getUserId() {
                return 0;
            }
        });
    }

    static void a(MonitorCrash monitorCrash) {
        new g(monitorCrash);
    }

    private JSONObject b(CrashType crashType) {
        Map<? extends String, ? extends String> userData;
        if (this.a.mCustomData == null || (userData = this.a.mCustomData.getUserData(crashType)) == null) {
            return null;
        }
        return new JSONObject(userData);
    }

    private JSONObject c(CrashType crashType) {
        return new JSONObject(this.a.mTagMap);
    }

    /* access modifiers changed from: private */
    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a.mConfig.mPackageName == null) {
                Context g = h.g();
                PackageInfo packageInfo = g.getPackageManager().getPackageInfo(g.getPackageName(), 128);
                if (packageInfo != null) {
                    if (this.a.mConfig.mVersionInt == -1) {
                        this.a.mConfig.mVersionInt = (long) packageInfo.versionCode;
                    }
                    if (this.a.mConfig.mVersionStr == null) {
                        this.a.mConfig.mVersionStr = packageInfo.versionName;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(this.a.mConfig.mDeviceId) || MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(this.a.mConfig.mDeviceId)) {
            this.a.mConfig.mDeviceId = h.c().a();
        }
        try {
            jSONObject.put("aid", String.valueOf(this.a.mConfig.mAid));
            jSONObject.put("update_version_code", this.a.mConfig.mVersionInt);
            jSONObject.put("version_code", this.a.mConfig.mVersionInt);
            jSONObject.put("app_version", this.a.mConfig.mVersionStr);
            jSONObject.put("channel", this.a.mConfig.mChannel);
            jSONObject.put("package", l.a(this.a.mConfig.mPackageName));
            jSONObject.put("device_id", this.a.mConfig.mDeviceId);
            jSONObject.put(ReportDBAdapter.ReportColumns.COLUMN_USER_ID, this.a.mConfig.mUID);
            jSONObject.put("ssid", this.a.mConfig.mSSID);
            jSONObject.put("os", "Android");
            jSONObject.put("so_list", l.a(this.a.mConfig.mSoList));
            jSONObject.put("single_upload", d() ? 1 : 0);
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    public JSONArray a(StackTraceElement[] stackTraceElementArr, Throwable th) {
        if (this.a.mConfig.mPackageName == null) {
            return new JSONArray().put(new v.a(0, stackTraceElementArr.length).a());
        }
        if (th == null || stackTraceElementArr == null) {
            return null;
        }
        return v.a(stackTraceElementArr, this.a.mConfig.mPackageName);
    }

    public JSONArray a(String[] strArr) {
        return this.a.config().mPackageName == null ? new JSONArray().put(new v.a(0, strArr.length).a()) : v.a(strArr, this.a.mConfig.mPackageName);
    }

    public JSONObject a(CrashType crashType) {
        return a(crashType, (JSONArray) null);
    }

    public JSONObject a(CrashType crashType, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", e());
            if (crashType != null) {
                jSONObject.put("custom", b(crashType));
                jSONObject.put("filters", c(crashType));
            }
            jSONObject.put("line_num", jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public boolean a(Object obj) {
        return this.a == obj;
    }

    public String b() {
        return this.a.mConfig.mAid;
    }

    public JSONObject c() {
        return e();
    }

    public boolean d() {
        return false;
    }
}
