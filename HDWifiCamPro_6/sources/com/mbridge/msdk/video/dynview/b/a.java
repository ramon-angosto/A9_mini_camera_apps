package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.dynview.b;
import com.mbridge.msdk.video.dynview.endcard.moffer.MOfferModel;
import java.util.Map;

/* compiled from: DataEnergize */
public class a {
    private static volatile a a;

    private a() {
    }

    public static a a() {
        a aVar;
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public final void a(View view, b bVar, Map map, com.mbridge.msdk.video.dynview.d.b bVar2) {
        int h = bVar.h();
        if (h == 1) {
            new com.mbridge.msdk.video.dynview.j.a().a(bVar, view, map, bVar2);
        } else if (h == 202 || h == 302 || h == 802 || h == 904) {
            new com.mbridge.msdk.video.dynview.j.a().b(bVar, view, map, bVar2);
        } else {
            bVar2.a();
        }
    }

    public final void a(View view, CampaignEx campaignEx, com.mbridge.msdk.video.module.a.a aVar) {
        new MOfferModel().bulidMofferAd(view, campaignEx, aVar);
    }
}
