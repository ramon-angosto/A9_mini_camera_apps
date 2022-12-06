package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.videocommon.download.a;

/* compiled from: ContainerViewJSListener */
public final class c extends d {
    private IJSFactory j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
        IJSFactory iJSFactory2 = iJSFactory;
        this.j = iJSFactory2;
        if (iJSFactory2 == null) {
            this.a = false;
        }
    }

    public final void a(int i, Object obj) {
        if (this.a) {
            if (i != 8) {
                if (i != 103) {
                    if (i == 105) {
                        this.j.getJSNotifyProxy().a(3, obj.toString());
                        i = -1;
                    } else if (i == 107) {
                        this.j.getJSContainerModule().showVideoClickView(-1);
                        this.j.getJSVideoModule().setCover(false);
                        this.j.getJSVideoModule().setMiniEndCardState(false);
                        this.j.getJSVideoModule().videoOperate(1);
                    } else if (i == 112) {
                        this.j.getJSVideoModule().setCover(true);
                        this.j.getJSVideoModule().setMiniEndCardState(true);
                        this.j.getJSVideoModule().videoOperate(2);
                    } else if (i == 115) {
                        i jSVideoModule = this.j.getJSVideoModule();
                        this.j.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                    } else if (i != 100) {
                    }
                }
            } else if (!this.j.getJSContainerModule().showAlertWebView()) {
                this.j.getJSVideoModule().showAlertView();
            } else {
                this.j.getJSVideoModule().alertWebViewShowed();
            }
        }
        super.a(i, obj);
    }
}
