package com.google.zxing.maxicode.decoder;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.common.BitMatrix;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import ms.bd.o.Pgl.c;

final class BitMatrixParser {
    private static final int[][] BITNR;
    private final BitMatrix bitMatrix;

    static {
        int[] iArr = new int[30];
        iArr[0] = 481;
        iArr[1] = 480;
        iArr[2] = 475;
        iArr[3] = 474;
        iArr[4] = 469;
        iArr[5] = 468;
        iArr[6] = 48;
        iArr[7] = -2;
        iArr[8] = 30;
        iArr[9] = -3;
        iArr[10] = -3;
        iArr[11] = -3;
        iArr[12] = -3;
        iArr[13] = -3;
        iArr[14] = -3;
        iArr[15] = -3;
        iArr[16] = -3;
        iArr[17] = -3;
        iArr[18] = -3;
        iArr[20] = 53;
        iArr[21] = 52;
        iArr[22] = 463;
        iArr[23] = 462;
        iArr[24] = 457;
        iArr[25] = 456;
        iArr[26] = 451;
        iArr[27] = 450;
        iArr[28] = 837;
        iArr[29] = -3;
        BITNR = new int[][]{new int[]{121, 120, 127, 126, 133, 132, 139, TsExtractor.TS_STREAM_TYPE_DTS, 145, 144, 151, IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, 157, 156, 163, 162, 169, 168, 175, 174, 181, 180, 187, 186, 193, PsExtractor.AUDIO_STREAM, 199, 198, -2, -2}, new int[]{123, 122, TsExtractor.TS_STREAM_TYPE_AC3, 128, TsExtractor.TS_STREAM_TYPE_E_AC3, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 141, IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 147, 146, 153, 152, 159, 158, 165, 164, 171, 170, 177, 176, 183, 182, PsExtractor.PRIVATE_STREAM_1, 188, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 137, 136, 143, 142, 149, 148, 155, 154, 161, 160, 167, 166, 173, 172, 179, 178, 185, 184, 191, 190, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, 259, 258, 253, 252, 247, 246, 241, PsExtractor.VIDEO_STREAM_MASK, 235, 234, 229, 228, 223, 222, 217, 216, 211, 210, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, 273, 272, 267, 266, 261, 260, 255, 254, 249, 248, 243, 242, 237, 236, 231, 230, 225, 224, 219, 218, 213, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, c.COLLECT_MODE_ML_TEEN, 275, 274, 269, 268, 263, 262, InputDeviceCompat.SOURCE_KEYBOARD, 256, 251, 250, 245, 244, 239, 238, 233, 232, 227, 226, 221, 220, 215, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, c.COLLECT_MODE_FINANCE, 307, 306, 313, 312, 319, 318, 325, 324, 331, c.COLLECT_MODE_TIKTOKLITE, 337, 336, 343, 342, 349, 348, 355, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, c.COLLECT_MODE_ML_MINIMIZE, 297, 296, 303, IronSourceConstants.OFFERWALL_AVAILABLE, 309, 308, 315, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, IronSourceConstants.OFFERWALL_OPENED, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{TTAdConstant.IMAGE_LIST_CODE, TTAdConstant.DOWNLOAD_URL_CODE, TTAdConstant.DEEPLINK_UNAVAILABLE_CODE, TTAdConstant.AD_ID_IS_NULL_CODE, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{TTAdConstant.IMAGE_CODE, TTAdConstant.IMAGE_LIST_SIZE_CODE, TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE, TTAdConstant.DEEPLINK_FALLBACK_CODE, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{TTAdConstant.VIDEO_INFO_CODE, TTAdConstant.IMAGE_URL_CODE, TTAdConstant.DOWNLOAD_APP_INFO_CODE, TTAdConstant.LANDING_PAGE_TYPE_CODE, TTAdConstant.MATE_IS_NULL_CODE, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{TTAdConstant.VIDEO_COVER_URL_CODE, TTAdConstant.VIDEO_URL_CODE, 421, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{419, 418, 425, 424, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, 442, 449, 448, 836, 835}, iArr, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, IronSourceError.ERROR_CODE_KEY_NOT_SET, c.COLLECT_MODE_TIKTOK_GUEST, FrameMetricsAggregator.EVERY_DURATION, IronSourceError.ERROR_CODE_GENERIC, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, IronSourceError.ERROR_CODE_NO_CONFIGURATION_AVAILABLE, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, IronSourceError.ERROR_CODE_INVALID_KEY_VALUE, InputDeviceCompat.SOURCE_DPAD, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, IronSourceError.ERROR_CODE_USING_CACHED_CONFIGURATION, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, IronSourceError.ERROR_CODE_INIT_FAILED, 515, IronSourceConstants.INIT_COMPLETE, 521, IronSourceError.ERROR_NO_INTERNET_CONNECTION, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, IronSourceError.ERROR_AD_UNIT_CAPPED, IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT, 848, 847}, new int[]{563, TTAdConstant.STYLE_SIZE_RADIO_9_16, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, IronSourceError.ERROR_NON_EXISTENT_INSTANCE, IronSourceError.ERROR_CAPPED_PER_SESSION, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, IronSourceError.ERROR_BN_LOAD_AFTER_LONG_INITIATION, 600, IronSourceError.ERROR_BN_INSTANCE_INIT_TIMEOUT, IronSourceError.ERROR_BN_LOAD_NO_FILL, IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE, IronSourceError.ERROR_BN_INSTANCE_INIT_ERROR, IronSourceError.ERROR_DO_BN_LOAD_ALREADY_IN_PROGRESS, IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_SERVER_DATA, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, IronSourceError.ERROR_BN_INIT_FAILED_AFTER_LOAD, IronSourceError.ERROR_BN_INSTANCE_RELOAD_TIMEOUT, IronSourceError.ERROR_BN_INSTANCE_LOAD_TIMEOUT, IronSourceError.ERROR_BN_LOAD_NO_CONFIG, IronSourceError.ERROR_BN_RELOAD_SKIP_BACKGROUND, 621, IronSourceError.ERROR_DO_BN_LOAD_DURING_SHOW, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, IronSourceError.ERROR_BN_LOAD_EXCEPTION, IronSourceError.ERROR_BN_LOAD_PLACEMENT_CAPPED, IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_ADAPTER, IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER, IronSourceError.ERROR_BN_BANNER_CONTAINER_IS_NULL, IronSourceError.ERROR_BN_UNSUPPORTED_SIZE, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, TTAdConstant.STYLE_SIZE_RADIO_2_3, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, c.COLLECT_MODE_ML_PGL_AL, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
    }

    BitMatrixParser(BitMatrix bitMatrix2) {
        this.bitMatrix = bitMatrix2;
    }

    /* access modifiers changed from: package-private */
    public byte[] readCodewords() {
        byte[] bArr = new byte[144];
        int height = this.bitMatrix.getHeight();
        int width = this.bitMatrix.getWidth();
        for (int i = 0; i < height; i++) {
            int[] iArr = BITNR[i];
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0 && this.bitMatrix.get(i2, i)) {
                    int i4 = i3 / 6;
                    bArr[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr[i4]);
                }
            }
        }
        return bArr;
    }
}
