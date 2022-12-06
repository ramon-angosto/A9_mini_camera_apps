package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1823gf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.r */
public class C2076r {

    /* renamed from: a */
    private static ArrayList<Pair<String, byte[]>> f3944a = new ArrayList<>();

    /* renamed from: a */
    private static final Map<String, byte[]> f3945a = new HashMap();

    /* renamed from: a */
    public static void m5324a(Context context, int i, String str) {
        synchronized (f3945a) {
            for (String next : f3945a.keySet()) {
                m5325a(context, next, f3945a.get(next), i, str);
            }
            f3945a.clear();
        }
    }

    /* renamed from: a */
    public static void m5325a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, C1970ab.m4883a(str));
    }

    /* renamed from: a */
    public static void m5326a(XMPushService xMPushService) {
        try {
            synchronized (f3945a) {
                for (String next : f3945a.keySet()) {
                    C1970ab.m4888a(xMPushService, next, f3945a.get(next));
                }
                f3945a.clear();
            }
        } catch (C1823gf e) {
            C1524b.m2160d("fail to deal with pending register request. " + e);
            xMPushService.mo18410a(10, (Exception) e);
        }
    }

    /* renamed from: a */
    public static void m5327a(String str, byte[] bArr) {
        synchronized (f3945a) {
            f3945a.put(str, bArr);
        }
    }

    /* renamed from: b */
    public static void m5328b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f3944a) {
                arrayList = f3944a;
                f3944a = new ArrayList<>();
            }
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                C1970ab.m4888a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (C1823gf e) {
            C1524b.m2160d("meet error when process pending message. " + e);
            xMPushService.mo18410a(10, (Exception) e);
        }
    }

    /* renamed from: b */
    public static void m5329b(String str, byte[] bArr) {
        synchronized (f3944a) {
            f3944a.add(new Pair(str, bArr));
            if (f3944a.size() > 50) {
                f3944a.remove(0);
            }
        }
    }
}
