package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import java.util.List;

public abstract class TTDislikeDialogAbstract extends Dialog {
    private View a;
    private String b;
    private List<FilterWord> c;

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public TTDislikeDialogAbstract(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
        if (this.a != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.a;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            a();
            return;
        }
        throw new IllegalArgumentException("getLayoutId,layout id may be abnormal, please check");
    }

    private void a() {
        if (this.c != null && this.a != null) {
            int[] tTDislikeListViewIds = getTTDislikeListViewIds();
            if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
                throw new IllegalArgumentException("The options list of dislike is empty, please set TTDislikeListView");
            }
            int length = tTDislikeListViewIds.length;
            int i = 0;
            while (i < length) {
                View findViewById = this.a.findViewById(tTDislikeListViewIds[i]);
                if (findViewById == null) {
                    throw new IllegalArgumentException("getTTDislikeListViewIds can not find view by Id,please check");
                } else if (findViewById instanceof TTDislikeListView) {
                    ((TTDislikeListView) findViewById).setMaterialMeta(this.b);
                    i++;
                } else {
                    throw new IllegalArgumentException("getTTDislikeListViewIds can not find view by Id , please check");
                }
            }
        }
    }

    public void setMaterialMeta(String str, List<FilterWord> list) {
        this.b = str;
        this.c = list;
        a();
    }
}
