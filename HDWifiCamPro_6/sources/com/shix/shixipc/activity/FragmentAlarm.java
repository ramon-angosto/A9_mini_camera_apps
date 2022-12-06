package com.shix.shixipc.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.adapter.AlarmActivityAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import object.p2pipcam.nativecaller.NativeCaller;

public class FragmentAlarm extends BaseFragment implements AdapterView.OnItemClickListener {
    private MyStatusBroadCast broadcast;
    /* access modifiers changed from: private */
    public AlarmActivityAdapter listAdapter;
    /* access modifiers changed from: private */
    public ListView listView;
    private WifiManager mWifiManager;
    String nowssid;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_alarm, viewGroup, false);
        this.listView = (ListView) inflate.findViewById(R.id.listviewCamera);
        this.listAdapter = new AlarmActivityAdapter(getActivity(), SystemValue.arrayList);
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(this);
        this.broadcast = new MyStatusBroadCast();
        IntentFilter intentFilter = new IntentFilter("camera_status_change");
        intentFilter.addAction("del_add_modify_camera");
        getActivity().registerReceiver(this.broadcast, intentFilter);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        this.listAdapter.notifyDataSetChanged();
        this.nowssid = getWifiSSID();
    }

    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(this.broadcast);
    }

    private String getWifiSSID() {
        this.mWifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService("wifi");
        if (!this.mWifiManager.isWifiEnabled()) {
            return "";
        }
        String ssid = this.mWifiManager.getConnectionInfo().getSSID();
        return (!ssid.startsWith("\"") || !ssid.endsWith("\"")) ? ssid : ssid.substring(1, ssid.length() - 1);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10);
        }
        CameraParamsBean itemCam = this.listAdapter.getItemCam(i);
        if (itemCam.getDev_p2pstatus() != 2 || !checkChina(itemCam.getDev_Did(), itemCam.getResetrict())) {
            String dev_Did = itemCam.getDev_Did();
            itemCam.getDev_name();
            int dev_p2pstatus = itemCam.getDev_p2pstatus();
            if (dev_p2pstatus == 5 || dev_p2pstatus == 7 || dev_p2pstatus == 6 || dev_p2pstatus == 3 || dev_p2pstatus == 4) {
                String dev_User = itemCam.getDev_User();
                String dev_Pwd = itemCam.getDev_Pwd();
                NativeCaller.StopPPPP(dev_Did);
                StartPPPP(dev_Did, dev_User, dev_Pwd, ContentCommon.SERVER_STRING);
            } else if (dev_p2pstatus == 2) {
                String str = this.nowssid;
                if (str == null || (!str.startsWith(ContentCommon.SHIX_APPRE) && !this.nowssid.startsWith(ContentCommon.SHIX_APPRE2) && !this.nowssid.startsWith(ContentCommon.SHIX_APPRE3) && !this.nowssid.startsWith(ContentCommon.SHIX_APPRE4))) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), ClouDateActivity.class);
                    intent.putExtra(ContentCommon.STR_CAMERA_ID, itemCam.getDev_Did());
                    intent.putExtra(ContentCommon.STR_CAMERA_NAME, itemCam.getDev_name());
                    startActivity(intent);
                    return;
                }
                showToast((int) R.string.show_ap_notify);
            }
        }
    }

    private class MyStatusBroadCast extends BroadcastReceiver {
        private MyStatusBroadCast() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("camera_status_change".equals(action)) {
                intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
                intent.getIntExtra(ContentCommon.STR_PPPP_STATUS, -1);
                FragmentAlarm.this.listAdapter.notifyDataSetChanged();
            }
            if ("del_add_modify_camera".equals(action)) {
                int intExtra = intent.getIntExtra("type", 0);
                intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
                if (!(intExtra == 1 || intExtra == 2)) {
                }
                if (SystemValue.arrayList.size() == 0) {
                    FragmentAlarm.this.listView.setVisibility(8);
                } else {
                    FragmentAlarm.this.listView.setVisibility(0);
                }
                FragmentAlarm.this.listAdapter.notifyDataSetChanged();
            }
        }
    }
}
