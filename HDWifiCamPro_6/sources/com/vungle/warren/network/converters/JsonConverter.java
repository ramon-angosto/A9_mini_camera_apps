package com.vungle.warren.network.converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import okhttp3.ResponseBody;

public class JsonConverter implements Converter<ResponseBody, JsonObject> {
    private static final Gson gson = new GsonBuilder().create();

    public JsonObject convert(ResponseBody responseBody) throws IOException {
        try {
            return (JsonObject) gson.fromJson(responseBody.string(), JsonObject.class);
        } finally {
            responseBody.close();
        }
    }
}
