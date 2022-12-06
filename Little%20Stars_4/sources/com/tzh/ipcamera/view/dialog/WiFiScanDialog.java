package com.tzh.ipcamera.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.view.adapter.WiFiAdapter;
import com.tzh.ipcamera.view.delegate.IWifiListClickDelegate;
import java.util.List;

public class WiFiScanDialog extends Dialog implements AdapterView.OnItemClickListener {
    private ListView deviceList = null;
    private IWifiListClickDelegate listClickListener;
    private Context mContext = null;
    private WiFiAdapter mWifiAdapter = null;

    public WiFiScanDialog(Context context, int i, List<ScanResult> list, IWifiListClickDelegate iWifiListClickDelegate) {
        super(context, i);
        this.mContext = context;
        this.listClickListener = iWifiListClickDelegate;
        setContentView(R.layout.activity_wifi_scan);
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_wifi_scan, (ViewGroup) null);
        Window window = getWindow();
        window.setFlags(1024, 1024);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) context.getResources().getDimension(R.dimen.dialog_window_width);
        attributes.height = (int) context.getResources().getDimension(R.dimen.dialog_window_height);
        attributes.gravity = 17;
        setContentView(inflate, attributes);
        widget_init(list);
    }

    public void notifyDataSetChanged() {
        this.mWifiAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void widget_init(List<ScanResult> list) {
        this.deviceList = (ListView) findViewById(R.id.wifiList);
        this.mWifiAdapter = new WiFiAdapter(this.mContext, list);
        this.deviceList.setAdapter(this.mWifiAdapter);
        this.deviceList.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
        IWifiListClickDelegate iWifiListClickDelegate = this.listClickListener;
        if (iWifiListClickDelegate != null) {
            iWifiListClickDelegate.onItemClick(((ScanResult) this.mWifiAdapter.getItem(i)).SSID, i);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }
}
