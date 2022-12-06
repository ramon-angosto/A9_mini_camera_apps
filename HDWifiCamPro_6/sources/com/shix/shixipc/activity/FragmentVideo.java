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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.adapter.AlarmActivityAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import object.p2pipcam.nativecaller.NativeCaller;

public class FragmentVideo extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    private Button bntPhone;
    private Button bntRemote;
    private MyStatusBroadCast broadcast;
    /* access modifiers changed from: private */
    public AlarmActivityAdapter listAdapter;
    /* access modifiers changed from: private */
    public ListView listView;
    private int tag = 0;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_video, viewGroup, false);
        this.listView = (ListView) inflate.findViewById(R.id.listviewCamera);
        this.listAdapter = new AlarmActivityAdapter(getActivity(), SystemValue.arrayList);
        this.bntPhone = (Button) inflate.findViewById(R.id.picture_phone);
        this.bntRemote = (Button) inflate.findViewById(R.id.picture_remote);
        this.bntPhone.setOnClickListener(this);
        this.bntRemote.setOnClickListener(this);
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(this);
        ((TextView) inflate.findViewById(R.id.toptitle)).setText(R.string.ipc_manager_locvideo);
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
            if (this.tag == 0) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), LocalPictureActivity.class);
                intent.putExtra("type", 1);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, itemCam.getDev_Did());
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, itemCam.getDev_name());
                startActivity(intent);
            } else if (dev_p2pstatus == 5 || dev_p2pstatus == 7 || dev_p2pstatus == 6 || dev_p2pstatus == 3 || dev_p2pstatus == 4) {
                String dev_User = itemCam.getDev_User();
                String dev_Pwd = itemCam.getDev_Pwd();
                NativeCaller.StopPPPP(dev_Did);
                StartPPPP(dev_Did, dev_User, dev_Pwd, ContentCommon.SERVER_STRING);
            } else {
                SystemValue.sysDevType = itemCam.getDevType();
                SystemValue.doorBellAdmin = itemCam.getDev_User();
                SystemValue.doorBellPass = itemCam.getDev_Pwd();
                if (CommonUtil.SHIX_isBkDid(dev_Did).booleanValue()) {
                    FragmentActivity activity = getActivity();
                    if (CommonUtil.GetCommonShareIntValue(activity, dev_Did + "isExistTf", 3) == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(getActivity(), ClouDateActivity.class);
                        intent2.putExtra(ContentCommon.STR_CAMERA_NAME, itemCam.getDev_name());
                        intent2.putExtra(ContentCommon.STR_CAMERA_ID, itemCam.getDev_Did());
                        intent2.putExtra(ContentCommon.STR_CAMERA_PWD, itemCam.getDev_Pwd());
                        intent2.putExtra(ContentCommon.STR_CAMERA_USER, itemCam.getDev_User());
                        startActivity(intent2);
                        return;
                    }
                    Intent intent3 = new Intent(getActivity(), TfFilesActivity.class);
                    intent3.putExtra(ContentCommon.STR_CAMERA_NAME, itemCam.getDev_name());
                    intent3.putExtra(ContentCommon.STR_CAMERA_ID, itemCam.getDev_Did());
                    intent3.putExtra(ContentCommon.STR_CAMERA_PWD, itemCam.getDev_Pwd());
                    intent3.putExtra(ContentCommon.STR_CAMERA_USER, itemCam.getDev_User());
                    startActivity(intent3);
                    return;
                }
                Intent intent4 = new Intent(getActivity(), PlayBackTFActivity.class);
                intent4.putExtra(ContentCommon.STR_CAMERA_NAME, itemCam.getDev_name());
                intent4.putExtra(ContentCommon.STR_CAMERA_ID, itemCam.getDev_Did());
                intent4.putExtra(ContentCommon.STR_CAMERA_PWD, itemCam.getDev_Pwd());
                intent4.putExtra(ContentCommon.STR_CAMERA_USER, itemCam.getDev_User());
                startActivity(intent4);
            }
        }
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10);
        }
        switch (view.getId()) {
            case R.id.picture_phone:
                this.tag = 0;
                this.bntPhone.setBackgroundResource(R.mipmap.checktopleft_pressed);
                this.bntRemote.setBackgroundResource(R.mipmap.checkright_normal);
                this.bntPhone.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                this.bntRemote.setTextColor(getResources().getColor(R.color.color_white));
                break;
            case R.id.picture_remote:
                this.tag = 1;
                this.bntRemote.setBackgroundResource(R.mipmap.checkright_pressed);
                this.bntPhone.setBackgroundResource(R.mipmap.checkleft_normal);
                this.bntRemote.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                this.bntPhone.setTextColor(getResources().getColor(R.color.color_white));
                break;
        }
        this.listAdapter.notifyDataSetChanged();
    }

    private class MyStatusBroadCast extends BroadcastReceiver {
        private MyStatusBroadCast() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("camera_status_change".equals(action)) {
                intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
                intent.getIntExtra(ContentCommon.STR_PPPP_STATUS, -1);
                FragmentVideo.this.listAdapter.notifyDataSetChanged();
            }
            if ("del_add_modify_camera".equals(action)) {
                int intExtra = intent.getIntExtra("type", 0);
                intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
                if (!(intExtra == 1 || intExtra == 2)) {
                }
                if (SystemValue.arrayList.size() == 0) {
                    FragmentVideo.this.listView.setVisibility(8);
                } else {
                    FragmentVideo.this.listView.setVisibility(0);
                }
                FragmentVideo.this.listAdapter.notifyDataSetChanged();
            }
        }
    }
}
