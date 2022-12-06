package com.xiaomi.smack;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.service.ah;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.util.g;
import com.xiaomi.smack.util.j;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

class i {
    private Writer a;
    private l b;

    protected i(l lVar) {
        this.b = lVar;
        this.a = lVar.k;
    }

    private void b(d dVar) {
        synchronized (this.a) {
            try {
                String a2 = dVar.a();
                Writer writer = this.a;
                writer.write(a2 + "\r\n");
                this.a.flush();
                String o = dVar.o();
                if (!TextUtils.isEmpty(o)) {
                    j.a(this.b.p, o, (long) j.a(a2), false, System.currentTimeMillis());
                }
            } catch (IOException e) {
                throw new p((Throwable) e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.b.h.clear();
    }

    public void a(d dVar) {
        b(dVar);
        this.b.b(dVar);
    }

    public void b() {
        synchronized (this.a) {
            this.a.write("</stream:stream>");
            this.a.flush();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        StringBuilder sb = new StringBuilder();
        sb.append("<stream:stream");
        sb.append(" xmlns=\"xm\"");
        sb.append(" xmlns:stream=\"xm\"");
        sb.append(" to=\"");
        sb.append(this.b.b());
        sb.append("\"");
        sb.append(" version=\"105\"");
        sb.append(" model=\"");
        sb.append(g.a(Build.MODEL));
        sb.append("\"");
        sb.append(" os=\"");
        sb.append(g.a(Build.VERSION.INCREMENTAL));
        sb.append("\"");
        String e = ah.e();
        if (!TextUtils.isEmpty(e)) {
            sb.append(" uid=\"");
            sb.append(e);
            sb.append("\"");
        }
        sb.append(" sdk=\"");
        sb.append(21);
        sb.append("\"");
        sb.append(" connpt=\"");
        sb.append(g.a(this.b.d()));
        sb.append("\"");
        sb.append(" host=\"");
        sb.append(this.b.c());
        sb.append("\"");
        sb.append(" locale=\"");
        sb.append(g.a(Locale.getDefault().toString()));
        sb.append("\"");
        byte[] a2 = this.b.a().a();
        if (a2 != null) {
            sb.append(" ps=\"");
            sb.append(Base64.encodeToString(a2, 10));
            sb.append("\"");
        }
        sb.append(">");
        this.a.write(sb.toString());
        this.a.flush();
    }

    public void d() {
        synchronized (this.a) {
            try {
                Writer writer = this.a;
                writer.write(this.b.u() + "\r\n");
                this.a.flush();
                this.b.w();
            } catch (IOException e) {
                throw new p((Throwable) e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
