package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1698cq;
import com.xiaomi.push.C1702cu;
import com.xiaomi.push.C1722dk;
import com.xiaomi.push.C1747ed;
import com.xiaomi.push.C1789ff;
import com.xiaomi.push.C1793fj;
import com.xiaomi.push.C1811fv;
import com.xiaomi.push.C1826gi;
import com.xiaomi.push.C1827gj;
import com.xiaomi.push.C1829gk;
import com.xiaomi.push.C1830gl;
import com.xiaomi.push.C1847gz;
import com.xiaomi.push.C1860hi;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.XMPushService;
import java.util.Date;

/* renamed from: com.xiaomi.push.service.ax */
public class C2000ax {

    /* renamed from: a */
    private XMPushService f3724a;

    C2000ax(XMPushService xMPushService) {
        this.f3724a = xMPushService;
    }

    /* renamed from: a */
    private void m5065a(C1826gi giVar) {
        String c = giVar.mo17695c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(";");
            C1698cq a = C1702cu.mo17360a().mo17358a(C1811fv.mo17670a(), false);
            if (a != null && split.length > 0) {
                a.mo17341a(split);
                this.f3724a.mo18410a(20, (Exception) null);
                this.f3724a.mo18418a(true);
            }
        }
    }

    /* renamed from: b */
    private void m5066b(C1830gl glVar) {
        C2003az.C2005b a;
        String l = glVar.mo17729l();
        String k = glVar.mo17727k();
        if (!TextUtils.isEmpty(l) && !TextUtils.isEmpty(k) && (a = C2003az.mo18481a().mo18482a(k, l)) != null) {
            C1847gz.m3818a(this.f3724a, a.f3738a, (long) C1847gz.m3810a(glVar.mo17698a()), true, true, System.currentTimeMillis());
        }
    }

    /* renamed from: c */
    private void m5067c(C1793fj fjVar) {
        C2003az.C2005b a;
        String g = fjVar.mo17629g();
        String num = Integer.toString(fjVar.mo17615a());
        if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(num) && (a = C2003az.mo18481a().mo18482a(num, g)) != null) {
            C1847gz.m3818a(this.f3724a, a.f3738a, (long) fjVar.mo17625c(), true, true, System.currentTimeMillis());
        }
    }

    /* renamed from: a */
    public void mo18477a(C1793fj fjVar) {
        if (5 != fjVar.mo17615a()) {
            m5067c(fjVar);
        }
        try {
            mo18479b(fjVar);
        } catch (Exception e) {
            C1524b.m2154a("handle Blob chid = " + fjVar.mo17615a() + " cmd = " + fjVar.mo17615a() + " packetid = " + fjVar.mo17627e() + " failure ", (Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo18478a(C1830gl glVar) {
        if (!"5".equals(glVar.mo17727k())) {
            m5066b(glVar);
        }
        String k = glVar.mo17727k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            glVar.mo17730l(k);
        }
        if (k.equals("0")) {
            C1524b.m2141a("Received wrong packet with chid = 0 : " + glVar.mo17698a());
        }
        if (glVar instanceof C1827gj) {
            C1826gi a = glVar.mo17703a("kick");
            if (a != null) {
                String l = glVar.mo17729l();
                String a2 = a.mo17692a("type");
                String a3 = a.mo17692a("reason");
                C1524b.m2141a("kicked by server, chid=" + k + " res=" + C2003az.C2005b.m5091a(l) + " type=" + a2 + " reason=" + a3);
                if ("wait".equals(a2)) {
                    C2003az.C2005b a4 = C2003az.mo18481a().mo18482a(k, l);
                    if (a4 != null) {
                        this.f3724a.mo18415a(a4);
                        a4.mo18494a(C2003az.C2009c.unbind, 3, 0, a3, a2);
                        return;
                    }
                    return;
                }
                this.f3724a.mo18416a(k, l, 3, a3, a2);
                C2003az.mo18481a().mo18482a(k, l);
                return;
            }
        } else if (glVar instanceof C1829gk) {
            C1829gk gkVar = (C1829gk) glVar;
            if ("redir".equals(gkVar.mo17701b())) {
                C1826gi a5 = gkVar.mo17703a("hosts");
                if (a5 != null) {
                    m5065a(a5);
                    return;
                }
                return;
            }
        }
        this.f3724a.mo18421b().mo18528a(this.f3724a, k, glVar);
    }

    /* renamed from: b */
    public void mo18479b(C1793fj fjVar) {
        StringBuilder sb;
        String a;
        String str;
        int i;
        int i2;
        C2003az.C2009c cVar;
        String a2 = fjVar.mo17615a();
        if (fjVar.mo17615a() != 0) {
            String num = Integer.toString(fjVar.mo17615a());
            if ("SECMSG".equals(fjVar.mo17615a())) {
                if (!fjVar.mo17615a()) {
                    this.f3724a.mo18421b().mo18527a(this.f3724a, num, fjVar);
                    return;
                }
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(fjVar.mo17623b());
                sb.append(" errStr = ");
                a = fjVar.mo17625c();
            } else if ("BIND".equals(a2)) {
                C1747ed.C1751d a3 = C1747ed.C1751d.m3190a(fjVar.mo17615a());
                String g = fjVar.mo17629g();
                C2003az.C2005b a4 = C2003az.mo18481a().mo18482a(num, g);
                if (a4 != null) {
                    if (a3.mo17407a()) {
                        C1524b.m2141a("SMACK: channel bind succeeded, chid=" + fjVar.mo17615a());
                        a4.mo18494a(C2003az.C2009c.binded, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String a5 = a3.mo17407a();
                    if ("auth".equals(a5)) {
                        if ("invalid-sig".equals(a3.mo17413b())) {
                            C1524b.m2141a("SMACK: bind error invalid-sig token = " + a4.f3744c + " sec = " + a4.f3749h);
                            C1860hi.m3863a(0, C1789ff.BIND_INVALID_SIG.mo17573a(), 1, (String) null, 0);
                        }
                        cVar = C2003az.C2009c.unbind;
                        i2 = 1;
                        i = 5;
                    } else if ("cancel".equals(a5)) {
                        cVar = C2003az.C2009c.unbind;
                        i2 = 1;
                        i = 7;
                    } else {
                        if ("wait".equals(a5)) {
                            this.f3724a.mo18415a(a4);
                            a4.mo18494a(C2003az.C2009c.unbind, 1, 7, a3.mo17413b(), a5);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.mo17413b();
                        C1524b.m2141a(str);
                    }
                    a4.mo18494a(cVar, i2, i, a3.mo17413b(), a5);
                    C2003az.mo18481a().mo18482a(num, g);
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.mo17413b();
                    C1524b.m2141a(str);
                }
                return;
            } else if ("KICK".equals(a2)) {
                C1747ed.C1754g a6 = C1747ed.C1754g.m3258a(fjVar.mo17615a());
                String g2 = fjVar.mo17629g();
                String a7 = a6.mo17407a();
                String b = a6.mo17413b();
                C1524b.m2141a("kicked by server, chid=" + num + " res= " + C2003az.C2005b.m5091a(g2) + " type=" + a7 + " reason=" + b);
                if ("wait".equals(a7)) {
                    C2003az.C2005b a8 = C2003az.mo18481a().mo18482a(num, g2);
                    if (a8 != null) {
                        this.f3724a.mo18415a(a8);
                        a8.mo18494a(C2003az.C2009c.unbind, 3, 0, b, a7);
                        return;
                    }
                    return;
                }
                this.f3724a.mo18416a(num, g2, 3, b, a7);
                C2003az.mo18481a().mo18482a(num, g2);
                return;
            } else {
                return;
            }
        } else if ("PING".equals(a2)) {
            byte[] a9 = fjVar.mo17615a();
            if (a9 != null && a9.length > 0) {
                C1747ed.C1757j a10 = C1747ed.C1757j.m3294a(a9);
                if (a10.mo17413b()) {
                    C2027bo.mo18506a().mo18507a(a10.mo17407a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.f3724a.getPackageName())) {
                this.f3724a.mo18408a();
            }
            if ("1".equals(fjVar.mo17627e())) {
                C1524b.m2141a("received a server ping");
            } else {
                C1860hi.m3869b();
            }
            this.f3724a.mo18421b();
            return;
        } else if ("SYNC".equals(a2)) {
            if ("CONF".equals(fjVar.mo17623b())) {
                C2027bo.mo18506a().mo18507a(C1747ed.C1749b.m3149a(fjVar.mo17615a()));
                return;
            } else if (TextUtils.equals("U", fjVar.mo17623b())) {
                C1747ed.C1758k a11 = C1747ed.C1758k.m3306a(fjVar.mo17615a());
                C1722dk.m3009a((Context) this.f3724a).mo17390a(a11.mo17407a(), a11.mo17413b(), new Date(a11.mo17407a()), new Date(a11.mo17413b()), a11.mo17506c() * 1024, a11.mo17508e());
                C1793fj fjVar2 = new C1793fj();
                fjVar2.mo17617a(0);
                fjVar2.mo17620a(fjVar.mo17615a(), "UCA");
                fjVar2.mo17619a(fjVar.mo17627e());
                XMPushService xMPushService = this.f3724a;
                xMPushService.mo18412a((XMPushService.C1956i) new C2025bm(xMPushService, fjVar2));
                return;
            } else if (TextUtils.equals("P", fjVar.mo17623b())) {
                C1747ed.C1756i a12 = C1747ed.C1756i.m3285a(fjVar.mo17615a());
                C1793fj fjVar3 = new C1793fj();
                fjVar3.mo17617a(0);
                fjVar3.mo17620a(fjVar.mo17615a(), "PCA");
                fjVar3.mo17619a(fjVar.mo17627e());
                C1747ed.C1756i iVar = new C1747ed.C1756i();
                if (a12.mo17407a()) {
                    iVar.mo17497a(a12.mo17407a());
                }
                fjVar3.mo17622a(iVar.mo17407a(), (String) null);
                XMPushService xMPushService2 = this.f3724a;
                xMPushService2.mo18412a((XMPushService.C1956i) new C2025bm(xMPushService2, fjVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                a = fjVar.mo17627e();
            } else {
                return;
            }
        } else if ("NOTIFY".equals(fjVar.mo17615a())) {
            C1747ed.C1755h a13 = C1747ed.C1755h.m3273a(fjVar.mo17615a());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(a13.mo17496c());
            sb.append(" desc = ");
            a = a13.mo17407a();
        } else {
            return;
        }
        sb.append(a);
        str = sb.toString();
        C1524b.m2141a(str);
    }
}
