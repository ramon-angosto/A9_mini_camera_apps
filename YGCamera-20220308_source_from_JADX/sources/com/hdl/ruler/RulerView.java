package com.hdl.ruler;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hdl.ruler.bean.OnBarMoveListener;
import com.hdl.ruler.bean.OnSelectedTimeListener;
import com.hdl.ruler.bean.ScaleMode;
import com.hdl.ruler.bean.TimeSlot;
import com.hdl.ruler.utils.CUtils;
import com.hdl.ruler.utils.DateUtils;
import com.shix.shixipc.C1113R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RulerView extends RecyclerView {
    private static final int TWO_HOUR = 43200000;
    private RulerAdapter adapter;
    /* access modifiers changed from: private */
    public float afterLenght;
    /* access modifiers changed from: private */
    public float beforeLength;
    private int centerLineColor = -9527297;
    private Paint centerLinePaint = new Paint();
    private int centerLineWidth = CUtils.dip2px(2.0f);
    /* access modifiers changed from: private */
    public int centerPointDuration;
    private Context context;
    /* access modifiers changed from: private */
    public long currentTimeMillis;
    /* access modifiers changed from: private */
    public int firstVisableItemPosition = 0;
    /* access modifiers changed from: private */
    public boolean isAutoScroll = true;
    /* access modifiers changed from: private */
    public boolean isDouble;
    /* access modifiers changed from: private */
    public boolean isSelectTimeArea;
    /* access modifiers changed from: private */
    public long lastTimeMillis;
    private long leftTime;
    /* access modifiers changed from: private */
    public float mScale;
    private int mScreenHeight = 0;
    private int mScreenWidth = 0;
    /* access modifiers changed from: private */
    public MyLinearLayoutManager manager;
    private Timer moveTimer;
    /* access modifiers changed from: private */
    public OnBarMoveListener onBarMoveListener;
    /* access modifiers changed from: private */
    public OnSelectedTimeListener onSelectedTimeListener;
    private ScaleMode scaleMode = ScaleMode.KEY_HOUSE;
    private Paint selectAreaPaint = new Paint();
    private int selectTimeAreaColor = 1157282660;
    /* access modifiers changed from: private */
    public float selectTimeAreaDistanceLeft = -1.0f;
    /* access modifiers changed from: private */
    public float selectTimeAreaDistanceRight = -1.0f;
    private int selectTimeBorderColor = -345244;
    /* access modifiers changed from: private */
    public long selectTimeMax = 600000;
    /* access modifiers changed from: private */
    public long selectTimeMin = 60000;
    /* access modifiers changed from: private */
    public float selectTimeStrokeWidth = ((float) CUtils.dip2px(8.0f));
    /* access modifiers changed from: private */
    public long startTimeMillis;
    private Paint vedioArea = new Paint();
    private Paint vedioAreaPaint = new Paint();
    private RectF vedioAreaRect = new RectF();
    private int vedioBg = 7249919;
    private List<TimeSlot> vedioTimeSlot = new ArrayList();
    private int viewHeight = CUtils.dip2px(75.0f);
    /* access modifiers changed from: private */
    public float zoom = -260.0f;

    public RulerView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, C1113R.styleable.RulerView);
            setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            obtainStyledAttributes.recycle();
            init(context2);
        }
    }

    private class MyLinearLayoutManager extends LinearLayoutManager {
        private boolean iscanScrollHorizontally = true;

        public MyLinearLayoutManager(Context context) {
            super(context);
        }

        public boolean canScrollHorizontally() {
            return this.iscanScrollHorizontally;
        }

        public void setIscanScrollHorizontally(boolean z) {
            this.iscanScrollHorizontally = z;
        }
    }

    public void setIsCanScrollBar(boolean z) {
        MyLinearLayoutManager myLinearLayoutManager = this.manager;
        if (myLinearLayoutManager != null) {
            myLinearLayoutManager.setIscanScrollHorizontally(z);
        }
    }

    private void init(Context context2) {
        initPaint();
        this.manager = new MyLinearLayoutManager(context2);
        this.manager.setOrientation(0);
        setLayoutManager(this.manager);
        this.adapter = new RulerAdapter(context2);
        this.adapter.setScaleMode(this.scaleMode);
        this.adapter.setZoom(this.zoom);
        setAdapter(this.adapter);
        WindowManager windowManager = (WindowManager) context2.getSystemService("window");
        windowManager.getDefaultDisplay().getSize(new Point());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        double d = (double) (((float) this.mScreenWidth) / 2.0f);
        double d2 = (double) this.zoom;
        Double.isNaN(d2);
        Double.isNaN(d);
        this.centerPointDuration = (int) (d / ((d2 + 320.0d) / 600000.0d));
        addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                boolean z = false;
                if (RulerView.this.isAutoScroll) {
                    boolean unused = RulerView.this.isAutoScroll = false;
                    return;
                }
                View findViewByPosition = RulerView.this.manager.findViewByPosition(RulerView.this.manager.findFirstVisibleItemPosition());
                if (findViewByPosition != null) {
                    RulerView rulerView = RulerView.this;
                    int unused2 = rulerView.firstVisableItemPosition = rulerView.manager.findFirstVisibleItemPosition();
                    RulerView rulerView2 = RulerView.this;
                    double todayStart = (double) DateUtils.getTodayStart(rulerView2.startTimeMillis);
                    double abs = (double) ((int) (((float) Math.abs(findViewByPosition.getLeft())) + (((float) RulerView.this.firstVisableItemPosition) * (RulerView.this.zoom + 320.0f))));
                    double access$300 = (double) RulerView.this.zoom;
                    Double.isNaN(access$300);
                    Double.isNaN(abs);
                    Double.isNaN(todayStart);
                    double d = todayStart + (abs / ((access$300 + 320.0d) / 600000.0d));
                    double access$600 = (double) RulerView.this.centerPointDuration;
                    Double.isNaN(access$600);
                    long unused3 = rulerView2.currentTimeMillis = ((long) (d + access$600)) - 43200000;
                    if (RulerView.this.onBarMoveListener != null) {
                        OnBarMoveListener access$700 = RulerView.this.onBarMoveListener;
                        if (i > 0) {
                            z = true;
                        }
                        access$700.onDragBar(z, RulerView.this.currentTimeMillis);
                    }
                }
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    boolean unused = RulerView.this.isAutoScroll = true;
                    if (RulerView.this.currentTimeMillis < DateUtils.getTodayStart(RulerView.this.startTimeMillis)) {
                        if (RulerView.this.onBarMoveListener != null) {
                            RulerView.this.onBarMoveListener.onMoveExceedStartTime();
                        }
                        RulerView rulerView = RulerView.this;
                        rulerView.setCurrentTimeMillis(DateUtils.getTodayStart(rulerView.startTimeMillis));
                        RulerView.this.toTodayStartPostion();
                    } else if (RulerView.this.currentTimeMillis > DateUtils.getTodayEnd(RulerView.this.startTimeMillis)) {
                        if (RulerView.this.onBarMoveListener != null) {
                            RulerView.this.onBarMoveListener.onMoveExceedEndTime();
                        }
                        RulerView rulerView2 = RulerView.this;
                        rulerView2.setCurrentTimeMillis(DateUtils.getTodayEnd(rulerView2.startTimeMillis));
                        RulerView.this.toTodayEndPostion();
                    } else if (RulerView.this.onBarMoveListener != null) {
                        RulerView.this.onBarMoveListener.onBarMoveFinish(RulerView.this.currentTimeMillis);
                    }
                } else {
                    RulerView.this.onBarMoveListener.onBarMoving(RulerView.this.currentTimeMillis);
                    RulerView.this.closeMove();
                }
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (RulerView.this.isSelectTimeArea) {
                    int action = motionEvent.getAction();
                    if (action != 0 && action == 2) {
                        float x = motionEvent.getX();
                        if (Math.abs(x - RulerView.this.selectTimeAreaDistanceLeft) < Math.abs(x - RulerView.this.selectTimeAreaDistanceRight)) {
                            float access$1200 = ((RulerView.this.selectTimeAreaDistanceRight - x) + RulerView.this.selectTimeStrokeWidth) / ((RulerView.this.zoom + 320.0f) / 600000.0f);
                            if (((float) RulerView.this.selectTimeMin) < access$1200 && access$1200 < ((float) RulerView.this.selectTimeMax)) {
                                float unused = RulerView.this.selectTimeAreaDistanceLeft = x;
                                if (RulerView.this.onSelectedTimeListener != null) {
                                    RulerView.this.onSelectedTimeListener.onDragging(RulerView.this.getSelectStartTime(), RulerView.this.getSelectEndTime());
                                }
                            } else if (access$1200 >= ((float) RulerView.this.selectTimeMax)) {
                                RulerView.this.onSelectedTimeListener.onMaxTime();
                            } else if (access$1200 <= ((float) RulerView.this.selectTimeMin)) {
                                RulerView.this.onSelectedTimeListener.onMinTime();
                            }
                        } else {
                            float access$1100 = (x - (RulerView.this.selectTimeAreaDistanceLeft + RulerView.this.selectTimeStrokeWidth)) / ((RulerView.this.zoom + 320.0f) / 600000.0f);
                            if (((float) RulerView.this.selectTimeMin) < access$1100 && access$1100 < ((float) RulerView.this.selectTimeMax)) {
                                float unused2 = RulerView.this.selectTimeAreaDistanceRight = x;
                                if (RulerView.this.onSelectedTimeListener != null) {
                                    RulerView.this.onSelectedTimeListener.onDragging(RulerView.this.getSelectStartTime(), RulerView.this.getSelectEndTime());
                                }
                            } else if (RulerView.this.onSelectedTimeListener != null) {
                                if (access$1100 >= ((float) RulerView.this.selectTimeMax)) {
                                    RulerView.this.onSelectedTimeListener.onMaxTime();
                                } else if (access$1100 <= ((float) RulerView.this.selectTimeMin)) {
                                    RulerView.this.onSelectedTimeListener.onMinTime();
                                }
                            }
                        }
                        RulerView.this.postInvalidate();
                    }
                } else if (motionEvent.getAction() == 0) {
                    boolean unused3 = RulerView.this.isDouble = false;
                } else if (motionEvent.getAction() == 2) {
                    if (motionEvent.getPointerCount() == 2 && RulerView.this.isDouble) {
                        RulerView rulerView = RulerView.this;
                        float unused4 = rulerView.afterLenght = rulerView.getDistance(motionEvent);
                        if (RulerView.this.beforeLength == 0.0f) {
                            RulerView rulerView2 = RulerView.this;
                            float unused5 = rulerView2.beforeLength = rulerView2.afterLenght;
                        }
                        if (Math.abs(RulerView.this.afterLenght - RulerView.this.beforeLength) > 5.0f) {
                            RulerView rulerView3 = RulerView.this;
                            float unused6 = rulerView3.mScale = rulerView3.afterLenght / RulerView.this.beforeLength;
                            RulerView rulerView4 = RulerView.this;
                            float unused7 = rulerView4.beforeLength = rulerView4.afterLenght;
                            RulerView.this.onZooming();
                        }
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (RulerView.this.isDouble) {
                        boolean unused8 = RulerView.this.isAutoScroll = false;
                        new Timer().schedule(new TimerTask() {
                            public void run() {
                                RulerView.this.post(new Runnable() {
                                    public void run() {
                                        RulerView.this.setIsCanScrollBar(true);
                                    }
                                });
                            }
                        }, 100);
                    }
                } else if ((motionEvent.getAction() & 255) == 5 && motionEvent.getPointerCount() == 2) {
                    RulerView.this.setIsCanScrollBar(false);
                    RulerView rulerView5 = RulerView.this;
                    long unused9 = rulerView5.lastTimeMillis = rulerView5.getCurrentTimeMillis();
                    RulerView rulerView6 = RulerView.this;
                    float unused10 = rulerView6.beforeLength = rulerView6.getDistance(motionEvent);
                    boolean unused11 = RulerView.this.isDouble = true;
                    boolean unused12 = RulerView.this.isAutoScroll = false;
                    return true;
                }
                return false;
            }
        });
    }

    public long getSelectEndTime() {
        if (this.selectTimeAreaDistanceRight == -1.0f) {
            return this.currentTimeMillis + 120000 + 30000;
        }
        return this.currentTimeMillis - ((long) (((((float) (getWidth() / 2)) - this.selectTimeAreaDistanceRight) + (this.selectTimeStrokeWidth / 2.0f)) / ((this.zoom + 320.0f) / 600000.0f)));
    }

    public long getSelectStartTime() {
        long j;
        long width;
        if (this.selectTimeAreaDistanceLeft == -1.0f) {
            j = this.currentTimeMillis - 120000;
            width = 30000;
        } else {
            j = this.currentTimeMillis;
            width = (long) (((((float) (getWidth() / 2)) - this.selectTimeAreaDistanceLeft) - (this.selectTimeStrokeWidth / 2.0f)) / ((this.zoom + 320.0f) / 600000.0f));
        }
        return j - width;
    }

    public List<TimeSlot> getVedioTimeSlot() {
        return this.vedioTimeSlot;
    }

    public void setVedioTimeSlot(List<TimeSlot> list) {
        this.vedioTimeSlot.clear();
        this.vedioTimeSlot.addAll(list);
        this.adapter.setVedioTimeSlot(list);
    }

    /* access modifiers changed from: private */
    public void onZooming() {
        if (this.mScale > 1.0f) {
            this.zoom += 30.0f;
        } else {
            this.zoom -= 30.0f;
        }
        float f = this.zoom;
        if (f < -160.0f) {
            this.scaleMode = ScaleMode.KEY_HOUSE;
            if (Math.abs(this.zoom + 320.0f) < 30.0f) {
                this.zoom = -290.0f;
                OnBarMoveListener onBarMoveListener2 = this.onBarMoveListener;
                if (onBarMoveListener2 != null) {
                    onBarMoveListener2.onMinScale();
                }
            }
        } else if (((double) f) < 480.0d) {
            this.scaleMode = ScaleMode.KEY_MINUTE;
            this.isAutoScroll = false;
        } else {
            this.scaleMode = ScaleMode.KEY_MINUTE;
            this.zoom = 480.0f;
            OnBarMoveListener onBarMoveListener3 = this.onBarMoveListener;
            if (onBarMoveListener3 != null) {
                onBarMoveListener3.onMaxScale();
            }
        }
        double d = (double) (((float) this.mScreenWidth) / 2.0f);
        double d2 = (double) this.zoom;
        Double.isNaN(d2);
        Double.isNaN(d);
        this.centerPointDuration = (int) (d / ((d2 + 320.0d) / 600000.0d));
        setCurrentTimeMillis(this.lastTimeMillis);
        this.adapter.setZoom(this.zoom);
        this.adapter.setScaleMode(this.scaleMode);
    }

    /* access modifiers changed from: private */
    public void toTodayStartPostion() {
        this.manager.scrollToPositionWithOffset(72, getOffsetByDuration((long) this.centerPointDuration));
    }

    /* access modifiers changed from: private */
    public void toTodayEndPostion() {
        this.manager.scrollToPositionWithOffset(216, getOffsetByDuration((long) this.centerPointDuration));
    }

    private int getOffsetByDuration(long j) {
        return (int) (((this.zoom + 320.0f) / 600000.0f) * ((float) j));
    }

    /* access modifiers changed from: private */
    public float getDistance(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public synchronized void setCurrentTimeMillis(long j) {
        this.currentTimeMillis = j;
        this.startTimeMillis = j;
        this.lastTimeMillis = j;
        updateCenteLinePostion();
    }

    public void updateCenteLinePostion() {
        this.leftTime = this.currentTimeMillis - ((long) this.centerPointDuration);
        int hour = (DateUtils.getHour(this.leftTime) * 6) + (DateUtils.getMinute(this.leftTime) / 10) + 72;
        if (this.leftTime < DateUtils.getTodayStart(this.currentTimeMillis)) {
            hour -= 144;
        }
        this.manager.scrollToPositionWithOffset(hour, (int) (((float) (-((int) (((this.zoom + 320.0f) / 600000.0f) * ((float) DateUtils.getMinuteMillisecond(this.leftTime)))))) % (this.zoom + 320.0f)));
    }

    public void openMove() {
        this.isAutoScroll = true;
        Timer timer = this.moveTimer;
        if (timer != null) {
            timer.cancel();
            this.moveTimer = null;
        }
        this.moveTimer = new Timer();
        this.moveTimer.schedule(new TimerTask() {
            public void run() {
                RulerView.this.post(new Runnable() {
                    public void run() {
                        boolean unused = RulerView.this.isAutoScroll = true;
                        if (RulerView.this.onBarMoveListener != null) {
                            RulerView.this.onBarMoveListener.onBarMoving(RulerView.this.currentTimeMillis);
                        }
                        long unused2 = RulerView.this.currentTimeMillis = RulerView.this.currentTimeMillis + 1000;
                        RulerView.this.updateCenteLinePostion();
                    }
                });
            }
        }, 0, 1000);
    }

    public void closeMove() {
        this.isAutoScroll = true;
        Timer timer = this.moveTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void initPaint() {
        this.centerLinePaint.setAntiAlias(true);
        this.centerLinePaint.setStrokeWidth((float) this.centerLineWidth);
        this.centerLinePaint.setColor(this.centerLineColor);
        this.selectAreaPaint.setColor(this.selectTimeBorderColor);
        this.selectAreaPaint.setAntiAlias(true);
        this.selectAreaPaint.setStrokeCap(Paint.Cap.ROUND);
        this.selectAreaPaint.setStyle(Paint.Style.STROKE);
        this.selectAreaPaint.setStrokeWidth(this.selectTimeStrokeWidth);
        this.vedioArea.setColor(this.selectTimeAreaColor);
        this.vedioArea.setAntiAlias(true);
        this.vedioAreaPaint.setAntiAlias(true);
        this.vedioAreaPaint.setColor(this.vedioBg);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawCenterLine(canvas);
        drawSelectTimeArea(canvas);
    }

    private void drawSelectTimeArea(Canvas canvas) {
        if (this.isSelectTimeArea) {
            if (this.selectTimeAreaDistanceLeft < 1.0f) {
                this.selectTimeAreaDistanceLeft = ((((float) getWidth()) / 2.0f) - (((this.zoom + 320.0f) / 600000.0f) * 150000.0f)) - (this.selectTimeStrokeWidth / 2.0f);
            }
            if (this.selectTimeAreaDistanceRight < 1.0f) {
                this.selectTimeAreaDistanceRight = (((float) getWidth()) / 2.0f) + (((this.zoom + 320.0f) / 600000.0f) * 150000.0f) + (this.selectTimeStrokeWidth / 2.0f);
            }
            this.selectAreaPaint.setStrokeWidth(this.selectTimeStrokeWidth);
            float f = this.selectTimeAreaDistanceLeft;
            canvas.drawLine(f, this.selectTimeStrokeWidth / 2.0f, f, ((float) (this.viewHeight - (CUtils.dip2px(12.0f) * 2))) - (this.selectTimeStrokeWidth / 2.0f), this.selectAreaPaint);
            float f2 = this.selectTimeAreaDistanceRight;
            canvas.drawLine(f2, this.selectTimeStrokeWidth / 2.0f, f2, ((float) (this.viewHeight - (CUtils.dip2px(12.0f) * 2))) - (this.selectTimeStrokeWidth / 2.0f), this.selectAreaPaint);
            this.selectAreaPaint.setStrokeWidth(this.selectTimeStrokeWidth / 3.0f);
            float f3 = this.selectTimeAreaDistanceLeft;
            float f4 = this.selectTimeStrokeWidth;
            canvas.drawLine(f3, f4 / 6.0f, this.selectTimeAreaDistanceRight, f4 / 6.0f, this.selectAreaPaint);
            canvas.drawLine(this.selectTimeAreaDistanceLeft, ((float) (this.viewHeight - (CUtils.dip2px(12.0f) * 2))) - (this.selectTimeStrokeWidth / 6.0f), this.selectTimeAreaDistanceRight, ((float) (this.viewHeight - (CUtils.dip2px(12.0f) * 2))) - (this.selectTimeStrokeWidth / 6.0f), this.selectAreaPaint);
            canvas.drawRect(this.selectTimeAreaDistanceLeft, 0.0f, this.selectTimeAreaDistanceRight, (float) (this.viewHeight - (CUtils.dip2px(12.0f) * 2)), this.vedioArea);
            this.onSelectedTimeListener.onDragging(getSelectStartTime(), getSelectEndTime());
        }
    }

    private void drawCenterLine(Canvas canvas) {
        canvas.drawLine((float) (getWidth() / 2), 0.0f, (float) (getWidth() / 2), (float) (this.viewHeight - (CUtils.dip2px(12.0f) * 2)), this.centerLinePaint);
    }

    public void setOnBarMoveListener(OnBarMoveListener onBarMoveListener2) {
        this.onBarMoveListener = onBarMoveListener2;
    }

    public long getCurrentTimeMillis() {
        return this.currentTimeMillis;
    }

    public boolean isSelectTimeArea() {
        return this.isSelectTimeArea;
    }

    public void setSelectTimeArea(boolean z) {
        this.lastTimeMillis = getCurrentTimeMillis();
        this.isSelectTimeArea = z;
        if (z && this.scaleMode == ScaleMode.KEY_HOUSE) {
            this.scaleMode = ScaleMode.KEY_MINUTE;
            this.zoom = 300.0f;
            double d = (double) (((float) this.mScreenWidth) / 2.0f);
            double d2 = (double) this.zoom;
            Double.isNaN(d2);
            Double.isNaN(d);
            this.centerPointDuration = (int) (d / ((d2 + 320.0d) / 600000.0d));
            setCurrentTimeMillis(this.lastTimeMillis);
            this.adapter.setZoom(this.zoom);
            this.adapter.setScaleMode(this.scaleMode);
        }
        this.selectTimeAreaDistanceLeft = -1.0f;
        this.selectTimeAreaDistanceRight = -1.0f;
        setIsCanScrollBar(!this.isSelectTimeArea);
        postInvalidate();
    }

    public void setOnSelectedTimeListener(OnSelectedTimeListener onSelectedTimeListener2) {
        this.onSelectedTimeListener = onSelectedTimeListener2;
    }

    public void setOrientation(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.e("hdltag", "onConfigurationChanged(RulerView.java:719):------------------横竖屏切换了-----------------");
        int i = this.mScreenHeight;
        this.mScreenHeight = this.mScreenWidth;
        this.mScreenWidth = i;
        double d = (double) (((float) this.mScreenWidth) / 2.0f);
        double d2 = (double) this.zoom;
        Double.isNaN(d2);
        Double.isNaN(d);
        this.centerPointDuration = (int) (d / ((d2 + 320.0d) / 600000.0d));
        postInvalidate();
        setCurrentTimeMillis(this.currentTimeMillis);
        if (configuration.orientation == 2) {
            this.viewHeight = CUtils.dip2px(75.0f);
        } else {
            this.viewHeight = CUtils.dip2px(75.0f);
        }
        this.adapter.setViewHeight(this.viewHeight);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            Log.e("RulerView", e.getMessage());
            return false;
        }
    }
}
