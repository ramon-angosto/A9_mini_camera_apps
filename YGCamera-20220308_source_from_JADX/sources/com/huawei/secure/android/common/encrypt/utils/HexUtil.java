package com.huawei.secure.android.common.encrypt.utils;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class HexUtil {
    private static final String TAG = "HexUtil";

    /* renamed from: i */
    private static final String f1122i = "";

    private HexUtil() {
    }

    public static String byteArray2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String byteArray2HexStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return byteArray2HexStr(str.getBytes(Key.STRING_CHARSET_NAME));
        } catch (UnsupportedEncodingException e) {
            C0932b.m1497f(TAG, "byte array 2 hex string exception : " + e.getMessage());
            return "";
        }
    }

    public static byte[] hexStr2ByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        byte[] bArr = new byte[(upperCase.length() / 2)];
        try {
            byte[] bytes = upperCase.getBytes(Key.STRING_CHARSET_NAME);
            for (int i = 0; i < bArr.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("0x");
                int i2 = i * 2;
                sb.append(new String(new byte[]{bytes[i2]}, Key.STRING_CHARSET_NAME));
                bArr[i] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i2 + 1]}, Key.STRING_CHARSET_NAME)).byteValue());
            }
        } catch (UnsupportedEncodingException | NumberFormatException e) {
            C0932b.m1497f(TAG, "hex string 2 byte array exception : " + e.getMessage());
        }
        return bArr;
    }
}
