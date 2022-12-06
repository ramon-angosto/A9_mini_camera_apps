package com.vungle.warren.utility;

import android.util.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.model.admarkup.AdMarkup;
import com.vungle.warren.model.admarkup.AdMarkupV1;
import com.vungle.warren.model.admarkup.AdMarkupV2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class AdMarkupDecoder {
    public static AdMarkup decode(String str) {
        if (str == null) {
            return null;
        }
        try {
            JsonElement parseString = JsonParser.parseString(str);
            if (!parseString.isJsonObject()) {
                return null;
            }
            JsonObject asJsonObject = parseString.getAsJsonObject();
            int asInt = parseString.getAsJsonObject().get("version").getAsInt();
            if (asInt == 1) {
                return AdMarkupV1.fromString(str);
            }
            if (asInt != 2) {
                return null;
            }
            return serializeAdMarkupV2(asJsonObject);
        } catch (JsonSyntaxException unused) {
            logError();
            return null;
        }
    }

    private static AdMarkupV2 serializeAdMarkupV2(JsonObject jsonObject) {
        String asString = jsonObject.get("adunit").getAsString();
        JsonArray asJsonArray = jsonObject.get("impression").getAsJsonArray();
        String[] strArr = new String[asJsonArray.size()];
        for (int i = 0; i < asJsonArray.size(); i++) {
            strArr[i] = asJsonArray.get(i).getAsString();
        }
        try {
            return new AdMarkupV2(JsonParser.parseString(gzipDecode(Base64.decode(asString, 0))).getAsJsonObject(), strArr);
        } catch (IOException unused) {
            logError();
            return null;
        }
    }

    private static String gzipDecode(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 32);
        StringBuilder sb = new StringBuilder();
        byte[] bArr2 = new byte[32];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                sb.append(new String(bArr2, 0, read));
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return sb.toString();
            }
        }
    }

    private static void logError() {
        VungleLogger.error(AdMarkupDecoder.class.getName(), "Encountered issue serializing models");
    }
}
