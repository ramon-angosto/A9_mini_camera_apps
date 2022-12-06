package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.tool.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TTDelegateActivity extends Activity {
    /* access modifiers changed from: private */
    public static final Map<String, b> d = Collections.synchronizedMap(new HashMap());
    private Intent a;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.widget.b b;
    private TTAdDislike c;

    public static void a() {
        Intent intent = new Intent(m.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 5);
        if (m.a() != null) {
            m.a().startActivity(intent);
        }
    }

    public static void a(n nVar, String str, b bVar) {
        if (nVar != null) {
            Intent intent = new Intent(m.a(), TTDelegateActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("type", 6);
            intent.putExtra("ext_info", nVar.ac());
            intent.putExtra("filter_words", a.a(nVar.ae()));
            intent.putExtra("closed_listener_key", str);
            if (bVar != null) {
                d.put(str, bVar);
            }
            if (m.a() != null) {
                m.a().startActivity(intent);
            }
        }
    }

    public static void a(n nVar, String str) {
        a(nVar, str, (b) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!PAGSdk.isInitSuccess()) {
            finish();
        }
        c();
        this.a = getIntent();
        if (m.a() == null) {
            m.a(this);
        }
    }

    private void c() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (m.a() == null) {
            m.a(this);
        }
        setIntent(intent);
        this.a = intent;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            d();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.b != null && this.b.isShowing()) {
                this.b.dismiss();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    private void d() {
        int intExtra = this.a.getIntExtra("type", 0);
        if (intExtra == 1) {
            return;
        }
        if (intExtra == 5) {
            e();
        } else if (intExtra != 6) {
            finish();
        } else {
            a(this.a.getStringExtra("ext_info"), this.a.getStringExtra("filter_words"), this.a.getStringExtra("closed_listener_key"));
        }
    }

    private void a(String str, String str2, final String str3) {
        if (!(str2 == null || str == null || this.c != null)) {
            this.c = new c(this, str, a.a(str2));
            ((c) this.c).a(str3);
            this.c.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() {
                public void onSelected(int i, String str) {
                    b bVar;
                    l.c("showDislike", "closedListenerKey=" + str3 + ",onSelected->position=" + i + ",value=" + str);
                    if (TTDelegateActivity.d != null && TTDelegateActivity.d.size() > 0 && !TextUtils.isEmpty(str3) && (bVar = (b) TTDelegateActivity.d.get(str3)) != null) {
                        bVar.a(i, str);
                    }
                    TTDelegateActivity.this.a(str3);
                    TTDelegateActivity.this.finish();
                }

                public void onCancel() {
                    TTDelegateActivity.this.a(str3);
                    TTDelegateActivity.this.finish();
                }

                public void onRefuse() {
                    l.c("showDislike", "onRefuse->onRefuse....");
                }
            });
        }
        TTAdDislike tTAdDislike = this.c;
        if (tTAdDislike != null) {
            tTAdDislike.showDislikeDialog();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        l.c("showDislike", "removeDislikeListener....closedListenerKey=" + str);
        if (d != null && !TextUtils.isEmpty(str)) {
            d.remove(str);
            if (l.d()) {
                l.c("showDislike", "removeDislikeListener....mListenerMap.size:" + d.size());
            }
        }
    }

    private void e() {
        if (this.b == null) {
            this.b = new com.bytedance.sdk.openadsdk.core.widget.b(this);
            this.b.a(t.a(this, "no_thank_you"), (b.C0051b) new b.C0051b() {
                public void a() {
                    TTAdSdk.setGdpr(0);
                    if (TTDelegateActivity.this.b.isShowing()) {
                        TTDelegateActivity.this.b.dismiss();
                    }
                    TTDelegateActivity.this.finish();
                }
            }).a(t.a(this, "yes_i_agree"), (b.c) new b.c() {
                public void a() {
                    TTAdSdk.setGdpr(1);
                    if (TTDelegateActivity.this.b.isShowing()) {
                        TTDelegateActivity.this.b.dismiss();
                    }
                    TTDelegateActivity.this.finish();
                }
            });
        }
        if (!this.b.isShowing()) {
            this.b.show();
        }
    }
}
