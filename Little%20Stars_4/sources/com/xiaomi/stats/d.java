package com.xiaomi.stats;

import com.xiaomi.smack.c;
import com.xiaomi.smack.p;
import java.net.UnknownHostException;

final class d {

    static class a {
        com.xiaomi.push.thrift.a a;
        String b;

        a() {
        }
    }

    static a a(Exception exc) {
        e(exc);
        boolean z = exc instanceof p;
        Throwable th = exc;
        if (z) {
            p pVar = (p) exc;
            th = exc;
            if (pVar.a() != null) {
                th = pVar.a();
            }
        }
        a aVar = new a();
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        String str = th.getClass().getSimpleName() + ":" + message;
        int a2 = c.a(th);
        if (a2 != 0) {
            aVar.a = com.xiaomi.push.thrift.a.a(com.xiaomi.push.thrift.a.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.a == null) {
            aVar.a = com.xiaomi.push.thrift.a.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == com.xiaomi.push.thrift.a.GSLB_TCP_ERR_OTHER) {
            aVar.b = str;
        }
        return aVar;
    }

    static a b(Exception exc) {
        com.xiaomi.push.thrift.a aVar;
        Throwable cause;
        e(exc);
        boolean z = exc instanceof p;
        Throwable th = exc;
        if (z) {
            p pVar = (p) exc;
            th = exc;
            if (pVar.a() != null) {
                th = pVar.a();
            }
        }
        a aVar2 = new a();
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        int a2 = c.a(th);
        String str = th.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            aVar2.a = com.xiaomi.push.thrift.a.a(com.xiaomi.push.thrift.a.CONN_SUCCESS.a() + a2);
            if (aVar2.a == com.xiaomi.push.thrift.a.CONN_BOSH_ERR && (cause = th.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar = com.xiaomi.push.thrift.a.CONN_BOSH_UNKNOWNHOST;
            }
            if (aVar2.a == com.xiaomi.push.thrift.a.CONN_TCP_ERR_OTHER || aVar2.a == com.xiaomi.push.thrift.a.CONN_XMPP_ERR || aVar2.a == com.xiaomi.push.thrift.a.CONN_BOSH_ERR) {
                aVar2.b = str;
            }
            return aVar2;
        }
        aVar = com.xiaomi.push.thrift.a.CONN_XMPP_ERR;
        aVar2.a = aVar;
        aVar2.b = str;
        return aVar2;
    }

    static a c(Exception exc) {
        com.xiaomi.push.thrift.a aVar;
        e(exc);
        boolean z = exc instanceof p;
        Throwable th = exc;
        if (z) {
            p pVar = (p) exc;
            th = exc;
            if (pVar.a() != null) {
                th = pVar.a();
            }
        }
        a aVar2 = new a();
        String message = th.getMessage();
        if (th.getCause() != null) {
            message = th.getCause().getMessage();
        }
        int a2 = c.a(th);
        String str = th.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            aVar = com.xiaomi.push.thrift.a.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            aVar = com.xiaomi.push.thrift.a.BIND_TCP_ERR;
        } else if (a2 != 499) {
            aVar = a2 != 109 ? a2 != 110 ? com.xiaomi.push.thrift.a.BIND_XMPP_ERR : com.xiaomi.push.thrift.a.BIND_TCP_BROKEN_PIPE : com.xiaomi.push.thrift.a.BIND_TCP_CONNRESET;
        } else {
            aVar2.a = com.xiaomi.push.thrift.a.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar = com.xiaomi.push.thrift.a.BIND_BOSH_ITEM_NOT_FOUND;
            }
            if (aVar2.a == com.xiaomi.push.thrift.a.BIND_TCP_ERR || aVar2.a == com.xiaomi.push.thrift.a.BIND_XMPP_ERR || aVar2.a == com.xiaomi.push.thrift.a.BIND_BOSH_ERR) {
                aVar2.b = str;
            }
            return aVar2;
        }
        aVar2.a = aVar;
        aVar2.b = str;
        return aVar2;
    }

    static a d(Exception exc) {
        com.xiaomi.push.thrift.a aVar;
        e(exc);
        boolean z = exc instanceof p;
        Throwable th = exc;
        if (z) {
            p pVar = (p) exc;
            th = exc;
            if (pVar.a() != null) {
                th = pVar.a();
            }
        }
        a aVar2 = new a();
        String message = th.getMessage();
        int a2 = c.a(th);
        String str = th.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            aVar = com.xiaomi.push.thrift.a.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            aVar = com.xiaomi.push.thrift.a.CHANNEL_TCP_ERR;
        } else if (a2 != 499) {
            aVar = a2 != 109 ? a2 != 110 ? com.xiaomi.push.thrift.a.CHANNEL_XMPPEXCEPTION : com.xiaomi.push.thrift.a.CHANNEL_TCP_BROKEN_PIPE : com.xiaomi.push.thrift.a.CHANNEL_TCP_CONNRESET;
        } else {
            aVar2.a = com.xiaomi.push.thrift.a.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar = com.xiaomi.push.thrift.a.CHANNEL_BOSH_ITEMNOTFIND;
            }
            if (aVar2.a == com.xiaomi.push.thrift.a.CHANNEL_TCP_ERR || aVar2.a == com.xiaomi.push.thrift.a.CHANNEL_XMPPEXCEPTION || aVar2.a == com.xiaomi.push.thrift.a.CHANNEL_BOSH_EXCEPTION) {
                aVar2.b = str;
            }
            return aVar2;
        }
        aVar2.a = aVar;
        aVar2.b = str;
        return aVar2;
    }

    private static void e(Exception exc) {
        if (exc == null) {
            throw new NullPointerException();
        }
    }
}
