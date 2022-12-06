package com.mbridge.msdk.video.dynview.i.a;

import android.graphics.Bitmap;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.video.dynview.b;
import com.mbridge.msdk.video.dynview.g.a;
import java.util.List;
import java.util.Map;

/* compiled from: ChoiceOneDrawBitBg */
public class a {
    private static volatile a a;
    private View b;
    private Bitmap c;
    private Bitmap d;

    private a() {
    }

    public static a a() {
        a aVar;
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public final void a(Map map, b bVar, View view) {
        Bitmap bitmap;
        List<CampaignEx> g;
        this.b = view;
        int e = bVar.e();
        float d2 = bVar.d();
        float c2 = bVar.c();
        if (map != null && map.size() > 1 && (g = bVar.g()) != null && g.size() > 1) {
            if (map.get(SameMD5.getMD5(g.get(0).getImageUrl())) != null && (map.get(SameMD5.getMD5(g.get(0).getImageUrl())) instanceof Bitmap)) {
                Bitmap bitmap2 = (Bitmap) map.get(SameMD5.getMD5(g.get(0).getImageUrl()));
                if (!(g.get(0) == null || bitmap2 == null || bitmap2.isRecycled())) {
                    this.c = com.mbridge.msdk.video.dynview.i.a.a().a(bitmap2, 0);
                }
            }
            if (map.get(SameMD5.getMD5(g.get(1).getImageUrl())) != null && (map.get(SameMD5.getMD5(g.get(1).getImageUrl())) instanceof Bitmap)) {
                Bitmap bitmap3 = (Bitmap) map.get(SameMD5.getMD5(g.get(1).getImageUrl()));
                if (g.get(1) != null && !bitmap3.isRecycled()) {
                    this.d = com.mbridge.msdk.video.dynview.i.a.a().a(bitmap3, 1);
                }
            }
        }
        Bitmap bitmap4 = this.c;
        if (bitmap4 != null && !bitmap4.isRecycled() && (bitmap = this.d) != null && !bitmap.isRecycled()) {
            a(e, d2, c2, this.c, this.d);
        }
    }

    private synchronized void a(int i, float f, float f2, Bitmap bitmap, Bitmap bitmap2) {
        a.C0104a a2 = com.mbridge.msdk.video.dynview.g.a.a();
        a2.a(i).a(bitmap).b(bitmap2);
        if (i != 2) {
            a2.a(f).b(f2);
        } else if (f > f2) {
            a2.a(f).b(f2);
        } else {
            a2.a(f2).b(f);
        }
        this.b.setBackground(a2.a());
    }

    public final void b() {
        if (this.b != null) {
            this.b = null;
        }
        Bitmap bitmap = this.c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
        Bitmap bitmap2 = this.d;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
    }
}
