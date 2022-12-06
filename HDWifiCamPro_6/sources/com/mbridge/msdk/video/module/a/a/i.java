package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.video.module.a.a;

/* compiled from: ProxyOnNotifyListener */
public class i extends f {
    protected a b;

    public i(a aVar) {
        this.b = aVar;
    }

    public void a(int i, Object obj) {
        super.a(i, obj);
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(i, obj);
        }
    }
}
