package com.vungle.warren.network.converters;

import okhttp3.ResponseBody;

public class EmptyResponseConverter implements Converter<ResponseBody, Void> {
    public Void convert(ResponseBody responseBody) {
        responseBody.close();
        return null;
    }
}
