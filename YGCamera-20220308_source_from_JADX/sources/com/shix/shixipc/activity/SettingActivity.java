package com.shix.shixipc.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.google.zxing.WriterException;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.NiftyDialogBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    /* access modifiers changed from: private */
    public static DeleDetInterface deleInterface;
    private final int ALERM = 2;
    private final int DATETIME = 3;
    private final int FTP = 5;
    private String LanNetIp;
    int LanPort;
    private final int MAIL = 4;
    private final int REQUEST_CHOOSEFILE = 110;
    private final int SDCard = 6;
    private final int USER = 1;
    private final int WIFI = 0;
    String binSer = "";
    private Bitmap bitmap;
    /* access modifiers changed from: private */
    public Bitmap bitmap1;
    private Button btnBack;
    private Button buttonAler;
    private Button buttonAp;
    private Button buttonFtp;
    private Button buttonMail;
    private Button buttonReboot;
    private Button buttonSd;
    private Button buttonTime;
    private Button buttonUser;
    private Button buttonWifi;
    /* access modifiers changed from: private */
    public String cameraName;
    private String currVersion;
    ImageView img_er;
    boolean isNew = false;
    String jsonStr;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                NativeCaller.TransferMessage(SettingActivity.this.strDID, CommonUtil.getUpdataParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
            }
        }
    };
    /* access modifiers changed from: private */
    public String mcuver = "";
    String mcuverSer = "";
    String md5Ser = "";
    private MyBackBrod myBackBrod = null;
    Runnable networkTask = new Runnable() {
        public void run() {
            try {
                SettingActivity.this.getJSONObject("https://shixapp.oss-cn-hongkong.aliyuncs.com/camera/MVT3620S2/checkVer.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private String newVersion;
    private int status;
    /* access modifiers changed from: private */
    public String strDID;
    /* access modifiers changed from: private */
    public String sysver = "";
    String sysverSer = "";
    /* access modifiers changed from: private */
    public TextView textViewVersion;
    private TextView tvCameraName;
    private int upgrade_signal;

    public interface DeleDetInterface {
        void CallBackDelSet(String str, String str2);
    }

    class MyBackBrod extends BroadcastReceiver {
        MyBackBrod() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("myback".equals(intent.getAction())) {
                SettingActivity.this.finish();
            }
        }
    }

    public void showUpdate() {
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(this);
        instance.withMessage((CharSequence) this.currVersion + "--->" + this.newVersion).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
                NativeCaller.TransferMessage(SettingActivity.this.strDID, CommonUtil.getUpdata(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 0, 1), 0);
                SettingActivity.this.finish();
            }
        }).show();
    }

    public void showSureReboot() {
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(this);
        instance.withMessage((CharSequence) getString(R.string.restart_show)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
                NativeCaller.TransferMessage(SettingActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "reboot", 1), 0);
                SettingActivity.this.finish();
            }
        }).show();
    }

    public void showSureReSet() {
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(this);
        instance.withMessage((CharSequence) getString(R.string.reset_show)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                new AsyncTask<Void, Void, Void>() {
                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        super.onPreExecute();
                        NativeCaller.TransferMessage(SettingActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "reset", 1), 0);
                    }

                    /* access modifiers changed from: protected */
                    public Void doInBackground(Void... voidArr) {
                        try {
                            Thread.sleep(500);
                            return null;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Void voidR) {
                        super.onPostExecute(voidR);
                        CameraParamsBean access$100 = SettingActivity.this.getCameraBean(SettingActivity.this.strDID);
                        if (access$100 != null) {
                            Intent intent = new Intent();
                            intent.setAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                            intent.putExtra(ContentCommon.CAMERA_OPTION, 2);
                            intent.putExtra(ContentCommon.STR_CAMERA_OLD_ID, SettingActivity.this.strDID);
                            intent.putExtra(ContentCommon.STR_CAMERA_NAME, access$100.getDev_name());
                            intent.putExtra(ContentCommon.STR_CAMERA_ID, SettingActivity.this.strDID.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").trim());
                            intent.putExtra(ContentCommon.STR_CAMERA_USER, "admin");
                            intent.putExtra(ContentCommon.STR_CAMERA_PWD, ContentCommon.SHIX_DEFUALT_PWD);
                            SettingActivity.this.sendBroadcast(intent);
                            SettingActivity.this.finish();
                            SettingActivity.this.startActivity(new Intent(SettingActivity.this, NUIMainActivity.class));
                        }
                    }
                }.execute(new Void[0]);
                instance.dismiss();
                SettingActivity.this.finish();
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public CameraParamsBean getCameraBean(String str) {
        int size = SystemValue.arrayList.size();
        for (int i = 0; i < size; i++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
            if (cameraParamsBean.getDev_Did().equalsIgnoreCase(str)) {
                SystemValue.position = i;
                return cameraParamsBean;
            }
        }
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.setting);
        findView();
        this.LanNetIp = "";
        TextView textView = this.tvCameraName;
        textView.setText(this.cameraName + "  " + getResources().getString(R.string.setting));
        this.textViewVersion = (TextView) findViewById(R.id.textViewVersion);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.textViewVersion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SettingActivity.this.isNew) {
                    Intent intent = new Intent(SettingActivity.this, OtaShowActivity.class);
                    intent.putExtra(ContentCommon.STR_CAMERA_ID, SettingActivity.this.strDID);
                    intent.putExtra(ContentCommon.STR_CAMERA_NAME, SettingActivity.this.cameraName);
                    intent.putExtra(ContentCommon.STR_CAMERA_UPDATAPATH, SettingActivity.this.binSer);
                    SettingActivity.this.startActivity(intent);
                    return;
                }
                SettingActivity.this.showToast((int) R.string.check_ser_showno);
            }
        });
        try {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            builder.detectFileUriExposure();
        } catch (Exception unused) {
        }
        NUIMainActivity.setSHIXCOMMONInterface(new NUIMainActivity.SHIXCOMMONInterface() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x001b A[ADDED_TO_REGION] */
            /* JADX WARNING: Removed duplicated region for block: B:27:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void CallBackSHIXJasonCommon(java.lang.String r3, java.lang.String r4) {
                /*
                    r2 = this;
                    java.lang.String r3 = "no"
                    r0 = 0
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0011 }
                    r1.<init>(r4)     // Catch:{ JSONException -> 0x0011 }
                    java.lang.String r4 = "cmd"
                    int r4 = r1.getInt(r4)     // Catch:{ JSONException -> 0x000f }
                    goto L_0x0017
                L_0x000f:
                    r4 = move-exception
                    goto L_0x0013
                L_0x0011:
                    r4 = move-exception
                    r1 = r0
                L_0x0013:
                    r4.printStackTrace()
                    r4 = 0
                L_0x0017:
                    r0 = 101(0x65, float:1.42E-43)
                    if (r4 != r0) goto L_0x0072
                    if (r1 == 0) goto L_0x0072
                    com.shix.shixipc.activity.SettingActivity r4 = com.shix.shixipc.activity.SettingActivity.this     // Catch:{ JSONException -> 0x0033 }
                    java.lang.String r0 = "sysver"
                    java.lang.String r0 = r1.getString(r0)     // Catch:{ JSONException -> 0x0033 }
                    java.lang.String unused = r4.sysver = r0     // Catch:{ JSONException -> 0x0033 }
                    com.shix.shixipc.activity.SettingActivity r4 = com.shix.shixipc.activity.SettingActivity.this     // Catch:{ JSONException -> 0x0033 }
                    com.shix.shixipc.activity.SettingActivity$9$1 r0 = new com.shix.shixipc.activity.SettingActivity$9$1     // Catch:{ JSONException -> 0x0033 }
                    r0.<init>()     // Catch:{ JSONException -> 0x0033 }
                    r4.runOnUiThread(r0)     // Catch:{ JSONException -> 0x0033 }
                    goto L_0x003c
                L_0x0033:
                    r4 = move-exception
                    r4.printStackTrace()
                    com.shix.shixipc.activity.SettingActivity r4 = com.shix.shixipc.activity.SettingActivity.this
                    java.lang.String unused = r4.sysver = r3
                L_0x003c:
                    com.shix.shixipc.activity.SettingActivity r4 = com.shix.shixipc.activity.SettingActivity.this     // Catch:{ JSONException -> 0x0048 }
                    java.lang.String r0 = "mcuver"
                    java.lang.String r0 = r1.getString(r0)     // Catch:{ JSONException -> 0x0048 }
                    java.lang.String unused = r4.mcuver = r0     // Catch:{ JSONException -> 0x0048 }
                    goto L_0x0051
                L_0x0048:
                    r4 = move-exception
                    r4.printStackTrace()
                    com.shix.shixipc.activity.SettingActivity r4 = com.shix.shixipc.activity.SettingActivity.this
                    java.lang.String unused = r4.mcuver = r3
                L_0x0051:
                    com.shix.shixipc.activity.SettingActivity r3 = com.shix.shixipc.activity.SettingActivity.this
                    java.lang.String r3 = r3.mcuver
                    if (r3 == 0) goto L_0x0072
                    com.shix.shixipc.activity.SettingActivity r3 = com.shix.shixipc.activity.SettingActivity.this
                    java.lang.String r3 = r3.mcuver
                    int r3 = r3.length()
                    r4 = 3
                    if (r3 <= r4) goto L_0x0072
                    java.lang.Thread r3 = new java.lang.Thread
                    com.shix.shixipc.activity.SettingActivity r4 = com.shix.shixipc.activity.SettingActivity.this
                    java.lang.Runnable r4 = r4.networkTask
                    r3.<init>(r4)
                    r3.start()
                L_0x0072:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.SettingActivity.C14079.CallBackSHIXJasonCommon(java.lang.String, java.lang.String):void");
            }
        });
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        try {
            this.bitmap = Create2DCode(this.strDID);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        if (this.bitmap != null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.qh_trans);
            int width = this.bitmap.getWidth();
            int height = this.bitmap.getHeight();
            int width2 = decodeResource.getWidth();
            int height2 = decodeResource.getHeight();
            float f = ((((float) width) * 1.0f) / 7.0f) / ((float) width2);
            this.bitmap1 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(this.bitmap1);
                canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
                canvas.scale(f, f, (float) (width / 2), (float) (height / 2));
                canvas.drawBitmap(decodeResource, (float) ((width - width2) / 2), (float) ((height - height2) / 2), (Paint) null);
                canvas.save();
                canvas.restore();
            } catch (Exception e2) {
                this.bitmap = null;
                e2.getStackTrace();
            }
            this.img_er = (ImageView) findViewById(R.id.img_er);
            this.img_er.setImageBitmap(this.bitmap1);
        }
        findViewById(R.id.img_er).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingActivity.this, 10);
                }
                View rootView = view.getRootView();
                rootView.setDrawingCacheEnabled(true);
                rootView.buildDrawingCache();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                CommonUtil.Log(1, "zhaogenghuai1");
                SettingActivity settingActivity = SettingActivity.this;
                Uri access$700 = settingActivity.savePicToSDcard(settingActivity.bitmap1);
                CommonUtil.Log(1, "zhaogenghuai2");
                intent.putExtra("android.intent.extra.STREAM", access$700);
                CommonUtil.Log(1, "zhaogenghuai3");
                SettingActivity settingActivity2 = SettingActivity.this;
                settingActivity2.startActivity(Intent.createChooser(intent, settingActivity2.getResources().getString(R.string.send_title)));
                CommonUtil.Log(1, "zhaogenghuai4");
            }
        });
        if (CommonUtil.SHIX_is100WDev(this.strDID).booleanValue()) {
            findViewById(R.id.setting_alerm).setVisibility(0);
            findViewById(R.id.view_sd).setVisibility(0);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.FileOutputStream} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5 A[SYNTHETIC, Splitter:B:34:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1 A[SYNTHETIC, Splitter:B:42:0x00b1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.net.Uri savePicToSDcard(android.graphics.Bitmap r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = r6.getStrDate()     // Catch:{ all -> 0x00ba }
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x009e }
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x009e }
            java.lang.String r4 = "LDDDD/pic"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x009e }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x009e }
            if (r3 != 0) goto L_0x001a
            r2.mkdirs()     // Catch:{ Exception -> 0x009e }
        L_0x001a:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x009e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e }
            r4.<init>()     // Catch:{ Exception -> 0x009e }
            r4.append(r0)     // Catch:{ Exception -> 0x009e }
            java.lang.String r0 = ".jpg"
            r4.append(r0)     // Catch:{ Exception -> 0x009e }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x009e }
            r3.<init>(r2, r0)     // Catch:{ Exception -> 0x009e }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x009e }
            r0.<init>(r3)     // Catch:{ Exception -> 0x009e }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r3 = 70
            boolean r2 = r7.compress(r2, r3, r0)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            if (r2 == 0) goto L_0x0042
            r0.flush()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
        L_0x0042:
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            java.lang.String r7 = android.provider.MediaStore.Images.Media.insertImage(r2, r7, r3, r4)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r2 = "test"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r3.<init>()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r4 = "zhaogenghuai savepath:"
            r3.append(r4)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r3.append(r7)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            android.util.Log.d(r2, r3)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            if (r7 == 0) goto L_0x008a
            int r2 = r7.length()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            if (r2 <= 0) goto L_0x008a
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r3 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r7 = r6.getFilePathByContentResolver(r6, r7)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            android.net.Uri r1 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r2.setData(r1)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            r6.sendBroadcast(r2)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
        L_0x008a:
            r0.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00ba }
        L_0x0092:
            r0 = r1
            goto L_0x00ad
        L_0x0094:
            r7 = move-exception
            goto L_0x00af
        L_0x0096:
            r7 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x00a0
        L_0x009b:
            r7 = move-exception
            r0 = r1
            goto L_0x00af
        L_0x009e:
            r7 = move-exception
            r0 = r1
        L_0x00a0:
            r7.printStackTrace()     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x00ad
            r1.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00ba }
        L_0x00ad:
            monitor-exit(r6)
            return r0
        L_0x00af:
            if (r0 == 0) goto L_0x00b9
            r0.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00ba }
        L_0x00b9:
            throw r7     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.SettingActivity.savePicToSDcard(android.graphics.Bitmap):android.net.Uri");
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    private String getFilePathByContentResolver(Context context, Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null) {
            try {
                if (query.getCount() == 1) {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                }
                return str;
            } finally {
                query.close();
            }
        } else {
            throw new IllegalArgumentException("Query on " + uri + " returns null result.");
        }
    }

    public void shareImage(Bitmap bitmap2) {
        try {
            Uri parse = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap2, (String) null, (String) null));
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", parse);
            intent.setType("image/*");
            getPackageManager().queryIntentActivities(intent, 32);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
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
        this.buttonAp = (Button) findViewById(R.id.setting_ap);
        this.buttonAler = (Button) findViewById(R.id.setting_alerm);
        this.buttonUser = (Button) findViewById(R.id.setting_use);
        this.buttonMail = (Button) findViewById(R.id.setting_mail);
        this.buttonFtp = (Button) findViewById(R.id.setting_ftp);
        this.buttonSd = (Button) findViewById(R.id.setting_sdcard);
        this.buttonTime = (Button) findViewById(R.id.setting_time);
        this.buttonReboot = (Button) findViewById(R.id.setting_reboot);
        this.buttonReboot.setOnClickListener(this);
        this.buttonWifi.setOnClickListener(this);
        this.buttonAp.setOnClickListener(this);
        this.buttonUser.setOnClickListener(this);
        this.buttonTime.setOnClickListener(this);
        this.buttonAler.setOnClickListener(this);
        this.buttonMail.setOnClickListener(this);
        this.buttonFtp.setOnClickListener(this);
        this.buttonSd.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
        findViewById(R.id.setting_voice).setOnClickListener(this);
        findViewById(R.id.setting_reset).setOnClickListener(this);
        findViewById(R.id.setting_updata).setOnClickListener(this);
        ((TextView) findViewById(R.id.textViewDID)).setText(this.strDID);
        findViewById(R.id.delbtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingActivity.this, 10);
                }
                if (SettingActivity.deleInterface != null) {
                    SettingActivity.deleInterface.CallBackDelSet(SettingActivity.this.strDID, SettingActivity.this.cameraName);
                }
                SettingActivity.this.finish();
            }
        });
        if (ContentCommon.SHIX_whoDevs(this.strDID) == 2) {
            findViewById(R.id.setting_wifi).setVisibility(8);
            findViewById(R.id.vewWifi).setVisibility(8);
            findViewById(R.id.setting_voice).setVisibility(0);
            findViewById(R.id.viewVoice).setVisibility(0);
        } else if (ContentCommon.SHIX_whoDevs(this.strDID) == 1) {
            findViewById(R.id.setting_wifi).setVisibility(0);
            findViewById(R.id.vewWifi).setVisibility(0);
            findViewById(R.id.setting_voice).setVisibility(8);
            findViewById(R.id.viewVoice).setVisibility(8);
        }
    }

    private int getPPPPStatus(String str) {
        int size = SystemValue.arrayList.size();
        for (int i = 0; i < size; i++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
            if (cameraParamsBean.getDev_Did().equalsIgnoreCase(str)) {
                return cameraParamsBean.getDev_p2pstatus();
            }
        }
        return 0;
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        if (view.getId() == R.id.back || getPPPPStatus(this.strDID) == 2) {
            int id = view.getId();
            if (id != R.id.back) {
                switch (id) {
                    case R.id.setting_alerm /*2131165766*/:
                        Intent intent = new Intent(this, SettingAlarmActivity.class);
                        intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent);
                        return;
                    case R.id.setting_reboot /*2131165770*/:
                        showSureReboot();
                        return;
                    case R.id.setting_reset /*2131165771*/:
                        showSureReSet();
                        return;
                    case R.id.setting_sdcard /*2131165772*/:
                        Intent intent2 = new Intent(this, SettingSDCardActivity.class);
                        intent2.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent2.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent2);
                        return;
                    case R.id.setting_time /*2131165773*/:
                        Intent intent3 = new Intent(this, SettingDateActivity.class);
                        intent3.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent3.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent3);
                        return;
                    case R.id.setting_updata /*2131165774*/:
                        if (this.upgrade_signal == 0) {
                            showToast((int) R.string.update_titl_update_no_show);
                            return;
                        }
                        int i = this.status;
                        if (i == 5) {
                            showUpdate();
                            return;
                        } else if (i == 1) {
                            showToast((int) R.string.check_updata_1);
                            return;
                        } else if (i == 2) {
                            showToast((int) R.string.check_updata_2);
                            return;
                        } else if (i == 3) {
                            showToast((int) R.string.check_updata_3);
                            return;
                        } else if (i == 4) {
                            showToast((int) R.string.check_updata_4);
                            return;
                        } else if (i == 6) {
                            showToast((int) R.string.check_updata_6);
                            return;
                        } else if (i == 7) {
                            showToast((int) R.string.check_updata_7);
                            return;
                        } else {
                            return;
                        }
                    case R.id.setting_use /*2131165775*/:
                        Intent intent4 = new Intent(this, PasswordSettingActivity.class);
                        intent4.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent4.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent4);
                        return;
                    case R.id.setting_voice /*2131165776*/:
                        Intent intent5 = new Intent(this, SettingDevAudioActivity.class);
                        intent5.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent5.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent5);
                        return;
                    case R.id.setting_wifi /*2131165777*/:
                        Intent intent6 = new Intent(this, SettingWifiActivity.class);
                        intent6.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent6.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent6);
                        return;
                    default:
                        return;
                }
            } else {
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        } else {
            showToast((int) R.string.device_not_on_line);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        StopHeat();
        MyBackBrod myBackBrod2 = this.myBackBrod;
        if (myBackBrod2 != null) {
            unregisterReceiver(myBackBrod2);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public static void setDeleDetInterface(DeleDetInterface deleDetInterface) {
        deleInterface = deleDetInterface;
    }

    public void getJSONObject(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
        httpURLConnection.setRequestMethod("GET");
        if (httpURLConnection.getResponseCode() == 200) {
            this.jsonStr = new String(readStream(httpURLConnection.getInputStream()));
            CommonUtil.Log(1, "getJSONObject:" + this.jsonStr);
            runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(SettingActivity.this.jsonStr);
                        SettingActivity.this.mcuverSer = jSONObject.getString("mcuver");
                        SettingActivity.this.sysverSer = jSONObject.getString("sysver");
                        SettingActivity.this.binSer = jSONObject.getString("bin");
                        SettingActivity.this.md5Ser = jSONObject.getString("md5");
                        CommonUtil.Log(1, "mcuverSer:" + SettingActivity.this.mcuverSer + "  sysverSer:" + SettingActivity.this.sysverSer + "  binSer:" + SettingActivity.this.binSer + "  md5Ser:" + SettingActivity.this.md5Ser + "  sysver:" + SettingActivity.this.sysver);
                        String[] split = SettingActivity.this.sysver.split("\\.");
                        String[] split2 = SettingActivity.this.sysverSer.split("\\.");
                        int i = 0;
                        SettingActivity.this.isNew = false;
                        StringBuilder sb = new StringBuilder();
                        sb.append("str1.length:");
                        sb.append(split.length);
                        sb.append("  str2.length:");
                        sb.append(split2.length);
                        CommonUtil.Log(1, sb.toString());
                        if (split != null && split2 != null) {
                            while (true) {
                                if (i >= split.length) {
                                    break;
                                }
                                int parseInt = Integer.parseInt(split[i]);
                                int parseInt2 = Integer.parseInt(split2[i]);
                                CommonUtil.Log(1, "a1:" + parseInt + "  a2:" + parseInt2 + "  str1:" + split + "  str2:" + split2);
                                if (parseInt2 > parseInt) {
                                    SettingActivity.this.isNew = true;
                                    break;
                                }
                                i++;
                            }
                            if (SettingActivity.this.isNew) {
                                SettingActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        SettingActivity.this.textViewVersion.setTextColor(SettingActivity.this.getResources().getColor(R.color.red));
                                        TextView access$400 = SettingActivity.this.textViewVersion;
                                        access$400.setText("" + SettingActivity.this.sysver + "\n" + SettingActivity.this.getResources().getString(R.string.check_ser_showyes) + "" + SettingActivity.this.sysverSer);
                                    }
                                });
                                return;
                            }
                            TextView access$400 = SettingActivity.this.textViewVersion;
                            access$400.setText("" + SettingActivity.this.sysver + "\n" + SettingActivity.this.getResources().getString(R.string.check_ser_showno));
                        }
                    } catch (Exception unused) {
                        SettingActivity settingActivity = SettingActivity.this;
                        settingActivity.mcuverSer = "";
                        settingActivity.sysverSer = "";
                        settingActivity.binSer = "";
                        settingActivity.md5Ser = "";
                    }
                }
            });
        }
    }

    public static byte[] readStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
