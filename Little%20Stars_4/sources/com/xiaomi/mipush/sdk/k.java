package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.ad;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.l;
import com.xiaomi.xmpush.thrift.o;
import com.xiaomi.xmpush.thrift.p;
import com.xiaomi.xmpush.thrift.s;
import com.xiaomi.xmpush.thrift.u;
import com.xiaomi.xmpush.thrift.w;
import com.xiaomi.xmpush.thrift.x;
import com.xiaomi.xmpush.thrift.z;
import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.thrift.a;

public class k {
    private static final byte[] a = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    protected static <T extends a<T, ?>> p a(Context context, T t, com.xiaomi.xmpush.thrift.a aVar) {
        return a(context, t, aVar, !aVar.equals(com.xiaomi.xmpush.thrift.a.Registration), context.getPackageName(), a.a(context).c());
    }

    protected static <T extends a<T, ?>> p a(Context context, T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, String str, String str2) {
        String str3;
        byte[] a2 = ae.a(t);
        if (a2 == null) {
            str3 = "invoke convertThriftObjectToBytes method, return null.";
        } else {
            p pVar = new p();
            if (z) {
                String f = a.a(context).f();
                if (TextUtils.isEmpty(f)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a2 = b(com.xiaomi.channel.commonutils.string.a.a(f), a2);
                    } catch (Exception unused) {
                        b.d("encryption error. ");
                    }
                }
            }
            com.xiaomi.xmpush.thrift.k kVar = new com.xiaomi.xmpush.thrift.k();
            kVar.a = 5;
            kVar.b = "fakeid";
            pVar.a(kVar);
            pVar.a(ByteBuffer.wrap(a2));
            pVar.a(aVar);
            pVar.c(true);
            pVar.b(str);
            pVar.a(z);
            pVar.a(str2);
            return pVar;
        }
        b.a(str3);
        return null;
    }

    private static Cipher a(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, secretKeySpec, ivParameterSpec);
        return instance;
    }

    public static a a(Context context, p pVar) {
        byte[] bArr;
        if (pVar.c()) {
            try {
                bArr = a(com.xiaomi.channel.commonutils.string.a.a(a.a(context).f()), pVar.f());
            } catch (Exception e) {
                throw new c("the aes decrypt failed.", e);
            }
        } else {
            bArr = pVar.f();
        }
        a a2 = a(pVar.a());
        if (a2 != null) {
            ae.a(a2, bArr);
        }
        return a2;
    }

    private static a a(com.xiaomi.xmpush.thrift.a aVar) {
        switch (aVar) {
            case Registration:
                return new u();
            case UnRegistration:
                return new ab();
            case Subscription:
                return new z();
            case UnSubscription:
                return new ad();
            case SendMessage:
                return new x();
            case AckMessage:
                return new l();
            case SetConfig:
                return new o();
            case ReportFeedback:
                return new w();
            case Notification:
                return new s();
            case Command:
                return new o();
            default:
                return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 2).doFinal(bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, 1).doFinal(bArr2);
    }
}
