package com.huawei.hms.opendevice;

import com.huawei.secure.android.common.encrypt.utils.HexUtil;

/* renamed from: com.huawei.hms.opendevice.a */
/* compiled from: BaseUtil */
public abstract class C0846a {
    /* renamed from: a */
    public static String m1115a(byte[] bArr) {
        return HexUtil.byteArray2HexStr(bArr);
    }

    /* renamed from: a */
    public static byte[] m1116a(String str) {
        return HexUtil.hexStr2ByteArray(str);
    }
}
