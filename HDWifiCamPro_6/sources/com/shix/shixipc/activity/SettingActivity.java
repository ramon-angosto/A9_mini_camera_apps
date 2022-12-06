package com.shix.shixipc.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.nativecaller.NativeCaller;

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
    /* access modifiers changed from: private */
    public int clickCount = 0;
    ImageView img_er;
    /* access modifiers changed from: private */
    public int isExistTf;
    private LinearLayout linearLayoutAll;
    /* access modifiers changed from: private */
    public String machver = MBridgeConstans.ENDCARD_URL_TYPE_PL;
    private MyBackBrod myBackBrod = null;
    /* access modifiers changed from: private */
    public String server_ver = "";
    /* access modifiers changed from: private */
    public String strDID;
    /* access modifiers changed from: private */
    public String sysver = "";
    /* access modifiers changed from: private */
    public TextView textViewVersion;
    private TextView tvCameraName;
    /* access modifiers changed from: private */
    public TextView tvCloud;

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

    public void showSureUp() {
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(this);
        instance.withMessage((CharSequence) "发现新固件，是否进行升级？").withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
                NativeCaller.TransferMessage(SettingActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "upgrade", 1), 0);
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
                            intent.putExtra(ContentCommon.STR_CAMERA_ID, SettingActivity.this.strDID.replace("-", "").trim());
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

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x00cc */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            super.onCreate(r11)
            r10.getDataFromOther()
            r11 = 1
            r10.requestWindowFeature(r11)
            r11 = 2131427547(0x7f0b00db, float:1.8476713E38)
            r10.setContentView(r11)
            r10.findView()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = r10.strDID
            r11.append(r0)
            java.lang.String r0 = "isExistTf"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r0 = 3
            int r11 = com.shix.shixipc.utils.CommonUtil.GetCommonShareIntValue(r10, r11, r0)
            r10.isExistTf = r11
            int r11 = r10.isExistTf
            r0 = 2131232178(0x7f0805b2, float:1.8080458E38)
            r1 = 2131231613(0x7f08037d, float:1.8079312E38)
            r2 = 0
            if (r11 != 0) goto L_0x0049
            android.view.View r11 = r10.findViewById(r1)
            r1 = 8
            r11.setVisibility(r1)
            android.view.View r11 = r10.findViewById(r0)
            r11.setVisibility(r1)
            goto L_0x0057
        L_0x0049:
            android.view.View r11 = r10.findViewById(r1)
            r11.setVisibility(r2)
            android.view.View r11 = r10.findViewById(r0)
            r11.setVisibility(r2)
        L_0x0057:
            java.lang.String r11 = ""
            r10.LanNetIp = r11
            android.widget.TextView r11 = r10.tvCameraName
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r10.cameraName
            r0.append(r1)
            java.lang.String r1 = "  "
            r0.append(r1)
            android.content.res.Resources r1 = r10.getResources()
            r3 = 2131690192(0x7f0f02d0, float:1.900942E38)
            java.lang.String r1 = r1.getString(r3)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.setText(r0)
            r11 = 2131231724(0x7f0803ec, float:1.8079537E38)
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.textViewVersion = r11
            android.widget.TextView r11 = r10.textViewVersion
            com.shix.shixipc.activity.SettingActivity$7 r0 = new com.shix.shixipc.activity.SettingActivity$7
            r0.<init>()
            r11.setOnClickListener(r0)
            int r11 = com.shix.shixipc.system.StyleCommon.Color_All_Top_StatuBar_Bg
            r10.SetTab(r10, r11)
            com.shix.shixipc.activity.SettingActivity$8 r11 = new com.shix.shixipc.activity.SettingActivity$8
            r11.<init>()
            com.shix.shixipc.activity.NUIMainActivity.setSHIXCOMMONInterface(r11)
            java.lang.String r11 = r10.strDID
            java.lang.String r0 = com.shix.shixipc.system.SystemValue.doorBellAdmin
            java.lang.String r1 = com.shix.shixipc.system.SystemValue.doorBellPass
            java.lang.String r0 = com.shix.shixipc.utils.CommonUtil.getCloudsupport(r0, r1)
            object.p2pipcam.nativecaller.NativeCaller.TransferMessage(r11, r0, r2)
            java.lang.String r11 = r10.strDID
            java.lang.String r0 = com.shix.shixipc.system.SystemValue.doorBellAdmin
            java.lang.String r1 = com.shix.shixipc.system.SystemValue.doorBellPass
            java.lang.String r0 = com.shix.shixipc.utils.CommonUtil.getCameraParms(r0, r1)
            object.p2pipcam.nativecaller.NativeCaller.TransferMessage(r11, r0, r2)
            android.os.StrictMode$VmPolicy$Builder r11 = new android.os.StrictMode$VmPolicy$Builder     // Catch:{ Exception -> 0x00cc }
            r11.<init>()     // Catch:{ Exception -> 0x00cc }
            android.os.StrictMode$VmPolicy r0 = r11.build()     // Catch:{ Exception -> 0x00cc }
            android.os.StrictMode.setVmPolicy(r0)     // Catch:{ Exception -> 0x00cc }
            r11.detectFileUriExposure()     // Catch:{ Exception -> 0x00cc }
        L_0x00cc:
            java.lang.String r11 = r10.strDID     // Catch:{ WriterException -> 0x00d5 }
            android.graphics.Bitmap r11 = r10.Create2DCode(r11)     // Catch:{ WriterException -> 0x00d5 }
            r10.bitmap = r11     // Catch:{ WriterException -> 0x00d5 }
            goto L_0x00d9
        L_0x00d5:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00d9:
            android.graphics.Bitmap r11 = r10.bitmap
            r0 = 2131231125(0x7f080195, float:1.8078322E38)
            if (r11 == 0) goto L_0x014e
            android.content.res.Resources r11 = r10.getResources()
            r1 = 2131493032(0x7f0c00a8, float:1.8609533E38)
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeResource(r11, r1)
            android.graphics.Bitmap r1 = r10.bitmap
            int r1 = r1.getWidth()
            android.graphics.Bitmap r2 = r10.bitmap
            int r2 = r2.getHeight()
            int r3 = r11.getWidth()
            int r4 = r11.getHeight()
            float r5 = (float) r1
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r5 * r6
            r6 = 1088421888(0x40e00000, float:7.0)
            float r5 = r5 / r6
            float r6 = (float) r3
            float r5 = r5 / r6
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r1, r2, r6)
            r10.bitmap1 = r6
            r6 = 0
            android.graphics.Canvas r7 = new android.graphics.Canvas     // Catch:{ Exception -> 0x0139 }
            android.graphics.Bitmap r8 = r10.bitmap1     // Catch:{ Exception -> 0x0139 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0139 }
            android.graphics.Bitmap r8 = r10.bitmap     // Catch:{ Exception -> 0x0139 }
            r9 = 0
            r7.drawBitmap(r8, r9, r9, r6)     // Catch:{ Exception -> 0x0139 }
            int r8 = r1 / 2
            float r8 = (float) r8     // Catch:{ Exception -> 0x0139 }
            int r9 = r2 / 2
            float r9 = (float) r9     // Catch:{ Exception -> 0x0139 }
            r7.scale(r5, r5, r8, r9)     // Catch:{ Exception -> 0x0139 }
            int r1 = r1 - r3
            int r1 = r1 / 2
            float r1 = (float) r1     // Catch:{ Exception -> 0x0139 }
            int r2 = r2 - r4
            int r2 = r2 / 2
            float r2 = (float) r2     // Catch:{ Exception -> 0x0139 }
            r7.drawBitmap(r11, r1, r2, r6)     // Catch:{ Exception -> 0x0139 }
            r7.save()     // Catch:{ Exception -> 0x0139 }
            r7.restore()     // Catch:{ Exception -> 0x0139 }
            goto L_0x013f
        L_0x0139:
            r11 = move-exception
            r10.bitmap = r6
            r11.getStackTrace()
        L_0x013f:
            android.view.View r11 = r10.findViewById(r0)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r10.img_er = r11
            android.widget.ImageView r11 = r10.img_er
            android.graphics.Bitmap r1 = r10.bitmap1
            r11.setImageBitmap(r1)
        L_0x014e:
            android.view.View r11 = r10.findViewById(r0)
            com.shix.shixipc.activity.SettingActivity$9 r0 = new com.shix.shixipc.activity.SettingActivity$9
            r0.<init>()
            r11.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.SettingActivity.onCreate(android.os.Bundle):void");
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.net.Uri] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ce A[SYNTHETIC, Splitter:B:37:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00da A[SYNTHETIC, Splitter:B:45:0x00da] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.net.Uri savePicToSDcard(android.graphics.Bitmap r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = r6.getStrDate()     // Catch:{ all -> 0x00e3 }
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00c7 }
            java.io.File r3 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "LDDDD/pic"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x00c7 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00c7 }
            if (r3 != 0) goto L_0x001a
            r2.mkdirs()     // Catch:{ Exception -> 0x00c7 }
        L_0x001a:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00c7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c7 }
            r4.<init>()     // Catch:{ Exception -> 0x00c7 }
            r4.append(r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = ".jpg"
            r4.append(r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00c7 }
            r3.<init>(r2, r0)     // Catch:{ Exception -> 0x00c7 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c7 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00c7 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r4 = 90
            boolean r2 = r7.compress(r2, r4, r0)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r2 == 0) goto L_0x0042
            r0.flush()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
        L_0x0042:
            java.lang.String r2 = r3.getPath()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r4 = 23
            if (r3 > r4) goto L_0x0095
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            java.lang.String r7 = android.provider.MediaStore.Images.Media.insertImage(r2, r7, r3, r4)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r2 = "test"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.<init>()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r4 = "zhaogenghuai savepath:"
            r3.append(r4)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.append(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.util.Log.d(r2, r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r7 == 0) goto L_0x00b3
            int r2 = r7.length()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r2 <= 0) goto L_0x00b3
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r2.<init>(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r7 = r6.getFilePathByContentResolver(r6, r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.<init>(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.net.Uri r1 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r2.setData(r1)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r6.sendBroadcast(r2)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            goto L_0x00b3
        L_0x0095:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r7.<init>()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = r6.getPackageName()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r7.append(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = ".fileprovider"
            r7.append(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r6, r7, r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
        L_0x00b3:
            r0.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00bb:
            r0 = r1
            goto L_0x00d6
        L_0x00bd:
            r7 = move-exception
            goto L_0x00d8
        L_0x00bf:
            r7 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x00c9
        L_0x00c4:
            r7 = move-exception
            r0 = r1
            goto L_0x00d8
        L_0x00c7:
            r7 = move-exception
            r0 = r1
        L_0x00c9:
            r7.printStackTrace()     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x00d6
            r1.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00d6:
            monitor-exit(r6)
            return r0
        L_0x00d8:
            if (r0 == 0) goto L_0x00e2
            r0.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00e2
        L_0x00de:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00e2:
            throw r7     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
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
        findViewById(R.id.viewAlarm).setVisibility(0);
        findViewById(R.id.setting_alerm).setVisibility(0);
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
        this.tvCloud = (TextView) findViewById(R.id.tvCloud);
        findViewById(R.id.check_ver).setOnClickListener(this);
        this.linearLayoutAll = (LinearLayout) findViewById(R.id.linearLayoutAll);
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
        findViewById(R.id.tvWX).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, TestNotyActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, SettingActivity.this.strDID);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, SettingActivity.this.cameraName);
                SettingActivity.this.startActivity(intent);
            }
        });
        this.tvCameraName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingActivity settingActivity = SettingActivity.this;
                int unused = settingActivity.clickCount = settingActivity.clickCount + 1;
                int unused2 = SettingActivity.this.clickCount;
            }
        });
        findViewById(R.id.tvCloud).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        findViewById(R.id.tvCloud).setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return false;
            }
        });
        findViewById(R.id.setting_reset).setOnClickListener(this);
        ((TextView) findViewById(R.id.textViewDID)).setText(this.strDID);
        if (CommonUtil.isMJOldCamera(this.strDID)) {
            this.linearLayoutAll.setVisibility(8);
        } else {
            this.linearLayoutAll.setVisibility(0);
        }
        if (CommonUtil.SHIX_isBkDid(this.strDID).booleanValue()) {
            CommonUtil.Log(1, "SHIXZHAO------1  strDID:" + this.strDID + "  DGO");
            findViewById(R.id.viewTime).setVisibility(8);
            findViewById(R.id.setting_time).setVisibility(8);
            CommonUtil.Log(1, "SHIXZHAO------1");
        } else if (CommonUtil.isMJCamera(this.strDID)) {
            findViewById(R.id.viewAlarm).setVisibility(8);
            findViewById(R.id.setting_alerm).setVisibility(8);
            CommonUtil.Log(1, "SHIXZHAO------2");
        }
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
                    case R.id.setting_alerm:
                        Intent intent = new Intent(this, SettingAlarmActivity.class);
                        intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent);
                        return;
                    case R.id.setting_reboot:
                        showSureReboot();
                        return;
                    case R.id.setting_reset:
                        showSureReSet();
                        return;
                    case R.id.setting_sdcard:
                        Intent intent2 = new Intent(this, SettingSDCardActivity.class);
                        intent2.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent2.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent2);
                        return;
                    case R.id.setting_time:
                        Intent intent3 = new Intent(this, SettingDateActivity.class);
                        intent3.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent3.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent3);
                        return;
                    case R.id.setting_use:
                        Intent intent4 = new Intent(this, PasswordSettingActivity.class);
                        intent4.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent4.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent4);
                        return;
                    case R.id.setting_wifi:
                        Intent intent5 = new Intent(this, SettingWifiActivity.class);
                        intent5.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                        intent5.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
                        startActivity(intent5);
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
}
