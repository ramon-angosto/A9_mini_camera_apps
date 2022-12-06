package androidx.browser.trusted;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class TokenContents {
    private final byte[] mContents;
    private List<byte[]> mFingerprints;
    private String mPackageName;

    static TokenContents deserialize(byte[] bArr) {
        return new TokenContents(bArr);
    }

    private TokenContents(byte[] bArr) {
        this.mContents = bArr;
    }

    static TokenContents create(String str, List<byte[]> list) throws IOException {
        return new TokenContents(createToken(str, list), str, list);
    }

    private TokenContents(byte[] bArr, String str, List<byte[]> list) {
        this.mContents = bArr;
        this.mPackageName = str;
        this.mFingerprints = new ArrayList(list.size());
        for (byte[] next : list) {
            this.mFingerprints.add(Arrays.copyOf(next, next.length));
        }
    }

    public String getPackageName() throws IOException {
        parseIfNeeded();
        String str = this.mPackageName;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException();
    }

    public int getFingerprintCount() throws IOException {
        parseIfNeeded();
        List<byte[]> list = this.mFingerprints;
        if (list != null) {
            return list.size();
        }
        throw new IllegalStateException();
    }

    public byte[] getFingerprint(int i) throws IOException {
        parseIfNeeded();
        List<byte[]> list = this.mFingerprints;
        if (list != null) {
            return Arrays.copyOf(list.get(i), this.mFingerprints.get(i).length);
        }
        throw new IllegalStateException();
    }

    public byte[] serialize() {
        byte[] bArr = this.mContents;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.mContents, ((TokenContents) obj).mContents);
    }

    public int hashCode() {
        return Arrays.hashCode(this.mContents);
    }

    private static byte[] createToken(String str, List<byte[]> list) throws IOException {
        Collections.sort(list, $$Lambda$TokenContents$EhAh0EiAbuzFn6siY46Fy8sz2WQ.INSTANCE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(str);
        dataOutputStream.writeInt(list.size());
        for (byte[] next : list) {
            dataOutputStream.writeInt(next.length);
            dataOutputStream.write(next);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r4v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r5v3, types: [byte] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r4v4, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r5v3, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int compareByteArrays(byte[] r4, byte[] r5) {
        /*
            r0 = 0
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            if (r4 != 0) goto L_0x0008
            r4 = -1
            return r4
        L_0x0008:
            if (r5 != 0) goto L_0x000c
            r4 = 1
            return r4
        L_0x000c:
            r1 = r0
        L_0x000d:
            int r2 = r4.length
            int r3 = r5.length
            int r2 = java.lang.Math.min(r2, r3)
            if (r1 >= r2) goto L_0x0024
            byte r2 = r4[r1]
            byte r3 = r5[r1]
            if (r2 == r3) goto L_0x0021
            byte r4 = r4[r1]
            byte r5 = r5[r1]
        L_0x001f:
            int r4 = r4 - r5
            return r4
        L_0x0021:
            int r1 = r1 + 1
            goto L_0x000d
        L_0x0024:
            int r1 = r4.length
            int r2 = r5.length
            if (r1 == r2) goto L_0x002b
            int r4 = r4.length
            int r5 = r5.length
            goto L_0x001f
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.browser.trusted.TokenContents.compareByteArrays(byte[], byte[]):int");
    }

    private void parseIfNeeded() throws IOException {
        if (this.mPackageName == null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.mContents));
            this.mPackageName = dataInputStream.readUTF();
            int readInt = dataInputStream.readInt();
            this.mFingerprints = new ArrayList(readInt);
            int i = 0;
            while (i < readInt) {
                int readInt2 = dataInputStream.readInt();
                byte[] bArr = new byte[readInt2];
                if (dataInputStream.read(bArr) == readInt2) {
                    this.mFingerprints.add(bArr);
                    i++;
                } else {
                    throw new IllegalStateException("Could not read fingerprint");
                }
            }
        }
    }
}
