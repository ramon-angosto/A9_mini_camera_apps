package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.SearchListAdapter;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import object.p2pipcam.nativecaller.NativeCaller;

public class UpTestActivity extends BaseActivity implements NUIMainActivity.AddCameraInterface1 {
    private ListView cameraListView = null;
    /* access modifiers changed from: private */
    public boolean isStart = false;
    /* access modifiers changed from: private */
    public SearchListAdapter listAdapter = null;
    /* access modifiers changed from: private */
    public List<Map<String, Object>> listItems11 = new ArrayList();
    private int sType = 0;
    /* access modifiers changed from: private */
    public TextView tvshow;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.uptest);
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
                    CommonUtil.Vibrate(UpTestActivity.this, 10);
                }
                if (!UpTestActivity.this.isStart) {
                    UpTestActivity.this.tvshow.setText(R.string.sertch_show1);
                    UpTestActivity.this.tvshow.setVisibility(0);
                    UpTestActivity.this.startSearch();
                }
            }
        });
        ((Button) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(UpTestActivity.this, 10);
                }
                UpTestActivity.this.finish();
            }
        });
        findViewById(R.id.textview_add_camera).setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UpTestActivity.this.startActivity(new Intent(UpTestActivity.this, TestPushActivity.class));
                return false;
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
            Log.d("tag", "startSearch");
            String localIpAddress = CommonUtil.getLocalIpAddress(UpTestActivity.this);
            Log.d("tag", "startSearch : " + localIpAddress);
            NativeCaller.StartSearch(localIpAddress);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            NativeCaller.StopSearch();
            UpTestActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    if (UpTestActivity.this.listItems11.size() == 0) {
                        UpTestActivity.this.tvshow.setText(R.string.sertch_show3);
                    } else {
                        UpTestActivity.this.tvshow.setVisibility(8);
                    }
                    UpTestActivity.this.listAdapter.setListItems(UpTestActivity.this.listItems11);
                    UpTestActivity.this.listAdapter.notifyDataSetChanged();
                    boolean unused = UpTestActivity.this.isStart = false;
                }
            });
        }
    }

    public void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2) {
        CommonUtil.Log(1, "strName:" + str2 + "  strDeviceID:" + str3 + "  strIpAddr:" + str4);
        if (str3 == null || str3.length() <= 3 || !AddCamera(str, ContentCommon.SHIX_DEFUALT_NAME, str3.trim().replace("-", "").toUpperCase())) {
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
