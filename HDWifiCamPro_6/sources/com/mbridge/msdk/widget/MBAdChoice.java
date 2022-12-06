package com.mbridge.msdk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.out.NativeListener;

public class MBAdChoice extends MBImageView {
    private static String a = "MBAdChoice";
    private String b = "";
    private String c = "";
    private String d = "";
    private Context e;

    public MBAdChoice(Context context) {
        super(context);
        this.e = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = context;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCampaign(com.mbridge.msdk.out.Campaign r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.mbridge.msdk.foundation.entity.CampaignEx
            if (r0 == 0) goto L_0x0093
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0040
            com.mbridge.msdk.foundation.entity.CampaignEx$a r2 = r4.getAdchoice()
            if (r2 == 0) goto L_0x0040
            com.mbridge.msdk.foundation.entity.CampaignEx$a r2 = r4.getAdchoice()
            java.lang.String r2 = r2.e()
            r3.b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0040
            com.mbridge.msdk.foundation.entity.CampaignEx$a r2 = r4.getAdchoice()
            java.lang.String r2 = r2.d()
            r3.d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0040
            com.mbridge.msdk.foundation.entity.CampaignEx$a r4 = r4.getAdchoice()
            java.lang.String r4 = r4.f()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0040
            r4 = r0
            goto L_0x0041
        L_0x0040:
            r4 = r1
        L_0x0041:
            if (r4 != 0) goto L_0x007a
            com.mbridge.msdk.b.b r4 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r2 = r2.h()
            com.mbridge.msdk.b.a r4 = r4.b(r2)
            if (r4 == 0) goto L_0x0079
            java.lang.String r2 = r4.O()
            r3.b = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0079
            java.lang.String r2 = r4.Q()
            r3.d = r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0079
            java.lang.String r4 = r4.P()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0079
            r4 = r0
            goto L_0x007a
        L_0x0079:
            r4 = r1
        L_0x007a:
            java.lang.String r0 = r3.b
            r3.setImageUrl(r0)
            if (r4 == 0) goto L_0x0093
            android.content.Context r4 = r3.e
            if (r4 == 0) goto L_0x0093
            com.mbridge.msdk.foundation.same.c.b r4 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r4)
            java.lang.String r0 = r3.b
            com.mbridge.msdk.widget.MBAdChoice$1 r1 = new com.mbridge.msdk.widget.MBAdChoice$1
            r1.<init>()
            r4.a((java.lang.String) r0, (com.mbridge.msdk.foundation.same.c.c) r1)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.widget.MBAdChoice.setCampaign(com.mbridge.msdk.out.Campaign):void");
    }

    public boolean performClick() {
        if (TextUtils.isEmpty(this.d)) {
            return true;
        }
        t.b(this.e, this.d, (NativeListener.NativeTrackingListener) null);
        return true;
    }
}
