package com.mbridge.msdk.mbnative.e.a;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.List;
import org.json.JSONObject;

/* compiled from: NativeResponseHandler */
public abstract class b extends f<JSONObject> {
    private static final String a = b.class.getSimpleName();
    private int b;
    private String c;

    public abstract void a(int i, String str);

    public abstract void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit);

    public abstract void b(List<Frame> list);

    public final void a(String str) {
        this.c = str;
    }

    public final String f() {
        return this.c;
    }

    public final void g(int i) {
        this.b = i;
    }

    public final int g() {
        return this.b;
    }

    public final void a() {
        super.a();
    }

    public final void a(k<JSONObject> kVar) {
        CampaignUnit campaignUnit;
        CampaignUnit campaignUnit2;
        super.a(kVar);
        if (kVar != null && kVar.c != null) {
            int i = this.b;
            if (i == 0) {
                List<com.mbridge.msdk.foundation.same.net.c.b> list = kVar.c.d;
                JSONObject jSONObject = (JSONObject) kVar.a;
                int optInt = jSONObject.optInt("status");
                if (1 == optInt) {
                    a(System.currentTimeMillis());
                    if ("v5".equals(jSONObject.optString("version"))) {
                        campaignUnit2 = CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA));
                    } else {
                        campaignUnit2 = CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA));
                    }
                    if (campaignUnit2 == null || campaignUnit2.getAds() == null || campaignUnit2.getAds().size() <= 0) {
                        a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
                        return;
                    }
                    a(list, campaignUnit2);
                    a(campaignUnit2.getAds().size());
                    return;
                }
                a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            } else if (i == 1) {
                List<com.mbridge.msdk.foundation.same.net.c.b> list2 = kVar.c.d;
                JSONObject jSONObject2 = (JSONObject) kVar.a;
                int optInt2 = jSONObject2.optInt("status");
                if (1 == optInt2) {
                    a(System.currentTimeMillis());
                    if ("v5".equals(jSONObject2.optString("version"))) {
                        campaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA));
                    } else {
                        campaignUnit = CampaignUnit.parseCampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA));
                    }
                    if (campaignUnit == null || campaignUnit.getListFrames() == null || campaignUnit.getListFrames().size() <= 0) {
                        a(optInt2, jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE));
                        return;
                    }
                    b(campaignUnit.getListFrames());
                    a(campaignUnit.getListFrames().size());
                    return;
                }
                a(optInt2, jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE));
            }
        }
    }

    public final void a(a aVar) {
        a(aVar.a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar.a));
    }
}
