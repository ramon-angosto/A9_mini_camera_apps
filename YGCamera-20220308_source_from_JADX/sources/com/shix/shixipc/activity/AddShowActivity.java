package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.dommy.qrcode.util.Constant;
import com.google.zxing.activity.CaptureActivity;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import shix.cykj.camera.R;

public class AddShowActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.add_show);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                AddShowActivity.this.finish();
            }
        });
        findViewById(R.id.ll_add1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                AddShowActivity.this.finish();
                ContentCommon.AP_ADD_OR_CON = 1;
                Intent intent = new Intent();
                intent.setClass(AddShowActivity.this, ApConnectActivity.class);
                AddShowActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.ll_add2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                AddShowActivity.this.finish();
                AddShowActivity.this.startActivity(new Intent(AddShowActivity.this, NApGetWififActivity.class));
            }
        });
        findViewById(R.id.ll_add4).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                AddShowActivity.this.finish();
                AddShowActivity.this.startActivity(new Intent(AddShowActivity.this, AddCameraActivity.class));
            }
        });
        findViewById(R.id.ll_add5).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                AddShowActivity.this.finish();
                Intent intent = new Intent(AddShowActivity.this, CaptureActivity.class);
                intent.putExtra("type", 1);
                AddShowActivity.this.startActivityForResult(intent, Constant.REQ_QR_CODE);
            }
        });
        findViewById(R.id.ll_add3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                ContentCommon.AP_ADD_OR_CON = 0;
                Intent intent = new Intent();
                intent.setClass(AddShowActivity.this, ApConnectActivity.class);
                AddShowActivity.this.startActivity(intent);
            }
        });
    }
}
