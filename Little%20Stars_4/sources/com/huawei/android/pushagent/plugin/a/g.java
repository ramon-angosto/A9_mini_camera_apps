package com.huawei.android.pushagent.plugin.a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import com.huawei.android.pushagent.plugin.tools.a.a;
import com.huawei.android.pushagent.plugin.tools.a.b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
    private JSONObject a = new JSONObject();

    public g(String str, int i, String str2, String str3, Context context) {
        try {
            e.a(BLocation.TAG, "cmd is:" + i);
            this.a.put(Constants.EXTRA_KEY_TOKEN, str);
            this.a.put("cmd", i);
            this.a.put("saltHash", str2);
            this.a.put("content", str3);
            this.a.put("appVersion", b(context));
        } catch (JSONException e) {
            e.b(BLocation.TAG, "init ReportReq error:" + e.getMessage());
        }
    }

    private static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.a(BLocation.TAG, "package not exist", (Throwable) e);
        } catch (Exception e2) {
            e.c(BLocation.TAG, "getApkVersionName error", e2);
        }
        return "0.0";
    }

    public String a() {
        return this.a.optString(Constants.EXTRA_KEY_TOKEN, "");
    }

    public String a(Context context) {
        Exception exc;
        String str;
        StringBuilder sb;
        byte[] a2 = b.a(new e(context).a().toCharArray());
        if (a2.length == 0) {
            return "";
        }
        try {
            String a3 = a.a(a2).a(d());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Constants.EXTRA_KEY_TOKEN);
            stringBuffer.append("=");
            stringBuffer.append(a());
            stringBuffer.append("&");
            stringBuffer.append("cmd");
            stringBuffer.append("=");
            stringBuffer.append(b());
            stringBuffer.append("&");
            stringBuffer.append("saltHash");
            stringBuffer.append("=");
            stringBuffer.append(c());
            stringBuffer.append("&");
            stringBuffer.append("mode");
            stringBuffer.append("=");
            stringBuffer.append(0);
            stringBuffer.append("&");
            stringBuffer.append("appVersion");
            stringBuffer.append("=");
            stringBuffer.append(e());
            stringBuffer.append("&");
            stringBuffer.append("content");
            stringBuffer.append("=");
            stringBuffer.append(a3);
            return stringBuffer.toString();
        } catch (InvalidKeyException e) {
            sb = new StringBuilder();
            sb.append("encrypt request content InvalidKeyException:");
            str = e.getMessage();
            exc = e;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return "";
        } catch (NoSuchAlgorithmException e2) {
            sb = new StringBuilder();
            sb.append("encrypt request content NoSuchAlgorithmException:");
            str = e2.getMessage();
            exc = e2;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return "";
        } catch (NoSuchPaddingException e3) {
            sb = new StringBuilder();
            sb.append("encrypt request content NoSuchPaddingException:");
            str = e3.getMessage();
            exc = e3;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return "";
        } catch (IllegalBlockSizeException e4) {
            sb = new StringBuilder();
            sb.append("encrypt request content IllegalBlockSizeException:");
            str = e4.getMessage();
            exc = e4;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return "";
        } catch (BadPaddingException e5) {
            sb = new StringBuilder();
            sb.append("encrypt request content BadPaddingException:");
            str = e5.getMessage();
            exc = e5;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return "";
        } catch (UnsupportedEncodingException e6) {
            sb = new StringBuilder();
            sb.append("encrypt request content UnsupportedEncodingException:");
            str = e6.getMessage();
            exc = e6;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return "";
        } catch (InvalidAlgorithmParameterException e7) {
            sb = new StringBuilder();
            sb.append("encrypt request content InvalidAlgorithmParameterException:");
            str = e7.getMessage();
            exc = e7;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return "";
        } catch (Exception e8) {
            sb = new StringBuilder();
            sb.append("encrypt request content Exception:");
            str = e8.getMessage();
            exc = e8;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return "";
        }
    }

    public int b() {
        return this.a.optInt("cmd", -1);
    }

    public String c() {
        return this.a.optString("saltHash", "");
    }

    public String d() {
        return this.a.optString("content", "");
    }

    public String e() {
        return this.a.optString("appVersion", "");
    }
}
