package com.hdl.ruler.bean;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Scroller;
import java.util.Timer;
import java.util.TimerTask;

public class ScaleScroller {
    /* access modifiers changed from: private */
    public static int lastX;
    private final int ON_FLING = 1;
    private float afterLenght;
    private float beforeLength;
    private Context context;
    private GestureDetector gestureDetector;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message message) {
            boolean computeScrollOffset = ScaleScroller.this.scroller.computeScrollOffset();
            int unused = ScaleScroller.lastX = ScaleScroller.this.scroller.getCurrX();
            if (computeScrollOffset) {
                ScaleScroller.this.handler.sendEmptyMessage(1);
            } else {
                ScaleScroller.this.listener.onScrollFinished();
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean isCanScroll = true;
    /* access modifiers changed from: private */
    public boolean isDouble = false;
    private float lastDistanceX;
    /* access modifiers changed from: private */
    public ScrollingListener listener;
    private float mScale;
    /* access modifiers changed from: private */
    public Scroller scroller;
    private GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!ScaleScroller.this.isDouble) {
                int unused = ScaleScroller.lastX = 0;
                ScaleScroller.this.scroller.fling(0, 0, (int) (-f), 0, -2147483647, Integer.MAX_VALUE, 0, 0);
                ScaleScroller.this.handler.sendEmptyMessage(1);
            }
            return false;
        }
    };
    private double time;

    public interface ScrollingListener {
        void onScroll(int i);

        void onScrollFinished();

        void onZoom(float f, double d);

        void onZoomFinished();
    }

    public ScaleScroller(Context context2, ScrollingListener scrollingListener) {
        this.context = context2;
        this.listener = scrollingListener;
        init();
    }

    private void init() {
        this.gestureDetector = new GestureDetector(this.context, this.simpleOnGestureListener);
        this.gestureDetector.setIsLongpressEnabled(false);
        this.scroller = new Scroller(this.context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.isDouble = false;
            this.scroller.forceFinished(true);
            lastX = (int) motionEvent.getX();
        } else if (motionEvent.getAction() == 2) {
            if (motionEvent.getPointerCount() == 1 && !this.isDouble && this.isCanScroll) {
                int x = (int) (motionEvent.getX() - ((float) lastX));
                if (x != 0 && Math.abs(((float) Math.abs(x)) - Math.abs(this.lastDistanceX)) < 150.0f) {
                    this.listener.onScroll(x);
                    lastX = (int) motionEvent.getX();
                    this.lastDistanceX = (float) x;
                }
            } else if (motionEvent.getPointerCount() == 2 && this.isDouble) {
                this.isCanScroll = false;
                this.afterLenght = getDistance(motionEvent);
                if (this.beforeLength == 0.0f) {
                    this.beforeLength = this.afterLenght;
                }
                if (Math.abs(this.afterLenght - this.beforeLength) > 5.0f) {
                    this.mScale = this.afterLenght / this.beforeLength;
                    this.listener.onZoom(this.mScale, this.time);
                    this.beforeLength = this.afterLenght;
                }
            }
        } else if (motionEvent.getAction() == 1) {
            if (motionEvent.getPointerCount() == 1 && !this.isDouble) {
                this.listener.onScrollFinished();
            } else if (this.isDouble) {
                new Timer().schedule(new TimerTask() {
                    public void run() {
                        boolean unused = ScaleScroller.this.isCanScroll = true;
                    }
                }, 500);
                this.listener.onZoomFinished();
            }
            return false;
        } else if ((motionEvent.getAction() & 255) == 5 && motionEvent.getPointerCount() == 2) {
            this.beforeLength = getDistance(motionEvent);
            this.isDouble = true;
        }
        this.gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    private float getDistance(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }
}
