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
import com.hichip.widget.stickygridheadersshix.StickyGridHeadersSimpleAdapter;
import com.shix.qhipc.R;
import java.util.List;

public class StickyGridTfAdapter extends BaseAdapter implements StickyGridHeadersSimpleAdapter {
    int delMode;
    private boolean isVideo = false;
    private List<GridItem> list;
    private Context mContext;
    private GridView mGridView;
    private LayoutInflater mInflater;
    private Point mPoint = new Point(0, 0);

    public static class HeaderViewHolder {
        public TextView mTextView;
    }

    public static class ViewHolder {
        public CheckBox grid_cb;
        public ImageView img_video;
        public ImageView mImageView;
        public TextView tv_time;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public StickyGridTfAdapter(Context context, List<GridItem> list2, GridView gridView, boolean z) {
        this.list = list2;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mGridView = gridView;
        this.isVideo = z;
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
            view2 = this.mInflater.inflate(R.layout.grid_item_tf, viewGroup, false);
            viewHolder.mImageView = (ImageView) view2.findViewById(R.id.grid_item);
            viewHolder.grid_cb = (CheckBox) view2.findViewById(R.id.grid_cb);
            viewHolder.img_video = (ImageView) view2.findViewById(R.id.img_video);
            viewHolder.tv_time = (TextView) view2.findViewById(R.id.tv_time);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.isVideo) {
            viewHolder.img_video.setVisibility(0);
        } else {
            viewHolder.img_video.setVisibility(8);
        }
        this.list.get(i).getPath();
        TextView textView = viewHolder.tv_time;
        textView.setText(this.list.get(i).getTime() + "");
        if (this.delMode == 1) {
            viewHolder.grid_cb.setVisibility(0);
        } else {
            viewHolder.grid_cb.setVisibility(8);
        }
        return view2;
    }

    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        HeaderViewHolder headerViewHolder;
        if (view == null) {
            HeaderViewHolder headerViewHolder2 = new HeaderViewHolder();
            View inflate = this.mInflater.inflate(R.layout.grid_header, viewGroup, false);
            headerViewHolder2.mTextView = (TextView) inflate.findViewById(R.id.grid_header);
            headerViewHolder2.mTextView = (TextView) inflate.findViewById(R.id.grid_header);
            inflate.setTag(headerViewHolder2);
            View view2 = inflate;
            headerViewHolder = headerViewHolder2;
            view = view2;
        } else {
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }
        view.setVisibility(8);
        headerViewHolder.mTextView.setText(this.list.get(i).getTime());
        return view;
    }

    public long getHeaderId(int i) {
        return (long) this.list.get(i).getSection();
    }
}
