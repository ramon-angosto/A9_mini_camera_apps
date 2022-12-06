package com.shix.shixipc.gridview;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.hichip.widget.stickygridheaders.StickyGridHeadersSimpleAdapter;
import com.shix.shixipc.gridview.MyImageView;
import java.util.List;
import shix.cykj.camera.R;

public class StickyGridAdapter extends BaseAdapter implements StickyGridHeadersSimpleAdapter {
    public boolean[] checks;
    int delMode;
    private boolean isVideo = false;
    private List<GridItem> list;
    private Context mContext;
    private GridView mGridView;
    private LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public Point mPoint = new Point(0, 0);

    public static class HeaderViewHolder {
        public TextView mTextView;
    }

    public static class ViewHolder {
        public CheckBox grid_cb;
        public ImageView img_video;
        public MyImageView mImageView;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public StickyGridAdapter(Context context, List<GridItem> list2, GridView gridView, boolean z) {
        this.list = list2;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mGridView = gridView;
        this.checks = new boolean[list2.size()];
        this.isVideo = z;
    }

    public void setDelMode(int i) {
        this.delMode = i;
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.checks;
            if (i2 < zArr.length) {
                zArr[i2] = false;
                i2++;
            } else {
                notifyDataSetChanged();
                return;
            }
        }
    }

    public int getDelMode() {
        return this.delMode;
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int i) {
        return this.list.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.mInflater.inflate(R.layout.grid_item, viewGroup, false);
            viewHolder.mImageView = (MyImageView) view2.findViewById(R.id.grid_item);
            viewHolder.grid_cb = (CheckBox) view2.findViewById(R.id.grid_cb);
            viewHolder.img_video = (ImageView) view2.findViewById(R.id.img_video);
            view2.setTag(viewHolder);
            viewHolder.mImageView.setOnMeasureListener(new MyImageView.OnMeasureListener() {
                public void onMeasureSize(int i, int i2) {
                    StickyGridAdapter.this.mPoint.set(i, i2);
                }
            });
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.grid_cb.setChecked(this.checks[i]);
        if (this.isVideo) {
            viewHolder.img_video.setVisibility(0);
        } else {
            viewHolder.img_video.setVisibility(8);
        }
        Glide.with(this.mContext).load(this.list.get(i).getPath()).into(viewHolder.mImageView);
        if (this.delMode == 1) {
            viewHolder.grid_cb.setVisibility(0);
        } else {
            viewHolder.grid_cb.setVisibility(8);
        }
        return view2;
    }

    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        View view2;
        HeaderViewHolder headerViewHolder;
        if (view == null) {
            headerViewHolder = new HeaderViewHolder();
            view2 = this.mInflater.inflate(R.layout.grid_header, viewGroup, false);
            headerViewHolder.mTextView = (TextView) view2.findViewById(R.id.grid_header);
            headerViewHolder.mTextView = (TextView) view2.findViewById(R.id.grid_header);
            view2.setTag(headerViewHolder);
        } else {
            view2 = view;
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }
        headerViewHolder.mTextView.setText(this.list.get(i).getTime());
        return view2;
    }

    public long getHeaderId(int i) {
        return (long) this.list.get(i).getSection();
    }
}
