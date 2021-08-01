package currency;

public class CoinFactory {
//method the creates new objects
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
