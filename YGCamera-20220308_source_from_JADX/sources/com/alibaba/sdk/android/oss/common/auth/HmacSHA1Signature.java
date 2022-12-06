package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import java.io.UnsupportedEncodingException;
import javax.crypto.Mac;

public class HmacSHA1Signature {
    private static final String ALGORITHM = "HmacSHA1";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Object LOCK = new Object();
    private static final String VERSION = "1";
    private static Mac macInstance;

    public String getAlgorithm() {
        return ALGORITHM;
    }

    public String getVersion() {
        return VERSION;
    }

    public String computeSignature(String str, String str2) {
        OSSLog.logDebug(getAlgorithm(), false);
        OSSLog.logDebug(getVersion(), false);
        try {
            OSSLog.logDebug("sign start");
            byte[] sign = sign(str.getBytes("UTF-8"), str2.getBytes("UTF-8"));
            OSSLog.logDebug("base64 start");
            return BinaryUtil.toBase64String(sign);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("Unsupported algorithm: UTF-8");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] sign(byte[] r4, byte[] r5) {
        /*
            r3 = this;
            javax.crypto.Mac r0 = macInstance     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
            if (r0 != 0) goto L_0x001a
            java.lang.Object r0 = LOCK     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
            monitor-enter(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
            javax.crypto.Mac r1 = macInstance     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x0015
            java.lang.String r1 = r3.getAlgorithm()     // Catch:{ all -> 0x0017 }
            javax.crypto.Mac r1 = javax.crypto.Mac.getInstance(r1)     // Catch:{ all -> 0x0017 }
            macInstance = r1     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            goto L_0x001a
        L_0x0017:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r4     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
        L_0x001a:
            javax.crypto.Mac r0 = macInstance     // Catch:{ CloneNotSupportedException -> 0x0023 }
            java.lang.Object r0 = r0.clone()     // Catch:{ CloneNotSupportedException -> 0x0023 }
            javax.crypto.Mac r0 = (javax.crypto.Mac) r0     // Catch:{ CloneNotSupportedException -> 0x0023 }
            goto L_0x002b
        L_0x0023:
            java.lang.String r0 = r3.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
            javax.crypto.Mac r0 = javax.crypto.Mac.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
        L_0x002b:
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
            java.lang.String r2 = r3.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
            r1.<init>(r4, r2)     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
            r0.init(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
            byte[] r4 = r0.doFinal(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0044, InvalidKeyException -> 0x003c }
            return r4
        L_0x003c:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "key must not be null"
            r4.<init>(r5)
            throw r4
        L_0x0044:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "Unsupported algorithm: HmacSHA1"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.auth.HmacSHA1Signature.sign(byte[], byte[]):byte[]");
    }
}
