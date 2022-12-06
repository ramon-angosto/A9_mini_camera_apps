package com.mbridge.msdk.video.module.a.a;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

/* compiled from: ContainerViewStatisticsListener */
public class d extends k {
    public d(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
    }

    public void a(int i, Object obj) {
        super.a(i, obj);
        if (this.a && i != 100 && i != 101 && i != 103) {
            if (i != 113) {
                if (i != 122) {
                    switch (i) {
                        case 105:
                        case 106:
                            break;
                        case 107:
                            return;
                        default:
                            switch (i) {
                                case 109:
                                    b(2);
                                    a(2);
                                    return;
                                case 110:
                                    b(1);
                                    a(1);
                                    return;
                                case 111:
                                    a(1);
                                    return;
                                default:
                                    return;
                            }
                    }
                } else {
                    a();
                    return;
                }
            }
            com.mbridge.msdk.video.module.b.a.d(com.mbridge.msdk.foundation.controller.a.e().g(), this.b);
            if (i != 105) {
                String noticeUrl = this.b.getNoticeUrl();
                if (!TextUtils.isEmpty(noticeUrl)) {
                    if (!noticeUrl.contains(com.mbridge.msdk.foundation.same.a.h)) {
                        noticeUrl = noticeUrl + "&" + com.mbridge.msdk.foundation.same.a.h + "=2";
                    } else {
                        noticeUrl = noticeUrl.replace(com.mbridge.msdk.foundation.same.a.h + "=" + Uri.parse(noticeUrl).getQueryParameter(com.mbridge.msdk.foundation.same.a.h), com.mbridge.msdk.foundation.same.a.h + "=2");
                    }
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.b, this.f, noticeUrl, true, false);
            }
        }
    }
}
