package com.shix.shixipc.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.google.zxing.WriterException;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelAddCameraErCodeActivity extends BaseActivity implements View.OnClickListener {
    private Bitmap bitmap;
    private Bitmap bitmap1;
    private ImageView img_er;
    private int isEdit = 0;
    private SharedPreferences preuser;
    private int pushTypeInt = 0;
    private String strName = "";
    private String strPwd = "";
    private String strUser = "";
    Handler updateListHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
        }
    };
    private String zjStrDid = "";
    private String zjStrMac = "";

    private void InitParams() {
    }

    private void done() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.add_channeler);
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        Intent intent = getIntent();
        this.pushTypeInt = intent.getIntExtra("pushTypeInt", 0);
        this.zjStrDid = intent.getStringExtra("strDid");
        this.isEdit = intent.getIntExtra("isEdit", 0);
        this.zjStrMac = intent.getStringExtra("strMac");
        findView();
        InitParams();
        SharedPreferences sharedPreferences = this.preuser;
        String string = sharedPreferences.getString("apname" + this.zjStrDid, "");
        SharedPreferences sharedPreferences2 = this.preuser;
        String string2 = sharedPreferences2.getString("appwd" + this.zjStrDid, "");
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ssid", string);
            jSONObject.put("appwd", string2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.bitmap = Create2DCode(jSONObject.toString());
        } catch (WriterException e2) {
            e2.printStackTrace();
        }
        if (this.bitmap != null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.qh_trans);
            int width = this.bitmap.getWidth();
            int height = this.bitmap.getHeight();
            int width2 = decodeResource.getWidth();
            int height2 = decodeResource.getHeight();
            float f = ((((float) width) * 1.0f) / 7.0f) / ((float) width2);
            this.bitmap1 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(this.bitmap1);
                canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
                canvas.scale(f, f, (float) (width / 2), (float) (height / 2));
                canvas.drawBitmap(decodeResource, (float) ((width - width2) / 2), (float) ((height - height2) / 2), (Paint) null);
                canvas.save();
                canvas.restore();
            } catch (Exception e3) {
                this.bitmap = null;
                e3.getStackTrace();
            }
            this.img_er = (ImageView) findViewById(R.id.img_er);
            this.img_er.setImageBitmap(this.bitmap1);
        }
    }

    private void hideSof(EditText editText) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void hideSoftKeyboard(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        hideSoftKeyboard(this);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    private void findView() {
        this.img_er = (ImageView) findViewById(R.id.img_er);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.done1).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.done1) {
            finish();
            Intent intent = new Intent(this, ChannelAddCameraActivity.class);
            intent.putExtra("pushTypeInt", 1);
            intent.putExtra("strDid", this.zjStrDid);
            startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    private void hiddenInputMethod() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
