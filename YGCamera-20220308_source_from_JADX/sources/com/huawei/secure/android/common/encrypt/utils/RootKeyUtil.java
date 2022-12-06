package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;

public class RootKeyUtil {
    private static final String TAG = RootKeyUtil.class.getSimpleName();

    /* renamed from: T */
    private byte[] f1123T = null;

    private RootKeyUtil() {
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, String str4) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.m1479a(str, str2, str3, str4);
        return rootKeyUtil;
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, byte[] bArr) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.m1480a(str, str2, str3, bArr);
        return rootKeyUtil;
    }

    /* renamed from: a */
    private void m1479a(String str, String str2, String str3, String str4) {
        m1480a(str, str2, str3, HexUtil.hexStr2ByteArray(str4));
    }

    public byte[] getRootKey() {
        return (byte[]) this.f1123T.clone();
    }

    public String getRootKeyHex() {
        return HexUtil.byteArray2HexStr(this.f1123T);
    }

    /* renamed from: a */
    private void m1480a(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            C0932b.m1495d(TAG, "initRootKey: sha1");
            this.f1123T = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, false);
            return;
        }
        C0932b.m1495d(TAG, "initRootKey: sha256");
        this.f1123T = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, true);
    }
}
