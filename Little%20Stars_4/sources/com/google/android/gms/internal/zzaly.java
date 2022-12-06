package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class zzaly implements Closeable, Flushable {
    private static final String[] zzbZJ = new String[128];
    private static final String[] zzbZK;
    private final Writer out;
    private String separator;
    private boolean zzbWb;
    private boolean zzbWc;
    private String zzbZL;
    private String zzbZM;
    private boolean zzbZm;
    private int[] zzbZu = new int[32];
    private int zzbZv = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            zzbZJ[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = zzbZJ;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        zzbZK = (String[]) strArr.clone();
        String[] strArr2 = zzbZK;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public zzaly(Writer writer) {
        zznQ(6);
        this.separator = ":";
        this.zzbWb = true;
        if (writer != null) {
            this.out = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private void zzWA() throws IOException {
        if (this.zzbZL != null) {
            this.out.write("\n");
            int i = this.zzbZv;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.zzbZL);
            }
        }
    }

    private void zzWB() throws IOException {
        int zzWy = zzWy();
        if (zzWy == 5) {
            this.out.write(44);
        } else if (zzWy != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        zzWA();
        zznS(4);
    }

    private int zzWy() {
        int i = this.zzbZv;
        if (i != 0) {
            return this.zzbZu[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void zzWz() throws IOException {
        if (this.zzbZM != null) {
            zzWB();
            zziX(this.zzbZM);
            this.zzbZM = null;
        }
    }

    private void zzbb(boolean z) throws IOException {
        int zzWy = zzWy();
        if (zzWy == 1) {
            zznS(2);
        } else if (zzWy == 2) {
            this.out.append(',');
        } else if (zzWy != 4) {
            if (zzWy != 6) {
                if (zzWy != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.zzbZm) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            if (this.zzbZm || z) {
                zznS(7);
                return;
            }
            throw new IllegalStateException("JSON must start with an array or an object.");
        } else {
            this.out.append(this.separator);
            zznS(5);
            return;
        }
        zzWA();
    }

    private zzaly zzc(int i, int i2, String str) throws IOException {
        int zzWy = zzWy();
        if (zzWy == i2 || zzWy == i) {
            String str2 = this.zzbZM;
            if (str2 != null) {
                String valueOf = String.valueOf(str2);
                throw new IllegalStateException(valueOf.length() != 0 ? "Dangling name: ".concat(valueOf) : new String("Dangling name: "));
            }
            this.zzbZv--;
            if (zzWy == i2) {
                zzWA();
            }
            this.out.write(str);
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    private void zziX(String str) throws IOException {
        String str2;
        String[] strArr = this.zzbWc ? zzbZK : zzbZJ;
        this.out.write("\"");
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                this.out.write(str, i, i2 - i);
            }
            this.out.write(str2);
            i = i2 + 1;
        }
        if (i < length) {
            this.out.write(str, i, length - i);
        }
        this.out.write("\"");
    }

    private void zznQ(int i) {
        int i2 = this.zzbZv;
        int[] iArr = this.zzbZu;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(i2 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzbZu = iArr2;
        }
        int[] iArr3 = this.zzbZu;
        int i3 = this.zzbZv;
        this.zzbZv = i3 + 1;
        iArr3[i3] = i;
    }

    private void zznS(int i) {
        this.zzbZu[this.zzbZv - 1] = i;
    }

    private zzaly zzp(int i, String str) throws IOException {
        zzbb(true);
        zznQ(i);
        this.out.write(str);
        return this;
    }

    public void close() throws IOException {
        this.out.close();
        int i = this.zzbZv;
        if (i > 1 || (i == 1 && this.zzbZu[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.zzbZv = 0;
    }

    public void flush() throws IOException {
        if (this.zzbZv != 0) {
            this.out.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public boolean isLenient() {
        return this.zzbZm;
    }

    public final void setIndent(String str) {
        String str2;
        if (str.length() == 0) {
            this.zzbZL = null;
            str2 = ":";
        } else {
            this.zzbZL = str;
            str2 = ": ";
        }
        this.separator = str2;
    }

    public final void setLenient(boolean z) {
        this.zzbZm = z;
    }

    public zzaly zzWg() throws IOException {
        zzWz();
        return zzp(1, "[");
    }

    public zzaly zzWh() throws IOException {
        return zzc(1, 2, "]");
    }

    public zzaly zzWi() throws IOException {
        zzWz();
        return zzp(3, "{");
    }

    public zzaly zzWj() throws IOException {
        return zzc(3, 5, "}");
    }

    public zzaly zzWk() throws IOException {
        if (this.zzbZM != null) {
            if (this.zzbWb) {
                zzWz();
            } else {
                this.zzbZM = null;
                return this;
            }
        }
        zzbb(false);
        this.out.write("null");
        return this;
    }

    public final boolean zzWw() {
        return this.zzbWc;
    }

    public final boolean zzWx() {
        return this.zzbWb;
    }

    public zzaly zza(Number number) throws IOException {
        if (number == null) {
            return zzWk();
        }
        zzWz();
        String obj = number.toString();
        if (this.zzbZm || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            zzbb(false);
            this.out.append(obj);
            return this;
        }
        String valueOf = String.valueOf(number);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
        sb.append("Numeric values must be finite, but was ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    public zzaly zzaN(long j) throws IOException {
        zzWz();
        zzbb(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public zzaly zzaX(boolean z) throws IOException {
        zzWz();
        zzbb(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public final void zzaZ(boolean z) {
        this.zzbWc = z;
    }

    public final void zzba(boolean z) {
        this.zzbWb = z;
    }

    public zzaly zziT(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.zzbZM != null) {
            throw new IllegalStateException();
        } else if (this.zzbZv != 0) {
            this.zzbZM = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public zzaly zziU(String str) throws IOException {
        if (str == null) {
            return zzWk();
        }
        zzWz();
        zzbb(false);
        zziX(str);
        return this;
    }
}
