package shix.ihdbell.project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import object.p2pipcam.adapter.LocalPictureAdapter;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.utils.DataBaseHelper;

public class LocalPictureListActivity extends BaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private String TAG = "LocalPictureActivity";
    private TextView back;
    private String cameraName;
    private Map<String, ArrayList<String>> childMap;
    private List<String> groupList;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 2) {
                LocalPictureListActivity.this.mAdapter.setOver(true);
            }
            LocalPictureListActivity.this.mAdapter.notifyDataSetChanged();
        }
    };
    private DataBaseHelper helper;
    private boolean isFirstStart = false;
    /* access modifiers changed from: private */
    public LocalPictureAdapter mAdapter;
    private ListView mListView;
    private String strDID;
    private TextView tvCameraName;
    private TextView tvNoPicture;
    private int wh;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        if (width > height) {
            width = height;
        }
        this.wh = width;
        setContentView(R.layout.local_picture);
        this.helper = DataBaseHelper.getInstance(this);
        this.groupList = new ArrayList();
        this.childMap = new HashMap();
        findView();
        this.tvCameraName.setText(this.cameraName);
        if (hasSdcard()) {
            initData();
        }
        this.mAdapter = new LocalPictureAdapter(this, this.groupList, this.childMap, this.wh / 5);
        this.mAdapter.setMode(1);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this);
        SetTab(this);
        Log.d("tag", "onCreate end");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (this.isFirstStart) {
            if (hasSdcard()) {
                initData();
            }
            this.mAdapter.updateGroup(this.groupList);
            this.mAdapter.updateChild(this.childMap);
            this.mAdapter.initBmp();
        } else {
            this.isFirstStart = true;
        }
        if (this.groupList.size() > 0) {
            Log.d("tag", "groupList.size():" + this.groupList.size());
            this.tvNoPicture.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(8);
        this.tvNoPicture.setVisibility(0);
    }

    private void findView() {
        this.mListView = (ListView) findViewById(R.id.localpic_listview);
        this.tvNoPicture = (TextView) findViewById(R.id.localpic_tv_nopic);
        this.tvCameraName = (TextView) findViewById(R.id.tv_title);
        this.back = (TextView) findViewById(R.id.back);
        this.back.setOnClickListener(this);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        Log.d("tag", "strDID:" + this.strDID + " cameraName:" + this.cameraName);
    }

    private void initData() {
        this.groupList.clear();
        this.childMap.clear();
        Cursor queryAllPicture = this.helper.queryAllPicture(this.strDID);
        while (queryAllPicture.moveToNext()) {
            String string = queryAllPicture.getString(queryAllPicture.getColumnIndex(DataBaseHelper.KEY_FILEPATH));
            try {
                if (!new File(string).exists()) {
                    boolean deleteVideoOrPicture = this.helper.deleteVideoOrPicture(this.strDID, string, DataBaseHelper.TYPE_PICTURE);
                    String str = this.TAG;
                    Log.d(str, "delResult:" + deleteVideoOrPicture);
                }
            } catch (Exception unused) {
            }
            String substring = string.substring(string.lastIndexOf("/") + 1).substring(0, 10);
            if (!this.groupList.contains(substring)) {
                this.groupList.add(substring);
                ArrayList arrayList = new ArrayList();
                arrayList.add(string);
                this.childMap.put(substring, arrayList);
            } else {
                this.childMap.get(substring).add(string);
            }
        }
        Collections.sort(this.groupList, new Comparator<String>() {
            public int compare(String str, String str2) {
                return str2.compareTo(str);
            }
        });
        if (queryAllPicture != null) {
            queryAllPicture.close();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = this.groupList.get(i);
        Intent intent = new Intent(this, ShowLocalPicGridActivity.class);
        intent.putExtra(DataBaseHelper.KEY_DID, this.strDID);
        intent.putExtra("list", this.childMap.get(str));
        intent.putExtra("date", str);
        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.cameraName);
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    public void onClick(View view) {
        finish();
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.groupList.clear();
        this.groupList = null;
        this.childMap.clear();
        this.childMap = null;
        this.mAdapter = null;
    }
}
