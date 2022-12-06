package com.google.zxing.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.List;

public final class CameraManager {
    private static final int MAX_FRAME_HEIGHT = 360;
    private static final int MAX_FRAME_WIDTH = 480;
    private static final int MIN_FRAME_HEIGHT = 240;
    private static final int MIN_FRAME_WIDTH = 240;
    static final int SDK_INT;
    private static final String TAG = CameraManager.class.getSimpleName();
    private static CameraManager cameraManager;
    private final AutoFocusCallback autoFocusCallback;
    private Camera camera;
    private final CameraConfigurationManager configManager;
    private final Context context;
    private Rect framingRect;
    private Rect framingRectInPreview;
    private boolean initialized;
    private final PreviewCallback previewCallback;
    private boolean previewing;
    private final boolean useOneShotPreviewCallback;

    static {
        int i;
        try {
            i = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            i = 10000;
        }
        SDK_INT = i;
    }

    public static void init(Context context2) {
        if (cameraManager == null) {
            cameraManager = new CameraManager(context2);
        }
    }

    public static CameraManager get() {
        return cameraManager;
    }

    private CameraManager(Context context2) {
        this.context = context2;
        this.configManager = new CameraConfigurationManager(context2);
        this.useOneShotPreviewCallback = Integer.parseInt(Build.VERSION.SDK) > 3;
        this.previewCallback = new PreviewCallback(this.configManager, this.useOneShotPreviewCallback);
        this.autoFocusCallback = new AutoFocusCallback();
    }

    public void openDriver(SurfaceHolder surfaceHolder) throws IOException {
        if (this.camera == null) {
            this.camera = Camera.open();
            Camera camera2 = this.camera;
            if (camera2 != null) {
                camera2.setPreviewDisplay(surfaceHolder);
                if (!this.initialized) {
                    this.initialized = true;
                    this.configManager.initFromCameraParameters(this.camera);
                }
                this.configManager.setDesiredCameraParameters(this.camera);
                FlashlightManager.enableFlashlight();
                return;
            }
            throw new IOException();
        }
    }

    public void closeDriver() {
        if (this.camera != null) {
            FlashlightManager.disableFlashlight();
            this.camera.release();
            this.camera = null;
        }
    }

    public void startPreview() {
        Camera camera2 = this.camera;
        if (camera2 != null && !this.previewing) {
            camera2.startPreview();
            this.previewing = true;
        }
    }

    public void stopPreview() {
        Camera camera2 = this.camera;
        if (camera2 != null && this.previewing) {
            if (!this.useOneShotPreviewCallback) {
                camera2.setPreviewCallback((Camera.PreviewCallback) null);
            }
            this.camera.stopPreview();
            this.previewCallback.setHandler((Handler) null, 0);
            this.autoFocusCallback.setHandler((Handler) null, 0);
            this.previewing = false;
        }
    }

    public void requestPreviewFrame(Handler handler, int i) {
        if (this.camera != null && this.previewing) {
            this.previewCallback.setHandler(handler, i);
            if (this.useOneShotPreviewCallback) {
                this.camera.setOneShotPreviewCallback(this.previewCallback);
            } else {
                this.camera.setPreviewCallback(this.previewCallback);
            }
        }
    }

    public void requestAutoFocus(Handler handler, int i) {
        if (this.camera != null && this.previewing) {
            this.autoFocusCallback.setHandler(handler, i);
            this.camera.autoFocus(this.autoFocusCallback);
        }
    }

    public Rect getFramingRect() {
        Point screenResolution = this.configManager.getScreenResolution();
        if (screenResolution == null) {
            return null;
        }
        if (this.framingRect == null) {
            if (this.camera == null) {
                return null;
            }
            int i = (screenResolution.x * 7) / 10;
            int i2 = (screenResolution.y * 7) / 10;
            if (i2 < i) {
                i = i2;
            }
            int i3 = (screenResolution.x - i) / 2;
            int i4 = (screenResolution.y - i) / 3;
            this.framingRect = new Rect(i3, i4, i3 + i, i + i4);
        }
        return this.framingRect;
    }

    public Rect getFramingRectInPreview() {
        if (this.framingRectInPreview == null) {
            Rect rect = new Rect(getFramingRect());
            Point cameraResolution = this.configManager.getCameraResolution();
            Point screenResolution = this.configManager.getScreenResolution();
            rect.left = (rect.left * cameraResolution.y) / screenResolution.x;
            rect.right = (rect.right * cameraResolution.y) / screenResolution.x;
            rect.top = (rect.top * cameraResolution.x) / screenResolution.y;
            rect.bottom = (rect.bottom * cameraResolution.x) / screenResolution.y;
            this.framingRectInPreview = rect;
        }
        return this.framingRectInPreview;
    }

    public PlanarYUVLuminanceSource buildLuminanceSource(byte[] bArr, int i, int i2) {
        getFramingRectInPreview();
        int previewFormat = this.configManager.getPreviewFormat();
        String previewFormatString = this.configManager.getPreviewFormatString();
        if (previewFormat == 16 || previewFormat == 17) {
            return new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2);
        }
        if ("yuv420p".equals(previewFormatString)) {
            return new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2);
        }
        throw new IllegalArgumentException("Unsupported picture format: " + previewFormat + '/' + previewFormatString);
    }

    public Context getContext() {
        return this.context;
    }

    public boolean setFlashLight(boolean z) {
        Camera.Parameters parameters;
        List<String> supportedFlashModes;
        Camera camera2 = this.camera;
        if (!(camera2 == null || !this.previewing || (parameters = camera2.getParameters()) == null || (supportedFlashModes = parameters.getSupportedFlashModes()) == null || supportedFlashModes.size() == 0)) {
            String flashMode = parameters.getFlashMode();
            if (z) {
                if ("torch".equals(flashMode)) {
                    return true;
                }
                if (!supportedFlashModes.contains("torch")) {
                    return false;
                }
                parameters.setFlashMode("torch");
                this.camera.setParameters(parameters);
                return true;
            } else if ("off".equals(flashMode)) {
                return true;
            } else {
                if (supportedFlashModes.contains("off")) {
                    parameters.setFlashMode("off");
                    this.camera.setParameters(parameters);
                    return true;
                }
            }
        }
        return false;
    }
}
