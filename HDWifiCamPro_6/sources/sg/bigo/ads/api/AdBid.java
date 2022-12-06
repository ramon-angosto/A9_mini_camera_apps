package sg.bigo.ads.api;

public interface AdBid {
    public static final int LOSS_REASON_INTERNAL_ERROR = 1;
    public static final int LOSS_REASON_LOWER_THAN_FLOOR_PRICE = 100;
    public static final int LOSS_REASON_LOWER_THAN_HIGHEST_PRICE = 101;
    public static final int LOSS_REASON_TIMEOUT = 2;

    double getPrice();

    void notifyLoss(Double d, String str, int i);

    void notifyWin(Double d, String str);
}
