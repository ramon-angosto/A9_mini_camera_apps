package com.ironsource.mediationsdk;

import android.content.Context;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/ironsource/mediationsdk/InitServerResponse;", "", "()V", "Companion", "mediationsdk_release"}, k = 1, mv = {1, 4, 2})
public final class D {
    private static a a = new a((byte) 0);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/ironsource/mediationsdk/InitServerResponse$Companion;", "", "()V", "getCachedResponse", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "isResponseCached", "", "loadFromCache", "Lcom/ironsource/mediationsdk/utils/ServerResponseWrapper;", "loadResponseFromCache", "Lcom/ironsource/mediationsdk/CachedResponse;", "mediationsdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private static JSONObject b(Context context) {
            try {
                return new JSONObject(IronSourceUtils.getLastResponse(context));
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }

        @JvmStatic
        public final C0162o a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            JSONObject b = b(context);
            String optString = b.optString("appKey");
            String optString2 = b.optString("userId");
            String optString3 = b.optString("response");
            Intrinsics.checkNotNullExpressionValue(optString, "cachedAppKey");
            Intrinsics.checkNotNullExpressionValue(optString2, "cachedUserId");
            Intrinsics.checkNotNullExpressionValue(optString3, "cachedSettings");
            return new C0162o(optString, optString2, optString3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        if ((r0.c.length() > 0) != false) goto L_0x003e;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.ironsource.mediationsdk.utils.l a(android.content.Context r4) {
        /*
            com.ironsource.mediationsdk.D$a r0 = a
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            com.ironsource.mediationsdk.D$a r0 = (com.ironsource.mediationsdk.D.a) r0
            com.ironsource.mediationsdk.o r0 = r0.a(r4)
            java.lang.String r1 = r0.a
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L_0x001b
            r1 = r2
            goto L_0x001c
        L_0x001b:
            r1 = r3
        L_0x001c:
            if (r1 == 0) goto L_0x003d
            java.lang.String r1 = r0.b
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x002a
            r1 = r2
            goto L_0x002b
        L_0x002a:
            r1 = r3
        L_0x002b:
            if (r1 == 0) goto L_0x003d
            java.lang.String r1 = r0.c
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0039
            r1 = r2
            goto L_0x003a
        L_0x0039:
            r1 = r3
        L_0x003a:
            if (r1 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r2 = r3
        L_0x003e:
            r1 = 0
            if (r2 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r0 = r1
        L_0x0043:
            if (r0 == 0) goto L_0x0055
            com.ironsource.mediationsdk.utils.l r1 = new com.ironsource.mediationsdk.utils.l
            java.lang.String r2 = r0.a
            java.lang.String r3 = r0.b
            java.lang.String r0 = r0.c
            r1.<init>(r4, r2, r3, r0)
            int r4 = com.ironsource.mediationsdk.utils.l.a.b
            r1.a((int) r4)
        L_0x0055:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.D.a(android.content.Context):com.ironsource.mediationsdk.utils.l");
    }

    @JvmStatic
    public static final boolean b(Context context) {
        a aVar = a;
        Intrinsics.checkNotNullParameter(context, "context");
        C0162o a2 = aVar.a(context);
        if (a2.a.length() > 0) {
            if (a2.b.length() > 0) {
                if (a2.c.length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
