package sg.bigo.ads.common.p;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.utils.o;

public final class b {
    /* access modifiers changed from: private */
    public static int a;
    /* access modifiers changed from: private */
    public static final List<a> b = new CopyOnWriteArrayList();
    private static boolean c = false;
    private static String d = "-1";
    private static String e = "-1";
    /* access modifiers changed from: private */
    public static int f = 0;
    private static final AtomicBoolean g = new AtomicBoolean(false);

    public interface a {
        void a(int i);
    }

    public static int a(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i = activity.getResources().getConfiguration().orientation;
        if (1 == i) {
            return (rotation == 1 || rotation == 2) ? 9 : 1;
        }
        if (2 == i) {
            return (rotation == 2 || rotation == 3) ? 8 : 0;
        }
        sg.bigo.ads.common.k.a.a(0, "DeviceUtil", "Unknown orientation. return portrait by default");
        return 9;
    }

    public static String a(Context context) {
        Resources resources;
        Locale locale;
        if (context == null || (resources = context.getResources()) == null || (locale = resources.getConfiguration().locale) == null) {
            return Locale.US.getLanguage();
        }
        String language = locale.getLanguage();
        return language.equals("iw") ? "he" : language.equals("in") ? "id" : language.equals("ji") ? "yi" : language;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (!b.contains(aVar)) {
                b.add(aVar);
            }
            if (!c) {
                c = true;
                sg.bigo.ads.common.k.a.a(0, 3, "DeviceUtil", "registerScreenListener");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                sg.bigo.ads.common.b.a.a.registerReceiver(new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        String action = intent.getAction();
                        if (!o.b(action)) {
                            int d = b.a;
                            sg.bigo.ads.common.k.a.a(0, 3, "DeviceUtil", "action = ".concat(String.valueOf(action)));
                            char c = 65535;
                            int hashCode = action.hashCode();
                            if (hashCode != -2128145023) {
                                if (hashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                                    c = 0;
                                }
                            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                                c = 1;
                            }
                            if (c == 0) {
                                int unused = b.a = 1;
                            } else if (c == 1) {
                                int unused2 = b.a = 2;
                            }
                            if (d != b.a) {
                                for (a a : b.b) {
                                    a.a(b.a);
                                }
                            }
                        }
                    }
                }, intentFilter);
            }
        }
    }

    public static boolean a() {
        if (a == 0) {
            PowerManager powerManager = (PowerManager) sg.bigo.ads.common.b.a.a.getSystemService("power");
            a = powerManager == null || powerManager.isScreenOn() ? 1 : 2;
        }
        return a == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r1 = (r1 = r1.getResources()).getConfiguration().locale;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r1) {
        /*
            java.lang.String r0 = "zz"
            if (r1 != 0) goto L_0x0005
            return r0
        L_0x0005:
            android.content.res.Resources r1 = r1.getResources()
            if (r1 != 0) goto L_0x000c
            return r0
        L_0x000c:
            android.content.res.Configuration r1 = r1.getConfiguration()
            java.util.Locale r1 = r1.locale
            if (r1 != 0) goto L_0x0015
            return r0
        L_0x0015:
            java.lang.String r1 = r1.getCountry()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.p.b.b(android.content.Context):java.lang.String");
    }

    public static void b() {
        d = "-1";
        e = "-1";
    }

    public static String c(Context context) {
        if ("-1".equals(d)) {
            d = "";
            if (!sg.bigo.ads.common.utils.b.c(context, "android.permission.READ_PHONE_STATE")) {
                return d;
            }
            try {
                d = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return d;
    }

    public static boolean c() {
        return g() && f == 1;
    }

    public static String d(Context context) {
        if ("-1".equals(e)) {
            e = "";
            if (!sg.bigo.ads.common.utils.b.c(context, "android.permission.READ_PHONE_STATE")) {
                return e;
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                e = networkCountryIso;
                if (TextUtils.isEmpty(networkCountryIso)) {
                    e = telephonyManager.getSimCountryIso();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return e;
    }

    public static String e(Context context) {
        String str;
        if (Build.VERSION.SDK_INT < 19) {
            return "534.30";
        }
        try {
            str = context.getPackageManager().getPackageInfo("com.google.android.webview", 0).versionName;
        } catch (Exception unused) {
            str = "";
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            return !TextUtils.isEmpty(defaultUserAgent) ? defaultUserAgent.substring(defaultUserAgent.indexOf("Chrome/") + 7, defaultUserAgent.indexOf("Mobile")).trim() : defaultUserAgent;
        } catch (Exception unused2) {
            return str;
        }
    }

    public static void f(Context context) {
        if (!g.getAndSet(true) && g()) {
            sg.bigo.ads.common.k.a.a(0, 3, "DeviceUtil", "Register display listener");
            final DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            displayManager.registerDisplayListener(new DisplayManager.DisplayListener() {
                public final void onDisplayAdded(int i) {
                }

                public final void onDisplayChanged(int i) {
                    if (i == 0) {
                        int unused = b.f = displayManager.getDisplay(i).getState();
                    }
                    sg.bigo.ads.common.k.a.a(0, 3, "DeviceUtil", "onDisplayChanged: " + i + ", sDefaultDisplayState: " + b.f);
                }

                public final void onDisplayRemoved(int i) {
                }
            }, (Handler) null);
        }
    }

    private static boolean g() {
        return Build.VERSION.SDK_INT >= 20;
    }
}
