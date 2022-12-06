package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.n;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.videocommon.download.f;
import com.vungle.warren.model.Advertisement;
import java.io.File;
import java.util.List;

/* compiled from: ResourceManager */
public final class j {
    private static String a = "ResourceManager";
    /* access modifiers changed from: private */
    public String b;

    /* compiled from: ResourceManager */
    private static class a {
        public static j a = new j();
    }

    private j() {
        this.b = e.b(c.MBRIDGE_700_RES);
    }

    public static j a() {
        return a.a;
    }

    public final void b() {
        try {
            if (!TextUtils.isEmpty(this.b)) {
                f.a.a.a(new com.mbridge.msdk.foundation.same.e.a() {
                    public final void b() {
                    }

                    public final void a() {
                        o.c(j.this.b);
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final synchronized String a(String str, byte[] bArr) {
        String str2;
        String str3 = "unknow exception ";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str4 = this.b + "/" + SameMD5.getMD5(y.a(str)) + ".zip";
                    File file = new File(str4);
                    if (o.a(bArr, file)) {
                        Uri parse = Uri.parse(str);
                        List<String> queryParameters = parse.getQueryParameters("nc");
                        if (queryParameters != null) {
                            if (queryParameters.size() != 0) {
                                str3 = a(str, str4, file);
                            }
                        }
                        List<String> queryParameters2 = parse.getQueryParameters("md5filename");
                        if (queryParameters2 != null && queryParameters2.size() > 0) {
                            String str5 = queryParameters2.get(0);
                            if (!TextUtils.isEmpty(str5) && str5.equals(n.a(file))) {
                                str3 = a(str, str4, file);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        o.b(file);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
                str2 = e.getMessage();
            }
        }
        str2 = str3;
        return str2;
    }

    private String a(String str, String str2, File file) {
        String a2 = o.a(str2, this.b + "/" + SameMD5.getMD5(y.a(str)));
        return TextUtils.isEmpty(a2) ? o.b(file) : a2;
    }

    public final String a(String str) {
        String str2;
        String str3 = "";
        try {
            String str4 = this.b + "/" + SameMD5.getMD5(y.a(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters("foldername");
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str5 = queryParameters.get(0);
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            String str6 = str4 + "/" + str5 + "/" + str5 + ".html";
            if (!o.a(str6)) {
                return null;
            }
            try {
                str2 = str.substring(str.indexOf("?") + 1);
            } catch (Exception unused) {
                str2 = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = "?" + str2;
            }
            return Advertisement.FILE_SCHEME + str6 + str3;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }
}
