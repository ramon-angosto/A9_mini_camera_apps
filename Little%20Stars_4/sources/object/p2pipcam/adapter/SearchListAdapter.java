package object.p2pipcam.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.system.SystemValue;

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

    public SearchListAdapter(Context context2) {
        this.context = context2;
        this.listContainer = LayoutInflater.from(context2);
    }

    public void setListItems(List<Map<String, Object>> list) {
        this.listItems = list;
    }

    public int getCount() {
        return this.listItems.size();
    }

    @SuppressLint({"ResourceAsColor"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        SearchListItem searchListItem;
        String str;
        if (view == null) {
            SearchListItem searchListItem2 = new SearchListItem();
            View inflate = this.listContainer.inflate(R.layout.search_list_item, (ViewGroup) null);
            searchListItem2.devName = (TextView) inflate.findViewById(R.id.searchDevName);
            searchListItem2.devID = (TextView) inflate.findViewById(R.id.searchDevID);
            searchListItem2.tvshow = (TextView) inflate.findViewById(R.id.showTv);
            inflate.setTag(searchListItem2);
            View view2 = inflate;
            searchListItem = searchListItem2;
            view = view2;
        } else {
            searchListItem = (SearchListItem) view.getTag();
        }
        view.setBackgroundResource(R.drawable.listitem_pressed_selector);
        searchListItem.devName.setText((String) this.listItems.get(i).get(ContentCommon.STR_CAMERA_NAME));
        searchListItem.devID.setText((String) this.listItems.get(i).get(ContentCommon.STR_CAMERA_ID));
        if (checkDID((String) this.listItems.get(i).get(ContentCommon.STR_CAMERA_ID))) {
            str = this.context.getResources().getString(R.string.sertch_add);
            searchListItem.tvshow.setTextColor(this.context.getResources().getColor(R.color.color_red));
        } else {
            str = this.context.getResources().getString(R.string.sertch_noadd);
        }
        searchListItem.tvshow.setText(str);
        return view;
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
            if (SystemValue.arrayList.get(i).getDid().equals(str)) {
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

    public final class SearchListItem {
        public TextView devID;
        public TextView devName;
        public TextView tvshow;

        public SearchListItem() {
        }
    }
}
