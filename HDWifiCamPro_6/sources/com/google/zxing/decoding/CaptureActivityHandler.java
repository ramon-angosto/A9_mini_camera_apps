package com.google.zxing.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.camera.CameraManager;
import com.google.zxing.view.ViewfinderResultPointCallback;
import com.shix.qhipc.R;
import java.util.Vector;

public final class CaptureActivityHandler extends Handler {
    private static final String TAG = CaptureActivityHandler.class.getSimpleName();
    private final CaptureActivity activity;
    private final DecodeThread decodeThread;
    private State state = State.SUCCESS;

    private enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureActivityHandler(CaptureActivity captureActivity, Vector<BarcodeFormat> vector, String str) {
        this.activity = captureActivity;
        this.decodeThread = new DecodeThread(captureActivity, vector, str, new ViewfinderResultPointCallback(captureActivity.getViewfinderView()));
        this.decodeThread.start();
        CameraManager.get().startPreview();
        restartPreviewAndDecode();
    }

    public void handleMessage(Message message) {
        Bitmap bitmap;
        switch (message.what) {
            case R.id.auto_focus:
                if (this.state == State.PREVIEW) {
                    CameraManager.get().requestAutoFocus(this, R.id.auto_focus);
                    return;
                }
                return;
            case R.id.decode_failed:
                this.state = State.PREVIEW;
                CameraManager.get().requestPreviewFrame(this.decodeThread.getHandler(), R.id.decode);
                return;
            case R.id.decode_succeeded:
                Log.d(TAG, "Got decode succeeded message");
                this.state = State.SUCCESS;
                Bundle data = message.getData();
                if (data == null) {
                    bitmap = null;
                } else {
                    bitmap = (Bitmap) data.getParcelable(DecodeThread.BARCODE_BITMAP);
                }
                this.activity.handleDecode((Result) message.obj, bitmap);
                return;
            case R.id.launch_product_query:
                Log.d(TAG, "Got product query message");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) message.obj));
                intent.addFlags(524288);
                this.activity.startActivity(intent);
                return;
            case R.id.restart_preview:
                Log.d(TAG, "Got restart preview message");
                restartPreviewAndDecode();
                return;
            case R.id.return_scan_result:
                Log.d(TAG, "Got return scan result message");
                this.activity.setResult(-1, (Intent) message.obj);
                this.activity.finish();
                return;
            default:
                return;
        }
    }

    public void quitSynchronously() {
        this.state = State.DONE;
        CameraManager.get().stopPreview();
        Message.obtain(this.decodeThread.getHandler(), R.id.quit).sendToTarget();
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    private void restartPreviewAndDecode() {
        if (this.state == State.SUCCESS) {
            this.state = State.PREVIEW;
            CameraManager.get().requestPreviewFrame(this.decodeThread.getHandler(), R.id.decode);
            CameraManager.get().requestAutoFocus(this, R.id.auto_focus);
            this.activity.drawViewfinder();
        }
    }
}
