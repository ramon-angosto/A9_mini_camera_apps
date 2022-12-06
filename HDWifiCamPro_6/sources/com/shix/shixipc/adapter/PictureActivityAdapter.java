package com.shix.shixipc.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.SystemValue;
import java.util.ArrayList;

public class PictureActivityAdapter extends BaseAdapter {
    public final int PHONE = 1;
    public final int REMOTE = 2;
    private Context context;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private boolean isOver = false;
    public int mode = 1;

    public void addBmpAndSum(Bitmap bitmap, int i) {
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public PictureActivityAdapter(Context context2, ArrayList<CameraParamsBean> arrayList) {
        this.context = context2;
        this.inflater = LayoutInflater.from(context2);
    }

    public int getCount() {
        return SystemValue.arrayList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = this.inflater.inflate(R.layout.picturevideo_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.name = (TextView) view.findViewById(R.id.tv_name);
            this.holder.id = (TextView) view.findViewById(R.id.tv_did);
            this.holder.status = (TextView) view.findViewById(R.id.tv_status);
            this.holder.number = (TextView) view.findViewById(R.id.tv_pic_num);
            this.holder.pic = (ImageView) view.findViewById(R.id.pic);
            this.holder.pBar = (ProgressBar) view.findViewById(R.id.progressBar1);
            this.holder.frame = view.findViewById(R.id.frame);
            this.holder.imgSnapShot = (ImageView) view.findViewById(R.id.imgSnapshot);
            this.holder.cameralistrootview = (RelativeLayout) view.findViewById(R.id.cameralistrootview);
            this.holder.arrow = (ImageView) view.findViewById(R.id.arrow);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
        TextView textView = this.holder.number;
        textView.setText("(" + 0 + ")");
        String dev_Did = cameraParamsBean.getDev_Did();
        String dev_name = cameraParamsBean.getDev_name();
        switch (cameraParamsBean.getDev_p2pstatus()) {
            case 0:
                i2 = R.string.pppp_status_connecting;
                break;
            case 1:
                i2 = R.string.pppp_status_initialing;
                break;
            case 2:
                i2 = R.string.pppp_status_online;
                break;
            case 3:
                i2 = R.string.pppp_status_connect_failed;
                break;
            case 4:
                i2 = R.string.pppp_status_disconnect;
                break;
            case 5:
                i2 = R.string.pppp_status_invalid_id;
                break;
            case 6:
                i2 = R.string.device_not_on_line;
                break;
            case 7:
                i2 = R.string.pppp_status_connect_timeout;
                break;
            default:
                i2 = R.string.pppp_status_unknown;
                break;
        }
        this.holder.status.setText(this.context.getResources().getString(i2));
        this.holder.id.setText(dev_Did);
        this.holder.name.setText(dev_name);
        int i3 = this.mode;
        if (i3 == 1) {
            this.holder.number.setVisibility(0);
            this.holder.status.setVisibility(8);
            this.holder.frame.setVisibility(0);
        } else if (i3 == 2) {
            this.holder.number.setVisibility(8);
            this.holder.status.setVisibility(0);
            this.holder.frame.setVisibility(8);
        }
        return view;
    }

    public void setOver(boolean z) {
        this.isOver = z;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public int getMode() {
        return this.mode;
    }

    private class ViewHolder {
        ImageView arrow;
        RelativeLayout cameralistrootview;
        View frame;
        TextView id;
        ImageView imgSnapShot;
        TextView name;
        TextView number;
        ProgressBar pBar;
        ImageView pic;
        TextView status;

        private ViewHolder() {
        }
    }
}
