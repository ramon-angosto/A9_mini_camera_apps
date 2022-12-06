package object.p2pipcam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import object.p2pipcam.bean.WifiScanBean;

public class WifiScanListAdapter extends BaseAdapter {
    private Context context;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private ArrayList<WifiScanBean> list = new ArrayList<>();

    public long getItemId(int i) {
        return (long) i;
    }

    public WifiScanListAdapter(Context context2) {
        this.context = context2;
        this.inflater = LayoutInflater.from(context2);
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        if (view == null) {
            view = this.inflater.inflate(R.layout.settingwifi_list_item, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.ssid = (TextView) view.findViewById(R.id.ssid);
            this.holder.safe = (TextView) view.findViewById(R.id.wifi_scan_listitem_tv_safe);
            this.holder.signal = (TextView) view.findViewById(R.id.wifi_scan_listitem_tv_signal_strong);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        if (this.list.size() == 0) {
            view.setBackgroundResource(R.drawable.listitem_one_pressed_selector);
        } else if (i == 0) {
            view.setBackgroundResource(R.drawable.listitem_pressed_top_corner_selector);
        } else if (i == this.list.size() - 1) {
            view.setBackgroundResource(R.drawable.listitem_pressed_bottom_corner_selector);
        } else {
            view.setBackgroundResource(R.drawable.listitem_pressed_selector);
        }
        WifiScanBean wifiScanBean = this.list.get(i);
        this.holder.ssid.setText(wifiScanBean.getSsid());
        TextView textView = this.holder.signal;
        textView.setText(wifiScanBean.getDbm0() + "%");
        int security = wifiScanBean.getSecurity();
        if (security != 0) {
            str = security != 1 ? security != 2 ? security != 3 ? security != 4 ? security != 5 ? "" : "WPA2_PSK(TKIP)" : "WPA2_PSK(AES)" : "WPA_PSK(TKIP)" : "WPA_PSK(AES)" : "WEP";
        } else {
            str = this.context.getResources().getString(R.string.wifi_no_safe);
        }
        this.holder.safe.setText(str);
        return view;
    }

    public void wifiSort() {
        Collections.sort(this.list, new Comparator<WifiScanBean>() {
            public int compare(WifiScanBean wifiScanBean, WifiScanBean wifiScanBean2) {
                return wifiScanBean.getDbm0() < wifiScanBean2.getDbm0() ? 1 : -1;
            }
        });
    }

    public void addWifiScan(WifiScanBean wifiScanBean) {
        this.list.add(wifiScanBean);
    }

    public void clearWifi() {
        this.list.clear();
    }

    public WifiScanBean getWifiScan(int i) {
        return this.list.get(i);
    }

    public ArrayList<WifiScanBean> getWifiScanBeans() {
        return this.list;
    }

    private class ViewHolder {
        TextView safe;
        TextView signal;
        TextView ssid;

        private ViewHolder() {
        }
    }
}
