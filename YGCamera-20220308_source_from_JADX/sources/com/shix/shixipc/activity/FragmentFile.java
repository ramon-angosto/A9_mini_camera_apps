package com.shix.shixipc.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.gridview.GridItem;
import com.shix.shixipc.gridview.StickyGridAdapter;
import com.shix.shixipc.gridview.YMComparator;
import com.shix.shixipc.system.ContentCommon;
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

public class FragmentFile extends BaseFragment implements View.OnClickListener {
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
    private Button bntPhone;
    private Button bntRemote;
    Button btnOk;
    private GridView gridview;
    /* access modifiers changed from: private */
    public boolean isDeleteModel = false;
    /* access modifiers changed from: private */
    public boolean isVideo = false;
    /* access modifiers changed from: private */
    public ArrayList<GridItem> mGirdList = new ArrayList<>();
    private LinearLayout mll_anim;
    private Map<String, Integer> sectionMap = new HashMap();
    /* access modifiers changed from: private */
    public String strName = "";
    int tag = 0;
    /* access modifiers changed from: private */
    public String uid = ContentCommon.SAVEFILES;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_file, viewGroup, false);
        this.gridview = (GridView) inflate.findViewById(R.id.asset_grid);
        this.mll_anim = (LinearLayout) inflate.findViewById(R.id.ll_anim);
        this.mll_anim.setOnClickListener(this);
        this.bntPhone = (Button) inflate.findViewById(R.id.picture_phone);
        this.bntRemote = (Button) inflate.findViewById(R.id.picture_remote);
        this.bntPhone.setOnClickListener(this);
        this.bntRemote.setOnClickListener(this);
        this.btnOk = (Button) inflate.findViewById(R.id.ok);
        this.btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentFile.mDeleteList.clear();
                if (FragmentFile.this.isDeleteModel) {
                    FragmentFile.this.btnOk.setText(R.string.door_white_list_edit);
                    FragmentFile.this.adapter.setDelMode(0);
                    FragmentFile fragmentFile = FragmentFile.this;
                    fragmentFile.loadAnimation((float) CommonUtil.dip2px(fragmentFile.getActivity(), 50.0f));
                    boolean unused = FragmentFile.this.isDeleteModel = false;
                    return;
                }
                FragmentFile.this.btnOk.setText(R.string.done);
                FragmentFile fragmentFile2 = FragmentFile.this;
                fragmentFile2.loadAnimation((float) CommonUtil.dip2px(fragmentFile2.getActivity(), -50.0f));
                FragmentFile.this.adapter.setDelMode(1);
                boolean unused2 = FragmentFile.this.isDeleteModel = true;
            }
        });
        this.gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(FragmentFile.this.getActivity(), 10);
                }
                if (i >= 0) {
                    if (FragmentFile.this.isDeleteModel) {
                        CheckBox checkBox = (CheckBox) view.findViewById(R.id.grid_cb);
                        checkBox.setChecked(!checkBox.isChecked());
                        if (checkBox.isChecked()) {
                            FragmentFile.mDeleteList.add(FragmentFile.this.mGirdList.get(i));
                        } else {
                            FragmentFile.mDeleteList.remove(FragmentFile.this.mGirdList.get(i));
                        }
                        FragmentFile.this.adapter.checks[i] = checkBox.isChecked();
                    } else if (FragmentFile.this.isVideo) {
                        String replace = ((GridItem) FragmentFile.this.mGirdList.get(i)).getPath().replace("IMG_", "").replace("videohead", "video").replace("jpg", "mp5");
                        new Intent("android.intent.action.VIEW");
                        Intent intent = new Intent(FragmentFile.this.getActivity(), ShowLocalVideoActivity.class);
                        intent.putExtra("filepath", replace);
                        intent.putExtra(ContentCommon.STR_CAMERA_NAME, FragmentFile.this.strName);
                        FragmentFile.this.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.setClass(FragmentFile.this.getActivity(), ImagePagerActivity.class);
                        intent2.putExtra(ContentCommon.STR_CAMERA_ID, FragmentFile.this.uid);
                        intent2.putParcelableArrayListExtra("girdlst", FragmentFile.this.mGirdList);
                        intent2.putExtra("position", i);
                        FragmentFile.this.startActivityForResult(intent2, 10);
                    }
                }
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public void loadAnimation(float f) {
        float translationY = this.mll_anim.getTranslationY();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mll_anim, "translationY", new float[]{translationY, f});
        ofFloat.setDuration(250);
        ofFloat.start();
    }

    private void initView() {
        File file;
        CommonUtil.Log(1, "zhaogenghuai   initView");
        this.mGirdList.clear();
        if (this.isVideo) {
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + ContentCommon.SAVEFILES + "/");
        } else {
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/Snapshot/" + ContentCommon.SAVEFILES + "/");
        }
        setImagesPath(file.getAbsolutePath());
        removeCorruptImage();
        CommonUtil.Log(1, "zhaogenghuai   initView1");
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
        this.adapter = new StickyGridAdapter(getActivity(), this.mGirdList, this.gridview, this.isVideo);
        this.gridview.setAdapter(this.adapter);
        CommonUtil.Log(1, "zhaogenghuai   initView2");
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

    public void onResume() {
        super.onResume();
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10);
        }
        switch (view.getId()) {
            case R.id.ll_anim /*2131165617*/:
                if (mDeleteList.size() <= 0) {
                    showToast(getString(R.string.tip_delete_snap));
                    return;
                }
                final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(getActivity());
                instance.withMessage((CharSequence) getString(R.string.tips_msg_delete_snapshot)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() {
                    public void onClick(View view) {
                        instance.dismiss();
                    }
                }).setButton2Click(new View.OnClickListener() {
                    public void onClick(View view) {
                        instance.dismiss();
                        for (GridItem path : FragmentFile.mDeleteList) {
                            new File(path.getPath()).delete();
                        }
                        FragmentFile.this.mGirdList.removeAll(FragmentFile.mDeleteList);
                        for (int i = 0; i < FragmentFile.this.adapter.checks.length - FragmentFile.mDeleteList.size(); i++) {
                            FragmentFile.this.adapter.checks[i] = false;
                        }
                        FragmentFile.this.adapter.notifyDataSetChanged();
                        FragmentFile.mDeleteList.clear();
                    }
                }).show();
                return;
            case R.id.picture_phone /*2131165690*/:
                this.tag = 0;
                this.bntPhone.setBackgroundResource(R.mipmap.checktopleft_pressed);
                this.bntRemote.setBackgroundResource(R.mipmap.checkright_normal);
                this.bntPhone.setTextColor(getResources().getColor(R.color.color_white));
                this.bntRemote.setTextColor(getResources().getColor(R.color.color_black));
                this.isVideo = false;
                initView();
                return;
            case R.id.picture_remote /*2131165691*/:
                this.tag = 1;
                this.bntRemote.setBackgroundResource(R.mipmap.checkright_pressed);
                this.bntPhone.setBackgroundResource(R.mipmap.checkleft_normal);
                this.bntRemote.setTextColor(getResources().getColor(R.color.color_white));
                this.bntPhone.setTextColor(getResources().getColor(R.color.color_black));
                this.isVideo = true;
                initView();
                return;
            default:
                return;
        }
    }
}
