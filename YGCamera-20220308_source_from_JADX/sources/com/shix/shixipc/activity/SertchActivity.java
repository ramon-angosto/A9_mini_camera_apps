package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.SearchListAdapter;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.cykj.camera.R;

public class SertchActivity extends BaseActivity implements NUIMainActivity.AddCameraInterface1 {
    private ListView cameraListView = null;
    /* access modifiers changed from: private */
    public boolean isStart = false;
    /* access modifiers changed from: private */
    public SearchListAdapter listAdapter = null;
    /* access modifiers changed from: private */
    public List<Map<String, Object>> listItems11 = new ArrayList();
    /* access modifiers changed from: private */
    public int sType = 0;
    /* access modifiers changed from: private */
    public TextView tvshow;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.sss);
        this.sType = getIntent().getIntExtra("sType", 0);
        this.cameraListView = (ListView) findViewById(R.id.listviewCamera);
        NUIMainActivity.setAddCameraInterface1(this);
        this.listAdapter = new SearchListAdapter(this);
        this.cameraListView.setAdapter(this.listAdapter);
        this.tvshow = (TextView) findViewById(R.id.tvshow);
        this.tvshow.setText(R.string.sertch_show1);
        this.isStart = false;
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        ((Button) findViewById(R.id.done)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SertchActivity.this, 10);
                }
                if (!SertchActivity.this.isStart) {
                    SertchActivity.this.tvshow.setText(R.string.sertch_show1);
                    SertchActivity.this.tvshow.setVisibility(0);
                    SertchActivity.this.startSearch();
                }
            }
        });
        ((Button) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SertchActivity.this, 10);
                }
                SertchActivity.this.finish();
            }
        });
        this.cameraListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SertchActivity.this, 10);
                }
                Map<String, Object> itemContent = SertchActivity.this.listAdapter.getItemContent(i);
                if (itemContent != null) {
                    String str = (String) itemContent.get(ContentCommon.STR_CAMERA_NAME);
                    String str2 = (String) itemContent.get(ContentCommon.STR_CAMERA_ID);
                    String str3 = (String) itemContent.get(ContentCommon.STR_CAMERA_MAC);
                    if (SertchActivity.this.listAdapter.checkDID(str2)) {
                        SertchActivity.this.showToast((int) R.string.sertch_show2);
                    } else if (SertchActivity.this.sType == 110) {
                        Intent intent = new Intent(SertchActivity.this, AddCameraActivity.class);
                        intent.putExtra(ContentCommon.CAMERA_OPTION, 1);
                        intent.putExtra(ContentCommon.STR_CAMERA_NAME, ContentCommon.SHIX_DEFUALT_NAME);
                        intent.putExtra(ContentCommon.STR_CAMERA_ID, str2);
                        intent.putExtra(ContentCommon.STR_CAMERA_USER, "admin");
                        intent.putExtra(ContentCommon.STR_CAMERA_PWD, ContentCommon.SHIX_DEFUALT_PWD);
                        intent.putExtra("pushTypeInt", 110);
                        SertchActivity.this.startActivity(intent);
                        SertchActivity.this.finish();
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mUID", str2);
                        SertchActivity.this.setResult(-1, intent2);
                        SertchActivity.this.finish();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        startSearch();
    }

    /* access modifiers changed from: private */
    public void startSearch() {
        this.isStart = true;
        this.listAdapter.ClearAll();
        this.listItems11.clear();
        this.listAdapter.notifyDataSetChanged();
        new Thread(new SearchThread()).start();
    }

    private class SearchThread implements Runnable {
        private SearchThread() {
        }

        public void run() {
            Log.d(RemoteMessageConst.Notification.TAG, "startSearch");
            String localIpAddress = CommonUtil.getLocalIpAddress(SertchActivity.this);
            Log.d(RemoteMessageConst.Notification.TAG, "startSearch : " + localIpAddress);
            NativeCaller.StartSearch("");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            NativeCaller.StopSearch();
            SertchActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    if (SertchActivity.this.listItems11.size() == 0) {
                        SertchActivity.this.tvshow.setText(R.string.sertch_show3);
                    } else {
                        SertchActivity.this.tvshow.setVisibility(8);
                    }
                    SertchActivity.this.listAdapter.setListItems(SertchActivity.this.listItems11);
                    SertchActivity.this.listAdapter.notifyDataSetChanged();
                    boolean unused = SertchActivity.this.isStart = false;
                }
            });
        }
    }

    public void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2) {
        CommonUtil.Log(1, "strName:" + str2 + "  strDeviceID:" + str3 + "  strIpAddr:" + str4);
        if (str3 == null || str3.length() <= 3 || !AddCamera(str, ContentCommon.SHIX_DEFUALT_NAME, str3.trim().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toUpperCase())) {
        }
    }

    public boolean AddCamera(String str, String str2, String str3) {
        if (!CheckCameraInfo(str3)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ContentCommon.STR_CAMERA_MAC, str);
        hashMap.put(ContentCommon.STR_CAMERA_NAME, str2);
        hashMap.put(ContentCommon.STR_CAMERA_ID, str3);
        this.listItems11.add(hashMap);
        return true;
    }

    private boolean CheckCameraInfo(String str) {
        int size = this.listItems11.size();
        for (int i = 0; i < size; i++) {
            if (str.equals((String) this.listItems11.get(i).get(ContentCommon.STR_CAMERA_ID))) {
                return false;
            }
        }
        return true;
    }
}
