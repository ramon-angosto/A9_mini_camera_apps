package com.mbridge.msdk.videocommon.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.videocommon.download.f;
import java.io.File;

/* compiled from: HTMLResourceManager */
public final class h {
    /* access modifiers changed from: private */
    public String a;

    /* compiled from: HTMLResourceManager */
    private static class a {
        public static h a = new h();
    }

    private h() {
        this.a = e.b(c.MBRIDGE_700_HTML);
    }

    public static h a() {
        return a.a;
    }

    public final void b() {
        try {
            if (!TextUtils.isEmpty(this.a)) {
                f.a.a.a(new com.mbridge.msdk.foundation.same.e.a() {
                    public final void b() {
                    }

                    public final void a() {
                        o.c(h.this.a);
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final boolean a(String str, byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            if (bArr.length <= 0) {
                return false;
            }
            if (o.a(bArr, new File(this.a + "/" + SameMD5.getMD5(y.a(str)) + ".html"))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public final String a(String str) {
        try {
            String str2 = this.a + "/" + SameMD5.getMD5(y.a(str)) + ".html";
            if (!new File(str2).exists()) {
                return null;
            }
            return "file:////" + str2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final String b(String str) {
        try {
            String md5 = SameMD5.getMD5(y.a(str));
            File file = new File(this.a + "/" + md5 + ".html");
            if (file.exists()) {
                return o.a(file);
            }
            return null;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
