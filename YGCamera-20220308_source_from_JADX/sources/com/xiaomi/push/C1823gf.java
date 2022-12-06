package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.xiaomi.push.gf */
public class C1823gf extends Exception {

    /* renamed from: a */
    private C1835go f2488a = null;

    /* renamed from: a */
    private C1836gp f2489a = null;

    /* renamed from: a */
    private Throwable f2490a = null;

    public C1823gf() {
    }

    public C1823gf(C1835go goVar) {
        this.f2488a = goVar;
    }

    public C1823gf(String str) {
        super(str);
    }

    public C1823gf(String str, Throwable th) {
        super(str);
        this.f2490a = th;
    }

    public C1823gf(Throwable th) {
        this.f2490a = th;
    }

    /* renamed from: a */
    public Throwable mo17685a() {
        return this.f2490a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r1 = r2.f2488a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMessage() {
        /*
            r2 = this;
            java.lang.String r0 = super.getMessage()
            if (r0 != 0) goto L_0x000f
            com.xiaomi.push.gp r1 = r2.f2489a
            if (r1 == 0) goto L_0x000f
            java.lang.String r0 = r1.toString()
            return r0
        L_0x000f:
            if (r0 != 0) goto L_0x0019
            com.xiaomi.push.go r1 = r2.f2488a
            if (r1 == 0) goto L_0x0019
            java.lang.String r0 = r1.toString()
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1823gf.getMessage():java.lang.String");
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f2490a != null) {
            printStream.println("Nested Exception: ");
            this.f2490a.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f2490a != null) {
            printWriter.println("Nested Exception: ");
            this.f2490a.printStackTrace(printWriter);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        C1836gp gpVar = this.f2489a;
        if (gpVar != null) {
            sb.append(gpVar);
        }
        C1835go goVar = this.f2488a;
        if (goVar != null) {
            sb.append(goVar);
        }
        if (this.f2490a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f2490a);
        }
        return sb.toString();
    }
}
