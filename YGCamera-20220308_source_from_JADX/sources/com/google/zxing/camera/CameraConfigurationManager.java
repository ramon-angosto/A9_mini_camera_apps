package com.google.zxing.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Pattern;

final class CameraConfigurationManager {
    private static final Pattern COMMA_PATTERN = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);
    private static final int DESIRED_SHARPNESS = 30;
    private static final String TAG = CameraConfigurationManager.class.getSimpleName();
    private static final int TEN_DESIRED_ZOOM = 27;
    private Point cameraResolution;
    private final Context context;
    private int previewFormat;
    private String previewFormatString;
    private Point screenResolution;

    public static int getDesiredSharpness() {
        return 30;
    }

    CameraConfigurationManager(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public void initFromCameraParameters(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.previewFormat = parameters.getPreviewFormat();
        this.previewFormatString = parameters.get("preview-format");
        String str = TAG;
        Log.d(str, "Default preview format: " + this.previewFormat + '/' + this.previewFormatString);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        this.screenResolution = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        String str2 = TAG;
        Log.d(str2, "Screen resolution: " + this.screenResolution);
        Point point = new Point();
        point.x = this.screenResolution.x;
        point.y = this.screenResolution.y;
        if (this.screenResolution.x < this.screenResolution.y) {
            point.x = this.screenResolution.y;
            point.y = this.screenResolution.x;
        }
        this.cameraResolution = getCameraResolution(parameters, point);
        String str3 = TAG;
        Log.d(str3, "Camera resolution: " + this.screenResolution);
    }

    /* access modifiers changed from: package-private */
    public void setDesiredCameraParameters(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        String str = TAG;
        Log.d(str, "Setting preview size: " + this.cameraResolution);
        parameters.setPreviewSize(this.cameraResolution.x, this.cameraResolution.y);
        setFlash(parameters);
        setZoom(parameters);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }

    /* access modifiers changed from: package-private */
    public Point getCameraResolution() {
        return this.cameraResolution;
    }

    /* access modifiers changed from: package-private */
    public Point getScreenResolution() {
        return this.screenResolution;
    }

    /* access modifiers changed from: package-private */
    public int getPreviewFormat() {
        return this.previewFormat;
    }

    /* access modifiers changed from: package-private */
    public String getPreviewFormatString() {
        return this.previewFormatString;
    }

    private static Point getCameraResolution(Camera.Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        Point point2 = null;
        if (str != null) {
            String str2 = TAG;
            Log.d(str2, "preview-size-values parameter: " + str);
            point2 = findBestPreviewSizeValue(str, point);
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }

    private static Point findBestPreviewSizeValue(CharSequence charSequence, Point point) {
        String[] split = COMMA_PATTERN.split(charSequence);
        int length = split.length;
        int i = 0;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String trim = split[i].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                String str = TAG;
                Log.w(str, "Bad preview-size: " + trim);
            } else {
                try {
                    int parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(trim.substring(indexOf + 1));
                    int abs = Math.abs(parseInt - point.x) + Math.abs(parseInt2 - point.y);
                    if (abs == 0) {
                        i3 = parseInt2;
                        i4 = parseInt;
                        break;
                    } else if (abs < i2) {
                        i3 = parseInt2;
                        i2 = abs;
                        i4 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    String str2 = TAG;
                    Log.w(str2, "Bad preview-size: " + trim);
                }
            }
            i++;
        }
        if (i4 <= 0 || i3 <= 0) {
            return null;
        }
        return new Point(i4, i3);
    }

    private static int findBestMotZoomValue(CharSequence charSequence, int i) {
        String[] split = COMMA_PATTERN.split(charSequence);
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            try {
                double parseDouble = Double.parseDouble(split[i2].trim());
                int i4 = (int) (10.0d * parseDouble);
                double d = (double) i;
                Double.isNaN(d);
                if (Math.abs(d - parseDouble) < ((double) Math.abs(i - i3))) {
                    i3 = i4;
                }
                i2++;
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i3;
    }

    private void setFlash(Camera.Parameters parameters) {
        if (!Build.MODEL.contains("Behold II") || CameraManager.SDK_INT != 3) {
            parameters.set("flash-value", 2);
        } else {
            parameters.set("flash-value", 1);
        }
        parameters.set("flash-mode", "off");
    }

    private void setZoom(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                    String str3 = TAG;
                    Log.w(str3, "Bad max-zoom: " + str2);
                }
            }
            String str4 = parameters.get("taking-picture-zoom-max");
            if (str4 != null) {
                try {
                    int parseInt = Integer.parseInt(str4);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                    String str5 = TAG;
                    Log.w(str5, "Bad taking-picture-zoom-max: " + str4);
                }
            }
            String str6 = parameters.get("mot-zoom-values");
            if (str6 != null) {
                i = findBestMotZoomValue(str6, i);
            }
            String str7 = parameters.get("mot-zoom-step");
            if (str7 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str7.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (!(str2 == null && str6 == null)) {
                double d = (double) i;
                Double.isNaN(d);
                parameters.set("zoom", String.valueOf(d / 10.0d));
            }
            if (str4 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }
}
