package com.huawei.android.pushagent.a.b;

import android.support.v4.media.TransportMediator;
import com.huawei.android.pushagent.a.b.a.b;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class l extends b {
    private byte b = -1;
    private byte[] c;
    private byte[] d;
    private int e;
    private byte[] f;
    private int g;
    private byte[] h;

    public l() {
        super(c());
    }

    public static final byte c() {
        return -96;
    }

    public b a(InputStream inputStream) throws Exception {
        this.c = new byte[8];
        a(inputStream, this.c);
        this.d = new byte[32];
        a(inputStream, this.d);
        byte[] bArr = new byte[2];
        a(inputStream, bArr);
        int c2 = a.c(bArr);
        e.a("PushLogAC2705", "push message len=" + c2);
        this.e = c2;
        this.f = new byte[c2];
        a(inputStream, this.f);
        byte[] bArr2 = new byte[2];
        try {
            bArr2[0] = (byte) inputStream.read();
            if (bArr2[0] < 0) {
                e.b("PushLogAC2705", "read first Len:" + bArr2[0] + ", not valid len, may be next cmdId in Old PushDataReqMessage");
                this.b = bArr2[0];
                return this;
            }
            bArr2[1] = (byte) inputStream.read();
            int i = bArr2[0] + bArr2[1];
            e.b("PushLogAC2705", "mPackageNameLen=" + i);
            if (i <= 0) {
                e.b("PushLogAC2705", "the package length:" + i + " is Unavailable ");
                return this;
            }
            this.g = i;
            this.h = new byte[i];
            a(inputStream, this.h);
            return this;
        } catch (Exception e2) {
            e.b("PushLogAC2705", "read msg cause:" + e2.toString() + " may be old PushDataReqMessage");
            return this;
        }
    }

    public byte[] b() {
        byte[] bArr = new byte[0];
        try {
            if (this.c == null) {
                e.d("PushLogAC2705", "encode error, mMsgId = null");
                return bArr;
            } else if (this.d == null) {
                e.d("PushLogAC2705", "encode error, reason mToken = null");
                return bArr;
            } else if (this.f == null) {
                e.d("PushLogAC2705", "encode error, reason mMsgData = null");
                return bArr;
            } else if (this.h == null) {
                e.d("PushLogAC2705", "encode error, reason mPackage = null");
                return bArr;
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(a());
                byteArrayOutputStream.write(this.c);
                byteArrayOutputStream.write(this.d);
                byteArrayOutputStream.write(a.b(this.f.length));
                byteArrayOutputStream.write(this.f);
                byte[] bArr2 = new byte[2];
                if (this.g > 127) {
                    bArr2[0] = Byte.MAX_VALUE;
                    bArr2[1] = (byte) (this.g - TransportMediator.KEYCODE_MEDIA_PAUSE);
                } else {
                    bArr2[0] = 0;
                    bArr2[1] = (byte) this.g;
                }
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(this.h);
                return byteArrayOutputStream.toByteArray();
            }
        } catch (Exception e2) {
            e.a("PushLogAC2705", "encode error," + e2.toString());
            return bArr;
        }
    }

    public byte[] d() {
        return this.c;
    }

    public byte[] e() {
        return this.d;
    }

    public byte[] f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public byte[] h() {
        return this.h;
    }

    public byte i() {
        return this.b;
    }

    public String toString() {
        String str;
        byte[] bArr = this.h;
        if (bArr != null) {
            try {
                str = new String(bArr, "UTF-8");
            } catch (Exception e2) {
                e.a("PushLogAC2705", e2.toString(), (Throwable) e2);
            }
            StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
            stringBuffer.append(" cmdId:");
            stringBuffer.append(j());
            stringBuffer.append(",msgId:");
            stringBuffer.append(a.a(this.c));
            stringBuffer.append(",deviceToken:");
            stringBuffer.append(a.a(this.d));
            stringBuffer.append(",msgData:");
            stringBuffer.append(a.a(this.f));
            stringBuffer.append(", mPackageLen:");
            stringBuffer.append(this.g);
            stringBuffer.append(", pkgName:");
            stringBuffer.append(str);
            return stringBuffer.toString();
        }
        str = "null";
        StringBuffer stringBuffer2 = new StringBuffer(getClass().getSimpleName());
        stringBuffer2.append(" cmdId:");
        stringBuffer2.append(j());
        stringBuffer2.append(",msgId:");
        stringBuffer2.append(a.a(this.c));
        stringBuffer2.append(",deviceToken:");
        stringBuffer2.append(a.a(this.d));
        stringBuffer2.append(",msgData:");
        stringBuffer2.append(a.a(this.f));
        stringBuffer2.append(", mPackageLen:");
        stringBuffer2.append(this.g);
        stringBuffer2.append(", pkgName:");
        stringBuffer2.append(str);
        return stringBuffer2.toString();
    }
}
