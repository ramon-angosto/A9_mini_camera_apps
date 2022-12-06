package shix.ihdbell.project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.jxl.app.littlestars.project.R;
import object.p2pipcam.adapter.AlarmActivityAdapter;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.DataBaseHelper;

public class CloudActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private MyStatusBroadCast broadcast;
    /* access modifiers changed from: private */
    public AlarmActivityAdapter listAdapter;
    /* access modifiers changed from: private */
    public ListView listView;
    private int position;
    private int timeOne = 0;
    private int timeTag = 0;
    private int timeTwo = 0;
    private TextView tv_title;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.alarmactivity);
        this.position = getIntent().getIntExtra(RequestParameters.POSITION, 0);
        CommonUtil.Log(1, "position:" + this.position);
        findView();
        this.position = 1;
        if (this.position == 0) {
            this.tv_title.setText(R.string.main_alarm);
        } else {
            this.tv_title.setText(R.string.main_cloud);
        }
        if (SystemValue.arrayList.size() == 0) {
            this.listView.setVisibility(8);
        } else {
            this.listView.setVisibility(0);
        }
        this.listAdapter = new AlarmActivityAdapter(this, SystemValue.arrayList);
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(this);
        this.broadcast = new MyStatusBroadCast();
        IntentFilter intentFilter = new IntentFilter("camera_status_change");
        intentFilter.addAction("del_add_modify_camera");
        registerReceiver(this.broadcast, intentFilter);
    }

    private void findView() {
        this.tv_title = (TextView) findViewById(R.id.tv_title);
        this.listView = (ListView) findViewById(R.id.listview);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CloudActivity.this.finish();
                CloudActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent;
        CameraParamsBean itemCam = this.listAdapter.getItemCam(i);
        String did = itemCam.getDid();
        String name = itemCam.getName();
        if (this.position == 0) {
            intent = new Intent(this, AlarmLogActivity.class);
        } else {
            intent = new Intent(this, ClouDateActivity.class);
            int status = itemCam.getStatus();
            if (status == 5 || status == 7 || status == 6 || status == 3 || status == 9 || status == 10 || status == 4) {
                String user = itemCam.getUser();
                String pwd = itemCam.getPwd();
                NativeCaller.StopPPPP(did);
                StartPPPP(did, user, pwd, "test");
                return;
            }
            NativeCaller.TransferMessage(did, CommonUtil.SHIX_Heat(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
            if (status != 2) {
                showToast((int) R.string.cannot_call_cloud);
                return;
            } else if (itemCam.getDevType() == 51) {
                SystemValue.isLitos = true;
            } else {
                SystemValue.isLitos = false;
            }
        }
        String strServer = itemCam.getStrServer();
        if (strServer == null) {
            strServer = "1.1.11";
        }
        intent.putExtra(ContentCommon.STR_CAMERA_ID, did);
        intent.putExtra(ContentCommon.STR_CAMERA_NAME, name);
        intent.putExtra("strServe", strServer);
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_MENU));
            return false;
        } else if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        } else {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_BACK));
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.broadcast);
    }

    private class MyStatusBroadCast extends BroadcastReceiver {
        private MyStatusBroadCast() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("camera_status_change".equals(action)) {
                intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
                intent.getIntExtra(ContentCommon.STR_PPPP_STATUS, -1);
                CloudActivity.this.listAdapter.notifyDataSetChanged();
            }
            if ("del_add_modify_camera".equals(action)) {
                int intExtra = intent.getIntExtra(DataBaseHelper.KEY_TYPE, 0);
                intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
                if (!(intExtra == 1 || intExtra == 2)) {
                }
                if (SystemValue.arrayList.size() == 0) {
                    CloudActivity.this.listView.setVisibility(8);
                } else {
                    CloudActivity.this.listView.setVisibility(0);
                }
                CloudActivity.this.listAdapter.notifyDataSetChanged();
            }
        }
    }
}
