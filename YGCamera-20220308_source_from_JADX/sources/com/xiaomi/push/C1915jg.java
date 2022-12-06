package com.xiaomi.push;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.jg */
public class C1915jg extends C1920jk {

    /* renamed from: a */
    private static final C1925jp f3510a = new C1925jp();

    /* renamed from: a */
    protected int f3511a;

    /* renamed from: a */
    protected boolean f3512a = false;

    /* renamed from: a */
    private byte[] f3513a = new byte[1];

    /* renamed from: b */
    protected boolean f3514b = true;

    /* renamed from: b */
    private byte[] f3515b = new byte[2];

    /* renamed from: c */
    protected boolean f3516c = false;

    /* renamed from: c */
    private byte[] f3517c = new byte[4];

    /* renamed from: d */
    private byte[] f3518d = new byte[8];

    /* renamed from: e */
    private byte[] f3519e = new byte[1];

    /* renamed from: f */
    private byte[] f3520f = new byte[2];

    /* renamed from: g */
    private byte[] f3521g = new byte[4];

    /* renamed from: h */
    private byte[] f3522h = new byte[8];

    /* renamed from: com.xiaomi.push.jg$a */
    public static class C1916a implements C1922jm {

        /* renamed from: a */
        protected int f3523a;

        /* renamed from: a */
        protected boolean f3524a;

        /* renamed from: b */
        protected boolean f3525b;

        public C1916a() {
            this(false, true);
        }

        public C1916a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C1916a(boolean z, boolean z2, int i) {
            this.f3524a = false;
            this.f3525b = true;
            this.f3524a = z;
            this.f3525b = z2;
            this.f3523a = i;
        }

        /* renamed from: a */
        public C1920jk mo18355a(C1931ju juVar) {
            C1915jg jgVar = new C1915jg(juVar, this.f3524a, this.f3525b);
            int i = this.f3523a;
            if (i != 0) {
                jgVar.mo18345b(i);
            }
            return jgVar;
        }
    }

    public C1915jg(C1931ju juVar, boolean z, boolean z2) {
        super(juVar);
        this.f3512a = z;
        this.f3514b = z2;
    }

    /* renamed from: a */
    private int m4606a(byte[] bArr, int i, int i2) {
        mo18347c(i2);
        return this.f3534a.mo18364b(bArr, i, i2);
    }

    /* renamed from: a */
    public byte mo18332a() {
        if (this.f3534a.mo18363b() >= 1) {
            byte b = this.f3534a.mo18360a()[this.f3534a.mo18360a()];
            this.f3534a.mo18361a(1);
            return b;
        }
        m4606a(this.f3519e, 0, 1);
        return this.f3519e[0];
    }

    /* renamed from: a */
    public double m4608a() {
        return Double.longBitsToDouble(mo18332a());
    }

    /* renamed from: a */
    public int m4609a() {
        byte[] bArr = this.f3521g;
        int i = 0;
        if (this.f3534a.mo18363b() >= 4) {
            bArr = this.f3534a.mo18360a();
            i = this.f3534a.mo18360a();
            this.f3534a.mo18361a(4);
        } else {
            m4606a(this.f3521g, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* renamed from: a */
    public long m4610a() {
        byte[] bArr = this.f3522h;
        int i = 0;
        if (this.f3534a.mo18363b() >= 8) {
            bArr = this.f3534a.mo18360a();
            i = this.f3534a.mo18360a();
            this.f3534a.mo18361a(8);
        } else {
            m4606a(this.f3522h, 0, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48) | (((long) (bArr[i + 2] & 255)) << 40) | (((long) (bArr[i + 3] & 255)) << 32) | (((long) (bArr[i + 4] & 255)) << 24) | (((long) (bArr[i + 5] & 255)) << 16) | (((long) (bArr[i + 6] & 255)) << 8);
    }

    /* renamed from: a */
    public C1917jh m4611a() {
        byte a = mo18332a();
        return new C1917jh("", a, a == 0 ? 0 : mo18332a());
    }

    /* renamed from: a */
    public C1918ji m4612a() {
        return new C1918ji(mo18332a(), mo18332a());
    }

    /* renamed from: a */
    public C1919jj m4613a() {
        return new C1919jj(mo18332a(), mo18332a(), mo18332a());
    }

    /* renamed from: a */
    public C1924jo m4614a() {
        return new C1924jo(mo18332a(), mo18332a());
    }

    /* renamed from: a */
    public C1925jp m4615a() {
        return f3510a;
    }

    /* renamed from: a */
    public String m4616a() {
        int a = mo18332a();
        if (this.f3534a.mo18363b() < a) {
            return mo18333a(a);
        }
        try {
            String str = new String(this.f3534a.mo18360a(), this.f3534a.mo18360a(), a, Key.STRING_CHARSET_NAME);
            this.f3534a.mo18361a(a);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new C1913je("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: a */
    public String mo18333a(int i) {
        try {
            mo18347c(i);
            byte[] bArr = new byte[i];
            this.f3534a.mo18364b(bArr, 0, i);
            return new String(bArr, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException unused) {
            throw new C1913je("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: a */
    public ByteBuffer m4618a() {
        int a = mo18332a();
        mo18347c(a);
        if (this.f3534a.mo18363b() >= a) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f3534a.mo18360a(), this.f3534a.mo18360a(), a);
            this.f3534a.mo18361a(a);
            return wrap;
        }
        byte[] bArr = new byte[a];
        this.f3534a.mo18364b(bArr, 0, a);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    public short m4619a() {
        byte[] bArr = this.f3520f;
        int i = 0;
        if (this.f3534a.mo18363b() >= 2) {
            bArr = this.f3534a.mo18360a();
            i = this.f3534a.mo18360a();
            this.f3534a.mo18361a(2);
        } else {
            m4606a(this.f3520f, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* renamed from: a */
    public void m4620a() {
    }

    /* renamed from: a */
    public void mo18334a(byte b) {
        this.f3513a[0] = b;
        this.f3534a.mo18358a(this.f3513a, 0, 1);
    }

    /* renamed from: a */
    public void m4622a(int i) {
        byte[] bArr = this.f3517c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.f3534a.mo18358a(this.f3517c, 0, 4);
    }

    /* renamed from: a */
    public void mo18335a(long j) {
        byte[] bArr = this.f3518d;
        bArr[0] = (byte) ((int) ((j >> 56) & 255));
        bArr[1] = (byte) ((int) ((j >> 48) & 255));
        bArr[2] = (byte) ((int) ((j >> 40) & 255));
        bArr[3] = (byte) ((int) ((j >> 32) & 255));
        bArr[4] = (byte) ((int) ((j >> 24) & 255));
        bArr[5] = (byte) ((int) ((j >> 16) & 255));
        bArr[6] = (byte) ((int) ((j >> 8) & 255));
        bArr[7] = (byte) ((int) (j & 255));
        this.f3534a.mo18358a(this.f3518d, 0, 8);
    }

    /* renamed from: a */
    public void mo18336a(C1917jh jhVar) {
        mo18334a(jhVar.f3526a);
        mo18342a(jhVar.f3528a);
    }

    /* renamed from: a */
    public void mo18337a(C1918ji jiVar) {
        mo18334a(jiVar.f3529a);
        mo18333a(jiVar.f3530a);
    }

    /* renamed from: a */
    public void mo18338a(C1919jj jjVar) {
        mo18334a(jjVar.f3531a);
        mo18334a(jjVar.f3533b);
        mo18333a(jjVar.f3532a);
    }

    /* renamed from: a */
    public void mo18339a(C1925jp jpVar) {
    }

    /* renamed from: a */
    public void mo18340a(String str) {
        try {
            byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
            mo18333a(bytes.length);
            this.f3534a.mo18358a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new C1913je("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: a */
    public void mo18341a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo18333a(limit);
        this.f3534a.mo18358a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    /* renamed from: a */
    public void mo18342a(short s) {
        byte[] bArr = this.f3515b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f3534a.mo18358a(this.f3515b, 0, 2);
    }

    /* renamed from: a */
    public void mo18343a(boolean z) {
        mo18334a(z ? (byte) 1 : 0);
    }

    /* renamed from: a */
    public boolean m4632a() {
        return mo18332a() == 1;
    }

    /* renamed from: b */
    public void mo18344b() {
    }

    /* renamed from: b */
    public void mo18345b(int i) {
        this.f3511a = i;
        this.f3516c = true;
    }

    /* renamed from: c */
    public void mo18346c() {
        mo18334a((byte) 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo18347c(int i) {
        if (i < 0) {
            throw new C1913je("Negative length: " + i);
        } else if (this.f3516c) {
            this.f3511a -= i;
            if (this.f3511a < 0) {
                throw new C1913je("Message length exceeded: " + i);
            }
        }
    }

    /* renamed from: d */
    public void mo18348d() {
    }

    /* renamed from: e */
    public void mo18349e() {
    }

    /* renamed from: f */
    public void mo18350f() {
    }

    /* renamed from: g */
    public void mo18351g() {
    }

    /* renamed from: h */
    public void mo18352h() {
    }

    /* renamed from: i */
    public void mo18353i() {
    }

    /* renamed from: j */
    public void mo18354j() {
    }
}
