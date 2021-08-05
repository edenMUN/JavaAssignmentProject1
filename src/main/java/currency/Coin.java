package currency;

/**
 * This class is for manipulation coins value.
 */
public abstract class Coin implements ICalcualte {

    /**
     * This method is to set the conversion value.
     * @return The value of the selected currency
     */
    public abstract double getValue();

}
