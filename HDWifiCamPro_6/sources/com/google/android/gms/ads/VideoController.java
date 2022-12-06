package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzfe;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();
    private zzdk zzb;
    private VideoLifecycleCallbacks zzc;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzb != null;
        }
        return z;
    }

    public void mute(boolean z) {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk != null) {
                try {
                    zzdk.zzj(z);
                } catch (RemoteException e) {
                    zzcgp.zzh("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk != null) {
                try {
                    zzdk.zzk();
                } catch (RemoteException e) {
                    zzcgp.zzh("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk != null) {
                try {
                    zzdk.zzl();
                } catch (RemoteException e) {
                    zzcgp.zzh("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk != null) {
                try {
                    zzdk.zzn();
                } catch (RemoteException e) {
                    zzcgp.zzh("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public final zzdk zza() {
        zzdk zzdk;
        synchronized (this.zza) {
            zzdk = this.zzb;
        }
        return zzdk;
    }

    public final void zzb(zzdk zzdk) {
        synchronized (this.zza) {
            this.zzb = zzdk;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzfe zzfe;
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzdk zzdk = this.zzb;
            if (zzdk != null) {
                if (videoLifecycleCallbacks == null) {
                    zzfe = null;
                } else {
                    try {
                        zzfe = new zzfe(videoLifecycleCallbacks);
                    } catch (RemoteException e) {
                        zzcgp.zzh("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                        return;
                    }
                }
                zzdk.zzm(zzfe);
            }
        }
    }

    public int getPlaybackState() {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk == null) {
                return 0;
            }
            try {
                int zzh = zzdk.zzh();
                return zzh;
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk == null) {
                return false;
            }
            try {
                boolean zzo = zzdk.zzo();
                return zzo;
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk == null) {
                return false;
            }
            try {
                boolean zzp = zzdk.zzp();
                return zzp;
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzdk zzdk = this.zzb;
            if (zzdk == null) {
                return true;
            }
            try {
                boolean zzq = zzdk.zzq();
                return zzq;
            } catch (RemoteException e) {
                zzcgp.zzh("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }
}
