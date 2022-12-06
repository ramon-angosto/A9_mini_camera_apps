package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.mipush.sdk.j */
final class C1587j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f1725a;

    /* renamed from: a */
    final /* synthetic */ C1582e f1726a;

    /* renamed from: a */
    final /* synthetic */ String f1727a;

    C1587j(String str, Context context, C1582e eVar) {
        this.f1727a = str;
        this.f1725a = context;
        this.f1726a = eVar;
    }

    public void run() {
        String str;
        if (!TextUtils.isEmpty(this.f1727a)) {
            String[] split = this.f1727a.split(Constants.WAVE_SEPARATOR);
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = "";
                    break;
                }
                String str2 = split[i];
                if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                    str = str2.substring(str2.indexOf(Constants.COLON_SEPARATOR) + 1);
                    break;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str)) {
                C1524b.m2141a("ASSEMBLE_PUSH : receive correct token");
                C1586i.m2447d(this.f1725a, this.f1726a, str);
                C1586i.m2430a(this.f1725a);
                return;
            }
            C1524b.m2141a("ASSEMBLE_PUSH : receive incorrect token");
        }
    }
}
