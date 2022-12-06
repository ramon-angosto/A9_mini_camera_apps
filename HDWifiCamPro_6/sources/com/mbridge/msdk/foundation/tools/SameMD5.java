package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.InternalFrame;
import com.mbridge.msdk.system.NoProGuard;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class SameMD5 implements NoProGuard {
    public static final String TAG = "MD5";

    public static String getMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            q.a(TAG, str);
            MessageDigest instance = MessageDigest.getInstance(TAG);
            instance.reset();
            instance.update(str.getBytes());
            return HexEncode(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getUPMD5(String str) {
        try {
            q.a(TAG, str);
            MessageDigest instance = MessageDigest.getInstance(TAG);
            instance.reset();
            instance.update(str.getBytes());
            return UpHexEncode(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getQftJSMD5(String str) {
        try {
            byte[] qftJSMD5Bytes = getQftJSMD5Bytes(str);
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            MessageDigest instance = MessageDigest.getInstance(TAG);
            instance.update(qftJSMD5Bytes);
            char[] cArr2 = new char[(r1 * 2)];
            int i = 0;
            for (byte b : instance.digest()) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] getQftJSMD5Bytes(String str) throws UnsupportedEncodingException {
        int length = str.length();
        byte[] bytes = str.getBytes("UTF-16LE");
        q.b(InternalFrame.ID, "b = " + ByteArrayToHexString(bytes));
        byte[] bArr = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < bytes.length; i2 += 2) {
            if (!(bytes[i2] == -1 || bytes[i2] == -2)) {
                bArr[i] = bytes[i2];
                i++;
                if (i == length) {
                    break;
                }
            }
        }
        q.b(InternalFrame.ID, "source = " + ByteArrayToHexString(bArr));
        return bArr;
    }

    public static String ByteArrayToHexString(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        byte[] bArr2 = new byte[(bArr.length * 2)];
        for (int i = 0; i < bArr2.length; i++) {
            bArr2[i] = 48;
        }
        byte[] bArr3 = new byte[(bArr.length + 1)];
        bArr3[0] = 0;
        System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        byte[] bytes = new BigInteger(bArr3).toString(16).getBytes();
        System.arraycopy(bytes, 0, bArr2, bArr2.length - bytes.length, bytes.length);
        return new String(bArr2);
    }

    private static String HexEncode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(Integer.toHexString((b & 240) >>> 4));
            sb.append(Integer.toHexString(b & 15));
        }
        return sb.toString().toLowerCase(Locale.US);
    }

    private static String UpHexEncode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(Integer.toHexString((b & 240) >>> 4));
            sb.append(Integer.toHexString(b & 15));
        }
        return sb.toString().toUpperCase(Locale.US);
    }
}
