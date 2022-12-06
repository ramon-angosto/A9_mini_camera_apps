package com.shix.shixipc.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.YearsModel;
import com.shix.shixipc.gridview.GridItem;
import com.shix.shixipc.gridview.StickyGridTfAdapter;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.NiftyDialogBuilder;
import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import object.p2pipcam.nativecaller.NativeCaller;

public class TfFilesActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    private static final int ACTIVITY_RESULT_PHOTO_VIEW = 10;
    private static final int DEFAULT_LIST_SIZE = 20;
    public static final String EXTRA_GIRDLST = "girdlst";
    public static final String EXTRA_POSITION = "position";
    public static Activity mActivity;
    public static List<GridItem> mDeleteList = new ArrayList();
    private static int section = 1;
    private final int GETDAYS = 2;
    private final int GETFILES = 3;
    final List<String> IMAGE_FILES = new ArrayList(20);
    private final int PARAMS = 1;
    private int TIMEOUT = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
    /* access modifiers changed from: private */
    public StickyGridTfAdapter adapter;
    Button btnOk;
    private Button btn_data_1;
    private Button btn_data_2;
    private Button btn_data_3;
    private Button btn_data_4;
    private Button btn_data_5;
    private Button btn_data_6;
    private Button btn_data_7;
    private Button btn_data_8;
    /* access modifiers changed from: private */
    public GridView gridview;
    /* access modifiers changed from: private */
    public boolean isDeleteModel = false;
    /* access modifiers changed from: private */
    public boolean isVideo = false;
    /* access modifiers changed from: private */
    public ArrayList<Button> listBtns = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<GridItem> mGirdList = new ArrayList<>();
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    if (TfFilesActivity.this.progressDialog != null && TfFilesActivity.this.progressDialog.isShowing()) {
                        TfFilesActivity.this.progressDialog.dismiss();
                    }
                    TfFilesActivity tfFilesActivity = TfFilesActivity.this;
                    StickyGridTfAdapter unused = tfFilesActivity.adapter = new StickyGridTfAdapter(tfFilesActivity, tfFilesActivity.mGirdList, TfFilesActivity.this.gridview, TfFilesActivity.this.isVideo);
                    TfFilesActivity.this.gridview.setAdapter(TfFilesActivity.this.adapter);
                    TfFilesActivity.this.adapter.notifyDataSetChanged();
                } else if (i == 110) {
                    String string = message.getData().getString(ImagePagerActivity.FILENAME);
                    if (string.length() > 8) {
                        string.substring(0, 4) + "-" + string.substring(4, 6) + "-" + string.substring(6, 8);
                    }
                }
            } else if (TfFilesActivity.this.yearsModel != null && TfFilesActivity.this.yearsModel.getDays().size() != 0) {
                int i2 = 0;
                while (i2 < TfFilesActivity.this.yearsModel.getDays().size() && i2 != 8) {
                    Button button = (Button) TfFilesActivity.this.listBtns.get(i2);
                    button.setVisibility(0);
                    button.setText(TfFilesActivity.this.yearsModel.getDays().get(i2) + "");
                    i2++;
                }
                TfFilesActivity.this.getYMD(0);
            }
        }
    };
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ImagePagerActivity.BROAD_ACTION)) {
                TfFilesActivity.this.mGirdList.remove(intent.getIntExtra(ImagePagerActivity.INDEX, 0));
                TfFilesActivity.this.adapter.notifyDataSetChanged();
            }
        }
    };
    private LinearLayout mll_anim;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    /* access modifiers changed from: private */
    public String strDid;
    /* access modifiers changed from: private */
    public String strName = "";
    /* access modifiers changed from: private */
    public String strNowYMD = "2020_01_08";
    /* access modifiers changed from: private */
    public String strNowYMDH = "";
    /* access modifiers changed from: private */
    public YearsModel yearsModel = null;

    /* access modifiers changed from: private */
    public void getYMD(int i) {
        if (this.mGirdList == null) {
            this.mGirdList = new ArrayList<>();
        }
        this.mGirdList.clear();
        this.strNowYMD = this.yearsModel.getDays().get(i);
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                NativeCaller.TransferMessage(TfFilesActivity.this.strDid, CommonUtil.getRecordHourList(SystemValue.doorBellAdmin, SystemValue.doorBellPass, TfFilesActivity.this.strNowYMD), 0);
                return null;
            }
        }.execute(new Void[0]);
        setBtnGreen(i);
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && !progressDialog2.isShowing()) {
            this.progressDialog.show();
        }
    }

    private void setBtnGreen(int i) {
        for (int i2 = 0; i2 < this.listBtns.size(); i2++) {
            Button button = this.listBtns.get(i2);
            if (i == i2) {
                button.setBackgroundResource(R.drawable.background_green);
            } else {
                button.setBackgroundResource(R.drawable.btn_blue_selector);
            }
        }
    }

    /* access modifiers changed from: private */
    public void getYMDH(String str) {
        this.strNowYMDH = this.strNowYMD + "_" + str;
        this.strNowYMDH = this.strNowYMDH.replace(":00", "");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tf_files);
        this.strDid = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.strName = getIntent().getStringExtra(ContentCommon.STR_CAMERA_NAME);
        if (getIntent().getIntExtra("type", 0) == 1) {
            this.isVideo = true;
        } else {
            this.isVideo = false;
        }
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.listBtns.clear();
        initView();
        registerBrodCast();
        TextView textView = (TextView) findViewById(R.id.tv_camera);
        if (this.isVideo) {
            textView.setText(this.strName);
        } else {
            textView.setText(this.strName);
        }
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TfFilesActivity.this.finish();
            }
        });
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDid, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, Calendar.getInstance().get(1)), 0);
        this.btnOk = (Button) findViewById(R.id.ok);
        this.btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TfFilesActivity.mDeleteList.clear();
                if (TfFilesActivity.this.isDeleteModel) {
                    TfFilesActivity.this.btnOk.setText(R.string.door_white_list_edit);
                    TfFilesActivity tfFilesActivity = TfFilesActivity.this;
                    tfFilesActivity.loadAnimation((float) CommonUtil.dip2px(tfFilesActivity, 50.0f));
                    boolean unused = TfFilesActivity.this.isDeleteModel = false;
                    return;
                }
                TfFilesActivity.this.btnOk.setText(R.string.done);
                TfFilesActivity tfFilesActivity2 = TfFilesActivity.this;
                tfFilesActivity2.loadAnimation((float) CommonUtil.dip2px(tfFilesActivity2, -50.0f));
                boolean unused2 = TfFilesActivity.this.isDeleteModel = true;
            }
        });
        this.progressDialog = new ProgressDialog(this, 3);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage("");
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        NUIMainActivity.setSHIXCOMMONInterface(this);
        super.onResume();
    }

    private void initView() {
        this.btn_data_1 = (Button) findViewById(R.id.btn_data_1);
        this.btn_data_2 = (Button) findViewById(R.id.btn_data_2);
        this.btn_data_3 = (Button) findViewById(R.id.btn_data_3);
        this.btn_data_4 = (Button) findViewById(R.id.btn_data_4);
        this.btn_data_5 = (Button) findViewById(R.id.btn_data_5);
        this.btn_data_6 = (Button) findViewById(R.id.btn_data_6);
        this.btn_data_6 = (Button) findViewById(R.id.btn_data_6);
        this.btn_data_7 = (Button) findViewById(R.id.btn_data_7);
        this.btn_data_8 = (Button) findViewById(R.id.btn_data_8);
        this.listBtns.add(this.btn_data_1);
        this.listBtns.add(this.btn_data_2);
        this.listBtns.add(this.btn_data_3);
        this.listBtns.add(this.btn_data_4);
        this.listBtns.add(this.btn_data_5);
        this.listBtns.add(this.btn_data_6);
        this.listBtns.add(this.btn_data_7);
        this.listBtns.add(this.btn_data_8);
        this.btn_data_1.setOnClickListener(this);
        this.btn_data_2.setOnClickListener(this);
        this.btn_data_3.setOnClickListener(this);
        this.btn_data_4.setOnClickListener(this);
        this.btn_data_5.setOnClickListener(this);
        this.btn_data_6.setOnClickListener(this);
        this.btn_data_7.setOnClickListener(this);
        this.btn_data_8.setOnClickListener(this);
        this.mGirdList.clear();
        initTopView();
        this.gridview = (GridView) findViewById(R.id.asset_grid);
        this.gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(TfFilesActivity.this, 10);
                }
                if (i >= 0) {
                    TfFilesActivity.this.getYMDH(((GridItem) TfFilesActivity.this.mGirdList.get(i)).getTime());
                    Intent intent = new Intent(TfFilesActivity.this, TfFilesHourActivity.class);
                    intent.putExtra(ContentCommon.STR_CAMERA_NAME, TfFilesActivity.this.strName);
                    intent.putExtra(ContentCommon.STR_CAMERA_ID, TfFilesActivity.this.strDid);
                    intent.putExtra(ContentCommon.STR_CAMERA_PWD, SystemValue.doorBellPass);
                    intent.putExtra(ContentCommon.STR_CAMERA_USER, SystemValue.doorBellAdmin);
                    intent.putExtra("strNowYMDH", TfFilesActivity.this.strNowYMDH);
                    TfFilesActivity.this.startActivity(intent);
                }
            }
        });
    }

    private String returnTime(String str, int i) {
        if (i < 10) {
            return MBridgeConstans.ENDCARD_URL_TYPE_PL + i + ":00";
        }
        return i + ":00";
    }

    private void initTopView() {
        this.mll_anim = (LinearLayout) findViewById(R.id.ll_anim);
        this.mll_anim.setOnClickListener(this);
    }

    public final synchronized void setImagesPath(String str) {
        this.IMAGE_FILES.clear();
        String[] list = new File(str).list();
        if (list != null && list.length > 0) {
            Arrays.sort(list);
            for (String str2 : list) {
                this.mGirdList.add(new GridItem(str + "/" + str2, paserTimeToYM(new File(str + "/" + str2).lastModified() / 1000)));
            }
            Collections.reverse(this.IMAGE_FILES);
        }
    }

    public final void removeCorruptImage() {
        Iterator<String> it = this.IMAGE_FILES.iterator();
        while (it.hasNext()) {
            if (BitmapFactory.decodeFile(it.next()) == null) {
                it.remove();
            }
        }
    }

    private String paserTimeToYM(long j) {
        TimeZone.setDefault(TimeZone.getDefault());
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(j * 1000));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10 && i2 == -1) {
            this.mGirdList.remove(intent.getExtras().getInt(ImagePagerActivity.INDEX));
            this.adapter.notifyDataSetChanged();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.ll_anim) {
            switch (id) {
                case R.id.btn_data_1:
                    getYMD(0);
                    return;
                case R.id.btn_data_2:
                    getYMD(1);
                    return;
                case R.id.btn_data_3:
                    getYMD(2);
                    return;
                case R.id.btn_data_4:
                    getYMD(3);
                    return;
                case R.id.btn_data_5:
                    getYMD(4);
                    return;
                case R.id.btn_data_6:
                    getYMD(5);
                    return;
                case R.id.btn_data_7:
                    getYMD(6);
                    return;
                case R.id.btn_data_8:
                    getYMD(7);
                    return;
                default:
                    return;
            }
        } else if (mDeleteList.size() <= 0) {
            showToast(getString(R.string.tip_delete_snap));
        } else {
            final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(this);
            instance.withMessage((CharSequence) getString(R.string.tips_msg_delete_snapshot)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() {
                public void onClick(View view) {
                    instance.dismiss();
                }
            }).setButton2Click(new View.OnClickListener() {
                public void onClick(View view) {
                    instance.dismiss();
                    for (GridItem path : TfFilesActivity.mDeleteList) {
                        new File(path.getPath()).delete();
                    }
                    TfFilesActivity.this.mGirdList.removeAll(TfFilesActivity.mDeleteList);
                    TfFilesActivity.this.adapter.notifyDataSetChanged();
                    TfFilesActivity.mDeleteList.clear();
                }
            }).show();
        }
    }

    /* access modifiers changed from: private */
    public void loadAnimation(float f) {
        float translationY = this.mll_anim.getTranslationY();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mll_anim, "translationY", new float[]{translationY, f});
        ofFloat.setDuration(250);
        ofFloat.start();
    }

    private void registerBrodCast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ImagePagerActivity.BROAD_ACTION);
        registerReceiver(this.mReceiver, intentFilter);
    }

    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && progressDialog2.isShowing()) {
            this.progressDialog.dismiss();
        }
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A[SYNTHETIC, Splitter:B:15:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void CallBackSHIXJasonCommon(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "CallBackSHIXJasonCommon:"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r1 = 1
            com.shix.shixipc.utils.CommonUtil.Log(r1, r0)
            java.lang.String r0 = r5.strDid
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L_0x001e
            return
        L_0x001e:
            r6 = 0
            r0 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002e }
            r2.<init>(r7)     // Catch:{ JSONException -> 0x002e }
            java.lang.String r6 = "cmd"
            int r6 = r2.getInt(r6)     // Catch:{ JSONException -> 0x002c }
            goto L_0x0036
        L_0x002c:
            r6 = move-exception
            goto L_0x0032
        L_0x002e:
            r2 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
        L_0x0032:
            r6.printStackTrace()
            r6 = r0
        L_0x0036:
            r3 = 205(0xcd, float:2.87E-43)
            if (r6 != r3) goto L_0x004c
            com.shix.shixipc.bean.YearsModel r6 = com.shix.shixipc.bean.YearsModel.jsonToModel(r7)     // Catch:{ JSONException -> 0x0047 }
            r5.yearsModel = r6     // Catch:{ JSONException -> 0x0047 }
            android.os.Handler r6 = r5.mHandler     // Catch:{ JSONException -> 0x0047 }
            r7 = 2
            r6.sendEmptyMessage(r7)     // Catch:{ JSONException -> 0x0047 }
            goto L_0x00a6
        L_0x0047:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x00a6
        L_0x004c:
            r7 = 401(0x191, float:5.62E-43)
            if (r6 != r7) goto L_0x00a6
            java.lang.String r6 = "record_hour"
            int r6 = r2.getInt(r6)     // Catch:{ JSONException -> 0x0057 }
            goto L_0x005d
        L_0x0057:
            r6 = move-exception
            r7 = -1
            r6.printStackTrace()
            r6 = r7
        L_0x005d:
            if (r6 < 0) goto L_0x00a6
        L_0x005f:
            r7 = 24
            if (r0 >= r7) goto L_0x00a0
            boolean r7 = com.shix.shixipc.utils.CommonUtil.get(r6, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = " record_hour:"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = "  isHave:"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = "   i:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.shix.shixipc.utils.CommonUtil.Log(r1, r2)
            if (r7 == 0) goto L_0x009d
            com.shix.shixipc.gridview.GridItem r7 = new com.shix.shixipc.gridview.GridItem
            java.lang.String r2 = ""
            java.lang.String r3 = r5.returnTime(r2, r0)
            r7.<init>(r2, r3)
            java.util.ArrayList<com.shix.shixipc.gridview.GridItem> r2 = r5.mGirdList
            r2.add(r7)
        L_0x009d:
            int r0 = r0 + 1
            goto L_0x005f
        L_0x00a0:
            android.os.Handler r6 = r5.mHandler
            r7 = 3
            r6.sendEmptyMessage(r7)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.TfFilesActivity.CallBackSHIXJasonCommon(java.lang.String, java.lang.String):void");
    }
}
