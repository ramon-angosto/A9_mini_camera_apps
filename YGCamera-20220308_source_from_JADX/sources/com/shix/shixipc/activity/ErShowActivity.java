package com.shix.shixipc.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.WriterException;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import shix.cykj.camera.R;

public class ErShowActivity extends BaseActivity implements View.OnClickListener {
    private final int CHECKCOUNT = 3;
    private final int CHECKSSID = 1;
    private final int CHECKUID = 2;
    /* access modifiers changed from: private */
    public Handler MsgHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3) {
                TextView access$300 = ErShowActivity.this.tv_count;
                access$300.setText(ErShowActivity.this.count + " S");
            }
        }
    };
    private String Password = "";
    private Bitmap bitmap;
    /* access modifiers changed from: private */
    public int count = 0;
    private ImageView img_mode_show;
    /* access modifiers changed from: private */
    public boolean isCheck = false;
    private boolean isFistComeOn = false;
    private String mConnectedSsid = "";
    private WifiManager mWifiManager;
    private String nowssid;
    private String strEr = "";
    private String strUid = "";
    /* access modifiers changed from: private */
    public TextView tv_count;

    static /* synthetic */ int access$108(ErShowActivity erShowActivity) {
        int i = erShowActivity.count;
        erShowActivity.count = i + 1;
        return i;
    }

    class CheckThread extends Thread {
        CheckThread() {
        }

        public void run() {
            super.run();
            while (ErShowActivity.this.isCheck && ErShowActivity.this.isCheck) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ErShowActivity.this.isCheck) {
                    ErShowActivity.access$108(ErShowActivity.this);
                    ErShowActivity.this.MsgHandler.sendEmptyMessage(3);
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_er);
        CommonUtil.Log(1, "SHIX  onCreate");
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.mConnectedSsid = getIntent().getStringExtra("mConnectedSsid");
        this.Password = getIntent().getStringExtra("Password");
        this.img_mode_show = (ImageView) findViewById(R.id.img_mode_show);
        findViewById(R.id.tvNext).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        this.tv_count = (TextView) findViewById(R.id.tv_count);
        this.isFistComeOn = true;
        this.isCheck = true;
        new CheckThread().start();
        SystemValue.isExitBackGoudExit = false;
        this.strEr = "{\"ssid\":\"" + this.mConnectedSsid + "\",\"password\":\"" + this.Password + "\"}";
        try {
            this.bitmap = Create2DCode(this.strEr);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        if (this.bitmap != null) {
            this.img_mode_show.setVisibility(0);
            this.img_mode_show.setImageBitmap(this.bitmap);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        this.isFistComeOn = false;
        Log.d("SHIX", "SHIX onRestart" + this.nowssid);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.isCheck = false;
        super.onDestroy();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.tvNext) {
            finish();
            Intent intent = new Intent(this, SertchActivity.class);
            intent.putExtra("sType", 110);
            startActivity(intent);
        }
    }
}
