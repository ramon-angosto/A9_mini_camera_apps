package sg.bigo.ads.common.utils;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import kotlin.UByte;
import sg.bigo.ads.common.k.a;

public final class k {
    public static String a(String str) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(random.nextInt(99999999));
        sb.append(random.nextInt(99999999));
        while (sb.length() < 16) {
            sb.append('0');
        }
        if (sb.length() > 16) {
            sb.delete(16, sb.length());
        }
        String b = b(str + sb);
        if (o.b(b)) {
            a.a(0, SameMD5.TAG, "md5WithSalt is empty!");
            return b;
        }
        char[] cArr = new char[48];
        for (int i = 0; i < 48; i++) {
            int i2 = i / 3;
            int i3 = i % 3;
            if (i3 == 0) {
                cArr[i] = b.charAt(i2 * 2);
            } else if (i3 != 1) {
                cArr[i] = b.charAt((i2 * 2) + 1);
            } else {
                cArr[i] = sb.charAt(i2);
            }
        }
        String str2 = new String(cArr);
        a.a(0, 3, SameMD5.TAG, "getMD5MixSalt, val=" + str + ", salt=" + sb + ", md5WithSalt=" + b + ", md5MixSalt=" + str2);
        return str2;
    }

    private static String b(String str) {
        byte[] bArr;
        try {
            MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
            instance.update(str.getBytes("UTF-8"));
            bArr = instance.digest();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            byte b2 = b & UByte.MAX_VALUE;
            if (b2 <= 15) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(b2));
        }
        return sb.toString().toLowerCase();
    }
}
