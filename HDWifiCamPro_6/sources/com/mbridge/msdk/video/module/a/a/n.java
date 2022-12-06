package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

/* compiled from: VideoViewJSListener */
public final class n extends o {
    private IJSFactory k;
    private int l;
    private boolean m = false;
    private int n;
    private boolean o = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(IJSFactory iJSFactory, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, int i, int i2, com.mbridge.msdk.video.module.a.a aVar2, int i3, boolean z, int i4) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i3, z);
        IJSFactory iJSFactory2 = iJSFactory;
        this.k = iJSFactory2;
        this.l = i;
        this.m = i2 == 0;
        if (iJSFactory2 == null) {
            this.a = false;
        }
        this.n = i4;
    }

    public final void a(int i, Object obj) {
        Integer num;
        int i2;
        if (this.a) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        int i3 = 6;
                        if (i != 6) {
                            if (i != 8) {
                                if (i != 114) {
                                    if (i != 116) {
                                        switch (i) {
                                            case 10:
                                                this.o = true;
                                                this.k.getJSNotifyProxy().a(0);
                                                break;
                                            case 11:
                                            case 12:
                                                this.k.getJSVideoModule().videoOperate(3);
                                                if (this.b.getVideo_end_type() == 3) {
                                                    this.k.getJSVideoModule().setVisible(0);
                                                } else if (this.b.getAdSpaceT() != 2) {
                                                    this.k.getJSVideoModule().setVisible(8);
                                                }
                                                if (i == 12) {
                                                    h();
                                                    i2 = 2;
                                                } else {
                                                    i2 = 1;
                                                }
                                                this.k.getJSNotifyProxy().a(i2);
                                                if (this.k.getJSCommon().g() == 2) {
                                                    this.k.getJSVideoModule().setVisible(0);
                                                    i jSVideoModule = this.k.getJSVideoModule();
                                                    this.k.getJSContainerModule().showMiniCard(jSVideoModule.getBorderViewTop(), jSVideoModule.getBorderViewLeft(), jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                                                } else if (i == 12) {
                                                    if (this.n == 1) {
                                                        if (this.b.getAdSpaceT() != 2) {
                                                            this.k.getJSContainerModule().showEndcard(this.b.getVideo_end_type());
                                                        } else {
                                                            this.k.getJSContainerModule().showVideoEndCover();
                                                        }
                                                    }
                                                } else if (this.b.getAdSpaceT() != 2) {
                                                    this.k.getJSContainerModule().showEndcard(this.b.getVideo_end_type());
                                                } else {
                                                    this.k.getJSContainerModule().showVideoEndCover();
                                                }
                                                this.k.getJSVideoModule().dismissAllAlert();
                                                if (i == 12 && !this.o && this.n == 1) {
                                                    h();
                                                    g();
                                                    f();
                                                    e();
                                                    break;
                                                }
                                            case 13:
                                                if (!this.k.getJSVideoModule().isH5Canvas()) {
                                                    this.k.getJSVideoModule().closeVideoOperate(0, 2);
                                                }
                                                this.k.getJSNotifyProxy().a(-1);
                                                break;
                                            case 14:
                                                if (!this.m) {
                                                    this.k.getJSVideoModule().closeVideoOperate(0, 1);
                                                    break;
                                                }
                                                break;
                                            case 15:
                                                if (obj != null && (obj instanceof MBridgeVideoView.a)) {
                                                    this.m = true;
                                                    this.k.getJSNotifyProxy().a((MBridgeVideoView.a) obj);
                                                    break;
                                                }
                                            default:
                                                switch (i) {
                                                    case 123:
                                                    case 124:
                                                        f jSNotifyProxy = this.k.getJSNotifyProxy();
                                                        if (i == 123) {
                                                            i3 = 7;
                                                        }
                                                        jSNotifyProxy.a(i3, "");
                                                        break;
                                                    case 125:
                                                        this.k.getJSContainerModule().hideAlertWebview();
                                                        break;
                                                }
                                        }
                                    } else {
                                        i jSVideoModule2 = this.k.getJSVideoModule();
                                        this.k.getJSContainerModule().configurationChanged(jSVideoModule2.getBorderViewWidth(), jSVideoModule2.getBorderViewHeight(), jSVideoModule2.getBorderViewRadius());
                                    }
                                } else if (this.k.getJSCommon().g() == 2) {
                                    i jSVideoModule3 = this.k.getJSVideoModule();
                                    this.k.getJSContainerModule().showMiniCard(jSVideoModule3.getBorderViewTop(), jSVideoModule3.getBorderViewLeft(), jSVideoModule3.getBorderViewWidth(), jSVideoModule3.getBorderViewHeight(), jSVideoModule3.getBorderViewRadius());
                                }
                            } else if (!this.k.getJSContainerModule().showAlertWebView()) {
                                this.k.getJSVideoModule().showAlertView();
                            } else {
                                this.k.getJSVideoModule().alertWebViewShowed();
                            }
                        }
                    } else if (obj != null && (obj instanceof Integer)) {
                        if (((Integer) obj).intValue() == 1) {
                            num = 2;
                        } else {
                            num = 1;
                        }
                        this.k.getJSVideoModule().soundOperate(num.intValue(), -1);
                        this.k.getJSNotifyProxy().a(5, num + "");
                    }
                }
                this.k.getJSVideoModule().dismissAllAlert();
                if (i == 2) {
                    this.k.getJSNotifyProxy().a(2, "");
                }
                this.k.getJSVideoModule().videoOperate(3);
                if (this.k.getJSCommon().g() != 2) {
                    if (this.b.getVideo_end_type() != 3) {
                        this.k.getJSVideoModule().setVisible(8);
                    } else {
                        this.k.getJSVideoModule().setVisible(0);
                    }
                    if (this.l == 2 && !this.k.getJSContainerModule().endCardShowing() && this.b.getAdSpaceT() != 2) {
                        this.k.getJSContainerModule().showEndcard(this.b.getVideo_end_type());
                        this.k.getJSNotifyProxy().a(1);
                    }
                }
                i = 16;
                this.k.getJSNotifyProxy().a(1);
            } else if (!this.k.getJSContainerModule().endCardShowing()) {
                this.k.getJSNotifyProxy().a(1, "");
            }
        }
        super.a(i, obj);
    }
}
