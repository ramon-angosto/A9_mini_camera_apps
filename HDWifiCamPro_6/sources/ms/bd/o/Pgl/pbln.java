package ms.bd.o.Pgl;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class pbln extends pblm {
    private SDKMonitor b;

    class pgla implements SDKMonitor.IGetExtendParams {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ String b;

        pgla(pbln pbln, JSONObject jSONObject, String str) {
            this.a = jSONObject;
            this.b = str;
        }

        public Map<String, String> getCommonParams() {
            Object obj;
            HashMap hashMap = new HashMap();
            try {
                String str = (String) pblk.a(16777217, 0, 0, "733bae", new byte[]{41, 39, 69, 4, 77, 119, 53});
                if (this.a.getBoolean((String) pblk.a(16777217, 0, 0, "cf939d", new byte[]{125, 114, 79, 85, 21, 118, 97}))) {
                    obj = pblk.a(16777217, 0, 0, "803313", new byte[]{120});
                } else {
                    obj = pblk.a(16777217, 0, 0, "b1407d", new byte[]{35});
                }
                hashMap.put(str, (String) obj);
            } catch (JSONException unused) {
                String str2 = (String) pblk.a(16777217, 0, 0, "41424e", new byte[]{54, 54, 74, 121, 12, 97});
            }
            hashMap.put((String) pblk.a(16777217, 0, 0, "263efa", new byte[]{43, 59, 83, 5, 102, 119, 56, 19}), this.b);
            return hashMap;
        }

        public String getSessionId() {
            return null;
        }
    }

    public void a(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        SDKMonitor sDKMonitor = this.b;
        if (sDKMonitor != null) {
            sDKMonitor.monitorApiError(j, j2, str, str2, str3, i, (JSONObject) null);
        }
    }

    public void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (this.b != null) {
            if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
                this.b.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
            }
        }
    }

    public boolean a(String str) {
        JSONObject jSONObject;
        String str2;
        Context b2 = pgla.a().b();
        String str3 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            String str4 = (String) pblk.a(16777217, 0, 0, "b1d526", new byte[]{96, 54, 26});
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            str2 = jSONObject.getString((String) pblk.a(16777217, 0, 0, "3f2e27", new byte[]{49, 96, 74, 46, 12, 41, 52}));
            try {
                str3 = jSONObject.getString((String) pblk.a(16777217, 0, 0, "a19598", new byte[]{120, 60, 89, 85, 57, 46, 107, 20}));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray((String) pblk.a(16777217, 0, 0, "46cfcc", new byte[]{38, 59, 30, 20, 85, 115, 2, 37, 30, 37}));
                JSONArray jSONArray2 = jSONObject.getJSONArray((String) pblk.a(16777217, 0, 0, "460ac7", new byte[]{55, 49, 83, 26, 78, 52, 2, 37, 77, 34}));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList2.add(jSONArray2.getString(i2));
                }
                if (arrayList.size() <= 0 || arrayList2.size() <= 0) {
                    return false;
                }
                SDKMonitorUtils.setConfigUrl(str2, arrayList);
                SDKMonitorUtils.setDefaultReportUrl(str2, arrayList2);
                jSONObject.remove((String) pblk.a(16777217, 0, 0, "15de5d", new byte[]{35, 56, 25, 23, 3, 116, 7, 38, 25, 38}));
                jSONObject.remove((String) pblk.a(16777217, 0, 0, "961db1", new byte[]{58, 49, 82, 31, 79, 50, 15, 37, 76, 39}));
                SDKMonitorUtils.initMonitor(b2, str2, jSONObject, new pgla(this, jSONObject, str3));
                this.b = SDKMonitorUtils.getInstance(str2);
                return true;
            } catch (JSONException unused2) {
                String str5 = (String) pblk.a(16777217, 0, 0, "fb349b", new byte[]{100, 101, 77, ByteCompanionObject.MAX_VALUE, 15});
                jSONObject.remove((String) pblk.a(16777217, 0, 0, "15de5d", new byte[]{35, 56, 25, 23, 3, 116, 7, 38, 25, 38}));
                jSONObject.remove((String) pblk.a(16777217, 0, 0, "961db1", new byte[]{58, 49, 82, 31, 79, 50, 15, 37, 76, 39}));
                SDKMonitorUtils.initMonitor(b2, str2, jSONObject, new pgla(this, jSONObject, str3));
                this.b = SDKMonitorUtils.getInstance(str2);
                return true;
            }
        } catch (JSONException unused3) {
            str2 = null;
            String str52 = (String) pblk.a(16777217, 0, 0, "fb349b", new byte[]{100, 101, 77, ByteCompanionObject.MAX_VALUE, 15});
            jSONObject.remove((String) pblk.a(16777217, 0, 0, "15de5d", new byte[]{35, 56, 25, 23, 3, 116, 7, 38, 25, 38}));
            jSONObject.remove((String) pblk.a(16777217, 0, 0, "961db1", new byte[]{58, 49, 82, 31, 79, 50, 15, 37, 76, 39}));
            SDKMonitorUtils.initMonitor(b2, str2, jSONObject, new pgla(this, jSONObject, str3));
            this.b = SDKMonitorUtils.getInstance(str2);
            return true;
        }
    }

    public void b(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        SDKMonitor sDKMonitor = this.b;
        if (sDKMonitor != null) {
            sDKMonitor.monitorSLA(j, j2, str, str2, str3, i, (JSONObject) null);
        }
    }
}
