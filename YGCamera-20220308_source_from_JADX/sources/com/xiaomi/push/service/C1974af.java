package com.xiaomi.push.service;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1656bj;
import com.xiaomi.push.C1777ev;
import com.xiaomi.push.C1778ew;
import com.xiaomi.push.C1779ex;
import com.xiaomi.push.C1816g;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.C2088v;
import com.xiaomi.push.service.C1990aq;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.service.af */
public class C1974af {

    /* renamed from: a */
    public static long f3662a;

    /* renamed from: a */
    private static volatile C1984am f3663a;

    /* renamed from: a */
    private static final LinkedList<Pair<Integer, C1891ik>> f3664a = new LinkedList<>();

    /* renamed from: a */
    private static ExecutorService f3665a = Executors.newCachedThreadPool();

    /* renamed from: com.xiaomi.push.service.af$a */
    private static class C1975a implements Callable<Bitmap> {

        /* renamed from: a */
        private Context f3666a;

        /* renamed from: a */
        private String f3667a;

        /* renamed from: a */
        private boolean f3668a;

        public C1975a(String str, Context context, boolean z) {
            this.f3666a = context;
            this.f3667a = str;
            this.f3668a = z;
        }

        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (!TextUtils.isEmpty(this.f3667a)) {
                if (this.f3667a.startsWith("http")) {
                    C1990aq.C1992b a = C1990aq.m4999a(this.f3666a, this.f3667a, this.f3668a);
                    if (a != null) {
                        return a.f3701a;
                    }
                } else {
                    bitmap = C1990aq.m4997a(this.f3666a, this.f3667a);
                    if (bitmap != null) {
                        return bitmap;
                    }
                }
                C1524b.m2141a("Failed get online picture/icon resource");
                return bitmap;
            }
            C1524b.m2141a("Failed get online picture/icon resource cause picUrl is empty");
            return null;
        }
    }

    /* renamed from: com.xiaomi.push.service.af$b */
    public static class C1976b {

        /* renamed from: a */
        long f3669a = 0;

        /* renamed from: a */
        Notification f3670a;
    }

    /* renamed from: com.xiaomi.push.service.af$c */
    public static class C1977c {

        /* renamed from: a */
        public long f3671a = 0;

        /* renamed from: a */
        public String f3672a;

        /* renamed from: a */
        public boolean f3673a = false;
    }

    /* renamed from: a */
    static int m4894a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    private static int m4895a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    /* renamed from: a */
    private static int m4896a(Context context, String str, Map<String, String> map, int i) {
        ComponentName a;
        Intent b = m4936b(context, str, map, i);
        if (b == null || (a = C2060h.m5229a(context, b)) == null) {
            return 0;
        }
        return a.hashCode();
    }

    /* renamed from: a */
    private static int m4897a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private static Notification m4898a(Notification notification) {
        Object a = C1656bj.m2696a((Object) notification, "extraNotification");
        if (a != null) {
            C1656bj.m2697a(a, "setCustomizedIcon", true);
        }
        return notification;
    }

    /* renamed from: a */
    private static PendingIntent m4899a(Context context, C1891ik ikVar, String str, byte[] bArr, int i) {
        return m4900a(context, ikVar, str, bArr, i, 0, m4927a(context, ikVar, str));
    }

    /* renamed from: a */
    private static PendingIntent m4900a(Context context, C1891ik ikVar, String str, byte[] bArr, int i, int i2, boolean z) {
        Intent intent;
        Context context2 = context;
        byte[] bArr2 = bArr;
        int i3 = m4946c(ikVar) ? 1000 : m4915a(ikVar) ? PathInterpolatorCompat.MAX_NUM_POINTS : -1;
        C1882ib a = ikVar.mo18043a();
        String a2 = a != null ? a.mo17876a() : "";
        boolean a3 = m4915a(ikVar);
        if (a == null || TextUtils.isEmpty(a.f3042e)) {
            if (a3) {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent.putExtra("mipush_payload", bArr2);
                intent.putExtra("mipush_notified", true);
                intent.addCategory(String.valueOf(i));
                intent.addCategory(String.valueOf(a2));
                String str2 = str;
            } else {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent2.putExtra("mipush_payload", bArr2);
                intent2.putExtra("mipush_notified", true);
                intent2.addCategory(String.valueOf(i));
                intent2.addCategory(String.valueOf(a2));
                intent = intent2;
            }
            intent.putExtra("notification_click_button", i2);
            intent.putExtra("messageId", a2);
            intent.putExtra("eventMessageType", i3);
            if (a3 || !z) {
                m4918a(context, intent, ikVar, a, a2, i2);
                return PendingIntent.getService(context2, 0, intent, 134217728);
            }
            Intent intent3 = new Intent();
            intent3.setComponent(m4902a(str));
            intent3.addFlags(276824064);
            intent3.putExtra("mipush_serviceIntent", intent);
            intent3.addCategory(String.valueOf(i));
            intent3.addCategory(String.valueOf(a2));
            intent3.addCategory(String.valueOf(i2));
            m4918a(context, intent3, ikVar, a, a2, i2);
            m4925a(intent3);
            return PendingIntent.getActivity(context2, 0, intent3, 134217728);
        }
        Intent intent4 = new Intent("android.intent.action.VIEW");
        intent4.setData(Uri.parse(a.f3042e));
        intent4.addFlags(268435456);
        intent4.putExtra("messageId", a2);
        intent4.putExtra("eventMessageType", i3);
        return PendingIntent.getActivity(context2, 0, intent4, 134217728);
    }

    /* renamed from: a */
    private static PendingIntent m4901a(Context context, String str, C1891ik ikVar, byte[] bArr, int i, int i2) {
        Map a = ikVar.mo18043a().mo17876a();
        if (a == null) {
            return null;
        }
        boolean a2 = m4927a(context, ikVar, str);
        if (a2) {
            return m4900a(context, ikVar, str, bArr, i, i2, a2);
        }
        Intent a3 = m4896a(context, str, (Map<String, String>) a, i2);
        if (a3 != null) {
            return PendingIntent.getActivity(context, 0, a3, 134217728);
        }
        return null;
    }

    /* renamed from: a */
    public static ComponentName m4902a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* renamed from: a */
    public static Intent m4903a(Context context, String str, Map<String, String> map, int i) {
        if (m4935b(map)) {
            return m4904a(context, str, map, String.format("cust_btn_%s_ne", new Object[]{Integer.valueOf(i)}), String.format("cust_btn_%s_iu", new Object[]{Integer.valueOf(i)}), String.format("cust_btn_%s_ic", new Object[]{Integer.valueOf(i)}), String.format("cust_btn_%s_wu", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return m4904a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
        } else {
            if (i == 2) {
                return m4904a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
            }
            if (i == 3) {
                return m4904a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            }
            if (i != 4) {
                return null;
            }
            return m4904a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x010a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.Intent m4904a(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.Object r6 = r5.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3782a
            boolean r0 = r0.equals(r6)
            java.lang.String r2 = "Cause: "
            if (r0 == 0) goto L_0x003c
            android.content.pm.PackageManager r5 = r3.getPackageManager()     // Catch:{ Exception -> 0x0023 }
            android.content.Intent r4 = r5.getLaunchIntentForPackage(r4)     // Catch:{ Exception -> 0x0023 }
            r5 = r4
            goto L_0x0108
        L_0x0023:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r4)
            goto L_0x0107
        L_0x003c:
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3783b
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x008a
            boolean r6 = r5.containsKey(r7)
            if (r6 == 0) goto L_0x006e
            java.lang.Object r5 = r5.get(r7)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0107
            r6 = 1
            android.content.Intent r5 = android.content.Intent.parseUri(r5, r6)     // Catch:{ URISyntaxException -> 0x005e }
            r5.setPackage(r4)     // Catch:{ URISyntaxException -> 0x005c }
            goto L_0x0108
        L_0x005c:
            r4 = move-exception
            goto L_0x0060
        L_0x005e:
            r4 = move-exception
            r5 = r1
        L_0x0060:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r4 = r4.getMessage()
            goto L_0x00fc
        L_0x006e:
            boolean r6 = r5.containsKey(r8)
            if (r6 == 0) goto L_0x0107
            java.lang.Object r5 = r5.get(r8)
            java.lang.String r5 = (java.lang.String) r5
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.ComponentName r7 = new android.content.ComponentName
            r7.<init>(r4, r5)
            r6.setComponent(r7)
            r5 = r6
            goto L_0x0108
        L_0x008a:
            java.lang.String r4 = com.xiaomi.push.service.C2014bd.f3784c
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0107
            java.lang.Object r4 = r5.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0107
            java.lang.String r4 = r4.trim()
            java.lang.String r5 = "http://"
            boolean r6 = r4.startsWith(r5)
            if (r6 != 0) goto L_0x00c1
            java.lang.String r6 = "https://"
            boolean r6 = r4.startsWith(r6)
            if (r6 != 0) goto L_0x00c1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
        L_0x00c1:
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00ee }
            r5.<init>(r4)     // Catch:{ MalformedURLException -> 0x00ee }
            java.lang.String r5 = r5.getProtocol()     // Catch:{ MalformedURLException -> 0x00ee }
            java.lang.String r6 = "http"
            boolean r6 = r6.equals(r5)     // Catch:{ MalformedURLException -> 0x00ee }
            if (r6 != 0) goto L_0x00da
            java.lang.String r6 = "https"
            boolean r5 = r6.equals(r5)     // Catch:{ MalformedURLException -> 0x00ee }
            if (r5 == 0) goto L_0x0107
        L_0x00da:
            android.content.Intent r5 = new android.content.Intent     // Catch:{ MalformedURLException -> 0x00ee }
            java.lang.String r6 = "android.intent.action.VIEW"
            r5.<init>(r6)     // Catch:{ MalformedURLException -> 0x00ee }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ MalformedURLException -> 0x00ec }
            r5.setData(r4)     // Catch:{ MalformedURLException -> 0x00ec }
            com.xiaomi.push.service.C1994as.m5038a((android.content.Context) r3, (android.content.Intent) r5)     // Catch:{ MalformedURLException -> 0x00ec }
            goto L_0x0108
        L_0x00ec:
            r4 = move-exception
            goto L_0x00f0
        L_0x00ee:
            r4 = move-exception
            r5 = r1
        L_0x00f0:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r4 = r4.getMessage()
        L_0x00fc:
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r4)
            goto L_0x0108
        L_0x0107:
            r5 = r1
        L_0x0108:
            if (r5 == 0) goto L_0x0133
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r5.addFlags(r4)
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ Exception -> 0x011c }
            r4 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r3 = r3.resolveActivity(r5, r4)     // Catch:{ Exception -> 0x011c }
            if (r3 == 0) goto L_0x0133
            return r5
        L_0x011c:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r3)
        L_0x0133:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1974af.m4904a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    /* renamed from: a */
    private static Bitmap m4905a(Context context, int i) {
        return m4907a(context.getResources().getDrawable(i));
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static Bitmap m4906a(Context context, String str, boolean z) {
        Future submit = f3665a.submit(new C1975a(str, context, z));
        try {
            Bitmap bitmap = (Bitmap) submit.get(180, TimeUnit.SECONDS);
            if (bitmap != null) {
                return bitmap;
            }
            submit.cancel(true);
            return bitmap;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            C1524b.m2155a(e);
            submit.cancel(true);
            return null;
        } catch (Throwable th) {
            submit.cancel(true);
            throw th;
        }
    }

    /* renamed from: a */
    public static Bitmap m4907a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    private static RemoteViews m4908a(Context context, C1891ik ikVar, byte[] bArr) {
        C1882ib a = ikVar.mo18043a();
        String a2 = m4915a(ikVar);
        if (!(a == null || a.mo17876a() == null)) {
            Map a3 = a.mo17876a();
            String str = (String) a3.get("layout_name");
            String str2 = (String) a3.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(a2, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a2);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a2);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a2);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has(CrashHianalyticsData.TIME)) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject(CrashHianalyticsData.TIME);
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a2);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e) {
                        C1524b.m2155a((Throwable) e);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    C1524b.m2155a((Throwable) e2);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static C1618ak.C1619a m4909a(Context context, String str, int i, String str2, Notification notification) {
        return new C1979ah(i, str2, context, str, notification);
    }

    /* renamed from: a */
    private static C1778ew m4910a(Context context, C1891ik ikVar, byte[] bArr, String str, int i) {
        PendingIntent a;
        String a2 = m4915a(ikVar);
        Map a3 = ikVar.mo18043a().mo17876a();
        String str2 = (String) a3.get("notification_style_type");
        C1778ew a4 = (!C1938m.m4714a(context) || f3663a == null) ? null : f3663a.mo18450a(context, i, a2, (Map<String, String>) a3);
        if (a4 != null) {
            a4.mo17550a((Map<String, String>) a3);
            return a4;
        } else if (Build.VERSION.SDK_INT >= 16 && "2".equals(str2)) {
            C1778ew ewVar = new C1778ew(context);
            Bitmap a5 = TextUtils.isEmpty((String) a3.get("notification_bigPic_uri")) ? null : m4906a(context, (String) a3.get("notification_bigPic_uri"), false);
            if (a5 == null) {
                C1524b.m2141a("can not get big picture.");
                return ewVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(ewVar);
            bigPictureStyle.bigPicture(a5);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            ewVar.setStyle(bigPictureStyle);
            return ewVar;
        } else if (Build.VERSION.SDK_INT >= 16 && "1".equals(str2)) {
            C1778ew ewVar2 = new C1778ew(context);
            ewVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return ewVar2;
        } else if ("4".equals(str2) && C1938m.m4714a(context)) {
            C1777ev evVar = new C1777ev(context, a2);
            if (!TextUtils.isEmpty((CharSequence) a3.get("notification_banner_image_uri"))) {
                evVar.setLargeIcon(m4906a(context, (String) a3.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty((CharSequence) a3.get("notification_banner_icon_uri"))) {
                evVar.mo17544b(m4906a(context, (String) a3.get("notification_banner_icon_uri"), false));
            }
            evVar.mo17550a((Map<String, String>) a3);
            return evVar;
        } else if (!"3".equals(str2) || !C1938m.m4714a(context)) {
            return new C1778ew(context);
        } else {
            C1779ex exVar = new C1779ex(context, i, a2);
            if (!TextUtils.isEmpty((CharSequence) a3.get("notification_colorful_button_text")) && (a = m4901a(context, a2, ikVar, bArr, i, 4)) != null) {
                exVar.mo17554a((CharSequence) a3.get("notification_colorful_button_text"), a).mo17542a((String) a3.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty((CharSequence) a3.get("notification_colorful_bg_color"))) {
                exVar.mo17555b((String) a3.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty((CharSequence) a3.get("notification_colorful_bg_image_uri"))) {
                exVar.mo17541a(m4906a(context, (String) a3.get("notification_colorful_bg_image_uri"), false));
            }
            exVar.mo17550a((Map<String, String>) a3);
            return exVar;
        }
    }

    /* JADX WARNING: type inference failed for: r12v22 */
    /* JADX WARNING: type inference failed for: r12v23 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r12v21, types: [boolean, int] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0486  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x013b A[SYNTHETIC, Splitter:B:38:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0278  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.xiaomi.push.service.C1974af.C1976b m4911a(android.content.Context r26, com.xiaomi.push.C1891ik r27, byte[] r28, android.widget.RemoteViews r29, android.app.PendingIntent r30, int r31) {
        /*
            r7 = r26
            r0 = r29
            com.xiaomi.push.service.af$b r8 = new com.xiaomi.push.service.af$b
            r8.<init>()
            com.xiaomi.push.ib r9 = r27.mo18043a()
            java.lang.String r10 = m4915a((com.xiaomi.push.C1891ik) r27)
            java.util.Map r11 = r9.mo17876a()
            java.lang.String[] r12 = m4933a((android.content.Context) r7, (com.xiaomi.push.C1882ib) r9)
            java.lang.String r13 = "notification_style_type"
            r14 = 1
            if (r0 == 0) goto L_0x002e
            com.xiaomi.push.ew r1 = new com.xiaomi.push.ew
            r1.<init>(r7)
            r1.setCustomContentView((android.widget.RemoteViews) r0)
            r15 = r27
            r5 = r28
            r6 = r31
            r4 = r1
            goto L_0x004f
        L_0x002e:
            if (r11 == 0) goto L_0x0043
            boolean r0 = r11.containsKey(r13)
            if (r0 == 0) goto L_0x0043
            r0 = r12[r14]
            r15 = r27
            r5 = r28
            r6 = r31
            com.xiaomi.push.ew r0 = m4910a((android.content.Context) r7, (com.xiaomi.push.C1891ik) r15, (byte[]) r5, (java.lang.String) r0, (int) r6)
            goto L_0x004e
        L_0x0043:
            r15 = r27
            r5 = r28
            r6 = r31
            com.xiaomi.push.ew r0 = new com.xiaomi.push.ew
            r0.<init>(r7)
        L_0x004e:
            r4 = r0
        L_0x004f:
            java.lang.String r3 = r27.mo18052b()
            r1 = r4
            r2 = r26
            r14 = r4
            r4 = r27
            r5 = r28
            r6 = r31
            m4926a((com.xiaomi.push.C1778ew) r1, (android.content.Context) r2, (java.lang.String) r3, (com.xiaomi.push.C1891ik) r4, (byte[]) r5, (int) r6)
            r1 = 0
            r0 = r12[r1]
            r14.setContentTitle(r0)
            r2 = 1
            r0 = r12[r2]
            r14.setContentText(r0)
            long r3 = java.lang.System.currentTimeMillis()
            r14.setWhen(r3)
            java.lang.String r0 = "notification_show_when"
            java.lang.String r0 = m4917a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r0)
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            r6 = 24
            if (r5 == 0) goto L_0x0089
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r6) goto L_0x0090
            r14.setShowWhen(r2)
            goto L_0x0090
        L_0x0089:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            r14.setShowWhen(r0)
        L_0x0090:
            r0 = r30
            r14.setContentIntent(r0)
            java.lang.String r0 = "mipush_notification"
            int r0 = m4895a((android.content.Context) r7, (java.lang.String) r10, (java.lang.String) r0)
            java.lang.String r2 = "mipush_small_notification"
            int r2 = m4895a((android.content.Context) r7, (java.lang.String) r10, (java.lang.String) r2)
            r5 = 23
            if (r0 <= 0) goto L_0x00b2
            if (r2 <= 0) goto L_0x00b2
            android.graphics.Bitmap r0 = m4905a((android.content.Context) r7, (int) r0)
            r14.setLargeIcon(r0)
            r14.setSmallIcon(r2)
            goto L_0x00c9
        L_0x00b2:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x00c2
            int r0 = com.xiaomi.push.service.C1994as.m5030a((android.content.Context) r7, (java.lang.String) r10)
            android.graphics.drawable.Icon r0 = android.graphics.drawable.Icon.createWithResource(r10, r0)
            r14.setSmallIcon(r0)
            goto L_0x00c9
        L_0x00c2:
            int r0 = m4934b((android.content.Context) r7, (java.lang.String) r10)
            r14.setSmallIcon(r0)
        L_0x00c9:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x0163
            java.lang.String r0 = "notification_small_icon_uri"
            if (r11 != 0) goto L_0x00d4
            r5 = 0
            r12 = 1
            goto L_0x00df
        L_0x00d4:
            java.lang.Object r5 = r11.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            r12 = 1
            android.graphics.Bitmap r5 = m4906a((android.content.Context) r7, (java.lang.String) r5, (boolean) r12)
        L_0x00df:
            if (r5 == 0) goto L_0x0117
            java.lang.Object[] r2 = new java.lang.Object[r12]
            r2[r1] = r5
            java.lang.String r5 = "android.graphics.drawable.Icon"
            java.lang.String r6 = "createWithBitmap"
            java.lang.Object r2 = com.xiaomi.push.C1656bj.m2699a((java.lang.String) r5, (java.lang.String) r6, (java.lang.Object[]) r2)
            if (r2 == 0) goto L_0x0106
            java.lang.Object[] r0 = new java.lang.Object[r12]
            r0[r1] = r2
            java.lang.String r2 = "setSmallIcon"
            com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r14, (java.lang.String) r2, (java.lang.Object[]) r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r2 = "miui.isGrayscaleIcon"
            r0.putBoolean(r2, r12)
            r14.addExtras((android.os.Bundle) r0)
            goto L_0x012f
        L_0x0106:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "failed te get small icon with url:"
            r2.append(r5)
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0125
        L_0x0117:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "failed to get small icon url:"
            r2.append(r5)
            java.lang.String r0 = m4917a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r0)
        L_0x0125:
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
        L_0x012f:
            java.lang.String r0 = "notification_small_icon_color"
            java.lang.String r0 = m4917a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0163
            int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ Exception -> 0x014e }
            java.lang.String r2 = "setColor"
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x014e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x014e }
            r6[r1] = r0     // Catch:{ Exception -> 0x014e }
            com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r14, (java.lang.String) r2, (java.lang.Object[]) r6)     // Catch:{ Exception -> 0x014e }
            goto L_0x0163
        L_0x014e:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "fail to set color. "
            r2.append(r5)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)
        L_0x0163:
            java.lang.String r0 = "__dynamic_icon_uri"
            java.lang.String r0 = m4917a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r0)
            java.lang.String r2 = "__adiom"
            java.lang.String r2 = m4917a((java.util.Map<java.lang.String, java.lang.String>) r11, (java.lang.String) r2)
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            if (r2 != 0) goto L_0x017e
            boolean r2 = com.xiaomi.push.C1938m.m4713a()
            if (r2 != 0) goto L_0x017c
            goto L_0x017e
        L_0x017c:
            r2 = 0
            goto L_0x017f
        L_0x017e:
            r2 = 1
        L_0x017f:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x01aa
            if (r2 == 0) goto L_0x01aa
            java.lang.String r2 = "http"
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L_0x019f
            r2 = 1
            com.xiaomi.push.service.aq$b r0 = com.xiaomi.push.service.C1990aq.m4999a((android.content.Context) r7, (java.lang.String) r0, (boolean) r2)
            if (r0 == 0) goto L_0x019d
            android.graphics.Bitmap r2 = r0.f3701a
            long r5 = r0.f3700a
            r8.f3669a = r5
            goto L_0x01a3
        L_0x019d:
            r2 = 0
            goto L_0x01a3
        L_0x019f:
            android.graphics.Bitmap r2 = com.xiaomi.push.service.C1990aq.m4997a((android.content.Context) r7, (java.lang.String) r0)
        L_0x01a3:
            if (r2 == 0) goto L_0x01aa
            r14.setLargeIcon(r2)
            r2 = 1
            goto L_0x01ab
        L_0x01aa:
            r2 = 0
        L_0x01ab:
            if (r11 != 0) goto L_0x01af
            r0 = 0
            goto L_0x01bc
        L_0x01af:
            java.lang.String r0 = "notification_large_icon_uri"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r5 = 1
            android.graphics.Bitmap r0 = m4906a((android.content.Context) r7, (java.lang.String) r0, (boolean) r5)
        L_0x01bc:
            if (r0 == 0) goto L_0x01c1
            r14.setLargeIcon(r0)
        L_0x01c1:
            java.lang.String r5 = "com.xiaomi.xmsf"
            if (r11 == 0) goto L_0x024e
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = 24
            if (r0 < r6) goto L_0x024e
            java.lang.String r0 = "notification_group"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r6 = "notification_is_summary"
            java.lang.Object r6 = r11.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r6 = java.lang.Boolean.parseBoolean(r6)
            java.lang.String r12 = "notification_group_disable_default"
            java.lang.Object r12 = r11.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            boolean r16 = android.text.TextUtils.isEmpty(r0)
            if (r16 == 0) goto L_0x01fd
            boolean r16 = com.xiaomi.push.C1938m.m4713a()
            if (r16 != 0) goto L_0x01f9
            if (r12 != 0) goto L_0x01fd
        L_0x01f9:
            java.lang.String r0 = m4915a((com.xiaomi.push.C1891ik) r27)
        L_0x01fd:
            r29 = r0
            r12 = 1
            java.lang.Object[] r0 = new java.lang.Object[r12]
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)
            r0[r1] = r12
            java.lang.String r12 = "setGroupSummary"
            com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r14, (java.lang.String) r12, (java.lang.Object[]) r0)
            java.lang.Object r0 = r11.get(r13)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r12 = r26.getPackageName()
            boolean r12 = r5.equals(r12)
            if (r12 == 0) goto L_0x0249
            java.lang.String r12 = "4"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x022d
            java.lang.String r12 = "3"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0249
        L_0x022d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r12 = m4915a((com.xiaomi.push.C1891ik) r27)
            r0.append(r12)
            java.lang.String r12 = "_custom_"
            r0.append(r12)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r12 = r0
            r0 = r6
            r6 = 1
            goto L_0x0251
        L_0x0249:
            r12 = r29
            r0 = r6
            r6 = 0
            goto L_0x0251
        L_0x024e:
            r0 = 0
            r6 = 0
            r12 = 0
        L_0x0251:
            r13 = 1
            r14.setAutoCancel(r13)
            long r16 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x026c
            java.lang.String r13 = "ticker"
            boolean r18 = r11.containsKey(r13)
            if (r18 == 0) goto L_0x026c
            java.lang.Object r13 = r11.get(r13)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r14.setTicker(r13)
        L_0x026c:
            long r18 = f3662a
            long r18 = r16 - r18
            r20 = 10000(0x2710, double:4.9407E-320)
            java.lang.String r13 = "sound_uri"
            int r22 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r22 <= 0) goto L_0x02ca
            f3662a = r16
            int r1 = r9.f3029a
            boolean r16 = m4934b((android.content.Context) r7, (java.lang.String) r10)
            if (r16 == 0) goto L_0x0286
            int r1 = m4894a((android.content.Context) r7, (java.lang.String) r10)
        L_0x0286:
            r14.setDefaults(r1)
            if (r11 == 0) goto L_0x02c5
            r16 = r1 & 1
            if (r16 == 0) goto L_0x02c5
            java.lang.Object r16 = r11.get(r13)
            r15 = r16
            java.lang.String r15 = (java.lang.String) r15
            boolean r16 = android.text.TextUtils.isEmpty(r15)
            if (r16 != 0) goto L_0x02c5
            r16 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r31 = r2
            java.lang.String r2 = "android.resource://"
            r8.append(r2)
            r8.append(r10)
            java.lang.String r2 = r8.toString()
            boolean r2 = r15.startsWith(r2)
            if (r2 == 0) goto L_0x02d0
            r2 = r1 ^ 1
            r14.setDefaults(r2)
            android.net.Uri r2 = android.net.Uri.parse(r15)
            r14.setSound(r2)
            goto L_0x02d0
        L_0x02c5:
            r31 = r2
            r16 = r8
            goto L_0x02d0
        L_0x02ca:
            r31 = r2
            r16 = r8
            r1 = -100
        L_0x02d0:
            r8 = 26
            if (r11 == 0) goto L_0x0411
            int r15 = android.os.Build.VERSION.SDK_INT
            if (r15 < r8) goto L_0x0411
            com.xiaomi.push.service.ar r17 = com.xiaomi.push.service.C1993ar.m5005a((android.content.Context) r7, (java.lang.String) r10)
            int r15 = m4897a((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r15 <= 0) goto L_0x02f8
            r2 = 1
            java.lang.Object[] r8 = new java.lang.Object[r2]
            int r15 = r15 * 1000
            r2 = r5
            r24 = r6
            long r5 = (long) r15
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r6 = 0
            r8[r6] = r5
            java.lang.String r5 = "setTimeoutAfter"
            com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r14, (java.lang.String) r5, (java.lang.Object[]) r8)
            goto L_0x02fb
        L_0x02f8:
            r2 = r5
            r24 = r6
        L_0x02fb:
            java.lang.String r5 = "channel_id"
            java.lang.Object r5 = r11.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L_0x0318
            android.content.pm.ApplicationInfo r6 = r26.getApplicationInfo()
            int r6 = r6.targetSdkVersion
            r8 = 26
            if (r6 < r8) goto L_0x0314
            goto L_0x0318
        L_0x0314:
            r25 = r10
            goto L_0x03e4
        L_0x0318:
            java.lang.String r19 = m4914a((android.content.Context) r7, (java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            int r6 = m4935b((java.util.Map<java.lang.String, java.lang.String>) r11)
            int r8 = r9.f3029a
            java.lang.String r9 = "channel_description"
            java.lang.Object r9 = r11.get(r9)
            r20 = r9
            java.lang.String r20 = (java.lang.String) r20
            java.lang.Object r9 = r11.get(r13)
            r23 = r9
            java.lang.String r23 = (java.lang.String) r23
            r9 = 4
            if (r6 < r9) goto L_0x0385
            boolean r9 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r26)
            if (r9 == 0) goto L_0x0385
            boolean r9 = m4945c((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r9 == 0) goto L_0x0385
            int r9 = m4950e((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r9 != 0) goto L_0x0355
            java.lang.String r3 = "meet prd of top notification is zero."
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r3)
            java.lang.String r3 = com.xiaomi.push.service.C1985an.m4969a((com.xiaomi.push.service.C1993ar) r17)
            r25 = r10
            goto L_0x0388
        L_0x0355:
            r13 = 2
            r14.setPriority(r13)
            int r13 = m4948d((java.util.Map<java.lang.String, java.lang.String>) r11)
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>()
            r25 = r10
            java.lang.String r10 = "mipush_org_when"
            r15.putLong(r10, r3)
            java.lang.String r3 = "mipush_n_top_flag"
            r4 = 1
            r15.putBoolean(r3, r4)
            if (r13 <= 0) goto L_0x0378
            if (r13 > r9) goto L_0x0378
            java.lang.String r3 = "mipush_n_top_fre"
            r15.putInt(r3, r13)
        L_0x0378:
            if (r9 <= 0) goto L_0x0381
            if (r13 > r9) goto L_0x0381
            java.lang.String r3 = "mipush_n_top_prd"
            r15.putInt(r3, r9)
        L_0x0381:
            r14.addExtras((android.os.Bundle) r15)
            goto L_0x0387
        L_0x0385:
            r25 = r10
        L_0x0387:
            r3 = 0
        L_0x0388:
            if (r3 != 0) goto L_0x0394
            r18 = r5
            r21 = r8
            r22 = r6
            java.lang.String r3 = com.xiaomi.push.service.C1985an.m4970a(r17, r18, r19, r20, r21, r22, r23)
        L_0x0394:
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r4 = 0
            r5[r4] = r3
            java.lang.String r3 = "setChannelId"
            com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r14, (java.lang.String) r3, (java.lang.Object[]) r5)
            r3 = -100
            if (r1 != r3) goto L_0x03ac
            boolean r1 = com.xiaomi.push.service.C1994as.m5042a((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r1 == 0) goto L_0x03ac
            com.xiaomi.push.service.C1994as.m5040a((android.app.Notification.Builder) r14, (boolean) r0)
        L_0x03ac:
            java.lang.String r1 = com.xiaomi.push.service.C1994as.m5034a((java.lang.Object) r11)
            java.lang.String r3 = "pulldown"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x03cf
            boolean r1 = com.xiaomi.push.service.C1994as.m5042a((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r1 == 0) goto L_0x03cf
            java.lang.String r1 = "pull_down_pop_type"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r3 = "0"
            boolean r1 = java.util.Objects.equals(r1, r3)
            if (r1 == 0) goto L_0x03cf
            com.xiaomi.push.service.C1994as.m5040a((android.app.Notification.Builder) r14, (boolean) r0)
        L_0x03cf:
            java.lang.String r1 = com.xiaomi.push.service.C1994as.m5034a((java.lang.Object) r11)
            java.lang.String r3 = "tts"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x03e4
            boolean r1 = com.xiaomi.push.service.C1994as.m5042a((java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r1 == 0) goto L_0x03e4
            com.xiaomi.push.service.C1994as.m5040a((android.app.Notification.Builder) r14, (boolean) r0)
        L_0x03e4:
            java.lang.String r0 = "background_color"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0437
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x040c }
            r1 = 1
            r14.setOngoing(r1)     // Catch:{ Exception -> 0x040c }
            r14.setColor(r0)     // Catch:{ Exception -> 0x040c }
            java.lang.String r0 = "setColorized"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x040c }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x040c }
            r1 = 0
            r3[r1] = r4     // Catch:{ Exception -> 0x040c }
            com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r14, (java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x040c }
            goto L_0x0437
        L_0x040c:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r0)
            goto L_0x0437
        L_0x0411:
            r2 = r5
            r24 = r6
            r25 = r10
            if (r11 == 0) goto L_0x0437
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 < r1) goto L_0x0437
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x0437
            int r0 = m4945c((java.util.Map<java.lang.String, java.lang.String>) r11)
            r1 = 1
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = 0
            r3[r1] = r0
            java.lang.String r0 = "setPriority"
            com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r14, (java.lang.String) r0, (java.lang.Object[]) r3)
        L_0x0437:
            if (r12 == 0) goto L_0x044e
            if (r24 != 0) goto L_0x0443
            com.xiaomi.push.service.ao r0 = com.xiaomi.push.service.C1986ao.m4980a()
            java.lang.String r12 = r0.mo18453a((android.content.Context) r7, (android.app.Notification.Builder) r14, (java.lang.String) r12)
        L_0x0443:
            r1 = 1
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r1 = 0
            r0[r1] = r12
            java.lang.String r1 = "setGroup"
            com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r14, (java.lang.String) r1, (java.lang.Object[]) r0)
        L_0x044e:
            boolean r0 = com.xiaomi.push.C1938m.m4729c()
            if (r0 == 0) goto L_0x0475
            java.lang.String r0 = r26.getPackageName()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0475
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r7
            r1 = 1
            r0[r1] = r14
            java.lang.String r1 = m4915a((com.xiaomi.push.C1891ik) r27)
            r2 = 2
            r0[r2] = r1
            java.lang.String r1 = "miui.util.NotificationHelper"
            java.lang.String r2 = "setTargetPkg"
            com.xiaomi.push.C1656bj.m2699a((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object[]) r0)
        L_0x0475:
            android.app.Notification r0 = r14.getNotification()
            if (r31 == 0) goto L_0x0484
            boolean r1 = com.xiaomi.push.C1938m.m4713a()
            if (r1 == 0) goto L_0x0484
            m4898a((android.app.Notification) r0)
        L_0x0484:
            if (r11 == 0) goto L_0x04f1
            android.os.Bundle r1 = r0.extras
            if (r1 != 0) goto L_0x0491
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r0.extras = r1
        L_0x0491:
            java.lang.String r1 = "enable_keyguard"
            java.lang.Object r2 = r11.get(r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x04ac
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            com.xiaomi.push.service.C1994as.m5045b(r0, r1)
        L_0x04ac:
            java.lang.String r1 = "enable_float"
            java.lang.Object r2 = r11.get(r1)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x04c7
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            com.xiaomi.push.service.C1994as.m5037a((android.app.Notification) r0, (boolean) r1)
        L_0x04c7:
            java.lang.String r1 = "float_small_win"
            java.lang.Object r1 = r11.get(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x04f1
            java.lang.String r1 = "float_small_win"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "0"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x04f1
            r1 = r25
            boolean r1 = com.xiaomi.push.C1816g.m3674d(r7, r1)
            if (r1 == 0) goto L_0x04f1
            r1 = 0
            com.xiaomi.push.service.C1994as.m5037a((android.app.Notification) r0, (boolean) r1)
        L_0x04f1:
            r1 = r16
            r1.f3670a = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1974af.m4911a(android.content.Context, com.xiaomi.push.ik, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.af$b");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.lang.String} */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0429  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x031f  */
    /* renamed from: a */
    public static com.xiaomi.push.service.C1974af.C1977c m4912a(android.content.Context r22, com.xiaomi.push.C1891ik r23, byte[] r24) {
        /*
            r7 = r22
            r8 = r23
            com.xiaomi.push.service.af$c r9 = new com.xiaomi.push.service.af$c
            r9.<init>()
            java.lang.String r0 = m4915a((com.xiaomi.push.C1891ik) r23)
            r10 = 1
            com.xiaomi.push.g$a r0 = com.xiaomi.push.C1816g.m3663a(r7, r0, r10)
            com.xiaomi.push.ib r11 = r23.mo18043a()
            r12 = 0
            r13 = 0
            if (r11 == 0) goto L_0x0024
            int r1 = r11.mo17888c()
            java.util.Map r2 = r11.mo17876a()
            r14 = r2
            goto L_0x0026
        L_0x0024:
            r14 = r12
            r1 = 0
        L_0x0026:
            java.lang.String r2 = m4915a((com.xiaomi.push.C1891ik) r23)
            int r2 = r2.hashCode()
            int r2 = r2 / 10
            int r2 = r2 * 10
            int r15 = r2 + r1
            boolean r1 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r22)
            if (r1 == 0) goto L_0x008a
            com.xiaomi.push.g$a r1 = com.xiaomi.push.C1816g.C1817a.NOT_ALLOWED
            if (r0 != r1) goto L_0x008a
            if (r11 == 0) goto L_0x006c
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r1 = r23.mo18052b()
            java.lang.String r2 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r3 = r11.mo17876a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "10:"
            r4.append(r5)
            java.lang.String r5 = m4915a((com.xiaomi.push.C1891ik) r23)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.mo17538a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4)
        L_0x006c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Do not notify because user block "
            r0.append(r1)
            java.lang.String r1 = m4915a((com.xiaomi.push.C1891ik) r23)
            r0.append(r1)
            java.lang.String r1 = "‘s notification"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0086:
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
            return r9
        L_0x008a:
            boolean r0 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r22)
            if (r0 == 0) goto L_0x00d1
            com.xiaomi.push.service.am r0 = f3663a
            if (r0 == 0) goto L_0x00d1
            com.xiaomi.push.service.am r0 = f3663a
            java.lang.String r1 = m4915a((com.xiaomi.push.C1891ik) r23)
            boolean r0 = r0.mo18450a((android.content.Context) r7, (int) r15, (java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.String>) r14)
            if (r0 == 0) goto L_0x00d1
            if (r11 == 0) goto L_0x00ce
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r1 = r23.mo18052b()
            java.lang.String r2 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r3 = r11.mo17876a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "14:"
            r4.append(r5)
            java.lang.String r5 = m4915a((com.xiaomi.push.C1891ik) r23)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.mo17538a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4)
        L_0x00ce:
            java.lang.String r0 = "Do not notify because card notification is canceled or sequence incorrect"
            goto L_0x0086
        L_0x00d1:
            android.widget.RemoteViews r4 = m4908a((android.content.Context) r22, (com.xiaomi.push.C1891ik) r23, (byte[]) r24)
            java.lang.String r0 = r23.mo18052b()
            r3 = r24
            android.app.PendingIntent r5 = m4899a((android.content.Context) r7, (com.xiaomi.push.C1891ik) r8, (java.lang.String) r0, (byte[]) r3, (int) r15)
            if (r5 != 0) goto L_0x00ff
            if (r11 == 0) goto L_0x00fc
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.eu r0 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r1 = r23.mo18052b()
            java.lang.String r2 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r3 = r11.mo17876a()
            java.lang.String r4 = "11"
            r0.mo17538a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4)
        L_0x00fc:
            java.lang.String r0 = "The click PendingIntent is null. "
            goto L_0x0086
        L_0x00ff:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 11
            if (r0 < r1) goto L_0x011f
            r1 = r22
            r2 = r23
            r3 = r24
            r6 = r15
            com.xiaomi.push.service.af$b r0 = m4911a((android.content.Context) r1, (com.xiaomi.push.C1891ik) r2, (byte[]) r3, (android.widget.RemoteViews) r4, (android.app.PendingIntent) r5, (int) r6)
            long r1 = r0.f3669a
            r9.f3671a = r1
            java.lang.String r1 = m4915a((com.xiaomi.push.C1891ik) r23)
            r9.f3672a = r1
            android.app.Notification r0 = r0.f3670a
            r1 = r0
            goto L_0x0284
        L_0x011f:
            android.app.Notification r1 = new android.app.Notification
            java.lang.String r0 = m4915a((com.xiaomi.push.C1891ik) r23)
            int r0 = m4934b((android.content.Context) r7, (java.lang.String) r0)
            long r2 = java.lang.System.currentTimeMillis()
            r1.<init>(r0, r12, r2)
            java.lang.String[] r0 = m4933a((android.content.Context) r7, (com.xiaomi.push.C1882ib) r11)
            java.lang.Class r2 = r1.getClass()     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            java.lang.String r3 = "setLatestEventInfo"
            r6 = 4
            java.lang.Class[] r12 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            java.lang.Class<android.content.Context> r16 = android.content.Context.class
            r12[r13] = r16     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            java.lang.Class<java.lang.CharSequence> r16 = java.lang.CharSequence.class
            r12[r10] = r16     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            java.lang.Class<java.lang.CharSequence> r16 = java.lang.CharSequence.class
            r17 = 2
            r12[r17] = r16     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            java.lang.Class<android.app.PendingIntent> r16 = android.app.PendingIntent.class
            r18 = 3
            r12[r18] = r16     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r12)     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            r3[r13] = r7     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            r6 = r0[r13]     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            r3[r10] = r6     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            r0 = r0[r10]     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            r3[r17] = r0     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            r3[r18] = r5     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            r2.invoke(r1, r3)     // Catch:{ NoSuchMethodException -> 0x01d4, IllegalAccessException -> 0x01b0, IllegalArgumentException -> 0x018c, InvocationTargetException -> 0x0168 }
            goto L_0x0204
        L_0x0168:
            r0 = move-exception
            if (r11 == 0) goto L_0x0184
            android.content.Context r2 = r22.getApplicationContext()
            com.xiaomi.push.eu r2 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r2)
            java.lang.String r3 = r23.mo18052b()
            java.lang.String r5 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r6 = r11.mo17876a()
            java.lang.String r12 = "7"
            r2.mo17539b(r3, r5, r6, r12)
        L_0x0184:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "meet invocation target error. "
            goto L_0x01f7
        L_0x018c:
            r0 = move-exception
            if (r11 == 0) goto L_0x01a8
            android.content.Context r2 = r22.getApplicationContext()
            com.xiaomi.push.eu r2 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r2)
            java.lang.String r3 = r23.mo18052b()
            java.lang.String r5 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r6 = r11.mo17876a()
            java.lang.String r12 = "6"
            r2.mo17539b(r3, r5, r6, r12)
        L_0x01a8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "meet illegal argument error. "
            goto L_0x01f7
        L_0x01b0:
            r0 = move-exception
            if (r11 == 0) goto L_0x01cc
            android.content.Context r2 = r22.getApplicationContext()
            com.xiaomi.push.eu r2 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r2)
            java.lang.String r3 = r23.mo18052b()
            java.lang.String r5 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r6 = r11.mo17876a()
            java.lang.String r12 = "5"
            r2.mo17539b(r3, r5, r6, r12)
        L_0x01cc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "meet illegal access error. "
            goto L_0x01f7
        L_0x01d4:
            r0 = move-exception
            if (r11 == 0) goto L_0x01f0
            android.content.Context r2 = r22.getApplicationContext()
            com.xiaomi.push.eu r2 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r2)
            java.lang.String r3 = r23.mo18052b()
            java.lang.String r5 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r6 = r11.mo17876a()
            java.lang.String r12 = "4"
            r2.mo17539b(r3, r5, r6, r12)
        L_0x01f0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "meet no such method error. "
        L_0x01f7:
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)
        L_0x0204:
            java.util.Map r0 = r11.mo17876a()
            if (r0 == 0) goto L_0x021c
            java.lang.String r2 = "ticker"
            boolean r2 = r0.containsKey(r2)
            if (r2 == 0) goto L_0x021c
            java.lang.String r2 = "ticker"
            java.lang.Object r2 = r0.get(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.tickerText = r2
        L_0x021c:
            long r2 = java.lang.System.currentTimeMillis()
            long r5 = f3662a
            long r5 = r2 - r5
            r16 = 10000(0x2710, double:4.9407E-320)
            int r12 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r12 <= 0) goto L_0x027a
            f3662a = r2
            int r2 = r11.f3029a
            java.lang.String r3 = m4915a((com.xiaomi.push.C1891ik) r23)
            boolean r3 = m4934b((android.content.Context) r7, (java.lang.String) r3)
            if (r3 == 0) goto L_0x0240
            java.lang.String r2 = m4915a((com.xiaomi.push.C1891ik) r23)
            int r2 = m4894a((android.content.Context) r7, (java.lang.String) r2)
        L_0x0240:
            r1.defaults = r2
            if (r0 == 0) goto L_0x027a
            r3 = r2 & 1
            if (r3 == 0) goto L_0x027a
            java.lang.String r3 = "sound_uri"
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x027a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "android.resource://"
            r3.append(r5)
            java.lang.String r5 = m4915a((com.xiaomi.push.C1891ik) r23)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x027a
            r2 = r2 ^ r10
            r1.defaults = r2
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r1.sound = r0
        L_0x027a:
            int r0 = r1.flags
            r0 = r0 | 16
            r1.flags = r0
            if (r4 == 0) goto L_0x0284
            r1.contentView = r4
        L_0x0284:
            boolean r0 = com.xiaomi.push.C1938m.m4713a()
            if (r0 == 0) goto L_0x0317
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 19
            if (r0 < r2) goto L_0x0317
            java.lang.String r0 = r11.mo17876a()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x02a5
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = r11.mo17876a()
            java.lang.String r3 = "message_id"
            r0.putString(r3, r2)
        L_0x02a5:
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = r23.mo18043a()
            java.lang.String r3 = "local_paid"
            r0.putString(r3, r2)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "msg_busi_type"
            com.xiaomi.push.service.C1994as.m5039a((java.util.Map<java.lang.String, java.lang.String>) r14, (android.os.Bundle) r0, (java.lang.String) r2)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "disable_notification_flags"
            com.xiaomi.push.service.C1994as.m5039a((java.util.Map<java.lang.String, java.lang.String>) r14, (android.os.Bundle) r0, (java.lang.String) r2)
            java.util.Map r0 = r11.mo17883b()
            if (r0 != 0) goto L_0x02c6
            r12 = 0
            goto L_0x02d3
        L_0x02c6:
            java.util.Map r0 = r11.mo17883b()
            java.lang.String r2 = "score_info"
            java.lang.Object r0 = r0.get(r2)
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
        L_0x02d3:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x02e0
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "score_info"
            r0.putString(r2, r12)
        L_0x02e0:
            android.os.Bundle r0 = r1.extras
            java.util.Map<java.lang.String, java.lang.String> r2 = r11.f3033a
            java.lang.String r3 = "n_stats_expose"
            java.lang.String r2 = m4917a((java.util.Map<java.lang.String, java.lang.String>) r2, (java.lang.String) r3)
            java.lang.String r3 = "pushUid"
            r0.putString(r3, r2)
            r0 = -1
            boolean r2 = m4946c((com.xiaomi.push.C1891ik) r23)
            if (r2 == 0) goto L_0x02f9
            r0 = 1000(0x3e8, float:1.401E-42)
            goto L_0x0301
        L_0x02f9:
            boolean r2 = m4915a((com.xiaomi.push.C1891ik) r23)
            if (r2 == 0) goto L_0x0301
            r0 = 3000(0xbb8, float:4.204E-42)
        L_0x0301:
            android.os.Bundle r2 = r1.extras
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "eventMessageType"
            r2.putString(r3, r0)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = m4915a((com.xiaomi.push.C1891ik) r23)
            java.lang.String r3 = "target_package"
            r0.putString(r3, r2)
        L_0x0317:
            java.util.Map r0 = r11.mo17876a()
            if (r0 != 0) goto L_0x031f
            r12 = 0
            goto L_0x032c
        L_0x031f:
            java.util.Map r0 = r11.mo17876a()
            java.lang.String r2 = "message_count"
            java.lang.Object r0 = r0.get(r2)
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
        L_0x032c:
            boolean r0 = com.xiaomi.push.C1938m.m4713a()
            if (r0 == 0) goto L_0x036c
            if (r12 == 0) goto L_0x036c
            int r0 = java.lang.Integer.parseInt(r12)     // Catch:{ NumberFormatException -> 0x033c }
            com.xiaomi.push.service.C1994as.m5035a((android.app.Notification) r1, (int) r0)     // Catch:{ NumberFormatException -> 0x033c }
            goto L_0x036c
        L_0x033c:
            r0 = move-exception
            if (r11 == 0) goto L_0x0358
            android.content.Context r2 = r22.getApplicationContext()
            com.xiaomi.push.eu r2 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r2)
            java.lang.String r3 = r23.mo18052b()
            java.lang.String r4 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r5 = r11.mo17876a()
            java.lang.String r6 = "8"
            r2.mo17539b(r3, r4, r5, r6)
        L_0x0358:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "fail to set message count. "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)
        L_0x036c:
            java.lang.String r0 = m4915a((com.xiaomi.push.C1891ik) r23)
            boolean r2 = com.xiaomi.push.C1938m.m4729c()
            if (r2 != 0) goto L_0x037f
            boolean r2 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r22)
            if (r2 == 0) goto L_0x037f
            com.xiaomi.push.service.C1994as.m5031a((android.app.Notification) r1, (java.lang.String) r0)
        L_0x037f:
            com.xiaomi.push.service.ar r2 = com.xiaomi.push.service.C1993ar.m5005a((android.content.Context) r7, (java.lang.String) r0)
            boolean r3 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r22)
            if (r3 == 0) goto L_0x0396
            com.xiaomi.push.service.am r3 = f3663a
            if (r3 == 0) goto L_0x0396
            com.xiaomi.push.service.am r3 = f3663a
            java.util.Map r4 = r11.mo17876a()
            r3.mo18451a((com.xiaomi.push.C1891ik) r8, (java.util.Map<java.lang.String, java.lang.String>) r4, (int) r15, (android.app.Notification) r1)
        L_0x0396:
            boolean r3 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r22)
            if (r3 == 0) goto L_0x03b2
            com.xiaomi.push.service.am r3 = f3663a
            if (r3 == 0) goto L_0x03b2
            com.xiaomi.push.service.am r3 = f3663a
            java.util.Map r4 = r11.mo17876a()
            boolean r3 = r3.mo18452a(r4, r15, r1)
            if (r3 == 0) goto L_0x03b2
            java.lang.String r3 = "consume this notificaiton by agent"
            com.xiaomi.channel.commonutils.logger.C1524b.m2158b(r3)
            goto L_0x03b7
        L_0x03b2:
            r2.mo18459a((int) r15, (android.app.Notification) r1)
            r9.f3673a = r10
        L_0x03b7:
            boolean r3 = com.xiaomi.push.C1938m.m4713a()
            r4 = 26
            if (r3 == 0) goto L_0x03e3
            boolean r3 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r22)
            if (r3 == 0) goto L_0x03e3
            com.xiaomi.push.service.ao r3 = com.xiaomi.push.service.C1986ao.m4980a()
            r3.mo18454a((android.content.Context) r7, (int) r15, (android.app.Notification) r1)
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r4) goto L_0x03e3
            if (r1 == 0) goto L_0x03e3
            android.os.Bundle r3 = r1.extras
            java.lang.String r5 = "mipush_n_top_flag"
            boolean r3 = r3.getBoolean(r5, r13)
            if (r3 == 0) goto L_0x03e3
            java.lang.String r3 = r11.mo17876a()
            m4941b(r7, r0, r15, r3, r1)
        L_0x03e3:
            boolean r0 = m4915a((com.xiaomi.push.C1891ik) r23)
            if (r0 == 0) goto L_0x0404
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.eu r16 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r17 = r23.mo18052b()
            java.lang.String r18 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r19 = r11.mo17876a()
            r20 = 3002(0xbba, float:4.207E-42)
            r21 = 0
            r16.mo17537a(r17, r18, r19, r20, r21)
        L_0x0404:
            boolean r0 = m4946c((com.xiaomi.push.C1891ik) r23)
            if (r0 == 0) goto L_0x0425
            android.content.Context r0 = r22.getApplicationContext()
            com.xiaomi.push.eu r16 = com.xiaomi.push.C1776eu.m3405a((android.content.Context) r0)
            java.lang.String r17 = r23.mo18052b()
            java.lang.String r18 = m4938b((com.xiaomi.push.C1891ik) r23)
            java.lang.String r19 = r11.mo17876a()
            r20 = 1002(0x3ea, float:1.404E-42)
            r21 = 0
            r16.mo17537a(r17, r18, r19, r20, r21)
        L_0x0425:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r4) goto L_0x0461
            if (r11 == 0) goto L_0x0430
            java.lang.String r12 = r11.mo17876a()
            goto L_0x0431
        L_0x0430:
            r12 = 0
        L_0x0431:
            com.xiaomi.push.ak r0 = com.xiaomi.push.C1618ak.m2518a((android.content.Context) r22)
            java.util.Map r1 = r11.mo17876a()
            int r1 = m4897a((java.util.Map<java.lang.String, java.lang.String>) r1)
            if (r1 <= 0) goto L_0x0461
            boolean r3 = android.text.TextUtils.isEmpty(r12)
            if (r3 != 0) goto L_0x0461
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "n_timeout_"
            r3.append(r4)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            r0.mo17218a((java.lang.String) r3)
            com.xiaomi.push.service.ag r4 = new com.xiaomi.push.service.ag
            r4.<init>(r3, r2, r15)
            r0.mo17219b(r4, r1)
        L_0x0461:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
            r0.<init>(r1, r8)
            java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.ik>> r1 = f3664a
            monitor-enter(r1)
            java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.ik>> r2 = f3664a     // Catch:{ all -> 0x0483 }
            r2.add(r0)     // Catch:{ all -> 0x0483 }
            java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.ik>> r0 = f3664a     // Catch:{ all -> 0x0483 }
            int r0 = r0.size()     // Catch:{ all -> 0x0483 }
            r2 = 100
            if (r0 <= r2) goto L_0x0481
            java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.ik>> r0 = f3664a     // Catch:{ all -> 0x0483 }
            r0.remove()     // Catch:{ all -> 0x0483 }
        L_0x0481:
            monitor-exit(r1)     // Catch:{ all -> 0x0483 }
            return r9
        L_0x0483:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0483 }
            goto L_0x0487
        L_0x0486:
            throw r0
        L_0x0487:
            goto L_0x0486
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1974af.m4912a(android.content.Context, com.xiaomi.push.ik, byte[]):com.xiaomi.push.service.af$c");
    }

    /* renamed from: a */
    private static String m4914a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? C1816g.m3669b(context, str) : map.get("channel_name");
    }

    /* renamed from: a */
    public static String m4915a(C1891ik ikVar) {
        C1882ib a;
        if (!(!"com.xiaomi.xmsf".equals(ikVar.f3195b) || (a = ikVar.mo18043a()) == null || a.mo17876a() == null)) {
            String str = (String) a.mo17876a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return ikVar.f3195b;
    }

    /* renamed from: a */
    public static String m4916a(Map<String, String> map, int i) {
        String format = i == 0 ? "notify_effect" : m4935b(map) ? String.format("cust_btn_%s_ne", new Object[]{Integer.valueOf(i)}) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    /* renamed from: a */
    private static String m4917a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* renamed from: a */
    private static void m4918a(Context context, Intent intent, C1891ik ikVar, C1882ib ibVar, String str, int i) {
        if (ikVar != null && ibVar != null && !TextUtils.isEmpty(str)) {
            String a = m4916a((Map<String, String>) ibVar.mo17876a(), i);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            if (C2014bd.f3782a.equals(a) || C2014bd.f3783b.equals(a) || C2014bd.f3784c.equals(a)) {
                intent.putExtra("messageId", str);
                intent.putExtra("local_paid", ikVar.f3191a);
                if (!TextUtils.isEmpty(ikVar.f3195b)) {
                    intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, ikVar.f3195b);
                }
                intent.putExtra("job_key", m4917a((Map<String, String>) ibVar.mo17876a(), "jobkey"));
                intent.putExtra(i + "_" + "target_component", m4896a(context, ikVar.f3195b, (Map<String, String>) ibVar.mo17876a(), i));
            }
        }
    }

    /* renamed from: a */
    public static void m4919a(Context context, String str) {
        m4920a(context, str, -1);
    }

    /* renamed from: a */
    public static void m4920a(Context context, String str, int i) {
        m4921a(context, str, i, -1);
    }

    /* renamed from: a */
    public static void m4921a(Context context, String str, int i, int i2) {
        boolean z;
        if (context != null && !TextUtils.isEmpty(str) && i >= -1) {
            C1993ar a = C1993ar.m5005a(context, str);
            List b = a.mo18462b();
            if (!C2088v.m5383a(b)) {
                LinkedList linkedList = new LinkedList();
                int i3 = 0;
                if (i == -1) {
                    z = true;
                } else {
                    i3 = ((str.hashCode() / 10) * 10) + i;
                    z = false;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    Iterator it = b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        StatusBarNotification statusBarNotification = (StatusBarNotification) it.next();
                        if (!TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                            int id = statusBarNotification.getId();
                            if (z) {
                                linkedList.add(statusBarNotification);
                                a.mo18458a(id);
                            } else if (i3 == id) {
                                C2053d.m5211a(context, statusBarNotification, i2);
                                linkedList.add(statusBarNotification);
                                a.mo18458a(id);
                                break;
                            }
                        }
                    }
                }
                m4924a(context, (LinkedList<? extends Object>) linkedList);
            }
        }
    }

    /* renamed from: a */
    public static void m4923a(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            C1993ar a = C1993ar.m5005a(context, str);
            List<StatusBarNotification> b = a.mo18462b();
            if (!C2088v.m5383a(b)) {
                LinkedList linkedList = new LinkedList();
                if (Build.VERSION.SDK_INT >= 18) {
                    for (StatusBarNotification statusBarNotification : b) {
                        Notification notification = statusBarNotification.getNotification();
                        if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                            int id = statusBarNotification.getId();
                            String a2 = C1994as.m5033a(notification);
                            String b2 = C1994as.m5044b(notification);
                            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(b2) && m4931a(a2, str2) && m4931a(b2, str3)) {
                                linkedList.add(statusBarNotification);
                                a.mo18458a(id);
                            }
                        }
                    }
                }
                m4924a(context, (LinkedList<? extends Object>) linkedList);
            }
        }
    }

    /* renamed from: a */
    public static void m4924a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            C2033bs.m5179a(context, "category_clear_notification", "clear_notification", (long) linkedList.size(), "");
        }
    }

    /* renamed from: a */
    private static void m4925a(Intent intent) {
        try {
            Method declaredMethod = intent.getClass().getDeclaredMethod("addMiuiFlags", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(intent, new Object[]{2});
        } catch (Exception e) {
            C1524b.m2158b("insert flags error " + e);
        }
    }

    /* renamed from: a */
    private static void m4926a(C1778ew ewVar, Context context, String str, C1891ik ikVar, byte[] bArr, int i) {
        PendingIntent a;
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        C1778ew ewVar2 = ewVar;
        Map a5 = ikVar.mo18043a().mo17876a();
        if (!TextUtils.equals("3", (CharSequence) a5.get("notification_style_type")) && !TextUtils.equals("4", (CharSequence) a5.get("notification_style_type"))) {
            if (m4935b((Map<String, String>) a5)) {
                for (int i2 = 1; i2 <= 3; i2++) {
                    String str2 = (String) a5.get(String.format("cust_btn_%s_n", new Object[]{Integer.valueOf(i2)}));
                    if (!TextUtils.isEmpty(str2) && (a4 = m4901a(context, str, ikVar, bArr, i, i2)) != null) {
                        ewVar.addAction(0, str2, a4);
                    }
                }
                return;
            }
            if (!TextUtils.isEmpty((CharSequence) a5.get("notification_style_button_left_name")) && (a3 = m4901a(context, str, ikVar, bArr, i, 1)) != null) {
                ewVar.addAction(0, (CharSequence) a5.get("notification_style_button_left_name"), a3);
            }
            if (!TextUtils.isEmpty((CharSequence) a5.get("notification_style_button_mid_name")) && (a2 = m4901a(context, str, ikVar, bArr, i, 2)) != null) {
                ewVar.addAction(0, (CharSequence) a5.get("notification_style_button_mid_name"), a2);
            }
            if (!TextUtils.isEmpty((CharSequence) a5.get("notification_style_button_right_name")) && (a = m4901a(context, str, ikVar, bArr, i, 3)) != null) {
                ewVar.addAction(0, (CharSequence) a5.get("notification_style_button_right_name"), a);
            }
        }
    }

    /* renamed from: a */
    private static boolean m4927a(Context context, C1891ik ikVar, String str) {
        if (ikVar != null && ikVar.mo18043a() != null && ikVar.mo18043a().mo17876a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean((String) ikVar.mo18043a().mo17876a().get("use_clicked_activity")) && C2060h.m5230a(context, m4902a(str));
        }
        C1524b.m2141a("should clicked activity params are null.");
        return false;
    }

    /* renamed from: a */
    public static boolean m4928a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.importance == 100 && Arrays.asList(next.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m4929a(C1882ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        String a = ibVar.mo17876a();
        return !TextUtils.isEmpty(a) && a.length() == 22 && "satuigmo".indexOf(a.charAt(0)) >= 0;
    }

    /* renamed from: a */
    public static boolean m4930a(C1891ik ikVar) {
        C1882ib a = ikVar.mo18043a();
        return m4929a(a) && a.mo17906l();
    }

    /* renamed from: a */
    private static boolean m4931a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a */
    public static boolean m4932a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004e, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0072;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] m4933a(android.content.Context r3, com.xiaomi.push.C1882ib r4) {
        /*
            java.lang.String r0 = r4.mo17888c()
            java.lang.String r1 = r4.mo17894d()
            java.util.Map r4 = r4.mo17876a()
            if (r4 == 0) goto L_0x0073
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L_0x0051
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x0042
            r0 = r3
        L_0x0042:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0073
            goto L_0x0072
        L_0x0051:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L_0x0073
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x0064
            r0 = r3
        L_0x0064:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0073
        L_0x0072:
            r1 = r3
        L_0x0073:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1974af.m4933a(android.content.Context, com.xiaomi.push.ib):java.lang.String[]");
    }

    /* renamed from: b */
    private static int m4934b(Context context, String str) {
        int a = m4895a(context, str, "mipush_notification");
        int a2 = m4895a(context, str, "mipush_small_notification");
        if (a <= 0) {
            a = a2 > 0 ? a2 : context.getApplicationInfo().icon;
        }
        return (a != 0 || Build.VERSION.SDK_INT < 9) ? a : context.getApplicationInfo().logo;
    }

    /* renamed from: b */
    private static int m4935b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            C1524b.m2159c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            C1524b.m2160d("parsing channel importance error: " + e);
            return 3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0142  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent m4936b(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, int r8) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r8 == 0) goto L_0x000b
            android.content.Intent r5 = m4896a((android.content.Context) r5, (java.lang.String) r6, (java.util.Map<java.lang.String, java.lang.String>) r7, (int) r8)
            return r5
        L_0x000b:
            java.lang.String r8 = "notify_effect"
            boolean r1 = r7.containsKey(r8)
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x0014:
            java.lang.Object r8 = r7.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r1 = -1
            java.lang.String r2 = "intent_flag"
            java.lang.Object r2 = r7.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ NumberFormatException -> 0x002e }
            if (r3 != 0) goto L_0x0047
            int r1 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x002e }
            goto L_0x0047
        L_0x002e:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cause by intent_flag: "
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r2)
        L_0x0047:
            java.lang.String r2 = com.xiaomi.push.service.C2014bd.f3782a
            boolean r2 = r2.equals(r8)
            java.lang.String r3 = "Cause: "
            if (r2 == 0) goto L_0x0075
            android.content.pm.PackageManager r7 = r5.getPackageManager()     // Catch:{ Exception -> 0x005c }
            android.content.Intent r6 = r7.getLaunchIntentForPackage(r6)     // Catch:{ Exception -> 0x005c }
            r7 = r6
            goto L_0x0140
        L_0x005c:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            java.lang.String r6 = r6.getMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r6)
            goto L_0x013f
        L_0x0075:
            java.lang.String r2 = com.xiaomi.push.service.C2014bd.f3783b
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x00c7
            java.lang.String r8 = "intent_uri"
            boolean r2 = r7.containsKey(r8)
            if (r2 == 0) goto L_0x00a9
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x013f
            r8 = 1
            android.content.Intent r7 = android.content.Intent.parseUri(r7, r8)     // Catch:{ URISyntaxException -> 0x0099 }
            r7.setPackage(r6)     // Catch:{ URISyntaxException -> 0x0097 }
            goto L_0x0140
        L_0x0097:
            r6 = move-exception
            goto L_0x009b
        L_0x0099:
            r6 = move-exception
            r7 = r0
        L_0x009b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            java.lang.String r6 = r6.getMessage()
            goto L_0x0134
        L_0x00a9:
            java.lang.String r8 = "class_name"
            boolean r2 = r7.containsKey(r8)
            if (r2 == 0) goto L_0x013f
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            android.content.Intent r8 = new android.content.Intent
            r8.<init>()
            android.content.ComponentName r2 = new android.content.ComponentName
            r2.<init>(r6, r7)
            r8.setComponent(r2)
            r7 = r8
            goto L_0x0140
        L_0x00c7:
            java.lang.String r6 = com.xiaomi.push.service.C2014bd.f3784c
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x013f
            java.lang.String r6 = "web_uri"
            java.lang.Object r6 = r7.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x013f
            java.lang.String r6 = r6.trim()
            java.lang.String r7 = "http://"
            boolean r8 = r6.startsWith(r7)
            if (r8 != 0) goto L_0x00fc
            java.lang.String r8 = "https://"
            boolean r8 = r6.startsWith(r8)
            if (r8 != 0) goto L_0x00fc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
        L_0x00fc:
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0126 }
            r7.<init>(r6)     // Catch:{ MalformedURLException -> 0x0126 }
            java.lang.String r7 = r7.getProtocol()     // Catch:{ MalformedURLException -> 0x0126 }
            java.lang.String r8 = "http"
            boolean r8 = r8.equals(r7)     // Catch:{ MalformedURLException -> 0x0126 }
            if (r8 != 0) goto L_0x0115
            java.lang.String r8 = "https"
            boolean r7 = r8.equals(r7)     // Catch:{ MalformedURLException -> 0x0126 }
            if (r7 == 0) goto L_0x013f
        L_0x0115:
            android.content.Intent r7 = new android.content.Intent     // Catch:{ MalformedURLException -> 0x0126 }
            java.lang.String r8 = "android.intent.action.VIEW"
            r7.<init>(r8)     // Catch:{ MalformedURLException -> 0x0126 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ MalformedURLException -> 0x0124 }
            r7.setData(r6)     // Catch:{ MalformedURLException -> 0x0124 }
            goto L_0x0140
        L_0x0124:
            r6 = move-exception
            goto L_0x0128
        L_0x0126:
            r6 = move-exception
            r7 = r0
        L_0x0128:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            java.lang.String r6 = r6.getMessage()
        L_0x0134:
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r6)
            goto L_0x0140
        L_0x013f:
            r7 = r0
        L_0x0140:
            if (r7 == 0) goto L_0x0185
            if (r1 < 0) goto L_0x0147
            r7.setFlags(r1)
        L_0x0147:
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r7.addFlags(r6)
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ Exception -> 0x016e }
            r6 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r5 = r5.resolveActivity(r7, r6)     // Catch:{ Exception -> 0x016e }
            if (r5 == 0) goto L_0x0159
            return r7
        L_0x0159:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016e }
            r5.<init>()     // Catch:{ Exception -> 0x016e }
            java.lang.String r6 = "not resolve activity:"
            r5.append(r6)     // Catch:{ Exception -> 0x016e }
            r5.append(r7)     // Catch:{ Exception -> 0x016e }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x016e }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r5)     // Catch:{ Exception -> 0x016e }
            goto L_0x0185
        L_0x016e:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r5)
        L_0x0185:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1974af.m4936b(android.content.Context, java.lang.String, java.util.Map, int):android.content.Intent");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m4937b(int i, String str) {
        return "n_top_update_" + i + "_" + str;
    }

    /* renamed from: b */
    public static String m4938b(C1891ik ikVar) {
        return m4915a(ikVar) ? "E100002" : m4946c(ikVar) ? "E100000" : m4938b(ikVar) ? "E100001" : m4949d(ikVar) ? "E100003" : "";
    }

    /* renamed from: b */
    static void m4939b(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    /* renamed from: b */
    static void m4940b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* renamed from: b */
    private static void m4941b(Context context, String str, int i, String str2, Notification notification) {
        boolean z;
        Context context2 = context;
        int i2 = i;
        String str3 = str2;
        Notification notification2 = notification;
        if (context2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && C1993ar.m5005a(context, str) != null && Build.VERSION.SDK_INT >= 26) {
            C1993ar a = C1993ar.m5005a(context, str);
            if (notification2 == null) {
                List b = a.mo18462b();
                if (b != null) {
                    Iterator it = b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            notification2 = null;
                            break;
                        }
                        StatusBarNotification statusBarNotification = (StatusBarNotification) it.next();
                        Notification notification3 = statusBarNotification.getNotification();
                        String string = notification3.extras.getString("message_id");
                        if (i2 == statusBarNotification.getId() && str3.equals(string)) {
                            notification2 = notification3;
                            break;
                        }
                    }
                    z = false;
                } else {
                    return;
                }
            } else if (str3.equals(notification2.extras.getString("message_id"))) {
                z = true;
            } else {
                return;
            }
            if (notification2 != null) {
                if (notification2.getGroupAlertBehavior() != 1) {
                    C1656bj.m2702a((Object) notification2, "mGroupAlertBehavior", (Object) 1);
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j = notification2.extras.getLong("mipush_org_when", 0);
                int i3 = notification2.extras.getInt("mipush_n_top_fre", 0);
                int i4 = notification2.extras.getInt("mipush_n_top_prd", 0);
                if (i4 > 0 && i4 >= i3) {
                    long j2 = ((long) (i4 * 1000)) + j;
                    if (j >= currentTimeMillis || currentTimeMillis >= j2) {
                        i4 = 0;
                    } else if (i3 > 0) {
                        int min = (int) Math.min((j2 - currentTimeMillis) / 1000, (long) i3);
                        if (min > 0 && !z) {
                            notification2.when = currentTimeMillis;
                            C1524b.m2141a("update top notification: " + str3);
                            a.mo18459a(i2, notification2);
                        }
                        i4 = min;
                    }
                    if (i4 > 0) {
                        C1524b.m2141a("schedule top notification next update delay: " + i4);
                        C1618ak.m2518a(context).mo17218a(m4937b(i, str2));
                        C1618ak.m2518a(context).mo17219b(m4909a(context2, str, i2, str3, (Notification) null), i4);
                        return;
                    }
                    String a2 = C1985an.m4969a(a);
                    Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context2, notification2);
                    recoverBuilder.setChannelId(a2);
                    recoverBuilder.setPriority(0);
                    C1524b.m2141a("update top notification to common: " + str3);
                    a.mo18459a(i2, recoverBuilder.build());
                }
            }
        }
    }

    /* renamed from: b */
    static boolean m4942b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b */
    public static boolean m4943b(C1891ik ikVar) {
        C1882ib a = ikVar.mo18043a();
        return m4929a(a) && a.f3035b == 1 && !m4915a(ikVar);
    }

    /* renamed from: b */
    private static boolean m4944b(Map<String, String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        C1524b.m2141a("meta extra is null");
        return false;
    }

    /* renamed from: c */
    private static int m4945c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            C1524b.m2159c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            C1524b.m2160d("parsing notification priority error: " + e);
            return 0;
        }
    }

    /* renamed from: c */
    public static boolean m4946c(C1891ik ikVar) {
        C1882ib a = ikVar.mo18043a();
        return m4929a(a) && a.f3035b == 0 && !m4915a(ikVar);
    }

    /* renamed from: c */
    private static boolean m4947c(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_top_repeat");
            if (!TextUtils.isEmpty(str)) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                C1524b.m2159c("top notification' repeat is " + parseBoolean);
                return parseBoolean;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static int m4948d(Map<String, String> map) {
        int i;
        if (map != null) {
            String str = map.get("notification_top_frequency");
            if (!TextUtils.isEmpty(str)) {
                try {
                    C1524b.m2159c("fre of top notification is " + str);
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    C1524b.m2160d("parsing top notification frequency error: " + e);
                }
                return Math.max(0, i);
            }
        }
        i = 0;
        return Math.max(0, i);
    }

    /* renamed from: d */
    public static boolean m4949d(C1891ik ikVar) {
        return ikVar.mo18043a() == C1868ho.Registration;
    }

    /* renamed from: e */
    private static int m4950e(Map<String, String> map) {
        int i;
        if (map != null) {
            String str = map.get("notification_top_period");
            if (!TextUtils.isEmpty(str)) {
                try {
                    C1524b.m2159c("prd of top notification is " + str);
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    C1524b.m2160d("parsing top notification period error: " + e);
                }
                return Math.max(0, i);
            }
        }
        i = 0;
        return Math.max(0, i);
    }

    /* renamed from: e */
    public static boolean m4951e(C1891ik ikVar) {
        return m4915a(ikVar) || m4946c(ikVar) || m4938b(ikVar);
    }
}
