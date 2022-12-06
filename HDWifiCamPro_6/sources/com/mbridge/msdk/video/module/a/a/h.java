package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

/* compiled from: PlayableStatisticsOnNotifyListener */
public final class h extends k {
    public h(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
    }

    public final void a(int i, Object obj) {
        if (i == 100) {
            g();
            f();
            e();
            a(2);
        } else if (i == 109) {
            b(2);
        } else if (i == 122) {
            a();
        } else if (i != 129) {
            String str = "";
            if (i == 118) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(3, str);
            } else if (i == 119) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(4, str);
            }
        } else if (this.b != null && this.b.getPlayable_ads_without_video() == 2) {
            g();
            f();
            e();
            a(1);
        }
        super.a(i, obj);
    }
}
