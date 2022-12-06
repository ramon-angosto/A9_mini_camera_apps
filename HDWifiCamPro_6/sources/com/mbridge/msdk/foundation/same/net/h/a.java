package com.mbridge.msdk.foundation.same.net.h;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;

/* compiled from: CampaignRequest */
public class a extends b {
    public a(Context context) {
        super(context);
    }

    public void a(String str, d dVar) {
        try {
            int c = u.c();
            String d = u.d();
            if (dVar != null) {
                dVar.a("misk_spt", String.valueOf(c));
                if (!TextUtils.isEmpty(d)) {
                    dVar.a("misk_spt_det", d);
                }
            }
        } catch (Exception e) {
            q.a("CampaignRequest", e.getMessage());
        } catch (Throwable th) {
            super.a(str, dVar);
            throw th;
        }
        super.a(str, dVar);
    }
}
