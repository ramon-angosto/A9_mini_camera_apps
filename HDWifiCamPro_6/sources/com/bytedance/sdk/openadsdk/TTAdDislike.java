package com.bytedance.sdk.openadsdk;

import java.io.Serializable;

public interface TTAdDislike {

    public interface DislikeInteractionCallback extends Serializable {
        void onCancel();

        void onRefuse();

        void onSelected(int i, String str);
    }

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void showDislikeDialog();
}
