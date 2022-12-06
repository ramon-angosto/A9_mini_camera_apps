package com.mbridge.msdk.advanced.c;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;

/* compiled from: NativeAdvancedShowListenerImpl */
public final class d {
    private NativeAdvancedAdListener a;
    private CampaignEx b;
    private c c;

    public d(c cVar, NativeAdvancedAdListener nativeAdvancedAdListener, CampaignEx campaignEx) {
        this.c = cVar;
        this.a = nativeAdvancedAdListener;
        this.b = campaignEx;
    }

    public final void a(MBridgeIds mBridgeIds) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("load_to=");
        stringBuffer.append(MBridgeConstans.ENDCARD_URL_TYPE_PL);
        stringBuffer.append("&");
        stringBuffer.append("allow_skip=");
        stringBuffer.append(this.c.c());
        stringBuffer.append("&");
        com.mbridge.msdk.foundation.same.report.d.a(a.e().g(), this.b, mBridgeIds.getUnitId(), stringBuffer.toString());
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLogImpression(mBridgeIds);
        }
    }

    public final void a(MBridgeIds mBridgeIds, String str) {
        com.mbridge.msdk.foundation.same.report.d.b(a.e().g(), this.b, mBridgeIds.getUnitId(), str);
    }

    public final void b(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onClick(mBridgeIds);
        }
    }

    public final void c(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onClose(mBridgeIds);
            c cVar = this.c;
            if (cVar != null) {
                cVar.a = false;
            }
        }
    }

    public final void d(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLeaveApp(mBridgeIds);
        }
    }

    public final void e(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.showFullScreen(mBridgeIds);
        }
    }

    public final void f(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.closeFullScreen(mBridgeIds);
        }
    }
}
