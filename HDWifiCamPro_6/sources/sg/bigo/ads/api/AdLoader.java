package sg.bigo.ads.api;

public interface AdLoader<T> {

    public interface Builder<T extends Ad, S extends Builder, U extends AdLoader> {
        U build();

        S withAdLoadListener(AdLoadListener<T> adLoadListener);
    }
}
