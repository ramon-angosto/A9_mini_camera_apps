package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;

/* compiled from: AppSigning */
public class c {
    private static HashMap<String, ArrayList<String>> a = new HashMap<>();

    public static ArrayList<String> a(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (!(context == null || str == null)) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (a.get(str) != null) {
                return a.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : b(context, packageName)) {
                    String str2 = "error!";
                    if (SameMD5.TAG.equals(str)) {
                        str2 = a(signature, SameMD5.TAG);
                    } else if ("SHA1".equals(str)) {
                        str2 = a(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        str2 = a(signature, "SHA256");
                    }
                    arrayList.add(str2);
                }
            } catch (Exception e) {
                l.d(e.toString());
            }
            a.put(str, arrayList);
        }
        return arrayList;
    }

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> a2 = a(context, "SHA1");
        if (!(a2 == null || a2.size() == 0)) {
            for (int i = 0; i < a2.size(); i++) {
                sb.append(a2.get(i));
                if (i < a2.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static Signature[] b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            l.d(e.toString());
            return null;
        }
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            if (instance == null) {
                return "error!";
            }
            byte[] digest = instance.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | UByte.MIN_VALUE).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e) {
            l.d(e.toString());
            return "error!";
        }
    }
}
