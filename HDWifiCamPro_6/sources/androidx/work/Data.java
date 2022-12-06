package androidx.work;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Data {
    public static final Data EMPTY = new Builder().build();
    public static final int MAX_DATA_BYTES = 10240;
    private static final String TAG = Logger.tagWithPrefix("Data");
    Map<String, Object> mValues;

    Data() {
    }

    public Data(Data data) {
        this.mValues = new HashMap(data.mValues);
    }

    public Data(Map<String, ?> map) {
        this.mValues = new HashMap(map);
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = this.mValues.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public boolean[] getBooleanArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Boolean[]) {
            return convertToPrimitiveArray((Boolean[]) obj);
        }
        return null;
    }

    public byte getByte(String str, byte b) {
        Object obj = this.mValues.get(str);
        return obj instanceof Byte ? ((Byte) obj).byteValue() : b;
    }

    public byte[] getByteArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Byte[]) {
            return convertToPrimitiveArray((Byte[]) obj);
        }
        return null;
    }

    public int getInt(String str, int i) {
        Object obj = this.mValues.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i;
    }

    public int[] getIntArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Integer[]) {
            return convertToPrimitiveArray((Integer[]) obj);
        }
        return null;
    }

    public long getLong(String str, long j) {
        Object obj = this.mValues.get(str);
        return obj instanceof Long ? ((Long) obj).longValue() : j;
    }

    public long[] getLongArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Long[]) {
            return convertToPrimitiveArray((Long[]) obj);
        }
        return null;
    }

    public float getFloat(String str, float f) {
        Object obj = this.mValues.get(str);
        return obj instanceof Float ? ((Float) obj).floatValue() : f;
    }

    public float[] getFloatArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Float[]) {
            return convertToPrimitiveArray((Float[]) obj);
        }
        return null;
    }

    public double getDouble(String str, double d) {
        Object obj = this.mValues.get(str);
        return obj instanceof Double ? ((Double) obj).doubleValue() : d;
    }

    public double[] getDoubleArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Double[]) {
            return convertToPrimitiveArray((Double[]) obj);
        }
        return null;
    }

    public String getString(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public String[] getStringArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        return null;
    }

    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public byte[] toByteArray() {
        return toByteArrayInternal(this);
    }

    public <T> boolean hasKeyWithValueOfType(String str, Class<T> cls) {
        Object obj = this.mValues.get(str);
        return obj != null && cls.isAssignableFrom(obj.getClass());
    }

    public int size() {
        return this.mValues.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A[SYNTHETIC, Splitter:B:31:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008f A[SYNTHETIC, Splitter:B:41:0x008f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArrayInternal(androidx.work.Data r5) {
        /*
            java.lang.String r0 = "Error in Data#toByteArray: "
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x006c }
            r3.<init>(r1)     // Catch:{ IOException -> 0x006c }
            int r2 = r5.size()     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            r3.writeInt(r2)     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            java.util.Map<java.lang.String, java.lang.Object> r5 = r5.mValues     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
        L_0x001e:
            boolean r2 = r5.hasNext()     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r5.next()     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            java.lang.Object r4 = r2.getKey()     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            r3.writeUTF(r4)     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            r3.writeObject(r2)     // Catch:{ IOException -> 0x0066, all -> 0x0064 }
            goto L_0x001e
        L_0x003b:
            r3.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0045
        L_0x003f:
            r5 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r5)
        L_0x0045:
            r1.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004f
        L_0x0049:
            r5 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r5)
        L_0x004f:
            int r5 = r1.size()
            r0 = 10240(0x2800, float:1.4349E-41)
            if (r5 > r0) goto L_0x005c
            byte[] r5 = r1.toByteArray()
            return r5
        L_0x005c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        L_0x0064:
            r5 = move-exception
            goto L_0x008d
        L_0x0066:
            r5 = move-exception
            r2 = r3
            goto L_0x006d
        L_0x0069:
            r5 = move-exception
            r3 = r2
            goto L_0x008d
        L_0x006c:
            r5 = move-exception
        L_0x006d:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0069 }
            android.util.Log.e(r3, r0, r5)     // Catch:{ all -> 0x0069 }
            byte[] r5 = r1.toByteArray()     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x0082
            r2.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0082
        L_0x007c:
            r2 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r2)
        L_0x0082:
            r1.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008c
        L_0x0086:
            r1 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r1)
        L_0x008c:
            return r5
        L_0x008d:
            if (r3 == 0) goto L_0x0099
            r3.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0099
        L_0x0093:
            r2 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r2)
        L_0x0099:
            r1.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a3
        L_0x009d:
            r1 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r1)
        L_0x00a3:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.toByteArrayInternal(androidx.work.Data):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e A[SYNTHETIC, Splitter:B:24:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b A[SYNTHETIC, Splitter:B:36:0x006b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0035=Splitter:B:14:0x0035, B:28:0x0058=Splitter:B:28:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.Data fromByteArray(byte[] r7) {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            int r1 = r7.length
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r2) goto L_0x0080
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0043, ClassNotFoundException -> 0x0041, all -> 0x003d }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0043, ClassNotFoundException -> 0x0041, all -> 0x003d }
            int r7 = r3.readInt()     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
        L_0x001b:
            if (r7 <= 0) goto L_0x002b
            java.lang.String r4 = r3.readUTF()     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
            java.lang.Object r5 = r3.readObject()     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
            r1.put(r4, r5)     // Catch:{ IOException -> 0x003b, ClassNotFoundException -> 0x0039 }
            int r7 = r7 + -1
            goto L_0x001b
        L_0x002b:
            r3.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0035
        L_0x002f:
            r7 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r7)
        L_0x0035:
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0062
        L_0x0039:
            r7 = move-exception
            goto L_0x0047
        L_0x003b:
            r7 = move-exception
            goto L_0x0047
        L_0x003d:
            r1 = move-exception
            r3 = r7
            r7 = r1
            goto L_0x0069
        L_0x0041:
            r3 = move-exception
            goto L_0x0044
        L_0x0043:
            r3 = move-exception
        L_0x0044:
            r6 = r3
            r3 = r7
            r7 = r6
        L_0x0047:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0068 }
            android.util.Log.e(r4, r0, r7)     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0058
        L_0x0052:
            r7 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r7)
        L_0x0058:
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0062
        L_0x005c:
            r7 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r7)
        L_0x0062:
            androidx.work.Data r7 = new androidx.work.Data
            r7.<init>((java.util.Map<java.lang.String, ?>) r1)
            return r7
        L_0x0068:
            r7 = move-exception
        L_0x0069:
            if (r3 == 0) goto L_0x0075
            r3.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0075
        L_0x006f:
            r1 = move-exception
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r0, r1)
        L_0x0075:
            r2.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007f
        L_0x0079:
            r1 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r0, r1)
        L_0x007f:
            throw r7
        L_0x0080:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.fromByteArray(byte[]):androidx.work.Data");
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.mValues.keySet();
        if (!keySet.equals(data.mValues.keySet())) {
            return false;
        }
        for (String next : keySet) {
            Object obj2 = this.mValues.get(next);
            Object obj3 = data.mValues.get(next);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z = obj2.equals(obj3);
                continue;
            } else {
                z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String next : this.mValues.keySet()) {
                sb.append(next);
                sb.append(" : ");
                Object obj = this.mValues.get(next);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static Integer[] convertPrimitiveIntArray(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Long[] convertPrimitiveLongArray(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    public static Float[] convertPrimitiveFloatArray(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    public static boolean[] convertToPrimitiveArray(Boolean[] boolArr) {
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    public static byte[] convertToPrimitiveArray(Byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    public static int[] convertToPrimitiveArray(Integer[] numArr) {
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public static long[] convertToPrimitiveArray(Long[] lArr) {
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    public static float[] convertToPrimitiveArray(Float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    public static double[] convertToPrimitiveArray(Double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    public static final class Builder {
        private Map<String, Object> mValues = new HashMap();

        public Builder putBoolean(String str, boolean z) {
            this.mValues.put(str, Boolean.valueOf(z));
            return this;
        }

        public Builder putBooleanArray(String str, boolean[] zArr) {
            this.mValues.put(str, Data.convertPrimitiveBooleanArray(zArr));
            return this;
        }

        public Builder putByte(String str, byte b) {
            this.mValues.put(str, Byte.valueOf(b));
            return this;
        }

        public Builder putByteArray(String str, byte[] bArr) {
            this.mValues.put(str, Data.convertPrimitiveByteArray(bArr));
            return this;
        }

        public Builder putInt(String str, int i) {
            this.mValues.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder putIntArray(String str, int[] iArr) {
            this.mValues.put(str, Data.convertPrimitiveIntArray(iArr));
            return this;
        }

        public Builder putLong(String str, long j) {
            this.mValues.put(str, Long.valueOf(j));
            return this;
        }

        public Builder putLongArray(String str, long[] jArr) {
            this.mValues.put(str, Data.convertPrimitiveLongArray(jArr));
            return this;
        }

        public Builder putFloat(String str, float f) {
            this.mValues.put(str, Float.valueOf(f));
            return this;
        }

        public Builder putFloatArray(String str, float[] fArr) {
            this.mValues.put(str, Data.convertPrimitiveFloatArray(fArr));
            return this;
        }

        public Builder putDouble(String str, double d) {
            this.mValues.put(str, Double.valueOf(d));
            return this;
        }

        public Builder putDoubleArray(String str, double[] dArr) {
            this.mValues.put(str, Data.convertPrimitiveDoubleArray(dArr));
            return this;
        }

        public Builder putString(String str, String str2) {
            this.mValues.put(str, str2);
            return this;
        }

        public Builder putStringArray(String str, String[] strArr) {
            this.mValues.put(str, strArr);
            return this;
        }

        public Builder putAll(Data data) {
            putAll(data.mValues);
            return this;
        }

        public Builder putAll(Map<String, Object> map) {
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
            return this;
        }

        public Builder put(String str, Object obj) {
            if (obj == null) {
                this.mValues.put(str, (Object) null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.mValues.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.mValues.put(str, Data.convertPrimitiveBooleanArray((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.mValues.put(str, Data.convertPrimitiveByteArray((byte[]) obj));
                } else if (cls == int[].class) {
                    this.mValues.put(str, Data.convertPrimitiveIntArray((int[]) obj));
                } else if (cls == long[].class) {
                    this.mValues.put(str, Data.convertPrimitiveLongArray((long[]) obj));
                } else if (cls == float[].class) {
                    this.mValues.put(str, Data.convertPrimitiveFloatArray((float[]) obj));
                } else if (cls == double[].class) {
                    this.mValues.put(str, Data.convertPrimitiveDoubleArray((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[]{str, cls}));
                }
            }
            return this;
        }

        public Data build() {
            Data data = new Data((Map<String, ?>) this.mValues);
            Data.toByteArrayInternal(data);
            return data;
        }
    }
}
