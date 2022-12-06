package com.vungle.warren.network;

import java.io.IOException;

public interface Call<T> {
    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;
}
