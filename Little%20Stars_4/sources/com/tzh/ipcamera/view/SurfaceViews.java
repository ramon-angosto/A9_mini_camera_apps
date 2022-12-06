package com.tzh.ipcamera.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.jxl.app.littlestars.project.R;

public class SurfaceViews extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "surfaceview";
    private Bitmap mBitmap;
    private Canvas m_canvas;
    private SurfaceHolder m_holder;
    private Paint m_paint;
    private Matrix matrix;
    private Rect rect;
    private int roateAngle;

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public SurfaceViews(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_holder = null;
        this.m_canvas = null;
        this.m_paint = null;
        this.rect = null;
        this.matrix = null;
        this.roateAngle = 0;
        this.mBitmap = null;
        this.m_holder = getHolder();
        this.m_holder.addCallback(this);
        this.m_paint = new Paint();
        this.m_paint.setColor(-16776961);
        this.m_paint.setAntiAlias(true);
        this.matrix = new Matrix();
        this.m_holder.setFormat(-2);
        this.rect = new Rect(0, 0, getWidth(), getHeight());
        Log.e(TAG, "width " + getWidth() + " height " + getHeight());
        this.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.video_player_bg);
    }

    public void setRotateAngle(int i) {
        this.roateAngle = i;
    }

    public void SetBitmap(Bitmap bitmap) {
        this.m_canvas = this.m_holder.lockCanvas(this.rect);
        Canvas canvas = this.m_canvas;
        if (canvas == null) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.m_canvas.clipRect(this.rect);
            this.m_canvas.drawBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), this.matrix, true), (Rect) null, this.rect, this.m_paint);
            SurfaceHolder surfaceHolder = this.m_holder;
            if (surfaceHolder != null) {
                surfaceHolder.unlockCanvasAndPost(this.m_canvas);
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        SetBitmap(this.mBitmap);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e(TAG, "width " + getWidth() + " height " + getHeight());
        SetBitmap(this.mBitmap);
    }

    public void disconnect() {
        this.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.video_player_bg);
        SetBitmap(this.mBitmap);
    }
}
