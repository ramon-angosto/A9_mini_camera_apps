package object.p2pipcam.zxingtwodimensioncode;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.jxl.app.littlestars.project.R;
import java.util.Hashtable;

final class DecodeHandler extends Handler {
    private static final String TAG = "DecodeHandler";
    private final CaptureActivity activity;
    private final MultiFormatReader multiFormatReader = new MultiFormatReader();

    DecodeHandler(CaptureActivity captureActivity, Hashtable<DecodeHintType, Object> hashtable) {
        this.multiFormatReader.setHints(hashtable);
        this.activity = captureActivity;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == R.id.decode) {
            decode((byte[]) message.obj, message.arg1, message.arg2);
        } else if (i == R.id.quit) {
            Looper.myLooper().quit();
        }
    }

    /* JADX INFO: finally extract failed */
    private void decode(byte[] bArr, int i, int i2) {
        Result result;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        PlanarYUVLuminanceSource buildLuminanceSource = CameraManager.get().buildLuminanceSource(bArr2, i2, i);
        if (buildLuminanceSource == null) {
            Log.d("tag", "source===nul========");
            CaptureActivity captureActivity = this.activity;
            Toast.makeText(captureActivity, captureActivity.getResources().getString(R.string.show_toat_buzhi), 0).show();
            this.activity.finish();
            return;
        }
        try {
            result = this.multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(buildLuminanceSource)));
            this.multiFormatReader.reset();
        } catch (ReaderException unused) {
            this.multiFormatReader.reset();
            result = null;
        } catch (Throwable th) {
            this.multiFormatReader.reset();
            throw th;
        }
        if (result != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = TAG;
            Log.d(str, "Found barcode (" + (currentTimeMillis2 - currentTimeMillis) + " ms):\n" + result.toString());
            Message obtain = Message.obtain(this.activity.getHandler(), R.id.decode_succeeded, result);
            Bundle bundle = new Bundle();
            bundle.putParcelable(DecodeThread.BARCODE_BITMAP, buildLuminanceSource.renderCroppedGreyscaleBitmap());
            obtain.setData(bundle);
            obtain.sendToTarget();
            return;
        }
        Message.obtain(this.activity.getHandler(), R.id.decode_failed).sendToTarget();
    }
}
