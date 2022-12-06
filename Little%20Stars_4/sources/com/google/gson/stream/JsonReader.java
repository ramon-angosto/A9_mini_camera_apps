package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
    private static final String FALSE = "false";
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final String TRUE = "true";
    private final char[] buffer = new char[1024];
    private int bufferStartColumn = 1;
    private int bufferStartLine = 1;
    private final Reader in;
    private boolean lenient = false;
    private int limit = 0;
    /* access modifiers changed from: private */
    public String name;
    private int pos = 0;
    private boolean skipping;
    private JsonScope[] stack = new JsonScope[32];
    private int stackSize = 0;
    private final StringPool stringPool = new StringPool();
    /* access modifiers changed from: private */
    public JsonToken token;
    /* access modifiers changed from: private */
    public String value;
    private int valueLength;
    private int valuePos;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                jsonReader.peek();
                if (jsonReader.token == JsonToken.NAME) {
                    String unused = jsonReader.value = jsonReader.name;
                    String unused2 = jsonReader.name = null;
                    JsonToken unused3 = jsonReader.token = JsonToken.STRING;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + " " + " at line " + jsonReader.getLineNumber() + " column " + jsonReader.getColumnNumber());
            }
        };
    }

    public JsonReader(Reader reader) {
        push(JsonScope.EMPTY_DOCUMENT);
        this.skipping = false;
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
    }

    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
    }

    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
    }

    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
    }

    private void expect(JsonToken jsonToken) throws IOException {
        peek();
        if (this.token == jsonToken) {
            advance();
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public boolean hasNext() throws IOException {
        peek();
        return (this.token == JsonToken.END_OBJECT || this.token == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken peek() throws IOException {
        JsonToken jsonToken = this.token;
        if (jsonToken != null) {
            return jsonToken;
        }
        switch (this.stack[this.stackSize - 1]) {
            case EMPTY_DOCUMENT:
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_DOCUMENT;
                JsonToken nextValue = nextValue();
                if (this.lenient || this.token == JsonToken.BEGIN_ARRAY || this.token == JsonToken.BEGIN_OBJECT) {
                    return nextValue;
                }
                throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
            case EMPTY_ARRAY:
                return nextInArray(true);
            case NONEMPTY_ARRAY:
                return nextInArray(false);
            case EMPTY_OBJECT:
                return nextInObject(true);
            case DANGLING_NAME:
                return objectValue();
            case NONEMPTY_OBJECT:
                return nextInObject(false);
            case NONEMPTY_DOCUMENT:
                if (nextNonWhitespace(false) == -1) {
                    return JsonToken.END_DOCUMENT;
                }
                this.pos--;
                if (this.lenient) {
                    return nextValue();
                }
                throw syntaxError("Expected EOF");
            case CLOSED:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        this.pos--;
        int i = this.pos;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i + cArr.length <= this.limit || fillBuffer(cArr.length)) {
            int i2 = 0;
            while (true) {
                char[] cArr2 = NON_EXECUTE_PREFIX;
                if (i2 >= cArr2.length) {
                    this.pos += cArr2.length;
                    return;
                } else if (this.buffer[this.pos + i2] == cArr2[i2]) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private JsonToken advance() throws IOException {
        peek();
        JsonToken jsonToken = this.token;
        this.token = null;
        this.value = null;
        this.name = null;
        return jsonToken;
    }

    public String nextName() throws IOException {
        peek();
        if (this.token == JsonToken.NAME) {
            String str = this.name;
            advance();
            return str;
        }
        throw new IllegalStateException("Expected a name but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public String nextString() throws IOException {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            String str = this.value;
            advance();
            return str;
        }
        throw new IllegalStateException("Expected a string but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public boolean nextBoolean() throws IOException {
        peek();
        if (this.token == JsonToken.BOOLEAN) {
            boolean z = this.value == TRUE;
            advance();
            return z;
        }
        throw new IllegalStateException("Expected a boolean but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public void nextNull() throws IOException {
        peek();
        if (this.token == JsonToken.NULL) {
            advance();
            return;
        }
        throw new IllegalStateException("Expected null but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public double nextDouble() throws IOException {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            double parseDouble = Double.parseDouble(this.value);
            if (parseDouble >= 1.0d && this.value.startsWith(PushConstants.PUSH_TYPE_NOTIFY)) {
                throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
            } else if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                advance();
                return parseDouble;
            } else {
                throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
            }
        } else {
            throw new IllegalStateException("Expected a double but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
    }

    public long nextLong() throws IOException {
        long j;
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            try {
                j = Long.parseLong(this.value);
            } catch (NumberFormatException unused) {
                double parseDouble = Double.parseDouble(this.value);
                long j2 = (long) parseDouble;
                if (((double) j2) == parseDouble) {
                    j = j2;
                } else {
                    throw new NumberFormatException("Expected a long but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
                }
            }
            if (j < 1 || !this.value.startsWith(PushConstants.PUSH_TYPE_NOTIFY)) {
                advance();
                return j;
            }
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        throw new IllegalStateException("Expected a long but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public int nextInt() throws IOException {
        int i;
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            try {
                i = Integer.parseInt(this.value);
            } catch (NumberFormatException unused) {
                double parseDouble = Double.parseDouble(this.value);
                int i2 = (int) parseDouble;
                if (((double) i2) == parseDouble) {
                    i = i2;
                } else {
                    throw new NumberFormatException("Expected an int but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
                }
            }
            if (((long) i) < 1 || !this.value.startsWith(PushConstants.PUSH_TYPE_NOTIFY)) {
                advance();
                return i;
            }
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        throw new IllegalStateException("Expected an int but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public void close() throws IOException {
        this.value = null;
        this.token = null;
        this.stack[0] = JsonScope.CLOSED;
        this.stackSize = 1;
        this.in.close();
    }

    public void skipValue() throws IOException {
        this.skipping = true;
        int i = 0;
        do {
            try {
                JsonToken advance = advance();
                if (advance != JsonToken.BEGIN_ARRAY) {
                    if (advance != JsonToken.BEGIN_OBJECT) {
                        if (advance == JsonToken.END_ARRAY || advance == JsonToken.END_OBJECT) {
                            i--;
                            continue;
                        }
                    }
                }
                i++;
                continue;
            } finally {
                this.skipping = false;
            }
        } while (i != 0);
    }

    private void push(JsonScope jsonScope) {
        int i = this.stackSize;
        JsonScope[] jsonScopeArr = this.stack;
        if (i == jsonScopeArr.length) {
            JsonScope[] jsonScopeArr2 = new JsonScope[(i * 2)];
            System.arraycopy(jsonScopeArr, 0, jsonScopeArr2, 0, i);
            this.stack = jsonScopeArr2;
        }
        JsonScope[] jsonScopeArr3 = this.stack;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        jsonScopeArr3[i2] = jsonScope;
    }

    private JsonToken nextInArray(boolean z) throws IOException {
        if (z) {
            this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_ARRAY;
        } else {
            int nextNonWhitespace = nextNonWhitespace(true);
            if (nextNonWhitespace != 44) {
                if (nextNonWhitespace == 59) {
                    checkLenient();
                } else if (nextNonWhitespace == 93) {
                    this.stackSize--;
                    JsonToken jsonToken = JsonToken.END_ARRAY;
                    this.token = jsonToken;
                    return jsonToken;
                } else {
                    throw syntaxError("Unterminated array");
                }
            }
        }
        int nextNonWhitespace2 = nextNonWhitespace(true);
        if (!(nextNonWhitespace2 == 44 || nextNonWhitespace2 == 59)) {
            if (nextNonWhitespace2 != 93) {
                this.pos--;
                return nextValue();
            } else if (z) {
                this.stackSize--;
                JsonToken jsonToken2 = JsonToken.END_ARRAY;
                this.token = jsonToken2;
                return jsonToken2;
            }
        }
        checkLenient();
        this.pos--;
        this.value = "null";
        JsonToken jsonToken3 = JsonToken.NULL;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private JsonToken nextInObject(boolean z) throws IOException {
        if (!z) {
            int nextNonWhitespace = nextNonWhitespace(true);
            if (!(nextNonWhitespace == 44 || nextNonWhitespace == 59)) {
                if (nextNonWhitespace == 125) {
                    this.stackSize--;
                    JsonToken jsonToken = JsonToken.END_OBJECT;
                    this.token = jsonToken;
                    return jsonToken;
                }
                throw syntaxError("Unterminated object");
            }
        } else if (nextNonWhitespace(true) != 125) {
            this.pos--;
        } else {
            this.stackSize--;
            JsonToken jsonToken2 = JsonToken.END_OBJECT;
            this.token = jsonToken2;
            return jsonToken2;
        }
        int nextNonWhitespace2 = nextNonWhitespace(true);
        if (nextNonWhitespace2 != 34) {
            if (nextNonWhitespace2 != 39) {
                checkLenient();
                this.pos--;
                this.name = nextLiteral(false);
                if (this.name.length() == 0) {
                    throw syntaxError("Expected name");
                }
                this.stack[this.stackSize - 1] = JsonScope.DANGLING_NAME;
                JsonToken jsonToken3 = JsonToken.NAME;
                this.token = jsonToken3;
                return jsonToken3;
            }
            checkLenient();
        }
        this.name = nextString((char) nextNonWhitespace2);
        this.stack[this.stackSize - 1] = JsonScope.DANGLING_NAME;
        JsonToken jsonToken32 = JsonToken.NAME;
        this.token = jsonToken32;
        return jsonToken32;
    }

    private JsonToken objectValue() throws IOException {
        int nextNonWhitespace = nextNonWhitespace(true);
        if (nextNonWhitespace != 58) {
            if (nextNonWhitespace == 61) {
                checkLenient();
                if (this.pos < this.limit || fillBuffer(1)) {
                    char[] cArr = this.buffer;
                    int i = this.pos;
                    if (cArr[i] == '>') {
                        this.pos = i + 1;
                    }
                }
            } else {
                throw syntaxError("Expected ':'");
            }
        }
        this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_OBJECT;
        return nextValue();
    }

    private JsonToken nextValue() throws IOException {
        int nextNonWhitespace = nextNonWhitespace(true);
        if (nextNonWhitespace != 34) {
            if (nextNonWhitespace == 39) {
                checkLenient();
            } else if (nextNonWhitespace == 91) {
                push(JsonScope.EMPTY_ARRAY);
                JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
                this.token = jsonToken;
                return jsonToken;
            } else if (nextNonWhitespace != 123) {
                this.pos--;
                return readLiteral();
            } else {
                push(JsonScope.EMPTY_OBJECT);
                JsonToken jsonToken2 = JsonToken.BEGIN_OBJECT;
                this.token = jsonToken2;
                return jsonToken2;
            }
        }
        this.value = nextString((char) nextNonWhitespace);
        JsonToken jsonToken3 = JsonToken.STRING;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private boolean fillBuffer(int i) throws IOException {
        int i2;
        char[] cArr = this.buffer;
        int i3 = this.bufferStartLine;
        int i4 = this.bufferStartColumn;
        int i5 = this.pos;
        int i6 = i4;
        int i7 = i3;
        for (int i8 = 0; i8 < i5; i8++) {
            if (cArr[i8] == 10) {
                i7++;
                i6 = 1;
            } else {
                i6++;
            }
        }
        this.bufferStartLine = i7;
        this.bufferStartColumn = i6;
        int i9 = this.limit;
        int i10 = this.pos;
        if (i9 != i10) {
            this.limit = i9 - i10;
            System.arraycopy(cArr, i10, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i11 = this.limit;
            int read = reader.read(cArr, i11, cArr.length - i11);
            if (read == -1) {
                return false;
            }
            this.limit += read;
            if (this.bufferStartLine == 1 && (i2 = this.bufferStartColumn) == 1 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.bufferStartColumn = i2 - 1;
            }
        } while (this.limit < i);
        return true;
    }

    /* access modifiers changed from: private */
    public int getLineNumber() {
        int i = this.bufferStartLine;
        for (int i2 = 0; i2 < this.pos; i2++) {
            if (this.buffer[i2] == 10) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public int getColumnNumber() {
        int i = this.bufferStartColumn;
        for (int i2 = 0; i2 < this.pos; i2++) {
            i = this.buffer[i2] == 10 ? 1 : i + 1;
        }
        return i;
    }

    private int nextNonWhitespace(boolean z) throws IOException {
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (fillBuffer(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + getLineNumber() + " column " + getColumnNumber());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 9 || c == 10 || c == 13 || c == ' ') {
                i = i3;
            } else if (c == '#') {
                this.pos = i3;
                checkLenient();
                skipToEndOfLine();
                i = this.pos;
                i2 = this.limit;
            } else if (c != '/') {
                this.pos = i3;
                return c;
            } else {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean fillBuffer = fillBuffer(2);
                    this.pos++;
                    if (!fillBuffer) {
                        return c;
                    }
                }
                checkLenient();
                int i4 = this.pos;
                char c2 = cArr[i4];
                if (c2 == '*') {
                    this.pos = i4 + 1;
                    if (skipTo("*/")) {
                        i = this.pos + 2;
                        i2 = this.limit;
                    } else {
                        throw syntaxError("Unterminated comment");
                    }
                } else if (c2 != '/') {
                    return c;
                } else {
                    this.pos = i4 + 1;
                    skipToEndOfLine();
                    i = this.pos;
                    i2 = this.limit;
                }
            }
        }
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void skipToEndOfLine() throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            int r0 = r3.pos
            int r1 = r3.limit
            if (r0 < r1) goto L_0x000d
            r0 = 1
            boolean r0 = r3.fillBuffer(r0)
            if (r0 == 0) goto L_0x001f
        L_0x000d:
            char[] r0 = r3.buffer
            int r1 = r3.pos
            int r2 = r1 + 1
            r3.pos = r2
            char r0 = r0[r1]
            r1 = 13
            if (r0 == r1) goto L_0x001f
            r1 = 10
            if (r0 != r1) goto L_0x0000
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipToEndOfLine():void");
    }

    private boolean skipTo(String str) throws IOException {
        while (true) {
            int i = 0;
            if (this.pos + str.length() > this.limit && !fillBuffer(str.length())) {
                return false;
            }
            while (i < str.length()) {
                if (this.buffer[this.pos + i] != str.charAt(i)) {
                    this.pos++;
                } else {
                    i++;
                }
            }
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        if (r1 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        r1 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        r1.append(r0, r4, r2 - r4);
        r8.pos = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextString(char r9) throws java.io.IOException {
        /*
            r8 = this;
            char[] r0 = r8.buffer
            r1 = 0
        L_0x0003:
            int r2 = r8.pos
            int r3 = r8.limit
        L_0x0007:
            r4 = r2
        L_0x0008:
            r5 = 1
            if (r2 >= r3) goto L_0x004f
            int r6 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r9) goto L_0x002f
            r8.pos = r6
            boolean r9 = r8.skipping
            if (r9 == 0) goto L_0x001a
            java.lang.String r9 = "skipped!"
            return r9
        L_0x001a:
            if (r1 != 0) goto L_0x0025
            com.google.gson.stream.StringPool r9 = r8.stringPool
            int r6 = r6 - r4
            int r6 = r6 - r5
            java.lang.String r9 = r9.get(r0, r4, r6)
            return r9
        L_0x0025:
            int r6 = r6 - r4
            int r6 = r6 - r5
            r1.append(r0, r4, r6)
            java.lang.String r9 = r1.toString()
            return r9
        L_0x002f:
            r7 = 92
            if (r2 != r7) goto L_0x004d
            r8.pos = r6
            if (r1 != 0) goto L_0x003c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x003c:
            int r6 = r6 - r4
            int r6 = r6 - r5
            r1.append(r0, r4, r6)
            char r2 = r8.readEscapeCharacter()
            r1.append(r2)
            int r2 = r8.pos
            int r3 = r8.limit
            goto L_0x0007
        L_0x004d:
            r2 = r6
            goto L_0x0008
        L_0x004f:
            if (r1 != 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x0056:
            int r3 = r2 - r4
            r1.append(r0, r4, r3)
            r8.pos = r2
            boolean r2 = r8.fillBuffer(r5)
            if (r2 == 0) goto L_0x0064
            goto L_0x0003
        L_0x0064:
            java.lang.String r9 = "Unterminated string"
            java.io.IOException r9 = r8.syntaxError(r9)
            goto L_0x006c
        L_0x006b:
            throw r9
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextString(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextLiteral(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = -1
            r7.valuePos = r0
            r0 = 0
            r7.valueLength = r0
            r1 = 0
            r3 = r1
        L_0x0008:
            r2 = 0
        L_0x0009:
            int r4 = r7.pos
            int r5 = r4 + r2
            int r6 = r7.limit
            if (r5 >= r6) goto L_0x0054
            char[] r5 = r7.buffer
            int r4 = r4 + r2
            char r4 = r5[r4]
            r5 = 9
            if (r4 == r5) goto L_0x0068
            r5 = 10
            if (r4 == r5) goto L_0x0068
            r5 = 12
            if (r4 == r5) goto L_0x0068
            r5 = 13
            if (r4 == r5) goto L_0x0068
            r5 = 32
            if (r4 == r5) goto L_0x0068
            r5 = 35
            if (r4 == r5) goto L_0x0050
            r5 = 44
            if (r4 == r5) goto L_0x0068
            r5 = 47
            if (r4 == r5) goto L_0x0050
            r5 = 61
            if (r4 == r5) goto L_0x0050
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L_0x0068
            r5 = 125(0x7d, float:1.75E-43)
            if (r4 == r5) goto L_0x0068
            r5 = 58
            if (r4 == r5) goto L_0x0068
            r5 = 59
            if (r4 == r5) goto L_0x0050
            switch(r4) {
                case 91: goto L_0x0068;
                case 92: goto L_0x0050;
                case 93: goto L_0x0068;
                default: goto L_0x004d;
            }
        L_0x004d:
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0050:
            r7.checkLenient()
            goto L_0x0068
        L_0x0054:
            char[] r4 = r7.buffer
            int r4 = r4.length
            if (r2 >= r4) goto L_0x006a
            int r4 = r2 + 1
            boolean r4 = r7.fillBuffer(r4)
            if (r4 == 0) goto L_0x0062
            goto L_0x0009
        L_0x0062:
            char[] r4 = r7.buffer
            int r5 = r7.limit
            r4[r5] = r0
        L_0x0068:
            r0 = r2
            goto L_0x0089
        L_0x006a:
            if (r3 != 0) goto L_0x0071
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x0071:
            char[] r4 = r7.buffer
            int r5 = r7.pos
            r3.append(r4, r5, r2)
            int r4 = r7.valueLength
            int r4 = r4 + r2
            r7.valueLength = r4
            int r4 = r7.pos
            int r4 = r4 + r2
            r7.pos = r4
            r2 = 1
            boolean r2 = r7.fillBuffer(r2)
            if (r2 != 0) goto L_0x0008
        L_0x0089:
            if (r8 == 0) goto L_0x0092
            if (r3 != 0) goto L_0x0092
            int r8 = r7.pos
            r7.valuePos = r8
            goto L_0x00b1
        L_0x0092:
            boolean r8 = r7.skipping
            if (r8 == 0) goto L_0x0099
            java.lang.String r1 = "skipped!"
            goto L_0x00b1
        L_0x0099:
            if (r3 != 0) goto L_0x00a6
            com.google.gson.stream.StringPool r8 = r7.stringPool
            char[] r1 = r7.buffer
            int r2 = r7.pos
            java.lang.String r1 = r8.get(r1, r2, r0)
            goto L_0x00b1
        L_0x00a6:
            char[] r8 = r7.buffer
            int r1 = r7.pos
            r3.append(r8, r1, r0)
            java.lang.String r1 = r3.toString()
        L_0x00b1:
            int r8 = r7.valueLength
            int r8 = r8 + r0
            r7.valueLength = r8
            int r8 = r7.pos
            int r8 = r8 + r0
            r7.pos = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextLiteral(boolean):java.lang.String");
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + getLineNumber() + " column " + getColumnNumber();
    }

    private char readEscapeCharacter() throws IOException {
        int i;
        int i2;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i3 = this.pos;
            this.pos = i3 + 1;
            char c = cArr[i3];
            if (c == 'b') {
                return 8;
            }
            if (c == 'f') {
                return 12;
            }
            if (c == 'n') {
                return 10;
            }
            if (c == 'r') {
                return 13;
            }
            if (c == 't') {
                return 9;
            }
            if (c != 'u') {
                return c;
            }
            if (this.pos + 4 <= this.limit || fillBuffer(4)) {
                char c2 = 0;
                int i4 = this.pos;
                int i5 = i4 + 4;
                while (i4 < i5) {
                    char c3 = this.buffer[i4];
                    char c4 = (char) (c2 << 4);
                    if (c3 < '0' || c3 > '9') {
                        if (c3 >= 'a' && c3 <= 'f') {
                            i = c3 - 'a';
                        } else if (c3 < 'A' || c3 > 'F') {
                            throw new NumberFormatException("\\u" + this.stringPool.get(this.buffer, this.pos, 4));
                        } else {
                            i = c3 - 'A';
                        }
                        i2 = i + 10;
                    } else {
                        i2 = c3 - '0';
                    }
                    c2 = (char) (c4 + i2);
                    i4++;
                }
                this.pos += 4;
                return c2;
            }
            throw syntaxError("Unterminated escape sequence");
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private JsonToken readLiteral() throws IOException {
        this.value = nextLiteral(true);
        if (this.valueLength != 0) {
            this.token = decodeLiteral();
            if (this.token == JsonToken.STRING) {
                checkLenient();
            }
            return this.token;
        }
        throw syntaxError("Expected literal value");
    }

    private JsonToken decodeLiteral() throws IOException {
        int i = this.valuePos;
        if (i == -1) {
            return JsonToken.STRING;
        }
        if (this.valueLength == 4) {
            char[] cArr = this.buffer;
            if ('n' == cArr[i] || 'N' == cArr[i]) {
                char[] cArr2 = this.buffer;
                int i2 = this.valuePos;
                if ('u' == cArr2[i2 + 1] || 'U' == cArr2[i2 + 1]) {
                    char[] cArr3 = this.buffer;
                    int i3 = this.valuePos;
                    if ('l' == cArr3[i3 + 2] || 'L' == cArr3[i3 + 2]) {
                        char[] cArr4 = this.buffer;
                        int i4 = this.valuePos;
                        if ('l' == cArr4[i4 + 3] || 'L' == cArr4[i4 + 3]) {
                            this.value = "null";
                            return JsonToken.NULL;
                        }
                    }
                }
            }
        }
        if (this.valueLength == 4) {
            char[] cArr5 = this.buffer;
            int i5 = this.valuePos;
            if ('t' == cArr5[i5] || 'T' == cArr5[i5]) {
                char[] cArr6 = this.buffer;
                int i6 = this.valuePos;
                if ('r' == cArr6[i6 + 1] || 'R' == cArr6[i6 + 1]) {
                    char[] cArr7 = this.buffer;
                    int i7 = this.valuePos;
                    if ('u' == cArr7[i7 + 2] || 'U' == cArr7[i7 + 2]) {
                        char[] cArr8 = this.buffer;
                        int i8 = this.valuePos;
                        if ('e' == cArr8[i8 + 3] || 'E' == cArr8[i8 + 3]) {
                            this.value = TRUE;
                            return JsonToken.BOOLEAN;
                        }
                    }
                }
            }
        }
        if (this.valueLength == 5) {
            char[] cArr9 = this.buffer;
            int i9 = this.valuePos;
            if ('f' == cArr9[i9] || 'F' == cArr9[i9]) {
                char[] cArr10 = this.buffer;
                int i10 = this.valuePos;
                if ('a' == cArr10[i10 + 1] || 'A' == cArr10[i10 + 1]) {
                    char[] cArr11 = this.buffer;
                    int i11 = this.valuePos;
                    if ('l' == cArr11[i11 + 2] || 'L' == cArr11[i11 + 2]) {
                        char[] cArr12 = this.buffer;
                        int i12 = this.valuePos;
                        if ('s' == cArr12[i12 + 3] || 'S' == cArr12[i12 + 3]) {
                            char[] cArr13 = this.buffer;
                            int i13 = this.valuePos;
                            if ('e' == cArr13[i13 + 4] || 'E' == cArr13[i13 + 4]) {
                                this.value = FALSE;
                                return JsonToken.BOOLEAN;
                            }
                        }
                    }
                }
            }
        }
        this.value = this.stringPool.get(this.buffer, this.valuePos, this.valueLength);
        return decodeNumber(this.buffer, this.valuePos, this.valueLength);
    }

    private JsonToken decodeNumber(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        char c;
        char c2 = cArr[i];
        if (c2 == '-') {
            int i5 = i + 1;
            i3 = i5;
            c2 = cArr[i5];
        } else {
            i3 = i;
        }
        if (c2 == '0') {
            i4 = i3 + 1;
            c = cArr[i4];
        } else if (c2 < '1' || c2 > '9') {
            return JsonToken.STRING;
        } else {
            i4 = i3 + 1;
            c = cArr[i4];
            while (c >= '0' && c <= '9') {
                i4++;
                c = cArr[i4];
            }
        }
        if (c == '.') {
            int i6 = i4 + 1;
            char c3 = cArr[i6];
            while (c >= '0' && c <= '9') {
                i6 = i4 + 1;
                c3 = cArr[i6];
            }
        }
        if (c == 'e' || c == 'E') {
            int i7 = i4 + 1;
            char c4 = cArr[i7];
            if (c4 == '+' || c4 == '-') {
                i7++;
                c4 = cArr[i7];
            }
            if (c4 < '0' || c4 > '9') {
                return JsonToken.STRING;
            }
            int i8 = i7 + 1;
            char c5 = cArr[i8];
            while (c5 >= '0' && c5 <= '9') {
                i8 = i4 + 1;
                c5 = cArr[i8];
            }
        }
        if (i4 == i + i2) {
            return JsonToken.NUMBER;
        }
        return JsonToken.STRING;
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
}
