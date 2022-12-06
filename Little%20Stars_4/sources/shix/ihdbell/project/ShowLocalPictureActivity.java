package shix.ihdbell.project;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.Upload;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import object.p2pipcam.adapter.ShowLocPicGalleryAdapter;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.customComponent.MyGallery;
import object.p2pipcam.utils.DataBaseHelper;

public class ShowLocalPictureActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, MyGallery.MyGalleryEvent {
    private static final int MSG_UPLOAD_FILE = 2;
    private static ArrayList<Map<String, Object>> arrayList;
    private static DeletePicInterface deletePicInterface;
    public static int screenHeight;
    public static int screenWidth;
    private final int DELETE = 0;
    private final int DELETEALL = 1;
    private String TAG = "ShowLocalPictureActivity";
    float afterLenght = 0.0f;
    float beforeLenght = 0.0f;
    private RelativeLayout bottomLayout;
    private ImageView btnUpload;
    float currentScale = 1.0f;
    private ArrayList<String> delList;
    private DataBaseHelper helper;
    boolean isScale = false;
    /* access modifiers changed from: private */
    public boolean isShowing = false;
    private ShowLocPicGalleryAdapter mAdapter;
    private MyGallery mGallery;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                boolean unused = ShowLocalPictureActivity.this.isShowing = false;
            } else if (i == 2) {
                ShowLocalPictureActivity.this.mView.setVisibility(4);
                ShowLocalPictureActivity showLocalPictureActivity = ShowLocalPictureActivity.this;
                showLocalPictureActivity.showToast(showLocalPictureActivity.getResources().getString(R.string.upload_file_success));
            }
        }
    };
    private TextView mTv_Sum;
    private TextView mTv_TakeDate;
    private TextView mTv_TakeTime;
    private Upload mUpload = null;
    /* access modifiers changed from: private */
    public View mView = null;
    private int position;
    private String strCameraName;
    private String strDID;
    private String strDate;
    private String strSlected = "";
    private RelativeLayout topLayout;
    private TextView tvBack;
    private TextView tvNoPics;
    private TextView tvTitle;
    private float x1 = 0.0f;
    private float x2 = 0.0f;
    private float y1 = 0.0f;
    private float y2 = 0.0f;

    public interface DeletePicInterface {
        void delPic(String str, boolean z);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public static void setDeletePicInterface(DeletePicInterface deletePicInterface2) {
        deletePicInterface = deletePicInterface2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.showlocalpicture);
        screenWidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        screenHeight = getWindow().getWindowManager().getDefaultDisplay().getHeight();
        this.helper = DataBaseHelper.getInstance(this);
        findView();
        this.mAdapter = new ShowLocPicGalleryAdapter(this, arrayList);
        this.mGallery.setVerticalFadingEdgeEnabled(false);
        this.mGallery.setHorizontalFadingEdgeEnabled(false);
        this.mGallery.setAdapter(this.mAdapter);
        this.mGallery.setOnItemSelectedListener(this);
        this.mGallery.setOnCreateContextMenuListener(this);
        this.mGallery.setMyTouch(this);
        this.mGallery.setSelection(this.position);
        TextView textView = this.tvTitle;
        textView.setText(this.strCameraName + " " + getResources().getString(R.string.main_pic));
        this.mTv_TakeDate.setText(this.strDate);
        TextView textView2 = this.mTv_Sum;
        textView2.setText((this.position + 1) + "/" + arrayList.size());
        this.mHandler.sendEmptyMessageDelayed(1, 1500);
        this.mView = initView(R.layout.loading);
        this.mView.setVisibility(4);
        this.mUpload = new Upload(this);
        this.delList = new ArrayList<>();
    }

    public View initView(int i) {
        View inflate = View.inflate(this, i, (ViewGroup) null);
        if (inflate == null) {
            return null;
        }
        addContentView(inflate, new FrameLayout.LayoutParams(-1, -1));
        return inflate;
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        if (intent != null) {
            Log.d("tag", "intent!=null");
            this.strDID = intent.getStringExtra(DataBaseHelper.KEY_DID);
            this.strDate = intent.getStringExtra("date");
            this.strCameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.position = intent.getIntExtra(RequestParameters.POSITION, 0);
            arrayList = (ArrayList) intent.getSerializableExtra("list");
            return;
        }
        Log.d("tag", "intent==null");
    }

    private void findView() {
        this.mGallery = (MyGallery) findViewById(R.id.showlocalpic_gallery);
        this.btnUpload = (ImageView) findViewById(R.id.btnUpload);
        this.btnUpload.setOnClickListener(this);
        this.mTv_TakeTime = (TextView) findViewById(R.id.takepic_time);
        this.mTv_TakeDate = (TextView) findViewById(R.id.takepic_date);
        this.mTv_Sum = (TextView) findViewById(R.id.picdesc);
        this.tvBack = (TextView) findViewById(R.id.back);
        this.tvTitle = (TextView) findViewById(R.id.takepic_title);
        this.tvNoPics = (TextView) findViewById(R.id.localpic_tv_nopic);
        this.tvBack.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            Intent intent = new Intent();
            intent.putExtra("dellist", this.delList);
            setResult(1, intent);
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        } else if (id == R.id.btnUpload) {
            this.mView.setVisibility(0);
            this.mUpload.uploadImg(new File(this.strSlected));
            this.mHandler.sendEmptyMessageDelayed(2, 800);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mView.setVisibility(4);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("dellist", this.delList);
            setResult(1, intent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private String getContent(String str) {
        return str.substring(str.lastIndexOf("/") + 1).substring(11, 19).replace("_", ":");
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.position = i;
        this.strSlected = (String) arrayList.get(i).get("path");
        this.mTv_TakeTime.setText(getContent(this.strSlected));
        TextView textView = this.mTv_Sum;
        textView.setText((i + 1) + "/" + arrayList.size());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ArrayList<Map<String, Object>> arrayList2 = arrayList;
        if (arrayList2 != null) {
            arrayList2.clear();
            arrayList = null;
        }
        ArrayList<String> arrayList3 = this.delList;
        if (arrayList3 != null) {
            arrayList3.clear();
            this.delList = null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mAdapter = null;
        this.mAdapter = new ShowLocPicGalleryAdapter(this, arrayList);
        this.mGallery.setVerticalFadingEdgeEnabled(false);
        this.mGallery.setHorizontalFadingEdgeEnabled(false);
        this.mGallery.setAdapter(this.mAdapter);
        this.mGallery.setOnItemSelectedListener(this);
        this.mGallery.setOnCreateContextMenuListener(this);
        this.mGallery.setMyTouch(this);
        this.mGallery.setSelection(this.position);
    }

    public void myTouch(MotionEvent motionEvent) {
        Log.d("tgg", "ShowLoc myTouch ");
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            Log.d("tgg", "ShowLoc down ");
            this.x1 = motionEvent.getX();
            this.y1 = motionEvent.getY();
        } else if (action == 1) {
            Log.d("tgg", "ShowLoc up ");
            if (Math.abs(this.x1 - this.x2) >= 25.0f || Math.abs(this.y1 - this.y2) >= 25.0f) {
                Log.d("tgg", "ShowLoc up fling ");
                return;
            }
            Log.d("tgg", "ShowLoc 111 ");
            if (this.isShowing) {
                Log.d("tgg", "ShowLoc 222");
                this.isShowing = false;
                return;
            }
            Log.d("tgg", "ShowLoc 333 ");
            this.isShowing = true;
        } else if (action != 2) {
            Log.d("tgg", "ShowLoc default");
        } else {
            Log.d("tgg", "ShowLoc move ");
            this.x2 = motionEvent.getX();
            this.y2 = motionEvent.getY();
        }
    }
}
