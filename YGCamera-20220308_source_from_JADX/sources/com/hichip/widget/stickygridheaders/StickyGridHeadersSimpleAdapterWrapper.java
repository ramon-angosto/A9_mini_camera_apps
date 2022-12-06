package com.hichip.widget.stickygridheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class StickyGridHeadersSimpleAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {
    /* access modifiers changed from: private */
    public StickyGridHeadersSimpleAdapter mDelegate;
    /* access modifiers changed from: private */
    public HeaderData[] mHeaders;

    public StickyGridHeadersSimpleAdapterWrapper(StickyGridHeadersSimpleAdapter stickyGridHeadersSimpleAdapter) {
        this.mDelegate = stickyGridHeadersSimpleAdapter;
        stickyGridHeadersSimpleAdapter.registerDataSetObserver(new DataSetObserverExtension(this, (DataSetObserverExtension) null));
        this.mHeaders = generateHeaderList(stickyGridHeadersSimpleAdapter);
    }

    public int getCount() {
        return this.mDelegate.getCount();
    }

    public int getCountForHeader(int i) {
        return this.mHeaders[i].getCount();
    }

    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        return this.mDelegate.getHeaderView(this.mHeaders[i].getRefPosition(), view, viewGroup);
    }

    public Object getItem(int i) {
        return this.mDelegate.getItem(i);
    }

    public long getItemId(int i) {
        return this.mDelegate.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.mDelegate.getItemViewType(i);
    }

    public int getNumHeaders() {
        return this.mHeaders.length;
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

    /* access modifiers changed from: protected */
    public HeaderData[] generateHeaderList(StickyGridHeadersSimpleAdapter stickyGridHeadersSimpleAdapter) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < stickyGridHeadersSimpleAdapter.getCount(); i++) {
            long headerId = stickyGridHeadersSimpleAdapter.getHeaderId(i);
            HeaderData headerData = (HeaderData) hashMap.get(Long.valueOf(headerId));
            if (headerData == null) {
                headerData = new HeaderData(i);
                arrayList.add(headerData);
            }
            headerData.incrementCount();
            hashMap.put(Long.valueOf(headerId), headerData);
        }
        return (HeaderData[]) arrayList.toArray(new HeaderData[arrayList.size()]);
    }

    private final class DataSetObserverExtension extends DataSetObserver {
        private DataSetObserverExtension() {
        }

        /* synthetic */ DataSetObserverExtension(StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper, DataSetObserverExtension dataSetObserverExtension) {
            this();
        }

        public void onChanged() {
            StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = StickyGridHeadersSimpleAdapterWrapper.this;
            stickyGridHeadersSimpleAdapterWrapper.mHeaders = stickyGridHeadersSimpleAdapterWrapper.generateHeaderList(stickyGridHeadersSimpleAdapterWrapper.mDelegate);
            StickyGridHeadersSimpleAdapterWrapper.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = StickyGridHeadersSimpleAdapterWrapper.this;
            stickyGridHeadersSimpleAdapterWrapper.mHeaders = stickyGridHeadersSimpleAdapterWrapper.generateHeaderList(stickyGridHeadersSimpleAdapterWrapper.mDelegate);
            StickyGridHeadersSimpleAdapterWrapper.this.notifyDataSetInvalidated();
        }
    }

    private class HeaderData {
        private int mCount = 0;
        private int mRefPosition;

        public HeaderData(int i) {
            this.mRefPosition = i;
        }

        public int getCount() {
            return this.mCount;
        }

        public int getRefPosition() {
            return this.mRefPosition;
        }

        public void incrementCount() {
            this.mCount++;
        }
    }
}
