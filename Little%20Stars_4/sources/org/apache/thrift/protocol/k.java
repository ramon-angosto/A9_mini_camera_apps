package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.f;
import org.apache.thrift.protocol.a;
import org.apache.thrift.transport.d;

public class k extends a {
    private static int f = 10000;
    private static int g = 10000;
    private static int h = 10000;
    private static int i = 10485760;
    private static int j = 104857600;

    public static class a extends a.C0057a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        public e a(d dVar) {
            k kVar = new k(dVar, this.a, this.b);
            if (this.c != 0) {
                kVar.c(this.c);
            }
            return kVar;
        }
    }

    public k(d dVar, boolean z, boolean z2) {
        super(dVar, z, z2);
    }

    public d j() {
        byte q = q();
        byte q2 = q();
        int s = s();
        if (s <= f) {
            return new d(q, q2, s);
        }
        throw new f(3, "Thrift map size " + s + " out of range!");
    }

    public c l() {
        byte q = q();
        int s = s();
        if (s <= g) {
            return new c(q, s);
        }
        throw new f(3, "Thrift list size " + s + " out of range!");
    }

    public i n() {
        byte q = q();
        int s = s();
        if (s <= h) {
            return new i(q, s);
        }
        throw new f(3, "Thrift set size " + s + " out of range!");
    }

    public String v() {
        int s = s();
        if (s > i) {
            throw new f(3, "Thrift string size " + s + " out of range!");
        } else if (this.e.c() < s) {
            return b(s);
        } else {
            try {
                String str = new String(this.e.a(), this.e.b(), s, "UTF-8");
                this.e.a(s);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new f("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    public ByteBuffer w() {
        int s = s();
        if (s <= j) {
            d(s);
            if (this.e.c() >= s) {
                ByteBuffer wrap = ByteBuffer.wrap(this.e.a(), this.e.b(), s);
                this.e.a(s);
                return wrap;
            }
            byte[] bArr = new byte[s];
            this.e.d(bArr, 0, s);
            return ByteBuffer.wrap(bArr);
        }
        throw new f(3, "Thrift binary size " + s + " out of range!");
    }
}
