package shix.ihdbell.project;

import android.app.NotificationManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import object.p2pipcam.adapter.AlarmLogAdapter;
import object.p2pipcam.bean.AlarmLogBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.view.RoundProgressBar;
import shix.ihdbell.project.BridgeService;

public class AlarmLogActivity extends BaseActivity implements View.OnClickListener, BridgeService.SnapShotInterface, BridgeService.LogsInterface {
    private final int BEND = 1;
    private final int BEND1 = 2;
    private Handler BitMapHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 110) {
                AlarmLogActivity.this.imageView.setImageBitmap(AlarmLogActivity.this.bmp);
                AlarmLogActivity.this.takePicture();
                return;
            }
            AlarmLogActivity.this.textView_name.setText("/mnt/sdcard/LittleStars/picVisitor/");
            AlarmLogActivity.this.adapter.notifyDataSetChanged();
            Log.d("test", "savePicToSDcard4");
        }
    };
    /* access modifiers changed from: private */
    public AlarmLogAdapter adapter;
    /* access modifiers changed from: private */
    public Bitmap bmp;
    private Button btnBack;
    private Button buttonPlay;
    private Button button_cancel;
    private Button button_ok;
    private String camName;
    private String dateTime = "";
    private String did;
    private FrameLayout framelayout;
    private DataBaseHelper helper = null;
    /* access modifiers changed from: private */
    public ImageView imageView;
    private LinearLayout linearLayout_buttom;
    private ListView listView;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                AlarmLogActivity.this.adapter.addarrayList11111(message.getData().getString("uuid"), message.getData().getString(DataBaseHelper.KEY_USER), message.getData().getInt("status"));
            } else if (i == 2) {
                AlarmLogActivity.this.adapter.UpdataArrayList();
                AlarmLogActivity.this.adapter.notifyDataSetChanged();
            }
        }
    };
    String pathTest;
    private int play_tag_log = 0;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_re;
    private View popv_re;
    private RoundProgressBar roundProgressBar1_1;
    private TextView textView;
    /* access modifiers changed from: private */
    public TextView textView_name;
    private TextView tvNoLog;
    private TextView tv_camera_setting;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.alarmlog);
        findView();
        setListener();
        this.helper = DataBaseHelper.getInstance(this);
        this.adapter = new AlarmLogAdapter(this, this);
        this.listView.setAdapter(this.adapter);
        BridgeService.setSnapShotInterface(this);
        BridgeService.setLogsInterface(this);
        getDataFromOther();
        if (this.adapter.getCount() > 0) {
            this.listView.setVisibility(0);
            this.tvNoLog.setVisibility(8);
        } else {
            this.listView.setVisibility(8);
            this.tvNoLog.setVisibility(0);
        }
        if (this.play_tag_log == 1) {
            this.linearLayout_buttom.setVisibility(0);
            this.btnBack.setVisibility(8);
        }
        initExitPopupWindow_re();
        TextView textView2 = this.tv_camera_setting;
        textView2.setText(this.camName + " " + getResources().getString(R.string.alerm_log));
        SetTab(this);
    }

    public void showPic(int i, String str, String str2, String str3, String str4, String str5, int i2) {
        String str6 = str5;
        Log.d("test", "-------------uuid-----------------" + str6);
        String replace = str4.replace(" ", "_").replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "_").replace(":", "_");
        if (i2 == 0) {
            NativeCaller.SnapShot(this.did, str6);
            if (str6 == null || str5.length() < 21) {
                this.dateTime = "";
            } else {
                this.dateTime = str6.substring(0, 10) + "  " + str6.substring(15, 17) + ":" + str6.substring(18, 20) + ":" + str6.substring(21);
                StringBuilder sb = new StringBuilder();
                sb.append("CallBack_AlarmNotifyDoorBell dateTime:");
                sb.append(str6);
                Log.d("test", sb.toString());
            }
        } else {
            TextView textView2 = this.textView_name;
            textView2.setText("/mnt/sdcard/LittleStars/picVisitor/\n" + replace + ".jpg");
        }
        this.pathTest = Environment.getExternalStorageDirectory() + "/" + ContentCommon.SDCARD_PATH + "/picVisitor/" + replace + ".jpg";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("----showPic----pathTest:");
        sb2.append(this.pathTest);
        Log.d("test", sb2.toString());
        String str7 = str2.length() < 2 ? "13" : str2;
        if ((str7.length() == 2 ? Integer.parseInt(str7.substring(0, 1)) : 11) != 1) {
            int i3 = i;
            this.adapter.UpdataCheck(i);
            this.adapter.notifyDataSetChanged();
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            Bitmap decodeFile = BitmapFactory.decodeFile(this.pathTest, options);
            if (decodeFile != null) {
                this.imageView.setImageBitmap(decodeFile);
            } else {
                this.imageView.setImageResource(R.drawable.vidicon);
            }
        } catch (Exception unused) {
            this.imageView.setImageResource(R.drawable.vidicon);
        }
        TextView textView3 = this.textView;
        StringBuilder sb3 = new StringBuilder();
        String str8 = str;
        sb3.append(str);
        sb3.append("  ");
        sb3.append(str3);
        textView3.setText(sb3.toString());
        this.popupWindow_re.showAtLocation(this.btnBack, 17, 0, 0);
    }

    /* access modifiers changed from: private */
    public void takePicture() {
        new Thread() {
            public void run() {
                AlarmLogActivity.this.savePicToSDcard();
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3 A[SYNTHETIC, Splitter:B:38:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b9 A[SYNTHETIC, Splitter:B:47:0x00b9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            java.lang.String r1 = "test"
            java.lang.String r2 = "savePicToSDcard1"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x00ce }
            r1 = 111(0x6f, float:1.56E-43)
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0096 }
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0096 }
            java.lang.String r4 = "LittleStars/picVisitor"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0096 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x0096 }
            if (r3 != 0) goto L_0x001f
            r2.mkdirs()     // Catch:{ Exception -> 0x0096 }
        L_0x001f:
            java.lang.String r2 = r6.dateTime     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = " "
            java.lang.String r4 = "_"
            java.lang.String r2 = r2.replace(r3, r4)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = "-"
            java.lang.String r4 = "_"
            java.lang.String r2 = r2.replace(r3, r4)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = ":"
            java.lang.String r4 = "_"
            r2.replace(r3, r4)     // Catch:{ Exception -> 0x0096 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = r6.pathTest     // Catch:{ Exception -> 0x0096 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0096 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x0096 }
            if (r3 == 0) goto L_0x0047
            monitor-exit(r6)
            return
        L_0x0047:
            java.lang.String r3 = "test"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0096 }
            r4.<init>()     // Catch:{ Exception -> 0x0096 }
            java.lang.String r5 = "savePicToSDcard1---file:"
            r4.append(r5)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0096 }
            r4.append(r5)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0096 }
            android.util.Log.d(r3, r4)     // Catch:{ Exception -> 0x0096 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0096 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0096 }
            android.graphics.Bitmap r0 = r6.bmp     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r0 == 0) goto L_0x0079
            android.graphics.Bitmap r0 = r6.bmp     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r4 = 60
            boolean r0 = r0.compress(r2, r4, r3)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r0 == 0) goto L_0x0079
            r3.flush()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
        L_0x0079:
            r3.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00ce }
        L_0x0081:
            java.lang.String r0 = "test"
            java.lang.String r2 = "savePicToSDcard3"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ce }
            android.os.Handler r0 = r6.BitMapHandler     // Catch:{ all -> 0x00ce }
        L_0x008a:
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x00ce }
            goto L_0x00b5
        L_0x008e:
            r2 = move-exception
            r0 = r3
            goto L_0x00b7
        L_0x0091:
            r2 = move-exception
            r0 = r3
            goto L_0x0097
        L_0x0094:
            r2 = move-exception
            goto L_0x00b7
        L_0x0096:
            r2 = move-exception
        L_0x0097:
            r2.printStackTrace()     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = "test"
            java.lang.String r3 = "savePicToSDcard2"
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x00b5
            r0.close()     // Catch:{ IOException -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00ce }
        L_0x00ab:
            java.lang.String r0 = "test"
            java.lang.String r2 = "savePicToSDcard3"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ce }
            android.os.Handler r0 = r6.BitMapHandler     // Catch:{ all -> 0x00ce }
            goto L_0x008a
        L_0x00b5:
            monitor-exit(r6)
            return
        L_0x00b7:
            if (r0 == 0) goto L_0x00cd
            r0.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00c1
        L_0x00bd:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00ce }
        L_0x00c1:
            java.lang.String r0 = "test"
            java.lang.String r3 = "savePicToSDcard3"
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00ce }
            android.os.Handler r0 = r6.BitMapHandler     // Catch:{ all -> 0x00ce }
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x00ce }
        L_0x00cd:
            throw r2     // Catch:{ all -> 0x00ce }
        L_0x00ce:
            r0 = move-exception
            monitor-exit(r6)
            goto L_0x00d2
        L_0x00d1:
            throw r0
        L_0x00d2:
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.AlarmLogActivity.savePicToSDcard():void");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void initExitPopupWindow_re() {
        this.popv_re = LayoutInflater.from(this).inflate(R.layout.popup_cloud, (ViewGroup) null);
        this.textView = (TextView) this.popv_re.findViewById(R.id.textView);
        this.textView_name = (TextView) this.popv_re.findViewById(R.id.textView_name);
        this.imageView = (ImageView) this.popv_re.findViewById(R.id.imageView);
        this.framelayout = (FrameLayout) this.popv_re.findViewById(R.id.framelayout);
        this.buttonPlay = (Button) this.popv_re.findViewById(R.id.buttonPlay);
        this.roundProgressBar1_1 = (RoundProgressBar) this.popv_re.findViewById(R.id.roundProgressBar);
        this.buttonPlay.setVisibility(8);
        this.roundProgressBar1_1.setVisibility(8);
        this.popupWindow_re = new PopupWindow(this.popv_re, -1, -1);
        this.popupWindow_re.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_re.setFocusable(true);
        this.popupWindow_re.setOutsideTouchable(true);
        this.popupWindow_re.setBackgroundDrawable(new ColorDrawable(0));
        ((Button) this.popv_re.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlarmLogActivity.this.popupWindow_re.dismiss();
            }
        });
        this.imageView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("test", "shix_image_ontou");
                AlarmLogActivity.this.popupWindow_re.dismiss();
                return false;
            }
        });
        this.popupWindow_re.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                AlarmLogActivity.this.popupWindow_re.dismiss();
            }
        });
        this.popupWindow_re.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                AlarmLogActivity.this.popupWindow_re.dismiss();
                return false;
            }
        });
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.did = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.camName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.play_tag_log = intent.getIntExtra("play_tag_log", 0);
        initData();
    }

    private void initData() {
        this.adapter.clearAllAlarmLog();
        Cursor queryAllAlarmLog = this.helper.queryAllAlarmLog(this.did);
        if (queryAllAlarmLog != null) {
            int i = 0;
            int i2 = 0;
            while (queryAllAlarmLog.moveToNext()) {
                i++;
                if (i <= 30) {
                    String string = queryAllAlarmLog.getString(queryAllAlarmLog.getColumnIndex(DataBaseHelper.KEY_CREATETIME));
                    String string2 = queryAllAlarmLog.getString(queryAllAlarmLog.getColumnIndex("content"));
                    String string3 = queryAllAlarmLog.getString(queryAllAlarmLog.getColumnIndex(DataBaseHelper.KEY_UUID));
                    String string4 = queryAllAlarmLog.getString(queryAllAlarmLog.getColumnIndex(DataBaseHelper.KEY_USER));
                    int i3 = queryAllAlarmLog.getInt(queryAllAlarmLog.getColumnIndex(DataBaseHelper.KEY_STATUS));
                    Log.d("tag", "createTime:" + string);
                    AlarmLogBean alarmLogBean = new AlarmLogBean();
                    alarmLogBean.setContent(string2);
                    alarmLogBean.setCreatetime(string);
                    alarmLogBean.setUUID(string3);
                    alarmLogBean.setCamName(this.camName);
                    alarmLogBean.setUser(string4);
                    alarmLogBean.setStatus(i3);
                    this.adapter.addAlarmLog(alarmLogBean);
                } else {
                    String string5 = queryAllAlarmLog.getString(queryAllAlarmLog.getColumnIndex(DataBaseHelper.KEY_CREATETIME));
                    this.helper.delAlarmLog(this.did, string5);
                    String replace = string5.replace(" ", "_").replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "_").replace(":", "_");
                    File file = new File(Environment.getExternalStorageDirectory() + "/" + ContentCommon.SDCARD_PATH + "/picVisitor/" + replace + ".jpg");
                    if (file.exists()) {
                        boolean delete = file.delete();
                        Log.e("tagdel", "if delect====" + delete);
                    } else {
                        Log.e("tagdel", "if delect====no");
                    }
                    i2++;
                    if (i2 == 3) {
                        break;
                    }
                }
            }
            queryAllAlarmLog.close();
            NativeCaller.PPPPGetSystemParams(this.did, 60);
            this.adapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        this.btnBack.setOnClickListener(this);
        this.button_cancel.setOnClickListener(this);
        this.button_ok.setOnClickListener(this);
    }

    private void findView() {
        this.btnBack = (Button) findViewById(R.id.back);
        this.listView = (ListView) findViewById(R.id.listView1);
        this.tvNoLog = (TextView) findViewById(R.id.no_log);
        this.button_cancel = (Button) findViewById(R.id.aler_cancel);
        this.button_ok = (Button) findViewById(R.id.aler_ok);
        this.linearLayout_buttom = (LinearLayout) findViewById(R.id.alarm_bottom_layout);
        this.tv_camera_setting = (TextView) findViewById(R.id.tv_camera_setting);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getDataFromOther();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.adapter = null;
        BridgeService.setSnapShotInterface((BridgeService.SnapShotInterface) null);
        BridgeService.setLogsInterface((BridgeService.LogsInterface) null);
        ((NotificationManager) getSystemService("notification")).cancel(110);
        SystemValue.PushAlarmCount = 0;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aler_cancel:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.back:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            default:
                return;
        }
    }

    private String retrunUser(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDid())) {
                i++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i).getUser());
                return SystemValue.arrayList.get(i).getUser();
            }
        }
        return null;
    }

    private String retrunUserPWD(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDid())) {
                i++;
            } else {
                Log.d("tag", "testuserpwd:" + SystemValue.arrayList.get(i).getPwd());
                return SystemValue.arrayList.get(i).getPwd();
            }
        }
        return null;
    }

    public void BSSnapshot(String str, byte[] bArr, int i) {
        this.bmp = BitmapFactory.decodeByteArray(bArr, 0, i);
        this.BitMapHandler.sendEmptyMessage(110);
    }

    public void CallBack_DoorBell_Logs(String str, String str2, int i, int i2) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString(DataBaseHelper.KEY_USER, str2);
        bundle.putString("uuid", str);
        bundle.putInt("status", i);
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
        if (i2 == 1) {
            this.mHandler.sendEmptyMessage(2);
        }
    }
}
