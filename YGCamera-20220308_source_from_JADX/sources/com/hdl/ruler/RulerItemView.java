package com.hdl.ruler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.hdl.ruler.bean.ScaleMode;
import com.hdl.ruler.bean.TimeSlot;
import com.hdl.ruler.utils.CUtils;
import com.hdl.ruler.utils.DateUtils;
import java.util.ArrayList;
import java.util.List;

public class RulerItemView extends View {
    private static final int DEFAULT_RULER_SPACE = CUtils.dip2px(12.0f);
    private static final int MAX_SCALE = CUtils.dip2px(39.0f);
    private static final int MIN_SCALE = CUtils.dip2px(6.0f);
    private int alarmDetectColor;
    private Paint alarmDetectPaint;
    private int centerLineColor;
    private Paint centerLinePaint;
    private int centerLineWidth;
    private int divisor;
    private int faceDetectColor;
    private Paint faceDetectPaint;
    private int faceStrangerColor;
    private Paint faceStrangerPaint;
    private int faceWhiteListColor;
    private Paint faceWhiteListPaint;
    private TextPaint keyTickTextPaint;
    private Paint largeRulerPaint;
    private int rulerColor;
    private int rulerHeightBig;
    private int rulerHeightSamll;
    private int rulerSpace;
    private int rulerWidthBig;
    private int rulerWidthSamll;
    private ScaleMode scaleMode;
    private Paint selectAreaPaint;
    private int selectTimeAreaColor;
    private int selectTimeBorderColor;
    private float selectTimeStrokeWidth;
    private Paint smallRulerPaint;
    private int textColor;
    private int textSize;
    private int timeIndex;
    private int upAndDownLineColor;
    private Paint upAndDownLinePaint;
    private int upAndDownLineWidth;
    private Paint vedioArea;
    private Paint vedioAreaPaint;
    private RectF vedioAreaRect;
    private int vedioBg;
    private List<TimeSlot> vedioTimeSlot;
    private int viewHeight;

    public RulerItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RulerItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RulerItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.smallRulerPaint = new Paint();
        this.rulerColor = -4868683;
        this.rulerWidthSamll = CUtils.dip2px(0.5f);
        this.rulerHeightSamll = CUtils.dip2px(10.0f);
        this.rulerSpace = DEFAULT_RULER_SPACE;
        this.largeRulerPaint = new Paint();
        this.rulerWidthBig = CUtils.dip2px(0.5f);
        this.rulerHeightBig = CUtils.dip2px(20.0f);
        this.upAndDownLinePaint = new Paint();
        this.upAndDownLineWidth = CUtils.dip2px(1.0f);
        this.upAndDownLineColor = this.rulerColor;
        this.keyTickTextPaint = new TextPaint();
        this.textColor = -12303806;
        this.textSize = CUtils.dip2px(12.0f);
        this.centerLinePaint = new Paint();
        this.centerLineColor = -9527297;
        this.centerLineWidth = CUtils.dip2px(2.0f);
        this.vedioAreaPaint = new Paint();
        this.alarmDetectColor = 16753920;
        this.faceDetectColor = 255;
        this.faceWhiteListColor = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.faceStrangerColor = 16711680;
        this.vedioBg = 1617862655;
        this.vedioAreaRect = new RectF();
        this.selectAreaPaint = new Paint();
        this.selectTimeBorderColor = -345244;
        this.vedioArea = new Paint();
        this.selectTimeAreaColor = 872069988;
        this.selectTimeStrokeWidth = (float) CUtils.dip2px(8.0f);
        this.viewHeight = CUtils.dip2px(65.0f);
        this.scaleMode = ScaleMode.KEY_HOUSE;
        this.vedioTimeSlot = new ArrayList();
        setDivisor();
        initPaint();
    }

    /* renamed from: com.hdl.ruler.RulerItemView$1 */
    static /* synthetic */ class C05111 {
        static final /* synthetic */ int[] $SwitchMap$com$hdl$ruler$bean$ScaleMode = new int[ScaleMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.hdl.ruler.bean.ScaleMode[] r0 = com.hdl.ruler.bean.ScaleMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$hdl$ruler$bean$ScaleMode = r0
                int[] r0 = $SwitchMap$com$hdl$ruler$bean$ScaleMode     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.hdl.ruler.bean.ScaleMode r1 = com.hdl.ruler.bean.ScaleMode.KEY_HOUSE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$hdl$ruler$bean$ScaleMode     // Catch:{ NoSuchFieldError -> 0x001f }
                com.hdl.ruler.bean.ScaleMode r1 = com.hdl.ruler.bean.ScaleMode.KEY_MINUTE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hdl.ruler.RulerItemView.C05111.<clinit>():void");
        }
    }

    private void setDivisor() {
        if (C05111.$SwitchMap$com$hdl$ruler$bean$ScaleMode[this.scaleMode.ordinal()] != 1) {
            this.divisor = 1;
        } else {
            this.divisor = 10;
        }
    }

    public ScaleMode getScaleMode() {
        return this.scaleMode;
    }

    public void setScaleMode(ScaleMode scaleMode2) {
        this.scaleMode = scaleMode2;
        setDivisor();
    }

    private void initPaint() {
        this.smallRulerPaint.setAntiAlias(true);
        this.smallRulerPaint.setColor(this.rulerColor);
        this.smallRulerPaint.setStrokeWidth((float) this.rulerWidthSamll);
        this.largeRulerPaint.setAntiAlias(true);
        this.largeRulerPaint.setColor(this.rulerColor);
        this.largeRulerPaint.setStrokeWidth((float) this.rulerWidthBig);
        this.keyTickTextPaint.setAntiAlias(true);
        this.keyTickTextPaint.setColor(this.textColor);
        this.keyTickTextPaint.setTextSize((float) this.textSize);
        this.centerLinePaint.setAntiAlias(true);
        this.centerLinePaint.setStrokeWidth((float) this.centerLineWidth);
        this.centerLinePaint.setColor(this.centerLineColor);
        this.vedioAreaPaint.setAntiAlias(true);
        this.vedioAreaPaint.setColor(this.vedioBg);
        this.upAndDownLinePaint.setAntiAlias(true);
        this.upAndDownLinePaint.setColor(this.upAndDownLineColor);
        this.upAndDownLinePaint.setStrokeWidth((float) this.upAndDownLineWidth);
        this.selectAreaPaint.setColor(this.selectTimeBorderColor);
        this.selectAreaPaint.setAntiAlias(true);
        this.selectAreaPaint.setStrokeCap(Paint.Cap.ROUND);
        this.selectAreaPaint.setStyle(Paint.Style.STROKE);
        this.selectAreaPaint.setStrokeWidth(this.selectTimeStrokeWidth);
        this.vedioArea.setColor(this.selectTimeAreaColor);
        this.vedioArea.setAntiAlias(true);
        this.alarmDetectPaint = new Paint();
        this.alarmDetectPaint.setColor(Color.parseColor("#33ff0000"));
        this.alarmDetectPaint.setAntiAlias(true);
        this.faceDetectPaint = new Paint();
        this.faceDetectPaint.setColor(this.faceDetectColor);
        this.faceDetectPaint.setAntiAlias(true);
        this.faceWhiteListPaint = new Paint();
        this.faceWhiteListPaint.setColor(this.faceWhiteListColor);
        this.faceWhiteListPaint.setAntiAlias(true);
        this.faceStrangerPaint = new Paint();
        this.faceStrangerPaint.setColor(this.faceStrangerColor);
        this.faceStrangerPaint.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawUpAndDownLine(canvas);
        drawRuler(canvas);
        drawVedioArea(canvas);
    }

    private void drawVedioArea(Canvas canvas) {
        Canvas canvas2 = canvas;
        for (TimeSlot next : this.vedioTimeSlot) {
            int i = this.timeIndex;
            boolean isContainTime = DateUtils.isContainTime(next, (long) (i * 60 * 1000), (long) ((i * 60 * 1000) + 600000));
            long startTimeMillis = next.getStartTimeMillis();
            int i2 = this.timeIndex;
            boolean isCurrentTimeArea = DateUtils.isCurrentTimeArea(startTimeMillis, (long) (i2 * 60 * 1000), (long) ((i2 * 60 * 1000) + 600000));
            long endTimeMillis = next.getEndTimeMillis();
            int i3 = this.timeIndex;
            boolean isCurrentTimeArea2 = DateUtils.isCurrentTimeArea(endTimeMillis, (long) (i3 * 60 * 1000), (long) ((i3 * 60 * 1000) + 600000));
            if (isContainTime) {
                this.vedioAreaRect.set(0.0f, 0.0f, (float) getWidth(), (float) (this.viewHeight - (this.textSize * 2)));
                if (next.getType() == 2) {
                    canvas2.drawRect(this.vedioAreaRect, this.alarmDetectPaint);
                } else {
                    canvas2.drawRect(this.vedioAreaRect, this.vedioAreaPaint);
                }
            } else if (isCurrentTimeArea && isCurrentTimeArea2) {
                this.vedioAreaRect.set(((float) (next.getStartTimeMillis() - ((long) ((this.timeIndex * 60) * 1000)))) * (((float) getWidth()) / 600000.0f), 0.0f, ((float) (next.getEndTimeMillis() - ((long) ((this.timeIndex * 60) * 1000)))) * (((float) getWidth()) / 600000.0f), (float) (this.viewHeight - (this.textSize * 2)));
                if (next.getType() == 2) {
                    canvas2.drawRect(this.vedioAreaRect, this.alarmDetectPaint);
                } else if (next.getType() == 1) {
                    canvas2.drawRect(this.vedioAreaRect, this.vedioAreaPaint);
                } else if (next.getType() == 3) {
                    canvas2.drawRect(this.vedioAreaRect, this.faceDetectPaint);
                } else if (next.getType() == 4) {
                    canvas2.drawRect(this.vedioAreaRect, this.faceWhiteListPaint);
                } else if (next.getType() == 5) {
                    canvas2.drawRect(this.vedioAreaRect, this.faceStrangerPaint);
                }
            } else if (isCurrentTimeArea) {
                this.vedioAreaRect.set(((float) (next.getStartTimeMillis() - ((long) ((this.timeIndex * 60) * 1000)))) * (((float) getWidth()) / 600000.0f), 0.0f, (float) getWidth(), (float) (this.viewHeight - (this.textSize * 2)));
                if (next.getType() == 2) {
                    canvas2.drawRect(this.vedioAreaRect, this.alarmDetectPaint);
                } else if (next.getType() == 1) {
                    canvas2.drawRect(this.vedioAreaRect, this.vedioAreaPaint);
                } else if (next.getType() == 3) {
                    canvas2.drawRect(this.vedioAreaRect, this.faceDetectPaint);
                } else if (next.getType() == 4) {
                    canvas2.drawRect(this.vedioAreaRect, this.faceWhiteListPaint);
                } else if (next.getType() == 5) {
                    canvas2.drawRect(this.vedioAreaRect, this.faceStrangerPaint);
                }
            } else if (isCurrentTimeArea2) {
                this.vedioAreaRect.set(0.0f, 0.0f, ((float) (next.getEndTimeMillis() - ((long) ((this.timeIndex * 60) * 1000)))) * (((float) getWidth()) / 600000.0f), (float) (this.viewHeight - (this.textSize * 2)));
                if (next.getType() == 2) {
                    canvas2.drawRect(this.vedioAreaRect, this.alarmDetectPaint);
                } else if (next.getType() == 1) {
                    canvas2.drawRect(this.vedioAreaRect, this.vedioAreaPaint);
                } else if (next.getType() == 3) {
                    canvas2.drawRect(this.vedioAreaRect, this.faceDetectPaint);
                } else if (next.getType() == 4) {
                    canvas2.drawRect(this.vedioAreaRect, this.faceWhiteListPaint);
                } else if (next.getType() == 5) {
                    canvas2.drawRect(this.vedioAreaRect, this.faceStrangerPaint);
                }
            }
        }
    }

    private void drawRuler(Canvas canvas) {
        float width = ((float) getWidth()) / ((float) (10 / this.divisor));
        if (this.scaleMode != ScaleMode.KEY_HOUSE) {
            float f = 0.0f;
            for (int i = 0; i < 60; i++) {
                if (i == 0 || i == 59) {
                    if (i == 0) {
                        canvas.drawLine(f, 0.0f, f, (float) (this.rulerHeightSamll * 2), this.smallRulerPaint);
                        int i2 = this.viewHeight;
                        int i3 = this.textSize;
                        int i4 = this.upAndDownLineWidth;
                        canvas.drawLine(f, (float) ((i2 - (i3 * 2)) - i4), f, (float) (((i2 - (this.rulerHeightSamll * 2)) - (i3 * 2)) - i4), this.smallRulerPaint);
                        f += width;
                        canvas.drawText(DateUtils.getHourMinute(this.timeIndex), (-this.keyTickTextPaint.measureText(DateUtils.getHourMinute(this.timeIndex))) / 2.0f, (float) (this.viewHeight - this.textSize), this.keyTickTextPaint);
                    }
                } else if (i % this.divisor == 0) {
                    canvas.drawLine(f, 0.0f, f, (float) this.rulerHeightSamll, this.largeRulerPaint);
                    int i5 = this.viewHeight;
                    int i6 = this.textSize;
                    int i7 = this.upAndDownLineWidth;
                    canvas.drawLine(f, (float) ((i5 - (i6 * 2)) - i7), f, (float) (((i5 - this.rulerHeightSamll) - (i6 * 2)) - i7), this.largeRulerPaint);
                    f += width;
                }
            }
        } else if ((this.timeIndex / 10) % 6 == 0) {
            canvas.drawLine(0.0f, 0.0f, 0.0f, (float) (this.rulerHeightSamll * 2), this.largeRulerPaint);
            int i8 = this.viewHeight;
            int i9 = this.textSize;
            int i10 = this.upAndDownLineWidth;
            canvas.drawLine(0.0f, (float) ((i8 - (i9 * 2)) - i10), 0.0f, (float) (((i8 - (this.rulerHeightSamll * 2)) - (i9 * 2)) - i10), this.largeRulerPaint);
            canvas.drawText(DateUtils.getHourMinute(this.timeIndex), (-this.keyTickTextPaint.measureText(DateUtils.getHourMinute(this.timeIndex))) / 2.0f, (float) (this.viewHeight - this.textSize), this.keyTickTextPaint);
        } else {
            canvas.drawLine(0.0f, 0.0f, 0.0f, (float) this.rulerHeightSamll, this.smallRulerPaint);
            int i11 = this.viewHeight;
            int i12 = this.textSize;
            int i13 = this.upAndDownLineWidth;
            canvas.drawLine(0.0f, (float) ((i11 - (i12 * 2)) - i13), 0.0f, (float) (((i11 - this.rulerHeightSamll) - (i12 * 2)) - i13), this.smallRulerPaint);
        }
    }

    private void drawUpAndDownLine(Canvas canvas) {
        int width = getWidth();
        int i = this.upAndDownLineWidth;
        float f = (float) width;
        canvas.drawLine(0.0f, (float) (i / 2), f, (float) (i / 2), this.upAndDownLinePaint);
        int i2 = this.viewHeight;
        int i3 = this.textSize;
        int i4 = this.upAndDownLineWidth;
        canvas.drawLine(0.0f, (float) ((i2 - (i3 * 2)) - (i4 / 2)), f, (float) ((i2 - (i3 * 2)) - (i4 / 2)), this.upAndDownLinePaint);
    }

    public void setCurTimeIndex(int i) {
        this.timeIndex = i * 10;
    }

    public List<TimeSlot> getVedioTimeSlot() {
        return this.vedioTimeSlot;
    }

    public void setVedioTimeSlot(List<TimeSlot> list) {
        this.vedioTimeSlot.clear();
        this.vedioTimeSlot.addAll(list);
        postInvalidate();
    }

    public void setViewHeight(int i) {
        this.viewHeight = i;
        postInvalidate();
    }
}
