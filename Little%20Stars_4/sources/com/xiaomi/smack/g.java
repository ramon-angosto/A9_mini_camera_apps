package com.xiaomi.smack;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.smack.a;
import com.xiaomi.smack.packet.b;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.util.c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

class g {
    private Thread a;
    private l b;
    private XmlPullParser c;
    private boolean d;

    protected g(l lVar) {
        this.b = lVar;
        a();
    }

    private void a(d dVar) {
        if (dVar != null) {
            for (a.C0056a a2 : this.b.g.values()) {
                a2.a(dVar);
            }
        }
    }

    private void e() {
        this.c = XmlPullParserFactory.newInstance().newPullParser();
        this.c.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        this.c.setInput(this.b.j);
    }

    /* access modifiers changed from: private */
    public void f() {
        d c2;
        try {
            e();
            int eventType = this.c.getEventType();
            String str = "";
            do {
                this.b.p();
                if (eventType == 2) {
                    String name = this.c.getName();
                    if (this.c.getName().equals("message")) {
                        c2 = c.a(this.c);
                    } else if (this.c.getName().equals("iq")) {
                        c2 = c.a(this.c, this.b);
                    } else if (this.c.getName().equals("presence")) {
                        c2 = c.b(this.c);
                    } else {
                        if (this.c.getName().equals("stream")) {
                            String str2 = "";
                            for (int i = 0; i < this.c.getAttributeCount(); i++) {
                                if (this.c.getAttributeName(i).equals("from")) {
                                    this.b.o.a(this.c.getAttributeValue(i));
                                } else if (this.c.getAttributeName(i).equals("challenge")) {
                                    str2 = this.c.getAttributeValue(i);
                                } else if ("ps".equals(this.c.getAttributeName(i))) {
                                    String attributeValue = this.c.getAttributeValue(i);
                                    b bVar = new b();
                                    bVar.l(PushConstants.PUSH_TYPE_NOTIFY);
                                    bVar.k(PushConstants.PUSH_TYPE_NOTIFY);
                                    bVar.a("ps", attributeValue);
                                    bVar.a(b.a.b);
                                    a((d) bVar);
                                }
                            }
                            this.b.a(str2);
                        } else if (this.c.getName().equals("error")) {
                            throw new p(c.d(this.c));
                        } else if (this.c.getName().equals("warning")) {
                            this.c.next();
                            if (this.c.getName().equals("multi-login")) {
                                a(6, (Exception) null);
                            }
                        } else if (this.c.getName().equals("bind")) {
                            c2 = c.c(this.c);
                        }
                        str = name;
                    }
                    a(c2);
                    str = name;
                } else if (eventType == 3 && this.c.getName().equals("stream")) {
                    a(13, (Exception) null);
                }
                eventType = this.c.next();
                if (this.d) {
                    break;
                }
            } while (eventType != 1);
            if (eventType == 1) {
                throw new Exception("SMACK: server close the connection or timeout happened, last element name=" + str + " host=" + this.b.c());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
            if (!this.d) {
                try {
                    a(9, e);
                } catch (Exception unused) {
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("reader is shutdown, ignore the exception.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.d = false;
        this.a = new h(this, "Smack Packet Reader (" + this.b.n + ")");
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Exception exc) {
        this.d = true;
        this.b.a(i, exc);
    }

    public void b() {
        this.a.start();
    }

    public void c() {
        this.d = true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.b.g.clear();
    }
}
