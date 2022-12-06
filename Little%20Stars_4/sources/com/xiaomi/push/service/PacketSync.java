package com.xiaomi.push.service;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.protobuf.b;
import com.xiaomi.push.service.y;
import com.xiaomi.smack.b;
import com.xiaomi.smack.k;
import com.xiaomi.smack.l;
import com.xiaomi.smack.packet.a;
import com.xiaomi.smack.packet.c;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.h;
import com.xiaomi.smack.util.j;
import java.util.Date;
import object.p2pipcam.utils.DataBaseHelper;

public class PacketSync {
    private XMPushService a;

    public interface PacketReceiveHandler extends Parcelable {
    }

    PacketSync(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(a aVar) {
        String c = aVar.c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(";");
            Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(b.b(), false);
            if (fallbacksByHost != null && split.length > 0) {
                fallbacksByHost.a(split);
                this.a.a(20, (Exception) null);
                this.a.a(true);
            }
        }
    }

    private void b(d dVar) {
        y.b b;
        String m = dVar.m();
        String l = dVar.l();
        if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(l) && (b = y.a().b(l, m)) != null) {
            j.a(this.a, b.a, (long) j.a(dVar.a()), true, System.currentTimeMillis());
        }
    }

    public void a(d dVar) {
        String str;
        StringBuilder sb;
        a p;
        y.b b;
        String str2;
        int i;
        int i2;
        y.c cVar;
        if (!"5".equals(dVar.l())) {
            b(dVar);
        }
        if (dVar instanceof k.b) {
            k.b bVar = (k.b) dVar;
            k.b.a b2 = bVar.b();
            String l = bVar.l();
            String m = bVar.m();
            if (!TextUtils.isEmpty(l) && (b = y.a().b(l, m)) != null) {
                if (b2 == k.b.a.a) {
                    b.a(y.c.binded, 1, 0, (String) null, (String) null);
                    str2 = "SMACK: channel bind succeeded, chid=" + l;
                } else {
                    h p2 = bVar.p();
                    com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind failed, error=" + p2.d());
                    if (p2 != null) {
                        if ("auth".equals(p2.b())) {
                            if ("invalid-sig".equals(p2.a())) {
                                com.xiaomi.channel.commonutils.logger.b.a("SMACK: bind error invalid-sig token = " + b.c + " sec = " + b.i);
                                com.xiaomi.stats.h.a(0, com.xiaomi.push.thrift.a.BIND_INVALID_SIG.a(), 1, (String) null, 0);
                            }
                            cVar = y.c.unbind;
                            i2 = 1;
                            i = 5;
                        } else if ("cancel".equals(p2.b())) {
                            cVar = y.c.unbind;
                            i2 = 1;
                            i = 7;
                        } else {
                            if ("wait".equals(p2.b())) {
                                this.a.b(b);
                                b.a(y.c.unbind, 1, 7, p2.a(), p2.b());
                            }
                            str2 = "SMACK: channel bind failed, chid=" + l + " reason=" + p2.a();
                        }
                        b.a(cVar, i2, i, p2.a(), p2.b());
                        y.a().a(l, m);
                        str2 = "SMACK: channel bind failed, chid=" + l + " reason=" + p2.a();
                    } else {
                        return;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.a(str2);
                return;
            }
            return;
        }
        String l2 = dVar.l();
        if (TextUtils.isEmpty(l2)) {
            l2 = "1";
            dVar.l(l2);
        }
        if (!l2.equals(PushConstants.PUSH_TYPE_NOTIFY)) {
            if (dVar instanceof com.xiaomi.smack.packet.b) {
                a p3 = dVar.p("kick");
                if (p3 != null) {
                    String m2 = dVar.m();
                    String a2 = p3.a(DataBaseHelper.KEY_TYPE);
                    String a3 = p3.a("reason");
                    com.xiaomi.channel.commonutils.logger.b.a("kicked by server, chid=" + l2 + " userid=" + m2 + " type=" + a2 + " reason=" + a3);
                    if ("wait".equals(a2)) {
                        y.b b3 = y.a().b(l2, m2);
                        if (b3 != null) {
                            this.a.b(b3);
                            b3.a(y.c.unbind, 3, 0, a3, a2);
                            return;
                        }
                        return;
                    }
                    this.a.a(l2, m2, 3, a3, a2);
                    y.a().a(l2, m2);
                    return;
                }
            } else if (dVar instanceof c) {
                c cVar2 = (c) dVar;
                if ("redir".equals(cVar2.b())) {
                    a p4 = cVar2.p("hosts");
                    if (p4 != null) {
                        a(p4);
                        return;
                    }
                    return;
                }
            }
            this.a.d().a(this.a, l2, dVar);
            return;
        } else if (dVar instanceof com.xiaomi.smack.packet.b) {
            com.xiaomi.smack.packet.b bVar2 = (com.xiaomi.smack.packet.b) dVar;
            if (PushConstants.PUSH_TYPE_NOTIFY.equals(dVar.k()) && "result".equals(bVar2.b().toString())) {
                com.xiaomi.smack.a g = this.a.g();
                if (g instanceof l) {
                    ((l) g).x();
                }
                com.xiaomi.stats.h.b();
            } else if ("command".equals(bVar2.b().toString()) && (p = dVar.p("u")) != null) {
                String a4 = p.a(PushConstants.WEB_URL);
                String a5 = p.a("startts");
                String a6 = p.a("endts");
                try {
                    Date date = new Date(Long.parseLong(a5));
                    Date date2 = new Date(Long.parseLong(a6));
                    String a7 = p.a(Constants.EXTRA_KEY_TOKEN);
                    boolean equals = "true".equals(p.a("force"));
                    String a8 = p.a("maxlen");
                    com.xiaomi.push.log.b.a((Context) this.a).a(a4, a7, date2, date, !TextUtils.isEmpty(a8) ? Integer.parseInt(a8) * 1024 : 0, equals);
                } catch (NumberFormatException e) {
                    com.xiaomi.channel.commonutils.logger.b.a("parseLong fail " + e.getMessage());
                }
            }
            if (bVar2.a("ps") != null) {
                try {
                    ah.a().a(b.a.b(Base64.decode(bVar2.a("ps"), 8)));
                    return;
                } catch (IllegalArgumentException e2) {
                    sb = new StringBuilder();
                    sb.append("invalid Base64 exception + ");
                    str = e2.getMessage();
                } catch (com.google.protobuf.micro.c e3) {
                    sb = new StringBuilder();
                    sb.append("invalid pb exception + ");
                    str = e3.getMessage();
                }
            } else {
                return;
            }
        } else {
            return;
        }
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
    }
}
