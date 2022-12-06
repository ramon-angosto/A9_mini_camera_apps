package com.mbridge.msdk.out;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.widget.MBImageView;

public class LoadingActivity extends Activity {
    /* access modifiers changed from: private */
    public Bitmap abitmap;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            LoadingActivity.this.finish();
        }
    };
    private c cipl = new c() {
        public void onFailedLoad(String str, String str2) {
        }

        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (LoadingActivity.this.img_icon != null && bitmap != null && !bitmap.isRecycled() && ((String) LoadingActivity.this.img_icon.getTag()).equals(str)) {
                LoadingActivity.this.img_icon.setImageBitmap(bitmap);
                Bitmap unused = LoadingActivity.this.abitmap = bitmap;
            }
        }
    };
    private Drawable drawable;
    private String icon_url;
    /* access modifiers changed from: private */
    public ImageView img_icon;
    private OnLoadingDialogCallback mCallback;
    private RelativeLayout rlayout;
    private RelativeLayout rlayout_main;

    public interface OnLoadingDialogCallback {
        void onCancel(CampaignEx campaignEx);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ExitApp");
        BroadcastReceiver broadcastReceiver2 = this.broadcastReceiver;
        if (broadcastReceiver2 != null) {
            registerReceiver(broadcastReceiver2, intentFilter);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver2 = this.broadcastReceiver;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
        }
        ImageView imageView = this.img_icon;
        if (imageView != null) {
            imageView.setImageBitmap((Bitmap) null);
        }
        this.img_icon = null;
        this.rlayout_main = null;
        this.cipl = null;
        this.drawable = null;
        RelativeLayout relativeLayout = this.rlayout;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundDrawable((Drawable) null);
        }
        this.rlayout = null;
        Bitmap bitmap = this.abitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.abitmap = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra(CampaignEx.JSON_KEY_ICON_URL)) {
            this.icon_url = getIntent().getStringExtra(CampaignEx.JSON_KEY_ICON_URL);
        }
        setContentView(initView());
    }

    private View initView() {
        if (this.rlayout_main == null) {
            this.rlayout_main = new RelativeLayout(this);
            this.rlayout = new RelativeLayout(this);
            int b = u.b((Context) this, 15.0f);
            this.rlayout.setPadding(b, b, b, b);
            this.rlayout.setBackgroundResource(getResources().getIdentifier("mbridge_native_bg_loading_camera", "drawable", getPackageName()));
            this.rlayout.addView(new TextView(this), new RelativeLayout.LayoutParams(u.b((Context) this, 140.0f), u.b((Context) this, 31.5f)));
            this.img_icon = new MBImageView(this);
            this.img_icon.setId(u.a());
            this.img_icon.setTag(this.icon_url);
            if (!TextUtils.isEmpty(this.icon_url)) {
                b.a(getApplicationContext()).a(this.icon_url, this.cipl);
            }
            int b2 = u.b((Context) this, 64.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b2, b2);
            layoutParams.addRule(13, -1);
            this.rlayout.addView(this.img_icon, layoutParams);
            TextView textView = new TextView(this);
            textView.setSingleLine();
            textView.setTextColor(-1);
            textView.setTextSize(16.0f);
            textView.setText("Relax while loading....");
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(3, this.img_icon.getId());
            layoutParams2.addRule(14, -1);
            this.rlayout.addView(textView, layoutParams2);
            this.rlayout_main.addView(this.rlayout, new RelativeLayout.LayoutParams(-1, -1));
        }
        return this.rlayout_main;
    }
}
