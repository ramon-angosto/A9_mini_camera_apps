package com.shix.shixipc.glview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;

public class HiGLMonitor extends GLSurfaceView {
    private Handler handler;
    /* access modifiers changed from: private */
    public int mCurVideoHeight;
    /* access modifiers changed from: private */
    public int mCurVideoWidth;
    /* access modifiers changed from: private */
    public HiGLRender renderer;
    /* access modifiers changed from: private */
    public byte[] videoBuffer;

    public HiGLMonitor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.renderer = null;
        this.mCurVideoWidth = 0;
        this.mCurVideoHeight = 0;
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                HiGLMonitor.this.renderer.writeSample(HiGLMonitor.this.videoBuffer, HiGLMonitor.this.mCurVideoWidth, HiGLMonitor.this.mCurVideoHeight);
            }
        };
        this.renderer = new HiGLRender(this);
        setRenderer(this.renderer);
    }

    public void setMatrix(int i, int i2, int i3, int i4) {
        HiGLRender hiGLRender = this.renderer;
        if (hiGLRender != null) {
            hiGLRender.setMatrix(i, i2, i3, i4);
        }
    }

    public void setYuvFrameData(byte[] bArr, int i, int i2) {
        if (!(this.mCurVideoWidth == i && this.mCurVideoHeight == i2)) {
            this.mCurVideoWidth = i;
            this.mCurVideoHeight = i2;
            this.videoBuffer = null;
            this.videoBuffer = new byte[4147200];
        }
        int length = bArr.length;
        byte[] bArr2 = this.videoBuffer;
        if (length <= bArr2.length) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.handler.sendMessage(new Message());
        }
    }
}
