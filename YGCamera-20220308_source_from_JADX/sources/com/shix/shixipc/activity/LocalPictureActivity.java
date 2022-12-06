package com.shix.shixipc.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.gridview.GridItem;
import com.shix.shixipc.gridview.StickyGridAdapter;
import com.shix.shixipc.gridview.YMComparator;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.NiftyDialogBuilder;
import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import shix.cykj.camera.R;

public class LocalPictureActivity extends BaseActivity implements View.OnClickListener {
    private static final int ACTIVITY_RESULT_PHOTO_VIEW = 10;
    private static final int DEFAULT_LIST_SIZE = 20;
    public static final String EXTRA_GIRDLST = "girdlst";
    public static final String EXTRA_POSITION = "position";
    public static Activity mActivity;
    public static List<GridItem> mDeleteList = new ArrayList();
    private static int section = 1;
    final List<String> IMAGE_FILES = new ArrayList(20);
    /* access modifiers changed from: private */
    public StickyGridAdapter adapter;
    Button btnOk;
    private GridView gridview;
    /* access modifiers changed from: private */
    public boolean isDeleteModel = false;
    /* access modifiers changed from: private */
    public boolean isVideo = false;
    /* access modifiers changed from: private */
    public ArrayList<GridItem> mGirdList = new ArrayList<>();
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ImagePagerActivity.BROAD_ACTION)) {
                LocalPictureActivity.this.mGirdList.remove(intent.getIntExtra(ImagePagerActivity.INDEX, 0));
                LocalPictureActivity.this.adapter.notifyDataSetChanged();
            }
        }
    };
    private LinearLayout mll_anim;
    private Map<String, Integer> sectionMap = new HashMap();
    private String strName = "";
    /* access modifiers changed from: private */
    public String uid;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_local_picture);
        this.uid = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.strName = getIntent().getStringExtra(ContentCommon.STR_CAMERA_NAME);
        if (getIntent().getIntExtra("type", 0) == 1) {
            this.isVideo = true;
        } else {
            this.isVideo = false;
        }
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        initView();
        registerBrodCast();
        TextView textView = (TextView) findViewById(R.id.tv_camera);
        if (this.isVideo) {
            textView.setText(this.strName + "  " + getResources().getString(R.string.ipc_manager_locvideo));
        } else {
            textView.setText(this.strName + "  " + getResources().getString(R.string.local_picture));
        }
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LocalPictureActivity.this.finish();
            }
        });
        this.btnOk = (Button) findViewById(R.id.ok);
        this.btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LocalPictureActivity.mDeleteList.clear();
                if (LocalPictureActivity.this.isDeleteModel) {
                    LocalPictureActivity.this.btnOk.setText(R.string.door_white_list_edit);
                    LocalPictureActivity.this.adapter.setDelMode(0);
                    LocalPictureActivity localPictureActivity = LocalPictureActivity.this;
                    localPictureActivity.loadAnimation((float) CommonUtil.dip2px(localPictureActivity, 50.0f));
                    boolean unused = LocalPictureActivity.this.isDeleteModel = false;
                    return;
                }
                LocalPictureActivity.this.btnOk.setText(R.string.done);
                LocalPictureActivity localPictureActivity2 = LocalPictureActivity.this;
                localPictureActivity2.loadAnimation((float) CommonUtil.dip2px(localPictureActivity2, -50.0f));
                LocalPictureActivity.this.adapter.setDelMode(1);
                boolean unused2 = LocalPictureActivity.this.isDeleteModel = true;
            }
        });
    }

    private void initView() {
        File file;
        this.mGirdList.clear();
        initTopView();
        if (this.isVideo) {
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + this.uid + "/");
        } else {
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/Snapshot/" + this.uid + "/");
        }
        setImagesPath(file.getAbsolutePath());
        removeCorruptImage();
        this.gridview = (GridView) findViewById(R.id.asset_grid);
        Collections.sort(this.mGirdList, new YMComparator());
        ListIterator<GridItem> listIterator = this.mGirdList.listIterator();
        while (listIterator.hasNext()) {
            GridItem next = listIterator.next();
            String time = next.getTime();
            if (!this.sectionMap.containsKey(time)) {
                next.setSection(section);
                this.sectionMap.put(time, Integer.valueOf(section));
                section++;
            } else {
                next.setSection(this.sectionMap.get(time).intValue());
            }
        }
        this.adapter = new StickyGridAdapter(this, this.mGirdList, this.gridview, this.isVideo);
        this.gridview.setAdapter(this.adapter);
        this.gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Uri uri;
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(LocalPictureActivity.this, 10);
                }
                if (i >= 0) {
                    if (LocalPictureActivity.this.isDeleteModel) {
                        CheckBox checkBox = (CheckBox) view.findViewById(R.id.grid_cb);
                        checkBox.setChecked(!checkBox.isChecked());
                        if (checkBox.isChecked()) {
                            LocalPictureActivity.mDeleteList.add(LocalPictureActivity.this.mGirdList.get(i));
                        } else {
                            LocalPictureActivity.mDeleteList.remove(LocalPictureActivity.this.mGirdList.get(i));
                        }
                        LocalPictureActivity.this.adapter.checks[i] = checkBox.isChecked();
                    } else if (LocalPictureActivity.this.isVideo) {
                        String replace = ((GridItem) LocalPictureActivity.this.mGirdList.get(i)).getPath().replace("IMG_", "").replace("videohead", "video").replace("jpg", "avi");
                        String str = "file://" + replace;
                        CommonUtil.Log(1, "zhaogenghuaipath:" + replace);
                        Intent intent = new Intent("android.intent.action.VIEW");
                        Uri.parse(str);
                        if (Build.VERSION.SDK_INT <= 23) {
                            uri = Uri.parse(str);
                        } else {
                            intent.setFlags(1);
                            uri = FileProvider.getUriForFile(LocalPictureActivity.this, "com.shix.qhipc.provider", new File(replace));
                        }
                        CommonUtil.Log(1, "SHIXURL   :" + uri.toString());
                        intent.setDataAndType(uri, "video/*");
                        LocalPictureActivity.this.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.setClass(LocalPictureActivity.this, ImagePagerActivity.class);
                        intent2.putExtra(ContentCommon.STR_CAMERA_ID, LocalPictureActivity.this.uid);
                        intent2.putParcelableArrayListExtra("girdlst", LocalPictureActivity.this.mGirdList);
                        intent2.putExtra("position", i);
                        LocalPictureActivity.this.startActivityForResult(intent2, 10);
                    }
                }
            }
        });
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
        if (view.getId() == R.id.ll_anim) {
            if (mDeleteList.size() <= 0) {
                showToast(getString(R.string.tip_delete_snap));
                return;
            }
            final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(this);
            instance.withMessage((CharSequence) getString(R.string.tips_msg_delete_snapshot)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() {
                public void onClick(View view) {
                    instance.dismiss();
                }
            }).setButton2Click(new View.OnClickListener() {
                public void onClick(View view) {
                    instance.dismiss();
                    for (GridItem path : LocalPictureActivity.mDeleteList) {
                        new File(path.getPath()).delete();
                    }
                    LocalPictureActivity.this.mGirdList.removeAll(LocalPictureActivity.mDeleteList);
                    for (int i = 0; i < LocalPictureActivity.this.adapter.checks.length - LocalPictureActivity.mDeleteList.size(); i++) {
                        LocalPictureActivity.this.adapter.checks[i] = false;
                    }
                    LocalPictureActivity.this.adapter.notifyDataSetChanged();
                    LocalPictureActivity.mDeleteList.clear();
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
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }
}
