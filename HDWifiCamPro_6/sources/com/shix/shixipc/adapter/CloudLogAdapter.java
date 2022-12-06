package com.shix.shixipc.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.activity.CloudLogActivity;
import com.shix.shixipc.bean.CloudBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import java.io.File;
import java.util.ArrayList;

public class CloudLogAdapter extends BaseAdapter {
    /* access modifiers changed from: private */
    public CloudLogActivity alarmLogActivity;
    /* access modifiers changed from: private */
    public ArrayList<CloudBean> arrayList = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public long getItemId(int i) {
        return (long) i;
    }

    public CloudLogAdapter(Context context2, CloudLogActivity cloudLogActivity) {
        this.context = context2;
        this.inflater = LayoutInflater.from(context2);
        this.alarmLogActivity = cloudLogActivity;
    }

    public ArrayList<CloudBean> getBeans() {
        return this.arrayList;
    }

    public void removeItem(int i) {
        if (i < this.arrayList.size()) {
            this.arrayList.remove(i);
            notifyDataSetChanged();
        }
    }

    public void removeAll() {
        this.arrayList.clear();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.arrayList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.cloud_listitem, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.content = (TextView) view.findViewById(R.id.alarm_log_content);
            viewHolder.createTime = (TextView) view.findViewById(R.id.alarm_log_time);
            viewHolder.button_check_pic = (ImageButton) view.findViewById(R.id.button_check_pic);
            viewHolder.tv_type = (TextView) view.findViewById(R.id.alarm_log_left);
            viewHolder.im_del = (ImageView) view.findViewById(R.id.im_del);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        CloudBean cloudBean = this.arrayList.get(i);
        String str = CommonUtil.getSDFilePath() + "/" + ContentCommon.SDCARD_PATH + "/cloud/" + cloudBean.getStrDid() + cloudBean.getFileName();
        if (new File(str).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    viewHolder.button_check_pic.setImageBitmap(decodeFile);
                } else {
                    viewHolder.button_check_pic.setImageResource(R.mipmap.play_set_setting_picture_press);
                }
            } catch (Exception unused) {
                viewHolder.button_check_pic.setImageResource(R.mipmap.play_set_setting_picture_press);
            }
        } else {
            viewHolder.button_check_pic.setImageResource(R.mipmap.play_set_setting_picture_press);
        }
        viewHolder.button_check_pic.setOnClickListener(new MyOnClickListener(i));
        viewHolder.im_del.setOnClickListener(new MyDelOnClickListener(i));
        cloudBean.getType();
        viewHolder.tv_type.setText(R.string.doorbell_alerm);
        viewHolder.createTime.setText(cloudBean.getCreateTime());
        viewHolder.content.setOnLongClickListener(new MyOnLongListener(i));
        return view;
    }

    private class MyDelOnClickListener implements View.OnClickListener {
        CloudBean alarmLogBean1;
        private int position;

        public MyDelOnClickListener(int i) {
            this.position = i;
            this.alarmLogBean1 = (CloudBean) CloudLogAdapter.this.arrayList.get(i);
        }

        public void onClick(View view) {
            CloudLogAdapter.this.alarmLogActivity.ShowDel(this.position, this.alarmLogBean1.getStrDid(), this.alarmLogBean1.getCloudPath(), this.alarmLogBean1.getCreateTime());
        }
    }

    private class MyOnClickListener implements View.OnClickListener {
        CloudBean alarmLogBean1;
        private int position;

        public MyOnClickListener(int i) {
            this.position = i;
            this.alarmLogBean1 = (CloudBean) CloudLogAdapter.this.arrayList.get(i);
        }

        public void onClick(View view) {
            CloudLogAdapter.this.alarmLogActivity.showPic(this.position, this.alarmLogBean1.getStrDid(), this.alarmLogBean1.getFileName(), this.alarmLogBean1.getCreateTime(), this.alarmLogBean1.getCloudPath(), (String) null, this.alarmLogBean1.getType());
        }
    }

    public void addAlarmLog(CloudBean cloudBean) {
        int i = 0;
        while (i < this.arrayList.size()) {
            if (!this.arrayList.get(i).getFileName().equals(cloudBean.getFileName())) {
                i++;
            } else {
                return;
            }
        }
        this.arrayList.add(0, cloudBean);
    }

    public void clearAllAlarmLog() {
        this.arrayList.clear();
    }

    private class MyOnLongListener implements View.OnLongClickListener {
        private int position;

        public boolean onLongClick(View view) {
            return false;
        }

        public MyOnLongListener(int i) {
            this.position = i;
        }
    }

    private class ViewHolder {
        ImageButton button_check_pic;
        TextView content;
        TextView createTime;
        ImageView im_del;
        TextView tv_type;

        private ViewHolder() {
        }
    }
}
