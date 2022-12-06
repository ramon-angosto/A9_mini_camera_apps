package com.apm.insight.k;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class m extends GZIPOutputStream {
    public m(OutputStream outputStream) {
        super(outputStream);
    }

    public void a() {
        super.close();
    }

    public void b() {
        super.finish();
    }

    public void close() {
    }

    public void finish() {
    }
}
