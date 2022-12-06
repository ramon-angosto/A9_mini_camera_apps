package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

public class ExceptionCode {
    public static final int CANCEL = 1104;
    private static final String CONNECT = "connect";
    public static final int CONNECTION_ABORT = 110205;
    public static final int CONNECTION_REFUSED = 110209;
    public static final int CONNECTION_RESET = 110204;
    public static final int CONNECT_FAILED = 110206;
    public static final int CRASH_EXCEPTION = 1103;
    public static final int INTERRUPT_CONNECT_CLOSE = 110214;
    public static final int INTERRUPT_EXCEPTION = 110213;
    public static final int NETWORK_CHANGED = 110216;
    public static final int NETWORK_IO_EXCEPTION = 1102;
    public static final int NETWORK_UNREACHABLE = 110208;
    public static final int PROTOCOL_ERROR = 110217;
    private static final String READ = "read";
    public static final int READ_ERROR = 110203;
    public static final int ROUTE_FAILED = 110207;
    public static final int SHUTDOWN_EXCEPTION = 110218;
    public static final int SOCKET_CLOSE = 110215;
    public static final int SOCKET_CONNECT_TIMEOUT = 110221;
    public static final int SOCKET_READ_TIMEOUT = 110223;
    public static final int SOCKET_TIMEOUT = 110200;
    public static final int SOCKET_WRITE_TIMEOUT = 110225;
    public static final int SSL_HANDSHAKE_EXCEPTION = 110211;
    public static final int SSL_PEERUNVERIFIED_EXCEPTION = 110212;
    public static final int SSL_PROTOCOL_EXCEPTION = 110210;
    public static final int UNABLE_TO_RESOLVE_HOST = 110202;
    public static final int UNEXPECTED_EOF = 110201;
    private static final String WRITE = "write";

    private static String checkExceptionContainsKey(Exception exc, String... strArr) {
        String checkStrContainsKey = checkStrContainsKey(StringUtils.toLowerCase(exc.getMessage()), strArr);
        if (!TextUtils.isEmpty(checkStrContainsKey)) {
            return checkStrContainsKey;
        }
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            checkStrContainsKey = checkStrContainsKey(StringUtils.toLowerCase(stackTraceElement.toString()), strArr);
            if (!TextUtils.isEmpty(checkStrContainsKey)) {
                return checkStrContainsKey;
            }
        }
        return checkStrContainsKey;
    }

    private static String checkStrContainsKey(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }

    public static int getErrorCodeFromException(Exception exc) {
        if (exc == null) {
            return NETWORK_IO_EXCEPTION;
        }
        if (!(exc instanceof IOException)) {
            return CRASH_EXCEPTION;
        }
        String message = exc.getMessage();
        if (message == null) {
            return NETWORK_IO_EXCEPTION;
        }
        String lowerCase = StringUtils.toLowerCase(message);
        int errorCodeFromMsg = getErrorCodeFromMsg(lowerCase);
        return errorCodeFromMsg != 1102 ? errorCodeFromMsg : exc instanceof SocketTimeoutException ? getErrorCodeSocketTimeout(exc) : exc instanceof ConnectException ? CONNECT_FAILED : exc instanceof NoRouteToHostException ? ROUTE_FAILED : exc instanceof SSLProtocolException ? SSL_PROTOCOL_EXCEPTION : exc instanceof SSLHandshakeException ? SSL_HANDSHAKE_EXCEPTION : exc instanceof SSLPeerUnverifiedException ? SSL_PEERUNVERIFIED_EXCEPTION : exc instanceof UnknownHostException ? UNABLE_TO_RESOLVE_HOST : exc instanceof InterruptedIOException ? lowerCase.contains("connection has been shut down") ? INTERRUPT_CONNECT_CLOSE : INTERRUPT_EXCEPTION : errorCodeFromMsg;
    }

    private static int getErrorCodeFromMsg(String str) {
        return str.contains("unexpected end of stream") ? UNEXPECTED_EOF : str.contains("unable to resolve host") ? UNABLE_TO_RESOLVE_HOST : str.contains("read error") ? READ_ERROR : str.contains("connection reset") ? CONNECTION_RESET : str.contains("software caused connection abort") ? CONNECTION_ABORT : str.contains("failed to connect to") ? CONNECT_FAILED : str.contains("connection refused") ? CONNECTION_REFUSED : str.contains("connection timed out") ? SOCKET_CONNECT_TIMEOUT : str.contains("no route to host") ? ROUTE_FAILED : str.contains("network is unreachable") ? NETWORK_UNREACHABLE : str.contains("socket closed") ? SOCKET_CLOSE : NETWORK_IO_EXCEPTION;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getErrorCodeSocketTimeout(java.lang.Exception r7) {
        /*
            java.lang.String r0 = "write"
            java.lang.String r1 = "read"
            java.lang.String r2 = "connect"
            java.lang.String[] r3 = new java.lang.String[]{r2, r1, r0}
            java.lang.String r7 = checkExceptionContainsKey(r7, r3)
            int r3 = r7.hashCode()
            r4 = 2
            r5 = 1
            r6 = 3496342(0x355996, float:4.899419E-39)
            if (r3 == r6) goto L_0x0034
            r1 = 113399775(0x6c257df, float:7.3103804E-35)
            if (r3 == r1) goto L_0x002c
            r0 = 951351530(0x38b478ea, float:8.605591E-5)
            if (r3 == r0) goto L_0x0024
            goto L_0x003c
        L_0x0024:
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x003c
            r7 = 0
            goto L_0x003d
        L_0x002c:
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x003c
            r7 = 2
            goto L_0x003d
        L_0x0034:
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x003c
            r7 = 1
            goto L_0x003d
        L_0x003c:
            r7 = -1
        L_0x003d:
            if (r7 == 0) goto L_0x004f
            if (r7 == r5) goto L_0x004b
            if (r7 == r4) goto L_0x0047
            r7 = 110200(0x1ae78, float:1.54423E-40)
            return r7
        L_0x0047:
            r7 = 110225(0x1ae91, float:1.54458E-40)
            return r7
        L_0x004b:
            r7 = 110223(0x1ae8f, float:1.54455E-40)
            return r7
        L_0x004f:
            r7 = 110221(0x1ae8d, float:1.54453E-40)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.ExceptionCode.getErrorCodeSocketTimeout(java.lang.Exception):int");
    }
}
