package sg.bigo.ads.controller.f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.warren.model.AdAssetDBAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sg.bigo.ads.a.a;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.api.AdActivity;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.core.landing.a;

public final class d {
    private static final Map<Integer, b<?>> a = new ConcurrentHashMap();

    public static int a(int i) {
        if (i == 0) {
            return 2;
        }
        if (i != 1) {
            return i != 2 ? 5 : 4;
        }
        return 3;
    }

    public static e a(Context context, String str, String str2, String str3, boolean z, int i, b<?> bVar) {
        ArrayList arrayList;
        if (str != null) {
            arrayList = new ArrayList();
            arrayList.add(str);
        } else {
            arrayList = null;
        }
        return a(context, (List<String>) arrayList, str2, str3, z, i, bVar);
    }

    public static e a(Context context, List<String> list, final String str, String str2, boolean z, int i, final b<?> bVar) {
        boolean z2;
        a aVar;
        e eVar = new e();
        eVar.a = 0;
        if (!(bVar == null || (aVar = bVar.h) == null || aVar.b())) {
            aVar.a();
        }
        if (list != null) {
            int i2 = 0;
            z2 = false;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                String str3 = list.get(i2);
                if (!TextUtils.isEmpty(str3) && (z2 = a.a(Uri.parse(str3), context, eVar, str2))) {
                    eVar.a = 1;
                    break;
                }
                i2++;
            }
        } else {
            z2 = false;
        }
        if (!z2 && z && !TextUtils.isEmpty(str2) && (z2 = a.a(context, str2))) {
            eVar.a = 4;
        }
        if (!z2 && !TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (a.a(str)) {
                eVar.a = 2;
                a.a(parse, context, eVar);
            } else {
                eVar.a = 3;
                if (i == 1) {
                    if (!str.startsWith("http://") && !str.startsWith("https://")) {
                        str = "http://".concat(String.valueOf(str));
                    }
                    Intent a2 = a.a(Uri.parse(str));
                    if (sg.bigo.ads.common.utils.b.d(context, "com.android.chrome") == 1) {
                        a2.setPackage("com.android.chrome");
                    }
                    try {
                        context.startActivity(a2);
                    } catch (Exception e) {
                        e.printStackTrace();
                        sg.bigo.ads.common.k.a.a(2, "LinkUtils", "Unable to open target URL by system browser.");
                    }
                } else if (i == 2) {
                    a aVar2 = null;
                    c n = bVar == null ? null : bVar.n();
                    if (bVar != null) {
                        aVar2 = bVar.h;
                    }
                    final b bVar2 = new b(str, n, aVar2);
                    a.C0109a aVar3 = new a.C0109a();
                    aVar3.a = str;
                    aVar3.b = bVar2;
                    aVar3.c = new a.b() {
                        public final void a(Context context, String str, int i, String str2) {
                            sg.bigo.ads.common.k.a.a(0, 3, "WebViewStatHelper", "Open landing page by chrome tabs failed, using webView.");
                            d.a(context, str, bVar, d.a(i));
                            if (!TextUtils.isEmpty(str2)) {
                                b bVar = bVar;
                                sg.bigo.ads.core.d.a.a(bVar == null ? null : bVar.n(), (int) IronSourceConstants.BN_INSTANCE_LOAD, 10114, str2);
                            }
                        }

                        public final void a(String str, String str2, String str3) {
                            b bVar = bVar2;
                            bVar.a = str;
                            bVar.b = str2;
                            bVar.c = str3;
                        }
                    };
                    sg.bigo.ads.a.a a3 = aVar3.a();
                    sg.bigo.ads.a.c.a(context, a3.a, a3.b, a3.c, a3.d, a3.e, a3.f, a3.g);
                } else {
                    a(context, str, bVar, 0);
                }
            }
        }
        return eVar;
    }

    private static void a(int i, b<?> bVar) {
        a.put(Integer.valueOf(i), bVar);
    }

    public static void a(Context context, Class<? extends sg.bigo.ads.controller.e.b<?>> cls, b<?> bVar) {
        Intent a2 = AdActivity.a(context, cls);
        int hashCode = bVar.hashCode();
        a(hashCode, bVar);
        a2.putExtra(AdAssetDBAdapter.AdAssetColumns.COLUMN_AD_ID, hashCode);
        context.startActivity(a2);
    }

    public static void a(Context context, String str, b<?> bVar, int i) {
        Intent a2 = AdActivity.a(context, c.class);
        a2.putExtra("url", str);
        if (bVar != null) {
            int hashCode = bVar.hashCode();
            a(hashCode, bVar);
            a2.putExtra(AdAssetDBAdapter.AdAssetColumns.COLUMN_AD_ID, hashCode);
            a2.putExtra("land_way", i);
        }
        context.startActivity(a2);
    }

    public static b<?> b(int i) {
        if (a.containsKey(Integer.valueOf(i))) {
            return a.get(Integer.valueOf(i));
        }
        return null;
    }

    public static void c(int i) {
        a.remove(Integer.valueOf(i));
    }
}
