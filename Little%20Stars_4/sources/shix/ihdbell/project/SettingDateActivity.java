package shix.ihdbell.project;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.mapapi.MKEvent;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.TimeZone;
import object.p2pipcam.bean.DateBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class SettingDateActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, BridgeService.DateTimeInterface {
    private final int FAIL = 0;
    private final int PARAMS = 3;
    private final int SUCCESS = 1;
    private String TAG = "SettingDateActivity";
    private final int TIMEOUT = 3000;
    private Button btnCancel = null;
    private Button btnCheckOut = null;
    private Button btnOk = null;
    private String cameraName;
    /* access modifiers changed from: private */
    public CheckBox cbxCheck = null;
    /* access modifiers changed from: private */
    public DateBean dateBean = null;
    /* access modifiers changed from: private */
    public EditText editNtpServer = null;
    /* access modifiers changed from: private */
    public EditText editTimeZone = null;
    private ImageButton imgNtpServerDown = null;
    private ImageButton imgTimeZoneDown = null;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SettingDateActivity.this.showToast((int) R.string.date_setting_failed);
            } else if (i == 1) {
                SettingDateActivity.this.showToast((int) R.string.date_setting_success);
                SettingDateActivity.this.finish();
            } else if (i == 3) {
                boolean unused = SettingDateActivity.this.successFlag = true;
                if (SettingDateActivity.this.progressDialog.isShowing()) {
                    SettingDateActivity.this.progressDialog.cancel();
                    if (SettingDateActivity.this.dateBean.getNtp_enable() == 1) {
                        SettingDateActivity.this.cbxCheck.setChecked(true);
                        SettingDateActivity.this.ntpView.setVisibility(0);
                    } else {
                        SettingDateActivity.this.cbxCheck.setChecked(false);
                        SettingDateActivity.this.ntpView.setVisibility(8);
                    }
                    SettingDateActivity.this.editNtpServer.setText(SettingDateActivity.this.dateBean.getNtp_ser());
                    Button access$600 = SettingDateActivity.this.tvDeviceTime;
                    access$600.setText("longtime:" + SettingDateActivity.this.dateBean.getNow());
                    setTimeZone();
                }
            }
        }

        private void setTimeZone() {
            int now = SettingDateActivity.this.dateBean.getNow();
            Log.d("tag", "now:" + SettingDateActivity.this.dateBean.getNow());
            Long l = new Long((long) now);
            switch (SettingDateActivity.this.dateBean.getTz()) {
                case -43200:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+12:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_auckland);
                    return;
                case -39600:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+11:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_suolumen);
                    return;
                case -36000:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+10:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_guam);
                    return;
                case -34200:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+09:30"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_darwin);
                    return;
                case -32400:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+09:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_seoul);
                    return;
                case -28800:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+08:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_beijing);
                    return;
                case -25200:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+07:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_bangkok);
                    return;
                case -21600:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+06:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_alamotu);
                    return;
                case -19800:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+05:30"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_calcutta);
                    return;
                case -18000:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+05:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_islamabad);
                    return;
                case -16200:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+04:30"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_kebuer);
                    return;
                case -14400:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+04:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_baku);
                    return;
                case -12600:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+03:30"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_teheran);
                    return;
                case -10800:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+03:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_nairobi);
                    return;
                case -7200:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+02:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_athens);
                    return;
                case -3600:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT+01:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_brussels);
                    return;
                case 0:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_greenwich);
                    return;
                case 3600:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-01:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_cape_verde_island);
                    return;
                case 7200:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-02:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_center_ocean);
                    return;
                case 10800:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-03:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_brasilia);
                    return;
                case 12600:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-03:30"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_newfoundland);
                    return;
                case 14400:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-04:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_ocean_time);
                    return;
                case 18000:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-05:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_eastern_time);
                    return;
                case 21600:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-06:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_middle_part_time);
                    return;
                case 25200:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-07:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_mountain_time);
                    return;
                case 28800:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-08:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_pacific_time);
                    return;
                case 32400:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-09:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_alaska);
                    return;
                case 36000:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-10:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_hawaii);
                    return;
                case 39600:
                    SettingDateActivity.this.tvDeviceTime.setText(SettingDateActivity.this.setDeviceTime(l.longValue() * 1000, "GMT-11:00"));
                    SettingDateActivity.this.editTimeZone.setText(R.string.date_middle_island);
                    return;
                default:
                    return;
            }
        }
    };
    private PopupWindow ntpServerPopWindow = null;
    /* access modifiers changed from: private */
    public View ntpView = null;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    private Runnable runnable = new Runnable() {
        public void run() {
            if (!SettingDateActivity.this.successFlag) {
                SettingDateActivity.this.progressDialog.dismiss();
            }
        }
    };
    private ScrollView scrollView = null;
    private String strDID;
    /* access modifiers changed from: private */
    public boolean successFlag;
    private PopupWindow timeZonePopWindow = null;
    private TextView tvCameraName = null;
    /* access modifiers changed from: private */
    public Button tvDeviceTime = null;

    /* access modifiers changed from: private */
    public String setDeviceTime(long j, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(str));
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(2) + 1;
        int i3 = instance.get(5);
        int i4 = instance.get(7);
        int i5 = instance.get(11);
        int i6 = instance.get(12);
        int i7 = instance.get(13);
        String str6 = "";
        switch (i4) {
            case 1:
                str2 = "Sun";
                break;
            case 2:
                str2 = "Mon";
                break;
            case 3:
                str2 = "Tues";
                break;
            case 4:
                str2 = "Wed";
                break;
            case 5:
                str2 = "Thur";
                break;
            case 6:
                str2 = "Fri";
                break;
            case 7:
                str2 = "Sat";
                break;
            default:
                str2 = str6;
                break;
        }
        switch (i2) {
            case 1:
                str6 = "Jan";
                break;
            case 2:
                str6 = "Feb";
                break;
            case 3:
                str6 = "Mar";
                break;
            case 4:
                str6 = "Apr";
                break;
            case 5:
                str6 = "May";
                break;
            case 6:
                str6 = "Jun";
                break;
            case 7:
                str6 = "Jul";
                break;
            case 8:
                str6 = "Aug";
                break;
            case 9:
                str6 = "Sept";
                break;
            case 10:
                str6 = "Oct";
                break;
            case 11:
                str6 = "Nov";
                break;
            case 12:
                str6 = "Dec";
                break;
        }
        if (i5 < 10) {
            str3 = PushConstants.PUSH_TYPE_NOTIFY + i5;
        } else {
            str3 = String.valueOf(i5);
        }
        if (i6 < 10) {
            str4 = PushConstants.PUSH_TYPE_NOTIFY + i6;
        } else {
            str4 = String.valueOf(i6);
        }
        if (i7 < 10) {
            str5 = PushConstants.PUSH_TYPE_NOTIFY + i7;
        } else {
            str5 = String.valueOf(i7);
        }
        return str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i3 + " " + str6 + i + " " + str3 + ":" + str4 + ":" + str5 + "    UTC";
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

    /* access modifiers changed from: protected */
    public void onPause() {
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.settingdate);
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.date_get_params));
        this.progressDialog.show();
        this.mHandler.postDelayed(this.runnable, 3000);
        findView();
        setListener();
        this.dateBean = new DateBean();
        BridgeService.setDateTimeInterface(this);
        NativeCaller.PPPPGetSystemParams(this.strDID, 4);
        SetTab(this);
    }

    private void setListener() {
        this.imgTimeZoneDown.setOnClickListener(this);
        this.imgNtpServerDown.setOnClickListener(this);
        this.scrollView.setOnTouchListener(this);
        this.editTimeZone.setOnClickListener(this);
        this.editNtpServer.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
        this.cbxCheck.setOnCheckedChangeListener(this);
        this.btnCheckOut.setOnClickListener(this);
        this.progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
    }

    private void findView() {
        this.btnOk = (Button) findViewById(R.id.date_ok);
        this.btnCancel = (Button) findViewById(R.id.date_cancel);
        this.btnCheckOut = (Button) findViewById(R.id.date_btn_checkout);
        this.tvDeviceTime = (Button) findViewById(R.id.date_tv_device_time);
        this.editTimeZone = (EditText) findViewById(R.id.date_edit_timezone);
        this.editNtpServer = (EditText) findViewById(R.id.date_edit_ntp_server);
        this.cbxCheck = (CheckBox) findViewById(R.id.date_cbx_check);
        this.imgTimeZoneDown = (ImageButton) findViewById(R.id.date_img_timezone_down);
        this.imgNtpServerDown = (ImageButton) findViewById(R.id.date_img_ntp_server_down);
        this.ntpView = findViewById(R.id.date_ntp_view);
        this.scrollView = (ScrollView) findViewById(R.id.scrollView1);
        this.tvCameraName = (TextView) findViewById(R.id.tv_camera_setting);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.top);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.top_bg));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        bitmapDrawable.setDither(true);
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        switch (view.getId()) {
            case R.id.date_btn_checkout:
                checkDeviceAsPhoneTime();
                return;
            case R.id.date_cancel:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.date_edit_ntp_server:
            case R.id.date_img_ntp_server_down:
                PopupWindow popupWindow = this.timeZonePopWindow;
                if (popupWindow != null && popupWindow.isShowing()) {
                    this.timeZonePopWindow.dismiss();
                    this.timeZonePopWindow = null;
                }
                showNtpServerPopWindow();
                return;
            case R.id.date_edit_timezone:
            case R.id.date_img_timezone_down:
                PopupWindow popupWindow2 = this.ntpServerPopWindow;
                if (popupWindow2 != null && popupWindow2.isShowing()) {
                    this.ntpServerPopWindow.dismiss();
                    this.ntpServerPopWindow = null;
                }
                showTimeZonePopWindow();
                return;
            case R.id.date_ntpserver_kriss:
                this.ntpServerPopWindow.dismiss();
                this.dateBean.setNtp_ser(getResources().getString(R.string.date_ntp_server_time_kriss_re_kr));
                this.editNtpServer.setText(R.string.date_ntp_server_time_kriss_re_kr);
                return;
            case R.id.date_ntpserver_nist:
                this.ntpServerPopWindow.dismiss();
                this.dateBean.setNtp_ser(getResources().getString(R.string.date_ntp_server_time_nist_gov));
                this.editNtpServer.setText(R.string.date_ntp_server_time_nist_gov);
                return;
            case R.id.date_ntpserver_nuri:
                this.ntpServerPopWindow.dismiss();
                this.dateBean.setNtp_ser(getResources().getString(R.string.date_ntp_server_time_nuri_net));
                this.editNtpServer.setText(R.string.date_ntp_server_time_nuri_net);
                return;
            case R.id.date_ntpserver_windows:
                this.ntpServerPopWindow.dismiss();
                this.dateBean.setNtp_ser(getResources().getString(R.string.date_ntp_server_time_windows_com));
                this.editNtpServer.setText(R.string.date_ntp_server_time_windows_com);
                return;
            case R.id.date_ok:
                setDate();
                return;
            case R.id.date_zone_alamotu:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-21600);
                this.editTimeZone.setText(R.string.date_alamotu);
                return;
            case R.id.date_zone_alaska:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(32400);
                this.editTimeZone.setText(R.string.date_alaska);
                return;
            case R.id.date_zone_athens:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-7200);
                this.editTimeZone.setText(R.string.date_athens);
                return;
            case R.id.date_zone_auckland:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-43200);
                this.editTimeZone.setText(R.string.date_auckland);
                return;
            case R.id.date_zone_baku:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-14400);
                this.editTimeZone.setText(R.string.date_baku);
                return;
            case R.id.date_zone_bangkok:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-25200);
                this.editTimeZone.setText(R.string.date_bangkok);
                return;
            case R.id.date_zone_beijing:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-28800);
                this.editTimeZone.setText(R.string.date_beijing);
                return;
            case R.id.date_zone_brasilia:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(10800);
                this.editTimeZone.setText(R.string.date_brasilia);
                return;
            case R.id.date_zone_brussels:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-3600);
                this.editTimeZone.setText(R.string.date_brussels);
                return;
            case R.id.date_zone_calcutta:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-19800);
                this.editTimeZone.setText(R.string.date_calcutta);
                return;
            case R.id.date_zone_cap_verde_island:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(3600);
                this.editTimeZone.setText(R.string.date_cape_verde_island);
                return;
            case R.id.date_zone_center_ocean:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(7200);
                this.editTimeZone.setText(R.string.date_center_ocean);
                return;
            case R.id.date_zone_darwin:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-34200);
                this.editTimeZone.setText(R.string.date_darwin);
                return;
            case R.id.date_zone_eastern_time:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(18000);
                this.editTimeZone.setText(R.string.date_eastern_time);
                return;
            case R.id.date_zone_greenwich:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(0);
                this.editTimeZone.setText(R.string.date_greenwich);
                return;
            case R.id.date_zone_guam:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-36000);
                this.editTimeZone.setText(R.string.date_guam);
                return;
            case R.id.date_zone_hawaii:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(36000);
                this.editTimeZone.setText(R.string.date_hawaii);
                return;
            case R.id.date_zone_islamabad:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-18000);
                this.editTimeZone.setText(R.string.date_islamabad);
                return;
            case R.id.date_zone_kebuer:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-16200);
                this.editTimeZone.setText(R.string.date_kebuer);
                return;
            case R.id.date_zone_middle_island:
                Log.d("tag", "��;�� 1");
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(39600);
                this.editTimeZone.setText(R.string.date_middle_island);
                Log.d("tag", "��;�� 2");
                return;
            case R.id.date_zone_middle_part_time:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(21600);
                this.editTimeZone.setText(R.string.date_middle_part_time);
                return;
            case R.id.date_zone_mountain_time:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(25200);
                this.editTimeZone.setText(R.string.date_mountain_time);
                return;
            case R.id.date_zone_nairobi:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-10800);
                this.editTimeZone.setText(R.string.date_nairobi);
                return;
            case R.id.date_zone_newfoundland:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(12600);
                this.editTimeZone.setText(R.string.date_newfoundland);
                return;
            case R.id.date_zone_ocean_time:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(14400);
                this.editTimeZone.setText(R.string.date_ocean_time);
                return;
            case R.id.date_zone_pacific_time:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(28800);
                this.editTimeZone.setText(R.string.date_pacific_time);
                return;
            case R.id.date_zone_seoul:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-32400);
                this.editTimeZone.setText(R.string.date_seoul);
                return;
            case R.id.date_zone_soulumen:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-39600);
                this.editTimeZone.setText(R.string.date_suolumen);
                return;
            case R.id.date_zone_teheran:
                this.timeZonePopWindow.dismiss();
                this.dateBean.setTz(-12600);
                this.editTimeZone.setText(R.string.date_teheran);
                return;
            default:
                return;
        }
    }

    private void setDate() {
        Log.d("tag", "now:0  tz:" + this.dateBean.getTz() + " enable:" + this.dateBean.getNtp_enable() + " server:" + this.dateBean.getNtp_ser());
        NativeCaller.PPPPDatetimeSetting(this.strDID, 0, this.dateBean.getTz(), this.dateBean.getNtp_enable(), this.dateBean.getNtp_ser());
        finish();
    }

    private void checkDeviceAsPhoneTime() {
        int i = (-TimeZone.getDefault().getRawOffset()) / PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE;
        int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
        Log.d("tag", "tz:" + i);
        Log.d("tag", "tz:" + timeInMillis + "");
        NativeCaller.PPPPDatetimeSetting(this.strDID, timeInMillis, i, this.dateBean.getNtp_enable(), this.dateBean.getNtp_ser());
        finish();
    }

    private void showNtpServerPopWindow() {
        PopupWindow popupWindow = this.ntpServerPopWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.settingdate_ntpserver_popwindow, (ViewGroup) null);
            ((Button) linearLayout.findViewById(R.id.date_ntpserver_kriss)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_ntpserver_nist)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_ntpserver_nuri)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_ntpserver_windows)).setOnClickListener(this);
            this.ntpServerPopWindow = new PopupWindow(linearLayout, MKEvent.ERROR_LOCATION_FAILED, -2);
            this.ntpServerPopWindow.showAsDropDown(this.imgNtpServerDown, -200, 0);
        }
    }

    private void showTimeZonePopWindow() {
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.settingdate_timezone_popwindow, (ViewGroup) null);
            Button button = (Button) linearLayout.findViewById(R.id.date_zone_brussels);
            Button button2 = (Button) linearLayout.findViewById(R.id.date_zone_athens);
            Button button3 = (Button) linearLayout.findViewById(R.id.date_zone_nairobi);
            Button button4 = (Button) linearLayout.findViewById(R.id.date_zone_teheran);
            Button button5 = (Button) linearLayout.findViewById(R.id.date_zone_baku);
            Button button6 = (Button) linearLayout.findViewById(R.id.date_zone_kebuer);
            Button button7 = (Button) linearLayout.findViewById(R.id.date_zone_islamabad);
            Button button8 = (Button) linearLayout.findViewById(R.id.date_zone_calcutta);
            Button button9 = (Button) linearLayout.findViewById(R.id.date_zone_alamotu);
            Button button10 = (Button) linearLayout.findViewById(R.id.date_zone_bangkok);
            Button button11 = (Button) linearLayout.findViewById(R.id.date_zone_beijing);
            Button button12 = (Button) linearLayout.findViewById(R.id.date_zone_seoul);
            Button button13 = (Button) linearLayout.findViewById(R.id.date_zone_darwin);
            Button button14 = (Button) linearLayout.findViewById(R.id.date_zone_guam);
            Button button15 = (Button) linearLayout.findViewById(R.id.date_zone_soulumen);
            ((Button) linearLayout.findViewById(R.id.date_zone_middle_island)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_hawaii)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_alaska)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_pacific_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_mountain_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_middle_part_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_eastern_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_ocean_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_newfoundland)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_brasilia)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_center_ocean)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_cap_verde_island)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_greenwich)).setOnClickListener(this);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);
            button4.setOnClickListener(this);
            button5.setOnClickListener(this);
            button6.setOnClickListener(this);
            button7.setOnClickListener(this);
            button8.setOnClickListener(this);
            button9.setOnClickListener(this);
            button10.setOnClickListener(this);
            button11.setOnClickListener(this);
            button12.setOnClickListener(this);
            button13.setOnClickListener(this);
            button14.setOnClickListener(this);
            button15.setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_auckland)).setOnClickListener(this);
            this.timeZonePopWindow = new PopupWindow(linearLayout, MKEvent.ERROR_PERMISSION_DENIED, 500);
            this.timeZonePopWindow.showAsDropDown(this.imgTimeZoneDown, -310, 0);
        }
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.timeZonePopWindow.dismiss();
            this.timeZonePopWindow = null;
        }
        PopupWindow popupWindow2 = this.ntpServerPopWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.ntpServerPopWindow.dismiss();
            this.ntpServerPopWindow = null;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.timeZonePopWindow.dismiss();
            this.timeZonePopWindow = null;
        }
        PopupWindow popupWindow2 = this.ntpServerPopWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.ntpServerPopWindow.dismiss();
            this.ntpServerPopWindow = null;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.timeZonePopWindow.dismiss();
            this.timeZonePopWindow = null;
        }
        PopupWindow popupWindow2 = this.ntpServerPopWindow;
        if (popupWindow2 == null || !popupWindow2.isShowing()) {
            return false;
        }
        this.ntpServerPopWindow.dismiss();
        this.ntpServerPopWindow = null;
        return false;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.dateBean.setNtp_enable(1);
            this.ntpView.setVisibility(0);
            return;
        }
        this.dateBean.setNtp_enable(0);
        this.ntpView.setVisibility(8);
    }

    public void callBackDatetimeParams(String str, int i, int i2, int i3, String str2) {
        Log.d(this.TAG, "CallBack_DatetimeParams");
        this.dateBean.setNow(i);
        this.dateBean.setTz(i2);
        this.dateBean.setNtp_enable(i3);
        this.dateBean.setNtp_ser(str2);
        this.mHandler.sendEmptyMessage(3);
    }

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
        String str2 = this.TAG;
        Log.d(str2, "result:" + i2 + " paramType:" + i);
    }
}
