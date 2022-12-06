package com.mbridge.msdk.video.module.a.a;

import android.os.Handler;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: VideoViewDefaultListener */
public final class m extends o {
    /* access modifiers changed from: private */
    public MBridgeVideoView k;
    /* access modifiers changed from: private */
    public MBridgeContainerView l;
    private int m;
    private Timer n;
    /* access modifiers changed from: private */
    public Handler o = new Handler();
    private boolean p = false;
    private boolean q = false;
    private int r;
    private int s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, int i, int i2, com.mbridge.msdk.video.module.a.a aVar2, int i3, boolean z, int i4) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i3, z);
        MBridgeVideoView mBridgeVideoView2 = mBridgeVideoView;
        MBridgeContainerView mBridgeContainerView2 = mBridgeContainerView;
        boolean z2 = true;
        this.r = 1;
        this.k = mBridgeVideoView2;
        this.l = mBridgeContainerView2;
        this.s = i;
        this.m = i2;
        this.r = i4;
        if (mBridgeVideoView2 != null) {
            this.p = mBridgeVideoView.getVideoSkipTime() != 0 ? false : z2;
        }
        if (mBridgeVideoView2 == null || mBridgeContainerView2 == null) {
            this.a = false;
        }
    }

    public final void a(int i, Object obj) {
        Integer num;
        int i2 = 16;
        if (this.a) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i != 8) {
                                switch (i) {
                                    case 10:
                                        this.q = true;
                                        this.k.soundOperate(0, 2);
                                        this.k.progressOperate(0, 2);
                                        break;
                                    case 11:
                                        this.k.videoOperate(3);
                                        this.k.dismissAllAlert();
                                        if (this.b.getVideo_end_type() == 3) {
                                            this.k.setVisibility(0);
                                        } else if (this.b.getAdSpaceT() != 2) {
                                            this.k.setVisibility(8);
                                        }
                                        if (this.b.getAdSpaceT() != 2) {
                                            this.l.showEndcard(this.b.getVideo_end_type());
                                            break;
                                        } else {
                                            this.l.showVideoEndCover();
                                            break;
                                        }
                                    case 12:
                                        h();
                                        this.k.videoOperate(3);
                                        this.k.dismissAllAlert();
                                        if (this.b.getVideo_end_type() != 3) {
                                            this.k.setVisibility(8);
                                        } else {
                                            this.k.setVisibility(0);
                                        }
                                        if (this.q || this.r != 0) {
                                            if (!this.q && this.r == 1) {
                                                g();
                                                f();
                                                e();
                                            }
                                            if (this.b.getAdSpaceT() == 2) {
                                                this.l.showVideoEndCover();
                                                break;
                                            } else {
                                                this.l.showEndcard(this.b.getVideo_end_type());
                                                break;
                                            }
                                        }
                                    case 13:
                                        this.k.closeVideoOperate(0, 2);
                                        break;
                                    case 14:
                                        if (!this.p) {
                                            this.k.closeVideoOperate(0, 1);
                                            break;
                                        }
                                        break;
                                    case 15:
                                        if (obj != null && (obj instanceof MBridgeVideoView.a)) {
                                            MBridgeVideoView.a aVar = (MBridgeVideoView.a) obj;
                                            int videoInteractiveType = this.l.getVideoInteractiveType();
                                            if (this.b.getAdSpaceT() == 2) {
                                                this.l.showVideoClickView(1);
                                            } else if (videoInteractiveType >= 0 && aVar.a >= videoInteractiveType) {
                                                this.l.showVideoClickView(1);
                                                this.k.soundOperate(0, 1);
                                            }
                                            this.p = aVar.c;
                                            if (((this.m >= 0 && (aVar.a >= this.m || aVar.a == aVar.b)) || (this.b.getVideoCompleteTime() > 0 && (aVar.a > this.b.getVideoCompleteTime() || aVar.a == aVar.b))) && !this.p) {
                                                this.k.closeVideoOperate(0, 2);
                                                this.p = true;
                                                break;
                                            }
                                        }
                                }
                            } else {
                                MBridgeContainerView mBridgeContainerView = this.l;
                                if (mBridgeContainerView == null) {
                                    MBridgeVideoView mBridgeVideoView = this.k;
                                    if (mBridgeVideoView != null) {
                                        mBridgeVideoView.showAlertView();
                                    }
                                } else if (!mBridgeContainerView.showAlertWebView()) {
                                    MBridgeVideoView mBridgeVideoView2 = this.k;
                                    if (mBridgeVideoView2 != null) {
                                        mBridgeVideoView2.showAlertView();
                                    }
                                } else {
                                    MBridgeVideoView mBridgeVideoView3 = this.k;
                                    if (mBridgeVideoView3 != null) {
                                        mBridgeVideoView3.alertWebViewShowed();
                                    }
                                }
                            }
                        }
                    } else if (obj != null && (obj instanceof Integer)) {
                        if (((Integer) obj).intValue() == 1) {
                            num = 2;
                        } else {
                            num = 1;
                        }
                        this.k.soundOperate(num.intValue(), -1);
                    }
                }
                this.k.dismissAllAlert();
                this.k.videoOperate(3);
                if (this.s == 2 && !this.l.endCardShowing() && this.b.getAdSpaceT() != 2) {
                    this.l.showEndcard(this.b.getVideo_end_type());
                }
                super.a(i2, obj);
            } else if (!this.l.endCardShowing()) {
                int videoInteractiveType2 = this.l.getVideoInteractiveType();
                if (videoInteractiveType2 != -2) {
                    if (videoInteractiveType2 == -1) {
                        if (this.l.isLast()) {
                            this.l.showVideoClickView(1);
                            this.k.soundOperate(0, 1);
                            try {
                                j();
                                this.n = new Timer();
                                this.n.schedule(new TimerTask() {
                                    public final void run() {
                                        try {
                                            m.this.o.post(new Runnable() {
                                                public final void run() {
                                                    m.this.l.showVideoClickView(-1);
                                                    m.this.k.soundOperate(0, 2);
                                                }
                                            });
                                        } catch (Throwable th) {
                                            if (MBridgeConstans.DEBUG) {
                                                th.printStackTrace();
                                            }
                                        }
                                    }
                                }, 3000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            this.l.showVideoClickView(-1);
                            this.k.soundOperate(0, 2);
                            j();
                        }
                    }
                } else if (this.l.miniCardLoaded()) {
                    this.l.showVideoClickView(2);
                }
            }
        }
        i2 = i;
        super.a(i2, obj);
    }

    private void j() {
        try {
            if (this.n != null) {
                this.n.cancel();
                this.n = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
