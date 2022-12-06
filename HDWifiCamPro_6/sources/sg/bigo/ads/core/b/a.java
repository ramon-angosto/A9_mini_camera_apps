package sg.bigo.ads.core.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.api.b;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.common.utils.o;

public final class a {
    public static Map<String, Object> a(String str, g gVar, b bVar, Integer num) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        hashMap.put("slot", gVar.k());
        hashMap.put("config_id", Long.valueOf(e.a.c()));
        hashMap.put("placement_id", gVar.m());
        hashMap.put("strategy_id", gVar.a());
        hashMap.put("ad_type", Integer.valueOf(gVar.b()));
        hashMap.put("abflags", o.a(e.a.d(), gVar.n()));
        hashMap.put(CampaignEx.JSON_KEY_ST_TS, Long.valueOf(System.currentTimeMillis()));
        hashMap.put("begin_ts", Long.valueOf(bVar.d()));
        hashMap.put("banner_type", Integer.valueOf(bVar.b));
        hashMap.put("adn_name", "bigoad");
        JSONObject jSONObject = new JSONObject();
        try {
            b.a aVar = bVar.c;
            if (aVar != null) {
                jSONObject.putOpt("session_id", aVar.a());
                jSONObject.putOpt("gps_country", aVar.b());
                jSONObject.putOpt("sim_country", aVar.c());
                jSONObject.putOpt("system_country", aVar.d());
            }
            if (num != null) {
                jSONObject.put("auc_mode", num);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put("extra_json", jSONObject.toString());
        return hashMap;
    }

    public static Map<String, Object> a(String str, sg.bigo.ads.api.core.g gVar, Integer num, String str2, String str3) {
        JSONObject jSONObject;
        Map<String, Object> a = a(str, gVar.b, gVar.d, num);
        c cVar = gVar.a;
        a.put("ad_id", cVar.g());
        a.put(CampaignEx.JSON_KEY_CREATIVE_ID, cVar.o());
        a.put("sid", Long.valueOf(cVar.n()));
        a.put("series_id", cVar.p());
        a.put("adx_type", Integer.valueOf(cVar.l()));
        a.put("mapping_slot", cVar.A());
        a.put("enc_price", cVar.w());
        String x = cVar.x();
        if (!TextUtils.isEmpty(x)) {
            a.put("abflags", o.a((String) a.get("abflags"), x));
        }
        Object obj = a.get("extra_json");
        if (obj == null || !(obj instanceof String)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject((String) obj);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                new JSONObject();
                throw th;
            }
        }
        try {
            jSONObject.put("dsp", cVar.k());
            jSONObject.put("logid", cVar.D());
            b.a aVar = gVar.d.c;
            if (aVar != null) {
                jSONObject.put("session_id", aVar.a());
            }
            if (sg.bigo.ads.api.core.b.b(gVar.b.b())) {
                jSONObject.put("style_id", cVar.G());
            }
            if (str2 != null) {
                jSONObject.putOpt("sec_price", str2);
            }
            if (str3 != null) {
                jSONObject.putOpt("sec_bidder", str3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a.put("extra_json", jSONObject.toString());
        return a;
    }
}
