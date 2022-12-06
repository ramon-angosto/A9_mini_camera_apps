package com.huawei.agconnect.config.p006a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.agconnect.config.a.h */
class C0548h implements C0544d {

    /* renamed from: a */
    private final Context f108a;

    /* renamed from: b */
    private final String f109b;

    C0548h(Context context, String str) {
        this.f108a = context;
        this.f109b = str;
    }

    /* renamed from: a */
    private static String m63a(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("agc_");
            sb.append(C0545e.m55a(m64a(str.getBytes(Key.STRING_CHARSET_NAME))));
            return sb.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static byte[] m64a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }

    public String getString(String str, String str2) {
        int identifier;
        String a = m63a(str);
        if (TextUtils.isEmpty(a) || (identifier = this.f108a.getResources().getIdentifier(a, "string", this.f109b)) == 0) {
            return str2;
        }
        try {
            return this.f108a.getResources().getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return str2;
        }
    }
}
