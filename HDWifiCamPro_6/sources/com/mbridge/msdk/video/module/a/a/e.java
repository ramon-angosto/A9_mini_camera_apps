package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.q;

/* compiled from: DefaultImageLoaderListener */
public class e implements c {
    private CampaignEx a;
    protected ImageView b;
    private String c;

    public e(ImageView imageView) {
        this.b = imageView;
    }

    public e(ImageView imageView, CampaignEx campaignEx, String str) {
        this.b = imageView;
        this.a = campaignEx;
        this.c = str;
    }

    public void onSuccessLoad(Bitmap bitmap, String str) {
        if (bitmap == null) {
            try {
                q.d("ImageLoaderListener", "bitmap=null");
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        } else if (this.b != null && !bitmap.isRecycled()) {
            this.b.setImageBitmap(bitmap);
            this.b.setVisibility(0);
        }
    }

    public void onFailedLoad(String str, String str2) {
        try {
            p a2 = p.a((f) g.a(a.e().g()));
            if (this.a == null) {
                q.a("ImageLoaderListener", "campaign is null");
                return;
            }
            m mVar = new m();
            mVar.o("2000044");
            mVar.c(com.mbridge.msdk.foundation.tools.m.n(a.e().g()));
            mVar.n(this.a.getId());
            mVar.d(this.a.getImageUrl());
            mVar.k(this.a.getRequestId());
            mVar.l(this.a.getRequestIdNotice());
            mVar.m(this.c);
            mVar.p(str);
            a2.a(mVar);
            q.d("ImageLoaderListener", "desc:" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
