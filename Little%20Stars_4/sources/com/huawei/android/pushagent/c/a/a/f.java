package com.huawei.android.pushagent.c.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class f {
    public static String a(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : a.a(str);
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            return g.a(bArr, str);
        } catch (Exception e) {
            e.c(BLocation.TAG, "rsa encrypt data error ", e);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        StringBuilder sb;
        Exception exc;
        String str;
        try {
            return c.a(bArr, 0, bArr2, 0);
        } catch (InvalidKeyException e) {
            sb = new StringBuilder();
            sb.append("InvalidKeyException:");
            str = e.getMessage();
            exc = e;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (BadPaddingException e2) {
            sb = new StringBuilder();
            sb.append("BadPaddingException:");
            str = e2.getMessage();
            exc = e2;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (IllegalBlockSizeException e3) {
            sb = new StringBuilder();
            sb.append("IllegalBlockSizeException:");
            str = e3.getMessage();
            exc = e3;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (NoSuchAlgorithmException e4) {
            sb = new StringBuilder();
            sb.append("NoSuchAlgorithmException:");
            str = e4.getMessage();
            exc = e4;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (NoSuchPaddingException e5) {
            sb = new StringBuilder();
            sb.append("NoSuchPaddingException:");
            str = e5.getMessage();
            exc = e5;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (Exception e6) {
            sb = new StringBuilder();
            sb.append("Exception:");
            str = e6.getMessage();
            exc = e6;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        }
    }

    public static String b(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : a.b(str);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        StringBuilder sb;
        Exception exc;
        String str;
        try {
            return c.a(bArr, bArr2, 0);
        } catch (InvalidKeyException e) {
            sb = new StringBuilder();
            sb.append("InvalidKeyException:");
            str = e.getMessage();
            exc = e;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (BadPaddingException e2) {
            sb = new StringBuilder();
            sb.append("BadPaddingException:");
            str = e2.getMessage();
            exc = e2;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (IllegalBlockSizeException e3) {
            sb = new StringBuilder();
            sb.append("IllegalBlockSizeException:");
            str = e3.getMessage();
            exc = e3;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (NoSuchAlgorithmException e4) {
            sb = new StringBuilder();
            sb.append("NoSuchAlgorithmException:");
            str = e4.getMessage();
            exc = e4;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (NoSuchPaddingException e5) {
            sb = new StringBuilder();
            sb.append("NoSuchPaddingException:");
            str = e5.getMessage();
            exc = e5;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        } catch (Exception e6) {
            sb = new StringBuilder();
            sb.append("Exception:");
            str = e6.getMessage();
            exc = e6;
            sb.append(str);
            e.c(BLocation.TAG, sb.toString(), exc);
            return null;
        }
    }
}
