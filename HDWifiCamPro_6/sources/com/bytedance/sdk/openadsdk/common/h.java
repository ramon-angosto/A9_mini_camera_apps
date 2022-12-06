package com.bytedance.sdk.openadsdk.common;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TTPrivacyAdReportDialog */
public class h extends Dialog {
    /* access modifiers changed from: private */
    public static final String[] b = {"SDK version", "App", "App version", "OS", "Device", "Creative info"};
    private Handler a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public String c = "";
    /* access modifiers changed from: private */
    public TextView d;

    public h(Context context) {
        super(context, t.g(context, "tt_privacy_dialog_theme_ad_report"));
    }

    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.c = a.a(new JSONObject(str)).toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(LayoutInflater.from(getContext()).inflate(t.f(getContext(), "tt_ad_report_info"), (ViewGroup) null), new ViewGroup.LayoutParams(z.c(getContext()), (int) (((double) z.d(getContext())) * 0.9d)));
        b();
        if (getWindow() != null) {
            getWindow().setGravity(80);
        }
    }

    private void b() {
        this.d = (TextView) findViewById(t.e(getContext(), "tt_ad_report_creative_info"));
        final String e = y.e();
        final String g = y.g();
        final String str = "Android " + Build.VERSION.RELEASE;
        final String str2 = Build.BRAND + " " + Build.MODEL;
        ((TextView) findViewById(t.e(getContext(), "tt_ad_report_sdk_version"))).setText(BuildConfig.VERSION_NAME);
        ((TextView) findViewById(t.e(getContext(), "tt_ad_report_app_package_name"))).setText(e);
        ((TextView) findViewById(t.e(getContext(), "tt_ad_report_app_version"))).setText(g);
        ((TextView) findViewById(t.e(getContext(), "tt_ad_report_os"))).setText(str);
        ((TextView) findViewById(t.e(getContext(), "tt_ad_report_device"))).setText(str2);
        this.d.setText("loading ...");
        ((Button) findViewById(t.e(getContext(), "tt_ad_report_copy_button"))).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) h.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null) {
                    StringBuilder sb = new StringBuilder("");
                    String[] strArr = {BuildConfig.VERSION_NAME, e, g, str, str2, h.this.c};
                    for (int i = 0; i < h.b.length; i++) {
                        sb.append(h.b[i]);
                        sb.append(": ");
                        sb.append(strArr[i]);
                        sb.append("\n");
                    }
                    try {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("pangle sdk build info", sb));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        ((ImageView) findViewById(t.e(getContext(), "tt_ad_report_close_button"))).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                h.this.d.setText("loading ...");
                h.this.cancel();
            }
        });
    }

    public void show() {
        super.show();
        this.a.postDelayed(new Runnable() {
            public void run() {
                h.this.d.setText(h.this.c);
            }
        }, 1000);
    }
}
