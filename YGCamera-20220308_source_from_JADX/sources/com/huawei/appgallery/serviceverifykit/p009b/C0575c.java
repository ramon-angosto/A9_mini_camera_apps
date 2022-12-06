package com.huawei.appgallery.serviceverifykit.p009b;

import android.text.TextUtils;
import com.huawei.appgallery.serviceverifykit.p009b.p010d.C0577b;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.appgallery.serviceverifykit.b.c */
public class C0575c {
    /* renamed from: a */
    private static String m123a(String str, String str2) {
        String upperCase = str.toUpperCase(Locale.getDefault());
        int indexOf = upperCase.indexOf(str2 + ContainerUtils.KEY_VALUE_DELIMITER);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP, indexOf);
        int length = indexOf + str2.length() + 1;
        return indexOf2 != -1 ? str.substring(length, indexOf2) : str.substring(length);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005b A[SYNTHETIC, Splitter:B:36:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x003d=Splitter:B:23:0x003d, B:16:0x002f=Splitter:B:16:0x002f} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate m124a(android.content.Context r6) {
        /*
            java.lang.String r0 = "close stream failed"
            java.lang.String r1 = "X509CertUtil"
            r2 = 0
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ NotFoundException -> 0x0047, IOException -> 0x003c, CertificateException -> 0x002e, all -> 0x0029 }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ NotFoundException -> 0x0047, IOException -> 0x003c, CertificateException -> 0x002e, all -> 0x0029 }
            java.lang.String r3 = "ag_sdk_cbg_root.cer"
            java.io.InputStream r6 = r6.open(r3)     // Catch:{ NotFoundException -> 0x0047, IOException -> 0x003c, CertificateException -> 0x002e, all -> 0x0029 }
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch:{ NotFoundException -> 0x0048, IOException -> 0x003d, CertificateException -> 0x002f }
            java.security.cert.Certificate r3 = r3.generateCertificate(r6)     // Catch:{ NotFoundException -> 0x0048, IOException -> 0x003d, CertificateException -> 0x002f }
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch:{ NotFoundException -> 0x0048, IOException -> 0x003d, CertificateException -> 0x002f }
            if (r6 == 0) goto L_0x0027
            r6.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0027
        L_0x0025:
            r2 = r3
            goto L_0x0052
        L_0x0027:
            r2 = r3
            goto L_0x0057
        L_0x0029:
            r6 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
            goto L_0x0059
        L_0x002e:
            r6 = r2
        L_0x002f:
            com.huawei.appgallery.serviceverifykit.b.d.b r3 = com.huawei.appgallery.serviceverifykit.p009b.p010d.C0577b.f170b     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = "CertificateException"
            r3.mo12804a(r1, r4)     // Catch:{ all -> 0x0058 }
            if (r6 == 0) goto L_0x0057
        L_0x0038:
            r6.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0057
        L_0x003c:
            r6 = r2
        L_0x003d:
            com.huawei.appgallery.serviceverifykit.b.d.b r3 = com.huawei.appgallery.serviceverifykit.p009b.p010d.C0577b.f170b     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = "can not open cbg root cer"
            r3.mo12804a(r1, r4)     // Catch:{ all -> 0x0058 }
            if (r6 == 0) goto L_0x0057
            goto L_0x0038
        L_0x0047:
            r6 = r2
        L_0x0048:
            com.huawei.appgallery.serviceverifykit.b.d.b r3 = com.huawei.appgallery.serviceverifykit.p009b.p010d.C0577b.f170b     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = "can not found cbg root cer"
            r3.mo12804a(r1, r4)     // Catch:{ all -> 0x0058 }
            if (r6 == 0) goto L_0x0057
            goto L_0x0038
        L_0x0052:
            com.huawei.appgallery.serviceverifykit.b.d.b r6 = com.huawei.appgallery.serviceverifykit.p009b.p010d.C0577b.f170b
            r6.mo12804a(r1, r0)
        L_0x0057:
            return r2
        L_0x0058:
            r2 = move-exception
        L_0x0059:
            if (r6 == 0) goto L_0x0064
            r6.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0064
        L_0x005f:
            com.huawei.appgallery.serviceverifykit.b.d.b r6 = com.huawei.appgallery.serviceverifykit.p009b.p010d.C0577b.f170b
            r6.mo12804a(r1, r0)
        L_0x0064:
            goto L_0x0066
        L_0x0065:
            throw r2
        L_0x0066:
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appgallery.serviceverifykit.p009b.C0575c.m124a(android.content.Context):java.security.cert.X509Certificate");
    }

    /* renamed from: a */
    private static X509Certificate m125a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m126a(C0573a.m118a(str));
    }

    /* renamed from: a */
    private static X509Certificate m126a(byte[] bArr) {
        if (!(bArr == null || bArr.length == 0)) {
            try {
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
                if (generateCertificate instanceof X509Certificate) {
                    return (X509Certificate) generateCertificate;
                }
            } catch (CertificateException e) {
                C0577b bVar = C0577b.f170b;
                bVar.mo12804a("X509CertUtil", "Failed to get cert: " + e.getMessage());
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m127a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    /* renamed from: a */
    public static boolean m128a(X509Certificate x509Certificate, String str) {
        return m129a(x509Certificate, "CN", str);
    }

    /* renamed from: a */
    private static boolean m129a(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(m123a(x509Certificate.getSubjectDN().getName(), str));
    }

    /* renamed from: a */
    public static boolean m130a(X509Certificate x509Certificate, List<X509Certificate> list) {
        if (!(list == null || list.size() == 0)) {
            if (x509Certificate == null) {
                C0577b.f170b.mo12804a("X509CertUtil", "rootCert is null,verify failed ");
                return false;
            }
            try {
                x509Certificate.checkValidity();
                PublicKey publicKey = x509Certificate.getPublicKey();
                int size = list.size() - 1;
                while (size >= 0) {
                    X509Certificate x509Certificate2 = list.get(size);
                    if (x509Certificate2 == null) {
                        return false;
                    }
                    try {
                        x509Certificate2.verify(publicKey);
                        x509Certificate2.checkValidity();
                        publicKey = x509Certificate2.getPublicKey();
                        size--;
                    } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                        C0577b.f170b.mo12804a("X509CertUtil", "verify failed " + e.getMessage());
                    }
                }
                return m132a(list);
            } catch (CertificateExpiredException | CertificateNotYetValidException e2) {
                C0577b.f170b.mo12804a("X509CertUtil", "verifyCertChain Exception:" + e2.getMessage());
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m131a(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) {
        if (x509Certificate == null || bArr == null || bArr2 == null || bArr2.length == 0) {
            C0577b.f170b.mo12806b("X509CertUtil", "checkSignature parameter is null");
            return false;
        }
        try {
            Signature instance = Signature.getInstance(x509Certificate.getSigAlgName());
            instance.initVerify(x509Certificate.getPublicKey());
            instance.update(bArr);
            return instance.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            C0577b.f170b.mo12805a("X509CertUtil", "failed checkSignature,Exception:", e);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m132a(List<X509Certificate> list) {
        for (int i = 1; i < list.size(); i++) {
            if (!m127a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static List<X509Certificate> m133b(String str) {
        return m134b(m136c(str));
    }

    /* renamed from: b */
    private static List<X509Certificate> m134b(List<String> list) {
        if (list == null) {
            C0577b.f170b.mo12806b("X509CertUtil", "base64 CertChain is null.");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String a : list) {
            X509Certificate a2 = m125a(a);
            if (a2 == null) {
                C0577b.f170b.mo12804a("X509CertUtil", "Failed to get cert from CertChain");
            } else {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static boolean m135b(X509Certificate x509Certificate, String str) {
        return m129a(x509Certificate, "OU", str);
    }

    /* renamed from: c */
    private static List<String> m136c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException e) {
            C0577b bVar = C0577b.f170b;
            bVar.mo12804a("X509CertUtil", "Failed to getCertChain: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
