package object.p2pipcam.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.widget.GridView;
import com.jxl.app.littlestars.project.R;

public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView> {
    public PullToRefreshGridView(Context context) {
        super(context);
    }

    public PullToRefreshGridView(Context context, int i) {
        super(context, i);
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final GridView createRefreshableView(Context context, AttributeSet attributeSet) {
        InternalGridView internalGridView = new InternalGridView(context, attributeSet);
        internalGridView.setId(R.id.gridview);
        return internalGridView;
    }

    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return ((InternalGridView) getRefreshableView()).getContextMenuInfo();
    }

    class InternalGridView extends GridView implements EmptyViewMethodAccessor {
        public InternalGridView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setEmptyView(View view) {
            PullToRefreshGridView.this.setEmptyView(view);
        }

        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }

        public ContextMenu.ContextMenuInfo getContextMenuInfo() {
            return super.getContextMenuInfo();
        }
    }
}
