package com.huawei.hms.framework.network.grs.p016c.p018b;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.p016c.C0748f;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Future;

/* renamed from: com.huawei.hms.framework.network.grs.c.b.b */
public class C0742b {

    /* renamed from: a */
    private Future<C0748f> f501a;

    /* renamed from: b */
    private long f502b = SystemClock.elapsedRealtime();

    public C0742b(Future<C0748f> future) {
        this.f501a = future;
    }

    /* renamed from: a */
    public Future<C0748f> mo13841a() {
        return this.f501a;
    }

    /* renamed from: b */
    public boolean mo13842b() {
        return SystemClock.elapsedRealtime() - this.f502b <= Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL;
    }
}
