package com.shix.shixipc;

import android.os.Build;
import android.text.TextUtils;
import com.shix.shixipc.utils.CommonUtil;

public class PushUtils {
    public static int PHONETYPE = 0;
    public static final int PHONE_HW = 1;
    public static final int PHONE_OPPO = 3;
    public static final int PHONE_VIVO = 4;
    public static final int PHONE_XM = 2;

    public static final int getPhoneType() {
        if (TextUtils.equals("Xiaomi".toLowerCase(), Build.BRAND.toLowerCase())) {
            PHONETYPE = 2;
            CommonUtil.Log(2, "-------------------检测到手机是小米手机");
        }
        if (TextUtils.equals("Huawei".toLowerCase(), Build.BRAND.toLowerCase()) || TextUtils.equals("honor".toLowerCase(), Build.BRAND.toLowerCase())) {
            PHONETYPE = 1;
            CommonUtil.Log(2, "-------------------检测到手机是华为手机");
        }
        TextUtils.equals("Meizu".toLowerCase(), Build.BRAND.toLowerCase());
        if (TextUtils.equals("oppo".toLowerCase(), Build.BRAND.toLowerCase())) {
            PHONETYPE = 3;
            CommonUtil.Log(2, "-------------------检测到手机是OPPO手机");
        }
        if (TextUtils.equals("vivo".toLowerCase(), Build.BRAND.toLowerCase())) {
            PHONETYPE = 4;
            CommonUtil.Log(2, "-------------------检测到手机是VIVO手机");
        }
        return PHONETYPE;
    }
}
