package com.google.android.gms.common.images;

public final class Size {
    private final int zzpi;
    private final int zzpj;

    public Size(int i, int i2) {
        this.zzpi = i;
        this.zzpj = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw zzdb(str);
                }
            } else {
                throw zzdb(str);
            }
        } else {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    private static NumberFormatException zzdb(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 16);
        sb.append("Invalid Size: \"");
        sb.append(str);
        sb.append("\"");
        throw new NumberFormatException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.zzpi == size.zzpi && this.zzpj == size.zzpj;
    }

    public int getHeight() {
        return this.zzpj;
    }

    public int getWidth() {
        return this.zzpi;
    }

    public int hashCode() {
        int i = this.zzpj;
        int i2 = this.zzpi;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        int i = this.zzpi;
        int i2 = this.zzpj;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }
}
