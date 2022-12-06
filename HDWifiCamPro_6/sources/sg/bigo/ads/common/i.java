package sg.bigo.ads.common;

import android.content.Context;
import android.text.TextUtils;
import com.vungle.warren.model.Advertisement;
import java.io.File;
import sg.bigo.ads.common.b.a;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.utils.o;

public final class i {
    public static String a = "";

    public static String a() {
        if (c.b() && !o.b(a)) {
            return a;
        }
        if (o.b(a)) {
            Context context = a.a;
            a = context.getFilesDir() + File.separator + "sg_bigo_ad";
        }
        File file = new File(a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return a;
    }

    public static boolean a(String str) {
        return str != null && str.equals(b());
    }

    public static String b() {
        return g() + File.separator + "files";
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Advertisement.FILE_SCHEME + c() + File.separator + str;
    }

    public static String c() {
        return g() + File.separator + "thumb";
    }

    public static String d() {
        return a() + File.separator + "image";
    }

    public static String e() {
        return a() + File.separator + "omsdk";
    }

    public static String f() {
        return a() + File.separator + "bannerjs";
    }

    private static String g() {
        return a() + File.separator + "video";
    }
}
