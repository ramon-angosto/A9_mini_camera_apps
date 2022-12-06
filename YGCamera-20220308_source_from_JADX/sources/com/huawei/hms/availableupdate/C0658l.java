package com.huawei.hms.availableupdate;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.utils.Checker;
import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.hms.availableupdate.l */
/* compiled from: ContentUriHelper */
public class C0658l {

    /* renamed from: a */
    public Context f395a;

    /* renamed from: b */
    public String f396b;

    /* renamed from: a */
    public static File m334a(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalFile();
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m335b(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public final String mo13277c(String str) {
        int indexOf;
        String b;
        String a = mo13274a();
        if (a != null && (indexOf = str.indexOf(47, 1)) >= 0 && "ContentUriHelper".equals(Uri.decode(str.substring(1, indexOf))) && (b = m335b(new File(a, Uri.decode(str.substring(indexOf + 1))))) != null && b.startsWith(a)) {
            return b;
        }
        return null;
    }

    /* renamed from: a */
    public void mo13275a(Context context) {
        if (this.f395a == null) {
            Checker.checkNonNull(context, "context must not be null.");
            this.f395a = context;
        }
    }

    /* renamed from: b */
    public final String mo13276b(String str) {
        int i;
        String a = mo13274a();
        if (a == null || !str.startsWith(a)) {
            return null;
        }
        if (a.endsWith("/")) {
            i = a.length();
        } else {
            i = a.length() + 1;
        }
        return Uri.encode("ContentUriHelper") + '/' + str.substring(i);
    }

    /* renamed from: a */
    public File mo13273a(String str) {
        String a = mo13274a();
        if (a == null) {
            return null;
        }
        return m334a(new File(a, str));
    }

    /* renamed from: a */
    public final String mo13274a() {
        String str;
        Context context = (Context) Checker.assertNonNull(this.f395a, "mContext is null, call setContext first.");
        synchronized (this) {
            if (this.f396b == null) {
                if (context.getExternalCacheDir() != null) {
                    this.f396b = m335b(context.getExternalCacheDir());
                } else {
                    this.f396b = m335b(context.getFilesDir());
                }
            }
            str = this.f396b;
        }
        return str;
    }

    /* renamed from: a */
    public Uri mo13271a(File file, String str) {
        String b;
        String b2 = m335b(file);
        if (b2 == null || (b = mo13276b(b2)) == null) {
            return null;
        }
        return new Uri.Builder().scheme(RemoteMessageConst.Notification.CONTENT).authority(str).encodedPath(b).build();
    }

    /* renamed from: a */
    public File mo13272a(Uri uri) {
        String c;
        String encodedPath = uri.getEncodedPath();
        if (encodedPath == null || (c = mo13277c(encodedPath)) == null) {
            return null;
        }
        return m334a(new File(c));
    }
}
