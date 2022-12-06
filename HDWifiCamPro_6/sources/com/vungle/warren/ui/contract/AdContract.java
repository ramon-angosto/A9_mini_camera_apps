package com.vungle.warren.ui.contract;

import android.content.DialogInterface;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.ui.JavascriptBridge;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.ui.state.OptionsState;
import com.vungle.warren.utility.ActivityManager;

public interface AdContract {

    public @interface AdStopReason {
        public static final int IS_AD_FINISHED_BY_API = 4;
        public static final int IS_AD_FINISHING = 2;
        public static final int IS_CHANGING_CONFIGURATION = 1;
    }

    public interface AdView<T extends AdvertisementPresenter> {
        void close();

        void destroyAdView(long j);

        String getWebsiteUrl();

        boolean hasWebView();

        void open(String str, String str2, ActivityManager.LeftApplicationCallback leftApplicationCallback, PresenterAdOpenCallback presenterAdOpenCallback);

        void pauseWeb();

        void refreshDialogIfVisible();

        void removeWebView();

        void resumeWeb();

        void setImmersiveMode();

        void setOrientation(int i);

        void setPresenter(T t);

        void showCloseButton();

        void showDialog(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener);

        void showWebsite(String str);
    }

    public interface AdvertisementBus {
        public static final String ACTION = "AdvertisementBus";
        public static final String COMMAND = "command";
        public static final String PLACEMENT = "placement";
        public static final String STOP_ALL = "stopAll";
    }

    public interface AdvertisementPresenter<T extends AdView> extends JavascriptBridge.MraidHandler {

        public interface EventListener {
            void onError(VungleException vungleException, String str);

            void onNext(String str, String str2, String str3);
        }

        void attach(T t, OptionsState optionsState);

        void detach(int i);

        void generateSaveState(OptionsState optionsState);

        boolean handleExit();

        void onViewConfigurationChanged();

        void restoreFromSave(OptionsState optionsState);

        void setEventListener(EventListener eventListener);

        void start();

        void stop(int i);
    }
}
