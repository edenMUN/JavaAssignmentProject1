package currency;

/**
 * This class is for implementation the methods of ICalcualte and Coin.
 */
public class USD extends Coin implements java.io.Serializable{

    private final double usdvalue = 3.52;
    private final String USDconversion = " ILS to USD";

    public String conversion(){
        return USDconversion;
    }

    @Override
    public double getValue() {
        return usdvalue;
    }

    @Override
    public double calculate(double useramount) {
        return useramount * getValue();
    }

    public double getUSDvalue() {
        return usdvalue;
    }

}
