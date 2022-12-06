package com.mbridge.msdk.video.dynview.j;

import android.view.View;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.video.dynview.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ViewOptionWrapper */
public final class c {
    public final b a(View view, CampaignEx campaignEx) {
        String str;
        String str2 = "";
        int i = 102;
        if (campaignEx != null) {
            str2 = campaignEx.getCampaignUnitId();
            if (campaignEx.getRewardTemplateMode() != null) {
                i = campaignEx.getRewardTemplateMode().b();
            }
            str = i != 302 ? i != 802 ? "mbridge_reward_layer_floor" : "mbridge_reward_layer_floor_802" : "mbridge_reward_layer_floor_302";
        } else {
            str = str2;
        }
        int i2 = 0;
        com.mbridge.msdk.videocommon.d.c a = com.mbridge.msdk.videocommon.d.b.a().a(a.e().h(), str2, false);
        if (a != null) {
            i2 = a.g();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        return new b.a().a(str).a(campaignEx.getRewardTemplateMode().b()).a((List<CampaignEx>) arrayList).a(view.getContext()).a(view).c(i2).b(m.d(view.getContext())).d(i).a();
    }
}
