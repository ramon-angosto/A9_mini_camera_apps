package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.e0;
import java.io.IOException;
import java.util.regex.Matcher;
import kotlin.text.Regex;

public final class e extends j {
    private String G = "";
    private String H = "";

    static final class a implements Runnable {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        public final void run() {
            e.super.c();
        }
    }

    public e(Context context, int i, h0 h0Var) {
        super(context, i, h0Var);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void b(Exception exc) {
        new e0.a().a(exc.getClass().toString()).a(" during metadata injection w/ metadata = ").a(c0.h(getInfo(), TtmlNode.TAG_METADATA)).a(e0.i);
        AdColonyInterstitial remove = a.b().c().f().remove(c0.h(getInfo(), "ad_session_id"));
        if (remove != null) {
            remove.p();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0089, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008a, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String p() {
        /*
            r8 = this;
            java.lang.String r0 = r8.H
            int r0 = r0.length()
            r1 = 0
            if (r0 <= 0) goto L_0x000b
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = r1
        L_0x000c:
            if (r0 == 0) goto L_0x0036
            kotlin.text.Regex r0 = new kotlin.text.Regex
            java.lang.String r1 = "script\\s*src\\s*=\\s*\"mraid.js\""
            r0.<init>((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "script src=\"file://"
            r1.append(r2)
            java.lang.String r2 = r8.getMraidFilepath()
            r1.append(r2)
            r2 = 34
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = r8.H
            java.lang.String r0 = r0.replaceFirst(r2, r1)
            goto L_0x0086
        L_0x0036:
            java.io.FileInputStream r0 = new java.io.FileInputStream
            java.lang.String r2 = r8.G
            r0.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            int r3 = r0.available()     // Catch:{ all -> 0x0087 }
            r2.<init>(r3)     // Catch:{ all -> 0x0087 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r3]     // Catch:{ all -> 0x0087 }
        L_0x004a:
            int r5 = r0.read(r4, r1, r3)     // Catch:{ all -> 0x0087 }
            if (r5 < 0) goto L_0x005b
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0087 }
            java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0087 }
            r6.<init>(r4, r1, r5, r7)     // Catch:{ all -> 0x0087 }
            r2.append(r6)     // Catch:{ all -> 0x0087 }
            goto L_0x004a
        L_0x005b:
            java.lang.String r3 = r8.G     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = ".html"
            r5 = 2
            r6 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (boolean) r1, (int) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x006c
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0087 }
            goto L_0x0082
        L_0x006c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r1.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "<html><script>"
            r1.append(r3)     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "</script></html>"
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0087 }
        L_0x0082:
            kotlin.io.CloseableKt.closeFinally(r0, r6)
            r0 = r1
        L_0x0086:
            return r0
        L_0x0087:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.e.p():java.lang.String");
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ String d(f1 f1Var) {
        if (this.H.length() > 0) {
            return "";
        }
        return super.d(f1Var);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void i() {
        h0 message = getMessage();
        f1 a2 = message == null ? null : message.a();
        if (a2 == null) {
            a2 = c0.b();
        }
        this.G = c(a2);
        this.H = c0.h(a2, "interstitial_html");
        super.i();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void j() {
        try {
            h0 message = getMessage();
            f1 a2 = message == null ? null : message.a();
            if (a2 == null) {
                a2 = c0.b();
            }
            String h = c0.h(c0.f(a2, "info"), TtmlNode.TAG_METADATA);
            String a3 = a(p(), c0.h(c0.b(h), "iab_filepath"));
            Regex regex = new Regex("var\\s*ADC_DEVICE_INFO\\s*=\\s*null\\s*;");
            String replaceFirst = regex.replaceFirst(a3, Matcher.quoteReplacement("var ADC_DEVICE_INFO = " + h + ';'));
            String mUrl = getMUrl();
            if (mUrl.length() == 0) {
                mUrl = getBaseUrl();
            }
            loadDataWithBaseURL(mUrl, replaceFirst, "text/html", (String) null, (String) null);
        } catch (IOException e) {
            b(e);
        } catch (IllegalArgumentException e2) {
            b(e2);
        } catch (IndexOutOfBoundsException e3) {
            b(e3);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void k() {
    }

    public void c() {
        if (!getDestroyed()) {
            z0.a((Runnable) new a(this), n() ? 1000 : 0);
        }
    }
}
