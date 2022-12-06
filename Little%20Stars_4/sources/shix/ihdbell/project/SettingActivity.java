package shix.ihdbell.project;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.xiaomi.mipush.sdk.Constants;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class SettingActivity extends BaseActivity implements View.OnClickListener, BridgeService.AddCameraInterface, BridgeService.DoorBellGETSTATU {
    /* access modifiers changed from: private */
    public String LanNetIp;
    int LanPort;
    /* access modifiers changed from: private */
    public Button btnBack;
    private Button buttonAler;
    private Button buttonAp;
    private Button buttonFtp;
    private Button buttonLock;
    private Button buttonNo;
    private Button buttonSd;
    private Button buttonTime;
    private Button buttonUser;
    private Button buttonWifi;
    private Button buttonYes;
    private String cameraName;
    private MyBackBrod myBackBrod = null;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_more_funtion;
    private View popv;
    private View popv_more_funtion;
    private Button setting_interface;
    private Button setting_reboot;
    private Button setting_reset;
    private Button setting_system;
    /* access modifiers changed from: private */
    public PopupWindow showWindow;
    /* access modifiers changed from: private */
    public String strCGI;
    /* access modifiers changed from: private */
    public String strDID;
    String sysVer = "";
    private TextView tvCameraName;
    private TextView tv_dev;
    private TextView tv_showtext;

    public void CallBackSDStatu(String str, int i, int i2, int i3) {
    }

    public void callBackResetResultData(int i) {
    }

    public void showSureReboot() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.app);
        builder.setTitle(getResources().getString(R.string.doorbell_setting_reboot));
        builder.setMessage(R.string.doorbell_setting_reboot_show);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                NativeCaller.PPPPRebootDevice(SettingActivity.this.strDID);
                SettingActivity.this.finish();
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showSureReset() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.app);
        builder.setTitle(getResources().getString(R.string.doorbell_setting_reset));
        builder.setMessage(R.string.doorbell_setting_reset_show);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                NativeCaller.TransferMessage(SettingActivity.this.strDID, "reset_alarm_config.cgi?&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                SettingActivity.this.finish();
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.setting);
        findView();
        initExitPopupWindow2();
        initExitPopupWindow_more_funtion();
        this.LanNetIp = "";
        BridgeService.setDoorBellGETSTATU(this);
        NativeCaller.PPPPGetSystemParams(this.strDID, 13);
        TextView textView = this.tvCameraName;
        textView.setText(this.cameraName + "  " + getResources().getString(R.string.setting));
        SetTab(this);
        if (SystemValue.isLitos) {
            findViewById(R.id.setting_alerm).setVisibility(8);
            findViewById(R.id.view_alerm).setVisibility(8);
            findViewById(R.id.setting_interface).setVisibility(8);
            findViewById(R.id.view_interface).setVisibility(8);
            findViewById(R.id.setting_wifi).setVisibility(8);
            findViewById(R.id.view_wifi).setVisibility(8);
            findViewById(R.id.setting_lock).setVisibility(8);
            findViewById(R.id.view_lock).setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (this.myBackBrod == null) {
            this.myBackBrod = new MyBackBrod();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("myback");
            registerReceiver(this.myBackBrod, intentFilter);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        StopHeat();
        super.onStop();
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    private void findView() {
        findViewById(R.id.check_ver).setOnClickListener(this);
        this.tvCameraName = (TextView) findViewById(R.id.tv_camera_setting);
        this.btnBack = (Button) findViewById(R.id.back);
        this.buttonWifi = (Button) findViewById(R.id.setting_wifi);
        this.buttonAler = (Button) findViewById(R.id.setting_alerm);
        this.buttonUser = (Button) findViewById(R.id.setting_use);
        this.buttonLock = (Button) findViewById(R.id.setting_lock);
        this.buttonFtp = (Button) findViewById(R.id.setting_ftp);
        this.buttonSd = (Button) findViewById(R.id.setting_sdcard);
        this.buttonTime = (Button) findViewById(R.id.setting_time);
        this.setting_reboot = (Button) findViewById(R.id.setting_reboot);
        this.setting_reset = (Button) findViewById(R.id.setting_reset);
        this.setting_interface = (Button) findViewById(R.id.setting_interface);
        this.setting_system = (Button) findViewById(R.id.setting_system);
        this.setting_system.setOnClickListener(this);
        this.setting_interface.setOnClickListener(this);
        this.setting_reset.setOnClickListener(this);
        this.setting_reboot.setOnClickListener(this);
        this.buttonWifi.setOnClickListener(this);
        this.buttonUser.setOnClickListener(this);
        this.buttonTime.setOnClickListener(this);
        this.buttonAler.setOnClickListener(this);
        this.buttonLock.setOnClickListener(this);
        this.buttonFtp.setOnClickListener(this);
        this.buttonSd.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
        boolean z = SystemValue.isLitos;
        findViewById(R.id.setting_ap).setOnClickListener(this);
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        switch (view.getId()) {
            case R.id.back:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.btn_no:
                PopupWindow popupWindow = this.popupWindow_more_funtion;
                if (popupWindow != null && popupWindow.isShowing()) {
                    this.popupWindow_more_funtion.dismiss();
                    return;
                }
                return;
            case R.id.btn_yes:
                PopupWindow popupWindow2 = this.popupWindow_more_funtion;
                if (popupWindow2 != null && popupWindow2.isShowing()) {
                    this.popupWindow_more_funtion.dismiss();
                }
                downLoadApk();
                return;
            case R.id.check_ver:
                if (this.sysVer.startsWith("16.3")) {
                    if (this.sysVer.endsWith("16.3.21.46") || this.sysVer.endsWith("16.3.22.46")) {
                        showToastLong(R.string.update_titl_update_no_show);
                        return;
                    } else {
                        new AsyncTask<Void, Void, Void>() {
                            /* access modifiers changed from: protected */
                            public void onPreExecute() {
                                BridgeService.setAddCameraInterface(SettingActivity.this);
                                if (SettingActivity.this.showWindow != null) {
                                    SettingActivity.this.showWindow.showAtLocation(SettingActivity.this.btnBack, 48, 0, 50);
                                }
                            }

                            /* access modifiers changed from: protected */
                            public Void doInBackground(Void... voidArr) {
                                NativeCaller.StartSearch();
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                NativeCaller.StopSearch();
                                return null;
                            }

                            /* access modifiers changed from: protected */
                            public void onPostExecute(Void voidR) {
                                BridgeService.setAddCameraInterface((BridgeService.AddCameraInterface) null);
                                if (SettingActivity.this.showWindow != null && SettingActivity.this.showWindow.isShowing()) {
                                    SettingActivity.this.showWindow.dismiss();
                                }
                                if (SettingActivity.this.LanNetIp == null || SettingActivity.this.LanNetIp.length() <= 5) {
                                    SettingActivity.this.showToastLong(R.string.update_titl_update_show);
                                } else if (SettingActivity.this.popupWindow_more_funtion != null) {
                                    SettingActivity.this.popupWindow_more_funtion.showAtLocation(SettingActivity.this.btnBack, 80, 0, 0);
                                }
                            }
                        }.execute(new Void[0]);
                        return;
                    }
                } else if (!this.sysVer.startsWith("6.3")) {
                    return;
                } else {
                    if (this.sysVer.endsWith("6.3.21.42") || this.sysVer.endsWith("6.3.22.42")) {
                        showToastLong(R.string.update_titl_update_no_show);
                        return;
                    } else {
                        new AsyncTask<Void, Void, Void>() {
                            /* access modifiers changed from: protected */
                            public void onPreExecute() {
                                BridgeService.setAddCameraInterface(SettingActivity.this);
                                if (SettingActivity.this.showWindow != null) {
                                    SettingActivity.this.showWindow.showAtLocation(SettingActivity.this.btnBack, 48, 0, 50);
                                }
                            }

                            /* access modifiers changed from: protected */
                            public Void doInBackground(Void... voidArr) {
                                NativeCaller.StartSearch();
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                NativeCaller.StopSearch();
                                return null;
                            }

                            /* access modifiers changed from: protected */
                            public void onPostExecute(Void voidR) {
                                BridgeService.setAddCameraInterface((BridgeService.AddCameraInterface) null);
                                if (SettingActivity.this.showWindow != null && SettingActivity.this.showWindow.isShowing()) {
                                    SettingActivity.this.showWindow.dismiss();
                                }
                                if (SettingActivity.this.LanNetIp == null || SettingActivity.this.LanNetIp.length() <= 5) {
                                    SettingActivity.this.showToastLong(R.string.update_titl_update_show);
                                } else if (SettingActivity.this.popupWindow_more_funtion != null) {
                                    SettingActivity.this.popupWindow_more_funtion.showAtLocation(SettingActivity.this.btnBack, 80, 0, 0);
                                }
                            }
                        }.execute(new Void[0]);
                        return;
                    }
                }
            case R.id.setting_alerm:
                Intent intent = new Intent(this, SettingAlarmActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            case R.id.setting_ap:
                Intent intent2 = new Intent(this, SettingSDCardActivity.class);
                intent2.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent2.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                startActivity(intent2);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            case R.id.setting_interface:
                Intent intent3 = new Intent(this, SettingPushActivity.class);
                intent3.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent3.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                startActivity(intent3);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            case R.id.setting_lock:
                Intent intent4 = new Intent(this, SettingDelayActivity.class);
                intent4.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent4.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                startActivity(intent4);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            case R.id.setting_system:
                Intent intent5 = new Intent(this, SettingSystemActivity.class);
                intent5.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent5.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                startActivity(intent5);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            case R.id.setting_time:
                Intent intent6 = new Intent(this, SettingDateActivity.class);
                intent6.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent6.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                startActivity(intent6);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            case R.id.setting_use:
                Intent intent7 = new Intent(this, SettingUserActivity.class);
                intent7.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent7.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                startActivity(intent7);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            case R.id.setting_wifi:
                Intent intent8 = new Intent(this, SettingWifiActivity.class);
                intent8.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent8.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                startActivity(intent8);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        MyBackBrod myBackBrod2 = this.myBackBrod;
        if (myBackBrod2 != null) {
            unregisterReceiver(myBackBrod2);
        }
    }

    public void initExitPopupWindow2() {
        this.popv = LayoutInflater.from(this).inflate(R.layout.popup_show, (ViewGroup) null);
        this.tv_showtext = (TextView) this.popv.findViewById(R.id.textView1);
        this.showWindow = new PopupWindow(this.popv, -1, -2);
        this.showWindow.setAnimationStyle(R.style.AnimationPreview);
        this.showWindow.setFocusable(true);
    }

    public void initExitPopupWindow_more_funtion() {
        this.popv_more_funtion = LayoutInflater.from(this).inflate(R.layout.popup_update_funtion, (ViewGroup) null);
        this.popupWindow_more_funtion = new PopupWindow(this.popv_more_funtion, -1, -2);
        this.tv_dev = (TextView) this.popv_more_funtion.findViewById(R.id.tv_dev);
        this.buttonYes = (Button) this.popv_more_funtion.findViewById(R.id.btn_yes);
        this.buttonYes.setOnClickListener(this);
        this.buttonNo = (Button) this.popv_more_funtion.findViewById(R.id.btn_no);
        this.buttonNo.setOnClickListener(this);
        this.popupWindow_more_funtion.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_more_funtion.setFocusable(true);
        this.popupWindow_more_funtion.setInputMethodMode(1);
        this.popupWindow_more_funtion.setSoftInputMode(16);
        this.popupWindow_more_funtion.setOutsideTouchable(true);
        this.popupWindow_more_funtion.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_more_funtion.setFocusableInTouchMode(true);
        this.popv_more_funtion.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 82) {
                    return false;
                }
                SettingActivity.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
        this.popupWindow_more_funtion.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popupWindow_more_funtion.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingActivity.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void downLoadApk() {
        new Thread() {
            public void run() {
                try {
                    SettingActivity settingActivity = SettingActivity.this;
                    String unused = settingActivity.strCGI = "http://" + SettingActivity.this.LanNetIp + ":" + SettingActivity.this.LanPort + "/upgrade_firmware.cgi?user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass;
                    SettingActivity.this.uploadFile("", SettingActivity.this.strCGI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void uploadFile(final String str, final String str2) {
        new Thread() {
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    Log.v("test", "imgfilestring==>>" + str);
                    if (str != null) {
                        Log.v("test", "imgfilestring==>>0");
                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        InputStream inputStream = null;
                        if (SettingActivity.this.sysVer.startsWith("16.3")) {
                            if (SettingActivity.this.sysVer.indexOf("21") > 0) {
                                inputStream = SettingActivity.this.getAssets().open("1632146.bin");
                            } else {
                                inputStream = SettingActivity.this.getAssets().open("1632246.bin");
                            }
                        } else if (SettingActivity.this.sysVer.startsWith("6.3")) {
                            if (SettingActivity.this.sysVer.indexOf("21") > 0) {
                                inputStream = SettingActivity.this.getAssets().open("632142.bin");
                            } else {
                                inputStream = SettingActivity.this.getAssets().open("632242.bin");
                            }
                        }
                        byte[] bArr = new byte[51200];
                        int i = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            Log.d("test", "ds.write");
                            dataOutputStream.write(bArr, 0, read);
                            i += bArr.length;
                            Log.v("test", "文件总大小==" + new File(str).length() + "    每次上传的length==" + read + "    上传进度=" + i);
                        }
                        inputStream.close();
                        dataOutputStream.flush();
                        Log.v("test", "响应码==" + httpURLConnection.getResponseCode());
                        if (httpURLConnection.getResponseCode() == 200) {
                            InputStream inputStream2 = httpURLConnection.getInputStream();
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                int read2 = inputStream2.read();
                                if (read2 != -1) {
                                    stringBuffer.append((char) read2);
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("返回的字符串==");
                                    stringBuffer.append((char) read2);
                                    sb.append(stringBuffer.toString());
                                    Log.v("test", sb.toString());
                                    dataOutputStream.close();
                                    httpURLConnection.disconnect();
                                    SettingActivity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            SettingActivity.this.showToastLong(R.string.updata_ok);
                                            SettingActivity.this.finish();
                                        }
                                    });
                                    return;
                                }
                            }
                        } else {
                            Log.v("test", "imgfilestring==>>1111");
                            throw new RuntimeException();
                        }
                    } else {
                        Log.v("test", "imgfilestring==>>2222");
                        throw new FileNotFoundException();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.v("test", "imgfilestring==>>333");
                }
            }
        }.start();
    }

    public void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2) {
        Log.d("test", "strIpAddr :" + str4 + "  port:" + i2 + "  strDeviceID:" + str3);
        String str5 = this.strDID;
        if (str5 != null && str5.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toUpperCase().equalsIgnoreCase(str3.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toUpperCase())) {
            this.LanNetIp = str4;
            this.LanPort = i2;
        }
    }

    public void CallBackStatu(String str, String str2, String str3) {
        this.sysVer = str2;
        CommonUtil.Log(1, "Version:" + str2 + "   devid:" + str3);
    }

    class MyBackBrod extends BroadcastReceiver {
        MyBackBrod() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("myback".equals(intent.getAction())) {
                SettingActivity.this.finish();
                SettingActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        }
    }
}
