package com.xiaomi.smack;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.y;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.h;
import com.xiaomi.smack.util.g;
import java.util.HashMap;
import object.p2pipcam.utils.DataBaseHelper;

public class k {

    public static class a extends d {
        public a(y.b bVar, String str, a aVar) {
            String str2;
            String str3;
            String str4;
            String str5;
            y.b bVar2 = bVar;
            HashMap hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put(Constants.EXTRA_KEY_TOKEN, bVar2.c);
            hashMap.put("chid", bVar2.h);
            hashMap.put("from", bVar2.b);
            hashMap.put(DataBaseHelper.KEY_ID, k());
            hashMap.put("to", "xiaomi.com");
            boolean z = bVar2.e;
            String str6 = PushConstants.PUSH_TYPE_NOTIFY;
            if (z) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", str6);
            }
            if (aVar == null || aVar.l() <= 0) {
                str2 = null;
            } else {
                str2 = String.format("conn:%1$d,t:%2$d", new Object[]{Integer.valueOf(aVar.j()), Long.valueOf(aVar.l())});
                hashMap.put("pf", str2);
                aVar.k();
                aVar.m();
            }
            String str7 = "";
            if (!TextUtils.isEmpty(bVar2.f)) {
                hashMap.put("client_attrs", bVar2.f);
            } else {
                hashMap.put("client_attrs", str7);
            }
            if (!TextUtils.isEmpty(bVar2.g)) {
                hashMap.put("cloud_attrs", bVar2.g);
            } else {
                hashMap.put("cloud_attrs", str7);
            }
            if (bVar2.d.equals("XIAOMI-PASS") || bVar2.d.equals("XMPUSH-PASS")) {
                str3 = "1";
                str5 = null;
                str4 = com.xiaomi.channel.commonutils.string.b.a(bVar2.d, (String) null, hashMap, bVar2.i);
            } else {
                bVar2.d.equals("XIAOMI-SASL");
                str3 = "1";
                str5 = null;
                str4 = null;
            }
            l(bVar2.h);
            n(bVar2.b);
            m("xiaomi.com");
            o(bVar2.a);
            String[] strArr = (String[]) str5;
            com.xiaomi.smack.packet.a aVar2 = new com.xiaomi.smack.packet.a(Constants.EXTRA_KEY_TOKEN, str5, strArr, strArr);
            aVar2.b(bVar2.c);
            a(aVar2);
            com.xiaomi.smack.packet.a aVar3 = new com.xiaomi.smack.packet.a("kick", str5, strArr, strArr);
            aVar3.b(bVar2.e ? str3 : str6);
            a(aVar3);
            com.xiaomi.smack.packet.a aVar4 = new com.xiaomi.smack.packet.a("sig", str5, strArr, strArr);
            aVar4.b(str4);
            a(aVar4);
            com.xiaomi.smack.packet.a aVar5 = new com.xiaomi.smack.packet.a("method", str5, strArr, strArr);
            if (!TextUtils.isEmpty(bVar2.d)) {
                aVar5.b(bVar2.d);
            } else {
                aVar5.b("XIAOMI-SASL");
            }
            a(aVar5);
            com.xiaomi.smack.packet.a aVar6 = new com.xiaomi.smack.packet.a("client_attrs", str5, strArr, strArr);
            aVar6.b(bVar2.f == null ? str7 : g.a(bVar2.f));
            a(aVar6);
            com.xiaomi.smack.packet.a aVar7 = new com.xiaomi.smack.packet.a("cloud_attrs", str5, strArr, strArr);
            aVar7.b(bVar2.g != null ? g.a(bVar2.g) : str7);
            a(aVar7);
            if (!TextUtils.isEmpty(str2)) {
                com.xiaomi.smack.packet.a aVar8 = new com.xiaomi.smack.packet.a("pf", (String) null, strArr, strArr);
                aVar8.b(str2);
                a(aVar8);
            }
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            sb.append("<bind ");
            if (k() != null) {
                sb.append("id=\"" + k() + "\" ");
            }
            if (m() != null) {
                sb.append("to=\"");
                sb.append(g.a(m()));
                sb.append("\" ");
            }
            if (n() != null) {
                sb.append("from=\"");
                sb.append(g.a(n()));
                sb.append("\" ");
            }
            if (l() != null) {
                sb.append("chid=\"");
                sb.append(g.a(l()));
                sb.append("\">");
            }
            if (q() != null) {
                for (com.xiaomi.smack.packet.a d : q()) {
                    sb.append(d.d());
                }
            }
            sb.append("</bind>");
            return sb.toString();
        }
    }

    public static class b extends d {
        private a c;

        public static class a {
            public static final a a = new a("result");
            public static final a b = new a("error");
            private String c;

            private a(String str) {
                this.c = str;
            }

            public static a a(String str) {
                if (str == null) {
                    return null;
                }
                String lowerCase = str.toLowerCase();
                if (b.toString().equals(lowerCase)) {
                    return b;
                }
                if (a.toString().equals(lowerCase)) {
                    return a;
                }
                return null;
            }

            public String toString() {
                return this.c;
            }
        }

        public String a() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("<bind ");
            if (k() != null) {
                sb.append("id=\"" + k() + "\" ");
            }
            if (m() != null) {
                sb.append("to=\"");
                sb.append(g.a(m()));
                sb.append("\" ");
            }
            if (n() != null) {
                sb.append("from=\"");
                sb.append(g.a(n()));
                sb.append("\" ");
            }
            if (l() != null) {
                sb.append(" chid=\"");
                sb.append(g.a(l()));
                sb.append("\" ");
            }
            if (this.c == null) {
                str = "type=\"result\">";
            } else {
                sb.append("type=\"");
                sb.append(b());
                str = "\">";
            }
            sb.append(str);
            if (q() != null) {
                for (com.xiaomi.smack.packet.a d : q()) {
                    sb.append(d.d());
                }
            }
            h p = p();
            if (p != null) {
                sb.append(p.d());
            }
            sb.append("</bind>");
            return sb.toString();
        }

        public void a(a aVar) {
            if (aVar == null) {
                aVar = a.a;
            }
            this.c = aVar;
        }

        public a b() {
            return this.c;
        }
    }

    public void a(y.b bVar, String str, a aVar) {
        a aVar2 = new a(bVar, str, aVar);
        aVar.a((d) aVar2);
        com.xiaomi.channel.commonutils.logger.b.a("SMACK: bind id=" + aVar2.k());
    }
}
