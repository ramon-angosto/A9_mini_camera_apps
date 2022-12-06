package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1747ed;
import com.xiaomi.push.service.C2021bi;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.fj */
public class C1793fj {

    /* renamed from: a */
    private static long f2381a = 0;

    /* renamed from: a */
    private static final byte[] f2382a = new byte[0];

    /* renamed from: b */
    private static String f2383b = (C1844gw.m3800a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* renamed from: a */
    int f2384a;

    /* renamed from: a */
    private C1747ed.C1748a f2385a;

    /* renamed from: a */
    String f2386a;

    /* renamed from: a */
    private short f2387a;

    /* renamed from: b */
    private byte[] f2388b;

    public C1793fj() {
        this.f2387a = 2;
        this.f2388b = f2382a;
        this.f2386a = null;
        this.f2385a = new C1747ed.C1748a();
        this.f2384a = 1;
    }

    C1793fj(C1747ed.C1748a aVar, short s, byte[] bArr) {
        this.f2387a = 2;
        this.f2388b = f2382a;
        this.f2386a = null;
        this.f2385a = aVar;
        this.f2387a = s;
        this.f2388b = bArr;
        this.f2384a = 2;
    }

    @Deprecated
    /* renamed from: a */
    public static C1793fj m3532a(C1830gl glVar, String str) {
        int i;
        C1793fj fjVar = new C1793fj();
        try {
            i = Integer.parseInt(glVar.mo17727k());
        } catch (Exception e) {
            C1524b.m2141a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        fjVar.mo17617a(i);
        fjVar.mo17619a(glVar.mo17726j());
        fjVar.mo17626c(glVar.mo17731m());
        fjVar.mo17624b(glVar.mo17733n());
        fjVar.mo17620a("XMLMSG", (String) null);
        try {
            fjVar.mo17622a(glVar.mo17698a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                fjVar.mo17621a(3);
            } else {
                fjVar.mo17621a(2);
                fjVar.mo17620a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            C1524b.m2141a("Blob setPayload err： " + e2.getMessage());
        }
        return fjVar;
    }

    /* renamed from: a */
    static C1793fj mo17616a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            C1747ed.C1748a aVar = new C1747ed.C1748a();
            aVar.mo17410a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new C1793fj(aVar, s, bArr);
        } catch (Exception e) {
            C1524b.m2141a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* renamed from: d */
    public static synchronized String m3534d() {
        String sb;
        synchronized (C1793fj.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f2383b);
            long j = f2381a;
            f2381a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    /* renamed from: a */
    public int mo17615a() {
        return this.f2385a.mo17429c();
    }

    /* renamed from: a */
    public String m3536a() {
        return this.f2385a.mo17429c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ByteBuffer m3537a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(mo17625c());
        }
        byteBuffer.putShort(this.f2387a);
        byteBuffer.putShort((short) this.f2385a.mo17407a());
        byteBuffer.putInt(this.f2388b.length);
        int position = byteBuffer.position();
        this.f2385a.mo17410a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f2385a.mo17407a());
        byteBuffer.position(position + this.f2385a.mo17407a());
        byteBuffer.put(this.f2388b);
        return byteBuffer;
    }

    /* renamed from: a */
    public short m3538a() {
        return this.f2387a;
    }

    /* renamed from: a */
    public void mo17617a(int i) {
        this.f2385a.mo17424a(i);
    }

    /* renamed from: a */
    public void mo17618a(long j, String str, String str2) {
        if (j != 0) {
            this.f2385a.mo17425a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f2385a.mo17426a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f2385a.mo17428b(str2);
        }
    }

    /* renamed from: a */
    public void mo17619a(String str) {
        this.f2385a.mo17436e(str);
    }

    /* renamed from: a */
    public void mo17620a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f2385a.mo17431c(str);
            this.f2385a.mo17407a();
            if (!TextUtils.isEmpty(str2)) {
                this.f2385a.mo17434d(str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("command should not be empty");
    }

    /* renamed from: a */
    public void mo17621a(short s) {
        this.f2387a = s;
    }

    /* renamed from: a */
    public void mo17622a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2385a.mo17430c(1);
            this.f2388b = C2021bi.m5135a(C2021bi.m5133a(str, mo17627e()), bArr);
            return;
        }
        this.f2385a.mo17430c(0);
        this.f2388b = bArr;
    }

    /* renamed from: a */
    public boolean m3545a() {
        return this.f2385a.mo17442j();
    }

    /* renamed from: a */
    public byte[] m3546a() {
        return C1794fk.m3557a(this, this.f2388b);
    }

    /* renamed from: a */
    public byte[] m3547a(String str) {
        if (this.f2385a.mo17435e() == 1) {
            return C1794fk.m3557a(this, C2021bi.m5135a(C2021bi.m5133a(str, mo17627e()), this.f2388b));
        }
        if (this.f2385a.mo17435e() == 0) {
            return C1794fk.m3557a(this, this.f2388b);
        }
        C1524b.m2141a("unknow cipher = " + this.f2385a.mo17435e());
        return C1794fk.m3557a(this, this.f2388b);
    }

    /* renamed from: b */
    public int mo17623b() {
        return this.f2385a.mo17437f();
    }

    /* renamed from: b */
    public String m3549b() {
        return this.f2385a.mo17432d();
    }

    /* renamed from: b */
    public void mo17624b(String str) {
        this.f2386a = str;
    }

    /* renamed from: c */
    public int mo17625c() {
        return this.f2385a.mo17413b() + 8 + this.f2388b.length;
    }

    /* renamed from: c */
    public String m3552c() {
        return this.f2385a.mo17437f();
    }

    /* renamed from: c */
    public void mo17626c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.f2385a.mo17425a(parseLong);
                this.f2385a.mo17426a(substring);
                this.f2385a.mo17428b(substring2);
            } catch (Exception e) {
                C1524b.m2141a("Blob parse user err " + e.getMessage());
            }
        }
    }

    /* renamed from: e */
    public String mo17627e() {
        String e = this.f2385a.mo17435e();
        if ("ID_NOT_AVAILABLE".equals(e)) {
            return null;
        }
        if (this.f2385a.mo17439g()) {
            return e;
        }
        String d = m3534d();
        this.f2385a.mo17436e(d);
        return d;
    }

    /* renamed from: f */
    public String mo17628f() {
        return this.f2386a;
    }

    /* renamed from: g */
    public String mo17629g() {
        if (!this.f2385a.mo17413b()) {
            return null;
        }
        return Long.toString(this.f2385a.mo17407a()) + "@" + this.f2385a.mo17407a() + "/" + this.f2385a.mo17413b();
    }

    public String toString() {
        return "Blob [chid=" + mo17615a() + "; Id=" + mo17627e() + "; cmd=" + mo17615a() + "; type=" + mo17615a() + "; from=" + mo17629g() + " ]";
    }
}
