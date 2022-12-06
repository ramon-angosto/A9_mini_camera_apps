package com.xiaomi.smack;

import com.xiaomi.smack.packet.g;
import com.xiaomi.smack.packet.h;
import java.io.PrintStream;
import java.io.PrintWriter;

public class p extends Exception {
    private g a = null;
    private h b = null;
    private Throwable c = null;

    public p() {
    }

    public p(g gVar) {
        this.a = gVar;
    }

    public p(String str) {
        super(str);
    }

    public p(String str, Throwable th) {
        super(str);
        this.c = th;
    }

    public p(Throwable th) {
        this.c = th;
    }

    public Throwable a() {
        return this.c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r1 = r2.a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMessage() {
        /*
            r2 = this;
            java.lang.String r0 = super.getMessage()
            if (r0 != 0) goto L_0x000f
            com.xiaomi.smack.packet.h r1 = r2.b
            if (r1 == 0) goto L_0x000f
            java.lang.String r0 = r1.toString()
            return r0
        L_0x000f:
            if (r0 != 0) goto L_0x0019
            com.xiaomi.smack.packet.g r1 = r2.a
            if (r1 == 0) goto L_0x0019
            java.lang.String r0 = r1.toString()
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.p.getMessage():java.lang.String");
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.c != null) {
            printStream.println("Nested Exception: ");
            this.c.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.c != null) {
            printWriter.println("Nested Exception: ");
            this.c.printStackTrace(printWriter);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        h hVar = this.b;
        if (hVar != null) {
            sb.append(hVar);
        }
        g gVar = this.a;
        if (gVar != null) {
            sb.append(gVar);
        }
        if (this.c != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.c);
        }
        return sb.toString();
    }
}
