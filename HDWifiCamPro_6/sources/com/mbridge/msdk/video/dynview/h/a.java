package com.mbridge.msdk.video.dynview.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.video.dynview.b;
import com.mbridge.msdk.video.dynview.d.c;
import java.util.Map;

/* compiled from: MBridgeUI */
public final class a {
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002b, code lost:
        r3 = r9.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r8, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r9, com.mbridge.msdk.video.dynview.d.c r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r7 = this;
            r7.<init>()
            com.mbridge.msdk.video.dynview.j.c r0 = new com.mbridge.msdk.video.dynview.j.c
            r0.<init>()
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r0 = r0.g()
            int r0 = com.mbridge.msdk.foundation.tools.u.h((android.content.Context) r0)
            float r0 = (float) r0
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r1 = r1.g()
            int r1 = com.mbridge.msdk.foundation.tools.u.g((android.content.Context) r1)
            float r1 = (float) r1
            r2 = 1
            if (r9 == 0) goto L_0x0043
            int r3 = r9.size()
            if (r3 <= 0) goto L_0x0043
            r3 = 0
            java.lang.Object r3 = r9.get(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3
            if (r3 == 0) goto L_0x0043
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r3.getRewardTemplateMode()
            if (r4 == 0) goto L_0x0043
            com.mbridge.msdk.foundation.entity.CampaignEx$c r3 = r3.getRewardTemplateMode()
            int r3 = r3.c()
            goto L_0x0044
        L_0x0043:
            r3 = r2
        L_0x0044:
            java.lang.String r4 = "mbridge_same_choice_one_layout_landscape"
            java.lang.String r5 = "mbridge_same_choice_one_layout_portrait"
            r6 = 2
            if (r3 == r2) goto L_0x0056
            if (r3 == r6) goto L_0x0057
            boolean r3 = com.mbridge.msdk.video.dynview.i.b.a(r8)
            if (r3 == 0) goto L_0x0055
            r3 = r6
            goto L_0x0057
        L_0x0055:
            r3 = r2
        L_0x0056:
            r4 = r5
        L_0x0057:
            com.mbridge.msdk.video.dynview.b$a r5 = new com.mbridge.msdk.video.dynview.b$a
            r5.<init>()
            com.mbridge.msdk.video.dynview.b$b r8 = r5.a((android.content.Context) r8)
            com.mbridge.msdk.video.dynview.b$b r8 = r8.a((java.lang.String) r4)
            com.mbridge.msdk.video.dynview.b$b r8 = r8.a((int) r2)
            com.mbridge.msdk.video.dynview.b$b r8 = r8.a((float) r1)
            com.mbridge.msdk.video.dynview.b$b r8 = r8.b((float) r0)
            com.mbridge.msdk.video.dynview.b$b r8 = r8.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r9)
            com.mbridge.msdk.video.dynview.b$b r8 = r8.b((int) r3)
            com.mbridge.msdk.video.dynview.b r8 = r8.a()
            r7.a(r8, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.h.a.<init>(android.content.Context, java.util.List, com.mbridge.msdk.video.dynview.d.c, java.util.Map):void");
    }

    public a(b bVar, c cVar, Map<String, Object> map) {
        a(bVar, cVar, map);
    }

    private void a(b bVar, final c cVar, Map<String, Object> map) {
        if (cVar != null) {
            if (bVar == null) {
                cVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            } else if (bVar.a() == null) {
                cVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
            } else if (TextUtils.isEmpty(bVar.b())) {
                cVar.a(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_LAYOUTNAME);
            } else {
                final View inflate = LayoutInflater.from(bVar.a()).inflate(k.a(bVar.a(), bVar.b(), TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                com.mbridge.msdk.video.dynview.b.b.a().a(inflate, bVar, map);
                com.mbridge.msdk.video.dynview.b.a.a().a(inflate, bVar, map, new com.mbridge.msdk.video.dynview.d.b() {
                    public final void a() {
                        cVar.a(inflate);
                    }

                    public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                        cVar.a(aVar);
                    }
                });
            }
        }
    }
}
