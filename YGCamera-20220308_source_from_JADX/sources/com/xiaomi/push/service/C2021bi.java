package com.xiaomi.push.service;

import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1660bl;

/* renamed from: com.xiaomi.push.service.bi */
public class C2021bi {

    /* renamed from: a */
    private static int f3815a = 8;

    /* renamed from: a */
    private byte[] f3816a = new byte[256];

    /* renamed from: b */
    private int f3817b = 0;

    /* renamed from: c */
    private int f3818c = 0;

    /* renamed from: d */
    private int f3819d = -666;

    /* renamed from: a */
    public static int m5128a(byte b) {
        return b >= 0 ? b : b + 256;
    }

    /* renamed from: a */
    private void mo18501a() {
        this.f3818c = 0;
        this.f3817b = 0;
    }

    /* renamed from: a */
    private void m5130a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f3816a[i2] = (byte) i2;
        }
        this.f3818c = 0;
        this.f3817b = 0;
        while (true) {
            int i3 = this.f3817b;
            if (i3 >= i) {
                break;
            }
            this.f3818c = ((this.f3818c + m5128a(this.f3816a[i3])) + m5128a(bArr[this.f3817b % length])) % 256;
            m5132a(this.f3816a, this.f3817b, this.f3818c);
            this.f3817b++;
        }
        if (i != 256) {
            this.f3819d = ((this.f3818c + m5128a(this.f3816a[i])) + m5128a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i4 = i - 1;
            sb.append(i4);
            sb.append(Constants.COLON_SEPARATOR);
            for (int i5 = 0; i5 <= i; i5++) {
                sb.append(" ");
                sb.append(m5128a(this.f3816a[i5]));
            }
            sb.append("   j_");
            sb.append(i4);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(this.f3818c);
            sb.append("   j_");
            sb.append(i);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(this.f3819d);
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i4);
            sb.append("]=");
            sb.append(m5128a(this.f3816a[this.f3818c]));
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i);
            sb.append("]=");
            sb.append(m5128a(this.f3816a[this.f3819d]));
            if (this.f3816a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            C1524b.m2141a(sb.toString());
        }
    }

    /* renamed from: a */
    private void m5131a(byte[] bArr) {
        m5130a(256, bArr, false);
    }

    /* renamed from: a */
    private static void m5132a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    /* renamed from: a */
    public static byte[] m5133a(String str, String str2) {
        byte[] a = C1660bl.m2714a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[(a.length + 1 + bytes.length)];
        for (int i = 0; i < a.length; i++) {
            bArr[i] = a[i];
        }
        bArr[a.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[a.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m5134a(byte[] bArr, String str) {
        return m5135a(bArr, C1660bl.m2714a(str));
    }

    /* renamed from: a */
    public static byte[] m5135a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        C2021bi biVar = new C2021bi();
        biVar.m5131a(bArr);
        biVar.mo18501a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ biVar.mo18501a());
        }
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m5136a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i + " len = " + i2);
        }
        if (!z) {
            bArr3 = new byte[i2];
            i3 = 0;
        } else {
            bArr3 = bArr2;
            i3 = i;
        }
        C2021bi biVar = new C2021bi();
        biVar.m5131a(bArr);
        biVar.mo18501a();
        for (int i4 = 0; i4 < i2; i4++) {
            bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ biVar.mo18501a());
        }
        return bArr3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte m5137a() {
        this.f3817b = (this.f3817b + 1) % 256;
        this.f3818c = (this.f3818c + m5128a(this.f3816a[this.f3817b])) % 256;
        m5132a(this.f3816a, this.f3817b, this.f3818c);
        byte[] bArr = this.f3816a;
        return bArr[(m5128a(bArr[this.f3817b]) + m5128a(this.f3816a[this.f3818c])) % 256];
    }
}
