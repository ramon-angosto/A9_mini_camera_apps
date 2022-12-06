package com.huawei.android.pushagent.a.b;

import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.huawei.android.pushagent.a.b.a.b;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class h extends b {
    private String b = null;
    private byte c = -1;
    private int d;
    private long e;
    private long f;
    private long g;
    private int h;
    private g[] i;

    public h() {
        super(c());
    }

    public h(String str, byte b2, int i2, long j, long j2, long j3, int i3, g[] gVarArr) {
        super(c());
        this.b = str;
        this.c = b2;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = i3;
        if (gVarArr != null && gVarArr.length > 0) {
            this.i = new g[gVarArr.length];
            System.arraycopy(gVarArr, 0, this.i, 0, gVarArr.length);
        }
    }

    public static byte c() {
        return -34;
    }

    public b a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[16];
        a(inputStream, bArr);
        this.b = new String(bArr, "UTF-8");
        byte[] bArr2 = new byte[1];
        a(inputStream, bArr2);
        this.c = bArr2[0];
        byte[] bArr3 = new byte[2];
        a(inputStream, bArr3);
        this.d = a.c(bArr3);
        byte[] bArr4 = new byte[8];
        a(inputStream, bArr4);
        this.e = a.d(bArr4);
        byte[] bArr5 = new byte[8];
        a(inputStream, bArr5);
        this.f = a.d(bArr5);
        byte[] bArr6 = new byte[8];
        a(inputStream, bArr6);
        this.g = a.d(bArr6);
        byte[] bArr7 = new byte[1];
        a(inputStream, bArr7);
        this.h = a.c(bArr7);
        int i2 = this.h & TransportMediator.KEYCODE_MEDIA_PAUSE;
        if (i2 > 0) {
            this.i = new g[i2];
            for (g gVar : this.i) {
                byte[] bArr8 = new byte[8];
                a(inputStream, bArr8);
                gVar.a(a.d(bArr8));
                byte[] bArr9 = new byte[1];
                a(inputStream, bArr9);
                gVar.a(bArr9[0]);
                byte[] bArr10 = new byte[1];
                a(inputStream, bArr10);
                gVar.b(bArr10[0]);
            }
        }
        return this;
    }

    public byte[] b() {
        String str;
        if (TextUtils.isEmpty(this.b)) {
            str = "encode error, reason mDeviceId = " + this.b;
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(a());
                byteArrayOutputStream.write(this.b.getBytes("UTF-8"));
                byteArrayOutputStream.write(this.c);
                byteArrayOutputStream.write(a.b(this.d));
                byteArrayOutputStream.write(a.a(this.e));
                byteArrayOutputStream.write(a.a(this.f));
                byteArrayOutputStream.write(a.a(this.g));
                byteArrayOutputStream.write((byte) this.h);
                if (this.i != null && this.i.length > 0) {
                    for (g gVar : this.i) {
                        byteArrayOutputStream.write(a.a(gVar.a()));
                        byteArrayOutputStream.write(gVar.b());
                        byteArrayOutputStream.write(gVar.c());
                    }
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                str = "encode error " + e2.toString();
            }
        }
        e.d("PushLogAC2705", str);
        return new byte[0];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append(" cmdId:");
        stringBuffer.append(j());
        stringBuffer.append(" mDeviceId:");
        stringBuffer.append(this.b);
        stringBuffer.append(" mNetworkType:");
        stringBuffer.append(this.c);
        stringBuffer.append(" mAgentVersion:");
        stringBuffer.append(this.d);
        stringBuffer.append(" mLastDisconnectTime:");
        stringBuffer.append(a.a(this.e, "yyyy-MM-dd HH:mm:ss SSS"));
        stringBuffer.append(" mCurrentConnectTime:");
        stringBuffer.append(a.a(this.f, "yyyy-MM-dd HH:mm:ss SSS"));
        stringBuffer.append(" mCurrentTime:");
        stringBuffer.append(a.a(this.g, "yyyy-MM-dd HH:mm:ss SSS"));
        stringBuffer.append(" mNetEventAccount:");
        stringBuffer.append(this.h);
        g[] gVarArr = this.i;
        if (gVarArr != null && gVarArr.length > 0) {
            for (g append : gVarArr) {
                stringBuffer.append(append);
            }
        }
        return stringBuffer.toString();
    }
}
