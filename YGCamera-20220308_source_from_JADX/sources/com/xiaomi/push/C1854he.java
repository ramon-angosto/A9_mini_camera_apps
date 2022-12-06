package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.UnknownHostException;

/* renamed from: com.xiaomi.push.he */
final class C1854he {

    /* renamed from: com.xiaomi.push.he$a */
    static class C1855a {

        /* renamed from: a */
        C1789ff f2618a;

        /* renamed from: a */
        String f2619a;

        C1855a() {
        }
    }

    /* renamed from: a */
    static C1855a m3834a(Exception exc) {
        m3834a(exc);
        boolean z = exc instanceof C1823gf;
        Throwable th = exc;
        if (z) {
            C1823gf gfVar = (C1823gf) exc;
            th = exc;
            if (gfVar.mo17685a() != null) {
                th = gfVar.mo17685a();
            }
        }
        C1855a aVar = new C1855a();
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        String str = th.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        int a = C1812fw.m3652a(th);
        if (a != 0) {
            aVar.f2618a = C1789ff.m3489a(C1789ff.GSLB_REQUEST_SUCCESS.mo17573a() + a);
        }
        if (aVar.f2618a == null) {
            aVar.f2618a = C1789ff.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f2618a == C1789ff.GSLB_TCP_ERR_OTHER) {
            aVar.f2619a = str;
        }
        return aVar;
    }

    /* renamed from: a */
    private static void m3835a(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }

    /* renamed from: b */
    static C1855a m3836b(Exception exc) {
        C1789ff ffVar;
        Throwable cause;
        m3834a(exc);
        boolean z = exc instanceof C1823gf;
        Throwable th = exc;
        if (z) {
            C1823gf gfVar = (C1823gf) exc;
            th = exc;
            if (gfVar.mo17685a() != null) {
                th = gfVar.mo17685a();
            }
        }
        C1855a aVar = new C1855a();
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        int a = C1812fw.m3652a(th);
        String str = th.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (a != 0) {
            aVar.f2618a = C1789ff.m3489a(C1789ff.CONN_SUCCESS.mo17573a() + a);
            if (aVar.f2618a == C1789ff.CONN_BOSH_ERR && (cause = th.getCause()) != null && (cause instanceof UnknownHostException)) {
                ffVar = C1789ff.CONN_BOSH_UNKNOWNHOST;
            }
            if (aVar.f2618a == C1789ff.CONN_TCP_ERR_OTHER || aVar.f2618a == C1789ff.CONN_XMPP_ERR || aVar.f2618a == C1789ff.CONN_BOSH_ERR) {
                aVar.f2619a = str;
            }
            return aVar;
        }
        ffVar = C1789ff.CONN_XMPP_ERR;
        aVar.f2618a = ffVar;
        aVar.f2619a = str;
        return aVar;
    }

    /* renamed from: c */
    static C1855a m3837c(Exception exc) {
        C1789ff ffVar;
        m3834a(exc);
        boolean z = exc instanceof C1823gf;
        Throwable th = exc;
        if (z) {
            C1823gf gfVar = (C1823gf) exc;
            th = exc;
            if (gfVar.mo17685a() != null) {
                th = gfVar.mo17685a();
            }
        }
        C1855a aVar = new C1855a();
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        int a = C1812fw.m3652a(th);
        String str = th.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (a == 105) {
            ffVar = C1789ff.BIND_TCP_READ_TIMEOUT;
        } else if (a == 199) {
            ffVar = C1789ff.BIND_TCP_ERR;
        } else if (a != 499) {
            ffVar = a != 109 ? a != 110 ? C1789ff.BIND_XMPP_ERR : C1789ff.BIND_TCP_BROKEN_PIPE : C1789ff.BIND_TCP_CONNRESET;
        } else {
            aVar.f2618a = C1789ff.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ffVar = C1789ff.BIND_BOSH_ITEM_NOT_FOUND;
            }
            if (aVar.f2618a == C1789ff.BIND_TCP_ERR || aVar.f2618a == C1789ff.BIND_XMPP_ERR || aVar.f2618a == C1789ff.BIND_BOSH_ERR) {
                aVar.f2619a = str;
            }
            return aVar;
        }
        aVar.f2618a = ffVar;
        aVar.f2619a = str;
        return aVar;
    }

    /* renamed from: d */
    static C1855a m3838d(Exception exc) {
        C1789ff ffVar;
        m3834a(exc);
        boolean z = exc instanceof C1823gf;
        Throwable th = exc;
        if (z) {
            C1823gf gfVar = (C1823gf) exc;
            th = exc;
            if (gfVar.mo17685a() != null) {
                th = gfVar.mo17685a();
            }
        }
        C1855a aVar = new C1855a();
        String message = th.getMessage();
        int a = C1812fw.m3652a(th);
        String str = th.getClass().getSimpleName() + Constants.COLON_SEPARATOR + message;
        if (a == 105) {
            ffVar = C1789ff.CHANNEL_TCP_READTIMEOUT;
        } else if (a == 199) {
            ffVar = C1789ff.CHANNEL_TCP_ERR;
        } else if (a != 499) {
            ffVar = a != 109 ? a != 110 ? C1789ff.CHANNEL_XMPPEXCEPTION : C1789ff.CHANNEL_TCP_BROKEN_PIPE : C1789ff.CHANNEL_TCP_CONNRESET;
        } else {
            aVar.f2618a = C1789ff.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ffVar = C1789ff.CHANNEL_BOSH_ITEMNOTFIND;
            }
            if (aVar.f2618a == C1789ff.CHANNEL_TCP_ERR || aVar.f2618a == C1789ff.CHANNEL_XMPPEXCEPTION || aVar.f2618a == C1789ff.CHANNEL_BOSH_EXCEPTION) {
                aVar.f2619a = str;
            }
            return aVar;
        }
        aVar.f2618a = ffVar;
        aVar.f2619a = str;
        return aVar;
    }
}
