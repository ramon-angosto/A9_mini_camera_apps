package com.bytedance.sdk.component.e.a.b.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.a.a.f;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.d.a;
import com.bytedance.sdk.component.e.a.g;
import com.bytedance.sdk.component.e.a.i;
import java.util.List;

/* compiled from: OverSeasEventProviderImpl */
public class b {
    public static g a;

    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public Uri a(Uri uri, ContentValues contentValues) {
        return null;
    }

    public String c() {
        return "ad_log_event";
    }

    public void d() {
    }

    public static g a(Context context) {
        try {
            c.a("getResolver");
            if (a == null) {
                a = i.e().m().l();
            }
        } catch (Exception unused) {
        }
        return a;
    }

    public static void a() {
        c.a("EventProviderImpl#start");
        if (i.e().d() != null) {
            try {
                g a2 = a(i.e().d());
                if (a2 != null) {
                    Uri parse = Uri.parse(e() + "adLogStart");
                    c.a("EventProviderImpl#gettype");
                    a2.a(parse);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void b() {
        if (i.e().d() != null) {
            try {
                g a2 = a(i.e().d());
                if (a2 != null) {
                    a2.a(Uri.parse(e() + "adLogStop"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(a aVar) {
        if (aVar != null) {
            try {
                c.a("dispatch event getResolver before");
                g a2 = a(i.e().d());
                c.a("dispatch event getResolver end");
                if (a2 != null) {
                    String a3 = f.a(aVar.f());
                    Uri parse = Uri.parse(e() + "adLogDispatch" + "?event=" + a3);
                    c.a("dispatch event getType:");
                    a2.a(parse);
                    c.a("dispatch event getType end ");
                }
            } catch (Throwable th) {
                c.d("dispatch event Throwable:" + th.toString());
            }
        }
    }

    public static void a(String str, List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String a2 : list) {
                    sb.append(f.a(a2));
                    sb.append(",");
                }
                String a3 = f.a(sb.toString());
                String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(a3) + "&replace=" + String.valueOf(z);
                g a4 = a(i.e().d());
                if (a4 != null) {
                    a4.a(Uri.parse(e() + "trackAdUrl" + str2));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (i.e().m().g() != 0 || !TextUtils.isEmpty(str)) {
            try {
                g a2 = a(i.e().d());
                if (a2 != null) {
                    a2.a(Uri.parse(e() + "trackAdFailed" + "?did=" + String.valueOf(str)));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String e() {
        return com.bytedance.sdk.component.e.a.a.a.g.b + "/" + "ad_log_event" + "/";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = "OverSeasEventProviderImpl#gettype()"
            com.bytedance.sdk.component.e.a.c.c.a(r0)
            java.lang.String r0 = r8.getPath()
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1)
            r1 = 2
            r0 = r0[r1]
            int r2 = r0.hashCode()
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 1
            switch(r2) {
                case -482705237: goto L_0x0046;
                case -171493183: goto L_0x003c;
                case 964299715: goto L_0x0032;
                case 1025736635: goto L_0x0028;
                case 1131732929: goto L_0x001e;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0050
        L_0x001e:
            java.lang.String r2 = "trackAdUrl"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0050
            r0 = r5
            goto L_0x0051
        L_0x0028:
            java.lang.String r2 = "adLogDispatch"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0050
            r0 = r1
            goto L_0x0051
        L_0x0032:
            java.lang.String r2 = "adLogStop"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0050
            r0 = r6
            goto L_0x0051
        L_0x003c:
            java.lang.String r2 = "adLogStart"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0050
            r0 = r3
            goto L_0x0051
        L_0x0046:
            java.lang.String r2 = "trackAdFailed"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0050
            r0 = r4
            goto L_0x0051
        L_0x0050:
            r0 = -1
        L_0x0051:
            if (r0 == 0) goto L_0x00e8
            java.lang.String r2 = "EventProviderImpl"
            if (r0 == r6) goto L_0x00db
            if (r0 == r1) goto L_0x00ba
            java.lang.String r1 = "did"
            if (r0 == r5) goto L_0x006e
            if (r0 == r4) goto L_0x0061
            goto L_0x00f4
        L_0x0061:
            java.lang.String r8 = r8.getQueryParameter(r1)
            com.bytedance.sdk.component.e.a.f.b r0 = com.bytedance.sdk.component.e.a.f.a.a()
            r0.a(r8)
            goto L_0x00f4
        L_0x006e:
            java.lang.String r0 = "dispatch FUN_TRACK_URL"
            com.bytedance.sdk.component.e.a.c.c.a(r2, r0)
            java.lang.String r0 = r8.getQueryParameter(r1)     // Catch:{ all -> 0x00f4 }
            java.lang.String r1 = "replace"
            java.lang.String r1 = r8.getQueryParameter(r1)     // Catch:{ all -> 0x00f4 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x00f4 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = "track"
            java.lang.String r8 = r8.getQueryParameter(r2)     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = com.bytedance.sdk.component.e.a.a.a.f.b(r8)     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = ","
            java.lang.String[] r8 = r8.split(r2)     // Catch:{ all -> 0x00f4 }
            int r2 = r8.length     // Catch:{ all -> 0x00f4 }
            if (r2 <= 0) goto L_0x00f4
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00f4 }
            r2.<init>()     // Catch:{ all -> 0x00f4 }
            int r4 = r8.length     // Catch:{ all -> 0x00f4 }
        L_0x009e:
            if (r3 >= r4) goto L_0x00b2
            r5 = r8[r3]     // Catch:{ all -> 0x00f4 }
            java.lang.String r5 = com.bytedance.sdk.component.e.a.a.a.f.b(r5)     // Catch:{ all -> 0x00f4 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00f4 }
            if (r6 != 0) goto L_0x00af
            r2.add(r5)     // Catch:{ all -> 0x00f4 }
        L_0x00af:
            int r3 = r3 + 1
            goto L_0x009e
        L_0x00b2:
            com.bytedance.sdk.component.e.a.f.b r8 = com.bytedance.sdk.component.e.a.f.a.a()     // Catch:{ all -> 0x00f4 }
            r8.a(r0, r2, r1)     // Catch:{ all -> 0x00f4 }
            goto L_0x00f4
        L_0x00ba:
            java.lang.String r0 = "dispatch FUN_AD_EVENT_DISPATCH"
            com.bytedance.sdk.component.e.a.c.c.a(r2, r0)
            java.lang.String r0 = "event"
            java.lang.String r8 = r8.getQueryParameter(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x00f4
            java.lang.String r8 = com.bytedance.sdk.component.e.a.a.a.f.b(r8)
            com.bytedance.sdk.component.e.a.d.a r8 = com.bytedance.sdk.component.e.a.d.a.a.c((java.lang.String) r8)
            if (r8 == 0) goto L_0x00f4
            com.bytedance.sdk.component.e.a.d r0 = com.bytedance.sdk.component.e.a.d.a
            r0.a((com.bytedance.sdk.component.e.a.d.a) r8)
            goto L_0x00f4
        L_0x00db:
            java.lang.String r8 = "====ad event function will be stop===="
            com.bytedance.sdk.component.e.a.c.c.a(r2, r8)
            com.bytedance.sdk.component.e.a.i r8 = com.bytedance.sdk.component.e.a.i.e()
            r8.h()
            goto L_0x00f4
        L_0x00e8:
            java.lang.String r8 = "EventProviderImpl====ad event function will be start===="
            com.bytedance.sdk.component.e.a.c.c.a(r8)
            com.bytedance.sdk.component.e.a.i r8 = com.bytedance.sdk.component.e.a.i.e()
            r8.g()
        L_0x00f4:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.b.b.b.a(android.net.Uri):java.lang.String");
    }
}
