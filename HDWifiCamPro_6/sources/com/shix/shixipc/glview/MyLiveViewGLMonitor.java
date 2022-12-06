package com.shix.shixipc.glview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import com.shix.shixipc.utils.CommonUtil;

public class MyLiveViewGLMonitor extends HiGLMonitor implements View.OnTouchListener, GestureDetector.OnGestureListener {
    private static final int FLING_MIN_DISTANCE = 50;
    public static final int PTZ_STEP = 25;
    public int bottom;
    private Activity context;
    public int height;
    private float lastX = 0.0f;
    private float lastY = 0.0f;
    public int left;
    private GestureDetector mGestureDetector;
    private View.OnTouchListener mOnTouchListener;
    Matrix matrix = new Matrix();
    double nLenStart = 0.0d;
    private OnfigCangeInterface onfigCangeInterface;
    private long ptzTime = 0;
    private int pyl = 20;
    private float rawX = 0.0f;
    private float rawY = 0.0f;
    float resetHeight;
    float resetWidth;
    public float screen_height;
    public float screen_width;
    private SurfaceHolder sfh;
    private int state = 0;
    private int touchMoved;
    public int width;
    int xlenOld;
    int ylenOld;

    public interface OnfigCangeInterface {
        void CallBackOnfigStatu(int i);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public MyLiveViewGLMonitor(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.mGestureDetector = new GestureDetector(context2, this);
        super.setOnTouchListener(this);
        setOnTouchListener(this);
        setFocusable(true);
        setClickable(true);
        setLongClickable(true);
        Activity activity = (Activity) context2;
        this.context = activity;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.screen_width = (float) displayMetrics.heightPixels;
        this.screen_height = (float) displayMetrics.widthPixels;
    }

    public int getTouchMove() {
        return this.touchMoved;
    }

    public void setTouchMove(int i) {
        this.touchMoved = i;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        CommonUtil.Log(1, "SHIXZ onTouch12:");
        View.OnTouchListener onTouchListener = this.mOnTouchListener;
        if (onTouchListener != null) {
            onTouchListener.onTouch(view, motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        CommonUtil.Log(1, "SHIXZ mMonitor.state=" + this.state);
        int i = this.state;
        if (i == 1) {
            if (pointerCount == 2) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                CommonUtil.Log(1, "SHIXZ mMonitor.ACTION_DOWN");
                this.rawX = motionEvent.getRawX();
                this.rawY = motionEvent.getRawY();
                this.lastX = this.rawX;
                this.lastY = this.rawY;
            } else if (action == 2 && this.touchMoved != 2) {
                CommonUtil.Log(1, "SHIXZ mMonitor.ACTION_MOVE");
                this.rawX = motionEvent.getRawX();
                this.rawY = motionEvent.getRawY();
                float f = this.rawX - this.lastX;
                float f2 = this.rawY - this.lastY;
                if (Math.abs(f) < ((float) this.pyl) && Math.abs(f2) < ((float) this.pyl)) {
                    return false;
                }
                this.left = (int) (((float) this.left) + f);
                this.bottom = (int) (((float) this.bottom) - f2);
                if (this.left > 0) {
                    this.left = 0;
                }
                if (this.bottom > 0) {
                    this.bottom = 0;
                }
                int i2 = this.left;
                int i3 = this.width;
                float f3 = this.screen_width;
                if (((float) (i2 + i3)) < f3) {
                    this.left = (int) (f3 - ((float) i3));
                }
                int i4 = this.bottom;
                int i5 = this.height;
                float f4 = this.screen_height;
                if (((float) (i4 + i5)) < f4) {
                    this.bottom = (int) (f4 - ((float) i5));
                }
                int i6 = this.left;
                int i7 = this.width;
                if (i6 <= (-i7)) {
                    this.left = -i7;
                }
                int i8 = this.bottom;
                int i9 = this.height;
                if (i8 <= (-i9)) {
                    this.bottom = -i9;
                }
                setMatrix(this.left, this.bottom, this.width, this.height);
                this.lastX = this.rawX;
                this.lastY = this.rawY;
            }
            return true;
        } else if (i != 0 || pointerCount != 1) {
            return true;
        } else {
            CommonUtil.Log(1, "SHIXZ mMonitor.mGestureDetector");
            return this.mGestureDetector.onTouchEvent(motionEvent);
        }
    }

    public void saveMatrix(int i, int i2, int i3, int i4) {
        this.left = i;
        this.bottom = i2;
        this.width = i3;
        this.height = i4;
    }

    public void setView() {
        WindowManager.LayoutParams attributes = this.context.getWindow().getAttributes();
        attributes.flags |= 1024;
        this.context.getWindow().setAttributes(attributes);
        this.context.getWindow().addFlags(512);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f = (float) displayMetrics.widthPixels;
        float f2 = (float) displayMetrics.heightPixels;
        if (this.resetWidth == 0.0f) {
            this.resetWidth = f;
            this.resetHeight = f2;
        }
        this.resetWidth += 100.0f;
        this.resetHeight += 100.0f;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        CommonUtil.Log(1, "SHIXNEW onFling velocityX: " + Math.abs(f) + ", velocityY: " + Math.abs(f2));
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ptzTime > 500) {
            this.ptzTime = currentTimeMillis;
            scrollTo((int) f, (int) f2);
            invalidate();
            if (this.state == 0) {
                if (motionEvent.getX() - motionEvent2.getX() > 50.0f && Math.abs(f) > Math.abs(f2)) {
                    CommonUtil.Log(1, "SHIXNEW onFling left");
                    OnfigCangeInterface onfigCangeInterface2 = this.onfigCangeInterface;
                    if (onfigCangeInterface2 != null) {
                        onfigCangeInterface2.CallBackOnfigStatu(0);
                    }
                } else if (motionEvent2.getX() - motionEvent.getX() > 50.0f && Math.abs(f) > Math.abs(f2)) {
                    CommonUtil.Log(1, "SHIXNEW onFling right");
                    OnfigCangeInterface onfigCangeInterface3 = this.onfigCangeInterface;
                    if (onfigCangeInterface3 != null) {
                        onfigCangeInterface3.CallBackOnfigStatu(1);
                    }
                } else if (motionEvent.getY() - motionEvent2.getY() > 50.0f && Math.abs(f2) > Math.abs(f)) {
                    CommonUtil.Log(1, "SHIXNEW onFling up");
                    OnfigCangeInterface onfigCangeInterface4 = this.onfigCangeInterface;
                    if (onfigCangeInterface4 != null) {
                        onfigCangeInterface4.CallBackOnfigStatu(2);
                    }
                } else if (motionEvent2.getY() - motionEvent.getY() > 50.0f && Math.abs(f2) > Math.abs(f)) {
                    CommonUtil.Log(1, "SHIXNEW onFling down");
                    OnfigCangeInterface onfigCangeInterface5 = this.onfigCangeInterface;
                    if (onfigCangeInterface5 != null) {
                        onfigCangeInterface5.CallBackOnfigStatu(3);
                    }
                }
            }
        }
        return false;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnTouchListener = onTouchListener;
    }

    public void setOnFigListener(OnfigCangeInterface onfigCangeInterface2) {
        this.onfigCangeInterface = onfigCangeInterface2;
    }
}
