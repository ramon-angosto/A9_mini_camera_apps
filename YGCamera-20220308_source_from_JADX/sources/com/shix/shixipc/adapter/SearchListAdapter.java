package com.shix.shixipc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import shix.cykj.camera.R;

public class SearchListAdapter extends BaseAdapter {
    private static final String LOG_TAG = "SearchListAdapter";
    private Context context = null;
    private LayoutInflater listContainer = null;
    private List<Map<String, Object>> listItems = new ArrayList();

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final class SearchListItem {
        public TextView devID;
        public TextView devName;
        public TextView tvshow;

        public SearchListItem() {
        }
    }

    public void setListItems(List<Map<String, Object>> list) {
        this.listItems = list;
    }

    public SearchListAdapter(Context context2) {
        this.context = context2;
        this.listContainer = LayoutInflater.from(context2);
    }

    public int getCount() {
        return this.listItems.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        SearchListItem searchListItem;
        String str;
        if (view == null) {
            searchListItem = new SearchListItem();
            view2 = this.listContainer.inflate(R.layout.search_list_item, (ViewGroup) null);
            searchListItem.devName = (TextView) view2.findViewById(R.id.searchDevName);
            searchListItem.devID = (TextView) view2.findViewById(R.id.searchDevID);
            searchListItem.tvshow = (TextView) view2.findViewById(R.id.showTv);
            view2.setTag(searchListItem);
        } else {
            view2 = view;
            searchListItem = (SearchListItem) view.getTag();
        }
        searchListItem.devName.setText((String) this.listItems.get(i).get(ContentCommon.STR_CAMERA_NAME));
        searchListItem.devID.setText((String) this.listItems.get(i).get(ContentCommon.STR_CAMERA_ID));
        if (checkDID((String) this.listItems.get(i).get(ContentCommon.STR_CAMERA_ID))) {
            str = this.context.getResources().getString(R.string.sertch_add);
            searchListItem.tvshow.setTextColor(this.context.getResources().getColor(R.color.color_main));
        } else {
            str = this.context.getResources().getString(R.string.sertch_noadd);
            searchListItem.tvshow.setTextColor(this.context.getResources().getColor(R.color.color_main));
        }
        searchListItem.tvshow.setText(str);
        return view2;
    }

    public boolean AddCamera(String str, String str2, String str3) {
        if (!CheckCameraInfo(str3)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ContentCommon.STR_CAMERA_MAC, str);
        hashMap.put(ContentCommon.STR_CAMERA_NAME, str2);
        hashMap.put(ContentCommon.STR_CAMERA_ID, str3);
        this.listItems.add(hashMap);
        return true;
    }

    public boolean checkDID(String str) {
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (SystemValue.arrayList.get(i).getDev_Did().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean CheckCameraInfo(String str) {
        int size = this.listItems.size();
        for (int i = 0; i < size; i++) {
            if (str.equals((String) this.listItems.get(i).get(ContentCommon.STR_CAMERA_ID))) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Object> getItemContent(int i) {
        if (i > this.listItems.size()) {
            return null;
        }
        return this.listItems.get(i);
    }

    public void ClearAll() {
        this.listItems.clear();
    }
}
