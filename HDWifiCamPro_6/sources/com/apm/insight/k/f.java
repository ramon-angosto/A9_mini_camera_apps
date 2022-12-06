package com.apm.insight.k;

import java.io.DataOutputStream;
import java.io.OutputStream;

public class f extends DataOutputStream {
    public f(OutputStream outputStream) {
        super(outputStream);
    }

    public void a() {
        super.close();
    }

    public void close() {
    }
}
