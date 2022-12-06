package shix.ihdbell.project;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import object.p2pipcam.adapter.PlaybackTFAdapter;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.DataBaseHelper;
import shix.ihdbell.project.BridgeService;

public class PlayBackTFActivity extends BaseActivity implements View.OnClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener, AbsListView.OnScrollListener, BridgeService.PlayBackTFInterface {
    private final int PARAMS = 1;
    private int TIMEOUT = 8000;
    private Button btnBack = null;
    private int count_expand = 0;
    private long endTime = 0;
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
            } else if (i == 110) {
                String string = message.getData().getString("filename");
                if (string.length() > 8) {
                    String substring = string.substring(0, 4);
                    String substring2 = string.substring(4, 6);
                    String substring3 = string.substring(6, 8);
                    PlayBackTFActivity.this.mExAdapter.addGroupAndChild(substring + Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring3, string);
                }
                PlayBackTFActivity.this.mExAdapter.notifyDataSetChanged();
            }
        }
    };
    /* access modifiers changed from: private */
    public int nPageCount;
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
    private String selectName;
    private long startTime = 0;
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

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return false;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
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
        BridgeService.setPlayBackTFInterface(this);
        NativeCaller.PPPPGetSDCardRecordFileList(this.strDID, 0, 128);
        SetTab(this);
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
        this.startTime = time.getTime();
        this.endTime = time2.getTime();
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
        this.tvTitle = (TextView) findViewById(R.id.tv_title);
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
        BridgeService.setPlayBackTFInterface((BridgeService.PlayBackTFInterface) null);
        super.onDestroy();
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        this.selectName = this.mExAdapter.getChildFilePath(i, i2);
        Intent intent = new Intent(this, PlayBackActivity.class);
        intent.putExtra(DataBaseHelper.KEY_DID, this.strDID);
        intent.putExtra(DataBaseHelper.KEY_FILEPATH, this.selectName);
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
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
            if (!this.isFirstOn) {
                this.isFirstOn = true;
                if (this.nPageCount > 1) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            int i = 0;
                            while (i < PlayBackTFActivity.this.nPageCount - 1) {
                                i++;
                                NativeCaller.PPPPGetSDCardRecordFileList(PlayBackTFActivity.this.strDID, i, 128);
                            }
                        }
                    });
                }
            }
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 110;
            Bundle bundle = new Bundle();
            bundle.putString("filename", str2);
            obtainMessage.setData(bundle);
            this.mHandler.sendMessage(obtainMessage);
            if (i3 == 1) {
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }
}
