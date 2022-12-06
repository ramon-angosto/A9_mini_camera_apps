package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.push.da */
public class C1712da {
    /* renamed from: a */
    public static int m2966a(Context context, int i) {
        int a = C1847gz.m3809a(context);
        if (-1 == a) {
            return -1;
        }
        return (i * (a == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a */
    public static int m2967a(C1868ho hoVar) {
        return C1774et.m3389a(hoVar.mo17766a());
    }

    /* renamed from: a */
    public static int m2968a(C1906iz izVar, C1868ho hoVar) {
        int a;
        switch (C1713db.f1996a[hoVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return C1774et.m3389a(hoVar.mo17766a());
            case 11:
                a = C1774et.m3389a(hoVar.mo17766a());
                if (izVar != null) {
                    try {
                        if (izVar instanceof C1886if) {
                            String str = ((C1886if) izVar).f3122d;
                            if (!TextUtils.isEmpty(str) && C1774et.m3390a((Enum) C1774et.m3393a(str)) != -1) {
                                a = C1774et.m3390a((Enum) C1774et.m3393a(str));
                                break;
                            }
                        } else if (izVar instanceof C1894in) {
                            String str2 = ((C1894in) izVar).f3229d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (C1774et.m3390a((Enum) C1774et.m3393a(str2)) != -1) {
                                    a = C1774et.m3390a((Enum) C1774et.m3393a(str2));
                                }
                                if (C1878hy.UploadTinyData.equals(C1774et.m3393a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        int i = a;
                        C1524b.m2160d("PERF_ERROR : parse Notification type error");
                        return i;
                    }
                }
                break;
            case 12:
                a = C1774et.m3389a(hoVar.mo17766a());
                if (izVar != null) {
                    try {
                        if (izVar instanceof C1890ij) {
                            String b = ((C1890ij) izVar).mo18028b();
                            if (!TextUtils.isEmpty(b) && C1788fe.m3488a(b) != -1) {
                                a = C1788fe.m3488a(b);
                                break;
                            }
                        } else if (izVar instanceof C1889ii) {
                            String a2 = ((C1889ii) izVar).mo18004a();
                            if (!TextUtils.isEmpty(a2) && C1788fe.m3488a(a2) != -1) {
                                return C1788fe.m3488a(a2);
                            }
                        }
                    } catch (Exception unused2) {
                        C1524b.m2160d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a;
    }

    /* renamed from: a */
    public static void m2969a(String str, Context context, int i, int i2) {
        if (i > 0 && i2 > 0) {
            int a = m2966a(context, i2);
            if (i != C1774et.m3390a((Enum) C1878hy.UploadTinyData)) {
                C1776eu.m3405a(context.getApplicationContext()).mo17533a(str, i, 1, (long) a);
            }
        }
    }

    /* renamed from: a */
    public static void m2970a(String str, Context context, C1891ik ikVar, int i) {
        C1868ho a;
        if (context != null && ikVar != null && (a = ikVar.mo18043a()) != null) {
            int a2 = m2967a(a);
            if (i <= 0) {
                byte[] a3 = C1905iy.m4543a(ikVar);
                i = a3 != null ? a3.length : 0;
            }
            m2969a(str, context, a2, i);
        }
    }

    /* renamed from: a */
    public static void m2971a(String str, Context context, C1906iz izVar, C1868ho hoVar, int i) {
        m2969a(str, context, m2968a(izVar, hoVar), i);
    }

    /* renamed from: a */
    public static void m2972a(String str, Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            C1891ik ikVar = new C1891ik();
            try {
                C1905iy.m4542a(ikVar, bArr);
                m2970a(str, context, ikVar, bArr.length);
            } catch (C1913je unused) {
                C1524b.m2141a("fail to convert bytes to container");
            }
        }
    }
}
