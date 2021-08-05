package currency;

/**
 * This class is for manipulation currency initializing.
 */
public class CoinFactory {

    /**
     * This method is to initialize the objects.
     * @param coin your choice of which currency to to initialize.
     * @return the new object.
     */
    public static Coin getCoinInstance(Coins coin) {
        switch (coin) {
            case ILS -> {
                return new ILS();
            }
            case USD -> {
                return new USD();
            }
        }
        return null;
    }
}
