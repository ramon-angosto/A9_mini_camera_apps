package com.tzh.ipcamera.view.adapter;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import java.util.List;

public class WiFiAdapter extends BaseAdapter {
    private Context mContext = null;
    private LayoutInflater mInflater = null;
    public ViewHolder mViewHolder = null;
    private List<ScanResult> wifiList = new ArrayList();

    public long getItemId(int i) {
        return (long) i;
    }

    public WiFiAdapter(Context context, List<ScanResult> list) {
        this.mContext = context;
        this.wifiList = list;
        this.mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.wifiList.size();
    }

    public Object getItem(int i) {
        return this.wifiList.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.mViewHolder = new ViewHolder();
            view = this.mInflater.inflate(R.layout.wifiadapter, (ViewGroup) null);
            this.mViewHolder.tvBleName = (TextView) view.findViewById(R.id.fileNameTxt);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.height = (int) this.mContext.getResources().getDimension(R.dimen.heigth_1);
            view.setLayoutParams(layoutParams);
            view.setTag(this.mViewHolder);
        } else {
            this.mViewHolder = (ViewHolder) view.getTag();
        }
        this.mViewHolder.tvBleName.setText(this.wifiList.get(i).SSID);
        return view;
    }

    private class ViewHolder {
        public TextView tvBleName;

        private ViewHolder() {
            this.tvBleName = null;
        }
    }
}
