package com.shix.shixipc.widget;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import shix.cykj.camera.R;

public class DialogLoading {
    static DialogLoading instance;
    ObjectAnimator animator;
    AlertDialog dialog;
    MyHandler handler;
    ImageView imageView;
    boolean isCanFinish = true;
    boolean isShowing = false;
    WindowManager.LayoutParams layoutParams;
    TextView textView;
    TextView tvTime;
    View view;

    private DialogLoading() {
    }

    public static DialogLoading getInstance() {
        if (instance == null) {
            instance = new DialogLoading();
        }
        return instance;
    }

    public void showDialog(Activity activity, String str) {
        this.view = LayoutInflater.from(activity).inflate(R.layout.layout_for_dialog, (ViewGroup) null);
        this.imageView = (ImageView) this.view.findViewById(R.id.iv_dialog_loading);
        this.textView = (TextView) this.view.findViewById(R.id.tv_dialog_msg);
        this.tvTime = (TextView) this.view.findViewById(R.id.tv_dialog_time);
        this.animator = ObjectAnimator.ofFloat(this.imageView, "rotation", new float[]{360.0f});
        this.animator.setRepeatMode(1);
        this.animator.setRepeatCount(-1);
        this.animator.setInterpolator(new LinearInterpolator());
        this.animator.setDuration(3000);
        this.animator.start();
        this.textView.setText(str);
        this.dialog = new AlertDialog.Builder(activity).create();
        this.dialog.setCancelable(false);
        this.dialog.show();
        this.layoutParams = this.dialog.getWindow().getAttributes();
        WindowManager.LayoutParams layoutParams2 = this.layoutParams;
        layoutParams2.height = -2;
        layoutParams2.width = -2;
        this.dialog.setContentView(this.view, layoutParams2);
    }

    public void setCanFinish(boolean z) {
        this.isCanFinish = z;
    }

    public void startTime(Activity activity) {
        this.handler = new MyHandler(activity);
        this.isShowing = true;
        new Thread() {
            public void run() {
                int i = 15;
                while (DialogLoading.this.isShowing && i > 0) {
                    Message message = new Message();
                    message.what = 1024;
                    message.arg1 = i;
                    DialogLoading.this.handler.sendMessage(message);
                    i--;
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (DialogLoading.this.isShowing && i == 0) {
                    DialogLoading.this.handler.sendEmptyMessage(110);
                }
            }
        }.start();
    }

    public void onDismiss() {
        synchronized (DialogLoading.class) {
            this.isShowing = false;
        }
        if (instance != null) {
            instance = null;
        }
        if (this.view != null) {
            this.view = null;
        }
        if (this.layoutParams != null) {
            this.layoutParams = null;
        }
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            if (alertDialog.isShowing()) {
                this.dialog.dismiss();
            }
            this.dialog = null;
        }
        if (this.imageView != null) {
            this.imageView = null;
        }
        if (this.textView != null) {
            this.textView = null;
        }
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.animator = null;
        }
        MyHandler myHandler = this.handler;
        if (myHandler != null) {
            myHandler.removeMessages(1024);
            this.handler.removeMessages(110);
        }
    }

    public void setPrecentText(String str) {
        TextView textView2 = this.tvTime;
        if (textView2 != null) {
            textView2.setVisibility(0);
            this.tvTime.setText(str);
        }
    }

    private class MyHandler extends Handler {
        WeakReference<Activity> weakReference;

        public MyHandler(Activity activity) {
            this.weakReference = new WeakReference<>(activity);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 110) {
                DialogLoading.this.onDismiss();
                if (DialogLoading.this.isCanFinish) {
                    ((Activity) this.weakReference.get()).finish();
                }
                Toast.makeText((Context) this.weakReference.get(), ((Activity) this.weakReference.get()).getResources().getString(R.string.get_info_fail), 0).show();
            } else if (i == 1024 && DialogLoading.this.tvTime != null) {
                DialogLoading.this.tvTime.setVisibility(0);
                TextView textView = DialogLoading.this.tvTime;
                textView.setText(message.arg1 + "S");
            }
        }
    }
}
