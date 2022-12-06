package com.mbridge.msdk.advanced.e;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.List;
import org.json.JSONObject;

/* compiled from: NativeAdvancedResponseHandler */
public abstract class b extends f<JSONObject> {
    private static final String a = b.class.getSimpleName();
    private int b;
    private String c;

    public abstract void a(List<Frame> list);

    public abstract void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit);

    public abstract void b(int i, String str);

    public final void a(String str) {
        this.c = str;
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
            String str = null;
            if (i == 0) {
                List<com.mbridge.msdk.foundation.same.net.c.b> list = kVar.c.d;
                JSONObject jSONObject = (JSONObject) kVar.a;
                int optInt = jSONObject.optInt("status");
                if (1 == optInt) {
                    a(System.currentTimeMillis());
                    if ("v5".equals(jSONObject.optString("version"))) {
                        campaignUnit2 = CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.c);
                    } else {
                        campaignUnit2 = CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.c);
                    }
                    if (campaignUnit2 == null || campaignUnit2.getAds() == null || campaignUnit2.getAds().size() <= 0) {
                        if (campaignUnit2 != null) {
                            str = campaignUnit2.getMsg();
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                        }
                        b(optInt, str);
                        return;
                    }
                    a(list, campaignUnit2);
                    a(campaignUnit2.getAds().size());
                    return;
                }
                b(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            } else if (i == 1) {
                List<com.mbridge.msdk.foundation.same.net.c.b> list2 = kVar.c.d;
                JSONObject jSONObject2 = (JSONObject) kVar.a;
                int optInt2 = jSONObject2.optInt("status");
                if (1 == optInt2) {
                    a(System.currentTimeMillis());
                    if ("v5".equals(jSONObject2.optString("version"))) {
                        campaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.c);
                    } else {
                        campaignUnit = CampaignUnit.parseCampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.c);
                    }
                    if (campaignUnit == null || campaignUnit.getListFrames() == null || campaignUnit.getListFrames().size() <= 0) {
                        if (campaignUnit != null) {
                            str = campaignUnit.getMsg();
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                        }
                        b(optInt2, str);
                        return;
                    }
                    List<Frame> listFrames = campaignUnit.getListFrames();
                    a(listFrames);
                    a(listFrames.size());
                    return;
                }
                b(optInt2, jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE));
            }
        }
    }

    public final void a(a aVar) {
        b(aVar.a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar.a));
    }
}
