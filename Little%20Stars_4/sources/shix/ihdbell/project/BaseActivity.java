package shix.ihdbell.project;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.jxl.app.littlestars.project.R;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;

public class BaseActivity extends Activity {
    /* access modifiers changed from: private */
    public boolean isSend = false;

    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isSend = false;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void SetTab(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);
        systemBarTintManager.setStatusBarTintResource(R.color.color_mainxx);
    }

    @TargetApi(19)
    private void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    public void StartHeat(String str, String str2, String str3) {
        this.isSend = true;
        CommonUtil.Log(1, "HeatThread start ");
        new HeatThread(str, str2, str3).start();
    }

    public void StopHeat() {
        CommonUtil.Log(1, "HeatThread StopHeat ");
        this.isSend = false;
    }

    public void showToast(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public void showToast(int i) {
        Toast.makeText(this, getResources().getString(i), 0).show();
    }

    public void showToastLong(int i) {
        Toast.makeText(this, getResources().getString(i), 1).show();
    }

    public String returnString(int i) {
        return getResources().getString(i);
    }

    public void showSureDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.app);
        builder.setTitle(getResources().getString(R.string.exit) + getResources().getString(R.string.app_name));
        builder.setMessage(R.string.exit_chenxu_show);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                BaseActivity.this.finish();
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void StartPPPP(String str, String str2, String str3, String str4) {
        String str5;
        if (str.toUpperCase().startsWith("ACCQ")) {
            str5 = SystemValue.SystemSerVer_ACCQ;
        } else if (str.toUpperCase().startsWith("THPC")) {
            str5 = SystemValue.SystemSerVer_TZH;
        } else if (str.toUpperCase().startsWith("AZQ")) {
            str5 = SystemValue.SystemSerVer_AZQ;
        } else if (str.toUpperCase().startsWith("ALK")) {
            str5 = SystemValue.SystemSerVer_ALK;
        } else if (str.toUpperCase().startsWith("BCCQ")) {
            str5 = SystemValue.SystemSerVer_ACCQ;
        } else {
            str5 = SystemValue.SystemSerVer_TZH;
        }
        NativeCaller.StartPPPP(str, str2, str3, str5);
    }

    public Bitmap Create2DCode(String str) throws WriterException {
        BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 600, 600);
        int width = encode.getWidth();
        int height = encode.getHeight();
        int[] iArr = new int[(width * height)];
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                if (encode.get(i2, i)) {
                    iArr[(i * width) + i2] = -16777216;
                } else {
                    iArr[(i * width) + i2] = -1;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    class HeatThread extends Thread {
        private int count = 0;
        private String did1 = "";
        private String pwd1 = "";
        private String user1 = "";

        public HeatThread(String str, String str2, String str3) {
            this.did1 = str;
            this.user1 = str2;
            this.pwd1 = str3;
            this.count = 0;
        }

        public void run() {
            while (BaseActivity.this.isSend) {
                if (this.count == 0) {
                    CommonUtil.Log(1, "HeatThread ");
                    NativeCaller.TransferMessage(this.did1, CommonUtil.SHIX_Heat(this.user1, this.pwd1), 0);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.count++;
                if (this.count == 4) {
                    this.count = 0;
                }
            }
            super.run();
        }
    }
}
