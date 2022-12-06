package com.alibaba.sdk.android.oss.internal;

import com.squareup.okhttp.Response;
import java.io.IOException;

public interface ResponseParser<T> {
    T parse(Response response) throws IOException;
}
