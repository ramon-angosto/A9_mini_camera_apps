package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1793fj;
import com.xiaomi.push.C1827gj;
import com.xiaomi.push.C1829gk;
import com.xiaomi.push.C1830gl;
import com.xiaomi.push.C1832gn;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.service.C2003az;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.service.f */
public class C2058f {

    /* renamed from: a */
    private C2078s f3885a = new C2078s();

    /* renamed from: a */
    public static String m5216a(C2003az.C2005b bVar) {
        StringBuilder sb;
        String str;
        if (!"9".equals(bVar.f3748g)) {
            sb = new StringBuilder();
            sb.append(bVar.f3738a);
            str = ".permission.MIPUSH_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.f3738a);
            str = ".permission.MIMC_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    private static void m5217a(Context context, Intent intent, C2003az.C2005b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, m5216a(bVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2003az.C2005b mo18521a(C1793fj fjVar) {
        Collection a = C2003az.mo18481a().mo18483a(Integer.toString(fjVar.mo17615a()));
        if (a.isEmpty()) {
            return null;
        }
        Iterator it = a.iterator();
        if (a.size() == 1) {
            return (C2003az.C2005b) it.next();
        }
        String g = fjVar.mo17629g();
        while (it.hasNext()) {
            C2003az.C2005b bVar = (C2003az.C2005b) it.next();
            if (TextUtils.equals(g, bVar.f3742b)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xiaomi.push.service.C2003az.C2005b mo18522a(com.xiaomi.push.C1830gl r6) {
        /*
            r5 = this;
            com.xiaomi.push.service.az r0 = com.xiaomi.push.service.C2003az.mo18481a()
            java.lang.String r1 = r6.mo17727k()
            java.util.Collection r0 = r0.mo18483a((java.lang.String) r1)
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 == 0) goto L_0x0014
            return r2
        L_0x0014:
            java.util.Iterator r1 = r0.iterator()
            int r0 = r0.size()
            r3 = 1
            if (r0 != r3) goto L_0x0026
            java.lang.Object r6 = r1.next()
            com.xiaomi.push.service.az$b r6 = (com.xiaomi.push.service.C2003az.C2005b) r6
            return r6
        L_0x0026:
            java.lang.String r0 = r6.mo17731m()
            java.lang.String r6 = r6.mo17729l()
        L_0x002e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x004b
            java.lang.Object r3 = r1.next()
            com.xiaomi.push.service.az$b r3 = (com.xiaomi.push.service.C2003az.C2005b) r3
            java.lang.String r4 = r3.f3742b
            boolean r4 = android.text.TextUtils.equals(r0, r4)
            if (r4 != 0) goto L_0x004a
            java.lang.String r4 = r3.f3742b
            boolean r4 = android.text.TextUtils.equals(r6, r4)
            if (r4 == 0) goto L_0x002e
        L_0x004a:
            return r3
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2058f.mo18522a(com.xiaomi.push.gl):com.xiaomi.push.service.az$b");
    }

    /* renamed from: a */
    public void mo18523a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (C1938m.m4729c()) {
            intent.addFlags(16777216);
        }
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public void mo18524a(Context context, C2003az.C2005b bVar, int i) {
        if (!"5".equalsIgnoreCase(bVar.f3748g)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.f3738a);
            intent.putExtra(C2014bd.f3800s, bVar.f3748g);
            intent.putExtra("ext_reason", i);
            intent.putExtra(C2014bd.f3797p, bVar.f3742b);
            intent.putExtra(C2014bd.f3773E, bVar.f3750i);
            if (bVar.f3732a == null || !"9".equals(bVar.f3748g)) {
                m5217a(context, intent, bVar);
                return;
            }
            try {
                bVar.f3732a.send(Message.obtain((Handler) null, 17, intent));
            } catch (RemoteException unused) {
                bVar.f3732a = null;
                C1524b.m2141a("peer may died: " + bVar.f3742b.substring(bVar.f3742b.lastIndexOf(64)));
            }
        }
    }

    /* renamed from: a */
    public void mo18525a(Context context, C2003az.C2005b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.f3748g)) {
            C1524b.m2160d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f3738a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.f3748g);
        intent.putExtra(C2014bd.f3797p, bVar.f3742b);
        intent.putExtra(C2014bd.f3773E, bVar.f3750i);
        m5217a(context, intent, bVar);
    }

    /* renamed from: a */
    public void mo18526a(Context context, C2003az.C2005b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.f3748g)) {
            this.f3885a.mo18565a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f3738a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f3748g);
        intent.putExtra(C2014bd.f3797p, bVar.f3742b);
        intent.putExtra(C2014bd.f3773E, bVar.f3750i);
        m5217a(context, intent, bVar);
    }

    /* renamed from: a */
    public void mo18527a(XMPushService xMPushService, String str, C1793fj fjVar) {
        C2003az.C2005b a = mo18521a(fjVar);
        if (a == null) {
            C1524b.m2160d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f3885a.mo18566a(xMPushService, fjVar, a);
        } else {
            String str2 = a.f3738a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_rcv_timestamp", System.currentTimeMillis());
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", fjVar.mo17619a(a.f3749h));
            intent.putExtra(C2014bd.f3773E, a.f3750i);
            intent.putExtra(C2014bd.f3804w, a.f3749h);
            if (a.f3732a != null) {
                try {
                    a.f3732a.send(Message.obtain((Handler) null, 17, intent));
                    C1524b.m2141a("message was sent by messenger for chid=" + str);
                    return;
                } catch (RemoteException unused) {
                    a.f3732a = null;
                    C1524b.m2141a("peer may died: " + a.f3742b.substring(a.f3742b.lastIndexOf(64)));
                }
            }
            if (!"com.xiaomi.xmsf".equals(str2)) {
                C1524b.m2141a("broadcast message to " + str2 + ", chid=" + str);
                m5217a((Context) xMPushService, intent, a);
            }
        }
    }

    /* renamed from: a */
    public void mo18528a(XMPushService xMPushService, String str, C1830gl glVar) {
        String str2;
        String str3;
        C2003az.C2005b a = mo18522a(glVar);
        if (a == null) {
            str3 = "error while notify channel closed! channel " + str + " not registered";
        } else if ("5".equalsIgnoreCase(str)) {
            this.f3885a.mo18567a(xMPushService, glVar, a);
            return;
        } else {
            String str4 = a.f3738a;
            if (glVar instanceof C1829gk) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (glVar instanceof C1827gj) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (glVar instanceof C1832gn) {
                str2 = "com.xiaomi.push.new_pres";
            } else {
                str3 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", glVar.mo17698a());
            intent.putExtra(C2014bd.f3773E, a.f3750i);
            intent.putExtra(C2014bd.f3804w, a.f3749h);
            m5217a((Context) xMPushService, intent, a);
            return;
        }
        C1524b.m2160d(str3);
    }
}
