package sg.bigo.ads.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsIntent;
import com.mbridge.msdk.MBridgeConstans;
import sg.bigo.ads.a.a;
import sg.bigo.ads.a.a.a;
import sg.bigo.ads.a.a.b;
import sg.bigo.ads.a.b;
import sg.bigo.ads.common.k.a;

public final class c {
    private static boolean a = true;

    private static void a() {
        a.a(0, 3, "ChromeTabsStatic", "Chrome tabs libs does not exist.");
        a = false;
    }

    public static void a(final Context context) {
        a(context, "", (a.b) null, "warmup", new Runnable() {
            public final void run() {
                b a2 = b.a();
                Context context = context;
                if (context != null) {
                    sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs warming up.");
                    a2.a(context.getApplicationContext());
                }
            }
        });
    }

    public static void a(Context context, String str, int i, int i2, boolean z, Bitmap bitmap, a.c cVar, a.b bVar) {
        final Context context2 = context;
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        final Bitmap bitmap2 = bitmap;
        final a.c cVar2 = cVar;
        final a.b bVar2 = bVar;
        a(context, str, bVar, "open", new Runnable() {
            public final void run() {
                Uri uri;
                b a2 = b.a();
                Context context = context2;
                String str = str2;
                int i = i3;
                int i2 = i4;
                boolean z = z2;
                Bitmap bitmap = bitmap2;
                a.c cVar = cVar2;
                a.b bVar = bVar2;
                if (!TextUtils.isEmpty(str)) {
                    a2.b.remove(str);
                }
                sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Start load url: " + str + " with chrome tab current thread: " + Thread.currentThread().getName() + ".");
                try {
                    uri = Uri.parse(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    uri = null;
                }
                if (uri == null) {
                    sg.bigo.ads.common.k.a.a(0, "ChromeTabsStatic", "Stop open chrome tab with error url.");
                    if (bVar != null) {
                        bVar.a(context, str, 3, "Invalid url");
                        return;
                    }
                    return;
                }
                a2.a(context);
                a2.a.d = new CustomTabsCallback(cVar) {
                    final /* synthetic */ a.c a;

                    {
                        this.a = r2;
                    }

                    public final void onNavigationEvent(int i, Bundle bundle) {
                        super.onNavigationEvent(i, bundle);
                        if (this.a != null) {
                            sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Receive custom tab event: " + b.a(i));
                            if (i == 5) {
                                this.a.a();
                            } else if (i == 1) {
                                this.a.b();
                            } else if (i == 3) {
                                this.a.d();
                            } else if (i == 4) {
                                this.a.c();
                            } else if (i == 2) {
                                this.a.e();
                            } else if (i == 6) {
                                this.a.f();
                                b.this.a.d = null;
                            }
                        }
                    }
                };
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(a2.a.a());
                if (i != 0) {
                    builder.setToolbarColor(i);
                }
                if (i2 != 0) {
                    builder.setSecondaryToolbarColor(i2);
                }
                if (bitmap != null) {
                    builder.setCloseButtonIcon(bitmap);
                }
                builder.setShowTitle(z);
                CustomTabsIntent build = builder.build();
                try {
                    Context a3 = sg.bigo.ads.common.b.c.a();
                    if (a3 == null) {
                        a3 = context;
                    }
                    b.AnonymousClass2 r5 = new a.b(bVar, str) {
                        final /* synthetic */ a.b a;
                        final /* synthetic */ String b;

                        {
                            this.a = r2;
                            this.b = r3;
                        }

                        public final void a(Context context, b.a aVar) {
                            a.b bVar = this.a;
                            if (bVar != null) {
                                bVar.a(context, this.b, 2, aVar == null ? "" : aVar.b);
                            }
                        }

                        public final void a(b.a aVar) {
                            a.b bVar = this.a;
                            if (bVar != null && aVar != null) {
                                bVar.a(aVar.e, aVar.d, aVar.c);
                            }
                        }
                    };
                    b.a a4 = sg.bigo.ads.a.a.b.a(a3);
                    if (a4 != null) {
                        if (a4.a) {
                            build.intent.setPackage(a4.e);
                            build.launchUrl(a3, uri);
                            r5.a(a4);
                            return;
                        }
                    }
                    r5.a(a3, a4);
                } catch (Exception e3) {
                    if (bVar != null) {
                        bVar.a(context, str, 4, e3.toString());
                    }
                    a2.a.d = null;
                    e3.printStackTrace();
                }
            }
        });
    }

    public static void a(final Context context, final String str, final a.b bVar) {
        a(context, str, bVar, "preload", new Runnable() {
            public final void run() {
                b a2 = b.a();
                Context context = context;
                String str = str;
                a.b bVar = bVar;
                sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Start preload url: " + str + " with chrome tab current thread: " + Thread.currentThread().getName() + ".");
                if (context == null) {
                    sg.bigo.ads.common.k.a.a(0, "ChromeTabsStatic", "Preload: empty context!");
                    if (bVar != null) {
                        bVar.a(context, str, 3, "Invalid context");
                        return;
                    }
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                if (TextUtils.isEmpty(str)) {
                    sg.bigo.ads.common.k.a.a(0, "ChromeTabsStatic", "Preload: empty url!");
                    if (bVar != null) {
                        bVar.a(applicationContext, str, 3, "Invalid url");
                        return;
                    }
                    return;
                }
                a2.b.add(str);
                if (a2.a(applicationContext)) {
                    sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Meet the conditions for connection of Chrome service.");
                    a2.b();
                    if (bVar != null) {
                        bVar.a("", MBridgeConstans.ENDCARD_URL_TYPE_PL, "");
                        return;
                    }
                    return;
                }
                sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Failed to make connection of Chrome service.");
                a2.b.remove(str);
                if (bVar != null) {
                    bVar.a(applicationContext, str, 2, "Failed to make connection of Chrome service.");
                }
            }
        });
    }

    private static void a(Context context, String str, a.b bVar, String str2, Runnable runnable) {
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "start ".concat(String.valueOf(str2)));
        if (!a) {
            sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Failed to " + str2 + " with not exists chrome tab libs");
            if (context != null && bVar != null) {
                bVar.a(context, str, 1, "NoClassDefFoundError");
                return;
            }
            return;
        }
        try {
            runnable.run();
        } catch (NoClassDefFoundError e) {
            sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Failed to " + str2 + " with not exists chrome tab libs");
            a();
            if (context != null && bVar != null) {
                bVar.a(context, str, 1, e.toString());
            }
        } catch (Throwable th) {
            sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabsStatic", "Failed to " + str2 + " with unknown reason: " + th.toString());
            th.printStackTrace();
            if (context != null && bVar != null) {
                bVar.a(context, str, 4, th.toString());
            }
        }
    }
}
