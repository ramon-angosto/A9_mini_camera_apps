package sg.bigo.ads.core.landing;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.utils.o;

public final class a {
    public static Intent a(Uri uri) {
        return new Intent("android.intent.action.VIEW", uri).addFlags(268435456);
    }

    public static String a(String str, Map<String, String> map, String str2) {
        StringBuilder sb;
        String host = Uri.parse(str2).getHost();
        if (o.b(str) || map.isEmpty() || o.b(host)) {
            return str2;
        }
        try {
            Set<String> queryParameterNames = Uri.parse(str2).getQueryParameterNames();
            if (!str.equals("all") && !str.contains(host)) {
                return str2;
            }
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : map.entrySet()) {
                if (!queryParameterNames.contains(next.getKey())) {
                    sb2.append((String) next.getValue());
                    sb2.append("&");
                }
            }
            String sb3 = sb2.toString();
            if (TextUtils.isEmpty(sb3)) {
                return str2;
            }
            String substring = sb3.substring(0, sb3.length() - 1);
            if (str2.contains("?")) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("&");
                sb.append(substring);
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("?");
                sb.append(substring);
            }
            return sb.toString();
        } catch (Throwable th) {
            sg.bigo.ads.common.k.a.a(0, "LinkUtils", "appendPixel error =" + th.getMessage());
            return str2;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Uri uri, Context context, e eVar) {
        int i;
        Intent a = a(uri);
        a.setPackage("com.android.vending");
        try {
            context.startActivity(a);
            eVar.b = 1;
            return true;
        } catch (ActivityNotFoundException unused) {
            i = 2;
            eVar.b = i;
            try {
                context.startActivity(a(uri));
                return true;
            } catch (Exception e) {
                sg.bigo.ads.common.k.a.a(0, "LinkUtils", e.toString());
                return false;
            }
        } catch (Exception e2) {
            sg.bigo.ads.common.k.a.a(0, "LinkUtils", e2.toString());
            i = 4;
            eVar.b = i;
            context.startActivity(a(uri));
            return true;
        }
    }

    public static boolean a(Uri uri, Context context, e eVar, String str) {
        if (uri == null || uri.getScheme() == null || uri.getScheme().startsWith("http")) {
            return false;
        }
        eVar.d = uri.toString();
        if (uri.getScheme().startsWith("market")) {
            Intent a = a(uri);
            a.setPackage("com.android.vending");
            try {
                context.startActivity(a);
                eVar.b = 1;
                return true;
            } catch (ActivityNotFoundException unused) {
                eVar.b = 2;
            } catch (Exception e) {
                sg.bigo.ads.common.k.a.a(0, "LinkUtils", e.toString());
                eVar.b = 4;
            }
        }
        PackageInfo packageInfo = null;
        if (!TextUtils.isEmpty(str) && (packageInfo = b.g(context, str)) != null) {
            eVar.e = new e.a();
            eVar.e.a = packageInfo.packageName;
            eVar.e.b = packageInfo.versionName;
            eVar.e.c = packageInfo.firstInstallTime;
        }
        try {
            context.startActivity(a(uri));
            eVar.c = 1;
            return true;
        } catch (ActivityNotFoundException unused2) {
            eVar.b = 2;
            if (!TextUtils.isEmpty(str) && packageInfo == null) {
                eVar.c = 3;
            }
            return false;
        } catch (Exception e2) {
            sg.bigo.ads.common.k.a.a(0, "LinkUtils", e2.toString());
            eVar.c = 4;
            eVar.c = 3;
            return false;
        }
    }

    public static boolean a(String str) {
        return str.startsWith("market://") || str.startsWith("http://play.google.com") || str.startsWith("https://play.google.com");
    }
}
