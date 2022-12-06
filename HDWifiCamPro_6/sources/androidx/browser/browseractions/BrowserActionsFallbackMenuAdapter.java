package androidx.browser.browseractions;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

@Deprecated
class BrowserActionsFallbackMenuAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<BrowserActionItem> mMenuItems;

    public long getItemId(int i) {
        return (long) i;
    }

    BrowserActionsFallbackMenuAdapter(List<BrowserActionItem> list, Context context) {
        this.mMenuItems = list;
        this.mContext = context;
    }

    public int getCount() {
        return this.mMenuItems.size();
    }

    public Object getItem(int i) {
        return this.mMenuItems.get(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$ViewHolderItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r4, android.view.View r5, android.view.ViewGroup r6) {
        /*
            r3 = this;
            java.util.List<androidx.browser.browseractions.BrowserActionItem> r6 = r3.mMenuItems
            java.lang.Object r4 = r6.get(r4)
            androidx.browser.browseractions.BrowserActionItem r4 = (androidx.browser.browseractions.BrowserActionItem) r4
            r6 = 0
            if (r5 != 0) goto L_0x003c
            android.content.Context r5 = r3.mContext
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            int r0 = androidx.browser.R.layout.browser_actions_context_menu_row
            android.view.View r5 = r5.inflate(r0, r6)
            int r0 = androidx.browser.R.id.browser_actions_menu_item_icon
            android.view.View r0 = r5.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r1 = androidx.browser.R.id.browser_actions_menu_item_text
            android.view.View r1 = r5.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r0 == 0) goto L_0x0034
            if (r1 == 0) goto L_0x0034
            androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$ViewHolderItem r2 = new androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$ViewHolderItem
            r2.<init>(r0, r1)
            r5.setTag(r2)
            goto L_0x0043
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Browser Actions fallback UI does not contain necessary Views."
            r4.<init>(r5)
            throw r4
        L_0x003c:
            java.lang.Object r0 = r5.getTag()
            r2 = r0
            androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$ViewHolderItem r2 = (androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter.ViewHolderItem) r2
        L_0x0043:
            java.lang.String r0 = r4.getTitle()
            android.widget.TextView r1 = r2.mText
            r1.setText(r0)
            int r1 = r4.getIconId()
            if (r1 == 0) goto L_0x0066
            android.content.Context r0 = r3.mContext
            android.content.res.Resources r0 = r0.getResources()
            int r4 = r4.getIconId()
            android.graphics.drawable.Drawable r4 = androidx.core.content.res.ResourcesCompat.getDrawable(r0, r4, r6)
            android.widget.ImageView r6 = r2.mIcon
            r6.setImageDrawable(r4)
            goto L_0x0093
        L_0x0066:
            android.net.Uri r1 = r4.getIconUri()
            if (r1 == 0) goto L_0x0088
            android.content.Context r6 = r3.mContext
            android.content.ContentResolver r6 = r6.getContentResolver()
            android.net.Uri r4 = r4.getIconUri()
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.browser.browseractions.BrowserServiceFileProvider.loadBitmap(r6, r4)
            androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$1 r6 = new androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$1
            r6.<init>(r0, r2, r4)
            androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$2 r0 = new androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$2
            r0.<init>()
            r4.addListener(r6, r0)
            goto L_0x0093
        L_0x0088:
            android.widget.ImageView r4 = r2.mIcon
            r4.setImageBitmap(r6)
            android.widget.ImageView r4 = r2.mIcon
            r6 = 4
            r4.setVisibility(r6)
        L_0x0093:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    static class ViewHolderItem {
        final ImageView mIcon;
        final TextView mText;

        ViewHolderItem(ImageView imageView, TextView textView) {
            this.mIcon = imageView;
            this.mText = textView;
        }
    }
}
