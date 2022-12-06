package com.shix.shixipc;

import android.app.Activity;
import android.app.ActivityManager;
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
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.SystemBarTintManager;
import java.util.List;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.cykj.camera.R;

public class BaseActivity extends Activity {
    private boolean isExit = true;
    /* access modifiers changed from: private */
    public boolean isSend = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.isSend = false;
        this.isExit = true;
        super.onCreate(bundle);
    }

    public void SetIsExitFalse() {
        this.isExit = false;
    }

    public void SetIsExitTure() {
        this.isExit = true;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.isExit && !isAppOnForeground()) {
            finish();
        }
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

    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public void StartHeat(String str, String str2, String str3) {
        this.isSend = true;
        CommonUtil.Log(1, "HeatThread start ");
    }

    public void StopHeat() {
        CommonUtil.Log(1, "HeatThread StopHeat ");
        this.isSend = false;
    }

    public boolean isAppOnForeground() {
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.equals(packageName) && next.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public void showSureDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.ic_launcher);
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

    public void StartPPPP(String str, String str2, String str3) {
        NativeCaller.StartPPPP(str, str2, str3, ContentCommon.SERVER_STRING);
    }

    public void StopPPPP(String str) {
        CommonUtil.Log(1, "StartPPPP--StopPPPP停止连接 " + str);
        NativeCaller.StopPPPP(str);
    }

    class MyStopThread extends Thread {
        private String strdidTest;

        public MyStopThread(String str) {
            this.strdidTest = str;
        }

        public void run() {
            NativeCaller.StopPPPP(this.strdidTest);
            super.run();
        }
    }

    public void SetTab(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);
        systemBarTintManager.setStatusBarTintResource(R.color.color_main);
    }

    public void SetTab(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);
        systemBarTintManager.setStatusBarTintResource(i);
    }

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

    public void StartPPPP(String str, String str2, String str3, String str4) {
        String str5;
        String substring = str.substring(0, 3);
        if (substring.equalsIgnoreCase("GBE")) {
            str5 = "EBGAEIBIKHJJGFJKEOGIFKEFHCMCHMNBG";
        } else {
            str5 = substring.equalsIgnoreCase("OBJ") ? "EBGAEOBOKHJMHMJMENGKFIEEHBMDHNNEGNEBBCCCBII" : "EBGAEIBIKHJJGFJJEEHOFAENHLNBHGNMHMFDAADAAOJNKNKG";
        }
        NativeCaller.StartPPPP(str, str2, str3, str5);
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
                    String SHIX_Heat = CommonUtil.SHIX_Heat(this.user1, this.pwd1);
                    CommonUtil.Log(1, "HeatThread :" + SHIX_Heat);
                    NativeCaller.TransferMessage(this.did1, SHIX_Heat, 0);
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
