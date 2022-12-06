package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.Map;

/* compiled from: VideoViewStatisticsListener */
public class o extends k {
    protected int j = 0;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o = false;
    private Map<Integer, String> p;
    private int q = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(CampaignEx campaignEx, c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
        if (this.a) {
            this.p = campaignEx.getAdvImpList();
        }
        this.j = campaignEx.getVideoCompleteTime();
    }

    public void a(int i, Object obj) {
        int i2;
        if (i != 1) {
            if (!(i == 2 || i == 6)) {
                if (i != 7) {
                    int i3 = 0;
                    if (i == 15) {
                        g();
                        f();
                        e();
                        if (obj == null || !(obj instanceof MBridgeVideoView.a)) {
                            i2 = 0;
                        } else {
                            i3 = ((MBridgeVideoView.a) obj).a;
                            i2 = ((MBridgeVideoView.a) obj).b;
                        }
                        if (i2 == 0 && this.b != null) {
                            i2 = this.b.getVideoLength();
                        }
                        com.mbridge.msdk.video.module.b.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.b, i3, i2, this.i);
                        com.mbridge.msdk.video.module.b.a.a(this.b, this.p, this.f, i3);
                        if (!this.n) {
                            this.n = true;
                            com.mbridge.msdk.video.module.b.a.a(this.b, this.f);
                        }
                        if (!this.o) {
                            if (this.j != 0) {
                                i2 = this.j;
                            }
                            if (i3 >= i2) {
                                this.o = true;
                                i = 17;
                            }
                        }
                        q.d("NotifyListener", "onPlayProgress:" + i3);
                        this.q = i3;
                    } else if (i != 16) {
                        switch (i) {
                            case 11:
                                com.mbridge.msdk.videocommon.download.c.getInstance().b(false);
                                d();
                                break;
                            case 12:
                                if (obj != null && (obj instanceof String)) {
                                    a((String) obj);
                                }
                                d();
                                b();
                                c();
                                i();
                                com.mbridge.msdk.videocommon.download.c.getInstance().b(false);
                                break;
                            case 13:
                                try {
                                    b();
                                    c();
                                    break;
                                } catch (Throwable th) {
                                    q.a("NotifyListener", th.getMessage(), th);
                                    return;
                                }
                        }
                    }
                } else if (this.a && obj != null && (obj instanceof Integer)) {
                    int intValue = ((Integer) obj).intValue();
                    if (intValue == 2) {
                        if (!this.l) {
                            this.l = true;
                            com.mbridge.msdk.video.module.b.a.b(com.mbridge.msdk.foundation.controller.a.e().g(), this.b);
                        }
                    } else if (intValue == 1 && !this.k) {
                        this.k = true;
                        com.mbridge.msdk.video.module.b.a.c(com.mbridge.msdk.foundation.controller.a.e().g(), this.b);
                    }
                }
            }
            if (this.a && !this.m) {
                this.m = true;
                d();
                com.mbridge.msdk.video.module.b.a.e(com.mbridge.msdk.foundation.controller.a.e().g(), this.b);
            }
        }
        this.h.a(i, obj);
    }
}
