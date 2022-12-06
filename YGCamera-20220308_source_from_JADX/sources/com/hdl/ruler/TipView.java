package com.hdl.ruler;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Timer;
import java.util.TimerTask;
import shix.cykj.camera.R;

public class TipView extends RelativeLayout {
    private static final int DURATION_TIP_HIDE = 3000;
    private static final int WHAT_CLOSE_LEFT = 447;
    private static final int WHAT_CLOSE_LEFT_LANDSCAPE = 448;
    private static final int WHAT_CLOSE_RIGHT = 449;
    private static final int WHAT_CLOSE_RIGHT_LANDSCAPE = 446;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public Handler handler;
    private boolean isShowLeftTip;
    private boolean isShowLeftTipLandscape;
    private boolean isShowRightTip;
    private boolean isShowRightTipLandscape;
    private ImageView ivLeft;
    private ImageView ivRight;
    private ImageView ivTipLeft;
    private ImageView ivTipLeftLandscape;
    private ImageView ivTipRight;
    private ImageView ivTipRightLandscape;
    private ObjectAnimator leftAnimation;
    private ObjectAnimator rightAnimation;
    private Timer timer;

    public TipView(Context context2) {
        this(context2, (AttributeSet) null);
    }

    public TipView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TipView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.isShowLeftTip = false;
        this.isShowRightTip = false;
        this.isShowLeftTipLandscape = false;
        this.isShowRightTipLandscape = false;
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                if (TipView.this.context != null) {
                    switch (message.what) {
                        case TipView.WHAT_CLOSE_RIGHT_LANDSCAPE /*446*/:
                            TipView.this.setShowRightTipLandscape(false);
                            return;
                        case TipView.WHAT_CLOSE_LEFT /*447*/:
                            TipView.this.setShowLeftTip(false);
                            return;
                        case TipView.WHAT_CLOSE_LEFT_LANDSCAPE /*448*/:
                            TipView.this.setShowLeftTipLandscape(false);
                            return;
                        case TipView.WHAT_CLOSE_RIGHT /*449*/:
                            TipView.this.setShowRightTip(false);
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        this.context = context2;
        View inflate = View.inflate(context2, R.layout.tip_layout, (ViewGroup) null);
        addView(inflate);
        this.ivLeft = (ImageView) inflate.findViewById(R.id.iv_left);
        this.ivRight = (ImageView) inflate.findViewById(R.id.iv_right);
        this.ivTipLeft = (ImageView) inflate.findViewById(R.id.iv_tip_left);
        this.ivTipRight = (ImageView) inflate.findViewById(R.id.iv_tip_right);
        this.ivTipLeftLandscape = (ImageView) inflate.findViewById(R.id.iv_tip_left_landscape);
        this.ivTipRightLandscape = (ImageView) inflate.findViewById(R.id.iv_tip_right_landscape);
        this.leftAnimation = ObjectAnimator.ofFloat(this.ivLeft, "Alpha", new float[]{0.0f, 1.0f, 0.0f, 1.0f});
        this.rightAnimation = ObjectAnimator.ofFloat(this.ivRight, "Alpha", new float[]{0.0f, 1.0f, 0.0f, 1.0f});
        this.leftAnimation.setDuration(3000);
        this.rightAnimation.setDuration(3000);
        this.leftAnimation.setRepeatMode(1);
        this.rightAnimation.setRepeatMode(1);
        setShowLeftTip(false);
        setShowRightTip(false);
    }

    public boolean isShowLeftTip() {
        return this.isShowLeftTip;
    }

    public void setShowLeftTip(boolean z) {
        this.isShowLeftTip = z;
        hideLandscapeTip();
        if (this.isShowLeftTip) {
            this.ivTipLeft.setVisibility(0);
            this.ivLeft.setVisibility(0);
            this.ivTipRight.setVisibility(8);
            this.ivRight.setVisibility(8);
            this.leftAnimation.start();
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            this.timer = new Timer();
            this.timer.schedule(new TimerTask() {
                public void run() {
                    TipView.this.handler.sendEmptyMessage(TipView.WHAT_CLOSE_LEFT);
                }
            }, 3000);
            return;
        }
        this.ivTipLeft.setVisibility(8);
        this.ivLeft.setVisibility(8);
        this.leftAnimation.cancel();
    }

    public boolean isShowRightTip() {
        return this.isShowRightTip;
    }

    public void setShowRightTip(boolean z) {
        this.isShowRightTip = z;
        hideLandscapeTip();
        if (this.isShowRightTip) {
            this.ivRight.setVisibility(0);
            this.ivTipRight.setVisibility(0);
            this.ivTipLeft.setVisibility(8);
            this.ivLeft.setVisibility(8);
            this.rightAnimation.start();
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            this.timer = new Timer();
            this.timer.schedule(new TimerTask() {
                public void run() {
                    TipView.this.handler.sendEmptyMessage(TipView.WHAT_CLOSE_RIGHT);
                }
            }, 3000);
            return;
        }
        this.ivRight.setVisibility(8);
        this.ivTipRight.setVisibility(8);
        this.rightAnimation.cancel();
    }

    private void hideLandscapeTip() {
        this.ivTipRightLandscape.setVisibility(8);
        this.ivTipLeftLandscape.setVisibility(8);
    }

    private void hideTip() {
        this.ivTipRight.setVisibility(8);
        this.ivTipLeft.setVisibility(8);
    }

    public boolean isShowLeftTipLandscape() {
        return this.isShowLeftTipLandscape;
    }

    public boolean isShowRightTipLandscape() {
        return this.isShowRightTipLandscape;
    }

    public void setShowLeftTipLandscape(boolean z) {
        this.isShowLeftTipLandscape = z;
        hideTip();
        if (this.isShowLeftTipLandscape) {
            this.ivLeft.setVisibility(0);
            this.ivTipLeftLandscape.setVisibility(0);
            this.ivTipRightLandscape.setVisibility(8);
            this.ivRight.setVisibility(8);
            this.leftAnimation.start();
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            this.timer = new Timer();
            this.timer.schedule(new TimerTask() {
                public void run() {
                    TipView.this.handler.sendEmptyMessage(TipView.WHAT_CLOSE_LEFT_LANDSCAPE);
                }
            }, 3000);
            return;
        }
        this.ivLeft.setVisibility(8);
        this.ivTipLeftLandscape.setVisibility(8);
        this.leftAnimation.cancel();
    }

    public void setShowRightTipLandscape(boolean z) {
        this.isShowRightTipLandscape = z;
        hideTip();
        if (this.isShowRightTipLandscape) {
            this.ivRight.setVisibility(0);
            this.ivTipRightLandscape.setVisibility(0);
            this.ivTipLeftLandscape.setVisibility(8);
            this.ivLeft.setVisibility(8);
            this.rightAnimation.start();
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            this.timer = new Timer();
            this.timer.schedule(new TimerTask() {
                public void run() {
                    TipView.this.handler.sendEmptyMessage(TipView.WHAT_CLOSE_RIGHT_LANDSCAPE);
                }
            }, 3000);
            return;
        }
        this.ivRight.setVisibility(8);
        this.ivTipRightLandscape.setVisibility(8);
        this.rightAnimation.cancel();
    }
}
