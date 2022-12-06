package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.huawei.secure.android.common.ssl.util.C0946g;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class SSLUtil {

    /* renamed from: a */
    private static final String f1147a = "SSLUtil";

    /* renamed from: b */
    private static final String f1148b = "TLSv1.3";

    /* renamed from: c */
    private static final String f1149c = "TLSv1.2";

    /* renamed from: d */
    private static final String f1150d = "TLS";

    /* renamed from: e */
    private static final String f1151e = "TLSv1";

    /* renamed from: f */
    private static final String[] f1152f = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: g */
    private static final String[] f1153g = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: h */
    private static final String[] f1154h = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static String[] getEnabledCipherSuites(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] getEnabledProtocols(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void printTLSAndCipher(SSLSocket sSLSocket) {
        for (String str : sSLSocket.getEnabledProtocols()) {
            C0946g.m1580c(f1147a, "new enable protocols is : " + str);
        }
        for (String str2 : sSLSocket.getEnabledCipherSuites()) {
            C0946g.m1580c(f1147a, "new cipher suites is : " + str2);
        }
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setBlackListCipherSuites(sSLSocket, f1154h);
    }

    public static void setEnableSafeCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket != null && !setWhiteListCipherSuites(sSLSocket)) {
            setBlackListCipherSuites(sSLSocket);
        }
    }

    public static void setEnabledProtocols(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                sSLSocket.setEnabledProtocols(new String[]{f1148b, f1149c});
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 16 && i < 29) {
                sSLSocket.setEnabledProtocols(new String[]{f1149c});
            } else if (Build.VERSION.SDK_INT < 16) {
                sSLSocket.setEnabledProtocols(new String[]{f1151e});
            }
        }
    }

    public static SSLContext setSSLContext() throws NoSuchAlgorithmException {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return SSLContext.getInstance(f1148b);
        }
        if (i >= 16) {
            return SSLContext.getInstance(f1149c);
        }
        return SSLContext.getInstance(f1150d);
    }

    public static void setSSLSocketOptions(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            setEnabledProtocols(sSLSocket);
            setEnableSafeCipherSuites(sSLSocket);
        }
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 19) {
            return setWhiteListCipherSuites(sSLSocket, f1153g);
        }
        return setWhiteListCipherSuites(sSLSocket, f1152f);
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            String str = enabledCipherSuites[i];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = false;
                    break;
                } else if (upperCase.contains(strArr[i2].toUpperCase(Locale.ENGLISH))) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                arrayList.add(str);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setEnabledProtocols(SSLSocket sSLSocket, String[] strArr) {
        if (!(sSLSocket == null || strArr == null)) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e) {
                C0946g.m1579b(f1147a, "setEnabledProtocols: exception : " + e.getMessage());
            }
        }
        return false;
    }
}
