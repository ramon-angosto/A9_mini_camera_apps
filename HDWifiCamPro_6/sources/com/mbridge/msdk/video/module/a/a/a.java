package com.mbridge.msdk.video.module.a.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.click.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;

/* compiled from: CommonContainerNotifyListener */
public class a extends f {
    private Activity a;
    private CampaignEx b;

    public a(Activity activity, CampaignEx campaignEx) {
        this.a = activity;
        this.b = campaignEx;
    }

    public void a(int i, Object obj) {
        super.a(i, obj);
        if (i == 106 && this.a != null && this.b != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                String a2 = b.a(this.b.getClickURL(), "-999", "-999");
                if (!TextUtils.isEmpty(a2)) {
                    intent.setData(Uri.parse(a2));
                    this.a.startActivity(intent);
                }
            } catch (Throwable th) {
                q.a("NotifyListener", th.getMessage(), th);
            }
            this.a.finish();
        }
    }
}
