package com.mbridge.msdk.video.dynview.f.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.c.b;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AbsMoreOfferResponseHandler */
public abstract class a extends f<JSONObject> {
    private int a;
    private String b;

    public abstract void a(int i, String str);

    public abstract void a(List<b> list, CampaignUnit campaignUnit);

    public final void a() {
        super.a();
    }

    public final void a(k<JSONObject> kVar) {
        CampaignUnit campaignUnit;
        super.a(kVar);
        if (kVar != null && kVar.c != null && this.a == 0) {
            List<b> list = kVar.c.d;
            JSONObject jSONObject = (JSONObject) kVar.a;
            int optInt = jSONObject.optInt("status");
            if (1 == optInt) {
                a(System.currentTimeMillis());
                if ("v5".equals(jSONObject.optString("version"))) {
                    campaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.b);
                } else {
                    campaignUnit = CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.b);
                }
                if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                    String str = null;
                    if (campaignUnit != null) {
                        str = campaignUnit.getMsg();
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                    a(optInt, str);
                    return;
                }
                a(list, campaignUnit);
                a(campaignUnit.getAds().size());
                return;
            }
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        a(aVar.a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar.a));
    }
}
