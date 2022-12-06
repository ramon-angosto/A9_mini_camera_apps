package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zag implements zai<BigInteger> {
    zag() {
    }

    public final /* synthetic */ Object zaa(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        return fastParser.zat(bufferedReader);
    }
}
