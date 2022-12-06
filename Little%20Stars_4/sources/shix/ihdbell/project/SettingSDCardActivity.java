package shix.ihdbell.project;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import object.p2pipcam.bean.SdcardBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import shix.ihdbell.project.BridgeService;

public class SettingSDCardActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BridgeService.SDCardInterface {
    private final int FAILED = 0;
    private final int PARAMS = 2;
    private final int SUCCESS = 1;
    private final int TIMEOUT = 3000;
    private Button btnBack = null;
    private Button btnOk = null;
    /* access modifiers changed from: private */
    public CheckBox cbxConverage = null;
    /* access modifiers changed from: private */
    public CheckBox cbxRecordTime = null;
    /* access modifiers changed from: private */
    public CheckBox cbxVoid = null;
    /* access modifiers changed from: private */
    public EditText editRecordLength = null;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SettingSDCardActivity.this.showToast((int) R.string.sdcard_set_failed);
            } else if (i == 1) {
                SettingSDCardActivity.this.showToast((int) R.string.sdcard_set_success);
                SettingSDCardActivity.this.finish();
                SettingSDCardActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            } else if (i == 2) {
                if (SettingSDCardActivity.this.ifShow == 1) {
                    SettingSDCardActivity.this.linearLayout_start.setVisibility(8);
                    SettingSDCardActivity.this.linearLayout_end.setVisibility(8);
                } else {
                    SettingSDCardActivity.this.linearLayout_start.setVisibility(8);
                    SettingSDCardActivity.this.linearLayout_end.setVisibility(8);
                }
                boolean unused = SettingSDCardActivity.this.successFlag = true;
                SettingSDCardActivity.this.progressDialog.dismiss();
                TextView access$600 = SettingSDCardActivity.this.tvSdTotal;
                access$600.setText(SettingSDCardActivity.this.sdcardBean.getSdtotal() + "M");
                TextView access$700 = SettingSDCardActivity.this.tvSdRemain;
                access$700.setText(SettingSDCardActivity.this.sdcardBean.getSdfree() + "M");
                if (SettingSDCardActivity.this.sdcardBean.getRecord_sd_status() == 1) {
                    SettingSDCardActivity.this.tvSdStatus.setText(SettingSDCardActivity.this.getResources().getString(R.string.sdcard_inserted));
                } else {
                    SettingSDCardActivity.this.tvSdStatus.setText(SettingSDCardActivity.this.getResources().getString(R.string.sdcard_no_inserted));
                }
                if (SettingSDCardActivity.this.sdcardBean.getRecord_conver_enable() == 1) {
                    SettingSDCardActivity.this.cbxConverage.setChecked(true);
                } else {
                    SettingSDCardActivity.this.cbxConverage.setChecked(false);
                }
                if (SettingSDCardActivity.this.sdcardBean.getRecord_void_enable() == 1) {
                    SettingSDCardActivity.this.cbxVoid.setChecked(true);
                } else {
                    SettingSDCardActivity.this.cbxVoid.setChecked(false);
                }
                if (SettingSDCardActivity.this.sdcardBean.getRecord_time_enable() == 1) {
                    SettingSDCardActivity.this.cbxRecordTime.setChecked(true);
                } else {
                    SettingSDCardActivity.this.cbxRecordTime.setChecked(false);
                }
                if (SettingSDCardActivity.this.sdcardBean.getRecord_timer() < 5) {
                    SettingSDCardActivity.this.editRecordLength.setText("5");
                    return;
                }
                EditText access$1200 = SettingSDCardActivity.this.editRecordLength;
                access$1200.setText(SettingSDCardActivity.this.sdcardBean.getRecord_timer() + "");
            }
        }
    };
    /* access modifiers changed from: private */
    public int ifShow = 0;
    /* access modifiers changed from: private */
    public RelativeLayout linearLayout_end;
    /* access modifiers changed from: private */
    public LinearLayout linearLayout_start;
    private List<String> list;
    private List<String> list1 = null;
    /* access modifiers changed from: private */
    public int m_end_time = 23;
    /* access modifiers changed from: private */
    public int m_start_time = 0;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog = null;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog1 = null;
    private Runnable runnable = new Runnable() {
        public void run() {
            if (!SettingSDCardActivity.this.successFlag) {
                boolean unused = SettingSDCardActivity.this.successFlag = false;
                SettingSDCardActivity.this.progressDialog.dismiss();
            }
        }
    };
    /* access modifiers changed from: private */
    public SdcardBean sdcardBean;
    private Button set_sd_format;
    private Spinner spinner_end;
    private Spinner spinner_start;
    /* access modifiers changed from: private */
    public String strDID = null;
    /* access modifiers changed from: private */
    public boolean successFlag = false;
    private int time15;
    private int time23;
    private int time7;
    /* access modifiers changed from: private */
    public TextView tvSdRemain = null;
    /* access modifiers changed from: private */
    public TextView tvSdStatus = null;
    /* access modifiers changed from: private */
    public TextView tvSdTotal = null;

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
        super.onPause();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.settingsdcard);
        this.list = new ArrayList();
        this.list1 = new ArrayList();
        listAdd();
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.sdcard_getparams));
        this.progressDialog.show();
        this.sdcardBean = new SdcardBean();
        this.handler.postDelayed(this.runnable, 3000);
        findView();
        setLister();
        BridgeService.setSDCardInterface(this);
        NativeCaller.PPPPGetSystemParams(this.strDID, 22);
        SetTab(this);
        if (SystemValue.isLitos) {
            findViewById(R.id.rL2).setVisibility(8);
            findViewById(R.id.rL1).setVisibility(8);
            findViewById(R.id.linearLayout_start).setVisibility(8);
        }
    }

    private void listAdd() {
        this.list.add("00:00");
        this.list.add("01:00");
        this.list.add("02:00");
        this.list.add("03:00");
        this.list.add("04:00");
        this.list.add("05:00");
        this.list.add("06:00");
        this.list.add("07:00");
        this.list.add("08:00");
        this.list.add("09:00");
        this.list.add("10:00");
        this.list.add("11:00");
        this.list.add("12:00");
        this.list.add("13:00");
        this.list.add("14:00");
        this.list.add("15:00");
        this.list.add("16:00");
        this.list.add("17:00");
        this.list.add("18:00");
        this.list.add("19:00");
        this.list.add("20:00");
        this.list.add("21:00");
        this.list.add("22:00");
        this.list.add("23:00");
        this.list1.add("01:00");
        this.list1.add("02:00");
        this.list1.add("03:00");
        this.list1.add("04:00");
        this.list1.add("05:00");
        this.list1.add("06:00");
        this.list1.add("07:00");
        this.list1.add("08:00");
        this.list1.add("09:00");
        this.list1.add("10:00");
        this.list1.add("11:00");
        this.list1.add("12:00");
        this.list1.add("13:00");
        this.list1.add("14:00");
        this.list1.add("15:00");
        this.list1.add("16:00");
        this.list1.add("17:00");
        this.list1.add("18:00");
        this.list1.add("19:00");
        this.list1.add("20:00");
        this.list1.add("21:00");
        this.list1.add("22:00");
        this.list1.add("23:00");
        this.list1.add("24:00");
    }

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
    }

    private void setLister() {
        this.btnBack.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
        this.cbxConverage.setOnCheckedChangeListener(this);
        this.cbxVoid.setOnCheckedChangeListener(this);
        this.cbxRecordTime.setOnCheckedChangeListener(this);
        this.editRecordLength.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                try {
                    String obj = editable.toString();
                    if (obj == null) {
                        obj = PushConstants.PUSH_TYPE_NOTIFY;
                    }
                    int parseInt = Integer.parseInt(obj);
                    if (parseInt < 5 || parseInt > 120) {
                        SettingSDCardActivity.this.showToast((int) R.string.sdcard_range);
                    }
                    SettingSDCardActivity.this.sdcardBean.setRecord_timer(parseInt);
                } catch (Exception unused) {
                }
            }
        });
    }

    private void findView() {
        this.tvSdTotal = (TextView) findViewById(R.id.tv_sd_total);
        this.tvSdRemain = (TextView) findViewById(R.id.tv_sd_remain);
        this.tvSdStatus = (TextView) findViewById(R.id.tv_state);
        this.cbxConverage = (CheckBox) findViewById(R.id.cbx_coverage);
        this.cbxVoid = (CheckBox) findViewById(R.id.cbx_void);
        this.editRecordLength = (EditText) findViewById(R.id.edit_record_length);
        this.cbxRecordTime = (CheckBox) findViewById(R.id.cbx_record_time);
        this.btnBack = (Button) findViewById(R.id.back);
        this.btnOk = (Button) findViewById(R.id.ok);
        this.set_sd_format = (Button) findViewById(R.id.set_sd_format);
        this.linearLayout_start = (LinearLayout) findViewById(R.id.linearLayout_start);
        this.linearLayout_end = (RelativeLayout) findViewById(R.id.linearLayout_end);
        this.set_sd_format.setOnClickListener(this);
        this.spinner_start = (Spinner) findViewById(R.id.spinner_start);
        this.spinner_end = (Spinner) findViewById(R.id.spinner_end);
        this.spinner_start.setAdapter(showSpnner(this.list));
        this.spinner_end.setAdapter(showSpnner(this.list1));
        this.spinner_start.setSelection(0);
        this.spinner_end.setSelection(23);
        this.spinner_start.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                int unused = SettingSDCardActivity.this.m_start_time = i;
            }
        });
        this.spinner_end.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                int unused = SettingSDCardActivity.this.m_end_time = i + 1;
            }
        });
    }

    private ArrayAdapter<String> showSpnner(List<String> list2) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, 17367048, list2);
        arrayAdapter.setDropDownViewResource(17367049);
        return arrayAdapter;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        } else if (id == R.id.ok) {
            setSDCardSchedule();
        } else if (id == R.id.set_sd_format) {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    NativeCaller.FormatSD(SettingSDCardActivity.this.strDID);
                    SettingSDCardActivity settingSDCardActivity = SettingSDCardActivity.this;
                    ProgressDialog unused = settingSDCardActivity.progressDialog1 = new ProgressDialog(settingSDCardActivity);
                    SettingSDCardActivity.this.progressDialog1.setProgressStyle(0);
                    SettingSDCardActivity.this.progressDialog1.setMessage(SettingSDCardActivity.this.getString(R.string.set_sd_format_show1));
                    SettingSDCardActivity.this.progressDialog1.setCancelable(false);
                    SettingSDCardActivity.this.progressDialog1.show();
                }

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    try {
                        Thread.sleep(20000);
                        return null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    if (SettingSDCardActivity.this.progressDialog1 != null && SettingSDCardActivity.this.progressDialog1.isShowing()) {
                        SettingSDCardActivity.this.progressDialog1.cancel();
                    }
                    SettingSDCardActivity.this.sendBroadcast(new Intent("myback"));
                    SettingSDCardActivity.this.finish();
                    SettingSDCardActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                }
            }.execute(new Void[0]);
        }
    }

    private void setSDCardSchedule() {
        if (!SystemValue.isLitos) {
            int record_timer = this.sdcardBean.getRecord_timer();
            if (record_timer > 120 || record_timer < 5) {
                showToast((int) R.string.sdcard_range);
                return;
            } else if (this.m_end_time <= this.m_start_time) {
                showToast((int) R.string.set_sd_show4);
                return;
            } else {
                selectTime();
            }
        }
        String str = this.strDID;
        int record_void_enable = this.sdcardBean.getRecord_void_enable();
        int record_conver_enable = this.sdcardBean.getRecord_conver_enable();
        int record_timer2 = this.sdcardBean.getRecord_timer();
        int record_size = this.sdcardBean.getRecord_size();
        int record_time_enable = this.sdcardBean.getRecord_time_enable();
        int i = this.time7;
        int i2 = i;
        int i3 = i;
        int i4 = i;
        int i5 = i;
        int i6 = i;
        int i7 = i;
        int i8 = i;
        int i9 = this.time15;
        int i10 = i9;
        int i11 = i9;
        int i12 = i9;
        int i13 = i9;
        int i14 = i9;
        int i15 = i9;
        int i16 = i9;
        int i17 = this.time23;
        int i18 = i17;
        int i19 = i17;
        NativeCaller.PPPPSDRecordSetting(str, record_void_enable, record_conver_enable, record_timer2, record_size, record_time_enable, i8, i11, i18, i4, i10, i17, i7, i16, i17, i2, i12, i19, i3, i13, i17, i5, i15, i17, i6, i14, i17);
    }

    private void selectTime() {
        switch (this.m_end_time) {
            case 1:
                this.time7 = 15;
                this.time15 = 0;
                this.time23 = 0;
                return;
            case 2:
                int i = this.m_start_time;
                if (i == 0) {
                    this.time7 = 255;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i == 1) {
                    this.time7 = 240;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else {
                    return;
                }
            case 3:
                int i2 = this.m_start_time;
                if (i2 == 0) {
                    this.time7 = 4095;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i2 == 1) {
                    this.time7 = 4080;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i2 == 2) {
                    this.time7 = 3840;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else {
                    return;
                }
            case 4:
                int i3 = this.m_start_time;
                if (i3 == 0) {
                    this.time7 = 65535;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i3 == 1) {
                    this.time7 = 65520;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i3 == 2) {
                    this.time7 = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i3 == 3) {
                    this.time7 = 61440;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else {
                    return;
                }
            case 5:
                int i4 = this.m_start_time;
                if (i4 == 0) {
                    this.time7 = 1048575;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i4 == 1) {
                    this.time7 = 1048560;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i4 == 2) {
                    this.time7 = 1048320;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i4 == 3) {
                    this.time7 = 1044480;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i4 == 4) {
                    this.time7 = 983040;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else {
                    return;
                }
            case 6:
                int i5 = this.m_start_time;
                if (i5 == 0) {
                    this.time7 = ViewCompat.MEASURED_SIZE_MASK;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i5 == 1) {
                    this.time7 = 16777200;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i5 == 2) {
                    this.time7 = 16776960;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i5 == 3) {
                    this.time7 = 16773120;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i5 == 4) {
                    this.time7 = 16711680;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else if (i5 == 5) {
                    this.time7 = 15728640;
                    this.time15 = 0;
                    this.time23 = 0;
                    return;
                } else {
                    return;
                }
            case 7:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = 268435455;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = 268435440;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = 268435200;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = 268431360;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = 268369920;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = 267386880;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = 251658240;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 8:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = 0;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 9:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = 15;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = 15;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = 15;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = 15;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = 15;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = 15;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = 15;
                        this.time23 = 0;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = 15;
                        this.time23 = 0;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = 15;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 10:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = 255;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = 255;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = 255;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = 255;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = 255;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = 255;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = 255;
                        this.time23 = 0;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = 255;
                        this.time23 = 0;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = 255;
                        this.time23 = 0;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = 240;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 11:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = 4095;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = 4095;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = 4095;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = 4095;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = 4095;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = 4095;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = 4095;
                        this.time23 = 0;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = 4095;
                        this.time23 = 0;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = 4095;
                        this.time23 = 0;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = 4080;
                        this.time23 = 0;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = 3840;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 12:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = 65535;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = 65535;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = 65535;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = 65535;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = 65535;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = 65535;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = 65535;
                        this.time23 = 0;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = 65535;
                        this.time23 = 0;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = 65535;
                        this.time23 = 0;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = 65520;
                        this.time23 = 0;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                        this.time23 = 0;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = 61440;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 13:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = 1048575;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = 1048575;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = 1048575;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = 1048575;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = 1048575;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = 1048575;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = 1048575;
                        this.time23 = 0;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = 1048575;
                        this.time23 = 0;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = 1048575;
                        this.time23 = 0;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = 1048560;
                        this.time23 = 0;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = 1048320;
                        this.time23 = 0;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = 1044480;
                        this.time23 = 0;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = 983040;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 14:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = ViewCompat.MEASURED_SIZE_MASK;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = ViewCompat.MEASURED_SIZE_MASK;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = ViewCompat.MEASURED_SIZE_MASK;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = ViewCompat.MEASURED_SIZE_MASK;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = ViewCompat.MEASURED_SIZE_MASK;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = ViewCompat.MEASURED_SIZE_MASK;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = ViewCompat.MEASURED_SIZE_MASK;
                        this.time23 = 0;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = ViewCompat.MEASURED_SIZE_MASK;
                        this.time23 = 0;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_SIZE_MASK;
                        this.time23 = 0;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = 16777200;
                        this.time23 = 0;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = 16776960;
                        this.time23 = 0;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = 16773120;
                        this.time23 = 0;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = 16711680;
                        this.time23 = 0;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = 15728640;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 15:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = 268435455;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = 268435455;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = 268435455;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = 268435455;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = 268435455;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = 268435455;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = 268435455;
                        this.time23 = 0;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = 268435455;
                        this.time23 = 0;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = 268435455;
                        this.time23 = 0;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = 268435440;
                        this.time23 = 0;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = 268435200;
                        this.time23 = 0;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = 268431360;
                        this.time23 = 0;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = 268369920;
                        this.time23 = 0;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = 267386880;
                        this.time23 = 0;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = 251658240;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 16:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = -1;
                        this.time23 = 0;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = -1;
                        this.time23 = 0;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = -1;
                        this.time23 = 0;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = -1;
                        this.time23 = 0;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = -1;
                        this.time23 = 0;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = -1;
                        this.time23 = 0;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = -1;
                        this.time23 = 0;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = -1;
                        this.time23 = 0;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = -1;
                        this.time23 = 0;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = -16;
                        this.time23 = 0;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = InputDeviceCompat.SOURCE_ANY;
                        this.time23 = 0;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = -4096;
                        this.time23 = 0;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = SupportMenu.CATEGORY_MASK;
                        this.time23 = 0;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = -1048576;
                        this.time23 = 0;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_STATE_MASK;
                        this.time23 = 0;
                        return;
                    case 15:
                        this.time7 = 0;
                        this.time15 = -268435456;
                        this.time23 = 0;
                        return;
                    default:
                        return;
                }
            case 17:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = -1;
                        this.time23 = 15;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = -1;
                        this.time23 = 15;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = -1;
                        this.time23 = 15;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = -1;
                        this.time23 = 15;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = -1;
                        this.time23 = 15;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = -1;
                        this.time23 = 15;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = -1;
                        this.time23 = 15;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = -1;
                        this.time23 = 15;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = -1;
                        this.time23 = 15;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = -16;
                        this.time23 = 15;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = InputDeviceCompat.SOURCE_ANY;
                        this.time23 = 15;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = -4096;
                        this.time23 = 15;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = SupportMenu.CATEGORY_MASK;
                        this.time23 = 15;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = -1048576;
                        this.time23 = 15;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_STATE_MASK;
                        this.time23 = 15;
                        return;
                    case 15:
                        this.time7 = 0;
                        this.time15 = -268435456;
                        this.time23 = 15;
                        return;
                    case 16:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 15;
                        return;
                    default:
                        return;
                }
            case 18:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = -1;
                        this.time23 = 255;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = -1;
                        this.time23 = 255;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = -1;
                        this.time23 = 255;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = -1;
                        this.time23 = 255;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = -1;
                        this.time23 = 255;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = -1;
                        this.time23 = 255;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = -1;
                        this.time23 = 255;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = -1;
                        this.time23 = 255;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = -1;
                        this.time23 = 255;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = -16;
                        this.time23 = 255;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = InputDeviceCompat.SOURCE_ANY;
                        this.time23 = 255;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = -4096;
                        this.time23 = 255;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = SupportMenu.CATEGORY_MASK;
                        this.time23 = 255;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = -1048576;
                        this.time23 = 255;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_STATE_MASK;
                        this.time23 = 255;
                        return;
                    case 15:
                        this.time7 = 0;
                        this.time15 = -268435456;
                        this.time23 = 255;
                        return;
                    case 16:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 255;
                        return;
                    case 17:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 240;
                        return;
                    default:
                        return;
                }
            case 19:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = -1;
                        this.time23 = 4095;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = -1;
                        this.time23 = 4095;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = -1;
                        this.time23 = 4095;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = -1;
                        this.time23 = 4095;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = -1;
                        this.time23 = 4095;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = -1;
                        this.time23 = 4095;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = -1;
                        this.time23 = 4095;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = -1;
                        this.time23 = 4095;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = -1;
                        this.time23 = 4095;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = -16;
                        this.time23 = 4095;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = InputDeviceCompat.SOURCE_ANY;
                        this.time23 = 4095;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = -4096;
                        this.time23 = 4095;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = SupportMenu.CATEGORY_MASK;
                        this.time23 = 4095;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = -1048576;
                        this.time23 = 4095;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_STATE_MASK;
                        this.time23 = 4095;
                        return;
                    case 15:
                        this.time7 = 0;
                        this.time15 = -268435456;
                        this.time23 = 4095;
                        return;
                    case 16:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 4095;
                        return;
                    case 17:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 4080;
                        return;
                    case 18:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 3840;
                        return;
                    default:
                        return;
                }
            case 20:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = -1;
                        this.time23 = 65535;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = -1;
                        this.time23 = 65535;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = -1;
                        this.time23 = 65535;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = -1;
                        this.time23 = 65535;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = -1;
                        this.time23 = 65535;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = -1;
                        this.time23 = 65535;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = -1;
                        this.time23 = 65535;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = -1;
                        this.time23 = 65535;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = -1;
                        this.time23 = 65535;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = -16;
                        this.time23 = 65535;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = InputDeviceCompat.SOURCE_ANY;
                        this.time23 = 65535;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = -4096;
                        this.time23 = 65535;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = SupportMenu.CATEGORY_MASK;
                        this.time23 = 65535;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = -1048576;
                        this.time23 = 65535;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_STATE_MASK;
                        this.time23 = 65535;
                        return;
                    case 15:
                        this.time7 = 0;
                        this.time15 = -268435456;
                        this.time23 = 65535;
                        return;
                    case 16:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 65535;
                        return;
                    case 17:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 65520;
                        return;
                    case 18:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                        return;
                    case 19:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 61440;
                        return;
                    default:
                        return;
                }
            case 21:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = -1;
                        this.time23 = 1048575;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = -1;
                        this.time23 = 1048575;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = -1;
                        this.time23 = 1048575;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = -1;
                        this.time23 = 1048575;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = -1;
                        this.time23 = 1048575;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = -1;
                        this.time23 = 1048575;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = -1;
                        this.time23 = 1048575;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = -1;
                        this.time23 = 1048575;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = -1;
                        this.time23 = 1048575;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = -16;
                        this.time23 = 1048575;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = InputDeviceCompat.SOURCE_ANY;
                        this.time23 = 1048575;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = -4096;
                        this.time23 = 1048575;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = SupportMenu.CATEGORY_MASK;
                        this.time23 = 1048575;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = -1048576;
                        this.time23 = 1048575;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_STATE_MASK;
                        this.time23 = 1048575;
                        return;
                    case 15:
                        this.time7 = 0;
                        this.time15 = -268435456;
                        this.time23 = 1048575;
                        return;
                    case 16:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 1048575;
                        return;
                    case 17:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 1048560;
                        return;
                    case 18:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 1048320;
                        return;
                    case 19:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 1044480;
                        return;
                    case 20:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 983040;
                        return;
                    default:
                        return;
                }
            case 22:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = -1;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = -1;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = -1;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = -1;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = -1;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = -1;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = -1;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = -1;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = -1;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = -16;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = InputDeviceCompat.SOURCE_ANY;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = -4096;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = SupportMenu.CATEGORY_MASK;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = -1048576;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_STATE_MASK;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 15:
                        this.time7 = 0;
                        this.time15 = -268435456;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 16:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = ViewCompat.MEASURED_SIZE_MASK;
                        return;
                    case 17:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 16777200;
                        return;
                    case 18:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 16776960;
                        return;
                    case 19:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 16773120;
                        return;
                    case 20:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 16711680;
                        return;
                    case 21:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 15728640;
                        return;
                    default:
                        return;
                }
            case 23:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = -1;
                        this.time23 = 268435455;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = -1;
                        this.time23 = 268435455;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = -1;
                        this.time23 = 268435455;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = -1;
                        this.time23 = 268435455;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = -1;
                        this.time23 = 268435455;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = -1;
                        this.time23 = 268435455;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = -1;
                        this.time23 = 268435455;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = -1;
                        this.time23 = 268435455;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = -1;
                        this.time23 = 268435455;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = -16;
                        this.time23 = 268435455;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = InputDeviceCompat.SOURCE_ANY;
                        this.time23 = 268435455;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = -4096;
                        this.time23 = 268435455;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = SupportMenu.CATEGORY_MASK;
                        this.time23 = 268435455;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = -1048576;
                        this.time23 = 268435455;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_STATE_MASK;
                        this.time23 = 268435455;
                        return;
                    case 15:
                        this.time7 = 0;
                        this.time15 = -268435456;
                        this.time23 = 268435455;
                        return;
                    case 16:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 268435455;
                        return;
                    case 17:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 268435440;
                        return;
                    case 18:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 268435200;
                        return;
                    case 19:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 268431360;
                        return;
                    case 20:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 268369920;
                        return;
                    case 21:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 267386880;
                        return;
                    case 22:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = 251658240;
                        return;
                    default:
                        return;
                }
            case 24:
                switch (this.m_start_time) {
                    case 0:
                        this.time7 = -1;
                        this.time15 = -1;
                        this.time23 = -1;
                        return;
                    case 1:
                        this.time7 = -16;
                        this.time15 = -1;
                        this.time23 = -1;
                        return;
                    case 2:
                        this.time7 = InputDeviceCompat.SOURCE_ANY;
                        this.time15 = -1;
                        this.time23 = -1;
                        return;
                    case 3:
                        this.time7 = -4096;
                        this.time15 = -1;
                        this.time23 = -1;
                        return;
                    case 4:
                        this.time7 = SupportMenu.CATEGORY_MASK;
                        this.time15 = -1;
                        this.time23 = -1;
                        return;
                    case 5:
                        this.time7 = -1048576;
                        this.time15 = -1;
                        this.time23 = -1;
                        return;
                    case 6:
                        this.time7 = ViewCompat.MEASURED_STATE_MASK;
                        this.time15 = -1;
                        this.time23 = -1;
                        return;
                    case 7:
                        this.time7 = -268435456;
                        this.time15 = -1;
                        this.time23 = -1;
                        return;
                    case 8:
                        this.time7 = 0;
                        this.time15 = -1;
                        this.time23 = -1;
                        return;
                    case 9:
                        this.time7 = 0;
                        this.time15 = -16;
                        this.time23 = -1;
                        return;
                    case 10:
                        this.time7 = 0;
                        this.time15 = InputDeviceCompat.SOURCE_ANY;
                        this.time23 = -1;
                        return;
                    case 11:
                        this.time7 = 0;
                        this.time15 = -4096;
                        this.time23 = -1;
                        return;
                    case 12:
                        this.time7 = 0;
                        this.time15 = SupportMenu.CATEGORY_MASK;
                        this.time23 = -1;
                        return;
                    case 13:
                        this.time7 = 0;
                        this.time15 = -1048576;
                        this.time23 = -1;
                        return;
                    case 14:
                        this.time7 = 0;
                        this.time15 = ViewCompat.MEASURED_STATE_MASK;
                        this.time23 = -1;
                        return;
                    case 15:
                        this.time7 = 0;
                        this.time15 = -268435456;
                        this.time23 = -1;
                        return;
                    case 16:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = -1;
                        return;
                    case 17:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = -16;
                        return;
                    case 18:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = InputDeviceCompat.SOURCE_ANY;
                        return;
                    case 19:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = -4096;
                        return;
                    case 20:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = SupportMenu.CATEGORY_MASK;
                        return;
                    case 21:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = -1048576;
                        return;
                    case 22:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = ViewCompat.MEASURED_STATE_MASK;
                        return;
                    case 23:
                        this.time7 = 0;
                        this.time15 = 0;
                        this.time23 = -268435456;
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.cbx_coverage:
                if (z) {
                    this.sdcardBean.setRecord_conver_enable(1);
                    return;
                } else {
                    this.sdcardBean.setRecord_conver_enable(0);
                    return;
                }
            case R.id.cbx_record_time:
                if (z) {
                    this.sdcardBean.setRecord_time_enable(1);
                    if (!SystemValue.isLitos) {
                        this.linearLayout_start.setVisibility(0);
                        this.linearLayout_end.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.sdcardBean.setRecord_time_enable(0);
                this.linearLayout_start.setVisibility(8);
                this.linearLayout_end.setVisibility(8);
                return;
            case R.id.cbx_void:
                if (z) {
                    this.sdcardBean.setRecord_void_enable(1);
                    return;
                } else {
                    this.sdcardBean.setRecord_void_enable(0);
                    return;
                }
            default:
                return;
        }
    }

    public void callBackRecordSchParams(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28) {
        int i29 = i27;
        Log.d("tag", "sdtotal:" + i29);
        this.ifShow = i4;
        String str2 = str;
        this.sdcardBean.setDid(str);
        int i30 = i;
        this.sdcardBean.setRecord_conver_enable(i);
        int i31 = i2;
        this.sdcardBean.setRecord_timer(i2);
        int i32 = i3;
        this.sdcardBean.setRecord_size(i3);
        this.sdcardBean.setRecord_time_enable(i4);
        int i33 = i5;
        this.sdcardBean.setRecord_void_enable(i5);
        this.sdcardBean.setRecord_sd_status(i26);
        this.sdcardBean.setSdtotal(i29);
        this.sdcardBean.setSdfree(i28);
        this.handler.sendEmptyMessage(2);
    }

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
        Log.d("tag", "result:" + i2 + " paramType:" + i);
        if (this.strDID.equals(str)) {
            this.handler.sendEmptyMessage(i2);
        }
    }
}
