package com.shix.shixipc.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonAppUtil;
import com.shix.shixipc.utils.CommonUtil;
import com.unad.sdk.UNADBannerView;
import com.unad.sdk.dto.AdError;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class AddShowActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public String TAG = "UNAD_SDK";
    private UNADBannerView bannerContainer;
    String jsonStr;
    Runnable networkTask = new Runnable() {
        public void run() {
            try {
                AddShowActivity.this.getJSONObject("https://hdwifiapp.oss-cn-hongkong.aliyuncs.com/testapk.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_show;
    private View popv_show;
    /* access modifiers changed from: private */
    public TextView tv_ver;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.add_show);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.tv_ver = (TextView) findViewById(R.id.tv_ver);
        this.tv_ver.setText(ContentCommon.APP_SOFTVERSION_SELF);
        this.tv_ver.setText(ContentCommon.APP_SOFTVERSION_SELF);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                AddShowActivity.this.finish();
            }
        });
        findViewById(R.id.ll_add0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                AddShowActivity.this.finish();
                AddShowActivity.this.startActivity(new Intent(AddShowActivity.this, NApGetWififActivity.class));
            }
        });
        findViewById(R.id.ll_add1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                AddShowActivity.this.finish();
                AddShowActivity.this.startActivity(new Intent(AddShowActivity.this, NApGetWififActivity.class));
            }
        });
        findViewById(R.id.ll_add2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                AddShowActivity.this.finish();
                AddShowActivity.this.startActivity(new Intent(AddShowActivity.this, AddCameraActivity.class));
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
        findViewById(R.id.tv_ver).setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (!ContentCommon.ISVISI.booleanValue()) {
                    return false;
                }
                CommonUtil.Vibrate(AddShowActivity.this, 10);
                return false;
            }
        });
        if (!getResources().getString(R.string.camera_user).equalsIgnoreCase("用户名")) {
            findViewById(R.id.tv_ys).setVisibility(8);
        }
        findViewById(R.id.tv_ys).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AddShowActivity.this.startActivity(new Intent(AddShowActivity.this, MenuHelepActivity.class));
            }
        });
        findViewById(R.id.tvWX).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(AddShowActivity.this, 10);
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/rChvwIH1mTI"));
                intent.addFlags(268435456);
                intent.setPackage("com.google.android.youtube");
                AddShowActivity.this.startActivity(intent);
            }
        });
        if (ContentCommon.ISAUDIOSHOW.booleanValue()) {
            try {
                CommonUtil.playAudioShow(this, R.string.audioshow_add_select);
            } catch (Exception unused) {
            }
        }
        initExitPopupWindow_Hight();
        if (CommonAppUtil.APP_adAdd()) {
            Log.i(this.TAG, "Banner start");
            try {
                this.bannerContainer = (UNADBannerView) findViewById(R.id.ad_banner_view);
                this.bannerContainer.setAdUnitId("Adgo-unit-1612497140");
                this.bannerContainer.setAdViewListener(new UNADBannerView.AdViewListener() {
                    public void onAdClose(UNADBannerView uNADBannerView) {
                    }

                    public void onAdOpen(UNADBannerView uNADBannerView) {
                    }

                    public void onAdLoaded(UNADBannerView uNADBannerView) {
                        Log.i(AddShowActivity.this.TAG, "Banner onAdViewLoaded");
                    }

                    public void onAdFailed(UNADBannerView uNADBannerView, AdError adError) {
                        String access$000 = AddShowActivity.this.TAG;
                        Log.i(access$000, "Banner error onAdViewFailed" + adError.getMessage());
                    }

                    public void onAdClicked(UNADBannerView uNADBannerView) {
                        Log.i(AddShowActivity.this.TAG, "Banner onAdViewClicked");
                    }
                });
                this.bannerContainer.loadAd();
            } catch (Exception unused2) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        UNADBannerView uNADBannerView = this.bannerContainer;
        if (uNADBannerView != null) {
            uNADBannerView.destroy();
        }
    }

    public void getJSONObject(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        if (httpURLConnection.getResponseCode() == 200) {
            this.jsonStr = new String(readStream(httpURLConnection.getInputStream()));
            CommonUtil.Log(1, "getJSONObject:" + this.jsonStr);
            runOnUiThread(new Runnable() {
                public void run() {
                    int i;
                    int i2;
                    int i3;
                    int i4;
                    int i5;
                    int i6;
                    int i7;
                    int i8;
                    int i9;
                    String str;
                    AddShowActivity.this.tv_ver.setText("TEST:" + SystemValue.testCount + "  " + AddShowActivity.this.jsonStr);
                    try {
                        JSONObject jSONObject = new JSONObject(AddShowActivity.this.jsonStr);
                        int i10 = jSONObject.getInt("testver");
                        i6 = jSONObject.getInt("testcount");
                        int i11 = jSONObject.getInt("testsm");
                        int i12 = jSONObject.getInt("testsd");
                        int i13 = jSONObject.getInt("testmm");
                        int i14 = jSONObject.getInt("clear");
                        int i15 = jSONObject.getInt("testmd");
                        i3 = i11;
                        i2 = i12;
                        i = i13;
                        i5 = jSONObject.getInt("onlyap");
                        i4 = i10;
                        i8 = i14;
                        i7 = i15;
                    } catch (Exception unused) {
                        i5 = 1;
                        i8 = 0;
                        i7 = 0;
                        i6 = 0;
                        i4 = 0;
                        i3 = 0;
                        i2 = 0;
                        i = 0;
                    }
                    if (i8 != 1 || SystemValue.testCount <= i6) {
                        str = "onlyap";
                        i9 = i5;
                    } else {
                        str = "onlyap";
                        i9 = i5;
                        CommonUtil.SaveCommonShare(AddShowActivity.this, "testCount", (String) null, 0);
                        SystemValue.testCount = 0;
                    }
                    CommonUtil.SaveCommonShare(AddShowActivity.this, "testver", (String) null, i4);
                    CommonUtil.SaveCommonShare(AddShowActivity.this, "testcount", (String) null, i6);
                    CommonUtil.SaveCommonShare(AddShowActivity.this, "testsm", (String) null, i3);
                    CommonUtil.SaveCommonShare(AddShowActivity.this, "testsd", (String) null, i2);
                    CommonUtil.SaveCommonShare(AddShowActivity.this, "testmm", (String) null, i);
                    CommonUtil.SaveCommonShare(AddShowActivity.this, "testmd", (String) null, i7);
                    CommonUtil.SaveCommonShare(AddShowActivity.this, "clear", (String) null, i8);
                    CommonUtil.SaveCommonShare(AddShowActivity.this, str, (String) null, i9);
                }
            });
            return;
        }
        runOnUiThread(new Runnable() {
            public void run() {
                TextView access$100 = AddShowActivity.this.tv_ver;
                access$100.setText("TEST:" + SystemValue.testCount + "  从服务器同步失败");
            }
        });
    }

    public static byte[] readStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public void initExitPopupWindow_Hight() {
        this.popv_show = LayoutInflater.from(this).inflate(R.layout.popup_showsel, (ViewGroup) null);
        this.popupWindow_show = new PopupWindow(this.popv_show, -1, -1);
        this.popupWindow_show.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_show.setFocusable(true);
        this.popupWindow_show.setInputMethodMode(1);
        this.popupWindow_show.setSoftInputMode(16);
        this.popupWindow_show.setOutsideTouchable(true);
        this.popupWindow_show.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_show.setFocusableInTouchMode(true);
        this.popv_show.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 82) {
                    return false;
                }
                AddShowActivity.this.popupWindow_show.dismiss();
                return false;
            }
        });
        this.popv_show.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AddShowActivity.this.popupWindow_show.dismiss();
                return false;
            }
        });
        this.popupWindow_show.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                AddShowActivity.this.popupWindow_show.dismiss();
            }
        });
        this.popupWindow_show.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AddShowActivity.this.popupWindow_show.dismiss();
                return false;
            }
        });
    }
}
