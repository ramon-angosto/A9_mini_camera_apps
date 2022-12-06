package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.C0946g;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;

/* renamed from: com.huawei.secure.android.common.ssl.hostname.b */
public class C0939b {

    /* renamed from: a */
    private static final Pattern f1217a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b */
    private static final String[] f1218b = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};

    static {
        Arrays.sort(f1218b);
    }

    /* renamed from: a */
    public static final void m1525a(String str, X509Certificate x509Certificate, boolean z) throws SSLException {
        String[] a = m1528a(x509Certificate);
        String[] b = m1530b(x509Certificate);
        C0946g.m1577a("", "cn is : " + Arrays.toString(a));
        C0946g.m1577a("", "san is : " + Arrays.toString(b));
        m1526a(str, a, b, z);
    }

    /* renamed from: b */
    public static String[] m1530b(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e) {
            C0946g.m1578a("", "Error parsing certificate.", e);
            collection = null;
        }
        if (collection != null) {
            for (List next : collection) {
                if (((Integer) next.get(0)).intValue() == 2) {
                    linkedList.add((String) next.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    /* renamed from: c */
    private static boolean m1531c(String str) {
        return f1217a.matcher(str).matches();
    }

    /* renamed from: a */
    public static final void m1526a(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        LinkedList linkedList = new LinkedList();
        if (!(strArr == null || strArr.length <= 0 || strArr[0] == null)) {
            linkedList.add(strArr[0]);
        }
        if (strArr2 != null) {
            for (String str2 : strArr2) {
                if (str2 != null) {
                    linkedList.add(str2);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            Iterator it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                stringBuffer.append(" <");
                stringBuffer.append(lowerCase2);
                stringBuffer.append('>');
                if (it.hasNext()) {
                    stringBuffer.append(" OR");
                }
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && m1527a(lowerCase2) && !m1531c(str)) {
                    boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (!endsWith || !z) {
                        z2 = endsWith;
                        continue;
                    } else if (m1529b(lowerCase) == m1529b(lowerCase2)) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                } else {
                    z2 = lowerCase.equals(lowerCase2);
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            if (!z2) {
                throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + stringBuffer);
            }
            return;
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    /* renamed from: b */
    public static int m1529b(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m1527a(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i = length - 3;
        if (str.charAt(i) != '.') {
            return true;
        }
        if (Arrays.binarySearch(f1218b, str.substring(2, i)) < 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static String[] m1528a(X509Certificate x509Certificate) {
        List<String> b = new C0938a(x509Certificate.getSubjectX500Principal()).mo14790b("cn");
        if (b.isEmpty()) {
            return null;
        }
        String[] strArr = new String[b.size()];
        b.toArray(strArr);
        return strArr;
    }
}
