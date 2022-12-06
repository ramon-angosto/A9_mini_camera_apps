package com.ironsource.sdk.c;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONObject;

public final class a extends FrameLayout implements e {
    public c a;
    private boolean b = false;

    public a(c cVar, Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(cVar.d.a, cVar.d.b));
        this.a = cVar;
        addView(this.a.b);
    }

    public void a() {
        JSONObject jSONObject;
        try {
            jSONObject = this.a.c.a().getJSONObject("configs").getJSONObject("visibilityParams");
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("adViewId", this.a.a).put("isBNAutoRemove", false).put("isBannerDisplay", this.b);
        this.a.c.a("destroyBanner", jSONObject);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(final java.lang.String r4, final java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.ironsource.sdk.c.c r0 = r3.a     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0034
            com.ironsource.sdk.c.c r0 = r3.a     // Catch:{ all -> 0x0036 }
            com.ironsource.sdk.b.b r0 = r0.c     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0034
            com.ironsource.sdk.c.c r0 = r3.a     // Catch:{ all -> 0x0036 }
            android.webkit.WebView r0 = r0.b     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0012
            goto L_0x0034
        L_0x0012:
            com.ironsource.sdk.c.c r0 = r3.a     // Catch:{ all -> 0x0036 }
            com.ironsource.sdk.b.b r0 = r0.c     // Catch:{ all -> 0x0036 }
            com.ironsource.sdk.b.a r1 = r0.a     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0028
            com.ironsource.sdk.b.d r1 = r0.b     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x001f
            goto L_0x0028
        L_0x001f:
            org.json.JSONObject r1 = r0.a()     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = "containerWasRemoved"
            r0.a((java.lang.String) r2, (org.json.JSONObject) r1)     // Catch:{ all -> 0x0036 }
        L_0x0028:
            com.ironsource.environment.e.a r0 = com.ironsource.environment.e.a.a     // Catch:{ all -> 0x0036 }
            com.ironsource.sdk.c.a$1 r1 = new com.ironsource.sdk.c.a$1     // Catch:{ all -> 0x0036 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0036 }
            r0.a(r1)     // Catch:{ all -> 0x0036 }
            monitor-exit(r3)
            return
        L_0x0034:
            monitor-exit(r3)
            return
        L_0x0036:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.c.a.a(java.lang.String, java.lang.String):void");
    }

    public final void a(String str, String str2, String str3) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(str, str2, str3);
        }
    }

    public final void a(JSONObject jSONObject, String str, String str2) {
        this.a.a(jSONObject, str, str2);
    }

    public final WebView b() {
        return this.a.b;
    }

    public final void b(JSONObject jSONObject, String str, String str2) {
        this.a.b(jSONObject, str, str2);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.i("IronSourceAdContainer", "onAttachedToWindow:");
        this.b = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        r1 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r1 = new org.json.JSONObject();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDetachedFromWindow() {
        /*
            r5 = this;
            super.onDetachedFromWindow()
            java.lang.String r0 = "IronSourceAdContainer"
            java.lang.String r1 = "onDetachedFromWindow:"
            com.ironsource.sdk.utils.Logger.i(r0, r1)
            com.ironsource.sdk.c.c r1 = r5.a
            if (r1 == 0) goto L_0x005b
            com.ironsource.sdk.b.b r1 = r1.c
            if (r1 != 0) goto L_0x0013
            goto L_0x005b
        L_0x0013:
            r1 = 0
            r5.b = r1
            com.ironsource.sdk.c.c r1 = r5.a     // Catch:{ Exception -> 0x002b }
            com.ironsource.sdk.b.b r1 = r1.c     // Catch:{ Exception -> 0x002b }
            org.json.JSONObject r1 = r1.a()     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = "configs"
            org.json.JSONObject r1 = r1.getJSONObject(r2)     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = "visibilityParams"
            org.json.JSONObject r1 = r1.getJSONObject(r2)     // Catch:{ Exception -> 0x002b }
            goto L_0x0030
        L_0x002b:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0052 }
            r1.<init>()     // Catch:{ Exception -> 0x0052 }
        L_0x0030:
            java.lang.String r2 = "adViewId"
            com.ironsource.sdk.c.c r3 = r5.a     // Catch:{ Exception -> 0x0052 }
            java.lang.String r3 = r3.a     // Catch:{ Exception -> 0x0052 }
            org.json.JSONObject r2 = r1.put(r2, r3)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r3 = "isBNAutoRemove"
            r4 = 1
            org.json.JSONObject r2 = r2.put(r3, r4)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r3 = "isBannerDisplay"
            boolean r4 = r5.b     // Catch:{ Exception -> 0x0052 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0052 }
            com.ironsource.sdk.c.c r2 = r5.a     // Catch:{ Exception -> 0x0052 }
            com.ironsource.sdk.b.b r2 = r2.c     // Catch:{ Exception -> 0x0052 }
            java.lang.String r3 = "destroyBanner"
            r2.a((java.lang.String) r3, (org.json.JSONObject) r1)     // Catch:{ Exception -> 0x0052 }
            return
        L_0x0052:
            r1 = move-exception
            java.lang.String r1 = r1.toString()
        L_0x0057:
            com.ironsource.sdk.utils.Logger.i(r0, r1)
            return
        L_0x005b:
            java.lang.String r1 = "in onDetachedFromWindow mAdPresenter or mAdPresenter.getLogic() are null"
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.c.a.onDetachedFromWindow():void");
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(View view, int i) {
        Logger.i("IronSourceAdContainer", "onVisibilityChanged: " + i);
        c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.c.a("isVisible", i, isShown());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        Logger.i("IronSourceAdContainer", "onWindowVisibilityChanged: " + i);
        c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.c.a("isWindowVisible", i, isShown());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
