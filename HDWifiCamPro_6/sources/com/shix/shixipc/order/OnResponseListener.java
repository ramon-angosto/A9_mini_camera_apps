package com.shix.shixipc.order;

public interface OnResponseListener {
    void onError(String str);

    void onSuccess(String str);
}
