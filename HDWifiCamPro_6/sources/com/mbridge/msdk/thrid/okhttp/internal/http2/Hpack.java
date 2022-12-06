package com.mbridge.msdk.thrid.okhttp.internal.http2;

import androidx.browser.trusted.sharing.ShareTarget;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Source;
import com.vungle.warren.model.CookieDBAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

final class Hpack {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, (String) ShareTarget.METHOD_GET), new Header(Header.TARGET_METHOD, (String) ShareTarget.METHOD_POST), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header((String) IronSourceSegment.AGE, ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header((String) CookieDBAdapter.CookieColumns.TABLE_NAME, ""), new Header("date", ""), new Header((String) DownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header((String) RequestParameters.SUBRESOURCE_LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header((String) RequestParameters.SUBRESOURCE_REFERER, ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    private Hpack() {
    }

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        Reader(int i, Source source2) {
            this(i, i, source2);
        }

        Reader(int i, int i2, Source source2) {
            this.headerList = new ArrayList();
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.source = Okio.buffer(source2);
        }

        /* access modifiers changed from: package-private */
        public int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        private void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i2 - i);
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        int i3 = this.nextHeaderIndex;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.headerCount);
                        this.nextHeaderIndex += i2;
                    } else {
                        i -= this.dynamicTable[length].hpackSize;
                        this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                        this.headerCount--;
                        i2++;
                    }
                }
                Header[] headerArr2 = this.dynamicTable;
                int i32 = this.nextHeaderIndex;
                System.arraycopy(headerArr2, i32 + 1, headerArr2, i32 + 1 + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                byte readByte = this.source.readByte() & UByte.MAX_VALUE;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & ByteCompanionObject.MIN_VALUE) == 128) {
                    readIndexedHeader(readInt(readByte, Hpack.PREFIX_7_BITS) - 1);
                } else if (readByte == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((readByte & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(readByte, 31);
                    int i = this.maxDynamicTableByteCount;
                    if (i < 0 || i > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (readByte == 16 || readByte == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(readByte, 15) - 1);
                }
            }
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        private void readIndexedHeader(int i) throws IOException {
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[dynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int dynamicTableIndex(int i) {
            return this.nextHeaderIndex + 1 + i;
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) throws IOException {
            this.headerList.add(new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private ByteString getName(int i) throws IOException {
            if (isStaticHeader(i)) {
                return Hpack.STATIC_HEADER_TABLE[i].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    return headerArr[dynamicTableIndex].name;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private boolean isStaticHeader(int i) {
            return i >= 0 && i <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                i2 -= this.dynamicTable[dynamicTableIndex(i)].hpackSize;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            if (i == -1) {
                int i4 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i + dynamicTableIndex(i) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & UByte.MAX_VALUE;
        }

        /* access modifiers changed from: package-private */
        public int readInt(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i2 + (readByte << i4);
                }
                i2 += (readByte & Hpack.PREFIX_7_BITS) << i4;
                i4 += 7;
            }
        }

        /* access modifiers changed from: package-private */
        public ByteString readByteString() throws IOException {
            int readByte = readByte();
            boolean z = (readByte & 128) == 128;
            int readInt = readInt(readByte, Hpack.PREFIX_7_BITS);
            if (z) {
                return ByteString.of(Huffman.get().decode(this.source.readByteArray((long) readInt)));
            }
            return this.source.readByteString((long) readInt);
        }
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
            }
            i++;
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        Writer(int i, boolean z, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            this.useCompression = z;
            this.out = buffer;
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        int i3 = this.nextHeaderIndex;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.headerCount);
                        Header[] headerArr2 = this.dynamicTable;
                        int i4 = this.nextHeaderIndex;
                        Arrays.fill(headerArr2, i4 + 1, i4 + 1 + i2, (Object) null);
                        this.nextHeaderIndex += i2;
                    } else {
                        i -= this.dynamicTable[length].hpackSize;
                        this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                        this.headerCount--;
                        i2++;
                    }
                }
                Header[] headerArr3 = this.dynamicTable;
                int i32 = this.nextHeaderIndex;
                System.arraycopy(headerArr3, i32 + 1, headerArr3, i32 + 1 + i2, this.headerCount);
                Header[] headerArr22 = this.dynamicTable;
                int i42 = this.nextHeaderIndex;
                Arrays.fill(headerArr22, i42 + 1, i42 + 1 + i2, (Object) null);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        private void insertIntoDynamicTable(Header header) {
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeHeaders(java.util.List<com.mbridge.msdk.thrid.okhttp.internal.http2.Header> r14) throws java.io.IOException {
            /*
                r13 = this;
                boolean r0 = r13.emitDynamicTableSizeUpdate
                r1 = 0
                if (r0 == 0) goto L_0x001e
                int r0 = r13.smallestHeaderTableSizeSetting
                int r2 = r13.maxDynamicTableByteCount
                r3 = 32
                r4 = 31
                if (r0 >= r2) goto L_0x0012
                r13.writeInt(r0, r4, r3)
            L_0x0012:
                r13.emitDynamicTableSizeUpdate = r1
                r0 = 2147483647(0x7fffffff, float:NaN)
                r13.smallestHeaderTableSizeSetting = r0
                int r0 = r13.maxDynamicTableByteCount
                r13.writeInt(r0, r4, r3)
            L_0x001e:
                int r0 = r14.size()
                r2 = r1
            L_0x0023:
                if (r2 >= r0) goto L_0x00ec
                java.lang.Object r3 = r14.get(r2)
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header r3 = (com.mbridge.msdk.thrid.okhttp.internal.http2.Header) r3
                com.mbridge.msdk.thrid.okio.ByteString r4 = r3.name
                com.mbridge.msdk.thrid.okio.ByteString r4 = r4.toAsciiLowercase()
                com.mbridge.msdk.thrid.okio.ByteString r5 = r3.value
                java.util.Map<com.mbridge.msdk.thrid.okio.ByteString, java.lang.Integer> r6 = com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.NAME_TO_FIRST_INDEX
                java.lang.Object r6 = r6.get(r4)
                java.lang.Integer r6 = (java.lang.Integer) r6
                r7 = -1
                r8 = 1
                if (r6 == 0) goto L_0x006e
                int r6 = r6.intValue()
                int r6 = r6 + r8
                if (r6 <= r8) goto L_0x006b
                r9 = 8
                if (r6 >= r9) goto L_0x006b
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r9 = com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.STATIC_HEADER_TABLE
                int r10 = r6 + -1
                r9 = r9[r10]
                com.mbridge.msdk.thrid.okio.ByteString r9 = r9.value
                boolean r9 = com.mbridge.msdk.thrid.okhttp.internal.Util.equal(r9, r5)
                if (r9 == 0) goto L_0x0059
                goto L_0x006f
            L_0x0059:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r9 = com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.STATIC_HEADER_TABLE
                r9 = r9[r6]
                com.mbridge.msdk.thrid.okio.ByteString r9 = r9.value
                boolean r9 = com.mbridge.msdk.thrid.okhttp.internal.Util.equal(r9, r5)
                if (r9 == 0) goto L_0x006b
                int r9 = r6 + 1
                r12 = r9
                r9 = r6
                r6 = r12
                goto L_0x0070
            L_0x006b:
                r9 = r6
                r6 = r7
                goto L_0x0070
            L_0x006e:
                r6 = r7
            L_0x006f:
                r9 = r6
            L_0x0070:
                if (r6 != r7) goto L_0x00a7
                int r10 = r13.nextHeaderIndex
                int r10 = r10 + r8
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r8 = r13.dynamicTable
                int r8 = r8.length
            L_0x0078:
                if (r10 >= r8) goto L_0x00a7
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r11 = r13.dynamicTable
                r11 = r11[r10]
                com.mbridge.msdk.thrid.okio.ByteString r11 = r11.name
                boolean r11 = com.mbridge.msdk.thrid.okhttp.internal.Util.equal(r11, r4)
                if (r11 == 0) goto L_0x00a4
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r11 = r13.dynamicTable
                r11 = r11[r10]
                com.mbridge.msdk.thrid.okio.ByteString r11 = r11.value
                boolean r11 = com.mbridge.msdk.thrid.okhttp.internal.Util.equal(r11, r5)
                if (r11 == 0) goto L_0x009a
                int r6 = r13.nextHeaderIndex
                int r10 = r10 - r6
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r6 = com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.STATIC_HEADER_TABLE
                int r6 = r6.length
                int r6 = r6 + r10
                goto L_0x00a7
            L_0x009a:
                if (r9 != r7) goto L_0x00a4
                int r9 = r13.nextHeaderIndex
                int r9 = r10 - r9
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r11 = com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.STATIC_HEADER_TABLE
                int r11 = r11.length
                int r9 = r9 + r11
            L_0x00a4:
                int r10 = r10 + 1
                goto L_0x0078
            L_0x00a7:
                if (r6 == r7) goto L_0x00b1
                r3 = 127(0x7f, float:1.78E-43)
                r4 = 128(0x80, float:1.794E-43)
                r13.writeInt(r6, r3, r4)
                goto L_0x00e8
            L_0x00b1:
                r6 = 64
                if (r9 != r7) goto L_0x00c4
                com.mbridge.msdk.thrid.okio.Buffer r7 = r13.out
                r7.writeByte((int) r6)
                r13.writeByteString(r4)
                r13.writeByteString(r5)
                r13.insertIntoDynamicTable(r3)
                goto L_0x00e8
            L_0x00c4:
                com.mbridge.msdk.thrid.okio.ByteString r7 = com.mbridge.msdk.thrid.okhttp.internal.http2.Header.PSEUDO_PREFIX
                boolean r7 = r4.startsWith((com.mbridge.msdk.thrid.okio.ByteString) r7)
                if (r7 == 0) goto L_0x00dd
                com.mbridge.msdk.thrid.okio.ByteString r7 = com.mbridge.msdk.thrid.okhttp.internal.http2.Header.TARGET_AUTHORITY
                boolean r4 = r7.equals(r4)
                if (r4 != 0) goto L_0x00dd
                r3 = 15
                r13.writeInt(r9, r3, r1)
                r13.writeByteString(r5)
                goto L_0x00e8
            L_0x00dd:
                r4 = 63
                r13.writeInt(r9, r4, r6)
                r13.writeByteString(r5)
                r13.insertIntoDynamicTable(r3)
            L_0x00e8:
                int r2 = r2 + 1
                goto L_0x0023
            L_0x00ec:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        /* access modifiers changed from: package-private */
        public void writeInt(int i, int i2, int i3) {
            if (i < i2) {
                this.out.writeByte(i | i3);
                return;
            }
            this.out.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.out.writeByte(128 | (i4 & Hpack.PREFIX_7_BITS));
                i4 >>>= 7;
            }
            this.out.writeByte(i4);
        }

        /* access modifiers changed from: package-private */
        public void writeByteString(ByteString byteString) throws IOException {
            if (!this.useCompression || Huffman.get().encodedLength(byteString) >= byteString.size()) {
                writeInt(byteString.size(), Hpack.PREFIX_7_BITS, 0);
                this.out.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            Huffman.get().encode(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            writeInt(readByteString.size(), Hpack.PREFIX_7_BITS, 128);
            this.out.write(readByteString);
        }

        /* access modifiers changed from: package-private */
        public void setHeaderTableSizeSetting(int i) {
            this.headerTableSizeSetting = i;
            int min = Math.min(i, 16384);
            int i2 = this.maxDynamicTableByteCount;
            if (i2 != min) {
                if (min < i2) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = min;
                adjustDynamicTableByteCount();
            }
        }

        private void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i2 - i);
            }
        }
    }

    static ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i = 0;
        while (i < size) {
            byte b = byteString.getByte(i);
            if (b < 65 || b > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
