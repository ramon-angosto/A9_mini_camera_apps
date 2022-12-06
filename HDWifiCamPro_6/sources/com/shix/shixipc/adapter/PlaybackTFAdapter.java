package com.shix.shixipc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.shix.qhipc.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaybackTFAdapter extends BaseExpandableListAdapter {
    private Map<String, List<String>> childMap = new HashMap();
    private List<String> groupList = new ArrayList();
    private LayoutInflater inflater;

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public PlaybackTFAdapter(Context context) {
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public Object getChild(int i, int i2) {
        return this.childMap.get(this.groupList.get(i)).get(i2);
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        CViewHolder cViewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.playbacktf_childlistitem, (ViewGroup) null);
            cViewHolder = new CViewHolder();
            cViewHolder.content = (TextView) view.findViewById(R.id.tv_datetime);
            view.setTag(cViewHolder);
        } else {
            cViewHolder = (CViewHolder) view.getTag();
        }
        cViewHolder.content.setText((String) this.childMap.get(this.groupList.get(i)).get(i2));
        return view;
    }

    public int getChildrenCount(int i) {
        return this.childMap.get(this.groupList.get(i)).size();
    }

    public Object getGroup(int i) {
        return this.groupList.get(i);
    }

    public int getGroupCount() {
        return this.groupList.size();
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View view2;
        GViewHolder gViewHolder;
        if (view == null) {
            gViewHolder = new GViewHolder();
            view2 = this.inflater.inflate(R.layout.playbacktf_grouplistitem, (ViewGroup) null);
            gViewHolder.tvdate = (TextView) view2.findViewById(R.id.tv_date);
            gViewHolder.tvsum = (TextView) view2.findViewById(R.id.tv_sum);
            gViewHolder.img = (ImageView) view2.findViewById(R.id.img);
            view2.setTag(gViewHolder);
        } else {
            view2 = view;
            gViewHolder = (GViewHolder) view.getTag();
        }
        if (z) {
            gViewHolder.img.setImageResource(R.mipmap.arrowdown);
        } else {
            gViewHolder.img.setImageResource(R.mipmap.arrow);
        }
        String str = this.groupList.get(i);
        List list = this.childMap.get(str);
        gViewHolder.tvdate.setText(str);
        if (list != null) {
            gViewHolder.tvsum.setText(String.valueOf(list.size()));
        }
        return view2;
    }

    public void addGroupAndChild(String str, String str2) {
        if (!this.groupList.contains(str)) {
            this.groupList.add(str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            this.childMap.put(str, arrayList);
            return;
        }
        this.childMap.get(str).add(str2);
    }

    public String getChildFilePath(int i, int i2) {
        return (String) this.childMap.get(this.groupList.get(i)).get(i2);
    }

    public String delChildFilePath(int i, int i2) {
        return (String) this.childMap.get(this.groupList.get(i)).remove(i2);
    }

    public String[] getGroupTitleAndSum(int i) {
        String str = this.groupList.get(i);
        return new String[]{str, String.valueOf(this.childMap.get(str).size())};
    }

    private class GViewHolder {
        ImageView img;
        TextView tvdate;
        TextView tvsum;

        private GViewHolder() {
        }
    }

    private class CViewHolder {
        TextView content;

        private CViewHolder() {
        }
    }
}
