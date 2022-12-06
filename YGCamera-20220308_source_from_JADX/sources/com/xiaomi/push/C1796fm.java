package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1747ed;
import com.xiaomi.push.service.C2021bi;
import com.xiaomi.push.service.C2027bo;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* renamed from: com.xiaomi.push.fm */
public class C1796fm {

    /* renamed from: a */
    private int f2398a;

    /* renamed from: a */
    private C1804fq f2399a;

    /* renamed from: a */
    private OutputStream f2400a;

    /* renamed from: a */
    ByteBuffer f2401a = ByteBuffer.allocate(2048);

    /* renamed from: a */
    private Adler32 f2402a = new Adler32();

    /* renamed from: a */
    private byte[] f2403a;

    /* renamed from: b */
    private int f2404b;

    /* renamed from: b */
    private ByteBuffer f2405b = ByteBuffer.allocate(4);

    C1796fm(OutputStream outputStream, C1804fq fqVar) {
        this.f2400a = new BufferedOutputStream(outputStream);
        this.f2399a = fqVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f2398a = timeZone.getRawOffset() / 3600000;
        this.f2404b = timeZone.useDaylightTime() ? 1 : 0;
    }

    /* renamed from: a */
    public int mo17633a(C1793fj fjVar) {
        int c = fjVar.mo17625c();
        if (c > 32768) {
            C1524b.m2141a("Blob size=" + c + " should be less than " + 32768 + " Drop blob chid=" + fjVar.mo17615a() + " id=" + fjVar.mo17627e());
            return 0;
        }
        this.f2401a.clear();
        int i = c + 8 + 4;
        if (i > this.f2401a.capacity() || this.f2401a.capacity() > 4096) {
            this.f2401a = ByteBuffer.allocate(i);
        }
        this.f2401a.putShort(-15618);
        this.f2401a.putShort(5);
        this.f2401a.putInt(c);
        int position = this.f2401a.position();
        this.f2401a = fjVar.mo17616a(this.f2401a);
        if (!"CONN".equals(fjVar.mo17615a())) {
            if (this.f2403a == null) {
                this.f2403a = this.f2399a.mo17639a();
            }
            C2021bi.m5136a(this.f2403a, this.f2401a.array(), true, position, c);
        }
        this.f2402a.reset();
        this.f2402a.update(this.f2401a.array(), 0, this.f2401a.position());
        this.f2405b.putInt(0, (int) this.f2402a.getValue());
        this.f2400a.write(this.f2401a.array(), 0, this.f2401a.position());
        this.f2400a.write(this.f2405b.array(), 0, 4);
        this.f2400a.flush();
        int position2 = this.f2401a.position() + 4;
        C1524b.m2159c("[Slim] Wrote {cmd=" + fjVar.mo17615a() + ";chid=" + fjVar.mo17615a() + ";len=" + position2 + "}");
        return position2;
    }

    /* renamed from: a */
    public void mo17634a() {
        C1747ed.C1752e eVar = new C1747ed.C1752e();
        eVar.mo17468a(106);
        eVar.mo17470a(Build.MODEL);
        eVar.mo17472b(C2087u.m5371a());
        eVar.mo17475c(C2027bo.mo18506a());
        eVar.mo17471b(46);
        eVar.mo17477d(this.f2399a.mo17661b());
        eVar.mo17479e(this.f2399a.mo17639a());
        eVar.mo17480f(Locale.getDefault().toString());
        eVar.mo17474c(Build.VERSION.SDK_INT);
        byte[] a = this.f2399a.mo17639a().mo17670a();
        if (a != null) {
            eVar.mo17469a(C1747ed.C1749b.m3149a(a));
        }
        C1793fj fjVar = new C1793fj();
        fjVar.mo17617a(0);
        fjVar.mo17620a("CONN", (String) null);
        fjVar.mo17618a(0, "xiaomi.com", (String) null);
        fjVar.mo17622a(eVar.mo17407a(), (String) null);
        mo17633a(fjVar);
        C1524b.m2141a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=" + 46 + " tz=" + this.f2398a + Constants.COLON_SEPARATOR + this.f2404b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    /* renamed from: b */
    public void mo17635b() {
        C1793fj fjVar = new C1793fj();
        fjVar.mo17620a("CLOSE", (String) null);
        mo17633a(fjVar);
        this.f2400a.close();
    }
}
