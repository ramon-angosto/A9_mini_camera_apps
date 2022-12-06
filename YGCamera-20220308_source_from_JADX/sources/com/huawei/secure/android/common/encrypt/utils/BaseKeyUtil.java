package com.huawei.secure.android.common.encrypt.utils;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

public class BaseKeyUtil {

    /* renamed from: M */
    private static final int f1116M = 16;

    /* renamed from: N */
    private static final int f1117N = 16;

    /* renamed from: O */
    private static final int f1118O = 10000;
    private static final String TAG = BaseKeyUtil.class.getSimpleName();

    /* renamed from: a */
    private static int m1472a(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    /* renamed from: a */
    private static boolean m1473a(int i) {
        return i >= 16;
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 16, z);
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        int a = m1472a(hexStr2ByteArray.length, hexStr2ByteArray2.length, hexStr2ByteArray3.length);
        if (m1474a(a, bArr)) {
            char[] cArr = new char[a];
            for (int i2 = 0; i2 < a; i2++) {
                cArr[i2] = (char) ((hexStr2ByteArray[i2] ^ hexStr2ByteArray2[i2]) ^ hexStr2ByteArray3[i2]);
            }
            if (!z) {
                C0932b.m1495d(TAG, "exportRootKey: sha1");
                return PBKDF2.pbkdf2(cArr, bArr, 10000, i * 8);
            }
            C0932b.m1495d(TAG, "exportRootKey: sha256");
            return PBKDF2.pbkdf2SHA256(cArr, bArr, 10000, i * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    public static byte[] exportRootKey(String str, String str2, String str3, String str4, int i, boolean z) {
        return exportRootKey(str, str2, str3, HexUtil.hexStr2ByteArray(str4), i, z);
    }

    public static String exportHexRootKey(String str, String str2, String str3, byte[] bArr, int i, boolean z) {
        return HexUtil.byteArray2HexStr(exportRootKey(str, str2, str3, bArr, i, z));
    }

    /* renamed from: a */
    private static boolean m1474a(int i, byte[] bArr) {
        return m1473a(i) & m1475e(bArr);
    }

    /* renamed from: e */
    private static boolean m1475e(byte[] bArr) {
        return bArr.length >= 16;
    }
}
