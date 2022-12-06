package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.xiaomi.push.fs */
public class C1806fs implements C1824gg {

    /* renamed from: a */
    public static boolean f2419a = false;

    /* renamed from: a */
    private C1807a f2420a = null;

    /* renamed from: a */
    private C1809fu f2421a = null;

    /* renamed from: a */
    private C1813fx f2422a = null;

    /* renamed from: a */
    private final String f2423a = "[Slim] ";

    /* renamed from: a */
    private SimpleDateFormat f2424a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: b */
    private C1807a f2425b = null;

    /* renamed from: com.xiaomi.push.fs$a */
    class C1807a implements C1815fz, C1825gh {

        /* renamed from: a */
        String f2427a;

        /* renamed from: a */
        private boolean f2428a = true;

        C1807a(boolean z) {
            this.f2428a = z;
            this.f2427a = z ? " RCV " : " Sent ";
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x012c  */
        /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo17650a(com.xiaomi.push.C1793fj r6) {
            /*
                r5 = this;
                boolean r0 = com.xiaomi.push.C1806fs.f2419a
                java.lang.String r1 = "[Slim] "
                if (r0 == 0) goto L_0x002a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                com.xiaomi.push.fs r1 = com.xiaomi.push.C1806fs.this
                java.text.SimpleDateFormat r1 = com.xiaomi.push.C1806fs.m3599a((com.xiaomi.push.C1806fs) r1)
                java.util.Date r2 = new java.util.Date
                r2.<init>()
                java.lang.String r1 = r1.format(r2)
                r0.append(r1)
                java.lang.String r1 = r5.f2427a
                r0.append(r1)
                java.lang.String r1 = r6.toString()
                goto L_0x006d
            L_0x002a:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                com.xiaomi.push.fs r1 = com.xiaomi.push.C1806fs.this
                java.text.SimpleDateFormat r1 = com.xiaomi.push.C1806fs.m3599a((com.xiaomi.push.C1806fs) r1)
                java.util.Date r2 = new java.util.Date
                r2.<init>()
                java.lang.String r1 = r1.format(r2)
                r0.append(r1)
                java.lang.String r1 = r5.f2427a
                r0.append(r1)
                java.lang.String r1 = " Blob ["
                r0.append(r1)
                java.lang.String r1 = r6.mo17615a()
                r0.append(r1)
                java.lang.String r1 = ","
                r0.append(r1)
                int r2 = r6.mo17615a()
                r0.append(r2)
                r0.append(r1)
                java.lang.String r1 = r6.mo17627e()
                r0.append(r1)
                java.lang.String r1 = "]"
            L_0x006d:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.xiaomi.channel.commonutils.logger.C1524b.m2159c(r0)
                if (r6 == 0) goto L_0x0160
                int r0 = r6.mo17615a()
                r1 = 99999(0x1869f, float:1.40128E-40)
                if (r0 != r1) goto L_0x0160
                java.lang.String r0 = r6.mo17615a()
                boolean r2 = r5.f2428a
                r3 = 0
                if (r2 != 0) goto L_0x0129
                java.lang.String r2 = "BIND"
                boolean r4 = r2.equals(r0)
                if (r4 == 0) goto L_0x00d7
                java.lang.String r0 = "build binded result for loopback."
                com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
                com.xiaomi.push.ed$d r0 = new com.xiaomi.push.ed$d
                r0.<init>()
                r4 = 1
                r0.mo17462a((boolean) r4)
                java.lang.String r4 = "login success."
                r0.mo17464c(r4)
                java.lang.String r4 = "success"
                r0.mo17463b(r4)
                r0.mo17461a((java.lang.String) r4)
                com.xiaomi.push.fj r4 = new com.xiaomi.push.fj
                r4.<init>()
                byte[] r0 = r0.mo17407a()
                r4.mo17622a((byte[]) r0, (java.lang.String) r3)
                r0 = 2
                r4.mo17621a((short) r0)
                r4.mo17617a((int) r1)
                r4.mo17620a((java.lang.String) r2, (java.lang.String) r3)
                java.lang.String r0 = r6.mo17627e()
                r4.mo17619a((java.lang.String) r0)
                r4.mo17624b(r3)
                java.lang.String r6 = r6.mo17629g()
                r4.mo17626c(r6)
                r0 = r4
                goto L_0x012a
            L_0x00d7:
                java.lang.String r2 = "UBND"
                boolean r2 = r2.equals(r0)
                if (r2 == 0) goto L_0x00e0
                goto L_0x0129
            L_0x00e0:
                java.lang.String r2 = "SECMSG"
                boolean r0 = r2.equals(r0)
                if (r0 == 0) goto L_0x0129
                com.xiaomi.push.fj r0 = new com.xiaomi.push.fj
                r0.<init>()
                r0.mo17617a((int) r1)
                r0.mo17620a((java.lang.String) r2, (java.lang.String) r3)
                java.lang.String r2 = r6.mo17629g()
                r0.mo17626c(r2)
                java.lang.String r2 = r6.mo17627e()
                r0.mo17619a((java.lang.String) r2)
                short r2 = r6.mo17615a()
                r0.mo17621a((short) r2)
                java.lang.String r2 = r6.mo17628f()
                r0.mo17624b(r2)
                com.xiaomi.push.service.az r2 = com.xiaomi.push.service.C2003az.mo18481a()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                java.lang.String r4 = r6.mo17629g()
                com.xiaomi.push.service.az$b r1 = r2.mo18482a((java.lang.String) r1, (java.lang.String) r4)
                java.lang.String r1 = r1.f3749h
                byte[] r6 = r6.mo17619a((java.lang.String) r1)
                r0.mo17622a((byte[]) r6, (java.lang.String) r3)
                goto L_0x012a
            L_0x0129:
                r0 = r3
            L_0x012a:
                if (r0 == 0) goto L_0x0160
                com.xiaomi.push.fs r6 = com.xiaomi.push.C1806fs.this
                com.xiaomi.push.fu r6 = com.xiaomi.push.C1806fs.m3599a((com.xiaomi.push.C1806fs) r6)
                java.util.Map r6 = r6.mo17639a()
                java.util.Set r6 = r6.entrySet()
                java.util.Iterator r6 = r6.iterator()
            L_0x013e:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x0160
                java.lang.Object r1 = r6.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                com.xiaomi.push.fs r2 = com.xiaomi.push.C1806fs.this
                com.xiaomi.push.fs$a r2 = com.xiaomi.push.C1806fs.m3599a((com.xiaomi.push.C1806fs) r2)
                java.lang.Object r3 = r1.getKey()
                if (r2 == r3) goto L_0x013e
                java.lang.Object r1 = r1.getValue()
                com.xiaomi.push.fu$a r1 = (com.xiaomi.push.C1809fu.C1810a) r1
                r1.mo17668a((com.xiaomi.push.C1793fj) r0)
                goto L_0x013e
            L_0x0160:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1806fs.C1807a.mo17650a(com.xiaomi.push.fj):void");
        }

        /* renamed from: a */
        public void mo17651a(C1830gl glVar) {
            String str;
            StringBuilder sb;
            if (C1806fs.f2419a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(C1806fs.m3599a(C1806fs.this).format(new Date()));
                sb.append(this.f2427a);
                sb.append(" PKT ");
                str = glVar.mo17698a();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(C1806fs.m3599a(C1806fs.this).format(new Date()));
                sb.append(this.f2427a);
                sb.append(" PKT [");
                sb.append(glVar.mo17727k());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(glVar.mo17726j());
                str = "]";
            }
            sb.append(str);
            C1524b.m2159c(sb.toString());
        }

        /* renamed from: a */
        public boolean m3605a(C1830gl glVar) {
            return true;
        }
    }

    public C1806fs(C1809fu fuVar) {
        this.f2421a = fuVar;
        m3602a();
    }

    /* renamed from: a */
    private void m3602a() {
        this.f2420a = new C1807a(true);
        this.f2425b = new C1807a(false);
        C1809fu fuVar = this.f2421a;
        C1807a aVar = this.f2420a;
        fuVar.mo17658a((C1815fz) aVar, (C1825gh) aVar);
        C1809fu fuVar2 = this.f2421a;
        C1807a aVar2 = this.f2425b;
        fuVar2.mo17664b((C1815fz) aVar2, (C1825gh) aVar2);
        this.f2422a = new C1808ft(this);
    }
}
