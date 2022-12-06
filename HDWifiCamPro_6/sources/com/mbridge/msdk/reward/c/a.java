package com.mbridge.msdk.reward.c;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.c.b;
import com.mbridge.msdk.out.Frame;
import java.util.List;

/* compiled from: RewarLoadVideoResponseHandler */
public abstract class a extends c {
    public abstract void a(int i, String str);

    public abstract void a(CampaignUnit campaignUnit);

    public final void a(List<Frame> list) {
    }

    public final void a(List<b> list, CampaignUnit campaignUnit) {
        a(campaignUnit);
    }

    public final void b(int i, String str) {
        a(i, str);
    }
}
