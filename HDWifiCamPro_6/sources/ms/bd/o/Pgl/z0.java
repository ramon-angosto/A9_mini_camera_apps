package ms.bd.o.Pgl;

import kotlin.text.Typography;

public class z0 {
    static {
        String str = (String) pblk.a(16777217, 0, 0, "1772ea", new byte[]{27, 105, 5, 24, 103});
    }

    public static String a(String str) {
        return (str == null || str.length() <= 0) ? "" : str.trim().replace('\'', ' ').replace(Typography.quote, ' ').replace(13, ' ').replace(10, ' ');
    }
}
