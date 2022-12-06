package sg.bigo.ads.api;

public interface Ad {
    void destroy();

    AdBid getBid();

    boolean isExpired();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);
}
