package sg.bigo.ads.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;

public final class b {
    private static String a;
    private static a b;

    public static class a {
        public final boolean a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public a(boolean z, String str, String str2, String str3, String str4) {
            this.a = z;
            this.e = str;
            this.d = str2;
            this.c = str3;
            this.b = str4;
        }
    }

    public static a a(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String valueOf;
        int indexOf;
        a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        boolean z = false;
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com")), 0);
        String str5 = null;
        String str6 = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.android.chrome", 0);
            if (packageInfo == null || !"com.android.chrome".equals(packageInfo.packageName)) {
                str3 = "No chrome pkg";
                str = str3;
                str2 = str5;
                a aVar2 = new a(z, a, str2, str6, str);
                b = aVar2;
                return aVar2;
            }
            a = "com.android.chrome";
            String str7 = packageInfo.versionName;
            try {
                String substring = (TextUtils.isEmpty(str7) || (indexOf = str7.indexOf(".")) < 0) ? null : str7.substring(0, indexOf);
                if (TextUtils.isEmpty(substring)) {
                    str4 = "Invalid chrome version: ";
                    valueOf = String.valueOf(str7);
                } else if (Integer.parseInt(substring) >= 45) {
                    z = true;
                    str2 = str7;
                    str = str5;
                    a aVar22 = new a(z, a, str2, str6, str);
                    b = aVar22;
                    return aVar22;
                } else {
                    str4 = "Chrome version is low: ";
                    valueOf = String.valueOf(str7);
                }
                str5 = str4.concat(valueOf);
                str2 = str7;
                str = str5;
            } catch (PackageManager.NameNotFoundException e) {
                e = e;
                str5 = str7;
                e.printStackTrace();
                str3 = e.toString();
                str = str3;
                str2 = str5;
                a aVar222 = new a(z, a, str2, str6, str);
                b = aVar222;
                return aVar222;
            } catch (Exception e2) {
                e = e2;
                str5 = str7;
                e.printStackTrace();
                str3 = e.toString();
                str = str3;
                str2 = str5;
                a aVar2222 = new a(z, a, str2, str6, str);
                b = aVar2222;
                return aVar2222;
            }
            a aVar22222 = new a(z, a, str2, str6, str);
            b = aVar22222;
            return aVar22222;
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
            e.printStackTrace();
            str3 = e.toString();
            str = str3;
            str2 = str5;
            a aVar222222 = new a(z, a, str2, str6, str);
            b = aVar222222;
            return aVar222222;
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            str3 = e.toString();
            str = str3;
            str2 = str5;
            a aVar2222222 = new a(z, a, str2, str6, str);
            b = aVar2222222;
            return aVar2222222;
        }
    }
}
