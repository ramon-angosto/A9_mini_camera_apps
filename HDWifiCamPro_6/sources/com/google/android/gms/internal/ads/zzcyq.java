package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcyq extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcyq(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcyq zza(Context context, View view, zzfdk zzfdk) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcyq zzcyq = new zzcyq(context);
        if (!(zzfdk.zzv.isEmpty() || (resources = zzcyq.zza.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzfdl zzfdl = (zzfdl) zzfdk.zzv.get(0);
            zzcyq.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzfdl.zza) * displayMetrics.density), (int) (((float) zzfdl.zzb) * displayMetrics.density)));
        }
        zzcyq.zzb = view;
        zzcyq.addView(view);
        zzt.zzx();
        zzchp.zzb(zzcyq, zzcyq);
        zzt.zzx();
        zzchp.zza(zzcyq, zzcyq);
        JSONObject jSONObject = zzfdk.zzaj;
        RelativeLayout relativeLayout = new RelativeLayout(zzcyq.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            zzcyq.zzc(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzcyq.zzc(optJSONObject2, relativeLayout, 12);
        }
        zzcyq.addView(relativeLayout);
        return zzcyq;
    }

    private final int zzb(double d) {
        zzaw.zzb();
        return zzcgi.zzw(this.zza, (int) d);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT, ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb2 = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, zzb2, 0, zzb2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }
}
