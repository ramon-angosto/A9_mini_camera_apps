package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.videocommon.b.c;

/* compiled from: DefaultShowRewardListener */
public class b implements h {
    public void a() {
        q.a("ShowRewardListener", "onAdShow");
    }

    public void a(boolean z, c cVar) {
        q.a("ShowRewardListener", "onAdClose:isCompleteView:" + z + ",reward:" + cVar);
    }

    public void a(String str) {
        q.a("ShowRewardListener", "onShowFail:" + str);
    }

    public void a(boolean z, String str, String str2) {
        q.a("ShowRewardListener", "onVideoAdClicked:" + str2);
    }

    public void a(String str, String str2) {
        q.a("ShowRewardListener", "onVideoComplete: " + str2);
    }

    public void a(boolean z, int i) {
        q.a("ShowRewardListener", "onAdCloseWithIVReward: " + z + "  " + i);
    }

    public void b(String str, String str2) {
        q.a("ShowRewardListener", "onEndcardShow: " + str2);
    }

    public void a(int i, String str, String str2) {
        q.a("ShowRewardListener", "onAutoLoad: " + str2);
    }
}
