package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1660bl;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1880i;
import com.xiaomi.push.C1884id;
import com.xiaomi.push.C1885ie;
import com.xiaomi.push.C1886if;
import com.xiaomi.push.C1890ij;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1896ip;
import com.xiaomi.push.C1897iq;
import com.xiaomi.push.C1898ir;
import com.xiaomi.push.C1900it;
import com.xiaomi.push.C1902iv;
import com.xiaomi.push.C1904ix;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1906iz;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.mipush.sdk.ai */
public class C1562ai {
    /* renamed from: a */
    protected static <T extends C1906iz<T, ?>> C1891ik m2286a(Context context, T t, C1868ho hoVar) {
        return m2287a(context, t, hoVar, !hoVar.equals(C1868ho.Registration), context.getPackageName(), C1578b.m2373a(context).mo17163a());
    }

    /* renamed from: a */
    protected static <T extends C1906iz<T, ?>> C1891ik m2287a(Context context, T t, C1868ho hoVar, boolean z, String str, String str2) {
        return m2288a(context, t, hoVar, z, str, str2, true);
    }

    /* renamed from: a */
    protected static <T extends C1906iz<T, ?>> C1891ik m2288a(Context context, T t, C1868ho hoVar, boolean z, String str, String str2, boolean z2) {
        String str3;
        byte[] a = C1905iy.m4543a(t);
        if (a == null) {
            str3 = "invoke convertThriftObjectToBytes method, return null.";
        } else {
            C1891ik ikVar = new C1891ik();
            if (z) {
                String d = C1578b.m2373a(context).mo17174d();
                if (TextUtils.isEmpty(d)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a = C1880i.m4000b(C1660bl.m2714a(d), a);
                    } catch (Exception unused) {
                        C1524b.m2160d("encryption error. ");
                    }
                }
            }
            C1884id idVar = new C1884id();
            idVar.f3055a = 5;
            idVar.f3056a = "fakeid";
            ikVar.mo18046a(idVar);
            ikVar.mo18048a(ByteBuffer.wrap(a));
            ikVar.mo18044a(hoVar);
            ikVar.mo18051b(z2);
            ikVar.mo18050b(str);
            ikVar.mo18049a(z);
            ikVar.mo18047a(str2);
            return ikVar;
        }
        C1524b.m2141a(str3);
        return null;
    }

    /* renamed from: a */
    public static C1906iz m2289a(Context context, C1891ik ikVar) {
        byte[] bArr;
        if (ikVar.mo18052b()) {
            try {
                bArr = C1880i.m3999a(C1660bl.m2714a(C1578b.m2373a(context).mo17174d()), ikVar.mo18043a());
            } catch (Exception e) {
                throw new C1599u("the aes decrypt failed.", e);
            }
        } else {
            bArr = ikVar.mo18043a();
        }
        C1906iz a = m2290a(ikVar.mo18043a(), ikVar.f3196b);
        if (a != null) {
            C1905iy.m4542a(a, bArr);
        }
        return a;
    }

    /* renamed from: a */
    private static C1906iz m2290a(C1868ho hoVar, boolean z) {
        switch (hoVar) {
            case Registration:
                return new C1896ip();
            case UnRegistration:
                return new C1902iv();
            case Subscription:
                return new C1900it();
            case UnSubscription:
                return new C1904ix();
            case SendMessage:
                return new C1898ir();
            case AckMessage:
                return new C1885ie();
            case SetConfig:
                return new C1890ij();
            case ReportFeedback:
                return new C1897iq();
            case Notification:
                if (z) {
                    return new C1894in();
                }
                C1886if ifVar = new C1886if();
                ifVar.mo17965a(true);
                return ifVar;
            case Command:
                return new C1890ij();
            default:
                return null;
        }
    }

    /* renamed from: b */
    protected static <T extends C1906iz<T, ?>> C1891ik m2291b(Context context, T t, C1868ho hoVar, boolean z, String str, String str2) {
        return m2288a(context, t, hoVar, z, str, str2, false);
    }
}
