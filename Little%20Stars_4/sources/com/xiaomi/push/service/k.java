package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.y;
import com.xiaomi.smack.packet.c;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.util.j;
import com.xiaomi.xmpush.thrift.a;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.i;
import com.xiaomi.xmpush.thrift.l;
import com.xiaomi.xmpush.thrift.p;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class k {
    public static p a(Context context, p pVar) {
        l lVar = new l();
        lVar.b(pVar.h());
        i m = pVar.m();
        if (m != null) {
            lVar.a(m.b());
            lVar.a(m.d());
            if (!TextUtils.isEmpty(m.f())) {
                lVar.c(m.f());
            }
        }
        lVar.a(ae.a(context, pVar.f));
        p a = XMPushService.a(pVar.j(), pVar.h(), lVar, a.AckMessage);
        i a2 = pVar.m().a();
        a2.a("mat", Long.toString(System.currentTimeMillis()));
        a.a(a2);
        return a;
    }

    private static void a(XMPushService xMPushService, p pVar) {
        xMPushService.a((XMPushService.g) new m(4, xMPushService, pVar));
    }

    private static void a(XMPushService xMPushService, p pVar, String str) {
        xMPushService.a((XMPushService.g) new p(4, xMPushService, pVar, str));
    }

    private static void a(XMPushService xMPushService, p pVar, String str, String str2) {
        xMPushService.a((XMPushService.g) new q(4, xMPushService, pVar, str, str2));
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        boolean z;
        Map<String, String> s;
        XMPushService xMPushService2 = xMPushService;
        byte[] bArr2 = bArr;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        p pVar = new p();
        try {
            ae.a(pVar, bArr2);
            if (TextUtils.isEmpty(pVar.f)) {
                b.a("receive a mipush message without package name");
                return;
            }
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.putExtra("mipush_payload", bArr2);
            intent.putExtra("mrt", Long.toString(valueOf.longValue()));
            intent.setPackage(pVar.f);
            String a = r.a(pVar);
            j.a(xMPushService, a, j, true, System.currentTimeMillis());
            i m = pVar.m();
            if (m != null) {
                m.a("mrt", Long.toString(valueOf.longValue()));
            }
            if (a.SendMessage == pVar.a() && h.a((Context) xMPushService).a(pVar.f) && !r.b(pVar)) {
                String b = m != null ? m.b() : "";
                b.a("Drop a message for unregistered, msgid=" + b);
                a(xMPushService, pVar, pVar.f);
            } else if (a.SendMessage != pVar.a() || TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") || TextUtils.equals(xMPushService.getPackageName(), pVar.f)) {
                if (!(m == null || m.b() == null)) {
                    b.a(String.format("receive a message, appid=%1$s, msgid= %2$s", new Object[]{pVar.h(), m.b()}));
                }
                if (m != null && (s = m.s()) != null && s.containsKey("hide") && "true".equalsIgnoreCase(s.get("hide"))) {
                    a(xMPushService, pVar);
                } else if (c(pVar) && a((Context) xMPushService, a)) {
                    b(xMPushService, pVar);
                } else if (a(pVar) && !a((Context) xMPushService, a) && !b(pVar)) {
                    c(xMPushService, pVar);
                } else if ((r.b(pVar) && b((Context) xMPushService, pVar.f)) || a((Context) xMPushService, intent)) {
                    if (a.Registration == pVar.a()) {
                        String j2 = pVar.j();
                        SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                        edit.putString(j2, pVar.e);
                        edit.commit();
                    }
                    if (m != null && !TextUtils.isEmpty(m.h()) && !TextUtils.isEmpty(m.j()) && m.h != 1 && (r.a(m.s()) || !r.a((Context) xMPushService, pVar.f))) {
                        String str = null;
                        if (m != null) {
                            if (m.j != null) {
                                str = m.j.get("jobkey");
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = m.b();
                            }
                            z = s.a(xMPushService, pVar.f, str);
                        } else {
                            z = false;
                        }
                        if (z) {
                            b.a("drop a duplicate message, key=" + str);
                        } else {
                            r.a((Context) xMPushService, pVar, bArr2);
                            if (!r.b(pVar)) {
                                Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                                intent2.putExtra("mipush_payload", bArr2);
                                intent2.setPackage(pVar.f);
                                try {
                                    List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                                    if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                        xMPushService.sendBroadcast(intent2, b.a(pVar.f));
                                    }
                                } catch (Exception unused) {
                                    xMPushService.sendBroadcast(intent2, b.a(pVar.f));
                                }
                            }
                        }
                        a(xMPushService, pVar);
                    } else if (!"com.xiaomi.xmsf".contains(pVar.f) || pVar.c() || m == null || !m.s().containsKey("ab")) {
                        xMPushService.sendBroadcast(intent, b.a(pVar.f));
                    } else {
                        a(xMPushService, pVar);
                        b.c("receive abtest message. ack it." + m.b());
                    }
                    if (pVar.a() == a.UnRegistration && !"com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                        xMPushService.stopSelf();
                    }
                } else if (!b((Context) xMPushService, pVar.f)) {
                    xMPushService.a((XMPushService.g) new l(4, xMPushService, pVar));
                } else {
                    b.a("receive a mipush message, we can see the app, but we can't see the receiver.");
                }
            } else {
                b.a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + pVar.f);
                a(xMPushService, pVar, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + pVar.f);
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            return !packageManager.queryBroadcastReceivers(intent2, 32).isEmpty() || !packageManager.queryIntentServices(intent, 32).isEmpty();
        } catch (Exception e) {
            b.a((Throwable) e);
            return false;
        }
    }

    private static boolean a(p pVar) {
        return "com.xiaomi.xmsf".equals(pVar.f) && pVar.m() != null && pVar.m().s() != null && pVar.m().s().containsKey("miui_package_name");
    }

    private static void b(XMPushService xMPushService, p pVar) {
        xMPushService.a((XMPushService.g) new n(4, xMPushService, pVar));
    }

    private static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static boolean b(p pVar) {
        return pVar.m().s().containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, p pVar) {
        xMPushService.a((XMPushService.g) new o(4, xMPushService, pVar));
    }

    private static boolean c(p pVar) {
        if (pVar.m() == null || pVar.m().s() == null) {
            return false;
        }
        return "1".equals(pVar.m().s().get("obslete_ads_message"));
    }

    public void a(Context context, y.b bVar, boolean z, int i, String str) {
        f a;
        if (!z && (a = g.a(context)) != null && "token-expired".equals(str)) {
            try {
                g.a(context, a.d, a.e, a.f);
            } catch (IOException | JSONException e) {
                b.a(e);
            }
        }
    }

    public void a(XMPushService xMPushService, d dVar, y.b bVar) {
        if (dVar instanceof c) {
            c cVar = (c) dVar;
            com.xiaomi.smack.packet.a p = cVar.p(NotifyType.SOUND);
            if (p != null) {
                try {
                    a(xMPushService, ae.b(ae.a(bVar.i, cVar.k()), p.c()), (long) j.a(dVar.a()));
                } catch (IllegalArgumentException e) {
                    b.a((Throwable) e);
                }
            }
        } else {
            b.a("not a mipush message");
        }
    }
}
