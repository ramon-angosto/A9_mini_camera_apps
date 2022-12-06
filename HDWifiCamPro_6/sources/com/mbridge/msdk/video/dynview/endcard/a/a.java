package com.mbridge.msdk.video.dynview.endcard.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExposeMonitor */
public final class a {
    private b a;
    private boolean b = true;
    private RecyclerView c;
    private boolean d = false;
    private List<Integer> e = new ArrayList();

    public final void a(RecyclerView recyclerView, b bVar) {
        this.a = bVar;
        this.c = recyclerView;
        RecyclerView recyclerView2 = this.c;
        if (recyclerView2 != null && recyclerView2.getVisibility() == 0) {
            this.c.addOnScrollListener(new RecyclerView.OnScrollListener() {
            });
        }
    }

    public final void a() {
        RecyclerView recyclerView = this.c;
        if (recyclerView != null) {
            recyclerView.removeAllViews();
            this.c = null;
        }
        List<Integer> list = this.e;
        if (list != null) {
            list.clear();
        }
        if (this.a != null) {
            this.a = null;
        }
    }
}
