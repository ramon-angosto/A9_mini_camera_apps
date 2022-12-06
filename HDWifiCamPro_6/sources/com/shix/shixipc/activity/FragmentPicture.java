package com.shix.shixipc.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.adapter.AlarmActivityAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import object.p2pipcam.nativecaller.NativeCaller;

public class FragmentPicture extends BaseFragment implements AdapterView.OnItemClickListener {
    private MyStatusBroadCast broadcast;
    /* access modifiers changed from: private */
    public AlarmActivityAdapter listAdapter;
    /* access modifiers changed from: private */
    public ListView listView;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_alarm, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.toptitle)).setText(R.string.ipc_manager_pic);
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
    }

    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(this.broadcast);
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
            }
            Intent intent = new Intent();
            intent.setClass(getActivity(), LocalPictureActivity.class);
            intent.putExtra("type", 0);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, itemCam.getDev_Did());
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, itemCam.getDev_name());
            startActivity(intent);
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
                FragmentPicture.this.listAdapter.notifyDataSetChanged();
            }
            if ("del_add_modify_camera".equals(action)) {
                int intExtra = intent.getIntExtra("type", 0);
                intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
                if (!(intExtra == 1 || intExtra == 2)) {
                }
                if (SystemValue.arrayList.size() == 0) {
                    FragmentPicture.this.listView.setVisibility(8);
                } else {
                    FragmentPicture.this.listView.setVisibility(0);
                }
                FragmentPicture.this.listAdapter.notifyDataSetChanged();
            }
        }
    }
}
