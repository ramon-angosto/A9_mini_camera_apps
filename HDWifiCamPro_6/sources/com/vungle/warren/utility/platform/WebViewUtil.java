package com.vungle.warren.utility.platform;

import android.content.Context;
import android.os.Build;
import android.util.AndroidRuntimeException;
import android.webkit.WebSettings;
import androidx.core.util.Consumer;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;

public class WebViewUtil {
    private final String TAG = WebViewUtil.class.getSimpleName();
    private final Context context;
    private final Repository repository;

    public WebViewUtil(Context context2, Repository repository2) {
        this.context = context2;
        this.repository = repository2;
    }

    public void getUserAgent(Consumer<String> consumer) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                String defaultUserAgent = WebSettings.getDefaultUserAgent(this.context);
                consumer.accept(defaultUserAgent);
                addUserAgentInCookie(defaultUserAgent);
            } catch (Exception e) {
                if (e instanceof DatabaseHelper.DBException) {
                    VungleLogger.error(this.TAG, "Ran into database issue");
                }
                if (e instanceof AndroidRuntimeException) {
                    VungleLogger.error(this.TAG, "WebView could be missing here");
                }
                consumer.accept(null);
            }
        } else {
            consumer.accept(null);
        }
    }

    private void addUserAgentInCookie(String str) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie(Cookie.USER_AGENT_ID_COOKIE);
        cookie.putValue(Cookie.USER_AGENT_ID_COOKIE, str);
        this.repository.save(cookie);
    }
}
