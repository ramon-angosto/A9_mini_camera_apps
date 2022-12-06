package com.tzh.ipcamera.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.Toast;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.presenter.listener.ITargetBitmapFixListener;
import java.util.ArrayList;
import java.util.List;

public class BmpUtils implements Runnable {
    public static final int IMAGE_MAX_SCALE_SIZE = 50;
    public static final int IMAGE_MIN_SCALE_SIZE = 1;
    private boolean bRunning = false;
    private int imgHeight;
    private int imgWidth;
    LogUtils logUtils = LogUtils.setLogger(BmpUtils.class);
    private Context mContext = null;
    private Thread mThread = null;
    private Matrix matrix = new Matrix();
    private ITargetBitmapFixListener onBitmapFixListener;
    private float scaleVal = 1.0f;
    public List<Bitmap> srcBmps = new ArrayList();
    public List<Bitmap> targetBmps = new ArrayList();

    public BmpUtils(Context context, ITargetBitmapFixListener iTargetBitmapFixListener) {
        this.mContext = context;
        this.onBitmapFixListener = iTargetBitmapFixListener;
    }

    public void setScale(int i) {
        this.scaleVal = (((float) i) * 0.1f) + 1.0f;
        Matrix matrix2 = this.matrix;
        float f = this.scaleVal;
        matrix2.setScale(f, f);
    }

    public void setImageParam(int i, int i2) {
        if (this.imgWidth != i || this.imgHeight != i2) {
            this.imgHeight = i2;
            this.imgWidth = i;
            synchronized (this.targetBmps) {
                this.targetBmps.clear();
            }
        }
    }

    public void start() {
        this.bRunning = true;
        Thread thread = this.mThread;
        if (thread == null || !thread.isAlive()) {
            this.mThread = new Thread(this);
            this.mThread.start();
        }
    }

    public void push(Bitmap bitmap) {
        synchronized (this.srcBmps) {
            if (this.srcBmps.size() < 8) {
                this.srcBmps.add(bitmap);
            } else {
                this.srcBmps.clear();
                this.srcBmps.add(bitmap);
            }
        }
    }

    public void run() {
        float f;
        float f2;
        this.bRunning = true;
        while (this.bRunning) {
            try {
                if (this.srcBmps.size() <= 0) {
                    Thread.sleep(2);
                } else {
                    Bitmap bitmap = this.srcBmps.get(0);
                    if (bitmap == null) {
                        Thread.sleep(2);
                    } else {
                        float f3 = ((float) this.imgWidth) / ((float) this.imgHeight);
                        float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
                        if (f3 != width) {
                            if (f3 > width) {
                                f = (float) ((bitmap.getHeight() - ((bitmap.getWidth() * this.imgHeight) / this.imgWidth)) / 2);
                                f2 = 0.0f;
                            } else {
                                f2 = (float) ((bitmap.getWidth() - ((bitmap.getHeight() * this.imgWidth) / this.imgHeight)) / 2);
                                f = 0.0f;
                            }
                            this.matrix.setScale(1.0f, 1.0f);
                            bitmap = Bitmap.createBitmap(bitmap, (int) f2, (int) f, (int) (((float) bitmap.getWidth()) - (f2 * 2.0f)), (int) (((float) bitmap.getHeight()) - (f * 2.0f)), this.matrix, true);
                            LogUtils logUtils2 = this.logUtils;
                            logUtils2.e("###cutX:" + f2 + "  cutY:" + f);
                        }
                        this.matrix.setScale(this.scaleVal, this.scaleVal);
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (int) ((((float) bitmap.getWidth()) * (1.0f - (1.0f / this.scaleVal))) / 2.0f), (int) ((((float) bitmap.getHeight()) * (1.0f - (1.0f / this.scaleVal))) / 2.0f), (int) (((float) bitmap.getWidth()) / this.scaleVal), (int) (((float) bitmap.getHeight()) / this.scaleVal), this.matrix, true);
                        LogUtils logUtils3 = this.logUtils;
                        logUtils3.e("###new bitmap:" + createBitmap.getWidth() + " " + createBitmap.getHeight());
                        this.srcBmps.remove(0);
                        if (this.onBitmapFixListener != null) {
                            this.onBitmapFixListener.OnBitmapFixed(createBitmap);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.srcBmps.clear();
        this.targetBmps.clear();
    }

    public void zoomAdd() {
        float f = this.scaleVal;
        if (f < 50.0f) {
            this.scaleVal = f + 1.0f;
            Context context = this.mContext;
            Toast.makeText(context, "缩放比例为:" + this.scaleVal, 500).show();
        }
    }

    public void zoomSub() {
        float f = this.scaleVal;
        if (f > 1.0f) {
            this.scaleVal = f - 1.0f;
            Context context = this.mContext;
            Toast.makeText(context, "缩放比例为:" + this.scaleVal, 500).show();
        }
    }

    public void stop() {
        this.bRunning = false;
    }
}
