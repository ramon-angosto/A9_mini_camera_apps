package com.mbridge.msdk.advanced.e;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.c.b;
import com.mbridge.msdk.out.Frame;
import java.util.List;

/* compiled from: NativeLoadAdvancedResponseHandler */
public abstract class c extends b {
    private int a;

    public abstract void a(int i, String str);

    public abstract void a(CampaignUnit campaignUnit, int i);

    public final void a(List<Frame> list) {
    }

    public c(int i) {
        this.a = i;
    }

    public final void a(List<b> list, CampaignUnit campaignUnit) {
        a(campaignUnit, this.a);
    }

    public final void b(int i, String str) {
        a(i, str);
    }
}
