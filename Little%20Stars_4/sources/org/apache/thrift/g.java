package org.apache.thrift;

import java.io.ByteArrayOutputStream;
import org.apache.thrift.protocol.a;
import org.apache.thrift.protocol.e;
import org.apache.thrift.transport.a;

public class g {
    private final ByteArrayOutputStream a;
    private final a b;
    private e c;

    public g() {
        this(new a.C0057a());
    }

    public g(org.apache.thrift.protocol.g gVar) {
        this.a = new ByteArrayOutputStream();
        this.b = new org.apache.thrift.transport.a(this.a);
        this.c = gVar.a(this.b);
    }

    public byte[] a(a aVar) {
        this.a.reset();
        aVar.b(this.c);
        return this.a.toByteArray();
    }
}
