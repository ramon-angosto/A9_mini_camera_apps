package com.hichip.widget.stickygridheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public class StickyGridHeadersListAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {
    private DataSetObserver mDataSetObserver = new DataSetObserver() {
        public void onChanged() {
            StickyGridHeadersListAdapterWrapper.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            StickyGridHeadersListAdapterWrapper.this.notifyDataSetInvalidated();
        }
    };
    private ListAdapter mDelegate;

    public int getCountForHeader(int i) {
        return 0;
    }

    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public int getNumHeaders() {
        return 0;
    }

    public StickyGridHeadersListAdapterWrapper(ListAdapter listAdapter) {
        this.mDelegate = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mDataSetObserver);
        }
    }

    public int getCount() {
        ListAdapter listAdapter = this.mDelegate;
        if (listAdapter == null) {
            return 0;
        }
        return listAdapter.getCount();
    }

    public Object getItem(int i) {
        ListAdapter listAdapter = this.mDelegate;
        if (listAdapter == null) {
            return null;
        }
        return listAdapter.getItem(i);
    }

    public long getItemId(int i) {
        return this.mDelegate.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.mDelegate.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.mDelegate.getView(i, view, viewGroup);
    }

    public int getViewTypeCount() {
        return this.mDelegate.getViewTypeCount();
    }

    public boolean hasStableIds() {
        return this.mDelegate.hasStableIds();
    }
}
