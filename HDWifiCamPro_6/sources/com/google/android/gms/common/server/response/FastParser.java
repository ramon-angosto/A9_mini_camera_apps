package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.warren.downloader.DownloadRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaa = {'u', 'l', 'l'};
    private static final char[] zab = {'r', 'u', 'e'};
    private static final char[] zac = {'r', 'u', 'e', Typography.quote};
    private static final char[] zad = {'a', 'l', 's', 'e'};
    private static final char[] zae = {'a', 'l', 's', 'e', Typography.quote};
    private static final char[] zaf = {10};
    private static final zai<Integer> zag = new zaa();
    private static final zai<Long> zah = new zab();
    private static final zai<Float> zai = new zac();
    private static final zai<Double> zaj = new zad();
    private static final zai<Boolean> zak = new zae();
    private static final zai<String> zal = new zaf();
    private static final zai<BigInteger> zam = new zag();
    private static final zai<BigDecimal> zan = new zah();
    private final char[] zao = new char[1];
    private final char[] zap = new char[32];
    private final char[] zaq = new char[1024];
    private final StringBuilder zar = new StringBuilder(32);
    private final StringBuilder zas = new StringBuilder(1024);
    private final Stack<Integer> zat = new Stack<>();

    /* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    private static final String zaA(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z = false;
        boolean z2 = false;
        loop0:
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                boolean z3 = z2;
                boolean z4 = z;
                for (int i = 0; i < read; i++) {
                    char c = cArr[i];
                    if (Character.isISOControl(c)) {
                        if (cArr2 == null) {
                            break loop0;
                        }
                        int i2 = 0;
                        while (i2 <= 0) {
                            if (cArr2[i2] != c) {
                                i2++;
                            }
                        }
                        break loop0;
                    }
                    if (c == '\"') {
                        if (!z3) {
                            sb.append(cArr, 0, i);
                            bufferedReader.reset();
                            bufferedReader.skip((long) (i + 1));
                            if (z4) {
                                return JsonUtils.unescapeString(sb.toString());
                            }
                            return sb.toString();
                        }
                    } else if (c == '\\') {
                        z3 = !z3;
                        z4 = true;
                    }
                    z3 = false;
                }
                sb.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
                z = z4;
                z2 = z3;
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    private final char zai(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zao) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.zao[0])) {
            if (bufferedReader.read(this.zao) == -1) {
                return 0;
            }
        }
        return this.zao[0];
    }

    /* access modifiers changed from: private */
    public final double zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final float zak(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final int zal(BufferedReader bufferedReader) throws ParseException, IOException {
        int i;
        int i2;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            char c = cArr[0];
            int i3 = c == '-' ? Integer.MIN_VALUE : DownloadRequest.Priority.CRITICAL;
            int i4 = c == '-' ? 1 : 0;
            if (i4 < zam2) {
                i2 = i4 + 1;
                int digit = Character.digit(cArr[i4], 10);
                if (digit >= 0) {
                    i = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                i = 0;
                i2 = i4;
            }
            while (i2 < zam2) {
                int i5 = i2 + 1;
                int digit2 = Character.digit(cArr[i2], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i >= -214748364) {
                    int i6 = i * 10;
                    if (i6 >= i3 + digit2) {
                        i = i6 - digit2;
                        i2 = i5;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i4 == 0) {
                return -i;
            }
            if (i2 > 1) {
                return i;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    private final int zam(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i;
        char zai2 = zai(bufferedReader);
        if (zai2 == 0) {
            throw new ParseException("Unexpected EOF");
        } else if (zai2 == ',') {
            throw new ParseException("Missing value");
        } else if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (zai2 == '\"') {
                i = 0;
                boolean z = false;
                while (i < 1024 && bufferedReader.read(cArr, i, 1) != -1) {
                    char c = cArr[i];
                    if (!Character.isISOControl(c)) {
                        if (c == '\"') {
                            if (!z) {
                                bufferedReader.reset();
                                bufferedReader.skip((long) (i + 1));
                                return i;
                            }
                        } else if (c == '\\') {
                            z = !z;
                            i++;
                        }
                        z = false;
                        i++;
                    } else {
                        throw new ParseException("Unexpected control character while reading string");
                    }
                }
            } else {
                cArr[0] = zai2;
                int i2 = 1;
                while (i < 1024 && bufferedReader.read(cArr, i, 1) != -1) {
                    char c2 = cArr[i];
                    if (c2 == '}' || c2 == ',' || Character.isWhitespace(c2) || cArr[i] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i - 1));
                        cArr[i] = 0;
                        return i;
                    }
                    i2 = i + 1;
                }
            }
            if (i == 1024) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException("Unexpected EOF");
        }
    }

    /* access modifiers changed from: private */
    public final long zan(BufferedReader bufferedReader) throws ParseException, IOException {
        long j;
        int i;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            int i2 = 0;
            char c = cArr[0];
            long j2 = c == '-' ? Long.MIN_VALUE : C.TIME_UNSET;
            if (c == '-') {
                i2 = 1;
            }
            if (i2 < zam2) {
                i = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit >= 0) {
                    j = (long) (-digit);
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                j = 0;
                i = i2;
            }
            while (i < zam2) {
                int i3 = i + 1;
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j >= -922337203685477580L) {
                    long j3 = j * 10;
                    int i4 = zam2;
                    long j4 = (long) digit2;
                    if (j3 >= j2 + j4) {
                        j = j3 - j4;
                        zam2 = i4;
                        i = i3;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i2 == 0) {
                return -j;
            }
            if (i > 1) {
                return j;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final String zao(BufferedReader bufferedReader) throws ParseException, IOException {
        return zap(bufferedReader, this.zap, this.zar, (char[]) null);
    }

    private final String zap(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            return zaA(bufferedReader, cArr, sb, cArr2);
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        }
        throw new ParseException("Expected string");
    }

    private final String zaq(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zat.push(2);
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            this.zat.push(3);
            String zaA = zaA(bufferedReader, this.zap, this.zar, (char[]) null);
            zaw(3);
            if (zai(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zai2 == ']') {
            zaw(2);
            zaw(1);
            zaw(5);
            return null;
        } else if (zai2 == '}') {
            zaw(2);
            return null;
        } else {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(zai2);
            throw new ParseException(sb.toString());
        }
    }

    private final String zar(BufferedReader bufferedReader) throws ParseException, IOException {
        BufferedReader bufferedReader2 = bufferedReader;
        bufferedReader2.mark(1024);
        char zai2 = zai(bufferedReader);
        int i = 1;
        if (zai2 != '\"') {
            if (zai2 == ',') {
                throw new ParseException("Missing value");
            } else if (zai2 == '[') {
                this.zat.push(5);
                bufferedReader2.mark(32);
                if (zai(bufferedReader) == ']') {
                    zaw(5);
                } else {
                    bufferedReader.reset();
                    boolean z = false;
                    boolean z2 = false;
                    while (i > 0) {
                        char zai3 = zai(bufferedReader);
                        if (zai3 == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        } else if (!Character.isISOControl(zai3)) {
                            if (zai3 == '\"') {
                                if (!z2) {
                                    z = !z;
                                }
                                zai3 = '\"';
                            }
                            if (zai3 == '[') {
                                if (!z) {
                                    i++;
                                }
                                zai3 = '[';
                            }
                            if (zai3 == ']' && !z) {
                                i--;
                            }
                            z2 = (zai3 != '\\' || !z) ? false : !z2;
                        } else {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                    }
                    zaw(5);
                }
            } else if (zai2 != '{') {
                bufferedReader.reset();
                zam(bufferedReader2, this.zaq);
            } else {
                this.zat.push(1);
                bufferedReader2.mark(32);
                char zai4 = zai(bufferedReader);
                if (zai4 == '}') {
                    zaw(1);
                } else if (zai4 == '\"') {
                    bufferedReader.reset();
                    zaq(bufferedReader);
                    do {
                    } while (zar(bufferedReader) != null);
                    zaw(1);
                } else {
                    StringBuilder sb = new StringBuilder(18);
                    sb.append("Unexpected token ");
                    sb.append(zai4);
                    throw new ParseException(sb.toString());
                }
            }
        } else if (bufferedReader2.read(this.zao) != -1) {
            char c = this.zao[0];
            boolean z3 = false;
            do {
                if (c == '\"') {
                    if (z3) {
                        c = '\"';
                        z3 = true;
                    }
                }
                z3 = c == '\\' ? !z3 : false;
                if (bufferedReader2.read(this.zao) != -1) {
                    c = this.zao[0];
                } else {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
            } while (!Character.isISOControl(c));
            throw new ParseException("Unexpected control character while reading string");
        } else {
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char zai5 = zai(bufferedReader);
        if (zai5 == ',') {
            zaw(2);
            return zaq(bufferedReader);
        } else if (zai5 == '}') {
            zaw(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(18);
            sb2.append("Unexpected token ");
            sb2.append(zai5);
            throw new ParseException(sb2.toString());
        }
    }

    /* access modifiers changed from: private */
    public final BigDecimal zas(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final BigInteger zat(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaq, 0, zam2));
    }

    private final <O> ArrayList<O> zau(BufferedReader bufferedReader, zai<O> zai2) throws ParseException, IOException {
        char zai3 = zai(bufferedReader);
        if (zai3 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        } else if (zai3 == '[') {
            this.zat.push(5);
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char zai4 = zai(bufferedReader);
                if (zai4 == 0) {
                    throw new ParseException("Unexpected EOF");
                } else if (zai4 != ',') {
                    if (zai4 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zai2.zaa(this, bufferedReader));
                    } else {
                        zaw(5);
                        return arrayList;
                    }
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    private final <T extends FastJsonResponse> ArrayList<T> zav(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = new ArrayList<>();
        char zai2 = zai(bufferedReader);
        if (zai2 == ']') {
            zaw(5);
            return arrayList;
        } else if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            zaw(5);
            return null;
        } else if (zai2 == '{') {
            this.zat.push(1);
            while (true) {
                try {
                    FastJsonResponse zad2 = field.zad();
                    if (!zaz(bufferedReader, zad2)) {
                        return arrayList;
                    }
                    arrayList.add(zad2);
                    char zai3 = zai(bufferedReader);
                    if (zai3 != ',') {
                        if (zai3 == ']') {
                            zaw(5);
                            return arrayList;
                        }
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(zai3);
                        throw new ParseException(sb.toString());
                    } else if (zai(bufferedReader) == '{') {
                        this.zat.push(1);
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (InstantiationException e) {
                    throw new ParseException("Error instantiating inner object", e);
                } catch (IllegalAccessException e2) {
                    throw new ParseException("Error instantiating inner object", e2);
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Unexpected token: ");
            sb2.append(zai2);
            throw new ParseException(sb2.toString());
        }
    }

    private final void zaw(int i) throws ParseException {
        if (!this.zat.isEmpty()) {
            int intValue = this.zat.pop().intValue();
            if (intValue != i) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Expected state ");
                sb.append(i);
                sb.append(" but had ");
                sb.append(intValue);
                throw new ParseException(sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Expected state ");
        sb2.append(i);
        sb2.append(" but had empty stack");
        throw new ParseException(sb2.toString());
    }

    private final void zax(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (true) {
            int length = cArr.length;
            if (i < length) {
                int read = bufferedReader.read(this.zap, 0, length - i);
                if (read != -1) {
                    int i2 = 0;
                    while (i2 < read) {
                        if (cArr[i2 + i] == this.zap[i2]) {
                            i2++;
                        } else {
                            throw new ParseException("Unexpected character");
                        }
                    }
                    i += read;
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zay(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        char[] cArr;
        char[] cArr2;
        char zai2 = zai(bufferedReader);
        if (zai2 != '\"') {
            if (zai2 == 'f') {
                if (z) {
                    cArr = zae;
                } else {
                    cArr = zad;
                }
                zax(bufferedReader, cArr);
                return false;
            } else if (zai2 == 'n') {
                zax(bufferedReader, zaa);
                return false;
            } else if (zai2 == 't') {
                if (z) {
                    cArr2 = zac;
                } else {
                    cArr2 = zab;
                }
                zax(bufferedReader, cArr2);
                return true;
            } else {
                StringBuilder sb = new StringBuilder(19);
                sb.append("Unexpected token: ");
                sb.append(zai2);
                throw new ParseException(sb.toString());
            }
        } else if (!z) {
            return zay(bufferedReader, true);
        } else {
            throw new ParseException("No boolean value found in string");
        }
    }

    private final boolean zaz(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        int i;
        HashMap hashMap;
        BufferedReader bufferedReader2 = bufferedReader;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaq2 = zaq(bufferedReader);
        if (zaq2 != null) {
            while (zaq2 != null) {
                FastJsonResponse.Field field = fieldMappings.get(zaq2);
                if (field == null) {
                    zaq2 = zar(bufferedReader);
                } else {
                    this.zat.push(4);
                    int i2 = field.zaa;
                    switch (i2) {
                        case 0:
                            if (!field.zab) {
                                fastJsonResponse2.zau(field, zal(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zav(field, zau(bufferedReader2, zag));
                                break;
                            }
                        case 1:
                            if (!field.zab) {
                                fastJsonResponse2.zae(field, zat(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zag(field, zau(bufferedReader2, zam));
                                break;
                            }
                        case 2:
                            if (!field.zab) {
                                fastJsonResponse2.zax(field, zan(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zay(field, zau(bufferedReader2, zah));
                                break;
                            }
                        case 3:
                            if (!field.zab) {
                                fastJsonResponse2.zaq(field, zak(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zas(field, zau(bufferedReader2, zai));
                                break;
                            }
                        case 4:
                            if (!field.zab) {
                                fastJsonResponse2.zam(field, zaj(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zao(field, zau(bufferedReader2, zaj));
                                break;
                            }
                        case 5:
                            if (!field.zab) {
                                fastJsonResponse2.zaa(field, zas(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zac(field, zau(bufferedReader2, zan));
                                break;
                            }
                        case 6:
                            if (!field.zab) {
                                fastJsonResponse2.zai(field, zay(bufferedReader2, false));
                                break;
                            } else {
                                fastJsonResponse2.zaj(field, zau(bufferedReader2, zak));
                                break;
                            }
                        case 7:
                            if (!field.zab) {
                                fastJsonResponse2.zaA(field, zao(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zaC(field, zau(bufferedReader2, zal));
                                break;
                            }
                        case 8:
                            fastJsonResponse2.zal(field, Base64Utils.decode(zap(bufferedReader2, this.zaq, this.zas, zaf)));
                            break;
                        case 9:
                            fastJsonResponse2.zal(field, Base64Utils.decodeUrlSafe(zap(bufferedReader2, this.zaq, this.zas, zaf)));
                            break;
                        case 10:
                            char zai2 = zai(bufferedReader);
                            if (zai2 == 'n') {
                                zax(bufferedReader2, zaa);
                                hashMap = null;
                            } else if (zai2 == '{') {
                                this.zat.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char zai3 = zai(bufferedReader);
                                    if (zai3 == 0) {
                                        throw new ParseException("Unexpected EOF");
                                    } else if (zai3 == '\"') {
                                        String zaA = zaA(bufferedReader2, this.zap, this.zar, (char[]) null);
                                        if (zai(bufferedReader) != ':') {
                                            String valueOf = String.valueOf(zaA);
                                            throw new ParseException(valueOf.length() != 0 ? "No map value found for key ".concat(valueOf) : new String("No map value found for key "));
                                        } else if (zai(bufferedReader) != '\"') {
                                            String valueOf2 = String.valueOf(zaA);
                                            throw new ParseException(valueOf2.length() != 0 ? "Expected String value for key ".concat(valueOf2) : new String("Expected String value for key "));
                                        } else {
                                            hashMap.put(zaA, zaA(bufferedReader2, this.zap, this.zar, (char[]) null));
                                            char zai4 = zai(bufferedReader);
                                            if (zai4 != ',') {
                                                if (zai4 == '}') {
                                                    zaw(1);
                                                } else {
                                                    StringBuilder sb = new StringBuilder(48);
                                                    sb.append("Unexpected character while parsing string map: ");
                                                    sb.append(zai4);
                                                    throw new ParseException(sb.toString());
                                                }
                                            }
                                        }
                                    } else if (zai3 == '}') {
                                        zaw(1);
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse2.zaB(field, hashMap);
                            break;
                        case 11:
                            if (field.zab) {
                                char zai5 = zai(bufferedReader);
                                if (zai5 == 'n') {
                                    zax(bufferedReader2, zaa);
                                    fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zae, (ArrayList) null);
                                } else {
                                    this.zat.push(5);
                                    if (zai5 == '[') {
                                        fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader2, field));
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char zai6 = zai(bufferedReader);
                                if (zai6 == 'n') {
                                    zax(bufferedReader2, zaa);
                                    fastJsonResponse2.addConcreteTypeInternal(field, field.zae, null);
                                } else {
                                    this.zat.push(1);
                                    if (zai6 == '{') {
                                        try {
                                            FastJsonResponse zad2 = field.zad();
                                            zaz(bufferedReader2, zad2);
                                            fastJsonResponse2.addConcreteTypeInternal(field, field.zae, zad2);
                                        } catch (InstantiationException e) {
                                            throw new ParseException("Error instantiating inner object", e);
                                        } catch (IllegalAccessException e2) {
                                            throw new ParseException("Error instantiating inner object", e2);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                            i = 4;
                            break;
                        default:
                            StringBuilder sb2 = new StringBuilder(30);
                            sb2.append("Invalid field type ");
                            sb2.append(i2);
                            throw new ParseException(sb2.toString());
                    }
                    i = 4;
                    zaw(i);
                    zaw(2);
                    char zai7 = zai(bufferedReader);
                    if (zai7 == ',') {
                        zaq2 = zaq(bufferedReader);
                    } else if (zai7 == '}') {
                        zaq2 = null;
                    } else {
                        StringBuilder sb3 = new StringBuilder(55);
                        sb3.append("Expected end of object or field separator, but found: ");
                        sb3.append(zai7);
                        throw new ParseException(sb3.toString());
                    }
                }
            }
            zaw(1);
            return true;
        }
        zaw(1);
        return false;
    }

    public void parse(InputStream inputStream, T t) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.zat.push(0);
            char zai2 = zai(bufferedReader);
            if (zai2 != 0) {
                if (zai2 == '[') {
                    this.zat.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        FastJsonResponse.Field field = (FastJsonResponse.Field) fieldMappings.entrySet().iterator().next().getValue();
                        t.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                    } else {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                } else if (zai2 == '{') {
                    this.zat.push(1);
                    zaz(bufferedReader, t);
                } else {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(zai2);
                    throw new ParseException(sb.toString());
                }
                zaw(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } else {
                throw new ParseException("No data to parse");
            }
        } catch (IOException e) {
            throw new ParseException((Throwable) e);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
