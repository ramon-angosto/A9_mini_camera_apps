package com.google.zxing.datamatrix.encoder;

import com.ironsource.mediationsdk.logger.IronSourceError;

final class DataMatrixSymbolInfo144 extends SymbolInfo {
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? 156 : 155;
    }

    public int getInterleavedBlockCount() {
        return 10;
    }

    DataMatrixSymbolInfo144() {
        super(false, 1558, IronSourceError.ERROR_DO_BN_LOAD_DURING_SHOW, 22, 22, 36, -1, 62);
    }
}
