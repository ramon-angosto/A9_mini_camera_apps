package sg.bigo.ads.core.d.b;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.utils.o;

public final class a {
    final String a;
    private final long b = System.currentTimeMillis();
    private Map<String, String> c;

    public a(String str, Map<String, String> map) {
        this.a = str;
        this.c = map;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject a(e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MBridgeConstans.APP_KEY, eVar.a());
            jSONObject.putOpt("pkg_name", eVar.b());
            jSONObject.putOpt("pkg_ver", eVar.c());
            jSONObject.putOpt("pkg_vc", Integer.valueOf(eVar.d()));
            jSONObject.putOpt("pkg_ch", eVar.e());
            jSONObject.putOpt("os", eVar.f());
            jSONObject.putOpt("os_ver", eVar.g());
            jSONObject.putOpt("os_lang", eVar.h());
            jSONObject.putOpt("vendor", eVar.i());
            jSONObject.putOpt("model", eVar.j());
            jSONObject.putOpt("isp", eVar.k());
            jSONObject.putOpt("resolution", eVar.l());
            jSONObject.putOpt("dpi", Integer.valueOf(eVar.m()));
            jSONObject.putOpt("net", eVar.n());
            jSONObject.putOpt("tz", eVar.o());
            if (eVar.p()) {
                jSONObject.putOpt("ewd", String.valueOf(eVar.q() ^ 3023727));
                jSONObject.putOpt("ejd", String.valueOf(eVar.r() ^ 3023727));
            }
            jSONObject.putOpt("country", eVar.t());
            jSONObject.putOpt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, eVar.v());
            jSONObject.putOpt("city", eVar.w());
            jSONObject.putOpt("sdk_ver", eVar.x());
            jSONObject.putOpt("sdk_vc", 20401);
            jSONObject.putOpt(VungleApiClient.GAID, eVar.z());
            jSONObject.putOpt("hw_id", eVar.G());
            jSONObject.putOpt("af_id", eVar.A());
            jSONObject.putOpt("uid", eVar.B());
            jSONObject.putOpt(CampaignEx.JSON_KEY_ST_TS, Integer.valueOf(eVar.C()));
            jSONObject.putOpt("abflags", eVar.E());
            jSONObject.putOpt("gg_service_ver", eVar.H());
            jSONObject.putOpt("webkit_ver", eVar.I());
            jSONObject.putOpt("time", Long.valueOf(this.b));
            jSONObject.putOpt("event_id", this.a);
            boolean z = false;
            if (this.c != null) {
                if (o.b(this.c.get("session_id"))) {
                    this.c.put("session_id", UUID.randomUUID().toString());
                } else {
                    z = true;
                }
                for (Map.Entry next : this.c.entrySet()) {
                    jSONObject.putOpt((String) next.getKey(), next.getValue());
                }
            }
            if (!z) {
                jSONObject.putOpt("gps_country", eVar.Q());
                jSONObject.putOpt("sim_country", eVar.R());
                jSONObject.putOpt("system_country", eVar.S());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
