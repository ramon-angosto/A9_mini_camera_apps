package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
final class zzbm implements zzg {
    private final Application zza;
    private final zzbi zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zzh zze;
    private final zzak zzf;
    private final zzay zzg;
    private final zzam zzh;

    zzbm(Application application, zzbi zzbi, Handler handler, Executor executor, zzh zzh2, zzak zzak, zzay zzay, zzam zzam) {
        this.zza = application;
        this.zzb = zzbi;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzh2;
        this.zzf = zzak;
        this.zzg = zzay;
        this.zzh = zzam;
    }

    private final void zzf(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            Log.d("UserMessagingPlatform", "Action[browser]: empty url.");
        }
        Uri parse = Uri.parse(optString);
        if (parse.getScheme() == null) {
            String valueOf = String.valueOf(optString);
            Log.d("UserMessagingPlatform", valueOf.length() != 0 ? "Action[browser]: empty scheme: ".concat(valueOf) : new String("Action[browser]: empty scheme: "));
        }
        try {
            this.zzb.startActivity(new Intent("android.intent.action.VIEW", parse));
        } catch (ActivityNotFoundException e) {
            String valueOf2 = String.valueOf(optString);
            Log.d("UserMessagingPlatform", valueOf2.length() != 0 ? "Action[browser]: can not open url: ".concat(valueOf2) : new String("Action[browser]: can not open url: "), e);
        }
    }

    public final Executor zza() {
        return new zzbl(this.zzc);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(java.lang.String r7, org.json.JSONObject r8) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = -1
            r2 = 0
            r3 = 2
            r4 = 3
            r5 = 1
            switch(r0) {
                case -1370505102: goto L_0x002b;
                case -278739366: goto L_0x0021;
                case 150940456: goto L_0x0017;
                case 1671672458: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0035
        L_0x000d:
            java.lang.String r0 = "dismiss"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = r5
            goto L_0x0036
        L_0x0017:
            java.lang.String r0 = "browser"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = r3
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "configure_app_assets"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = r4
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "load_complete"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = r2
            goto L_0x0036
        L_0x0035:
            r7 = r1
        L_0x0036:
            if (r7 == 0) goto L_0x00ab
            if (r7 == r5) goto L_0x004e
            if (r7 == r3) goto L_0x004a
            if (r7 == r4) goto L_0x003f
            return r2
        L_0x003f:
            java.util.concurrent.Executor r7 = r6.zzd
            com.google.android.gms.internal.consent_sdk.zzbk r8 = new com.google.android.gms.internal.consent_sdk.zzbk
            r8.<init>(r6)
            r7.execute(r8)
            return r5
        L_0x004a:
            r6.zzf(r8)
            return r5
        L_0x004e:
            java.lang.String r7 = "status"
            java.lang.String r7 = r8.optString(r7)
            int r8 = r7.hashCode()
            r0 = 4
            switch(r8) {
                case -954325659: goto L_0x0085;
                case -258041904: goto L_0x007b;
                case 429411856: goto L_0x0071;
                case 467888915: goto L_0x0067;
                case 1666911234: goto L_0x005d;
                default: goto L_0x005c;
            }
        L_0x005c:
            goto L_0x008e
        L_0x005d:
            java.lang.String r8 = "non_personalized"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x008e
            r1 = r3
            goto L_0x008e
        L_0x0067:
            java.lang.String r8 = "CONSENT_SIGNAL_PERSONALIZED_ADS"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x008e
            r1 = r5
            goto L_0x008e
        L_0x0071:
            java.lang.String r8 = "CONSENT_SIGNAL_SUFFICIENT"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x008e
            r1 = r0
            goto L_0x008e
        L_0x007b:
            java.lang.String r8 = "personalized"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x008e
            r1 = r2
            goto L_0x008e
        L_0x0085:
            java.lang.String r8 = "CONSENT_SIGNAL_NON_PERSONALIZED_ADS"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x008e
            r1 = r4
        L_0x008e:
            if (r1 == 0) goto L_0x00a5
            if (r1 == r5) goto L_0x00a5
            if (r1 == r3) goto L_0x00a5
            if (r1 == r4) goto L_0x00a5
            if (r1 == r0) goto L_0x00a5
            com.google.android.gms.internal.consent_sdk.zzay r7 = r6.zzg
            com.google.android.gms.internal.consent_sdk.zzj r8 = new com.google.android.gms.internal.consent_sdk.zzj
            java.lang.String r0 = "We are getting something wrong with the webview."
            r8.<init>(r5, r0)
            r7.zzd(r8)
            goto L_0x00aa
        L_0x00a5:
            com.google.android.gms.internal.consent_sdk.zzay r7 = r6.zzg
            r7.zzc(r4)
        L_0x00aa:
            return r5
        L_0x00ab:
            com.google.android.gms.internal.consent_sdk.zzay r7 = r6.zzg
            r7.zze()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzbm.zzb(java.lang.String, org.json.JSONObject):boolean");
    }

    public final /* synthetic */ void zzc() {
        String str;
        Application application = this.zza;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", application.getPackageManager().getApplicationLabel(application.getApplicationInfo()).toString());
            Drawable applicationIcon = application.getPackageManager().getApplicationIcon(application.getApplicationInfo());
            if (applicationIcon == null) {
                str = null;
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                String valueOf = String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                str = valueOf.length() != 0 ? "data:image/png;base64,".concat(valueOf) : new String("data:image/png;base64,");
            }
            jSONObject.put("app_icon", str);
            jSONObject.put("stored_infos_map", this.zzh.zzb());
        } catch (JSONException unused) {
        }
        this.zzg.zza().zzb("UMP_configureFormWithAppAssets", jSONObject.toString());
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        String valueOf = String.valueOf(str);
        Log.d("UserMessagingPlatform", valueOf.length() != 0 ? "Receive consent action: ".concat(valueOf) : new String("Receive consent action: "));
        Uri parse = Uri.parse(str);
        this.zze.zzb(parse.getQueryParameter("action"), parse.getQueryParameter("args"), this, this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final void zze(int i, String str, String str2) {
        this.zzg.zzf(new zzj(2, String.format(Locale.US, "WebResourceError(%d, %s): %s", new Object[]{Integer.valueOf(i), str2, str})));
    }
}
