package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.PlaybackTFAdapter;
import com.shix.shixipc.bean.YearsModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.Effectstype;
import com.shix.shixipc.view.NiftyDialogBuilder;
import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayBackTFActivity extends BaseActivity implements View.OnClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener, AbsListView.OnScrollListener, NUIMainActivity.SHIXCOMMONInterface {
    private final int GETDAYS = 2;
    private final int GETFILES = 3;
    private final int PARAMS = 1;
    private int TIMEOUT = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
    private Button btnBack = null;
    /* access modifiers changed from: private */
    public int countGet = 0;
    private int count_expand = 0;
    private int endTime = 0;
    /* access modifiers changed from: private */
    public ExpandableListView exListView = null;
    private Map<Integer, Integer> expandGroup = new HashMap();
    /* access modifiers changed from: private */
    public RelativeLayout floatHeaderView = null;
    private ImageView headerImg = null;
    private TextView headerSum = null;
    private TextView headerTitle = null;
    private int indicatorGroupHeight;
    private boolean isFirstOn = false;
    /* access modifiers changed from: private */
    public boolean isGet00 = false;
    /* access modifiers changed from: private */
    public PlaybackTFAdapter mExAdapter = null;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                boolean unused = PlayBackTFActivity.this.successFlag = true;
                if (PlayBackTFActivity.this.progressDialog.isShowing()) {
                    PlayBackTFActivity.this.progressDialog.cancel();
                }
                PlayBackTFActivity.this.mExAdapter.notifyDataSetChanged();
            } else if (i != 2) {
                if (i == 110) {
                    String string = message.getData().getString(ImagePagerActivity.FILENAME);
                    if (string.length() > 8) {
                        String substring = string.substring(0, 4);
                        String substring2 = string.substring(4, 6);
                        String substring3 = string.substring(6, 8);
                        PlayBackTFActivity.this.mExAdapter.addGroupAndChild(substring + "-" + substring2 + "-" + substring3, string);
                    }
                    PlayBackTFActivity.this.mExAdapter.notifyDataSetChanged();
                }
            } else if (PlayBackTFActivity.this.yearsModel == null) {
                if (!PlayBackTFActivity.this.isGet00) {
                    boolean unused2 = PlayBackTFActivity.this.isGet00 = true;
                    NativeCaller.TransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 2000), 0);
                    NativeCaller.TransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 2020), 0);
                }
            } else if (PlayBackTFActivity.this.yearsModel.getDays().size() == 0) {
                if (PlayBackTFActivity.this.progressDialog.isShowing()) {
                    PlayBackTFActivity.this.progressDialog.cancel();
                }
                if (!PlayBackTFActivity.this.isGet00) {
                    boolean unused3 = PlayBackTFActivity.this.isGet00 = true;
                    NativeCaller.TransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 2000), 0);
                    NativeCaller.TransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 2020), 0);
                }
            } else {
                new AsyncTask<Void, Void, Void>() {
                    /* access modifiers changed from: protected */
                    public Void doInBackground(Void... voidArr) {
                        int unused = PlayBackTFActivity.this.countGet = 0;
                        for (int i = 0; i < PlayBackTFActivity.this.yearsModel.getDays().size(); i++) {
                            NativeCaller.TransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.getRecordList(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTFActivity.this.yearsModel.getDays().get(i)), 0);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }
    };
    private int nPageCount;
    private AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            long expandableListPosition = PlayBackTFActivity.this.exListView.getExpandableListPosition(i);
            final int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
            final int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
            if (packedPositionChild == -1) {
                return true;
            }
            PlayBackTFActivity playBackTFActivity = PlayBackTFActivity.this;
            String unused = playBackTFActivity.selectName = playBackTFActivity.mExAdapter.getChildFilePath(packedPositionGroup, packedPositionChild);
            final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(PlayBackTFActivity.this);
            instance.withTitle(PlayBackTFActivity.this.selectName).withMessage((CharSequence) PlayBackTFActivity.this.getString(R.string.del_sucess_title)).withEffect(Effectstype.Slidetop).setButton1Click(new View.OnClickListener() {
                public void onClick(View view) {
                    instance.dismiss();
                }
            }).setButton2Click(new View.OnClickListener() {
                public void onClick(View view) {
                    NativeCaller.TransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.SHIX_DelVideoFiles(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTFActivity.this.selectName), 0);
                    PlayBackTFActivity.this.mExAdapter.delChildFilePath(packedPositionGroup, packedPositionChild);
                    PlayBackTFActivity.this.exListView.collapseGroup(packedPositionGroup);
                    PlayBackTFActivity.this.exListView.expandGroup(packedPositionGroup);
                    Toast.makeText(PlayBackTFActivity.this, R.string.del_sucess, 0).show();
                    instance.dismiss();
                }
            }).show();
            return true;
        }
    };
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog = null;
    private Runnable runnable = new Runnable() {
        public void run() {
            if (!PlayBackTFActivity.this.successFlag) {
                PlayBackTFActivity.this.progressDialog.dismiss();
                if (PlayBackTFActivity.this.mExAdapter.getGroupCount() > 0) {
                    PlayBackTFActivity.this.exListView.setVisibility(0);
                    PlayBackTFActivity.this.tvNoVideo.setVisibility(8);
                    return;
                }
                PlayBackTFActivity.this.exListView.setVisibility(0);
                PlayBackTFActivity.this.tvNoVideo.setVisibility(8);
            }
        }
    };
    /* access modifiers changed from: private */
    public String selectName;
    private int startTime = 0;
    /* access modifiers changed from: private */
    public String strDID = null;
    private String strName = null;
    /* access modifiers changed from: private */
    public boolean successFlag = false;
    private TextView text_resolution;
    /* access modifiers changed from: private */
    public int the_group_expand_position = -1;
    /* access modifiers changed from: private */
    public TextView tvNoVideo = null;
    private TextView tvTitle = null;
    /* access modifiers changed from: private */
    public YearsModel yearsModel;

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return false;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getDataFromOther();
        setContentView(R.layout.playbacktf);
        findView();
        this.exListView.addHeaderView(new View(this));
        this.mExAdapter = new PlaybackTFAdapter(this);
        this.exListView.setAdapter(this.mExAdapter);
        this.exListView.setGroupIndicator((Drawable) null);
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.remote_video_getparams));
        this.progressDialog.show();
        this.mHandler.postDelayed(this.runnable, (long) this.TIMEOUT);
        setListener();
        this.tvTitle.setText(this.strName);
        initDate();
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PlayBackTFActivity.this, PlayBackActivity.class);
                intent.putExtra("did", PlayBackTFActivity.this.strDID);
                intent.putExtra("filepath", "1619131123");
                PlayBackTFActivity.this.startActivity(intent);
            }
        });
        NUIMainActivity.setSHIXCOMMONInterface(this);
        int i = Calendar.getInstance().get(1);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, i), 0);
        int time = (int) (new Date().getTime() / 1000);
        this.startTime = time - 604800;
        this.endTime = time;
        CommonUtil.Log(1, "SHIX startTime:" + this.startTime + "  year:" + i);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
    }

    private void initDate() {
        int i;
        int i2;
        int i3;
        Calendar instance = Calendar.getInstance();
        int i4 = instance.get(1);
        int i5 = instance.get(2);
        int i6 = instance.get(5);
        if (i6 == 1) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(instance.get(1), instance.get(2) - 1, 1);
            i3 = gregorianCalendar.get(1);
            i2 = gregorianCalendar.get(2);
            i = gregorianCalendar.getActualMaximum(5);
        } else {
            i = i6 - 1;
            i3 = i4;
            i2 = i5;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(i3, i2, i);
        GregorianCalendar gregorianCalendar3 = new GregorianCalendar(i4, i5, i6);
        Date time = gregorianCalendar2.getTime();
        Date time2 = gregorianCalendar3.getTime();
        this.startTime = (int) time.getTime();
        this.endTime = (int) time2.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.format(time);
        simpleDateFormat.format(time2);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        String stringExtra = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        String stringExtra2 = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
        Log.d("tag", "PlayBackTFActivity  strName:" + this.strName + " strDID:" + this.strDID + " strPwd:" + stringExtra + " strUser:" + stringExtra2);
    }

    private void setListener() {
        this.btnBack.setOnClickListener(this);
        this.exListView.setOnGroupCollapseListener(this);
        this.exListView.setOnGroupExpandListener(this);
        this.exListView.setOnGroupClickListener(this);
        this.exListView.setOnChildClickListener(this);
        this.exListView.setOnScrollListener(this);
        this.progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
        this.floatHeaderView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PlayBackTFActivity.this.floatHeaderView.setVisibility(8);
                PlayBackTFActivity.this.exListView.collapseGroup(PlayBackTFActivity.this.the_group_expand_position);
                PlayBackTFActivity.this.exListView.setSelectedGroup(PlayBackTFActivity.this.the_group_expand_position);
            }
        });
    }

    private void findView() {
        this.exListView = (ExpandableListView) findViewById(R.id.listview);
        this.btnBack = (Button) findViewById(R.id.back);
        this.tvNoVideo = (TextView) findViewById(R.id.no_video);
        this.tvTitle = (TextView) findViewById(R.id.tv_camera_setting);
        this.floatHeaderView = (RelativeLayout) findViewById(R.id.floatHeaderView);
        this.headerImg = (ImageView) findViewById(R.id.header_img);
        this.headerTitle = (TextView) findViewById(R.id.header_tv_date);
        this.headerSum = (TextView) findViewById(R.id.header_tv_sum);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        this.selectName = this.mExAdapter.getChildFilePath(i, i2);
        Intent intent = new Intent(this, PlayBackActivity.class);
        intent.putExtra("did", this.strDID);
        intent.putExtra("filepath", this.selectName);
        startActivity(intent);
        return false;
    }

    public void onGroupCollapse(int i) {
        this.expandGroup.remove(Integer.valueOf(i));
        this.exListView.setSelectedGroup(i);
        this.count_expand = this.expandGroup.size();
        Log.d("tag", "count_expand:" + this.count_expand);
    }

    public void onGroupExpand(int i) {
        this.the_group_expand_position = i;
        Log.d("tag", "the_group_expand_position:" + this.the_group_expand_position);
        this.expandGroup.put(Integer.valueOf(i), Integer.valueOf(i));
        Log.d("tag", "expandGroup.size:" + this.expandGroup.size());
        this.count_expand = this.expandGroup.size();
        Log.d("tag", "count_expand:" + this.count_expand);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Log.d("tag", "onScroll: 1");
        if (i == 0) {
            this.floatHeaderView.setVisibility(8);
        }
        Log.d("tag", "onScroll: 2");
        int pointToPosition = absListView.pointToPosition(0, 0);
        if (pointToPosition != -1) {
            Log.d("tag", "onScroll: 3");
            long expandableListPosition = this.exListView.getExpandableListPosition(pointToPosition);
            int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
            if (packedPositionChild == -1) {
                Log.d("tag", "onScroll: 4");
                ExpandableListView expandableListView = this.exListView;
                this.indicatorGroupHeight = expandableListView.getChildAt(pointToPosition - expandableListView.getFirstVisiblePosition()).getHeight();
            }
            Log.d("tag", "onScroll: 5");
            if (this.indicatorGroupHeight == 0) {
                Log.d("tag", "onScroll: 6");
                return;
            }
            Log.d("tag", "onScroll: 7");
            if (this.count_expand > 0) {
                Log.d("tag", "onScroll: 8");
                this.the_group_expand_position = packedPositionGroup;
                String[] groupTitleAndSum = this.mExAdapter.getGroupTitleAndSum(this.the_group_expand_position);
                this.headerTitle.setText(groupTitleAndSum[0]);
                this.headerSum.setText(groupTitleAndSum[1]);
                if (this.the_group_expand_position != packedPositionGroup || !this.exListView.isGroupExpanded(packedPositionGroup)) {
                    this.floatHeaderView.setVisibility(8);
                    Log.d("tag", "onScroll: 9");
                } else {
                    Log.d("tag", "onScroll: 10");
                    this.floatHeaderView.setVisibility(0);
                }
            }
            Log.d("tag", "onScroll: 11");
            if (this.count_expand == 0) {
                Log.d("tag", "onScroll: 12");
                this.floatHeaderView.setVisibility(8);
            }
        }
        Log.d("tag", "onScroll: 13");
        if (this.the_group_expand_position == -1) {
            Log.d("tag", "onScroll: 14");
            return;
        }
        Log.d("tag", "onScroll: 15");
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.floatHeaderView.getLayoutParams();
        marginLayoutParams.topMargin = -(this.indicatorGroupHeight - height);
        this.floatHeaderView.setLayoutParams(marginLayoutParams);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    private int getHeight() {
        int i = this.indicatorGroupHeight;
        int pointToPosition = this.exListView.pointToPosition(0, i);
        if (pointToPosition == -1 || ExpandableListView.getPackedPositionGroup(this.exListView.getExpandableListPosition(pointToPosition)) == this.the_group_expand_position) {
            return i;
        }
        ExpandableListView expandableListView = this.exListView;
        return expandableListView.getChildAt(pointToPosition - expandableListView.getFirstVisiblePosition()).getTop();
    }

    public void callBackRecordFileSearchResult(String str, String str2, int i, int i2, int i3) {
        Log.d("tag", "CallBack_RecordFileSearchResult");
        this.nPageCount = i2;
        if (this.strDID.equals(str)) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 110;
            Bundle bundle = new Bundle();
            bundle.putString(ImagePagerActivity.FILENAME, str2);
            obtainMessage.setData(bundle);
            this.mHandler.sendMessage(obtainMessage);
            if (i3 == 1) {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        int i;
        JSONArray jSONArray;
        CommonUtil.Log(1, "CallBackSHIXJasonCommon:" + str2);
        if (this.strDID.equals(str)) {
            int i2 = 0;
            try {
                i = new JSONObject(str2).getInt("cmd");
            } catch (JSONException e) {
                e.printStackTrace();
                i = 0;
            }
            if (i == 205) {
                try {
                    this.yearsModel = YearsModel.jsonToModel(str2);
                    this.mHandler.sendEmptyMessage(2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (i == 206) {
                this.countGet++;
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
                                    if (this.strDID.equals(str)) {
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
                        }
                    } else {
                        while (i2 < i3) {
                            String string = jSONObject.getString("record_name[" + i2 + "]");
                            if (this.strDID.equals(str)) {
                                Message obtainMessage2 = this.mHandler.obtainMessage();
                                obtainMessage2.what = 110;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(ImagePagerActivity.FILENAME, string);
                                obtainMessage2.setData(bundle2);
                                this.mHandler.sendMessage(obtainMessage2);
                            }
                            i2++;
                        }
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            YearsModel yearsModel2 = this.yearsModel;
            if (yearsModel2 != null && yearsModel2.getDays() != null && this.countGet == this.yearsModel.getDays().size()) {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }
}
