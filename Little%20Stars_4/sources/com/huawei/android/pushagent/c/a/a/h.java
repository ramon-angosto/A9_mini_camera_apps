package com.huawei.android.pushagent.c.a.a;

import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class h {
    public static String a(String str) {
        String str2;
        Exception exc;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer(40);
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            e.a(BLocation.TAG, "getSHA256str:" + stringBuffer.toString());
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            str2 = e.toString();
            exc = e;
            e.c(BLocation.TAG, str2, exc);
            return str;
        } catch (NullPointerException e2) {
            str2 = e2.toString();
            exc = e2;
            e.c(BLocation.TAG, str2, exc);
            return str;
        } catch (Exception e3) {
            str2 = e3.toString();
            exc = e3;
            e.c(BLocation.TAG, str2, exc);
            return str;
        }
    }
}
