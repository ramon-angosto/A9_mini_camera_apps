package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.android.hms.openid.C0564R;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.opendevice.c */
/* compiled from: SecretUtil */
public abstract class C0848c {

    /* renamed from: a */
    public static final String f780a = "c";

    /* renamed from: b */
    public static RootKeyUtil f781b;

    /* renamed from: c */
    public static Map<String, String> f782c = new HashMap();

    /* renamed from: d */
    public static final Object f783d = new Object();

    /* renamed from: a */
    public static String m1118a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    /* renamed from: a */
    public static byte[] m1122a(Context context) {
        byte[] a = C0846a.m1116a(context.getString(C0564R.string.push_cat_head));
        byte[] a2 = C0846a.m1116a(context.getString(C0564R.string.push_cat_body));
        return m1123a(m1124a(m1124a(a, a2), C0846a.m1116a(m1118a())));
    }

    /* renamed from: b */
    public static RootKeyUtil m1125b(Context context) {
        if (f781b == null) {
            if (m1134g()) {
                f781b = RootKeyUtil.newInstance(m1127c(), m1129d(), m1126b(), m1133f());
            } else {
                HMSLog.m1380w(f780a, "root key util is null, init root key.");
                m1130d(context);
            }
        }
        return f781b;
    }

    /* renamed from: c */
    public static String m1128c(Context context) {
        if (!m1134g()) {
            HMSLog.m1379i(f780a, "work key is empty, execute init.");
            m1130d(context);
        }
        return WorkKeyCryptUtil.decryptWorkKey(m1131e(), m1125b(context));
    }

    /* renamed from: d */
    public static void m1130d(Context context) {
        synchronized (f783d) {
            m1132e(context.getApplicationContext());
            if (m1134g()) {
                HMSLog.m1379i(f780a, "The local secret is already in separate file mode.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(C0864p.m1176a(context.getApplicationContext()));
            sb.append("/shared_prefs/LocalAvengers.xml");
            File file = new File(sb.toString());
            if (file.exists()) {
                IOUtil.deleteSecure(file);
                HMSLog.m1379i(f780a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom2 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom3 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom4 = EncryptUtil.generateSecureRandom(32);
            String a = C0846a.m1115a(generateSecureRandom);
            String a2 = C0846a.m1115a(generateSecureRandom2);
            String a3 = C0846a.m1115a(generateSecureRandom3);
            f781b = RootKeyUtil.newInstance(a, a2, a3, generateSecureRandom4);
            m1121a(a, a2, a3, C0846a.m1115a(generateSecureRandom4), WorkKeyCryptUtil.encryptWorkKey(C0846a.m1115a(EncryptUtil.generateSecureRandom(32)), f781b), context);
            HMSLog.m1379i(f780a, "generate D.");
        }
    }

    /* renamed from: e */
    public static void m1132e(Context context) {
        if (m1134g()) {
            HMSLog.m1379i(f780a, "secretKeyCache not empty.");
            return;
        }
        f782c.clear();
        String a = C0864p.m1176a(context);
        if (!TextUtils.isEmpty(a)) {
            String a2 = C0867s.m1186a(a + "/files/math/m");
            String a3 = C0867s.m1186a(a + "/files/panda/p");
            String a4 = C0867s.m1186a(a + "/files/panda/d");
            String a5 = C0867s.m1186a(a + "/files/math/t");
            String a6 = C0867s.m1186a(a + "/files/s");
            if (C0868t.m1190a(a2, a3, a4, a5, a6)) {
                f782c.put("m", a2);
                f782c.put("p", a3);
                f782c.put("d", a4);
                f782c.put("t", a5);
                f782c.put("s", a6);
            }
        }
    }

    /* renamed from: f */
    public static String m1133f() {
        return m1119a("t");
    }

    /* renamed from: g */
    public static boolean m1134g() {
        return !TextUtils.isEmpty(m1131e());
    }

    /* renamed from: a */
    public static byte[] m1124a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    /* renamed from: c */
    public static String m1127c() {
        return m1119a("m");
    }

    /* renamed from: b */
    public static String m1126b() {
        return m1119a("d");
    }

    /* renamed from: a */
    public static byte[] m1123a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] >> 2);
        }
        return bArr;
    }

    /* renamed from: a */
    public static void m1121a(String str, String str2, String str3, String str4, String str5, Context context) {
        String a = C0864p.m1176a(context.getApplicationContext());
        if (!TextUtils.isEmpty(a)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                sb.append("/files/math/m");
                m1120a("m", str, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a);
                sb2.append("/files/panda/p");
                m1120a("p", str2, sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(a);
                sb3.append("/files/panda/d");
                m1120a("d", str3, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(a);
                sb4.append("/files/math/t");
                m1120a("t", str4, sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(a);
                sb5.append("/files/s");
                m1120a("s", str5, sb5.toString());
            } catch (IOException unused) {
                HMSLog.m1377e(f780a, "save key IOException.");
            }
        }
    }

    /* renamed from: e */
    public static String m1131e() {
        return m1119a("s");
    }

    /* renamed from: d */
    public static String m1129d() {
        return m1119a("p");
    }

    /* renamed from: a */
    public static void m1120a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        HMSLog.m1379i(f780a, "save local secret key.");
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str3);
            C0867s.m1188a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), Key.STRING_CHARSET_NAME);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(outputStreamWriter);
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    f782c.put(str, str2);
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter2);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly((Writer) outputStreamWriter);
                IOUtils.closeQuietly((Writer) bufferedWriter);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStreamWriter = null;
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th;
        }
    }

    /* renamed from: a */
    public static String m1119a(String str) {
        String str2 = f782c.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
