package com.shix.shixipc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.shix.shixipc.bean.WifiModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import shix.cykj.camera.R;

public class WifiScanListAdapter extends BaseAdapter {
    private Context context;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private List<WifiModel> list = new ArrayList();

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
        WifiModel wifiModel = this.list.get(i);
        this.holder.ssid.setText(wifiModel.getSsid());
        TextView textView = this.holder.signal;
        textView.setText(wifiModel.getSignal() + "%");
        int encryption = wifiModel.getEncryption();
        if (encryption != 0) {
            str = encryption != 1 ? encryption != 2 ? encryption != 3 ? encryption != 4 ? encryption != 5 ? "" : "WPA2_PSK(TKIP)" : "WPA2_PSK(AES)" : "WPA_PSK(TKIP)" : "WPA_PSK(AES)" : "WEP";
        } else {
            str = this.context.getResources().getString(R.string.wifi_no_safe);
        }
        this.holder.safe.setText(str);
        return view;
    }

    public void updateList(List<WifiModel> list2) {
        this.list.clear();
        this.list.addAll(list2);
        notifyDataSetChanged();
    }

    public void wifiSort() {
        Collections.sort(this.list, new Comparator<WifiModel>() {
            public int compare(WifiModel wifiModel, WifiModel wifiModel2) {
                return wifiModel.getSignal() < wifiModel2.getSignal() ? 1 : -1;
            }
        });
    }

    public void addWifiScan(WifiModel wifiModel) {
        this.list.add(wifiModel);
    }

    public void clearWifi() {
        List<WifiModel> list2 = this.list;
        if (list2 != null) {
            list2.clear();
        }
    }

    public WifiModel getWifiScan(int i) {
        return this.list.get(i);
    }

    public List<WifiModel> getWifiScanBeans() {
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
