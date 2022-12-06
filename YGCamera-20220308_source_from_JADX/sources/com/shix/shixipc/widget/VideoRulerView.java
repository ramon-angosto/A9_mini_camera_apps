package com.shix.shixipc.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VideoRulerView extends View {
    public static final float LINE_DIVIDER = 2.0f;
    public static final int Mode_0 = 0;
    public static final int Mode_1 = 1;
    public static final int Mode_2 = 2;
    public static final int STATUS_ZOOM_IN = 2;
    public static final int STATUS_ZOOM_OUT = 1;
    private static final float TEXT_SIZE = 10.0f;
    static float lastItemDivider = 2.0f;
    public static int valueToSencond;
    private float ITEM_MAX_HEIGHT = 30.0f;
    private float ITEM_MIN_HEIGHT = 15.0f;
    public int Mode = 2;
    private int REFRESH_TIME = (valueToSencond * 1000);
    Paint alarmPaint = new Paint();
    Calendar calendar = Calendar.getInstance();
    Calendar calendar1 = Calendar.getInstance();
    private float centerPointX;
    private float centerPointY;
    private int currentStatus;
    Paint faceWhitePaint = new Paint();
    boolean isMoving = false;
    boolean isScaling = false;
    int largeScaleValue = 60;
    private double lastFingerDis;
    Paint linePaint = new Paint();
    List<RecordInfo> list = new ArrayList();
    private float mDensity;
    public float mHeight;
    float mLineDivider = 2.0f;
    private OnValueChangeListener mListener;
    public float mMove;
    int mValue;
    public float mWidth;
    long maxTimestamp;
    long minTimestamp;
    int minValue = 0;
    public float mlastX;
    int mode = 0;
    private float scaledRatio;
    Calendar selectCalendar = Calendar.getInstance();
    Paint shadowPaint = new Paint();
    int smallScaleValue = 10;
    TextPaint textPaint = new TextPaint(1);
    private float textWidth;
    private String[] timeString0 = {"00:00", "00:10", "00:20", "00:30", "00:40", "00:50", "01:00", "01:10", "01:20", "01:30", "01:40", "01:50", "02:00", "02:10", "02:20", "02:30", "02:40", "02:50", "03:00", "03:10", "03:20", "03:30", "03:40", "03:50", "04:00", "04:10", "04:20", "04:30", "04:40", "04:50", "05:00", "05:10", "05:20", "05:30", "05:40", "05:50", "06:00", "06:10", "06:20", "06:30", "06:40", "06:50", "07:00", "07:10", "07:20", "07:30", "07:40", "07:50", "08:00", "08:10", "08:20", "08:30", "08:40", "08:50", "09:00", "09:10", "09:20", "09:30", "09:40", "09:40", "10:00", "10:10", "10:20", "10:30", "10:40", "10:50", "11:00", "11:10", "11:20", "11:30", "11:40", "11:50", "12:00", "12:10", "12:20", "12:30", "12:40", "12:50", "13:00", "13:10", "13:20", "13:30", "13:40", "13:50", "14:00", "14:10", "14:20", "14:30", "14:40", "14:50", "15:00", "15:10", "15:20", "15:30", "15:40", "15:50", "16:00", "16:10", "16:20", "16:30", "16:40", "16:50", "17:00", "17:10", "17:20", "17:30", "17:40", "17:50", "18:00", "18:10", "18:20", "18:30", "18:40", "18:50", "19:00", "19:10", "19:20", "19:30", "19:40", "19:50", "20:00", "20:10", "20:20", "20:30", "20:40", "20:50", "21:00", "21:10", "21:20", "21:30", "21:40", "21:50", "22:00", "22:10", "22:20", "22:30", "22:40", "22:50", "23:00", "23:10", "23:20", "23:30", "23:40", "23:50"};
    private String[] timeString1 = {"00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"};
    private String[] timeString2 = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    public String[] useString;

    private float countLeftStart(int i, float f, float f2) {
        return f - ((f2 * 5.0f) / 2.0f);
    }

    public OnValueChangeListener getmListener() {
        return this.mListener;
    }

    public void setmListener(OnValueChangeListener onValueChangeListener) {
        this.mListener = onValueChangeListener;
    }

    public VideoRulerView(Context context) {
        super(context);
    }

    public VideoRulerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initData();
    }

    /* access modifiers changed from: package-private */
    public void initData() {
        this.mMove = 0.0f;
        this.useString = this.timeString2;
        valueToSencond = 60;
        this.mDensity = getContext().getResources().getDisplayMetrics().density;
        this.shadowPaint.setStyle(Paint.Style.FILL);
        this.shadowPaint.setColor(Color.parseColor("#3087CEFA"));
        this.alarmPaint.setStyle(Paint.Style.FILL);
        this.alarmPaint.setColor(Color.parseColor("#33ff0000"));
        this.linePaint.setStrokeWidth(2.0f);
        this.linePaint.setColor(-16777216);
        this.textPaint.setTextSize(this.mDensity * TEXT_SIZE);
        this.textWidth = Layout.getDesiredWidth("0", this.textPaint);
    }

    public void setVedioArea(List<RecordInfo> list2) {
        this.list.clear();
        this.list.addAll(list2);
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawScaleLine(canvas);
        drawMiddleLine(canvas);
        drawShadow(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mWidth = (float) getWidth();
        this.mHeight = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void drawScaleLine(Canvas canvas) {
        float f = this.mWidth;
        float f2 = 0.0f;
        int i = 0;
        while (f2 < f * 2.0f) {
            float f3 = (this.mWidth / 2.0f) + this.mMove;
            float f4 = (float) i;
            float f5 = this.mDensity;
            float f6 = f3 + (f4 * f5 * this.mLineDivider);
            int i2 = this.mValue;
            if ((i2 + i) % this.largeScaleValue == 0) {
                canvas.drawLine(f6, 0.0f, f6, f5 * this.ITEM_MAX_HEIGHT, this.linePaint);
                int i3 = this.mValue;
                int i4 = this.largeScaleValue;
                String[] strArr = this.useString;
                if (((i3 + i) / i4) % strArr.length < 0) {
                    canvas.drawText(strArr[strArr.length + (((i3 + i) / i4) % strArr.length)], countLeftStart(i3 + i, f6, this.textWidth), ((float) getHeight()) - this.textWidth, this.textPaint);
                } else {
                    canvas.drawText(strArr[((i3 + i) / i4) % strArr.length], countLeftStart(i3 + i, f6, this.textWidth), ((float) getHeight()) - this.textWidth, this.textPaint);
                }
            } else if ((i2 + i) % this.smallScaleValue == 0) {
                canvas.drawLine(f6, 0.0f, f6, f5 * this.ITEM_MIN_HEIGHT, this.linePaint);
            }
            float f7 = (this.mWidth / 2.0f) + this.mMove;
            float f8 = this.mDensity;
            float f9 = f7 - ((f4 * f8) * this.mLineDivider);
            int i5 = this.mValue;
            if ((i5 - i) % this.largeScaleValue == 0) {
                canvas.drawLine(f9, 0.0f, f9, f8 * this.ITEM_MAX_HEIGHT, this.linePaint);
                int i6 = this.mValue;
                int i7 = this.largeScaleValue;
                String[] strArr2 = this.useString;
                if (((i6 - i) / i7) % strArr2.length < 0) {
                    canvas.drawText(strArr2[strArr2.length + (((i6 - i) / i7) % strArr2.length)], countLeftStart(i6 - i, f9, this.textWidth), ((float) getHeight()) - this.textWidth, this.textPaint);
                } else {
                    canvas.drawText(strArr2[((i6 - i) / i7) % strArr2.length], countLeftStart(i6 - i, f9, this.textWidth), ((float) getHeight()) - this.textWidth, this.textPaint);
                }
            } else if ((i5 - i) % this.smallScaleValue == 0) {
                canvas.drawLine(f9, 0.0f, f9, f8 * this.ITEM_MIN_HEIGHT, this.linePaint);
            }
            f2 += this.mDensity * this.mLineDivider;
            i++;
        }
    }

    public void drawShadow(Canvas canvas) {
        for (int i = 0; i < this.list.size(); i++) {
            RecordInfo recordInfo = this.list.get(i);
            long startTime = recordInfo.getStartTime();
            long j = this.minTimestamp;
            if (startTime < j) {
                recordInfo.setStartTime(j);
            }
            long endTime = recordInfo.getEndTime();
            long j2 = this.maxTimestamp;
            if (endTime > j2) {
                recordInfo.setEndTime(j2);
            }
            float f = ((this.mWidth / 2.0f) - ((((float) (this.mValue - getmValue(recordInfo.getStartTime()))) * this.mDensity) * this.mLineDivider)) + ((this.mMove * 99.0f) / 100.0f);
            float f2 = ((this.mWidth / 2.0f) - ((((float) (this.mValue - getmValue(recordInfo.getEndTime()))) * this.mDensity) * this.mLineDivider)) + ((this.mMove * 99.0f) / 100.0f);
            if (recordInfo.getType() == 2) {
                canvas.drawRect(f, 0.0f, f2, this.mHeight - ((this.mDensity * TEXT_SIZE) * 2.0f), this.alarmPaint);
            } else {
                canvas.drawRect(f, 0.0f, f2, this.mHeight - ((this.mDensity * TEXT_SIZE) * 2.0f), this.shadowPaint);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int actionMasked = motionEvent.getActionMasked() & motionEvent.getAction();
        if (actionMasked == 0) {
            if (motionEvent.getPointerCount() == 1) {
                this.isMoving = true;
                this.isScaling = false;
                this.mode = 0;
            } else {
                this.mode = 1;
                this.isMoving = false;
                this.isScaling = true;
            }
            this.mlastX = (float) x;
            this.mMove = 0.0f;
        } else if (actionMasked == 1) {
            if (motionEvent.getPointerCount() == 1 && this.isMoving && !this.isScaling) {
                this.isMoving = false;
                this.mValue -= (int) (this.mMove / (this.mLineDivider * this.mDensity));
                if (this.mValue <= 1) {
                    this.mValue = 1;
                }
                int i = this.mValue;
                int i2 = valueToSencond;
                if (i >= 86389 / i2) {
                    this.mValue = 86389 / i2;
                }
                notifyValueChange();
            } else if (this.isScaling) {
                this.isMoving = false;
                this.mValue -= (int) (this.mMove / (this.mLineDivider * this.mDensity));
            }
            this.mMove = 0.0f;
            this.mLineDivider = 2.0f;
            lastItemDivider = 2.0f;
            postInvalidate();
        } else if (actionMasked != 2) {
            if (actionMasked != 3) {
                if (actionMasked != 5) {
                    if (actionMasked == 6 && motionEvent.getPointerCount() == 2) {
                        lastItemDivider = this.mLineDivider;
                    }
                } else if (motionEvent.getPointerCount() == 2) {
                    this.lastFingerDis = (double) distanceBetweenFingers(motionEvent);
                    this.mode = 1;
                }
            }
        } else if (motionEvent.getPointerCount() == 1 && this.mode == 0) {
            this.isMoving = true;
            this.mMove = ((float) x) - this.mlastX;
            if (Math.abs(this.mMove) > 15.0f) {
                this.mValue -= (int) (this.mMove / ((this.mLineDivider * this.mDensity) * 100.0f));
                Log.e("value", "value  " + this.mValue);
                postInvalidate();
                onMoving();
            }
        } else if (motionEvent.getPointerCount() == 2) {
            centerPointBetweenFingers(motionEvent);
            double distanceBetweenFingers = (double) distanceBetweenFingers(motionEvent);
            if (distanceBetweenFingers > this.lastFingerDis) {
                this.currentStatus = 1;
            } else {
                this.currentStatus = 2;
            }
            if ((this.Mode == 0 && this.currentStatus == 1) || (this.Mode == 2 && this.currentStatus == 2)) {
                Log.e("wzytest", "Mode_0 时放大 和 Mode_4 时候缩小不做任何处理");
            } else {
                double d = this.lastFingerDis;
                Double.isNaN(distanceBetweenFingers);
                this.scaledRatio = (float) (distanceBetweenFingers / d);
                this.shadowPaint.setStrokeWidth(this.scaledRatio * 6.0f);
                this.mLineDivider = lastItemDivider * this.scaledRatio;
                this.isScaling = true;
                if (this.currentStatus == 2 && this.Mode == 0) {
                    double d2 = (double) this.mLineDivider;
                    Double.isNaN(d2);
                    if (d2 * 1.5d < 2.0d) {
                        this.mLineDivider = 2.0f;
                        lastItemDivider = 2.0f;
                        this.useString = this.timeString1;
                        this.Mode = 1;
                        valueToSencond *= 3;
                    }
                } else if (this.currentStatus == 2 && this.Mode == 1) {
                    if (this.mLineDivider * 2.0f < 2.0f) {
                        this.mLineDivider = 2.0f;
                        lastItemDivider = 2.0f;
                        this.useString = this.timeString2;
                        this.Mode = 2;
                        valueToSencond *= 2;
                    }
                } else if (this.currentStatus == 1 && this.Mode == 2) {
                    double d3 = (double) this.mLineDivider;
                    Double.isNaN(d3);
                    if (d3 / 1.5d > 2.0d) {
                        this.mLineDivider = 2.0f;
                        lastItemDivider = 2.0f;
                        this.useString = this.timeString1;
                        this.Mode = 1;
                        valueToSencond /= 2;
                    }
                } else if (this.currentStatus == 1 && this.Mode == 1 && this.mLineDivider / 2.0f > 2.0f) {
                    this.mLineDivider = 2.0f;
                    lastItemDivider = 2.0f;
                    this.useString = this.timeString0;
                    this.Mode = 0;
                    valueToSencond /= 3;
                }
                postInvalidate();
            }
        }
        return true;
    }

    private void notifyValueChange() {
        OnValueChangeListener onValueChangeListener = this.mListener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange((float) this.mValue);
        }
    }

    private void onMoving() {
        OnValueChangeListener onValueChangeListener = this.mListener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onMoving();
        }
    }

    public float getValue() {
        return (float) this.mValue;
    }

    private void drawMiddleLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth((float) 5);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        float f = this.mWidth;
        float f2 = f / 2.0f;
        canvas.drawLine(f2, 0.0f, f / 2.0f, this.mHeight, paint);
    }

    public static int getNowValue() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(11);
        return ((((i * 60) + instance.get(12)) * 60) + instance.get(13)) / valueToSencond;
    }

    public void setCurrentIime(long j) {
        if (!this.isMoving) {
            this.calendar.setTimeInMillis(j);
            int i = this.calendar.get(11);
            this.mValue = ((((i * 60) + this.calendar.get(12)) * 60) + this.calendar.get(13)) / valueToSencond;
            invalidate();
        }
    }

    public void setSelectTime(int i, int i2, int i3) {
        this.selectCalendar.set(1, i);
        this.selectCalendar.set(2, i2 - 1);
        this.selectCalendar.set(5, i3);
        this.selectCalendar.set(11, 0);
        this.selectCalendar.set(12, 0);
        this.selectCalendar.set(13, 10);
        this.minTimestamp = this.selectCalendar.getTimeInMillis();
        this.selectCalendar.set(11, 23);
        this.selectCalendar.set(12, 59);
        this.selectCalendar.set(13, 50);
        this.maxTimestamp = this.selectCalendar.getTimeInMillis();
        Log.e("timesample ", "min  " + this.minTimestamp + "  max    " + this.maxTimestamp);
    }

    public String getTime(float f) {
        int i = valueToSencond;
        int i2 = (int) ((((float) i) * f) / 86400.0f);
        int i3 = RemoteMessageConst.DEFAULT_TTL * i2;
        float f2 = (float) i3;
        int i4 = (int) (((((float) i) * f) - f2) / 3600.0f);
        int i5 = i4 * 3600;
        int i6 = ((int) (((((float) i) * f) - ((float) i5)) - f2)) / 60;
        int i7 = (((((int) f) * i) - i5) - (i6 * 60)) - i3;
        Calendar calendar2 = (Calendar) this.calendar.clone();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar2.add(5, i2);
        calendar2.set(11, i4);
        calendar2.set(12, i6);
        calendar2.set(13, i7);
        return simpleDateFormat.format(calendar2.getTime());
    }

    public long getTimeInMillis(float f) {
        int i = valueToSencond;
        int i2 = ((int) ((((float) i) * f) / 86400.0f)) * RemoteMessageConst.DEFAULT_TTL;
        float f2 = (float) i2;
        int i3 = (int) (((((float) i) * f) - f2) / 3600.0f);
        int i4 = i3 * 3600;
        int i5 = ((int) (((((float) i) * f) - ((float) i4)) - f2)) / 60;
        Calendar calendar2 = (Calendar) this.calendar.clone();
        calendar2.set(11, i3);
        calendar2.set(12, i5);
        calendar2.set(13, (((((int) f) * i) - i4) - (i5 * 60)) - i2);
        return calendar2.getTimeInMillis();
    }

    private int getmValue(long j) {
        this.calendar1.setTimeInMillis(j);
        this.calendar1.set(11, 0);
        this.calendar1.set(12, 0);
        this.calendar1.set(13, 0);
        return ((int) (j - this.calendar1.getTimeInMillis())) / (valueToSencond * 1000);
    }

    private float distanceBetweenFingers(MotionEvent motionEvent) {
        return (float) Math.sqrt(Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
    }

    private void centerPointBetweenFingers(MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        float x2 = motionEvent.getX(1);
        float y2 = motionEvent.getY(1);
        this.centerPointX = (x + x2) / 2.0f;
        this.centerPointY = (y + y2) / 2.0f;
    }
}
