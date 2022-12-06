package com.huawei.android.pushselfshow.richpush.favorites;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.a.c;
import com.huawei.android.pushselfshow.utils.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class a extends BaseAdapter {
    private Context a;
    private boolean b = true;
    private boolean c = false;
    private List d = new ArrayList();

    /* renamed from: com.huawei.android.pushselfshow.richpush.favorites.a$a  reason: collision with other inner class name */
    private static class C0038a {
        ImageView a;
        TextView b;
        TextView c;
        CheckBox d;

        private C0038a() {
        }
    }

    public a(Context context) {
        this.a = context;
    }

    /* renamed from: a */
    public f getItem(int i) {
        return (f) this.d.get(i);
    }

    public List a() {
        return this.d;
    }

    public void a(int i, f fVar) {
        try {
            if (this.d.size() >= i) {
                this.d.set(i, fVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(boolean z) {
        this.b = z;
        notifyDataSetChanged();
    }

    public void a(boolean z, Set set) {
        this.c = z;
        int i = 0;
        for (f fVar : this.d) {
            if (set == null || !set.contains(Integer.valueOf(i))) {
                fVar.a(z);
            } else {
                fVar.a(!z);
            }
            a(i, fVar);
            i++;
        }
        notifyDataSetChanged();
    }

    public void b() {
        this.d = c.a(this.a, (String) null);
    }

    public int getCount() {
        return this.d.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0038a aVar;
        if (view == null) {
            try {
                aVar = new C0038a();
                view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(d.c(this.a, "hwpush_collection_item"), (ViewGroup) null);
                aVar.a = (ImageView) view.findViewById(d.d(this.a, "hwpush_favicon"));
                aVar.b = (TextView) view.findViewById(d.d(this.a, "hwpush_selfshowmsg_title"));
                aVar.c = (TextView) view.findViewById(d.d(this.a, "hwpush_selfshowmsg_content"));
                aVar.d = (CheckBox) view.findViewById(d.d(this.a, "hwpush_delCheck"));
                view.setTag(aVar);
            } catch (Exception e) {
                e.b("PushSelfShowLog", e.toString());
            }
        } else {
            aVar = (C0038a) view.getTag();
        }
        Bitmap d2 = ((f) this.d.get(i)).d();
        if (d2 == null) {
            d2 = BitmapFactory.decodeResource(this.a.getResources(), d.f(this.a, "hwpush_list_icon"));
        }
        aVar.a.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), d2));
        String str = ((f) this.d.get(i)).b().r;
        if (str != null && str.length() > 0) {
            aVar.b.setText(str);
        }
        String str2 = ((f) this.d.get(i)).b().p;
        if (str2 != null && str2.length() > 0) {
            aVar.c.setText(str2);
        }
        if (this.b) {
            aVar.d.setVisibility(4);
        } else {
            aVar.d.setVisibility(0);
            if (!this.c) {
                if (!((f) this.d.get(i)).a()) {
                    aVar.d.setChecked(false);
                }
            }
            aVar.d.setChecked(true);
        }
        return view;
    }
}
