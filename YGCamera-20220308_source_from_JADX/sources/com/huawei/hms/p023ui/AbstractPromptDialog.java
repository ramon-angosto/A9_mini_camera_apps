package com.huawei.hms.p023ui;

import android.content.Context;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* renamed from: com.huawei.hms.ui.AbstractPromptDialog */
public abstract class AbstractPromptDialog extends AbstractDialog {
    public String onGetNegativeButtonString(Context context) {
        return null;
    }

    public String onGetTitleString(Context context) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context);
        }
        return ResourceLoaderUtil.getString("hms_bindfaildlg_title");
    }
}
