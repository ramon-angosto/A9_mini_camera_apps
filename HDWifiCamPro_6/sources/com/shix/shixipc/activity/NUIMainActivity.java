package com.shix.shixipc.activity;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.shix.qhipc.R;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.PushUtils;
import com.shix.shixipc.activity.FragmentCameraList;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.SystemBarTintManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;

public class NUIMainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener, FragmentCameraList.NewUiMainInterface {
    private static AddCameraInterface1 addCameraInterface;
    private static ConnectChannelStatusInterface1 connectChannelStatusInterface1;
    private static ConnectStatusInterface1 connectStatusInterface;
    private static IPPlayInterface ipPlayInterface;
    private static IpcamClientInterface ipcamClientInterface;
    private static P2PMpdeInterface p2pMpdeInterface;
    private static PlayBackInterface playBackInterface;
    private static PlayInterface playInterface;
    private static SHIXAlarmInterface shixAlarmInterface;
    private static SHIXCOMMONInterface shixOMMONInterface;
    private static SnapShotInterface snapShotInterface;
    private static VideoTransInterface videoTransInterface;
    private String TAG = "NUIMainActivity";
    private LinearLayout bottom_tab;
    private FrameLayout container;
    private int devType;
    private FragmentAlarm fragmentAlarm;
    private FragmentCameraList fragmentCameraList;
    private FragmentManager fragmentManager;
    private FragmentPicture fragmentPicture;
    private FragmentVideo fragmentVideo;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private boolean isGetSnap;
    private boolean isSnap;
    String jsonStr;
    private LinearLayout layoutAbout;
    private LinearLayout layoutAlarm;
    private LinearLayout layoutPic;
    private LinearLayout layoutVid;
    private LinearLayout layoutVidicon;
    /* access modifiers changed from: private */
    public int mFinalCount = 0;
    Runnable networkTask = new Runnable() {
        public void run() {
            try {
                NUIMainActivity.this.getJSONObject("https://hdwifiapp.oss-cn-hongkong.aliyuncs.com/testapk.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_show;
    private View popv_show;
    /* access modifiers changed from: private */
    public SharedPreferences preuser;
    private int snapCount = 0;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    public interface AddCameraInterface1 {
        void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2);
    }

    public interface ConnectChannelStatusInterface1 {
        void BSCallBack_TYPEMODE(String str, String str2);

        void BSMsgNotifyData(String str, int i, int i2);
    }

    public interface ConnectStatusInterface1 {
        void BSCallBack_TYPEMODE(String str, String str2);

        void BSMsgNotifyData(String str, int i, int i2);
    }

    public interface IPPlayInterface {
        void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4);

        void callBackAudioData(byte[] bArr, int i);

        void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6);

        void callBackH264Data(byte[] bArr, int i, int i2);

        void callBackMessageNotify(String str, int i, int i2);
    }

    public interface IpcamClientInterface {
        void BSMsgNotifyData(String str, int i, int i2);

        void BSSnapshotNotify(String str, byte[] bArr, int i);

        void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4);

        void callBackAudioData(byte[] bArr, int i);

        void callBackH264Data(String str, byte[] bArr, int i, int i2);

        void callBackMessageNotify(String str, int i, int i2);
    }

    public interface P2PMpdeInterface {
        void CallBack_Checkhandle(String str, String str2, String str3, String str4, int i);
    }

    public interface PlayBackInterface {
        void AudioPCMDataPlayBack(byte[] bArr, int i, int i2);

        void callBackH264Data(String str, byte[] bArr, int i, int i2);

        void callBackPlaybackAudioData(byte[] bArr, int i);

        void callBackPlaybackVideoData(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7);
    }

    public interface PlayInterface {
        void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5);

        void callBackAudioData(byte[] bArr, int i);

        void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        void callBackConnectLook(String str, int i, int i2);

        void callBackH264Data(String str, byte[] bArr, int i, int i2);

        void callBackMessageNotify(String str, int i, int i2);
    }

    public interface SHIXAlarmInterface {
        void CallBackSHIXJasonAlarm(String str, String str2);
    }

    public interface SHIXCOMMONInterface {
        void CallBackSHIXJasonCommon(String str, String str2);
    }

    public interface SnapShotInterface {
        void BSSnapshotNotify(String str, byte[] bArr, int i);
    }

    public interface VideoTransInterface {
        void VideoTrans_H264H265(String str, byte[] bArr, int i, int i2, int i3);
    }

    private void CallBack_RecordFileSearchResult(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    private void getFCMToken() {
    }

    private void getToken() {
    }

    private void whatPhone() {
    }

    public void AudioDataPlayBack(byte[] bArr, int i) {
    }

    public void MessageNotifyDNS(int i) {
    }

    static /* synthetic */ int access$008(NUIMainActivity nUIMainActivity) {
        int i = nUIMainActivity.mFinalCount;
        nUIMainActivity.mFinalCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(NUIMainActivity nUIMainActivity) {
        int i = nUIMainActivity.mFinalCount;
        nUIMainActivity.mFinalCount = i - 1;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.aictivity_nuimain);
        int androidVersion = CommonUtil.getAndroidVersion();
        Log.d("zhaogenghuai111 dirFile", "ver:" + androidVersion + "   getSystemVersion():");
        StringBuilder sb = new StringBuilder();
        sb.append("ver:");
        sb.append(androidVersion);
        Log.d("zhaogenghuai111 dirFile", sb.toString());
        SystemValue.isInCn = 0;
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        if (this.preuser.getInt("firstGoGet", 0) == 1) {
            CommonUtil.checkPermissionAll(this);
        }
        SystemValue.isInCn = this.preuser.getInt("isInCn", 0);
        SystemValue.testCount = this.preuser.getInt("testCount", 0);
        SystemValue.testCount++;
        SystemValue.strXZTest = "";
        SystemValue.strUUID = this.preuser.getString("SysSHIXUUID", "");
        if (SystemValue.strUUID == null || SystemValue.strUUID.length() < 10) {
            SystemValue.strUUID = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = this.preuser.edit();
            edit.putString("SysSHIXUUID", SystemValue.strUUID);
            edit.commit();
        }
        initExitPopupWindow_Hight();
        this.fragmentManager = getSupportFragmentManager();
        SystemValue.strCount.clear();
        SystemValue.strCount.add("北京市");
        SystemValue.strCount.add("天津市");
        SystemValue.strCount.add("上海市");
        SystemValue.strCount.add("重庆市");
        SystemValue.strCount.add("河北省");
        SystemValue.strCount.add("山西省");
        SystemValue.strCount.add("辽宁省");
        SystemValue.strCount.add("吉林省");
        SystemValue.strCount.add("黑龙江省");
        SystemValue.strCount.add("浙江省");
        SystemValue.strCount.add("安徽省");
        SystemValue.strCount.add("福建省");
        SystemValue.strCount.add("江西省");
        SystemValue.strCount.add("山东省");
        SystemValue.strCount.add("河南省");
        SystemValue.strCount.add("湖北省");
        SystemValue.strCount.add("湖南省");
        SystemValue.strCount.add("广东省");
        SystemValue.strCount.add("海南省");
        SystemValue.strCount.add("四川省");
        SystemValue.strCount.add("贵州省");
        SystemValue.strCount.add("云南省");
        SystemValue.strCount.add("陕西省");
        SystemValue.strCount.add("甘肃省");
        SystemValue.strCount.add("青海省");
        SystemValue.strCount.add("内蒙");
        SystemValue.strCount.add("西藏");
        SystemValue.strCount.add("新疆");
        SystemValue.strCount.add("宁夏");
        SystemValue.strCount.add("广西");
        GetNetIpSOHU();
        PushUtils.getPhoneType();
        findViewInit();
        setTabSelection(0);
        this.bottom_tab = (LinearLayout) findViewById(R.id.bottom_tab);
        CommonUtil.Log(1, "FCMTOKEN:" + "");
        NativeCaller.PPPPSetCallbackContext(this);
        new Thread(new Runnable() {
            public void run() {
                try {
                    CommonUtil.Log(1, "zhaogenghuai 开始初始化");
                    NativeCaller.PPPPInitial(ContentCommon.SERVER_STRING);
                    NativeCaller.Init();
                    CommonUtil.Log(1, "zhaogenghuai 初始化结束");
                } catch (Exception unused) {
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                NUIMainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        NUIMainActivity.this.findViewById(R.id.splash_img).setVisibility(8);
                    }
                });
            }
        }).start();
        ((TextView) findViewById(R.id.tv12)).setText("V V:1.2201.1115");
        this.isGetSnap = true;
        this.isSnap = true;
        this.snapCount = 0;
        FragmentCameraList.setNewUiMainInterface(this);
        SystemValue.isExitBackGoudExit = true;
        CrashApplication.getInstance().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                NUIMainActivity.access$008(NUIMainActivity.this);
            }

            public void onActivityStopped(Activity activity) {
                NUIMainActivity.access$010(NUIMainActivity.this);
                if (NUIMainActivity.this.mFinalCount == 0) {
                    CommonUtil.Log(1, "进入后台运行");
                    boolean z = SystemValue.isExitBackGoudExit;
                }
            }
        });
        getFCMToken();
        whatPhone();
        if (ContentCommon.ISAUDIOSHOW.booleanValue()) {
            try {
                CommonUtil.playAudioShow(this, R.string.audioshow_add);
            } catch (Exception unused) {
            }
        }
    }

    public void getJSONObject(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        if (httpURLConnection.getResponseCode() == 200) {
            this.jsonStr = new String(readStream(httpURLConnection.getInputStream()));
            CommonUtil.Log(1, "getJSONObject:" + this.jsonStr);
            runOnUiThread(new Runnable() {
                public void run() {
                    int i;
                    int i2;
                    int i3;
                    int i4;
                    int i5;
                    int i6;
                    int i7;
                    int i8;
                    String str;
                    try {
                        JSONObject jSONObject = new JSONObject(NUIMainActivity.this.jsonStr);
                        int i9 = jSONObject.getInt("testver");
                        i6 = jSONObject.getInt("testcount");
                        int i10 = jSONObject.getInt("testsm");
                        int i11 = jSONObject.getInt("testsd");
                        int i12 = jSONObject.getInt("testmm");
                        int i13 = jSONObject.getInt("clear");
                        int i14 = jSONObject.getInt("testmd");
                        i3 = i10;
                        i2 = i11;
                        i = i12;
                        i5 = jSONObject.getInt("onlyap");
                        i4 = i9;
                        i8 = i13;
                        i7 = i14;
                    } catch (Exception unused) {
                        i5 = 1;
                        i8 = 0;
                        i7 = 0;
                        i6 = 0;
                        i4 = 0;
                        i3 = 0;
                        i2 = 0;
                        i = 0;
                    }
                    if (i8 != 1 || SystemValue.testCount <= i6) {
                        str = "onlyap";
                    } else {
                        SharedPreferences.Editor edit = NUIMainActivity.this.preuser.edit();
                        str = "onlyap";
                        edit.putInt("testCount", 0);
                        edit.commit();
                        SystemValue.testCount = 0;
                    }
                    CommonUtil.SaveCommonShare(NUIMainActivity.this, "testver", (String) null, i4);
                    CommonUtil.SaveCommonShare(NUIMainActivity.this, "testcount", (String) null, i6);
                    CommonUtil.SaveCommonShare(NUIMainActivity.this, "testsm", (String) null, i3);
                    CommonUtil.SaveCommonShare(NUIMainActivity.this, "testsd", (String) null, i2);
                    CommonUtil.SaveCommonShare(NUIMainActivity.this, "testmm", (String) null, i);
                    CommonUtil.SaveCommonShare(NUIMainActivity.this, "testmd", (String) null, i7);
                    CommonUtil.SaveCommonShare(NUIMainActivity.this, "clear", (String) null, i8);
                    CommonUtil.SaveCommonShare(NUIMainActivity.this, str, (String) null, i5);
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

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        if (i == 82) {
            return false;
        }
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
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

    /* access modifiers changed from: protected */
    public void onResume() {
        int i = this.preuser.getInt("firstGo", 0);
        int i2 = this.preuser.getInt("firstGoGet", 0);
        if (i != 0 && i2 == 0) {
            SharedPreferences.Editor edit = this.preuser.edit();
            edit.putInt("firstGoGet", 1);
            edit.commit();
            CommonUtil.checkPermissionAll(this);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(this, true);
        }
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);
        systemBarTintManager.setStatusBarTintResource(StyleCommon.Color_All_Backgroud);
        this.isGetSnap = true;
        CommonUtil.Log(1, "ZHAO--Start");
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.isGetSnap = false;
        super.onPause();
    }

    private void findViewInit() {
        this.layoutVidicon = (LinearLayout) findViewById(R.id.main_layout_vidicon);
        this.layoutAlarm = (LinearLayout) findViewById(R.id.main_layout_alarm);
        this.layoutPic = (LinearLayout) findViewById(R.id.main_layout_pic);
        this.layoutVid = (LinearLayout) findViewById(R.id.main_layout_vid);
        this.layoutAbout = (LinearLayout) findViewById(R.id.main_layout_about);
        this.container = (FrameLayout) findViewById(R.id.content);
        this.layoutVidicon.setOnTouchListener(this);
        this.layoutAlarm.setOnTouchListener(this);
        this.layoutPic.setOnTouchListener(this);
        this.layoutVid.setOnTouchListener(this);
        this.layoutAbout.setOnTouchListener(this);
        this.imageView1 = (ImageView) findViewById(R.id.main_img_vidicon);
        this.imageView2 = (ImageView) findViewById(R.id.main_img_alarm);
        this.imageView3 = (ImageView) findViewById(R.id.main_img_picture);
        this.imageView4 = (ImageView) findViewById(R.id.main_img_vid);
        this.textView1 = (TextView) findViewById(R.id.main_tv_vidicon);
        this.textView2 = (TextView) findViewById(R.id.main_tv_alarm);
        this.textView3 = (TextView) findViewById(R.id.main_tv_picture);
        this.textView4 = (TextView) findViewById(R.id.main_tv_vid);
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent();
        intent.setClass(this, NUIMainActivity.class);
        stopService(intent);
        NativeCaller.Free();
        SystemValue.checkSDStatu = 0;
        ((NotificationManager) getSystemService("notification")).cancel(1514);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        if (motionEvent.getAction() == 0) {
            switch (view.getId()) {
                case R.id.main_layout_alarm:
                    this.isGetSnap = false;
                    setTabSelection(1);
                    break;
                case R.id.main_layout_pic:
                    this.isGetSnap = false;
                    setTabSelection(2);
                    break;
                case R.id.main_layout_vid:
                    this.isGetSnap = false;
                    setTabSelection(3);
                    break;
                case R.id.main_layout_vidicon:
                    if (ContentCommon.ISAUDIOSHOW.booleanValue()) {
                        try {
                            CommonUtil.playAudioShow(this, R.string.audioshow_add);
                        } catch (Exception unused) {
                        }
                    }
                    this.isGetSnap = true;
                    setTabSelection(0);
                    break;
            }
        }
        return false;
    }

    private void setTabSelection(int i) {
        clearSelection();
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        hideFragments(beginTransaction);
        if (i == 0) {
            this.imageView1.setImageResource(StyleCommon.IMG_Menu_Camera_Press);
            this.textView1.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            FragmentCameraList fragmentCameraList2 = this.fragmentCameraList;
            if (fragmentCameraList2 == null) {
                this.fragmentCameraList = new FragmentCameraList();
                beginTransaction.add((int) R.id.content, (Fragment) this.fragmentCameraList);
            } else {
                beginTransaction.show(fragmentCameraList2);
            }
        } else if (i == 1) {
            this.imageView2.setImageResource(StyleCommon.IMG_Menu_Alarm_Press);
            this.textView2.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            FragmentAlarm fragmentAlarm2 = this.fragmentAlarm;
            if (fragmentAlarm2 == null) {
                this.fragmentAlarm = new FragmentAlarm();
                beginTransaction.add((int) R.id.content, (Fragment) this.fragmentAlarm);
            } else {
                beginTransaction.show(fragmentAlarm2);
            }
        } else if (i != 2) {
            this.imageView4.setImageResource(StyleCommon.IMG_Menu_Video_Press);
            this.textView4.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            FragmentVideo fragmentVideo2 = this.fragmentVideo;
            if (fragmentVideo2 == null) {
                this.fragmentVideo = new FragmentVideo();
                beginTransaction.add((int) R.id.content, (Fragment) this.fragmentVideo);
            } else {
                beginTransaction.show(fragmentVideo2);
            }
        } else {
            this.imageView3.setImageResource(StyleCommon.IMG_Menu_Pic_Press);
            this.textView3.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            FragmentPicture fragmentPicture2 = this.fragmentPicture;
            if (fragmentPicture2 == null) {
                this.fragmentPicture = new FragmentPicture();
                beginTransaction.add((int) R.id.content, (Fragment) this.fragmentPicture);
            } else {
                beginTransaction.show(fragmentPicture2);
            }
        }
        beginTransaction.commit();
    }

    private void clearSelection() {
        this.imageView1.setImageResource(StyleCommon.IMG_Menu_Camera);
        this.imageView2.setImageResource(StyleCommon.IMG_Menu_Alarm);
        this.imageView3.setImageResource(StyleCommon.IMG_Menu_Pic);
        this.imageView4.setImageResource(StyleCommon.IMG_Menu_Video);
        this.textView1.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
        this.textView2.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
        this.textView3.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
        this.textView4.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
    }

    private void hideFragments(FragmentTransaction fragmentTransaction) {
        FragmentAlarm fragmentAlarm2 = this.fragmentAlarm;
        if (fragmentAlarm2 != null) {
            fragmentTransaction.hide(fragmentAlarm2);
        }
        FragmentCameraList fragmentCameraList2 = this.fragmentCameraList;
        if (fragmentCameraList2 != null) {
            fragmentTransaction.hide(fragmentCameraList2);
        }
        FragmentVideo fragmentVideo2 = this.fragmentVideo;
        if (fragmentVideo2 != null) {
            fragmentTransaction.hide(fragmentVideo2);
        }
        FragmentPicture fragmentPicture2 = this.fragmentPicture;
        if (fragmentPicture2 != null) {
            fragmentTransaction.hide(fragmentPicture2);
        }
    }

    public void GetNetIpSOHU() {
        new Thread() {
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://pv.sohu.com/cityjson?ie=utf-8").openConnection();
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine + "\n");
                        }
                        inputStream.close();
                        String substring = sb.substring(sb.indexOf("{"), sb.indexOf("}") + 1);
                        if (substring != null) {
                            try {
                                String optString = new JSONObject(substring).optString("cname");
                                SystemValue.strChina1 = optString;
                                CommonUtil.Log(1, "CHANA line:" + optString);
                                if (optString != null && optString.length() > 0) {
                                    if (CommonUtil.isContainChinese(optString)) {
                                        SystemValue.isInCn = 1;
                                    } else {
                                        SystemValue.isInCn = 2;
                                    }
                                    CommonUtil.Log(1, "CHANA SystemValue.isInCn:" + SystemValue.isInCn);
                                    SharedPreferences.Editor edit = NUIMainActivity.this.preuser.edit();
                                    edit.putInt("isInCn", SystemValue.isInCn);
                                    edit.commit();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }.start();
    }

    public void CallBackStyle(int i) {
        StyleCommon.COM_STYLE = i;
        if (StyleCommon.COM_STYLE == 1) {
            this.bottom_tab.setVisibility(8);
        } else {
            this.bottom_tab.setVisibility(0);
        }
    }

    public void CallBackTransferMessage(String str, String str2, int i) {
        CommonUtil.Log(1, "ZHAORECEVE SHIXTRANS did:" + str + "  buffer:" + str2);
        String substring = str2.substring(str2.indexOf("{"), str2.indexOf("}") + 1);
        CommonUtil.Log(1, "ZHAORECEVE SHIXTRANS did:" + str + "  strJason:" + substring + "LEN:" + substring.length());
        SHIXCOMMONInterface sHIXCOMMONInterface = shixOMMONInterface;
        if (sHIXCOMMONInterface != null) {
            sHIXCOMMONInterface.CallBackSHIXJasonCommon(str, str2);
        }
        if (str2.indexOf("notification") >= 0 && !SystemValue.isCallIng) {
            SystemValue.devType = retrunType(str);
            SystemValue.devMode = retrunMode(str);
            Intent intent = new Intent(this, DoorbellNotifyActivity.class);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, str);
            intent.putExtra(ContentCommon.STR_CAMERA_USER, retrunUser(str));
            intent.putExtra(ContentCommon.STR_CAMERA_PWD, retrunUserPWD(str));
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, retrunName(str));
            intent.putExtra(ContentCommon.STR_CAMERA_TYPE, 0);
            intent.setFlags(268435456);
            startActivity(intent);
        }
    }

    public void CallBack_TYPEMODE(String str, String str2) {
        ConnectStatusInterface1 connectStatusInterface1 = connectStatusInterface;
        if (connectStatusInterface1 != null) {
            connectStatusInterface1.BSCallBack_TYPEMODE(str, str2);
        }
        ConnectChannelStatusInterface1 connectChannelStatusInterface12 = connectChannelStatusInterface1;
        if (connectChannelStatusInterface12 != null) {
            connectChannelStatusInterface12.BSCallBack_TYPEMODE(str, str2);
        } else {
            CommonUtil.Log(1, " connectChannelStatusInterface1 ================= null");
        }
    }

    private void VideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        byte[] bArr2 = bArr;
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SHIXCONNET VideoData...h264Data: ");
        int i7 = i;
        sb.append(i);
        sb.append(" len: ");
        sb.append(i2);
        sb.append(" videobuf len: ");
        sb.append(bArr2.length);
        sb.append("  time==");
        sb.append(i5);
        Log.d(str2, sb.toString());
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBaceVideoData(str, bArr, i, i2, i3, i4);
        }
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBaceVideoData(str, bArr, i, bArr2.length, i3, i4, i6);
        }
        IPPlayInterface iPPlayInterface = ipPlayInterface;
        if (iPPlayInterface != null) {
            iPPlayInterface.callBaceVideoData(str, bArr, i, i2, i3, i4);
        }
    }

    public static void setSnapShotInterface(SnapShotInterface snapShotInterface2) {
        snapShotInterface = snapShotInterface2;
    }

    public void MessageNotify(String str, int i, int i2) {
        Log.d("test_four_2", "SHIXCONNET MessageNotify did: " + str + " msgType: " + i + " param: " + i2);
    }

    public void AudioData(byte[] bArr, int i) {
        String str = this.TAG;
        Log.d(str, "SHIXCONNET AudioData: len :+ " + i);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBackAudioData(bArr, i);
        }
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackAudioData(bArr, i);
        }
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackPlaybackAudioData(bArr, i);
        }
    }

    public void AudioPCMDataPlayBack(byte[] bArr, int i, int i2) {
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.AudioPCMDataPlayBack(bArr, i, i2);
        }
    }

    public void PPPPMsgNotify(String str, int i, int i2) {
        String str2 = this.TAG;
        Log.d(str2, "SHIXCONNET PPPPMsgNotify  did:" + str + " type:" + i + " param:" + i2);
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackMessageNotify(str, i, i2);
        }
        IPPlayInterface iPPlayInterface = ipPlayInterface;
        if (iPPlayInterface != null) {
            iPPlayInterface.callBackMessageNotify(str, i, i2);
        }
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSMsgNotifyData(str, i, i2);
        }
        ConnectStatusInterface1 connectStatusInterface1 = connectStatusInterface;
        if (connectStatusInterface1 != null) {
            connectStatusInterface1.BSMsgNotifyData(str, i, i2);
        }
        ConnectChannelStatusInterface1 connectChannelStatusInterface12 = connectChannelStatusInterface1;
        if (connectChannelStatusInterface12 != null) {
            connectChannelStatusInterface12.BSMsgNotifyData(str, i, i2);
        }
    }

    public void SearchResult(int i, String str, String str2, String str3, String str4, int i2) {
        AddCameraInterface1 addCameraInterface1;
        String str5 = this.TAG;
        Log.d(str5, "SHIXCONNET SearchResult1: " + str4 + " " + i2);
        if (str3.length() != 0 && (addCameraInterface1 = addCameraInterface) != null) {
            addCameraInterface1.callBackSearchResultData(i, str, str2, str3, str4, i2);
        }
    }

    public void CallBack_MJTCPTrans(String str, String str2) {
        CommonUtil.Log(1, "CallBack_MJTCPTrans:" + str + "  strMsg:" + str2);
    }

    private void PPPPSnapshotNotify(String str, byte[] bArr, int i) {
        String str2 = this.TAG;
        Log.d(str2, "SHIXCONNET did:" + str + " len:" + i);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSSnapshotNotify(str, bArr, i);
        }
    }

    public void CallBack_Snapshot(String str, byte[] bArr, int i) {
        Log.d("ddd", "SHIXCONNET CallBack_Snapshot");
        SnapShotInterface snapShotInterface2 = snapShotInterface;
        if (snapShotInterface2 != null) {
            snapShotInterface2.BSSnapshotNotify(str, bArr, i);
        }
    }

    public void CallBack_AlarmNotifyDoorBell(String str, String str2, String str3, String str4) {
        Log.e(ContentCommon.SERVER_STRING, "doorbell:db_did:" + str3 + "  db_type:" + str4 + "  db_time:" + str2);
    }

    public void CallBack_AlarmNotify(String str, int i) {
        Log.d("tag", "callBack_AlarmNotify did:" + str + " alarmtype:" + i);
    }

    public void CallBack_AlarmNotify(String str, String str2) {
        Log.d("tag", "callBack_AlarmNotify did:" + str + " alarmtype:" + str2);
        if (shixAlarmInterface != null && str2.indexOf("check_ota") >= 0) {
            shixAlarmInterface.CallBackSHIXJasonAlarm(str, str2);
        }
    }

    public void CallBack_PlaybackVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        StringBuilder sb = new StringBuilder();
        sb.append("CallBack_PlaybackVideoData  len:");
        int i9 = i2;
        sb.append(i2);
        sb.append(" width:");
        sb.append(i3);
        sb.append(" height:");
        sb.append(i4);
        sb.append("  time:");
        sb.append(i5);
        Log.e("zhaogenghuai", sb.toString());
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackPlaybackVideoData(bArr, i, i2, i3, i4, i5, i7, i8);
        }
    }

    public void CallBack_Checkhandle(String str, String str2, String str3, String str4, int i) {
        P2PMpdeInterface p2PMpdeInterface = p2pMpdeInterface;
        if (p2PMpdeInterface != null) {
            p2PMpdeInterface.CallBack_Checkhandle(str, str2, str3, str4, i);
        }
    }

    public void CallBack_H264Data(String str, byte[] bArr, int i, int i2, int i3) {
        Log.e("tag", "did=" + str + "  h264=" + bArr.length);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBackH264Data(str, bArr, i, i2);
        }
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackH264Data(str, bArr, i, i2);
        }
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackH264Data(str, bArr, i, i2);
        }
    }

    public static void setP2PMpdeInterface(P2PMpdeInterface p2PMpdeInterface) {
        p2pMpdeInterface = p2PMpdeInterface;
    }

    public static void setIpcamClientInterface(IpcamClientInterface ipcamClientInterface2) {
        ipcamClientInterface = ipcamClientInterface2;
    }

    public static void setAddCameraInterface1(AddCameraInterface1 addCameraInterface1) {
        addCameraInterface = addCameraInterface1;
    }

    public static void setSHIXCOMMONInterface(SHIXCOMMONInterface sHIXCOMMONInterface) {
        shixOMMONInterface = sHIXCOMMONInterface;
    }

    public static void setSHIXAlarmInterface(SHIXAlarmInterface sHIXAlarmInterface) {
        shixAlarmInterface = sHIXAlarmInterface;
    }

    public static void setConnectStatusInterface1(ConnectStatusInterface1 connectStatusInterface1) {
        connectStatusInterface = connectStatusInterface1;
    }

    public static void setConnectChannelStatusInterface1(ConnectChannelStatusInterface1 connectChannelStatusInterface12) {
        connectChannelStatusInterface1 = connectChannelStatusInterface12;
    }

    public static void setPlayInterface(PlayInterface playInterface2) {
        playInterface = playInterface2;
    }

    public static void setIpPlayInterface(IPPlayInterface iPPlayInterface) {
        ipPlayInterface = iPPlayInterface;
    }

    public void CallBack_VideoTrans_H264H265(String str, byte[] bArr, int i, int i2, int i3) {
        CommonUtil.Log(1, "H264H265 did:" + str + "  type:" + i + "  h45:" + i2 + "  framno:" + i3);
        VideoTransInterface videoTransInterface2 = videoTransInterface;
        if (videoTransInterface2 != null) {
            videoTransInterface2.VideoTrans_H264H265(str, bArr, i, i2, i3);
        }
    }

    public static void setPlayBackInterface(PlayBackInterface playBackInterface2) {
        playBackInterface = playBackInterface2;
    }

    public static void setVideoTransInterface(VideoTransInterface videoTransInterface2) {
        videoTransInterface = videoTransInterface2;
    }

    private String retrunName(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDev_Did().replace("-", "").toUpperCase())) {
                i++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i).getDev_name());
                return SystemValue.arrayList.get(i).getDev_name();
            }
        }
        return null;
    }

    private int retrunType(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDev_Did().replace("-", "").toUpperCase())) {
                i++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i).getDevType());
                return SystemValue.arrayList.get(i).getDevType();
            }
        }
        return 2020;
    }

    private int retrunMode(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDev_Did().replace("-", "").toUpperCase())) {
                i++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i).getDevMode());
                return SystemValue.arrayList.get(i).getDevMode();
            }
        }
        return 2020;
    }

    private String retrunUser(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDev_Did().replace("-", "").toUpperCase())) {
                i++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i).getDev_User());
                return SystemValue.arrayList.get(i).getDev_User();
            }
        }
        return null;
    }

    private String retrunUserPWD(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDev_Did().replace("-", "").toUpperCase())) {
                i++;
            } else {
                Log.d("tag", "testuserpwd:" + SystemValue.arrayList.get(i).getDev_Pwd());
                return SystemValue.arrayList.get(i).getDev_Pwd();
            }
        }
        return null;
    }

    private void sendRegTokenToServer(String str) {
        String str2 = this.TAG;
        Log.i(str2, "sending token to server. token:" + str);
    }

    public void initExitPopupWindow_Hight() {
        this.popv_show = LayoutInflater.from(this).inflate(R.layout.popup_showadd, (ViewGroup) null);
        this.popupWindow_show = new PopupWindow(this.popv_show, -1, -1);
        this.popupWindow_show.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_show.setFocusable(true);
        this.popupWindow_show.setInputMethodMode(1);
        this.popupWindow_show.setSoftInputMode(16);
        this.popupWindow_show.setOutsideTouchable(true);
        this.popupWindow_show.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_show.setFocusableInTouchMode(true);
        this.popv_show.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 82) {
                    return false;
                }
                NUIMainActivity.this.popupWindow_show.dismiss();
                return false;
            }
        });
        this.popv_show.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                NUIMainActivity.this.popupWindow_show.dismiss();
                return false;
            }
        });
        this.popupWindow_show.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                NUIMainActivity.this.popupWindow_show.dismiss();
            }
        });
        this.popupWindow_show.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                NUIMainActivity.this.popupWindow_show.dismiss();
                return false;
            }
        });
    }
}
