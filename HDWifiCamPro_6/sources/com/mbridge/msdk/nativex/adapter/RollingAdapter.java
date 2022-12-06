package com.mbridge.msdk.nativex.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.mbridge.msdk.nativex.view.MBNativeRollView;
import com.mbridge.msdk.out.Frame;
import java.util.ArrayList;
import java.util.List;

public class RollingAdapter extends PagerAdapter {
    private List<Frame> list = new ArrayList();
    private List<View> listview = new ArrayList();
    private MBNativeRollView.a mvinterface;

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public MBNativeRollView.a getMvinterface() {
        return this.mvinterface;
    }

    public void setMvinterface(MBNativeRollView.a aVar) {
        this.mvinterface = aVar;
    }

    public RollingAdapter(List<Frame> list2) {
        this.list = list2;
    }

    public int getCount() {
        return this.list.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        List<Frame> list2;
        View a;
        if (this.mvinterface == null || (list2 = this.list) == null || list2.size() <= 0 || (a = this.mvinterface.a(this.list.get(i), i)) == null) {
            return null;
        }
        this.listview.add(a);
        viewGroup.addView(a);
        return a;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.listview.get(i));
    }
}
