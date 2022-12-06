package com.mbridge.msdk.click;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.a;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.same.report.c;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* compiled from: CommonClickUtil */
public final class b {
    static Handler a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            super.handleMessage(message);
            try {
                if (message.what == 1000) {
                    int i = message.arg1;
                    int i2 = message.arg2;
                    Bundle data = message.getData();
                    if (data != null) {
                        String string = data.getString("rid");
                        String string2 = data.getString("cid_n");
                        str = data.getString("cid");
                        str3 = string;
                        str2 = string2;
                    } else {
                        str3 = "";
                        str2 = str3;
                        str = str2;
                    }
                    new c(a.e().g()).a(i, i2, str3, str2, str);
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    };

    public static void a(Context context, String str) {
        if (str != null && context != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null) {
                    intent.setClassName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
                }
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b(Context context, String str) {
        if (context != null && str != null) {
            try {
                Class.forName("com.mbridge.msdk.activity.MBCommonActivity");
                Intent intent = new Intent(context, Class.forName("com.mbridge.msdk.activity.MBCommonActivity"));
                intent.putExtra("url", str);
                if (!(context instanceof ContextThemeWrapper)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            } catch (ClassNotFoundException e) {
                q.d("CommonClickUtil", e.getMessage());
            } catch (Throwable th) {
                q.d("CommonClickUtil", th.getMessage());
            }
        }
    }

    public static boolean c(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
                if (packageInfo != null) {
                    return str.equals(packageInfo.packageName);
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean d(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.setData(parse);
            if (parse.getScheme().startsWith(l.b("L7QthdSsLkP8")) && a(context, intent)) {
                return true;
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            q.a("CommonClickUtil", th.getMessage(), th);
            return false;
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            if (context instanceof Activity) {
                context.startActivity(intent);
                return true;
            } else if (a.e().c() == null) {
                return false;
            } else {
                a.e().c().startActivity(intent);
                return true;
            }
        } catch (Throwable th) {
            q.a("CommonClickUtil", th.getMessage(), th);
            return false;
        }
    }

    public static void e(Context context, String str) {
        Intent launchIntentForPackage;
        ResolveInfo next;
        try {
            if (!TextUtils.isEmpty(str) && c(context, str) && (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) != null) {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(launchIntentForPackage, 0);
                if (queryIntentActivities.size() > 0 && (next = queryIntentActivities.iterator().next()) != null) {
                    ComponentName componentName = new ComponentName(next.activityInfo.packageName, next.activityInfo.name);
                    Intent intent = new Intent();
                    intent.setComponent(componentName);
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String a(String str, List<String> list, String str2) {
        if (list != null) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next)) {
                    str = str.replaceAll(next, str2);
                }
            }
        }
        return str;
    }

    public static String a(String str, String str2, String str3) {
        Map<String, a.C0056a> R;
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String host = Uri.parse(str).getHost();
            com.mbridge.msdk.b.a b = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
            if (b == null || (R = b.R()) == null || TextUtils.isEmpty(host)) {
                return str;
            }
            for (Map.Entry<String, a.C0056a> key : R.entrySet()) {
                String str4 = (String) key.getKey();
                if (!TextUtils.isEmpty(str4) && host.contains(str4)) {
                    a.C0056a aVar = R.get(str4);
                    if (aVar != null) {
                        return a(a(a(a(str, aVar.d(), String.valueOf((float) m.i(com.mbridge.msdk.foundation.controller.a.e().g()))), aVar.c(), String.valueOf((float) m.h(com.mbridge.msdk.foundation.controller.a.e().g()))), aVar.a(), str2), aVar.b(), str3);
                    }
                    return str;
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static void a(final Context context, int i, final String str) {
        if (i != 0) {
            try {
                com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
                    public final void run() {
                        try {
                            Method method = Class.forName("com.mbridge.msdk.foundation.tools.j").getMethod("mia", new Class[]{Context.class, String.class});
                            if (context == null) {
                                method.invoke((Object) null, new Object[]{com.mbridge.msdk.foundation.controller.a.e().g(), str});
                                return;
                            }
                            method.invoke((Object) null, new Object[]{context, str});
                        } catch (Throwable th) {
                            q.d("CommonClickUtil", th.getMessage());
                        }
                    }
                });
            } catch (Throwable th) {
                q.d("CommonClickUtil", th.getMessage());
            }
        }
    }
}
