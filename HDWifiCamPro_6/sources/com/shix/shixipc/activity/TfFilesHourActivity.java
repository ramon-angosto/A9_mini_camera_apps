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
import com.shix.shixipc.gridview.GridItem;
import com.shix.shixipc.gridview.StickyGridTfAdapter;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TfFilesHourActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    private static final int ACTIVITY_RESULT_PHOTO_VIEW = 10;
    private static final int DEFAULT_LIST_SIZE = 20;
    public static final String EXTRA_GIRDLST = "girdlst";
    public static final String EXTRA_POSITION = "position";
    public static Activity mActivity;
    public static List<GridItem> mDeleteList = new ArrayList();
    private static int section = 1;
    private final int GETDAYS = 2;
    private final int GETFILES = 3;
    private final int GETFILESEND = 4;
    final List<String> IMAGE_FILES = new ArrayList(20);
    private final int PARAMS = 1;
    private int TIMEOUT = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
    /* access modifiers changed from: private */
    public StickyGridTfAdapter adapter;
    Button btnOk;
    /* access modifiers changed from: private */
    public GridView gridview;
    private boolean isDeleteModel = false;
    private boolean isVideo = false;
    /* access modifiers changed from: private */
    public ArrayList<GridItem> mGirdList = new ArrayList<>();
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1 && i != 2) {
                if (i == 4) {
                    if (TfFilesHourActivity.this.progressDialog != null && TfFilesHourActivity.this.progressDialog.isShowing()) {
                        TfFilesHourActivity.this.progressDialog.dismiss();
                    }
                    TfFilesHourActivity tfFilesHourActivity = TfFilesHourActivity.this;
                    StickyGridTfAdapter unused = tfFilesHourActivity.adapter = new StickyGridTfAdapter(tfFilesHourActivity, tfFilesHourActivity.mGirdList, TfFilesHourActivity.this.gridview, true);
                    TfFilesHourActivity.this.gridview.setAdapter(TfFilesHourActivity.this.adapter);
                } else if (i == 110) {
                    String string = message.getData().getString(ImagePagerActivity.FILENAME);
                    if (string.length() > 13) {
                        TfFilesHourActivity.this.mGirdList.add(new GridItem(string, string.substring(10, 12)));
                    }
                }
            }
        }
    };
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ImagePagerActivity.BROAD_ACTION)) {
                TfFilesHourActivity.this.mGirdList.remove(intent.getIntExtra(ImagePagerActivity.INDEX, 0));
                TfFilesHourActivity.this.adapter.notifyDataSetChanged();
            }
        }
    };
    private LinearLayout mll_anim;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    /* access modifiers changed from: private */
    public String strDid;
    private String strName = "";
    /* access modifiers changed from: private */
    public String strNowYMDH = "";

    private void getYMDH(int i) {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                NativeCaller.TransferMessage(TfFilesHourActivity.this.strDid, CommonUtil.getRecordMinList(SystemValue.doorBellAdmin, SystemValue.doorBellPass, TfFilesHourActivity.this.strNowYMDH), 0);
                return null;
            }
        }.execute(new Void[0]);
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && !progressDialog2.isShowing()) {
            this.progressDialog.show();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tf_files);
        this.strDid = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.strName = getIntent().getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strNowYMDH = getIntent().getStringExtra("strNowYMDH");
        CommonUtil.Log(1, "strNowYMDH:" + this.strNowYMDH);
        if (getIntent().getIntExtra("type", 0) == 1) {
            this.isVideo = true;
        } else {
            this.isVideo = false;
        }
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        initView();
        registerBrodCast();
        ((TextView) findViewById(R.id.tv_camera)).setText(this.strNowYMDH);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TfFilesHourActivity.this.finish();
            }
        });
        NUIMainActivity.setSHIXCOMMONInterface(this);
        this.btnOk = (Button) findViewById(R.id.ok);
        this.progressDialog = new ProgressDialog(this, 3);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage("");
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        getYMDH(0);
    }

    private void initView() {
        this.mGirdList.clear();
        initTopView();
        this.gridview = (GridView) findViewById(R.id.asset_grid);
        findViewById(R.id.scrollView1).setVisibility(8);
        this.gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(TfFilesHourActivity.this, 10);
                }
                if (i >= 0) {
                    String path = ((GridItem) TfFilesHourActivity.this.mGirdList.get(i)).getPath();
                    Intent intent = new Intent(TfFilesHourActivity.this, PlayBackActivity.class);
                    intent.putExtra("did", TfFilesHourActivity.this.strDid);
                    intent.putExtra("filepath", path);
                    TfFilesHourActivity.this.startActivity(intent);
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
        view.getId();
    }

    private void loadAnimation(float f) {
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

    public void CallBackSHIXJasonCommon(String str, String str2) {
        int i;
        JSONArray jSONArray;
        CommonUtil.Log(1, "CallBackSHIXJasonCommon:" + str2);
        if (this.strDid.equals(str)) {
            int i2 = 0;
            try {
                i = new JSONObject(str2).getInt("cmd");
            } catch (JSONException e) {
                e.printStackTrace();
                i = 0;
            }
            if (i == 402) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int i3 = jSONObject.getInt("record_num");
                    if (jSONObject.has("recordList")) {
                        try {
                            jSONArray = jSONObject.getJSONArray("recordList");
                        } catch (Exception unused) {
                            jSONArray = null;
                        }
                        if (i3 > 0 && jSONArray != null) {
                            while (i2 < i3) {
                                String str3 = (String) jSONArray.get(i2);
                                CommonUtil.Log(1, "ZHAOXXX name.toString();:" + str3.toString());
                                if (str3.indexOf("-1") < 0) {
                                    if (this.strDid.equals(str)) {
                                        Message obtainMessage = this.mHandler.obtainMessage();
                                        obtainMessage.what = 110;
                                        Bundle bundle = new Bundle();
                                        bundle.putString(ImagePagerActivity.FILENAME, str3);
                                        obtainMessage.setData(bundle);
                                        this.mHandler.sendMessage(obtainMessage);
                                    }
                                }
                                i2++;
                            }
                            this.mHandler.sendEmptyMessage(4);
                            return;
                        }
                        return;
                    }
                    while (i2 < i3) {
                        String string = jSONObject.getString("record_name[" + i2 + "]");
                        if (this.strDid.equals(str)) {
                            Message obtainMessage2 = this.mHandler.obtainMessage();
                            obtainMessage2.what = 110;
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(ImagePagerActivity.FILENAME, string);
                            obtainMessage2.setData(bundle2);
                            this.mHandler.sendMessage(obtainMessage2);
                        }
                        i2++;
                    }
                    this.mHandler.sendEmptyMessage(4);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
