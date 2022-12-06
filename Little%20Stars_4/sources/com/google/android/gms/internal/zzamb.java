package com.google.android.gms.internal;

import java.io.IOException;

public final class zzamb {
    private final byte[] buffer;
    private int zzbZQ;
    private int zzbZR;
    private int zzbZS;
    private int zzbZT;
    private int zzbZU;
    private int zzbZV = Integer.MAX_VALUE;
    private int zzbZW;
    private int zzbZX = 64;
    private int zzbZY = 67108864;

    private zzamb(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbZQ = i;
        this.zzbZR = i2 + i;
        this.zzbZT = i;
    }

    public static zzamb zzN(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    private void zzWP() {
        this.zzbZR += this.zzbZS;
        int i = this.zzbZR;
        int i2 = this.zzbZV;
        if (i > i2) {
            this.zzbZS = i - i2;
            this.zzbZR = i - this.zzbZS;
            return;
        }
        this.zzbZS = 0;
    }

    public static zzamb zza(byte[] bArr, int i, int i2) {
        return new zzamb(bArr, i, i2);
    }

    public static long zzaO(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zznV(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public int getPosition() {
        return this.zzbZT - this.zzbZQ;
    }

    public byte[] readBytes() throws IOException {
        int zzWL = zzWL();
        if (zzWL < 0) {
            throw zzami.zzWY();
        } else if (zzWL == 0) {
            return zzamm.zzcas;
        } else {
            int i = this.zzbZR;
            int i2 = this.zzbZT;
            if (zzWL <= i - i2) {
                byte[] bArr = new byte[zzWL];
                System.arraycopy(this.buffer, i2, bArr, 0, zzWL);
                this.zzbZT += zzWL;
                return bArr;
            }
            throw zzami.zzWX();
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzWO());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzWN());
    }

    public String readString() throws IOException {
        int zzWL = zzWL();
        if (zzWL >= 0) {
            int i = this.zzbZR;
            int i2 = this.zzbZT;
            if (zzWL <= i - i2) {
                String str = new String(this.buffer, i2, zzWL, zzamh.UTF_8);
                this.zzbZT += zzWL;
                return str;
            }
            throw zzami.zzWX();
        }
        throw zzami.zzWY();
    }

    public byte[] zzD(int i, int i2) {
        if (i2 == 0) {
            return zzamm.zzcas;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbZQ + i, bArr, 0, i2);
        return bArr;
    }

    public int zzWC() throws IOException {
        if (zzWR()) {
            this.zzbZU = 0;
            return 0;
        }
        this.zzbZU = zzWL();
        int i = this.zzbZU;
        if (i != 0) {
            return i;
        }
        throw zzami.zzXa();
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void zzWD() throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.zzWC()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.zznU(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamb.zzWD():void");
    }

    public long zzWE() throws IOException {
        return zzWM();
    }

    public long zzWF() throws IOException {
        return zzWM();
    }

    public int zzWG() throws IOException {
        return zzWL();
    }

    public long zzWH() throws IOException {
        return zzWO();
    }

    public boolean zzWI() throws IOException {
        return zzWL() != 0;
    }

    public int zzWJ() throws IOException {
        return zznV(zzWL());
    }

    public long zzWK() throws IOException {
        return zzaO(zzWM());
    }

    public int zzWL() throws IOException {
        int i;
        byte zzWS = zzWS();
        if (zzWS >= 0) {
            return zzWS;
        }
        byte b = zzWS & Byte.MAX_VALUE;
        byte zzWS2 = zzWS();
        if (zzWS2 >= 0) {
            i = zzWS2 << 7;
        } else {
            b |= (zzWS2 & Byte.MAX_VALUE) << 7;
            byte zzWS3 = zzWS();
            if (zzWS3 >= 0) {
                i = zzWS3 << 14;
            } else {
                b |= (zzWS3 & Byte.MAX_VALUE) << 14;
                byte zzWS4 = zzWS();
                if (zzWS4 >= 0) {
                    i = zzWS4 << 21;
                } else {
                    byte b2 = b | ((zzWS4 & Byte.MAX_VALUE) << 21);
                    byte zzWS5 = zzWS();
                    byte b3 = b2 | (zzWS5 << 28);
                    if (zzWS5 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (zzWS() >= 0) {
                            return b3;
                        }
                    }
                    throw zzami.zzWZ();
                }
            }
        }
        return b | i;
    }

    public long zzWM() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzWS = zzWS();
            j |= ((long) (zzWS & Byte.MAX_VALUE)) << i;
            if ((zzWS & 128) == 0) {
                return j;
            }
        }
        throw zzami.zzWZ();
    }

    public int zzWN() throws IOException {
        return (zzWS() & 255) | ((zzWS() & 255) << 8) | ((zzWS() & 255) << 16) | ((zzWS() & 255) << 24);
    }

    public long zzWO() throws IOException {
        byte zzWS = zzWS();
        byte zzWS2 = zzWS();
        return ((((long) zzWS2) & 255) << 8) | (((long) zzWS) & 255) | ((((long) zzWS()) & 255) << 16) | ((((long) zzWS()) & 255) << 24) | ((((long) zzWS()) & 255) << 32) | ((((long) zzWS()) & 255) << 40) | ((((long) zzWS()) & 255) << 48) | ((((long) zzWS()) & 255) << 56);
    }

    public int zzWQ() {
        int i = this.zzbZV;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzbZT;
    }

    public boolean zzWR() {
        return this.zzbZT == this.zzbZR;
    }

    public byte zzWS() throws IOException {
        int i = this.zzbZT;
        if (i != this.zzbZR) {
            byte[] bArr = this.buffer;
            this.zzbZT = i + 1;
            return bArr[i];
        }
        throw zzami.zzWX();
    }

    public void zza(zzamj zzamj) throws IOException {
        int zzWL = zzWL();
        if (this.zzbZW < this.zzbZX) {
            int zznW = zznW(zzWL);
            this.zzbZW++;
            zzamj.mergeFrom(this);
            zznT(0);
            this.zzbZW--;
            zznX(zznW);
            return;
        }
        throw zzami.zzXd();
    }

    public void zza(zzamj zzamj, int i) throws IOException {
        int i2 = this.zzbZW;
        if (i2 < this.zzbZX) {
            this.zzbZW = i2 + 1;
            zzamj.mergeFrom(this);
            zznT(zzamm.zzJ(i, 4));
            this.zzbZW--;
            return;
        }
        throw zzami.zzXd();
    }

    public void zznT(int i) throws zzami {
        if (this.zzbZU != i) {
            throw zzami.zzXb();
        }
    }

    public boolean zznU(int i) throws IOException {
        int zzon = zzamm.zzon(i);
        if (zzon == 0) {
            zzWG();
            return true;
        } else if (zzon == 1) {
            zzWO();
            return true;
        } else if (zzon == 2) {
            zznZ(zzWL());
            return true;
        } else if (zzon == 3) {
            zzWD();
            zznT(zzamm.zzJ(zzamm.zzoo(i), 4));
            return true;
        } else if (zzon == 4) {
            return false;
        } else {
            if (zzon == 5) {
                zzWN();
                return true;
            }
            throw zzami.zzXc();
        }
    }

    public int zznW(int i) throws zzami {
        if (i >= 0) {
            int i2 = i + this.zzbZT;
            int i3 = this.zzbZV;
            if (i2 <= i3) {
                this.zzbZV = i2;
                zzWP();
                return i3;
            }
            throw zzami.zzWX();
        }
        throw zzami.zzWY();
    }

    public void zznX(int i) {
        this.zzbZV = i;
        zzWP();
    }

    public void zznY(int i) {
        int i2 = this.zzbZT;
        int i3 = this.zzbZQ;
        if (i > i2 - i3) {
            int i4 = i2 - i3;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i4);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= 0) {
            this.zzbZT = i3 + i;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public void zznZ(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzbZT;
            int i3 = i2 + i;
            int i4 = this.zzbZV;
            if (i3 > i4) {
                zznZ(i4 - i2);
                throw zzami.zzWX();
            } else if (i <= this.zzbZR - i2) {
                this.zzbZT = i2 + i;
            } else {
                throw zzami.zzWX();
            }
        } else {
            throw zzami.zzWY();
        }
    }
}
