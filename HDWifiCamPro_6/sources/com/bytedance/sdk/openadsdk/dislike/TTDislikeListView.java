package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.core.bannerexpress.a;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.ArrayList;
import java.util.List;

public class TTDislikeListView extends ListView {
    protected IListenerManager a;
    /* access modifiers changed from: private */
    public AdapterView.OnItemClickListener b;
    /* access modifiers changed from: private */
    public String c;
    /* access modifiers changed from: private */
    public String d;
    private AdapterView.OnItemClickListener e = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i) == null || !(TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                throw new IllegalArgumentException("Adapter data is abnormal, it must be FilterWord");
            }
            FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
            if (!filterWord.hasSecondOptions()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(filterWord);
                if (!TextUtils.isEmpty(TTDislikeListView.this.c)) {
                    c.a(TTDislikeListView.this.c, (List<FilterWord>) arrayList);
                }
                if (!TextUtils.isEmpty(TTDislikeListView.this.d)) {
                    if (b.c()) {
                        TTDislikeListView.this.a("onItemClickClosed");
                    } else {
                        a.C0044a e = h.d().e(TTDislikeListView.this.d);
                        if (e != null) {
                            e.a();
                            h.d().f(TTDislikeListView.this.d);
                        }
                    }
                }
            }
            try {
                if (TTDislikeListView.this.b != null) {
                    TTDislikeListView.this.b.onItemClick(adapterView, view, i, j);
                }
            } catch (Throwable unused) {
            }
        }
    };

    public TTDislikeListView(Context context) {
        super(context);
        a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void setMaterialMeta(String str) {
        this.c = str;
    }

    private void a() {
        super.setOnItemClickListener(this.e);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.b = onItemClickListener;
    }

    public void setClosedListenerKey(String str) {
        this.d = str;
    }

    /* access modifiers changed from: private */
    public void a(final String str) {
        e.c(new g("Reward_executeMultiProcessCallback") {
            public void run() {
                try {
                    if (!TextUtils.isEmpty(TTDislikeListView.this.d)) {
                        TTDislikeListView.this.a(6).executeDisLikeClosedCallback(TTDislikeListView.this.d, str);
                    }
                } catch (Throwable th) {
                    l.c("TTDislikeListView", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* access modifiers changed from: protected */
    public IListenerManager a(int i) {
        if (this.a == null) {
            this.a = com.bytedance.sdk.openadsdk.multipro.aidl.a.a.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(m.a()).a(i));
        }
        return this.a;
    }

    public static void a(final int i, final String str, final a.C0044a aVar) {
        if (b.c()) {
            e.c(new g("DislikeClosed_registerMultiProcessListener") {
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(m.a());
                    if (i == 6 && aVar != null) {
                        try {
                            l.b("TTDislikeListView", "start registerDislikeClickCloseListener ! ");
                            com.bytedance.sdk.openadsdk.multipro.aidl.b.b bVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.b(str, aVar);
                            IListenerManager asInterface = d.asInterface(a2.a(6));
                            if (asInterface != null) {
                                asInterface.registerDisLikeClosedListener(str, bVar);
                                l.b("TTDislikeListView", "end registerDislikeClickCloseListener ! ");
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            l.b("TTDislikeListView", "multiProcess registerDislikeClickCloseListener error");
                        }
                    }
                }
            }, 5);
        }
    }

    public static void a(final int i, final String str) {
        if (b.c()) {
            e.c(new g("DislikeClosed_unregisterMultiProcessListener") {
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(m.a());
                    if (i == 6) {
                        try {
                            l.b("TTDislikeListView", "start unregisterDislikeClickCloseListener ! ");
                            IListenerManager asInterface = d.asInterface(a2.a(6));
                            if (asInterface != null) {
                                asInterface.unregisterDisLikeClosedListener(str);
                                l.b("TTDislikeListView", "end unregisterDislikeClickCloseListener ! ");
                            }
                        } catch (RemoteException unused) {
                            l.b("TTDislikeListView", "multiProcess unregisterMultiProcessListener error");
                        }
                    }
                }
            }, 5);
        }
    }
}
