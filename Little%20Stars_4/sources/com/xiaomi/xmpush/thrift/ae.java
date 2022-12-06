package com.xiaomi.xmpush.thrift;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.b;
import com.xiaomi.channel.commonutils.misc.c;
import org.apache.thrift.a;
import org.apache.thrift.e;
import org.apache.thrift.f;
import org.apache.thrift.g;
import org.apache.thrift.protocol.a;
import org.apache.thrift.protocol.k;

public class ae {
    public static short a(Context context, String str) {
        int i = 0;
        int a = b.d(context, str).a() + 0 + (c.b(context) ? 4 : 0);
        if (c.a(context)) {
            i = 8;
        }
        return (short) (a + i);
    }

    public static <T extends a<T, ?>> void a(T t, byte[] bArr) {
        if (bArr != null) {
            new e(new k.a(true, true, bArr.length)).a(t, bArr);
            return;
        }
        throw new f("the message byte is empty.");
    }

    public static <T extends a<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new g(new a.C0057a()).a(t);
        } catch (f e) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", (Throwable) e);
            return null;
        }
    }
}
