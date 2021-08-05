package currency;

/**
 * This class is for implementation the methods of ICalcualte and Coin.
 */
public class ILS extends Coin implements java.io.Serializable{

    private final double ILSvalue = 0.28;
    private final String ILSconversion = "USD to ILS";

    public String conversion(){
        return ILSconversion;
    }

    @Override
    public double getValue() {
        return ILSvalue;
    }

    @Override
    public double calculate(double useramount) {
        return useramount * getValue();
    }

    public double getILSvalue() {
        return ILSvalue;
    }

}
