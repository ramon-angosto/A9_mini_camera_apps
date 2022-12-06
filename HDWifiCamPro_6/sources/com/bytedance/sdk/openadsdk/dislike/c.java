package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.dislike.d;
import java.util.List;

/* compiled from: TTAdDislikeImpl */
public class c implements TTAdDislike {
    private final Context a;
    private d b;
    /* access modifiers changed from: private */
    public TTAdDislike.DislikeInteractionCallback c;

    public c(Context context, String str, List<FilterWord> list) {
        if (!(context instanceof Activity)) {
            l.d("Dislike Initialization must use activity, please pass in TTAdManager.createAdNative(activity)");
        }
        this.a = context;
        b(str, list);
    }

    private void b(String str, List<FilterWord> list) {
        this.b = new d(this.a, str, list);
        this.b.a((d.a) new d.a() {
            public void a() {
                l.b("TTAdDislikeImpl", "onDislikeShow: ");
            }

            public void a(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions() && c.this.c != null) {
                        c.this.c.onSelected(i, filterWord.getName());
                    }
                    l.e("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + String.valueOf(filterWord.getName()));
                } catch (Throwable th) {
                    l.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            public void b() {
                l.e("TTAdDislikeImpl", "onDislikeDismiss: ");
                try {
                    if (c.this.c != null) {
                        c.this.c.onCancel();
                    }
                } catch (Throwable th) {
                    l.c("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            public void c() {
                l.e("TTAdDislikeImpl", "onDislikeOptionBack: ");
            }
        });
    }

    public void showDislikeDialog() {
        Context context = this.a;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.b.isShowing()) {
            this.b.show();
        }
    }

    public void a(String str, List<FilterWord> list) {
        this.b.a(str, list);
    }

    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.c = dislikeInteractionCallback;
    }

    public void a(String str) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(str);
        }
    }
}
