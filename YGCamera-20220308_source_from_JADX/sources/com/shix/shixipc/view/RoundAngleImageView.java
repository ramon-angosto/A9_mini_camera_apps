package com.shix.shixipc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.shix.shixipc.C1113R;

public class RoundAngleImageView extends ImageView {
    private Paint paint;
    private Paint paint2;
    private int roundHeight = 5;
    private int roundWidth = 5;

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public RoundAngleImageView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1113R.styleable.RoundAngleImageView);
            this.roundWidth = obtainStyledAttributes.getDimensionPixelSize(1, this.roundWidth);
            this.roundHeight = obtainStyledAttributes.getDimensionPixelSize(0, this.roundHeight);
        } else {
            float f = context.getResources().getDisplayMetrics().density;
            this.roundWidth = (int) (((float) this.roundWidth) * f);
            this.roundHeight = (int) (((float) this.roundHeight) * f);
        }
        this.paint = new Paint();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.paint2 = new Paint();
        this.paint2.setXfermode((Xfermode) null);
    }

    public void draw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        drawLiftUp(canvas2);
        drawRightUp(canvas2);
        drawLiftDown(canvas2);
        drawRightDown(canvas2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.paint2);
        createBitmap.recycle();
    }

    private void drawLiftUp(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, (float) this.roundHeight);
        path.lineTo(0.0f, 0.0f);
        path.lineTo((float) this.roundWidth, 0.0f);
        path.arcTo(new RectF(0.0f, 0.0f, (float) (this.roundWidth * 2), (float) (this.roundHeight * 2)), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawLiftDown(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, (float) (getHeight() - this.roundHeight));
        path.lineTo(0.0f, (float) getHeight());
        path.lineTo((float) this.roundWidth, (float) getHeight());
        path.arcTo(new RectF(0.0f, (float) (getHeight() - (this.roundHeight * 2)), (float) ((this.roundWidth * 2) + 0), (float) getHeight()), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawRightDown(Canvas canvas) {
        Path path = new Path();
        path.moveTo((float) (getWidth() - this.roundWidth), (float) getHeight());
        path.lineTo((float) getWidth(), (float) getHeight());
        path.lineTo((float) getWidth(), (float) (getHeight() - this.roundHeight));
        path.arcTo(new RectF((float) (getWidth() - (this.roundWidth * 2)), (float) (getHeight() - (this.roundHeight * 2)), (float) getWidth(), (float) getHeight()), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawRightUp(Canvas canvas) {
        Path path = new Path();
        path.moveTo((float) getWidth(), (float) this.roundHeight);
        path.lineTo((float) getWidth(), 0.0f);
        path.lineTo((float) (getWidth() - this.roundWidth), 0.0f);
        path.arcTo(new RectF((float) (getWidth() - (this.roundWidth * 2)), 0.0f, (float) getWidth(), (float) ((this.roundHeight * 2) + 0)), -90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }
}
