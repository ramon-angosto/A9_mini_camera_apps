package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import com.ironsource.environment.a;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Random;
import org.json.JSONException;

public final class g {
    private static final g d = new g();
    private String a = "";
    private String b = "";
    private String c = "";

    public static g a() {
        return d;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = "C38FB23A402222A0C17D34A92F971D1F";
        }
        return this.a;
    }

    public final synchronized String c() {
        if (TextUtils.isEmpty(this.b)) {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < 32; i++) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&'()*+,-./:;<=>?@[\\]^_`{|}~".charAt(random.nextInt(93)));
            }
            this.b = sb.toString();
        }
        return this.b;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.c)) {
            try {
                this.c = a.AnonymousClass1.a(c(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDaUZaiASqhU4+s3JiQaIzVYtC+rZiPX2K+ZRg4C21kBZDNQM5+SEkp5GT5a9W/IR2oz6Q/ucifXcc7QEo5Xl5GX1BAhFI+8KaxPmn5Km5zFdH0aCvrrpDYQpH239Q+2uuUC79G5MpfSIw0zixU4VkF0WbVdHDpgQDds39cPl6cTwIDAQAB");
            } catch (Exception e) {
                String str = "Session key encryption exception: " + e.getLocalizedMessage();
                IronLog.INTERNAL.error(str);
                throw new JSONException(str);
            }
        }
        return this.c;
    }
}
